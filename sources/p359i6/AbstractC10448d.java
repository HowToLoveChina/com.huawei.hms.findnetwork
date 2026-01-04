package p359i6;

import com.huawei.android.backup.filelogic.utils.C2111d;

/* renamed from: i6.d */
/* loaded from: classes.dex */
public abstract class AbstractC10448d {

    /* renamed from: a */
    public int f50410a = 60;

    /* renamed from: b */
    public int f50411b = 0;

    /* renamed from: c */
    public float f50412c = 0.0f;

    /* renamed from: a */
    public final void m64250a() {
        this.f50411b = 0;
        this.f50410a = 60;
        this.f50412c = 0.0f;
    }

    /* renamed from: b */
    public abstract float mo64241b();

    /* renamed from: c */
    public C10450f m64251c() {
        float fMo64241b = mo64241b();
        if (fMo64241b > -1000.0f) {
            this.f50412c += fMo64241b;
            this.f50411b++;
        }
        int i10 = this.f50410a - 1;
        this.f50410a = i10;
        if (i10 != 0) {
            return null;
        }
        int i11 = this.f50411b;
        if (i11 < 3) {
            m64250a();
            C2111d.m12658n("TempWinBase", "Get temp failed, suc count: ", Integer.valueOf(this.f50411b));
            return null;
        }
        float f10 = this.f50412c / i11;
        C2111d.m12654j("TempWinBase", "windowTemp is ", Float.valueOf(f10), " ,tempSum is ", Float.valueOf(this.f50412c), " ,sucTempCount is ", Integer.valueOf(this.f50411b));
        m64250a();
        return new C10450f(System.currentTimeMillis(), f10);
    }

    /* renamed from: d */
    public abstract boolean mo64242d();
}
