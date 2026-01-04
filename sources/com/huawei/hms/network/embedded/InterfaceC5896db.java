package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* renamed from: com.huawei.hms.network.embedded.db */
/* loaded from: classes8.dex */
public interface InterfaceC5896db extends InterfaceC6183zb, ReadableByteChannel {
    /* renamed from: a */
    int mo33915a(C6053pb c6053pb) throws IOException;

    /* renamed from: a */
    long mo33917a(byte b10) throws IOException;

    /* renamed from: a */
    long mo33918a(byte b10, long j10) throws IOException;

    /* renamed from: a */
    long mo33919a(byte b10, long j10, long j11) throws IOException;

    /* renamed from: a */
    long mo33920a(C5910eb c5910eb, long j10) throws IOException;

    /* renamed from: a */
    long mo33921a(InterfaceC6170yb interfaceC6170yb) throws IOException;

    @Deprecated
    /* renamed from: a */
    C5868bb mo33924a();

    /* renamed from: a */
    String mo33939a(long j10, Charset charset) throws IOException;

    /* renamed from: a */
    String mo33940a(Charset charset) throws IOException;

    /* renamed from: a */
    void mo33941a(C5868bb c5868bb, long j10) throws IOException;

    /* renamed from: a */
    boolean mo33942a(long j10, C5910eb c5910eb) throws IOException;

    /* renamed from: a */
    boolean mo33943a(long j10, C5910eb c5910eb, int i10, int i11) throws IOException;

    /* renamed from: b */
    long mo33944b(C5910eb c5910eb) throws IOException;

    /* renamed from: b */
    long mo33945b(C5910eb c5910eb, long j10) throws IOException;

    /* renamed from: c */
    long mo33951c(C5910eb c5910eb) throws IOException;

    /* renamed from: d */
    C5910eb mo33957d(long j10) throws IOException;

    /* renamed from: e */
    int mo33959e() throws IOException;

    /* renamed from: e */
    String mo33962e(long j10) throws IOException;

    /* renamed from: f */
    long mo33963f() throws IOException;

    /* renamed from: f */
    String mo33965f(long j10) throws IOException;

    /* renamed from: g */
    C5868bb mo33966g();

    /* renamed from: g */
    byte[] mo33967g(long j10) throws IOException;

    /* renamed from: h */
    int mo33968h() throws IOException;

    /* renamed from: h */
    boolean mo33969h(long j10) throws IOException;

    /* renamed from: i */
    void mo33970i(long j10) throws IOException;

    /* renamed from: i */
    boolean mo33971i() throws IOException;

    /* renamed from: j */
    short mo33973j() throws IOException;

    /* renamed from: k */
    long mo33974k() throws IOException;

    /* renamed from: l */
    String mo33976l() throws IOException;

    /* renamed from: m */
    InputStream mo33977m();

    /* renamed from: n */
    String mo33978n() throws IOException;

    /* renamed from: o */
    String mo33979o() throws IOException;

    /* renamed from: p */
    long mo33980p() throws IOException;

    InterfaceC5896db peek();

    /* renamed from: q */
    byte[] mo33981q() throws IOException;

    /* renamed from: r */
    C5910eb mo33982r() throws IOException;

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int i10, int i11) throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    void skip(long j10) throws IOException;
}
