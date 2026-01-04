package com.huawei.android.hicloud.task.simple;

import com.huawei.android.hicloud.common.manager.DeviceSwitchQueryCallback;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import fk.C9721b;
import java.util.HashMap;
import p020ap.C1010e;
import p581qk.AbstractC12367d;

/* renamed from: com.huawei.android.hicloud.task.simple.i */
/* loaded from: classes3.dex */
public class C3041i extends AbstractC12367d {

    /* renamed from: a */
    public DeviceSwitchQueryCallback f13285a;

    /* renamed from: b */
    public String f13286b;

    /* renamed from: c */
    public String f13287c;

    /* renamed from: d */
    public String f13288d;

    public C3041i(String str, String str2, String str3, DeviceSwitchQueryCallback deviceSwitchQueryCallback) {
        this.f13285a = deviceSwitchQueryCallback;
        this.f13286b = str;
        this.f13287c = str2;
        this.f13288d = str3;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        String str = C1010e.m6125b().m6137c(this.f13287c, this.f13288d) ? JsbMapKeyNames.H5_TEXT_DOWNLOAD_OPEN : "close";
        HashMap map = new HashMap();
        map.put("phonefinder", str);
        map.put("result_status", "query_success");
        map.put("requestId", this.f13286b);
        map.put("deviceId", this.f13287c);
        this.f13285a.mo15609a(map);
    }
}
