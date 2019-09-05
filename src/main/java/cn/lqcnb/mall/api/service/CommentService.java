package cn.lqcnb.mall.api.service;

import cn.lqcnb.mall.api.entity.Comment;
import cn.lqcnb.mall.api.mapper.CommentMapper;
import cn.lqcnb.mall.common.service.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/9/3 13:50
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
@Service
public class CommentService extends AbstractService<Comment> {
    @Resource
    private CommentMapper commentMapper;

    public List<Map> getListByGId(Integer gid){
        return commentMapper.getListByGId(gid);
    }
}
