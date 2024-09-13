package org.hisp.dhis.alldevs;

public record Event(
        String uid,
        Integer[] values
) {

    public Integer maxValue() {
        Integer maxValue = null;
        for (Integer value : values) {
            if (maxValue == null || value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
