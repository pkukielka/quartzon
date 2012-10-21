package com.pkukielka.quartzon.trigger;

import org.quartz.Trigger;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class SimpleTrigger
        extends AbstractTrigger {
    protected String misfireInstruction;
    protected Integer repeatCount;
    protected Integer repeatInterval;

    public Trigger build() {
        return prepareBuilder()
                .withSchedule(
                        simpleSchedule()
                                .withIntervalInSeconds(getRepeatInterval())
                                .withRepeatCount(getRepeatCount())
                ).build();
    }

    public String getMisfireInstruction() {
        return misfireInstruction;
    }

    public void setMisfireInstruction(String misfireInstruction) {
        this.misfireInstruction = misfireInstruction;
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Integer getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(Integer repeatInterval) {
        this.repeatInterval = repeatInterval;
    }
}
