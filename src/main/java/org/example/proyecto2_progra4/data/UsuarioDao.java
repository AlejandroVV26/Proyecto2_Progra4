package org.example.proyecto2_progra4.data;

import org.example.proyecto2_progra4.logic.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Usuario read(String id, String pass) {
        String sql = "select * from Usuario u where u.id=? and u.contrasena=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id, pass}, (rs, rowNum) -> {
            Usuario user = new Usuario();
            user.setId(rs.getString("id"));
            user.setPassword(rs.getString("contrasena"));
            user.setType(rs.getString("tipo"));
            user.setAccess(rs.getBoolean("acceso"));
            return user;
        });
    }

    public void createUser(Usuario user) throws Exception {
        String sql = "insert into Usuario(id, contrasena, tipo, acceso) values (?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, user.getId(), user.getPassword(), user.getType(), user.isAccess());
        } catch (DataAccessException e) {
            throw new Exception("Error al crear Usuario: " + e.getMessage());
        }
    }

    public void updateAccesTrue(String id) throws Exception{
        try{
            boolean access = true;
            String sql ="update Usuario set acceso=? where id =?";//SI DA ERROR HAY QUE PONER '' EN EL ID
            int count = jdbcTemplate.update(sql, access, id);
            if(count==0){
                throw new Exception("No se actualizo el acceso al usuario");
            }
        }catch (DataAccessException e){
            throw new Exception("Error al actualizar el acceso al usuario");
        }
    }

    public void updateAccesFalse(String id) throws Exception{
        try{
            boolean access = false;
            String sql ="update Usuario set acceso=? where id =?";//SI DA ERROR HAY QUE PONER '' EN EL ID
            int count = jdbcTemplate.update(sql, access, id);
            if(count==0){
                throw new Exception("No se actualizo el acceso al usuario");
            }
        }catch (DataAccessException e){
            throw new Exception("Error al actualizar el acceso al usuario");
        }
    }
}
