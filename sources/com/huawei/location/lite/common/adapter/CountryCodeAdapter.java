package com.huawei.location.lite.common.adapter;

import as.C1016d;
import es.C9552q;

/* loaded from: classes8.dex */
public class CountryCodeAdapter {
    private static final String TAG = "CountryCodeAdapter";
    private static String countryCode = "UNKNOWN";
    private static boolean countryCodeSet = false;

    public static String getCountryCode() {
        return countryCode;
    }

    public static boolean isCountryCodeSet() {
        return countryCodeSet;
    }

    public static boolean setCountryCode(String str) {
        C1016d.m6186f(TAG, "sdk type: " + C9552q.m59643a() + ", countryCode receive: " + str);
        if (C9552q.m59643a() != 100) {
            return false;
        }
        countryCode = str;
        countryCodeSet = true;
        return true;
    }
}
