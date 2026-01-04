package p789xv;

import p374iv.C10626e;
import p535ov.InterfaceC12043j;

/* renamed from: xv.b */
/* loaded from: classes9.dex */
public class C13868b {
    /* renamed from: a */
    public static void m83204a(InterfaceC12043j interfaceC12043j) throws C10626e {
        int iMin = interfaceC12043j.min();
        int iMax = interfaceC12043j.max();
        if (iMin < 0) {
            throw new C10626e("min can't be negative");
        }
        if (iMax < 0) {
            throw new C10626e("max can't be negative");
        }
        if (iMax < iMin) {
            throw new C10626e("max should be bigger than min");
        }
    }
}
