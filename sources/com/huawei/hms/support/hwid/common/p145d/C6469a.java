package com.huawei.hms.support.hwid.common.p145d;

import android.content.Context;

/* renamed from: com.huawei.hms.support.hwid.common.d.a */
/* loaded from: classes8.dex */
public class C6469a extends C6470b {

    /* renamed from: a */
    private static C6469a f30043a;

    public C6469a(Context context, String str) {
        super(context, str);
    }

    /* renamed from: a */
    public static C6469a m36860a(Context context) {
        if (f30043a == null) {
            synchronized (C6469a.class) {
                try {
                    if (f30043a == null) {
                        f30043a = new C6469a(context, "SiteDomain");
                    }
                } finally {
                }
            }
        }
        return f30043a;
    }
}
