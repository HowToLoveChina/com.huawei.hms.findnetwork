package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;

/* renamed from: com.huawei.hianalytics.e1 */
/* loaded from: classes5.dex */
public class C4750e1 {

    /* renamed from: a */
    public C4728a1 f21709a;

    /* renamed from: a */
    public String f21710a;

    /* renamed from: b */
    public C4728a1 f21711b;

    /* renamed from: b */
    public String f21712b;

    /* renamed from: c */
    public String f21713c;

    /* renamed from: d */
    public String f21714d;

    /* renamed from: e */
    public String f21715e;

    /* renamed from: a */
    public C4728a1 m28826a(String str) {
        if ("oper".equals(str)) {
            return this.f21711b;
        }
        if ("maint".equals(str)) {
            return this.f21709a;
        }
        HiLog.m28811sw("HAID", "wrong type");
        return null;
    }
}
