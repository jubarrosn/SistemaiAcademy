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

import br.com.iacademy.model.Cargo;
import br.com.iacademy.repository.CargoRepository;

@Controller
public class CargoController {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@GetMapping("/cargoAll")
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
	}
}