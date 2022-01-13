package net.software.projects.carwash.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.software.projects.carwash.model.Customer;
import net.software.projects.carwash.model.enums.Gender;
import net.software.projects.carwash.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
    CustomerService customerService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showListOfObjects(ModelMap model) {
        model.put("customers", customerService.findAll());
        return "list-customers";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddObjectPage(ModelMap model) {
		model.addAttribute("genders", Gender.values());
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String showDeleteObjectPage(ModelMap model, @RequestParam long id) {
    	customerService.removeOne(id);
        return "redirect:/customer/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String showUpdateObjectPage(ModelMap model, @RequestParam long id) {
    	Customer customer = customerService.findOne(id);
		model.addAttribute("genders", Gender.values());
        model.addAttribute("customer", customer);
        return "customer";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateObjectPost(@ModelAttribute("customer") Customer customer, HttpServletRequest request) {
    	customerService.save(customer);
        return "redirect:/customer/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addObjectPost(@ModelAttribute("customer") Customer customer, HttpServletRequest request) {
    	customerService.save(customer);
        return "redirect:/customer/list";
    }
}
