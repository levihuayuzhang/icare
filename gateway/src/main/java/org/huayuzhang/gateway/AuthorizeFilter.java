package org.huayuzhang.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Global filter
 * priority: default > routing > global
 *
 */
@Order(-1) // the less value is, the higher the priority
@Component
public class AuthorizeFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1. get request parameters
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> params = request.getQueryParams();
        // 2. get authorization parameters
        String auth = params.getFirst("authorization");
        // 3. whether equal to admin
        if ("admin".equals(auth)) {
            // yes, pass
            return chain.filter(exchange);
        }

        // set status code
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

        // no, block
        return exchange.getResponse().setComplete();
    }
}
