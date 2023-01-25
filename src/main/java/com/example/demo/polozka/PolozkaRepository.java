package com.example.demo.polozka;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PolozkaRepository extends CrudRepository<PolozkaEntity, Long> {
    @Override
    List<PolozkaEntity> findAll();
    Optional<PolozkaEntity> findById(Long id);
}




