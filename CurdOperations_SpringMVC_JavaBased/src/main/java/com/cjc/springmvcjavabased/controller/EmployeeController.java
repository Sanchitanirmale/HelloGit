package com.cjc.springmvcjavabased.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.springmvcjavabased.model.Employee;
import com.cjc.springmvcjavabased.servicei.EmployeeServicei;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeServicei esi;

    @RequestMapping("/")
	public String preLogin()
	{
		return "login";
	}

    @RequestMapping("/openreg")
    public String preRegister() {
        return "register";
    }

    @RequestMapping("/save")
    public String saveEmployee(@ModelAttribute Employee e) {
        esi.saveEmployee(e);
        return "login";
    }
    @RequestMapping("/login")
    public String loginEmployee(@RequestParam String username, @RequestParam String password, Model m) {
        List<Employee> list = esi.loginEmployee(username, password);
        if (!list.isEmpty()) {
            m.addAttribute("l", list);
            return "success";
        } else {
            return "login";
        }
    }
      @RequestMapping("/delete")
    public String deleteEmployee(@RequestParam int id, Model m) {
        List<Employee> list = esi.deleteEmployee(id);
        m.addAttribute("l", list);
        return "success";
    }
      @RequestMapping("/edit")
    public String editEmployee(@RequestParam int id, Model m)
    {
    	Employee e =esi.editEmployee(id);
    	m.addAttribute("e", e);
		return "edit";
    	
    }
      @RequestMapping("/update")
      public String updateEmployee(@ModelAttribute Employee e, Model m)
      {
    	  List<Employee> list =esi.updateEmployee(e);
    	  m.addAttribute("l", list);
		return "success";
    	  
      }
}
