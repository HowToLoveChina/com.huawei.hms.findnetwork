package com.huawei.openalliance.p169ad;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.CachedContent;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.Scheme;
import com.huawei.openalliance.p169ad.p171db.bean.C7013a;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7780c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.es */
/* loaded from: classes8.dex */
public class C7103es extends AbstractC7100ep implements InterfaceC7135fs {

    /* renamed from: c */
    private static C7103es f32743c;

    /* renamed from: d */
    private static final byte[] f32744d = new byte[0];

    /* renamed from: e */
    private static final byte[] f32745e = new byte[0];

    public C7103es(Context context) {
        super(context);
    }

    /* renamed from: a */
    private ContentRecord m43093a(EnumC7125fi enumC7125fi, String[] strArr) {
        for (ContentRecord contentRecord : m42984a(mo43104a(), null, enumC7125fi, strArr, "priority asc, displayCount asc, updateTime desc", String.valueOf(4))) {
            String strM41619z = contentRecord.m41619z();
            if (!TextUtils.isEmpty(strM41619z) && strM41619z.startsWith(Scheme.CONTENT.toString())) {
                AbstractC7185ho.m43817a("ContentRecordDao", "queryShowContent valid, uri.");
                return contentRecord;
            }
            if (AbstractC7731ae.m47462c(this.f32709a, strM41619z, Constants.NORMAL_CACHE) || AbstractC7731ae.m47462c(this.f32709a, strM41619z, Constants.TPLATE_CACHE)) {
                AbstractC7185ho.m43818a("ContentRecordDao", "queryShowContent valid: %s", AbstractC7806cz.m48162b(contentRecord));
                return contentRecord;
            }
            AbstractC7185ho.m43818a("ContentRecordDao", "queryShowContent is not valid: %s", AbstractC7806cz.m48162b(contentRecord));
            mo43119b(contentRecord.m41588n(), contentRecord.m41585m());
        }
        return null;
    }

    /* renamed from: f */
    private List<ContentRecord> m43097f(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            Iterator it = m42984a(mo43104a(), new String[]{"contentId", "templateId"}, EnumC7125fi.CONTENT_BY_SLOTID, new String[]{str}, null, null).iterator();
            while (it.hasNext()) {
                arrayList.add((ContentRecord) it.next());
            }
        }
        return arrayList;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: b */
    public List<ContentRecord> mo43113b(String str) {
        return m42984a(mo43104a(), null, EnumC7125fi.CONTENT_BY_ID_WHERE, new String[]{str}, null, null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: c */
    public List<ContentRecord> mo43120c() {
        return m42984a(mo43104a(), new String[]{"contentId", "slotId", ContentRecord.SPLASH_MEDIA_PATH}, EnumC7125fi.CONTENT_EXPIRE_WHERE, new String[]{String.valueOf(AbstractC7741ao.m47566c()), String.valueOf(0)}, null, null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: d */
    public long mo43123d(String str) {
        if (str == null) {
            return 0L;
        }
        List listM42984a = m42984a(mo43104a(), new String[]{ContentRecord.LAST_SHOW_TIME}, EnumC7125fi.CONTENT_BY_TASKID_WHERE, new String[]{str}, "lastShowTime desc", null);
        if (listM42984a.isEmpty()) {
            return 0L;
        }
        return ((ContentRecord) listM42984a.get(0)).m41597q();
    }

    /* renamed from: e */
    public List<CachedContent> m43124e(String str) {
        return m43096d(m43097f(str));
    }

    /* renamed from: d */
    private List<CachedContent> m43096d(List<ContentRecord> list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (ContentRecord contentRecord : list) {
                if (!AbstractC7806cz.m48165b(contentRecord.m41588n()) && !AbstractC7806cz.m48165b(contentRecord.m41463aO())) {
                    List arrayList2 = (List) concurrentHashMap.get(contentRecord.m41588n());
                    if (AbstractC7760bg.m47767a(arrayList2)) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(contentRecord.m41463aO());
                    concurrentHashMap.put(contentRecord.m41588n(), arrayList2);
                }
            }
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                if (entry != null) {
                    arrayList.add(new CachedContent((String) entry.getKey(), 3, (List) entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public ContentRecord mo43098a(String str) {
        List listM42984a = m42984a(mo43104a(), null, EnumC7125fi.CONTENT_BY_ID_WHERE, new String[]{str}, "updateTime desc", String.valueOf(4));
        if (listM42984a.isEmpty()) {
            return null;
        }
        return (ContentRecord) listM42984a.get(0);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: b */
    public List<ContentRecord> mo43114b(String str, int i10, long j10, int i11) {
        ArrayList arrayList = new ArrayList();
        EnumC7125fi enumC7125fi = 1 == i10 ? EnumC7125fi.CONTENT_PORTRAIT_CACHE_SHOW_WHERE : EnumC7125fi.CONTENT_LANDSCAPE_CACHE_SHOW_WHERE;
        long jM47566c = AbstractC7741ao.m47566c();
        for (ContentRecord contentRecord : m42984a(mo43104a(), null, enumC7125fi, new String[]{String.valueOf(jM47566c), String.valueOf(jM47566c), str, String.valueOf(jM47566c - j10), AbstractC7741ao.m47561b("yyyy-MM-dd"), String.valueOf(i11)}, "priority asc, displayCount asc, updateTime desc", String.valueOf(4))) {
            if (!AbstractC7731ae.m47462c(this.f32709a, contentRecord.m41619z(), Constants.NORMAL_CACHE)) {
                Context context = this.f32709a;
                if (!C7780c.m47864a(context, contentRecord, C7780c.m47855a(context, contentRecord))) {
                    mo43119b(contentRecord.m41588n(), contentRecord.m41585m());
                }
            }
            arrayList.add(contentRecord);
        }
        return arrayList;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: c */
    public void mo43121c(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        synchronized (f32744d) {
            try {
                if (mo43102a(contentRecord.m41588n(), contentRecord.m41463aO(), contentRecord.m41585m()) != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("_id");
                    arrayList.add(ContentRecord.DISPLAY_COUNT);
                    arrayList.add(ContentRecord.DISPLAY_DATE);
                    arrayList.add(ContentRecord.SPLASH_MEDIA_PATH);
                    arrayList.add(ContentRecord.LAST_SHOW_TIME);
                    arrayList.add(ContentRecord.FC_CTRL_DATE);
                    mo43117b(contentRecord, arrayList);
                } else {
                    mo43107a(contentRecord);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7100ep
    /* renamed from: e */
    public void mo42990e() {
        super.mo42990e();
        m42979a(mo43104a(), (EnumC7125fi) null, (String[]) null);
    }

    /* renamed from: b */
    private List<String> m43095b(List<ContentRecord> list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ContentRecord> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m41588n());
        }
        return arrayList;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public ContentRecord mo43099a(String str, int i10, long j10, int i11) {
        EnumC7125fi enumC7125fi = 1 == i10 ? EnumC7125fi.CONTENT_PORTRAIT_CACHE_SHOW_WHERE : EnumC7125fi.CONTENT_LANDSCAPE_CACHE_SHOW_WHERE;
        long jM47566c = AbstractC7741ao.m47566c();
        ContentRecord contentRecordM43093a = m43093a(enumC7125fi, new String[]{String.valueOf(jM47566c), String.valueOf(jM47566c), str, String.valueOf(jM47566c - j10), AbstractC7741ao.m47561b("yyyy-MM-dd"), String.valueOf(i11)});
        AbstractC7185ho.m43820b("ContentRecordDao", "queryCacheShowContent " + AbstractC7806cz.m48162b(contentRecordM43093a));
        return contentRecordM43093a;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: c */
    public void mo43122c(String str) {
        AbstractC7185ho.m43818a("ContentRecordDao", "deleteContentById id: %s", str);
        m42979a(mo43104a(), EnumC7125fi.CONTENT_BY_ID_WHERE, new String[]{str});
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public ContentRecord mo43100a(String str, String str2) {
        List listM42984a = m42984a(mo43104a(), null, EnumC7125fi.CONTENT_BY_IDS_WHERE, new String[]{str, str2}, null, null);
        if (listM42984a.isEmpty()) {
            return null;
        }
        return (ContentRecord) listM42984a.get(0);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: b */
    public void mo43115b() {
        ContentValues contentValues = new ContentValues();
        String strM47561b = AbstractC7741ao.m47561b("yyyy-MM-dd");
        contentValues.put(ContentRecord.DISPLAY_DATE, strM47561b);
        contentValues.put(ContentRecord.DISPLAY_COUNT, (Integer) 0);
        m42977a(mo43104a(), contentValues, EnumC7125fi.CONTENT_BY_DATE_NOT_EQUAL_WHERE, new String[]{strM47561b});
    }

    /* renamed from: a */
    public ContentRecord m43101a(String str, String str2, int i10, long j10) {
        return m43093a(1 == i10 ? EnumC7125fi.CONTENT_PORTRAIT_REAL_SHOW_WHERE : EnumC7125fi.CONTENT_LANDSCAPE_REAL_SHOW_WHERE, new String[]{str, str2, String.valueOf(j10), String.valueOf(j10)});
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: b */
    public void mo43116b(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        synchronized (f32744d) {
            try {
                String strM41588n = contentRecord.m41588n();
                String strM41585m = contentRecord.m41585m();
                if (mo43100a(strM41588n, strM41585m) != null) {
                    m42977a(mo43104a(), contentRecord.m41863d(this.f32709a), EnumC7125fi.CONTENT_BY_IDS_WHERE, new String[]{strM41588n, strM41585m});
                } else {
                    mo43107a(contentRecord);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public ContentRecord mo43102a(String str, String str2, String str3) {
        List listM42984a = m42984a(mo43104a(), null, EnumC7125fi.CONTENT_RECORD_BY_IDS, new String[]{str, str2, str3}, null, null);
        if (listM42984a.isEmpty()) {
            return null;
        }
        return (ContentRecord) listM42984a.get(0);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: b */
    public void mo43117b(ContentRecord contentRecord, List<String> list) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        if (contentRecord == null) {
            return;
        }
        ContentValues contentValuesM41863d = contentRecord.m41863d(this.f32709a);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            contentValuesM41863d.remove(it.next());
        }
        m42977a(mo43104a(), contentValuesM41863d, EnumC7125fi.CONTENT_BY_IDS_WHERE, new String[]{contentRecord.m41588n(), contentRecord.m41585m()});
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public ContentRecord mo43103a(String str, String str2, String str3, int i10, long j10) {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: b */
    public void mo43118b(ContentRecord contentRecord, List<String> list, String str) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        AbstractC7185ho.m43817a("ContentRecordDao", "updateContentExcludeById. ");
        if (contentRecord == null) {
            return;
        }
        ContentValues contentValuesM41863d = contentRecord.m41863d(this.f32709a);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            contentValuesM41863d.remove(it.next());
        }
        m42977a(mo43104a(), contentValuesM41863d, EnumC7125fi.CONTENT_BY_ID_WHERE, new String[]{str});
    }

    /* renamed from: a */
    public static C7103es m43094a(Context context) {
        C7103es c7103es;
        synchronized (f32745e) {
            try {
                if (f32743c == null) {
                    f32743c = new C7103es(context);
                }
                c7103es = f32743c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7103es;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: b */
    public void mo43119b(String str, String str2) {
        AbstractC7185ho.m43818a("ContentRecordDao", "deleteContentById id: %s %s", str, str2);
        m42979a(mo43104a(), EnumC7125fi.CONTENT_BY_IDS_WHERE, new String[]{str, str2});
    }

    /* renamed from: a */
    public Class<? extends C7013a> mo43104a() {
        return ContentRecord.class;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public List<ContentRecord> mo43105a(int i10) {
        return m42984a(mo43104a(), null, EnumC7125fi.CONTENT_BY_ADTYPE_WHERE, new String[]{String.valueOf(i10)}, null, null);
    }

    /* renamed from: a */
    public List<String> m43106a(int i10, String str) {
        return m43095b(m42984a(mo43104a(), new String[]{"contentId"}, EnumC7125fi.CONTENT_BY_ADTYPE_AND_WHERE_SLOTID, new String[]{String.valueOf(i10), str}, null, null));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public void mo43107a(ContentRecord contentRecord) {
        AbstractC7185ho.m43817a("ContentRecordDao", "insertContent. ");
        if (contentRecord == null) {
            return;
        }
        m42981a(mo43104a(), contentRecord.m41863d(this.f32709a));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public void mo43108a(ContentRecord contentRecord, List<String> list) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        AbstractC7185ho.m43817a("ContentRecordDao", "updateContentIncludeById. ");
        if (contentRecord == null) {
            return;
        }
        List<String> listM41860bs = contentRecord.m41860bs();
        ContentValues contentValuesM41863d = contentRecord.m41863d(this.f32709a);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            listM41860bs.remove(it.next());
        }
        Iterator<String> it2 = listM41860bs.iterator();
        while (it2.hasNext()) {
            contentValuesM41863d.remove(it2.next());
        }
        m42977a(mo43104a(), contentValuesM41863d, EnumC7125fi.CONTENT_BY_IDS_WHERE, new String[]{contentRecord.m41588n(), contentRecord.m41585m()});
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public void mo43109a(ContentRecord contentRecord, List<String> list, String str) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        AbstractC7185ho.m43817a("ContentRecordDao", "updateContentIncludeById. ");
        if (contentRecord == null) {
            return;
        }
        List<String> listM41860bs = contentRecord.m41860bs();
        ContentValues contentValuesM41863d = contentRecord.m41863d(this.f32709a);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            listM41860bs.remove(it.next());
        }
        Iterator<String> it2 = listM41860bs.iterator();
        while (it2.hasNext()) {
            contentValuesM41863d.remove(it2.next());
        }
        m42977a(mo43104a(), contentValuesM41863d, EnumC7125fi.CONTENT_BY_ID_WHERE, new String[]{str});
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public void mo43110a(String str, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContentRecord.LAST_SHOW_TIME, Long.valueOf(j10));
        m42977a(mo43104a(), contentValues, EnumC7125fi.CONTENT_BY_TASKID_WHERE, new String[]{str});
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public void mo43111a(String str, String str2, String str3, String str4) {
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public void mo43112a(List<ContentRecord> list) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (AbstractC7760bg.m47767a(list) || this.f32709a == null) {
            return;
        }
        synchronized (f32744d) {
            try {
                ArrayList arrayList = new ArrayList();
                String simpleName = mo43104a().getSimpleName();
                EnumC7125fi enumC7125fi = EnumC7125fi.CONTENT_BY_IDS_WHERE;
                String strM43493a = enumC7125fi.m43493a();
                String strM43493a2 = enumC7125fi.m43493a();
                for (ContentRecord contentRecord : list) {
                    String strM41588n = contentRecord.m41588n();
                    String strM41585m = contentRecord.m41585m();
                    String[] strArr = {strM41588n, strM41585m};
                    String[] strArr2 = {strM41588n, strM41585m};
                    arrayList.add(new C7016de(simpleName, strM43493a, strArr, strM43493a2, strArr2, contentRecord.m41863d(this.f32709a)));
                    simpleName = simpleName;
                }
                m42989c(arrayList);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        AbstractC7185ho.m43818a("ContentRecordDao", "insertOrUpdateContents duration: %s ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
    }
}
