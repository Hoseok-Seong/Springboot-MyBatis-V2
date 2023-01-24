package shop.mtcoding.v2.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {
    public int insert(@Param("username") String username,
            @Param("password") String password, @Param("email") String email);
}
