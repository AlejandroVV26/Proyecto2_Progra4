package org.example.proyecto2_progra4.data;

import org.example.proyecto2_progra4.logic.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProveedorClienteRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ClienteRepository clienteRepository;

    public void create(String provId, String clientId) throws Exception {
        String sql = "insert into ProveedorCliente (id_proveedor, id_cliente) values (?,?)";
        try {
            jdbcTemplate.update(sql, provId, clientId);
        } catch (DataAccessException e) {
            throw new Exception("Error al crear ProveedorCliente: " + e.getMessage());
        }
    }

    public List<Cliente> clientesPorProveedor(String provId) {
        String sql = "select * from ProveedorCliente where id_proveedor=?";
        return Collections.singletonList(jdbcTemplate.queryForObject(sql, new Object[]{provId}, (rs, rowNum) -> {
            Cliente client = new Cliente();
            try {
                client = clienteRepository.read(rs.getString("id_cliente"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return client;
        }));
    }

    public void delete(String provId, String clientId) throws Exception {
        String sql = "delete from ProveedorCliente where id_proveedor=? and id_cliente=?";
        try {
            jdbcTemplate.update(sql, provId, clientId);
        } catch (DataAccessException e) {
            throw new Exception("Error al eliminar registro en ProveedorCliente: " + e.getMessage());
        }
    }
}