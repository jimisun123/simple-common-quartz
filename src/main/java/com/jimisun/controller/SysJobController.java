package com.jimisun.controller;


import com.jimisun.constant.AjaxResult;
import com.jimisun.constant.TaskException;
import com.jimisun.entity.SysJob;
import com.jimisun.service.ISysJobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 调度任务信息操作处理
 *
 * @author ds
 */
@RestController
@RequestMapping("/job")
public class SysJobController {
    @Autowired
    private ISysJobService jobService;

    /**
     * 查询定时任务列表
     */
    @GetMapping("/list")
    public AjaxResult list(SysJob sysJob) {
        List<SysJob> list = jobService.selectJobList(sysJob);
        return AjaxResult.successData(list);
    }


    /**
     * 获取定时任务详细信息
     */
    @GetMapping(value = "/{jobId}")
    public AjaxResult getInfo(@PathVariable("jobId") Long jobId) {
        return AjaxResult.success(jobService.selectJobById(jobId));
    }

    /**
     * 新增定时任务
     */
    @PostMapping
    public AjaxResult add(@RequestBody SysJob job) throws SchedulerException, TaskException {
        return AjaxResult.successData(jobService.insertJob(job));
    }

    /**
     * 修改定时任务
     */
    @PutMapping
    public AjaxResult edit(@RequestBody SysJob job) throws SchedulerException, TaskException {
        return AjaxResult.successData(jobService.updateJob(job));
    }

    /**
     * 定时任务状态修改
     */
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysJob job) throws SchedulerException {
        SysJob newJob = jobService.selectJobById(job.getJobId());
        newJob.setStatus(job.getStatus());
        return AjaxResult.successData(jobService.changeStatus(newJob));
    }

    /**
     * 定时任务立即执行一次
     */
    @PutMapping("/run")
    public AjaxResult run(@RequestBody SysJob job) throws SchedulerException {
        jobService.run(job);
        return AjaxResult.success();
    }

    /**
     * 删除定时任务
     */
    @DeleteMapping("/{jobIds}")
    public AjaxResult remove(@PathVariable Long[] jobIds) throws SchedulerException, TaskException {
        jobService.deleteJobByIds(jobIds);
        return AjaxResult.success();
    }
}
