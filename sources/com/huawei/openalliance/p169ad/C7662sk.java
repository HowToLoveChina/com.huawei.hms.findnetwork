package com.huawei.openalliance.p169ad;

import android.content.Context;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.sk */
/* loaded from: classes8.dex */
public class C7662sk {

    /* renamed from: a */
    private static List<Integer> f35677a = new ArrayList();

    /* renamed from: b */
    private static ConcurrentHashMap<Integer, SoftReference<InterfaceC7671st>> f35678b = new ConcurrentHashMap<>();

    static {
        f35677a.add(1);
        f35677a.add(-1);
        f35677a.add(60);
        f35677a.add(7);
        f35677a.add(3);
        f35677a.add(8);
        f35677a.add(9);
        f35677a.add(12);
        f35677a.add(13);
        f35677a.add(18);
        f35677a.add(2);
    }

    /* renamed from: a */
    public static InterfaceC7671st m47225a(Context context, int i10) {
        SoftReference<InterfaceC7671st> softReference = f35678b.get(Integer.valueOf(i10));
        InterfaceC7671st interfaceC7671st = softReference != null ? softReference.get() : null;
        if (interfaceC7671st != null) {
            return interfaceC7671st;
        }
        InterfaceC7671st interfaceC7671stM47227b = m47227b(context, i10);
        f35678b.put(Integer.valueOf(i10), new SoftReference<>(interfaceC7671stM47227b));
        return interfaceC7671stM47227b;
    }

    /* renamed from: b */
    private static InterfaceC7671st m47227b(Context context, int i10) {
        if (i10 == -1) {
            return new C7655sd(context);
        }
        if (i10 == 7) {
            return new C7667sp(context);
        }
        if (i10 != 18) {
            if (i10 == 60) {
                return new C7666so(context);
            }
            if (i10 != 1) {
                return i10 != 2 ? new C7665sn(context, i10) : new C7664sm(context);
            }
        }
        return new C7668sq(context, i10);
    }

    /* renamed from: a */
    public static void m47226a(Context context) {
        if (context == null) {
            return;
        }
        Iterator<Integer> it = f35677a.iterator();
        while (it.hasNext()) {
            m47225a(context, it.next().intValue()).mo47213b();
        }
    }
}
