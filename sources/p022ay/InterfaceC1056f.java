package p022ay;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* renamed from: ay.f */
/* loaded from: classes9.dex */
public interface InterfaceC1056f extends InterfaceC1076z, ReadableByteChannel {
    /* renamed from: C0 */
    long mo6315C0() throws IOException;

    /* renamed from: E0 */
    InputStream mo6318E0();

    /* renamed from: L */
    C1054d mo6324L();

    /* renamed from: M */
    boolean mo6325M() throws IOException;

    /* renamed from: O */
    String mo6327O(long j10) throws IOException;

    /* renamed from: S */
    int mo6330S(C1067q c1067q) throws IOException;

    /* renamed from: T */
    String mo6331T(Charset charset) throws IOException;

    /* renamed from: f0 */
    String mo6341f0() throws IOException;

    /* renamed from: l */
    C1057g mo6345l(long j10) throws IOException;

    /* renamed from: l0 */
    byte[] mo6346l0(long j10) throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    void skip(long j10) throws IOException;

    /* renamed from: w0 */
    void mo6357w0(long j10) throws IOException;
}
