package com.huawei.cloud.pay.model;

import android.text.TextUtils;
import com.huawei.android.hicloud.agd.ads.DeviceInfo;
import com.huawei.android.hicloud.agd.ads.NetworkInfo;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import java.util.List;
import p709vj.C13452e;

/* loaded from: classes5.dex */
public class AdAppsReportReq extends Request {
    public static final int REQUEST_CHANNEL_DEFAULT = 1;
    private List<AdAppInfo> appList;
    private DeviceInfo deviceInfo;
    private NetworkInfo networkInfo;
    private String requestId;

    public static class AdAppInfo {
        private int channel = 1;
        private long exposureTime;
        private String packageName;

        public AdAppInfo(String str, long j10) {
            this.packageName = str;
            this.exposureTime = j10;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }
    }

    public AdAppsReportReq(String str, List<AdAppInfo> list, String str2) {
        super(str);
        this.appList = list;
        this.requestId = str2;
        this.deviceInfo = new DeviceInfo();
        this.networkInfo = new NetworkInfo();
        String oaid = AdSwitchManager.getInstance().getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            this.deviceInfo.setOaid(oaid);
        }
        String strM80958q = C13452e.m80781L().m80958q();
        if (TextUtils.isEmpty(strM80958q)) {
            return;
        }
        this.deviceInfo.setVudid(strM80958q);
    }

    public List<AdAppInfo> getAppList() {
        return this.appList;
    }

    public void setAppList(List<AdAppInfo> list) {
        this.appList = list;
    }
}
