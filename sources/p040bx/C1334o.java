package p040bx;

import com.huawei.hms.network.embedded.C5929g4;
import p408jw.C10951q;
import p692uw.C13267j;
import tw.InterfaceC13086l;

/* renamed from: bx.o */
/* loaded from: classes9.dex */
public final class C1334o {

    /* renamed from: a */
    public final Object f5833a;

    /* renamed from: b */
    public final InterfaceC13086l<Throwable, C10951q> f5834b;

    /* JADX WARN: Multi-variable type inference failed */
    public C1334o(Object obj, InterfaceC13086l<? super Throwable, C10951q> interfaceC13086l) {
        this.f5833a = obj;
        this.f5834b = interfaceC13086l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1334o)) {
            return false;
        }
        C1334o c1334o = (C1334o) obj;
        return C13267j.m79673a(this.f5833a, c1334o.f5833a) && C13267j.m79673a(this.f5834b, c1334o.f5834b);
    }

    public int hashCode() {
        Object obj = this.f5833a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f5834b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f5833a + ", onCancellation=" + this.f5834b + C5929g4.f26850l;
    }
}
