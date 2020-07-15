package com.shera.api.scm001.dao.vehicle;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>, JpaSpecificationExecutor<Vehicle> {

    //--------------------------------------------Current date & status not completed---------------------------------------------------//
    List<Vehicle> findByPublicationDateAndPlantAndCompletedFalse(Date publicationDate, String Plant);

    //Queuing all
    List<Vehicle> findByPublicationDateAndProcessAndPlantAndCompletedFalse(Date publicationDate, String Process, String Plant);

    //Queuing by status
    List<Vehicle> findByPublicationDateAndProcessAndPlantAndVehicleStatus_Status_StatusIdAndCompletedFalse(Date publicationDate, String process, String plant, int statusId);

    //--------------------------------------------Current date & status not completed---------------------------------------------------//
    List<Vehicle> findByProcessAndPlantAndVehicleStatus_Status_StatusId(String process, String plant, int statusId);

    List<Vehicle> findByProcessAndPlant(String process, String plant);

    List<Vehicle> findByPlant(String plant);

    int countByCreatedDate(Date createdDate);

    int countByPublicationDateAndPlant(Date publicationDate, String Plant);
}
