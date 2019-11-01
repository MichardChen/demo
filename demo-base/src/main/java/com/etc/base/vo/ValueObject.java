package com.etc.base.vo;

/**
 * @author ChenDang
 * @date 2019/10/31 0031
 */
public class ValueObject {

    private String id;
    private Integer value;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "ValueObject [id=" + id + ", value=" + value + "]";
    }
}
