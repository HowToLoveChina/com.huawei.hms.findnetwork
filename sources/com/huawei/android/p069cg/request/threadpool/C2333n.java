package com.huawei.android.p069cg.request.threadpool;

import ck.C1444b;
import java.lang.reflect.Field;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p031b7.C1120a;

/* renamed from: com.huawei.android.cg.request.threadpool.n */
/* loaded from: classes2.dex */
public class C2333n {

    /* renamed from: s */
    public static volatile C2333n f11130s;

    /* renamed from: a */
    public volatile ExecutorService f11131a;

    /* renamed from: b */
    public ExecutorService f11132b;

    /* renamed from: c */
    public ExecutorService f11133c;

    /* renamed from: d */
    public ExecutorService f11134d;

    /* renamed from: e */
    public ExecutorService f11135e;

    /* renamed from: f */
    public ExecutorService f11136f;

    /* renamed from: g */
    public ExecutorService f11137g;

    /* renamed from: h */
    public Vector<AbstractC2329j> f11138h;

    /* renamed from: i */
    public Vector<Map<String, Object>> f11139i;

    /* renamed from: j */
    public Vector<Map<String, Object>> f11140j;

    /* renamed from: k */
    public Vector<Map<String, Object>> f11141k;

    /* renamed from: l */
    public Vector<Map<String, Object>> f11142l;

    /* renamed from: m */
    public Vector<Map<String, Object>> f11143m;

    /* renamed from: n */
    public boolean f11144n = false;

    /* renamed from: o */
    public C2330k f11145o = new C2330k(1, 0);

    /* renamed from: p */
    public C2330k f11146p = new C2330k(1, 0);

    /* renamed from: q */
    public C2330k f11147q = new C2330k(1, 0);

    /* renamed from: r */
    public C2330k f11148r = new C2330k(1, 0);

    public C2333n() {
        this.f11131a = null;
        this.f11132b = null;
        this.f11133c = null;
        this.f11134d = null;
        this.f11135e = null;
        this.f11136f = null;
        this.f11137g = null;
        this.f11138h = null;
        this.f11139i = null;
        this.f11140j = null;
        this.f11141k = null;
        this.f11142l = null;
        this.f11143m = null;
        this.f11138h = new Vector<>();
        this.f11131a = Executors.newSingleThreadExecutor();
        this.f11132b = Executors.newFixedThreadPool(C1444b.m8296b());
        this.f11133c = Executors.newFixedThreadPool(C1444b.m8296b());
        this.f11139i = new Vector<>();
        this.f11140j = new Vector<>();
        this.f11136f = Executors.newFixedThreadPool(1);
        this.f11137g = Executors.newFixedThreadPool(1);
        this.f11142l = new Vector<>();
        this.f11143m = new Vector<>();
        this.f11134d = Executors.newFixedThreadPool(1);
        this.f11135e = Executors.newFixedThreadPool(1);
        this.f11141k = new Vector<>();
        this.f11142l = new Vector<>();
        this.f11143m = new Vector<>();
        m14665b();
    }

    /* renamed from: c */
    public static synchronized void m14662c() {
        if (f11130s == null) {
            f11130s = new C2333n();
        }
    }

    /* renamed from: f */
    public static C2333n m14663f() {
        if (f11130s == null) {
            m14662c();
        }
        return f11130s;
    }

    /* renamed from: a */
    public final boolean m14664a(Vector<Map<String, Object>> vector, AbstractCallableC2320a abstractCallableC2320a) {
        Map<String, Object> mapNextElement;
        if (vector == null || vector.isEmpty()) {
            C1120a.m6675d("ThreadPoolManager", "contains poolList is null or empty");
            return false;
        }
        if (abstractCallableC2320a == null) {
            C1120a.m6675d("ThreadPoolManager", "contains baseCallable is null");
            return false;
        }
        Enumeration<Map<String, Object>> enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            try {
                mapNextElement = enumerationElements.nextElement();
            } catch (NoSuchElementException e10) {
                C1120a.m6676e("ThreadPoolManager", "contains getElement error: " + e10.toString());
                mapNextElement = null;
            }
            if (mapNextElement == null) {
                C1120a.m6675d("ThreadPoolManager", "contains map is null, ignore");
            } else {
                AbstractCallableC2320a abstractCallableC2320a2 = (AbstractCallableC2320a) mapNextElement.get("FIXED_BASECALLABLE_KEY");
                if (abstractCallableC2320a2 == null) {
                    C1120a.m6675d("ThreadPoolManager", "contains callable is null, ignore");
                } else if (abstractCallableC2320a.baseEquals(abstractCallableC2320a2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void m14665b() {
        Iterator<C2330k> it = m14670i().iterator();
        while (it.hasNext()) {
            it.next().m14598a();
        }
    }

    /* renamed from: d */
    public final boolean m14666d(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10, ExecutorService executorService, ExecutorService executorService2, Vector<Map<String, Object>> vector, Vector<Map<String, Object>> vector2, long j10) {
        if (!executorService.isShutdown() && !executorService2.isShutdown()) {
            m14671j(abstractCallableC2320a, abstractC2324e, z10, executorService2, vector, vector2);
            C2327h c2327h = new C2327h();
            c2327h.put("FIXED_BASECALLABLE_KEY", abstractCallableC2320a);
            c2327h.put("FIXED_HANDLECALLABLE_KEY", abstractC2324e);
            boolean zM14664a = m14664a(vector, abstractCallableC2320a);
            boolean zM14664a2 = m14664a(vector2, abstractCallableC2320a);
            C1120a.m6675d("ThreadPoolManager", "callListContains:" + zM14664a);
            C1120a.m6675d("ThreadPoolManager", "execCallListContains:" + zM14664a2);
            if (!zM14664a && !zM14664a2) {
                if (z10) {
                    vector.add(0, c2327h);
                } else {
                    vector.add(c2327h);
                }
                if (executorService2.submit(new CallableC2322c(executorService2, executorService, vector, vector2, j10)) != null) {
                    return true;
                }
                C1120a.m6675d("ThreadPoolManager", "future fail");
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public final boolean m14667e(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10, C2330k c2330k) {
        return m14666d(abstractCallableC2320a, abstractC2324e, z10, c2330k.m14602e(), c2330k.m14603f(), c2330k.m14600c(), c2330k.m14599b(), c2330k.m14601d());
    }

    /* renamed from: g */
    public synchronized Vector<Map<String, Object>> m14668g() {
        return this.f11140j;
    }

    /* renamed from: h */
    public synchronized Vector<Map<String, Object>> m14669h() {
        return this.f11139i;
    }

    /* renamed from: i */
    public final List<C2330k> m14670i() {
        ArrayList arrayList = new ArrayList();
        Field[] declaredFields = C2333n.class.getDeclaredFields();
        String str = "class " + C2330k.class.getName();
        Type genericType = null;
        for (Field field : declaredFields) {
            if (field == null) {
                C1120a.m6678w("ThreadPoolManager", "getPoolList: field is null");
            } else {
                try {
                    genericType = field.getGenericType();
                } catch (TypeNotPresentException e10) {
                    C1120a.m6676e("ThreadPoolManager", "TypeNotPresentException: " + e10.toString());
                } catch (GenericSignatureFormatError e11) {
                    C1120a.m6676e("ThreadPoolManager", "GenericSignatureFormatError: " + e11.toString());
                } catch (MalformedParameterizedTypeException e12) {
                    C1120a.m6676e("ThreadPoolManager", "MalformedParameterizedTypeException: " + e12.toString());
                }
                if (genericType == null) {
                    C1120a.m6678w("ThreadPoolManager", "getPoolList: type is null");
                } else if (str.equals(genericType.toString())) {
                    try {
                        C2330k c2330k = (C2330k) field.get(this);
                        if (c2330k != null) {
                            arrayList.add(c2330k);
                        }
                    } catch (IllegalAccessException e13) {
                        C1120a.m6676e("ThreadPoolManager", "IllegalAccessException: " + e13.toString());
                    } catch (IllegalArgumentException e14) {
                        C1120a.m6676e("ThreadPoolManager", "IllegalArgumentException: " + e14.toString());
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    public final void m14671j(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10, ExecutorService executorService, Vector<Map<String, Object>> vector, Vector<Map<String, Object>> vector2) {
        if (abstractCallableC2320a.getThreadType() == 0) {
            abstractCallableC2320a.setThreadType(2);
        }
        abstractCallableC2320a.setPriority(z10);
        abstractCallableC2320a.setFixedThreadPoolList(vector);
        abstractCallableC2320a.setFixedThreadPoolExecutedList(vector2);
        abstractCallableC2320a.setCurrentExecutorService(executorService);
    }

    /* renamed from: k */
    public synchronized boolean m14672k(AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e, boolean z10) {
        try {
            if (!this.f11132b.isShutdown() && !this.f11133c.isShutdown()) {
                abstractCallableC2320a.setThreadType(2);
                abstractCallableC2320a.setPriority(z10);
                abstractCallableC2320a.setFixedThreadPoolList(this.f11139i);
                abstractCallableC2320a.setFixedThreadPoolExecutedList(this.f11140j);
                C2327h c2327h = new C2327h();
                c2327h.put("FIXED_BASECALLABLE_KEY", abstractCallableC2320a);
                c2327h.put("FIXED_HANDLECALLABLE_KEY", abstractC2324e);
                boolean zM14664a = m14664a(this.f11139i, abstractCallableC2320a);
                boolean zM14664a2 = m14664a(this.f11140j, abstractCallableC2320a);
                C1120a.m6675d("ThreadPoolManager", "fixedCallableListContains:" + zM14664a);
                C1120a.m6675d("ThreadPoolManager", "fixedCallableExecutedListContains:" + zM14664a2);
                if (!zM14664a && !zM14664a2) {
                    if (z10) {
                        this.f11139i.add(0, c2327h);
                    } else {
                        this.f11139i.add(c2327h);
                    }
                    if (this.f11133c.submit(new CallableC2322c(this.f11133c, this.f11132b, this.f11139i, this.f11140j, 0L)) == null) {
                        C1120a.m6675d("ThreadPoolManager", "future fail");
                    }
                    return true;
                }
                return false;
            }
            return false;
        } finally {
        }
    }

    /* renamed from: l */
    public synchronized boolean m14673l(AbstractC2328i abstractC2328i, boolean z10) {
        return m14667e(abstractC2328i, null, z10, this.f11147q);
    }

    /* renamed from: m */
    public synchronized void m14674m(AbstractC2331l abstractC2331l, boolean z10) {
        try {
            if (!this.f11134d.isShutdown() && !this.f11135e.isShutdown()) {
                abstractC2331l.setThreadType(2);
                abstractC2331l.setPriority(z10);
                C2327h c2327h = new C2327h();
                c2327h.put("FIXED_BASECALLABLE_KEY", abstractC2331l);
                c2327h.put("FIXED_HANDLECALLABLE_KEY", null);
                if (this.f11141k.contains(c2327h)) {
                    return;
                }
                if (z10) {
                    this.f11141k.add(0, c2327h);
                } else {
                    this.f11141k.add(c2327h);
                }
                if (this.f11135e.submit(new CallableC2322c(this.f11135e, this.f11134d, this.f11141k, 200L)) == null) {
                    C1120a.m6675d("ThreadPoolManager", "future fail");
                }
            }
        } finally {
        }
    }
}
