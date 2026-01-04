package com.apprichtap.haptic.player;

import android.content.Context;
import android.os.Process;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import p629s1.C12663b;
import p629s1.C12664c;
import p629s1.C12665d;
import p644t1.InterfaceC12914b;

/* renamed from: com.apprichtap.haptic.player.d */
/* loaded from: classes.dex */
public class C1515d implements InterfaceC12914b {

    /* renamed from: h */
    public static int f6503h = -1;

    /* renamed from: i */
    public static int f6504i = -1;

    /* renamed from: a */
    public Vibrator f6505a;

    /* renamed from: b */
    public Context f6506b;

    /* renamed from: c */
    public Class<?> f6507c;

    /* renamed from: d */
    public String f6508d;

    /* renamed from: f */
    public boolean f6510f;

    /* renamed from: e */
    public AtomicInteger f6509e = new AtomicInteger();

    /* renamed from: g */
    public int f6511g = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;

    public C1515d(Context context) {
        this.f6506b = context;
        this.f6505a = (Vibrator) context.getSystemService("vibrator");
        try {
            this.f6507c = Class.forName("richtap.os.PhonyVibrationEffect");
        } catch (ClassNotFoundException unused) {
            this.f6507c = null;
            C12665d.a.m76244c("RichTapPerformer", "failed to reflect class: \"richtap.os.PhonyVibrationEffect\"!");
        }
        if (this.f6507c == null) {
            try {
                this.f6507c = Class.forName("android.os.RichTapVibrationEffect");
            } catch (ClassNotFoundException unused2) {
                this.f6507c = null;
                C12665d.a.m76244c("RichTapPerformer", "failed to reflect class: \"android.os.RichTapVibrationEffect\"!");
            }
        }
        if (this.f6507c == null) {
            try {
                this.f6507c = Class.forName("android.os.VibrationEffect");
            } catch (ClassNotFoundException unused3) {
                C12665d.a.m76244c("RichTapPerformer", "failed to reflect class: \"android.os.VibrationEffect\"!");
            }
        }
        m8623g();
    }

    /* renamed from: f */
    public static boolean m8617f() {
        Class<?> cls;
        try {
            try {
                cls = Class.forName("richtap.os.PhonyVibrationEffect");
            } catch (ClassNotFoundException unused) {
                C12665d.a.m76244c("RichTapPerformer", "failed to reflect class: \"richtap.os.PhonyVibrationEffect\"!");
                cls = null;
            }
            if (cls == null) {
                try {
                    cls = Class.forName("android.os.RichTapVibrationEffect");
                } catch (ClassNotFoundException unused2) {
                    C12665d.a.m76244c("RichTapPerformer", "failed to reflect class: \"android.os.RichTapVibrationEffect\"!");
                    cls = null;
                }
            }
            if (cls == null) {
                try {
                    cls = Class.forName("android.os.VibrationEffect");
                } catch (ClassNotFoundException unused3) {
                    C12665d.a.m76244c("RichTapPerformer", "failed to reflect class: \"android.os.VibrationEffect\"!");
                }
            }
            return 2 != ((Integer) cls.getMethod("checkIfRichTapSupport", new Class[0]).invoke(null, new Object[0])).intValue();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    @Override // p644t1.InterfaceC12914b
    /* renamed from: a */
    public void mo8618a(String str) throws Throwable {
        String strM76217d;
        int i10;
        int iMyPid;
        int iIncrementAndGet;
        String str2 = this.f6508d;
        int[] iArrM76236a = str2 != null ? C12664c.m76236a(str2) : null;
        int i11 = f6503h;
        if (i11 <= 0) {
            C12665d.a.m76243b("RichTapPerformer", "start(), mRichTapCoreMajorVersion:" + f6503h);
            return;
        }
        if (23 >= i11) {
            strM76217d = C12663b.m76217d(str, true);
            i10 = 1;
        } else {
            strM76217d = str;
            i10 = 2;
        }
        if (iArrM76236a == null || 2 != iArrM76236a.length) {
            iMyPid = Process.myPid();
            iIncrementAndGet = this.f6509e.incrementAndGet() % Integer.MAX_VALUE;
        } else {
            int i12 = iArrM76236a[0];
            iIncrementAndGet = iArrM76236a[1];
            iMyPid = i12;
        }
        int[] iArrM76223j = C12663b.m76223j(strM76217d, i10, f6503h, f6504i, iMyPid, iIncrementAndGet, this.f6510f);
        try {
            C12665d.a.m76242a("RichTapPerformer", "start() mGain:" + this.f6511g + " raw data:" + Arrays.toString(iArrM76223j));
            Class<?> cls = this.f6507c;
            Class<?> cls2 = Integer.TYPE;
            this.f6505a.vibrate((VibrationEffect) cls.getMethod("createPatternHeWithParam", int[].class, cls2, cls2, cls2, cls2).invoke(null, iArrM76223j, 1, 0, Integer.valueOf(this.f6511g), 0));
        } catch (Throwable th2) {
            C12665d.a.m76245d("RichTapPerformer", "The system doesn't integrate richTap software");
            th2.printStackTrace();
        }
    }

    @Override // p644t1.InterfaceC12914b
    /* renamed from: b */
    public void mo8619b(int i10) {
        if (this.f6506b == null) {
            C12665d.a.m76245d("RichTapPerformer", "set gain null == mContext");
            return;
        }
        if (i10 == 0) {
            C12665d.a.m76242a("RichTapPerformer", "0 == gain");
            i10 = 1;
        }
        m8622e(0, i10, 0);
        this.f6511g = i10;
    }

    @Override // p644t1.InterfaceC12914b
    /* renamed from: c */
    public void mo8620c(String str) {
        C12665d.a.m76242a("RichTapPerformer", "setSenderIdKey:" + str);
        this.f6508d = str;
    }

    @Override // p644t1.InterfaceC12914b
    /* renamed from: d */
    public int mo8621d() {
        return f6503h;
    }

    /* renamed from: e */
    public final void m8622e(int i10, int i11, int i12) {
        if (f6503h <= 0) {
            C12665d.a.m76243b("RichTapPerformer", "applyPatternHeParam, CORE_MAJOR_VERSION:" + f6503h);
            return;
        }
        try {
            C12665d.a.m76244c("RichTapPerformer", "applyPatternHeParam, interval:" + i10 + ", amplitude:" + i11 + ",freq:" + i12);
            Class<?> cls = this.f6507c;
            Class<?> cls2 = Integer.TYPE;
            this.f6505a.vibrate((VibrationEffect) cls.getMethod("createPatternHeParameter", cls2, cls2, cls2).invoke(null, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)));
        } catch (Throwable th2) {
            th2.printStackTrace();
            C12665d.a.m76245d("RichTapPerformer", "The system doesn't integrate RichTap software");
        }
    }

    /* renamed from: g */
    public final void m8623g() {
        try {
            if (this.f6506b != null && this.f6505a != null) {
                int iIntValue = ((Integer) this.f6507c.getMethod("checkIfRichTapSupport", new Class[0]).invoke(null, new Object[0])).intValue();
                C12665d.a.m76242a("RichTapPerformer", "getRichTapCoreMajorVersion check framework RichTap version:" + iIntValue);
                if (1 == iIntValue) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("clientCode:");
                sb2.append((16711680 & iIntValue) >> 16);
                sb2.append(" majorVersion:");
                int i10 = (65280 & iIntValue) >> 8;
                sb2.append(i10);
                sb2.append(" minorVersion:");
                int i11 = iIntValue & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                sb2.append(i11);
                C12665d.a.m76242a("RichTapPerformer", sb2.toString());
                f6503h = i10;
                f6504i = i11;
                return;
            }
            C12665d.a.m76243b("RichTapPerformer", "getRichTapCoreMajorVersion mContext or mVibrator null");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // p644t1.InterfaceC12914b
    public void stop() {
        C12665d.a.m76242a("RichTapPerformer", "stop()");
        m8622e(0, 0, 0);
    }
}
