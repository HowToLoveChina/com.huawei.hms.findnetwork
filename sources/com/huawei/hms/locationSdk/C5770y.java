package com.huawei.hms.locationSdk;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.location.router.RouterTaskHandler;
import com.huawei.location.router.entity.RouterRequest;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import p208cq.AbstractC8933a;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.y */
/* loaded from: classes8.dex */
public class C5770y<TResult, TClient extends AnyClient, TOption extends Api.ApiOptions> implements InvocationHandler {

    /* renamed from: d */
    private static final Object[] f25599d = new Object[0];

    /* renamed from: a */
    private final Object f25600a;

    /* renamed from: b */
    private final WeakReference<Context> f25601b;

    /* renamed from: c */
    private RouterTaskHandler f25602c;

    /* renamed from: com.huawei.hms.locationSdk.y$a */
    public class a extends AbstractC8933a {
        public a() {
        }

        @Override // p208cq.AbstractC8933a
        public boolean isCancellationRequested() {
            return false;
        }

        @Override // p208cq.AbstractC8933a
        public AbstractC8933a register(Runnable runnable) {
            return null;
        }
    }

    private C5770y(Context context, Object obj) {
        this.f25600a = obj;
        this.f25601b = new WeakReference<>(context);
    }

    /* renamed from: a */
    public static Object m33213a(Context context, Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new C5770y(context, obj));
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws IllegalAccessException, InvocationTargetException {
        if (!method.isAnnotationPresent(InterfaceC5767x.class)) {
            return method.invoke(this.f25600a, objArr);
        }
        HMSLog.m36988i("LiteSDKApiProxyHandler", "not find HMS Core ,try use lite");
        return m33211a(objArr);
    }

    /* renamed from: a */
    private AbstractC5696b<TClient, TResult> m33212a(AbstractC5696b<TClient, TResult> abstractC5696b) {
        abstractC5696b.setToken(new a());
        return abstractC5696b;
    }

    /* renamed from: a */
    private Task<TResult> m33211a(Object[] objArr) {
        ApiException apiException;
        C8941i c8941i = new C8941i();
        if (objArr == null || objArr.length == 0) {
            apiException = new ApiException(Status.FAILURE);
        } else {
            if (this.f25602c == null) {
                RouterTaskHandler routerTaskHandler = RouterTaskHandler.getInstance();
                this.f25602c = routerTaskHandler;
                routerTaskHandler.initTaskCall(this.f25601b.get());
            }
            AbstractC5696b<TClient, TResult> abstractC5696bM33212a = null;
            AbstractClientBuilder abstractClientBuilder = null;
            for (Object obj : objArr) {
                if (obj instanceof AbstractC5696b) {
                    abstractC5696bM33212a = m33212a((AbstractC5696b) obj);
                }
                if (obj instanceof AbstractClientBuilder) {
                    abstractClientBuilder = (AbstractClientBuilder) obj;
                }
            }
            if (abstractC5696bM33212a != null && abstractClientBuilder != null) {
                synchronized (f25599d) {
                    try {
                        RouterRequest routerRequest = new RouterRequest(abstractC5696bM33212a.getUri(), abstractC5696bM33212a.getRequestJson(), abstractC5696bM33212a.getTransactionId(), new C5764w(abstractC5696bM33212a, c8941i, abstractClientBuilder), abstractC5696bM33212a.getParcelable());
                        if (C5773z.m33215a()) {
                            routerRequest.setResendFromHMS(true);
                        }
                        this.f25602c.enqueue(routerRequest);
                        HMSLog.m36988i("LiteSDKApiProxyHandler", "handlerLiteTask success");
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return c8941i.m56656b();
            }
            apiException = new ApiException(Status.FAILURE);
        }
        c8941i.m56657c(apiException);
        return c8941i.m56656b();
    }
}
