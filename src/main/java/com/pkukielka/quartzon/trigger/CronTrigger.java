package com.pkukielka.quartzon.trigger;

public class CronTrigger
        extends AbstractTrigger {
    protected String misfireInstruction;
    protected String cronExpression;
    protected String timeZone;

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
