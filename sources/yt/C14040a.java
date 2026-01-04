package yt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.Thread;
import java.lang.reflect.Field;
import p787xt.C13865a;

/* renamed from: yt.a */
/* loaded from: classes5.dex */
public final class C14040a {

    /* renamed from: a */
    public static boolean f62819a = false;

    /* renamed from: b */
    public static final String f62820b = "ActivityProtect";

    /* renamed from: c */
    public static InterfaceC14042c f62821c = null;

    /* renamed from: d */
    public static AbstractC14041b f62822d = null;

    /* renamed from: e */
    public static boolean f62823e = false;

    /* renamed from: f */
    public static boolean f62824f;

    /* renamed from: yt.a$a */
    public static class a implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            if (C14040a.f62822d != null) {
                C14040a.f62822d.m84242d(thread, th2);
            }
            if (thread == Looper.getMainLooper().getThread()) {
                C14040a.m84231f(th2);
                C14040a.m84233h(th2);
                C14040a.m84238m();
            }
        }
    }

    /* renamed from: yt.a$b */
    public static class b implements Handler.Callback {

        /* renamed from: a */
        public final /* synthetic */ Handler f62825a;

        public b(Handler handler) {
            this.f62825a = handler;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            return C14040a.m84234i(message, this.f62825a);
        }
    }

    /* renamed from: f */
    public static void m84231f(Throwable th2) {
        if (th2 == null || f62822d == null) {
            return;
        }
        StackTraceElement[] stackTrace = th2.getStackTrace();
        int length = stackTrace.length;
        while (true) {
            length--;
            if (length <= -1 || stackTrace.length - length > 20) {
                return;
            }
            StackTraceElement stackTraceElement = stackTrace[length];
            if ("android.view.Choreographer".equals(stackTraceElement.getClassName()) && "Choreographer.java".equals(stackTraceElement.getFileName()) && "doFrame".equals(stackTraceElement.getMethodName())) {
                C13865a.m83189c(f62820b, "isChoreographerException BlackScreen , suggest killing self ");
                return;
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: g */
    public static void m84232g() throws Exception {
        Class<?> cls = Class.forName("android.app.ActivityThread");
        Object objInvoke = cls.getDeclaredMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        Field declaredField = cls.getDeclaredField("mH");
        declaredField.setAccessible(true);
        Handler handler = (Handler) declaredField.get(objInvoke);
        Field declaredField2 = Handler.class.getDeclaredField("mCallback");
        declaredField2.setAccessible(true);
        declaredField2.set(handler, new b(handler));
    }

    /* renamed from: h */
    public static void m84233h(Throwable th2) {
        if (th2 == null || f62822d == null) {
            return;
        }
        StackTraceElement[] stackTrace = th2.getStackTrace();
        int length = stackTrace.length;
        do {
            length--;
            if (length <= -1 || stackTrace.length - length > 20) {
                return;
            }
        } while (!"java.lang.ThreadGroup".equals(stackTrace[length].getClassName()));
        C13865a.m83189c(f62820b, "java.lang.ThreadGroup , suggest killing self ");
    }

    /* renamed from: i */
    public static boolean m84234i(Message message, Handler handler) {
        m84239n();
        if (message.what != 159) {
            return false;
        }
        try {
            handler.handleMessage(message);
            return true;
        } catch (Throwable th2) {
            f62821c.mo84243a(message);
            m84236k(th2);
            return true;
        }
    }

    /* renamed from: j */
    public static void m84235j() {
        f62821c = new C14043d();
        try {
            m84232g();
        } catch (Throwable th2) {
            C13865a.m83190d(f62820b, "initActivityProtect: " + th2.getMessage(), th2);
        }
    }

    /* renamed from: k */
    public static void m84236k(Throwable th2) {
        if (f62822d == null) {
            return;
        }
        if (m84237l()) {
            f62822d.m84241a(th2);
        } else {
            f62822d.m84242d(Looper.getMainLooper().getThread(), th2);
            m84238m();
        }
    }

    /* renamed from: l */
    public static boolean m84237l() {
        return f62824f;
    }

    /* renamed from: m */
    public static void m84238m() {
        f62824f = true;
        if (f62822d != null) {
            C13865a.m83193g(f62820b, "safeMode: enter safe mode");
        }
        while (true) {
            try {
                Looper.loop();
            } catch (Throwable th2) {
                m84231f(th2);
                m84233h(th2);
                AbstractC14041b abstractC14041b = f62822d;
                if (abstractC14041b != null) {
                    abstractC14041b.m84241a(th2);
                }
            }
        }
    }

    /* renamed from: n */
    public static void m84239n() {
        if (f62819a) {
            return;
        }
        C13865a.m83193g(f62820b, "handleMessage: >= 28");
        f62819a = true;
    }

    /* renamed from: o */
    public static void m84240o(Context context, AbstractC14041b abstractC14041b) {
        if (f62823e) {
            return;
        }
        try {
            C14044e.m84248a(context);
        } catch (Throwable th2) {
            C13865a.m83190d(f62820b, "un reflect error :" + th2.getMessage(), th2);
        }
        f62823e = true;
        f62822d = abstractC14041b;
        m84235j();
        Thread.setDefaultUncaughtExceptionHandler(new a());
    }
}
