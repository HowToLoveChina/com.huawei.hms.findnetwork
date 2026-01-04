package md;

import android.text.TextUtils;
import com.huawei.android.hicloud.task.frame.ICBTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p426kd.AbstractC11027a;
import p426kd.AbstractC11040n;
import p514o9.C11839m;
import p770xc.AbstractC13752o;

/* renamed from: md.c */
/* loaded from: classes3.dex */
public class C11440c {

    /* renamed from: b */
    public static volatile List<C11439b<?>> f53301b = new ArrayList();

    /* renamed from: c */
    public static final Object f53302c = new Object();

    /* renamed from: d */
    public static final Map<String, Integer> f53303d = new a();

    /* renamed from: e */
    public static C11440c f53304e = null;

    /* renamed from: a */
    public final ExecutorService f53305a = Executors.newCachedThreadPool();

    /* renamed from: md.c$a */
    public class a extends HashMap<String, Integer> {
        public a() {
            put("autosmslistkey", 55000014);
            put("autocallloglistkey", 55000015);
            put("autorecordingkey", 55000018);
            put("autophonemanagerkey", 55000021);
            put("autosmslistkey_restore", 55000201);
            put("autocallloglistkey_restore", 55000202);
            put("autorecordingkey_restore", 55000204);
            put("autophonemanagerkey_restore", 55000205);
            put("notepad_restore", 55000203);
            put("addressbook", 55000004);
            put("calendar", 55000006);
            put("wlan", 55000005);
        }
    }

    /* renamed from: a */
    public static void m68525a(boolean z10, int i10) {
        synchronized (f53302c) {
            try {
                for (C11439b<?> c11439b : f53301b) {
                    if (c11439b.m68509f() == i10) {
                        c11439b.mo66492l(z10);
                        c11439b.m68520u(i10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public static void m68526b(boolean z10, int i10) {
        synchronized (f53302c) {
            try {
                for (C11439b<?> c11439b : f53301b) {
                    c11439b.mo66492l(z10);
                    c11439b.m68520u(i10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public static void m68527c(C11439b<?> c11439b) {
        synchronized (f53302c) {
            f53301b.add(c11439b);
        }
    }

    /* renamed from: e */
    public static void m68528e(String str) {
        Map<String, Integer> map = f53303d;
        if (map.get(str) == null) {
            return;
        }
        int iIntValue = map.get(str).intValue();
        for (C11439b<?> c11439b : m68530h()) {
            if (iIntValue == c11439b.m68509f()) {
                c11439b.mo66492l(true);
            }
        }
    }

    /* renamed from: g */
    public static C11440c m68529g() {
        C11440c c11440c = f53304e;
        if (c11440c == null) {
            synchronized (f53302c) {
                try {
                    if (f53304e == null) {
                        f53304e = new C11440c();
                    }
                } finally {
                }
            }
        } else if (c11440c.m68545o()) {
            f53304e = new C11440c();
        }
        return f53304e;
    }

    /* renamed from: h */
    public static List<C11439b<?>> m68530h() {
        List<C11439b<?>> list;
        synchronized (f53302c) {
            list = f53301b;
        }
        return list;
    }

    /* renamed from: i */
    public static boolean m68531i(String str) {
        int i10 = "autocallloglistkey".equals(str) ? 55000015 : "autorecordingkey".equals(str) ? 55000018 : "autophonemanagerkey".equals(str) ? 55000021 : 55000014;
        synchronized (f53302c) {
            try {
                Iterator<C11439b<?>> it = f53301b.iterator();
                while (it.hasNext()) {
                    if (it.next().m68509f() == i10) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: j */
    public static boolean m68532j() {
        synchronized (f53302c) {
            try {
                Iterator<C11439b<?>> it = f53301b.iterator();
                while (it.hasNext()) {
                    if (it.next().m68509f() == 55000003) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: k */
    public static boolean m68533k(String str) {
        int i10 = "autocallloglistkey".equals(str) ? 55000202 : "notepad".equals(str) ? 55000203 : "autorecordingkey".equals(str) ? 55000204 : "autophonemanagerkey".equals(str) ? 55000205 : 55000201;
        synchronized (f53302c) {
            try {
                Iterator<C11439b<?>> it = f53301b.iterator();
                while (it.hasNext()) {
                    if (it.next().m68509f() == i10) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: l */
    public static boolean m68534l(String str) {
        int i10 = "addressbook".equals(str) ? 55000004 : "wlan".equals(str) ? 55000005 : "calendar".equals(str) ? 55000006 : 0;
        synchronized (f53302c) {
            try {
                Iterator<C11439b<?>> it = f53301b.iterator();
                while (it.hasNext()) {
                    if (it.next().m68509f() == i10) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: m */
    public static void m68535m(int i10) {
        synchronized (f53302c) {
            try {
                for (C11439b<?> c11439b : f53301b) {
                    int iM68509f = c11439b.m68509f();
                    if (iM68509f == 55000014 || iM68509f == 55000015 || iM68509f == 55000018 || iM68509f == 55000021) {
                        c11439b.mo66492l(false);
                        c11439b.m68520u(i10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: n */
    public static boolean m68536n(int i10) {
        return i10 == 55000026 || i10 == 55000027 || i10 == 55000028 || i10 == 55000032 || i10 == 55000030 || i10 == 55000033 || i10 == 55000034;
    }

    /* renamed from: p */
    public static boolean m68537p(int i10) {
        return i10 == 55000007 || i10 == 55000008 || i10 == 55000010 || i10 == 55000012 || i10 == 55000009 || m68536n(i10);
    }

    /* renamed from: q */
    public static boolean m68538q(String str) {
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("CBTaskManager", "isSyncing error: syncType is null or empty.");
            return false;
        }
        C11839m.m70688i("CBTaskManager", "isSyncing: syncType = " + str);
        synchronized (f53302c) {
            try {
                Iterator<C11439b<?>> it = f53301b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C11439b<?> next = it.next();
                    if (str.equals(next.m68517q())) {
                        int iM68509f = next.m68509f();
                        if (m68537p(iM68509f)) {
                            C11839m.m70688i("CBTaskManager", "isSyncing : requestCode = " + iM68509f);
                            z10 = true;
                            break;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    /* renamed from: r */
    public static boolean m68539r(String str) {
        synchronized (f53302c) {
            try {
                Map<String, Integer> map = f53303d;
                if (map.get(str) == null) {
                    return false;
                }
                int iIntValue = map.get(str).intValue();
                for (C11439b<?> c11439b : m68530h()) {
                    if (iIntValue == c11439b.m68509f()) {
                        return c11439b.m68511i();
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: s */
    public static void m68540s(C11439b<?> c11439b) {
        synchronized (f53302c) {
            try {
                ArrayList arrayList = new ArrayList();
                for (C11439b<?> c11439b2 : f53301b) {
                    if (c11439b2.m68509f() == c11439b.m68509f()) {
                        arrayList.add(c11439b2);
                    }
                }
                f53301b.removeAll(arrayList);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: t */
    public static void m68541t(List<String> list, int i10) {
        C11839m.m70688i("CBTaskManager", "stopMultiSync");
        synchronized (f53302c) {
            try {
                for (C11439b<?> c11439b : m68530h()) {
                    String strM68517q = c11439b.m68517q();
                    Iterator<String> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String next = it.next();
                            if (strM68517q.equals(next)) {
                                C11839m.m70688i("CBTaskManager", "stopMultiSync: " + next);
                                c11439b.mo66492l(true);
                                c11439b.m68520u(i10);
                                break;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: u */
    public static boolean m68542u(String str, int i10) {
        boolean z10;
        synchronized (f53302c) {
            try {
                z10 = true;
                for (C11439b<?> c11439b : m68530h()) {
                    if (c11439b.m68517q().equals(str)) {
                        c11439b.mo66492l(true);
                        c11439b.m68520u(i10);
                        z10 = false;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    /* renamed from: d */
    public void m68543d(int i10) {
        m68526b(true, i10);
        this.f53305a.shutdownNow();
        synchronized (f53302c) {
            f53301b.clear();
        }
        C11839m.m70688i("CBTaskManager", "CBTaskManager destroy.");
    }

    /* renamed from: f */
    public int m68544f(ICBTask iCBTask, String str) {
        if ((iCBTask instanceof AbstractC11027a) || (iCBTask instanceof AbstractC11040n) || (iCBTask instanceof AbstractC13752o)) {
            ((C11439b) iCBTask).m68521v(str);
            C11839m.m70688i("CBTaskManager", "add task : " + iCBTask.toString());
            m68527c((C11439b) iCBTask);
        }
        try {
            this.f53305a.execute(iCBTask);
            return 0;
        } catch (Exception e10) {
            C11839m.m70687e("CBTaskManager", iCBTask + " fail: " + e10.toString());
            return -4;
        }
    }

    /* renamed from: o */
    public boolean m68545o() {
        return this.f53305a.isShutdown();
    }
}
