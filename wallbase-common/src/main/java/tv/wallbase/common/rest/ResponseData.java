package tv.wallbase.common.rest;


import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用户ajax提交之后的相应结果
 * <p>
 * Created by wangkun23 on 2017/6/2.
 */
public class ResponseData implements Serializable {

    /**
     * 消息code
     */
    private String code;

    /**
     * 错误提示
     */
    private String msg;

    /**
     * 结果数据
     * 如果返回对象或数组直接用setData
     * 如果返回简单的键值对用addData
     */
    private Object data;
    private Map<String, Object> dataShadow;

    public ResponseData() {

    }

    public ResponseData(String code) {
        this.code = code;
    }

    public ResponseData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回成功
     *
     * @return
     */
    public static ResponseData success() {
        return new ResponseData("200");
    }

    /**
     * 返回成功消息
     *
     * @param code 消息code
     * @return 成功消息
     */
    public static ResponseData success(String code) {
        return new ResponseData(code);
    }

    /**
     * 返回警告消息
     *
     * @param code 消息code
     * @return 警告消息
     */
    public static ResponseData warn(String code) {
        return new ResponseData(code);
    }

    /**
     * 返回错误
     *
     * @return
     */
    public static ResponseData error() {
        return new ResponseData("500");
    }

    /**
     * 返回错误消息
     *
     * @param code 消息code
     * @return 错误消息
     */
    public static ResponseData error(String code) {
        return new ResponseData(code);
    }

    /**
     * 返回错误消息
     *
     * @param code 消息code
     * @return 错误消息
     */
    public static ResponseData error(String code, String error) {
        return new ResponseData(code, error);
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 添加返回的数据
     *
     * @param key
     * @param value
     */
    public void addData(String key, Object value) {
        if (this.dataShadow == null) {
            this.dataShadow = new LinkedHashMap<String, Object>();

            this.data = this.dataShadow;
        }
        this.dataShadow.put(key, value);
    }

    /**
     * @param key
     * @return
     */
    public Object removeData(String key) {
        return this.dataShadow != null ? this.dataShadow.remove(key) : null;
    }
}
