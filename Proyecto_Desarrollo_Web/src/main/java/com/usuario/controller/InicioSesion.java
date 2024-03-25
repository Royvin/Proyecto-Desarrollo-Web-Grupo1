package com.usuario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioSesion {

    @PostMapping("/iniciar-sesion")
    public String iniciarSesion(@RequestParam("email") String email,
                                @RequestParam("contrasenna") String contrasenna,
                                Model model) {
        // Lógica para iniciar sesión
        if (email.equals("usuario@example.com") && contrasenna.equals("contrasena")) {
            return "redirect:/inicio"; 
        } else {
            model.addAttribute("error", true);
            return "inicio-sesion"; 
        }
    }
}