package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.db.MemberManager;
import com.example.demo.vo.MemberVo;

@Configuration
@SpringBootApplication
public class SpringSecurityApplication {

	//패스워드 암호화를 위한 객체 생성
	@Bean  				//난 객체제공자입니다~
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	//	PasswordEncoderFactories 패스워드를 생성해주는 클래스
	//	createDelegatingPasswordEncoder 패스워드를 암호화 해주는 객체 제공
	//  passwordEncorder()메소드를 찾아서 내부적으로 암호화 처리 해주기 때문에 반드시 이 이름으로 id를 만들어줘야함
	
	
	public static void main(String[] args) {
//	MemberManager.insertMember(new MemberVo("tiger", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("tiger"),"홍길동","USER"));			//매니저에 만든 메소드를 호출해서 사용자 생성 
//	MemberManager.insertMember(new MemberVo("master",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("1234"),"곽동길","ADMIN"));			//매니저에 만든 메소드를 호출해서 사용자 생성 
		//실험을 위해 객체를 생성했으니 재실행 되면 안되기떄문에 주석으로 막음
			
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
}
