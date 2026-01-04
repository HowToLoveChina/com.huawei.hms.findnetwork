package p009a8;

import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.android.util.JlogEx;
import com.huawei.hicloud.bean.CPUOffloadSleepDuration;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import java.util.Random;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p292fn.C9733f;
import p371ik.C10527a;
import p487n7.C11652a;
import p529op.C11979a;
import p529op.C11984f;

/* renamed from: a8.f */
/* loaded from: classes2.dex */
public class C0068f {

    /* renamed from: a */
    public b f221a;

    /* renamed from: b */
    public c f222b;

    /* renamed from: c */
    public volatile int f223c;

    /* renamed from: d */
    public volatile boolean f224d;

    /* renamed from: e */
    public long f225e;

    /* renamed from: f */
    public boolean f226f;

    /* renamed from: g */
    public boolean f227g;

    /* renamed from: h */
    public volatile String f228h;

    /* renamed from: a8.f$b */
    public class b implements C11979a.c {
        public b() {
        }

        @Override // p529op.C11979a.c
        /* renamed from: a */
        public void mo471a(int i10, int i11) {
            if (i11 == 16) {
                C1120a.m6677i("PhotoLoadReductionManager", "onThermalCallback cpuLevel " + i10);
                C0068f.this.f223c = i10;
            }
        }

        public /* synthetic */ b(C0068f c0068f, a aVar) {
            this();
        }
    }

    /* renamed from: a8.f$c */
    public class c implements C11984f.d {
        public c() {
        }

        @Override // p529op.C11984f.d
        public void onScreenOff() {
            C1120a.m6677i("PhotoLoadReductionManager", "AlbumScreenListener:screen is off");
            C0068f.this.f224d = false;
        }

        @Override // p529op.C11984f.d
        public void onScreenOn() {
            C1120a.m6677i("PhotoLoadReductionManager", "AlbumScreenListener:screen is on");
            C0068f.this.f224d = true;
        }

        @Override // p529op.C11984f.d
        public void onUserPresent() {
        }

        public /* synthetic */ c(C0068f c0068f, a aVar) {
            this();
        }
    }

    /* renamed from: a8.f$d */
    public static class d {

        /* renamed from: a */
        public static final C0068f f231a = new C0068f();
    }

    public /* synthetic */ C0068f(a aVar) {
        this();
    }

    /* renamed from: d */
    public static C0068f m459d() {
        return d.f231a;
    }

    /* renamed from: c */
    public final long m460c() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C1120a.m6677i("PhotoLoadReductionManager", "hiCloudSysParamMap is null,return default sleep duration:200ms");
            return 200L;
        }
        String cpuOffloadSleepDuration = hiCloudSysParamMapM60757p.getCpuOffloadSleepDuration();
        CPUOffloadSleepDuration cPUOffloadSleepDuration = (CPUOffloadSleepDuration) C10527a.m64629g(cpuOffloadSleepDuration, CPUOffloadSleepDuration.class);
        long photo = cPUOffloadSleepDuration != null ? cPUOffloadSleepDuration.getPhoto() : 200L;
        C1120a.m6677i("PhotoLoadReductionManager", "cpuOffloadSleepDuration config is:" + cpuOffloadSleepDuration + ",photo sleepDuration is:" + photo + "ms");
        return photo;
    }

    /* renamed from: e */
    public final boolean m461e() {
        boolean z10 = !this.f227g;
        boolean z11 = !this.f226f;
        boolean z12 = this.f225e <= 0;
        boolean z13 = !C0070h.m527v().m542O();
        boolean zM69581f = C11652a.m69579e().m69581f();
        boolean z14 = !this.f224d && this.f223c < 1;
        m465i("notHarmonyFour:" + z10 + ", notFeatureOpen:" + z11 + ", notValidSleepTime:" + z12 + ", isGalleryForeground:" + z13 + ", isCloudForeground:" + zM69581f + ", isCpuFree:" + z14 + ", sleepTime:" + this.f225e + ", isScreenOn:" + this.f224d + ", cpuLevel:" + this.f223c);
        return z10 || z11 || z12 || z13 || zM69581f || z14;
    }

    /* renamed from: f */
    public void m462f() {
        this.f227g = m464h();
        this.f225e = m460c();
        this.f226f = m463g();
        this.f223c = C11979a.m72102l().m72104i();
        this.f224d = C0209d.m1194N1(C0213f.m1377a());
        C1120a.m6677i("PhotoLoadReductionManager", "isHarmonyOSFour " + this.f227g + ", sleepTime " + this.f225e + ", isCpuReductionOpen " + this.f226f + ", cpuLevel " + this.f223c + ", isScreenOn " + this.f224d);
    }

    /* renamed from: g */
    public final boolean m463g() {
        return C9733f.m60705z().m60720O("enableCPULoadReduction") || (C9733f.m60705z().m60720O("enableCPULoadReductionForBeta") && C0209d.m1193N0());
    }

    /* renamed from: h */
    public final boolean m464h() {
        return C0209d.m1253f1();
    }

    /* renamed from: i */
    public final void m465i(String str) {
        if (str.equals(this.f228h)) {
            return;
        }
        this.f228h = str;
        C1120a.m6677i("PhotoLoadReductionManager", this.f228h);
        new CommonOpsReport(C0213f.m1377a()).m15209C(C1122c.m6755Z0("04022"), "photoLoadReduction", 0, this.f228h);
    }

    /* renamed from: j */
    public void m466j() {
        if (this.f227g) {
            try {
                String str = "#P:com.huawei.hidisk#SD:" + (!C0070h.m527v().m542O() ? 101 : 0) + "#FRT:" + System.currentTimeMillis();
                JlogEx.d(570, str);
                C1120a.m6677i("PhotoLoadReductionManager", "refreshSceneNum 570 " + str);
            } catch (Exception e10) {
                C1120a.m6676e("PhotoLoadReductionManager", "refreshSceneNum error " + e10);
            }
        }
    }

    /* renamed from: k */
    public void m467k() {
        if (this.f221a == null) {
            this.f221a = new b();
            C11979a.m72102l().m72108n(2, 2, this.f221a);
            C1120a.m6677i("PhotoLoadReductionManager", "registerThermalCallback");
        }
        if (this.f222b == null) {
            this.f222b = new c();
            C11984f.m72128c().m72129b(this.f222b);
            C1120a.m6677i("PhotoLoadReductionManager", "registerAlbumScreenListener");
        }
    }

    /* renamed from: l */
    public void m468l() {
        if (m461e()) {
            return;
        }
        long jNextInt = new Random().nextInt(100) + this.f225e;
        C1120a.m6677i("PhotoLoadReductionManager", "tryToSleep randomSleepTime " + jNextInt);
        try {
            Thread.sleep(jNextInt);
        } catch (Exception e10) {
            C1120a.m6676e("PhotoLoadReductionManager", "tryToSleep exception: " + e10);
        }
    }

    /* renamed from: m */
    public void m469m(long j10) throws InterruptedException {
        if (m461e()) {
            return;
        }
        C1120a.m6677i("PhotoLoadReductionManager", "tryToSleep sleepTimeInFact " + j10);
        long jMin = Math.min(j10, 10000L);
        try {
            long j11 = jMin / 1000;
            long j12 = jMin % 1000;
            for (int i10 = 0; i10 < j11; i10++) {
                if (m461e()) {
                    C1120a.m6677i("PhotoLoadReductionManager", "ignoreSleep");
                    return;
                }
                Thread.sleep(1000L);
            }
            if (j12 != 0) {
                Thread.sleep(j12);
            }
        } catch (Exception e10) {
            C1120a.m6676e("PhotoLoadReductionManager", "tryToSleep exception: " + e10);
        }
    }

    /* renamed from: n */
    public void m470n() {
        if (this.f221a != null) {
            C11979a.m72102l().m72111q(2);
            this.f221a = null;
            C1120a.m6677i("PhotoLoadReductionManager", "unRegisterThermalCallback");
        }
        if (this.f222b != null) {
            C11984f.m72128c().m72131e(this.f222b);
            this.f222b = null;
            C1120a.m6677i("PhotoLoadReductionManager", "unregisterAlbumScreenListener");
        }
    }

    public C0068f() {
        this.f221a = null;
        this.f222b = null;
        this.f223c = -1;
        this.f224d = false;
        this.f225e = 0L;
        this.f226f = false;
        this.f227g = false;
        this.f228h = "";
    }
}
