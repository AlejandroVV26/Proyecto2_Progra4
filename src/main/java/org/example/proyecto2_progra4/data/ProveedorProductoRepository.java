package org.example.proyecto2_progra4.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProveedorProductoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(String provId, String productId) throws Exception {
        String sql = "insert into ProveedorProducto (proveedor, producto) values (?,?)";
        try {
            jdbcTemplate.update(sql, provId, productId);
        } catch (DataAccessException e) {
            throw new Exception("Error al crear registro en ProveedorProducto: " + e.getMessage());
        }
    }

    public void delete(String provId, String productId) throws Exception {
        String sql = "delete from ProveedorProducto where proveedor=? and producto=?";
        try {
            jdbcTemplate.update(sql, provId, productId);
        } catch (DataAccessException e) {
            throw new Exception("Error al eliminar registro en ProveedorProducto: " + e.getMessage());
        }
    }
}
