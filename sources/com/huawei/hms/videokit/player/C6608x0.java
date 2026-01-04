package com.huawei.hms.videokit.player;

import java.io.File;

/* renamed from: com.huawei.hms.videokit.player.x0 */
/* loaded from: classes8.dex */
final class C6608x0 implements InterfaceC6612z0 {

    /* renamed from: c */
    private static final C6608x0 f30708c = new C6608x0();

    /* renamed from: d */
    private static final InterfaceC6612z0 f30709d = C6604v0.m37698b();

    /* renamed from: a */
    private InterfaceC6612z0 f30710a = C6610y0.m37728b();

    /* renamed from: b */
    private String f30711b = null;

    private C6608x0() {
    }

    /* renamed from: a */
    public static C6608x0 m37722a(String str, int i10, int i11) {
        if (C6600t0.m37683c(str)) {
            return f30708c;
        }
        C6608x0 c6608x0 = f30708c;
        if (!C6600t0.m37683c(c6608x0.f30711b) && c6608x0.f30711b.compareTo(str) == 0 && new File(c6608x0.f30711b).exists()) {
            return c6608x0;
        }
        try {
            c6608x0.f30710a.mo37200a();
            c6608x0.f30710a = new C6542a1(str, i10, i11);
            c6608x0.f30711b = str;
            return c6608x0;
        } catch (IllegalArgumentException unused) {
            C6608x0 c6608x02 = f30708c;
            c6608x02.f30710a = C6610y0.m37728b();
            c6608x02.f30711b = null;
            return c6608x02;
        }
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: b */
    public void mo37203b(String str, Object obj) {
        f30709d.mo37203b(str, String.valueOf(obj));
        this.f30710a.mo37203b(str, String.valueOf(obj));
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: c */
    public void mo37204c(String str, Object obj) {
        f30709d.mo37204c(str, String.valueOf(obj));
        this.f30710a.mo37204c(str, String.valueOf(obj));
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: d */
    public void mo37205d(String str, Object obj) {
        f30709d.mo37205d(str, String.valueOf(obj));
        this.f30710a.mo37205d(str, String.valueOf(obj));
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: a */
    public void mo37200a() {
        this.f30710a.mo37200a();
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: a */
    public void mo37201a(String str, Object obj) {
        f30709d.mo37201a(str, String.valueOf(obj));
        this.f30710a.mo37201a(str, String.valueOf(obj));
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: a */
    public void mo37202a(String str, Object obj, Throwable th2) {
        f30709d.mo37201a(str, C6606w0.m37720a(obj, th2));
        this.f30710a.mo37201a(str, C6606w0.m37720a(obj, th2));
    }
}
