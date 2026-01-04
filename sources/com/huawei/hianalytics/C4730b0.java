package com.huawei.hianalytics;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.threadpool.TaskThread;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.secure.android.common.util.SafeBase64;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.b0 */
/* loaded from: classes5.dex */
public class C4730b0 extends AbstractC4786j0 {

    /* renamed from: a */
    public final List<a> f21645a;

    /* renamed from: b */
    public String f21646b;

    /* renamed from: c */
    public String f21647c;

    /* renamed from: d */
    public String f21648d;

    /* renamed from: e */
    public String f21649e;

    /* renamed from: com.huawei.hianalytics.b0$a */
    public static class a {

        /* renamed from: a */
        public long f21650a;

        /* renamed from: a */
        public String f21651a;

        /* renamed from: b */
        public String f21652b;

        /* renamed from: c */
        public String f21653c;

        /* renamed from: d */
        public String f21654d;

        /* renamed from: e */
        public String f21655e;

        /* renamed from: a */
        public JSONObject m28778a() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MapKeyNames.PACKAGE_NAME, this.f21652b);
                jSONObject.put("dst_package_name", this.f21652b);
                jSONObject.put("dst_page_name", this.f21654d);
                jSONObject.put("src_package_name", this.f21651a);
                jSONObject.put("src_page_name", this.f21653c);
                jSONObject.put("triggerTime", this.f21650a);
                jSONObject.put("version", InterfaceC5323b.f24693t);
                if (!TextUtils.isEmpty(this.f21655e)) {
                    jSONObject.put("lite_name", this.f21655e);
                }
            } catch (JSONException unused) {
                HiLog.m28812w("CC3", "toJson error");
            }
            return jSONObject;
        }
    }

    public C4730b0(Handler handler, String str) {
        super(handler, str);
        this.f21645a = new ArrayList();
    }

    @Override // com.huawei.hianalytics.AbstractC4786j0
    /* renamed from: a */
    public void mo28775a() {
    }

    @Override // com.huawei.hianalytics.AbstractC4786j0
    /* renamed from: a */
    public void mo28776a(final Bundle bundle) {
        if (C4803s.m29018a().f21929e) {
            String str = C4803s.m29018a().f21916a;
            if ((TextUtils.equals(str, "all") || TextUtils.equals(str, ((AbstractC4786j0) this).f21835a)) && "onResume".equalsIgnoreCase(bundle.getString(CommonConstant.ReqAccessTokenParam.STATE_LABEL)) && (!bundle.getBoolean("isHomeActivity"))) {
                TaskThread.getRecordThread().addToQueue(new Runnable() { // from class: pj.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f56352a.m28773b(bundle);
                    }
                });
            }
        }
    }

    /* renamed from: b */
    public synchronized void m28777b() {
        HiAnalyticsInstance instanceByTag;
        if (this.f21645a.isEmpty()) {
            return;
        }
        try {
            instanceByTag = HiAnalyticsManager.getInstanceByTag("ha_default_collection");
        } catch (Throwable th2) {
            HiLog.m28809i("CC3", "flush fail: " + th2.getMessage());
        }
        if (instanceByTag == null) {
            this.f21645a.clear();
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<a> it = this.f21645a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m28778a());
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageOpen", jSONArray);
        instanceByTag.onEventSync(0, "106", jSONObject);
        this.f21645a.clear();
        return;
    }

    /* renamed from: b */
    public void m28773b(Bundle bundle) {
        ComponentName componentName;
        try {
            componentName = (ComponentName) bundle.getParcelable("comp");
        } catch (Throwable unused) {
            componentName = null;
        }
        if (componentName == null) {
            return;
        }
        String packageName = componentName.getPackageName();
        String className = componentName.getClassName();
        String shortClassName = componentName.getShortClassName();
        if (TextUtils.isEmpty(shortClassName)) {
            shortClassName = null;
        } else {
            int iLastIndexOf = shortClassName.lastIndexOf(".");
            if (iLastIndexOf > -1) {
                shortClassName = shortClassName.substring(iLastIndexOf + 1);
            }
        }
        if (!TextUtils.isEmpty(className)) {
            Iterator<String> it = C4803s.m29018a().f21925c.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(className, it.next())) {
                    return;
                }
            }
        }
        if (!TextUtils.isEmpty(this.f21646b) && !TextUtils.isEmpty(className)) {
            Iterator<String> it2 = C4803s.m29018a().f21921b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (className.startsWith(it2.next())) {
                    this.f21647c = packageName;
                    a aVar = new a();
                    aVar.f21651a = this.f21646b;
                    aVar.f21652b = this.f21647c;
                    aVar.f21653c = this.f21648d;
                    aVar.f21654d = shortClassName;
                    aVar.f21650a = System.currentTimeMillis();
                    String string = this.f21649e;
                    if (!TextUtils.isEmpty(string)) {
                        string = SafeBase64.encodeToString(string.getBytes(StandardCharsets.UTF_8), 0);
                    }
                    if (!TextUtils.isEmpty(string)) {
                        string = new StringBuilder(string).reverse().toString();
                    }
                    aVar.f21655e = string;
                    synchronized (this) {
                        try {
                            ((AbstractC4786j0) this).f21834a.removeMessages(6);
                            this.f21645a.add(aVar);
                            if (this.f21645a.size() >= C4803s.m29018a().f21914a) {
                                m28777b();
                            } else {
                                ((AbstractC4786j0) this).f21834a.sendEmptyMessageDelayed(6, C4803s.m29018a().f21927d);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            }
        }
        this.f21646b = packageName;
        this.f21648d = shortClassName;
        if (!C4785j.m28924a(className)) {
            this.f21649e = null;
        } else {
            ((AbstractC4786j0) this).f21834a.removeMessages(7);
            ((AbstractC4786j0) this).f21834a.sendEmptyMessageDelayed(7, C4803s.m29018a().f21923c);
        }
    }
}
