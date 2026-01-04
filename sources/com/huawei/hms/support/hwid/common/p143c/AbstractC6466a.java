package com.huawei.hms.support.hwid.common.p143c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.hwid.common.p146e.C6473c;
import com.huawei.hms.support.hwid.common.p146e.C6477g;
import com.huawei.hms.support.hwid.common.p146e.C6480j;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;

/* renamed from: com.huawei.hms.support.hwid.common.c.a */
/* loaded from: classes8.dex */
public abstract class AbstractC6466a {

    /* renamed from: d */
    protected String f30011d;

    /* renamed from: f */
    private String f30013f;

    /* renamed from: a */
    protected int f30008a = 200;

    /* renamed from: b */
    protected int f30009b = -1;

    /* renamed from: c */
    protected int f30010c = -1;

    /* renamed from: e */
    private int f30012e = 0;

    /* renamed from: g */
    private a f30014g = a.XMLType;

    /* renamed from: com.huawei.hms.support.hwid.common.c.a$a */
    public enum a {
        XMLType,
        URLType,
        JSONType,
        Stream,
        FileType
    }

    /* renamed from: a */
    public abstract String mo36846a();

    /* renamed from: a */
    public abstract String mo36847a(Context context);

    /* renamed from: a */
    public void m36848a(String str, int i10) {
        this.f30012e = i10;
        String strMo36846a = mo36846a();
        String str2 = "https://" + str + "/AccountServer";
        C6477g.m36904a("HttpRequest", "setGlobalSiteId, AsUrl::=" + str2, false);
        this.f30013f = str2 + strMo36846a;
        int i11 = this.f30012e;
        this.f30013f = C6480j.m36912a(this.f30013f, new String[]{"\\{0\\}", (i11 < 1 || i11 > 999) ? "" : String.valueOf(i10)});
        C6477g.m36904a("HttpRequest", "Set mGlobalHostUrl::=" + this.f30013f, false);
    }

    /* renamed from: b */
    public Bundle mo36849b() {
        return m36850c();
    }

    /* renamed from: c */
    public Bundle m36850c() {
        Bundle bundle = new Bundle();
        bundle.putInt("responseCode", this.f30008a);
        bundle.putInt(MapKeyNames.RESULT_CODE, this.f30009b);
        bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, this.f30010c);
        bundle.putString("errorDesc", this.f30011d);
        return bundle;
    }

    /* renamed from: d */
    public String m36851d() {
        if (TextUtils.isEmpty(this.f30013f)) {
            return mo36846a() + "?Version=66300&cVersion=" + C6473c.m36870a();
        }
        return this.f30013f + "?Version=66300&cVersion=" + C6473c.m36870a();
    }
}
