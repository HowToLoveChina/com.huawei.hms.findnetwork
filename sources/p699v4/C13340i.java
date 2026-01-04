package p699v4;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.LruCache;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p566q4.C12284c;
import p566q4.C12285d;

/* renamed from: v4.i */
/* loaded from: classes.dex */
public class C13340i {

    /* renamed from: a */
    public static LruCache<String, C12285d> f60162a = new LruCache<>(1000);

    /* renamed from: b */
    public static String f60163b = null;

    /* renamed from: c */
    public static String f60164c = null;

    /* renamed from: d */
    public static String f60165d = null;

    /* renamed from: a */
    public static String m80015a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getApplicationContext().getFilesDir());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("mediainfo_new");
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        sb2.append(C12284c.m73809b(str));
        return sb2.toString();
    }

    /* renamed from: b */
    public static String m80016b(Context context, String str, String str2) {
        return "_data = '" + m80017c(context, str, str2) + "'";
    }

    /* renamed from: c */
    public static String m80017c(Context context, String str, String str2) {
        if (str.equals(Constants.VIDEO_SUB_DIR) || str.equals("photo")) {
            if (str2.startsWith("/storage/emulated/0")) {
                return str2;
            }
            return m80022h(context, str) + m80018d(str2);
        }
        if (str.equals("video_sd") || str.equals("photo_sd")) {
            return m80023i(context, str) + m80025k(context, str2);
        }
        if (!str.equals("wechat_record") || str2.startsWith("/storage/emulated/0")) {
            return str2;
        }
        return m80024j(context, str) + m80029o(str2);
    }

    /* renamed from: d */
    public static String m80018d(String str) {
        int iM79963G = C13334c.m79963G(str, File.separator, 3);
        if (str.startsWith("/storage/emulated") && iM79963G != -1) {
            return str.substring(iM79963G);
        }
        C2111d.m12657m("MediaInfoDBUtils", "getFileRelativePath, root path is invalid");
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.io.Closeable] */
    /* renamed from: e */
    public static String m80019e(Context context, String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseM80020f;
        Cursor cursorQuery = null;
        try {
            try {
                sQLiteDatabaseM80020f = m80020f(context, str);
                if (sQLiteDatabaseM80020f != null) {
                    try {
                        cursorQuery = sQLiteDatabaseM80020f.query("mediainfo", new String[]{"_data"}, null, null, null, null, null, "1");
                        if (cursorQuery != null && cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                            C13339h.m80014a(cursorQuery);
                            C13339h.m80014a(sQLiteDatabaseM80020f);
                            return string;
                        }
                        C2111d.m12657m("MediaInfoDBUtils", "cursor is empty");
                    } catch (SQLException unused) {
                        C2111d.m12648d("MediaInfoDBUtils", "SQLite database corrupt error!");
                        C13339h.m80014a(null);
                        C13339h.m80014a(sQLiteDatabaseM80020f);
                        return "";
                    } catch (IllegalArgumentException unused2) {
                        C2111d.m12648d("MediaInfoDBUtils", "queryBucketDataInternal IllegalArgument!");
                        C13339h.m80014a(null);
                        C13339h.m80014a(sQLiteDatabaseM80020f);
                        return "";
                    } catch (Exception unused3) {
                        C2111d.m12648d("MediaInfoDBUtils", "queryBucketDataInternal Exception!");
                        C13339h.m80014a(null);
                        C13339h.m80014a(sQLiteDatabaseM80020f);
                        return "";
                    }
                }
                C13339h.m80014a(cursorQuery);
                C13339h.m80014a(sQLiteDatabaseM80020f);
                return "";
            } catch (SQLException unused4) {
                sQLiteDatabaseM80020f = null;
            } catch (IllegalArgumentException unused5) {
                sQLiteDatabaseM80020f = null;
            } catch (Exception unused6) {
                sQLiteDatabaseM80020f = null;
            } catch (Throwable th2) {
                th = th2;
                context = 0;
                C13339h.m80014a(null);
                C13339h.m80014a(context);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            C13339h.m80014a(null);
            C13339h.m80014a(context);
            throw th;
        }
    }

    /* renamed from: f */
    public static SQLiteDatabase m80020f(Context context, String str) {
        String strM80015a = m80015a(context, str);
        File file = new File(strM80015a);
        if (!file.isDirectory() && file.length() > 0) {
            return SQLiteDatabase.openDatabase(strM80015a, null, 1);
        }
        C2111d.m12657m("MediaInfoDBUtils", "getMediaDb error, db is null");
        return null;
    }

    /* renamed from: g */
    public static SQLiteDatabase m80021g(String str, int i10) {
        File file = new File(str);
        if (!file.isFile() || file.length() <= 0) {
            return null;
        }
        try {
            return SQLiteDatabase.openDatabase(str, null, i10);
        } catch (SQLException unused) {
            C2111d.m12648d("MediaInfoDBUtils", "open db exception happen");
            return null;
        }
    }

    /* renamed from: h */
    public static String m80022h(Context context, String str) {
        if (f60163b == null) {
            f60163b = m80026l(context, str);
        }
        return f60163b;
    }

    /* renamed from: i */
    public static String m80023i(Context context, String str) throws Throwable {
        if (f60164c == null) {
            String strM80027m = m80027m(context, str);
            f60164c = strM80027m;
            C2111d.m12654j("MediaInfoDBUtils", "srcSdRootPath is ", strM80027m);
        }
        return f60164c;
    }

    /* renamed from: j */
    public static String m80024j(Context context, String str) throws Throwable {
        if (f60165d == null) {
            String strM80028n = m80028n(context, str);
            f60165d = strM80028n;
            C2111d.m12654j("MediaInfoDBUtils", "srcTwinRootPath is ", strM80028n);
        }
        return f60165d;
    }

    /* renamed from: k */
    public static String m80025k(Context context, String str) {
        String strM80072k;
        if (C13345n.m80074m(context, 3)) {
            strM80072k = C13345n.m80072k(context, 3);
        } else {
            strM80072k = C13345n.m80072k(context, 2) + "/Huawei/CloudClone/SDCardClone";
        }
        if (str.startsWith(strM80072k)) {
            return str.substring(strM80072k.length());
        }
        C2111d.m12657m("MediaInfoDBUtils", "getSdcardFileRelativePath, root path is invalid");
        return str;
    }

    /* renamed from: l */
    public static String m80026l(Context context, String str) throws Throwable {
        int iM79963G;
        String strM80019e = m80019e(context, str);
        return (TextUtils.isEmpty(strM80019e) || (iM79963G = C13334c.m79963G(strM80019e, File.separator, 3)) == -1) ? "" : strM80019e.substring(0, iM79963G);
    }

    /* renamed from: m */
    public static String m80027m(Context context, String str) throws Throwable {
        int iM79963G;
        String strM80019e = m80019e(context, str);
        return (TextUtils.isEmpty(strM80019e) || (iM79963G = C13334c.m79963G(strM80019e, File.separator, 2)) == -1) ? "" : strM80019e.substring(0, iM79963G);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.io.Closeable] */
    /* renamed from: n */
    public static String m80028n(Context context, String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseM80020f;
        Cursor cursorQuery = null;
        try {
            try {
                sQLiteDatabaseM80020f = m80020f(context, str);
            } catch (SQLException unused) {
                sQLiteDatabaseM80020f = null;
            } catch (IllegalArgumentException unused2) {
                sQLiteDatabaseM80020f = null;
            } catch (Exception unused3) {
                sQLiteDatabaseM80020f = null;
            } catch (Throwable th2) {
                th = th2;
                context = 0;
                C13339h.m80014a(null);
                C13339h.m80014a(context);
                throw th;
            }
            if (sQLiteDatabaseM80020f != null) {
                try {
                    cursorQuery = sQLiteDatabaseM80020f.query("mediainfo", new String[]{"_data"}, "(_data not like '/storage/emulated/0/%') AND (_data like '/storage/emulated/%')", null, null, null, null, "1");
                } catch (SQLException unused4) {
                    C2111d.m12648d("MediaInfoDBUtils", "SQLite database corrupt error!");
                    C13339h.m80014a(cursorQuery);
                    C13339h.m80014a(sQLiteDatabaseM80020f);
                    return "";
                } catch (IllegalArgumentException unused5) {
                    C2111d.m12648d("MediaInfoDBUtils", "queryBucketDataInternal IllegalArgument!");
                    C13339h.m80014a(cursorQuery);
                    C13339h.m80014a(sQLiteDatabaseM80020f);
                    return "";
                } catch (Exception unused6) {
                    C2111d.m12648d("MediaInfoDBUtils", "queryBucketDataInternal Exception!");
                    C13339h.m80014a(cursorQuery);
                    C13339h.m80014a(sQLiteDatabaseM80020f);
                    return "";
                }
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                    int iM79963G = C13334c.m79963G(string, File.separator, 3);
                    if (iM79963G != -1) {
                        String strSubstring = string.substring(0, iM79963G);
                        C13339h.m80014a(cursorQuery);
                        C13339h.m80014a(sQLiteDatabaseM80020f);
                        return strSubstring;
                    }
                    C13339h.m80014a(cursorQuery);
                    C13339h.m80014a(sQLiteDatabaseM80020f);
                    return "";
                }
                C2111d.m12657m("MediaInfoDBUtils", "cursor is empty");
            }
            C13339h.m80014a(cursorQuery);
            C13339h.m80014a(sQLiteDatabaseM80020f);
            return "";
        } catch (Throwable th3) {
            th = th3;
            C13339h.m80014a(null);
            C13339h.m80014a(context);
            throw th;
        }
    }

    /* renamed from: o */
    public static String m80029o(String str) {
        int iM79963G = C13334c.m79963G(str, File.separator, 3);
        if (str.startsWith("/storage/emulated") && iM79963G != -1) {
            return str.substring(iM79963G);
        }
        C2111d.m12657m("MediaInfoDBUtils", "getTwinWechatRecordFileRelativePath, root path is invalid");
        return str;
    }

    /* renamed from: p */
    public static List<String> m80030p(String str, String str2) {
        C2111d.m12653i("MediaInfoDBUtils", "queryAllFilePathInternal begin");
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabaseM80021g = m80021g(str, 1);
        if (sQLiteDatabaseM80021g == null) {
            C2111d.m12648d("MediaInfoDBUtils", "queryAllFilePath db is null");
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            try {
                try {
                    try {
                        sQLiteDatabaseM80021g = SQLiteDatabase.openDatabase(str, null, 1);
                        cursorQuery = sQLiteDatabaseM80021g.query(str2, new String[]{"filepath"}, null, null, null, null, null);
                    } catch (SQLException unused) {
                        C2111d.m12648d("MediaInfoDBUtils", "sql exception");
                        if (0 != 0) {
                        }
                    }
                } catch (Exception unused2) {
                    C2111d.m12648d("MediaInfoDBUtils", "queryBucketDataInternal Exception!");
                    if (0 != 0) {
                    }
                }
            } catch (IllegalArgumentException unused3) {
                C2111d.m12648d("MediaInfoDBUtils", "queryBucketDataInternal IllegalArgument!");
                if (0 != 0) {
                }
            }
            if (cursorQuery == null) {
                C2111d.m12657m("MediaInfoDBUtils", "cursor is empty");
                return arrayList;
            }
            int columnIndex = cursorQuery.getColumnIndex("filepath");
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(columnIndex));
            }
            cursorQuery.close();
            sQLiteDatabaseM80021g.close();
            C2111d.m12653i("MediaInfoDBUtils", "queryAllFilePathInternal end");
            return arrayList;
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
            sQLiteDatabaseM80021g.close();
        }
    }

    /* renamed from: q */
    public static List<String> m80031q(String str) {
        C2111d.m12653i("MediaInfoDBUtils", "queryAllNoMediaFilePaths");
        return m80030p(str, "nomediafile");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.database.sqlite.SQLiteDatabase, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* renamed from: r */
    public static C12285d m80032r(Context context, String str, String str2) throws Throwable {
        Cursor cursorQuery;
        Closeable closeable;
        String strM80017c = m80017c(context, str, str2);
        ?? M80020f = f60162a.get(strM80017c);
        if (M80020f != 0) {
            C2111d.m12646b("MediaInfoDBUtils", "point one file");
            return f60162a.get(strM80017c);
        }
        C2111d.m12653i("MediaInfoDBUtils", "queryMediaPointInfoByCache begin ......");
        ?? r12 = 0;
        r12 = 0;
        try {
            try {
                M80020f = m80020f(context, str);
                if (M80020f == 0) {
                    C13339h.m80014a(null);
                } else {
                    try {
                        cursorQuery = M80020f.query("mediainfo", null, m80016b(context, str, str2), null, null, null, null);
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.moveToFirst()) {
                                    C12285d c12285d = new C12285d();
                                    c12285d.m73816g(cursorQuery.getDouble(cursorQuery.getColumnIndex(JsbMapKeyNames.H5_LOC_LAT)));
                                    c12285d.m73817h(cursorQuery.getDouble(cursorQuery.getColumnIndex(JsbMapKeyNames.H5_LOC_LON)));
                                    c12285d.m73815f(cursorQuery.getLong(cursorQuery.getColumnIndex("datetaken")));
                                    c12285d.m73814e(cursorQuery.getLong(cursorQuery.getColumnIndex("date_modified")));
                                    f60162a.put(cursorQuery.getString(cursorQuery.getColumnIndex("_data")), c12285d);
                                    if (cursorQuery.getColumnIndex("_id") != -1) {
                                        int i10 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                                        C2111d.m12654j("MediaInfoDBUtils", "file id is ", Integer.valueOf(i10));
                                        m80033s(M80020f, i10);
                                    }
                                    C13339h.m80014a(cursorQuery);
                                    C13339h.m80014a(M80020f);
                                    return c12285d;
                                }
                            } catch (SQLException unused) {
                                C2111d.m12648d("MediaInfoDBUtils", "SQLite database corrupt error!");
                                closeable = M80020f;
                                C13339h.m80014a(cursorQuery);
                                C13339h.m80014a(closeable);
                                return null;
                            } catch (IllegalArgumentException unused2) {
                                C2111d.m12648d("MediaInfoDBUtils", "queryBucketDataInternal IllegalArgument!");
                                closeable = M80020f;
                                C13339h.m80014a(cursorQuery);
                                C13339h.m80014a(closeable);
                                return null;
                            } catch (Exception unused3) {
                                C2111d.m12648d("MediaInfoDBUtils", "queryBucketDataInternal Exception!");
                                closeable = M80020f;
                                C13339h.m80014a(cursorQuery);
                                C13339h.m80014a(closeable);
                                return null;
                            }
                        }
                        C2111d.m12657m("MediaInfoDBUtils", "cursor is empty");
                        C13339h.m80014a(cursorQuery);
                    } catch (SQLException unused4) {
                        cursorQuery = null;
                    } catch (IllegalArgumentException unused5) {
                        cursorQuery = null;
                    } catch (Exception unused6) {
                        cursorQuery = null;
                    } catch (Throwable th2) {
                        th = th2;
                        C13339h.m80014a(r12);
                        C13339h.m80014a(M80020f);
                        throw th;
                    }
                }
                C13339h.m80014a(M80020f);
                return null;
            } catch (SQLException unused7) {
                cursorQuery = null;
                M80020f = 0;
            } catch (IllegalArgumentException unused8) {
                cursorQuery = null;
                M80020f = 0;
            } catch (Exception unused9) {
                cursorQuery = null;
                M80020f = 0;
            } catch (Throwable th3) {
                th = th3;
                M80020f = 0;
            }
        } catch (Throwable th4) {
            th = th4;
            r12 = context;
        }
    }

    /* renamed from: s */
    public static synchronized void m80033s(SQLiteDatabase sQLiteDatabase, int i10) {
        Cursor cursorQuery;
        C2111d.m12653i("MediaInfoDBUtils", "updateCache begin ...");
        try {
            cursorQuery = sQLiteDatabase.query("mediainfo", null, null, null, null, null, null, i10 + ", 100");
        } catch (IllegalArgumentException unused) {
            C2111d.m12648d("MediaInfoDBUtils", "queryBucketDataInternal IllegalArgument!");
        } catch (Exception unused2) {
            C2111d.m12648d("MediaInfoDBUtils", "queryBucketDataInternal Exception!");
        }
        try {
            int columnIndex = cursorQuery.getColumnIndex("_data");
            int columnIndex2 = cursorQuery.getColumnIndex("date_modified");
            int columnIndex3 = cursorQuery.getColumnIndex(JsbMapKeyNames.H5_LOC_LAT);
            int columnIndex4 = cursorQuery.getColumnIndex(JsbMapKeyNames.H5_LOC_LON);
            int columnIndex5 = cursorQuery.getColumnIndex("datetaken");
            if (!cursorQuery.moveToFirst()) {
                C2111d.m12657m("MediaInfoDBUtils", "cursor is empty");
                cursorQuery.close();
                return;
            }
            do {
                C12285d c12285d = new C12285d();
                c12285d.m73816g(cursorQuery.getDouble(columnIndex3));
                c12285d.m73817h(cursorQuery.getDouble(columnIndex4));
                c12285d.m73815f(cursorQuery.getLong(columnIndex5));
                c12285d.m73814e(cursorQuery.getLong(columnIndex2));
                f60162a.put(cursorQuery.getString(columnIndex), c12285d);
            } while (cursorQuery.moveToNext());
            cursorQuery.close();
            C2111d.m12654j("MediaInfoDBUtils", "updateCache end ..., ", Integer.valueOf(f60162a.size()));
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }
}
