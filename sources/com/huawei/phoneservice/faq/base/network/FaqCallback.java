package com.huawei.phoneservice.faq.base.network;

import android.app.Activity;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Response;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import p692uw.C13267j;

/* loaded from: classes4.dex */
public abstract class FaqCallback<T> implements Callback {

    /* renamed from: a */
    public final Class<T> f38647a;

    /* renamed from: b */
    public Gson f38648b;

    /* renamed from: c */
    public WeakReference<Activity> f38649c;

    public FaqCallback(Class<T> cls, Activity activity) {
        C13267j.m79677e(cls, "clazz");
        this.f38647a = cls;
        this.f38648b = new Gson();
        this.f38649c = new WeakReference<>(activity);
    }

    /* renamed from: e */
    public static final void m51774e(FaqCallback faqCallback, String str) throws Throwable {
        C13267j.m79677e(faqCallback, "this$0");
        faqCallback.m51778g(str);
    }

    /* renamed from: f */
    public static final void m51775f(FaqCallback faqCallback, Throwable th2) {
        C13267j.m79677e(faqCallback, "this$0");
        faqCallback.onResult(th2, null);
    }

    /* renamed from: c */
    public final void m51776c(Response response, final String str) throws Throwable {
        WeakReference<Activity> weakReference = this.f38649c;
        Activity activity = weakReference != null ? weakReference.get() : null;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.huawei.phoneservice.faq.base.network.b
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    FaqCallback.m51774e(this.f38658a, str);
                }
            });
        } else {
            m51778g(str);
        }
    }

    /* renamed from: d */
    public final void m51777d(Response response, final Throwable th2) {
        WeakReference<Activity> weakReference = this.f38649c;
        Activity activity = weakReference != null ? weakReference.get() : null;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.huawei.phoneservice.faq.base.network.a
                @Override // java.lang.Runnable
                public final void run() {
                    FaqCallback.m51775f(this.f38656a, th2);
                }
            });
        } else {
            onResult(th2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public final void m51778g(String str) throws Throwable {
        try {
            onResult(null, this.f38648b.fromJson(str, (Class) this.f38647a));
        } catch (Throwable th2) {
            onResult(th2, null);
            FaqLogger.m51842e("doResult", th2);
        }
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
    public void onFailure(Submit submit, Throwable th2) throws Throwable {
        C13267j.m79677e(submit, "submit");
        C13267j.m79677e(th2, "throwable");
        try {
            m51777d(null, th2);
        } catch (Throwable th3) {
            FaqLogger.m51842e("FaqCallback", th3);
        }
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
    public void onResponse(Submit submit, Response response) throws Throwable {
        C13267j.m79677e(submit, "submit");
        C13267j.m79677e(response, TrackConstants$Opers.RESPONSE);
        String strByte2Str = StringUtils.byte2Str(response.getBody().bytes());
        try {
            String string = null;
            if (FaqStringUtil.isEmpty(strByte2Str)) {
                C13267j.m79675c(null, "null cannot be cast to non-null type kotlin.String");
            } else {
                JSONObject jSONObject = new JSONObject(strByte2Str);
                int iOptInt = jSONObject.optInt("responseCode");
                String strOptString = jSONObject.optString("responseDesc");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("responseData");
                int iOptInt2 = jSONObject.optInt("code");
                String strOptString2 = jSONObject.optString("msg");
                if (iOptInt != 200) {
                    if (iOptInt2 != 0) {
                        m51777d(response, new FaqWebServiceException(iOptInt2, strOptString2));
                        return;
                    } else {
                        m51777d(response, new FaqWebServiceException(iOptInt, strOptString));
                        return;
                    }
                }
                if (jSONObjectOptJSONObject != null) {
                    string = jSONObjectOptJSONObject.toString();
                }
            }
            m51776c(response, string);
        } catch (Exception e10) {
            m51777d(response, e10);
        }
    }

    @Keep
    public abstract void onResult(Throwable th2, T t10);
}
