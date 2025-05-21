package com.burnie.gateway.filters.idcard;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class BeforeCircuitBreakerFilter extends AbstractGatewayFilterFactory<BeforeCircuitBreakerFilter.Config> {

    public BeforeCircuitBreakerFilter(){
        super(Config.class);
    }

    public static class Config {
        // 필요한 설정이 있다면 여기에 추가
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> chain.filter(exchange)
                .then(Mono.defer(() -> {

                    String errorHeader =
                            exchange.getResponse()
                                    .getHeaders()
                                    .getFirst("X-API-WAITING");

                    System.out.println("나 여기있어 임마 222");



                    return Mono.empty();
                }));
    }

}
