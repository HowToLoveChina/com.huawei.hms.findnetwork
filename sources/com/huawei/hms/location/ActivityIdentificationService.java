package com.huawei.hms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.locationSdk.C5758u;
import com.huawei.hms.locationSdk.C5765w0;
import com.huawei.hms.locationSdk.InterfaceC5693a0;

/* loaded from: classes8.dex */
public class ActivityIdentificationService {
    private InterfaceC5693a0 locationArClient;

    public ActivityIdentificationService(Activity activity) {
        this.locationArClient = C5758u.m33168a(activity, (C5765w0) null);
    }

    public Task<Void> createActivityConversionUpdates(ActivityConversionRequest activityConversionRequest, PendingIntent pendingIntent) {
        return this.locationArClient.mo33036a(activityConversionRequest, pendingIntent);
    }

    public Task<Void> createActivityIdentificationUpdates(long j10, PendingIntent pendingIntent) {
        return this.locationArClient.mo33034a(j10, pendingIntent);
    }

    public Task<Void> deleteActivityConversionUpdates(PendingIntent pendingIntent) {
        return this.locationArClient.mo33035a(pendingIntent);
    }

    public Task<Void> deleteActivityIdentificationUpdates(PendingIntent pendingIntent) {
        return this.locationArClient.mo33037b(pendingIntent);
    }

    public ActivityIdentificationService(Context context) {
        this.locationArClient = C5758u.m33169a(context, (C5765w0) null);
    }
}
