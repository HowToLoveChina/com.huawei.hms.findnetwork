package com.huawei.android.hicloud.cloudbackup.process.util;

import java.io.File;
import p015ak.C0209d;

/* loaded from: classes2.dex */
public class BackupRestoreConstans {
    public static final String DATA_OWNER_PATH = "/data/user/0/";
    public static final String DATA_PATH = "/data/data/";
    public static final String DATA_USER_PATH = "/data/user/";
    private static final String TAG = "BackupRestoreConstans";

    private BackupRestoreConstans() {
    }

    public static String getDataPathByUid(String str, int i10) {
        StringBuffer stringBuffer = new StringBuffer(DATA_USER_PATH);
        stringBuffer.append(i10);
        stringBuffer.append(File.separator);
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static String getDefaultDataPath(String str) {
        return getDefaultDataPath(str, C0209d.m1222X());
    }

    public static String getUserPath() {
        return DATA_USER_PATH + C0209d.m1222X();
    }

    public static String getDefaultDataPath(String str, int i10) {
        StringBuffer stringBuffer = new StringBuffer(DATA_USER_PATH);
        stringBuffer.append(i10);
        stringBuffer.append(File.separator);
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static String getUserPath(int i10) {
        return DATA_USER_PATH + i10;
    }
}
