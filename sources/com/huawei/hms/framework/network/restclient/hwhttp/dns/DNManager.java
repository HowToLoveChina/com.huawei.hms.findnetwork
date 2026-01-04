package com.huawei.hms.framework.network.restclient.hwhttp.dns;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.restclient.hwhttp.dns.dnresolver.dnkeeper.DNKeeper;
import com.huawei.hms.network.NetworkKit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class DNManager {
    public static final String ENABLE_HTTPDNS = "enable_httpdns";
    private static final String TAG = "DNManager";
    private static volatile DNManager instance;

    private DNManager() {
    }

    public static DNManager getInstance() {
        if (instance == null) {
            synchronized (DNManager.class) {
                try {
                    if (instance == null) {
                        instance = new DNManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public void init(Context context, DNKeeper dNKeeper) {
    }

    public void setHttpDnsEnabled(boolean z10) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ENABLE_HTTPDNS, z10);
            NetworkKit.getInstance().setOptions(jSONObject.toString());
        } catch (JSONException unused) {
            Logger.m32145w("DNManager", "DNManager setHttpDnsEnabled catch a JSONException");
        }
    }
}
