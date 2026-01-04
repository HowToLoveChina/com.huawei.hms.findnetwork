package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.Scheme;
import com.huawei.openalliance.p169ad.constant.VideoPlayFlag;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7821dn;
import java.io.File;
import java.io.Serializable;

@OuterVisible
/* loaded from: classes2.dex */
public class VideoInfo implements Serializable {

    /* renamed from: a */
    private String f33672a;

    /* renamed from: b */
    private String f33673b;

    /* renamed from: c */
    private int f33674c;

    /* renamed from: d */
    private int f33675d;

    /* renamed from: e */
    private String f33676e;

    /* renamed from: f */
    private int f33677f;

    /* renamed from: g */
    private String f33678g;

    /* renamed from: h */
    private int f33679h;

    /* renamed from: i */
    private String f33680i;

    /* renamed from: j */
    private int f33681j;

    /* renamed from: k */
    private String f33682k;

    /* renamed from: l */
    private int f33683l;

    /* renamed from: m */
    private boolean f33684m;

    /* renamed from: n */
    private boolean f33685n;

    /* renamed from: o */
    private boolean f33686o;

    /* renamed from: p */
    private int f33687p;

    /* renamed from: q */
    private int f33688q;

    /* renamed from: r */
    private int f33689r;

    /* renamed from: s */
    private Float f33690s;

    /* renamed from: t */
    private boolean f33691t;

    /* renamed from: u */
    private boolean f33692u;

    /* renamed from: v */
    private float f33693v;

    /* renamed from: w */
    private int f33694w;

    /* renamed from: x */
    private String f33695x;

    /* renamed from: y */
    private int f33696y;

    /* renamed from: z */
    private String f33697z;

    @OuterVisible
    public VideoInfo() {
        this.f33676e = "y";
        this.f33678g = "n";
        this.f33679h = 200;
        this.f33681j = 0;
        this.f33682k = "n";
        this.f33683l = 1;
        this.f33685n = true;
        this.f33686o = false;
        this.f33687p = 100;
        this.f33688q = 90;
        this.f33689r = 0;
        this.f33691t = true;
        this.f33692u = false;
        this.f33694w = 0;
        this.f33695x = Boolean.FALSE.toString();
        this.f33696y = 0;
    }

    /* renamed from: a */
    public int m44559a() {
        return Constants.VIDEO_SIZE_UPPER_LIMIT;
    }

    /* renamed from: b */
    public int m44566b() {
        return this.f33681j;
    }

    /* renamed from: c */
    public void m44571c(int i10) {
        this.f33679h = i10;
    }

    /* renamed from: d */
    public float m44575d() {
        return this.f33693v;
    }

    /* renamed from: e */
    public void m44579e(int i10) {
        this.f33681j = i10;
    }

    /* renamed from: f */
    public void m44583f(int i10) {
        this.f33687p = i10;
    }

    /* renamed from: g */
    public String m44586g() {
        return this.f33673b;
    }

    @OuterVisible
    public int getAutoPlayAreaRatio() {
        return this.f33687p;
    }

    @OuterVisible
    public int getAutoPlayNetwork() {
        return this.f33677f;
    }

    @OuterVisible
    public int getAutoStopPlayAreaRatio() {
        return this.f33688q;
    }

    @OuterVisible
    public int getDownloadNetwork() {
        return this.f33689r;
    }

    @OuterVisible
    public String getSha256() {
        return this.f33680i;
    }

    @OuterVisible
    public String getSoundSwitch() {
        return this.f33682k;
    }

    @OuterVisible
    public int getTimeBeforeVideoAutoPlay() {
        AbstractC7185ho.m43821b("VideoInfo", "getTimeBeforeVideoAutoPlay, custom exposure type: %s", Integer.valueOf(this.f33694w));
        int i10 = this.f33694w;
        if (i10 == 2 || i10 == 1) {
            return 0;
        }
        return this.f33679h;
    }

    @OuterVisible
    public String getVideoAutoPlay() {
        return this.f33676e;
    }

    @OuterVisible
    public String getVideoAutoPlayWithSound() {
        return this.f33678g;
    }

    @OuterVisible
    public String getVideoDownloadUrl() {
        return this.f33672a;
    }

    @OuterVisible
    public int getVideoDuration() {
        return this.f33674c;
    }

    @OuterVisible
    public int getVideoFileSize() {
        return this.f33675d;
    }

    @OuterVisible
    public int getVideoPlayMode() {
        return this.f33683l;
    }

    @OuterVisible
    public Float getVideoRatio() {
        return this.f33690s;
    }

    /* renamed from: h */
    public int m44589h() {
        return this.f33694w;
    }

    /* renamed from: i */
    public String m44592i() {
        return this.f33695x;
    }

    @OuterVisible
    public boolean isBackFromFullScreen() {
        return this.f33686o;
    }

    @OuterVisible
    public boolean isCheckSha256() {
        return this.f33684m;
    }

    /* renamed from: j */
    public int m44594j() {
        return this.f33696y;
    }

    /* renamed from: k */
    public String m44596k() {
        return this.f33697z;
    }

    public VideoInfo(com.huawei.openalliance.p169ad.beans.metadata.VideoInfo videoInfo) {
        this.f33676e = "y";
        this.f33678g = "n";
        this.f33679h = 200;
        this.f33681j = 0;
        this.f33682k = "n";
        this.f33683l = 1;
        this.f33685n = true;
        this.f33686o = false;
        this.f33687p = 100;
        this.f33688q = 90;
        this.f33689r = 0;
        this.f33691t = true;
        this.f33692u = false;
        this.f33694w = 0;
        this.f33695x = Boolean.FALSE.toString();
        this.f33696y = 0;
        if (videoInfo != null) {
            this.f33672a = videoInfo.m40471a();
            this.f33673b = videoInfo.m40471a();
            this.f33674c = videoInfo.m40477b();
            this.f33675d = videoInfo.m40481c();
            if (TextUtils.equals(videoInfo.m40484d(), "y") || TextUtils.equals(videoInfo.m40484d(), VideoPlayFlag.PLAY_IN_ALL)) {
                this.f33676e = "y";
            } else {
                this.f33676e = "n";
            }
            this.f33678g = videoInfo.m40487e();
            this.f33679h = videoInfo.m40490f();
            this.f33680i = videoInfo.m40493g();
            this.f33683l = videoInfo.m40495h();
            this.f33682k = this.f33678g;
            this.f33684m = videoInfo.m40496i() == 0;
            if (videoInfo.m40497j() != null) {
                this.f33687p = videoInfo.m40497j().intValue();
            }
            if (videoInfo.m40498k() != null) {
                this.f33688q = videoInfo.m40498k().intValue();
            }
            m44590h(videoInfo.m40499l());
            if (TextUtils.equals(videoInfo.m40484d(), VideoPlayFlag.PLAY_IN_ALL)) {
                this.f33677f = 1;
            } else {
                this.f33677f = 0;
            }
            m44562a(videoInfo.m40500m());
            this.f33691t = "y".equalsIgnoreCase(videoInfo.m40501n());
            m44560a(videoInfo.m40502o());
        }
    }

    /* renamed from: a */
    public void m44560a(float f10) {
        if (f10 <= 0.0f) {
            f10 = 3.5f;
        }
        this.f33693v = f10;
    }

    /* renamed from: b */
    public void m44567b(int i10) {
        this.f33675d = i10;
    }

    /* renamed from: c */
    public void m44572c(String str) {
        this.f33678g = str;
    }

    /* renamed from: d */
    public void m44576d(int i10) {
        this.f33683l = i10;
    }

    /* renamed from: e */
    public void m44580e(String str) {
        this.f33682k = str;
    }

    /* renamed from: f */
    public void m44584f(String str) {
        this.f33673b = str;
    }

    /* renamed from: g */
    public void m44587g(int i10) {
        this.f33688q = i10;
    }

    /* renamed from: h */
    public void m44590h(int i10) {
        if (i10 == 1) {
            this.f33689r = 1;
        } else {
            this.f33689r = 0;
        }
    }

    /* renamed from: i */
    public void m44593i(int i10) {
        this.f33677f = i10;
    }

    /* renamed from: j */
    public void m44595j(int i10) {
        this.f33694w = i10;
    }

    /* renamed from: k */
    public void m44597k(int i10) {
        this.f33696y = i10;
    }

    public VideoInfo(PlacementMediaFile placementMediaFile) {
        this.f33676e = "y";
        this.f33678g = "n";
        this.f33679h = 200;
        this.f33681j = 0;
        this.f33682k = "n";
        this.f33683l = 1;
        this.f33685n = true;
        this.f33686o = false;
        this.f33687p = 100;
        this.f33688q = 90;
        this.f33689r = 0;
        this.f33691t = true;
        this.f33692u = false;
        this.f33694w = 0;
        this.f33695x = Boolean.FALSE.toString();
        this.f33696y = 0;
        if (placementMediaFile != null) {
            this.f33673b = placementMediaFile.getUrl();
            this.f33684m = placementMediaFile.getCheckSha256() == 0;
            this.f33680i = placementMediaFile.getSha256();
        }
    }

    /* renamed from: a */
    public void m44561a(int i10) {
        this.f33674c = i10;
    }

    /* renamed from: b */
    public void m44568b(String str) {
        this.f33676e = str;
    }

    /* renamed from: c */
    public void m44573c(boolean z10) {
        this.f33686o = z10;
    }

    /* renamed from: d */
    public void m44577d(String str) {
        this.f33680i = str;
    }

    /* renamed from: e */
    public void m44581e(boolean z10) {
        this.f33692u = z10;
    }

    /* renamed from: f */
    public boolean m44585f() {
        return this.f33692u;
    }

    /* renamed from: g */
    public void m44588g(String str) {
        this.f33695x = str;
    }

    /* renamed from: h */
    public void m44591h(String str) {
        this.f33697z = str;
    }

    /* renamed from: a */
    public void m44562a(Float f10) {
        if (f10 == null) {
            f10 = null;
        } else if (f10.floatValue() <= 0.0f) {
            f10 = Float.valueOf(1.7777778f);
        }
        this.f33690s = f10;
    }

    /* renamed from: b */
    public void m44569b(boolean z10) {
        this.f33685n = z10;
    }

    /* renamed from: c */
    public boolean m44574c() {
        return this.f33685n;
    }

    /* renamed from: d */
    public void m44578d(boolean z10) {
        this.f33691t = z10;
    }

    /* renamed from: e */
    public boolean m44582e() {
        return this.f33691t;
    }

    /* renamed from: a */
    public void m44563a(String str) {
        this.f33672a = str;
    }

    /* renamed from: b */
    public boolean m44570b(Context context) {
        String strM41968c;
        C7022dk c7022dkM41937a;
        String strM41970e;
        int i10 = this.f33683l;
        if (2 == i10 || 3 == i10 || this.f33692u) {
            return true;
        }
        if (TextUtils.isEmpty(this.f33672a)) {
            return false;
        }
        String str = this.f33672a;
        if (str != null && str.startsWith(Scheme.CONTENT.toString())) {
            return true;
        }
        if (this.f33672a.startsWith("http")) {
            C7022dk c7022dkM41937a2 = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
            strM41968c = c7022dkM41937a2.m41968c(c7022dkM41937a2.m41970e(this.f33672a));
            if (AbstractC7806cz.m48165b(strM41968c)) {
                c7022dkM41937a = C7019dh.m41937a(context, Constants.TPLATE_CACHE);
                strM41970e = c7022dkM41937a.m41970e(this.f33672a);
                strM41968c = c7022dkM41937a.m41968c(strM41970e);
            }
        } else if (C7022dk.m41954i(this.f33672a)) {
            strM41968c = C7019dh.m41937a(context, Constants.NORMAL_CACHE).m41968c(this.f33672a);
            if (!AbstractC7731ae.m47464d(new File(strM41968c))) {
                c7022dkM41937a = C7019dh.m41937a(context, Constants.TPLATE_CACHE);
                strM41970e = this.f33672a;
                strM41968c = c7022dkM41937a.m41968c(strM41970e);
            }
        } else {
            strM41968c = this.f33672a;
        }
        return 1 == this.f33683l && C7821dn.m48377a(context, strM41968c, (long) m44559a()) && (!this.f33684m || C7821dn.m48378a(context, strM41968c, this.f33680i));
    }

    /* renamed from: a */
    public void m44564a(boolean z10) {
        this.f33684m = z10;
    }

    /* renamed from: a */
    public boolean m44565a(Context context) {
        int i10 = this.f33683l;
        if (2 == i10 || this.f33692u) {
            return true;
        }
        return 1 == i10 && C7821dn.m48377a(context, this.f33672a, (long) m44559a());
    }
}
