package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.location.ActivityConversionInfo;
import com.huawei.hms.location.ActivityConversionRequest;
import com.huawei.hms.location.ActivityIdentificationData;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.activityrecognition.RequestActivityConversionRequest;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.location.common.CollectionsUtil;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import es.C9542g;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.c0 */
/* loaded from: classes8.dex */
public class C5701c0 extends HuaweiApi<C5765w0> implements InterfaceC5693a0 {

    /* renamed from: b */
    private static final C5697b0 f25490b = new C5697b0();

    /* renamed from: c */
    private static final Api<C5765w0> f25491c = new Api<>("HmsLocation.API");

    /* renamed from: a */
    private InterfaceC5761v f25492a;

    public C5701c0(Activity activity, C5765w0 c5765w0) {
        super(activity, f25491c, c5765w0, (AbstractClientBuilder) f25490b);
    }

    /* renamed from: a */
    private void m33042a(String str) throws ApiException {
        if (PermissionUtil.isPermissionAvailable(getContext(), "android.permission.ACTIVITY_RECOGNITION")) {
            return;
        }
        HMSLocationLog.m36660e("LocationArClientImpl", str, "android Q requestActivityUpdates isPermissionAvailable is false ");
        throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5693a0
    /* renamed from: b */
    public Task<Void> mo33037b(PendingIntent pendingIntent) throws ApiException {
        ApiException e10;
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        HMSLocationLog.m36662i("LocationArClientImpl", tid, "deleteActivityIdentificationUpdates begin");
        C8941i c8941i = new C8941i();
        try {
            if (pendingIntent == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            C5714f1 c5714f1 = new C5714f1();
            c5714f1.m33080a(pendingIntent);
            C5714f1 c5714f12 = (C5714f1) C5718g1.m33086b().m33193b(c5714f1);
            if (c5714f12 != null) {
                HMSLocationLog.m36660e("LocationArClientImpl", tid, "deleteActivityIdentificationUpdates cannot find cache");
                tid = c5714f12.m33186a();
            }
            locationBaseRequest.setTid(tid);
            c5714f1.m33187a(tid);
            C5774z0 c5774z0 = new C5774z0("location.removeActivityIdentificationUpdates", JsonUtil.createJsonString(locationBaseRequest), c5714f1);
            c5774z0.setParcelable(pendingIntent);
            return doWrite(c5774z0);
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("LocationArClientImpl", tid, "deleteActivityIdentificationUpdates api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationArClientImpl", tid, "deleteActivityIdentificationUpdates exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        InterfaceC5761v interfaceC5761v;
        if (this.f25492a == null) {
            Object objM33213a = C5770y.m33213a(getContext(), new C5773z());
            if (objM33213a instanceof InterfaceC5761v) {
                this.f25492a = (InterfaceC5761v) objM33213a;
            }
        }
        return (C5773z.m33216a(getContext()) || (interfaceC5761v = this.f25492a) == null) ? super.doWrite(taskApiCall) : interfaceC5761v.mo33178a(this, taskApiCall, f25490b);
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getKitSdkVersion() {
        return 61403300;
    }

    public C5701c0(Context context, C5765w0 c5765w0) {
        super(context, f25491c, c5765w0, f25490b);
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5693a0
    /* renamed from: a */
    public Task<Void> mo33035a(PendingIntent pendingIntent) throws ApiException {
        ApiException e10;
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        HMSLocationLog.m36662i("LocationArClientImpl", tid, "deleteActivityConversionUpdates begin");
        C8941i c8941i = new C8941i();
        try {
            if (pendingIntent == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            C5702c1 c5702c1 = new C5702c1();
            c5702c1.m33043a(pendingIntent);
            C5702c1 c5702c12 = (C5702c1) C5706d1.m33063b().m33193b(c5702c1);
            if (c5702c12 != null) {
                HMSLocationLog.m36660e("LocationArClientImpl", tid, "deleteActivityConversionUpdates cannot find cache");
                tid = c5702c12.m33186a();
            }
            locationBaseRequest.setTid(tid);
            c5702c1.m33187a(tid);
            C5771y0 c5771y0 = new C5771y0("location.removeActivityConversionUpdates", JsonUtil.createJsonString(locationBaseRequest), c5702c1);
            c5771y0.setParcelable(pendingIntent);
            return doWrite(c5771y0);
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("LocationArClientImpl", tid, "deleteActivityConversionUpdates api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationArClientImpl", tid, "deleteActivityConversionUpdates exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5693a0
    /* renamed from: a */
    public Task<Void> mo33036a(ActivityConversionRequest activityConversionRequest, PendingIntent pendingIntent) throws ApiException {
        ApiException e10;
        RequestActivityConversionRequest requestActivityConversionRequest = new RequestActivityConversionRequest(getContext());
        String tid = requestActivityConversionRequest.getTid();
        HMSLocationLog.m36662i("LocationArClientImpl", tid, "createActivityConversionUpdates begin");
        C8941i c8941i = new C8941i();
        try {
            if (activityConversionRequest == null || pendingIntent == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            m33042a(tid);
            List<ActivityConversionInfo> activityConversions = activityConversionRequest.getActivityConversions();
            if (!CollectionsUtil.isEmpty(activityConversions)) {
                for (ActivityConversionInfo activityConversionInfo : activityConversions) {
                    int conversionType = activityConversionInfo.getConversionType();
                    int activityType = activityConversionInfo.getActivityType();
                    if (conversionType != 0 && conversionType != 1) {
                        throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
                    }
                    if (!ActivityIdentificationData.isValidType(activityType)) {
                        throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
                    }
                }
            }
            C5702c1 c5702c1 = new C5702c1();
            c5702c1.m33043a(pendingIntent);
            c5702c1.m33187a(tid);
            requestActivityConversionRequest.setActivityConversions(activityConversionRequest.getActivityConversions());
            C5710e1 c5710e1 = new C5710e1("location.requestActivityConversionUpdates", C5773z.m33216a(getContext()) ? JsonUtil.createJsonString(requestActivityConversionRequest) : C9542g.m59588a().toJson(requestActivityConversionRequest), c5702c1);
            c5710e1.setParcelable(pendingIntent);
            return doWrite(c5710e1);
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("LocationArClientImpl", tid, "createActivityConversionUpdates api exception");
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationArClientImpl", tid, "createActivityConversionUpdates exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5693a0
    /* renamed from: a */
    public Task<Void> mo33034a(long j10, PendingIntent pendingIntent) throws ApiException, JSONException {
        ApiException e10;
        String string = UUID.randomUUID().toString();
        HMSLocationLog.m36662i("LocationArClientImpl", string, "createActivityIdentificationUpdates begin");
        C8941i c8941i = new C8941i();
        try {
            if (pendingIntent == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            m33042a(string);
            if (j10 < 0) {
                throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
            }
            C5714f1 c5714f1 = new C5714f1();
            c5714f1.m33080a(pendingIntent);
            c5714f1.m33187a(string);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("detectionIntervalMillis", j10);
            jSONObject.put("locTransactionId", string);
            jSONObject.put("packageName", getContext().getPackageName());
            C5721h1 c5721h1 = new C5721h1("location.requestActivityIdentificationUpdates", jSONObject.toString(), c5714f1);
            c5721h1.setParcelable(pendingIntent);
            return doWrite(c5721h1);
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("LocationArClientImpl", string, "createActivityIdentificationUpdates api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationArClientImpl", string, "createActivityIdentificationUpdates exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }
}
