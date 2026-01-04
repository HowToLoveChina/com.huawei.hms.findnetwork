package mx;

import p409jx.EnumC10954c;
import p502nx.EnumC11761a;
import p502nx.EnumC11762b;
import p502nx.EnumC11764d;

/* renamed from: mx.a */
/* loaded from: classes9.dex */
public class C11541a extends AbstractC11555o {

    /* renamed from: b */
    public int f53498b;

    /* renamed from: c */
    public EnumC11762b f53499c;

    /* renamed from: d */
    public String f53500d;

    /* renamed from: e */
    public EnumC11761a f53501e;

    /* renamed from: f */
    public EnumC11764d f53502f;

    public C11541a() {
        m68966b(EnumC10954c.AES_EXTRA_DATA_RECORD);
        this.f53498b = 7;
        this.f53499c = EnumC11762b.TWO;
        this.f53500d = "AE";
        this.f53501e = EnumC11761a.KEY_STRENGTH_256;
        this.f53502f = EnumC11764d.DEFLATE;
    }

    /* renamed from: c */
    public EnumC11761a m68843c() {
        return this.f53501e;
    }

    /* renamed from: d */
    public EnumC11762b m68844d() {
        return this.f53499c;
    }

    /* renamed from: e */
    public EnumC11764d m68845e() {
        return this.f53502f;
    }

    /* renamed from: f */
    public int m68846f() {
        return this.f53498b;
    }

    /* renamed from: g */
    public String m68847g() {
        return this.f53500d;
    }

    /* renamed from: h */
    public void m68848h(EnumC11761a enumC11761a) {
        this.f53501e = enumC11761a;
    }

    /* renamed from: i */
    public void m68849i(EnumC11762b enumC11762b) {
        this.f53499c = enumC11762b;
    }

    /* renamed from: j */
    public void m68850j(EnumC11764d enumC11764d) {
        this.f53502f = enumC11764d;
    }

    /* renamed from: k */
    public void m68851k(int i10) {
        this.f53498b = i10;
    }

    /* renamed from: l */
    public void m68852l(String str) {
        this.f53500d = str;
    }
}
