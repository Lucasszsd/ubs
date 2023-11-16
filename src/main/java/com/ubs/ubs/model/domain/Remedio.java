package com.ubs.ubs.model.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REM_REMEDIOS")
public class Remedio {
    @Id
    private Long id;
    private String nome;

}
