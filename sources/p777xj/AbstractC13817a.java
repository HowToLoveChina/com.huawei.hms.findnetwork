package p777xj;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.cloudservice.ICloudAccount;
import p015ak.C0209d;
import p015ak.C0213f;
import p399jk.AbstractC10896a;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* renamed from: xj.a */
/* loaded from: classes5.dex */
public abstract class AbstractC13817a {

    /* renamed from: a */
    public ICloudAccount f62020a;

    /* renamed from: b */
    public final ServiceConnection f62021b = new a();

    /* renamed from: xj.a$a */
    public class a implements ServiceConnection {

        /* renamed from: xj.a$a$a, reason: collision with other inner class name */
        public class C14514a extends AbstractC12367d {
            public C14514a() {
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                AbstractC13817a.this.mo57289f();
                AbstractC13817a.this.m82863i();
            }
        }

        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AbstractC10896a.m65887i("HmsLogoutBaseRegister", "onServiceConnected");
            AbstractC13817a.this.f62020a = ICloudAccount.Stub.asInterface(iBinder);
            if (AbstractC13817a.this.f62020a == null) {
                AbstractC10896a.m65887i("HmsLogoutBaseRegister", "onServiceConnected null");
            } else {
                C12515a.m75110o().m75175e(new C14514a(), false);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AbstractC10896a.m65887i("HmsLogoutBaseRegister", "onServiceDisconnected");
            AbstractC13817a.this.f62020a = null;
        }
    }

    /* renamed from: b */
    public final void m82860b() {
        if (this.f62020a != null) {
            AbstractC10896a.m65887i("HmsLogoutBaseRegister", "mCloudAccount not null");
            return;
        }
        AbstractC10896a.m65887i("HmsLogoutBaseRegister", "bindService");
        try {
            Context contextM1377a = C0213f.m1377a();
            Intent intent = new Intent();
            intent.setAction("com.huawei.hwid.ICloudService");
            C0209d.m1302r2(intent, "com.huawei.hwid");
            contextM1377a.bindService(intent, this.f62021b, 1);
        } catch (Exception e10) {
            AbstractC10896a.m65887i("HmsLogoutBaseRegister", "bindService exception:" + e10.getMessage());
        }
    }

    /* renamed from: c */
    public abstract int mo57287c();

    /* renamed from: d */
    public abstract Intent mo57288d();

    /* renamed from: e */
    public final int m82861e() {
        return 50;
    }

    /* renamed from: f */
    public abstract void mo57289f();

    /* renamed from: g */
    public abstract void mo57290g();

    /* renamed from: h */
    public void m82862h() {
        try {
            if (this.f62020a == null) {
                AbstractC10896a.m65887i("HmsLogoutBaseRegister", "setLogoutIntent2: mCloudAccount null");
                return;
            }
            int logoutIntent2 = this.f62020a.setLogoutIntent2(mo57288d(), m82861e(), mo57287c());
            if (2 == logoutIntent2) {
                mo57290g();
            }
            AbstractC10896a.m65887i("HmsLogoutBaseRegister", "setLogoutIntent2 result:" + logoutIntent2);
        } catch (Exception e10) {
            AbstractC10896a.m65887i("HmsLogoutBaseRegister", "onServiceConnected exception " + e10.getMessage());
        }
    }

    /* renamed from: i */
    public final void m82863i() {
        if (this.f62020a == null) {
            AbstractC10896a.m65887i("HmsLogoutBaseRegister", "mCloudAccount null");
            return;
        }
        AbstractC10896a.m65887i("HmsLogoutBaseRegister", "unBindService");
        try {
            C0213f.m1377a().unbindService(this.f62021b);
        } catch (Exception e10) {
            AbstractC10896a.m65887i("HmsLogoutBaseRegister", "unbindService exception:" + e10.getMessage());
        }
        this.f62020a = null;
    }
}
