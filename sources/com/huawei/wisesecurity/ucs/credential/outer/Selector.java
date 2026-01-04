package com.huawei.wisesecurity.ucs.credential.outer;

import android.content.Context;
import android.text.TextUtils;
import aw.C1029b;
import bw.EnumC1292b;
import com.huawei.wisesecurity.ucs.credential.outer.impl.QuietHACapabilityImpl;
import com.huawei.wisesecurity.ucs_credential.C8916i0;
import p239dw.C9320b;
import p239dw.C9325d0;
import p239dw.C9329f0;
import p239dw.C9342m;
import p239dw.InterfaceC9323c0;
import p857zv.C14389c;

/* loaded from: classes9.dex */
public class Selector {
    private static final String GRS_FEATURE_CLASS = "com.huawei.hms.framework.network.grs.GrsClient";
    private static final String HA_FEATURE_CLASS = "com.huawei.hianalytics.process.HiAnalyticsInstance";
    private static final String NETWORK_FEATURE_CLASS = "com.huawei.hms.network.restclient.RestClient";
    private static final int NETWORK_RETRY_TIME_MAX = 5;
    private static final int NETWORK_RETRY_TIME_MIN = 1;
    private static final int NETWORK_TIME_OUT_MAX = 20000;
    private static final int NETWORK_TIME_OUT_MIN = 10000;
    private static final int SER_COUNTRY_LENGTH_MAX = 7;
    private static final int SER_COUNTRY_LENGTH_MIN = 2;
    private static final String TAG = "Selector";

    public static InterfaceC9323c0 selectGrsCapability(GrsCapability grsCapability, Context context, String str) throws C14389c {
        if (grsCapability != null) {
            return new C9342m(grsCapability);
        }
        try {
            if (!TextUtils.isEmpty(str) && (str.length() < 2 || str.length() > 7)) {
                throw new C14389c(1001L, "serCountry param error");
            }
            C1029b.m6234e(TAG, "outer GRS capability is null, use inner capability", new Object[0]);
            return new C9329f0(context, str);
        } catch (ClassNotFoundException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("GRS capability not found : ");
            sbM58651a.append(e10.getMessage());
            throw new C14389c(1025L, sbM58651a.toString());
        }
    }

    public static HACapability selectHACapability(HACapability hACapability, InterfaceC9323c0 interfaceC9323c0, EnumC1292b enumC1292b) throws C14389c {
        if (hACapability != null) {
            return hACapability;
        }
        if (EnumC1292b.REPORT_CLOSE == enumC1292b) {
            return new QuietHACapabilityImpl();
        }
        try {
            C1029b.m6234e(TAG, "outer HA capability is null, use inner capability", new Object[0]);
            return new C9325d0(interfaceC9323c0, enumC1292b);
        } catch (ClassNotFoundException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("HA capability not found : ");
            sbM58651a.append(e10.getMessage());
            throw new C14389c(1025L, sbM58651a.toString());
        }
    }

    public static NetworkCapability selectNetWorkCapability(NetworkCapability networkCapability, Context context, int i10, int i11) throws C14389c {
        if (networkCapability != null) {
            networkCapability.initConfig(i10, i11);
            return networkCapability;
        }
        try {
            if (i10 < 10000 || i10 > 20000 || i11 < 1 || i11 > 5) {
                throw new C14389c(1001L, "networkTimeOut or networkRetryTime param error");
            }
            C8916i0 c8916i0 = new C8916i0(context);
            c8916i0.initConfig(i10, i11);
            C1029b.m6234e(TAG, "outer Network capability is null, use inner capability", new Object[0]);
            return c8916i0;
        } catch (ClassNotFoundException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Network capability not found : ");
            sbM58651a.append(e10.getMessage());
            throw new C14389c(1025L, sbM58651a.toString());
        }
    }
}
