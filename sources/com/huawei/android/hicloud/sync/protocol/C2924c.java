package com.huawei.android.hicloud.sync.protocol;

import com.huawei.android.hicloud.security.bean.DataDecryptReq;
import fk.C9721b;
import fk.C9722c;
import gp.C10028c;
import p365ic.C10466a;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.sync.protocol.c */
/* loaded from: classes3.dex */
public class C2924c {

    /* renamed from: a */
    public String f12948a;

    /* renamed from: b */
    public String f12949b;

    /* renamed from: c */
    public int f12950c = -1;

    /* renamed from: d */
    public String f12951d;

    /* renamed from: e */
    public int f12952e;

    /* renamed from: f */
    public long f12953f;

    public C2924c() {
    }

    /* renamed from: a */
    public String m17741a() {
        return this.f12948a;
    }

    /* renamed from: b */
    public void m17742b(String str) throws C9722c {
        int iM62373p = C10028c.m62182c0().m62373p();
        if (iM62373p == 0) {
            this.f12948a = str;
            return;
        }
        if (iM62373p != 1) {
            return;
        }
        DataDecryptReq dataDecryptReq = new DataDecryptReq();
        dataDecryptReq.setSrcData(str);
        dataDecryptReq.setEdek(this.f12949b);
        try {
            String strM64316g = C10466a.m64316g(dataDecryptReq);
            this.f12948a = strM64316g;
            C11839m.m70686d("Data", "setDecryptedData: src data is " + strM64316g);
        } catch (C9721b e10) {
            String str2 = "Decrypt data fail, errorCode = " + e10.m60659c() + ", msg = " + e10.getMessage();
            C11839m.m70687e("Data", str2);
            throw new C9722c(2014, str2);
        }
    }

    /* renamed from: c */
    public void m17743c(String str) {
        this.f12949b = str;
    }

    /* renamed from: d */
    public void m17744d(int i10) {
        this.f12952e = i10;
    }

    /* renamed from: e */
    public void m17745e(long j10) {
        this.f12953f = j10;
    }

    /* renamed from: f */
    public void m17746f(int i10) {
        this.f12950c = i10;
    }

    /* renamed from: g */
    public void m17747g(String str) {
        this.f12951d = str;
    }

    public C2924c(String str) {
        this.f12948a = str;
    }
}
