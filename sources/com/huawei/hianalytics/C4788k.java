package com.huawei.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.data.WorkKeyHandler;
import com.huawei.hianalytics.kit.AesKeyGetterImpl;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hianalytics.k */
/* loaded from: classes5.dex */
public class C4788k {

    /* renamed from: a */
    public static C4788k f21838a;

    /* renamed from: a */
    public Context f21841a;

    /* renamed from: a */
    public final ConcurrentHashMap<String, C4747d1> f21842a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static final String[] f21840a = {"ABTesting", "_default_config_tag"};

    /* renamed from: a */
    public static final Object f21839a = new Object();

    /* renamed from: a */
    public C4747d1 m28954a(String str) {
        String str2;
        if (str == null) {
            str2 = "tag can't be null";
        } else {
            if (this.f21842a.containsKey(str)) {
                HiLog.m28807d("HADM", "tag: " + str + " found");
                return this.f21842a.get(str);
            }
            str2 = "tag: " + str + " not found";
        }
        HiLog.m28811sw("HADM", str2);
        return null;
    }

    /* renamed from: a */
    public void m28956a(Context context) {
        synchronized (f21839a) {
            try {
                if (this.f21841a != null) {
                    HiLog.m28809i("HADM", "sdk has been initialized");
                    return;
                }
                this.f21841a = context;
                EnvUtils.setAppContext(context);
                WorkKeyHandler.setAesKeyGetter(new AesKeyGetterImpl());
                C4782i.m28891a().m28893a().f21854f = context.getPackageName();
                C4782i.m28891a().m28893a().f21846a = C4785j.m28941c(C4785j.m28947e() ? "ro.build.version.magic" : "ro.build.version.emui", "");
                C4782i.m28891a().m28893a().f21869u = C4785j.m28941c("hw_sc.build.platform.version", "");
                C4793m0 c4793m0M28967a = C4793m0.m28967a();
                if (c4793m0M28967a.f21879a == null) {
                    c4793m0M28967a.f21879a = context;
                }
                C4782i.m28891a().m28893a().f21863o = C4785j.m28930b(context);
                String strM28903a = C4785j.m28903a(context);
                C4782i.m28891a().m28893a().f21856h = TextUtils.isEmpty(strM28903a) ? "" : strM28903a;
                if (!C4787j1.f21836a.m28952a()) {
                    HiLog.m28809i("HADM", "user lock");
                    return;
                }
                String strM28908a = C4785j.m28908a("global_v2", "app_ver", "");
                C4785j.m28918a("global_v2", "app_ver", strM28903a);
                C4782i.m28891a().m28893a().f21857i = strM28908a;
                if (TextUtils.isEmpty(strM28903a) || strM28903a.equals(strM28908a)) {
                    return;
                }
                C4782i.m28891a().m28893a().f21848b = System.currentTimeMillis();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static C4788k m28953a() {
        if (f21838a == null) {
            synchronized (C4788k.class) {
                if (f21838a == null) {
                    f21838a = new C4788k();
                }
            }
        }
        return f21838a;
    }

    /* renamed from: a */
    public C4747d1 m28955a(String str, C4747d1 c4747d1) {
        C4747d1 c4747d1PutIfAbsent = this.f21842a.putIfAbsent(str, c4747d1);
        C4747d1 c4747d12 = this.f21842a.get(str);
        if (c4747d12 != null) {
            C4782i c4782iM28891a = C4782i.m28891a();
            C4750e1 c4750e1 = c4747d12.f21701a;
            c4782iM28891a.getClass();
            C4782i.f21830a.put(str, c4750e1);
        }
        return c4747d1PutIfAbsent;
    }
}
