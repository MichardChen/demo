package com.etc.auth;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}

	@GetMapping("/test")
	@ResponseBody
	public Object test() {
		JSONObject data = new JSONObject();
		data.put("code","200");
		data.put("module","auth");
		return data;
	}
}
