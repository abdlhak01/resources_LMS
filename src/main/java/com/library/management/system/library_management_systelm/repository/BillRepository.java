package com.library.management.system.library_management_systelm.repository;

import com.library.management.system.library_management_systelm.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer> {
}
