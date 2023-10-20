package com.sprint3_activity.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint3_activity.crm.entity.Loja;
import com.sprint3_activity.crm.request.LojaRequest;
import com.sprint3_activity.crm.service.LojaService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/lojas")
public class LojaController {
	
	@Autowired
	private LojaService service;
	
	@PostMapping("/addLoja")
	public ResponseEntity<Loja> addloja(@Valid @RequestBody LojaRequest lojaRequest ){
		return new ResponseEntity<>(service.saveLoja_(lojaRequest), HttpStatus.CREATED);
	}
	@PostMapping("/addLojas")
	public ResponseEntity<List<Loja>> addloja(@Valid @RequestBody List<LojaRequest> lojasRequest ){
		return new ResponseEntity<>(service.saveLojas_(lojasRequest), HttpStatus.CREATED);
	}
	
	@GetMapping("/lojas")
	public ResponseEntity<List<Loja>> findAllLojas(){
		return ResponseEntity.ok(service.getLojas());
	}
	@GetMapping("/lojas/{id}")
	public ResponseEntity<Loja> getLojaById(@PathVariable int id){
		return ResponseEntity.ok(service.getLojaById(id));
	}
	@GetMapping("/lojas/{name}")
	public ResponseEntity<Loja> getLojaByName(@PathVariable String name){
		return ResponseEntity.ok(service.getLojaByName(name));
	}
	@PutMapping("/update")
	public ResponseEntity<Loja> updateLoja(@RequestBody Loja loja){
		return service.updateLoja(loja);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Loja> deleteLoja(@PathVariable int id){
		return service.deleteLoja(id);
	}
	
	
	
	
	
}
