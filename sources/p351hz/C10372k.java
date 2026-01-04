package p351hz;

import com.huawei.hiar.ARImageMetadata;
import com.huawei.hms.network.embedded.C5976k;
import com.huawei.hms.network.embedded.C6051p9;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: hz.k */
/* loaded from: classes9.dex */
public class C10372k extends AbstractC10369h {

    /* renamed from: j */
    public static final int[] f50126j = {C6051p9.f27764p, ARImageMetadata.SHADING_MODE, C5976k.e.f27211b, 4194304, 4194304, 8388608, 8388608, 16777216, 33554432, HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK};

    /* renamed from: k */
    public static final int[] f50127k = {4, 8, 24, 48};

    /* renamed from: a */
    public int f50128a;

    /* renamed from: b */
    public byte[] f50129b = null;

    /* renamed from: c */
    public int f50130c;

    /* renamed from: d */
    public int f50131d;

    /* renamed from: e */
    public int f50132e;

    /* renamed from: f */
    public int f50133f;

    /* renamed from: g */
    public int f50134g;

    /* renamed from: h */
    public int f50135h;

    /* renamed from: i */
    public int f50136i;

    public C10372k() {
        try {
            m63807g(6);
        } catch (C10377p unused) {
            throw new RuntimeException();
        }
    }

    @Override // p351hz.AbstractC10369h
    /* renamed from: b */
    public InputStream mo63793b(InputStream inputStream, C10364c c10364c) throws IOException {
        return new C10371j(inputStream, this.f50128a, this.f50129b, c10364c);
    }

    /* renamed from: c */
    public void m63804c(int i10) throws C10377p {
        if (i10 < 4096) {
            throw new C10377p("LZMA2 dictionary size must be at least 4 KiB: " + i10 + " B");
        }
        if (i10 <= 805306368) {
            this.f50128a = i10;
            return;
        }
        throw new C10377p("LZMA2 dictionary size must not exceed 768 MiB: " + i10 + " B");
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new RuntimeException();
        }
    }

    /* renamed from: d */
    public void m63805d(int i10, int i11) throws C10377p {
        if (i10 >= 0 && i11 >= 0 && i10 <= 4 && i11 <= 4 && i10 + i11 <= 4) {
            this.f50130c = i10;
            this.f50131d = i11;
            return;
        }
        throw new C10377p("lc + lp must not exceed 4: " + i10 + " + " + i11);
    }

    /* renamed from: f */
    public void m63806f(int i10) throws C10377p {
        if (i10 >= 0 && i10 <= 4) {
            this.f50132e = i10;
            return;
        }
        throw new C10377p("pb must not exceed 4: " + i10);
    }

    /* renamed from: g */
    public void m63807g(int i10) throws C10377p {
        if (i10 < 0 || i10 > 9) {
            throw new C10377p("Unsupported preset: " + i10);
        }
        this.f50130c = 3;
        this.f50131d = 0;
        this.f50132e = 2;
        this.f50128a = f50126j[i10];
        if (i10 <= 3) {
            this.f50133f = 1;
            this.f50135h = 4;
            this.f50134g = i10 <= 1 ? 128 : 273;
            this.f50136i = f50127k[i10];
            return;
        }
        this.f50133f = 2;
        this.f50135h = 20;
        this.f50134g = i10 == 4 ? 16 : i10 == 5 ? 32 : 64;
        this.f50136i = 0;
    }
}
