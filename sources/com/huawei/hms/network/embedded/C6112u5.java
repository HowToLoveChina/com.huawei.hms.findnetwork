package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PackageManagerCompat;
import com.huawei.hms.network.embedded.C5863b6;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.huawei.hms.network.embedded.u5 */
/* loaded from: classes8.dex */
public class C6112u5 extends AbstractC6125v5 {

    /* renamed from: h */
    public static final String f28506h = "HttpDetectQuery";

    /* renamed from: i */
    public static final String f28507i = "DETECT_APP_ID";

    /* renamed from: f */
    public String f28509f;

    /* renamed from: e */
    public String f28508e = "";

    /* renamed from: g */
    public Callable<C5890d5> f28510g = new a();

    /* renamed from: com.huawei.hms.network.embedded.u5$a */
    public class a implements Callable<C5890d5> {
        public a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C5890d5 call() {
            return C5877c6.m34037a(ContextHolder.getAppContext(), C6112u5.this.f28509f + C5863b6.e.f26441a, C6112u5.this.f28508e);
        }
    }

    public C6112u5(ExecutorService executorService) {
        this.f28644b = executorService;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6125v5
    /* renamed from: b */
    public C6138w5 mo35507b(AbstractC5956i5 abstractC5956i5) {
        Logger.m32143v(f28506h, "the http detect is coming!");
        abstractC5956i5.mo34380b(1);
        this.f28508e = PackageManagerCompat.getMetaDataFromApp(ContextHolder.getAppContext(), f28507i, "");
        Logger.m32143v(f28506h, "the obtain appId is:" + this.f28508e);
        if (TextUtils.isEmpty(this.f28508e)) {
            abstractC5956i5.m34375a(C5863b6.d.f26435b);
            this.f28643a.m35721a(false);
        } else {
            String strM34038a = C5877c6.m34038a(ContextHolder.getResourceContext());
            this.f28509f = strM34038a;
            if (!TextUtils.isEmpty(strM34038a)) {
                Logger.m32143v(f28506h, "the detectDomainName is :" + this.f28509f);
                Future futureSubmit = null;
                try {
                    try {
                        futureSubmit = this.f28644b.submit(this.f28510g);
                        C5890d5 c5890d5 = (C5890d5) futureSubmit.get(5000L, TimeUnit.MILLISECONDS);
                        if (c5890d5.m34102a() == 404) {
                            this.f28643a.m35721a(false);
                        }
                        abstractC5956i5.mo34376a(c5890d5.m34102a(), this.f28509f);
                    } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException unused) {
                        Logger.m32145w(f28506h, "the connect is overTime");
                        abstractC5956i5.mo34376a(C5863b6.d.f26434a, this.f28509f);
                        if (futureSubmit != null) {
                        }
                    } catch (RejectedExecutionException unused2) {
                        Logger.m32145w(f28506h, "executorService submit is RejectedExecutionException");
                        abstractC5956i5.mo34376a(C5863b6.d.f26434a, this.f28509f);
                        if (futureSubmit != null) {
                        }
                    }
                    futureSubmit.cancel(true);
                    return this.f28643a;
                } catch (Throwable th2) {
                    if (futureSubmit != null) {
                        futureSubmit.cancel(true);
                    }
                    throw th2;
                }
            }
            abstractC5956i5.m34375a(C5863b6.d.f26436c);
        }
        return this.f28643a;
    }
}
