package org.example.productservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.productservice.mapper.ProductMapper;
import org.example.productservice.po.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 商品的服务控制层
 */
@AllArgsConstructor
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private final ProductMapper productMapper;

    /**
     * 根据商品id查询商品
     */
    @GetMapping("/findByProductId/{productId}")
    public Product findAll(@PathVariable("productId") Long productId) {
        Product product = productMapper.findByProductId(productId);
        log.info("-------------OK /findByProductId/{productId}--------------------");
        return product;
    }

    /**
     * 查询所有商品
     */
    @GetMapping("/queryAllProduct")
    public List<Product> findAll() {
        List<Product> productList = productMapper.queryAllProduct();
        log.info("-------------OK queryAllProduct--------------------");
        return productList;
    }

    /**
     * 根据商品id删除商品
     */
    @DeleteMapping("/deleteByProductId/{productId}")
    public void deleteByProductId(@PathVariable("productId") Long productId) {
        productMapper.deleteByProductId(productId);
        log.info("Deleted product with ID: {}", productId);
    }

    /**
     * 插入新的商品对象
     */
    @PostMapping("/insertProduct")
    public void insertProduct(@RequestBody Product product) {
        productMapper.insertProduct(product);
        log.info("Inserted product: {}", product);
    }

    /**
     * 更改商品对象
     */
    @PostMapping("/updateProduct")
    public void updateProduct(@RequestBody Product product) {
        productMapper.updateProduct(product);
        log.info("Updated product: {}", product);
    }
}
