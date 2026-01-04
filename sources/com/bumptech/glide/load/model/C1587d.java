package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import p214d2.InterfaceC8994h;
import p599r2.C12459b;
import p759x1.C13684i;
import p759x1.EnumC13676a;

/* renamed from: com.bumptech.glide.load.model.d */
/* loaded from: classes.dex */
public final class C1587d<Model, Data> implements InterfaceC1589f<Model, Data> {

    /* renamed from: a */
    public final a<Data> f7010a;

    /* renamed from: com.bumptech.glide.load.model.d$a */
    public interface a<Data> {
        /* renamed from: a */
        Class<Data> mo9086a();

        /* renamed from: b */
        Data mo9087b(String str) throws IllegalArgumentException;

        /* renamed from: c */
        void mo9088c(Data data) throws IOException;
    }

    /* renamed from: com.bumptech.glide.load.model.d$b */
    public static final class b<Data> implements InterfaceC1563d<Data> {

        /* renamed from: a */
        public final String f7011a;

        /* renamed from: b */
        public final a<Data> f7012b;

        /* renamed from: c */
        public Data f7013c;

        public b(String str, a<Data> aVar) {
            this.f7011a = str;
            this.f7012b = aVar;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: a */
        public Class<Data> mo9017a() {
            return this.f7012b.mo9086a();
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: b */
        public void mo9022b() {
            try {
                this.f7012b.mo9088c(this.f7013c);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: d */
        public EnumC13676a mo9024d() {
            return EnumC13676a.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: e */
        public void mo9025e(EnumC1551g enumC1551g, InterfaceC1563d.a<? super Data> aVar) {
            try {
                Data dataMo9087b = this.f7012b.mo9087b(this.f7011a);
                this.f7013c = dataMo9087b;
                aVar.mo9031f(dataMo9087b);
            } catch (IllegalArgumentException e10) {
                aVar.mo9030c(e10);
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.model.d$c */
    public static final class c<Model> implements InterfaceC8994h<Model, InputStream> {

        /* renamed from: a */
        public final a<InputStream> f7014a = new a();

        /* renamed from: com.bumptech.glide.load.model.d$c$a */
        public class a implements a<InputStream> {
            public a() {
            }

            @Override // com.bumptech.glide.load.model.C1587d.a
            /* renamed from: a */
            public Class<InputStream> mo9086a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.C1587d.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void mo9088c(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.model.C1587d.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream mo9087b(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public InterfaceC1589f<Model, InputStream> mo9074b(C1591h c1591h) {
            return new C1587d(this.f7014a);
        }
    }

    public C1587d(a<Data> aVar) {
        this.f7010a = aVar;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: a */
    public boolean mo9070a(Model model) {
        return model.toString().startsWith("data:image");
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: b */
    public InterfaceC1589f.a<Data> mo9071b(Model model, int i10, int i11, C13684i c13684i) {
        return new InterfaceC1589f.a<>(new C12459b(model), new b(model.toString(), this.f7010a));
    }
}
