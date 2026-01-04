package p051c9;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import p514o9.C11839m;

/* renamed from: c9.b */
/* loaded from: classes3.dex */
public class C1397b {

    /* renamed from: a */
    public static final String[] f5977a = {"sum(_size) as _size"};

    /* renamed from: b */
    public static final String f5978b;

    /* renamed from: c */
    public static final String f5979c;

    /* renamed from: d */
    public static final String f5980d;

    /* renamed from: e */
    public static final String f5981e;

    /* renamed from: f */
    public static final String f5982f;

    /* renamed from: g */
    public static final String[] f5983g;

    static {
        String str = "_data NOT LIKE '%/.File_Recycle%'";
        f5978b = str;
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("(");
        sb2.append("media_type = 1");
        sb2.append(" OR ");
        sb2.append("mime_type like 'image/%'");
        sb2.append(" and ");
        sb2.append(str);
        sb2.append(")");
        f5979c = sb2.toString();
        StringBuilder sb3 = new StringBuilder(128);
        sb3.append("(");
        sb3.append("media_type = 2");
        sb3.append(" OR ");
        sb3.append("mime_type like 'audio/%'");
        sb3.append(" and ");
        sb3.append(str);
        sb3.append(")");
        f5980d = sb3.toString();
        StringBuilder sb4 = new StringBuilder(128);
        sb4.append("(");
        sb4.append("media_type = 3");
        sb4.append(" OR ");
        sb4.append("mime_type like 'video/%'");
        sb4.append(" and ");
        sb4.append(str);
        sb4.append(")");
        f5981e = sb4.toString();
        f5983g = new String[]{InterfaceC5483d.f25083i, "text/html", "application/pdf", "application/msword", "application/wpt", "application/vnd.ms-excel", "text/comma-separated-values", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.openxmlformats-officedocument.spreadsheetml.template", "application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.template", "application/vnd.openxmlformats-officedocument.presentationml.slideshow", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/x-dot", "application/vnd.ms-excel.sheet.macroEnabled.12", "application/vnd.ms-excel.template.macroEnabled.12", "application/et", "application/vnd.ms-powerpoint.presentation.macroEnabled.12", "application/vnd.ms-powerpoint.slideshow.macroEnabled.12", "application/dps", "application/dpt", "text/rtf", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.wordprocessingml.template", "application/rtf", "application/mspowerpoint", "application/epub", "application/epub+zip"};
        int length = m7998b().length;
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("(");
        for (int i10 = 0; i10 < length; i10++) {
            sb5.append("(");
            sb5.append("mime_type");
            sb5.append("='");
            sb5.append(m7998b()[i10]);
            sb5.append("') OR ");
        }
        sb5.delete(sb5.lastIndexOf(")") + 1, sb5.length() - 1);
        sb5.append(" )");
        f5982f = sb5.toString();
    }

    /* renamed from: a */
    public static long m7997a(Context context, int i10, Uri uri, String str) {
        long j10 = 0;
        if (uri != null && context != null && i10 <= 5) {
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = context.getContentResolver().query(uri, f5977a, str, null, null);
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        do {
                            j10 = cursorQuery.getLong(0);
                        } while (cursorQuery.moveToNext());
                    }
                } catch (Exception e10) {
                    C11839m.m70687e("QueryCategoryStorageHelper", "doGetFileTypeSize Exception: " + e10.toString());
                    if (cursorQuery != null) {
                    }
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return j10;
    }

    /* renamed from: b */
    public static String[] m7998b() {
        return (String[]) f5983g.clone();
    }

    /* renamed from: c */
    public static String m7999c(int i10, String str) {
        String str2 = i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? null : f5982f : f5981e : f5980d : f5979c;
        if (str2 == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(1024);
        sb2.append(str2);
        if (str != null) {
            sb2.append(" AND (");
            sb2.append("_data");
            sb2.append(" LIKE '");
            sb2.append(str);
            sb2.append("%')");
        }
        return sb2.toString();
    }

    /* renamed from: d */
    public static long m8000d(Context context, int i10, String str) {
        return m7997a(context, i10, MediaStore.Files.getContentUri("external"), m7999c(i10, str));
    }
}
