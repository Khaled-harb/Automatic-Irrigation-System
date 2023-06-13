package com.example.demo.Reposetory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Plot;

@Repository
public interface PlotRepo extends CrudRepository<Plot, Integer> {

	Plot findByCrop (String cropName);
}
