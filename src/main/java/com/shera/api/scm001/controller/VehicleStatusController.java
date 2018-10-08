package com.shera.api.scm001.controller;

import com.shera.api.scm001.dao.vehicleStatus.VehicleStatus;
import com.shera.api.scm001.dao.vehicleStatus.VehicleStatusRepository;
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
public class VehicleStatusController {

    @Autowired
    VehicleStatusRepository vehicleStatusRepository;

    @RequestMapping(value = "/vehicleStatus", method = RequestMethod.GET)
    public @ResponseBody
    List<VehicleStatus> getAllVehicleStatuses() {
        return vehicleStatusRepository.findAll();
    }

    @RequestMapping(value = "/vehicleStatus/vehicleId/{vehicleId}", method = RequestMethod.GET)
    public @ResponseBody
    List<VehicleStatus> getAllVehicleStatusesByVehicleId(@PathVariable int vehicleId) {
        return vehicleStatusRepository.findByVehicleId(vehicleId);
    }

    @RequestMapping(value = "/vehicleStatus", method = RequestMethod.POST)
    public @ResponseBody
    String createVehicleStatus(@RequestBody VehicleStatus vehicleStatusBody) {
        vehicleStatusRepository.save(vehicleStatusBody);
        return "Created";
    }

    @RequestMapping(value = "/vehicleStatus/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String updateVehicleStatus(@RequestBody VehicleStatus vehicleStatusBody, @PathVariable int id) {
        vehicleStatusRepository.save(vehicleStatusBody);
        return "Updated";
    }

    @RequestMapping(value = "/vehicleStatus/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deleteVehicleStatus(@PathVariable int id) {
        vehicleStatusRepository.deleteById(id);
        return "Deleted";
    }

}
