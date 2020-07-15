package com.shera.api.scm001;

import com.shera.api.scm001.dao.process.ProcessRepository;
import com.shera.api.scm001.dao.status.StatusRepository;
import com.shera.api.scm001.dao.vehicle.VehicleRepository;
import com.shera.api.scm001.dao.vehicleStatus.VehicleStatusRepository;
import com.shera.api.scm001.util.Scm001Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public void contextLoads() throws ParseException {

//        System.out.println("----------------- TEST -----------------");
//
//        Scm001Util scm001Util = new Scm001Util();
//
//        String referenceId = "MF13";
//
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//        String date = format.format(new Date());
//
//        referenceId += "-" + date + String.format("%06d", 12);
//
//        System.out.println("referenceId: " + referenceId);
//
//        Date date2 = new Date();
//        String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date2);
        System.out.println("Count: " + vehicleRepository.countByCreatedDate(new Date()));
    }

}
