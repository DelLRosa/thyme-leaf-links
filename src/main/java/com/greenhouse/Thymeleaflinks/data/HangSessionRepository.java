package com.greenhouse.Thymeleaflinks.data;

import com.greenhouse.Thymeleaflinks.models.HangSession;
import com.greenhouse.Thymeleaflinks.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HangSessionRepository extends CrudRepository<HangSession,Integer> {
    List<HangSession> findByUser(User user);
}
