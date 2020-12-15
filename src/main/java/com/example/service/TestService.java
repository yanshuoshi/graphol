package com.example.service;

import com.example.bean.Gateway;
import com.example.bean.SubGateway;
import com.example.mapper.TIotGatewaysMapper;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shuoshi.Yan
 * @description:
 * @date 2020-12-11 16:05
 **/
@Service
@Slf4j
public class TestService {

    @Autowired
    TIotGatewaysMapper tIotGatewaysMapper;

    @GraphQLQuery(name = "subgateway")
    public SubGateway subGateway(@GraphQLArgument(name = "extsno") String extsno) {
        log.debug("subgateway start by extsno:{}",extsno);
        if (Strings.isBlank(extsno)) {
            return null;
        }
        List<SubGateway> subGateways = tIotGatewaysMapper.findByExtsno(extsno);
        return subGateways.get(0);
    }
    @GraphQLQuery(name = "gateway")
    public Gateway getDeviceBySno(@GraphQLContext SubGateway subGateway) {
        List<Gateway> devices = tIotGatewaysMapper.findGatewayBySub(subGateway);
        return devices.get(0);
    }
}
