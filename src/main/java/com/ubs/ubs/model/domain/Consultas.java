package com.ubs.ubs.model.domain;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CON_CONSULTA")
@lombok.Data
public class Consultas {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;
    private Date dataMarcada;
    private Date dataConsulta;

    @ManyToOne
    @JoinColumn(name="idPaciente")
    private Paciente paciente;

}
