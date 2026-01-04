package com.huawei.hms.drive;

import java.io.Closeable;
import java.io.InputStream;
import p022ay.C1054d;
import p022ay.InterfaceC1056f;

/* renamed from: com.huawei.hms.drive.bi */
/* loaded from: classes8.dex */
public abstract class AbstractC5204bi implements Closeable {

    /* renamed from: com.huawei.hms.drive.bi$1 */
    public class AnonymousClass1 extends AbstractC5204bi {

        /* renamed from: b */
        final /* synthetic */ long f23971b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC1056f f23972c;

        public AnonymousClass1(long j10, InterfaceC1056f interfaceC1056f) {
            j = j10;
            interfaceC1056f = interfaceC1056f;
        }

        @Override // com.huawei.hms.drive.AbstractC5204bi
        /* renamed from: a */
        public long mo31159a() {
            return j;
        }

        @Override // com.huawei.hms.drive.AbstractC5204bi
        /* renamed from: c */
        public InterfaceC1056f mo31161c() {
            return interfaceC1056f;
        }
    }

    /* renamed from: a */
    public static AbstractC5204bi m31157a(C5197bb c5197bb, long j10, InterfaceC1056f interfaceC1056f) {
        if (interfaceC1056f != null) {
            return new AbstractC5204bi() { // from class: com.huawei.hms.drive.bi.1

                /* renamed from: b */
                final /* synthetic */ long f23971b;

                /* renamed from: c */
                final /* synthetic */ InterfaceC1056f f23972c;

                public AnonymousClass1(long j102, InterfaceC1056f interfaceC1056f2) {
                    j = j102;
                    interfaceC1056f = interfaceC1056f2;
                }

                @Override // com.huawei.hms.drive.AbstractC5204bi
                /* renamed from: a */
                public long mo31159a() {
                    return j;
                }

                @Override // com.huawei.hms.drive.AbstractC5204bi
                /* renamed from: c */
                public InterfaceC1056f mo31161c() {
                    return interfaceC1056f;
                }
            };
        }
        throw new NullPointerException("source == null");
    }

    /* renamed from: a */
    public abstract long mo31159a();

    /* renamed from: b */
    public final InputStream m31160b() {
        return mo31161c().mo6318E0();
    }

    /* renamed from: c */
    public abstract InterfaceC1056f mo31161c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C5210bo.m31191a(mo31161c());
    }

    /* renamed from: a */
    public static AbstractC5204bi m31158a(C5197bb c5197bb, byte[] bArr) {
        return m31157a(c5197bb, bArr.length, new C1054d().write(bArr));
    }
}
