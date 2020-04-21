package com.neoniou.auth.annotation;

import com.neoniou.auth.config.InterceptorConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Neo.Zzj
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(InterceptorConfig.class)
public @interface EnableAuth {

}
