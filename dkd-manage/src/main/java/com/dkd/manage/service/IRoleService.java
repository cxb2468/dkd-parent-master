package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.Role;

/**
 * 人员角色Service接口
 * 
 * @author ruoyi
 * @date 2025-12-05
 */
public interface IRoleService 
{
    /**
     * 查询人员角色
     * 
     * @param roleId 人员角色主键
     * @return 人员角色
     */
    public Role selectRoleByRoleId(Long roleId);

    /**
     * 查询人员角色列表
     * 
     * @param role 人员角色
     * @return 人员角色集合
     */
    public List<Role> selectRoleList(Role role);

    /**
     * 新增人员角色
     * 
     * @param role 人员角色
     * @return 结果
     */
    public int insertRole(Role role);

    /**
     * 修改人员角色
     * 
     * @param role 人员角色
     * @return 结果
     */
    public int updateRole(Role role);

    /**
     * 批量删除人员角色
     * 
     * @param roleIds 需要删除的人员角色主键集合
     * @return 结果
     */
    public int deleteRoleByRoleIds(Long[] roleIds);

    /**
     * 删除人员角色信息
     * 
     * @param roleId 人员角色主键
     * @return 结果
     */
    public int deleteRoleByRoleId(Long roleId);
}
