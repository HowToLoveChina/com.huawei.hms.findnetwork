package com.tencent.p204mm.opensdk.openapi;

import android.content.Context;
import com.tencent.p204mm.opensdk.utils.Log;

/* loaded from: classes9.dex */
public class WXAPIFactory {
    private static final String TAG = "MicroMsg.PaySdk.WXFactory";

    private WXAPIFactory() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        return createWXAPI(context, str, true);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z10) {
        Log.m56638d(TAG, "createWXAPI, appId = " + str + ", checkSignature = " + z10);
        return new WXApiImplV10(context, str, z10);
    }
}
