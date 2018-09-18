package com.zrl.modules.api.dto;

public class ResponseVo {

    /**
     * http 状态码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回的数据
     */
    private Object data;

    public ResponseVo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseVo(Object data) {
        this.data = data;
        this.code = 200;
        this.msg = "OK";
    }

    /**
     * 自定义返回json code
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static ResponseVo build(int code, String msg , Object data){
        return new ResponseVo(code,msg,data);
    }

    /**
     * 正常调用接口，且有结果集
     * @param data
     * @return
     */
    public static ResponseVo ok(Object data){
        return new ResponseVo(data);
    }

    /**
     * 正常调用接口，无结果集
     * @return
     */
    public static ResponseVo ok(){
        return new ResponseVo(null);
    }

    /**
     * 错误信息在msg字段中
     * @param msg
     * @return
     */
    public static ResponseVo errorMsg(String msg){
        return new ResponseVo(400,msg,null);
    }

    /**
     * 返回错误集合
     * @param data
     * @return
     */
    public static ResponseVo errorMap(Object data){
        return new ResponseVo(501,"error",data );
    }

    /**
     * 拦截器拦截到用户token错误；
     * @param msg
     * @return
     */
    public static ResponseVo errorTokenMsg(String msg){
        return new ResponseVo(401,msg,null);
    }

    /**
     * 异常抛出错误
     * @param msg
     * @return
     */
    public static ResponseVo errorException(String msg) {
        return new ResponseVo(503 ,msg,null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
}
