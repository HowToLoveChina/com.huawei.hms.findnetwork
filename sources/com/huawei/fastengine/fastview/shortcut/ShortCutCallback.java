package com.huawei.fastengine.fastview.shortcut;

/* loaded from: classes5.dex */
public interface ShortCutCallback {
    public static final int CREATE_FAIL_BIND_SERVICE = 4;
    public static final int CREATE_FAIL_ERROR = 3;
    public static final int CREATE_FAIL_NO_PERMISSION = 2;
    public static final int CREATE_FAIL_PARAMATER_ERROR = 1;
    public static final int CREATE_SUC = 0;
    public static final int CREATE_TIME_OUT = 6;
    public static final int SHORT_CUT_EXIST = 5;

    void onCreateShortCut(int i10);
}
