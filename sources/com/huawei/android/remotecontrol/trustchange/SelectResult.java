package com.huawei.android.remotecontrol.trustchange;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class SelectResult {
    private static final String TAG = "SelectResult";

    @SerializedName("dbcontent")
    private String dbcontent = "";

    public boolean isMatchKey(String str) {
        String syncAccountUid;
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e(TAG, "isMatchKey input error");
            return false;
        }
        if (TextUtils.isEmpty(this.dbcontent)) {
            C13981a.m83988e(TAG, "isMatchKey dbcontent error");
            return false;
        }
        try {
            syncAccountUid = ((SelectInfo) new Gson().fromJson(this.dbcontent, SelectInfo.class)).getSyncAccountUid();
        } catch (JsonSyntaxException e10) {
            C13981a.m83988e(TAG, "isMatchKey error:" + e10.getMessage());
            syncAccountUid = "";
        }
        return TextUtils.equals(str, syncAccountUid);
    }
}
