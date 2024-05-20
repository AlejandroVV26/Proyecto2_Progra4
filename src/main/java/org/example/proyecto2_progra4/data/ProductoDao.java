package org.example.proyecto2_progra4.data;

import org.example.proyecto2_progra4.logic.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //ESTE METODO SOLO INSERTA EL PRODUCTO EN LA TABLA PRODUCTO
    public void createProduct(Producto product)throws Exception{
        String sql ="insert into Producto(id, categoria, descripcion, unidad_medida, costo) values (?,?,?,?,?)";
        try{
            jdbcTemplate.update(sql, product.getId(), product.getCategoria(), product.getDescription(), product.getUnidadM(), product.getCost());
        }catch (DataAccessException e){
            throw new Exception("Error al crear Producto: "+ e.getMessage());
        }
    }

//    METODO PARA VINCULAR UN PRODUCTO CON UN PROVEEDOR
//    public void insertProveedorProducto(String provId, String productId) throws Exception{
//        String sql="insert into ProveedorProducto (id_proveedor, id_producto) values (?,?)";
//        try {
//            jdbcTemplate.update(sql, provId, productId);
//        } catch (DataAccessException e){
//            throw new Exception("Error al vincular el producto con un proveedor: "+e.getMessage());
//        }
//    } este va en proveedorDao

    public void updateProduct(Producto product) throws Exception{
        String sql="update Producto set categoria=?, descripcion=?, unidad_medida=?, costo=?";
        try{
            jdbcTemplate.update(sql, product.getCategoria(), product.getDescription(), product.getUnidadM(), product.getCost());
        } catch (DataAccessException e){
            throw new Exception("Error al modificar el producto: "+e.getMessage());
        }
    }

    public Producto readById(String id){
        String sql="select * from Producto where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},(rs, rowNum) -> {
            Producto prod = new Producto();
            prod.setId(rs.getString("id"));
            prod.setCategoria(rs.getString("categoria"));
            prod.setDescription(rs.getString("descripcion"));
            prod.setUnidadM(rs.getString("unidad_medida"));
            prod.setCost(rs.getDouble("costo"));
            return prod;
        });
    }

    public Producto readByDescription(String description){
        String sql="select * from Producto where descripcion=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{description},(rs, rowNum) -> {
            Producto prod = new Producto();
            prod.setId(rs.getString("id"));
            prod.setCategoria(rs.getString("categoria"));
            prod.setDescription(rs.getString("descripcion"));
            prod.setUnidadM(rs.getString("unidad_medida"));
            prod.setCost(rs.getDouble("costo"));
            return prod;
        });
    }
}
