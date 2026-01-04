package com.huawei.updatesdk.p191b.p196c;

import android.os.Build;
import android.text.TextUtils;
import java.util.List;

/* renamed from: com.huawei.updatesdk.b.c.c */
/* loaded from: classes9.dex */
public abstract class AbstractC8812c {

    /* renamed from: a */
    private String f45145a;

    /* renamed from: b */
    private String f45146b;

    /* renamed from: a */
    public abstract String mo56229a();

    /* renamed from: b */
    public abstract String mo56230b();

    /* renamed from: c */
    public abstract String mo56231c();

    /* renamed from: d */
    public String m56234d() {
        if (!TextUtils.isEmpty(this.f45146b)) {
            return this.f45146b;
        }
        String strMo56231c = mo56231c();
        this.f45146b = strMo56231c;
        if (TextUtils.isEmpty(strMo56231c)) {
            this.f45146b = Build.MANUFACTURER;
        }
        return this.f45146b;
    }

    /* renamed from: e */
    public String m56235e() {
        if (!TextUtils.isEmpty(this.f45145a)) {
            return this.f45145a;
        }
        String strMo56229a = mo56229a();
        this.f45145a = strMo56229a;
        if (TextUtils.isEmpty(strMo56229a) || TextUtils.equals(this.f45145a, "unknown")) {
            this.f45145a = Build.MODEL;
        }
        return this.f45145a;
    }

    /* renamed from: f */
    public abstract List<String> mo56232f();
}
