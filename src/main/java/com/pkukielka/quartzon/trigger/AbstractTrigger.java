package com.pkukielka.quartzon.trigger;

import com.pkukielka.quartzon.job.JobDataMap;

import javax.xml.datatype.XMLGregorianCalendar;

public abstract class AbstractTrigger {
    protected String name;
    protected String group;
    protected String description;
    protected String jobName;
    protected String jobGroup;
    protected Integer priority;
    protected String calendarName;
    protected JobDataMap jobDataMap;
    protected XMLGregorianCalendar startTime;
    protected Integer startTimeSecondsInFuture;
    protected XMLGregorianCalendar endTime;

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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public JobDataMap getJobDataMap() {
        return jobDataMap;
    }

    public void setJobDataMap(JobDataMap jobDataMap) {
        this.jobDataMap = jobDataMap;
    }

    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    public void setStartTime(XMLGregorianCalendar startTime) {
        this.startTime = startTime;
    }

    public Integer getStartTimeSecondsInFuture() {
        return startTimeSecondsInFuture;
    }

    public void setStartTimeSecondsInFuture(Integer startTimeSecondsInFuture) {
        this.startTimeSecondsInFuture = startTimeSecondsInFuture;
    }

    public XMLGregorianCalendar getEndTime() {
        return endTime;
    }

    public void setEndTime(XMLGregorianCalendar endTime) {
        this.endTime = endTime;
    }
}
