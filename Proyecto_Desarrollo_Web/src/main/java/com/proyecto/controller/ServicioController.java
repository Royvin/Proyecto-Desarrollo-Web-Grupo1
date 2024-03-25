package com.proyecto.controller;

import com.proyecto.service.ServicioService;
import com.tienda.domain.Servicio;
import com.tienda.service.ServicioService;
import com.tienda.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/servicio"))
public class ServicioController {
  
    @Autowired
    private ServicioService servicioService;


    @GetMapping("/listado")
    private String listado(Model model) {
        var servicios = servicioService.getservicios(false);
        model.addAttribute("servicios", servicios);
        model.addAttribute("totalServicios", servicios.size());
        return "/servicio/listado";
    }

    @GetMapping("/nuevo")
    public String servicioNuevo(Servicio servicio) {
        return "/servicio/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String servicioGuardar(Servicio servicio,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            servicioService.save(servicio);
            servicio.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "servicio",
                            servicio.getIdServicio()));
        }
        servicioService.save(servicio);
        return "redirect:/servicio/listado";
    }

    @GetMapping("/eliminar/{idServicio}")
    public String servicioEliminar(Servicio servicio) {
        servicioService.delete(servicio);
        return "redirect:/servicio/listado";
    }

    @GetMapping("/modifica/{idServicio}")
    public String servicioModificar(Servicio servicio, Model model) {
        servicio = servicioService.getServicio(servicio);
        model.addAttribute("servicio", servicio);

        return "/servicio/modifica";
    }
}