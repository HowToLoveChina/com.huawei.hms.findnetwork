package com.huawei.wearengine.p2p;

import java.io.File;
import p558pu.C12227b;

/* renamed from: com.huawei.wearengine.p2p.a */
/* loaded from: classes9.dex */
public class C8902a {

    /* renamed from: a */
    public String f45338a;

    /* renamed from: b */
    public byte[] f45339b;

    /* renamed from: c */
    public File f45340c;

    /* renamed from: d */
    public boolean f45341d;

    /* renamed from: com.huawei.wearengine.p2p.a$a */
    public static class a {

        /* renamed from: a */
        public String f45342a;

        /* renamed from: b */
        public byte[] f45343b;

        /* renamed from: c */
        public File f45344c;

        /* renamed from: d */
        public int f45345d = 0;

        /* renamed from: e */
        public boolean f45346e = true;

        /* renamed from: c */
        public C8902a m56596c() {
            return new C8902a(this);
        }

        /* renamed from: e */
        public a m56597e(File file) {
            int i10 = this.f45345d;
            if (i10 != 0 && i10 != 2) {
                throw new C12227b(5);
            }
            this.f45344c = file;
            this.f45345d = 2;
            return this;
        }

        /* renamed from: f */
        public a m56598f(byte[] bArr) {
            int i10 = this.f45345d;
            if (i10 != 0 && i10 != 1) {
                throw new C12227b(5);
            }
            this.f45343b = bArr == null ? null : (byte[]) bArr.clone();
            this.f45345d = 1;
            return this;
        }
    }

    public C8902a(a aVar) {
        this.f45338a = aVar.f45342a;
        this.f45339b = aVar.f45343b;
        this.f45340c = aVar.f45344c;
        this.f45341d = aVar.f45346e;
    }

    /* renamed from: a */
    public byte[] m56588a() {
        byte[] bArr = this.f45339b;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    /* renamed from: b */
    public String m56589b() {
        return this.f45338a;
    }

    /* renamed from: c */
    public File m56590c() {
        return this.f45340c;
    }

    /* renamed from: d */
    public int m56591d() {
        if (this.f45339b != null) {
            return 1;
        }
        return this.f45340c != null ? 2 : 0;
    }

    /* renamed from: e */
    public boolean m56592e() {
        return this.f45341d;
    }
}
