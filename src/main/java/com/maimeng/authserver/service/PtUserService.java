package com.maimeng.authserver.service;

import com.maimeng.authserver.global.bean.BaseData;
import com.maimeng.authserver.global.bean.ResultCode;
import com.maimeng.authserver.global.bean.ResultGenerator;
import com.maimeng.authserver.global.jwt.JwtUtils;
import com.maimeng.authserver.manager.PtCompanyManager;
import com.maimeng.authserver.manager.PtUserManager;
import com.maimeng.authserver.model.PtCompany;
import com.maimeng.authserver.model.PtUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/10/30.
 */
@Service
public class PtUserService {
    @Resource
    private PtUserManager ptUserManager;
    @Resource
    private PtCompanyManager ptCompanyManager;
    @Resource
    private JwtUtils jwtUtils;

    public BaseData login(String account, String password) {
        PtUser ptUser = ptUserManager.findByAccount(account);
        if (ptUser == null) {
            //用户不存在
            return ResultGenerator.genFailResult(ResultCode.USER_NO_EXIST, "用户不存在");
        }
        if (!ptUser.getPassword().equals(password)) {
            //密码错误
            //用户不存在
            return ResultGenerator.genFailResult(ResultCode.PASSWORD_ERROR, "密码错误");
        }
        if (ptUser.getDeleteFlag() || ptUser.getState() != 0) {
            //没有权限
            return ResultGenerator.genFailResult(ResultCode.UNAUTHORIZED, "该用户没有权限");
        }
        // Create Twt token
        try {
            String token = jwtUtils.generateToken(ptUser.getId());
            return ResultGenerator.genSuccessResult(token);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public BaseData regist(String account, String password, String companyName, String name) {
        PtUser ptUser = ptUserManager.findByAccount(account);
        if (ptUser != null) {
            return ResultGenerator.genFailResult("用户已存在");
        }

        List<PtCompany> companyList = ptCompanyManager.findByNameLike(companyName);
        if (companyList.size() > 0) {
            return ResultGenerator.genFailResult("公司名称已存在类似");
        }

        ptUser = new PtUser();
        PtCompany ptCompany = new PtCompany();
        ptCompany.setName(companyName);
        ptCompany.setMobile(account);
        ptCompany = ptCompanyManager.add(ptCompany);

        ptUser.setCompanyId(ptCompany.getId());
        ptUser.setName(name);
        ptUser.setAccount(account);
        ptUser.setMobile(account);
        ptUser.setPassword(password);
        ptUser.setDeleteFlag(false);
        ptUserManager.add(ptUser);

        try {
            String token = jwtUtils.generateToken(ptUser.getId());
            return ResultGenerator.genSuccessResult(token);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public BaseData updatePassword(String account, String pass) {
        PtUser ptUser = ptUserManager.findByAccount(account);
        if (ptUser == null) {
            //用户不存在
            return ResultGenerator.genFailResult(ResultCode.USER_NO_EXIST, "用户不存在");
        }

        ptUser.setPassword(pass);
        ptUserManager.update(ptUser);
        return ResultGenerator.genSuccessResult("修改成功");
    }
}
