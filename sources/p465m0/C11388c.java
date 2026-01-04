package p465m0;

import java.nio.ByteBuffer;

/* renamed from: m0.c */
/* loaded from: classes.dex */
public class C11388c {

    /* renamed from: a */
    public int f53141a;

    /* renamed from: b */
    public ByteBuffer f53142b;

    /* renamed from: c */
    public int f53143c;

    /* renamed from: d */
    public int f53144d;

    /* renamed from: e */
    public AbstractC11389d f53145e = AbstractC11389d.m68296a();

    /* renamed from: a */
    public int m68291a(int i10) {
        return i10 + this.f53142b.getInt(i10);
    }

    /* renamed from: b */
    public int m68292b(int i10) {
        if (i10 < this.f53144d) {
            return this.f53142b.getShort(this.f53143c + i10);
        }
        return 0;
    }

    /* renamed from: c */
    public void m68293c(int i10, ByteBuffer byteBuffer) {
        this.f53142b = byteBuffer;
        if (byteBuffer == null) {
            this.f53141a = 0;
            this.f53143c = 0;
            this.f53144d = 0;
        } else {
            this.f53141a = i10;
            int i11 = i10 - byteBuffer.getInt(i10);
            this.f53143c = i11;
            this.f53144d = this.f53142b.getShort(i11);
        }
    }

    /* renamed from: d */
    public int m68294d(int i10) {
        int i11 = i10 + this.f53141a;
        return i11 + this.f53142b.getInt(i11) + 4;
    }

    /* renamed from: e */
    public int m68295e(int i10) {
        int i11 = i10 + this.f53141a;
        return this.f53142b.getInt(i11 + this.f53142b.getInt(i11));
    }
}
