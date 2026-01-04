package com.huawei.hicloud.request.cbs.bean;

import java.util.Map;

/* loaded from: classes6.dex */
public class CBSQueryRecordDetailCursorReq extends CBSQueryRecordDetailReq {
    private Map<String, Integer> cursor;

    public CBSQueryRecordDetailCursorReq() {
    }

    public Map<String, Integer> getCursor() {
        return this.cursor;
    }

    public void setCursor(Map<String, Integer> map) {
        this.cursor = map;
    }

    public CBSQueryRecordDetailCursorReq(String str, int i10, String str2, Map<String, Integer> map) {
        super(str, i10, str2);
        this.info = "QueryBackupRecordDetailReq";
        this.cursor = map;
    }
}
