package org.example.proyecto2_progra4.data;

import org.example.proyecto2_progra4.logic.Producto;
import org.example.proyecto2_progra4.logic.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProveedorDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Proveedor read(String id) {
        String sql = "select * from Proveedor where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Proveedor prov = new Proveedor();
            prov.setId(rs.getString("id"));
            prov.setName(rs.getString("nombre"));
            prov.setLastName(rs.getString("apellido"));
            prov.setPhone(rs.getString("telefono"));
            prov.setEmail(rs.getString("correo"));
            return prov;
        });
    }

    public void create(Proveedor prov) throws Exception {
        String sql = "insert into Proveedor(id, nombre, apellido, telefono, correo) values (?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql, prov.getId(), prov.getName(), prov.getLastName(), prov.getPhone(), prov.getEmail());
        } catch (DataAccessException e) {
            throw new Exception("Error al crear el proveedor: " + e.getMessage());
        }
    }

    public void update(Proveedor prov) throws Exception {
        String sql = "update Proveedor set nombre=?, apellido=?, telefono=?, correo=? where id =?";
        try {
            jdbcTemplate.update(sql, prov.getName(), prov.getLastName(), prov.getPhone(), prov.getEmail(), prov.getId());
        } catch (DataAccessException e) {
            throw new Exception("Error al actualizar proveedor: " + e.getMessage());
        }
    }

    public void delete(String id) throws Exception {
        String sql = "delete from Proveedor where id=?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            throw new Exception("No se elimino el proveedor: " + e.getMessage());
        }
    }
}
