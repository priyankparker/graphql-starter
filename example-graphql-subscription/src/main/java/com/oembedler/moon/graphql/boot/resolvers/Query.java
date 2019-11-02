package com.oembedler.moon.graphql.boot.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
class Query implements GraphQLQueryResolver {
    public String a = "a";
    public String b = "b";

    public String hello() {
        a = a + "a";
        return "Hello world!" + a;
    }

    public String helloo() {
        b = b + "b";
        return "Hello world!" + b;
    }

}
