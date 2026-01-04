package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.ads.common.inter.LoaderCommonInter;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;

/* renamed from: com.huawei.openalliance.ad.ez */
/* loaded from: classes8.dex */
public class C7115ez implements LoaderCommonInter {

    /* renamed from: a */
    private static C7115ez f32761a;

    /* renamed from: c */
    private static final byte[] f32762c = new byte[0];

    /* renamed from: b */
    private Context f32763b;

    private C7115ez(Context context) {
        this.f32763b = context;
    }

    /* renamed from: a */
    public static C7115ez m43186a(Context context) {
        return m43187b(context);
    }

    /* renamed from: b */
    private static C7115ez m43187b(Context context) {
        C7115ez c7115ez;
        synchronized (f32762c) {
            try {
                if (f32761a == null) {
                    f32761a = new C7115ez(context);
                }
                c7115ez = f32761a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7115ez;
    }

    public boolean isTrustApp(String str, String str2) {
        return WhiteListPkgList.isTrustApp(this.f32763b, str, str2);
    }

    public void saveReportPoint(int i10, Integer num, Integer num2) {
        new C6922c(this.f32763b).mo39059a(i10, num, num2);
    }
}
