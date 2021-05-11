package lv.lu.finalwork.repository;

import lv.lu.finalwork.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Transactional
@org.springframework.stereotype.Repository
public class ProductOrmRepository implements Repository<Product> {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductOrmRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long save(Product entity) {
        return (Long) this.sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public List<Product> findAll() {

        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<Product> criteriaQuery = session.getCriteriaBuilder().createQuery(Product.class);
        criteriaQuery.from(Product.class);

        return session.createQuery(criteriaQuery).getResultList();

       /* return sessionFactory.getCurrentSession()
                .createQuery("FROM PRODCUTS P", Product.class)
                .getResultList();*/
        // return sessionFactory.getCurrentSession().createQuery("FROM PRODUCTS").list();
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
