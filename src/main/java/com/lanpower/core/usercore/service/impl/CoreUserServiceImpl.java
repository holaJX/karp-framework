package com.lanpower.core.usercore.service.impl;

import com.lanpower.core.usercore.entity.CoreUser;
import com.lanpower.core.usercore.mapper.CoreUserMapper;
import com.lanpower.core.usercore.service.ICoreUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanpower.core.usercore.entity.CoreUser;
import com.lanpower.core.usercore.mapper.CoreUserMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pujx
 * @since 2019-05-22
 */
@Service
public class CoreUserServiceImpl extends ServiceImpl<CoreUserMapper, CoreUser> implements ICoreUserService {

}
