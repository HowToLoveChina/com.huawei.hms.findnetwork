package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.api.entity.opendevice.HuaweiOpendeviceNaming;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class OpenDeviceClientImpl extends HuaweiApi<OpenDeviceOptions> implements OpenDeviceClient {

    /* renamed from: a */
    private static final OpenDeviceHmsClientBuilder f29571a = new OpenDeviceHmsClientBuilder();

    /* renamed from: b */
    private static final Api<OpenDeviceOptions> f29572b = new Api<>(HuaweiApiAvailability.HMS_API_NAME_OD);

    /* renamed from: c */
    private static OpenDeviceOptions f29573c = new OpenDeviceOptions();

    public OpenDeviceClientImpl(Context context) {
        super(context, f29572b, f29573c, f29571a);
        super.setKitSdkVersion(61300300);
    }

    @Override // com.huawei.hms.opendevice.OpenDeviceClient
    public Task<OdidResult> getOdid() {
        return doWrite(new OpenDeviceTaskApiCall(HuaweiOpendeviceNaming.GET_ODID, JsonUtil.createJsonString(null), HiAnalyticsClient.reportEntry(getContext(), HuaweiOpendeviceNaming.GET_ODID, 61300300)));
    }
}
