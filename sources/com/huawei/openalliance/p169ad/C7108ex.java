package com.huawei.openalliance.p169ad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.huawei.openalliance.p169ad.p171db.bean.AnalysisEventRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ClickEventRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EventMonitorRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ImpEventRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ThirdPartyEventRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.ex */
/* loaded from: classes8.dex */
public class C7108ex extends AbstractC7100ep implements InterfaceC7138fv {

    /* renamed from: c */
    private static C7108ex f32754c;

    /* renamed from: d */
    private static final byte[] f32755d = new byte[0];

    public C7108ex(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7138fv
    /* renamed from: a */
    public long mo43159a(Class<? extends EventRecord> cls, EventRecord eventRecord) {
        return m42981a(cls, eventRecord.m41863d(this.f32709a));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7138fv
    /* renamed from: b */
    public List<ThirdPartyEventRecord> mo43171b(long j10, int i10) {
        return m42984a(ThirdPartyEventRecord.class, null, EnumC7125fi.THIER_PARTY_EVENT_UPLOAD_ITEMS_WHERE, new String[]{String.valueOf(AbstractC7741ao.m47566c() - j10)}, "lastReportTime asc", String.valueOf(i10));
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7100ep
    /* renamed from: e */
    public void mo42990e() {
        super.mo42990e();
        m42979a(EventRecord.class, (EnumC7125fi) null, (String[]) null);
        m42979a(ImpEventRecord.class, (EnumC7125fi) null, (String[]) null);
        m42979a(ClickEventRecord.class, (EnumC7125fi) null, (String[]) null);
        m42979a(AnalysisEventRecord.class, (EnumC7125fi) null, (String[]) null);
        m42979a(ThirdPartyEventRecord.class, (EnumC7125fi) null, (String[]) null);
    }

    /* renamed from: a */
    public EventMonitorRecord m43160a(String str) {
        List listM42984a = m42984a(EventMonitorRecord.class, null, EnumC7125fi.EVENT_MONITOR_RECORD_BY_EVENT_ID_WHERE, new String[]{str}, null, null);
        if (AbstractC7760bg.m47767a(listM42984a)) {
            return null;
        }
        return (EventMonitorRecord) listM42984a.get(0);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7138fv
    /* renamed from: b */
    public void mo43172b(long j10, List<String> list) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("lastReportTime", Long.valueOf(j10));
        m42988a(ThirdPartyEventRecord.class, contentValues, EnumC7125fi.THIRD_PARTY_EVENT_UPDATE_BY_ID_WHERE, list);
    }

    /* renamed from: a */
    public static C7108ex m43156a(Context context) {
        C7108ex c7108ex;
        synchronized (f32755d) {
            try {
                if (f32754c == null) {
                    f32754c = new C7108ex(context);
                }
                c7108ex = f32754c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7108ex;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7138fv
    /* renamed from: b */
    public void mo43173b(Class<? extends EventRecord> cls, List<String> list) {
        m42978a(cls, EnumC7125fi.EVENT_DELETE_BY_ID_WHERE, list);
    }

    /* renamed from: a */
    private List<String> m43157a() {
        ArrayList arrayList = new ArrayList();
        List listM42984a = m42984a(EventMonitorRecord.class, new String[]{EventMonitorRecord.EVENT_ID}, null, null, "addTime asc", null);
        if (!AbstractC7760bg.m47767a(listM42984a)) {
            Iterator it = listM42984a.iterator();
            while (it.hasNext()) {
                arrayList.add(((EventMonitorRecord) it.next()).m41660a());
            }
        }
        return arrayList;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7138fv
    /* renamed from: a */
    public Map<String, EventRecord> mo43161a(Class<? extends EventRecord> cls, int i10) {
        return m43162a(cls, (String[]) null, "_id desc", String.valueOf(i10));
    }

    /* renamed from: a */
    public Map<String, EventRecord> m43162a(Class<? extends EventRecord> cls, String[] strArr, String str, String str2) throws Throwable {
        C7015dd c7015ddM41894a;
        String str3;
        HashMap map = new HashMap();
        Cursor cursorM41909a = null;
        try {
            c7015ddM41894a = C7015dd.m41894a(this.f32709a);
        } catch (Throwable th2) {
            th = th2;
            c7015ddM41894a = null;
        }
        try {
            cursorM41909a = c7015ddM41894a.m41909a(cls.getSimpleName(), strArr, null, null, str, str2);
            if (cursorM41909a != null) {
                while (cursorM41909a.moveToNext()) {
                    try {
                        try {
                            EventRecord eventRecordNewInstance = cls.newInstance();
                            eventRecordNewInstance.m41856a(cursorM41909a);
                            map.put(eventRecordNewInstance.m41748i(), eventRecordNewInstance);
                        } catch (RuntimeException e10) {
                            str3 = "query RuntimeException:" + e10.getClass().getSimpleName();
                            AbstractC7185ho.m43826d("EventDao", str3);
                        }
                    } catch (Exception e11) {
                        str3 = "query exception:" + e11.getClass().getSimpleName();
                        AbstractC7185ho.m43826d("EventDao", str3);
                    }
                }
            }
            m42986a(cursorM41909a);
            m42987a(c7015ddM41894a);
            return map;
        } catch (Throwable th3) {
            th = th3;
            m42986a(cursorM41909a);
            m42987a(c7015ddM41894a);
            throw th;
        }
    }

    /* renamed from: a */
    private void m43158a(int i10) {
        List<String> listM43157a = m43157a();
        AbstractC7185ho.m43818a("EventDao", "delete over: size:%s, limit:%s", Integer.valueOf(listM43157a.size()), Integer.valueOf(i10));
        int size = listM43157a.size() - i10;
        if (size <= 0) {
            return;
        }
        m42978a(EventMonitorRecord.class, EnumC7125fi.EVENT_MONITOR_RECORD_UPDATE_BY_EVENT_ID_WHERE, listM43157a.subList(0, size));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7138fv
    /* renamed from: a */
    public void mo43163a(long j10, int i10) {
        EnumC7125fi enumC7125fi = EnumC7125fi.EVENT_DELETE_EXPIRE_WHERE;
        m42979a(EventRecord.class, enumC7125fi, new String[]{String.valueOf(j10), String.valueOf(i10)});
        m42979a(ImpEventRecord.class, enumC7125fi, new String[]{String.valueOf(j10), String.valueOf(i10)});
        m42979a(ClickEventRecord.class, enumC7125fi, new String[]{String.valueOf(j10), String.valueOf(i10)});
        m42979a(AnalysisEventRecord.class, enumC7125fi, new String[]{String.valueOf(j10), String.valueOf(i10)});
        m42979a(ThirdPartyEventRecord.class, EnumC7125fi.THIRD_PARTY_EVENT_DELETE_EXPIRE_WHERE, new String[]{String.valueOf(j10), String.valueOf(i10)});
        m42979a(EventMonitorRecord.class, EnumC7125fi.EVENT_MONITOR_RECORD_DELETE_EXPIRE_WHERE, new String[]{String.valueOf(j10), String.valueOf(i10)});
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7138fv
    /* renamed from: a */
    public void mo43164a(long j10, List<String> list) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ThirdPartyEventRecord.LOCK_TIME, Long.valueOf(j10));
        m42988a(ThirdPartyEventRecord.class, contentValues, EnumC7125fi.THIRD_PARTY_EVENT_UPDATE_BY_ID_WHERE, list);
    }

    /* renamed from: a */
    public void m43165a(EventMonitorRecord eventMonitorRecord, int i10) {
        m42981a(EventMonitorRecord.class, eventMonitorRecord.m41863d(this.f32709a));
        m43158a(i10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7138fv
    /* renamed from: a */
    public void mo43166a(ThirdPartyEventRecord thirdPartyEventRecord) {
        m42981a(ThirdPartyEventRecord.class, thirdPartyEventRecord.m41863d(this.f32709a));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7138fv
    /* renamed from: a */
    public void mo43167a(Class<? extends EventRecord> cls, String str, String str2, long j10, List<String> list) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("lastReportTime", str);
        contentValues.put(EventRecord.LAST_FAIL_REASON, str2);
        contentValues.put(EventRecord.REPEATED_COUNT, Long.valueOf(j10));
        m42988a(cls, contentValues, EnumC7125fi.EVENT_REPORT_FAILED_UPDATE_BY_ID_WHERE, list);
    }

    /* renamed from: a */
    public void m43168a(String str, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EventMonitorRecord.ADD_TIME, Long.valueOf(j10));
        m42977a(EventMonitorRecord.class, contentValues, EnumC7125fi.EVENT_MONITOR_RECORD_UPDATE_BY_EVENT_ID_WHERE, new String[]{str});
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7138fv
    /* renamed from: a */
    public void mo43169a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("requestId", str2);
        m42977a(ThirdPartyEventRecord.class, contentValues, EnumC7125fi.THIRD_PARTY_EVENT_UPDATE_BY_ID_WHERE, new String[]{str});
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7138fv
    /* renamed from: a */
    public void mo43170a(List<String> list) {
        m42978a(ThirdPartyEventRecord.class, EnumC7125fi.THIRD_PARTY_EVENT_DELETE_BY_ID_WHERE, list);
    }
}
