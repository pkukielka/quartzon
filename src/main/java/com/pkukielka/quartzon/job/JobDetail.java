package com.pkukielka.quartzon.job;

import org.quartz.Job;
import org.quartz.JobBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.quartz.JobBuilder.newJob;

public class JobDetail {
    protected String name;
    protected String group;
    protected String description;
    protected String jobClass;
    protected Boolean durability;
    protected Boolean recover;
    protected List<Entry> jobDataMap;

    public org.quartz.JobDetail build() throws ClassNotFoundException {
        @SuppressWarnings("unchecked")
        JobBuilder jobBuilder = newJob((Class<? extends Job>) Class.forName(getJobClass()))
                .withIdentity(getName(), getGroup())
                .withDescription(getDescription());

        if (getDurability() != null) {
            jobBuilder.storeDurably(getDurability());
        }

        if (getRecover() != null) {
            jobBuilder.requestRecovery(getRecover());
        }

        for (Entry entry : getJobDataMap()) {
            jobBuilder.usingJobData(entry.getKey(), entry.getValue());
        }

        return jobBuilder.build();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public Boolean getDurability() {
        return durability;
    }

    public void setDurability(Boolean durability) {
        this.durability = durability;
    }

    public Boolean getRecover() {
        return recover;
    }

    public void setRecover(Boolean recover) {
        this.recover = recover;
    }

    public List<Entry> getJobDataMap() {
        if (jobDataMap == null) {
            jobDataMap = new ArrayList<Entry>();
        }

        return this.jobDataMap;
    }

    public void setJobDataMap(List<Entry> jobDataMap) {
        this.jobDataMap = jobDataMap;
    }
}
