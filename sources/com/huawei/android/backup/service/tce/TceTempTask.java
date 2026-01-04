package com.huawei.android.backup.service.tce;

import android.content.Context;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.util.TimerTask;
import p359i6.AbstractC10448d;
import p359i6.C10446b;
import p359i6.C10447c;
import p359i6.C10449e;
import p359i6.C10450f;

/* loaded from: classes.dex */
public class TceTempTask extends TimerTask {

    /* renamed from: c */
    public static final int[][] f9707c = {new int[]{-10, 10}, new int[]{-10, 10}, new int[]{-10, 5}, new int[]{-15, 5}, new int[]{-20, 5}};

    /* renamed from: d */
    public static int f9708d = 100;

    /* renamed from: e */
    public static AbstractC10448d f9709e;

    /* renamed from: a */
    public C10450f[] f9710a = new C10450f[2];

    /* renamed from: b */
    public boolean f9711b = true;

    public TceTempTask(Context context) {
        m13116k(new C10449e(context));
        C2111d.m12654j("TCETempTask", "TEMP_MAX is ", 44, ", TEMP_MIN is ", 40);
        for (int i10 = 0; i10 <= 4; i10++) {
            Integer numValueOf = Integer.valueOf(i10 + 40);
            int[][] iArr = f9707c;
            C2111d.m12654j("TCETempTask", "Temp ", numValueOf, ", decrease weight is ", Integer.valueOf(iArr[i10][0]), ", increase weight is ", Integer.valueOf(iArr[i10][1]));
        }
        if (f9709e.mo64242d()) {
            return;
        }
        C2111d.m12657m("TCETempTask", "Can't use hardware properties to get temperature");
        m13116k(new C10446b());
        if (f9709e.mo64242d()) {
            return;
        }
        C2111d.m12657m("TCETempTask", "Can't use thermal node to get temperature");
    }

    /* renamed from: g */
    public static int m13114g() {
        return f9708d;
    }

    /* renamed from: j */
    public static void m13115j(int i10) {
        f9708d = i10;
    }

    /* renamed from: k */
    public static void m13116k(AbstractC10448d abstractC10448d) {
        f9709e = abstractC10448d;
    }

    /* renamed from: a */
    public final void m13117a(float f10, int i10) {
        int iM13123i = m13123i(f10, i10);
        if (iM13123i != f9708d) {
            C10447c.m64245a().m64249e(iM13123i);
            m13115j(iM13123i);
        }
    }

    /* renamed from: c */
    public final void m13118c() {
        float fM64252a = this.f9710a[1].m64252a();
        float fM64252a2 = this.f9710a[0].m64252a();
        long jM64253b = this.f9710a[1].m64253b() - this.f9710a[0].m64253b();
        float f10 = fM64252a - fM64252a2;
        long jM64246b = C10447c.m64245a().m64246b();
        if (f10 < 0.0f) {
            m13119d(fM64252a);
        } else if (f10 == 0.0f) {
            m13120e(fM64252a);
        } else {
            m13121f(fM64252a, jM64253b, f10, jM64246b);
        }
    }

    /* renamed from: d */
    public final void m13119d(float f10) {
        int i10;
        if (f10 >= 44.0f) {
            f10 = 40.0f;
            i10 = 0;
        } else {
            i10 = 1;
        }
        m13117a(f10, i10);
        m13124l();
    }

    /* renamed from: e */
    public final void m13120e(float f10) {
        if (f10 < 40.0f) {
            m13117a(44.0f, 1);
            m13124l();
        } else if (f10 < 44.0f) {
            C2111d.m12647c("TCETempTask", "dealWithTempEqual tempN = ", Float.valueOf(f10));
        } else {
            m13117a(40.0f, 0);
            m13124l();
        }
    }

    /* renamed from: f */
    public final void m13121f(float f10, long j10, float f11, long j11) {
        if (f10 < 40.0f) {
            m13124l();
            return;
        }
        if (f10 >= 44.0f) {
            m13117a(f10, 0);
            m13124l();
        } else if (j10 >= 239001 || f11 > 1.0f) {
            if ((j11 * (f11 / j10)) + f10 >= 44.0f) {
                m13117a(f10, 0);
            }
            m13124l();
        }
    }

    /* renamed from: h */
    public final int m13122h(float f10) {
        if (f10 < 40.0f) {
            return 100;
        }
        int iFloor = (int) Math.floor(f10 - 40.0f);
        int i10 = 0;
        int i11 = 100;
        while (i10 <= iFloor) {
            i11 += i10 <= 4 ? f9707c[i10][0] : f9707c[4][0];
            i10++;
        }
        if (i11 < 1) {
            return 1;
        }
        if (i11 > 100) {
            return 100;
        }
        C2111d.m12654j("TCETempTask", "temWeight is ", Integer.valueOf(i11));
        return i11;
    }

    /* renamed from: i */
    public final int m13123i(float f10, int i10) {
        if (f10 == -1000.0f || i10 == 1) {
            return f9708d;
        }
        if (f10 < 40.0f) {
            f10 = 40.0f;
        } else if (f10 > 44.0f) {
            f10 = 44.0f;
        } else {
            C2111d.m12647c("TCETempTask", "tempValue: ", Float.valueOf(f10));
        }
        int i11 = f9708d + f9707c[(int) Math.floor(f10 - 40.0f)][i10];
        if (i11 <= 1) {
            return 1;
        }
        if (i11 > 100) {
            return 100;
        }
        C2111d.m12647c("TCETempTask", "tempWeight: ", Integer.valueOf(i11));
        return i11;
    }

    /* renamed from: l */
    public final void m13124l() {
        C10450f[] c10450fArr = this.f9710a;
        c10450fArr[0] = c10450fArr[1];
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            C10450f c10450fM64251c = f9709e.m64251c();
            if (c10450fM64251c == null) {
                return;
            }
            if (this.f9711b) {
                this.f9710a[0] = c10450fM64251c;
                this.f9711b = false;
                float fM64252a = c10450fM64251c.m64252a();
                C2111d.m12654j("TCETempTask", "First temp is ", Float.valueOf(fM64252a));
                if (fM64252a >= 40.0f) {
                    m13115j(m13122h(fM64252a));
                    C2111d.m12654j("TCETempTask", "First currentWeight is ", Integer.valueOf(f9708d));
                    C10447c.m64245a().m64249e(f9708d);
                }
            } else {
                this.f9710a[1] = c10450fM64251c;
                m13118c();
            }
        } catch (IllegalArgumentException unused) {
            C2111d.m12648d("TCETempTask", "IllegalArgument in TceTemp");
        } catch (Exception unused2) {
            C2111d.m12648d("TCETempTask", "unknow err in TceTemp");
        }
    }
}
