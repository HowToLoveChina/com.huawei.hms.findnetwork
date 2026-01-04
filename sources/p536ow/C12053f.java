package p536ow;

import com.huawei.hms.network.embedded.C5929g4;
import java.lang.reflect.Field;
import p692uw.C13267j;

/* renamed from: ow.f */
/* loaded from: classes9.dex */
public final class C12053f {
    /* renamed from: a */
    public static final void m72186a(int i10, int i11) {
        if (i11 <= i10) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i10 + ", got " + i11 + ". Please update the Kotlin standard library.").toString());
    }

    /* renamed from: b */
    public static final InterfaceC12052e m72187b(AbstractC12048a abstractC12048a) {
        return (InterfaceC12052e) abstractC12048a.getClass().getAnnotation(InterfaceC12052e.class);
    }

    /* renamed from: c */
    public static final int m72188c(AbstractC12048a abstractC12048a) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = abstractC12048a.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(abstractC12048a);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: d */
    public static final StackTraceElement m72189d(AbstractC12048a abstractC12048a) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        String strM72181c;
        C13267j.m79677e(abstractC12048a, "<this>");
        InterfaceC12052e interfaceC12052eM72187b = m72187b(abstractC12048a);
        if (interfaceC12052eM72187b == null) {
            return null;
        }
        m72186a(1, interfaceC12052eM72187b.m72185v());
        int iM72188c = m72188c(abstractC12048a);
        int i10 = iM72188c < 0 ? -1 : interfaceC12052eM72187b.m72183l()[iM72188c];
        String strM72192b = C12055h.f55805a.m72192b(abstractC12048a);
        if (strM72192b == null) {
            strM72181c = interfaceC12052eM72187b.m72181c();
        } else {
            strM72181c = strM72192b + C5929g4.f26852n + interfaceC12052eM72187b.m72181c();
        }
        return new StackTraceElement(strM72181c, interfaceC12052eM72187b.m72184m(), interfaceC12052eM72187b.m72182f(), i10);
    }
}
