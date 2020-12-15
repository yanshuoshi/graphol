package com.example.bean;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;

@Data
public class SubGateway extends CommonModel {


    /**
     * SNO 机器码
     */
    @GraphQLQuery(name = "sno", description = "机器码")
    private String sno;

    /**
     * SNO  外网IP
     */
    @GraphQLQuery(name = "ext_ip", description = "外网IP")
    private String extip;

    /**
     * SNO  内网IP
     */
    @GraphQLQuery(name = "ip", description = "内网IP")
    private String ip;

    /**
     * contrl_device_api_port  外网控制端口
     */
    @GraphQLQuery(name = "port", description = "外网控制端口")
    private String port;

    /**
     * contrl_device_api_uri  外网控制接口
     */
    @GraphQLQuery(name = "api", description = "外网控制接口")
    private String api;

    /**
     * SNO 生成机器码
     */
    @GraphQLQuery(name = "ext_sno", description = "生成机器码")
    private String extSno;


    /**
     * gwid
     */
    @GraphQLQuery(name = "gateway_id", description = "生成机器码")
    private String gwid;


}
