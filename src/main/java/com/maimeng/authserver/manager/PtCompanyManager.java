package com.maimeng.authserver.manager;

import com.maimeng.authserver.model.PtCompany;
import com.maimeng.authserver.repository.PtCompanyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuweifeng wrote on 2017/10/26.
 */
@Service
public class PtCompanyManager {
    @Resource
    private PtCompanyRepository ptCompanyRepository;

    public PtCompany findOne(Long id) {
        return ptCompanyRepository.getOne(id);
    }

    public PtCompany add(PtCompany ptCompany) {
        return save(ptCompany);
    }

    public PtCompany update(PtCompany ptCompany) {
        return save(ptCompany);
    }

    private PtCompany save(PtCompany ptCompany) {
        return ptCompanyRepository.save(ptCompany);
    }

    public List<PtCompany> findByNameLike(String name) {
        return ptCompanyRepository.findByNameLike("%" + name + "%");
    }

}
