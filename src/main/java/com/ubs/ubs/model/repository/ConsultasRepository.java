package com.ubs.ubs.model.repository;

import com.ubs.ubs.model.domain.Consultas;
import com.ubs.ubs.model.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ConsultasRepository extends JpaRepository<Consultas, Long> {
    List<Consultas> findByMedicoAndDataConsulta(Medico medico, Date dataConsulta);
}
