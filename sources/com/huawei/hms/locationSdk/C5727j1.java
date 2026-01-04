package com.huawei.hms.locationSdk;

import android.os.Looper;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;

/* renamed from: com.huawei.hms.locationSdk.j1 */
/* loaded from: classes8.dex */
public class C5727j1 extends C5736m1 {
    public C5727j1(String str, String str2, String str3, C5733l1 c5733l1, Looper looper, String str4) throws ApiException {
        super(str, str2, str3, c5733l1, looper, str4);
    }

    @Override // com.huawei.hms.locationSdk.C5736m1
    /* renamed from: a */
    public String mo33104a() {
        return "RequestLocationExUpdatesTaskApiCall";
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        LocationRequest locationRequestM33122d = ((C5736m1) this).f25546d.m33122d();
        if (locationRequestM33122d == null) {
            HMSLocationLog.m36660e(mo33104a(), ((AbstractC5696b) this).f25484a, "locationRequest is null");
            return super.getApiLevel();
        }
        int priority = locationRequestM33122d.getPriority();
        if (priority == 300) {
            return 5;
        }
        if (priority == 400) {
            return 8;
        }
        if (priority == 301) {
            return 9;
        }
        return super.getApiLevel();
    }

    @Override // com.huawei.hms.locationSdk.C5736m1, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40003318;
    }
}
