package p755wx;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import p022ay.C1050a0;
import p022ay.C1054d;
import p022ay.C1057g;
import p022ay.InterfaceC1056f;
import p022ay.InterfaceC1076z;
import p755wx.C13655d;
import sx.C12875e;

/* renamed from: wx.h */
/* loaded from: classes9.dex */
public final class C13659h implements Closeable {

    /* renamed from: e */
    public static final Logger f61488e = Logger.getLogger(C13656e.class.getName());

    /* renamed from: a */
    public final InterfaceC1056f f61489a;

    /* renamed from: b */
    public final a f61490b;

    /* renamed from: c */
    public final boolean f61491c;

    /* renamed from: d */
    public final C13655d.a f61492d;

    /* renamed from: wx.h$a */
    public static final class a implements InterfaceC1076z {

        /* renamed from: a */
        public final InterfaceC1056f f61493a;

        /* renamed from: b */
        public int f61494b;

        /* renamed from: c */
        public byte f61495c;

        /* renamed from: d */
        public int f61496d;

        /* renamed from: e */
        public int f61497e;

        /* renamed from: f */
        public short f61498f;

        public a(InterfaceC1056f interfaceC1056f) {
            this.f61493a = interfaceC1056f;
        }

        @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            while (true) {
                int i10 = this.f61497e;
                if (i10 != 0) {
                    long j11 = this.f61493a.read(c1054d, Math.min(j10, i10));
                    if (j11 == -1) {
                        return -1L;
                    }
                    this.f61497e = (int) (this.f61497e - j11);
                    return j11;
                }
                this.f61493a.skip(this.f61498f);
                this.f61498f = (short) 0;
                if ((this.f61495c & 4) != 0) {
                    return -1L;
                }
                m82140s();
            }
        }

        /* renamed from: s */
        public final void m82140s() throws IOException {
            int i10 = this.f61496d;
            int iM82126i = C13659h.m82126i(this.f61493a);
            this.f61497e = iM82126i;
            this.f61494b = iM82126i;
            byte b10 = (byte) (this.f61493a.readByte() & 255);
            this.f61495c = (byte) (this.f61493a.readByte() & 255);
            Logger logger = C13659h.f61488e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C13656e.m82069b(true, this.f61496d, this.f61494b, b10, this.f61495c));
            }
            int i11 = this.f61493a.readInt() & Integer.MAX_VALUE;
            this.f61496d = i11;
            if (b10 != 9) {
                throw C13656e.m82071d("%s != TYPE_CONTINUATION", Byte.valueOf(b10));
            }
            if (i11 != i10) {
                throw C13656e.m82071d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // p022ay.InterfaceC1076z
        public C1050a0 timeout() {
            return this.f61493a.timeout();
        }
    }

    /* renamed from: wx.h$b */
    public interface b {
        /* renamed from: a */
        void mo82112a();

        /* renamed from: c */
        void mo82113c(boolean z10, int i10, int i11, List<C13654c> list);

        /* renamed from: d */
        void mo82114d(int i10, EnumC13653b enumC13653b);

        /* renamed from: e */
        void mo82115e(boolean z10, C13664m c13664m);

        /* renamed from: f */
        void mo82116f(int i10, long j10);

        /* renamed from: g */
        void mo82117g(boolean z10, int i10, int i11);

        /* renamed from: h */
        void mo82118h(int i10, int i11, int i12, boolean z10);

        /* renamed from: i */
        void mo82119i(int i10, int i11, List<C13654c> list) throws IOException;

        /* renamed from: j */
        void mo82120j(boolean z10, int i10, InterfaceC1056f interfaceC1056f, int i11) throws IOException;

        /* renamed from: k */
        void mo82121k(int i10, EnumC13653b enumC13653b, C1057g c1057g);
    }

    public C13659h(InterfaceC1056f interfaceC1056f, boolean z10) {
        this.f61489a = interfaceC1056f;
        this.f61491c = z10;
        a aVar = new a(interfaceC1056f);
        this.f61490b = aVar;
        this.f61492d = new C13655d.a(4096, aVar);
    }

    /* renamed from: b */
    public static int m82125b(int i10, byte b10, short s10) throws IOException {
        if ((b10 & 8) != 0) {
            i10--;
        }
        if (s10 <= i10) {
            return (short) (i10 - s10);
        }
        throw C13656e.m82071d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s10), Integer.valueOf(i10));
    }

    /* renamed from: i */
    public static int m82126i(InterfaceC1056f interfaceC1056f) throws IOException {
        return (interfaceC1056f.readByte() & 255) | ((interfaceC1056f.readByte() & 255) << 16) | ((interfaceC1056f.readByte() & 255) << 8);
    }

    /* renamed from: c */
    public boolean m82127c(boolean z10, b bVar) throws IOException {
        try {
            this.f61489a.mo6357w0(9L);
            int iM82126i = m82126i(this.f61489a);
            if (iM82126i < 0 || iM82126i > 16384) {
                throw C13656e.m82071d("FRAME_SIZE_ERROR: %s", Integer.valueOf(iM82126i));
            }
            byte b10 = (byte) (this.f61489a.readByte() & 255);
            if (z10 && b10 != 4) {
                throw C13656e.m82071d("Expected a SETTINGS frame but was %s", Byte.valueOf(b10));
            }
            byte b11 = (byte) (this.f61489a.readByte() & 255);
            int i10 = this.f61489a.readInt() & Integer.MAX_VALUE;
            Logger logger = f61488e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C13656e.m82069b(true, i10, iM82126i, b10, b11));
            }
            switch (b10) {
                case 0:
                    m82129e(bVar, iM82126i, b11, i10);
                    return true;
                case 1:
                    m82132h(bVar, iM82126i, b11, i10);
                    return true;
                case 2:
                    m82135m(bVar, iM82126i, b11, i10);
                    return true;
                case 3:
                    m82137o(bVar, iM82126i, b11, i10);
                    return true;
                case 4:
                    m82138p(bVar, iM82126i, b11, i10);
                    return true;
                case 5:
                    m82136n(bVar, iM82126i, b11, i10);
                    return true;
                case 6:
                    m82133j(bVar, iM82126i, b11, i10);
                    return true;
                case 7:
                    m82130f(bVar, iM82126i, b11, i10);
                    return true;
                case 8:
                    m82139q(bVar, iM82126i, b11, i10);
                    return true;
                default:
                    this.f61489a.skip(iM82126i);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f61489a.close();
    }

    /* renamed from: d */
    public void m82128d(b bVar) throws IOException {
        if (this.f61491c) {
            if (!m82127c(true, bVar)) {
                throw C13656e.m82071d("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        InterfaceC1056f interfaceC1056f = this.f61489a;
        C1057g c1057g = C13656e.f61406a;
        C1057g c1057gMo6345l = interfaceC1056f.mo6345l(c1057g.m6370E());
        Logger logger = f61488e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C12875e.m77260q("<< CONNECTION %s", c1057gMo6345l.mo6384u()));
        }
        if (!c1057g.equals(c1057gMo6345l)) {
            throw C13656e.m82071d("Expected a connection header but was %s", c1057gMo6345l.m6374I());
        }
    }

    /* renamed from: e */
    public final void m82129e(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            throw C13656e.m82071d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z10 = (b10 & 1) != 0;
        if ((b10 & 32) != 0) {
            throw C13656e.m82071d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short s10 = (b10 & 8) != 0 ? (short) (this.f61489a.readByte() & 255) : (short) 0;
        bVar.mo82120j(z10, i11, this.f61489a, m82125b(i10, b10, s10));
        this.f61489a.skip(s10);
    }

    /* renamed from: f */
    public final void m82130f(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 < 8) {
            throw C13656e.m82071d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw C13656e.m82071d("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i12 = this.f61489a.readInt();
        int i13 = this.f61489a.readInt();
        int i14 = i10 - 8;
        EnumC13653b enumC13653bM82040b = EnumC13653b.m82040b(i13);
        if (enumC13653bM82040b == null) {
            throw C13656e.m82071d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i13));
        }
        C1057g c1057gMo6345l = C1057g.f5136e;
        if (i14 > 0) {
            c1057gMo6345l = this.f61489a.mo6345l(i14);
        }
        bVar.mo82121k(i12, enumC13653bM82040b, c1057gMo6345l);
    }

    /* renamed from: g */
    public final List<C13654c> m82131g(int i10, short s10, byte b10, int i11) throws IOException {
        a aVar = this.f61490b;
        aVar.f61497e = i10;
        aVar.f61494b = i10;
        aVar.f61498f = s10;
        aVar.f61495c = b10;
        aVar.f61496d = i11;
        this.f61492d.m82053k();
        return this.f61492d.m82047e();
    }

    /* renamed from: h */
    public final void m82132h(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            throw C13656e.m82071d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z10 = (b10 & 1) != 0;
        short s10 = (b10 & 8) != 0 ? (short) (this.f61489a.readByte() & 255) : (short) 0;
        if ((b10 & 32) != 0) {
            m82134k(bVar, i11);
            i10 -= 5;
        }
        bVar.mo82113c(z10, i11, -1, m82131g(m82125b(i10, b10, s10), s10, b10, i11));
    }

    /* renamed from: j */
    public final void m82133j(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 8) {
            throw C13656e.m82071d("TYPE_PING length != 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw C13656e.m82071d("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.mo82117g((b10 & 1) != 0, this.f61489a.readInt(), this.f61489a.readInt());
    }

    /* renamed from: k */
    public final void m82134k(b bVar, int i10) throws IOException {
        int i11 = this.f61489a.readInt();
        bVar.mo82118h(i10, i11 & Integer.MAX_VALUE, (this.f61489a.readByte() & 255) + 1, (Integer.MIN_VALUE & i11) != 0);
    }

    /* renamed from: m */
    public final void m82135m(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 5) {
            throw C13656e.m82071d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw C13656e.m82071d("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        m82134k(bVar, i11);
    }

    /* renamed from: n */
    public final void m82136n(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            throw C13656e.m82071d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short s10 = (b10 & 8) != 0 ? (short) (this.f61489a.readByte() & 255) : (short) 0;
        bVar.mo82119i(i11, this.f61489a.readInt() & Integer.MAX_VALUE, m82131g(m82125b(i10 - 4, b10, s10), s10, b10, i11));
    }

    /* renamed from: o */
    public final void m82137o(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 4) {
            throw C13656e.m82071d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw C13656e.m82071d("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i12 = this.f61489a.readInt();
        EnumC13653b enumC13653bM82040b = EnumC13653b.m82040b(i12);
        if (enumC13653bM82040b == null) {
            throw C13656e.m82071d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i12));
        }
        bVar.mo82114d(i11, enumC13653bM82040b);
    }

    /* renamed from: p */
    public final void m82138p(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 != 0) {
            throw C13656e.m82071d("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b10 & 1) != 0) {
            if (i10 != 0) {
                throw C13656e.m82071d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.mo82112a();
            return;
        }
        if (i10 % 6 != 0) {
            throw C13656e.m82071d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
        }
        C13664m c13664m = new C13664m();
        for (int i12 = 0; i12 < i10; i12 += 6) {
            int i13 = this.f61489a.readShort() & 65535;
            int i14 = this.f61489a.readInt();
            if (i13 == 2) {
                if (i14 != 0 && i14 != 1) {
                    throw C13656e.m82071d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (i13 == 3) {
                i13 = 4;
            } else if (i13 != 4) {
                if (i13 == 5 && (i14 < 16384 || i14 > 16777215)) {
                    throw C13656e.m82071d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i14));
                }
            } else {
                if (i14 < 0) {
                    throw C13656e.m82071d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                i13 = 7;
            }
            c13664m.m82197i(i13, i14);
        }
        bVar.mo82115e(false, c13664m);
    }

    /* renamed from: q */
    public final void m82139q(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 4) {
            throw C13656e.m82071d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i10));
        }
        long j10 = this.f61489a.readInt() & 2147483647L;
        if (j10 == 0) {
            throw C13656e.m82071d("windowSizeIncrement was 0", Long.valueOf(j10));
        }
        bVar.mo82116f(i11, j10);
    }
}
