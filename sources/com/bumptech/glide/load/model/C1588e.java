package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.model.InterfaceC1589f;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import p214d2.InterfaceC8994h;
import p599r2.C12459b;
import p759x1.C13684i;
import p759x1.EnumC13676a;

/* renamed from: com.bumptech.glide.load.model.e */
/* loaded from: classes.dex */
public class C1588e<Data> implements InterfaceC1589f<File, Data> {

    /* renamed from: a */
    public final d<Data> f7016a;

    /* renamed from: com.bumptech.glide.load.model.e$a */
    public static class a<Data> implements InterfaceC8994h<File, Data> {

        /* renamed from: a */
        public final d<Data> f7017a;

        public a(d<Data> dVar) {
            this.f7017a = dVar;
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public final InterfaceC1589f<File, Data> mo9074b(C1591h c1591h) {
            return new C1588e(this.f7017a);
        }
    }

    /* renamed from: com.bumptech.glide.load.model.e$b */
    public static class b extends a<ParcelFileDescriptor> {

        /* renamed from: com.bumptech.glide.load.model.e$b$a */
        public class a implements d<ParcelFileDescriptor> {
            @Override // com.bumptech.glide.load.model.C1588e.d
            /* renamed from: a */
            public Class<ParcelFileDescriptor> mo9093a() {
                return ParcelFileDescriptor.class;
            }

            @Override // com.bumptech.glide.load.model.C1588e.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void mo9095c(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // com.bumptech.glide.load.model.C1588e.d
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor mo9094b(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
        }

        public b() {
            super(new a());
        }
    }

    /* renamed from: com.bumptech.glide.load.model.e$c */
    public static final class c<Data> implements InterfaceC1563d<Data> {

        /* renamed from: a */
        public final File f7018a;

        /* renamed from: b */
        public final d<Data> f7019b;

        /* renamed from: c */
        public Data f7020c;

        public c(File file, d<Data> dVar) {
            this.f7018a = file;
            this.f7019b = dVar;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: a */
        public Class<Data> mo9017a() {
            return this.f7019b.mo9093a();
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: b */
        public void mo9022b() {
            Data data = this.f7020c;
            if (data != null) {
                try {
                    this.f7019b.mo9095c(data);
                } catch (IOException unused) {
                }
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

        /* JADX WARN: Type inference failed for: r2v5, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: e */
        public void mo9025e(EnumC1551g enumC1551g, InterfaceC1563d.a<? super Data> aVar) {
            try {
                Data dataMo9094b = this.f7019b.mo9094b(this.f7018a);
                this.f7020c = dataMo9094b;
                aVar.mo9031f(dataMo9094b);
            } catch (FileNotFoundException e10) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e10);
                }
                aVar.mo9030c(e10);
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.model.e$d */
    public interface d<Data> {
        /* renamed from: a */
        Class<Data> mo9093a();

        /* renamed from: b */
        Data mo9094b(File file) throws FileNotFoundException;

        /* renamed from: c */
        void mo9095c(Data data) throws IOException;
    }

    /* renamed from: com.bumptech.glide.load.model.e$e */
    public static class e extends a<InputStream> {

        /* renamed from: com.bumptech.glide.load.model.e$e$a */
        public class a implements d<InputStream> {
            @Override // com.bumptech.glide.load.model.C1588e.d
            /* renamed from: a */
            public Class<InputStream> mo9093a() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.C1588e.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void mo9095c(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.model.C1588e.d
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream mo9094b(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public C1588e(d<Data> dVar) {
        this.f7016a = dVar;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1589f.a<Data> mo9071b(File file, int i10, int i11, C13684i c13684i) {
        return new InterfaceC1589f.a<>(new C12459b(file), new c(file, this.f7016a));
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9070a(File file) {
        return true;
    }
}
