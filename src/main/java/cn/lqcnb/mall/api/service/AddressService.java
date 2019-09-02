package cn.lqcnb.mall.api.service;

import cn.lqcnb.mall.api.entity.Address;
import cn.lqcnb.mall.api.mapper.AddressMapper;
import cn.lqcnb.mall.common.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/25 18:30
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
@Service
public class AddressService extends AbstractService<Address> {
    @Resource
    private AddressMapper addressMapper;

    public boolean setDefault(Integer memberId){
        Address address = new Address();
        //address.setMemberId(memberId);
        address.setIsDefault(1);
        Example example =new Example(Address.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("memberId",memberId);
        return addressMapper.updateByExampleSelective(address,example)>0;
    }
}
