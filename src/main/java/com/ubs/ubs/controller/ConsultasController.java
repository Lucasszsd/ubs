package com.ubs.ubs.controller;

import com.ubs.ubs.model.domain.Consultas;
import com.ubs.ubs.model.repository.ConsultasRepository;
import com.ubs.ubs.model.repository.MedicoRepository;
import com.ubs.ubs.model.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/consultas")
public class ConsultasController {

    @Autowired
    private ConsultasRepository consultasRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public ModelAndView all() {
        ModelAndView view = new ModelAndView("consultas");
        view.addObject("consultas", consultasRepository.findAll());
        return view;
    }

    @GetMapping("/nova")
    public ModelAndView novaConsultaForm() {
        ModelAndView view = new ModelAndView("marcar-consultas");
        view.addObject("consulta", new Consultas());
        view.addObject("medicos", medicoRepository.findAll());
        view.addObject("pacientes", pacienteRepository.findAll());
        return view;
    }

    @PostMapping("/nova")
    public String novaConsulta(@ModelAttribute Consultas consulta) {
        consulta.setDataMarcada(new Date());
        consultasRepository.save(consulta);
        return "redirect:/consultas";
    }
}
