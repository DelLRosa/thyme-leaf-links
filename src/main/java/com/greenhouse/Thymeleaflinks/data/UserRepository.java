package com.greenhouse.Thymeleaflinks.data;

import com.greenhouse.Thymeleaflinks.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User,Integer>{
    User findByUsername(String username);
}
