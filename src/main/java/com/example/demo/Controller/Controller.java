package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Plot;
import com.example.demo.Services.Services;

@RestController
public class Controller {

	private Services services;

	public Controller(Services services) {
		this.services = services;
	}

	@GetMapping("/")
	public String mainPage () {
		return "Welcome to Irrigation System";
	}
	@PostMapping("/AddPlot")
	public ResponseEntity<Plot> AddPlot(@RequestBody Plot plot) {
		services.AddPlot(plot);
		return new ResponseEntity<>(plot, HttpStatus.OK);
	}

	@GetMapping("/Plots")
	public ResponseEntity<Iterable<Plot>> Plots() {

		return new ResponseEntity<>(services.Plots(), HttpStatus.OK);
	}

	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<String> DeletePlots(int id) {

		return new ResponseEntity<>(services.DeletePlots(id), HttpStatus.OK);
	}

	@GetMapping("/Plot/{id}")
	public ResponseEntity<Plot> FindPlot(@PathVariable int  id) {

		return new ResponseEntity<>(services.findPlot(id), HttpStatus.OK);
	}
	@PostMapping("/EditPlot")
	public ResponseEntity<Plot> EditPlot(@RequestBody Plot plot) {
		
		return new ResponseEntity<>(services.EditPlot(plot), HttpStatus.OK);
	}
}
