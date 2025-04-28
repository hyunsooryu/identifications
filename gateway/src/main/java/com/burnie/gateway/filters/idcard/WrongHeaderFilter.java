package com.burnie.gateway.filters.idcard;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class WrongHeaderFilter extends AbstractGatewayFilterFactory<WrongHeaderFilter.Config> {

    public WrongHeaderFilter(){
        super(Config.class);
    }

    public static class Config {
        // 필요한 설정이 있다면 여기에 추가
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                return chain.filter(exchange)
                        .then(Mono.defer(() -> {
                            String errorHeader =
                                    exchange.getResponse()
                                            .getHeaders()
                                            .getFirst("x-api-error-response");
                            if (StringUtils.hasLength(errorHeader) && "true".equals(errorHeader)) {
                                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "정의된 에러 ");
                            }

                            return Mono.empty();
                        }));
            }
        };
    }

}
