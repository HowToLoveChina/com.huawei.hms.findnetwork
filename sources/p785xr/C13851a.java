package p785xr;

import android.net.Uri;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.location.BuildConfig;
import com.huawei.openalliance.p169ad.constant.Constants;
import es.C9543h;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import sr.C12847b;

/* renamed from: xr.a */
/* loaded from: classes8.dex */
public class C13851a {

    /* renamed from: a */
    public final String f62120a;

    /* renamed from: b */
    public String f62121b;

    /* renamed from: c */
    public String f62122c;

    /* renamed from: d */
    public SortedMap<String, String> f62123d;

    /* renamed from: e */
    public final C13852b f62124e;

    /* renamed from: f */
    public final String f62125f;

    /* renamed from: g */
    public final byte[] f62126g;

    /* renamed from: xr.a$a */
    public static final class a {

        /* renamed from: a */
        public SortedMap<String, String> f62127a;

        /* renamed from: b */
        public String f62128b;

        /* renamed from: c */
        public String f62129c;

        /* renamed from: d */
        public byte[] f62130d;

        /* renamed from: e */
        public String f62131e;

        /* renamed from: f */
        public String f62132f = "POST";

        /* renamed from: g */
        public C13852b f62133g;

        public a(String str) {
            this.f62129c = str;
        }

        /* renamed from: h */
        public a m83138h(SortedMap<String, String> sortedMap) {
            if (sortedMap == null) {
                return this;
            }
            if (this.f62127a == null) {
                this.f62127a = new TreeMap();
            }
            this.f62127a.putAll(sortedMap);
            return this;
        }

        /* renamed from: i */
        public a m83139i(String str, String str2) {
            if (this.f62133g == null) {
                this.f62133g = new C13852b();
            }
            this.f62133g.m83148a(str, str2);
            return this;
        }

        /* renamed from: j */
        public a m83140j(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.f62127a == null) {
                    this.f62127a = new TreeMap();
                }
                this.f62127a.put(str, str2);
            }
            return this;
        }

        /* renamed from: k */
        public C13851a m83141k() {
            if (TextUtils.isEmpty(this.f62128b)) {
                this.f62128b = C12847b.m77149d(BuildConfig.LIBRARY_PACKAGE_NAME);
            }
            return new C13851a(this);
        }

        /* renamed from: l */
        public a m83142l(String str) {
            C13852b c13852b = this.f62133g;
            if (c13852b == null) {
                return this;
            }
            c13852b.m83152e(str);
            return this;
        }

        /* renamed from: m */
        public a m83143m(String str) {
            this.f62128b = str;
            return this;
        }

        /* renamed from: n */
        public a m83144n(C13853c c13853c) {
            this.f62130d = c13853c.m83155b().getBytes();
            this.f62131e = c13853c.m83154a();
            return this;
        }

        /* renamed from: o */
        public a m83145o(byte[] bArr, String str) {
            this.f62130d = bArr;
            this.f62131e = str;
            return this;
        }

        /* renamed from: p */
        public a m83146p(C13852b c13852b) {
            this.f62133g = c13852b;
            return this;
        }

        /* renamed from: q */
        public a m83147q(String str) {
            this.f62132f = str;
            return this;
        }
    }

    public C13851a(a aVar) {
        this.f62121b = aVar.f62128b;
        this.f62124e = aVar.f62133g;
        this.f62126g = aVar.f62130d;
        this.f62120a = aVar.f62132f;
        this.f62125f = aVar.f62131e;
        this.f62122c = aVar.f62129c;
        this.f62123d = aVar.f62127a;
        m83130j();
    }

    /* renamed from: a */
    public String m83121a() {
        return this.f62121b;
    }

    /* renamed from: b */
    public byte[] m83122b() {
        return this.f62126g;
    }

    /* renamed from: c */
    public String m83123c() {
        return this.f62125f;
    }

    /* renamed from: d */
    public String m83124d() {
        Uri.Builder builderBuildUpon = Uri.parse(this.f62121b).buildUpon();
        if (!TextUtils.isEmpty(this.f62122c)) {
            builderBuildUpon.path(this.f62122c);
        }
        SortedMap<String, String> sortedMap = this.f62123d;
        if (sortedMap != null) {
            for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
                builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return C9543h.m59591c(builderBuildUpon.build().toString());
    }

    /* renamed from: e */
    public C13852b m83125e() {
        return this.f62124e;
    }

    /* renamed from: f */
    public String m83126f() {
        return this.f62120a;
    }

    /* renamed from: g */
    public String m83127g() {
        return this.f62122c;
    }

    /* renamed from: h */
    public String m83128h() {
        if (this.f62123d == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f62123d.entrySet()) {
            if (sb2.length() > 0) {
                sb2.append("&");
            }
            sb2.append(entry.getKey());
            sb2.append("=");
            sb2.append(entry.getValue());
        }
        return sb2.toString();
    }

    /* renamed from: i */
    public a m83129i() {
        return new a(this.f62122c).m83143m(this.f62121b).m83145o(this.f62126g, this.f62125f).m83146p(this.f62124e).m83147q(this.f62120a).m83138h(this.f62123d);
    }

    /* renamed from: j */
    public final void m83130j() {
        if (this.f62122c.contains(Constants.QUESTION_STR)) {
            if (this.f62123d == null) {
                this.f62123d = new TreeMap();
            }
            try {
                URI uriCreate = URI.create(C9543h.m59591c(this.f62121b + this.f62122c));
                String query = uriCreate.getQuery();
                if (query == null) {
                    return;
                }
                this.f62121b = uriCreate.getScheme() + "://" + uriCreate.getHost();
                this.f62122c = uriCreate.getPath();
                String[] strArrSplit = query.split("&");
                int length = strArrSplit.length;
                for (int i10 = 0; i10 < length; i10++) {
                    String[] strArrSplit2 = strArrSplit[i10].split("=");
                    if (strArrSplit2.length == 2) {
                        this.f62123d.put(strArrSplit2[0], strArrSplit2[1]);
                    }
                }
            } catch (IllegalArgumentException unused) {
                C1016d.m6183c("BaseRequest", "parse query failed");
            }
        }
    }

    public String toString() {
        return "BaseRequest{method='" + this.f62120a + "', baseUrl='" + this.f62121b + "', path='" + this.f62122c + "', heads=" + this.f62124e + ", contentType='" + this.f62125f + "', body=" + new String(this.f62126g, StandardCharsets.UTF_8) + '}';
    }
}
