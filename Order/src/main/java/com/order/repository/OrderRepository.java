package com.order.repository;

	import org.springframework.data.jpa.repository.Modifying;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.CrudRepository;
	import org.springframework.transaction.annotation.Transactional;
import com.order.model.Custorder;

	@Transactional
	public interface OrderRepository extends CrudRepository <Custorder, Integer>{
		
		@Modifying
		@Query("update  #{#entityName}  e set e.orderName = ?1 where e.orderId = ?2")
		int updateByName(String orderName, Integer orderId);
		
		//@Query("select  e.custId from #{#entityName}  e where e.orderId = ?1")
		//int getCustomerId(Integer orderId);
		
	@Query("SELECT o.orderId, o.orderName, c.custId, c.custName, c.custAddress from custorder o join customer c ON  o.customerid = c.custId  where o.orderId = ?1")
	int getByOrderId(Integer orderId);
	}