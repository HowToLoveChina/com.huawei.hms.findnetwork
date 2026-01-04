package p852zq;

import com.huawei.location.base.activity.callback.ATCallback;

/* renamed from: zq.e */
/* loaded from: classes8.dex */
public final class C14364e<ATCallBackInfo> extends AbstractC14361b {

    /* renamed from: b */
    public static final byte[] f63716b = new byte[0];

    /* renamed from: c */
    public static volatile C14364e f63717c;

    /* renamed from: zq.e$a */
    public static class a extends C14362c {

        /* renamed from: c */
        public ATCallback f63718c;

        /* renamed from: e */
        public final ATCallback m85547e() {
            return this.f63718c;
        }

        public final boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if ((obj instanceof a) && this.f63718c.equals(((a) obj).f63718c)) {
                return true;
            }
            return super.equals(obj);
        }

        /* renamed from: f */
        public final void m85548f(ATCallback aTCallback) {
            this.f63718c = aTCallback;
        }

        public final int hashCode() {
            return super.hashCode();
        }
    }

    /* renamed from: f */
    public static C14364e m85546f() {
        if (f63717c == null) {
            synchronized (f63716b) {
                try {
                    if (f63717c == null) {
                        f63717c = new C14364e();
                    }
                } finally {
                }
            }
        }
        return f63717c;
    }

    @Override // p852zq.AbstractC14361b
    /* renamed from: b */
    public final String mo85535b() {
        return "ATCallBackManager";
    }
}
