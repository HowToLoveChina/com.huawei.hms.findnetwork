package com.huawei.hms.network.file.p130a.p133k.p134b;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.huawei.hms.network.file.core.C6227e;
import com.huawei.hms.network.file.core.task.InterfaceC6234e;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.download.api.GetRequest;
import com.huawei.hms.network.file.p130a.C6188d;
import com.huawei.hms.network.file.p130a.p133k.InterfaceC6198a;
import java.util.List;
import java.util.Set;

/* renamed from: com.huawei.hms.network.file.a.k.b.e */
/* loaded from: classes8.dex */
public class C6203e implements InterfaceC6198a<GetRequest, C6188d> {

    /* renamed from: d */
    private static volatile C6203e f29331d;

    /* renamed from: a */
    private C6205g f29332a;

    /* renamed from: b */
    private C6207i f29333b;

    /* renamed from: c */
    private volatile boolean f29334c;

    private C6203e(Context context) {
        this.f29334c = false;
        if (context == null) {
            FLogger.m36351e("DownloadDataDaoImpl", "context is null, must call init method to set context");
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("download_move2DE_records", 0);
        if (sharedPreferences.getBoolean("DownloadData.db", false)) {
            FLogger.m36353i("DownloadDataDaoImpl", "the db has moved!", new Object[0]);
        } else {
            Context applicationContext = context.getApplicationContext();
            if (context.moveDatabaseFrom(applicationContext, "DownloadData.db")) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putBoolean("DownloadData.db", true);
                editorEdit.apply();
                FLogger.m36353i("DownloadDataDaoImpl", "the package file has moved to user_de", new Object[0]);
            } else {
                FLogger.m36355w("DownloadDataDaoImpl", "moveDatabaseFrom failed! use sysContext continue", new Object[0]);
                context = applicationContext;
            }
        }
        try {
            SQLiteDatabase writableDatabase = new C6202d(context).getWritableDatabase();
            this.f29332a = new C6205g(writableDatabase);
            this.f29333b = new C6207i(writableDatabase);
            this.f29334c = true;
        } catch (SQLiteException e10) {
            FLogger.m36355w("DownloadDataDaoImpl", "the sqlite is not available!", e10);
            FLogger.m36353i("DownloadDataDaoImpl", "this time for dbWriting, dbWrite == null", new Object[0]);
        } catch (RuntimeException e11) {
            FLogger.m36355w("DownloadDataDaoImpl", "create DB RuntimeException", e11);
        }
    }

    /* renamed from: a */
    public static C6203e m36092a(Context context) {
        if (f29331d == null) {
            synchronized (C6203e.class) {
                try {
                    if (f29331d == null) {
                        f29331d = new C6203e(context);
                    }
                } finally {
                }
            }
        }
        return f29331d;
    }

    /* renamed from: b */
    public void m36101b(long j10, String str) {
        this.f29333b.m36125a(j10, str);
    }

    /* renamed from: c */
    public C6227e<GetRequest> m36104c(long j10, String str) {
        return this.f29332a.m36112a(j10);
    }

    /* renamed from: d */
    public List<C6188d> m36105d(long j10, String str) {
        return this.f29333b.m36127b(j10, str);
    }

    /* renamed from: a */
    public String m36093a(long j10, String str) {
        return this.f29332a.m36113a(j10, str);
    }

    /* renamed from: b */
    public void m36102b(long j10, List<C6188d> list, String str) {
        this.f29333b.m36088b((List) list, str);
    }

    /* renamed from: a */
    public List<C6227e<GetRequest>> m36094a(String str) {
        return this.f29332a.m36122c(str);
    }

    /* renamed from: b */
    public void m36103b(GetRequest getRequest, InterfaceC6234e.a aVar, String str) {
        this.f29332a.m36116a(getRequest.getId(), aVar, str);
    }

    /* renamed from: a */
    public Set<Long> m36095a(String str, int i10) {
        return this.f29332a.m36115a(str, i10);
    }

    /* renamed from: a */
    public void m36096a(long j10, List<C6188d> list, String str) {
        this.f29333b.m36128c(list, str);
    }

    /* renamed from: a */
    public void m36097a(GetRequest getRequest, InterfaceC6234e.a aVar, String str) {
        this.f29332a.m36119a(getRequest, aVar, str);
    }

    /* renamed from: a */
    public void m36098a(GetRequest getRequest, String str) {
        this.f29332a.m36087b((C6205g) new C6227e(getRequest, InterfaceC6234e.a.INIT.ordinal()), str);
    }

    /* renamed from: a */
    public void m36099a(List<C6188d> list, String str) {
        this.f29333b.m36129d(list, str);
    }

    /* renamed from: a */
    public boolean m36100a() {
        return this.f29334c;
    }
}
