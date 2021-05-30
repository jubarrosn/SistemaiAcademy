package br.com.iacademy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.iacademy.model.Pagamento;
import br.com.iacademy.repository.PagamentoRepository;

@Controller
public class PagamentoController {

	
			@Autowired
			private PagamentoRepository pagamentoRepository;
			
			@GetMapping("/pagamentoAll")
			public List<Pagamento> listaPagamento(){
				return pagamentoRepository.findAll();
			}
				
			@GetMapping("/pagamentoId/{id}")
			public Optional<Pagamento> listaPagamentoId(@PathVariable(value = "id") long id) {
				return pagamentoRepository.findById(id);
			}
			
			@PostMapping("/pagamentoSave")
			public Pagamento salvaPagamento(@RequestBody Pagamento pagamento) {
				return pagamentoRepository.save(pagamento);
			}
			
			@DeleteMapping("/mpagamentoDelete")
			public void deletePagamento(@RequestBody Pagamento pagamento) {
				pagamentoRepository.delete(pagamento);
			}
			
			@PutMapping("/pagamentoUpdate")
			public Pagamento updatePagamento(@RequestBody Pagamento pagamento) {
				return pagamentoRepository.save(pagamento);
			}
}