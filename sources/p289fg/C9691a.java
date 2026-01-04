package p289fg;

import android.content.Context;
import bf.AbstractC1177c;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.offlinelocate.C4375j;
import p521og.C11877j;
import p575qe.C12347f;
import p809yg.C13981a;

/* renamed from: fg.a */
/* loaded from: classes4.dex */
public class C9691a extends AbstractC1177c {

    /* renamed from: l */
    public String f47916l;

    /* renamed from: m */
    public String f47917m;

    public C9691a(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
        this.f47916l = this.f5581b.getCmdParamValue("changeType");
        this.f47917m = this.f5581b.getCmdParamValue("mkversion");
        C13981a.m83989i("TrustChange", "mChangeType:" + this.f47916l + " mMkVersion:" + this.f47917m);
    }

    /* renamed from: X */
    public static int m60517X(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return Integer.MIN_VALUE;
        }
    }

    /* renamed from: W */
    public final void m60518W() {
        C13981a.m83989i("TrustChange", "clearSpOfReport");
        Context contextM74301m = C12347f.m74285n().m74301m();
        if (contextM74301m == null) {
            C13981a.m83989i("TrustChange", "handleControlCmd context is null");
            return;
        }
        C11877j.m71286m1(contextM74301m, false);
        C11877j.m71289n1(contextM74301m, 0L);
        C11877j.m71291o0(contextM74301m, "mac_key");
    }

    @Override // bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        C13981a.m83989i("TrustChange", "handleControlCmd mChangeType:" + this.f47916l + " mMkVersion:" + this.f47917m);
        int iM60517X = m60517X(this.f47917m);
        int iM60517X2 = m60517X(this.f47916l);
        if (iM60517X2 == 1 && iM60517X > 0) {
            C4375j.m26421w(true);
        } else if (iM60517X2 == 3) {
            m60518W();
        } else {
            C13981a.m83989i("TrustChange", "handleControlCmd error");
        }
        this.f5582c = 0;
        m7427Q("TrustChange", "0", -1, "TrustChange handleControlCmd", null, this.f5581b.getOperation(), "trustRingChange", false, null);
    }
}
