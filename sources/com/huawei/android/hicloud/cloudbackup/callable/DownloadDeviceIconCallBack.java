package com.huawei.android.hicloud.cloudbackup.callable;

import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.hicloud.download.C4896a;
import java.util.HashMap;
import okhttp3.HttpResponseBuilder;
import p399jk.AbstractC10896a;
import p626ry.C12652a;
import p626ry.C12653b;

/* loaded from: classes2.dex */
public class DownloadDeviceIconCallBack extends C4896a {
    private static final String TAG = "DownloadFileToLocalPathCallback";
    private HashMap<String, String> deviceMap;
    private String terminalType;

    public DownloadDeviceIconCallBack(String str, long j10) {
        super(str, j10);
    }

    public DownloadDeviceIconCallBack(String str, String str2, long j10, HashMap<String, String> map, String str3) {
        super(str, str2, j10);
        this.deviceMap = map;
        this.terminalType = str3;
    }

    @Override // com.huawei.hicloud.download.C4896a, com.huawei.hicloud.okhttp.callback.AbstractC4975a
    public Void onResponse(HttpResponseBuilder HttpResponseBuilder) throws Throwable {
        super.onResponse(HttpResponseBuilder);
        AbstractC10896a.m65887i(TAG, "DownloadDeviceIconCallBack completed successfully.");
        if (C12653b.m76182b(this.terminalType) || C12652a.m76180b(this.deviceMap)) {
            return null;
        }
        DeviceIconManager.getInstance().updateCacheValidity(this.terminalType);
        this.deviceMap.remove(this.terminalType);
        if (!this.deviceMap.isEmpty()) {
            return null;
        }
        AbstractC10896a.m65887i(TAG, "send message.");
        Message messageObtain = Message.obtain();
        messageObtain.what = 33055;
        CBCallBack.getInstance().sendMessage(messageObtain);
        return null;
    }
}
