package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
		
	@GetMapping("/all/list")     //아무나 로그인 안해도 사용할수 있도록 설정
	public String list() {
		return "list";
		}
	
	
	@GetMapping("/admin/cmd1")	//로그인한 상태에서 admin 권한있는사람이 cmd1에 접근가능
	public String cmd1() {
		return "서비스1";
	}
	
	
	@GetMapping("/insert")		//로그인한 접근자들은 접근가능
	public String isnert() {
		return "insert";     
	}
	
}
