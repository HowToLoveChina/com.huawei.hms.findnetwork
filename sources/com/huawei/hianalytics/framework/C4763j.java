package com.huawei.hianalytics.framework;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.C4763j;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.listener.HAEventManager;
import com.huawei.hianalytics.framework.listener.IHAEventListener;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import gu.C10048b;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.huawei.hianalytics.framework.j */
/* loaded from: classes5.dex */
public class C4763j {

    /* renamed from: a */
    public final byte[] f21793a;

    /* renamed from: b */
    public final String f21794b;

    /* renamed from: c */
    public final String f21795c;

    /* renamed from: d */
    public final String f21796d;

    /* renamed from: e */
    public final List<Event> f21797e;

    /* renamed from: f */
    public ICallback f21798f;

    /* renamed from: g */
    public boolean f21799g;

    public C4763j(byte[] bArr, String str, String str2, String str3, List<Event> list) {
        this.f21793a = (byte[]) bArr.clone();
        this.f21794b = str;
        this.f21795c = str3;
        this.f21796d = str2;
        this.f21797e = list;
    }

    /* renamed from: a */
    public static /* synthetic */ int m28862a(Event event, Event event2) {
        return event2.getContent().length() - event.getContent().length();
    }

    /* renamed from: a */
    public final void m28863a() {
        int iMin;
        IHAEventListener eventListener = HAEventManager.getInstance().getEventListener();
        if (eventListener != null && (iMin = Math.min(5, this.f21797e.size())) > 0) {
            Collections.sort(this.f21797e, new Comparator() { // from class: qj.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C4763j.m28862a((Event) obj, (Event) obj2);
                }
            });
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < iMin; i10++) {
                sb2.append(this.f21797e.get(i10).getEvtid());
                sb2.append(",");
            }
            eventListener.onEvent(this.f21794b, "$discard_list", sb2.substring(0, sb2.length() - 1));
        }
    }

    /* renamed from: a */
    public final void m28866a(IStorageHandler iStorageHandler, Event event, int i10) {
        IStoragePolicy iStoragePolicyM28845d = C4755b.m28845d(this.f21794b);
        if (iStoragePolicyM28845d == null) {
            HiLog.m28808e("SendTask", "storage policy is null. tag: " + this.f21794b + ", type: " + this.f21796d);
            return;
        }
        if (iStoragePolicyM28845d.decide(IStoragePolicy.PolicyType.STORAGE_LENGTH, this.f21796d)) {
            HiLog.m28808e("SendTask", "db file reach max size, tag: " + this.f21794b + ", type: " + this.f21796d);
            iStorageHandler.deleteAll();
            C4755b.m28840a(Boolean.FALSE, this.f21798f, iStorageHandler, event, i10);
            return;
        }
        long eventSize = iStorageHandler.readEventSize(this.f21794b);
        if (eventSize == 0) {
            C4755b.m28840a(Boolean.FALSE, this.f21798f, iStorageHandler, event, i10);
            return;
        }
        if (eventSize <= 5000) {
            C4755b.m28840a(Boolean.FALSE, this.f21798f, iStorageHandler, event, i10);
            return;
        }
        HiLog.m28808e("SendTask", "evt size reach max size, tag: " + this.f21794b + ", TYPE: " + this.f21796d);
        iStorageHandler.deleteByTag(this.f21794b);
        C4755b.m28840a(Boolean.FALSE, this.f21798f, iStorageHandler, event, i10);
    }

    /* renamed from: a */
    public final void m28865a(IStorageHandler iStorageHandler) {
        IMandatoryParameters iMandatoryParameters = C4757d.f21744e.f21745a;
        if (iMandatoryParameters.isFlashKey() && iStorageHandler.readEventsAllSize() == 0) {
            iMandatoryParameters.refreshKey(C10048b.m62473e(16), 1);
            iStorageHandler.deleteCommonHeaderExAll();
        }
    }

    /* renamed from: a */
    public final void m28864a(int i10) {
        List<Event> list;
        if ((i10 == 400 || i10 == 413) && (list = this.f21797e) != null && list.size() > 0) {
            if (this.f21797e.size() > 100 && !"ha_default_collection".equals(this.f21794b)) {
                C4758e c4758eM28833a = C4755b.m28833a(this.f21794b);
                String str = this.f21796d;
                c4758eM28833a.f21765e.put(str + "_send_retry_flag", 100);
                return;
            }
            IStorageHandler iStorageHandlerM28844c = C4755b.m28844c(this.f21794b);
            if (iStorageHandlerM28844c != null) {
                HiLog.m28809i("SendTask", "storageHandler delete bad request events, tag: " + this.f21794b + ", type: " + this.f21796d);
                iStorageHandlerM28844c.deleteEvents(this.f21797e);
                m28865a(iStorageHandlerM28844c);
            }
            m28863a();
        }
    }
}
