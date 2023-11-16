package com.ubs.ubs.controller;

import com.ubs.ubs.model.domain.Paciente;
import com.ubs.ubs.model.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/novo")
    public ModelAndView newPaciente() {
        ModelAndView view = new ModelAndView("paciente");
        view.addObject("paciente", new Paciente());
        return view;
    }


    @PostMapping("/cadastrar-paciente")
    public String cadastrarPaciente(@ModelAttribute Paciente paciente) {
        // Lógica para cadastrar o paciente no banco de dados
        pacienteRepository.save(paciente);

        // Redirecionar para a página de listar-pacientes
        return "redirect:/paciente";
    }
}
