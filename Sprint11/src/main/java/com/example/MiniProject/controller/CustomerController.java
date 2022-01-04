package com.example.MiniProject.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.MiniProject.model.Customer;
import com.example.MiniProject.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountController accountController;

	@PostMapping("/customer")
	public void createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		accountController.createAccount(customer.getAcctID(), 0, "Active");
	}

	@GetMapping("/customer/{acctID}")
	public Customer getCustomerInfo(@PathVariable int acctID) {
		return customerService.getCustomerInfo(acctID);
	}

	@DeleteMapping("/customer/{acctID}")
	public void deleteCustomer(@PathVariable int acctID) {
		customerService.deleteCustomer(acctID);
	}
    @GetMapping("/login")
	    public ModelAndView login() {
	     ModelAndView mav = new ModelAndView("login");
	        mav.addObject("user", new Customer());
	        return mav;
	    }
	 
	@PostMapping("/login")
	    public String login(@ModelAttribute("user") Customer user ) {
	        
	        Customer oauthUser = customerService.login(user.getAcctID(), user.getPassword());
	       
	    
	        System.out.print(oauthUser);
	        if(Objects.nonNull(oauthUser))
	        {
	     
	        return "redirect:/";
	       
	       
	        } else {
	        return "redirect:/login";
	       
	       
	        }
	    
	   }
	       
	       @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
	       public String logoutDo(HttpServletRequest request,HttpServletResponse response)
	       {
	       
	     
	           return "redirect:/login";
	       }
	    

}
