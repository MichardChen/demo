package com.etc.base.vo;

import lombok.Data;

/**
 * 返回数据VO
 * @author ChenDang
 * @date 2019/7/8 0008
 */
@Data
public class ResultVo<T> {

    // 状态码
    private Integer code;
    // 提示信息
    private String msg;
    // 响应数据
    private T data;
}
