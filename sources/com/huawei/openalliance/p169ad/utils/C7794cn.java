package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.inter.HiAd;

/* renamed from: com.huawei.openalliance.ad.utils.cn */
/* loaded from: classes2.dex */
public class C7794cn {
    /* renamed from: a */
    public static RequestOptions m48075a(Context context, RequestOptions requestOptions) {
        RequestOptions requestConfiguration = HiAd.getInstance(context).getRequestConfiguration();
        if (requestOptions == null) {
            return requestConfiguration;
        }
        RequestOptions.Builder builder = requestOptions.toBuilder();
        if (requestOptions.m40721a() == null) {
            builder.setAdContentClassification(requestConfiguration.getAdContentClassification());
        }
        if (requestOptions.getTagForUnderAgeOfPromise() == null) {
            builder.setTagForUnderAgeOfPromise(requestConfiguration.getTagForUnderAgeOfPromise());
        }
        if (requestOptions.getTagForChildProtection() == null) {
            builder.setTagForChildProtection(requestConfiguration.getTagForChildProtection());
        }
        if (requestOptions.getNonPersonalizedAd() == null) {
            builder.setNonPersonalizedAd(requestConfiguration.getNonPersonalizedAd());
        }
        if (requestOptions.getIsQueryUseEnabled() == null) {
            builder.setIsQueryUseEnabled(requestConfiguration.getIsQueryUseEnabled());
        }
        if (requestOptions.m40722b() == null) {
            builder.setHwNonPersonalizedAd(requestConfiguration.m40722b());
        }
        if (requestOptions.m40723c() == null) {
            builder.setThirdNonPersonalizedAd(requestConfiguration.m40723c());
        }
        if (requestOptions.getAppLang() == null) {
            builder.setAppLang(requestConfiguration.getAppLang());
        }
        if (requestOptions.getAppCountry() == null) {
            builder.setAppCountry(requestConfiguration.getAppCountry());
        }
        if (TextUtils.isEmpty(requestOptions.getConsent())) {
            builder.setConsent(requestConfiguration.getConsent());
        }
        if (requestOptions.getApp() == null) {
            builder.setApp(requestConfiguration.getApp());
        }
        if (requestOptions.m40726f() == null) {
            builder.setSearchInfo(requestConfiguration.m40726f());
        }
        if (requestOptions.m40727g() == null) {
            builder.setSupportFa(requestConfiguration.m40727g());
        }
        return builder.build();
    }
}
