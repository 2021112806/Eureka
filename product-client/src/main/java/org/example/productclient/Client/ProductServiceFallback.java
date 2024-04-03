package org.example.productclient.Client;
import org.example.productclient.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;

@Slf4j
@Component
public class ProductServiceFallback implements ProductServiceClient {
    @Override
    public Product findByProductId(Long productId) {
        log.info("findByProductId callback");
        return null;
    }

    @Override
    public List<Product> queryAllProduct() {
        log.info("queryAllProduct callback");
        return null;
    }

    @Override
    public void deleteByProdubtId(Long productId) {
        log.info("deleteByProdubtId callback");
    }

    @Override
    public void insertProduct(Product product) {
        log.info("insertProduct callback");
    }

    @Override
    public void updateProduct(Product product) {
        log.info("updateProduct callback");
    }
}
