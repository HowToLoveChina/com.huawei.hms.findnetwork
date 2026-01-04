package p029b5;

import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* renamed from: b5.i */
/* loaded from: classes.dex */
public class C1116i extends AbstractC1108a<b> {

    /* renamed from: c */
    public String f5315c;

    /* renamed from: d */
    public b f5316d;

    /* renamed from: e */
    public a f5317e;

    /* renamed from: f */
    public Set<String> f5318f;

    /* renamed from: b5.i$a */
    public static class a {

        /* renamed from: a */
        public String f5319a;

        /* renamed from: b */
        public Set<String> f5320b = new HashSet();

        /* renamed from: c */
        public Set<String> f5321c;

        /* renamed from: e */
        public Set<String> m6642e() {
            return this.f5321c;
        }

        /* renamed from: f */
        public String m6643f() {
            return this.f5319a;
        }

        /* renamed from: g */
        public Set<String> m6644g() {
            return this.f5320b;
        }
    }

    /* renamed from: b5.i$b */
    public static class b {

        /* renamed from: a */
        public List<a> f5322a = new ArrayList();

        /* renamed from: b */
        public List<a> m6646b() {
            return this.f5322a;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: b */
    public void mo6626b(String str) {
        if (!TextUtils.isEmpty(str) && "path".equals(this.f5315c) && str.startsWith("external/")) {
            this.f5317e.f5320b.add(str);
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: c */
    public void mo6627c(String str) {
        this.f5315c = str;
        if ("package".equals(str)) {
            a aVar = new a();
            this.f5317e = aVar;
            aVar.f5321c = this.f5318f;
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: d */
    public void mo6628d(String str) {
        if ("package".equals(str) && !TextUtils.isEmpty(this.f5317e.f5319a)) {
            this.f5316d.f5322a.add(this.f5317e);
            this.f5317e = null;
        } else if (this.f5280b.equals(str)) {
            this.f5279a = false;
        } else {
            C2111d.m12646b("TrustListParserImpl", "unKnow Element");
        }
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: g */
    public void mo6630g(Map<String, String> map) {
        if (map == null) {
            return;
        }
        if ("package".equals(this.f5315c)) {
            this.f5317e.f5319a = map.get("name");
        } else if ("group".equals(this.f5315c)) {
            this.f5318f = m6637m(map.get("country"));
        } else {
            C2111d.m12646b("TrustListParserImpl", "unknown condition");
        }
    }

    @Override // p029b5.AbstractC1108a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void mo6618j(b bVar, String str) {
        this.f5316d = bVar;
        this.f5279a = true;
        this.f5280b = str;
    }

    /* renamed from: m */
    public final Set<String> m6637m(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptySet();
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length == 0) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (String str2 : strArrSplit) {
            String strTrim = str2.trim();
            Locale locale = Locale.ENGLISH;
            if (!TextUtils.isEmpty(strTrim.toUpperCase(locale))) {
                hashSet.add(str2.trim().toUpperCase(locale));
            }
        }
        return hashSet;
    }
}
