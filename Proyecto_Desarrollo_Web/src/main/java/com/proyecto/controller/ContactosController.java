package com.proyecto.controller;


import com.proyecto.domain.Contactos;
import com.proyecto.service.ContactosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/contactos")
public class ContactosController {
  
    @Autowired
    private ContactosService contactosService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var contactos = contactosService.getContactos(false);
        model.addAttribute("contactos", contactos);
        model.addAttribute("totalContactos",contactos.size());
        return "/contactos/listado";
    }
    
     @GetMapping("/nuevo")
    public String contactosNuevo(Contactos contactos) {
        return "/contactos/modifica";
    }
    
//    @PostMapping("/guardar")
//    public String contactosGuardar(Contactos contactos,
//            @RequestParam("imagenFile") MultipartFile imagenFile) {        
//        if (!imagenFile.isEmpty()) {
//            contactosService.save(contactos);
//            contactos.setRutaImagen(
//                    firebaseStorageService.cargaImagen(
//                            imagenFile, 
//                            "contactos", 
//                            contactos.getIdContactos()));
//        }
//        contactosService.save(contactos);
//        return "redirect:/contactos/listado";
//    }

    @GetMapping("/eliminar/{idContactos}")
    public String contactosEliminar(Contactos contactos) {
        contactosService.delete(contactos);
        return "redirect:/contactos/listado";
    }

    @GetMapping("/modificar/{idContactos}")
    public String contactosModificar(Contactos contactos, Model model) {
        contactos = contactosService.getContactos(contactos);
        model.addAttribute("contactos", contactos);
        return "/contactos/modifica";
    }   
}