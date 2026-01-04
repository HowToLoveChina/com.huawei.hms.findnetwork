package p742wj;

import android.os.Handler;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hwcloudjs.C6618c;
import p399jk.AbstractC10896a;

/* renamed from: wj.c */
/* loaded from: classes5.dex */
public class C13613c extends C13614d {

    /* renamed from: b */
    public Handler f61267b;

    public C13613c(Handler handler) {
        this.f61267b = handler;
    }

    @Override // p742wj.C13614d
    /* renamed from: b */
    public void mo81903b() {
        if (this.f61267b != null) {
            AbstractC10896a.m65887i("LoginConsistentCallbackHandler", "notifyAccountConsistent");
            this.f61267b.sendEmptyMessage(ConnectionResult.SERVICE_UPDATING);
        }
    }

    @Override // p742wj.C13614d
    /* renamed from: c */
    public void mo81904c() {
        if (this.f61267b != null) {
            AbstractC10896a.m65887i("LoginConsistentCallbackHandler", "notifyAccountInConsistent");
            this.f61267b.sendEmptyMessage(9003);
        }
    }

    @Override // p742wj.C13614d
    /* renamed from: d */
    public void mo81905d() {
        if (this.f61267b != null) {
            AbstractC10896a.m65887i("LoginConsistentCallbackHandler", "notifyAuthFailed");
            this.f61267b.sendEmptyMessage(C6618c.f30770o);
        }
    }

    @Override // p742wj.C13614d
    /* renamed from: f */
    public void mo81906f() {
        if (this.f61267b != null) {
            AbstractC10896a.m65887i("LoginConsistentCallbackHandler", "notifyLoginCanceled");
            this.f61267b.sendEmptyMessage(ConnectionResult.SIGN_IN_FAILED);
        }
    }
}
