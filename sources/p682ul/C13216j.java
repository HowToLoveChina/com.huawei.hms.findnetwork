package p682ul;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hicloud.cloudbackup.store.manager.CloudBackupGalleryDBHelper;
import com.huawei.hicloud.cloudbackup.store.manager.CloudBackupLanguageHelper;
import com.huawei.hicloud.cloudbackup.store.manager.CloudBackupSettingDBHelper;
import com.huawei.hicloud.cloudbackup.store.manager.CloudBackupStatusDBHelper;
import com.huawei.hicloud.cloudbackup.store.manager.CloudBackupTagsDBHelper;
import com.huawei.hicloud.cloudbackup.store.manager.CloudRestoreMetadataDBHelper;
import fk.C9721b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p682ul.C13216j;
import p851zp.InterfaceC14355b;

/* renamed from: ul.j */
/* loaded from: classes6.dex */
public class C13216j {

    /* renamed from: a */
    public static final Map<c, C13219m<Object, HashMap<String, SQLiteDatabase>, Function<String, SQLiteOpenHelper>>> f59852a = new a();

    /* renamed from: ul.j$a */
    public class a extends HashMap<c, C13219m<Object, HashMap<String, SQLiteDatabase>, Function<String, SQLiteOpenHelper>>> {
        public a() {
            put(c.SETTING, C13216j.m79429n(new Function() { // from class: ul.b
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C13216j.a.m79440m((String) obj);
                }
            }));
            put(c.LANGUAGE, C13216j.m79429n(new Function() { // from class: ul.c
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C13216j.a.m79441n((String) obj);
                }
            }));
            put(c.TAG, C13216j.m79429n(new Function() { // from class: ul.d
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C13216j.a.m79442o((String) obj);
                }
            }));
            put(c.STATUS, C13216j.m79429n(new Function() { // from class: ul.e
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C13216j.a.m79443p((String) obj);
                }
            }));
            put(c.SNAPSHOT, C13216j.m79429n(new Function() { // from class: ul.f
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C13216j.a.m79444q((String) obj);
                }
            }));
            put(c.METADATA, C13216j.m79429n(new Function() { // from class: ul.g
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C13216j.a.m79445r((String) obj);
                }
            }));
            put(c.GALLEY, C13216j.m79429n(new Function() { // from class: ul.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C13216j.a.m79446s((String) obj);
                }
            }));
            put(c.PMSBRIEF, C13216j.m79429n(new Function() { // from class: ul.i
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C13216j.a.m79447t((String) obj);
                }
            }));
        }

        /* renamed from: m */
        public static /* synthetic */ SQLiteOpenHelper m79440m(String str) {
            return new CloudBackupSettingDBHelper(C13216j.m79426k());
        }

        /* renamed from: n */
        public static /* synthetic */ SQLiteOpenHelper m79441n(String str) {
            return new CloudBackupLanguageHelper(C13216j.m79426k());
        }

        /* renamed from: o */
        public static /* synthetic */ SQLiteOpenHelper m79442o(String str) {
            return new CloudBackupTagsDBHelper(C13216j.m79426k());
        }

        /* renamed from: p */
        public static /* synthetic */ SQLiteOpenHelper m79443p(String str) {
            return new CloudBackupStatusDBHelper(C13216j.m79426k());
        }

        /* renamed from: q */
        public static /* synthetic */ SQLiteOpenHelper m79444q(String str) {
            return new C13217k(C13216j.m79426k(), str);
        }

        /* renamed from: r */
        public static /* synthetic */ SQLiteOpenHelper m79445r(String str) {
            return new CloudRestoreMetadataDBHelper(C13216j.m79426k());
        }

        /* renamed from: s */
        public static /* synthetic */ SQLiteOpenHelper m79446s(String str) {
            return new CloudBackupGalleryDBHelper(C13216j.m79426k());
        }

        /* renamed from: t */
        public static /* synthetic */ SQLiteOpenHelper m79447t(String str) {
            return new C13218l(C13216j.m79426k(), str);
        }
    }

    /* renamed from: ul.j$b */
    public static class b extends AbstractC12367d {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C13216j.m79423h();
        }
    }

    /* renamed from: ul.j$c */
    public enum c {
        SETTING,
        LANGUAGE,
        TAG,
        STATUS,
        METADATA,
        SNAPSHOT,
        GALLEY,
        PMSBRIEF
    }

    /* renamed from: c */
    public static void m79418c(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' and name like 'index_%' order by name;", null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            sQLiteDatabase.execSQL(String.format(Locale.ENGLISH, "drop table if exists %1$s;", cursorRawQuery.getString(0)));
                        } while (cursorRawQuery.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupDbManager", "delete index table error, " + e10.getMessage());
        }
        try {
            Cursor cursorRawQuery2 = sQLiteDatabase.rawQuery("pragma journal_mode", null);
            if (cursorRawQuery2 != null) {
                try {
                    if (cursorRawQuery2.moveToFirst() && "wal".equalsIgnoreCase(cursorRawQuery2.getString(0))) {
                        Cursor cursorRawQuery3 = sQLiteDatabase.rawQuery("pragma wal_checkpoint", null);
                        if (cursorRawQuery3 != null) {
                            try {
                                if (cursorRawQuery3.moveToFirst()) {
                                    C11839m.m70688i("CloudBackupDbManager", "flushDB  WAL cache , walBusy = " + cursorRawQuery3.getInt(0) + ", walLog = " + cursorRawQuery3.getInt(1) + ", walCheckPointed = " + cursorRawQuery3.getInt(2));
                                }
                            } finally {
                            }
                        }
                        if (cursorRawQuery3 != null) {
                            cursorRawQuery3.close();
                        }
                    }
                } finally {
                }
            }
            if (cursorRawQuery2 != null) {
                cursorRawQuery2.close();
            }
        } catch (Exception e11) {
            C11839m.m70687e("CloudBackupDbManager", "flush DBCache error, " + e11.getMessage());
        }
        sQLiteDatabase.close();
    }

    /* renamed from: d */
    public static void m79419d() {
        C11839m.m70688i("CloudBackupDbManager", "closeStatusDatabase");
        c cVar = c.STATUS;
        C13219m<Object, HashMap<String, SQLiteDatabase>, Function<String, SQLiteOpenHelper>> c13219mM79428m = m79428m(cVar);
        if (c13219mM79428m == null || c13219mM79428m.m79448a()) {
            C11839m.m70689w("CloudBackupDbManager", "closeBackupStatusDatabase dbWrapper == null || dbWrapper invalid");
            return;
        }
        synchronized (c13219mM79428m.m79449b()) {
            HashMap<String, SQLiteDatabase> mapM79450c = c13219mM79428m.m79450c();
            Iterator<Map.Entry<String, SQLiteDatabase>> it = mapM79450c.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, SQLiteDatabase> next = it.next();
                if (next.getKey().startsWith(cVar.name())) {
                    try {
                        m79418c(mapM79450c.get(next.getKey()));
                    } catch (Exception e10) {
                        C11839m.m70688i("CloudBackupDbManager", "closeStatusDatabase error: " + e10.getMessage());
                    }
                    it.remove();
                }
            }
        }
    }

    /* renamed from: e */
    public static void m79420e(String str) {
        C11839m.m70688i("CloudBackupDbManager", "close snapshot meta database: " + str);
        c cVar = c.SNAPSHOT;
        C13219m<Object, HashMap<String, SQLiteDatabase>, Function<String, SQLiteOpenHelper>> c13219mM79428m = m79428m(cVar);
        if (c13219mM79428m == null || c13219mM79428m.m79448a()) {
            C11839m.m70689w("CloudBackupDbManager", "closeOneSnapshotMetaDatabase dbWrapper == null || dbWrapper invalid");
            return;
        }
        synchronized (c13219mM79428m.m79449b()) {
            try {
                HashMap<String, SQLiteDatabase> mapM79450c = c13219mM79428m.m79450c();
                Iterator<Map.Entry<String, SQLiteDatabase>> it = mapM79450c.entrySet().iterator();
                String str2 = cVar + "_" + str;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, SQLiteDatabase> next = it.next();
                    if (next.getKey().equalsIgnoreCase(str2)) {
                        m79418c(mapM79450c.get(next.getKey()));
                        it.remove();
                        break;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public static void m79421f() {
        C11839m.m70688i("CloudBackupDbManager", "close pms brief meta database");
        c cVar = c.PMSBRIEF;
        C13219m<Object, HashMap<String, SQLiteDatabase>, Function<String, SQLiteOpenHelper>> c13219mM79428m = m79428m(cVar);
        if (c13219mM79428m == null || c13219mM79428m.m79448a()) {
            C11839m.m70689w("CloudBackupDbManager", "closeSnapshotMetaDatabase dbWrapper == null || dbWrapper invalid");
            return;
        }
        synchronized (c13219mM79428m.m79449b()) {
            try {
                HashMap<String, SQLiteDatabase> mapM79450c = c13219mM79428m.m79450c();
                Iterator<Map.Entry<String, SQLiteDatabase>> it = mapM79450c.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, SQLiteDatabase> next = it.next();
                    if (next.getKey().startsWith(cVar.name())) {
                        m79418c(mapM79450c.get(next.getKey()));
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g */
    public static void m79422g(String str) {
        C11839m.m70688i("CloudBackupDbManager", "close pms brief meta database: " + str);
        c cVar = c.PMSBRIEF;
        C13219m<Object, HashMap<String, SQLiteDatabase>, Function<String, SQLiteOpenHelper>> c13219mM79428m = m79428m(cVar);
        if (c13219mM79428m == null || c13219mM79428m.m79448a()) {
            C11839m.m70689w("CloudBackupDbManager", "closePmsBriefMetaDatabase dbWrapper == null || dbWrapper invalid");
            return;
        }
        synchronized (c13219mM79428m.m79449b()) {
            try {
                Iterator<Map.Entry<String, SQLiteDatabase>> it = c13219mM79428m.m79450c().entrySet().iterator();
                String str2 = cVar.name() + "_" + str;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, SQLiteDatabase> next = it.next();
                    if (next.getKey().equalsIgnoreCase(str2)) {
                        SQLiteDatabase value = next.getValue();
                        it.remove();
                        m79418c(value);
                        break;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: h */
    public static void m79423h() {
        m79424i(true);
    }

    /* renamed from: i */
    public static void m79424i(boolean z10) {
        C11839m.m70688i("CloudBackupDbManager", "close snapshot meta database");
        c cVar = c.SNAPSHOT;
        C13219m<Object, HashMap<String, SQLiteDatabase>, Function<String, SQLiteOpenHelper>> c13219mM79428m = m79428m(cVar);
        if (c13219mM79428m == null || c13219mM79428m.m79448a()) {
            C11839m.m70689w("CloudBackupDbManager", "closeSnapshotMetaDatabase dbWrapper == null || dbWrapper invalid");
            return;
        }
        synchronized (c13219mM79428m.m79449b()) {
            try {
                HashMap<String, SQLiteDatabase> mapM79450c = c13219mM79428m.m79450c();
                Iterator<Map.Entry<String, SQLiteDatabase>> it = mapM79450c.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, SQLiteDatabase> next = it.next();
                    String key = next.getKey();
                    if (key != null && key.startsWith(cVar.name()) && (z10 || !key.contains("/cloudrestore"))) {
                        m79418c(mapM79450c.get(next.getKey()));
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        m79421f();
    }

    /* renamed from: j */
    public static void m79425j() {
        C11839m.m70688i("CloudBackupDbManager", "closeSnapshotMetaDatabaseAsync start");
        C12515a.m75110o().m75172d(new b());
    }

    /* renamed from: k */
    public static Context m79426k() {
        return C0213f.m1378b();
    }

    /* renamed from: l */
    public static SQLiteDatabase m79427l(c cVar, String str) {
        String strName;
        C13219m<Object, HashMap<String, SQLiteDatabase>, Function<String, SQLiteOpenHelper>> c13219mM79428m = m79428m(cVar);
        if (c13219mM79428m == null || c13219mM79428m.m79448a()) {
            C11839m.m70689w("CloudBackupDbManager", "getDatabase dbWrapper == null || dbWrapper invalid");
            return null;
        }
        synchronized (c13219mM79428m.m79449b()) {
            try {
                if (TextUtils.isEmpty(str)) {
                    strName = cVar.name();
                } else {
                    strName = cVar.name() + "_" + str;
                }
                HashMap<String, SQLiteDatabase> mapM79450c = c13219mM79428m.m79450c();
                SQLiteDatabase writableDatabase = mapM79450c.get(strName);
                if (writableDatabase == null || !writableDatabase.isOpen()) {
                    try {
                        Function<String, SQLiteOpenHelper> functionM79451d = c13219mM79428m.m79451d();
                        if (functionM79451d == null) {
                            C11839m.m70689w("CloudBackupDbManager", "getDatabase func == null");
                            return null;
                        }
                        writableDatabase = functionM79451d.apply(str).getWritableDatabase();
                        mapM79450c.put(strName, writableDatabase);
                    } catch (SQLiteException e10) {
                        C11839m.m70687e("CloudBackupDbManager", "get getDatabase" + cVar + " db error, " + e10.getMessage());
                    }
                }
                return writableDatabase;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: m */
    public static C13219m<Object, HashMap<String, SQLiteDatabase>, Function<String, SQLiteOpenHelper>> m79428m(c cVar) {
        return f59852a.getOrDefault(cVar, null);
    }

    /* renamed from: n */
    public static C13219m<Object, HashMap<String, SQLiteDatabase>, Function<String, SQLiteOpenHelper>> m79429n(Function<String, SQLiteOpenHelper> function) {
        return new C13219m<>(new Object(), new HashMap(), function);
    }

    /* renamed from: o */
    public static boolean m79430o(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return true;
        }
        return sQLiteDatabase.isDatabaseIntegrityOk();
    }

    /* renamed from: p */
    public static void m79431p(InterfaceC14355b interfaceC14355b) throws C9721b {
        C11839m.m70688i("CloudBackupDbManager", "waitSnapshotCloseResult start");
        while (C12515a.m75110o().m75158X0(b.class.getName())) {
            interfaceC14355b.execute();
            SystemClock.sleep(500L);
        }
        C11839m.m70688i("CloudBackupDbManager", "waitSnapshotCloseResult start");
    }
}
