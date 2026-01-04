package com.huawei.hms.network.file.core.task;

import com.huawei.hms.network.file.api.Progress;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.core.FileManagerException;
import com.huawei.hms.network.file.core.task.AbstractC6240k;
import com.huawei.hms.network.file.core.task.InterfaceC6234e;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.hms.network.file.core.task.j */
/* loaded from: classes8.dex */
public class C6239j<R extends Request, T extends AbstractC6240k> implements InterfaceC6233d<R, T> {

    /* renamed from: e */
    InterfaceC6232c f29461e;

    /* renamed from: f */
    protected volatile long f29462f;

    /* renamed from: a */
    volatile InterfaceC6234e.a f29457a = InterfaceC6234e.a.INIT;

    /* renamed from: b */
    protected volatile long f29458b = 0;

    /* renamed from: c */
    protected volatile long f29459c = 0;

    /* renamed from: d */
    volatile long f29460d = 0;

    /* renamed from: g */
    volatile long f29463g = 0;

    /* renamed from: h */
    volatile long f29464h = 0;

    public C6239j(InterfaceC6232c interfaceC6232c) {
        this.f29461e = interfaceC6232c;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6233d
    /* renamed from: a */
    public long mo36230a() {
        FLogger.m36353i("RequestStatus", "currentTime:" + System.currentTimeMillis() + "; taskStartTime:" + this.f29460d + "; lastUsedTime:" + this.f29463g, new Object[0]);
        return this.f29460d > 0 ? (System.currentTimeMillis() - this.f29460d) + this.f29463g : this.f29463g;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6233d
    /* renamed from: b */
    public long mo36231b() {
        return this.f29460d > 0 ? (this.f29464h - this.f29460d) + this.f29463g : this.f29463g;
    }

    /* renamed from: c */
    public long m36311c(List<T> list) {
        long jMo36239c = 0;
        if (Utils.isEmpty(list)) {
            return 0L;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jMo36239c += it.next().mo36239c();
        }
        FLogger.m36350d("RequestStatus", "getCurrentSize:" + jMo36239c, new Object[0]);
        return jMo36239c;
    }

    /* renamed from: d */
    public void m36314d(R r10) {
        this.f29457a = InterfaceC6234e.a.PROCESS;
    }

    /* renamed from: e */
    public void m36315e(R r10) {
        this.f29457a = InterfaceC6234e.a.PROCESS;
    }

    /* renamed from: f */
    public void m36316f(R r10) {
        FLogger.m36353i("RequestStatus", "onSuccess:" + r10, new Object[0]);
        this.f29457a = InterfaceC6234e.a.INVALID;
        this.f29461e.mo35998a((InterfaceC6232c) r10, this.f29457a);
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6233d
    /* renamed from: a */
    public long mo36015a(List<T> list) {
        long jMo36232b = mo36232b(list);
        long jMo36230a = mo36230a();
        if (jMo36230a > 0) {
            return (long) ((jMo36232b / jMo36230a) * 1000.0d);
        }
        return 0L;
    }

    @Override // com.huawei.hms.network.file.core.task.InterfaceC6233d
    /* renamed from: b */
    public long mo36232b(List<T> list) {
        long jMo36239c = 0;
        if (!Utils.isEmpty(list)) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                jMo36239c += it.next().mo36239c();
            }
        }
        return jMo36239c;
    }

    /* renamed from: c */
    public InterfaceC6234e.a m36312c() {
        return this.f29457a;
    }

    /* renamed from: a */
    public Progress m36306a(R r10, String str, List<T> list) {
        long j10;
        long j11;
        if (Utils.isEmpty(list)) {
            return null;
        }
        long jMo36022a = 0;
        long jMo36239c = 0;
        for (T t10 : list) {
            jMo36239c += t10.mo36239c();
            jMo36022a += t10.mo36022a();
        }
        FLogger.m36354v("RequestStatus", "onProgress currentTotalFinished:" + jMo36239c + ",totalFileSize:" + jMo36022a);
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f29459c;
        if (jCurrentTimeMillis > 0) {
            j11 = (long) (((jMo36239c - this.f29458b) / jCurrentTimeMillis) * 1000.0d);
            j10 = 0;
        } else {
            j10 = 0;
            j11 = 0;
        }
        if (j11 < j10 || jCurrentTimeMillis == 0) {
            FLogger.m36355w("RequestStatus", "onProgress wait to notify -> timeSpan:" + jCurrentTimeMillis + ",lastReportSize:" + this.f29458b + ",currentTotalFinished:" + jMo36239c, new Object[0]);
            return null;
        }
        this.f29459c = System.currentTimeMillis();
        this.f29458b = jMo36239c;
        int i10 = (int) ((jMo36239c / jMo36022a) * 100.0d);
        if (i10 > 100) {
            FLogger.m36355w("RequestStatus", "onProgress for error percent, currentTotalFinished:" + jMo36239c + ",totalFileSize:" + jMo36022a, new Object[0]);
            i10 = 99;
        }
        return new Progress(r10, str, i10, jMo36022a, jMo36239c, j11);
    }

    /* renamed from: b */
    public void m36310b(R r10) {
        FLogger.m36353i("RequestStatus", "onCanceled:" + r10, new Object[0]);
        this.f29457a = InterfaceC6234e.a.CANCEL;
        this.f29461e.mo35998a((InterfaceC6232c) r10, this.f29457a);
    }

    /* renamed from: c */
    public void m36313c(R r10) {
        FLogger.m36353i("RequestStatus", "onPaused:" + r10, new Object[0]);
        this.f29463g += this.f29460d > 0 ? System.currentTimeMillis() - this.f29460d : 0L;
        this.f29460d = 0L;
        this.f29457a = InterfaceC6234e.a.PAUSE;
        this.f29461e.mo35998a((InterfaceC6232c) r10, this.f29457a);
    }

    /* renamed from: a */
    public void m36307a(long j10) {
        this.f29462f = j10;
    }

    /* renamed from: a */
    public void m36308a(R r10) {
        FLogger.m36353i("RequestStatus", "onAllTaskFinished:" + r10, new Object[0]);
        this.f29464h = System.currentTimeMillis();
    }

    /* renamed from: a */
    public void m36309a(R r10, FileManagerException fileManagerException) {
        FLogger.m36353i("RequestStatus", "onException:" + r10, new Object[0]);
        this.f29457a = InterfaceC6234e.a.INVALID;
    }

    /* renamed from: a */
    public void mo36016a(R r10, List<T> list) {
        FLogger.m36353i("RequestStatus", "onTaskStart:" + list, new Object[0]);
        if (this.f29460d <= 0) {
            this.f29460d = System.currentTimeMillis();
        }
        if (this.f29459c <= 0) {
            this.f29459c = System.currentTimeMillis();
        }
        this.f29457a = InterfaceC6234e.a.PROCESS;
        this.f29461e.mo35998a((InterfaceC6232c) r10, this.f29457a);
    }
}
