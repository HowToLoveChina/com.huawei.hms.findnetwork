package com.huawei.hms.network.file.api;

import android.content.Context;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.file.api.GlobalRequestConfig;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.RequestConfig;
import com.huawei.hms.network.file.api.RequestManager;
import com.huawei.hms.network.file.api.Result;
import com.huawei.hms.network.file.core.C6224b;
import com.huawei.hms.network.file.core.C6225c;
import com.huawei.hms.network.file.core.C6226d;
import com.huawei.hms.network.file.core.C6228f;
import com.huawei.hms.network.file.core.task.InterfaceC6232c;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.p130a.C6192h;
import com.huawei.hms.network.file.p130a.p133k.p134b.p135j.C6209b;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes8.dex */
public class RequestManager<R extends Request> implements IRequestManager<R> {
    private static final String TAG = "RequestManager";
    private static Context appContext;
    private static volatile boolean isInited;
    protected Context context;
    protected final GlobalRequestConfig globalConfig;
    C6226d managerImpl;
    final String tag;

    /* renamed from: com.huawei.hms.network.file.api.RequestManager$1 */
    public class C62111 extends NetworkKit.Callback {
        final /* synthetic */ ThreadPoolExecutor val$executor;

        public C62111(ThreadPoolExecutor threadPoolExecutor) {
            this.val$executor = threadPoolExecutor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static /* synthetic */ void m36140a() {
            FLogger.m36353i(RequestManager.TAG, "init DecisionTreeManager module over", new Object[0]);
            boolean zM36180a = C6224b.m36180a("core_enable_privacy_policy", false);
            if (zM36180a) {
                FLogger.m36353i(RequestManager.TAG, "init enablePrivacyPolocy", new Object[0]);
                HianalyticsHelper.getInstance().enablePrivacyPolicy(zM36180a);
            }
            String strM36178a = C6224b.m36178a("core_ha_tag");
            if (!Utils.isBlank(strM36178a)) {
                HianalyticsHelper.getInstance().setHaTag(strM36178a);
            }
            FLogger.m36353i(RequestManager.TAG, "init set haTag:" + strM36178a, new Object[0]);
        }

        @Override // com.huawei.hms.network.NetworkKit.Callback
        public void onResult(boolean z10) {
            try {
                FLogger.m36353i(RequestManager.TAG, "init result:" + z10, new Object[0]);
                C6225c.m36192h();
                C6192h.m36048f().m36056e();
                FLogger.m36353i(RequestManager.TAG, "init httpclient over", new Object[0]);
                this.val$executor.execute(new Runnable() { // from class: com.huawei.hms.network.file.api.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        RequestManager.C62111.m36140a();
                    }
                });
                FLogger.m36353i(RequestManager.TAG, "init over", new Object[0]);
            } catch (Throwable unused) {
                FLogger.m36355w(RequestManager.TAG, "NetworkKit.init exception", new Object[0]);
            }
        }
    }

    public static abstract class Builder<T extends Builder> {
        private GlobalRequestConfig globalConfig;
        private String tag;

        public Builder() {
            this(null);
        }

        public abstract RequestManager build(Context context);

        public T commonConfig(GlobalRequestConfig globalRequestConfig) {
            if (globalRequestConfig != null) {
                this.globalConfig = globalRequestConfig;
            }
            return this;
        }

        public String getTag() {
            return this.tag;
        }

        public Builder(String str) {
            this.tag = "default";
            if (!Utils.isBlank(str)) {
                this.tag = str;
            }
            this.globalConfig = new GlobalRequestConfig.Builder().build();
        }
    }

    public RequestManager(Builder builder, Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        this.context = context.createDeviceProtectedStorageContext();
        setAppContext(context);
        this.tag = builder.getTag();
        GlobalRequestConfig globalRequestConfig = builder.globalConfig;
        this.globalConfig = globalRequestConfig;
        this.managerImpl = new C6226d(globalRequestConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m36138a() {
        try {
            C6209b.m36132a();
        } catch (Throwable unused) {
            FLogger.m36355w(TAG, "Secure.initAesGcm() exception", new Object[0]);
        }
    }

    public static Context getAppContext() {
        return appContext;
    }

    /* JADX WARN: In static synchronized method top region not synchronized by class const: (wrap:java.lang.Class:0x0000: CONST_CLASS  A[WRAPPED] com.huawei.hms.network.file.api.RequestManager.class) */
    public static synchronized void init(Context context) {
        synchronized (RequestManager.class) {
            if (!isInited && context != null) {
                isInited = true;
                ThreadPoolExecutor threadPoolExecutorM36213f = C6228f.m36213f();
                NetworkKit.init(context, new C62111(threadPoolExecutorM36213f));
                threadPoolExecutorM36213f.execute(new Runnable() { // from class: com.huawei.hms.network.file.api.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        RequestManager.m36138a();
                    }
                });
            }
        }
    }

    public static GlobalRequestConfig.Builder newGlobalRequestConfigBuilder() {
        return new GlobalRequestConfig.Builder();
    }

    public static RequestConfig.RequestConfBuilder newRequestConfigBuilder() {
        return new RequestConfig.RequestConfBuilder();
    }

    private static void setAppContext(Context context) {
        appContext = context.getApplicationContext();
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public Result cancelRequest(long j10) {
        return this.managerImpl.cancelRequest(j10);
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public Result closeThreadPools() {
        return this.managerImpl.closeThreadPools();
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public Result destoryRequests() {
        return this.managerImpl.destoryRequests();
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public List<R> getAllRequests() {
        return this.managerImpl.getAllRequests();
    }

    public GlobalRequestConfig getGlobalRequestConfig() {
        return this.globalConfig;
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public R getRequest(long j10) {
        return (R) this.managerImpl.getRequest(j10);
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public Result.STATUS getRequestStatus(long j10) {
        return this.managerImpl.getRequestStatus(j10);
    }

    public String getTag() {
        return this.tag;
    }

    public void injectRequestHandler(InterfaceC6232c interfaceC6232c) {
        this.managerImpl.m36209a(interfaceC6232c);
    }

    public Result pauseRequest(long j10) {
        return this.managerImpl.m36206a(j10);
    }

    public Result resumeRequest(R r10, Callback callback) {
        return this.managerImpl.m36207a(r10, callback);
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public Result start(R r10, Callback callback) {
        return this.managerImpl.start(r10, callback);
    }

    public String toString() {
        return "RequestManager{commonConfig=" + this.globalConfig + '}';
    }
}
