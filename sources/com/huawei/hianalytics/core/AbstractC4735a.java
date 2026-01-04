package com.huawei.hianalytics.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.DBUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hianalytics.core.a */
/* loaded from: classes5.dex */
public abstract class AbstractC4735a<T> {

    /* renamed from: a */
    public String f21666a;

    /* renamed from: b */
    public SQLiteDatabase f21667b;

    /* renamed from: c */
    public final ContentValues f21668c = new ContentValues();

    /* renamed from: d */
    public SQLiteStatement f21669d;

    public AbstractC4735a(SQLiteDatabase sQLiteDatabase, String str) {
        this.f21667b = sQLiteDatabase;
        this.f21666a = str;
    }

    /* renamed from: a */
    public final int m28782a(String str, String[] strArr) {
        int iDelete = -1;
        try {
            synchronized (this) {
                iDelete = this.f21667b.delete(this.f21666a, str, strArr);
            }
        } catch (Exception e10) {
            HiLog.m28808e("AbstractDao", "deleteSynchronized() error: " + e10.getMessage());
        }
        return iDelete;
    }

    /* renamed from: a */
    public abstract T mo28784a(Cursor cursor);

    /* renamed from: a */
    public abstract void mo28786a(ContentValues contentValues, T t10);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.huawei.hianalytics.core.a, com.huawei.hianalytics.core.a<T>] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hianalytics.core.a] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* renamed from: b */
    public int m28788b(String str, String[] strArr) {
        int iM28782a = -1;
        if (m28787a()) {
            return -1;
        }
        if (this.f21667b.isDbLockedByCurrentThread()) {
            return m28782a(str, strArr);
        }
        this.f21667b.beginTransaction();
        try {
            try {
                iM28782a = m28782a(str, strArr);
                this.f21667b.setTransactionSuccessful();
            } catch (Exception e10) {
                HiLog.m28808e("AbstractDao", e10.getMessage());
            }
            return iM28782a;
        } finally {
            this.f21667b.endTransaction();
        }
    }

    /* renamed from: c */
    public void m28791c() throws SQLException {
        if (m28787a()) {
            return;
        }
        DBUtil.deleteAll(this.f21667b, this.f21666a);
        HiLog.m28809i("AbstractDao", "deleteAll: " + this.f21666a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.huawei.hianalytics.core.a, com.huawei.hianalytics.core.a<T>] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.huawei.hianalytics.core.a] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* renamed from: a */
    public long m28783a(List<T> list, boolean z10) {
        long jM28790b = -1;
        if (m28787a()) {
            return -1L;
        }
        if (this.f21667b.isDbLockedByCurrentThread()) {
            return m28790b(list, z10);
        }
        this.f21667b.beginTransaction();
        try {
            try {
                jM28790b = m28790b(list, z10);
                this.f21667b.setTransactionSuccessful();
            } catch (Exception e10) {
                HiLog.m28808e("AbstractDao", e10.getMessage());
            }
            return jM28790b;
        } finally {
            this.f21667b.endTransaction();
        }
    }

    /* renamed from: b */
    public long mo28789b() {
        if (this.f21669d == null) {
            this.f21669d = this.f21667b.compileStatement("SELECT COUNT(*) FROM \"" + this.f21666a + '\"');
        }
        return this.f21669d.simpleQueryForLong();
    }

    /* renamed from: a */
    public List<T> m28785a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f21667b.query(this.f21666a, strArr, str, strArr2, null, null, str4, str5);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(mo28784a(cursorQuery));
                }
            } catch (Exception e10) {
                HiLog.m28808e("AbstractDao", e10.getMessage());
                if (cursorQuery != null) {
                }
            }
            cursorQuery.close();
            return arrayList;
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: b */
    public final long m28790b(List<T> list, boolean z10) {
        long jInsertWithOnConflict;
        long j10 = -1;
        try {
            synchronized (this) {
                jInsertWithOnConflict = -1;
                for (int i10 = 0; i10 < list.size(); i10++) {
                    try {
                        mo28786a(this.f21668c, (ContentValues) list.get(i10));
                        jInsertWithOnConflict = z10 ? this.f21667b.insertWithOnConflict(this.f21666a, null, this.f21668c, 5) : this.f21667b.insert(this.f21666a, null, this.f21668c);
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Exception e10) {
                            e = e10;
                            j10 = jInsertWithOnConflict;
                            HiLog.m28808e("AbstractDao", "insertOrReplace() error: " + e.getMessage());
                            return j10;
                        }
                    }
                }
            }
            return jInsertWithOnConflict;
        } catch (Exception e11) {
            e = e11;
        }
    }

    /* renamed from: a */
    public boolean m28787a() {
        return this.f21667b == null;
    }
}
