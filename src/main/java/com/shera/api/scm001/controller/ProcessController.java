package com.shera.api.scm001.controller;

import com.shera.api.scm001.dao.process.ProcessRepository;
import com.shera.api.scm001.dao.process.Process;
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
public class ProcessController {

    @Autowired
    private ProcessRepository processRepository;

    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public @ResponseBody
    List<Process> getAllProcesses() {
        return processRepository.findAll();
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public @ResponseBody
    String createProcess(@RequestBody Process processBody) {
        processRepository.save(processBody);
        return "Created";
    }

    @RequestMapping(value = "/process/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String updateProcess(@RequestBody Process processBody, @PathVariable int id) {
        processRepository.save(processBody);
        return "Updated";
    }

    @RequestMapping(value = "/process/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deleteProcess(@PathVariable int id) {
        processRepository.deleteById(id);
        return "Deleted";
    }

}
