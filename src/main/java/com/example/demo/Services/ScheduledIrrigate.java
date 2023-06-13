package com.example.demo.Services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.Plot;
import com.example.demo.Reposetory.PlotRepo;

import ch.qos.logback.classic.Logger;

@Component
public class ScheduledIrrigate {
	@Autowired
	PlotRepo plotRepo;

	private static final Logger log = (Logger) LoggerFactory.getLogger(ScheduledIrrigate.class);
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

	@Scheduled(fixedRate = 60000)
	public void IrrigationCheck() throws InterruptedException {
		List<Plot> numOfPlots = (List<Plot>) plotRepo.findAll();

		if (numOfPlots.size() != 0) {
			for (int i = 0; i < numOfPlots.size(); i++) {
				String date = dateFormat.format(new Date());

				if (numOfPlots.get(i).getTimeToBeIrrigate().contains(date) && numOfPlots.get(i).isSensor() == true) {
					Plot oldPlot = numOfPlots.get(i);
					oldPlot.setNumOfIrrigations(oldPlot.getNumOfIrrigations() + 1);
					plotRepo.save(oldPlot);
					log.info("The irrigation system is checked {}");

				} else if (numOfPlots.get(i).getTimeToBeIrrigate().contains(date) && numOfPlots.get(i).isSensor() != true) {

					for (int j = 1; j < 4; j++) {
						if (numOfPlots.get(i).getTimeToBeIrrigate().contains(date)
								&& numOfPlots.get(i).isSensor() == true) {
							Plot oldPlot = plotRepo.findById(i).get();
							oldPlot.setNumOfIrrigations(oldPlot.getNumOfIrrigations() + 1);
							plotRepo.save(oldPlot);
							log.info("The irrigation system is checked {}");
						} else {
							Plot oldPlot = numOfPlots.get(i);
							oldPlot.setAlert(true);
							plotRepo.save(oldPlot);
							log.info("The irrigation system is checked and sesnor down ! {}");

						}
					}
				}
			}
		}
	}

}
