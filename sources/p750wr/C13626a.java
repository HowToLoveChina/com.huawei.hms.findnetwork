package p750wr;

import android.text.TextUtils;
import as.C1016d;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import es.C9543h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.AbstractC11920f0;
import okhttp3.AbstractC11924h0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import okhttp3.C11955v;
import p022ay.C1057g;
import p688ur.C13243c;
import p688ur.C13244d;
import p688ur.C13245e;
import p785xr.C13851a;
import p785xr.C13852b;
import tr.C13065i;
import tr.C13066j;

/* renamed from: wr.a */
/* loaded from: classes8.dex */
public class C13626a {
    /* renamed from: a */
    public static HashMap<String, String> m81981a(C11955v c11955v) {
        HashMap<String, String> map = new HashMap<>();
        for (String str : c11955v.m71855f()) {
            List<String> listM71860m = c11955v.m71860m(str);
            if (!listM71860m.isEmpty()) {
                Iterator<String> it = listM71860m.iterator();
                while (it.hasNext()) {
                    map.put(str, it.next());
                }
            }
        }
        return map;
    }

    /* renamed from: b */
    public static HttpRequestBuilder m81982b(C13851a c13851a, HttpRequestBuilder.a aVar) throws C13244d {
        if (c13851a == null) {
            return null;
        }
        C1016d.m6181a("ParseHttpUtils", "baseRequest:" + c13851a);
        String strM83126f = c13851a.m83126f();
        try {
            aVar.m71586m(c13851a.m83124d()).m71580g(strM83126f, TextUtils.equals("POST", strM83126f) ? AbstractC11920f0.create(MimeClass.m71445d(!TextUtils.isEmpty(c13851a.m83123c()) ? c13851a.m83123c() : "application/json; charset=utf-8"), C1057g.m6365x(c13851a.m83122b())) : null);
            HashMap<String, String> mapM83151d = c13851a.m83125e().m83151d();
            if (mapM83151d == null) {
                return aVar.m71575b();
            }
            for (Map.Entry<String, String> entry : mapM83151d.entrySet()) {
                if (!TextUtils.isEmpty(entry.getValue())) {
                    aVar.addHeader(entry.getKey(), entry.getValue());
                }
            }
            return aVar.m71575b();
        } catch (IllegalArgumentException unused) {
            throw new C13244d(C13243c.m79629a(10309));
        }
    }

    /* renamed from: c */
    public static C13065i m81983c(HttpResponseBuilder HttpResponseBuilder) throws C13245e {
        AbstractC11924h0 abstractC11924h0M71595s = HttpResponseBuilder.m71595s();
        if (abstractC11924h0M71595s == null) {
            throw new C13245e(C13243c.m79629a(ActivityErrorCode.ENABLE_CONVERSION_EVENT_FAILED));
        }
        HashMap<String, String> mapM81981a = m81981a(HttpResponseBuilder.m71601y());
        MimeClass MimeClassMo71635v = abstractC11924h0M71595s.mo71635v();
        return new C13065i.b().m78810h(new C13066j.b().m78823e(C9543h.m59590b(abstractC11924h0M71595s.m71632s())).m78825g(MimeClassMo71635v != null ? MimeClassMo71635v.toString() : "").m78824f(abstractC11924h0M71595s.mo71634u()).m78822d()).m78813k(new C13852b().m83149b(mapM81981a)).m78814l(HttpResponseBuilder.m71602z()).m78812j(HttpResponseBuilder.m71597u()).m78817o(HttpResponseBuilder.m71593E().m71573m().toString()).m78811i();
    }
}
