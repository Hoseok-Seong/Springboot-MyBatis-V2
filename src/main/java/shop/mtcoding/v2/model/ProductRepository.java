package shop.mtcoding.v2.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository {
    public List<Product> findAll();

    public Product findById(int id);

}
