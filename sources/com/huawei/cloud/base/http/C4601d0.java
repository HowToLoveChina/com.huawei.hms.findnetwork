package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4628b;
import com.huawei.cloud.base.util.C4635e0;
import com.huawei.cloud.base.util.C4636f;
import com.huawei.cloud.base.util.C4637f0;
import com.huawei.cloud.base.util.C4638g;
import com.huawei.cloud.base.util.C4642j;
import com.huawei.cloud.base.util.C4645m;
import com.huawei.cloud.base.util.C4646n;
import com.huawei.cloud.base.util.InterfaceC4657y;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p656ti.C13014a;

/* renamed from: com.huawei.cloud.base.http.d0 */
/* loaded from: classes.dex */
public class C4601d0 implements InterfaceC4657y {

    /* renamed from: a */
    public static final String f21152a = new C4611n(RequestBody.HEAD_VALUE_CONTENT_TYPE_URLENCODED).m28256k(C4636f.f21271a).m28248a();

    /* renamed from: c */
    public static void m28182c(Reader reader, Object obj) throws IOException {
        int i10;
        Class<?> cls = obj.getClass();
        C4638g c4638gM28427f = C4638g.m28427f(cls);
        List listAsList = Arrays.asList(cls);
        C4646n c4646n = C4646n.class.isAssignableFrom(cls) ? (C4646n) obj : null;
        Map map = Map.class.isAssignableFrom(cls) ? (Map) obj : null;
        C4628b c4628b = new C4628b(obj);
        StringWriter stringWriter = new StringWriter();
        StringWriter stringWriter2 = new StringWriter();
        do {
            boolean z10 = true;
            while (true) {
                i10 = reader.read();
                if (i10 == -1 || i10 == 38) {
                    break;
                }
                if (i10 != 61) {
                    if (z10) {
                        stringWriter.write(i10);
                    } else {
                        stringWriter2.write(i10);
                    }
                } else if (z10) {
                    z10 = false;
                } else {
                    stringWriter2.write(i10);
                }
            }
            String strM78323a = C13014a.m78323a(stringWriter.toString());
            if (strM78323a.length() != 0) {
                String strM78323a2 = C13014a.m78323a(stringWriter2.toString());
                C4645m c4645mM28430b = c4638gM28427f.m28430b(strM78323a);
                if (c4645mM28430b != null) {
                    m28184e(obj, listAsList, c4628b, c4645mM28430b, strM78323a2);
                } else if (map != null) {
                    m28186g(c4646n, map, (ArrayList) map.get(strM78323a), strM78323a, strM78323a2);
                }
            }
            stringWriter = new StringWriter();
            stringWriter2 = new StringWriter();
        } while (i10 != -1);
        c4628b.m28398b();
    }

    /* renamed from: d */
    public static void m28183d(String str, Object obj) {
        if (str == null) {
            return;
        }
        try {
            m28182c(new StringReader(str), obj);
        } catch (IOException e10) {
            throw C4635e0.m28408a(e10);
        }
    }

    /* renamed from: e */
    public static void m28184e(Object obj, List<Type> list, C4628b c4628b, C4645m c4645m, String str) {
        Type typeM28450m = C4642j.m28450m(list, c4645m.m28466d());
        if (C4637f0.m28421j(typeM28450m)) {
            Class<?> clsM28417f = C4637f0.m28417f(list, C4637f0.m28413b(typeM28450m));
            c4628b.m28397a(c4645m.m28465b(), clsM28417f, m28185f(clsM28417f, list, str));
        } else {
            if (!C4637f0.m28422k(C4637f0.m28417f(list, typeM28450m), Iterable.class)) {
                c4645m.m28472m(obj, m28185f(typeM28450m, list, str));
                return;
            }
            Collection<Object> collectionM28445h = (Collection) c4645m.m28469g(obj);
            if (collectionM28445h == null) {
                collectionM28445h = C4642j.m28445h(typeM28450m);
                c4645m.m28472m(obj, collectionM28445h);
            }
            collectionM28445h.add(m28185f(typeM28450m == Object.class ? null : C4637f0.m28415d(typeM28450m), list, str));
        }
    }

    /* renamed from: f */
    public static Object m28185f(Type type, List<Type> list, String str) {
        return C4642j.m28449l(C4642j.m28450m(list, type), str);
    }

    /* renamed from: g */
    public static void m28186g(C4646n c4646n, Map<Object, Object> map, ArrayList<String> arrayList, String str, String str2) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            if (c4646n != null) {
                c4646n.set(str, arrayList);
            } else {
                map.put(str, arrayList);
            }
        }
        arrayList.add(str2);
    }
}
