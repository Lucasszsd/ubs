package com.ubs.ubs.controller;

import com.ubs.ubs.model.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
}
