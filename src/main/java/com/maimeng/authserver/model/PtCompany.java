package com.maimeng.authserver.model;


import com.maimeng.authserver.model.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2017/10/25.
 * 平台添加的公司
 */
@Entity
@Table(name = "pt_company")
public class PtCompany extends BaseEntity {
    /**
     * 公司名称
     */
    private String name;
    private String mobile;
    /**
     * 公司状态（0正常，1欠费，-1产品故障等等）
     */
    private Integer status = 0;

    @Override
    public String toString() {
        return "PtCompany{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                '}';
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
