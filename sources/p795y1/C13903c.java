package p795y1;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.C1566g;
import com.bumptech.glide.load.data.InterfaceC1563d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import p759x1.EnumC13676a;

/* renamed from: y1.c */
/* loaded from: classes.dex */
public class C13903c implements InterfaceC1563d<InputStream> {

    /* renamed from: a */
    public final Uri f62246a;

    /* renamed from: b */
    public final C13905e f62247b;

    /* renamed from: c */
    public InputStream f62248c;

    /* renamed from: y1.c$a */
    public static class a implements InterfaceC13904d {

        /* renamed from: b */
        public static final String[] f62249b = {"_data"};

        /* renamed from: a */
        public final ContentResolver f62250a;

        public a(ContentResolver contentResolver) {
            this.f62250a = contentResolver;
        }

        @Override // p795y1.InterfaceC13904d
        /* renamed from: a */
        public Cursor mo83322a(Uri uri) {
            return this.f62250a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f62249b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* renamed from: y1.c$b */
    public static class b implements InterfaceC13904d {

        /* renamed from: b */
        public static final String[] f62251b = {"_data"};

        /* renamed from: a */
        public final ContentResolver f62252a;

        public b(ContentResolver contentResolver) {
            this.f62252a = contentResolver;
        }

        @Override // p795y1.InterfaceC13904d
        /* renamed from: a */
        public Cursor mo83322a(Uri uri) {
            return this.f62252a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f62251b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public C13903c(Uri uri, C13905e c13905e) {
        this.f62246a = uri;
        this.f62247b = c13905e;
    }

    /* renamed from: c */
    public static C13903c m83318c(Context context, Uri uri, InterfaceC13904d interfaceC13904d) {
        return new C13903c(uri, new C13905e(ComponentCallbacks2C1546b.m8898c(context).m8911j().m8937g(), interfaceC13904d, ComponentCallbacks2C1546b.m8898c(context).m8906e(), context.getContentResolver()));
    }

    /* renamed from: f */
    public static C13903c m83319f(Context context, Uri uri) {
        return m83318c(context, uri, new a(context.getContentResolver()));
    }

    /* renamed from: g */
    public static C13903c m83320g(Context context, Uri uri) {
        return m83318c(context, uri, new b(context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: a */
    public Class<InputStream> mo9017a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: b */
    public void mo9022b() throws IOException {
        InputStream inputStream = this.f62248c;
        if (inputStream != null) {
            try {
                inputStream.close();
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

    @Override // com.bumptech.glide.load.data.InterfaceC1563d
    /* renamed from: e */
    public void mo9025e(EnumC1551g enumC1551g, InterfaceC1563d.a<? super InputStream> aVar) throws Throwable {
        try {
            InputStream inputStreamM83321h = m83321h();
            this.f62248c = inputStreamM83321h;
            aVar.mo9031f(inputStreamM83321h);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e10);
            }
            aVar.mo9030c(e10);
        }
    }

    /* renamed from: h */
    public final InputStream m83321h() throws Throwable {
        InputStream inputStreamM83326d = this.f62247b.m83326d(this.f62246a);
        int iM83323a = inputStreamM83326d != null ? this.f62247b.m83323a(this.f62246a) : -1;
        return iM83323a != -1 ? new C1566g(inputStreamM83326d, iM83323a) : inputStreamM83326d;
    }
}
