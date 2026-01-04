package com.huawei.hianalytics.framework;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.datahandler.ReportTask;
import com.huawei.hianalytics.framework.listener.HAEventManager;
import com.huawei.hianalytics.framework.listener.IHAEventListener;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import com.huawei.hianalytics.framework.threadpool.TaskThread;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.framework.g */
/* loaded from: classes5.dex */
public class RunnableC4760g implements Runnable {

    /* renamed from: a */
    public String f21772a;

    /* renamed from: b */
    public String f21773b;

    /* renamed from: c */
    public String f21774c;

    /* renamed from: d */
    public final String f21775d;

    /* renamed from: e */
    public final String f21776e;

    /* renamed from: f */
    public final JSONObject f21777f;

    /* renamed from: g */
    public final long f21778g;

    /* renamed from: h */
    public final IMandatoryParameters f21779h = C4757d.m28846a().m28848b();

    /* renamed from: i */
    public final int f21780i;

    /* renamed from: j */
    public final int f21781j;

    /* renamed from: k */
    public boolean f21782k;

    /* renamed from: l */
    public ICallback f21783l;

    public RunnableC4760g(String str, String str2, String str3, JSONObject jSONObject, long j10, int i10, int i11) {
        this.f21772a = str;
        this.f21776e = str3;
        this.f21777f = jSONObject;
        this.f21778g = j10;
        this.f21775d = str2;
        this.f21780i = i10;
        this.f21781j = i11;
    }

    @Override // java.lang.Runnable
    public void run() {
        IHAEventListener eventListener;
        IHAEventListener eventListener2;
        JSONObject jSONObject;
        Event event = new Event();
        event.setServicetag(this.f21772a);
        event.setEvttype(this.f21775d);
        event.setEvtid(this.f21776e);
        JSONObject jSONObject2 = this.f21777f;
        String string = jSONObject2 != null ? jSONObject2.toString() : "{}";
        event.setEvttime(String.valueOf(this.f21778g));
        event.setSessionid("");
        event.setSessionname("");
        event.setSubCount((!Event.EventConstants.EVENT_ID_AGGREGATE.equals(this.f21776e) || (jSONObject = this.f21777f) == null) ? 1 : jSONObject.optInt(Event.EventConstants.SUB_COUNT, 1));
        event.setEvtExHashCode(this.f21773b);
        IMandatoryParameters iMandatoryParameters = this.f21779h;
        if (iMandatoryParameters == null) {
            return;
        }
        event.setProcessname(iMandatoryParameters.getProcessName());
        if (this.f21782k) {
            event.setContent(string);
            ArrayList arrayList = new ArrayList();
            arrayList.add(event);
            C4762i c4762i = new C4762i(this.f21772a, this.f21775d, arrayList, this.f21783l, "", this.f21780i, this.f21781j);
            c4762i.f21789f = true;
            c4762i.m28860a();
            return;
        }
        if (C4755b.m28843b(this.f21772a).isLocalEncrypted(this.f21775d)) {
            event.setContent(C4755b.m28836a(string, this.f21779h));
            event.setIsEncrypted(1);
        } else {
            event.setContent(string);
            event.setIsEncrypted(0);
        }
        IStorageHandler iStorageHandlerM28844c = C4755b.m28844c(this.f21772a);
        IStoragePolicy iStoragePolicyM28845d = C4755b.m28845d(this.f21772a);
        if (iStorageHandlerM28844c == null || iStoragePolicyM28845d == null) {
            HiLog.m28808e("RecordTask", "storageHandler is null! tag: " + this.f21772a);
            return;
        }
        if (iStoragePolicyM28845d.decide(IStoragePolicy.PolicyType.STORAGE_LENGTH, this.f21775d)) {
            HiLog.m28808e("RecordTask", "db file reach max size, clear db file, tag: " + this.f21772a);
            iStorageHandlerM28844c.deleteAll();
        } else {
            long eventSize = iStorageHandlerM28844c.readEventSize(this.f21772a);
            if (eventSize == 0 && event.getSubCount() == 1) {
                C4755b.m28838a(this.f21783l, iStorageHandlerM28844c, event);
                HiLog.m28809i("RecordTask", "record evt size: 1, tag: " + this.f21772a + ", type: " + this.f21775d);
                return;
            }
            if (eventSize <= 5000) {
                C4755b.m28838a(this.f21783l, iStorageHandlerM28844c, event);
                C4758e c4758eM28833a = C4755b.m28833a(this.f21772a);
                if (c4758eM28833a == null) {
                    HiLog.m28812w("RecordTask", "framework config is null, tag: " + this.f21772a);
                    return;
                }
                Long l10 = c4758eM28833a.f21762b.get(this.f21775d);
                long jLongValue = l10 != null ? l10.longValue() : 0L;
                long jCurrentTimeMillis = System.currentTimeMillis();
                Long l11 = c4758eM28833a.f21763c.get(this.f21775d);
                long jLongValue2 = l11 != null ? l11.longValue() : 30000L;
                if (jCurrentTimeMillis - jLongValue <= jLongValue2) {
                    return;
                }
                long eventSize2 = iStorageHandlerM28844c.readEventSize(this.f21772a, this.f21775d);
                HiLog.m28809i("RecordTask", "record evt size: " + eventSize2 + ", tag: " + this.f21772a + ", type: " + this.f21775d);
                if (iStoragePolicyM28845d.decide(IStoragePolicy.PolicyType.STORAGE_SIZE, this.f21775d, eventSize2)) {
                    c4758eM28833a.f21762b.put(this.f21775d, Long.valueOf(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(C4755b.m28837a(this.f21772a, this.f21775d)) || !iStoragePolicyM28845d.decide(IStoragePolicy.PolicyType.NETWORK, this.f21775d)) {
                        HiLog.m28812w("RecordTask", "network is invalid or collectUrl is empty, tag: " + this.f21772a + ", type: " + this.f21775d);
                        return;
                    }
                    HiLog.m28809i("RecordTask", "begin to auto report! tag: " + this.f21772a + ", type: " + this.f21775d);
                    TaskThread.getReportThread().addToQueue(new ReportTask(this.f21772a, this.f21775d, "", this.f21780i, this.f21781j));
                    if (jLongValue2 != 30000 && (eventListener2 = HAEventManager.getInstance().getEventListener()) != null) {
                        eventListener2.onEvent(this.f21772a, "$retry_list", "");
                    }
                    IHAEventListener eventListener3 = HAEventManager.getInstance().getEventListener();
                    if (eventListener3 != null) {
                        eventListener3.onReport(this.f21772a);
                    }
                    if (TextUtils.equals("HmsProfiler", this.f21772a) && (eventListener = HAEventManager.getInstance().getEventListener()) != null) {
                        eventListener.reportAppEvent();
                    }
                    IHAEventListener eventListener4 = HAEventManager.getInstance().getEventListener();
                    if (eventListener4 == null) {
                        return;
                    }
                    eventListener4.metricReport(this.f21772a);
                    return;
                }
                return;
            }
            HiLog.m28808e("RecordTask", "cache failed, tag: " + this.f21772a + ", type: " + this.f21775d);
            iStorageHandlerM28844c.deleteByTag(this.f21772a);
        }
        C4755b.m28838a(this.f21783l, iStorageHandlerM28844c, event);
    }
}
