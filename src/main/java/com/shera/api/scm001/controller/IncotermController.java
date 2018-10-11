package com.shera.api.scm001.controller;

import com.shera.api.scm001.dao.incoterm.Incoterm;
import com.shera.api.scm001.dao.incoterm.IncotermRepository;
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
public class IncotermController {

    @Autowired
    private IncotermRepository incotermRepository;

    @RequestMapping(value = "/incoterm", method = RequestMethod.GET)
    public @ResponseBody
    List<Incoterm> getAllIncoterms() {
        return incotermRepository.findAllByOrderByNameAsc();
    }

    @RequestMapping(value = "/incoterm", method = RequestMethod.POST)
    public @ResponseBody
    String createIncoterm(@RequestBody Incoterm incotermBody) {
        incotermRepository.save(incotermBody);
        return "Created";
    }

    @RequestMapping(value = "/incoterm/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String updateIncoterm(@RequestBody Incoterm incotermBody, @PathVariable int id) {
        incotermRepository.save(incotermBody);
        return "Updated";
    }

    @RequestMapping(value = "/incoterm/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deleteIncoterm(@PathVariable int id) {
        incotermRepository.deleteById(id);
        return "Deleted";
    }
}
