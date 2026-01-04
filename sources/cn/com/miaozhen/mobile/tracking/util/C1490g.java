package cn.com.miaozhen.mobile.tracking.util;

import ijiami_release01.NCall;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: cn.com.miaozhen.mobile.tracking.util.g */
/* loaded from: classes.dex */
public class C1490g<K, V> {

    /* renamed from: a */
    private LinkedHashMap<K, V> f6370a;

    /* renamed from: b */
    private int f6371b;

    /* renamed from: cn.com.miaozhen.mobile.tracking.util.g$a */
    public class a extends LinkedHashMap<K, V> {

        /* renamed from: a */
        final /* synthetic */ int f6372a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i10, float f10, boolean z10, int i11) {
            super(i10, f10, z10);
            this.f6372a = i11;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry entry) {
            return NCall.m64619IZ(new Object[]{110, this, entry});
        }
    }

    public C1490g(int i10) {
        this.f6371b = i10;
        this.f6370a = new a(16, 0.75f, true, i10);
    }

    /* renamed from: a */
    public synchronized V m8462a(K k10) {
        return (V) NCall.m64616IL(new Object[]{111, this, k10});
    }

    /* renamed from: b */
    public synchronized V m8464b(K k10) {
        return (V) NCall.m64616IL(new Object[]{113, this, k10});
    }

    /* renamed from: a */
    public synchronized void m8463a(K k10, V v10) {
        NCall.m64618IV(new Object[]{112, this, k10, v10});
    }
}
