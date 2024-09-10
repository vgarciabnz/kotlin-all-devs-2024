package org.hisp.dhis.alldevs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventServiceTest {

    private final EventService service = new EventService();

    @Test
    public void testGetEventWithBiggestValue() {
        List<Event> events = List.of(
                new Event("uid1", new Integer[]{1, 3}),
                new Event("uid2", new Integer[]{12, 34}),
                new Event("uid3", new Integer[]{12, 21})
        );

        String eventUid = service.getEventWithBiggestValue(events);

        assertEquals(eventUid, "uid2");
    }
}
