package com.huawei.appgallery.marketinstallerservice.p094a.p095e;

import android.content.Context;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.InstallerNetTransmission;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.RequestBean;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.ResponseBean;
import p492nh.C11705a;
import p578qh.C12355a;
import p578qh.C12358d;

/* renamed from: com.huawei.appgallery.marketinstallerservice.a.e.a */
/* loaded from: classes4.dex */
public class C4570a extends RequestBean {
    public static final String METHOD = "client.getMarketInfo";

    @InstallerNetTransmission
    private String marketPkg;

    @InstallerNetTransmission
    private String resolution;

    @InstallerNetTransmission
    private String version;

    public C4570a() {
    }

    public static C4570a newInstance(Context context) {
        C4570a c4570a = new C4570a(context);
        c4570a.setMethod("client.getMarketInfo");
        c4570a.version = C12358d.m74384a(context);
        c4570a.resolution = C12355a.m74366f(context);
        return c4570a;
    }

    public String getMarketPkg() {
        return this.marketPkg;
    }

    public String getResolution() {
        return this.resolution;
    }

    @Override // com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.RequestBean
    public ResponseBean getResponseBean() {
        return new C11705a();
    }

    public String getVersion() {
        return this.version;
    }

    public void setMarketPkg(String str) {
        this.marketPkg = str;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public C4570a(Context context) {
        super(context);
    }
}
