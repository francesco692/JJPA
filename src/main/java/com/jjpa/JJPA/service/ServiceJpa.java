package com.jjpa.JJPA.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjpa.JJPA.model.Persona;
import com.jjpa.JJPA.repository.IPersona;

import antlr.collections.List;

@Service
public class ServiceJpa {
	
	@Autowired
	IPersona repo;
	public String getPersona(String cf)
	{
		Persona p = repo.findByCodiceFiscale(cf);
		return p.getCodiceFiscale() + " " + p.getNome() + " " + p.getCognome() + " " + p.getCap() + " " + p.getTarga();
	}
	public void insertPersona(Persona data)
	{
		repo.save(data);
	}
	
	public Persona getByNome(String nome) {
		ArrayList<Persona> result = new ArrayList<Persona>();
		return null;
		
	}
	public ArrayList<Persona> findByCognomeAndNome(String cognome, String nome)
	{
		return repo.findByCognomeAndNome(cognome,nome);
	}
	
	public ArrayList<Persona> findByCognomeAndNome2(String cognome, String nome)
	{
		return repo.findByCognomeAndNome2(cognome,nome);
	}

}
