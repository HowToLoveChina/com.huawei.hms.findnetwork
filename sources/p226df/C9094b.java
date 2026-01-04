package p226df;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.huawei.android.remotecontrol.service.PhoneFinderService;
import p521og.C11877j;
import p575qe.C12347f;
import p777xj.AbstractC13817a;
import p809yg.C13981a;

/* renamed from: df.b */
/* loaded from: classes4.dex */
public class C9094b extends AbstractC13817a {
    @Override // p777xj.AbstractC13817a
    /* renamed from: c */
    public int mo57287c() {
        return 2;
    }

    @Override // p777xj.AbstractC13817a
    /* renamed from: d */
    public Intent mo57288d() {
        Context contextM74301m = C12347f.m74285n().m74301m();
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.remotecontrol.action.CLOSE_PHONE_FINDER");
        intent.setComponent(new ComponentName(contextM74301m, (Class<?>) PhoneFinderService.class));
        return intent;
    }

    @Override // p777xj.AbstractC13817a
    /* renamed from: f */
    public void mo57289f() {
        m82862h();
    }

    @Override // p777xj.AbstractC13817a
    /* renamed from: g */
    public void mo57290g() {
        C13981a.m83989i("PhoneFinderLogoutRegister", "processAfterRegisterSuccess");
        C11877j.m71199B0(C12347f.m74285n().m74301m());
    }
}
