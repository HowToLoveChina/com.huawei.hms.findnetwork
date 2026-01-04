package com.huawei.hmf.tasks.p108a;

import android.app.Activity;
import android.app.Fragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import p208cq.InterfaceC8935c;

/* renamed from: com.huawei.hmf.tasks.a.g */
/* loaded from: classes8.dex */
public class FragmentC5036g extends Fragment {

    /* renamed from: b */
    public static final WeakHashMap<Activity, WeakReference<FragmentC5036g>> f23022b = new WeakHashMap<>();

    /* renamed from: a */
    public final List<WeakReference<InterfaceC8935c<?>>> f23023a = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m30076a(android.app.Activity r6, p208cq.InterfaceC8935c r7) {
        /*
            java.lang.String r0 = "LifecycleCallbackFrg"
            java.lang.String r1 = "com.huawei.hmf.tasks.lifecycle_fragment_tag"
            java.util.WeakHashMap<android.app.Activity, java.lang.ref.WeakReference<com.huawei.hmf.tasks.a.g>> r2 = com.huawei.hmf.tasks.p108a.FragmentC5036g.f23022b
            java.lang.Object r2 = r2.get(r6)
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
            if (r2 == 0) goto L1c
            java.lang.Object r3 = r2.get()
            if (r3 == 0) goto L1c
            java.lang.Object r6 = r2.get()
            com.huawei.hmf.tasks.a.g r6 = (com.huawei.hmf.tasks.p108a.FragmentC5036g) r6
            goto L82
        L1c:
            android.app.FragmentManager r2 = r6.getFragmentManager()
            r3 = 0
            android.app.Fragment r4 = r2.findFragmentByTag(r1)     // Catch: java.lang.ClassCastException -> L68
            com.huawei.hmf.tasks.a.g r4 = (com.huawei.hmf.tasks.p108a.FragmentC5036g) r4     // Catch: java.lang.ClassCastException -> L68
            if (r4 != 0) goto L5b
            com.huawei.hmf.tasks.a.g r5 = new com.huawei.hmf.tasks.a.g     // Catch: java.lang.Exception -> L3e
            r5.<init>()     // Catch: java.lang.Exception -> L3e
            android.app.FragmentTransaction r2 = r2.beginTransaction()     // Catch: java.lang.Exception -> L3b
            android.app.FragmentTransaction r1 = r2.add(r5, r1)     // Catch: java.lang.Exception -> L3b
            r1.commitAllowingStateLoss()     // Catch: java.lang.Exception -> L3b
            r3 = r5
            goto L5c
        L3b:
            r1 = move-exception
            r3 = r5
            goto L3f
        L3e:
            r1 = move-exception
        L3f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.ClassCastException -> L58
            r2.<init>()     // Catch: java.lang.ClassCastException -> L58
            java.lang.String r5 = "create fragment failed."
            r2.append(r5)     // Catch: java.lang.ClassCastException -> L58
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.ClassCastException -> L58
            r2.append(r1)     // Catch: java.lang.ClassCastException -> L58
            java.lang.String r1 = r2.toString()     // Catch: java.lang.ClassCastException -> L58
            android.util.Log.e(r0, r1)     // Catch: java.lang.ClassCastException -> L58
            goto L5c
        L58:
            r6 = move-exception
            r3 = r4
            goto L69
        L5b:
            r3 = r4
        L5c:
            java.util.WeakHashMap<android.app.Activity, java.lang.ref.WeakReference<com.huawei.hmf.tasks.a.g>> r1 = com.huawei.hmf.tasks.p108a.FragmentC5036g.f23022b     // Catch: java.lang.ClassCastException -> L68
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch: java.lang.ClassCastException -> L68
            r2.<init>(r3)     // Catch: java.lang.ClassCastException -> L68
            r1.put(r6, r2)     // Catch: java.lang.ClassCastException -> L68
        L66:
            r6 = r3
            goto L82
        L68:
            r6 = move-exception
        L69:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "found LifecycleCallbackFragment but the type do not match. "
            r1.append(r2)
            java.lang.String r6 = r6.getMessage()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            android.util.Log.e(r0, r6)
            goto L66
        L82:
            if (r6 == 0) goto L87
            r6.m30077b(r7)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hmf.tasks.p108a.FragmentC5036g.m30076a(android.app.Activity, cq.c):void");
    }

    /* renamed from: b */
    public final void m30077b(InterfaceC8935c interfaceC8935c) {
        synchronized (this.f23023a) {
            this.f23023a.add(new WeakReference<>(interfaceC8935c));
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        synchronized (this.f23023a) {
            try {
                Iterator<WeakReference<InterfaceC8935c<?>>> it = this.f23023a.iterator();
                while (it.hasNext()) {
                    InterfaceC8935c<?> interfaceC8935c = it.next().get();
                    if (interfaceC8935c != null) {
                        interfaceC8935c.cancel();
                    }
                }
                this.f23023a.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
