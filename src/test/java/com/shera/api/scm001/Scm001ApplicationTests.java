package com.shera.api.scm001;

import com.shera.api.scm001.dao.plant.Plant;
import com.shera.api.scm001.dao.process.Process;
import com.shera.api.scm001.dao.process.ProcessRepository;
import com.shera.api.scm001.dao.status.Status;
import com.shera.api.scm001.dao.status.StatusRepository;
import com.shera.api.scm001.dao.vehicle.Vehicle;
import com.shera.api.scm001.dao.vehicle.VehicleRepository;
import com.shera.api.scm001.dao.vehicleStatus.VehicleStatus;
import com.shera.api.scm001.dao.vehicleStatus.VehicleStatusRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Scm001ApplicationTests {

    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ProcessRepository processRepository;
    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    @Test
    public void contextLoads() {

//        System.out.println("----------------- TEST -----------------");
//
//        for (Status status : statusRepository.findAll()) {
//            System.out.println("status process name: " + status.getProcess().getName());
//        }
//        System.out.println("----------------- TEST Create Vehicle -----------------");
//        Vehicle vehicle = new Vehicle();
//        vehicle.setLicense("ทด-4321");
//        vehicle.setTransporterName("อิอิ");
//        vehicle.setTransporterCompany("JIJIJIJIJI");
//        vehicle.setProduct("กระเบี้ยง");
//        vehicle.setPlant("MF13");
//        vehicle.setProcess("SA");
//
//        vehicle = vehicleRepository.save(vehicle);
//        System.out.println("vehicle: " + vehicle.toString());
//        System.out.println("----------------- TEST Create VehicleStatus -----------------");
//
//        VehicleStatus vehicleStatus = new VehicleStatus();
//        Status status = new Status();
//        status.setStatusId(4);
//        Process process = new Process();
//        process.setProcessId("SA");
//        process.setName("Sales");
//
//        status.setProcess(process);
//        status.setName("ชั่งออก");
//        status.setDuration(15);
//        status.setSequence(4);
//
//        Plant plant = new Plant();
//        plant.setPlantId("MF13");
//        plant.setName("ลพบุรี");
//
//        status.setPlant(plant);
//
//        vehicleStatus.setStatus(status);
//        vehicleStatus.setVehicleId(vehicle.getVehicleId());
//        vehicleStatus = vehicleStatusRepository.save(vehicleStatus);
//        System.out.println("vehicleStatus: " + vehicleStatus.toString());
//
//        System.out.println("----------------- TEST Update Vehicle -----------------");
//        vehicle.setVehicleStatus(vehicleStatus);
//        vehicle = vehicleRepository.save(vehicle);
//        System.out.println("vehicle: " + vehicle.toString());

    }

}
