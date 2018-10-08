package com.shera.api.scm001.dao.vehicle;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>, JpaSpecificationExecutor<Vehicle> {

    List<Vehicle> findByCreatedDate(Date date);

    List<Vehicle> findByProcessAndPlantAndVehicleStatus_Status_StatusId(String process, String plant, int statusId);

    List<Vehicle> findByProcessAndPlant(String process, String plant);

//    List<Vehicle> findByVehicleStatus_Status_StatusId(int statusId);
}
