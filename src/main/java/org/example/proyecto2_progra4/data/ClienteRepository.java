package org.example.proyecto2_progra4.data;

import org.example.proyecto2_progra4.logic.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProveedorClienteRepository proveedorClienteRepository;

    public Cliente readById(String id, String provId){
        String sql = "select c.id, c.nombre, c.apellido, c.telefono, c.correo, c.direccion, c.tipo" +
                "from Cliente c" +
                "join ProveedorCliente pc on c.id=pc.id_cliente and pc.id_proveedor=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id, provId},(rs, rowNum) -> mapResultSetToCliente(rs));
    }

    public Cliente mapResultSetToCliente(ResultSet resultSet) throws SQLException{
        String id = resultSet.getString("id");
        String name = resultSet.getString("nombre");
        String lastName = resultSet.getString("apellido");
        String phone = resultSet.getString("telefono");
        String email = resultSet.getString("correo");
        String address = resultSet.getString("direccion");
        String type = resultSet.getString("tipo");
        return new Cliente(id, name, lastName, phone, email, address, type);
    }

    public void createClient(Cliente client, String provId) throws Exception {
        String clientId;
        String sql = "select id from Cliente where correo=?";
        List<String> ids = jdbcTemplate.query(sql, new Object[]{client.getEmail()}, (rs, rowNum) -> rs.getString(1));
        try{
            if(!ids.isEmpty()){
                clientId = ids.get(0);
                proveedorClienteRepository.create(provId, clientId);
            } else {
                clientId = insertClient(client);
                proveedorClienteRepository.create(provId, clientId);
            }
        } catch (Exception e){
            e.printStackTrace();
            System.err.println("Error al ejecutar la operacion en la base de datos: "+e.getMessage());
        }
    }

    public String insertClient(Cliente client) throws Exception{
        String sql1 = "insert into Cliente (id, nombre, apellido, telefono, correo, direccion, tipo) values (?,?,?,?,?,?,?)";
        int affectedRows = jdbcTemplate.update(sql1, client.getId(), client.getName(), client.getLastName(), client.getPhone(), client.getEmail(), client.getAddress(), client.getType());
        if(affectedRows==0){
            throw new SQLException("No se pudo insertar el cliente");
        }
        String sql2="select top 1 id from Cliente order by id desc";
        String id = jdbcTemplate.queryForObject(sql2, String.class);
        if (id==null){
            throw new SQLException("No se pudo obtener el Id del cliente");
        }
        return id;
    }

    public List<Cliente> getAllClientsByProvId(String provId){
        String sql="select c.id, c.nombre, c.apellido, c.telefono, c.correo, c.direccion, c.tipo" +
                "from Cliente c" +
                "join ProveedorCliente pc on c.id=pc.id_cliente and pc.id_proveedor=?";
        List<Cliente> list = new ArrayList<>();
        jdbcTemplate.query(sql, new Object[]{provId}, (rs, rowNum) -> {
           Cliente client = mapResultSetToCliente(rs);
           list.add(client);
           return client;
        });
        return list;
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
