package cn.lqcnb.mall.api.service;

import cn.lqcnb.mall.api.entity.User;
import cn.lqcnb.mall.api.mapper.UserMapper;
import cn.lqcnb.mall.common.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/30 10:32
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
@Service
public class UserService extends AbstractService<User> {
    @Resource
    private UserMapper userMapper;

    public boolean updateByMobile(User user){
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("mobile",user.getMobile());
        return userMapper.updateByExampleSelective(user,example)>0;
    }

    public boolean updateByPassword(User user,String password){
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("password",password);
        return userMapper.updateByExampleSelective(user,example)>0;
    }
}
