package com.huawei.hianalytics.framework;

import android.text.TextUtils;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.core.transport.Utils;
import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import gu.C10048b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hianalytics.framework.i */
/* loaded from: classes5.dex */
public class C4762i {

    /* renamed from: a */
    public final String f21784a;

    /* renamed from: b */
    public final String f21785b;

    /* renamed from: c */
    public final List<Event> f21786c;

    /* renamed from: d */
    public final ICollectorConfig f21787d;

    /* renamed from: e */
    public final ICallback f21788e;

    /* renamed from: f */
    public boolean f21789f;

    /* renamed from: g */
    public final String f21790g;

    /* renamed from: h */
    public final int f21791h;

    /* renamed from: i */
    public final int f21792i;

    public C4762i(String str, String str2, List<Event> list, ICallback iCallback, String str3, int i10, int i11) {
        this.f21784a = str;
        this.f21785b = str2;
        this.f21786c = list;
        this.f21788e = iCallback;
        this.f21790g = str3;
        this.f21787d = C4755b.m28843b(str);
        this.f21791h = i10;
        this.f21792i = i11;
    }

    /* renamed from: a */
    public void m28860a() {
        Event event;
        String evtExHashCode;
        List arrayList;
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < this.f21786c.size(); i10++) {
            if (TextUtils.isEmpty(this.f21786c.get(i10).getEvtExHashCode())) {
                event = this.f21786c.get(i10);
                evtExHashCode = "noExHashFlag";
                arrayList = (List) map.get("noExHashFlag");
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
            } else {
                event = this.f21786c.get(i10);
                evtExHashCode = this.f21786c.get(i10).getEvtExHashCode();
                arrayList = (List) map.get(evtExHashCode);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
            }
            arrayList.add(event);
            map.put(evtExHashCode, arrayList);
        }
        if (map.size() <= 0) {
            return;
        }
        IStoragePolicy iStoragePolicyM28845d = C4755b.m28845d(this.f21784a);
        Iterator it = map.entrySet().iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            if (!m28861a(iStoragePolicyM28845d, (List) ((Map.Entry) it.next()).getValue())) {
                z10 = false;
            }
        }
        if (this.f21789f) {
            return;
        }
        C4758e c4758eM28833a = C4755b.m28833a(this.f21784a);
        String str = this.f21785b;
        if (z10) {
            c4758eM28833a.m28855b(str);
        } else {
            c4758eM28833a.m28854a(str);
        }
    }

    /* renamed from: a */
    public final boolean m28861a(IStoragePolicy iStoragePolicy, List<Event> list) {
        IStorageHandler iStorageHandlerM28844c;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int decryptMaxBatchSize = iStoragePolicy.getDecryptMaxBatchSize(this.f21785b);
        boolean z10 = true;
        int subCount = 0;
        for (Event event : list) {
            if (iStoragePolicy.decide(IStoragePolicy.PolicyType.STORAGE_CYCLE, this.f21785b, Utils.parseStringToLong(event.getEvttime()))) {
                arrayList.add(event);
            } else {
                if (event.getSubCount() + subCount > decryptMaxBatchSize) {
                    if (m28859a(arrayList2, C10048b.m62473e(16), this.f21789f, subCount) == 0) {
                        z10 = false;
                    }
                    arrayList2 = new ArrayList();
                    subCount = 0;
                }
                arrayList2.add(event);
                subCount += event.getSubCount();
            }
        }
        boolean z11 = (arrayList2.size() <= 0 || m28859a(arrayList2, C10048b.m62473e(16), this.f21789f, subCount) != 0) ? z10 : false;
        if (z11 && !"ha_default_collection".equals(this.f21784a)) {
            C4758e c4758eM28833a = C4755b.m28833a(this.f21784a);
            String str = this.f21785b;
            c4758eM28833a.f21765e.remove(str + "_send_retry_flag");
        }
        if (arrayList.size() > 0 && (iStorageHandlerM28844c = C4755b.m28844c(this.f21784a)) != null) {
            iStorageHandlerM28844c.deleteEvents(arrayList);
        }
        return z11;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m28859a(java.util.List<com.huawei.hianalytics.core.storage.Event> r22, java.lang.String r23, boolean r24, int r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1156
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.framework.C4762i.m28859a(java.util.List, java.lang.String, boolean, int):int");
    }
}
