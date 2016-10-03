package com.newt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newt.model.Customer;

import java.lang.String;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository <Customer , Integer> 
{
	List<Customer> findByCustId(Integer custid);

}
