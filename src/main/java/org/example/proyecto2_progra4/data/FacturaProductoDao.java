package org.example.proyecto2_progra4.data;

import org.example.proyecto2_progra4.logic.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacturaProductoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProductoDao productoDao;

    public void create(int facturaId, String productoId) throws Exception {
        String sql = "insert into FacturaProducto (id_factura, id_producto) values (?,?)";
        try {
            jdbcTemplate.update(sql, facturaId, productoId);
        } catch (DataAccessException e) {
            throw new Exception("Error al crear FacturaProducto: " + e.getMessage());
        }
    }

    public List<Producto> productosPorFactura(int facturaId) {
        String sql = "select * from FacturaProducto where id_factura=?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Producto producto = new Producto();
            producto = productoDao.readById(rs.getString("id_producto"));
            return producto;
        });
    }

    public void delete(int facturaId, String productoId) throws Exception {
        String sql = "delete from FacturaProducto where id_factura=? and id_producto=?";
        try {
            jdbcTemplate.update(sql, facturaId, productoId);
        } catch (DataAccessException e) {
            throw new Exception("Error al eliminar registro en FacturaProducto: " + e.getMessage());
        }
    }
}
