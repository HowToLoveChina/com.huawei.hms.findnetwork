package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import hu.C10343b;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p031b7.C1136q;
import p650t7.C12977m;
import p764x6.AbstractC13709a;
import p765x7.C13720b;

/* renamed from: s7.m */
/* loaded from: classes2.dex */
public class C12744m extends AbstractC12758w {

    /* renamed from: l */
    public String f58360l;

    /* renamed from: m */
    public long f58361m;

    /* renamed from: n */
    public List<String> f58362n;

    /* renamed from: o */
    public int f58363o;

    /* renamed from: p */
    public boolean f58364p;

    public C12744m(Context context, String str, List<String> list, long j10, int i10, String str2) {
        this.f58363o = 500;
        this.f58364p = false;
        this.f60186b = context;
        this.f60189e = str;
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.file.querychange";
        this.f58362n = list;
        this.f58361m = j10;
        this.f58363o = i10;
        this.f58360l = str2;
        this.f58364p = C12740k.m76570y(list);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        List<String> list = this.f58362n;
        if (list != null && !list.isEmpty()) {
            jSONObject.put("albumIds", new JSONArray((Collection) this.f58362n));
        }
        jSONObject.put("needUrl", false);
        jSONObject.put("latestVersion", this.f58361m);
        jSONObject.put("limit", this.f58363o);
        String str = this.f58360l;
        if (str != null) {
            jSONObject.put(SyncProtocol.Constant.CURSOR, str);
        }
        if (!TextUtils.isEmpty(C1136q.b.m7035X(this.f60186b))) {
            jSONObject.put(SyncProtocol.Constant.SYNC_TOKEN, C1136q.b.m7035X(this.f60186b));
        }
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "General.Changes.list";
        C12977m c12977m = new C12977m(this.f58361m, this.f58363o, this.f58360l, this.f58364p);
        c12977m.m82456i(this.f60189e);
        return c12977m;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) throws JSONException {
        Bundle bundleM76568w = C12740k.m76568w(str, this.f58364p);
        if (bundleM76568w != null) {
            C10343b c10343b = new C10343b(bundleM76568w);
            bundleM76568w.putString("errMsg", C12740k.m76569x(this.f58360l, 6) + "_" + c10343b.m63694p("errMsg"));
        }
        return bundleM76568w;
    }
}
