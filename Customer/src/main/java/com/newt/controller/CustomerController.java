package com.newt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newt.model.Customer;
import com.newt.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")

public class CustomerController {
	
	private final CustomerRepository customerRepo;
@Autowired
	public CustomerController(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.GET)
	public Iterable findAll() {
		return customerRepo.findAll();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer find(@PathVariable Integer id) {
           return customerRepo.findOne(id);        
    }
	
	//@ApiOperation(value = "post a product")
    @RequestMapping(method = RequestMethod.POST)
    public Customer create(@RequestBody Customer cust) {
        return customerRepo.save(cust);
    }	
}
