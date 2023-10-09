package org.icare.gateway;

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
 * The priority of filter: 1. default, 2. routing, 3. global
 *
 * e.g., <a href="http://127.0.0.1:20080/booking/901?authorization=admin">example URL</a>
 * for booking ID 901 with authorization as admin
 * @author Huayu Zhang
 */
@Order(-1) // the less value is, the higher the priority
@Component
public class AuthorizeFilter implements GlobalFilter {
    /**
     * set filter for authorization=admin
     * if request parameter was not contained, return status code of 401
     *
     * @param exchange exchange of web server
     * @param chain filter chain of gateway
     * @return Mono object
     */
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
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED); // 401

        // no, block
        return exchange.getResponse().setComplete();
    }
}
