package com.shera.api.scm001.controller;

import com.shera.api.scm001.dao.vehicleType.VehicleType;
import com.shera.api.scm001.dao.vehicleType.VehicleTypeRepository;
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
public class VehicleTypeController {

    @Autowired
    private VehicleTypeRepository vehicleTypeTypeRepository;

    @RequestMapping(value = "/vehicleType", method = RequestMethod.GET)
    public @ResponseBody
    List<VehicleType> getAllVehicleTypes() {
        return vehicleTypeTypeRepository.findAllByOrderByNameAsc();
    }

    @RequestMapping(value = "/vehicleType", method = RequestMethod.POST)
    public @ResponseBody
    String createVehicleType(@RequestBody VehicleType vehicleTypeBody) {
        vehicleTypeTypeRepository.save(vehicleTypeBody);
        return "Created";
    }

    @RequestMapping(value = "/vehicleType/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String updateVehicleType(@RequestBody VehicleType vehicleTypeBody, @PathVariable int id) {
        vehicleTypeTypeRepository.save(vehicleTypeBody);
        return "Updated";
    }

    @RequestMapping(value = "/vehicleType/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deleteVehicleType(@PathVariable int id) {
        vehicleTypeTypeRepository.deleteById(id);
        return "Deleted";
    }
}
