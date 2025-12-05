package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.Emp;

/**
 * 人员管理Service接口
 * 
 * @author ruoyi
 * @date 2025-12-05
 */
public interface IEmpService 
{
    /**
     * 查询人员管理
     * 
     * @param id 人员管理主键
     * @return 人员管理
     */
    public Emp selectEmpById(Long id);

    /**
     * 查询人员管理列表
     * 
     * @param emp 人员管理
     * @return 人员管理集合
     */
    public List<Emp> selectEmpList(Emp emp);

    /**
     * 新增人员管理
     * 
     * @param emp 人员管理
     * @return 结果
     */
    public int insertEmp(Emp emp);

    /**
     * 修改人员管理
     * 
     * @param emp 人员管理
     * @return 结果
     */
    public int updateEmp(Emp emp);

    /**
     * 批量删除人员管理
     * 
     * @param ids 需要删除的人员管理主键集合
     * @return 结果
     */
    public int deleteEmpByIds(Long[] ids);

    /**
     * 删除人员管理信息
     * 
     * @param id 人员管理主键
     * @return 结果
     */
    public int deleteEmpById(Long id);
}
