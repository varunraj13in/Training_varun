package com.example.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.model.Sales;
import com.example.store.service.StoreService;

@RestController
public class StoreRestController {
	
	@Autowired
	private StoreService service;
	
	@GetMapping("/showsales")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Sales> fetchSalesList(){
		List<Sales> salesInfo = new ArrayList<Sales>();
		salesInfo = service.fetchSalesList();
		return salesInfo;
	}
	@PostMapping("/addsales")
	@CrossOrigin(origins = "http://localhost:4200")
	public Sales addSales(@RequestBody Sales sales){
		return service.saveSalesToDb(sales);
	}
	
	@GetMapping("/showsalesbyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Sales fetchSalesById(@PathVariable int id){
		return service.fetchSalesById(id).get();
	}
	
	@DeleteMapping("/deletesalesbyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String deleteSalesById(@PathVariable int id){
		return service.deleteSalesById(id);
	}
	
	@PostMapping("/checkuser")
	@CrossOrigin(origins = "http://localhost:4200")
	public String checkuser(@RequestParam String unm, @RequestParam String pwd){
		String admin = "admin";
		if(unm.equalsIgnoreCase(admin)) {
			return "admin";
		}
		else if(unm.equalsIgnoreCase(pwd)) {
			return "valid user";
		}
		return "Invalid user";
	}
}
