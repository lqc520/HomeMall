package cn.lqcnb.mall.api.service;

import cn.lqcnb.mall.api.annotation.UserLoginToken;
import cn.lqcnb.mall.api.entity.Collection;
import cn.lqcnb.mall.api.entity.Member;
import cn.lqcnb.mall.api.mapper.CollectionMapper;
import cn.lqcnb.mall.common.entity.R;
import cn.lqcnb.mall.common.service.AbstractService;
import cn.lqcnb.mall.common.utils.TokenUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/29 23:45
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
@Service
public class CollectionService extends AbstractService<Collection> {
    @Resource
    private CollectionMapper collectionMapper;

    public boolean deleteByUidAndGid(int uid,int gid){
        Example example = new Example(Collection.class);
        example.createCriteria().andEqualTo("memberId",uid).andEqualTo("goodsId",gid);
        return collectionMapper.deleteByExample(example)>0;
    }
}
