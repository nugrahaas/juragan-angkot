package com.ranu.juraganangkot.controller;

import com.ranu.juraganangkot.entity.Driver;
import com.ranu.juraganangkot.service.framework.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class DriverWebController {
    private DriverService driverService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("driver", driverService.getAllDrivers());
        return "index";
    }

    @GetMapping(value = "/create")
    public String create1(Model model) {
        model.addAttribute("driver", new Driver());
        return "formDriver";
    }

    @PostMapping(value = "/create")
    public String tambahDriver(Model model, Driver driver) {
        model.addAttribute("driver", driverService.save(driver));
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("driver", driverService.findById(id));
        return "formDriver";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusDriver(@PathVariable Long id) {
        driverService.deleteById(id);
        return "redirect:/";
    }
}
