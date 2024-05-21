package org.example.proyecto2_progra4.data;

import org.example.proyecto2_progra4.logic.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProveedorProductoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProductoDao productoDao;

    public void create(String provId, String productId) throws Exception {
        String sql = "insert into ProveedorProducto (proveedor, producto) values (?,?)";
        try {
            jdbcTemplate.update(sql, provId, productId);
        } catch (DataAccessException e) {
            throw new Exception("Error al crear registro en ProveedorProducto: " + e.getMessage());
        }
    }

    public List<Producto> productosPorProveedor(String provId) {
        String sql = "select * from ProveedorProducto where proveedor=?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Producto product = new Producto();
            product = productoDao.readById(rs.getString("producto"));
            return product;
        });
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
