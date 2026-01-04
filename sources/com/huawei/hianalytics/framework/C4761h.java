package com.huawei.hianalytics.framework;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.CommonHeaderEx;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import org.json.JSONException;
import org.json.JSONObject;
import p237du.C9310c;

/* renamed from: com.huawei.hianalytics.framework.h */
/* loaded from: classes5.dex */
public class C4761h extends RunnableC4760g {
    public C4761h(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, long j10, int i10, int i11) throws JSONException {
        super(str, str2, str3, jSONObject, j10, i10, i11);
        String strM28858a = m28858a(jSONObject2, jSONObject3, str, str2);
        this.f21774c = strM28858a;
        if (!TextUtils.isEmpty(strM28858a)) {
            IMandatoryParameters iMandatoryParametersM28848b = C4757d.m28846a().m28848b();
            if (iMandatoryParametersM28848b == null || iMandatoryParametersM28848b.checkDebugModeEnabled()) {
                return;
            }
            this.f21773b = m28857a(this.f21774c);
            return;
        }
        HiLog.m28811sw("RecordTaskEx", "common and header Ex is empty, tag: " + str + ", type: " + str2);
    }

    /* renamed from: a */
    public static String m28857a(String str) {
        return C9310c.m58618b(str);
    }

    @Override // com.huawei.hianalytics.framework.RunnableC4760g, java.lang.Runnable
    public void run() {
        if (!TextUtils.isEmpty(this.f21773b)) {
            CommonHeaderEx commonHeaderEx = new CommonHeaderEx(this.f21773b, this.f21774c);
            IStorageHandler iStorageHandlerM28844c = C4755b.m28844c(this.f21772a);
            if (iStorageHandlerM28844c != null) {
                iStorageHandlerM28844c.insert(commonHeaderEx);
            }
        }
        super.run();
    }

    /* renamed from: a */
    public static String m28858a(JSONObject jSONObject, JSONObject jSONObject2, String str, String str2) throws JSONException {
        StringBuilder sb2;
        String str3;
        if (jSONObject == null && jSONObject2 == null) {
            sb2 = new StringBuilder();
            str3 = "header and evt is null, tag: ";
        } else {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("headerEx", jSONObject);
            jSONObject3.put("commonEx", jSONObject2);
            if (jSONObject3.length() != 0) {
                return jSONObject3.toString();
            }
            sb2 = new StringBuilder();
            str3 = "content is empty, tag: ";
        }
        sb2.append(str3);
        sb2.append(str);
        sb2.append(", type: ");
        sb2.append(str2);
        HiLog.m28811sw("RecordTaskEx", sb2.toString());
        return "";
    }
}
