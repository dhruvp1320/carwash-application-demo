package net.software.projects.carwash.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.software.projects.carwash.model.Service;
import net.software.projects.carwash.service.ServicesOfferedService;

@Controller
@RequestMapping(value = "/service")
public class OfferedServicesController {
	
	@Autowired
    ServicesOfferedService servicesOfferedService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showListOfObjects(ModelMap model) {
        model.put("services", servicesOfferedService.findAll());
        return "list-services";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddObjectPage(ModelMap model) {
        model.addAttribute("service", new Service());
        return "service";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String showDeleteObjectPage(ModelMap model, @RequestParam long id) {
    	servicesOfferedService.removeOne(id);
        return "redirect:/service/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String showUpdateObjectPage(ModelMap model, @RequestParam long id) {
        Service service = servicesOfferedService.findOne(id);
        model.addAttribute("service", service);
        return "service";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateObjectPost(@ModelAttribute("service") Service service, HttpServletRequest request) {
    	servicesOfferedService.save(service);
        return "redirect:/service/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addObjectPost(@ModelAttribute("service") Service service, HttpServletRequest request) {
    	servicesOfferedService.save(service);
        return "redirect:/service/list";
    }
}
