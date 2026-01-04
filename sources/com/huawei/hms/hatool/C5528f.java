package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.f */
/* loaded from: classes8.dex */
public class C5528f implements InterfaceRunnableC5531g {

    /* renamed from: a */
    private byte[] f25175a;

    /* renamed from: b */
    private String f25176b;

    /* renamed from: c */
    private String f25177c;

    /* renamed from: d */
    private String f25178d;

    /* renamed from: e */
    private String f25179e;

    /* renamed from: f */
    private List<C5518b1> f25180f;

    public C5528f(byte[] bArr, String str, String str2, String str3, String str4, List<C5518b1> list) {
        this.f25175a = (byte[]) bArr.clone();
        this.f25176b = str;
        this.f25177c = str2;
        this.f25179e = str3;
        this.f25178d = str4;
        this.f25180f = list;
    }

    /* renamed from: a */
    private C5553n0 m32508a(Map<String, String> map) {
        return AbstractC5573w.m32799a(this.f25176b, this.f25175a, map);
    }

    /* renamed from: b */
    private void m32510b() {
        C5517b0.m32449c().m32450a(new C5524d1(this.f25180f, this.f25177c, this.f25178d, this.f25179e));
    }

    @Override // java.lang.Runnable
    public void run() {
        C5571v.m32786a("hmsSdk", "send data running");
        int iM32656b = m32508a(m32509a()).m32656b();
        if (iM32656b != 200) {
            m32510b();
            return;
        }
        C5571v.m32790b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f25178d, this.f25179e, this.f25177c, Integer.valueOf(iM32656b));
    }

    /* renamed from: a */
    private Map<String, String> m32509a() {
        return C5543k.m32600b(this.f25177c, this.f25179e, this.f25178d);
    }
}
