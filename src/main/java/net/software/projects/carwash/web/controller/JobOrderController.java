package net.software.projects.carwash.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.software.projects.carwash.model.JobOrder;
import net.software.projects.carwash.model.enums.OrderStatus;
import net.software.projects.carwash.service.CustomerService;
import net.software.projects.carwash.service.EmployeeService;
import net.software.projects.carwash.service.JobOrderService;
import net.software.projects.carwash.service.ServicesOfferedService;

@Controller
@RequestMapping(value = "/order")
public class JobOrderController {
	
	@Autowired
    CustomerService customerService;
	
	@Autowired
	JobOrderService jobOrderService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
    ServicesOfferedService servicesOfferedService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showListOfObjects(ModelMap model) {
        model.put("orders", jobOrderService.findAll());
        return "list-orders";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddObjectPage(ModelMap model) {
        model.put("customers", customerService.findAll());
        model.put("attendants", employeeService.findAll());
        model.put("services", servicesOfferedService.findAll());
        model.addAttribute("orderStatuses", OrderStatus.values());
        model.addAttribute("order", new JobOrder());
        return "order";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String showDeleteObjectPage(ModelMap model, @RequestParam long id) {
    	jobOrderService.removeOne(id);
        return "redirect:/order/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String showUpdateObjectPage(ModelMap model, @RequestParam long id) {
    	JobOrder order = jobOrderService.findOne(id);
        model.put("customers", customerService.findAll());
        model.put("attendants", employeeService.findAll());
        model.put("services", servicesOfferedService.findAll());
        model.addAttribute("orderStatuses", OrderStatus.values());
        model.addAttribute("order", order);
        return "order";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateObjectPost(@ModelAttribute("order") JobOrder order, HttpServletRequest request) {
    	jobOrderService.save(order);
        return "redirect:/order/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addObjectPost(@ModelAttribute("order") JobOrder order, HttpServletRequest request) {
    	jobOrderService.save(order);
        return "redirect:/order/list";
    }
}
