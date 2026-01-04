package com.huawei.hms.framework.network.restclient.hwhttp.trans;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes8.dex */
public class ByteString implements Comparable<ByteString> {
    private com.huawei.hms.network.base.common.trans.ByteString proxyByteString;

    public ByteString(byte[] bArr) {
        this.proxyByteString = new com.huawei.hms.network.base.common.trans.ByteString(bArr);
    }

    public static ByteString decodeBase64(String str) {
        com.huawei.hms.network.base.common.trans.ByteString byteStringDecodeBase64 = com.huawei.hms.network.base.common.trans.ByteString.decodeBase64(str);
        if (byteStringDecodeBase64 != null) {
            return new ByteString(byteStringDecodeBase64.toByteArray());
        }
        return null;
    }

    public static ByteString decodeHex(String str) {
        return new ByteString(com.huawei.hms.network.base.common.trans.ByteString.decodeHex(str).toByteArray());
    }

    public static ByteString encodeString(String str, Charset charset) {
        return new ByteString(com.huawei.hms.network.base.common.trans.ByteString.encodeString(str, charset).toByteArray());
    }

    public static ByteString encodeUtf8(String str) {
        return new ByteString(com.huawei.hms.network.base.common.trans.ByteString.encodeUtf8(str).toByteArray());
    }

    /* renamed from: of */
    public static ByteString m32417of(byte... bArr) {
        return new ByteString(com.huawei.hms.network.base.common.trans.ByteString.m33654of(bArr).toByteArray());
    }

    public static ByteString read(InputStream inputStream, int i10) throws IOException {
        return new ByteString(com.huawei.hms.network.base.common.trans.ByteString.read(inputStream, i10).toByteArray());
    }

    public ByteBuffer asByteBuffer() {
        return this.proxyByteString.asByteBuffer();
    }

    public String base64() {
        return this.proxyByteString.base64();
    }

    public String base64Url() {
        return this.proxyByteString.base64Url();
    }

    public final boolean endsWith(ByteString byteString) {
        return this.proxyByteString.endsWith(byteString.proxyByteString);
    }

    public boolean equals(Object obj) {
        return this.proxyByteString.equals(obj);
    }

    public byte getByte(int i10) {
        return this.proxyByteString.getByte(i10);
    }

    public int hashCode() {
        return this.proxyByteString.hashCode();
    }

    public String hex() {
        return this.proxyByteString.hex();
    }

    public ByteString hmacSha1(ByteString byteString) {
        return new ByteString(this.proxyByteString.hmacSha1(byteString.proxyByteString).toByteArray());
    }

    public ByteString hmacSha256(ByteString byteString) {
        return new ByteString(this.proxyByteString.hmacSha256(byteString.proxyByteString).toByteArray());
    }

    public ByteString hmacSha512(ByteString byteString) {
        return new ByteString(this.proxyByteString.hmacSha512(byteString.proxyByteString).toByteArray());
    }

    public final int indexOf(ByteString byteString) {
        return this.proxyByteString.indexOf(byteString.proxyByteString);
    }

    public final int lastIndexOf(ByteString byteString) {
        return this.proxyByteString.lastIndexOf(byteString.proxyByteString);
    }

    public ByteString md5() {
        return new ByteString(this.proxyByteString.md5().toByteArray());
    }

    public boolean rangeEquals(int i10, ByteString byteString, int i11, int i12) {
        return this.proxyByteString.rangeEquals(i10, byteString.proxyByteString, i11, i12);
    }

    public ByteString sha1() {
        return new ByteString(this.proxyByteString.sha1().toByteArray());
    }

    public ByteString sha256() {
        return new ByteString(this.proxyByteString.sha256().toByteArray());
    }

    public ByteString sha512() {
        return new ByteString(this.proxyByteString.sha512().toByteArray());
    }

    public int size() {
        return this.proxyByteString.size();
    }

    public final boolean startsWith(ByteString byteString) {
        return this.proxyByteString.startsWith(byteString.proxyByteString);
    }

    public String string(Charset charset) {
        return this.proxyByteString.string(charset);
    }

    public ByteString substring(int i10) {
        return new ByteString(this.proxyByteString.substring(i10).toByteArray());
    }

    public ByteString toAsciiLowercase() {
        return new ByteString(this.proxyByteString.toAsciiLowercase().toByteArray());
    }

    public ByteString toAsciiUppercase() {
        return new ByteString(this.proxyByteString.toAsciiUppercase().toByteArray());
    }

    public byte[] toByteArray() {
        return this.proxyByteString.toByteArray();
    }

    public String toString() {
        return this.proxyByteString.toString();
    }

    public String utf8() {
        return this.proxyByteString.utf8();
    }

    public void write(OutputStream outputStream) throws IOException {
        this.proxyByteString.write(outputStream);
    }

    /* renamed from: of */
    public static ByteString m32418of(byte[] bArr, int i10, int i11) {
        return new ByteString(com.huawei.hms.network.base.common.trans.ByteString.m33655of(bArr, i10, i11).toByteArray());
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteString byteString) {
        return this.proxyByteString.compareTo(byteString.proxyByteString);
    }

    public final boolean endsWith(byte[] bArr) {
        return this.proxyByteString.endsWith(bArr);
    }

    public final int indexOf(ByteString byteString, int i10) {
        return this.proxyByteString.indexOf(byteString.proxyByteString, i10);
    }

    public final int lastIndexOf(ByteString byteString, int i10) {
        return this.proxyByteString.lastIndexOf(byteString.proxyByteString, i10);
    }

    public boolean rangeEquals(int i10, byte[] bArr, int i11, int i12) {
        return this.proxyByteString.rangeEquals(i10, bArr, i11, i12);
    }

    public final boolean startsWith(byte[] bArr) {
        return this.proxyByteString.startsWith(bArr);
    }

    public ByteString substring(int i10, int i11) {
        return new ByteString(this.proxyByteString.substring(i10, i11).toByteArray());
    }

    public final int indexOf(byte[] bArr) {
        return this.proxyByteString.indexOf(bArr);
    }

    public final int lastIndexOf(byte[] bArr) {
        return this.proxyByteString.lastIndexOf(bArr);
    }

    /* renamed from: of */
    public static ByteString m32416of(ByteBuffer byteBuffer) {
        return new ByteString(com.huawei.hms.network.base.common.trans.ByteString.m33653of(byteBuffer).toByteArray());
    }

    public int indexOf(byte[] bArr, int i10) {
        return this.proxyByteString.indexOf(bArr, i10);
    }

    public int lastIndexOf(byte[] bArr, int i10) {
        return this.proxyByteString.lastIndexOf(bArr, i10);
    }
}
