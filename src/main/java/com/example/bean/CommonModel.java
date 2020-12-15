package com.example.bean;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;

import java.util.Date;

@Data
public abstract class CommonModel {


    @GraphQLQuery
    private String id;

    @GraphQLQuery(name = "status",description = "状态")
    protected String status="true";

    @GraphQLQuery(name = "isdel",description = "是否删除")
    protected String delFlag="false";

    protected String createBy;


    protected Date createTime;

    protected String updateBy;

    protected Date updateTime;


    public Date now() {
        return new Date();
    }

}
