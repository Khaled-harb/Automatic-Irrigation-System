package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Plot;
import com.example.demo.Reposetory.PlotRepo;

@Service
public class Services {

	@Autowired
	private PlotRepo plotRepo;

	
	public Services(PlotRepo plotRepo) {
		this.plotRepo = plotRepo;
	}

	public Plot AddPlot(Plot plot) {
		plotRepo.save(plot);
		return plot;
	}

	public List<Plot> Plots() {

		return (List<Plot>) plotRepo.findAll();
	}

	public String DeletePlots(int id) {
		plotRepo.deleteById(id);
		return "Deleted";
	}

	public Plot EditPlot(Plot plot) {
		Plot oldPlot = plotRepo.findById(plot.getId()).get();
		oldPlot.setLitersOfWater(plot.getLitersOfWater());
		oldPlot.setCrop(plot.getCrop());
		oldPlot.setAlert(plot.getAlert());
		oldPlot.setSensor(plot.isSensor());
		oldPlot.setSizeOfArea(plot.getSizeOfArea());
		oldPlot.setNumOfIrrigations(plot.getNumOfIrrigations());
		plotRepo.save(oldPlot);

		return oldPlot;
	}
	public Plot EditNumOfIrrgations(Plot plot) {
		Plot oldPlot = plotRepo.findById(plot.getId()).get();
		
		oldPlot.setNumOfIrrigations(plot.getNumOfIrrigations());
		plotRepo.save(oldPlot);

		return oldPlot;
	}
	public Plot findByCrop(String cropName) {
		return plotRepo.findByCrop(cropName);
	}

	public Plot findPlot(int id) {
		return plotRepo.findById(id).get();

	}
}
