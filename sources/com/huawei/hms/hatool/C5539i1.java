package com.huawei.hms.hatool;

import java.util.ArrayList;
import java.util.UUID;

/* renamed from: com.huawei.hms.hatool.i1 */
/* loaded from: classes8.dex */
public class C5539i1 {

    /* renamed from: a */
    private String f25212a;

    /* renamed from: b */
    private String f25213b;

    /* renamed from: c */
    private String f25214c;

    /* renamed from: d */
    private String f25215d;

    /* renamed from: e */
    private long f25216e;

    public C5539i1(String str, String str2, String str3, String str4, long j10) {
        this.f25212a = str;
        this.f25213b = str2;
        this.f25214c = str3;
        this.f25215d = str4;
        this.f25216e = j10;
    }

    /* renamed from: a */
    public void m32575a() {
        C5571v.m32792c("StreamEventHandler", "Begin to handle stream events...");
        C5518b1 c5518b1 = new C5518b1();
        c5518b1.m32455b(this.f25214c);
        c5518b1.m32459d(this.f25213b);
        c5518b1.m32452a(this.f25215d);
        c5518b1.m32457c(String.valueOf(this.f25216e));
        if ("oper".equals(this.f25213b) && AbstractC5579z.m32836i(this.f25212a, "oper")) {
            C5559p0 c5559p0M32824a = C5577y.m32822a().m32824a(this.f25212a, this.f25216e);
            String strM32687a = c5559p0M32824a.m32687a();
            Boolean boolValueOf = Boolean.valueOf(c5559p0M32824a.m32689b());
            c5518b1.m32461f(strM32687a);
            c5518b1.m32460e(String.valueOf(boolValueOf));
        }
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(c5518b1);
        new C5547l0(this.f25212a, this.f25213b, AbstractC5562q0.m32714g(), arrayList, strReplace).m32625a();
    }
}
