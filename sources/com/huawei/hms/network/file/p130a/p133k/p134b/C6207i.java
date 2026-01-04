package com.huawei.hms.network.file.p130a.p133k.p134b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.p130a.C6188d;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import java.util.List;

/* renamed from: com.huawei.hms.network.file.a.k.b.i */
/* loaded from: classes8.dex */
public class C6207i extends AbstractC6201c<C6188d> {
    public C6207i(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public ContentValues a2(C6188d c6188d, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("requestId", Long.valueOf(c6188d.m36341p().getId()));
        contentValues.put(ContentRecord.TASK_ID, Long.valueOf(c6188d.mo36241f()));
        contentValues.put("end", Long.valueOf(c6188d.m36031y()));
        contentValues.put("start", Long.valueOf(c6188d.m36019A()));
        AbstractC6201c.m36076a(contentValues, "filePath", StringUtils.str2Byte(Utils.nullStrToEmpty(c6188d.m36032z())));
        contentValues.put("finished", Long.valueOf(c6188d.mo36239c()));
        contentValues.put("manager", str);
        return contentValues;
    }

    @Override // com.huawei.hms.network.file.p130a.p133k.p134b.AbstractC6201c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ContentValues mo36077a(C6188d c6188d, String str) {
        return a2(c6188d, str);
    }

    /* renamed from: c */
    public void m36128c(List<C6188d> list, String str) {
        m36084a((List) list, str);
    }

    /* renamed from: d */
    public void m36129d(List<C6188d> list, String str) {
        if (Utils.isEmpty(list)) {
            return;
        }
        for (C6188d c6188d : list) {
            if (c6188d.m36341p() != null) {
                m36082a(a2(c6188d, str), "taskId=? and manager=?", new String[]{String.valueOf(c6188d.mo36241f()), str});
            }
        }
    }

    /* renamed from: b */
    public List<C6188d> m36127b(long j10, String str) {
        return m36086b("requestId=? and manager=?", new String[]{String.valueOf(j10), str});
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hms.network.file.p130a.p133k.p134b.AbstractC6201c
    /* renamed from: a */
    public C6188d mo36078a(Cursor cursor) {
        long j10 = cursor.getLong(cursor.getColumnIndex("start"));
        long j11 = cursor.getLong(cursor.getColumnIndex("end"));
        byte[] bArrM36085a = m36085a(cursor, "filePath");
        return new C6188d(cursor.getLong(cursor.getColumnIndex("finished")), j10, j11, bArrM36085a != null ? StringUtils.byte2Str(bArrM36085a) : "", cursor.getLong(cursor.getColumnIndex(ContentRecord.TASK_ID)));
    }

    @Override // com.huawei.hms.network.file.p130a.p133k.p134b.AbstractC6201c
    /* renamed from: a */
    public String mo36079a() {
        return "download_taskinfo";
    }

    /* renamed from: a */
    public void m36125a(long j10, String str) {
        m36083a("requestId=? and manager=?", new String[]{String.valueOf(j10), str});
    }
}
