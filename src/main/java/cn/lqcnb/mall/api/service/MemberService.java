package cn.lqcnb.mall.api.service;

import cn.lqcnb.mall.api.entity.Member;
import cn.lqcnb.mall.api.mapper.MemberMapper;
import cn.lqcnb.mall.common.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.io.IOException;

@Service
public class MemberService extends AbstractService<Member> {
    @Autowired(required = false)
    private MemberMapper memberMapper;


    public boolean updateByEmail(String email){
        Example example =new Example(Member.class);
        example.createCriteria().andEqualTo("email",email);
        Member member = new Member();
        member.setIsActivate(0);
        return memberMapper.updateByExampleSelective(member,example)>0;
    }
}
