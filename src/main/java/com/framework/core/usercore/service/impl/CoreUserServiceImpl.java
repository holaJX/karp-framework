package com.framework.core.usercore.service.impl;

import com.framework.core.usercore.entity.CoreUser;
import com.framework.core.usercore.mapper.CoreUserMapper;
import com.framework.core.usercore.service.ICoreUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
