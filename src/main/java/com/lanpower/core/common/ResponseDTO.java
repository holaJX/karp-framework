package com.lanpower.core.common;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: pujx
 * @Date: 2019/5/22 11:18
 * Json通用返回DTO
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {

    private static final int FAILED_STATUS = 0;
    private static final int SUCCESS_STATUS = 1;

    private static final String DEFAULT_FAILED_MSG = "失败";
    private static final String DEFAULT_SUCCESS_MSG = "成功";

    /**
     * 成功/失败 状态标志位
     */
    @JSONField(ordinal = 1)
    private Integer status;
    /**
     * 返回码(以http status code 为基础扩充)
     */
    @JSONField(ordinal = 2)
    private Integer code;
    /**
     * 返回信息
     */
    @JSONField(ordinal = 3)
    private String msg;

    /**
     * 返回数据
     */
    @JSONField(ordinal = 4)
    private T data;

    /**
     * 成功返回:默认
     *
     * @return
     */
    public static ResponseDTO success() {
        return ResponseDTO.builder()
                .code(200)
                .status(SUCCESS_STATUS)
                .msg(DEFAULT_SUCCESS_MSG)
                .build();
    }

    /**
     * 成功返回:自定消息
     *
     * @param msg
     * @return
     */
    public static ResponseDTO success(String msg) {
        return ResponseDTO.builder()
                .code(200)
                .status(SUCCESS_STATUS)
                .msg(msg)
                .build();
    }

    /**
     * 成功返回:自定返回码和消息
     *
     * @param code
     * @param msg
     * @return
     */
    public static ResponseDTO success(int code, String msg) {
        return ResponseDTO.builder()
                .status(SUCCESS_STATUS)
                .code(code)
                .msg(msg)
                .build();
    }

    /**
     * 成功返回:自定返回码,消息,数据
     *
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseDTO<T> success(int code, String msg, T data) {
        return ResponseDTO.<T>builder()
                .status(SUCCESS_STATUS)
                .code(code)
                .msg(msg)
                .data(data)
                .build();
    }

    /**
     * 成功返回:自定消息,数据
     *
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseDTO<T> success(String msg, T data) {
        return ResponseDTO.<T>builder()
                .code(200)
                .status(SUCCESS_STATUS)
                .msg(msg)
                .data(data)
                .build();
    }

    /**
     * 成功返回:自定数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseDTO<T> success(T data) {
        return ResponseDTO.success(DEFAULT_SUCCESS_MSG, data);
    }

    /**
     * 失败返回:默认
     *
     * @return
     */
    public static ResponseDTO failed() {
        return ResponseDTO.builder()
                .status(FAILED_STATUS)
                .msg(DEFAULT_FAILED_MSG)
                .build();
    }

    /**
     * 失败返回:自定消息
     *
     * @param msg
     * @return
     */
    public static ResponseDTO failed(String msg) {
        return ResponseDTO.builder()
                .status(FAILED_STATUS)
                .msg(msg)
                .build();
    }

    /**
     * 失败返回:自定返回码,消息
     *
     * @param code
     * @param msg
     * @return
     */
    public static ResponseDTO failed(int code, String msg) {
        return ResponseDTO.<String>builder()
                .status(FAILED_STATUS)
                .code(code)
                .msg(msg)
                .build();
    }

    /**
     * 失败返回:自定返回码,消息,数据
     *
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseDTO<T> failed(int code, String msg, T data) {
        return ResponseDTO.<T>builder()
                .status(FAILED_STATUS)
                .code(code)
                .msg(msg)
                .data(data)
                .build();
    }

    /**
     * 失败返回:自定消息,数据
     *
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseDTO<T> failed(String msg, T data) {
        return ResponseDTO.<T>builder()
                .status(FAILED_STATUS)
                .msg(msg)
                .data(data)
                .build();
    }

}