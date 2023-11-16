package com.ubs.ubs.controller;

import com.ubs.ubs.model.repository.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/remedio")
public class RemedioController {
    @Autowired
    private RemedioRepository remedioRepository;
}
