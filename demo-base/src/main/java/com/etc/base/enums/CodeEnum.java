package com.etc.base.enums;

/**
 * @author ChenDang
 * @date 2019/11/5 0005
 */
public enum  CodeEnum{

    AAE007("aae007","邮编"),
    AAE004("aae004","性别"),
    ;

    private String code;
    private String name;

    CodeEnum(String code,String name){
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(String code){
        for(CodeEnum data : CodeEnum.values()){
            if(data.getCode().equals(code)){
                return data.getName();
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
