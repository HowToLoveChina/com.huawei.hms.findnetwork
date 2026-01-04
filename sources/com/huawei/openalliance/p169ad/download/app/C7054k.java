package com.huawei.openalliance.p169ad.download.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.InterfaceC7615qq;
import com.huawei.openalliance.p169ad.activity.SafeIntent;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7768bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.download.app.k */
/* loaded from: classes2.dex */
public class C7054k {

    /* renamed from: a */
    private static final byte[] f32460a = new byte[0];

    /* renamed from: b */
    private static final byte[] f32461b = new byte[0];

    /* renamed from: c */
    private static C7054k f32462c;

    /* renamed from: d */
    private Context f32463d;

    /* renamed from: e */
    private Map<String, AppDownloadTask> f32464e = new ConcurrentHashMap();

    /* renamed from: f */
    private long f32465f = C5863b6.g.f26453g;

    /* renamed from: g */
    private String f32466g = Constants.TIMEOUT_TASK_ID + hashCode();

    /* renamed from: h */
    private BroadcastReceiver f32467h = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.k.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String dataString = safeIntent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                AbstractC7185ho.m43823c("GPDownloadManager", "itRer dataString is empty");
                return;
            }
            String strSubstring = dataString.substring(8);
            try {
                if ("android.intent.action.PACKAGE_ADDED".equals(safeIntent.getAction())) {
                    C7054k.this.m42493a(strSubstring);
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("GPDownloadManager", "itRer: %s", th2.getClass().getSimpleName());
            }
        }
    };

    /* renamed from: com.huawei.openalliance.ad.download.app.k$a */
    public static class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C7054k.f32462c == null) {
                return;
            }
            C7054k.f32462c.m42495c();
        }
    }

    private C7054k(Context context) {
        this.f32463d = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C7054k m42490a(Context context) {
        C7054k c7054k;
        synchronized (f32460a) {
            try {
                if (f32462c == null) {
                    f32462c = new C7054k(context);
                }
                c7054k = f32462c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7054k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m42495c() {
        AbstractC7185ho.m43820b("GPDownloadManager", "unRegisterAppInstReceiver");
        this.f32463d.unregisterReceiver(this.f32467h);
    }

    /* renamed from: d */
    private void m42496d() {
        AbstractC7768bo.m47810a(this.f32466g);
        AbstractC7768bo.m47809a(new a(), this.f32466g, this.f32465f);
    }

    /* renamed from: a */
    public void m42497a() {
        AbstractC7185ho.m43820b("GPDownloadManager", "registerAppInstReceiver");
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        AbstractC7741ao.m47536a(this.f32463d, this.f32467h, intentFilter);
        m42496d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m42493a(String str) {
        AbstractC7185ho.m43820b("GPDownloadManager", "dealWithAdd");
        synchronized (f32461b) {
            try {
                if (this.f32464e.containsKey(str)) {
                    AppDownloadTask appDownloadTask = this.f32464e.get(str);
                    this.f32464e.remove(str);
                    AbstractC7185ho.m43821b("GPDownloadManager", "task size after remove: %s", Integer.valueOf(this.f32464e.size()));
                    InterfaceC7615qq interfaceC7615qqM42223C = appDownloadTask.m42223C();
                    if (interfaceC7615qqM42223C != null) {
                        ContentRecord contentRecordMo46574a = interfaceC7615qqM42223C.mo46574a();
                        if (contentRecordMo46574a != null && contentRecordMo46574a.m41484af() != null) {
                            interfaceC7615qqM42223C.mo46596a(Integer.valueOf(appDownloadTask.m42224D()), appDownloadTask.m42226F(), appDownloadTask.m42236P(), contentRecordMo46574a.m41484af().m44430u(), appDownloadTask.m42227G());
                            new C6922c(this.f32463d).m39079a(contentRecordMo46574a, contentRecordMo46574a.m41484af().m44430u(), (AppDownloadTask) null);
                        }
                    }
                }
            } finally {
            }
        }
    }

    /* renamed from: a */
    public void m42498a(String str, AppDownloadTask appDownloadTask) {
        synchronized (f32461b) {
            try {
                AbstractC7185ho.m43818a("GPDownloadManager", "task size before: %s", Integer.valueOf(this.f32464e.size()));
                for (Map.Entry entry : new ConcurrentHashMap(this.f32464e).entrySet()) {
                    AbstractC7185ho.m43818a("GPDownloadManager", "entry key: %s time: %s", entry.getKey(), Long.valueOf(((AppDownloadTask) entry.getValue()).m42238R()));
                    if (System.currentTimeMillis() - ((AppDownloadTask) entry.getValue()).m42238R() > 900000) {
                        this.f32464e.remove(entry.getKey());
                    }
                }
                this.f32464e.put(str, appDownloadTask);
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(this.f32464e.size());
                objArr[1] = str;
                objArr[2] = this.f32464e.get(str) != null ? Long.valueOf(this.f32464e.get(str).m42238R()) : null;
                AbstractC7185ho.m43821b("GPDownloadManager", "task size after: %s, packageName: %s time: %s", objArr);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
