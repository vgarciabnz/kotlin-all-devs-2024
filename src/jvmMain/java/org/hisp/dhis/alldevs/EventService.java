package org.hisp.dhis.alldevs;

import java.util.List;

public class EventService {

    public String getEventWithBiggestValue(List<Event> events) {
        String eventUid = null;
        Integer maxValue = null;

        for (Event event : events) {
            Integer maxEventValue = event.maxValue();
            if (maxValue == null || (maxEventValue != null && maxEventValue > maxValue)) {
                maxValue = maxEventValue;
                eventUid = event.uid();
            }
        }

        return eventUid;
    }
}
