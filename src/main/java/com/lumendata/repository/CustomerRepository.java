package com.lumendata.repository;

import com.lumendata.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<EmailEntity,String> {
     List<EmailEntity> findByPartyUid(String guid);
}
