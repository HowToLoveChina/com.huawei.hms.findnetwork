package gg;

import android.content.Context;
import android.os.Handler;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import p521og.C11880m;
import p709vj.InterfaceC13451d;
import p809yg.C13981a;

/* renamed from: gg.a */
/* loaded from: classes4.dex */
public class C9916a implements InterfaceC13451d {

    /* renamed from: a */
    public Handler f48665a;

    /* renamed from: b */
    public Context f48666b;

    public C9916a(Handler handler, Context context) {
        this.f48665a = handler;
        this.f48666b = context;
    }

    @Override // p709vj.InterfaceC13451d
    /* renamed from: a */
    public void mo17021a(ErrorStatus errorStatus) {
        if (errorStatus != null && !errorStatus.getErrorReason().isEmpty() && errorStatus.getErrorCode() != 3002) {
            C13981a.m83988e("CheckPwdRequest", "CloudAccount on error reason: " + errorStatus.getErrorReason());
            Context context = this.f48666b;
            if (context != null) {
                C11880m.m71336c(context, R$string.phonefinder_remand_download_hms);
            }
        }
        Handler handler = this.f48665a;
        if (handler != null) {
            handler.obtainMessage(4008).sendToTarget();
        }
    }

    @Override // p709vj.InterfaceC13451d
    /* renamed from: b */
    public void mo17022b(String str) {
        Handler handler = this.f48665a;
        if (handler != null) {
            handler.obtainMessage(4007, str).sendToTarget();
        }
    }
}
