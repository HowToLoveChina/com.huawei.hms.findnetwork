package p681uj;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.push.HmsMessaging;
import p015ak.C0209d;
import p208cq.InterfaceC8937e;
import p399jk.AbstractC10896a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p846zj.C14306d;

/* renamed from: uj.o */
/* loaded from: classes5.dex */
public class C13198o {

    /* renamed from: a */
    public static C13198o f59819a = new C13198o();

    /* renamed from: uj.o$a */
    public class a implements InterfaceC8937e<Void> {

        /* renamed from: a */
        public final /* synthetic */ Handler f59820a;

        /* renamed from: b */
        public final /* synthetic */ long f59821b;

        public a(Handler handler, long j10) {
            this.f59820a = handler;
            this.f59821b = j10;
        }

        @Override // p208cq.InterfaceC8937e
        public void onComplete(Task<Void> task) {
            if (!task.isSuccessful()) {
                BaseLogger.m28731e("HmsHwPush", "turn on push fail");
                C13198o.this.m79388e(this.f59820a, false, true, this.f59821b);
            } else {
                BaseLogger.m28733i("HmsHwPush", "turn on push success");
                C14306d.m85223x();
                C13198o.this.m79388e(this.f59820a, true, true, this.f59821b);
            }
        }
    }

    /* renamed from: uj.o$b */
    public class b implements InterfaceC8937e<Void> {

        /* renamed from: a */
        public final /* synthetic */ Handler f59823a;

        /* renamed from: b */
        public final /* synthetic */ long f59824b;

        public b(Handler handler, long j10) {
            this.f59823a = handler;
            this.f59824b = j10;
        }

        @Override // p208cq.InterfaceC8937e
        public void onComplete(Task<Void> task) {
            if (task.isSuccessful()) {
                BaseLogger.m28733i("HmsHwPush", "turn off push success");
                C13198o.this.m79388e(this.f59823a, true, false, this.f59824b);
            } else {
                BaseLogger.m28731e("HmsHwPush", "turn off push fail");
                C13198o.this.m79388e(this.f59823a, false, false, this.f59824b);
            }
        }
    }

    /* renamed from: uj.o$c */
    public static class c extends AbstractC12367d {

        /* renamed from: a */
        public Context f59826a;

        public c(Context context) {
            this.f59826a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            AbstractC10896a.m65887i("HmsHwPush", "deleteToken begin");
            try {
                HmsInstanceId.getInstance(this.f59826a.getApplicationContext()).deleteToken(C0209d.m1213U("com.huawei.hms.client.appid", "10055832"), HmsMessaging.DEFAULT_TOKEN_SCOPE);
            } catch (Exception e10) {
                BaseLogger.m28731e("HmsHwPush", "deleteToken: error: " + e10.getMessage());
            }
        }
    }

    /* renamed from: uj.o$d */
    public static class d extends AbstractC12367d {

        /* renamed from: a */
        public Context f59827a;

        /* renamed from: b */
        public InterfaceC13189f f59828b;

        public d(Context context, InterfaceC13189f interfaceC13189f) {
            this.f59827a = context;
            this.f59828b = interfaceC13189f;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            AbstractC10896a.m65887i("HmsHwPush", "getToken begin");
            try {
                if (this.f59828b == null) {
                    AbstractC10896a.m65887i("HmsHwPush", "GetPushTokenCallBack is null");
                    return;
                }
                HmsInstanceId.getInstance(this.f59827a).getId();
                String token = HmsInstanceId.getInstance(this.f59827a).getToken(C0209d.m1213U("com.huawei.hms.client.appid", "10055832"), HmsMessaging.DEFAULT_TOKEN_SCOPE);
                AbstractC10896a.m65885d("HmsHwPush", "push token is" + token);
                if (TextUtils.isEmpty(token)) {
                    AbstractC10896a.m65888w("HmsHwPush", "get push token synchronize fail");
                    this.f59828b.mo14508a();
                } else {
                    AbstractC10896a.m65887i("HmsHwPush", "get push token synchronize");
                    this.f59828b.onSuccess(token);
                }
            } catch (Exception e10) {
                BaseLogger.m28731e("HmsHwPush", "getToken error: " + e10.getMessage());
                InterfaceC13189f interfaceC13189f = this.f59828b;
                if (interfaceC13189f != null) {
                    interfaceC13189f.mo14508a();
                }
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.COMMON_PUSH;
        }
    }

    /* renamed from: c */
    public static C13198o m79385c() {
        return f59819a;
    }

    /* renamed from: b */
    public void m79386b(Context context) {
        C12515a.m75110o().m75172d(new c(context));
    }

    /* renamed from: d */
    public void m79387d(Context context, InterfaceC13189f interfaceC13189f) {
        C12515a.m75110o().m75172d(new d(context, interfaceC13189f));
    }

    /* renamed from: e */
    public final void m79388e(Handler handler, boolean z10, boolean z11, long j10) {
        if (handler == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - j10;
        if (jCurrentTimeMillis < 1000) {
            SystemClock.sleep(1000 - jCurrentTimeMillis);
        }
        if (!z10) {
            handler.sendEmptyMessage(3);
        } else if (z11) {
            handler.sendEmptyMessage(1);
        } else {
            handler.sendEmptyMessage(2);
        }
    }

    /* renamed from: f */
    public void m79389f(Context context, boolean z10, Handler handler) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        AbstractC10896a.m65887i("HmsHwPush", "set push notify status: " + z10);
        if (z10) {
            HmsMessaging.getInstance(context).turnOnPush().addOnCompleteListener(new a(handler, jCurrentTimeMillis));
        } else {
            HmsMessaging.getInstance(context).turnOffPush().addOnCompleteListener(new b(handler, jCurrentTimeMillis));
        }
    }
}
