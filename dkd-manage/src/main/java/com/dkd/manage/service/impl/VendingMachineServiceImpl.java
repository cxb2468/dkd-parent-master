package com.dkd.manage.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.dkd.common.utils.DateUtils;
import com.dkd.common.utils.bean.BeanUtils;
import com.dkd.common.utils.uuid.UUIDUtils;
import com.dkd.manage.domain.Channel;
import com.dkd.manage.domain.Node;
import com.dkd.manage.domain.VmType;
import com.dkd.manage.service.IChannelService;
import com.dkd.manage.service.INodeService;
import com.dkd.manage.service.IVmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkd.manage.mapper.VendingMachineMapper;
import com.dkd.manage.domain.VendingMachine;
import com.dkd.manage.service.IVendingMachineService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 设备管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-08
 */
@Service
public class VendingMachineServiceImpl implements IVendingMachineService 
{
    @Autowired
    private VendingMachineMapper vendingMachineMapper;

    @Autowired
    private IVmTypeService  vmTypeService ;
    @Autowired
    private INodeService nodeService;

    @Autowired
    private IChannelService channelService ;

    /**
     * 查询设备管理
     * 
     * @param id 设备管理主键
     * @return 设备管理
     */
    @Override
    public VendingMachine selectVendingMachineById(Long id)
    {
        return vendingMachineMapper.selectVendingMachineById(id);
    }

    /**
     * 查询设备管理列表
     * 
     * @param vendingMachine 设备管理
     * @return 设备管理
     */
    @Override
    public List<VendingMachine> selectVendingMachineList(VendingMachine vendingMachine)
    {
        return vendingMachineMapper.selectVendingMachineList(vendingMachine);
    }

    /**
     * 新增设备管理
     * 
     * @param vendingMachine 设备管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertVendingMachine(VendingMachine vendingMachine)
    {
        /*1 新增货道*/
        /*1.1 用uuid设置innerCode*/
        String innerCode = UUIDUtils.getUUID();
        // 确保innerCode不超过15个字符
        if (innerCode.length() > 15) {
            innerCode = innerCode.substring(0, 15);
        }
        vendingMachine.setInnerCode(innerCode); // 售货机编号
        /*1.2  将vmType对象的 channelMaxCapacity  set到vendingMachine*/
        VmType vmType=vmTypeService.selectVmTypeById(vendingMachine.getVmTypeId());
        vendingMachine.setChannelMaxCapacity(vmType.getChannelMaxCapacity());
        /*根据nodeId 用nodeMapper查询到该点位的所有信息，然后copy到vendingMachine ，但是id除外*/
        Node node=nodeService.selectNodeById(vendingMachine.getNodeId());
        /*用beanUtil 将node copy到vendingMachine ，但是id除外*/
       BeanUtils.copyProperties(node,vendingMachine,new String[]{"id"});
       vendingMachine.setAddr(node.getAddress());
       /*vmstatus状态 默认设置为0*/
        vendingMachine.setVmStatus(0L);

        vendingMachine.setCreateTime(DateUtils.getNowDate());
        vendingMachine.setUpdateTime(DateUtils.getNowDate());
        int result = vendingMachineMapper.insertVendingMachine(vendingMachine);

        /*2 新增货道*/
        /*当双层for循环执行多次插入 操作时，会比较耗时，为解决这个问题，采用 插入语句add到chanelList中合并一次性插入（要改sql.xml文件 ）
        */
//        List<Channel> channelList = new ArrayList<>();

        for (int i = 1; i <= vmType.getVmRow(); i++) {
            for (int j = 1; j <= vmType.getVmCol(); j++) {
                Channel channel = new Channel();
                channel.setVmId(vendingMachine.getId());
                channel.setInnerCode(vendingMachine.getInnerCode()); // 设置售货机编号
                channel.setChannelCode(i + "-" + j);
                channel.setMaxCapacity(vmType.getChannelMaxCapacity());
                channel.setCurrentCapacity(0L);
                channel.setLastSupplyTime(DateUtils.getNowDate());
                channel.setUpdateTime(DateUtils.getNowDate());

                channelService.insertChannel(channel);
//                channelList.add(channel);
            }
        }
//       批量新增
//        channelService.batchInsertChannelList(channelList);

        return result;
    }

    /**
     * 修改设备管理
     * 
     * @param vendingMachine 设备管理
     * @return 结果
     */
    @Override
    public int updateVendingMachine(VendingMachine vendingMachine)
    {
        //根据nodeId 用nodeService查询到该点位所有信息，然后copy到vendingMachine ，但是id除外
        //合作商信息  区域信息  设备地址信息
        Node node=nodeService.selectNodeById(vendingMachine.getNodeId());
        /*用beanUtil 将node copy到vendingMachine ，但是id除外*/
        BeanUtils.copyProperties(node,vendingMachine,new String[]{"id"});
        vendingMachine.setAddr(node.getAddress());
        vendingMachine.setUpdateTime(DateUtils.getNowDate());
        return vendingMachineMapper.updateVendingMachine(vendingMachine);
    }

    /**
     * 批量删除设备管理
     * 
     * @param ids 需要删除的设备管理主键
     * @return 结果
     */
    @Override
    public int deleteVendingMachineByIds(Long[] ids)
    {
        return vendingMachineMapper.deleteVendingMachineByIds(ids);
    }

    /**
     * 删除设备管理信息
     * 
     * @param id 设备管理主键
     * @return 结果
     */
    @Override
    public int deleteVendingMachineById(Long id)
    {
        return vendingMachineMapper.deleteVendingMachineById(id);
    }
}