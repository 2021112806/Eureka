package org.example.productclient.controller;

import org.example.productclient.Client.ProductServiceClient;
import org.example.productclient.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@Slf4j
public class ProductServiceClientController {

    @Qualifier("org.example.productclient.Client.ProductServiceClient")
    @Autowired
    private final ProductServiceClient prodServiceClient;

    /**
     * 根据商品id查询商品
     */
    @GetMapping("/findByProductId/{productId}")
    public Product findByProductId(@PathVariable("productId") Long productId) {
        Product product = prodServiceClient.findByProductId(productId);
        log.info("-------------In client findByProductId---------------");
        return product;
    }

    /**
     * 查询所有商品
     */
    @GetMapping("/queryAllProduct")
    public List<Product> queryAllProduct() {
        List<Product> productList = prodServiceClient.queryAllProduct();
        //Thread.sleep(2000);
        log.info("--------------In client queryAllProduct--------------");
        return productList;
    }

    /**
     * 根据商品id删除商品
     */
    @DeleteMapping("/deleteByProductId/{productId}")
    public void deleteByProductId(@PathVariable("productId") Long productId) {
        prodServiceClient.deleteByProdubtId(productId);
        log.info("-------------In client deleteByProductId---------------");
    }

    /**
     * 插入商品对象
     */
    @PostMapping("/insertProduct")
    public void insertProduct(@RequestBody Product product){
        prodServiceClient.insertProduct(product);
        log.info("-------------In client insertProduct---------------");
    }

    /**
     * 更改商品对象
     */
    @PostMapping("/updateProduct")
    public void updateProduct(@RequestBody Product product){
        prodServiceClient.updateProduct(product);
        log.info("-------------In client updateProduct---------------");
    }
}
