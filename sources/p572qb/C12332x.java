package p572qb;

import android.content.Context;
import android.content.IntentFilter;
import com.huawei.android.hicloud.receiver.OperateMsgNotifyClickReceiver;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: qb.x */
/* loaded from: classes3.dex */
public class C12332x {

    /* renamed from: b */
    public static C12332x f57090b;

    /* renamed from: c */
    public static final Object f57091c = new Object();

    /* renamed from: a */
    public OperateMsgNotifyClickReceiver f57092a;

    /* renamed from: a */
    public static C12332x m74156a() {
        C12332x c12332x;
        synchronized (f57091c) {
            try {
                if (f57090b == null) {
                    f57090b = new C12332x();
                }
                c12332x = f57090b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c12332x;
    }

    /* renamed from: b */
    public void m74157b() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i("OperateMsgClickReceiverManager", "registerReceiver context is null");
            return;
        }
        if (this.f57092a == null) {
            this.f57092a = new OperateMsgNotifyClickReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.cloud.OPERATE_MSG_CILCK_NOTIFICATION");
        this.f57092a.m29111a(contextM1377a, intentFilter);
    }

    /* renamed from: c */
    public void m74158c() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i("OperateMsgClickReceiverManager", "unregisterReceiver context is null");
            return;
        }
        OperateMsgNotifyClickReceiver operateMsgNotifyClickReceiver = this.f57092a;
        if (operateMsgNotifyClickReceiver != null) {
            operateMsgNotifyClickReceiver.m29112b(contextM1377a);
        }
    }
}
