package com.lanpower.core.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pujx
 * @date 2019/5/13
 *
 * @describe 枚举值类
 */
public enum DlTypeEnum {

    DLTYPE_UNKNOWN("","未知"),
    DLTYPE_ZCKT("0","正常开通"),
    DLTYPE_ZSGQ("1","暂时挂起"),
    DLTYPE_YCZZ("2","异常终止"),
    DLTYPE_KTWB("3","开通完毕");

    private String code;
    private String note;

    DlTypeEnum(String code, String note){
        this.code = code;
        this.note = note;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 添加枚举字段Map映射方便其它枚举取值（可扩展其它字段映射Map）
     */
    private static Map<String,String> noteMap = new HashMap<String,String>();
    static{
        for(DlTypeEnum c:DlTypeEnum.values()){
            noteMap.put(c.getCode(),c.getNote());
        }
    }
    public static String getNoteByCode(String Code){
        return noteMap.get(Code);
    }
}
