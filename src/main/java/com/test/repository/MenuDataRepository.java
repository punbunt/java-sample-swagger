package com.test.repository;

import com.test.model.Entity.MenuDataEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface MenuDataRepository extends CrudRepository<MenuDataEntity, String> {
    List<MenuDataEntity> findByName(String name);
    Optional<MenuDataEntity> findById(int id);
}
