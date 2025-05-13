CREATE TABLE config (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        key VARCHAR(255) NOT NULL,        -- 설정 키
                        value TEXT NOT NULL,              -- 설정 값
                        profile VARCHAR(255) NOT NULL,    -- 프로파일 (예: dev, prod 등)
                        label VARCHAR(255) NOT NULL,      -- 레이블 (예: master)
                        application VARCHAR(255),         -- 애플리케이션 이름 (옵션)
                        description TEXT                  -- 설명 (옵션)
);