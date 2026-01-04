package com.huawei.hms.videokit.player;

import android.os.RemoteException;
import com.huawei.hms.videokit.player.internal.InterfaceC6569d;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.videokit.player.f */
/* loaded from: classes8.dex */
public class C6556f {

    /* renamed from: c */
    private static volatile C6556f f30455c;

    /* renamed from: a */
    InterfaceC6569d f30456a = null;

    /* renamed from: b */
    Map<String, Long> f30457b = new HashMap(44);

    private C6556f() {
    }

    /* renamed from: a */
    public static C6556f m37359a() {
        if (f30455c == null) {
            synchronized (C6556f.class) {
                try {
                    if (f30455c == null) {
                        f30455c = new C6556f();
                    }
                } finally {
                }
            }
        }
        return f30455c;
    }

    /* renamed from: b */
    private void m37360b(String str, long j10, int i10, String str2) {
        long jM37688f = C6600t0.m37688f() - j10;
        Long l10 = this.f30457b.get(str);
        if (l10 == null || j10 - l10.longValue() > 300000) {
            this.f30457b.put(str, Long.valueOf(j10));
            try {
                OperationData operationData = new OperationData();
                operationData.setApiName(str);
                operationData.setResult(i10);
                operationData.setCallTime(j10);
                operationData.setCostTime(jM37688f);
                operationData.setUuid(str2);
                this.f30456a.mo37408a(operationData);
            } catch (RemoteException e10) {
                C6550c1.m37258a("OMReportManager", "reportOpData:", e10);
            }
        }
    }

    /* renamed from: a */
    public void m37361a(long j10, int i10) {
        if (this.f30456a == null) {
            C6550c1.m37256a("OMReportManager", "reportOpData omReporter is null");
            return;
        }
        m37360b("Preloader#" + Thread.currentThread().getStackTrace()[3].getMethodName(), j10, i10, null);
    }

    /* renamed from: a */
    public void m37362a(long j10, int i10, String str) {
        if (this.f30456a == null) {
            C6550c1.m37256a("OMReportManager", "reportPlayerOpData omReporter is null");
            return;
        }
        m37360b("WisePlayer#" + Thread.currentThread().getStackTrace()[3].getMethodName(), j10, i10, str);
    }

    /* renamed from: a */
    public void m37363a(InterfaceC6569d interfaceC6569d) {
        this.f30456a = interfaceC6569d;
    }

    /* renamed from: a */
    public void m37364a(String str, long j10, int i10, String str2) {
        if (this.f30456a == null) {
            C6550c1.m37256a("OMReportManager", "reportOpData omReporter is null");
            return;
        }
        m37360b("WisePlayerFactory#" + str, j10, i10, str2);
    }
}
