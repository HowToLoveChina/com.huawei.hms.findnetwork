package com.huawei.hianalytics.framework;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.datahandler.ReportTask;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import com.huawei.hianalytics.framework.threadpool.TaskThread;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.framework.a */
/* loaded from: classes5.dex */
public class C4754a implements HAFrameworkInstance {

    /* renamed from: a */
    public final String f21742a;

    public C4754a(String str) {
        this.f21742a = str;
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void clearCacheDataAll() {
        IStorageHandler iStorageHandlerM28844c;
        C4765l c4765lM28868a = C4765l.m28868a();
        String str = this.f21742a;
        synchronized (c4765lM28868a) {
            try {
                iStorageHandlerM28844c = C4755b.m28844c(str);
            } catch (Exception unused) {
                HiLog.m28808e("HES", "clearCacheDataByTag Exception");
            }
            if (iStorageHandlerM28844c != null) {
                iStorageHandlerM28844c.deleteByTag(str);
            }
        }
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void clearCacheDataByTag() {
        IStorageHandler iStorageHandlerM28844c;
        C4765l c4765lM28868a = C4765l.m28868a();
        String str = this.f21742a;
        synchronized (c4765lM28868a) {
            try {
                iStorageHandlerM28844c = C4755b.m28844c(str);
            } catch (Exception unused) {
                HiLog.m28808e("HES", "clearCacheDataByTag Exception");
            }
            if (iStorageHandlerM28844c != null) {
                iStorageHandlerM28844c.deleteByTag(str);
            }
        }
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void clearCacheDataByTagType(String str) {
        IStorageHandler iStorageHandlerM28844c;
        C4765l c4765lM28868a = C4765l.m28868a();
        String str2 = this.f21742a;
        synchronized (c4765lM28868a) {
            try {
                iStorageHandlerM28844c = C4755b.m28844c(str2);
            } catch (Exception unused) {
                HiLog.m28808e("HES", "clearCacheDataByTagType Exception");
            }
            if (iStorageHandlerM28844c != null) {
                iStorageHandlerM28844c.deleteByTagType(str2, str);
            }
        }
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void onEvent(String str, String str2, JSONObject jSONObject, ICallback iCallback) {
        C4765l c4765lM28868a = C4765l.m28868a();
        String str3 = this.f21742a;
        synchronized (c4765lM28868a) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            IStoragePolicy iStoragePolicyM28845d = C4755b.m28845d(str3);
            RunnableC4760g runnableC4760g = new RunnableC4760g(str3, str, str2, jSONObject, jCurrentTimeMillis, iStoragePolicyM28845d.getDecryptBatchSize(str), iStoragePolicyM28845d.getDecryptBatchSleepTime(str));
            runnableC4760g.f21783l = iCallback;
            TaskThread.getRecordThread().addToQueue(runnableC4760g);
        }
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void onEventSync(String str, String str2, JSONObject jSONObject) {
        C4765l c4765lM28868a = C4765l.m28868a();
        String str3 = this.f21742a;
        synchronized (c4765lM28868a) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            IStoragePolicy iStoragePolicyM28845d = C4755b.m28845d(str3);
            new RunnableC4760g(str3, str, str2, jSONObject, jCurrentTimeMillis, iStoragePolicyM28845d.getDecryptBatchSize(str), iStoragePolicyM28845d.getDecryptBatchSleepTime(str)).run();
        }
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void onReport(String str) {
        StringBuilder sb2;
        String str2;
        C4765l c4765lM28868a = C4765l.m28868a();
        String str3 = this.f21742a;
        c4765lM28868a.getClass();
        if (TextUtils.isEmpty(C4755b.m28837a(str3, str))) {
            sb2 = new StringBuilder();
            str2 = "collectUrl is empty, tag: ";
        } else {
            IStoragePolicy iStoragePolicyM28845d = C4755b.m28845d(str3);
            if (iStoragePolicyM28845d == null) {
                sb2 = new StringBuilder();
                str2 = "policy is invalid, tag: ";
            } else if (iStoragePolicyM28845d.decide(IStoragePolicy.PolicyType.NETWORK, str)) {
                TaskThread.getReportThread().addToQueue(new ReportTask(str3, str, "", iStoragePolicyM28845d.getDecryptBatchSize(str), iStoragePolicyM28845d.getDecryptBatchSleepTime(str)));
                return;
            } else {
                sb2 = new StringBuilder();
                str2 = "network is invalid, tag: ";
            }
        }
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(", type: ");
        sb2.append(str);
        HiLog.m28812w("HES", sb2.toString());
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void onStreamEvent(String str, String str2, JSONObject jSONObject, ICallback iCallback) {
        C4765l c4765lM28868a = C4765l.m28868a();
        String str3 = this.f21742a;
        c4765lM28868a.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        IStoragePolicy iStoragePolicyM28845d = C4755b.m28845d(str3);
        RunnableC4760g runnableC4760g = new RunnableC4760g(str3, str, str2, jSONObject, jCurrentTimeMillis, iStoragePolicyM28845d.getDecryptBatchSize(str), iStoragePolicyM28845d.getDecryptBatchSleepTime(str));
        runnableC4760g.f21782k = true;
        runnableC4760g.f21783l = iCallback;
        TaskThread.getRecordThread().addToQueue(runnableC4760g);
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void onEvent(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, ICallback iCallback) {
        C4765l c4765lM28868a = C4765l.m28868a();
        String str3 = this.f21742a;
        synchronized (c4765lM28868a) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            IStoragePolicy iStoragePolicyM28845d = C4755b.m28845d(str3);
            try {
                C4761h c4761h = new C4761h(str3, str, str2, jSONObject, jSONObject2, jSONObject3, jCurrentTimeMillis, iStoragePolicyM28845d.getDecryptBatchSize(str), iStoragePolicyM28845d.getDecryptBatchSleepTime(str));
                c4761h.f21783l = iCallback;
                TaskThread.getRecordThread().addToQueue(c4761h);
            } catch (JSONException unused) {
                HiLog.m28812w("HES", "headerEx or commonEx is not json");
            }
        }
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void onStreamEvent(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, ICallback iCallback) {
        C4765l c4765lM28868a = C4765l.m28868a();
        String str3 = this.f21742a;
        c4765lM28868a.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        IStoragePolicy iStoragePolicyM28845d = C4755b.m28845d(str3);
        try {
            C4761h c4761h = new C4761h(str3, str, str2, jSONObject, jSONObject2, jSONObject3, jCurrentTimeMillis, iStoragePolicyM28845d.getDecryptBatchSize(str), iStoragePolicyM28845d.getDecryptBatchSleepTime(str));
            c4761h.f21782k = true;
            c4761h.f21783l = iCallback;
            TaskThread.getRecordThread().addToQueue(c4761h);
        } catch (JSONException unused) {
            HiLog.m28812w("HES", "headerEx or commonEx is not json");
        }
    }
}
