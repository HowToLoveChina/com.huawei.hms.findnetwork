package p022ay;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* renamed from: ay.e */
/* loaded from: classes9.dex */
public interface InterfaceC1055e extends InterfaceC1074x, WritableByteChannel {
    /* renamed from: A0 */
    OutputStream mo6312A0();

    /* renamed from: K */
    C1054d mo6323K();

    /* renamed from: N */
    InterfaceC1055e mo6326N() throws IOException;

    /* renamed from: P */
    long mo6328P(InterfaceC1076z interfaceC1076z) throws IOException;

    /* renamed from: R */
    InterfaceC1055e mo6329R(String str) throws IOException;

    /* renamed from: W */
    InterfaceC1055e mo6333W(long j10) throws IOException;

    /* renamed from: a */
    InterfaceC1055e mo6337a(C1057g c1057g) throws IOException;

    @Override // p022ay.InterfaceC1074x, java.io.Flushable
    void flush() throws IOException;

    InterfaceC1055e write(byte[] bArr) throws IOException;

    InterfaceC1055e write(byte[] bArr, int i10, int i11) throws IOException;

    InterfaceC1055e writeByte(int i10) throws IOException;

    InterfaceC1055e writeInt(int i10) throws IOException;

    InterfaceC1055e writeShort(int i10) throws IOException;

    /* renamed from: y0 */
    InterfaceC1055e mo6360y0(long j10) throws IOException;
}
