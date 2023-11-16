package com.ubs.ubs.controller;

import com.ubs.ubs.model.domain.OperacaoListaEstrutura;
import com.ubs.ubs.model.repository.ListaEstruturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;

@RestController
@RequestMapping("/listaEstrutura")
public class ListaEstruturaController {

    @Autowired
    private ListaEstruturaService listaEstruturaService;

    @PostMapping("/adicionar-operacoes")
    public void adicionarOperacoesListaEstrutura(@RequestBody Queue<OperacaoListaEstrutura> operacoes) {
        listaEstruturaService.processarListaEstrutura(operacoes);
    }
}
