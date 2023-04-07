package io.sam.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.cloud.gateway.filter.LoadBalancerClientFilter;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.net.URI;
import java.util.List;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

/**
 * @author zhuweimu
 * @description
 * @date 2023/3/21 15:46
 */
@Slf4j
@Component
public class MyLoadBalancerClientFilter extends LoadBalancerClientFilter {
    public MyLoadBalancerClientFilter(LoadBalancerClient loadBalancer, LoadBalancerProperties properties) {
        super(loadBalancer, properties);
    }

    @Override
    protected ServiceInstance choose(ServerWebExchange exchange) {
        log.info("自定义过滤器");
        List<String> userId = exchange.getRequest().getQueryParams().get("userId");
        if (userId == null || userId.isEmpty()) {
            return super.choose(exchange);
        }
        LoadBalancerClient loadBalancer = this.loadBalancer;
        if (loadBalancer instanceof RibbonLoadBalancerClient) {
            return ((RibbonLoadBalancerClient)loadBalancer).choose(((URI) exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR)).getHost(),userId.get(0));
        }
        return super.choose(exchange);
    }

    @Override
    public int getOrder() {
        return super.getOrder()-1;
    }
}
