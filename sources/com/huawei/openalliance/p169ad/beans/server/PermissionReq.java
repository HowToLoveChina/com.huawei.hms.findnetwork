package com.huawei.openalliance.p169ad.beans.server;

import android.content.Context;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import com.huawei.openalliance.p169ad.beans.base.ReqBean;
import com.huawei.openalliance.p169ad.constant.Config;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7732af;
import com.huawei.openalliance.p169ad.utils.C7845x;

@DataKeep
/* loaded from: classes8.dex */
public class PermissionReq extends ReqBean {
    private int appType;
    private String appcountry;
    private String applang;
    private String devcountry;
    private int deviceType;
    private String devlang;
    private String model;

    @InterfaceC6932d(m39225a = "app")
    private String packageName;
    private String sdkver;
    private String ver;

    public PermissionReq() {
        this.ver = Constants.INTER_VERSION;
        this.sdkver = Config.SDK_VERSION;
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: a */
    public String mo39254a() {
        return Constants.PERMISSION_SERVER_REALM;
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: b */
    public String mo39256b() {
        return Constants.PERMISSION_SERVER_REQ_URI;
    }

    public PermissionReq(String str, String str2, String str3, int i10, int i11) {
        this.ver = Constants.INTER_VERSION;
        this.sdkver = Config.SDK_VERSION;
        this.packageName = str;
        this.applang = str2;
        this.appcountry = str3;
        this.devlang = AbstractC7807d.m48204a();
        this.devcountry = AbstractC7811dd.m48322d();
        this.appType = i10;
        this.deviceType = i11;
        this.model = C7845x.m48538b();
    }

    @Override // com.huawei.openalliance.p169ad.beans.base.ReqBean
    /* renamed from: a */
    public String mo39255a(Context context) {
        return context.getString(C7732af.m47471a() ? C6849R.string.hiad_acd_backup_sig : C6849R.string.hiad_acd_server_sig);
    }
}
