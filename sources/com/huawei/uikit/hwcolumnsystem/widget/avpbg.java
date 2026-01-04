package com.huawei.uikit.hwcolumnsystem.widget;

import android.util.Log;

/* loaded from: classes7.dex */
class avpbg extends akxao {

    /* renamed from: p */
    private static final String f41929p = "avpbg";

    /* renamed from: q */
    private static final int f41930q = 2;

    /* renamed from: r */
    private static final int f41931r = 4;

    /* renamed from: s */
    private static final int f41932s = 8;

    /* renamed from: t */
    private static final int f41933t = 12;

    /* renamed from: u */
    private static final float f41934u = 0.5f;

    /* renamed from: m */
    private int f41935m;

    /* renamed from: n */
    private int f41936n;

    /* renamed from: o */
    private int f41937o;

    @Override // com.huawei.uikit.hwcolumnsystem.widget.akxao
    /* renamed from: a */
    public final float mo54173a(int i10) {
        return (i10 * this.f41926j) + ((i10 - 1) * this.f41922f);
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.akxao
    /* renamed from: b */
    public final int mo54177b() {
        return this.f41935m;
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.akxao
    /* renamed from: c */
    public int mo54179c() {
        return this.f41936n;
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.akxao
    /* renamed from: d */
    public int mo54181d() {
        return this.f41935m;
    }

    @Override // com.huawei.uikit.hwcolumnsystem.widget.akxao
    /* renamed from: e */
    public void mo54182e() {
        int i10 = this.f41925i;
        if (i10 == 0) {
            Log.e(f41929p, "total column is 0");
            return;
        }
        this.f41926j = ((this.f41917a - (this.f41921e * 2)) - (this.f41922f * (i10 - 1))) / (i10 * 1.0f);
        int iMo54173a = (int) (mo54173a(i10) + f41934u);
        this.f41937o = iMo54173a;
        int i11 = this.f41923g;
        if (i11 == -2) {
            this.f41935m = iMo54173a + (this.f41921e * 2);
        } else {
            this.f41935m = (int) (mo54173a(i11) + m54183a(true) + f41934u);
        }
        int i12 = this.f41924h;
        if (i12 == -2) {
            this.f41936n = this.f41937o + (this.f41921e * 2);
        } else {
            this.f41936n = (int) (mo54173a(i12) + m54183a(false) + f41934u);
        }
    }

    /* renamed from: f */
    public int m54184f() {
        return this.f41937o;
    }

    /* renamed from: a */
    private int m54183a(boolean z10) {
        int i10;
        if (!this.f41928l) {
            return 0;
        }
        int i11 = this.f41927k;
        if (i11 == 1 || i11 == 17) {
            if (this.f41925i != 4 || !z10) {
                return 0;
            }
            i10 = this.f41922f;
        } else {
            if (i11 != 19) {
                return 0;
            }
            int i12 = this.f41925i;
            if (i12 != 8 && i12 != 12) {
                return 0;
            }
            i10 = this.f41922f;
        }
        return i10 * 2;
    }
}
