package com.huawei.hms.network;

import android.content.Context;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.Utils;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes8.dex */
public class RemoteInitializer {

    /* renamed from: b */
    private static final String f25637b = "RemoteInitializer";

    /* renamed from: c */
    private static final String f25638c = "huawei_module_networkkit";

    /* renamed from: a */
    private Context f25639a;

    /* renamed from: com.huawei.hms.network.RemoteInitializer$a */
    public class RunnableC5781a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f25640a;

        /* renamed from: b */
        final /* synthetic */ ExecutorService f25641b;

        /* renamed from: com.huawei.hms.network.RemoteInitializer$a$a */
        public class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ LinkedHashMapPack f25643a;

            public a(LinkedHashMapPack linkedHashMapPack) {
                this.f25643a = linkedHashMapPack;
            }

            @Override // java.lang.Runnable
            public void run() {
                PLSharedPreferences pLSharedPreferences = new PLSharedPreferences(RunnableC5781a.this.f25640a, C5782b.f25653i);
                for (Map.Entry<String, String> entry : this.f25643a.getAll().entrySet()) {
                    pLSharedPreferences.putString(entry.getKey(), entry.getValue());
                }
            }
        }

        public RunnableC5781a(Context context, ExecutorService executorService) {
            this.f25640a = context;
            this.f25641b = executorService;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
            linkedHashMapPack.put("req_start_time", Utils.getCurrentTime(false));
            long currentTime = Utils.getCurrentTime(true);
            RemoteInitializer remoteInitializer = RemoteInitializer.this;
            remoteInitializer.f25639a = remoteInitializer.m33230a(RemoteInitializer.f25638c, this.f25640a, linkedHashMapPack);
            linkedHashMapPack.put("total_time", Utils.getCurrentTime(true) - currentTime);
            this.f25641b.execute(new a(linkedHashMapPack));
        }
    }

    /* renamed from: com.huawei.hms.network.RemoteInitializer$b */
    public static class C5782b {

        /* renamed from: a */
        private static final String f25645a = "req_start_time";

        /* renamed from: b */
        private static final String f25646b = "total_time";

        /* renamed from: c */
        private static final String f25647c = "error_code";

        /* renamed from: d */
        private static final String f25648d = "exception_name";

        /* renamed from: e */
        private static final String f25649e = "message";

        /* renamed from: f */
        private static final String f25650f = "split_modules_msg";

        /* renamed from: g */
        private static final String f25651g = "split_module";

        /* renamed from: h */
        public static final String f25652h = "kit_version";

        /* renamed from: i */
        public static final String f25653i = "network_load_analytics";

        /* renamed from: j */
        private static final int f25654j = 10000900;

        /* renamed from: k */
        private static final int f25655k = 10000901;
    }

    /* renamed from: a */
    public Context m33230a(String str, Context context, LinkedHashMapPack linkedHashMapPack) {
        DynamicModule.enable3rdPhone(str, true);
        DynamicModule.enableLowEMUI(str, true);
        try {
            Context moduleContext = DynamicModule.loadV2(context, DynamicModule.PREFER_REMOTE, str).getModuleContext();
            linkedHashMapPack.put("error_code", 10000900L);
            return moduleContext;
        } catch (DynamicModule.LoadingException e10) {
            linkedHashMapPack.put("exception_name", e10.getClass().getName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(e10.getMessage()));
            linkedHashMapPack.put("error_code", 10000901L);
            Logger.m32145w(f25637b, " load module " + str + " failed " + StringUtils.anonymizeMessage(e10.getMessage()));
            return null;
        }
    }

    public Context getRemoteContext() {
        return this.f25639a;
    }

    public synchronized Future init(Context context) {
        ExecutorService executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor = ExecutorsUtils.newSingleThreadExecutor("Loading_NetworkKit");
        return executorServiceNewSingleThreadExecutor.submit(new RunnableC5781a(context, executorServiceNewSingleThreadExecutor));
    }

    public boolean isInited() {
        return this.f25639a != null;
    }
}
