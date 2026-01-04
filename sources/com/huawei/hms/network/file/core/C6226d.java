package com.huawei.hms.network.file.core;

import com.huawei.hms.network.file.api.Callback;
import com.huawei.hms.network.file.api.GlobalRequestConfig;
import com.huawei.hms.network.file.api.IRequestManager;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.Result;
import com.huawei.hms.network.file.core.Constants;
import com.huawei.hms.network.file.core.task.C6238i;
import com.huawei.hms.network.file.core.task.InterfaceC6232c;
import com.huawei.hms.network.file.core.task.InterfaceC6234e;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.network.file.core.d */
/* loaded from: classes8.dex */
public class C6226d<R extends Request> implements IRequestManager<R> {

    /* renamed from: b */
    Set<Long> f29393b;

    /* renamed from: c */
    InterfaceC6232c f29394c;

    /* renamed from: e */
    C6228f f29396e;

    /* renamed from: f */
    GlobalRequestConfig f29397f;

    /* renamed from: g */
    volatile boolean f29398g;

    /* renamed from: h */
    volatile boolean f29399h;

    /* renamed from: a */
    final ConcurrentHashMap<Long, C6238i> f29392a = new ConcurrentHashMap<>();

    /* renamed from: d */
    Result f29395d = Result.RESULT_SUCCESS;

    public C6226d(GlobalRequestConfig globalRequestConfig) {
        this.f29396e = new C6228f(globalRequestConfig);
        this.f29397f = globalRequestConfig;
        FLogger.m36353i("RequestManagerCore", "RequestManagerCore fileManager version:8.0.1.305", new Object[0]);
    }

    /* renamed from: b */
    public /* synthetic */ void m36202b() {
        FLogger.m36353i("RequestManagerCore", "start getCachedRequestID async", new Object[0]);
        Set<Long> setMo35993a = this.f29394c.mo35993a(100);
        if (!Utils.isEmpty(setMo35993a)) {
            Iterator<Long> it = setMo35993a.iterator();
            while (it.hasNext()) {
                m36201a(it.next());
            }
        }
        this.f29398g = true;
        if (this.f29393b.size() < 100) {
            this.f29399h = true;
        }
        FLogger.m36353i("RequestManagerCore", "get db data success for count:" + this.f29393b.size() + "/100; isGetCacheComplete:" + this.f29399h, new Object[0]);
    }

    /* renamed from: c */
    private Constants.ErrorCode m36204c(long j10) {
        return !this.f29392a.containsKey(Long.valueOf(j10)) ? Constants.ErrorCode.REQUEST_NO_EXIST : this.f29392a.get(Long.valueOf(j10)).m36298d() != InterfaceC6234e.a.PROCESS ? Constants.ErrorCode.REQUEST_STATUS_ERROR : Constants.ErrorCode.SUCCESS;
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public synchronized Result cancelRequest(long j10) {
        Result result = this.f29395d;
        if (this.f29392a.containsKey(Long.valueOf(j10))) {
            Result resultM36280a = this.f29392a.get(Long.valueOf(j10)).m36280a();
            if (resultM36280a.getCode() == Result.SUCCESS) {
                this.f29392a.remove(Long.valueOf(j10));
            }
            return resultM36280a;
        }
        if (m36203b(j10)) {
            this.f29394c.mo35994a(j10);
            return result;
        }
        return new Result(Constants.ErrorCode.REQUEST_NO_EXIST);
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public synchronized Result closeThreadPools() {
        this.f29396e.m36219e();
        return this.f29395d;
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public synchronized Result destoryRequests() {
        try {
            List<R> listMo35992a = this.f29394c.mo35992a(false);
            if (!Utils.isEmpty(listMo35992a)) {
                Iterator<R> it = listMo35992a.iterator();
                while (it.hasNext()) {
                    cancelRequest(it.next().getId());
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f29395d;
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public synchronized List<R> getAllRequests() {
        List<R> listMo35992a = this.f29394c.mo35992a(true);
        if (listMo35992a != null && listMo35992a.size() > 0) {
            return listMo35992a;
        }
        Collection<C6238i> collectionValues = this.f29392a.values();
        if (collectionValues.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C6238i> it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m36297c());
        }
        return arrayList;
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public synchronized R getRequest(long j10) {
        if (this.f29392a.containsKey(Long.valueOf(j10))) {
            return (R) this.f29392a.get(Long.valueOf(j10)).m36297c();
        }
        C6227e<R> c6227eMo36008c = this.f29394c.mo36008c(j10);
        if (c6227eMo36008c == null) {
            return null;
        }
        return (R) c6227eMo36008c.m36210a();
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public synchronized Result.STATUS getRequestStatus(long j10) {
        if (this.f29392a.containsKey(Long.valueOf(j10))) {
            return Utils.getMapedStatus(this.f29392a.get(Long.valueOf(j10)).m36298d());
        }
        C6227e<R> c6227eMo36008c = this.f29394c.mo36008c(j10);
        if (c6227eMo36008c == null) {
            return Result.STATUS.INVALID;
        }
        if (c6227eMo36008c.m36211b() == InterfaceC6234e.a.PROCESS.ordinal()) {
            return Result.STATUS.PAUSE;
        }
        return Utils.getMapedStatus(InterfaceC6234e.a.values()[c6227eMo36008c.m36211b()]);
    }

    @Override // com.huawei.hms.network.file.api.IRequestManager
    public synchronized Result start(R r10, Callback callback) {
        if (r10 == null) {
            return new Result(Constants.ErrorCode.REQUEST_NULL);
        }
        if (!this.f29392a.containsKey(Long.valueOf(r10.getId())) && !m36203b(r10.getId())) {
            C6238i c6238i = new C6238i(r10, this.f29394c, callback, this, this.f29396e);
            Result resultM36305k = c6238i.m36305k();
            if (resultM36305k.getCode() == Constants.ErrorCode.SUCCESS.getErrorCode()) {
                this.f29392a.put(Long.valueOf(r10.getId()), c6238i);
                m36201a(Long.valueOf(r10.getId()));
            }
            return resultM36305k;
        }
        FLogger.m36353i("RequestManagerCore", "start will resume the request in DB:" + r10.getId(), new Object[0]);
        return m36207a(r10, callback);
    }

    /* renamed from: b */
    private boolean m36203b(long j10) {
        if (this.f29398g && this.f29393b.contains(Long.valueOf(j10))) {
            return true;
        }
        if (this.f29399h) {
            return false;
        }
        FLogger.m36353i("RequestManagerCore", "isIdExistInCache get request in db", new Object[0]);
        return this.f29394c.mo36008c(j10) != null;
    }

    /* renamed from: a */
    public GlobalRequestConfig m36205a() {
        return this.f29397f;
    }

    /* renamed from: a */
    public synchronized Result m36206a(long j10) {
        Constants.ErrorCode errorCodeM36204c = m36204c(j10);
        if (errorCodeM36204c != Constants.ErrorCode.SUCCESS) {
            return new Result(errorCodeM36204c);
        }
        return this.f29392a.get(Long.valueOf(j10)).m36303i();
    }

    /* renamed from: a */
    public synchronized Result m36207a(R r10, Callback callback) {
        boolean z10;
        C6238i c6238i;
        if (r10 == null) {
            return new Result(Constants.ErrorCode.REQUEST_NULL);
        }
        long id2 = r10.getId();
        if (this.f29392a.containsKey(Long.valueOf(id2))) {
            c6238i = this.f29392a.get(Long.valueOf(id2));
            if (c6238i.m36298d() != InterfaceC6234e.a.PAUSE) {
                return new Result(Constants.ErrorCode.REQUEST_STATUS_ERROR);
            }
            z10 = false;
        } else {
            if (!m36203b(id2)) {
                return new Result(Constants.ErrorCode.REQUEST_NO_EXIST);
            }
            C6227e<R> c6227eMo36008c = this.f29394c.mo36008c(id2);
            if (c6227eMo36008c == null) {
                return new Result(Constants.ErrorCode.REQUEST_NO_EXIST);
            }
            m36201a(Long.valueOf(r10.getId()));
            if (c6227eMo36008c.m36211b() > InterfaceC6234e.a.PAUSE.ordinal()) {
                return new Result(Constants.ErrorCode.REQUEST_STATUS_ERROR);
            }
            C6238i c6238i2 = new C6238i(r10, this.f29394c, callback, this, this.f29396e);
            this.f29392a.put(Long.valueOf(r10.getId()), c6238i2);
            z10 = true;
            c6238i = c6238i2;
        }
        c6238i.m36281a((C6238i) r10, callback, z10);
        return this.f29395d;
    }

    /* renamed from: a */
    public synchronized void m36208a(Request request) {
        if (request != null) {
            if (this.f29392a.containsKey(Long.valueOf(request.getId()))) {
                this.f29392a.remove(Long.valueOf(request.getId()));
            }
        }
    }

    /* renamed from: a */
    public void m36209a(InterfaceC6232c interfaceC6232c) {
        this.f29394c = interfaceC6232c;
        this.f29393b = Collections.synchronizedSet(new HashSet());
        if (interfaceC6232c != null) {
            C6228f.m36213f().execute(new Runnable() { // from class: com.huawei.hms.network.file.core.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29409a.m36202b();
                }
            });
        }
    }

    /* renamed from: a */
    private void m36201a(Long l10) {
        this.f29393b.add(l10);
    }
}
