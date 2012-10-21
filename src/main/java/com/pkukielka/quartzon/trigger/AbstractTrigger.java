package com.pkukielka.quartzon.trigger;

import com.pkukielka.quartzon.job.Entry;
import org.quartz.DateBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.quartz.DateBuilder.futureDate;
import static org.quartz.TriggerBuilder.newTrigger;

public abstract class AbstractTrigger {
    protected String name;
    protected String group;
    protected String description;
    protected String jobName;
    protected String jobGroup;
    protected Integer priority;
    protected String calendarName;
    protected List<Entry> jobDataMap;
    protected Date startTime;
    protected Integer startTimeSecondsInFuture;
    protected Date endTime;

    protected TriggerBuilder<Trigger> prepareBuilder() {
        TriggerBuilder<Trigger> triggerBuilder = newTrigger()
                .withIdentity(getName(), getGroup())
                .withDescription(getDescription())
                .forJob(getJobName(), getJobGroup())
                .modifiedByCalendar(getCalendarName());

        if (getPriority() != null) {
            triggerBuilder.withPriority(getPriority());
        }

        if (getStartTime() != null) {
            triggerBuilder.startAt(getStartTime());
        } else if (getStartTimeSecondsInFuture() != null) {
            triggerBuilder.startAt(futureDate(getStartTimeSecondsInFuture(), DateBuilder.IntervalUnit.SECOND));
        }

        if (getEndTime() != null) {
            triggerBuilder.endAt(getEndTime());
        }

        for (Entry entry : getJobDataMap()) {
            triggerBuilder.usingJobData(entry.getKey(), entry.getValue());
        }

        return triggerBuilder;
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

    public List<Entry> getJobDataMap() {
        if (jobDataMap == null) {
            jobDataMap = new ArrayList<Entry>();
        }

        return this.jobDataMap;
    }

    public void setJobDataMap(List<Entry> jobDataMap) {
        this.jobDataMap = jobDataMap;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getStartTimeSecondsInFuture() {
        return startTimeSecondsInFuture;
    }

    public void setStartTimeSecondsInFuture(Integer startTimeSecondsInFuture) {
        this.startTimeSecondsInFuture = startTimeSecondsInFuture;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
