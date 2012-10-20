package com.pkukielka.quartzon;

import java.util.ArrayList;
import java.util.List;

public class JobScheduling {
    ProcessingDirectives processingDirectives;
    List<Schedule> schedules;

    public List<Schedule> getSchedules() {
        if (schedules == null) {
            schedules = new ArrayList<Schedule>();
        }
        return this.schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
