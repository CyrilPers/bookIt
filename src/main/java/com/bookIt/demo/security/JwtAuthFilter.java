package com.bookIt.demo.security;

import com.bookIt.demo.model.Customer;
import com.bookIt.demo.model.Worker;
import com.bookIt.demo.service.CustomerService;
import com.bookIt.demo.service.WorkerService;
import com.bookIt.demo.tool.jwtToken.JwtTokenTool;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenTool jwtService;

    @Autowired
    private WorkerService workerSvc;

    @Autowired
    private CustomerService customerSvc;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (requestURI.startsWith("/api/company/")) {
                doFilterForWorker(username, token, request);

            } else {
                doFilterForCustomer(username, token, request);
            }
        }

        filterChain.doFilter(request, response);

    }

    private void doFilterForCustomer(String username, String token, HttpServletRequest request) {
        Customer customer = customerSvc.findByEmail(username);
        if(jwtService.validateToken(token, customer)){
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(customer, null, null);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
    }

    private void doFilterForWorker(String username, String token, HttpServletRequest request) {
            Worker userDetails = workerSvc.findByEmail(username);
            if(jwtService.validateToken(token, userDetails)){
                Collection<SimpleGrantedAuthority> authorities = userDetails.getWorkerCompany().stream()
                        .flatMap(wc -> wc.getRoles().stream()
                                .map(role -> new SimpleGrantedAuthority(role.getName() + "_FOR_COMPANY_" + wc.getCompany().getId())))
                        .toList();
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
    }
}