package p852zq;

import com.huawei.location.base.activity.callback.ARCallback;

/* renamed from: zq.j */
/* loaded from: classes8.dex */
public final class C14369j<ARCallBackInfo> extends AbstractC14361b {

    /* renamed from: b */
    public static final byte[] f63731b = new byte[0];

    /* renamed from: c */
    public static volatile C14369j f63732c;

    /* renamed from: zq.j$a */
    public static class a extends C14362c {

        /* renamed from: c */
        public ARCallback f63733c;

        /* renamed from: e */
        public final ARCallback m85557e() {
            return this.f63733c;
        }

        public final boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if ((obj instanceof a) && this.f63733c.equals(((a) obj).f63733c)) {
                return true;
            }
            return super.equals(obj);
        }

        /* renamed from: f */
        public final void m85558f(ARCallback aRCallback) {
            this.f63733c = aRCallback;
        }

        public final int hashCode() {
            return super.hashCode();
        }
    }

    /* renamed from: f */
    public static C14369j m85556f() {
        if (f63732c == null) {
            synchronized (f63731b) {
                try {
                    if (f63732c == null) {
                        f63732c = new C14369j();
                    }
                } finally {
                }
            }
        }
        return f63732c;
    }

    @Override // p852zq.AbstractC14361b
    /* renamed from: b */
    public final String mo85535b() {
        return "ARCallbackManager";
    }
}
