package com.shera.api.scm001.controller;

import com.shera.api.scm001.dao.vehicle.Vehicle;
import com.shera.api.scm001.dao.vehicle.VehicleRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scm001")
public class VehicleController {

    public static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    private VehicleRepository vehicleRepository;

    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public @ResponseBody
    List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @RequestMapping(value = "/vehicle/plant/{plant}", method = RequestMethod.GET)
    public @ResponseBody
    List<Vehicle> getAllVehiclesByPlant(@PathVariable String plant) {
        return vehicleRepository.findByPlant(plant);
    }

    @RequestMapping(value = "/vehicle/process/{process}/plant/{plant}/status", method = RequestMethod.GET)
    public @ResponseBody
    List<Vehicle> getAllVehiclesByProcessAndPlant(@PathVariable String process, @PathVariable String plant) {
        return vehicleRepository.findByProcessAndPlant(process, plant);
    }

    @RequestMapping(value = "/vehicle/process/{process}/plant/{plant}/status/{status}", method = RequestMethod.GET)
    public @ResponseBody
    List<Vehicle> getAllVehiclesByProcessAndPlantAndStatus(@PathVariable String process, @PathVariable String plant, @PathVariable int status) {
        return vehicleRepository.findByProcessAndPlantAndVehicleStatus_Status_StatusId(process, plant, status);
    }

    @RequestMapping(value = "/vehicle", method = RequestMethod.POST)
    public @ResponseBody
    String createVehicle(@RequestBody Vehicle vehicleBody) {
        vehicleRepository.save(vehicleBody);
        return "Created";
    }

    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String updateVehicle(@RequestBody Vehicle vehicleBody, @PathVariable int id) {
        vehicleRepository.save(vehicleBody);
        return "Updated";
    }

    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deleteVehicle(@PathVariable int id) {
        vehicleRepository.deleteById(id);
        return "Deleted";
    }

    //    @RequestMapping(value = "/vehicle/date", method = RequestMethod.GET)
//    public @ResponseBody
//    Iterable<Vehicle> getAllByDate() throws ParseException {
//        Date date = new Date();
////        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println("DATE: " + new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-28"));
//        return vehicleRepository.findByCreatedDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-28"));
//    }
//    @RequestMapping(method = RequestMethod.GET, value = "/vehicle")
//    @ResponseBody
//    public Iterable<Vehicle> findAllBySpecification(@RequestParam(value = "search") String search) {
//        VehicleSpecificationBuilder builder = new VehicleSpecificationBuilder();
//        String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
//        Pattern pattern = Pattern.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),", Pattern.UNICODE_CHARACTER_CLASS);
//        Matcher matcher = pattern.matcher(search + ",");
//        while (matcher.find()) {
//            builder.with(
//                    matcher.group(1),
//                    matcher.group(2),
//                    matcher.group(4),
//                    matcher.group(3),
//                    matcher.group(5));
//        }
//
//        Specification<Vehicle> spec = builder.build();
//        return vehicleRepository.findAll(spec);
//    }
}
