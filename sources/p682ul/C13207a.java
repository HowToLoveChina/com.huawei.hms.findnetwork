package p682ul;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.appgallery.coreservice.api.CoreServiceApi;
import fk.C9721b;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: ul.a */
/* loaded from: classes6.dex */
public class C13207a {

    /* renamed from: b */
    public static C13207a f59839b;

    /* renamed from: c */
    public static final Object f59840c = new Object();

    /* renamed from: d */
    public static boolean f59841d;

    /* renamed from: e */
    public static boolean f59842e;

    /* renamed from: a */
    public final Context f59843a = C0213f.m1377a();

    /* renamed from: ul.a$a */
    public enum a {
        WHITE_LIST(1);


        /* renamed from: a */
        public final int f59846a;

        a(int i10) {
            this.f59846a = i10;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Item{id=" + this.f59846a + '}';
        }
    }

    /* renamed from: ul.a$b */
    public enum b {
        PROTOCOL(7, null, "isAgree");


        /* renamed from: a */
        public final int f59849a;

        /* renamed from: b */
        public final String f59850b;

        /* renamed from: c */
        public final String f59851c;

        b(int i10, String str, String str2) {
            this.f59849a = i10;
            this.f59850b = str;
            this.f59851c = str2;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Item{id=" + this.f59849a + ", selection='" + this.f59850b + "', columnName='" + this.f59851c + "'}";
        }
    }

    /* renamed from: c */
    public static C13207a m79404c() {
        C13207a c13207a;
        synchronized (f59840c) {
            try {
                if (f59839b == null) {
                    f59839b = new C13207a();
                }
                c13207a = f59839b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c13207a;
    }

    /* renamed from: g */
    public static void m79405g(boolean z10) {
        f59842e = z10;
    }

    /* renamed from: h */
    public static void m79406h(boolean z10) {
        f59841d = z10;
    }

    /* renamed from: a */
    public String m79407a() {
        return f59841d + "|" + f59842e;
    }

    /* renamed from: b */
    public boolean m79408b(a aVar) throws C9721b {
        boolean z10 = false;
        m79405g(false);
        Cursor cursor = null;
        try {
            try {
                try {
                    Uri uri = Uri.parse("content://" + CoreServiceApi.getAppGalleryPkg(this.f59843a) + ".agd/item");
                    if (!C0209d.m1227Y1(C0213f.m1377a(), uri)) {
                        C11839m.m70687e("AgdProtocolProviderManager", "getAgreeAgd is not Target App or System App");
                        return false;
                    }
                    Cursor cursorQuery = this.f59843a.getContentResolver().query(ContentUris.withAppendedId(uri, aVar.f59846a), null, null, null, null);
                    if (cursorQuery != null && cursorQuery.moveToNext()) {
                        z10 = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex("isAgreeAGD")));
                    }
                    if (cursorQuery == null) {
                        C11839m.m70687e("AgdProtocolProviderManager", "agd network provider cursor is null!");
                        throw new C9721b(4001, "agd network provider cursor is null");
                    }
                    cursorQuery.close();
                    m79405g(z10);
                    return z10;
                } catch (Exception e10) {
                    C11839m.m70687e("AgdProtocolProviderManager", "agd network provider Exception get item " + aVar + " failed, reason:" + e10.toString());
                    throw new C9721b(4001, "agd network provider exception " + e10.getMessage());
                }
            } catch (SecurityException e11) {
                C11839m.m70687e("AgdProtocolProviderManager", "agd network provider SecurityException get item " + aVar + " failed, reason:" + e11.toString());
                throw new C9721b(4001, "agd network provider exception " + e11.getMessage());
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* renamed from: d */
    public boolean m79409d(Context context, b bVar) throws C9721b {
        m79406h(false);
        Cursor cursor = null;
        try {
            try {
                try {
                    Uri uriWithAppendedId = ContentUris.withAppendedId(Uri.parse("content://" + CoreServiceApi.getAppGalleryPkg(context) + ".commondata/item"), bVar.f59849a);
                    if (!C0209d.m1227Y1(C0213f.m1377a(), uriWithAppendedId)) {
                        C11839m.m70687e("AgdProtocolProviderManager", "isAgreeAgdProtocol is not Target App or System App");
                        throw new C9721b(4001, "isAgreeAgdProtocol is not Target App or System App");
                    }
                    Cursor cursorQuery = context.getContentResolver().query(uriWithAppendedId, null, bVar.f59850b, null, null);
                    String string = (cursorQuery == null || !cursorQuery.moveToNext()) ? "false" : cursorQuery.getString(cursorQuery.getColumnIndex(bVar.f59851c));
                    if (cursorQuery == null) {
                        C11839m.m70687e("AgdProtocolProviderManager", "AgreeProtocolProvider cursor is null!");
                        throw new C9721b(4001, "AgreeProtocolProvider cursor is null");
                    }
                    cursorQuery.close();
                    m79406h(Boolean.parseBoolean(string));
                    return Boolean.parseBoolean(string);
                } catch (Exception e10) {
                    C11839m.m70687e("AgdProtocolProviderManager", "AgreeProtocolProvider Exception get item " + bVar + " failed, reason:" + e10.toString());
                    throw new C9721b(4001, e10.getMessage());
                }
            } catch (SecurityException e11) {
                C11839m.m70687e("AgdProtocolProviderManager", "AgreeProtocolProvider SecurityException get item " + bVar + " failed, reason:" + e11.toString());
                throw new C9721b(4001, e11.getMessage());
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* renamed from: e */
    public boolean m79410e() {
        return f59841d || f59842e;
    }

    /* renamed from: f */
    public boolean m79411f(a aVar, boolean z10) {
        boolean z11 = false;
        try {
            Uri uriWithAppendedId = ContentUris.withAppendedId(Uri.parse("content://" + CoreServiceApi.getAppGalleryPkg(this.f59843a) + ".agd/item"), aVar.f59846a);
            if (!C0209d.m1227Y1(C0213f.m1377a(), uriWithAppendedId)) {
                C11839m.m70687e("AgdProtocolProviderManager", "saveAgreeValue is not Target App or System App");
                m79405g(false);
                return false;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("isAgreeAGD", Boolean.valueOf(z10));
            boolean z12 = this.f59843a.getContentResolver().update(uriWithAppendedId, contentValues, null, null) == 1;
            if (z10 && z12) {
                z11 = true;
            }
            try {
                m79405g(z11);
                return z12;
            } catch (IllegalArgumentException unused) {
                z11 = z12;
                C11839m.m70687e("AgdProtocolProviderManager", "WhiteListProvider provider uri may not correct");
                return z11;
            } catch (SecurityException e10) {
                z11 = z12;
                e = e10;
                C11839m.m70687e("AgdProtocolProviderManager", "WhiteListProvider SecurityException get item " + aVar + " failed, reason:" + e.toString());
                return z11;
            } catch (Exception e11) {
                z11 = z12;
                e = e11;
                C11839m.m70687e("AgdProtocolProviderManager", "WhiteListProvider Exception get item " + aVar + " failed, reason:" + e.toString());
                return z11;
            }
        } catch (IllegalArgumentException unused2) {
        } catch (SecurityException e12) {
            e = e12;
        } catch (Exception e13) {
            e = e13;
        }
    }
}
