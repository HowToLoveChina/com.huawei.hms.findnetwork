package p777xj;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.cloudservice.IHwIDCallback;
import p399jk.AbstractC10896a;

/* renamed from: xj.b */
/* loaded from: classes5.dex */
public class C13818b extends AbstractC13817a {

    /* renamed from: c */
    public final IHwIDCallback f62024c = new a();

    /* renamed from: xj.b$a */
    public class a extends IHwIDCallback.Stub {
        public a() {
        }

        @Override // com.huawei.cloudservice.IHwIDCallback
        public void getIntentResult(int i10, Intent intent) throws RemoteException {
            AbstractC10896a.m65887i("HmsSetLogoutEnableRegister", "iHwIDCallback getIntentResult result:" + i10);
        }

        @Override // com.huawei.cloudservice.IHwIDCallback
        public void getQrContentResult(int i10, String str) throws RemoteException {
            AbstractC10896a.m65887i("HmsSetLogoutEnableRegister", "iHwIDCallback getQrContentResult result:" + i10);
        }

        @Override // com.huawei.cloudservice.IHwIDCallback
        public void getRealNameInfoResult(int i10, Bundle bundle) throws RemoteException {
            AbstractC10896a.m65887i("HmsSetLogoutEnableRegister", "iHwIDCallback getRealNameInfoResult result:" + i10);
        }

        @Override // com.huawei.cloudservice.IHwIDCallback
        public void loginResult(int i10, Bundle bundle) throws RemoteException {
            AbstractC10896a.m65887i("HmsSetLogoutEnableRegister", " iHwIDCallback loginResult result:" + i10);
        }

        @Override // com.huawei.cloudservice.IHwIDCallback
        public void logoutResult(int i10) throws RemoteException {
            AbstractC10896a.m65887i("HmsSetLogoutEnableRegister", "iHwIDCallback logoutResult result:" + i10);
        }
    }

    @Override // p777xj.AbstractC13817a
    /* renamed from: c */
    public int mo57287c() {
        return 0;
    }

    @Override // p777xj.AbstractC13817a
    /* renamed from: d */
    public Intent mo57288d() {
        return null;
    }

    @Override // p777xj.AbstractC13817a
    /* renamed from: f */
    public void mo57289f() {
        m82864j();
    }

    @Override // p777xj.AbstractC13817a
    /* renamed from: g */
    public void mo57290g() {
    }

    /* renamed from: j */
    public final void m82864j() {
        try {
            if (this.f62020a == null) {
                AbstractC10896a.m65887i("HmsSetLogoutEnableRegister", "setLogoutEnable: mCloudAccount null");
            } else {
                AbstractC10896a.m65887i("HmsSetLogoutEnableRegister", "setLogoutEnable");
                this.f62020a.setLogoutEnable("com.huawei.hidisk", true, this.f62024c);
            }
        } catch (Exception e10) {
            AbstractC10896a.m65887i("HmsSetLogoutEnableRegister", "setLogoutEnable exception " + e10.getMessage());
        }
    }
}
