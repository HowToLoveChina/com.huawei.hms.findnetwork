package com.huawei.hianalytics;

import android.content.Context;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.storage.CommonHeaderEx;
import com.huawei.hianalytics.core.storage.DaoManager;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.huawei.hianalytics.n */
/* loaded from: classes5.dex */
public class C4794n implements IStorageHandler {

    /* renamed from: a */
    public static IStorageHandler f21882a;

    /* renamed from: a */
    public final C4792m f21883a;

    public C4794n(Context context) {
        this.f21883a = C4792m.m28963a(context);
    }

    /* renamed from: a */
    public static IStorageHandler m28969a(Context context) {
        if (f21882a == null) {
            synchronized (C4794n.class) {
                if (f21882a == null) {
                    f21882a = new C4794n(context);
                }
            }
        }
        return f21882a;
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public boolean checkAndClearTable() {
        this.f21883a.getClass();
        return DaoManager.getInstance().checkAndClearTable();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public void deleteAll() {
        C4792m c4792m = this.f21883a;
        c4792m.getClass();
        DaoManager.getInstance().deleteAllEvents();
        c4792m.m28965a("", "");
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public void deleteByTag(String str) {
        C4792m c4792m = this.f21883a;
        c4792m.getClass();
        DaoManager.getInstance().deleteEvents(str, "");
        c4792m.m28965a(str, "");
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public void deleteByTagType(String str, String str2) {
        C4792m c4792m = this.f21883a;
        c4792m.getClass();
        DaoManager.getInstance().deleteEvents(str, str2);
        c4792m.m28965a(str, str2);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public void deleteCommonHeaderExAll() {
        this.f21883a.getClass();
        DaoManager.getInstance().deleteAllHeaders();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public void deleteEvents(List<Event> list) {
        C4792m c4792m = this.f21883a;
        c4792m.getClass();
        if (list == null || list.isEmpty()) {
            return;
        }
        DaoManager.getInstance().deleteEvents(list);
        String servicetag = list.get(0).getServicetag();
        String evttype = list.get(0).getEvttype();
        long subCount = 0;
        while (list.iterator().hasNext()) {
            subCount -= r9.next().getSubCount();
        }
        AtomicLong atomicLongM28966b = c4792m.m28966b(servicetag, evttype);
        if (atomicLongM28966b == null) {
            c4792m.m28964a(servicetag, evttype);
        } else if (atomicLongM28966b.addAndGet(subCount) < 0) {
            c4792m.m28965a(servicetag, evttype);
        }
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public int deleteMcInfo(List<String> list) {
        this.f21883a.getClass();
        return DaoManager.getInstance().deleteMcInfo(list);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public int deleteMcTag(List<String> list) {
        this.f21883a.getClass();
        return DaoManager.getInstance().deleteMcTag(list);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public long insert(CommonHeaderEx commonHeaderEx) {
        this.f21883a.getClass();
        return DaoManager.getInstance().insert(commonHeaderEx);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public long insertMcInfo(String str) {
        this.f21883a.getClass();
        return DaoManager.getInstance().insertMcInfo(str);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public long insertMcTagList(List<String> list) {
        this.f21883a.getClass();
        return DaoManager.getInstance().insertMcTagList(list);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public List<String> queryMcInfo() {
        this.f21883a.getClass();
        return DaoManager.getInstance().queryMcInfo();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public List<String> queryMcTag(String str) {
        this.f21883a.getClass();
        return DaoManager.getInstance().queryMcTag(str);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public CommonHeaderEx readCommonHeaderEx(String str) {
        this.f21883a.getClass();
        return DaoManager.getInstance().readHeader(str);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public long readEventSize(String str) {
        C4792m c4792m = this.f21883a;
        AtomicLong atomicLongM28966b = c4792m.m28966b(str, "oper");
        long j10 = atomicLongM28966b != null ? atomicLongM28966b.get() : c4792m.m28964a(str, "oper").get();
        AtomicLong atomicLongM28966b2 = c4792m.m28966b(str, "maint");
        return j10 + (atomicLongM28966b2 != null ? atomicLongM28966b2.get() : c4792m.m28964a(str, "maint").get());
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public List<Event> readEvents(String str, String str2) {
        C4792m c4792m = this.f21883a;
        if (c4792m.f21875a == null) {
            c4792m.f21875a = C4785j.m28930b(EnvUtils.getAppContext());
        }
        return DaoManager.getInstance().readEvents(str, str2, c4792m.f21875a, -1L);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public long readEventsAllSize() {
        this.f21883a.getClass();
        return DaoManager.getInstance().countEvents();
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public List<Event> readOldEvents(String str, String str2) {
        C4792m c4792m = this.f21883a;
        if (c4792m.f21875a == null) {
            c4792m.f21875a = C4785j.m28930b(EnvUtils.getAppContext());
        }
        long jCurrentTimeMillis = C4782i.m28891a().m28893a().f21848b;
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        return DaoManager.getInstance().readEvents(str, str2, c4792m.f21875a, jCurrentTimeMillis);
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public long insert(Event event) {
        C4792m c4792m = this.f21883a;
        c4792m.getClass();
        long jInsert = DaoManager.getInstance().insert(event);
        if (jInsert > 0) {
            String servicetag = event.getServicetag();
            String evttype = event.getEvttype();
            long subCount = event.getSubCount();
            AtomicLong atomicLongM28966b = c4792m.m28966b(servicetag, evttype);
            if (atomicLongM28966b == null) {
                c4792m.m28964a(servicetag, evttype);
            } else if (atomicLongM28966b.addAndGet(subCount) < 0) {
                c4792m.m28965a(servicetag, evttype);
            }
        }
        return jInsert;
    }

    @Override // com.huawei.hianalytics.core.storage.IStorageHandler
    public long readEventSize(String str, String str2) {
        C4792m c4792m = this.f21883a;
        AtomicLong atomicLongM28966b = c4792m.m28966b(str, str2);
        return atomicLongM28966b != null ? atomicLongM28966b.get() : c4792m.m28964a(str, str2).get();
    }
}
