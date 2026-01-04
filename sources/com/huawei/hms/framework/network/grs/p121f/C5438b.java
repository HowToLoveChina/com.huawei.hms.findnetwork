package com.huawei.hms.framework.network.grs.p121f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.C5462a;
import com.huawei.hms.framework.network.grs.p120e.C5434a;
import com.huawei.hms.framework.network.grs.p120e.C5436c;
import com.huawei.hms.framework.network.grs.p125h.C5457c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* renamed from: com.huawei.hms.framework.network.grs.f.b */
/* loaded from: classes8.dex */
public class C5438b {

    /* renamed from: b */
    private static final Map<String, C5438b> f24929b = new ConcurrentHashMap(16);

    /* renamed from: c */
    private static final Object f24930c = new Object();

    /* renamed from: a */
    private AbstractC5437a f24931a;

    public C5438b() {
        this.f24931a = new C5440d(true, true);
    }

    /* renamed from: a */
    public static C5438b m32226a(String str) {
        return f24929b.get(str);
    }

    /* renamed from: b */
    public Set<String> m32233b() {
        return this.f24931a.m32220c();
    }

    public C5438b(Context context, boolean z10) throws IOException {
        m32227a(context, z10);
        f24929b.put(context.getPackageName(), this);
    }

    /* renamed from: a */
    public C5462a m32228a() {
        return this.f24931a.m32217b();
    }

    /* renamed from: a */
    public String m32229a(Context context, C5434a c5434a, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z10) {
        String strM32210a;
        synchronized (f24930c) {
            strM32210a = this.f24931a.m32210a(context, c5434a, grsBaseInfo, str, str2, z10);
        }
        return strM32210a;
    }

    /* renamed from: a */
    public Map<String, String> m32230a(Context context, C5434a c5434a, GrsBaseInfo grsBaseInfo, String str, boolean z10) {
        Map<String, String> mapM32213a;
        synchronized (f24930c) {
            mapM32213a = this.f24931a.m32213a(context, c5434a, grsBaseInfo, str, z10);
        }
        return mapM32213a;
    }

    /* renamed from: a */
    private void m32227a(Context context, boolean z10) throws IOException {
        String[] strArrSplit;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM32327a = C5457c.m32327a("grs_route_config_files_list.txt", context);
        Logger.m32142i("LocalManagerProxy", "initLocalManager configFileListContent TimeCost:%d  Content:%s", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), strM32327a);
        if (TextUtils.isEmpty(strM32327a)) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            strArrSplit = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
            Logger.m32141i("LocalManagerProxy", "list by AssetsManager, timeCost:" + (System.currentTimeMillis() - jCurrentTimeMillis2));
        } else {
            strArrSplit = strM32327a.split("#");
        }
        List<String> arrayList = strArrSplit == null ? new ArrayList<>() : Arrays.asList(strArrSplit);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.m32141i("LocalManagerProxy", "appConfigName is: " + appConfigName);
        this.f24931a = new C5440d(false, z10);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.f24931a = new C5440d(context, appConfigName, z10);
        }
        if (!this.f24931a.m32221d() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.f24931a = new C5439c(context, z10);
        }
        this.f24931a.m32215a(context, arrayList);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("on initLocalManager finish, check appGrs: ");
        sb2.append(this.f24931a.f24924a == null);
        Logger.m32141i("LocalManagerProxy", sb2.toString());
    }

    /* renamed from: a */
    public void m32231a(String str, C5436c c5436c) {
        String str2;
        try {
            c5436c.m32204b(str + "#localConfig", this.f24931a.m32214a().toString());
        } catch (JSONException unused) {
            str2 = "save local config encounter JSONException.";
            Logger.m32145w("LocalManagerProxy", str2);
        } catch (Throwable th2) {
            str2 = "save local config encounter Throwable:" + StringUtils.anonymizeMessage(th2.getMessage());
            Logger.m32145w("LocalManagerProxy", str2);
        }
    }

    /* renamed from: a */
    public boolean m32232a(Context context, String str) {
        boolean zM32222d = this.f24931a.m32222d(str);
        f24929b.put(context.getPackageName(), this);
        return zM32222d;
    }
}
