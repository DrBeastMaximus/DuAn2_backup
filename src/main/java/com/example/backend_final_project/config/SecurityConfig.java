package com.example.backend_final_project.config;

import com.example.backend_final_project.filter.JWTAuthFilter;
import com.example.backend_final_project.service.AuthService;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private AuthService authService;

    private final  AuthService authService;
    public SecurityConfig(AuthService authService) {
        this.authService = authService;
    }

    @Autowired
    private AuthEntryPointJWT unauthorizedHandler;

//    @Bean
//    public JWTAuthFilter jwtAuthFilter(){
//        return new JWTAuthFilter(authService);
//    }


    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService).passwordEncoder(passwordEncoder());
    }
    @Bean
    @SuppressWarnings("deprecation")
    public NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/image/**").permitAll()
                .antMatchers("/api/product/**").permitAll()
                .antMatchers("/api/product/**").permitAll()
                .antMatchers("/admin/**").permitAll()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/*.css").permitAll()
                .antMatchers("/*.js").permitAll()
                .antMatchers("/*.jpg").permitAll()
                .antMatchers("/*.png").permitAll()
                .antMatchers("/*.scss").permitAll()
                .antMatchers("/*.gif").permitAll()
                .anyRequest().authenticated();
        http.addFilterAfter(new JWTAuthFilter(authenticationManager(),authService), UsernamePasswordAuthenticationFilter.class);

    }

}