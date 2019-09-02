package cn.lqcnb.mall.common.entity;

public class R {

    private String msg;
    private Integer code;// 成功返回0 失败默认返回1
    private Object data;

    public R(String msg, Integer code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static R ok() {
        return new R("操作成功", 0, null);
    }

    public static R ok(String msg) {
        return new R(msg, 0, null);
    }

    public static R ok(Object data) {
        return new R("操作成功", 0, data);
    }

    public static R ok(String msg, Object data) {
        return new R(msg, 0, data);
    }

    public static R error(){return new R("操作失败",1,null);}

    public static R error(String msg) {
        return new R(msg, 1, null);
    }

    public static R error(String msg, Integer code) {
        return new R(msg, code, null);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
