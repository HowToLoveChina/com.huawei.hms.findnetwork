package com.huawei.cloud.pay.model;

import android.text.TextUtils;
import com.huawei.android.hicloud.agd.ads.DeviceInfo;
import com.huawei.android.hicloud.agd.ads.NetworkInfo;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import p709vj.C13452e;

/* loaded from: classes5.dex */
public class AdAppsQueryReq extends Request {
    private AdAppRequestInfo appRequest;
    private DeviceInfo deviceInfo;
    private NetworkInfo networkInfo;
    private String requestId;

    public class AdAppRequestInfo {
        private int begin;
        private int channel;
        private int end;

        public AdAppRequestInfo(int i10, int i11, int i12) {
            this.begin = i10;
            this.end = i11;
            this.channel = i12;
        }
    }

    public AdAppsQueryReq(String str, int i10, int i11, int i12, String str2) {
        super(str);
        this.requestId = str2;
        this.networkInfo = new NetworkInfo();
        this.deviceInfo = new DeviceInfo();
        this.appRequest = new AdAppRequestInfo(i10, i11, i12);
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
}
