package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.Task;

/**
 * 工单管理Service接口
 * 
 * @author ruoyi
 * @date 2025-12-16
 */
public interface ITaskService 
{
    /**
     * 查询工单管理
     * 
     * @param taskId 工单管理主键
     * @return 工单管理
     */
    public Task selectTaskByTaskId(Long taskId);

    /**
     * 查询工单管理列表
     * 
     * @param task 工单管理
     * @return 工单管理集合
     */
    public List<Task> selectTaskList(Task task);

    /**
     * 新增工单管理
     * 
     * @param task 工单管理
     * @return 结果
     */
    public int insertTask(Task task);

    /**
     * 修改工单管理
     * 
     * @param task 工单管理
     * @return 结果
     */
    public int updateTask(Task task);

    /**
     * 批量删除工单管理
     * 
     * @param taskIds 需要删除的工单管理主键集合
     * @return 结果
     */
    public int deleteTaskByTaskIds(Long[] taskIds);

    /**
     * 删除工单管理信息
     * 
     * @param taskId 工单管理主键
     * @return 结果
     */
    public int deleteTaskByTaskId(Long taskId);
}
