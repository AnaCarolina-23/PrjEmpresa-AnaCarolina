package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitie.Funcionario;
import com.example.demo.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@PostMapping("/inserir")
	public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario) {
		Funcionario funcionarioSalvo = funcionarioService.salvarFuncionario(funcionario);
		if (funcionarioSalvo != null) {
			return ResponseEntity.ok(funcionarioSalvo);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping
	public List<Funcionario> buscarTodosFuncionario() {
		return funcionarioService.buscarTodosFuncionario();
	}

	@GetMapping("/{id}")
	public Funcionario buscarPorId(@PathVariable Long id) {
		return funcionarioService.buscarFuncionarioPorId(id);
	}
}