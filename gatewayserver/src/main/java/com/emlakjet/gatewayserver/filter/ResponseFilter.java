package com.emlakjet.gatewayserver.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;


@Configuration
//Post Filter for injecting correlation_id to gateway's client response
public class ResponseFilter {

    private static final Logger logger = LoggerFactory.getLogger(ResponseFilter.class);
    FilterUtils filterUtils;

    @Bean
    public GlobalFilter postGlobalFilter(){
        return ((exchange, chain) -> {
          return chain.filter(exchange).then(Mono.fromRunnable(() -> {
              HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
              String correlationId = filterUtils.getCorrelationId(requestHeaders);// take correlation_id from request
              logger.debug("Adding the correlation id to the outbound headers. {}", correlationId);
              exchange.getResponse().getHeaders().add(FilterUtils.CORRELATION_ID,correlationId); // add correlation_id to response
              logger.debug("Completing outgoing request for {}.", exchange.getRequest().getURI());
          }));
        });
    }

}
