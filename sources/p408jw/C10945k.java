package p408jw;

import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Events;
import java.io.Serializable;
import p692uw.C13264g;
import p692uw.C13267j;

/* renamed from: jw.k */
/* loaded from: classes9.dex */
public final class C10945k<T> implements Serializable {

    /* renamed from: a */
    public static final a f51855a = new a(null);

    /* renamed from: jw.k$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        public a() {
        }
    }

    /* renamed from: jw.k$b */
    public static final class b implements Serializable {

        /* renamed from: a */
        public final Throwable f51856a;

        public b(Throwable th2) {
            C13267j.m79677e(th2, TrackConstants$Events.EXCEPTION);
            this.f51856a = th2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && C13267j.m79673a(this.f51856a, ((b) obj).f51856a);
        }

        public int hashCode() {
            return this.f51856a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f51856a + C5929g4.f26850l;
        }
    }

    /* renamed from: b */
    public static <T> Object m66070b(Object obj) {
        return obj;
    }

    /* renamed from: c */
    public static final Throwable m66071c(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f51856a;
        }
        return null;
    }

    /* renamed from: d */
    public static final boolean m66072d(Object obj) {
        return obj instanceof b;
    }
}
