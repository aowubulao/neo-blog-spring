package com.neoniou.auth.config;

import com.neoniou.auth.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Neo.Zzj
 */
@Configuration
@ConditionalOnClass(RedisUtil.class)
@EnableConfigurationProperties({RedisProperties.class})
public class RedisConfig {

    private final RedisProperties props;

    @Autowired
    public RedisConfig(RedisProperties props) {
        this.props = props;
    }

    @Bean
    @ConditionalOnMissingBean(RedisUtil.class)
    RedisUtil redisUtil() {
        return new RedisUtil(props.getMaxTotal(), props.getMaxIdle(), props.getMaxWaitMillis(),
                props.getHost(), props.getPort(), props.getPassword());
    }
}
