package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* loaded from: classes8.dex */
public abstract class PendingResultImpl<R extends Result, T extends IMessageEntity> extends InnerPendingResult<R> {

    /* renamed from: a */
    private CountDownLatch f29761a;

    /* renamed from: c */
    private WeakReference<ApiClient> f29763c;
    protected DatagramTransport transport = null;

    /* renamed from: b */
    private R f29762b = null;

    /* renamed from: d */
    private String f29764d = null;

    /* renamed from: e */
    private String f29765e = null;

    /* renamed from: f */
    private boolean f29766f = true;

    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$a */
    public class C6316a implements DatagramTransport.InterfaceC6400a {
        public C6316a() {
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.InterfaceC6400a
        /* renamed from: a */
        public void mo36643a(int i10, IMessageEntity iMessageEntity) throws JSONException {
            PendingResultImpl.this.m36639a(i10, iMessageEntity);
            PendingResultImpl.this.f29761a.countDown();
        }
    }

    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$b */
    public class C6317b implements DatagramTransport.InterfaceC6400a {

        /* renamed from: a */
        final /* synthetic */ AtomicBoolean f29768a;

        public C6317b(AtomicBoolean atomicBoolean) {
            this.f29768a = atomicBoolean;
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.InterfaceC6400a
        /* renamed from: a */
        public void mo36643a(int i10, IMessageEntity iMessageEntity) throws JSONException {
            if (!this.f29768a.get()) {
                PendingResultImpl.this.m36639a(i10, iMessageEntity);
            }
            PendingResultImpl.this.f29761a.countDown();
        }
    }

    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$c */
    public class C6318c implements DatagramTransport.InterfaceC6400a {

        /* renamed from: a */
        final /* synthetic */ HandlerC6319d f29770a;

        /* renamed from: b */
        final /* synthetic */ ResultCallback f29771b;

        public C6318c(HandlerC6319d handlerC6319d, ResultCallback resultCallback) {
            this.f29770a = handlerC6319d;
            this.f29771b = resultCallback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hms.support.api.transport.DatagramTransport.InterfaceC6400a
        /* renamed from: a */
        public void mo36643a(int i10, IMessageEntity iMessageEntity) throws JSONException {
            PendingResultImpl.this.m36639a(i10, iMessageEntity);
            this.f29770a.m36644a(this.f29771b, PendingResultImpl.this.f29762b);
        }
    }

    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$d */
    public static class HandlerC6319d<R extends Result> extends Handler {
        public HandlerC6319d(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void m36644a(ResultCallback<? super R> resultCallback, R r10) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r10)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: b */
        public void m36645b(ResultCallback<? super R> resultCallback, R r10) {
            resultCallback.onResult(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            Pair pair = (Pair) message.obj;
            m36645b((ResultCallback) pair.first, (Result) pair.second);
        }
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        m36641a(apiClient, str, iMessageEntity, getResponseType(), 0);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        HMSLog.m36988i("PendingResultImpl", "await");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return (R) awaitOnAnyThread();
        }
        HMSLog.m36986e("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread() throws JSONException, InterruptedException {
        HMSLog.m36988i("PendingResultImpl", "awaitOnAnyThread");
        WeakReference<ApiClient> weakReference = this.f29763c;
        if (weakReference == null) {
            HMSLog.m36986e("PendingResultImpl", "api is null");
            m36639a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f29762b;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.m36986e("PendingResultImpl", "client invalid");
            m36639a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f29762b;
        }
        if (this.f29766f) {
            m36638a(0, 1);
        }
        this.transport.send(apiClient, new C6316a());
        try {
            this.f29761a.await();
        } catch (InterruptedException unused) {
            HMSLog.m36986e("PendingResultImpl", "await in anythread InterruptedException");
            m36639a(CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.f29762b;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void cancel() {
    }

    public boolean checkApiClient(ApiClient apiClient) {
        return true;
    }

    public Class<T> getResponseType() {
        Type type;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1]) == null) {
            return null;
        }
        return (Class) type;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    public abstract R onComplete(T t10);

    public R onError(int i10) {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Type type = genericSuperclass != null ? ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0] : null;
        Class<?> type2 = type != null ? GenericTypeReflector.getType(type) : null;
        if (type2 != null) {
            try {
                R r10 = (R) type2.newInstance();
                this.f29762b = r10;
                r10.setStatus(new Status(i10));
            } catch (Exception e10) {
                HMSLog.m36986e("PendingResultImpl", "on Error:" + e10.getMessage());
                return null;
            }
        }
        return this.f29762b;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> resultCallback) {
        this.f29766f = !(resultCallback instanceof BaseAdapter.BaseRequestResultCallback);
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    /* renamed from: a */
    private void m36641a(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls, int i10) {
        HMSLog.m36988i("PendingResultImpl", "init uri:" + str);
        this.f29764d = str;
        if (apiClient == null) {
            HMSLog.m36986e("PendingResultImpl", "client is null");
            return;
        }
        this.f29763c = new WeakReference<>(apiClient);
        this.f29761a = new CountDownLatch(1);
        try {
            this.transport = (DatagramTransport) Class.forName(apiClient.getTransportName()).getConstructor(String.class, IMessageEntity.class, Class.class, Integer.TYPE).newInstance(str, iMessageEntity, cls, Integer.valueOf(i10));
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            HMSLog.m36986e("PendingResultImpl", "gen transport error:" + e10.getMessage());
            throw new IllegalStateException("Instancing transport exception, " + e10.getMessage(), e10);
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) throws JSONException {
        HMSLog.m36988i("PendingResultImpl", "setResultCallback");
        if (looper == null) {
            looper = Looper.myLooper();
        }
        HandlerC6319d handlerC6319d = new HandlerC6319d(looper);
        WeakReference<ApiClient> weakReference = this.f29763c;
        if (weakReference == null) {
            HMSLog.m36986e("PendingResultImpl", "api is null");
            m36639a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.m36986e("PendingResultImpl", "client is invalid");
            m36639a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            handlerC6319d.m36644a(resultCallback, this.f29762b);
        } else {
            if (this.f29766f) {
                m36638a(0, 1);
            }
            this.transport.post(apiClient, new C6318c(handlerC6319d, resultCallback));
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j10, TimeUnit timeUnit) {
        HMSLog.m36988i("PendingResultImpl", "await timeout:" + j10 + " unit:" + timeUnit.toString());
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return (R) awaitOnAnyThread(j10, timeUnit);
        }
        HMSLog.m36988i("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        m36641a(apiClient, str, iMessageEntity, cls, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m36639a(int i10, IMessageEntity iMessageEntity) throws JSONException {
        Status status;
        HMSLog.m36988i("PendingResultImpl", "setResult:" + i10);
        Status commonStatus = iMessageEntity instanceof AbstractMessageEntity ? ((AbstractMessageEntity) iMessageEntity).getCommonStatus() : null;
        if (i10 == 0) {
            this.f29762b = (R) onComplete(iMessageEntity);
        } else {
            this.f29762b = (R) onError(i10);
        }
        if (this.f29766f) {
            m36638a(i10, 2);
        }
        R r10 = this.f29762b;
        if (r10 == null || (status = r10.getStatus()) == null || commonStatus == null) {
            return;
        }
        int statusCode = status.getStatusCode();
        String statusMessage = status.getStatusMessage();
        int statusCode2 = commonStatus.getStatusCode();
        String statusMessage2 = commonStatus.getStatusMessage();
        if (statusCode != statusCode2) {
            HMSLog.m36986e("PendingResultImpl", "rstStatus code (" + statusCode + ") is not equal commonStatus code (" + statusCode2 + ")");
            HMSLog.m36986e("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
            return;
        }
        if (!TextUtils.isEmpty(statusMessage) || TextUtils.isEmpty(statusMessage2)) {
            return;
        }
        HMSLog.m36988i("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
        this.f29762b.setStatus(new Status(statusCode, statusMessage2, status.getResolution()));
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, int i10) {
        m36641a(apiClient, str, iMessageEntity, getResponseType(), i10);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j10, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread(long j10, TimeUnit timeUnit) throws JSONException {
        HMSLog.m36988i("PendingResultImpl", "awaitOnAnyThread timeout:" + j10 + " unit:" + timeUnit.toString());
        WeakReference<ApiClient> weakReference = this.f29763c;
        if (weakReference == null) {
            HMSLog.m36986e("PendingResultImpl", "api is null");
            m36639a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f29762b;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.m36986e("PendingResultImpl", "client invalid");
            m36639a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f29762b;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        if (this.f29766f) {
            m36638a(0, 1);
        }
        this.transport.post(apiClient, new C6317b(atomicBoolean));
        try {
            if (!this.f29761a.await(j10, timeUnit)) {
                atomicBoolean.set(true);
                m36639a(CommonCode.ErrorCode.EXECUTE_TIMEOUT, (IMessageEntity) null);
            }
        } catch (InterruptedException unused) {
            HMSLog.m36986e("PendingResultImpl", "awaitOnAnyThread InterruptedException");
            m36639a(CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.f29762b;
    }

    /* renamed from: a */
    private void m36638a(int i10, int i11) throws JSONException {
        SubAppInfo subAppInfo;
        HMSLog.m36988i("PendingResultImpl", "biReportEvent ====== ");
        ApiClient apiClient = this.f29763c.get();
        if (apiClient != null && this.f29764d != null && !HiAnalyticsUtil.getInstance().hasError(apiClient.getContext())) {
            HashMap map = new HashMap();
            map.put("package", apiClient.getPackageName());
            map.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.13.0.303");
            if (i11 == 1) {
                map.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
            } else {
                map.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
                map.put("result", String.valueOf(i10));
                R r10 = this.f29762b;
                if (r10 != null && r10.getStatus() != null) {
                    map.put("statusCode", String.valueOf(this.f29762b.getStatus().getStatusCode()));
                }
            }
            map.put("version", "0");
            String appId = Util.getAppId(apiClient.getContext());
            if (TextUtils.isEmpty(appId) && (subAppInfo = apiClient.getSubAppInfo()) != null) {
                appId = subAppInfo.getSubAppID();
            }
            map.put("appid", appId);
            if (TextUtils.isEmpty(this.f29765e)) {
                String id2 = TransactionIdCreater.getId(appId, this.f29764d);
                this.f29765e = id2;
                map.put("transId", id2);
            } else {
                map.put("transId", this.f29765e);
                this.f29765e = null;
            }
            String[] strArrSplit = this.f29764d.split("\\.");
            if (strArrSplit.length >= 2) {
                map.put("service", strArrSplit[0]);
                map.put("apiName", strArrSplit[1]);
            }
            map.put("callTime", String.valueOf(System.currentTimeMillis()));
            map.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onEvent(apiClient.getContext(), HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, map);
            return;
        }
        HMSLog.m36986e("PendingResultImpl", "<biReportEvent> has some error.");
    }
}
