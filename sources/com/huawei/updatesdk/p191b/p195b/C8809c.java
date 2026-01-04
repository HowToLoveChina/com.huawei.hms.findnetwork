package com.huawei.updatesdk.p191b.p195b;

import android.content.Context;
import android.os.Build;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.C8800c;
import com.huawei.updatesdk.p191b.p196c.AbstractC8812c;
import com.huawei.updatesdk.p191b.p196c.C8811b;
import com.huawei.updatesdk.p191b.p201h.C8833a;
import com.huawei.updatesdk.service.appmgr.bean.SDKNetTransmission;

/* renamed from: com.huawei.updatesdk.b.b.c */
/* loaded from: classes9.dex */
public class C8809c extends C8800c {

    @SDKNetTransmission
    private String brand;

    @SDKNetTransmission
    private String buildNumber;

    @SDKNetTransmission
    private String density;

    @SDKNetTransmission
    private int emuiApiLevel;

    @SDKNetTransmission
    protected String firmwareVersion;

    @SDKNetTransmission
    private int harmonyApiLevel;

    @SDKNetTransmission
    private int magicApiLevel;

    @SDKNetTransmission
    private String magicVer;

    @SDKNetTransmission
    private String manufacturer;

    @SDKNetTransmission
    private int odm;

    @SDKNetTransmission
    private String osBrand;

    @SDKNetTransmission
    private String phoneType;

    @SDKNetTransmission
    private String resolution;

    @SDKNetTransmission
    private String sdkVersion;

    /* renamed from: ts */
    @SDKNetTransmission
    private long f45142ts;

    public C8809c() {
        Context contextM56133a = C8793a.m56132c().m56133a();
        this.f45142ts = System.currentTimeMillis();
        this.firmwareVersion = Build.VERSION.RELEASE.trim();
        this.buildNumber = C8789c.m56100d();
        AbstractC8812c abstractC8812cM56233a = C8811b.m56233a();
        this.phoneType = abstractC8812cM56233a.m56235e();
        this.density = C8789c.m56103e(contextM56133a);
        this.resolution = C8789c.m56101d(contextM56133a);
        this.emuiApiLevel = C8833a.m56305f().m56308a();
        this.manufacturer = abstractC8812cM56233a.m56234d();
        this.brand = C8789c.f45088d;
        this.odm = C8789c.f45092h ? 1 : 0;
        this.sdkVersion = "5.0.1.300";
        this.harmonyApiLevel = C8789c.f45093i;
        this.osBrand = C8789c.f45094j;
        this.magicApiLevel = C8833a.m56305f().m56309b();
        this.magicVer = C8833a.m56305f().m56310c();
    }
}
