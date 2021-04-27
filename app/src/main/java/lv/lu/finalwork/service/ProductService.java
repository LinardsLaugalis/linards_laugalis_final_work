package lv.lu.finalwork.service;

import lv.lu.finalwork.domain.Product;
import lv.lu.finalwork.domain.ProductCategory;
import lv.lu.finalwork.model.ProductData;
import lv.lu.finalwork.model.ProductInputData;
import lv.lu.finalwork.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final Repository<Product> productRepository;

    @Autowired
    public ProductService(Repository<Product> productOrmRepository) {
        this.productRepository = productOrmRepository;
    }

    public void save(ProductInputData productData) {
        Product product = convertFrom(productData);
        productRepository.save(product);
    }

    private Product convertFrom(ProductInputData productData) {
        Product product = new Product();
        product.setName(productData.getName());
        product.setPrice(BigDecimal.valueOf(productData.getPrice()));
        product.setCategory(ProductCategory.valueOf(productData.getCategory()));

        if (productData.getDiscount() != null) {
            product.setDiscount(BigDecimal.valueOf(productData.getDiscount()));
        }

        if (productData.getDescription() != null) {
            product.setDescription(productData.getDescription());
        }

        return product;
    }

    public List<ProductData> findAll() {
        return productRepository.findAll().stream()
                .map(this::convertFrom)
                .collect(Collectors.toList());
    }

    private ProductData convertFrom(Product product) {
        return new ProductData(
                product.getId().toString(),
                product.getName(),
                product.getPrice().toPlainString()
        );
    }

}
