package com.codeygym.book.repository;

import com.codeygym.book.model.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOderRepository extends JpaRepository<Oder, Long> {
}
