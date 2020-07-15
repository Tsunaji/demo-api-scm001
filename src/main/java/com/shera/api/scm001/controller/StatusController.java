package com.shera.api.scm001.controller;

import com.shera.api.scm001.dao.status.Status;
import com.shera.api.scm001.dao.status.StatusRepository;
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
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public @ResponseBody
    List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    @RequestMapping(value = "/status/process/{id}", method = RequestMethod.GET)
    public @ResponseBody
    List<Status> getAllStatusesByProcess(@PathVariable String id) {
        return statusRepository.findByProcess_ProcessId(id);
    }

    @RequestMapping(value = "/status/plant/{plant}/process/{process}", method = RequestMethod.GET)
    public @ResponseBody
    List<Status> getAllStatusesByPlantAndProcess(@PathVariable String plant, @PathVariable String process) {
        return statusRepository.findByPlant_PlantIdAndProcess_ProcessId(plant, process);
    }

    @RequestMapping(value = "/status/plant/{plant}/process/{process}/first", method = RequestMethod.GET)
    public @ResponseBody
    Status getFirstStatusesByPlantAndProcess(@PathVariable String plant, @PathVariable String process) {
        return statusRepository.findFirstByPlant_PlantIdAndProcess_ProcessIdOrderBySequenceAsc(plant, process);
    }

    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public @ResponseBody
    String createStatus(@RequestBody Status statusBody) {
        statusRepository.save(statusBody);
        return "Created";
    }

    @RequestMapping(value = "/status/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String updateStatus(@RequestBody Status statusBody, @PathVariable int id) {
        statusRepository.save(statusBody);
        return "Updated";
    }

    @RequestMapping(value = "/status/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deleteStatus(@PathVariable int id) {
        statusRepository.deleteById(id);
        return "Deleted";
    }
}
