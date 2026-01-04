package ad;

import android.content.Context;
import com.huawei.android.hicloud.sync.wifi.datamanager.SyncWlanBean;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p517oc.C11847b;
import p517oc.C11848c;
import sc.C12769b;
import sc.C12774g;
import sc.C12777j;

/* renamed from: ad.a */
/* loaded from: classes3.dex */
public class C0100a {

    /* renamed from: a */
    public static HashMap<String, Integer> f336a;

    /* renamed from: b */
    public static HashMap<String, Integer> f337b;

    /* renamed from: c */
    public static Map<String, C11847b> f338c;

    /* renamed from: d */
    public static Map<String, C11848c> f339d;

    /* renamed from: e */
    public static Map<String, SyncWlanBean> f340e;

    /* renamed from: f */
    public static Map<String, C11847b> f341f = new HashMap();

    /* renamed from: g */
    public static Map<String, C11848c> f342g = new HashMap();

    /* renamed from: h */
    public static Map<String, SyncWlanBean> f343h = new HashMap();

    /* renamed from: i */
    public static ArrayList<C11847b> f344i = new ArrayList<>();

    /* renamed from: j */
    public static ArrayList<C11848c> f345j = new ArrayList<>();

    /* renamed from: k */
    public static ArrayList<SyncWlanBean> f346k = new ArrayList<>();

    /* renamed from: a */
    public static Map<String, C11847b> m701a(Map<String, C11847b> map) {
        f341f.clear();
        for (Map.Entry<String, C11847b> entry : map.entrySet()) {
            f341f.put(entry.getValue().getGuid(), entry.getValue());
        }
        return f341f;
    }

    /* renamed from: b */
    public static Map<String, C11847b> m702b() {
        return f338c;
    }

    /* renamed from: c */
    public static int m703c(String str) {
        HashMap<String, Integer> map = f336a;
        if (map == null || map.size() <= 0 || f336a.get(str) == null) {
            return 0;
        }
        return f336a.get(str).intValue();
    }

    /* renamed from: d */
    public static Map<String, C11848c> m704d(Map<String, C11848c> map) {
        f342g.clear();
        for (Map.Entry<String, C11848c> entry : map.entrySet()) {
            f342g.put(entry.getValue().getGuid(), entry.getValue());
        }
        return f342g;
    }

    /* renamed from: e */
    public static int m705e(String str) {
        HashMap<String, Integer> map = f337b;
        if (map == null || map.size() <= 0 || f337b.get(str) == null) {
            return 0;
        }
        return f337b.get(str).intValue();
    }

    /* renamed from: f */
    public static Map<String, C11847b> m706f() {
        f338c.clear();
        ArrayList<C11847b> arrayListM76635l = new C12769b().m76635l(HNConstants.DataType.CONTACT);
        f344i = arrayListM76635l;
        if (arrayListM76635l == null || arrayListM76635l.size() == 0) {
            return f338c;
        }
        Iterator<C11847b> it = f344i.iterator();
        while (it.hasNext()) {
            C11847b next = it.next();
            f338c.put(next.getLuid(), next);
        }
        return f338c;
    }

    /* renamed from: g */
    public static Map<String, C11848c> m707g() {
        f339d.clear();
        ArrayList<C11848c> arrayListM76675j = new C12774g().m76675j("group");
        f345j = arrayListM76675j;
        if (arrayListM76675j == null || arrayListM76675j.size() == 0) {
            return f339d;
        }
        Iterator<C11848c> it = f345j.iterator();
        while (it.hasNext()) {
            C11848c next = it.next();
            f339d.put(next.getLuid(), next);
        }
        return f339d;
    }

    /* renamed from: h */
    public static Map<String, C11848c> m708h() {
        return f339d;
    }

    /* renamed from: i */
    public static Map<String, SyncWlanBean> m709i() {
        f340e.clear();
        ArrayList<SyncWlanBean> arrayListM76690j = new C12777j().m76690j("wlan");
        f346k = arrayListM76690j;
        if (arrayListM76690j == null || arrayListM76690j.size() == 0) {
            return f340e;
        }
        Iterator<SyncWlanBean> it = f346k.iterator();
        while (it.hasNext()) {
            SyncWlanBean next = it.next();
            f340e.put(next.getLuid(), next);
        }
        return f340e;
    }

    /* renamed from: j */
    public static Map<String, SyncWlanBean> m710j() {
        return f340e;
    }

    /* renamed from: k */
    public static Map<String, SyncWlanBean> m711k(Map<String, SyncWlanBean> map) {
        f343h.clear();
        for (Map.Entry<String, SyncWlanBean> entry : map.entrySet()) {
            f343h.put(entry.getValue().getGuid(), entry.getValue());
        }
        return f343h;
    }

    /* renamed from: l */
    public static Map<String, SyncWlanBean> m712l() {
        HashMap map = new HashMap(10);
        Iterator<SyncWlanBean> it = new C12777j().m76690j("wlan").iterator();
        while (it.hasNext()) {
            SyncWlanBean next = it.next();
            map.put(next.getLuid(), next);
        }
        return map;
    }

    /* renamed from: m */
    public static void m713m(Context context) {
        f338c = new HashMap();
        f339d = new HashMap();
        f340e = new HashMap();
        f336a = new HashMap<>(128);
        f337b = new HashMap<>(64);
    }

    /* renamed from: n */
    public static void m714n(String str, int i10) {
        HashMap<String, Integer> map = f336a;
        if (map != null) {
            map.put(str, Integer.valueOf(i10));
        }
    }

    /* renamed from: o */
    public static void m715o(String str, int i10) {
        HashMap<String, Integer> map = f337b;
        if (map != null) {
            map.put(str, Integer.valueOf(i10));
        }
    }

    /* renamed from: p */
    public static void m716p(String str, int i10) {
        f338c.get(str).setStatus(i10);
    }

    /* renamed from: q */
    public static void m717q(String str, int i10) {
        f339d.get(str).setStatus(i10);
    }

    /* renamed from: r */
    public static void m718r(String str, int i10) {
        f340e.get(str).setStatus(i10);
    }
}
