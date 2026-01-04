package com.tencent.p204mm.opensdk.diffdev;

import com.tencent.p204mm.opensdk.diffdev.p206a.C8919a;
import com.tencent.p204mm.opensdk.utils.Log;

/* loaded from: classes9.dex */
public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static IDiffDevOAuth v1Instance;

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        return getDiffDevOAuth(1);
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i10) {
        Log.m56641v(TAG, "getDiffDevOAuth, version = ".concat(String.valueOf(i10)));
        if (i10 > 1) {
            Log.m56639e(TAG, "getDiffDevOAuth fail, unsupported version = ".concat(String.valueOf(i10)));
            return null;
        }
        if (i10 != 1) {
            return null;
        }
        if (v1Instance == null) {
            v1Instance = new C8919a();
        }
        return v1Instance;
    }
}
