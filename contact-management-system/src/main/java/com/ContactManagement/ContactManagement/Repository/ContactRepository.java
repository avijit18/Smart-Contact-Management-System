package com.ContactManagement.ContactManagement.Repository;

import com.ContactManagement.ContactManagement.Entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

}
