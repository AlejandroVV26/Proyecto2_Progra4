package org.example.proyecto2_progra4.data;

import org.example.proyecto2_progra4.logic.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    ProveedorProductoRepository proveedorProductoRepository;

    public void createProduct(Producto product, String provId) throws Exception {
        String productId;
        String sql = "select id from Producto where descripcion =?";
        List<String> productsIds = jdbcTemplate.query(sql, new Object[]{product.getId()}, (rs, rowNum) -> rs.getString(1));
        try{
            if(!productsIds.isEmpty()){
                productId = productsIds.get(0);
                proveedorProductoRepository.create(productId, provId);
            } else {
                productId = insertProduct(product);
                proveedorProductoRepository.create(productId, provId);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Error al ejecutar la operacion en la base de datos: "+e.getMessage());
        }
    }

    public String insertProduct(Producto product) throws Exception{
        String sql = "insert into Producto(id, categoria, descripcion, unidad_medida, costo) values (?,?,?,?,?)";
        int affectedRows=jdbcTemplate.update(sql, product.getId(), product.getCategoria(), product.getDescription(), product.getUnidadM(), product.getCost());
        if (affectedRows==0){
            throw new SQLException("No se pudo insertar el producto");
        }
        String sql2="select top 1 id from Producto order by id desc";
        String id=jdbcTemplate.queryForObject(sql2, String.class);
        if (id==null){
            throw new SQLException("No se pudo obtener el Id del producto");
        }
        return id;
    }

    public void updateProduct(Producto product, String provId) {
        try{
            String prodId="-1";
            String sql1 ="select id from Producto where descripcion=?";
            List<String> ids = jdbcTemplate.query(sql1, new Object[]{product.getId()}, (rs, rowNum) -> rs.getString(1));
            if(!ids.isEmpty()){
                prodId=ids.get(0);
            }
            if(!Objects.equals(prodId, "-1")){
                String sqlProveedorAsociado="select count (*) as numProveedores from ProveedorProducto where producto=?";
                int numProveedores = jdbcTemplate.queryForObject(sqlProveedorAsociado, Integer.class, prodId);
                if(numProveedores>1){
                    prodId = insertProduct(product);
                }
            } else {
                prodId = insertProduct(product);
            }
            if(!Objects.equals(prodId,"-1")){
                String sqlUpdate="update ProveedorProducto set producto=? where proveedor=? and producto=?";
                jdbcTemplate.update(sqlUpdate, prodId, provId, product.getId());

                String sqlDeleteOld="delete from ProveedorProducto where proveedor=? and producto=?";
                jdbcTemplate.update(sqlDeleteOld, provId, product.getId());
            }
            limpiarProductosHuerfanos();
        } catch (Exception e){
            throw new RuntimeException("Error al actualizar el producto",e);
        }
    }

    public void limpiarProductosHuerfanos() throws Exception{
        String sql="delete from Producto where id not in (select producto from ProveedorProducto)";
        int affectedRows=jdbcTemplate.update(sql);
        if (affectedRows<0){
            throw new SQLException("No se pudo limpliar los productos huerfanos");
        }
    }

    public Producto readById(String id, String proveedor) {
        String sql = "select p.id, p.categoria, p.descripcion, p.unidad_medida, p.costo" +
                "from Producto p" +
                "join ProveedorProducto pp on p.id=pp.producto where p.id=? and pp.proveedor=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id, proveedor}, (rs, rowNum) -> mapResultSetToProducto(rs));
    }

    public Producto mapResultSetToProducto(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String categoria = resultSet.getString("categoria");
        String descripcion = resultSet.getString("descripcion");
        String unidadMedida = resultSet.getString("unidad_medida");
        double costo = resultSet.getDouble("costo");
        return new Producto(id, categoria, descripcion, unidadMedida, costo);
    }

    public Producto readByDescription(String description) {
        String sql = "select * from Producto where descripcion=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{description}, (rs, rowNum) -> {
            Producto prod = new Producto();
            prod.setId(rs.getString("id"));
            prod.setCategoria(rs.getString("categoria"));
            prod.setDescription(rs.getString("descripcion"));
            prod.setUnidadM(rs.getString("unidad_medida"));
            prod.setCost(rs.getDouble("costo"));
            return prod;
        });
    }

    public List<Producto> getAll(){
        String sql="select * from Producto";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
           Producto producto = new Producto();
           producto.setId(rs.getString("id"));
           producto.setCategoria(rs.getString("categoria"));
           producto.setDescription(rs.getString("descripcion"));
           producto.setUnidadM(rs.getString("unidad_medida"));
           producto.setCost(rs.getDouble("costo"));
           return producto;
        });
    }
}
