package p701v6;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import gp.C10028c;
import java.util.Map;
import p009a8.C0073k;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p260ek.C9499a;
import p649t6.C12943c;
import p664u0.C13108a;
import p681uj.C13199p;
import p764x6.AbstractC13709a;

/* renamed from: v6.a */
/* loaded from: classes2.dex */
public abstract class AbstractC13354a<T> {

    /* renamed from: b */
    public Context f60186b;

    /* renamed from: c */
    public String f60187c;

    /* renamed from: d */
    public String f60188d;

    /* renamed from: g */
    public Map<String, String> f60191g;

    /* renamed from: a */
    public AbstractC13709a<T> f60185a = null;

    /* renamed from: e */
    public String f60189e = "";

    /* renamed from: f */
    public String f60190f = "";

    /* renamed from: h */
    public boolean f60192h = false;

    /* renamed from: i */
    public boolean f60193i = false;

    /* renamed from: j */
    public boolean f60194j = false;

    /* renamed from: v6.a$a */
    public class a extends AbstractC13355b<T> {
        public a(Context context, Map map, String str) {
            super(context, map, str);
        }

        @Override // p701v6.AbstractC13355b
        /* renamed from: g */
        public void mo80116g() throws Exception {
            AbstractC13354a.this.mo14589a();
            AbstractC13354a abstractC13354a = AbstractC13354a.this;
            this.f60198b = abstractC13354a.f60187c;
            String str = abstractC13354a.f60188d;
            this.f60199c = str;
            C0073k.m595d().m598c(this.f60200d, false, C9499a.m59436d(str, "cmd"));
        }
    }

    /* renamed from: a */
    public abstract void mo14589a() throws Exception;

    /* renamed from: b */
    public void m80103b() {
        AbstractC13709a<T> abstractC13709a = this.f60185a;
        if (abstractC13709a != null) {
            abstractC13709a.mo80117a();
        }
    }

    /* renamed from: c */
    public void m80104c(String str) throws Throwable {
        String strM77763n = new C12943c().m77763n(str);
        if (TextUtils.isEmpty(strM77763n)) {
            return;
        }
        if (strM77763n.equals("1.0")) {
            m80106e();
        } else {
            m80107f();
        }
    }

    /* renamed from: d */
    public AbstractC13709a<T> m80105d() {
        if (m80112m()) {
            this.f60185a = mo14591n();
        }
        if (this.f60185a == null) {
            this.f60185a = new a(this.f60186b, this.f60191g, this.f60189e);
        }
        return this.f60185a;
    }

    /* renamed from: e */
    public void m80106e() {
        this.f60193i = true;
    }

    /* renamed from: f */
    public void m80107f() {
        this.f60194j = true;
    }

    /* renamed from: g */
    public String m80108g() throws C13199p {
        AbstractC13709a<T> abstractC13709a = this.f60185a;
        if (abstractC13709a == null) {
            return null;
        }
        return abstractC13709a.mo80118b();
    }

    /* renamed from: h */
    public String m80109h(String str) {
        return str;
    }

    /* renamed from: i */
    public int m80110i() {
        AbstractC13709a<T> abstractC13709a = this.f60185a;
        if (abstractC13709a == null) {
            return 200;
        }
        return abstractC13709a.mo80119c();
    }

    /* renamed from: j */
    public final boolean m80111j() throws Exception {
        if (C0209d.m1173G1(this.f60186b)) {
            C1120a.m6677i("AbstractHttpClientRequest", "runTask(), isPrivacyUser, now send broadcast.");
            C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.PRIVATE_SPACE"));
            throw new C13359f("3024", "Cloud not support PrivateSpace");
        }
        if (mo14590k() && C10028c.m62182c0().m62206E1()) {
            C1120a.m6678w("AbstractHttpClientRequest", "up cmd is not allowed as data migrating");
            throw new C13359f("3026", "cannot dow up cmd as data migrating");
        }
        if (!C10028c.m62182c0().m62375p1()) {
            return false;
        }
        C1120a.m6678w("AbstractHttpClientRequest", "check isForcedUpgrade return null");
        return true;
    }

    /* renamed from: k */
    public boolean mo14590k() {
        return false;
    }

    /* renamed from: l */
    public boolean mo76586l() {
        return true;
    }

    /* renamed from: m */
    public boolean m80112m() {
        if (this.f60193i) {
            return false;
        }
        return this.f60194j || CloudAlbumSettings.m14363h().m14376l();
    }

    /* renamed from: n */
    public AbstractC13709a<T> mo14591n() {
        return null;
    }

    /* renamed from: o */
    public T m80113o(Class<T> cls) throws Exception {
        if (m80111j()) {
            return null;
        }
        if (mo76586l()) {
            SyncSessionManager.m15153t().m15164K(3);
        }
        if (this.f60185a == null) {
            this.f60185a = m80105d();
        }
        return this.f60185a.mo77941d(cls);
    }

    /* renamed from: p */
    public String mo76565p() throws Exception {
        if (m80111j()) {
            return null;
        }
        if (mo76586l()) {
            SyncSessionManager.m15153t().m15164K(3);
        }
        if (this.f60185a == null) {
            this.f60185a = m80105d();
        }
        return this.f60185a.mo80120e();
    }

    /* renamed from: q */
    public void m80114q(boolean z10) {
        if (this.f60185a == null) {
            this.f60185a = m80105d();
        }
        this.f60185a.mo80121f(z10);
    }

    /* renamed from: r */
    public void m80115r() {
        this.f60192h = true;
    }
}
