package io.sam.filter;


import io.sam.db.mapper.AccountTblMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author zhuweimu
 * @description
 * @date 2021/4/13 9:55
 */
@Slf4j
@WebFilter
public class UseFilter implements Filter {

    @Autowired
    AccountTblMapper accountTblMapper;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("dofilter");
        accountTblMapper.selectByPrimaryKey(1);
    }

    @Override
    public void destroy() {

    }
}
