package com.gitegg.service.extension.justauth.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.gitegg.service.extension.justauth.entity.JustAuthSocialUser;
import com.gitegg.service.extension.justauth.mapper.JustAuthSocialUserMapper;
import com.gitegg.service.extension.justauth.service.IJustAuthSocialUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.gitegg.platform.base.util.BeanCopierUtils;
import com.gitegg.service.extension.justauth.dto.JustAuthSocialUserDTO;
import com.gitegg.service.extension.justauth.dto.CreateJustAuthSocialUserDTO;
import com.gitegg.service.extension.justauth.dto.UpdateJustAuthSocialUserDTO;
import com.gitegg.service.extension.justauth.dto.QueryJustAuthSocialUserDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 租户第三方登录功能配置表 服务实现类
 * </p>
 *
 * @author GitEgg
 * @since 2022-05-19
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class JustAuthSocialUserServiceImpl extends ServiceImpl<JustAuthSocialUserMapper, JustAuthSocialUser> implements IJustAuthSocialUserService {

    private final JustAuthSocialUserMapper justAuthSocialUserMapper;

    /**
    * 分页查询租户第三方登录功能配置表列表
    * @param page
    * @param queryJustAuthSocialUserDTO
    * @return
    */
    @Override
    public Page<JustAuthSocialUserDTO> queryJustAuthSocialUserList(Page<JustAuthSocialUserDTO> page, QueryJustAuthSocialUserDTO queryJustAuthSocialUserDTO) {
        Page<JustAuthSocialUserDTO> justAuthSocialUserInfoList = justAuthSocialUserMapper.queryJustAuthSocialUserList(page, queryJustAuthSocialUserDTO);
        return justAuthSocialUserInfoList;
    }

    /**
    * 查询租户第三方登录功能配置表列表
    * @param queryJustAuthSocialUserDTO
    * @return
    */
    @Override
    public List<JustAuthSocialUserDTO> queryJustAuthSocialUserList(QueryJustAuthSocialUserDTO queryJustAuthSocialUserDTO) {
        List<JustAuthSocialUserDTO> justAuthSocialUserInfoList = justAuthSocialUserMapper.queryJustAuthSocialUserList(queryJustAuthSocialUserDTO);
        return justAuthSocialUserInfoList;
    }

    /**
    * 查询租户第三方登录功能配置表详情
    * @param queryJustAuthSocialUserDTO
    * @return
    */
    @Override
    public JustAuthSocialUserDTO queryJustAuthSocialUser(QueryJustAuthSocialUserDTO queryJustAuthSocialUserDTO) {
        JustAuthSocialUserDTO justAuthSocialUserDTO = justAuthSocialUserMapper.queryJustAuthSocialUser(queryJustAuthSocialUserDTO);
        return justAuthSocialUserDTO;
    }

    /**
    * 创建租户第三方登录功能配置表
    * @param justAuthSocialUser
    * @return
    */
    @Override
    public boolean createJustAuthSocialUser(CreateJustAuthSocialUserDTO justAuthSocialUser) {
        JustAuthSocialUser justAuthSocialUserEntity = BeanCopierUtils.copyByClass(justAuthSocialUser, JustAuthSocialUser.class);
        boolean result = this.save(justAuthSocialUserEntity);
        return result;
    }

    /**
    * 更新租户第三方登录功能配置表
    * @param justAuthSocialUser
    * @return
    */
    @Override
    public boolean updateJustAuthSocialUser(UpdateJustAuthSocialUserDTO justAuthSocialUser) {
        JustAuthSocialUser justAuthSocialUserEntity = BeanCopierUtils.copyByClass(justAuthSocialUser, JustAuthSocialUser.class);
        boolean result = this.updateById(justAuthSocialUserEntity);
        return result;
    }

    /**
    * 删除租户第三方登录功能配置表
    * @param justAuthSocialUserId
    * @return
    */
    @Override
    public boolean deleteJustAuthSocialUser(Long justAuthSocialUserId) {
        boolean result = this.removeById(justAuthSocialUserId);
        return result;
    }

    /**
    * 批量删除租户第三方登录功能配置表
    * @param justAuthSocialUserIds
    * @return
    */
    @Override
    public boolean batchDeleteJustAuthSocialUser(List<Long> justAuthSocialUserIds) {
        boolean result = this.removeByIds(justAuthSocialUserIds);
        return result;
    }
}
