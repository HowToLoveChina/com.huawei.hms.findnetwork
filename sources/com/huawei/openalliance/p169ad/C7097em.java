package com.huawei.openalliance.p169ad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.huawei.openalliance.p169ad.p171db.bean.AppDataCollectionRecord;
import com.huawei.openalliance.p169ad.p171db.bean.C7013a;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.em */
/* loaded from: classes8.dex */
public class C7097em extends AbstractC7100ep {

    /* renamed from: c */
    private static C7097em f32695c;

    /* renamed from: d */
    private static final byte[] f32696d = new byte[0];

    /* renamed from: e */
    private static final byte[] f32697e = new byte[0];

    public C7097em(Context context) {
        super(context);
    }

    /* renamed from: a */
    public long m42959a(List<AppDataCollectionRecord> list) {
        long jM42982a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (AbstractC7760bg.m47767a(list) || this.f32709a == null) {
            return -1L;
        }
        synchronized (f32696d) {
            ArrayList arrayList = new ArrayList();
            Iterator<AppDataCollectionRecord> it = list.iterator();
            while (it.hasNext()) {
                try {
                    ContentValues contentValuesM41863d = it.next().m41863d(this.f32709a);
                    if (contentValuesM41863d != null) {
                        arrayList.add(contentValuesM41863d);
                    }
                } catch (Exception unused) {
                    AbstractC7185ho.m43823c("AppDataCollectionRecordDao", "convert to record error");
                }
            }
            jM42982a = m42982a(m42960a(), arrayList);
        }
        AbstractC7185ho.m43818a("AppDataCollectionRecordDao", "insertAppDataRecords duration: %s ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        return jM42982a;
    }

    /* renamed from: b */
    public int m42962b(List<String> list) {
        if (AbstractC7760bg.m47767a(list)) {
            AbstractC7185ho.m43820b("AppDataCollectionRecordDao", "deleteRecords with empty id list");
            return 0;
        }
        AbstractC7185ho.m43818a("AppDataCollectionRecordDao", "deleteRecords size is : %s", Integer.valueOf(list.size()));
        return m42978a(m42960a(), EnumC7125fi.APP_DATA_COLLECTION_DELETE_WHERE, list);
    }

    /* renamed from: c */
    public long m42964c() {
        return m42980a(m42960a());
    }

    /* renamed from: d */
    public Map<String, Long> m42965d() {
        Cursor cursor;
        HashMap map = new HashMap();
        C7015dd c7015dd = null;
        Cursor cursorM41908a = null;
        try {
            C7015dd c7015ddM41894a = C7015dd.m41894a(this.f32709a);
            try {
                cursorM41908a = c7015ddM41894a.m41908a("SELECT eventType, COUNT(*) as cnt FROM " + m42960a().getSimpleName() + " GROUP BY eventType", (String[]) null);
                if (cursorM41908a != null) {
                    while (cursorM41908a.moveToNext()) {
                        int columnIndex = cursorM41908a.getColumnIndex("eventType");
                        String string = columnIndex != -1 ? cursorM41908a.getString(columnIndex) : "";
                        int columnIndex2 = cursorM41908a.getColumnIndex("cnt");
                        long j10 = columnIndex2 != -1 ? cursorM41908a.getLong(columnIndex2) : 0L;
                        if (!AbstractC7806cz.m48165b(string) && j10 > 0) {
                            map.put(string, Long.valueOf(j10));
                        }
                    }
                }
                m42986a(cursorM41908a);
                m42987a(c7015ddM41894a);
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorM41908a;
                c7015dd = c7015ddM41894a;
                try {
                    AbstractC7185ho.m43824c("AppDataCollectionRecordDao", "query cached app data exception: %s", th.getClass().getSimpleName());
                    return map;
                } finally {
                    m42986a(cursor);
                    m42987a(c7015dd);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        return map;
    }

    /* renamed from: a */
    public static C7097em m42958a(Context context) {
        C7097em c7097em;
        synchronized (f32697e) {
            try {
                if (f32695c == null) {
                    f32695c = new C7097em(context);
                }
                c7097em = f32695c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7097em;
    }

    /* renamed from: b */
    public void m42963b() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(5, -15);
        AbstractC7185ho.m43821b("AppDataCollectionRecordDao", "delete expire records over 15 days, expire times: %s", calendar.getTime());
        m42979a(m42960a(), EnumC7125fi.APP_DATA_COLLECTION_DELETE_EXPIRE_WHERE, new String[]{String.valueOf(calendar.getTime().getTime())});
    }

    /* renamed from: a */
    public Class<? extends C7013a> m42960a() {
        return AppDataCollectionRecord.class;
    }

    /* renamed from: a */
    public List<AppDataCollectionRecord> m42961a(int i10) {
        if (i10 <= 0) {
            i10 = 50;
        }
        return m42984a(m42960a(), null, null, null, "reportTimestamp DESC", String.valueOf(i10));
    }
}
