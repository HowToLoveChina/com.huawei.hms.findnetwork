package p516ob;

import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p709vj.C13452e;

/* renamed from: ob.a */
/* loaded from: classes3.dex */
public class C11845a {

    /* renamed from: a */
    public static List<ModuleItem> f54848a = new ArrayList();

    /* renamed from: b */
    public static List<ModuleItem> f54849b = new ArrayList();

    /* renamed from: c */
    public static List<CBSDevice> f54850c = new ArrayList();

    /* renamed from: d */
    public static List<CBSDevice> f54851d = new ArrayList();

    /* renamed from: e */
    public static int f54852e = 0;

    /* renamed from: f */
    public static List<ModuleItem> f54853f = new ArrayList();

    /* renamed from: g */
    public static List<ModuleItem> f54854g = new ArrayList();

    /* renamed from: h */
    public static List<ModuleItem> f54855h = new ArrayList();

    /* renamed from: i */
    public static Map<String, Long> f54856i = new HashMap();

    /* renamed from: j */
    public static Map<String, String> f54857j = new HashMap();

    /* renamed from: k */
    public static String f54858k = "";

    /* renamed from: l */
    public static boolean f54859l;

    /* renamed from: m */
    public static boolean f54860m;

    /* renamed from: A */
    public static void m70904A(String str, List<ModuleItem> list, List<CBSDevice> list2, int i10, boolean z10) {
        if ("calllog".equals(str)) {
            m70920g(list, list2, i10, z10);
        } else if (NavigationUtils.SMS_SCHEMA_PREF.equals(str)) {
            m70922i(list, list2, i10, z10);
        }
    }

    /* renamed from: B */
    public static void m70905B(String str) {
        f54857j.put(str, String.valueOf(f54857j.size()));
    }

    /* renamed from: C */
    public static void m70906C(boolean z10) {
        f54860m = z10;
    }

    /* renamed from: D */
    public static void m70907D(boolean z10) {
        f54859l = z10;
    }

    /* renamed from: E */
    public static void m70908E(String str, List<ModuleItem> list) {
        if ("notepad".equals(str)) {
            m70909F(list);
        } else if ("recordig".equals(str)) {
            m70911H(list);
        } else if ("phonemanager".equals(str)) {
            m70910G(list);
        }
    }

    /* renamed from: F */
    public static void m70909F(List<ModuleItem> list) {
        f54853f = list;
    }

    /* renamed from: G */
    public static void m70910G(List<ModuleItem> list) {
        f54855h = list;
    }

    /* renamed from: H */
    public static void m70911H(List<ModuleItem> list) {
        f54854g = list;
    }

    /* renamed from: I */
    public static void m70912I(List<ModuleItem> list) {
        f54848a = list;
    }

    /* renamed from: J */
    public static void m70913J(List<CBSDevice> list) {
        f54851d = list;
    }

    /* renamed from: a */
    public static void m70914a() {
        m70912I(new ArrayList());
        m70938y(new ArrayList());
        m70939z(new ArrayList());
        m70913J(new ArrayList());
        m70911H(new ArrayList());
        m70909F(new ArrayList());
        m70910G(new ArrayList());
    }

    /* renamed from: b */
    public static void m70915b() {
        m70938y(new ArrayList());
        m70939z(new ArrayList());
    }

    /* renamed from: c */
    public static void m70916c() {
        m70912I(new ArrayList());
        m70913J(new ArrayList());
    }

    /* renamed from: d */
    public static void m70917d(List<ModuleItem> list) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < list.size(); i10++) {
            int i11 = 0;
            while (true) {
                if (i11 < f54849b.size()) {
                    String deviceID = list.get(i10).getDeviceID();
                    String deviceID2 = f54849b.get(i11).getDeviceID();
                    if (deviceID == null || deviceID2 == null) {
                        break;
                    }
                    if (deviceID.equals(deviceID2)) {
                        map.put(list.get(i10), 0);
                        break;
                    } else {
                        map.put(list.get(i10), 1);
                        i11++;
                    }
                }
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if (((Integer) entry.getValue()).equals(1)) {
                arrayList.add((ModuleItem) entry.getKey());
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        f54849b.addAll(arrayList);
    }

    /* renamed from: e */
    public static void m70918e(List<ModuleItem> list) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < list.size(); i10++) {
            int i11 = 0;
            while (true) {
                if (i11 < f54848a.size()) {
                    String deviceID = list.get(i10).getDeviceID();
                    String deviceID2 = f54848a.get(i11).getDeviceID();
                    if (deviceID == null || deviceID2 == null) {
                        break;
                    }
                    if (deviceID.equals(deviceID2)) {
                        map.put(list.get(i10), 0);
                        break;
                    } else {
                        map.put(list.get(i10), 1);
                        i11++;
                    }
                }
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if (((Integer) entry.getValue()).equals(1)) {
                arrayList.add((ModuleItem) entry.getKey());
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        f54848a.addAll(arrayList);
    }

    /* renamed from: f */
    public static String m70919f() {
        return f54858k;
    }

    /* renamed from: g */
    public static void m70920g(List<ModuleItem> list, List<CBSDevice> list2, int i10, boolean z10) {
        int i11;
        ModuleItem next;
        boolean z11;
        f54860m = z10;
        List<ModuleItem> list3 = f54849b;
        if (list3 != null) {
            if (list3.size() > 0) {
                String strM80950o = C13452e.m80781L().m80950o();
                Iterator<ModuleItem> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next != null && next.getDeviceID().equals(strM80950o)) {
                        String deviceID = f54849b.get(0).getDeviceID();
                        if (deviceID == null || strM80950o == null || !deviceID.equals(strM80950o)) {
                            break;
                        }
                        f54849b.set(0, next);
                        z11 = true;
                    }
                }
                z11 = false;
                if (!z11 && next != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(0, next);
                    for (i11 = 1; i11 <= f54849b.size(); i11++) {
                        arrayList.add(i11, f54849b.get(i11 - 1));
                    }
                    f54849b.clear();
                    f54849b.addAll(arrayList);
                }
                m70917d(list);
            } else {
                m70938y(list);
            }
            if (f54860m) {
                return;
            }
            m70939z(list2);
        }
    }

    /* renamed from: h */
    public static List<ModuleItem> m70921h() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(m70924k());
        arrayList.addAll(m70929p());
        arrayList.addAll(m70932s());
        arrayList.addAll(m70931r());
        arrayList.addAll(m70930q());
        return arrayList;
    }

    /* renamed from: i */
    public static void m70922i(List<ModuleItem> list, List<CBSDevice> list2, int i10, boolean z10) {
        int i11;
        ModuleItem next;
        boolean z11;
        f54859l = z10;
        List<ModuleItem> list3 = f54848a;
        if (list3 != null) {
            if (list3.size() > 0) {
                String strM80950o = C13452e.m80781L().m80950o();
                Iterator<ModuleItem> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next != null && next.getDeviceID().equals(strM80950o)) {
                        String deviceID = f54848a.get(0).getDeviceID();
                        if (deviceID == null || strM80950o == null || !deviceID.equals(strM80950o)) {
                            break;
                        }
                        f54848a.set(0, next);
                        z11 = true;
                    }
                }
                z11 = false;
                if (!z11 && next != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(0, next);
                    for (i11 = 1; i11 <= f54848a.size(); i11++) {
                        arrayList.add(i11, f54848a.get(i11 - 1));
                    }
                    f54848a.clear();
                    f54848a.addAll(arrayList);
                }
                m70918e(list);
            } else {
                m70912I(list);
            }
            if (f54859l) {
                return;
            }
            m70913J(list2);
        }
    }

    /* renamed from: j */
    public static Long m70923j(String str) {
        if (f54856i.get(str) == null) {
            return 0L;
        }
        return f54856i.get(str);
    }

    /* renamed from: k */
    public static List<ModuleItem> m70924k() {
        return f54849b;
    }

    /* renamed from: l */
    public static List<CBSDevice> m70925l() {
        return f54850c;
    }

    /* renamed from: m */
    public static String m70926m(String str) {
        return f54857j.get(str);
    }

    /* renamed from: n */
    public static List<ModuleItem> m70927n(String str) {
        return NavigationUtils.SMS_SCHEMA_PREF.equals(str) ? m70932s() : "calllog".equals(str) ? m70924k() : "notepad".equals(str) ? m70929p() : "recordig".equals(str) ? m70931r() : "phonemanager".equals(str) ? m70930q() : new ArrayList();
    }

    /* renamed from: o */
    public static List<CBSDevice> m70928o(String str) {
        return NavigationUtils.SMS_SCHEMA_PREF.equals(str) ? m70933t() : "calllog".equals(str) ? m70925l() : new ArrayList();
    }

    /* renamed from: p */
    public static List<ModuleItem> m70929p() {
        return f54853f;
    }

    /* renamed from: q */
    public static List<ModuleItem> m70930q() {
        return f54855h;
    }

    /* renamed from: r */
    public static List<ModuleItem> m70931r() {
        return f54854g;
    }

    /* renamed from: s */
    public static List<ModuleItem> m70932s() {
        return f54848a;
    }

    /* renamed from: t */
    public static List<CBSDevice> m70933t() {
        return f54851d;
    }

    /* renamed from: u */
    public static boolean m70934u() {
        return f54860m;
    }

    /* renamed from: v */
    public static boolean m70935v() {
        return f54859l;
    }

    /* renamed from: w */
    public static void m70936w(String str) {
        f54858k = str;
    }

    /* renamed from: x */
    public static void m70937x(String str, Long l10) {
        f54856i.put(str, l10);
    }

    /* renamed from: y */
    public static void m70938y(List<ModuleItem> list) {
        f54849b = list;
    }

    /* renamed from: z */
    public static void m70939z(List<CBSDevice> list) {
        f54850c = list;
    }
}
