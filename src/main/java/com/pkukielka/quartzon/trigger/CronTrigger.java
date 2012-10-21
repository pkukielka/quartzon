package com.pkukielka.quartzon.trigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;

import java.util.TimeZone;

import static org.quartz.CronScheduleBuilder.cronSchedule;

public class CronTrigger
        extends AbstractTrigger {
    protected String misfireInstruction;
    protected String cronExpression;
    protected String timeZone;

    public Trigger build() {
        CronScheduleBuilder cronScheduleBuilder = cronSchedule(getCronExpression());

        if (getTimeZone() != null) {
            cronScheduleBuilder.inTimeZone(TimeZone.getTimeZone(getTimeZone()));
        }

        return prepareBuilder().withSchedule(cronScheduleBuilder).build();
    }

    public String getMisfireInstruction() {
        return misfireInstruction;
    }

    public void setMisfireInstruction(String misfireInstruction) {
        this.misfireInstruction = misfireInstruction;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
