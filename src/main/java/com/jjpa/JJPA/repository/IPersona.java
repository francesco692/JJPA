package com.jjpa.JJPA.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.jjpa.JJPA.model.*;

import antlr.collections.List;

@Repository
public interface IPersona extends JpaRepository<Persona, String>
{
Persona findByCodiceFiscale(String cf);
Persona save(Persona data);

@Query(value = "select * from persona p where p.cognome=:cognome and p.nome=:nome", nativeQuery=true)
ArrayList<Persona> findByCognomeAndNome(@Param("cognome") String cognome, @Param("nome") String nome);

@Query(value = "select * from persona p where p.cognome=?1 and p.nome=?2", nativeQuery=true)
ArrayList<Persona> findByCognomeAndNome2(String cognome, String nome);
}
