package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitie.Departamento;
import com.example.demo.entitie.Funcionario;
import com.example.demo.repository.DepartamentoRepository;
import com.example.demo.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;
	private final DepartamentoRepository departamentoRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository,
			DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
		this.funcionarioRepository = funcionarioRepository;
	}

	public Funcionario salvarFuncionario(Funcionario funcionario) {
		if (funcionario.getDepartamento() != null && funcionario.getDepartamento().getId() != null) {
			Optional<Departamento> departamento = departamentoRepository
					.findById(funcionario.getDepartamento().getId());
			if (departamento.isPresent()) {
				funcionario.setDepartamento(departamento.get());
				return funcionarioRepository.save(funcionario);
			} else {
				throw new RuntimeException("Departamento não encontrado");
			}
		} else {
			throw new RuntimeException("ID do Departamento é Obrigatório");
		}
	}

	public Funcionario buscarFuncionarioPorId(Long id) {
		return funcionarioRepository.findById(id).orElse(null);
	}

	public List<Funcionario> buscarTodosFuncionario() {
		return funcionarioRepository.findAll();
	}
}