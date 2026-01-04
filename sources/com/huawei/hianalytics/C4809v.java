package com.huawei.hianalytics;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.threadpool.TaskThread;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.secure.android.common.util.SafeBase64;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.v */
/* loaded from: classes5.dex */
public class C4809v extends AbstractC4786j0 {

    /* renamed from: a */
    public long f21945a;

    /* renamed from: a */
    public final List<a> f21946a;

    /* renamed from: b */
    public String f21947b;

    /* renamed from: c */
    public String f21948c;

    /* renamed from: com.huawei.hianalytics.v$a */
    public static class a {

        /* renamed from: a */
        public int f21949a;

        /* renamed from: a */
        public long f21950a;

        /* renamed from: a */
        public String f21951a;

        /* renamed from: b */
        public long f21952b;

        /* renamed from: b */
        public String f21953b;

        public a(String str, int i10, long j10, long j11, String str2) {
            this.f21951a = str;
            this.f21949a = i10;
            this.f21950a = j10;
            this.f21952b = j11;
            this.f21953b = str2;
        }

        /* renamed from: a */
        public JSONObject m29046a() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            String string = this.f21951a;
            if (!TextUtils.isEmpty(string)) {
                string = SafeBase64.encodeToString(string.getBytes(StandardCharsets.UTF_8), 0);
            }
            if (!TextUtils.isEmpty(string)) {
                string = new StringBuilder(string).reverse().toString();
            }
            jSONObject.put("label", string);
            jSONObject.put("cnt", this.f21949a);
            jSONObject.put("firstTimeStamp", this.f21950a);
            jSONObject.put("lastTimeStamp", this.f21952b);
            jSONObject.put("version", InterfaceC5323b.f24693t);
            jSONObject.put("packageName", this.f21953b);
            return jSONObject;
        }
    }

    public C4809v(Handler handler, String str) {
        super(handler, str);
        this.f21946a = new ArrayList();
    }

    @Override // com.huawei.hianalytics.AbstractC4786j0
    /* renamed from: a */
    public void mo28775a() {
        m29044b();
    }

    /* renamed from: c */
    public synchronized void m29045c() {
        try {
            if (this.f21946a.isEmpty()) {
                return;
            }
            try {
                HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("ha_default_collection");
                if (instanceByTag != null) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<a> it = this.f21946a.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().m29046a());
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("liteApps", jSONArray);
                    jSONObject.put("version", "2.0");
                    if (HiLog.isDebugEnable()) {
                        HiLog.m28807d("CC2", "onEvent:" + jSONObject);
                    }
                    instanceByTag.onEventSync(0, "101", jSONObject);
                }
            } catch (Throwable th2) {
                HiLog.m28809i("CC2", "flush fail: " + th2.getMessage());
            }
            this.f21946a.clear();
        } catch (Throwable th3) {
            throw th3;
        }
    }

    @Override // com.huawei.hianalytics.AbstractC4786j0
    /* renamed from: a */
    public void mo28776a(final Bundle bundle) {
        if (InterfaceC4776g.f21821a[0].equals(((AbstractC4786j0) this).f21835a) && C4803s.m29018a().f21926c && "onResume".equalsIgnoreCase(bundle.getString(CommonConstant.ReqAccessTokenParam.STATE_LABEL))) {
            TaskThread.getRecordThread().addToQueue(new Runnable() { // from class: pj.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f56364a.m29042b(bundle);
                }
            });
        }
    }

    /* renamed from: b */
    public synchronized void m29044b() {
        try {
            if (TextUtils.isEmpty(this.f21947b)) {
                return;
            }
            ((AbstractC4786j0) this).f21834a.removeMessages(2);
            this.f21946a.add(new a(this.f21947b, 1, this.f21945a, System.currentTimeMillis(), this.f21948c));
            if (this.f21946a.size() >= C4803s.m29018a().f21914a) {
                m29045c();
            } else {
                ((AbstractC4786j0) this).f21834a.sendEmptyMessageDelayed(2, C4803s.m29018a().f21927d);
            }
            this.f21947b = "";
            this.f21945a = 0L;
            this.f21948c = "";
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: b */
    public void m29042b(Bundle bundle) {
        try {
            ComponentName componentName = (ComponentName) bundle.getParcelable("comp");
            if (componentName == null) {
                return;
            }
            ((AbstractC4786j0) this).f21834a.removeMessages(1);
            if (C4785j.m28924a(componentName.getClassName())) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = componentName.getPackageName();
                ((AbstractC4786j0) this).f21834a.sendMessageDelayed(messageObtain, C4803s.m29018a().f21923c);
            } else {
                m29044b();
            }
        } catch (Throwable th2) {
            HiLog.m28809i("CC2", "cache " + th2.getMessage());
        }
    }
}
