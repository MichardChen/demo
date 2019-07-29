package com.etc.component.jwt.enums;

/**
 * @author ChenDang
 * @date 2019/7/25 0025
 */
public enum AccountType {

    NORMAL_USER("1001", "普通用户"),
    VIP("1002", "vip");

    private String code;
    private String name;

    private AccountType(String code, String name) {
        this.code = code;
        this.name = name;
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

    public String getName(String code) {
        for (AccountType accountType : AccountType.values()) {
            if (accountType.code.equals(code)) {
                return accountType.name();
            }
        }
        return "";
    }
}
