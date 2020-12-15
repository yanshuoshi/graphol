package com.example.mapper;

import com.example.bean.Gateway;
import com.example.bean.SubGateway;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TIotGatewaysMapper {

    List<SubGateway> findByExtsno(String extsno);

    List<Gateway> findGatewayBySub(SubGateway subGateway);
}