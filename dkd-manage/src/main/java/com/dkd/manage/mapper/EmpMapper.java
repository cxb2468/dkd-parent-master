package com.dkd.manage.mapper;

import java.util.List;
import com.dkd.manage.domain.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 人员管理Mapper接口
 * 
 * @author ruoyi
 * @date 2025-12-05
 */
public interface EmpMapper 
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
     * 删除人员管理
     * 
     * @param id 人员管理主键
     * @return 结果
     */
    public int deleteEmpById(Long id);

    /**
     * 批量删除人员管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEmpByIds(Long[] ids);

    /**
     * 根据区域id修改区域名称
     * @param regionName
     * @param regionId
     * @return
     */
    @Update("update tb_emp set region_name=#{regionName} where region_id = #{regionId}")
    int updateByRegionId(@Param("regionName") String regionName, @Param("regionId") Long regionId);
}
