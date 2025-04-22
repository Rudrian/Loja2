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

import com.Loja.Entity.ItemVenda;
import com.Loja.Service.ItemVendaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/itemVenda")
public class ItemVendaController {

	private final ItemVendaService itemVendaService;

	@Autowired
	public ItemVendaController(ItemVendaService itemVendaService) {
		this.itemVendaService = itemVendaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemVenda> buscaItemVendaControlId(@PathVariable Long id) {
		ItemVenda itemVenda = itemVendaService.buscaItemVendaById(id);
		if (itemVenda != null) {
			return ResponseEntity.ok(itemVenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<ItemVenda>> buscaTodosItemVendaControl() {
		List<ItemVenda> ItemVenda = itemVendaService.buscaTodosItemVendas();
		return ResponseEntity.ok(ItemVenda);
	}

	@PostMapping("/")
	public ResponseEntity<ItemVenda> salvaItemVendaControl(@RequestBody @Valid ItemVenda itemVenda) {
		ItemVenda salvaItemVenda = itemVendaService.salvarItemVenda(itemVenda);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaItemVenda);
	}

	@PutMapping("/")
	public ResponseEntity<ItemVenda> alteraItemVendaControl(@PathVariable Long id,
			@RequestBody @Valid ItemVenda itemVenda) {
		ItemVenda alteraItemVenda = itemVendaService.alterarItemVenda(id, itemVenda);
		if (alteraItemVenda != null) {
			return ResponseEntity.ok(itemVenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ItemVenda> apagaItemVendaControl(@PathVariable Long id) {
		boolean apagar = itemVendaService.apagarItemVenda(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}