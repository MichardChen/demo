package com.etc.component.jwt.controller;

import com.etc.base.entity.User;
import com.etc.base.util.EncryptUtil;
import com.etc.base.util.ResultVoUtil;
import com.etc.base.vo.ResultVo;
import com.etc.component.jwt.config.JwtProperties;
import com.etc.component.jwt.service.UserService;
import com.etc.component.jwt.util.JwtUtil;
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

    //获取jwt的配置对象
    @Autowired
    JwtProperties properties;

    @RequestMapping("/api/auth")
    public ResultVo login(String userName, String password){

        User user = userService.findUser(userName,password);
        if(user == null){
            return ResultVoUtil.success("登录失败,用户不存在");
        }else{
            String salt = user.getSalt();
            //对明文密码进行加密,判断密码是否一致,一致的话就返回token
            String encrypt = EncryptUtil.encrypt(password,user.getSalt());
            if(encrypt.equals(user.getPassword())){
                //密码一样
                String token = JwtUtil.getToken(userName,properties.getSecret(),properties.getExpired());
                return ResultVoUtil.success("登录成功",token);
            }
        }
        return ResultVoUtil.success("登录失败,用户不存在");
    }
}
