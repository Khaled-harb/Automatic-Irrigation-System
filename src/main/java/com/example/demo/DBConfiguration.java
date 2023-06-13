package com.example.demo;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.Plot;
import com.example.demo.Services.Services;

@Component

public class DBConfiguration implements CommandLineRunner {
	@Autowired
	private Services services;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		if (services.Plots().isEmpty()) {
			HashSet<String> hash1 = new HashSet<>();
			HashSet<String> hash2 = new HashSet<>();
			HashSet<String> hash3 = new HashSet<>();
			HashSet<String> hash4 = new HashSet<>();

			hash1.add("01:13");
			hash1.add("02:00");
			hash2.add("04:49");
			hash3.add("04:48");
			hash3.add("04:35");
			hash4.add("20:21");

			services.AddPlot(new Plot(1, "corn", false, 3.0, true, (float) 2300.33, 0, hash1));
			services.AddPlot(new Plot(2, "Chia seeds", false, 4.0, true, (float) 1200.33, 0, hash2));
			services.AddPlot(new Plot(3, "Ajwain", false, 2.7, false, (float) 200.98, 0, hash3));
			services.AddPlot(new Plot(4, "Caraway", false, 5.8, true, (float) 334.14, 0, hash4));

		}

	}

}
