package com.huawei.hicloud.request.cbs.bean;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class CBSBaseReq {
    public static final int CBS_LOCK_TYPE_BACKUP_OR_RESTORE = 0;
    public static final int CBS_LOCK_TYPE_DELETE_RECORD = 1;
    public static final int CMD_AGREE_TO_TERMS = 52;
    public static final int CMD_APPMKFILE = 44;
    public static final int CMD_BACKUP = 2;
    public static final int CMD_CHECKAPKEXIST = 48;
    public static final int CMD_CHECKFILEEXIST = 41;
    public static final int CMD_CHECKFILEEXIST_V2 = 45;
    public static final int CMD_COUNTBYDEVICE = 9;
    public static final int CMD_CREATEAPPBACKUPRECORD = 26;
    public static final int CMD_CREATEBACKUPRECORD = 24;
    public static final int CMD_CREATEDBANKSESSION = 1;
    public static final int CMD_DELETEAPPBACKUPRECORD = 28;
    public static final int CMD_DELETEBACKUP = 5;
    public static final int CMD_DELETEBACKUPRECORD = 27;
    public static final int CMD_DELETESINGLEBACKUPRECORD = 32;
    public static final int CMD_GET_BACKUP_INIT_PARAMS = 0;
    public static final int CMD_INITPARAM = 21;
    public static final int CMD_LOCKDEVICEBACKUP = 29;
    public static final int CMD_QUERYALLBACKUPRECORD = 22;
    public static final int CMD_QUERYBACKUPRECORDDETAIL = 23;
    public static final int CMD_QUERYDEVICE = 6;
    public static final int CMD_QUERYDOWNLOADPARAM = 47;
    public static final int CMD_QUERYUPLOADPARAM = 46;
    public static final int CMD_QUERY_ALL_DEVICE_BACKUP = 36;
    public static final int CMD_QUERY_APK_NOT_CDN_URL = 31;
    public static final int CMD_QUERY_ASYNCEXEC_RESULT = 34;
    public static final int CMD_QUERY_DEVICE_OPRATION = 51;
    public static final int CMD_RECOVER = 8;
    public static final int CMD_SIGNUPRARAM = 43;
    public static final int CMD_SMS_CALLLOG_COUNT = 4;
    public static final int CMD_UNLOCKDEVICEBACKUP = 30;
    public static final int CMD_UPDATEBACKUPRECORD = 25;
    public static final int CMD_UPDATEDEVICE = 7;
    public static final int CMD_UPDATE_BACKUPRECORD_ASYNC = 33;
    public static final String CURRENT_API_VERSION = "V3";
    public static final int FLAG_IS_IN_BACKUP = 1;
    public static final String OLD_CURRENT_API_VERSION = "V2";
    private static final HashMap<Integer, String> SERVICE_ID_NAME_MAP = new HashMap<Integer, String>() { // from class: com.huawei.hicloud.request.cbs.bean.CBSBaseReq.1
        {
            put(0, "com.huawei.hidisk.backup");
            put(5, "com.huawei.hidisk.backup");
            put(21, "com.huawei.hidisk.backup");
            put(22, "com.huawei.hidisk.backup");
            put(23, "com.huawei.hidisk.backup");
            put(24, "com.huawei.hidisk.backup");
            put(25, "com.huawei.hidisk.backup");
            put(26, "com.huawei.hidisk.backup");
            put(27, "com.huawei.hidisk.backup");
            put(28, "com.huawei.hidisk.backup");
            put(29, "com.huawei.hidisk.backup");
            put(30, "com.huawei.hidisk.backup");
            put(31, "com.huawei.hidisk.backup");
            put(32, "com.huawei.hidisk.backup");
            put(33, "com.huawei.hidisk.backup");
            put(34, "com.huawei.hidisk.backup");
            put(36, "com.huawei.hidisk.backup");
            put(41, "com.huawei.hidisk.backup");
            put(43, "com.huawei.hidisk.backup");
            put(44, "com.huawei.hidisk.backup");
            put(45, "com.huawei.hidisk.backup");
            put(46, "com.huawei.hidisk.backup");
            put(47, "com.huawei.hidisk.backup");
            put(48, "com.huawei.hidisk.backup");
        }
    };
    public static final int X_HW_CONTAIN_OH = 1;
    public static final int X_HW_CONTAIN_OH_3 = 3;
    public static final int X_HW_NOT_CONTAIN_OH = 0;
    protected int cmd;
    protected String info;

    public CBSBaseReq() {
    }

    public static String getCmdServicIdName(int i10) {
        HashMap<Integer, String> map = SERVICE_ID_NAME_MAP;
        return TextUtils.isEmpty(map.get(Integer.valueOf(i10))) ? "" : map.get(Integer.valueOf(i10));
    }

    public int getCmd() {
        return this.cmd;
    }

    public String getInfo() {
        return this.info;
    }

    public void setCmd(int i10) {
        this.cmd = i10;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public CBSBaseReq(int i10, String str) {
        this.cmd = i10;
        this.info = str;
    }
}
