package cn.lqcnb.mall.common.entity;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/25 19:25
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
public class LayUI {
    private String msg;
    private Integer code;// 成功返回0 失败默认返回1
    private String  count;
    private Object data;

    public LayUI(String msg, Integer code, String count, Object data) {
        this.msg = msg;
        this.code = code;
        this.count = count;
        this.data = data;
    }

    public static LayUI ok(String count, Object data) {
       return new LayUI("ok",0,count,data);
    }
    public static LayUI error() {
        return new LayUI("error",1,"0",null);
    }

    public LayUI() {
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
