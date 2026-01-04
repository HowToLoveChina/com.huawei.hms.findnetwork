package com.huawei.hms.network.conf.api;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.hms.network.embedded.C5976k;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class ConfigAPI {
    public static Object getValue(String str) {
        Object objM34454a = C5963j.m34447e().m34454a(str);
        return objM34454a == null ? C5976k.m34556b().m34558a(str) : String.valueOf(objM34454a);
    }

    public static void init(Context context) throws JSONException {
        C5963j.m34447e().m34455a(context);
    }

    public static Bundle providerCall(Context context, String str, String str2, Bundle bundle) {
        return C5963j.m34447e().m34453a(context, str, str2, bundle);
    }
}
