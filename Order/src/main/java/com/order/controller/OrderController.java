package com.order.controller;


	import java.io.IOException;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.cloud.client.ServiceInstance;
	import org.springframework.cloud.client.discovery.DiscoveryClient;
	import org.springframework.http.HttpEntity;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpMethod;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.client.RestTemplate;

import com.order.DTO.OrderDTO;
import com.order.model.Custorder;
import com.order.repository.OrderRepository;

import io.swagger.annotations.ApiOperation;

	@RestController
	@RequestMapping("/orders")

public class OrderController {
		
//		@RequestMapping(value = "/", method = RequestMethod.GET)
//		public String getName(){
//			return "Hi";
//		}
		
		@Autowired
	    private DiscoveryClient discoveryClient;
	    private final OrderRepository repository;
	    String url=new String();
	    
	    @Autowired
	    public OrderController(OrderRepository repository) {
	        this.repository = repository;
	    }
	    @SuppressWarnings("rawtypes")
		@RequestMapping(method = RequestMethod.GET)
	    @ApiOperation(value = "Get all Orders")
	    public Iterable findAllOrders(){
	    	return repository.findAll();
	    }
	    
	    
	    @ApiOperation(value = "Get all customerss api Call")
	    @RequestMapping(value = "/customers", method = RequestMethod.GET)
	    public Object findAll() {
	    	return getapi();
	    }
	    @ApiOperation(value="Get Details By OrderId")
		@RequestMapping(value="/{orderId}", method=RequestMethod.GET)
		public int getDetails(@PathVariable Integer orderId){
			return repository.getByOrderId(orderId); 
			
		}
	    
	 @ApiOperation(value = "Get the order using Orderid")
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 public Custorder findOne(@PathVariable Integer id) {
		return repository.findOne(id);   
	 }
	    
	    @ApiOperation(value = "Post a order")
	    @RequestMapping(method = RequestMethod.POST)
	    public Custorder create(@RequestBody Custorder detail) {
	        return repository.save(detail);
	    }
	    
	    @ApiOperation(value="Update OrderName By OrderId")
		@RequestMapping(value="/update/{orderName}/{orderId}", method=RequestMethod.PUT)
		public int updateBysal(@PathVariable String orderName,@PathVariable Integer orderId){
			return repository.updateByName(orderName, orderId);
			
		}
	    
	    @ApiOperation(value = "Delete the order using id")
	    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	    public void delete(@PathVariable Integer id){
			 repository.delete(id);
	    	
	    }
	    
	    public HttpEntity<String> prepareGet() throws  IOException {
	    	  HttpEntity<String> entity = new HttpEntity<String>(prepareHeader());
	    	  return entity;
	    	 }
	    
	    public HttpHeaders prepareHeader() throws  IOException {
	    	  HttpHeaders headers = new HttpHeaders();
	    	  headers.add("Content-Type", "application/json");
	    	  return headers;
	    	 }
	    
	    public RestTemplate restTemplate = new RestTemplate();
	    
	    public Object getapi(){
	    	ResponseEntity<Object> response = null;

	    	HttpEntity<String> requestEntity;
	    	try {
	    		requestEntity = prepareGet();
	    		
	    		discoveryClient.getInstances("CUSTOMERSERVICE").forEach((ServiceInstance s) -> {url=s.getUri().toString();});
	    		
	    		System.out.println("URL:"+url);
	    	
	    		response = restTemplate.exchange(url+"/customers", HttpMethod.GET, requestEntity, Object.class);
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
			return response.getBody();
	    }
	}