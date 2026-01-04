package com.huawei.hms.videokit.player;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.huawei.hms.videokit.player.o */
/* loaded from: classes8.dex */
public class C6590o implements InvocationHandler {

    /* renamed from: a */
    private Object f30644a;

    /* renamed from: b */
    private HandlerThread f30645b;

    /* renamed from: c */
    private b f30646c;

    /* renamed from: d */
    private boolean f30647d = false;

    /* renamed from: com.huawei.hms.videokit.player.o$b */
    public class b extends Handler {
        private b(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r4) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            /*
                r3 = this;
                super.handleMessage(r4)
                java.lang.Object r4 = r4.obj
                com.huawei.hms.videokit.player.o$c r4 = (com.huawei.hms.videokit.player.C6590o.c) r4
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "handleMessage MethodName: "
                r0.append(r1)
                java.lang.reflect.Method r1 = r4.m37573b()
                java.lang.String r1 = r1.getName()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "AsyncMethodProxy"
                com.huawei.hms.videokit.player.C6550c1.m37256a(r1, r0)
                java.lang.reflect.Method r0 = r4.m37573b()     // Catch: java.lang.Exception -> L37 java.lang.reflect.InvocationTargetException -> L39 java.lang.IllegalArgumentException -> L3b java.lang.IllegalAccessException -> L3d
                com.huawei.hms.videokit.player.o r2 = com.huawei.hms.videokit.player.C6590o.this     // Catch: java.lang.Exception -> L37 java.lang.reflect.InvocationTargetException -> L39 java.lang.IllegalArgumentException -> L3b java.lang.IllegalAccessException -> L3d
                java.lang.Object r2 = com.huawei.hms.videokit.player.C6590o.m37568a(r2)     // Catch: java.lang.Exception -> L37 java.lang.reflect.InvocationTargetException -> L39 java.lang.IllegalArgumentException -> L3b java.lang.IllegalAccessException -> L3d
                java.lang.Object[] r4 = r4.m37572a()     // Catch: java.lang.Exception -> L37 java.lang.reflect.InvocationTargetException -> L39 java.lang.IllegalArgumentException -> L3b java.lang.IllegalAccessException -> L3d
                r0.invoke(r2, r4)     // Catch: java.lang.Exception -> L37 java.lang.reflect.InvocationTargetException -> L39 java.lang.IllegalArgumentException -> L3b java.lang.IllegalAccessException -> L3d
                goto L4e
            L37:
                r4 = move-exception
                goto L3f
            L39:
                r4 = move-exception
                goto L45
            L3b:
                r4 = move-exception
                goto L48
            L3d:
                r4 = move-exception
                goto L4b
            L3f:
                java.lang.String r0 = "Exception"
            L41:
                com.huawei.hms.videokit.player.C6550c1.m37258a(r1, r0, r4)
                goto L4e
            L45:
                java.lang.String r0 = "InvocationTargetException"
                goto L41
            L48:
                java.lang.String r0 = "IllegalArgumentException"
                goto L41
            L4b:
                java.lang.String r0 = "IllegalAccessException"
                goto L41
            L4e:
                com.huawei.hms.videokit.player.o r4 = com.huawei.hms.videokit.player.C6590o.this
                boolean r4 = com.huawei.hms.videokit.player.C6590o.m37569b(r4)
                if (r4 == 0) goto L5b
                com.huawei.hms.videokit.player.o r3 = com.huawei.hms.videokit.player.C6590o.this
                r3.m37571b()
            L5b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.videokit.player.C6590o.b.handleMessage(android.os.Message):void");
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.o$c */
    public static class c {

        /* renamed from: a */
        private Method f30649a;

        /* renamed from: b */
        private Object[] f30650b;

        public c(Method method, Object[] objArr) {
            this.f30649a = method;
            this.f30650b = objArr;
        }

        /* renamed from: a */
        public Object[] m37572a() {
            return this.f30650b;
        }

        /* renamed from: b */
        public Method m37573b() {
            return this.f30649a;
        }
    }

    public C6590o(Object obj, String str) {
        this.f30646c = null;
        this.f30644a = obj;
        HandlerThread handlerThread = new HandlerThread(str);
        this.f30645b = handlerThread;
        handlerThread.start();
        Looper looper = this.f30645b.getLooper();
        if (looper != null) {
            this.f30646c = new b(looper);
        } else {
            C6550c1.m37262b("AsyncMethodProxy", "failed to getLooper.");
        }
    }

    /* renamed from: a */
    public Object m37570a() {
        return Proxy.newProxyInstance(this.f30644a.getClass().getClassLoader(), this.f30644a.getClass().getInterfaces(), this);
    }

    /* renamed from: b */
    public void m37571b() {
        try {
            if (this.f30646c.hasMessages(1)) {
                C6550c1.m37264c("AsyncMethodProxy", "Handler has message not processed");
                this.f30647d = true;
                return;
            }
            C6550c1.m37264c("AsyncMethodProxy", "release Handler");
            if (this.f30645b.getLooper() != null) {
                this.f30645b.getLooper().quitSafely();
            } else {
                C6550c1.m37264c("AsyncMethodProxy", "current Handler loop is null");
            }
            this.f30646c.removeCallbacksAndMessages(null);
            this.f30646c = null;
            this.f30647d = false;
        } catch (Exception e10) {
            C6550c1.m37258a("AsyncMethodProxy", "release Handler error:", e10);
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            b bVar = this.f30646c;
            if (bVar != null) {
                Message messageObtainMessage = bVar.obtainMessage();
                messageObtainMessage.obj = new c(method, objArr);
                messageObtainMessage.what = 1;
                this.f30646c.sendMessage(messageObtainMessage);
            } else {
                C6550c1.m37264c("AsyncMethodProxy", "Handler have released");
            }
            return null;
        } catch (Exception e10) {
            C6550c1.m37258a("AsyncMethodProxy", "invoke method error :", e10);
            return null;
        }
    }
}
