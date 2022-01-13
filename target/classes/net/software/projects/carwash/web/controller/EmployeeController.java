package net.software.projects.carwash.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.software.projects.carwash.model.Employee;
import net.software.projects.carwash.model.enums.EmployeePosition;
import net.software.projects.carwash.model.enums.EmployeeStatus;
import net.software.projects.carwash.model.enums.Gender;
import net.software.projects.carwash.service.EmployeeService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showListOfObjects(ModelMap model) {
        model.put("employees", employeeService.findAll());
        return "list-employees";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddObjectPage(ModelMap model) {
		model.addAttribute("genders", Gender.values());
		model.addAttribute("positions", EmployeePosition.values());
		model.addAttribute("statuses", EmployeeStatus.values());
        model.addAttribute("employee", new Employee());
        return "employee";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String showDeleteObjectPage(ModelMap model, @RequestParam long id) {
    	employeeService.removeOne(id);
        return "redirect:/employee/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String showUpdateObjectPage(ModelMap model, @RequestParam long id) {
    	Employee employee = employeeService.findOne(id);
		model.addAttribute("genders", Gender.values());
		model.addAttribute("positions", EmployeePosition.values());
		model.addAttribute("statuses", EmployeeStatus.values());
        model.addAttribute("employee", employee);
        return "employee";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateObjectPost(@ModelAttribute("employee") Employee employee, HttpServletRequest request) {
    	employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addObjectPost(@ModelAttribute("employee") Employee employee, HttpServletRequest request) {
    	employeeService.save(employee);
        return "redirect:/employee/list";
    }
}
