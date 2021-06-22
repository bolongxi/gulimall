package com.xunqi.gulimall.member.dao;

import com.xunqi.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 *
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
