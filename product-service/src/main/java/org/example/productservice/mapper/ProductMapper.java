package org.example.productservice.mapper;

import org.apache.ibatis.annotations.*;
import org.example.productservice.po.Product;

import java.util.List;
public interface ProductMapper {
    @Select("select p.product_name as productName,p.price as price from product p where id = #{productId}")
    Product findByProductId(@Param("productId") Long productId);

    @Select("select p.id,p.product_name as productName,p.price as price from product p")
    List<Product> queryAllProduct();

    @Delete("delete from product where id = #{productId}")
    void deleteByProductId(@Param("productId") Long productId);

    @Insert("insert into product (product_name, price) values (#{productName}, #{price})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertProduct(Product product);

    @Update("update product set product_name = #{productName}, price = #{price} where id = #{id}")
    void updateProduct(Product product);
}
