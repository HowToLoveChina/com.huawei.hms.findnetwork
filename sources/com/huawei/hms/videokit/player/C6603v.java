package com.huawei.hms.videokit.player;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.util.SafeString;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.huawei.hms.videokit.player.v */
/* loaded from: classes8.dex */
public class C6603v implements InterfaceC6594q {

    /* renamed from: a */
    private C6552d0 f30686a;

    /* renamed from: b */
    private C6555e0 f30687b;

    /* renamed from: c */
    private AtomicBoolean f30688c = new AtomicBoolean(true);

    /* renamed from: d */
    private String f30689d = "";

    /* renamed from: e */
    private int f30690e = 0;

    /* renamed from: f */
    private int f30691f = 0;

    public C6603v(Context context) {
        this.f30686a = new C6552d0(context);
        this.f30687b = new C6555e0(context);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37596a() {
        this.f30686a.m37330y();
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: b */
    public void mo37612b() {
        C6550c1.m37256a("HiAnalyticsDataControl", "setMatchAuthCache");
        this.f30686a.m37326u();
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: c */
    public void mo37617c() {
        this.f30686a.m37323q();
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: d */
    public void mo37621d() {
        C6550c1.m37256a("HiAnalyticsDataControl", "setMatchPreload");
        this.f30686a.m37327v();
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: e */
    public void mo37625e() {
        C6550c1.m37256a("HiAnalyticsDataControl", "resetPlayComplete");
        this.f30686a.m37288a(true, true);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: f */
    public void mo37629f(long j10) {
        this.f30686a.m37319l(j10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: g */
    public void mo37631g(long j10) {
        this.f30686a.m37304e(j10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: h */
    public void mo37632h(long j10) {
        this.f30686a.m37300d(j10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: i */
    public void mo37633i(long j10) {
        this.f30686a.m37320m(j10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: j */
    public void mo37634j(long j10) {
        C6550c1.m37256a("HiAnalyticsDataControl", "updateCdnStallingDuration");
        this.f30686a.m37315i(j10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: k */
    public void mo37635k(long j10) {
        this.f30686a.m37317j(j10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    public void setBufferingStatus(boolean z10) {
        C6550c1.m37264c("HiAnalyticsDataControl", "setBufferingStatus");
        this.f30686a.m37298c(z10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    public void setPlayUrl(String str) {
        if (str != null && str.contains(Constants.QUESTION_STR)) {
            str = SafeString.substring(str, 0, str.indexOf(Constants.QUESTION_STR));
        }
        this.f30686a.m37306e(str);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    public void setVideoType(int i10) {
        this.f30686a.m37314i(i10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37597a(int i10) {
        this.f30686a.m37280a(i10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: b */
    public void mo37613b(int i10) {
        C6550c1.m37256a("HiAnalyticsDataControl", "playScene:" + i10);
        this.f30686a.m37303e(i10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: c */
    public void mo37618c(int i10) {
        this.f30686a.m37310g(i10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: d */
    public void mo37622d(int i10) {
        this.f30686a.m37307f(i10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: e */
    public void mo37626e(int i10) {
        this.f30686a.m37299d(i10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: f */
    public void mo37630f(long j10, long j11) {
        C6550c1.m37256a("HiAnalyticsDataControl", "reportPlayComplete time:" + j10);
        this.f30686a.m37317j(j11);
        this.f30686a.m37291b(j10, j11);
        this.f30686a.m37281a(0, 0, 0, "");
        this.f30686a.m37283a(j11);
        this.f30686a.m37321o();
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37598a(int i10, int i11, String str) {
        this.f30690e = i10;
        this.f30691f = i11;
        this.f30689d = str;
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: b */
    public void mo37614b(long j10) {
        this.f30686a.m37295c(j10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: c */
    public void mo37619c(long j10) {
        this.f30686a.m37313h(j10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: d */
    public void mo37623d(long j10) {
        this.f30686a.m37311g(j10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: e */
    public void mo37627e(long j10) {
        this.f30686a.m37318k(j10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37599a(int i10, Object obj) {
        this.f30686a.m37282a(i10, obj);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: b */
    public void mo37615b(long j10, long j11) {
        if (!this.f30688c.get()) {
            C6550c1.m37264c("HiAnalyticsDataControl", "reportPlayStart isStartReport is false");
            return;
        }
        C6550c1.m37256a("HiAnalyticsDataControl", "reportPlayStart time:" + j10);
        this.f30686a.m37305e(j10, j11);
        this.f30686a.m37312h(0);
        this.f30686a.m37316j();
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: c */
    public void mo37620c(long j10, long j11) {
        C6550c1.m37256a("HiAnalyticsDataControl", "startBeginTime:" + j10);
        this.f30686a.m37301d(j10, j11);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: d */
    public void mo37624d(long j10, long j11) {
        this.f30687b.m37351c(j10);
        this.f30687b.m37349b(j11);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: e */
    public void mo37628e(long j10, long j11) {
        C6550c1.m37256a("HiAnalyticsDataControl", "prepareTime:" + j10);
        this.f30686a.m37296c(j10, j11);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37600a(int i10, String str) {
        this.f30686a.m37302d(C6588n.m37563a().m37564a((str == null || !str.contains(Constants.QUESTION_STR)) ? str : SafeString.substring(str, 0, str.indexOf(Constants.QUESTION_STR))));
        this.f30686a.m37306e(C6588n.m37563a().m37564a(str));
        this.f30686a.m37294c(i10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: b */
    public void mo37616b(String str) {
        this.f30686a.m37297c(str);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37601a(int i10, String str, String str2) {
        this.f30687b.m37355e("/playserver/vod/getPlayInfo");
        this.f30686a.m37294c(i10);
        this.f30686a.m37302d(str);
        this.f30686a.m37286a(str2);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37602a(long j10) {
        this.f30686a.m37308f(j10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37603a(long j10, long j11) {
        C6550c1.m37256a("HiAnalyticsDataControl", "accessTime:" + j11);
        this.f30686a.m37284a(j10, j11);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37604a(long j10, long j11, int i10, int i11, String str) {
        C6550c1.m37256a("HiAnalyticsDataControl", "reportPlayError time:" + j10);
        this.f30686a.m37324r();
        this.f30686a.m37317j(j11);
        this.f30686a.m37291b(j10, j11);
        this.f30686a.m37281a(1, i10, i11, str);
        this.f30686a.m37283a(j11);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37605a(long j10, long j11, String str, int i10, int i11) {
        this.f30687b.m37352c(str);
        this.f30687b.m37346a(i10);
        this.f30687b.m37353d(j10);
        this.f30687b.m37347a(j11);
        this.f30686a.m37290b(j11);
        if (i11 != 0) {
            this.f30687b.m37348a(String.valueOf(i11));
        }
        this.f30687b.m37357h();
        this.f30687b.m37358i();
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37606a(long j10, long j11, boolean z10, boolean z11) {
        C6550c1.m37264c("HiAnalyticsDataControl", "reportPlayRelease time:" + j10 + ",isPlayComplete:" + z10);
        this.f30688c.set(false);
        this.f30686a.m37324r();
        this.f30686a.m37317j(j11);
        this.f30686a.m37291b(j10, j11);
        if (!z10) {
            int i10 = this.f30690e;
            if (i10 != 0) {
                this.f30686a.m37281a(1, i10, this.f30691f, this.f30689d);
            } else {
                this.f30686a.m37281a(2, 0, 0, "");
            }
        }
        this.f30686a.m37283a(j11);
        this.f30686a.m37280a(4);
        this.f30686a.m37293b(z11);
        this.f30689d = "";
        this.f30690e = 0;
        this.f30691f = 0;
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37607a(long j10, boolean z10) {
        C6550c1.m37256a("HiAnalyticsDataControl", "addDownloadSpeed");
        this.f30686a.m37285a(j10, z10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37608a(String str) {
        this.f30686a.m37292b(str);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37609a(String str, long j10) {
        C6550c1.m37256a("HiAnalyticsDataControl", "addCDNInfo");
        this.f30686a.m37287a(str, j10);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37610a(String str, String str2, String str3) {
        this.f30687b.m37356f(str);
        this.f30686a.m37309f(str);
        this.f30687b.m37350b(str2);
        this.f30687b.m37354d(str3);
    }

    @Override // com.huawei.hms.videokit.player.InterfaceC6594q
    /* renamed from: a */
    public void mo37611a(boolean z10) {
        this.f30688c.set(z10);
    }
}
