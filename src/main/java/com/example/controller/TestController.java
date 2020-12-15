package com.example.controller;

import com.example.service.TestService;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shuoshi.Yan
 * @description:
 * @date 2020-12-11 15:42
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    static GraphQLSchema schema = null;

    public GraphQLSchema init() {
        if (schema != null) {
            return schema;
        }

        schema = new GraphQLSchemaGenerator()
                .withBasePackages("io.leangen")
                .withOperationsFromSingleton(testService)
                .generate();
        return schema;
    }

    @PostMapping("/graphQL")
    public Object getGateway(@RequestBody String sql) {
        init();

        GraphQL graphQL = new GraphQL.Builder(schema).build();

        ExecutionResult result = graphQL.execute(sql);

        return result;
    }
}
