package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7483mr;
import com.huawei.openalliance.p169ad.beans.metadata.App;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.utils.k */
/* loaded from: classes2.dex */
public class C7832k {

    /* renamed from: a */
    private static final C7832k f36112a = new C7832k();

    /* renamed from: b */
    private final AtomicBoolean f36113b = new AtomicBoolean(true);

    private C7832k() {
    }

    /* renamed from: a */
    public int m48468a(Context context, AppDownloadTask appDownloadTask) {
        if (context != null && appDownloadTask != null) {
            try {
                AppInfo appInfoM42222B = appDownloadTask.m42222B();
                if (appInfoM42222B == null) {
                    return -1;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appInfo", AbstractC7758be.m47727a(appInfoM42222B));
                jSONObject.put("slotId", appDownloadTask.m42233M());
                jSONObject.put("appTaskInfo", appDownloadTask.m42234N());
                CallResult callResultM45853a = C7483mr.m45852a(context).m45853a("restoreAppByPackageName", jSONObject.toString(), String.class);
                if (callResultM45853a == null || !m48467b(callResultM45853a)) {
                    return -1;
                }
                String str = (String) callResultM45853a.getData();
                if (!"0".equals(str) && !"-4".equals(str)) {
                    if ("-3".equals(str)) {
                        return -2;
                    }
                }
                return 0;
            } catch (Throwable unused) {
                AbstractC7185ho.m43823c("AppRestoreUtils", "call remote occurs exception");
            }
        }
        return -1;
    }

    /* renamed from: b */
    public List<App> m48470b(Context context) {
        try {
            CallResult<String> callResultM45853a = C7483mr.m45852a(context).m45853a("queryUninstalledAppInfo", null, String.class);
            if (callResultM45853a == null) {
                AbstractC7185ho.m43823c("AppRestoreUtils", "get error with result");
                return null;
            }
            if (m48467b(callResultM45853a)) {
                return m48466a(callResultM45853a);
            }
            return null;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("AppRestoreUtils", "get info failed");
            return null;
        }
    }

    /* renamed from: a */
    public static C7832k m48465a() {
        return f36112a;
    }

    /* renamed from: b */
    private <T> boolean m48467b(CallResult<T> callResult) {
        int code = callResult.getCode();
        AbstractC7185ho.m43818a("AppRestoreUtils", "call rs result code:%s", Integer.valueOf(code));
        boolean z10 = code == 200;
        if (z10) {
            this.f36113b.set(!"-100".equals(callResult.getData()));
            AbstractC7185ho.m43818a("AppRestoreUtils", "updated isRemoteSupport:%s", Boolean.valueOf(this.f36113b.get()));
        }
        return z10;
    }

    /* renamed from: a */
    private List<App> m48466a(CallResult<String> callResult) throws JSONException {
        String data = callResult.getData();
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(data)) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = new JSONObject(data).optJSONArray("result_list");
        if (jSONArrayOptJSONArray != null) {
            arrayList = new ArrayList();
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i10);
                App app = new App();
                app.m39703b(jSONObject.optString("packageName"));
                app.m39700a(jSONObject.optString("versionName"));
                arrayList.add(app);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public boolean m48469a(Context context) {
        String str;
        AbstractC7185ho.m43818a("AppRestoreUtils", "isRemoteSupport:%s", this.f36113b);
        if (!this.f36113b.get()) {
            return false;
        }
        if (!C7845x.m48590o(context) && !C7845x.m48587n(context)) {
            str = "device not phone or pad, not support";
        } else {
            if (C6982bz.m41152b(context)) {
                return true;
            }
            str = "device not support";
        }
        AbstractC7185ho.m43817a("AppRestoreUtils", str);
        return false;
    }
}
