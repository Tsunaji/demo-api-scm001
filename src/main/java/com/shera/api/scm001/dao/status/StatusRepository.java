package com.shera.api.scm001.dao.status;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {

    List<Status> findByProcess_ProcessId(String processId);

    List<Status> findByPlant_PlantIdAndProcess_ProcessId(String plantId, String processId);

}
