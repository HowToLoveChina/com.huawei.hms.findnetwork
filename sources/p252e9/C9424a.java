package p252e9;

import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.task.simple.C3103z1;
import p514o9.C11839m;
import p616rk.C12515a;

/* renamed from: e9.a */
/* loaded from: classes3.dex */
public class C9424a {

    /* renamed from: a */
    public boolean f47099a;

    /* renamed from: e9.a$b */
    public static class b {

        /* renamed from: a */
        public static final C9424a f47100a = new C9424a();
    }

    public /* synthetic */ C9424a(a aVar) {
        this();
    }

    /* renamed from: a */
    public static C9424a m59104a() {
        return b.f47100a;
    }

    /* renamed from: b */
    public void m59105b(Handler handler) {
        if (handler != null) {
            Message messageObtain = Message.obtain(handler);
            messageObtain.obj = Boolean.valueOf(this.f47099a);
            messageObtain.what = 1050;
            messageObtain.arg1 = 1;
            handler.sendMessage(messageObtain);
        }
        C12515a.m75110o().m75175e(new C3103z1(handler), false);
    }

    /* renamed from: c */
    public void m59106c(boolean z10) {
        C11839m.m70686d("BackUpClearManager", "refreshCondition: " + z10);
        this.f47099a = z10;
    }

    public C9424a() {
    }
}
