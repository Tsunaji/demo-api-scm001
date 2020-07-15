package com.shera.api.scm001.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Scm001Util {

    static final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

    public Date timestampAddMinuteCalculator(Date date, int minuteTime) {
        Date afterAddMinute = new Date(date.getTime() + (minuteTime * ONE_MINUTE_IN_MILLIS));
        return afterAddMinute;
    }

    public String referenceIdGenerator(String plant, int count) {
        StringBuilder referenceId = new StringBuilder();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String date = format.format(new Date());

        // ex. MF13-201810230001
        referenceId.append(plant);
        referenceId.append("-");
        referenceId.append(date);
        referenceId.append(String.format("%04d", count));

        return referenceId.toString();
    }

}
