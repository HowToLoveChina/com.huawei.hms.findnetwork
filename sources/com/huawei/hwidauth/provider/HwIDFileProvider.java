package com.huawei.hwidauth.provider;

import android.content.Context;
import android.content.pm.ProviderInfo;
import androidx.core.content.FileProvider;
import p640sq.C12836o;

/* loaded from: classes8.dex */
public class HwIDFileProvider extends FileProvider {
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        try {
            super.attachInfo(context, providerInfo);
        } catch (IllegalArgumentException e10) {
            C12836o.m77099d("HwIDFileProvider", "IllegalArgumentException. " + e10.getLocalizedMessage(), true);
        }
    }
}
