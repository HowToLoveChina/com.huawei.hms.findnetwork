package com.huawei.android.hicloud.sync.protocol;

import android.content.Intent;
import fk.C9722c;
import p015ak.C0213f;
import p514o9.C11839m;
import p664u0.C13108a;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;

/* renamed from: com.huawei.android.hicloud.sync.protocol.h */
/* loaded from: classes3.dex */
public class C2929h {
    /* renamed from: a */
    public static String m17766a() throws C9722c {
        try {
            return C13195l.m79272J().m79344y("RequestUtil", "");
        } catch (C13194k e10) {
            throw new C9722c(e10.m79269b(), "getAccessToken HmsException: " + e10.getMessage());
        } catch (C13199p e11) {
            C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED"));
            C11839m.m70687e("RequestUtil", "getAccessToken ST auth failed: " + e11.getMessage());
            throw new C9722c(2001, "getAccessToken ST auth failed: " + e11.getMessage());
        }
    }

    /* renamed from: b */
    public static String m17767b(String str) throws C9722c {
        try {
            return C13195l.m79272J().m79290C(str, "RequestUtil2", "");
        } catch (C13194k e10) {
            throw new C9722c(e10.m79269b(), "getAccessToken Exception: " + e10.getMessage());
        } catch (C13199p e11) {
            C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED"));
            C11839m.m70687e("RequestUtil", "getAccessToken auth failed: " + e11.getMessage());
            throw new C9722c(2001, "getAccessToken auth failed: " + e11.getMessage());
        }
    }
}
