package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* renamed from: com.huawei.hms.network.embedded.cb */
/* loaded from: classes8.dex */
public interface InterfaceC5882cb extends InterfaceC6170yb, WritableByteChannel {
    /* renamed from: a */
    long mo33922a(InterfaceC6183zb interfaceC6183zb) throws IOException;

    /* renamed from: a */
    C5868bb mo33924a();

    /* renamed from: a */
    InterfaceC5882cb mo33925a(int i10) throws IOException;

    /* renamed from: a */
    InterfaceC5882cb mo33926a(long j10) throws IOException;

    /* renamed from: a */
    InterfaceC5882cb mo33928a(C5910eb c5910eb) throws IOException;

    /* renamed from: a */
    InterfaceC5882cb mo33938a(InterfaceC6183zb interfaceC6183zb, long j10) throws IOException;

    /* renamed from: a */
    InterfaceC5882cb mo33934a(String str) throws IOException;

    /* renamed from: a */
    InterfaceC5882cb mo33935a(String str, int i10, int i11) throws IOException;

    /* renamed from: a */
    InterfaceC5882cb mo33936a(String str, int i10, int i11, Charset charset) throws IOException;

    /* renamed from: a */
    InterfaceC5882cb mo33937a(String str, Charset charset) throws IOException;

    /* renamed from: b */
    InterfaceC5882cb mo33947b(int i10) throws IOException;

    /* renamed from: b */
    InterfaceC5882cb mo33948b(long j10) throws IOException;

    /* renamed from: b */
    OutputStream mo33950b();

    /* renamed from: c */
    InterfaceC5882cb mo33954c() throws IOException;

    /* renamed from: c */
    InterfaceC5882cb mo33952c(int i10) throws IOException;

    /* renamed from: c */
    InterfaceC5882cb mo33953c(long j10) throws IOException;

    /* renamed from: d */
    InterfaceC5882cb mo33955d() throws IOException;

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
    void flush() throws IOException;

    InterfaceC5882cb write(byte[] bArr) throws IOException;

    InterfaceC5882cb write(byte[] bArr, int i10, int i11) throws IOException;

    InterfaceC5882cb writeByte(int i10) throws IOException;

    InterfaceC5882cb writeInt(int i10) throws IOException;

    InterfaceC5882cb writeLong(long j10) throws IOException;

    InterfaceC5882cb writeShort(int i10) throws IOException;
}
