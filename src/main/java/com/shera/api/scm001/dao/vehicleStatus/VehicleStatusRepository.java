package com.shera.api.scm001.dao.vehicleStatus;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Integer> {

    List<VehicleStatus> findByVehicleId(int vehicleId);
}
