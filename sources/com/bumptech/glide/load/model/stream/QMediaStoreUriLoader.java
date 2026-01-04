package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.model.C1591h;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import p214d2.InterfaceC8994h;
import p599r2.C12459b;
import p759x1.C13684i;
import p759x1.EnumC13676a;
import p795y1.C13902b;

/* loaded from: classes.dex */
public final class QMediaStoreUriLoader<DataT> implements InterfaceC1589f<Uri, DataT> {

    /* renamed from: a */
    public final Context f7063a;

    /* renamed from: b */
    public final InterfaceC1589f<File, DataT> f7064b;

    /* renamed from: c */
    public final InterfaceC1589f<Uri, DataT> f7065c;

    /* renamed from: d */
    public final Class<DataT> f7066d;

    public static final class FileDescriptorFactory extends AbstractC1597a<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    public static final class InputStreamFactory extends AbstractC1597a<InputStream> {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    /* renamed from: com.bumptech.glide.load.model.stream.QMediaStoreUriLoader$a */
    public static abstract class AbstractC1597a<DataT> implements InterfaceC8994h<Uri, DataT> {

        /* renamed from: a */
        public final Context f7067a;

        /* renamed from: b */
        public final Class<DataT> f7068b;

        public AbstractC1597a(Context context, Class<DataT> cls) {
            this.f7067a = context;
            this.f7068b = cls;
        }

        @Override // p214d2.InterfaceC8994h
        /* renamed from: b */
        public final InterfaceC1589f<Uri, DataT> mo9074b(C1591h c1591h) {
            return new QMediaStoreUriLoader(this.f7067a, c1591h.m9105d(File.class, this.f7068b), c1591h.m9105d(Uri.class, this.f7068b), this.f7068b);
        }
    }

    /* renamed from: com.bumptech.glide.load.model.stream.QMediaStoreUriLoader$b */
    public static final class C1598b<DataT> implements InterfaceC1563d<DataT> {

        /* renamed from: k */
        public static final String[] f7069k = {"_data"};

        /* renamed from: a */
        public final Context f7070a;

        /* renamed from: b */
        public final InterfaceC1589f<File, DataT> f7071b;

        /* renamed from: c */
        public final InterfaceC1589f<Uri, DataT> f7072c;

        /* renamed from: d */
        public final Uri f7073d;

        /* renamed from: e */
        public final int f7074e;

        /* renamed from: f */
        public final int f7075f;

        /* renamed from: g */
        public final C13684i f7076g;

        /* renamed from: h */
        public final Class<DataT> f7077h;

        /* renamed from: i */
        public volatile boolean f7078i;

        /* renamed from: j */
        public volatile InterfaceC1563d<DataT> f7079j;

        public C1598b(Context context, InterfaceC1589f<File, DataT> interfaceC1589f, InterfaceC1589f<Uri, DataT> interfaceC1589f2, Uri uri, int i10, int i11, C13684i c13684i, Class<DataT> cls) {
            this.f7070a = context.getApplicationContext();
            this.f7071b = interfaceC1589f;
            this.f7072c = interfaceC1589f2;
            this.f7073d = uri;
            this.f7074e = i10;
            this.f7075f = i11;
            this.f7076g = c13684i;
            this.f7077h = cls;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: a */
        public Class<DataT> mo9017a() {
            return this.f7077h;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: b */
        public void mo9022b() {
            InterfaceC1563d<DataT> interfaceC1563d = this.f7079j;
            if (interfaceC1563d != null) {
                interfaceC1563d.mo9022b();
            }
        }

        /* renamed from: c */
        public final InterfaceC1589f.a<DataT> m9132c() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.f7071b.mo9071b(m9135h(this.f7073d), this.f7074e, this.f7075f, this.f7076g);
            }
            return this.f7072c.mo9071b(m9134g() ? MediaStore.setRequireOriginal(this.f7073d) : this.f7073d, this.f7074e, this.f7075f, this.f7076g);
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        public void cancel() {
            this.f7078i = true;
            InterfaceC1563d<DataT> interfaceC1563d = this.f7079j;
            if (interfaceC1563d != null) {
                interfaceC1563d.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: d */
        public EnumC13676a mo9024d() {
            return EnumC13676a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1563d
        /* renamed from: e */
        public void mo9025e(EnumC1551g enumC1551g, InterfaceC1563d.a<? super DataT> aVar) {
            try {
                InterfaceC1563d<DataT> interfaceC1563dM9133f = m9133f();
                if (interfaceC1563dM9133f == null) {
                    aVar.mo9030c(new IllegalArgumentException("Failed to build fetcher for: " + this.f7073d));
                    return;
                }
                this.f7079j = interfaceC1563dM9133f;
                if (this.f7078i) {
                    cancel();
                } else {
                    interfaceC1563dM9133f.mo9025e(enumC1551g, aVar);
                }
            } catch (FileNotFoundException e10) {
                aVar.mo9030c(e10);
            }
        }

        /* renamed from: f */
        public final InterfaceC1563d<DataT> m9133f() throws FileNotFoundException {
            InterfaceC1589f.a<DataT> aVarM9132c = m9132c();
            if (aVarM9132c != null) {
                return aVarM9132c.f7023c;
            }
            return null;
        }

        /* renamed from: g */
        public final boolean m9134g() {
            return this.f7070a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        /* renamed from: h */
        public final File m9135h(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor cursorQuery = this.f7070a.getContentResolver().query(uri, f7069k, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    cursorQuery.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (Throwable th2) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th2;
            }
        }
    }

    public QMediaStoreUriLoader(Context context, InterfaceC1589f<File, DataT> interfaceC1589f, InterfaceC1589f<Uri, DataT> interfaceC1589f2, Class<DataT> cls) {
        this.f7063a = context.getApplicationContext();
        this.f7064b = interfaceC1589f;
        this.f7065c = interfaceC1589f2;
        this.f7066d = cls;
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC1589f.a<DataT> mo9071b(Uri uri, int i10, int i11, C13684i c13684i) {
        return new InterfaceC1589f.a<>(new C12459b(uri), new C1598b(this.f7063a, this.f7064b, this.f7065c, uri, i10, i11, c13684i, this.f7066d));
    }

    @Override // com.bumptech.glide.load.model.InterfaceC1589f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9070a(Uri uri) {
        return C13902b.m83314b(uri);
    }
}
