package com.dkd.manage.service;

import java.util.List;
import com.dkd.manage.domain.Channel;
import com.dkd.manage.domain.vo.ChannelVo;

/**
 * 售货机货道管理Service接口
 * 
 * @author ruoyi
 * @date 2025-12-08
 */
public interface IChannelService 
{
    /**
     * 查询售货机货道管理
     * 
     * @param id 售货机货道管理主键
     * @return 售货机货道管理
     */
    public Channel selectChannelById(Long id);

    /**
     * 查询售货机货道管理列表
     * 
     * @param channel 售货机货道管理
     * @return 售货机货道管理集合
     */
    public List<Channel> selectChannelList(Channel channel);

    /**
     * 新增售货机货道管理
     * 
     * @param channel 售货机货道管理
     * @return 结果
     */
    public int insertChannel(Channel channel);

    /**
     * 修改售货机货道管理
     * 
     * @param channel 售货机货道管理
     * @return 结果
     */
    public int updateChannel(Channel channel);

    /**
     * 批量删除售货机货道管理
     * 
     * @param ids 需要删除的售货机货道管理主键集合
     * @return 结果
     */
    public int deleteChannelByIds(Long[] ids);

    /**
     * 删除售货机货道管理信息
     * 
     * @param id 售货机货道管理主键
     * @return 结果
     */
    public int deleteChannelById(Long id);


     public int countChannelBySkuIds(Long[] ids);

    /*根据innercode 查询channel列表*/
    List<ChannelVo>  selectChannelVoListByInnerCode(String innerCode);
}
