package org.yashtech.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiWorld {
	
	@GetMapping("/hi")
	public String getHiWorld(){
		return "Hi Yash Tech!!!";
	}

}
