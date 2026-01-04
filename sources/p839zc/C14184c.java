package p839zc;

import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: zc.c */
/* loaded from: classes3.dex */
public class C14184c extends OutputStream {

    /* renamed from: a */
    public OutputStream f63346a;

    /* renamed from: b */
    public int f63347b = 0;

    /* renamed from: c */
    public int f63348c;

    /* renamed from: d */
    public int f63349d;

    /* renamed from: e */
    public int f63350e;

    public C14184c(OutputStream outputStream, int i10) {
        this.f63346a = outputStream;
        this.f63350e = i10;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        m85056s();
        this.f63346a.close();
    }

    /* renamed from: s */
    public void m85056s() throws IOException {
        if (this.f63348c > 0) {
            int i10 = this.f63350e;
            if (i10 > 0 && this.f63349d == i10) {
                this.f63346a.write("\r\n".getBytes("utf-8"));
                this.f63349d = 0;
            }
            char cCharAt = C14185d.f63351a.charAt((this.f63347b << 8) >>> 26);
            char cCharAt2 = C14185d.f63351a.charAt((this.f63347b << 14) >>> 26);
            char cCharAt3 = this.f63348c < 2 ? C14185d.f63352b : C14185d.f63351a.charAt((this.f63347b << 20) >>> 26);
            char cCharAt4 = this.f63348c < 3 ? C14185d.f63352b : C14185d.f63351a.charAt((this.f63347b << 26) >>> 26);
            this.f63346a.write(cCharAt);
            this.f63346a.write(cCharAt2);
            this.f63346a.write(cCharAt3);
            this.f63346a.write(cCharAt4);
            this.f63349d += 4;
            this.f63348c = 0;
            this.f63347b = 0;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        int i11 = i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        int i12 = this.f63348c;
        this.f63347b = (i11 << (16 - (i12 * 8))) | this.f63347b;
        int i13 = i12 + 1;
        this.f63348c = i13;
        if (i13 == 3) {
            m85056s();
        }
    }
}
