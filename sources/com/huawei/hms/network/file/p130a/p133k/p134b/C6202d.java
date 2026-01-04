package com.huawei.hms.network.file.p130a.p133k.p134b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import java.io.File;
import java.util.Arrays;

/* renamed from: com.huawei.hms.network.file.a.k.b.d */
/* loaded from: classes8.dex */
class C6202d extends SQLiteOpenHelper {

    /* renamed from: a */
    private C6206h f29329a;

    /* renamed from: b */
    private C6206h f29330b;

    public C6202d(Context context) {
        super(context, "DownloadData.db", (SQLiteDatabase.CursorFactory) null, 2);
        this.f29329a = new C6206h("download_request");
        this.f29330b = new C6206h("download_taskinfo");
        this.f29329a.m36123a(new C6199a("requestId", "INTEGER", true, true)).m36123a(new C6199a("name", "TEXT")).m36123a(new C6199a("fileSize", "INTEGER")).m36123a(new C6199a("filePath", "BLOB")).m36123a(new C6199a("status", "INTEGER")).m36123a(new C6199a("fileSha256", "TEXT")).m36123a(new C6199a("startPosition", "INTEGER")).m36123a(new C6199a("manager", "TEXT")).m36123a(new C6199a("headers", "BLOB")).m36123a(new C6199a("params", "BLOB")).m36123a(new C6199a("logInfos", "BLOB")).m36123a(new C6199a("configs", "BLOB")).m36123a(new C6199a("urls", "BLOB")).m36123a(new C6199a("extra", "TEXT"));
        this.f29330b.m36123a(new C6199a("requestId", "INTEGER")).m36123a(new C6199a(ContentRecord.TASK_ID, "INTEGER")).m36123a(new C6199a("start", "INTEGER")).m36123a(new C6199a("end", "INTEGER")).m36123a(new C6199a("finished", "INTEGER")).m36123a(new C6199a("filePath", "BLOB")).m36123a(new C6199a("manager", "TEXT")).m36123a(new C6199a("extra", "TEXT")).m36123a(new C6200b("requestId", ContentRecord.TASK_ID));
    }

    /* renamed from: a */
    private void m36090a(SQLiteDatabase sQLiteDatabase) {
        int i10;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("download_task", null, null, null, null, null, null, null);
                i10 = 0;
                while (!cursorQuery.isClosed() && cursorQuery.moveToNext()) {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("filePath"));
                        i10++;
                        if (!TextUtils.isEmpty(string)) {
                            long j10 = cursorQuery.getLong(cursorQuery.getColumnIndex(ContentRecord.TASK_ID));
                            File file = new File(string + ".tmp");
                            if (new File(string + ".tmp").exists()) {
                                boolean zRenameTo = file.renameTo(new File(string + ".tmp" + j10));
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("rename result:");
                                sb2.append(zRenameTo);
                                FLogger.m36350d("DBHelper", sb2.toString(), new Object[0]);
                            }
                            ContentValues contentValues = new ContentValues();
                            AbstractC6201c.m36076a(contentValues, "filePath", StringUtils.str2Byte(string));
                            FLogger.m36350d("DBHelper", "update result:" + sQLiteDatabase.update("download_request", contentValues, "requestId=?", new String[]{String.valueOf(j10)}), new Object[0]);
                        }
                    } catch (Exception e10) {
                        e = e10;
                        FLogger.logException(e);
                        C6204f.m36107a(cursorQuery);
                        FLogger.m36350d("DBHelper", "renameTmpFilesAndUpdateFilePath num:" + i10, new Object[0]);
                    }
                }
            } catch (Throwable th2) {
                C6204f.m36107a(cursorQuery);
                throw th2;
            }
        } catch (Exception e11) {
            e = e11;
            i10 = 0;
        }
        C6204f.m36107a(cursorQuery);
        FLogger.m36350d("DBHelper", "renameTmpFilesAndUpdateFilePath num:" + i10, new Object[0]);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        FLogger.m36353i("DBHelper", "onCreate", new Object[0]);
        m36091a(sQLiteDatabase, this.f29329a.m36124a(), this.f29330b.m36124a());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        FLogger.m36353i("DBHelper", "onUpgrade oldVersion:" + i10 + "," + i11, new Object[0]);
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (i10 <= 1) {
                    sQLiteDatabase.execSQL(this.f29329a.m36124a());
                    sQLiteDatabase.execSQL(this.f29330b.m36124a());
                    if (i11 == 2) {
                        sQLiteDatabase.execSQL("insert into download_request (requestId,name,fileSize,status,fileSha256,startPosition,manager) select taskId,name,fileSize,status,fileSha256,startPostition,manager from download_task");
                        sQLiteDatabase.execSQL("insert into download_taskinfo (requestId,taskId,start,end,finished,filePath,manager) select taskId,sliceId,start,end,finished,'', manager from download_slice");
                        m36090a(sQLiteDatabase);
                        sQLiteDatabase.execSQL("drop table download_task");
                        sQLiteDatabase.execSQL("drop table download_slice");
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                FLogger.m36353i("DBHelper", "onUpgrade success", new Object[0]);
            } catch (Exception e10) {
                FLogger.m36352e("DBHelper", "onUpgrade error", e10);
                FLogger.m36354v("DBHelper", "onUpgrade error:" + e10.getMessage() + ",for:" + e10.getMessage());
            }
            C6204f.m36108a(sQLiteDatabase, "when endTransaction has error!,this time is onUpgrade");
        } catch (Throwable th2) {
            C6204f.m36108a(sQLiteDatabase, "when endTransaction has error!,this time is onUpgrade");
            throw th2;
        }
    }

    /* renamed from: a */
    private void m36091a(SQLiteDatabase sQLiteDatabase, String... strArr) {
        FLogger.m36354v("DBHelper", Arrays.toString(strArr));
        try {
            try {
                sQLiteDatabase.beginTransaction();
                for (String str : strArr) {
                    sQLiteDatabase.execSQL(str);
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (RuntimeException unused) {
                FLogger.m36355w("DBHelper", "excuteSafely is runtimeException", new Object[0]);
            }
            C6204f.m36108a(sQLiteDatabase, "when endTransaction has error!,this time is excuteSafely");
        } catch (Throwable th2) {
            C6204f.m36108a(sQLiteDatabase, "when endTransaction has error!,this time is excuteSafely");
            throw th2;
        }
    }
}
