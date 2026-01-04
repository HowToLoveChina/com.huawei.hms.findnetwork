package com.huawei.hms.drive;

import com.huawei.hms.drive.C5248cy;
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

/* renamed from: com.huawei.hms.drive.dc */
/* loaded from: classes8.dex */
final class C5254dc implements Closeable {

    /* renamed from: a */
    static final Logger f24393a = Logger.getLogger(C5249cz.class.getName());

    /* renamed from: b */
    final C5248cy.a f24394b;

    /* renamed from: c */
    private final InterfaceC1056f f24395c;

    /* renamed from: d */
    private final a f24396d;

    /* renamed from: e */
    private final boolean f24397e;

    /* renamed from: com.huawei.hms.drive.dc$a */
    public static final class a implements InterfaceC1076z {

        /* renamed from: a */
        int f24398a;

        /* renamed from: b */
        byte f24399b;

        /* renamed from: c */
        int f24400c;

        /* renamed from: d */
        int f24401d;

        /* renamed from: e */
        short f24402e;

        /* renamed from: f */
        private final InterfaceC1056f f24403f;

        public a(InterfaceC1056f interfaceC1056f) {
            this.f24403f = interfaceC1056f;
        }

        /* renamed from: a */
        private void m31580a() throws IOException {
            int i10 = this.f24400c;
            int iM31566a = C5254dc.m31566a(this.f24403f);
            this.f24401d = iM31566a;
            this.f24398a = iM31566a;
            byte b10 = (byte) (this.f24403f.readByte() & 255);
            this.f24399b = (byte) (this.f24403f.readByte() & 255);
            Logger logger = C5254dc.f24393a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C5249cz.m31485a(true, this.f24400c, this.f24398a, b10, this.f24399b));
            }
            int i11 = this.f24403f.readInt() & Integer.MAX_VALUE;
            this.f24400c = i11;
            if (b10 != 9) {
                throw C5249cz.m31486b("%s != TYPE_CONTINUATION", Byte.valueOf(b10));
            }
            if (i11 != i10) {
                throw C5249cz.m31486b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            while (true) {
                int i10 = this.f24401d;
                if (i10 != 0) {
                    long j11 = this.f24403f.read(c1054d, Math.min(j10, i10));
                    if (j11 == -1) {
                        return -1L;
                    }
                    this.f24401d = (int) (this.f24401d - j11);
                    return j11;
                }
                this.f24403f.skip(this.f24402e);
                this.f24402e = (short) 0;
                if ((this.f24399b & 4) != 0) {
                    return -1L;
                }
                m31580a();
            }
        }

        @Override // p022ay.InterfaceC1076z
        public C1050a0 timeout() {
            return this.f24403f.timeout();
        }
    }

    /* renamed from: com.huawei.hms.drive.dc$b */
    public interface b {
        /* renamed from: a */
        void mo31552a();

        /* renamed from: a */
        void mo31553a(int i10, int i11, int i12, boolean z10);

        /* renamed from: a */
        void mo31554a(int i10, int i11, List<C5247cx> list) throws IOException;

        /* renamed from: a */
        void mo31555a(int i10, long j10);

        /* renamed from: a */
        void mo31556a(int i10, EnumC5246cw enumC5246cw);

        /* renamed from: a */
        void mo31557a(int i10, EnumC5246cw enumC5246cw, C1057g c1057g);

        /* renamed from: a */
        void mo31558a(boolean z10, int i10, int i11);

        /* renamed from: a */
        void mo31559a(boolean z10, int i10, int i11, List<C5247cx> list);

        /* renamed from: a */
        void mo31560a(boolean z10, int i10, InterfaceC1056f interfaceC1056f, int i11) throws IOException;

        /* renamed from: a */
        void mo31561a(boolean z10, C5259dh c5259dh);
    }

    public C5254dc(InterfaceC1056f interfaceC1056f, boolean z10) {
        this.f24395c = interfaceC1056f;
        this.f24397e = z10;
        a aVar = new a(interfaceC1056f);
        this.f24396d = aVar;
        this.f24394b = new C5248cy.a(4096, aVar);
    }

    /* renamed from: b */
    private void m31570b(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            throw C5249cz.m31486b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z10 = (b10 & 1) != 0;
        if ((b10 & 32) != 0) {
            throw C5249cz.m31486b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short s10 = (b10 & 8) != 0 ? (short) (this.f24395c.readByte() & 255) : (short) 0;
        bVar.mo31560a(z10, i11, this.f24395c, m31565a(i10, b10, s10));
        this.f24395c.skip(s10);
    }

    /* renamed from: c */
    private void m31571c(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 5) {
            throw C5249cz.m31486b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw C5249cz.m31486b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        m31568a(bVar, i11);
    }

    /* renamed from: d */
    private void m31572d(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 4) {
            throw C5249cz.m31486b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw C5249cz.m31486b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i12 = this.f24395c.readInt();
        EnumC5246cw enumC5246cwM31455a = EnumC5246cw.m31455a(i12);
        if (enumC5246cwM31455a == null) {
            throw C5249cz.m31486b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i12));
        }
        bVar.mo31556a(i11, enumC5246cwM31455a);
    }

    /* renamed from: e */
    private void m31573e(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 != 0) {
            throw C5249cz.m31486b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b10 & 1) != 0) {
            if (i10 != 0) {
                throw C5249cz.m31486b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.mo31552a();
            return;
        }
        if (i10 % 6 != 0) {
            throw C5249cz.m31486b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
        }
        C5259dh c5259dh = new C5259dh();
        for (int i12 = 0; i12 < i10; i12 += 6) {
            int i13 = this.f24395c.readShort() & 65535;
            int i14 = this.f24395c.readInt();
            if (i13 == 2) {
                if (i14 != 0 && i14 != 1) {
                    throw C5249cz.m31486b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (i13 == 3) {
                i13 = 4;
            } else if (i13 != 4) {
                if (i13 == 5 && (i14 < 16384 || i14 > 16777215)) {
                    throw C5249cz.m31486b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i14));
                }
            } else {
                if (i14 < 0) {
                    throw C5249cz.m31486b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                i13 = 7;
            }
            c5259dh.m31630a(i13, i14);
        }
        bVar.mo31561a(false, c5259dh);
    }

    /* renamed from: f */
    private void m31574f(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            throw C5249cz.m31486b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short s10 = (b10 & 8) != 0 ? (short) (this.f24395c.readByte() & 255) : (short) 0;
        bVar.mo31554a(i11, this.f24395c.readInt() & Integer.MAX_VALUE, m31567a(m31565a(i10 - 4, b10, s10), s10, b10, i11));
    }

    /* renamed from: g */
    private void m31575g(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 8) {
            throw C5249cz.m31486b("TYPE_PING length != 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw C5249cz.m31486b("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.mo31558a((b10 & 1) != 0, this.f24395c.readInt(), this.f24395c.readInt());
    }

    /* renamed from: h */
    private void m31576h(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 < 8) {
            throw C5249cz.m31486b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw C5249cz.m31486b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i12 = this.f24395c.readInt();
        int i13 = this.f24395c.readInt();
        int i14 = i10 - 8;
        EnumC5246cw enumC5246cwM31455a = EnumC5246cw.m31455a(i13);
        if (enumC5246cwM31455a == null) {
            throw C5249cz.m31486b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i13));
        }
        C1057g c1057gMo6345l = C1057g.f5136e;
        if (i14 > 0) {
            c1057gMo6345l = this.f24395c.mo6345l(i14);
        }
        bVar.mo31557a(i12, enumC5246cwM31455a, c1057gMo6345l);
    }

    /* renamed from: i */
    private void m31577i(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 4) {
            throw C5249cz.m31486b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i10));
        }
        long j10 = this.f24395c.readInt() & 2147483647L;
        if (j10 == 0) {
            throw C5249cz.m31486b("windowSizeIncrement was 0", Long.valueOf(j10));
        }
        bVar.mo31555a(i11, j10);
    }

    /* renamed from: a */
    public void m31578a(b bVar) throws IOException {
        if (this.f24397e) {
            if (!m31579a(true, bVar)) {
                throw C5249cz.m31486b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        InterfaceC1056f interfaceC1056f = this.f24395c;
        C1057g c1057g = C5249cz.f24297a;
        C1057g c1057gMo6345l = interfaceC1056f.mo6345l(c1057g.m6370E());
        Logger logger = f24393a;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C5210bo.m31181a("<< CONNECTION %s", c1057gMo6345l.mo6384u()));
        }
        if (!c1057g.equals(c1057gMo6345l)) {
            throw C5249cz.m31486b("Expected a connection header but was %s", c1057gMo6345l.m6374I());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f24395c.close();
    }

    /* renamed from: a */
    public boolean m31579a(boolean z10, b bVar) throws IOException {
        try {
            this.f24395c.mo6357w0(9L);
            int iM31566a = m31566a(this.f24395c);
            if (iM31566a >= 0 && iM31566a <= 16384) {
                byte b10 = (byte) (this.f24395c.readByte() & 255);
                if (z10 && b10 != 4) {
                    throw C5249cz.m31486b("Expected a SETTINGS frame but was %s", Byte.valueOf(b10));
                }
                byte b11 = (byte) (this.f24395c.readByte() & 255);
                int i10 = this.f24395c.readInt() & Integer.MAX_VALUE;
                Logger logger = f24393a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(C5249cz.m31485a(true, i10, iM31566a, b10, b11));
                }
                switch (b10) {
                    case 0:
                        m31570b(bVar, iM31566a, b11, i10);
                        return true;
                    case 1:
                        m31569a(bVar, iM31566a, b11, i10);
                        return true;
                    case 2:
                        m31571c(bVar, iM31566a, b11, i10);
                        return true;
                    case 3:
                        m31572d(bVar, iM31566a, b11, i10);
                        return true;
                    case 4:
                        m31573e(bVar, iM31566a, b11, i10);
                        return true;
                    case 5:
                        m31574f(bVar, iM31566a, b11, i10);
                        return true;
                    case 6:
                        m31575g(bVar, iM31566a, b11, i10);
                        return true;
                    case 7:
                        m31576h(bVar, iM31566a, b11, i10);
                        return true;
                    case 8:
                        m31577i(bVar, iM31566a, b11, i10);
                        return true;
                    default:
                        this.f24395c.skip(iM31566a);
                        return true;
                }
            }
            throw C5249cz.m31486b("FRAME_SIZE_ERROR: %s", Integer.valueOf(iM31566a));
        } catch (EOFException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m31569a(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 != 0) {
            boolean z10 = (b10 & 1) != 0;
            short s10 = (b10 & 8) != 0 ? (short) (this.f24395c.readByte() & 255) : (short) 0;
            if ((b10 & 32) != 0) {
                m31568a(bVar, i11);
                i10 -= 5;
            }
            bVar.mo31559a(z10, i11, -1, m31567a(m31565a(i10, b10, s10), s10, b10, i11));
            return;
        }
        throw C5249cz.m31486b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    /* renamed from: a */
    private List<C5247cx> m31567a(int i10, short s10, byte b10, int i11) throws IOException {
        a aVar = this.f24396d;
        aVar.f24401d = i10;
        aVar.f24398a = i10;
        aVar.f24402e = s10;
        aVar.f24399b = b10;
        aVar.f24400c = i11;
        this.f24394b.m31472a();
        return this.f24394b.m31473b();
    }

    /* renamed from: a */
    private void m31568a(b bVar, int i10) throws IOException {
        int i11 = this.f24395c.readInt();
        bVar.mo31553a(i10, i11 & Integer.MAX_VALUE, (this.f24395c.readByte() & 255) + 1, (Integer.MIN_VALUE & i11) != 0);
    }

    /* renamed from: a */
    public static int m31566a(InterfaceC1056f interfaceC1056f) throws IOException {
        return (interfaceC1056f.readByte() & 255) | ((interfaceC1056f.readByte() & 255) << 16) | ((interfaceC1056f.readByte() & 255) << 8);
    }

    /* renamed from: a */
    public static int m31565a(int i10, byte b10, short s10) throws IOException {
        if ((b10 & 8) != 0) {
            i10--;
        }
        if (s10 <= i10) {
            return (short) (i10 - s10);
        }
        throw C5249cz.m31486b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s10), Integer.valueOf(i10));
    }
}
