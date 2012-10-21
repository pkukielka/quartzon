package com.pkukielka.quartzon;

import com.pkukielka.quartzon.job.JobDetail;
import com.pkukielka.quartzon.trigger.SimpleTrigger;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

public class SchedulerTest {
    @Test
    public void testBuild() throws Exception {
        JobDetail jobDetail = new JobDetail();
        jobDetail.setDurability(true);
        jobDetail.setName("testJob");
        jobDetail.setGroup("testGroup");
        jobDetail.setJobClass("com.pkukielka.quartzon.TestJob");

        SimpleTrigger simpleTrigger = new SimpleTrigger();
        simpleTrigger.setName("testTrigger");
        simpleTrigger.setGroup("testGroup");
        simpleTrigger.setJobName("testJob");
        simpleTrigger.setJobGroup("testGroup");
        simpleTrigger.setRepeatCount(2);
        simpleTrigger.setRepeatInterval(3);
        simpleTrigger.setStartTime(new Date());

        Scheduler scheduler = new Scheduler();
        scheduler.getJobs().add(jobDetail);
        scheduler.getSimpleTriggers().add(simpleTrigger);

        org.quartz.Scheduler quartzScheduler = scheduler.build(new StdSchedulerFactory());

        org.quartz.JobDetail job = quartzScheduler.getJobDetail(new JobKey("testJob", "testGroup"));
        assertEquals(TestJob.class, job.getJobClass());
        assertEquals(jobDetail.getDurability().booleanValue(), job.isDurable());

        Trigger trigger = quartzScheduler.getTrigger(new TriggerKey("testTrigger", "testGroup"));
        assertEquals("testJob", trigger.getJobKey().getName());
        assertEquals("testGroup", trigger.getJobKey().getGroup());
    }
}
