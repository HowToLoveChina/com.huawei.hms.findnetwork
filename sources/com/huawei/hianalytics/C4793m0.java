package com.huawei.hianalytics;

import android.content.Context;

/* renamed from: com.huawei.hianalytics.m0 */
/* loaded from: classes5.dex */
public class C4793m0 {

    /* renamed from: a */
    public static C4793m0 f21878a;

    /* renamed from: a */
    public Context f21879a;

    /* renamed from: com.huawei.hianalytics.m0$a */
    public static class a extends AbstractC4795n0 {

        /* renamed from: a */
        public String f21880a;

        /* renamed from: b */
        public String f21881b;

        public a(String str, String str2) {
            this.f21880a = str;
            this.f21881b = str2;
        }

        @Override // com.huawei.hianalytics.AbstractC4795n0
        /* renamed from: a */
        public int mo28968a() {
            C4731b1 c4731b1M28901a = C4785j.m28901a(this.f21880a, this.f21881b);
            int i10 = 0;
            int i11 = (c4731b1M28901a == null || !c4731b1M28901a.f21661c) ? 0 : 4;
            C4731b1 c4731b1M28901a2 = C4785j.m28901a(this.f21880a, this.f21881b);
            int i12 = i11 | ((c4731b1M28901a2 == null || !c4731b1M28901a2.f21657a) ? 0 : 2);
            C4731b1 c4731b1M28901a3 = C4785j.m28901a(this.f21880a, this.f21881b);
            if (c4731b1M28901a3 != null && c4731b1M28901a3.f21659b) {
                i10 = 1;
            }
            return i12 | i10;
        }
    }

    /* renamed from: a */
    public static C4793m0 m28967a() {
        C4793m0 c4793m0;
        synchronized (C4793m0.class) {
            try {
                if (f21878a == null) {
                    f21878a = new C4793m0();
                }
                c4793m0 = f21878a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c4793m0;
    }
}
