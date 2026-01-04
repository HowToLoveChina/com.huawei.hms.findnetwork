package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C6103t9;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.huawei.hms.network.embedded.x9 */
/* loaded from: classes8.dex */
public final class C6155x9 implements Closeable {

    /* renamed from: e */
    public static final Logger f29077e = Logger.getLogger(C6116u9.class.getName());

    /* renamed from: a */
    public final InterfaceC5896db f29078a;

    /* renamed from: b */
    public final a f29079b;

    /* renamed from: c */
    public final boolean f29080c;

    /* renamed from: d */
    public final C6103t9.a f29081d;

    /* renamed from: com.huawei.hms.network.embedded.x9$a */
    public static final class a implements InterfaceC6183zb {

        /* renamed from: a */
        public final InterfaceC5896db f29082a;

        /* renamed from: b */
        public int f29083b;

        /* renamed from: c */
        public byte f29084c;

        /* renamed from: d */
        public int f29085d;

        /* renamed from: e */
        public int f29086e;

        /* renamed from: f */
        public short f29087f;

        public a(InterfaceC5896db interfaceC5896db) {
            this.f29082a = interfaceC5896db;
        }

        /* renamed from: b */
        private void m35806b() throws IOException {
            int i10 = this.f29085d;
            int iM35792a = C6155x9.m35792a(this.f29082a);
            this.f29086e = iM35792a;
            this.f29083b = iM35792a;
            byte b10 = (byte) (this.f29082a.readByte() & 255);
            this.f29084c = (byte) (this.f29082a.readByte() & 255);
            Logger logger = C6155x9.f29077e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C6116u9.m35513a(true, this.f29085d, this.f29083b, b10, this.f29084c));
            }
            int i11 = this.f29082a.readInt() & Integer.MAX_VALUE;
            this.f29085d = i11;
            if (b10 != 9) {
                throw C6116u9.m35514b("%s != TYPE_CONTINUATION", Byte.valueOf(b10));
            }
            if (i11 != i10) {
                throw C6116u9.m35514b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
        public void close() throws IOException {
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
        public long read(C5868bb c5868bb, long j10) throws IOException {
            while (true) {
                int i10 = this.f29086e;
                if (i10 != 0) {
                    long j11 = this.f29082a.read(c5868bb, Math.min(j10, i10));
                    if (j11 == -1) {
                        return -1L;
                    }
                    this.f29086e = (int) (this.f29086e - j11);
                    return j11;
                }
                this.f29082a.skip(this.f29087f);
                this.f29087f = (short) 0;
                if ((this.f29084c & 4) != 0) {
                    return -1L;
                }
                m35806b();
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return this.f29082a.timeout();
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.x9$b */
    public interface b {
        /* renamed from: a */
        void mo35684a();

        /* renamed from: a */
        void mo35685a(int i10, int i11, int i12, boolean z10);

        /* renamed from: a */
        void mo35686a(int i10, int i11, List<C6090s9> list) throws IOException;

        /* renamed from: a */
        void mo35687a(int i10, long j10);

        /* renamed from: a */
        void mo35688a(int i10, EnumC6077r9 enumC6077r9);

        /* renamed from: a */
        void mo35689a(int i10, EnumC6077r9 enumC6077r9, C5910eb c5910eb);

        /* renamed from: a */
        void mo35690a(int i10, String str, C5910eb c5910eb, String str2, int i11, long j10);

        /* renamed from: a */
        void mo35691a(boolean z10, int i10, int i11);

        /* renamed from: a */
        void mo35692a(boolean z10, int i10, int i11, List<C6090s9> list);

        /* renamed from: a */
        void mo35693a(boolean z10, int i10, InterfaceC5896db interfaceC5896db, int i11) throws IOException;

        /* renamed from: a */
        void mo35694a(boolean z10, C5881ca c5881ca);
    }

    public C6155x9(InterfaceC5896db interfaceC5896db, boolean z10) {
        this.f29078a = interfaceC5896db;
        this.f29080c = z10;
        a aVar = new a(interfaceC5896db);
        this.f29079b = aVar;
        this.f29081d = new C6103t9.a(4096, aVar);
    }

    /* renamed from: a */
    public static int m35791a(int i10, byte b10, short s10) throws IOException {
        if ((b10 & 8) != 0) {
            i10--;
        }
        if (s10 <= i10) {
            return (short) (i10 - s10);
        }
        throw C6116u9.m35514b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s10), Integer.valueOf(i10));
    }

    /* renamed from: b */
    private void m35796b(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 < 8) {
            throw C6116u9.m35514b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw C6116u9.m35514b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i12 = this.f29078a.readInt();
        int i13 = this.f29078a.readInt();
        int i14 = i10 - 8;
        EnumC6077r9 enumC6077r9M35230a = EnumC6077r9.m35230a(i13);
        if (enumC6077r9M35230a == null) {
            throw C6116u9.m35514b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i13));
        }
        C5910eb c5910ebMo33957d = C5910eb.f26711f;
        if (i14 > 0) {
            c5910ebMo33957d = this.f29078a.mo33957d(i14);
        }
        bVar.mo35689a(i12, enumC6077r9M35230a, c5910ebMo33957d);
    }

    /* renamed from: c */
    private void m35797c(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            throw C6116u9.m35514b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z10 = (b10 & 1) != 0;
        short s10 = (b10 & 8) != 0 ? (short) (this.f29078a.readByte() & 255) : (short) 0;
        if ((b10 & 32) != 0) {
            m35794a(bVar, i11);
            i10 -= 5;
        }
        bVar.mo35692a(z10, i11, -1, m35793a(m35791a(i10, b10, s10), s10, b10, i11));
    }

    /* renamed from: d */
    private void m35798d(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 8) {
            throw C6116u9.m35514b("TYPE_PING length != 8: %s", Integer.valueOf(i10));
        }
        if (i11 != 0) {
            throw C6116u9.m35514b("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.mo35691a((b10 & 1) != 0, this.f29078a.readInt(), this.f29078a.readInt());
    }

    /* renamed from: e */
    private void m35799e(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 5) {
            throw C6116u9.m35514b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw C6116u9.m35514b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        m35794a(bVar, i11);
    }

    /* renamed from: f */
    private void m35800f(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 == 0) {
            throw C6116u9.m35514b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short s10 = (b10 & 8) != 0 ? (short) (this.f29078a.readByte() & 255) : (short) 0;
        bVar.mo35686a(i11, this.f29078a.readInt() & Integer.MAX_VALUE, m35793a(m35791a(i10 - 4, b10, s10), s10, b10, i11));
    }

    /* renamed from: g */
    private void m35801g(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 4) {
            throw C6116u9.m35514b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i10));
        }
        if (i11 == 0) {
            throw C6116u9.m35514b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i12 = this.f29078a.readInt();
        EnumC6077r9 enumC6077r9M35230a = EnumC6077r9.m35230a(i12);
        if (enumC6077r9M35230a == null) {
            throw C6116u9.m35514b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i12));
        }
        bVar.mo35688a(i11, enumC6077r9M35230a);
    }

    /* renamed from: h */
    private void m35802h(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 != 0) {
            throw C6116u9.m35514b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b10 & 1) != 0) {
            if (i10 != 0) {
                throw C6116u9.m35514b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.mo35684a();
            return;
        }
        if (i10 % 6 != 0) {
            throw C6116u9.m35514b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
        }
        C5881ca c5881ca = new C5881ca();
        for (int i12 = 0; i12 < i10; i12 += 6) {
            int i13 = this.f29078a.readShort() & 65535;
            int i14 = this.f29078a.readInt();
            if (i13 == 2) {
                if (i14 != 0 && i14 != 1) {
                    throw C6116u9.m35514b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (i13 == 3) {
                i13 = 4;
            } else if (i13 != 4) {
                if (i13 == 5 && (i14 < 16384 || i14 > 16777215)) {
                    throw C6116u9.m35514b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i14));
                }
            } else {
                if (i14 < 0) {
                    throw C6116u9.m35514b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                i13 = 7;
            }
            c5881ca.m34074a(i13, i14);
        }
        bVar.mo35694a(false, c5881ca);
    }

    /* renamed from: i */
    private void m35803i(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i10 != 4) {
            throw C6116u9.m35514b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i10));
        }
        long j10 = this.f29078a.readInt() & 2147483647L;
        if (j10 == 0) {
            throw C6116u9.m35514b("windowSizeIncrement was 0", Long.valueOf(j10));
        }
        bVar.mo35687a(i11, j10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29078a.close();
    }

    /* renamed from: a */
    public static int m35792a(InterfaceC5896db interfaceC5896db) throws IOException {
        return (interfaceC5896db.readByte() & 255) | ((interfaceC5896db.readByte() & 255) << 16) | ((interfaceC5896db.readByte() & 255) << 8);
    }

    /* renamed from: a */
    private List<C6090s9> m35793a(int i10, short s10, byte b10, int i11) throws IOException {
        a aVar = this.f29079b;
        aVar.f29086e = i10;
        aVar.f29083b = i10;
        aVar.f29087f = s10;
        aVar.f29084c = b10;
        aVar.f29085d = i11;
        this.f29081d.m35465d();
        return this.f29081d.m35462a();
    }

    /* renamed from: a */
    public void m35804a(b bVar) throws IOException {
        if (this.f29080c) {
            if (!m35805a(true, bVar)) {
                throw C6116u9.m35514b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        InterfaceC5896db interfaceC5896db = this.f29078a;
        C5910eb c5910eb = C6116u9.f28524a;
        C5910eb c5910ebMo33957d = interfaceC5896db.mo33957d(c5910eb.mo34192j());
        Logger logger = f29077e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C5920f8.m34236a("<< CONNECTION %s", c5910ebMo33957d.mo34181d()));
        }
        if (!c5910eb.equals(c5910ebMo33957d)) {
            throw C6116u9.m35514b("Expected a connection header but was %s", c5910ebMo33957d.mo34196n());
        }
    }

    /* renamed from: a */
    private void m35794a(b bVar, int i10) throws IOException {
        int i11 = this.f29078a.readInt();
        bVar.mo35685a(i10, i11 & Integer.MAX_VALUE, (this.f29078a.readByte() & 255) + 1, (Integer.MIN_VALUE & i11) != 0);
    }

    /* renamed from: a */
    private void m35795a(b bVar, int i10, byte b10, int i11) throws IOException {
        if (i11 != 0) {
            boolean z10 = (b10 & 1) != 0;
            if ((b10 & 32) != 0) {
                throw C6116u9.m35514b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            short s10 = (b10 & 8) != 0 ? (short) (this.f29078a.readByte() & 255) : (short) 0;
            bVar.mo35693a(z10, i11, this.f29078a, m35791a(i10, b10, s10));
            this.f29078a.skip(s10);
            return;
        }
        throw C6116u9.m35514b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    /* renamed from: a */
    public boolean m35805a(boolean z10, b bVar) throws IOException {
        try {
            this.f29078a.mo33970i(9L);
            int iM35792a = m35792a(this.f29078a);
            if (iM35792a < 0 || iM35792a > 16384) {
                throw C6116u9.m35514b("FRAME_SIZE_ERROR: %s", Integer.valueOf(iM35792a));
            }
            byte b10 = (byte) (this.f29078a.readByte() & 255);
            if (z10 && b10 != 4) {
                throw C6116u9.m35514b("Expected a SETTINGS frame but was %s", Byte.valueOf(b10));
            }
            byte b11 = (byte) (this.f29078a.readByte() & 255);
            int i10 = this.f29078a.readInt() & Integer.MAX_VALUE;
            Logger logger = f29077e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C6116u9.m35513a(true, i10, iM35792a, b10, b11));
            }
            switch (b10) {
                case 0:
                    m35795a(bVar, iM35792a, b11, i10);
                    return true;
                case 1:
                    m35797c(bVar, iM35792a, b11, i10);
                    return true;
                case 2:
                    m35799e(bVar, iM35792a, b11, i10);
                    return true;
                case 3:
                    m35801g(bVar, iM35792a, b11, i10);
                    return true;
                case 4:
                    m35802h(bVar, iM35792a, b11, i10);
                    return true;
                case 5:
                    m35800f(bVar, iM35792a, b11, i10);
                    return true;
                case 6:
                    m35798d(bVar, iM35792a, b11, i10);
                    return true;
                case 7:
                    m35796b(bVar, iM35792a, b11, i10);
                    return true;
                case 8:
                    m35803i(bVar, iM35792a, b11, i10);
                    return true;
                default:
                    this.f29078a.skip(iM35792a);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }
}
