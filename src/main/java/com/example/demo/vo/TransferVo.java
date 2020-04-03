package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferVo {
	private String from;	//돈보내는사람
	private String to;		//돈 받는사람
	private int amount;		//송금액
}
