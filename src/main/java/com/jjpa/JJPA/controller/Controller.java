package com.jjpa.JJPA.controller;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jjpa.JJPA.model.Persona;
import com.jjpa.JJPA.service.ServiceJpa;

@CrossOrigin
@RestController
public class Controller {
@Autowired
ServiceJpa service;
@GetMapping("/execute")
String execute (@RequestParam String  cf)
{
	return (service.getPersona(cf));
}
@PostMapping(value = "/save", consumes = {"application/json"})
void save(@RequestBody Map<String,String> body) {
Gson gson = new Gson();
String json = gson.toJson(body);
Persona p = gson.fromJson(json,Persona.class);
System.out.println(p.getCognome());
service.insertPersona(p);
}
@GetMapping(value = "/findp")
String findByCognomeAndNome(@RequestParam String nome, @RequestParam String cognome) 
{
	ArrayList<Persona> persone = service.findByCognomeAndNome(cognome,nome);
	persone.forEach(element -> System.out.println(element.getNome() + element.getCognome()));
	return null;
}

@GetMapping(value = "/findpp")
String findByCognomeAndNome2(@RequestParam String cognome, @RequestParam String nome) 
{
	ArrayList<Persona> persone = service.findByCognomeAndNome(cognome,nome);
	persone.forEach(element -> System.out.println(element.getNome() + element.getCognome()));
	return null;
}

@GetMapping(value ="test")
String str(@RequestParam String parameter)
{
	return "ciao"+parameter;
}
}
