package com.example.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.model.Sales;
import com.example.store.repo.StoreRepo;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepo repo;
	
	public List<Sales> fetchSalesList(){
		return repo.findAll();
	}
	
	public Sales saveSalesToDb(Sales sales) {
		return repo.save(sales);
	}
	
	public Optional<Sales> fetchSalesById(int id) {
		return repo.findById(id);
	}
	
	public String deleteSalesById(int id) {
		
		String result = "";
		try {
			repo.deleteById(id);
			result = "product successfully deleted";
		} catch (Exception e) {
			result = "product with id not deleted";
		}
		return result;
	}
}
 