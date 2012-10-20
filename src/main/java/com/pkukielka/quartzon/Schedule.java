package com.pkukielka.quartzon;

import com.pkukielka.quartzon.job.JobDetail;
import com.pkukielka.quartzon.trigger.Trigger;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    protected List<JobDetail> jobs;
    protected List<Trigger> triggers;

    public List<JobDetail> getJobs() {
        if (jobs == null) {
            jobs = new ArrayList<JobDetail>();
        }
        return this.jobs;
    }

    public void setJobs(List<JobDetail> jobs) {
        this.jobs = jobs;
    }

    public List<Trigger> getTriggers() {
        if (triggers == null) {
            triggers = new ArrayList<Trigger>();
        }
        return this.triggers;
    }

    public void setTriggers(List<Trigger> triggers) {
        this.triggers = triggers;
    }
}
