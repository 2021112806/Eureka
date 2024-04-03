package org.example.productclient.Client;

import org.example.productclient.model.Product;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品服务远程调用客户端
 */
@FeignClient(name="product-service")
public interface ProductServiceClient {
    /**
     * 根据商品id获取商品对象
     * @param productId
     * @return 商品对象
     */
    @GetMapping("/findByProductId/{productId}")
    Product findByProductId(@RequestParam(value = "productId") Long productId);

     /**
      * 获取所有商品集合
      * @return 所有商品对象
      */
    @GetMapping("queryAllProduct")
    List<Product> queryAllProduct();

    /**
     * 根据商品id删除商品对象
     * @param productId
     */
    @DeleteMapping("/deleteByProductId/{productId}")
    void deleteByProdubtId(@RequestParam(value = "productId") Long productId);

    /**
     * 插入商品对象
     */
    @PostMapping("/insertProduct")
    void insertProduct(@RequestBody Product product);

    /**
     * 更改商品对象
     */
    @PostMapping("/updateProduct")
    void updateProduct(@RequestBody Product product);
}
