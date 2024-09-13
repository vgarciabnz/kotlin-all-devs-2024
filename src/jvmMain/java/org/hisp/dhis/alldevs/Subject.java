package org.hisp.dhis.alldevs;

import java.util.List;

public record Subject(
        String name,
        List<Integer> values
) {
}
