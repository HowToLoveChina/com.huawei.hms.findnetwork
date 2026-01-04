package com.huawei.phoneservice.faq.base.network;

import android.app.Activity;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.httpclient.Callback;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import p692uw.C13267j;

/* loaded from: classes4.dex */
public abstract class FaqNewCallback<T> extends Callback<ResponseBody> {
    private WeakReference<Activity> activityWeak;
    private final Class<T> clazz;
    private Gson gson;

    public FaqNewCallback(Class<T> cls, Activity activity) {
        C13267j.m79677e(cls, "clazz");
        this.clazz = cls;
        this.gson = new Gson();
        this.activityWeak = new WeakReference<>(activity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void doResult(String str) throws Throwable {
        try {
            onResult(null, this.gson.fromJson(str, (Class) this.clazz));
        } catch (Throwable th2) {
            onResult(th2, null);
            FaqLogger.m51842e("doResult", th2);
        }
    }

    private final void onFailureCallback(final Throwable th2) {
        WeakReference<Activity> weakReference = this.activityWeak;
        Activity activity = weakReference != null ? weakReference.get() : null;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.huawei.phoneservice.faq.base.network.c
                @Override // java.lang.Runnable
                public final void run() {
                    FaqNewCallback.onFailureCallback$lambda$1(this.f38660a, th2);
                }
            });
        } else {
            onResult(th2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFailureCallback$lambda$1(FaqNewCallback faqNewCallback, Throwable th2) {
        C13267j.m79677e(faqNewCallback, "this$0");
        faqNewCallback.onResult(th2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResponse$lambda$0(FaqNewCallback faqNewCallback, String str) throws Throwable {
        C13267j.m79677e(faqNewCallback, "this$0");
        faqNewCallback.doResult(str);
    }

    @Override // com.huawei.hms.network.httpclient.Callback
    public void onFailure(Submit<ResponseBody> submit, Throwable th2) throws Throwable {
        C13267j.m79677e(submit, "submit");
        C13267j.m79677e(th2, "throwable");
        try {
            onFailureCallback(th2);
        } catch (Throwable th3) {
            FaqLogger.m51842e("FaqNewCallback", th3);
        }
    }

    @Override // com.huawei.hms.network.httpclient.Callback
    public void onResponse(Submit<ResponseBody> submit, Response<ResponseBody> response) throws Throwable {
        C13267j.m79677e(submit, "submit");
        C13267j.m79677e(response, TrackConstants$Opers.RESPONSE);
        String strByte2Str = StringUtils.byte2Str(response.getBody().bytes());
        try {
            String string = null;
            if (FaqStringUtil.isEmpty(strByte2Str)) {
                C13267j.m79675c(null, "null cannot be cast to non-null type kotlin.String");
            } else {
                JSONObject jSONObject = new JSONObject(strByte2Str);
                String strOptString = jSONObject.optString("responseDesc");
                int iOptInt = jSONObject.optInt("responseCode");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("responseData");
                int iOptInt2 = jSONObject.optInt("code");
                String strOptString2 = jSONObject.optString("msg");
                if (iOptInt != 200) {
                    if (iOptInt2 != 0) {
                        onFailureCallback(new FaqWebServiceException(iOptInt2, strOptString2));
                        return;
                    } else {
                        onFailureCallback(new FaqWebServiceException(iOptInt, strOptString));
                        return;
                    }
                }
                if (jSONObjectOptJSONObject != null) {
                    string = jSONObjectOptJSONObject.toString();
                }
            }
            onResponse(string);
        } catch (Exception e10) {
            onFailureCallback(e10);
        }
    }

    @Keep
    public abstract void onResult(Throwable th2, T t10);

    private final void onResponse(final String str) throws Throwable {
        WeakReference<Activity> weakReference = this.activityWeak;
        Activity activity = weakReference != null ? weakReference.get() : null;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.huawei.phoneservice.faq.base.network.d
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    FaqNewCallback.onResponse$lambda$0(this.f38662a, str);
                }
            });
        } else {
            doResult(str);
        }
    }
}
