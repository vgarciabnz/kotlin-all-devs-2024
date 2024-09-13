package org.hisp.dhis.alldevs;

import java.util.Date;
import java.util.List;

public record Class(
        List<Student> students,
        Date startDate,
        Date endDate
) {}
