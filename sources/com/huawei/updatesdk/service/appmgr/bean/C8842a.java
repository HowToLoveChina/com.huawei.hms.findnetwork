package com.huawei.updatesdk.service.appmgr.bean;

import android.content.Context;
import android.os.Build;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8790d;
import com.huawei.updatesdk.p177a.p178a.p183d.p185j.C8792a;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p191b.p195b.C8809c;

/* renamed from: com.huawei.updatesdk.service.appmgr.bean.a */
/* loaded from: classes9.dex */
public class C8842a extends C8809c {
    public static final String APIMETHOD = "client.getMarketInfo";

    @SDKNetTransmission
    private int deviceType;

    @SDKNetTransmission
    private int international;

    @SDKNetTransmission
    private String lang;

    @SDKNetTransmission
    private String marketPkg;

    @SDKNetTransmission
    private int net;

    @SDKNetTransmission
    private int sysBits;

    @SDKNetTransmission
    private String version;

    @SDKNetTransmission
    private String subsystem = "updatesdk";

    @SDKNetTransmission
    private String code = "0200";

    public C8842a(String str) {
        m56169a("client.getMarketInfo");
        this.marketPkg = str;
        this.sysBits = C8789c.m56112j();
        this.lang = C8789c.m56106g();
        m56171b("8.0");
        Context contextM56133a = C8793a.m56132c().m56133a();
        this.version = C8789c.m56107g(contextM56133a);
        this.deviceType = C8789c.m56102e();
        this.international = C8790d.m56123a();
        this.net = C8792a.m56129c(contextM56133a);
        this.firmwareVersion = String.valueOf(Build.VERSION.SDK_INT);
    }
}
