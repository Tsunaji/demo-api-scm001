package com.shera.api.scm001.controller;

import com.shera.api.scm001.dao.plant.PlantRepository;
import com.shera.api.scm001.dao.plant.Plant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scm001")
public class PlantController {

    @Autowired
    private PlantRepository plantRepository;

    @RequestMapping(value = "/plant", method = RequestMethod.GET)
    public @ResponseBody
    List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @RequestMapping(value = "/plant", method = RequestMethod.POST)
    public @ResponseBody
    String createPlant(@RequestBody Plant plantBody) {
        plantRepository.save(plantBody);
        return "Created";
    }

    @RequestMapping(value = "/plant/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String updatePlant(@RequestBody Plant plantBody, @PathVariable int id) {
        plantRepository.save(plantBody);
        return "Updated";
    }

    @RequestMapping(value = "/plant/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deletePlant(@PathVariable int id) {
        plantRepository.deleteById(id);
        return "Deleted";
    }

}
