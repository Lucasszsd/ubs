package com.ubs.ubs.model.repository;

import com.ubs.ubs.model.domain.OperacaoListaEstrutura;
import org.springframework.stereotype.Repository;

import java.util.Queue;

@Repository
public class ListaEstruturaRepositoryImpl implements ListaEstruturaRepository {

    @Override
    public void processarListaEstrutura(Queue<OperacaoListaEstrutura> operacoes) {

    }
}
