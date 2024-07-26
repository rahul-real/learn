///**
// * 
// */
//package com.rahul.learn.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//
//import com.rahul.learn.service.JwtService;
//
//import io.jsonwebtoken.io.IOException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
///**
// * @author rahul
//   @since  13-Jan-2024 2024 9:39:51 pm
// */
//public class JwtAuthFilter {
//	
//	 @Autowired
//	    private JwtService jwtService;
//
//	    @Autowired
//	    private UserInfoUserDetailsService userDetailsService;
//
//	    @Override
//	    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//				throws ServletException, IOException{
//	        String authHeader = request.getHeader("Authorization");
//	        String token = null;
//	        String username = null;
//	        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//	            token = authHeader.substring(7);
//	            username = jwtService.extractUsername(token);
//	        }
//
//	        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//	            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//	            if (jwtService.validateToken(token, userDetails)) {
//	                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//	                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//	                SecurityContextHolder.getContext().setAuthentication(authToken);
//	            }
//	        }
//	        filterChain.doFilter(request, response);
//	    }
//	}
