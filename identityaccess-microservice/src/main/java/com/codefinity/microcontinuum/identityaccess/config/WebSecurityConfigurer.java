package com.codefinity.microcontinuum.identityaccess.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.codefinity.microcontinuum.identityaccess.security.ServicesAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private ServicesAuthenticationProvider authProvider;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.antMatcher("/api/**")
			.authorizeRequests()
			.antMatchers("/api/authenticate")
			.permitAll()
			.antMatchers("/api/**/*")
			.hasAuthority("ROLE_USER");
	}
}

/*
 * public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
 * 
 * // @Autowired // private DataSource dataSource;
 * 
 * //@Autowired //private ClientDetailsService clientDetailsService;
 * 
 * @Autowired private MicroContinuumUserDetailsService
 * microContinuumUserDetailsService;
 * 
 * @Override
 * 
 * @Order(Ordered.HIGHEST_PRECEDENCE) protected void configure(HttpSecurity
 * http) throws Exception { http .sessionManagement()
 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS) .and()
 * .csrf().disable() .authorizeRequests() .antMatchers("/about").permitAll()
 * .antMatchers("/signup").permitAll() .antMatchers("/oauth/token").permitAll()
 * //.antMatchers("/api/**").authenticated() .anyRequest().authenticated()
 * .and() .httpBasic() .realmName("CRM_REALM"); }
 * 
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.userDetailsService(microContinuumUserDetailsService)
 * .passwordEncoder(passwordEncoder()); }
 * 
 * 
 * @Override
 * 
 * @Bean public AuthenticationManager authenticationManagerBean() throws
 * Exception { return super.authenticationManagerBean(); }
 * 
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * }
 */
