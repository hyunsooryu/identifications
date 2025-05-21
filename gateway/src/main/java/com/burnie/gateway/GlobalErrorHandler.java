package com.burnie.gateway;

import com.burnie.gateway.filters.idcard.LastException;
import com.burnie.gateway.filters.idcard.WaitingException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.cloud.gateway.support.ServiceUnavailableException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class GlobalErrorHandler implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {

        if(ex instanceof ServiceUnavailableException){
            System.out.println("써킷브레이커 오픈입니다.");
            exchange.getResponse().setStatusCode(HttpStatus.BAD_GATEWAY);
            byte[] bytes = "CircuitBreaker Open".getBytes(StandardCharsets.UTF_8);
            exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
            return exchange.getResponse().writeWith(
                    Mono.just(exchange.getResponse().bufferFactory().wrap(bytes))
            );
        }

        else if(ex instanceof LastException){
           // System.out.println("LastException 오픈입니다.");
            exchange.getResponse().setStatusCode(HttpStatus.OK);
            byte[] bytes = "{\"error\": \"LastException\"}".getBytes(StandardCharsets.UTF_8);
            exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
            exchange.getResponse().getHeaders().setContentLength(bytes.length);
            return exchange.getResponse().writeWith(
                    Mono.just(exchange.getResponse().bufferFactory().wrap(bytes))
            );
        }

        if(ex instanceof WaitingException){
            exchange.getResponse().setStatusCode(HttpStatus.OK);
            byte[] bytes = "{\"error\": \"WaitingException\"}".getBytes(StandardCharsets.UTF_8);
            exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
            exchange.getResponse().getHeaders().setContentLength(bytes.length);
            return exchange.getResponse().writeWith(
                    Mono.just(exchange.getResponse().bufferFactory().wrap(bytes))
            );
        }

        return Mono.error(ex);
    }
}
