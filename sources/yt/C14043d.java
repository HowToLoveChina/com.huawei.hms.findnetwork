package yt;

import android.app.ActivityManager;
import android.app.servertransaction.ClientTransaction;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import java.lang.reflect.Method;
import p787xt.C13865a;

/* renamed from: yt.d */
/* loaded from: classes5.dex */
public class C14043d implements InterfaceC14042c {

    /* renamed from: a */
    public static final String f62827a = "e";

    /* renamed from: b */
    private void m84244b(IBinder iBinder) throws Exception {
        Object objInvoke = ActivityManager.class.getDeclaredMethod("getService", new Class[0]).invoke(null, new Object[0]);
        Class<?> cls = objInvoke.getClass();
        Class cls2 = Integer.TYPE;
        Method declaredMethod = cls.getDeclaredMethod("finishActivity", IBinder.class, cls2, Intent.class, cls2);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(objInvoke, iBinder, 0, null, 0);
    }

    /* renamed from: c */
    private void m84245c(Message message) throws Exception {
        m84244b(((ClientTransaction) message.obj).getActivityToken());
    }

    @Override // yt.InterfaceC14042c
    /* renamed from: a */
    public void mo84243a(Message message) {
        C13865a.m83193g(f62827a, "finishLaunchActivity: ");
        try {
            m84245c(message);
        } catch (Throwable unused) {
            C13865a.m83189c(f62827a, "finishLaunchActivity1 exception ");
            try {
                m84246d(message);
            } catch (Throwable unused2) {
                C13865a.m83189c(f62827a, "finishLaunchActivity2 exception ");
                try {
                    m84247e(message);
                } catch (Throwable unused3) {
                    C13865a.m83189c(f62827a, "finishLaunchActivity3 exception ");
                }
            }
        }
    }

    /* renamed from: d */
    public final void m84246d(Message message) throws Exception {
        Object obj = message.obj;
        m84244b((IBinder) obj.getClass().getDeclaredMethod("getActivityToken", new Class[0]).invoke(obj, new Object[0]));
    }

    /* renamed from: e */
    public final void m84247e(Message message) throws Exception {
        Object obj = message.obj;
        m84244b((IBinder) obj.getClass().getDeclaredField("mActivityToken").get(obj));
    }
}
