package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.p171db.bean.DeletedContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ew */
/* loaded from: classes8.dex */
public class C7107ew extends AbstractC7100ep {

    /* renamed from: c */
    private static C7107ew f32752c;

    /* renamed from: d */
    private static final byte[] f32753d = new byte[0];

    public C7107ew(Context context) {
        super(context);
    }

    /* renamed from: a */
    public DeletedContentRecord m43151a(String str) {
        List listM42984a = m42984a(DeletedContentRecord.class, new String[]{"contentId"}, EnumC7125fi.DELETED_CONTENT_BY_ID_WHERE, new String[]{str}, null, null);
        if (listM42984a.isEmpty()) {
            return null;
        }
        return (DeletedContentRecord) listM42984a.get(0);
    }

    /* renamed from: b */
    public void m43154b() {
        long jM47566c = AbstractC7741ao.m47566c() - 604800000;
        AbstractC7185ho.m43818a("DeletedContentRecordDao", "deleteExpireIds where updateTime before %s", Long.valueOf(jM47566c));
        m42979a(DeletedContentRecord.class, EnumC7125fi.DELETED_CONTENT_EXPIRE_WHERE, new String[]{String.valueOf(jM47566c)});
    }

    /* renamed from: a */
    public static C7107ew m43149a(Context context) {
        C7107ew c7107ew;
        synchronized (f32753d) {
            try {
                if (f32752c == null) {
                    f32752c = new C7107ew(context);
                }
                c7107ew = f32752c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7107ew;
    }

    /* renamed from: b */
    public void m43155b(DeletedContentRecord deletedContentRecord) {
        if (deletedContentRecord == null) {
            return;
        }
        synchronized (f32753d) {
            try {
                String strM41651a = deletedContentRecord.m41651a();
                if (m43151a(strM41651a) != null) {
                    m42977a(DeletedContentRecord.class, deletedContentRecord.m41863d(this.f32709a), EnumC7125fi.DELETED_CONTENT_BY_ID_WHERE, new String[]{strM41651a});
                } else {
                    m43153a(deletedContentRecord);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public List<String> m43152a() {
        return m43150a(m42984a(DeletedContentRecord.class, new String[]{"contentId"}, EnumC7125fi.DELETED_CONTENT_IDS_WHERE, new String[]{String.valueOf(AbstractC7741ao.m47566c() - 604800000)}, null, null));
    }

    /* renamed from: a */
    private List<String> m43150a(List<DeletedContentRecord> list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<DeletedContentRecord> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m41651a());
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m43153a(DeletedContentRecord deletedContentRecord) {
        m42981a(DeletedContentRecord.class, deletedContentRecord.m41863d(this.f32709a));
    }
}
