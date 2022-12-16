package com.example.demo.repository;

import com.example.demo.model.Phim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhimRepository extends JpaRepository<Phim, Long> {
}
