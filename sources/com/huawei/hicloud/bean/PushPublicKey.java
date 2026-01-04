package com.huawei.hicloud.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;

/* loaded from: classes6.dex */
public class PushPublicKey {

    @SerializedName(PowerKitApplyUtil.GROUP_ALBUM)
    private String album;

    @SerializedName("sync")
    private String sync;

    @SerializedName("syncV2")
    private String syncV2;

    private String getStringPrint(String str, String str2) {
        return (TextUtils.isEmpty(str) || str.length() <= 7) ? str2 : str.substring(str.length() - 7);
    }

    public String getAlbum() {
        return this.album;
    }

    public String getSync() {
        return this.sync;
    }

    public String getSyncV2() {
        return this.syncV2;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public void setSync(String str) {
        this.sync = str;
    }

    public void setSyncV2(String str) {
        this.syncV2 = str;
    }

    public String toString() {
        String str = this.sync;
        String stringPrint = getStringPrint(str, str);
        String str2 = this.syncV2;
        String stringPrint2 = getStringPrint(str2, str2);
        String str3 = this.album;
        return "PushPublicKey { sync: " + stringPrint + ", syncV2: " + stringPrint2 + ", album: " + getStringPrint(str3, str3) + "}";
    }
}
