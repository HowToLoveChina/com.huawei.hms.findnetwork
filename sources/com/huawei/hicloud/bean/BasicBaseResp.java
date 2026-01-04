package com.huawei.hicloud.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class BasicBaseResp {
    public static final int COUNTRY_NO_SITE_MATCH = 706;
    public static final int COUNTRY_OFF_LINE = 707;
    public static final int COUNTRY_SITE_CHANGE = 701;
    public static final int RESULTCODE_AUTH_FAIL = 401;
    public static final int RESULTCODE_AUTH_FAIL_2 = 402;
    public static final int RESULTCODE_FAIL = 1;
    public static final int RESULTCODE_INTERNAL_ERROR = 503;
    public static final int RESULTCODE_INVAILD_PARAM = 3;
    public static final int RESULTCODE_SUCCESS = 0;
    public static final int TERM_NO_SIGN = 505;
    public static final int TERM_SERVER_ERROR = 504;
    public static final int UNKNOWN_COUNTRY = 705;
    protected int errorNo;
    protected String info;
    protected int result;
    protected String scenarioId;

    public int getErrorNo() {
        return this.errorNo;
    }

    public String getInfo() {
        return this.info;
    }

    public int getResult() {
        return this.result;
    }

    public String getScenarioId() {
        return this.scenarioId;
    }

    public void setErrorNo(int i10) {
        this.errorNo = i10;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setResult(int i10) {
        this.result = i10;
    }

    public void setScenarioId(String str) {
        this.scenarioId = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
