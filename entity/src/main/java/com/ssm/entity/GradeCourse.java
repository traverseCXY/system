package com.ssm.entity;

import lombok.Data;

@Data
public class GradeCourse {
        private Integer gradeid;
        private Integer corseId;

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public Integer getCorseId() {
        return corseId;
    }

    public void setCorseId(Integer corseId) {
        this.corseId = corseId;
    }

    public GradeCourse(Integer gradeid, Integer corseId) {
        this.gradeid = gradeid;
        this.corseId = corseId;
    }
}
