package br.com.iacademy.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.iacademy.model.Pagamento;
import br.com.iacademy.repository.PagamentoRepository;

@Controller
@RequestMapping({"/pagamento"})
public class PagamentoController {

	
			@Autowired
			private PagamentoRepository pagamentoRepository;
			
			

			@GetMapping
			public List<Pagamento> findAll(){
			   return (List<Pagamento>) pagamentoRepository.findAll();
			}
			
			
			@GetMapping(path = {"/{id}"})
			public ResponseEntity<?> findById(@PathVariable long id){
			   return pagamentoRepository.findById(id)
			           .map(record -> ResponseEntity.ok().body(null))
			           .orElse(ResponseEntity.notFound().build());
			}
			
			
			@PostMapping
			public Pagamento create(@RequestBody Pagamento pagamento){
			   return pagamentoRepository.save(pagamento);
			}
			
			
		    @RequestMapping(value = "/treino/{id}", method =  RequestMethod.PUT)
		    public ResponseEntity<Pagamento> Put(@PathVariable(value = "pagm_iden") long id, @Valid @RequestBody Pagamento newPagamento)
		    {
		        Optional<Pagamento> oldPagamento = pagamentoRepository.findById(id);
		        if(oldPagamento.isPresent()){
		        	Pagamento pagamento = oldPagamento.get();
		        	pagamento.setPagm_valor(newPagamento.getPagm_valor());
		        	pagamento.setPagm_data(newPagamento.getPagm_data());
		        	pagamento.setPagm_data_venc(newPagamento.getPagm_data_venc());            
		            pagamentoRepository.save(pagamento);
		            return new ResponseEntity<Pagamento>(pagamento, HttpStatus.OK);
		        }
		        else
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }

		    
		    @DeleteMapping(path ={"/{id}"})
		    public ResponseEntity <?> delete(@PathVariable long id) {
		       return pagamentoRepository.findById(id)
		               .map(record -> {
		            	   pagamentoRepository.deleteById(id);
		                   return ResponseEntity.ok().build();
		               }).orElse(ResponseEntity.notFound().build());
		    }

			
			
/*			
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
			*/
}