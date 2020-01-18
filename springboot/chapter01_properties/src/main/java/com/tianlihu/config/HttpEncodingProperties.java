package com.tianlihu.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.http.HttpProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.Charset;

@Data
@ConfigurationProperties(prefix = "spring.http.encoding")  //从配置文件中获取指定的值和bean的属性进行绑定
public class HttpEncodingProperties extends HttpProperties {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Charset charset;
    private Boolean forceResponse;
    private Boolean forceRequest;
    private Boolean force;

    public boolean shouldForce(HttpProperties.Encoding.Type type) {
        Boolean force = (type != HttpProperties.Encoding.Type.REQUEST) ? this.forceResponse : this.forceRequest;
        if (force == null) {
            force = this.force;
        }
        if (force == null) {
            force = (type == HttpProperties.Encoding.Type.REQUEST);
        }
        return force;
    }
}
