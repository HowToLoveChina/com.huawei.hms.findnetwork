package im;

import android.text.TextUtils;
import com.huawei.hms.network.file.api.RequestConfig;
import com.huawei.hms.network.file.api.RequestManager;
import com.huawei.hms.network.file.api.exception.HttpException;
import com.huawei.hms.network.file.api.exception.InternalException;
import com.huawei.hms.network.file.api.exception.NetWorkErrorException;
import com.huawei.hms.network.file.api.exception.NetWorkIOException;
import com.huawei.hms.network.file.api.exception.NetworkException;
import com.huawei.hms.network.file.api.exception.ParamsCheckException;
import com.huawei.hms.network.file.api.exception.ServerException;
import com.huawei.hms.network.file.api.exception.UnKnownErrorException;
import com.huawei.hms.network.httpclient.Response;
import fk.C9721b;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p429kk.C11060c;
import p514o9.C11839m;

/* renamed from: im.b */
/* loaded from: classes6.dex */
public abstract class AbstractC10548b {

    /* renamed from: d */
    public static final Object f50725d = new Object();

    /* renamed from: e */
    public static final Object f50726e = new Object();

    /* renamed from: a */
    public C9721b f50727a;

    /* renamed from: b */
    public boolean f50728b = false;

    /* renamed from: c */
    public C11060c f50729c;

    /* renamed from: d */
    public abstract void mo64709d() throws C9721b;

    /* renamed from: e */
    public RequestConfig m64710e() {
        return mo64714i().build();
    }

    /* renamed from: f */
    public void mo64711f() {
        this.f50728b = true;
    }

    /* renamed from: g */
    public void m64712g(C9721b c9721b) {
        synchronized (f50725d) {
            try {
                if (this.f50727a == null) {
                    this.f50727a = c9721b;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: h */
    public final String m64713h(Exception exc) {
        if (exc == null) {
            return "";
        }
        if (exc.getCause() == null) {
            return exc.getMessage();
        }
        return exc.getCause().toString() + exc.getMessage();
    }

    /* renamed from: i */
    public RequestConfig.RequestConfBuilder mo64714i() {
        return RequestManager.newRequestConfigBuilder().connectTimeoutMillis(50000L).readTimeoutMillis(50000L).writeTimeoutMillis(50000L).pingIntervalMillis(50000L).retryTimes(2);
    }

    /* renamed from: j */
    public void m64715j() throws C9721b {
        C9721b c9721b = this.f50727a;
        if (c9721b != null) {
            throw c9721b;
        }
        if (this.f50728b) {
            throw new C9721b(1001, "asset task interrupted.");
        }
    }

    /* renamed from: k */
    public boolean m64716k() {
        return this.f50728b;
    }

    /* renamed from: l */
    public void m64717l(String str) {
        synchronized (f50726e) {
            try {
                C11060c c11060c = this.f50729c;
                if (c11060c != null) {
                    c11060c.m66667w(str);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: m */
    public void m64718m(CountDownLatch countDownLatch) throws C9721b {
        while (countDownLatch.getCount() > 0) {
            m64715j();
            try {
                if (countDownLatch.await(400L, TimeUnit.MILLISECONDS)) {
                    C11839m.m70688i("CloudBackupV3AssetBaseTask", "syncLock await success");
                }
            } catch (InterruptedException e10) {
                C11839m.m70689w("CloudBackupV3AssetBaseTask", "syncLock await interrupted. " + e10);
                throw new C9721b(1001, "thread has been interrupted, " + e10);
            }
        }
    }

    /* renamed from: n */
    public C9721b m64719n(NetworkException networkException, Response<?> response, String str) {
        String str2;
        if (networkException instanceof NetWorkErrorException) {
            return new C9721b(2206, m64713h(networkException), str);
        }
        if (!(networkException instanceof ServerException)) {
            return networkException instanceof HttpException ? new C9721b(2205, m64713h(networkException), str) : networkException instanceof NetWorkIOException ? new C9721b(2201, m64713h(networkException), str) : networkException instanceof ParamsCheckException ? new C9721b(2000, m64713h(networkException), str) : networkException instanceof InternalException ? new C9721b(2202, m64713h(networkException), str) : networkException instanceof UnKnownErrorException ? new C9721b(2203, m64713h(networkException), str) : new C9721b(2204, m64713h(networkException), str);
        }
        if (response == null) {
            return new C9721b(2204, m64713h(networkException), str);
        }
        try {
            str2 = new String(response.getErrorBody().bytes(), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            str2 = "";
        }
        return new C9721b(3911, ((ServerException) networkException).getStatusCode(), m64713h(networkException) + " " + str2, str);
    }

    /* renamed from: o */
    public int m64720o(C9721b c9721b) {
        if (c9721b == null) {
            C11839m.m70689w("CloudBackupV3AssetBaseTask", "transferServerExceptionCode CException = NULL");
            return 4314;
        }
        int iM60659c = c9721b.m60659c();
        int iM60663g = c9721b.m60663g();
        String message = c9721b.getMessage();
        C11839m.m70686d("CloudBackupV3AssetBaseTask", "transferServerExceptionCode status = " + iM60663g + " code = " + iM60659c + " message = " + message);
        int i10 = iM60663g == 404 ? 3929 : iM60659c;
        if (iM60659c == 3911 && !TextUtils.isEmpty(message) && message.contains("XAmzContentSHA256Mismatch")) {
            return 3932;
        }
        return i10;
    }
}
