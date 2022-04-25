package com.ranu.juraganangkot.controller;

import com.ranu.juraganangkot.entity.Angkot;
import com.ranu.juraganangkot.entity.Driver;
import com.ranu.juraganangkot.service.framework.AngkotService;
import com.ranu.juraganangkot.service.framework.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AngkotWebController {
    private AngkotService angkotService;

    @GetMapping("/angkot")
    public String index(Model model) {
        model.addAttribute("angkot", angkotService.getAllAngkots());
        return "indexAngkot";
    }

    @GetMapping(value = "/createangkot")
    public String create1(Model model) {
        model.addAttribute("angkot", new Angkot());
        return "formAngkot";
    }

    @PostMapping(value = "/createangkot")
    public String tambahDriver(Model model, Angkot angkot) {
        model.addAttribute("angkot", angkotService.save(angkot));
        return "redirect:/angkot";
    }

    @GetMapping(value = "/editangkot/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("angkot", angkotService.findById(id));
        return "formAngkot";
    }

    @GetMapping(value = "/hapusangkot/{id}")
    public String hapusAngkot(@PathVariable Long id) {
        angkotService.deleteById(id);
        return "redirect:/angkot";
    }
}
