package com.maimeng.authserver.repository;

import com.maimeng.authserver.model.PtCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wuweifeng wrote on 2017/10/26.
 */
public interface PtCompanyRepository extends JpaRepository<PtCompany, Long>,
        JpaSpecificationExecutor<PtCompany> {

    /**
     * 根据名称模糊查询
     * @param name name
     * @return List
     */
    List<PtCompany> findByNameLike(String name);
}
