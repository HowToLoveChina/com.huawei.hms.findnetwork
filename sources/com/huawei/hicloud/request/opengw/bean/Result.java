package com.huawei.hicloud.request.opengw.bean;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class Result {
    private List<Map<String, Object>> successList = new ArrayList();
    private List<ErrMsg> failList = new ArrayList();

    public static class ErrMsg {
        private int errCode;
        private String errMsg;
        private String name;

        public int getErrCode() {
            return this.errCode;
        }

        public String getErrMsg() {
            return this.errMsg;
        }

        public String getName() {
            return this.name;
        }

        public void setErrCode(int i10) {
            this.errCode = i10;
        }

        public void setErrMsg(String str) {
            this.errMsg = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String toString() {
            return "ErrMsg{name='" + this.name + "', errCode=" + this.errCode + ", errMsg='" + this.errMsg + "'}";
        }
    }

    public List<ErrMsg> getFailList() {
        return this.failList;
    }

    public List<Map<String, Object>> getSuccessList() {
        return this.successList;
    }

    public void setFailList(List<ErrMsg> list) {
        this.failList = list;
    }

    public void setSuccessList(List<Map<String, Object>> list) {
        this.successList = list;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
