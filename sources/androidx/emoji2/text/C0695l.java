package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p465m0.C11387b;

/* renamed from: androidx.emoji2.text.l */
/* loaded from: classes.dex */
public class C0695l {

    /* renamed from: androidx.emoji2.text.l$a */
    public static class a implements c {

        /* renamed from: a */
        public final ByteBuffer f3663a;

        public a(ByteBuffer byteBuffer) {
            this.f3663a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.C0695l.c
        /* renamed from: a */
        public int mo4292a() throws IOException {
            return this.f3663a.getInt();
        }

        @Override // androidx.emoji2.text.C0695l.c
        /* renamed from: b */
        public void mo4293b(int i10) throws IOException {
            ByteBuffer byteBuffer = this.f3663a;
            byteBuffer.position(byteBuffer.position() + i10);
        }

        @Override // androidx.emoji2.text.C0695l.c
        /* renamed from: c */
        public long mo4294c() throws IOException {
            return C0695l.m4290c(this.f3663a.getInt());
        }

        @Override // androidx.emoji2.text.C0695l.c
        public long getPosition() {
            return this.f3663a.position();
        }

        @Override // androidx.emoji2.text.C0695l.c
        public int readUnsignedShort() throws IOException {
            return C0695l.m4291d(this.f3663a.getShort());
        }
    }

    /* renamed from: androidx.emoji2.text.l$b */
    public static class b {

        /* renamed from: a */
        public final long f3664a;

        /* renamed from: b */
        public final long f3665b;

        public b(long j10, long j11) {
            this.f3664a = j10;
            this.f3665b = j11;
        }

        /* renamed from: a */
        public long m4295a() {
            return this.f3664a;
        }
    }

    /* renamed from: androidx.emoji2.text.l$c */
    public interface c {
        /* renamed from: a */
        int mo4292a() throws IOException;

        /* renamed from: b */
        void mo4293b(int i10) throws IOException;

        /* renamed from: c */
        long mo4294c() throws IOException;

        long getPosition();

        int readUnsignedShort() throws IOException;
    }

    /* renamed from: a */
    public static b m4288a(c cVar) throws IOException {
        long jMo4294c;
        cVar.mo4293b(4);
        int unsignedShort = cVar.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.mo4293b(6);
        int i10 = 0;
        while (true) {
            if (i10 >= unsignedShort) {
                jMo4294c = -1;
                break;
            }
            int iMo4292a = cVar.mo4292a();
            cVar.mo4293b(4);
            jMo4294c = cVar.mo4294c();
            cVar.mo4293b(4);
            if (1835365473 == iMo4292a) {
                break;
            }
            i10++;
        }
        if (jMo4294c != -1) {
            cVar.mo4293b((int) (jMo4294c - cVar.getPosition()));
            cVar.mo4293b(12);
            long jMo4294c2 = cVar.mo4294c();
            for (int i11 = 0; i11 < jMo4294c2; i11++) {
                int iMo4292a2 = cVar.mo4292a();
                long jMo4294c3 = cVar.mo4294c();
                long jMo4294c4 = cVar.mo4294c();
                if (1164798569 == iMo4292a2 || 1701669481 == iMo4292a2) {
                    return new b(jMo4294c3 + jMo4294c, jMo4294c4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    /* renamed from: b */
    public static C11387b m4289b(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) m4288a(new a(byteBufferDuplicate)).m4295a());
        return C11387b.m68284h(byteBufferDuplicate);
    }

    /* renamed from: c */
    public static long m4290c(int i10) {
        return i10 & 4294967295L;
    }

    /* renamed from: d */
    public static int m4291d(short s10) {
        return s10 & 65535;
    }
}
