package com.huawei.hicloud.request.cbs.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class CBSBaseResp {
    public static final int ACCOUNT_NO_MATCH = 702;
    public static final int BACKUP_ID_NOT_EXIST = 999;
    public static final int CONTRY_CODE_NO_MATCH = 701;
    public static final int RESULTCODE_AUTH_FAIL = 401;
    public static final int RESULTCODE_AUTH_FAIL_2 = 402;
    public static final int RESULTCODE_BACKUPRECORDS_COMPLETED = 602;
    public static final int RESULTCODE_BACKUPRECORDS_INUSED = 603;
    public static final int RESULTCODE_BACKUPRECORDS_NOTEXITS = 601;
    public static final int RESULTCODE_BACKUPRECORDS_STATUS_ILLEGAL = 611;
    public static final int RESULTCODE_BACKUP_FAILED = 605;
    public static final int RESULTCODE_BACKUP_NOSPACE = 1;
    public static final int RESULTCODE_FAIL = 1;
    public static final int RESULTCODE_INTERNAL_ERROR = 503;
    public static final int RESULTCODE_INVAILD_PARAM = 2;
    public static final int RESULTCODE_MAKEFILE_PROGRESS = 604;
    public static final int RESULTCODE_SUCCESS = 0;
    public static final int USERKEY_GUID_NO_MATCH = 708;
    protected String info;
    protected int result;

    public String getInfo() {
        return this.info;
    }

    public int getResult() {
        return this.result;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setResult(int i10) {
        this.result = i10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
