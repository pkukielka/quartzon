package com.pkukielka.quartzon.trigger;

public class CalendarIntervalTrigger
        extends AbstractTrigger {
    protected String misfireInstruction;
    protected Integer repeatInterval;
    protected String repeatIntervalUnit;

    public String getMisfireInstruction() {
        return misfireInstruction;
    }

    public void setMisfireInstruction(String misfireInstruction) {
        this.misfireInstruction = misfireInstruction;
    }

    public Integer getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(Integer repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public String getRepeatIntervalUnit() {
        return repeatIntervalUnit;
    }

    public void setRepeatIntervalUnit(String repeatIntervalUnit) {
        this.repeatIntervalUnit = repeatIntervalUnit;
    }
}
