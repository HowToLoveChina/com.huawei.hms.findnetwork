package com.huawei.hms.videokit.player;

import android.util.Log;

/* renamed from: com.huawei.hms.videokit.player.v0 */
/* loaded from: classes8.dex */
final class C6604v0 implements InterfaceC6612z0 {

    /* renamed from: a */
    private static final InterfaceC6612z0 f30692a = new C6604v0();

    private C6604v0() {
    }

    /* renamed from: b */
    public static InterfaceC6612z0 m37698b() {
        return f30692a;
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: a */
    public void mo37200a() {
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: c */
    public void mo37204c(String str, Object obj) {
        Log.println(3, str, String.valueOf(obj));
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: d */
    public void mo37205d(String str, Object obj) {
        Log.println(5, str, String.valueOf(obj));
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: a */
    public void mo37201a(String str, Object obj) {
        Log.println(6, str, String.valueOf(obj));
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: b */
    public void mo37203b(String str, Object obj) {
        Log.println(4, str, String.valueOf(obj));
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6612z0
    /* renamed from: a */
    public void mo37202a(String str, Object obj, Throwable th2) {
        Log.println(6, str, C6606w0.m37720a(obj, th2));
    }
}
