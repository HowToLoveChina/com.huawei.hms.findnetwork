package com.huawei.appgallery.agd.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import com.huawei.appgallery.coreservice.api.IConnectionResult;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class ConnectionResult implements IConnectionResult {

    /* renamed from: a */
    public IConnectionResult f20955a;

    public ConnectionResult(IConnectionResult iConnectionResult) {
        this.f20955a = iConnectionResult;
    }

    public boolean equals(Object obj) {
        return this.f20955a.equals(obj);
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public String getErrorMessage() {
        return this.f20955a.getErrorMessage();
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public PendingIntent getResolution() {
        return this.f20955a.getResolution();
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public int getStatusCode() {
        return this.f20955a.getStatusCode();
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public boolean hasResolution() {
        return this.f20955a.hasResolution();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f20955a.getStatusCode()), this.f20955a.getResolution(), this.f20955a.getErrorMessage()});
    }

    @Override // com.huawei.appgallery.coreservice.api.IConnectionResult
    public void startResolutionForResult(Activity activity, int i10) throws IntentSender.SendIntentException {
        this.f20955a.startResolutionForResult(activity, i10);
    }
}
