package com.bumptech.glide.load.model;

import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import p214d2.InterfaceC8994h;
import p599r2.C12459b;
import p759x1.C13684i;
import p759x1.EnumC13676a;

/* renamed from: com.bumptech.glide.load.model.b */
/* loaded from: classes.dex */
public class C1585b<Data> implements InterfaceC1589f<byte[], Data> {

    /* renamed from: a */
    public final b<Data> f7004a;

    /* renamed from: com.bumptech.glide.load.model.b$a */
    public static class a implements InterfaceC8994h<byte[], ByteBuffer> {

        /* renamed from: com.bumptech.glide.load.model.b$a$a, reason: collision with other inner class name */
        public class C14417a implements b<ByteBuffer> {
            public C14417a() {
            }

            @Override // com.bumptech.glide.load.model.C1585b.b
            /* renamed from: a */
            public Class<ByteBuffer> mo9080a() {
                return ByteBuffer.class;
            }

            @Override // com.bumptech.glide.load.model.C1585b.b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer mo9081b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<byte[], ByteBuffer> mo9074b(C1591h c1591h) {
            return new C1585b(new C14417a());
        }
    }

    /* renamed from: com.bumptech.glide.load.model.b$b */
    public interface b<Data> {
        /* renamed from: a */
        Class<Data> mo9080a();

        /* renamed from: b */
        Data mo9081b(byte[] bArr);
    }

    /* renamed from: com.bumptech.glide.load.model.b$c */
    public static class c<Data> implements InterfaceC1563d<Data> {

        /* renamed from: a */
        public final byte[] f7006a;

        /* renamed from: b */
        public final b<Data> f7007b;

        public c(byte[] bArr, b<Data> bVar) {
            this.f7006a = bArr;
            this.f7007b = bVar;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: a */
        public Class<Data> mo9017a() {
            return this.f7007b.mo9080a();
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: b */
        public void mo9022b() {
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: d */
        public EnumC13676a mo9024d() {
            return EnumC13676a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: e */
        public void mo9025e(EnumC1551g enumC1551g, InterfaceC1563d.a<? super Data> aVar) {
            aVar.mo9031f(this.f7007b.mo9081b(this.f7006a));
        }
    }

    /* renamed from: com.bumptech.glide.load.model.b$d */
    public static class d implements InterfaceC8994h<byte[], InputStream> {

        /* renamed from: com.bumptech.glide.load.model.b$d$a */
        public class a implements b<InputStream> {
            public a() {
            }

            @Override // com.bumptech.glide.load.model.C1585b.b
            /* renamed from: a */
            public Class<InputStream> mo9080a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.C1585b.b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream mo9081b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<byte[], InputStream> mo9074b(C1591h c1591h) {
            return new C1585b(new a());
        }
    }

    public C1585b(b<Data> bVar) {
        this.f7004a = bVar;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1589f.a<Data> mo9071b(byte[] bArr, int i10, int i11, C13684i c13684i) {
        return new InterfaceC1589f.a<>(new C12459b(bArr), new c(bArr, this.f7004a));
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9070a(byte[] bArr) {
        return true;
    }
}
