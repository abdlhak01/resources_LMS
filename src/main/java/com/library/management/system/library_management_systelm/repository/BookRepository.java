package com.library.management.system.library_management_systelm.repository;

import com.library.management.system.library_management_systelm.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
