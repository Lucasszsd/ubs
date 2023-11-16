package com.ubs.ubs.model.repository;
import com.ubs.ubs.model.domain.OperacaoListaEstrutura;
import com.ubs.ubs.model.repository.ListaEstruturaRepository;

import java.util.Queue;

public interface ListaEstruturaService {
    void processarListaEstrutura(Queue<OperacaoListaEstrutura> operacoes);
}
