package com.example.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.repositories.CategoriaRepository;
import com.example.cursomc.services.exception.DataIntegrityException;
import com.example.cursomc.services.exception.ObjectNotFountException;


@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria Insert (Categoria cat) {
		cat.setId(null);
		return repo.save(cat);
	}
	
	public Categoria update (Categoria cat) {
		
		find(cat.getId());
		return repo.save(cat);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}catch(DataIntegrityViolationException e ) {
			throw new DataIntegrityException("Não é possivel excluir!");
		}
	}
}
