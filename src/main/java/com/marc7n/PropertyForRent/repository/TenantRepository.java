package com.marc7n.PropertyForRent.repository;

import com.marc7n.PropertyForRent.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

}
