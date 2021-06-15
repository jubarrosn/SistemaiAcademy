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

import br.com.iacademy.model.Cargo;
import br.com.iacademy.repository.CargoRepository;

@Controller
@RequestMapping({"/cargo"})
public class CargoController {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@GetMapping
	public List<Cargo> findAll(){
	   return (List<Cargo>) cargoRepository.findAll();
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable long id){
	   return cargoRepository.findById(id)
	           .map(record -> ResponseEntity.ok().body(null))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public Cargo create(@RequestBody Cargo cargo){
	   return cargoRepository.save(cargo);
	}
	
	
    @RequestMapping(value = "/cargo/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Cargo> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Cargo newCargo)
    {
        Optional<Cargo> oldCargo = cargoRepository.findById(id);
        if(oldCargo.isPresent()){
        	Cargo cargo = oldCargo.get();
        	cargo.setCrg_nome(newCargo.getCrg_nome());
        	cargo.setCrg_funcao(newCargo.getCrg_funcao());
        	cargo.setCrg_salario(newCargo.getCrg_salario());            
            cargoRepository.save(cargo);
            return new ResponseEntity<Cargo>(cargo, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
       return cargoRepository.findById(id)
               .map(record -> {
            	   cargoRepository.deleteById(id);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }
    
	
	
	
	/*@GetMapping("/cargoAll")
	public List<Cargo> listacargo(){
		return cargoRepository.findAll();
	}
		
	@GetMapping("/cargoId/{id}")
	public Optional<Cargo> listaCargoId(@PathVariable(value = "id") long id) {
		return cargoRepository.findById(id);
	}
	
	@PostMapping("/cargoSave")
	public Cargo salvaCargo(@RequestBody Cargo cargo) {
		return cargoRepository.save(cargo);
	}
	
	@DeleteMapping("/cargoDelete")
	public void deleteCargo(@RequestBody Cargo cargo) {
		cargoRepository.delete(cargo);
	}
	
	@PutMapping("/cargoUpdate")
	public Cargo updateCargo(@RequestBody Cargo cargo) {
		return cargoRepository.save(cargo);
	}*/
}