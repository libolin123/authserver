package com.maimeng.authserver.manager;

import com.maimeng.authserver.model.PtUser;
import com.maimeng.authserver.repository.PtUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/10/30.
 */
@Service
public class PtUserManager {
    @Resource
    private PtUserRepository ptUserRepository;

    /**
     * 根据account查询User
     *
     * @param account
     *         账号名
     * @return 用户
     */
    public PtUser findByAccount(String account) {
        return ptUserRepository.findByAccount(account);
    }

    public PtUser add(PtUser ptUser) {
        return ptUserRepository.save(ptUser);
    }

    public PtUser update(PtUser ptUser) {
        return ptUserRepository.save(ptUser);
    }
}
