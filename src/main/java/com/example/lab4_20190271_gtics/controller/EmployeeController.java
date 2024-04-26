package com.example.lab4_20190271_gtics.controller;

import com.example.lab4_20190271_gtics.entity.Employee;
import com.example.lab4_20190271_gtics.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @GetMapping(value = {"/list", ""})
    public String listarTransportistas(Model model) {

        List<Employee> lista = employeeRepository.findAll();
        model.addAttribute("employeelist", lista);

        return "employee/Recursos_Humano_GTICS";
    }

    @GetMapping("/new")
    public String nuevoEmpleadoFrm() {
        return "shipper/newFrm";
    }

    @PostMapping("/save")
    public String guardarNuevoEmpleado(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employee/list";
    }
    @GetMapping("/edit")
    public String editarEmpleado(Model model,
                                      @RequestParam("id") int id) {

        Optional<Employee> optEmployee = employeeRepository.findById(id);

        if (optEmployee.isPresent()) {
            Employee employee = optEmployee.get();
            model.addAttribute("employee", employee);
            return "shipper/editFrm";
        } else {
            return "redirect:/shipper/list";
        }
    }
    @GetMapping("/delete")
    public String borrarTransportista(Model model,
                                      @RequestParam("id") int id) {

        Optional<Employee> optEmployee = employeeRepository.findById(id);

        if (optEmployee.isPresent()) {
            employeeRepository.deleteById(id);
        }
        return "redirect:/shipper/list";

    }

}
