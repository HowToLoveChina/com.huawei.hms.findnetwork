package p381j1;

import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import p244e1.C9378b;
import p323h1.C10077a;
import p354i1.InterfaceC10408t;

/* renamed from: j1.g */
/* loaded from: classes.dex */
public class C10657g implements InterfaceC10686t0, InterfaceC10408t {

    /* renamed from: a */
    public static final C10657g f51253a = new C10657g();

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.util.concurrent.atomic.AtomicLongArray] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.util.concurrent.atomic.AtomicIntegerArray] */
    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        if (c10077a.f49153f.mo62768a0() == 8) {
            c10077a.f49153f.mo62756D(16);
            return null;
        }
        C9378b c9378b = new C9378b();
        c10077a.m62717X(c9378b);
        int i10 = 0;
        if (type == AtomicIntegerArray.class) {
            ?? r32 = (T) new AtomicIntegerArray(c9378b.size());
            while (i10 < c9378b.size()) {
                r32.set(i10, c9378b.m58781F(i10).intValue());
                i10++;
            }
            return r32;
        }
        ?? r33 = (T) new AtomicLongArray(c9378b.size());
        while (i10 < c9378b.size()) {
            r33.set(i10, c9378b.m58782G(i10).longValue());
            i10++;
        }
        return r33;
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 14;
    }

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IOException {
        C10650d1 c10650d1 = c10664i0.f51258k;
        if (obj instanceof AtomicInteger) {
            c10650d1.m65219X(((AtomicInteger) obj).get());
            return;
        }
        if (obj instanceof AtomicLong) {
            c10650d1.m65221Z(((AtomicLong) obj).get());
            return;
        }
        if (obj instanceof AtomicBoolean) {
            c10650d1.append(((AtomicBoolean) obj).get() ? FaqConstants.DISABLE_HA_REPORT : "false");
            return;
        }
        if (obj == null) {
            c10650d1.m65226c0(EnumC10653e1.WriteNullListAsEmpty);
            return;
        }
        int i11 = 0;
        if (obj instanceof AtomicIntegerArray) {
            AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
            int length = atomicIntegerArray.length();
            c10650d1.write(91);
            while (i11 < length) {
                int i12 = atomicIntegerArray.get(i11);
                if (i11 != 0) {
                    c10650d1.write(44);
                }
                c10650d1.m65219X(i12);
                i11++;
            }
            c10650d1.write(93);
            return;
        }
        AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
        int length2 = atomicLongArray.length();
        c10650d1.write(91);
        while (i11 < length2) {
            long j10 = atomicLongArray.get(i11);
            if (i11 != 0) {
                c10650d1.write(44);
            }
            c10650d1.m65221Z(j10);
            i11++;
        }
        c10650d1.write(93);
    }
}
