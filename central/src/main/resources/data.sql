-- Spring Cloud Gateway 라우트 설정
INSERT INTO config (key, value, profile, label, application, description)
VALUES
    ('spring.cloud.gateway.routes[0].id', 'proxy-to-idcard', 'dev', 'master', 'gateway', 'Proxy route to ID Card service'),
    ('spring.cloud.gateway.routes[0].uri', 'http://localhost:10062', 'dev', 'master', 'gateway', 'Uri for ID Card service'),
    ('spring.cloud.gateway.routes[0].predicates[0]', 'Path=/nfiocr/**', 'dev', 'master', 'gateway', 'Path predicate for ID Card service'),
    ('spring.cloud.gateway.routes[0].filters[0]', 'StripPrefix=1', 'dev', 'master', 'gateway', 'Filter to strip prefix'),
    ('spring.cloud.gateway.routes[0].filters[1].name', 'CircuitBreaker', 'dev', 'master', 'gateway', 'Circuit breaker filter'),
    ('spring.cloud.gateway.routes[0].filters[1].args[name]', 'myCircuitBreaker', 'dev', 'master', 'gateway', 'Name of the circuit breaker'),
    ('spring.cloud.gateway.routes[0].filters[1].args[fallbackUri]', 'forward:/fallback', 'dev', 'master', 'gateway', 'Fallback URI for circuit breaker'),
    ('spring.cloud.gateway.routes[0].filters[2]', 'WrongHeaderFilter', 'dev', 'master', 'gateway', 'Custom header filter');

-- Resilience4J 설정
INSERT INTO config (key, value, profile, label, application, description)
VALUES
    ('spring.cloud.gateway.resilience4j.timelimiter.configs.default.timeout-duration', '15s', 'dev', 'master', 'gateway', 'Default timeout duration for Resilience4J Timelimiter'),
    ('spring.cloud.gateway.resilience4j.circuitbreaker.configs.default.register-health-indicator', 'true', 'dev', 'master', 'gateway', 'Register health indicator for CircuitBreaker'),
    ('spring.cloud.gateway.resilience4j.circuitbreaker.configs.default.wait-duration-in-open-state', '60s', 'dev', 'master', 'gateway', 'Wait duration in open state for CircuitBreaker'),
    ('spring.cloud.gateway.resilience4j.circuitbreaker.configs.default.failure-rate-threshold', '80', 'dev', 'master', 'gateway', 'Failure rate threshold for CircuitBreaker'),
    ('spring.cloud.gateway.resilience4j.circuitbreaker.configs.default.permitted-number-of-calls-in-half-open-state', '5', 'dev', 'master', 'gateway', 'Permitted number of calls in half-open state for CircuitBreaker'),
    ('spring.cloud.gateway.resilience4j.circuitbreaker.configs.default.sliding-window-size', '50', 'dev', 'master', 'gateway', 'Sliding window size for CircuitBreaker');

-- Management Endpoints 설정
INSERT INTO config (key, value, profile, label, application, description)
VALUES
    ('management.endpoint.health.show-details', 'always', 'dev', 'master', 'gateway', 'Show details in health endpoint'),
    ('management.endpoint.circuitbreakerevents.enabled', 'true', 'dev', 'master', 'gateway', 'Enable circuitbreaker events'),
    ('management.endpoint.circuitbreakers.enabled', 'true', 'dev', 'master', 'gateway', 'Enable circuitbreakers management'),
    ('management.endpoints.web.exposure.include', 'circuitbreakers,circuitbreakerevents,health,prometheus,info,refresh', 'dev', 'master', 'gateway', 'Web exposure for management endpoints');

-- Prometheus Metrics 설정
INSERT INTO config (key, value, profile, label, application, description)
VALUES
    ('spring.metrics.export.prometheus.enabled', 'true', 'dev', 'master', 'gateway', 'Enable Prometheus metrics export');

-- Server Port 설정
INSERT INTO config (key, value, profile, label, application, description)
VALUES
    ('server.port', '10020', 'dev', 'master', 'gateway', 'Server port');
