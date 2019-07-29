package com.etc.component.jwt.controller;

import com.etc.base.entity.User;
import com.etc.component.jwt.ResultVO;
import com.etc.component.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 访问授权认证器
 * @author ChenDang
 * @date 2019/7/8 0008
 */
@RestController
@RequestMapping("/auth")
public class AccessAuthController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public ResultVO login(String userName,String password){

        ResultVO vo = new ResultVO();
        User user = userService.findUser(userName,password);
        if(user == null){
            vo.setStatusCode(404);
            vo.setMessage("用户数据不对");
        }else{
            String salt = user.getSalt();
            //对明文密码进行加密
            //String encrypt =
        }

        return vo;
    }
}
