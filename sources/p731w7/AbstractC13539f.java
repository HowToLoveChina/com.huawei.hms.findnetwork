package p731w7;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.hihttp.able.HttpErrorHandler;
import p031b7.C1120a;
import p635s7.AbstractC12758w;
import p701v6.AbstractC13354a;
import p731w7.AbstractC13539f;

/* renamed from: w7.f */
/* loaded from: classes2.dex */
public abstract class AbstractC13539f<T extends AbstractC13539f, Result> extends AbstractC13534a<T> {

    /* renamed from: f */
    public int f60918f = -1;

    /* renamed from: g */
    public int f60919g = -1;

    /* renamed from: h */
    public String f60920h = "";

    /* renamed from: i */
    public AbstractC13354a f60921i;

    /* renamed from: j */
    public HttpErrorHandler f60922j;

    /* renamed from: k */
    public String f60923k;

    /* renamed from: A */
    public abstract Result mo81440A(int i10, String str, String str2);

    /* renamed from: B */
    public void m81451B(AbstractC13354a abstractC13354a) {
        this.f60921i = abstractC13354a;
    }

    /* renamed from: C */
    public void m81452C(HttpErrorHandler httpErrorHandler) {
        this.f60922j = httpErrorHandler;
    }

    /* renamed from: D */
    public void m81453D(String str) {
        this.f60923k = str;
    }

    @Override // p731w7.AbstractC13534a
    /* renamed from: e */
    public void mo81428e() {
        C1120a.m6677i("ProtocolRequest", "cancel");
        super.mo81428e();
        AbstractC13354a abstractC13354a = this.f60921i;
        if (abstractC13354a != null) {
            abstractC13354a.m80103b();
        }
    }

    /* renamed from: s */
    public int m81454s() {
        return this.f60918f;
    }

    /* renamed from: t */
    public String m81455t() {
        return this.f60920h;
    }

    /* renamed from: u */
    public AbstractC13354a m81456u() {
        return this.f60921i;
    }

    /* renamed from: v */
    public String m81457v() {
        AbstractC13354a abstractC13354a = this.f60921i;
        return (abstractC13354a == null || !(abstractC13354a instanceof AbstractC12758w)) ? "cmd" : ((AbstractC12758w) abstractC13354a).m76584t();
    }

    /* renamed from: w */
    public HttpErrorHandler m81458w() {
        return this.f60922j;
    }

    /* renamed from: x */
    public int m81459x() {
        return this.f60919g;
    }

    /* renamed from: y */
    public Bundle m81460y(String str) {
        AbstractC13354a abstractC13354a = this.f60921i;
        if (abstractC13354a == null || !(abstractC13354a instanceof AbstractC12758w)) {
            return null;
        }
        Bundle bundleM76583s = ((AbstractC12758w) abstractC13354a).m76583s(str);
        if (bundleM76583s != null && !TextUtils.isEmpty(this.f60923k)) {
            bundleM76583s.putString("sessionId", this.f60923k);
        }
        return bundleM76583s;
    }

    /* renamed from: z */
    public String m81461z() {
        return this.f60923k;
    }
}
