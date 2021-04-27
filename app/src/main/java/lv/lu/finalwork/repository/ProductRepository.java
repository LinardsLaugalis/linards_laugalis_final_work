package lv.lu.finalwork.repository;

import lv.lu.finalwork.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@org.springframework.stereotype.Repository
class ProductRepository implements Repository<Product> {

    private Long idCounter = 0L;
    private Map<Long, Product> repository = new HashMap<>();

    @Override
    public Long save(Product entity) {
        idCounter++;

        entity.setId(idCounter);
        repository.put(idCounter, entity);

        return idCounter;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Product findById(Long id) {
        return repository.get(id);
    }

    @Override
    public void delete(Long id) {
        repository.remove(id);
    }
}
