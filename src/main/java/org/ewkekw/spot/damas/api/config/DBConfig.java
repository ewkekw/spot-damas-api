package org.ewkekw.spot.damas.api.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.ewkekw.spot.damas.api.repository")
public class DBConfig {
}
