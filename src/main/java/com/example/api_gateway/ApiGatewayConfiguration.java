package com.example.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){

        return builder.routes()
                .route(p->p.path("/calculate/**").uri("lb://CALCULATIONSERVICE"))
                .route(p->p.path("/item/**").uri("lb://ITEMPRICESERVICE"))
                .route(p->p.path("/calculate-new/**").filters(f->f.rewritePath("/calculate-new/","/calculate/")).uri("lb://CALCULATIONSERVICE"))
                .build();
    }
}
