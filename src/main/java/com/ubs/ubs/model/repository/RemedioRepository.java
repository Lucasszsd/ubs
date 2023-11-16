package com.ubs.ubs.model.repository;

import com.ubs.ubs.model.domain.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemedioRepository extends JpaRepository<Remedio,Long> {
}
