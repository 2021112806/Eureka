package org.example.productclient.model;
import lombok.Data;

/**
 * 商品的实体
 *
 * @author 张赵东
 */

@Data
public class Product {
    private Long id;
    private String productName;
    private Double price;
    private Long stock;
}
