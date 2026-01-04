package p238dv;

import p535ov.InterfaceC12040g;
import p535ov.InterfaceC12042i;

/* renamed from: dv.c */
/* loaded from: classes9.dex */
public class C9313c {

    /* renamed from: a */
    @InterfaceC12042i
    @InterfaceC12040g
    public String f46675a;

    /* renamed from: b */
    public int f46676b;

    /* renamed from: c */
    @InterfaceC12042i
    public EnumC9316f f46677c;

    /* renamed from: d */
    public boolean f46678d;

    /* renamed from: dv.c$a */
    public static class a {

        /* renamed from: a */
        public String f46679a;

        /* renamed from: b */
        public int f46680b;

        /* renamed from: c */
        public EnumC9316f f46681c;

        /* renamed from: d */
        public boolean f46682d = true;

        /* renamed from: a */
        public a m58630a(String str) {
            this.f46679a = str;
            return this;
        }

        /* renamed from: b */
        public C9313c m58631b() {
            return new C9313c(this.f46679a, this.f46680b, this.f46681c, this.f46682d);
        }

        /* renamed from: c */
        public a m58632c(int i10) {
            this.f46680b = i10;
            return this;
        }

        /* renamed from: d */
        public a m58633d(EnumC9316f enumC9316f) {
            this.f46681c = enumC9316f;
            return this;
        }
    }

    public C9313c(String str, int i10, EnumC9316f enumC9316f) {
        this(str, i10, enumC9316f, true);
    }

    /* renamed from: a */
    public String m58626a() {
        return this.f46675a;
    }

    /* renamed from: b */
    public int m58627b() {
        return this.f46676b;
    }

    /* renamed from: c */
    public EnumC9316f m58628c() {
        return this.f46677c;
    }

    /* renamed from: d */
    public boolean m58629d() {
        return this.f46678d;
    }

    public C9313c(String str, int i10, EnumC9316f enumC9316f, boolean z10) {
        this.f46675a = str;
        this.f46676b = i10;
        this.f46677c = enumC9316f;
        this.f46678d = z10;
    }
}
