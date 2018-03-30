package com.shiny.ucenter.web.config;

import com.shiny.cache.config.RedisCacheConfig;
import com.shiny.cache.util.RedisUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shiny
 **/
@Configuration
@Import({RedisCacheConfig.class, RedisUtil.class})
public class RedisConfigure {
}
