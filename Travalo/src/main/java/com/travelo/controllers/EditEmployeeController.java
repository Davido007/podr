package com.travelo.controllers;

/**
 * Created by ddph on 03/11/2015.
 */
import com.travelo.entities.EmployeeEntity;
import com.travelo.services.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/emp")
public class EditEmployeeController
{
    @Autowired
    private EmployeeManager employeeManager;
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("employee", new EmployeeEntity());
        model.addAttribute("employeeList", employeeManager.getAllEmployees());
        return "editEmployeeList";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listEmployees(ModelMap map)
    {
        map.addAttribute("employee", new EmployeeEntity());
        map.addAttribute("employeeList", employeeManager.getAllEmployees());
        return "editEmployeeList";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute(value="employee") EmployeeEntity employee, BindingResult result)
    {
        employeeManager.addEmployee(employee);
        return "redirect:/";
    }
    @RequestMapping("/delete/{employeeId}")
    public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId)
    {
        employeeManager.deleteEmployee(employeeId);
        return "redirect:/";
    }
    public void setEmployeeManager(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }
}
