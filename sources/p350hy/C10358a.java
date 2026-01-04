package p350hy;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* renamed from: hy.a */
/* loaded from: classes9.dex */
public final class C10358a implements InterfaceC10359b {

    /* renamed from: c */
    public static final byte[] f50098c = {63};

    /* renamed from: d */
    public static final String f50099d = String.valueOf('?');

    /* renamed from: e */
    public static final char[] f50100e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public final Charset f50101a;

    /* renamed from: b */
    public final boolean f50102b;

    public C10358a(Charset charset, boolean z10) {
        this.f50101a = charset;
        this.f50102b = z10;
    }

    /* renamed from: d */
    public static ByteBuffer m63778d(CharsetEncoder charsetEncoder, CharBuffer charBuffer, ByteBuffer byteBuffer) {
        while (charBuffer.hasRemaining()) {
            if (charsetEncoder.encode(charBuffer, byteBuffer, false).isOverflow()) {
                byteBuffer = AbstractC10361d.m63787d(byteBuffer, m63780f(charsetEncoder, charBuffer.remaining()));
            }
        }
        return byteBuffer;
    }

    /* renamed from: e */
    public static CharBuffer m63779e(CharBuffer charBuffer, char c10) {
        charBuffer.position(0).limit(6);
        charBuffer.put('%');
        charBuffer.put('U');
        char[] cArr = f50100e;
        charBuffer.put(cArr[(c10 >> '\f') & 15]);
        charBuffer.put(cArr[(c10 >> '\b') & 15]);
        charBuffer.put(cArr[(c10 >> 4) & 15]);
        charBuffer.put(cArr[c10 & 15]);
        charBuffer.flip();
        return charBuffer;
    }

    /* renamed from: f */
    public static int m63780f(CharsetEncoder charsetEncoder, int i10) {
        return (int) Math.ceil(i10 * charsetEncoder.averageBytesPerChar());
    }

    /* renamed from: g */
    public static int m63781g(CharsetEncoder charsetEncoder, int i10) {
        return (int) Math.ceil(charsetEncoder.maxBytesPerChar() + ((i10 - 1) * charsetEncoder.averageBytesPerChar()));
    }

    @Override // p350hy.InterfaceC10359b
    /* renamed from: a */
    public String mo62690a(byte[] bArr) throws IOException {
        return m63782h().decode(ByteBuffer.wrap(bArr)).toString();
    }

    @Override // p350hy.InterfaceC10359b
    /* renamed from: b */
    public ByteBuffer mo62691b(String str) {
        CharsetEncoder charsetEncoderM63783i = m63783i();
        CharBuffer charBufferWrap = CharBuffer.wrap(str);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(m63781g(charsetEncoderM63783i, charBufferWrap.remaining()));
        CharBuffer charBufferAllocate = null;
        while (charBufferWrap.hasRemaining()) {
            CoderResult coderResultEncode = charsetEncoderM63783i.encode(charBufferWrap, byteBufferAllocate, false);
            if (!coderResultEncode.isUnmappable() && !coderResultEncode.isMalformed()) {
                if (!coderResultEncode.isOverflow()) {
                    if (coderResultEncode.isUnderflow() || coderResultEncode.isError()) {
                        break;
                    }
                } else {
                    byteBufferAllocate = AbstractC10361d.m63787d(byteBufferAllocate, m63780f(charsetEncoderM63783i, charBufferWrap.remaining()));
                }
            } else {
                if (m63780f(charsetEncoderM63783i, coderResultEncode.length() * 6) > byteBufferAllocate.remaining()) {
                    int i10 = 0;
                    for (int iPosition = charBufferWrap.position(); iPosition < charBufferWrap.limit(); iPosition++) {
                        i10 += !charsetEncoderM63783i.canEncode(charBufferWrap.get(iPosition)) ? 6 : 1;
                    }
                    byteBufferAllocate = AbstractC10361d.m63787d(byteBufferAllocate, m63780f(charsetEncoderM63783i, i10) - byteBufferAllocate.remaining());
                }
                if (charBufferAllocate == null) {
                    charBufferAllocate = CharBuffer.allocate(6);
                }
                for (int i11 = 0; i11 < coderResultEncode.length(); i11++) {
                    byteBufferAllocate = m63778d(charsetEncoderM63783i, m63779e(charBufferAllocate, charBufferWrap.get()), byteBufferAllocate);
                }
            }
        }
        charsetEncoderM63783i.encode(charBufferWrap, byteBufferAllocate, true);
        byteBufferAllocate.limit(byteBufferAllocate.position());
        byteBufferAllocate.rewind();
        return byteBufferAllocate;
    }

    @Override // p350hy.InterfaceC10359b
    /* renamed from: c */
    public boolean mo62692c(String str) {
        return m63783i().canEncode(str);
    }

    /* renamed from: h */
    public final CharsetDecoder m63782h() {
        if (this.f50102b) {
            CharsetDecoder charsetDecoderNewDecoder = this.f50101a.newDecoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
            return charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).replaceWith(f50099d);
        }
        CharsetDecoder charsetDecoderNewDecoder2 = this.f50101a.newDecoder();
        CodingErrorAction codingErrorAction2 = CodingErrorAction.REPORT;
        return charsetDecoderNewDecoder2.onMalformedInput(codingErrorAction2).onUnmappableCharacter(codingErrorAction2);
    }

    /* renamed from: i */
    public final CharsetEncoder m63783i() {
        if (this.f50102b) {
            CharsetEncoder charsetEncoderNewEncoder = this.f50101a.newEncoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
            return charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).replaceWith(f50098c);
        }
        CharsetEncoder charsetEncoderNewEncoder2 = this.f50101a.newEncoder();
        CodingErrorAction codingErrorAction2 = CodingErrorAction.REPORT;
        return charsetEncoderNewEncoder2.onMalformedInput(codingErrorAction2).onUnmappableCharacter(codingErrorAction2);
    }
}
