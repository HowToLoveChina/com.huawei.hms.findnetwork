package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* renamed from: androidx.fragment.app.f0 */
/* loaded from: classes.dex */
public final class C0745f0 extends Writer {

    /* renamed from: a */
    public final String f4018a;

    /* renamed from: b */
    public StringBuilder f4019b = new StringBuilder(128);

    public C0745f0(String str) {
        this.f4018a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m4742s();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        m4742s();
    }

    /* renamed from: s */
    public final void m4742s() {
        if (this.f4019b.length() > 0) {
            Log.d(this.f4018a, this.f4019b.toString());
            StringBuilder sb2 = this.f4019b;
            sb2.delete(0, sb2.length());
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == '\n') {
                m4742s();
            } else {
                this.f4019b.append(c10);
            }
        }
    }
}
