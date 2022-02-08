package com.marc7n.PropertyForRent.repository;

import com.marc7n.PropertyForRent.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property>findAll();

    Optional<Property> findById(long id);


}
