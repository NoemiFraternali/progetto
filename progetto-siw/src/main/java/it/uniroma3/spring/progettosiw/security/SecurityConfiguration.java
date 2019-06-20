/* package it.uniroma3.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//chi puo accedere
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/index", "/fotografi", "/fotografo","/richiesteUtilizzoForm", "/album").permitAll() 
		.antMatchers(HttpMethod.GET, "/amministratore", "/richiesteUtilizzo", "/loginAmministratore", "/albumForm", "/fotografoForm", "/addFoto", "/addFoto2").hasAnyAuthority("ADMIN") 
		.anyRequest().authenticated()

		//login
		.and()
		.formLogin()
		.loginPage("/loginAmministratore")
		.defaultSuccessUrl("/amministratore/")
		
		//logout
		.and()
		.logout() 
		.logoutUrl("/logout") 
		.logoutSuccessUrl("/");
	}
	


	@Bean
	PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder();
	}
}
*/
