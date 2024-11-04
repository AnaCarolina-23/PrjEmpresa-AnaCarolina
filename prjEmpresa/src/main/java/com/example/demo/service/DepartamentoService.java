package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitie.Departamento;
import com.example.demo.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	private final DepartamentoRepository departamentoRepository;

	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	public Departamento salvarDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	public Departamento buscarDepartamentoPorId(Long id) {
		return departamentoRepository.findById(id).orElse(null);
	}

	public List<Departamento> buscarTodosDepartamento() {
		return departamentoRepository.findAll();
	}

	public void excluirDepartamento(Long id) {
		departamentoRepository.deleteById(id);
	}
}