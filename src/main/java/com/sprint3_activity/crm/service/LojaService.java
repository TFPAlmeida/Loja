package com.sprint3_activity.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprint3_activity.crm.entity.Loja;
import com.sprint3_activity.crm.repository.LojaRepository;
import com.sprint3_activity.crm.request.LojaRequest;

@Service
public class LojaService {
	
	private LojaRepository repository;
	
	public Loja saveLoja_(LojaRequest lojaRequest) {
		Loja loja = Loja.build(0, lojaRequest.getName(), lojaRequest.getCidade(), lojaRequest.getPaís());
		return repository.save(loja);
	}
	
	public List<Loja> saveLojas_(List<LojaRequest> lojasRequest) {
		
	List<Loja> lojas = new ArrayList<>();
	for (LojaRequest lojaRequest : lojasRequest) {
		Loja loja = Loja.build(0, lojaRequest.getName(), lojaRequest.getCidade(), lojaRequest.getPaís());
		lojas.add(loja);
	}
		return repository.saveAll(lojas);
	}
	
	public List<Loja> getLojas(){
		return repository.findAll();
	}
	
	public Loja getLojaById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Loja getLojaByName(String name) {
		return repository.findByName(name);
	}
	
	public ResponseEntity<Loja> deleteLoja(int id){
		if(!repository.existsById(id)){
			System.out.println("Loja " + id + "not found");
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		System.out.println("loja removed!!" + id);
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<Loja> updateLoja(Loja loja){
		if(!repository.existsById(loja.getId())) {
			System.out.println("product removed !!" + loja.getId());
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(loja.getId());
		System.out.println(loja.getId());
		
		loja.setName(loja.getName());
		loja.setCidade(loja.getCidade());
		loja.setPaís(loja.getPaís());
		repository.save(loja);
		return ResponseEntity.noContent().build();
	}

}
