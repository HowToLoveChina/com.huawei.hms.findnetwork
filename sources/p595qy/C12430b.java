package p595qy;

/* renamed from: qy.b */
/* loaded from: classes9.dex */
public class C12430b extends AbstractC12429a {
    public C12430b() {
        this(1024);
    }

    @Override // p595qy.AbstractC12429a
    /* renamed from: s */
    public synchronized byte[] mo74621s() {
        return m74622t();
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i10) {
        m74624v(i10);
    }

    public C12430b(int i10) {
        if (i10 >= 0) {
            synchronized (this) {
                m74620d(i10);
            }
        } else {
            throw new IllegalArgumentException("Negative initial size: " + i10);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > bArr.length || i11 < 0 || (i12 = i10 + i11) > bArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 == 0) {
            return;
        }
        synchronized (this) {
            m74625w(bArr, i10, i11);
        }
    }
}
