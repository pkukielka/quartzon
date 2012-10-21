package com.pkukielka.quartzon;

import com.pkukielka.quartzon.job.JobDetail;
import com.pkukielka.quartzon.trigger.CronTrigger;
import com.pkukielka.quartzon.trigger.SimpleTrigger;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    protected ProcessingDirectives processingDirectives;
    protected List<JobDetail> jobs;
    protected List<SimpleTrigger> simpleTriggers;
    protected List<CronTrigger> cronTriggers;

    private boolean shouldOverwriteExistingData() {
        if (processingDirectives != null && processingDirectives.getOverwriteExistingData() != null) {
            return processingDirectives.getOverwriteExistingData();
        }

        return false;
    }

    public org.quartz.Scheduler build(SchedulerFactory schedulerFactory) throws SchedulerException, ClassNotFoundException, MalformedURLException {
        org.quartz.Scheduler scheduler = schedulerFactory.getScheduler();

        for (JobDetail job : getJobs()) {
            scheduler.addJob(job.build(), shouldOverwriteExistingData());
        }

        for (SimpleTrigger simpleTrigger : getSimpleTriggers()) {
            scheduler.scheduleJob(simpleTrigger.build());
        }

        for (CronTrigger cronTrigger : getCronTriggers()) {
            scheduler.scheduleJob(cronTrigger.build());
        }

        return scheduler;
    }

    public ProcessingDirectives getProcessingDirectives() {
        return processingDirectives;
    }

    public List<SimpleTrigger> getSimpleTriggers() {
        if (simpleTriggers == null) {
            simpleTriggers = new ArrayList<SimpleTrigger>();
        }
        return this.simpleTriggers;
    }

    public void setSimpleTriggers(List<SimpleTrigger> simpleTriggers) {
        this.simpleTriggers = simpleTriggers;
    }

    public List<CronTrigger> getCronTriggers() {
        if (cronTriggers == null) {
            cronTriggers = new ArrayList<CronTrigger>();
        }
        return this.cronTriggers;
    }

    public void setCronTriggers(List<CronTrigger> cronTriggers) {
        this.cronTriggers = cronTriggers;
    }

    public void setProcessingDirectives(ProcessingDirectives processingDirectives) {
        this.processingDirectives = processingDirectives;
    }

    public List<JobDetail> getJobs() {
        if (jobs == null) {
            jobs = new ArrayList<JobDetail>();
        }
        return this.jobs;
    }

    public void setJobs(List<JobDetail> jobs) {
        this.jobs = jobs;
    }
}
