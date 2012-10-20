package com.pkukielka.quartzon.trigger;

public class Trigger {
    protected SimpleTrigger simple;
    protected CronTrigger cron;
    protected CalendarIntervalTrigger calendarInterval;

    public SimpleTrigger getSimple() {
        return simple;
    }

    public void setSimple(SimpleTrigger simple) {
        this.simple = simple;
    }

    public CronTrigger getCron() {
        return cron;
    }

    public void setCron(CronTrigger cron) {
        this.cron = cron;
    }

    public CalendarIntervalTrigger getCalendarInterval() {
        return calendarInterval;
    }

    public void setCalendarInterval(CalendarIntervalTrigger calendarInterval) {
        this.calendarInterval = calendarInterval;
    }
}
