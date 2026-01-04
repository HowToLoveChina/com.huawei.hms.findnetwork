package com.huawei.hms.network.file.p130a.p133k.p134b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.p130a.p133k.p134b.p135j.C6209b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.huawei.hms.network.file.a.k.b.c */
/* loaded from: classes8.dex */
public abstract class AbstractC6201c<T> {

    /* renamed from: a */
    private SQLiteDatabase f29328a;

    public AbstractC6201c(SQLiteDatabase sQLiteDatabase) {
        this.f29328a = sQLiteDatabase;
    }

    /* renamed from: a */
    public abstract ContentValues mo36077a(T t10, String str);

    /* renamed from: a */
    public abstract T mo36078a(Cursor cursor);

    /* renamed from: a */
    public abstract String mo36079a();

    /* renamed from: a */
    public List<T> m36080a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                this.f29328a.beginTransaction();
                cursorQuery = this.f29328a.query(mo36079a(), strArr, str, strArr2, str2, str3, str4, str5);
                while (!cursorQuery.isClosed() && cursorQuery.moveToNext()) {
                    arrayList.add(mo36078a(cursorQuery));
                }
                this.f29328a.setTransactionSuccessful();
            } catch (Exception e10) {
                FLogger.logException(e10);
            }
            C6204f.m36107a(cursorQuery);
            C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is query");
            return arrayList;
        } catch (Throwable th2) {
            C6204f.m36107a(cursorQuery);
            C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is query");
            throw th2;
        }
    }

    /* renamed from: b */
    public List<T> m36086b(String str, String[] strArr) {
        return m36080a(null, str, strArr, null, null, null, null);
    }

    /* renamed from: c */
    public T m36089c(String str, String[] strArr) {
        List<T> listM36080a = m36080a(null, str, strArr, null, null, null, "1");
        if (listM36080a.size() > 0) {
            return listM36080a.get(0);
        }
        return null;
    }

    /* renamed from: a */
    public Set<Long> m36081a(String str, String str2, String[] strArr, String str3) {
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = null;
        try {
            try {
                this.f29328a.beginTransaction();
                cursorQuery = this.f29328a.query(mo36079a(), new String[]{str}, str2, strArr, null, null, null, str3);
                while (!cursorQuery.isClosed() && cursorQuery.moveToNext()) {
                    hashSet.add(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex(str))));
                }
                this.f29328a.setTransactionSuccessful();
            } catch (Exception e10) {
                FLogger.logException(e10);
            }
            C6204f.m36107a(cursorQuery);
            C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is queryRequuestIds");
            return hashSet;
        } catch (Throwable th2) {
            C6204f.m36107a(cursorQuery);
            C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is queryRequuestIds");
            throw th2;
        }
    }

    /* renamed from: b */
    public boolean m36087b(T t10, String str) {
        if (t10 == null) {
            return false;
        }
        try {
            try {
                this.f29328a.beginTransaction();
                if (this.f29328a.insert(mo36079a(), null, mo36077a((AbstractC6201c<T>) t10, str)) == -1) {
                    FLogger.m36355w("DBDao", "insert error", new Object[0]);
                }
                this.f29328a.setTransactionSuccessful();
                C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is insert");
                return true;
            } catch (Exception e10) {
                FLogger.logException(e10);
                C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is insert");
                return false;
            }
        } catch (Throwable th2) {
            C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is insert");
            throw th2;
        }
    }

    /* renamed from: a */
    public static void m36076a(ContentValues contentValues, String str, byte[] bArr) {
        try {
            contentValues.put(str, C6209b.m36134b(bArr));
        } catch (Exception unused) {
            FLogger.m36351e("DBDao", "putBlobWithEncrypt exception");
        }
    }

    /* renamed from: b */
    public boolean m36088b(List<T> list, String str) {
        if (list == null) {
            return false;
        }
        try {
            try {
                this.f29328a.beginTransaction();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (this.f29328a.replace(mo36079a(), null, mo36077a((AbstractC6201c<T>) it.next(), str)) == -1) {
                        FLogger.m36355w("DBDao", "for replace error", new Object[0]);
                    }
                }
                this.f29328a.setTransactionSuccessful();
                C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is replace");
                return true;
            } catch (Exception e10) {
                FLogger.logException(e10);
                C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is replace");
                return false;
            }
        } catch (Throwable th2) {
            C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is replace");
            throw th2;
        }
    }

    /* renamed from: a */
    public boolean m36082a(ContentValues contentValues, String str, String[] strArr) {
        try {
            try {
                FLogger.m36354v("DBDao", "update " + str + "," + contentValues);
                this.f29328a.beginTransaction();
                int iUpdate = this.f29328a.update(mo36079a(), contentValues, str, strArr);
                if (iUpdate < 1) {
                    FLogger.m36355w("DBDao", "update error:" + iUpdate + ",tableName:" + mo36079a(), new Object[0]);
                }
                this.f29328a.setTransactionSuccessful();
                C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is update");
                return true;
            } catch (Exception e10) {
                FLogger.logException(e10);
                C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is update");
                return false;
            }
        } catch (Throwable th2) {
            C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is update");
            throw th2;
        }
    }

    /* renamed from: a */
    public boolean m36083a(String str, String[] strArr) {
        try {
            try {
                this.f29328a.beginTransaction();
                if (this.f29328a.delete(mo36079a(), str, strArr) < 1) {
                    FLogger.m36355w("DBDao", "delete error", new Object[0]);
                }
                this.f29328a.setTransactionSuccessful();
                C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is delete");
                return true;
            } catch (Exception e10) {
                FLogger.logException(e10);
                C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is delete");
                return false;
            }
        } catch (Throwable th2) {
            C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is delete");
            throw th2;
        }
    }

    /* renamed from: a */
    public boolean m36084a(List<T> list, String str) {
        if (list == null) {
            return false;
        }
        try {
            try {
                this.f29328a.beginTransaction();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (this.f29328a.insert(mo36079a(), null, mo36077a((AbstractC6201c<T>) it.next(), str)) == -1) {
                        FLogger.m36355w("DBDao", "for insert error", new Object[0]);
                    }
                }
                this.f29328a.setTransactionSuccessful();
                C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is insert list");
                return true;
            } catch (Exception e10) {
                FLogger.logException(e10);
                C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is insert list");
                return false;
            }
        } catch (Throwable th2) {
            C6204f.m36108a(this.f29328a, "when endTransaction has error!,this time is insert list");
            throw th2;
        }
    }

    /* renamed from: a */
    public byte[] m36085a(Cursor cursor, String str) {
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(str));
            return blob != null ? C6209b.m36133a(blob) : blob;
        } catch (Exception e10) {
            FLogger.m36355w("DBDao", "getBytesBoException exception for:" + str, new Object[0]);
            FLogger.logException(e10);
            return null;
        }
    }
}
