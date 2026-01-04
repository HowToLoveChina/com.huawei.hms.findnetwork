package com.huawei.hianalytics;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.DaoManager;

/* renamed from: com.huawei.hianalytics.o */
/* loaded from: classes5.dex */
public class C4796o extends SQLiteOpenHelper {

    /* renamed from: a */
    public static volatile C4796o f21884a;

    public C4796o(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        super(context, str, cursorFactory, i10);
    }

    /* renamed from: a */
    public static C4796o m28972a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        if (f21884a == null) {
            synchronized (C4796o.class) {
                try {
                    if (f21884a == null) {
                        f21884a = new C4796o(context, str, null, i10);
                    }
                } finally {
                }
            }
        }
        return f21884a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) throws SQLException {
        super.onConfigure(sQLiteDatabase);
        try {
            sQLiteDatabase.execSQL("PRAGMA synchronous = OFF");
        } catch (SQLException unused) {
            HiLog.m28808e("HaOpenHelper", "execSQL synchronous OFF SQLException");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        DaoManager.getInstance().createEventTable(sQLiteDatabase);
        DaoManager.getInstance().createHeaderTable(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        HiLog.m28810si("HaOpenHelper", "upgrade run");
        try {
            C4785j.m28915a(sQLiteDatabase);
            HiLog.m28810si("HaOpenHelper", "upgrade run success");
        } catch (Exception unused) {
            HiLog.m28808e("HaOpenHelper", "onUpgrade error");
            DaoManager.getInstance().dropAllTable(sQLiteDatabase);
            DaoManager.getInstance().createEventTable(sQLiteDatabase);
            DaoManager.getInstance().createHeaderTable(sQLiteDatabase);
        }
    }
}
