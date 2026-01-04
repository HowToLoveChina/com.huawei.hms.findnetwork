package p605r8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11839m;

/* renamed from: r8.b */
/* loaded from: classes2.dex */
public class C12477b {

    /* renamed from: a */
    public static final Uri f57442a = Uri.parse("content://com.huawei.systemmanager.BackupModuleProvider");

    /* renamed from: b */
    public static final Uri f57443b = Uri.parse("content://com.hihonor.systemmanager.BackupModuleProvider");

    /* renamed from: r8.b$a */
    public static class a {

        /* renamed from: a */
        public int f57444a;

        /* renamed from: b */
        public ArrayList<String> f57445b;

        /* renamed from: c */
        public ArrayList<String> f57446c;

        /* renamed from: d */
        public int m74891d() {
            return this.f57444a;
        }

        /* renamed from: e */
        public ArrayList<String> m74892e() {
            return this.f57445b;
        }

        /* renamed from: f */
        public ArrayList<String> m74893f() {
            return this.f57446c;
        }
    }

    /* renamed from: r8.b$b */
    public static class b {

        /* renamed from: a */
        public int f57447a;

        /* renamed from: b */
        public int f57448b;

        /* renamed from: e */
        public int m74898e() {
            return this.f57448b;
        }

        /* renamed from: f */
        public int m74899f() {
            return this.f57447a;
        }
    }

    /* renamed from: r8.b$c */
    public static class c {

        /* renamed from: a */
        public boolean f57449a;

        /* renamed from: b */
        public boolean m74901b() {
            return this.f57449a;
        }
    }

    /* renamed from: a */
    public static List<ContentValues> m74883a(Uri uri, Context context) {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        if (!C0209d.m1227Y1(context, uri)) {
            C11839m.m70687e("PhoneManagerProtocol", "TargetApp is not SystemApp");
            return arrayList;
        }
        try {
            cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
        } catch (Exception e10) {
            C11839m.m70687e("PhoneManagerProtocol", "getContentValues query e " + e10.toString());
            cursorQuery = null;
        }
        if (cursorQuery == null) {
            return arrayList;
        }
        if (!cursorQuery.moveToFirst()) {
            cursorQuery.close();
            return arrayList;
        }
        String[] columnNames = cursorQuery.getColumnNames();
        do {
            ContentValues contentValues = new ContentValues();
            for (String str : columnNames) {
                int columnIndex = cursorQuery.getColumnIndex(str);
                int type = cursorQuery.getType(columnIndex);
                if (type == 0) {
                    contentValues.putNull(str);
                } else if (type == 1) {
                    contentValues.put(str, Long.valueOf(cursorQuery.getLong(columnIndex)));
                } else if (type == 2) {
                    contentValues.put(str, Float.valueOf(cursorQuery.getFloat(columnIndex)));
                } else if (type == 3) {
                    contentValues.put(str, cursorQuery.getString(columnIndex));
                } else if (type == 4) {
                    contentValues.put(str, cursorQuery.getBlob(columnIndex));
                }
            }
            arrayList.add(contentValues);
        } while (cursorQuery.moveToNext());
        cursorQuery.close();
        return arrayList;
    }

    /* renamed from: b */
    public static String m74884b(Context context) {
        ArrayList<String> stringArrayList;
        if (context == null) {
            return null;
        }
        Bundle bundleM1243d = C0209d.m1277l1() ? C0209d.m1243d(context, f57443b, "all_module_provider_uri_query", null, null) : C0209d.m1243d(context, f57442a, "all_module_provider_uri_query", null, null);
        if (bundleM1243d != null && (stringArrayList = bundleM1243d.getStringArrayList("all_module_provider_uri_list")) != null) {
            if (C0209d.m1277l1() && stringArrayList.contains("content://com.hihonor.systemmanager.HarassmentInterceptionDBProvider")) {
                C11839m.m70688i("PhoneManagerProtocol", "getModuleProviderUri isHonorS");
                return "content://com.hihonor.systemmanager.HarassmentInterceptionDBProvider";
            }
            if (stringArrayList.contains("content://com.huawei.systemmanager.HarassmentInterceptionDBProvider")) {
                C11839m.m70688i("PhoneManagerProtocol", "getModuleProviderUri");
                return "content://com.huawei.systemmanager.HarassmentInterceptionDBProvider";
            }
        }
        return null;
    }

    /* renamed from: c */
    public static a m74885c(Uri uri, Context context) {
        Bundle bundleM1243d;
        if (context == null || (bundleM1243d = C0209d.m1243d(context, uri, "backup_query", null, null)) == null) {
            return null;
        }
        a aVar = new a();
        aVar.f57444a = bundleM1243d.getInt("version");
        aVar.f57445b = bundleM1243d.getStringArrayList("uri_list");
        aVar.f57446c = bundleM1243d.getStringArrayList("uri_list_need_count");
        return aVar;
    }

    /* renamed from: d */
    public static b m74886d(Uri uri, Context context) {
        Bundle bundleM1243d;
        if (context == null || (bundleM1243d = C0209d.m1243d(context, uri, "backup_recover_complete", null, null)) == null) {
            return null;
        }
        b bVar = new b();
        bVar.f57447a = bundleM1243d.getInt("success_count");
        bVar.f57448b = bundleM1243d.getInt("fail_count");
        C11839m.m70688i("PhoneManagerProtocol", "restoreComplete, success:fail=" + bVar.f57447a + ":" + bVar.f57448b);
        return bVar;
    }

    /* renamed from: e */
    public static c m74887e(Uri uri, Context context, int i10) {
        if (context == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("version", i10);
        Bundle bundleM1243d = C0209d.m1243d(context, uri, "backup_recover_start", null, bundle);
        if (bundleM1243d == null) {
            return null;
        }
        c cVar = new c();
        cVar.f57449a = bundleM1243d.getBoolean("permit");
        return cVar;
    }
}
