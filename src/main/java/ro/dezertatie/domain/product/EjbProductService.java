package ro.dezertatie.domain.product;


import org.apache.commons.lang.NullArgumentException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

@Stateless
public class EjbProductService implements ProductService {

    @Inject
    private ProductDao productDao;

    public Product create(Product entity) {
        return createOrUpdate(entity);
    }

    public Product update(Product entity) {
        return createOrUpdate(entity);
    }

    private Product createOrUpdate(Product entity) {
        if (entity == null) {
            throw new NullArgumentException("Null not allowed");
        }
        try {
            return productDao.save(entity);
        } catch (IllegalArgumentException e) {
            throw new ProductException("Failed to persist product", e);
        }
    }


    public void delete(Product entity) {
        if (entity == null) {
            throw new NullArgumentException("Null not allowed");
        }
        deleteById(entity.getId());
    }

    public void deleteById(String id) {
        try {
            productDao.delete(id);
        } catch (IllegalArgumentException e) {
            throw new ProductException("Failed to delete product", e);
        }
    }

    public Product get(String id) {
        Product product;
        try {
            product = productDao.findOne(id);
        } catch (IllegalArgumentException e) {
            throw new ProductException("Failed to retrieve product", e);
        }
        if (product == null) {
            throw new ProductException("Product not found");
        }
        return product;
    }

    public Collection<Product> getAll() {
        return productDao.findAll();
    }

    public Collection<Product> getAll(long offset, long limit) {
        throw new UnsupportedOperationException();
    }
}
