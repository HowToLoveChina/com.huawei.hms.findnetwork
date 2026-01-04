package com.huawei.android.hicloud.task.frame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Messenger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import md.C11440c;
import md.C11441d;
import md.C11442e;
import md.C11443f;
import p426kd.C11028b;
import p426kd.C11029c;
import p426kd.C11030d;
import p426kd.C11031e;
import p426kd.C11033g;
import p426kd.C11041o;
import p426kd.C11042p;
import p426kd.C11043q;
import p426kd.C11044r;
import p426kd.C11045s;
import p514o9.C11839m;
import p770xc.C13738a;
import p770xc.C13739b;
import p770xc.C13740c;
import p770xc.C13741d;
import p770xc.C13743f;
import p770xc.C13745h;
import p770xc.C13747j;
import p770xc.C13749l;
import p770xc.C13750m;
import p770xc.C13751n;
import p770xc.C13753p;
import p770xc.C13754q;
import p770xc.C13755r;
import p770xc.C13756s;
import p806yc.C13937a;
import p806yc.C13938b;
import p806yc.C13939c;
import p806yc.C13940d;
import p806yc.C13941e;
import p806yc.C13942f;
import p806yc.C13943g;
import p806yc.C13944h;

/* loaded from: classes3.dex */
public class RequestDispatcher {

    /* renamed from: b */
    public static Class<?>[] f13060b = {C13753p.class, C13754q.class, C13751n.class, C13750m.class, C13743f.class, C13755r.class, C13756s.class, C13739b.class, C11033g.class, C11028b.class, C11041o.class, C11031e.class, C11045s.class, C11042p.class, C11029c.class, C11043q.class, C11030d.class, C11044r.class, C13745h.class, C13738a.class, C13740c.class, C13943g.class, C13944h.class, C13941e.class, C13937a.class, C13939c.class, C13942f.class, C13940d.class, C13741d.class, C13938b.class, C13749l.class, C13747j.class};

    /* renamed from: c */
    public static Map<Integer, Class<? extends ICBTask>> f13061c;

    /* renamed from: d */
    public static final Map<Messenger, C11441d> f13062d;

    /* renamed from: a */
    public Context f13063a;

    static {
        m18033a();
        f13062d = new HashMap();
    }

    public RequestDispatcher(Context context) {
        this.f13063a = context;
    }

    @SuppressLint({"UseSparseArrays"})
    /* renamed from: a */
    public static void m18033a() {
        CBServiceTask cBServiceTask;
        HashMap map = new HashMap();
        for (Class<?> cls : f13060b) {
            if (ICBTask.class.isAssignableFrom(cls) && (cBServiceTask = (CBServiceTask) cls.getAnnotation(CBServiceTask.class)) != null) {
                map.put(Integer.valueOf(cBServiceTask.request()), cls);
            }
        }
        f13061c = Collections.unmodifiableMap(map);
        C11839m.m70686d("RequestDispatcher", "sTasks = " + f13061c);
    }

    /* renamed from: c */
    public static Map<Messenger, C11441d> m18034c() {
        return f13062d;
    }

    /* renamed from: b */
    public void m18035b(C11442e c11442e, String str) {
        ICBTask iCBTaskM18036d = m18036d(c11442e, null);
        if (iCBTaskM18036d != null) {
            iCBTaskM18036d.mo18031w();
            C11440c.m68529g().m68544f(iCBTaskM18036d, str);
        }
    }

    /* renamed from: d */
    public ICBTask m18036d(C11442e c11442e, C11441d c11441d) throws IllegalAccessException, InstantiationException {
        Class<? extends ICBTask> cls = f13061c.get(Integer.valueOf(c11442e.m68550b()));
        ICBTask iCBTask = null;
        if (cls == null) {
            return null;
        }
        try {
            ICBTask iCBTaskNewInstance = cls.newInstance();
            try {
                iCBTaskNewInstance.setContext(this.f13063a);
                iCBTaskNewInstance.mo18030b(c11442e);
                CBServiceTask cBServiceTask = (CBServiceTask) cls.getAnnotation(CBServiceTask.class);
                C11443f c11443fM68551b = C11443f.m68551b();
                c11443fM68551b.m68555e(cBServiceTask.response());
                iCBTaskNewInstance.mo18032x(c11443fM68551b);
                return iCBTaskNewInstance;
            } catch (Exception e10) {
                e = e10;
                iCBTask = iCBTaskNewInstance;
                C11839m.m70687e("RequestDispatcher", "getServiceTask error: " + e.toString());
                return iCBTask;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    /* renamed from: e */
    public void m18037e(Messenger messenger, int i10) {
        C11839m.m70686d("RequestDispatcher", "Register " + messenger);
        Map<Messenger, C11441d> map = f13062d;
        synchronized (map) {
            try {
                C11441d c11441d = map.get(messenger);
                if (c11441d == null) {
                    c11441d = new C11441d(messenger, i10);
                } else {
                    c11441d.m68548c(i10);
                }
                map.put(messenger, c11441d);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public void m18038f(Messenger messenger) {
        C11441d c11441dRemove;
        Map<Messenger, C11441d> map = f13062d;
        synchronized (map) {
            c11441dRemove = map.remove(messenger);
        }
        if (c11441dRemove != null) {
            c11441dRemove.m68546a();
        }
    }
}
