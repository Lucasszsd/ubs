package com.ubs.ubs.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "MED_MEDICO")
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uf;
    private String numeroCrm;
    private String orgao;
    private String nome;
    private String cpf;


}
