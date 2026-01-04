package p701v6;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.request.response.QueryUserSpaceResponse;
import org.json.JSONObject;
import p031b7.C1120a;
import p764x6.AbstractC13709a;
import p764x6.C13718j;

/* renamed from: v6.h */
/* loaded from: classes2.dex */
public class C13361h extends AbstractC13354a<QueryUserSpaceResponse> {

    /* renamed from: p */
    public static String f60233p;

    /* renamed from: q */
    public static QueryUserSpaceResponse f60234q;

    /* renamed from: r */
    public static long f60235r;

    /* renamed from: k */
    public String f60236k;

    /* renamed from: l */
    public String f60237l;

    /* renamed from: m */
    public String f60238m;

    /* renamed from: n */
    public String f60239n;

    /* renamed from: o */
    public boolean f60240o;

    public C13361h(String str, Context context) {
        this.f60186b = context;
        this.f60187c = m80109h("/JPJX/BaseAPI");
        this.f60189e = str;
        this.f60240o = false;
        m80107f();
    }

    /* renamed from: s */
    public static boolean m80150s() {
        return TextUtils.isEmpty(f60233p) || System.currentTimeMillis() - f60235r > 30000;
    }

    /* renamed from: t */
    public static synchronized QueryUserSpaceResponse m80151t(C13361h c13361h, Class<QueryUserSpaceResponse> cls) throws Exception {
        try {
            if (m80150s()) {
                f60234q = c13361h.m80113o(cls);
                f60235r = System.currentTimeMillis();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f60234q;
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", "bapi.dbank.queryspace");
        String str = this.f60236k;
        if (str != null) {
            jSONObject.put("queryType", str);
        }
        if (!TextUtils.isEmpty(this.f60237l) && !TextUtils.isEmpty(this.f60238m) && !TextUtils.isEmpty(this.f60239n)) {
            jSONObject.put("ownerId", this.f60237l);
            jSONObject.put("resource", this.f60238m);
            jSONObject.put("shareId", this.f60239n);
        }
        C1120a.m6675d("UserSpaceQueryRequest", "bapi.dbank.queryspace");
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a<QueryUserSpaceResponse> mo14591n() {
        C13718j c13718j = new C13718j(this.f60189e);
        c13718j.m82471o(this.f60236k);
        c13718j.m82472p(this.f60239n);
        c13718j.m82470n(this.f60237l);
        c13718j.m82469m(this.f60240o);
        return c13718j;
    }

    /* renamed from: u */
    public QueryUserSpaceResponse m80152u(Class<QueryUserSpaceResponse> cls, boolean z10) throws Exception {
        return !z10 ? (QueryUserSpaceResponse) super.m80113o(cls) : m80151t(this, cls);
    }

    public C13361h(Context context, String str) {
        this.f60186b = context;
        this.f60187c = m80109h("/JPJX/BaseAPI");
        this.f60236k = str;
        this.f60240o = true;
        m80107f();
    }

    public C13361h(Context context, String str, String str2, String str3, String str4, boolean z10) throws Throwable {
        this.f60186b = context;
        this.f60237l = str;
        this.f60238m = str2;
        this.f60239n = str3;
        this.f60187c = m80109h("/JPJX/BaseAPI");
        this.f60189e = str4;
        this.f60240o = z10;
        if (CloudAlbumSettings.m14363h().m14378n()) {
            m80107f();
        } else {
            m80104c(str3);
        }
    }
}
