package p216d4;

import android.content.Context;
import com.huawei.ads.adsrec.C2093e;
import com.huawei.ads.adsrec.p066db.table.AdIECImpRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p247e4.C9406b;
import p247e4.C9407c;
import p277f4.C9655a;
import p384j4.AbstractC10705d;
import p384j4.AbstractC10706e;
import p384j4.AbstractC10707f;

/* renamed from: d4.y */
/* loaded from: classes.dex */
public abstract class AbstractC9038y {
    /* renamed from: a */
    public static String m56994a(Context context, List<String> list) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(C9027o0.m56955b(context).m56962h(it.next()));
            sb2.append(",");
        }
        String string = sb2.toString();
        return !AbstractC10707f.m65379d(string) ? string.substring(0, string.length() - 1) : string;
    }

    /* renamed from: b */
    public static String m56995b(Context context, List<String> list, C9655a c9655a) {
        C2093e c2093e = new C2093e(context);
        String strM60304j = c9655a.m60304j();
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            HashMap map = new HashMap();
            map.put(str, String.valueOf(0));
            for (AdIECImpRecord adIECImpRecord : c2093e.m12569o(AdIECImpRecord.class, null, "pkgName=? and contentId=?", new String[]{strM60304j, str}, null, null)) {
                map.put(adIECImpRecord.m12484t(), String.valueOf(adIECImpRecord.m12483A()));
            }
            arrayList.add(map);
        }
        return AbstractC10705d.m65338D(arrayList);
    }

    /* renamed from: c */
    public static String m56996c(List<String> list) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            sb2.append(",");
        }
        String string = sb2.toString();
        return !AbstractC10707f.m65379d(string) ? string.substring(0, string.length() - 1) : string;
    }

    /* renamed from: d */
    public static String m56997d(Map<String, List<String>> map, Map<String, List<String>> map2) {
        StringBuilder sb2 = new StringBuilder();
        for (String str : map2.keySet()) {
            List<String> list = map.get(str);
            List<String> list2 = map2.get(str);
            if (list != null && list2 != null) {
                int i10 = 0;
                for (int i11 = 0; i11 < list2.size(); i11++) {
                    if (i11 >= list.size() || !list2.get(i11).equals(list.get(i11))) {
                        i10 = i11 + 1;
                        break;
                    }
                }
                if (sb2.length() > 0) {
                    sb2.append(";");
                }
                sb2.append(str);
                sb2.append(":");
                sb2.append(i10);
            }
        }
        return sb2.toString();
    }

    /* renamed from: e */
    public static List<String> m56998e(C9020l c9020l) {
        ArrayList arrayList = new ArrayList();
        if (c9020l != null && !AbstractC10706e.m65374a(c9020l.m56946q())) {
            for (C9031r c9031r : c9020l.m56946q()) {
                if (c9031r != null && !c9031r.m56978s()) {
                    Iterator<C9406b> it = c9031r.m56974o().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().m58977j());
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public static void m56999f(Context context, C9020l c9020l, C9655a c9655a) {
        String strM60305k = c9655a.m60305k();
        String strM56932a = AbstractC9019k0.m56932a(strM60305k);
        HashMap map = new HashMap();
        int i10 = 1;
        if (c9020l.m56947r()) {
            int iM56961g = C9027o0.m56955b(context).m56961g(c9655a.m60296b().get(0));
            if (1 != iM56961g && 2 != iM56961g) {
                i10 = 0;
            }
        } else {
            int iM58981n = -1;
            for (C9031r c9031r : c9020l.m56946q()) {
                if (c9031r != null && !c9031r.m56978s()) {
                    StringBuilder sb2 = new StringBuilder();
                    for (C9406b c9406b : c9031r.m56974o()) {
                        sb2.append(c9406b.m58977j());
                        sb2.append(",");
                        iM58981n = c9406b.m58981n();
                    }
                    String string = sb2.toString();
                    if (!AbstractC10707f.m65379d(string)) {
                        string = string.substring(0, string.length() - 1);
                    }
                    map.put(c9031r.m56976q(), string);
                }
            }
            i10 = iM58981n;
        }
        String strM65338D = AbstractC10705d.m65338D(map);
        C9407c c9407c = new C9407c();
        c9407c.m58986b("2500004");
        c9407c.m58988d(strM56932a);
        c9407c.m58989e(strM60305k);
        c9407c.m58990f(String.valueOf(i10));
        c9407c.m58991g(strM65338D);
        c9407c.m58985a(c9655a.m60307m());
        c9407c.m58984A(c9655a.m60304j());
        c9407c.m58987c(c9655a.m60310p().intValue());
        new C9025n0().m56954a(c9407c);
    }

    /* renamed from: g */
    public static void m57000g(Context context, C9020l c9020l, C9655a c9655a, Map<String, List<String>> map) {
        if (c9655a == null) {
            return;
        }
        C9407c c9407c = new C9407c();
        c9407c.m58986b("2500001");
        c9407c.m58988d(m56996c(c9655a.m60296b()));
        c9407c.m58989e(m56994a(context, c9655a.m60296b()));
        List<String> listM56998e = m56998e(c9020l);
        c9407c.m58990f(listM56998e.size() > 0 ? "1" : "0");
        c9407c.m58991g(m56995b(context, listM56998e, c9655a));
        InterfaceC9006e interfaceC9006eM56860d = C8998a.m56860d();
        if (interfaceC9006eM56860d != null) {
            c9407c.m58992h(String.valueOf(interfaceC9006eM56860d.isInHmsProcess() ? 1 : 0));
        }
        c9407c.m58993i(m56997d(map, AbstractC9003c0.m56870a(c9020l)));
        c9407c.m59008x(c9655a.m60305k());
        c9407c.m59009y(c9655a.m60313s());
        c9407c.m59010z(String.valueOf(c9655a.m60306l()));
        c9407c.m58985a(c9655a.m60307m());
        c9407c.m58984A(c9655a.m60304j());
        c9407c.m58987c(c9655a.m60310p().intValue());
        new C9025n0().m56954a(c9407c);
    }
}
