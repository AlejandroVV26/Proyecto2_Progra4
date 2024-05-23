package org.example.proyecto2_progra4.data;

import org.example.proyecto2_progra4.logic.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente read(String id) throws Exception {
        String sql = "select * from Cliente c where c.id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
                Cliente client = new Cliente();
                client.setId(rs.getString("id"));
                client.setName(rs.getString("nombre"));
                client.setLastName(rs.getString("apellido"));
                client.setPhone(rs.getString("telefono"));
                client.setEmail(rs.getString("correo"));
                client.setAddress(rs.getString("direccion"));
                client.setType(rs.getString("tipo"));
                return client;
            });
        } catch (Exception e) {
            throw new Exception("Cliente no Existe" + e.getMessage());
        }
    }

    public void clientUpdate(Cliente client) throws Exception {
        String sql = "update Cliente set nombre=?, apellido=?, telefono=?, correo=?, direccion=? where id=?";
        try {
            jdbcTemplate.update(sql, client.getName(), client.getLastName(), client.getPhone(), client.getEmail(), client.getAddress());
            System.out.println("Cliente Modificado Correctamente");
        } catch (DataAccessException e) {
            throw new Exception("Error al Actualizar Datos del Cliente: " + e.getMessage());
        }
    }

    public void createClient(Cliente client) throws Exception {
        String sql = "insert into Cliente (id, nombre, apellido, telefono, correo, direccion, tipo) values (?,?,?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql, client.getId(), client.getName(), client.getLastName(), client.getPhone(), client.getEmail(), client.getAddress(), client.getType());
        } catch (DataAccessException e) {
            throw new Exception("Error al Crear Cliente: " + e.getMessage());
        }
    }

    public List<Cliente> getAllClients() {
        String sql = "select * from Cliente";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Cliente client = new Cliente();
            client.setId(rs.getString("id"));
            client.setName(rs.getString("nombre"));
            client.setLastName(rs.getString("apellido"));
            client.setPhone(rs.getString("telefono"));
            client.setEmail(rs.getString("correo"));
            client.setAddress(rs.getString("direccion"));
            client.setType(rs.getString("tipo"));
            return client;
        });
    }
}
