package lv.lu.finalwork.service;

import lv.lu.finalwork.model.Product;
import lv.lu.finalwork.model.ProductCategory;
import lv.lu.finalwork.model.ProductInputData;
import lv.lu.finalwork.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repositoryMock;

    @Test
    public void shouldConvertAndStoreProductData() {
        ProductInputData inputData = getProduct("Orange", 0.75, "FRUIT", 5D, "Very tasty fruit");
        service.save(inputData);

        Product expectedProduct = new Product();
        expectedProduct.setName("Orange");
        expectedProduct.setPrice(BigDecimal.valueOf(0.75));
        expectedProduct.setCategory(ProductCategory.FRUIT);
        expectedProduct.setDiscount(BigDecimal.valueOf(5D));
        expectedProduct.setDescription("Very tasty fruit");

        verify(repositoryMock).save(expectedProduct);
    }

    private ProductInputData getProduct(String name, Double price, String category, Double discount, String description) {
        ProductInputData inputData = new ProductInputData();
        inputData.setName(name);
        inputData.setPrice(price);
        inputData.setCategory(category);
        inputData.setDiscount(discount);
        inputData.setDescription(description);

        return inputData;
    }
}