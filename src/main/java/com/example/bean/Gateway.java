package com.example.bean;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;

@Data
public class Gateway extends CommonModel {

    /**
     * SNO 机器码
     */
    @GraphQLQuery(name = "sno", description = "机器码")
    private String sno;


    /**
     *  GIT 地址
     */
    @GraphQLQuery(name = "git_path", description = "项目地址")
    private String gitPath;

    /**
     *  描述
     */
    @GraphQLQuery(name = "desription", description = "描述")
    private String desription;

    private String subid;


}
