package lv.lu.finalwork.repository;

import lv.lu.finalwork.model.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ProductRepositoryTest {
    private Map<Long, Product> repoMock;
    private ProductRepository victim;

    @Before
    public void setUp() throws Exception {
        repoMock = new HashMap<>();
        victim = new ProductRepository(repoMock);
    }

    @Test
    public void shouldFindAllProducts() {
        Product orange = new Product();
        orange.setId(2L);

        Product bread = new Product();
        bread.setId(4L);

        repoMock.put(1L, orange);
        repoMock.put(2L, bread);

        List<Product> result = victim.findAll();

        assertNotNull(result);
        assertTrue(result.contains(orange));
        assertTrue(result.contains(bread));
    }

    @Test
    public void shouldFindProductById() {
        Product orange = new Product();
        repoMock.put(1L, orange);

        Product result = victim.findById(1L);

        assertEquals(orange, result);
    }

    @Test
    public void shouldSaveProduct() {
        Product orange = new Product();
        Long productId = victim.save(orange);

        assertTrue(repoMock.containsKey(productId));
        assertEquals(orange, repoMock.get(productId));
        assertEquals(productId, orange.getId());
    }

    @Test
    public void shouldRemoveProductById() {
        Product orange = new Product();
        orange.setId(1L);
        repoMock.put(1L, orange);

        victim.delete(1L);

        assertFalse(repoMock.containsKey(1L));
        assertFalse(repoMock.containsValue(orange));
    }
}