package org.example.proyecto2_progra4.data;

import org.example.proyecto2_progra4.logic.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class FacturaDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProveedorDao proveedorDao;
    @Autowired
    private ClienteDao clienteDao;

    public List<Factura> readByProveedor(String provId) throws Exception {
        String sql = "select * from Factura f inner join Proveedor p on f.id_usuario = p.id inner join Cliente c on f.cliente_id=c.id where f.id_usuario=?";
        try {
            return Collections.singletonList(jdbcTemplate.queryForObject(sql, new Object[]{provId}, (rs, rowNum) -> {
                Factura factura = new Factura();
                factura.setId(rs.getInt("id"));
                String idProv = rs.getString("id_usuario");
                factura.setProv(proveedorDao.read(idProv));
                String idClient = rs.getString("cliente_id");
                try {
                    factura.setClient(clienteDao.read(idClient));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                factura.setCostoTotal(rs.getDouble("costo_total"));
                return factura;
            }));
        } catch (DataAccessException e) {
            throw new Exception("Error");
        }
    }

    public void create(Factura factura) throws Exception {
        String sql = "insert into Factura (id, id_usuario, cliente_id, costo_total) values (?,?,?,?)";
        try {
            jdbcTemplate.update(sql, factura.getId(), factura.getProv().getId(), factura.getClient().getId(), factura.getCostoTotal());
        } catch (DataAccessException e) {
            throw new Exception("Error al crear la factura: " + e.getMessage());
        }
    }
}
