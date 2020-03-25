package com.library.management.system.library_management_systelm.repository;

import com.library.management.system.library_management_systelm.entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {
}
