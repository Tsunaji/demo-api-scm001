package com.shera.api.scm001.controller;

import com.shera.api.scm001.dao.status.Status;
import com.shera.api.scm001.dao.status.StatusRepository;
import com.shera.api.scm001.dao.vehicle.Vehicle;
import com.shera.api.scm001.dao.vehicle.VehicleRepository;
import com.shera.api.scm001.dao.vehicleStatus.VehicleStatus;
import com.shera.api.scm001.dao.vehicleStatus.VehicleStatusRepository;
import com.shera.api.scm001.util.Scm001Util;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
    public Scm001Util scm001Util = new Scm001Util();

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;
    @Autowired
    private StatusRepository statusRepository;

    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public @ResponseBody
    List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Vehicle> getVehicleById(@PathVariable int id) {
        return vehicleRepository.findById(id);
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

    //--------------------------------------------Current date & status not completed---------------------------------------------------//
    //weight view all current date
    @RequestMapping(value = "/vehicle/plant/{plant}/toDay/notCompleted", method = RequestMethod.GET)
    public @ResponseBody
    List<Vehicle> findByPublicationDateAndPlantAndCompletedFalse(@PathVariable String plant) {
        return vehicleRepository.findByPublicationDateAndPlantAndCompletedFalse(new Date(), plant);
    }

    //queuing view all current date
    @RequestMapping(value = "/vehicle/process/{process}/plant/{plant}/status/toDay/notCompleted", method = RequestMethod.GET)
    public @ResponseBody
    List<Vehicle> findByPublicationDateAndProcessAndPlantAndCompletedFalse(@PathVariable String process, @PathVariable String plant) {
        return vehicleRepository.findByPublicationDateAndProcessAndPlantAndCompletedFalse(new Date(), process, plant);
    }

    //queuing view by status current date
    @RequestMapping(value = "/vehicle/process/{process}/plant/{plant}/status/{status}/toDay/notCompleted", method = RequestMethod.GET)
    public @ResponseBody
    List<Vehicle> findByPublicationDateAndProcessAndPlantAndVehicleStatus_Status_StatusIdAndCompletedFalse(@PathVariable String process, @PathVariable String plant, @PathVariable int status) {
        return vehicleRepository.findByPublicationDateAndProcessAndPlantAndVehicleStatus_Status_StatusIdAndCompletedFalse(new Date(), process, plant, status);
    }

    //--------------------------------------------Current date & status not completed---------------------------------------------------//
    @RequestMapping(value = "/vehicle", method = RequestMethod.POST)
    public @ResponseBody
    String createVehicle(@RequestBody Vehicle vehicleBody) {

        //first save to gen id and timestamp
        Vehicle vehicle = vehicleRepository.save(vehicleBody);

        //get first status of plant & process
        Status status = statusRepository.findFirstByPlant_PlantIdAndProcess_ProcessIdOrderBySequenceAsc(vehicle.getPlant(), vehicle.getProcess());

        //update status history
        VehicleStatus vehicleStatus = new VehicleStatus();
        vehicleStatus.setVehicleId(vehicle.getVehicleId());
        vehicleStatus.setStatus(status);
        vehicleStatus = vehicleStatusRepository.save(vehicleStatus);
        //calculate estimate time
        vehicleStatus.setEstimateTime(scm001Util.timestampAddMinuteCalculator(vehicleStatus.getCreatedDate(), vehicleStatus.getStatus().getDuration()));

        //set current status
        vehicle.setVehicleStatus(vehicleStatus);

        //gen reference id
        vehicle.setReferenceId(scm001Util.referenceIdGenerator(vehicle.getPlant(), vehicleRepository.countByPublicationDateAndPlant(new Date(), vehicle.getPlant())));
        vehicleRepository.save(vehicle);

        return "Created";
    }

    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    String updateVehicle(@RequestBody Vehicle vehicle, @PathVariable int id) {
        List<Status> statuses = statusRepository.findByPlant_PlantIdAndProcess_ProcessId(vehicle.getPlant(), vehicle.getProcess());
        Status status = new Status();

        //check have next status ?
        if (vehicle.getVehicleStatus().getStatus().getSequence() < statuses.get(statuses.size() - 1).getSequence()) {
            for (int i = 0; i < statuses.size(); i++) {
                //check match sequence status
                if (statuses.get(i).getSequence() == vehicle.getVehicleStatus().getStatus().getSequence() + 1) {
                    status = statuses.get(i);
                    break;
                }
            }
        }

        //update status history
        VehicleStatus vehicleStatus = new VehicleStatus();
        vehicleStatus.setVehicleId(vehicle.getVehicleId());
        vehicleStatus.setStatus(status);
        vehicleStatus = vehicleStatusRepository.save(vehicleStatus);

        //check last status not estimate time
        if (status.getDuration() > 0) {
            //calculate estimate time
            vehicleStatus.setEstimateTime(scm001Util.timestampAddMinuteCalculator(vehicleStatus.getCreatedDate(), vehicleStatus.getStatus().getDuration()));
        }

        //set current status
        vehicle.setVehicleStatus(vehicleStatus);
        vehicleRepository.save(vehicle);

        return "Updated";
    }

    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deleteVehicle(@PathVariable int id) {
        vehicleRepository.deleteById(id);
        return "Deleted";
    }
}
