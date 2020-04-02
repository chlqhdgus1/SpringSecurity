package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration			//자동으로 스캔되어야 하니 configuration이라고 작성
@EnableWebSecurity		//어노테이션기반의 시큐리티라는걸 나타냄
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		
		http.authorizeRequests()					//사용자의 요청별 권한 설정을 하겠습니다.
		.mvcMatchers("/","/all/**").permitAll() 	//1.이러한 요청은 아무나 사용할수 있어요.
		.mvcMatchers("/admin/**").hasRole("ADMIN")	//2.이러한 요청은 ADMIN권한(role)이 있어야 사용가능해요
		.anyRequest().authenticated();				//3.그외에는 인증(로그인)만 하면돼
		
		//http.formLogin();	
		//스프링 시큐리티가 제공하는 로그인 폼을 사용하겠습니다.		
		
		//로그인 페이지를 사용자가 만들어 지정해보자
		http.formLogin().loginPage("/login").permitAll();
		
		//우리가 사용자 정의 loginPage를 지정하면 로그아웃 제공하지 않아요.
		//로그아웃을 위한 서비스명도 지정해요.
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.invalidateHttpSession(true);
		
		
		http.httpBasic();	
		//http기본 프로토콜을 사용하겠습니다.
	}
}
