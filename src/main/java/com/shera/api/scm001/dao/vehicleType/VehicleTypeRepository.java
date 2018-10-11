package com.shera.api.scm001.dao.vehicleType;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {

    List<VehicleType> findAllByOrderByNameAsc();
}
