package p644t1;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p541p1.InterfaceC12071c;
import p598r1.C12455a;
import p629s1.C12664c;

/* renamed from: t1.d */
/* loaded from: classes.dex */
public class C12916d {

    /* renamed from: a */
    public String f58914a;

    /* renamed from: b */
    public long f58915b;

    /* renamed from: c */
    public int f58916c;

    /* renamed from: d */
    public int f58917d;

    /* renamed from: e */
    public int f58918e;

    /* renamed from: f */
    public int f58919f;

    /* renamed from: g */
    public C12455a f58920g;

    /* renamed from: h */
    public int f58921h;

    /* renamed from: i */
    public int f58922i;

    /* renamed from: j */
    public float f58923j = 1.0f;

    /* renamed from: k */
    public String f58924k;

    /* renamed from: l */
    public String f58925l;

    /* renamed from: m */
    public int f58926m;

    /* renamed from: n */
    public int f58927n;

    /* renamed from: o */
    public String f58928o;

    /* renamed from: p */
    public int f58929p;

    /* renamed from: q */
    public int f58930q;

    /* renamed from: r */
    public String f58931r;

    /* renamed from: d */
    public static boolean m77553d(InterfaceC12071c interfaceC12071c) {
        return InterfaceC12071c.m72222a(interfaceC12071c);
    }

    /* renamed from: a */
    public int m77554a() {
        C12455a c12455a = this.f58920g;
        if (c12455a == null) {
            return -1;
        }
        int iMo72223a = c12455a.mo72223a();
        C12455a c12455a2 = this.f58920g;
        if (2 == iMo72223a) {
            return c12455a2.f57380b.size();
        }
        if (1 == c12455a2.mo72223a()) {
            return 1;
        }
        Log.w("CurrentPlayingInfo", "getPatternCount(), invalid HE version!");
        return -1;
    }

    /* renamed from: b */
    public void m77555b(int i10, int i11) {
        String str;
        Log.d("CurrentPlayingInfo", "changePlayerStatus, from:" + this.f58922i + ",to:" + i10 + ", code:" + i11);
        if (!m77558f(this.f58922i, i10)) {
            str = "changePlayerStatus, invalid transition, from " + this.f58922i + " to " + i10;
        } else {
            if (i10 != this.f58922i || i11 == 0) {
                this.f58922i = i10;
                return;
            }
            str = "changePlayerStatus, needn't update";
        }
        Log.w("CurrentPlayingInfo", str);
    }

    /* renamed from: c */
    public final boolean m77556c(int i10) {
        return i10 >= 0 && i10 <= 9;
    }

    /* renamed from: e */
    public int m77557e() {
        return this.f58922i;
    }

    /* renamed from: f */
    public final boolean m77558f(int i10, int i11) {
        if (!m77556c(i10) || !m77556c(i11)) {
            return false;
        }
        switch (i10) {
            case 0:
                if (i11 == 0 || 2 == i11 || 1 == i11 || 3 == i11) {
                }
                break;
            case 1:
                if (1 == i11) {
                }
                break;
            case 2:
                if (2 == i11) {
                }
                break;
            case 3:
                if (i11 == 0 || 2 == i11 || 1 == i11 || 3 == i11 || 4 == i11 || 5 == i11) {
                }
                break;
            case 4:
                if (2 == i11 || i11 == 0 || 1 == i11 || 4 == i11 || 5 == i11) {
                }
                break;
            case 5:
                if (2 == i11 || i11 == 0 || 1 == i11 || 5 == i11 || 6 == i11 || 8 == i11) {
                }
                break;
            case 6:
            case 7:
                if (2 == i11 || i11 == 0 || 1 == i11 || 6 == i11 || 8 == i11 || 7 == i11 || 9 == i11) {
                }
                break;
            case 8:
                if (2 == i11 || i11 == 0 || 1 == i11 || 4 == i11 || 5 == i11 || 8 == i11) {
                }
                break;
            case 9:
                if (2 == i11 || i11 == 0 || 1 == i11 || 6 == i11 || 7 == i11 || 9 == i11) {
                }
                break;
        }
        return false;
    }

    /* renamed from: g */
    public void m77559g() {
        String str = this.f58925l;
        if (str != null && str.length() != 0) {
            C12664c.m76238c(this.f58925l);
        }
        String str2 = Process.myTid() + "," + SystemClock.elapsedRealtime();
        this.f58925l = str2;
        C12664c.m76237b(str2);
    }

    /* renamed from: h */
    public void m77560h() {
        Log.d("CurrentPlayingInfo", "reset!");
        this.f58914a = null;
        this.f58915b = 0L;
        this.f58916c = 0;
        this.f58917d = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        this.f58918e = 0;
        this.f58919f = 0;
        this.f58920g = null;
        this.f58921h = 0;
        this.f58922i = 0;
        this.f58923j = 1.0f;
        this.f58924k = null;
        this.f58926m = 0;
        this.f58928o = null;
        this.f58929p = 0;
        this.f58930q = 0;
        this.f58931r = null;
        String str = this.f58925l;
        if (str != null && str.length() != 0) {
            C12664c.m76238c(this.f58925l);
        }
        this.f58925l = null;
    }

    public String toString() {
        return "CurrentPlayingHeInfo{mHeString='" + this.f58914a + "', mStartTime=" + this.f58915b + ", mLoop=" + this.f58916c + ", mAmplitude=" + this.f58917d + ", mFreq=" + this.f58918e + ", mHeRoot=" + this.f58920g + ", mSyncCallback=" + ((Object) null) + ", mStartPosition=" + this.f58921h + ", mStatus:" + this.f58922i + ", mSpeedMultiple:" + this.f58923j + '}';
    }
}
