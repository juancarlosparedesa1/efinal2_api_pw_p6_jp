package com.example.demo.controller;

//importaciones estaticas
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.IVehiculoService;
import com.example.demo.service.to.VehiculoTO;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin
public class VehiculoController {

	@Autowired
	private IVehiculoService vehiculoService;

	// URL: http://localhost:8080/API/v1.0/Consesionario/vehiculos
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void ingresarVehiculo(@RequestBody VehiculoTO vehiculoTo) {
		this.vehiculoService.ingresar(vehiculoTo);
		// return
		// ResponseEntity.status(HttpStatus.OK).body(this.vehiculoService.ingresar(vehiculoTo));
	}

	// GET
	// URL:http://localhost:8080/API/v1.0/Consesionario/vehiculos
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoTO>> consultarTodos() {
		List<VehiculoTO> lista = this.vehiculoService.buscarTodos();

		for (VehiculoTO v : lista) {
			Link myLink = linkTo(methodOn(VehiculoController.class).buscarPorPlaca(v.getPlaca())).withSelfRel();
			v.add(myLink);

		}

		return new ResponseEntity<List<VehiculoTO>>(lista, null, HttpStatus.OK);
	}

	// URL:http://localhost:8080/API/v1.0/Consesionario/vehiculos/placa01
	@GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vehiculo> buscarPorPlaca(@PathVariable String placa) {
		return ResponseEntity.status(HttpStatus.OK).body(this.vehiculoService.buscarPorPlaca(placa));
	}

}
