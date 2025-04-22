package com.Loja.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Loja.Entity.Cliente;
import com.Loja.Service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscaClienteControlId(@PathVariable Long id) {
		Cliente cliente = clienteService.buscaClienteById(id);
		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Cliente>> buscaTodosClientesControl() {
		List<Cliente> Cliente = clienteService.buscaTodosClientes();
		return ResponseEntity.ok(Cliente);
	}

	@PostMapping("/")
	public ResponseEntity<Cliente> criarCliente(@RequestBody @Valid Cliente cliente) {
		Cliente criarCliente = clienteService.salvarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarCliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> alterarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente alterarCliente = clienteService.alterarCliente(id, cliente);
		if (alterarCliente != null) {
			return ResponseEntity.ok(alterarCliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> apagarCliente(@PathVariable Long id) {
		boolean apagar = clienteService.apagarCliente(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
