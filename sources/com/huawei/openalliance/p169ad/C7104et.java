package com.huawei.openalliance.p169ad;

import android.content.ContentValues;
import android.content.Context;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.p171db.bean.C7013a;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecordV3;
import com.huawei.openalliance.p169ad.p171db.bean.ContentTemplateRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7780c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.et */
/* loaded from: classes8.dex */
public class C7104et extends C7103es {

    /* renamed from: c */
    private static C7104et f32746c;

    /* renamed from: d */
    private static final byte[] f32747d = new byte[0];

    public C7104et(Context context) {
        super(context);
    }

    /* renamed from: a */
    private ContentRecord m43125a(EnumC7125fi enumC7125fi, String[] strArr) {
        List listM42984a = m42984a(mo43104a(), null, enumC7125fi, strArr, "priority asc, displayCount asc, updateTime desc", String.valueOf(4));
        if (AbstractC7760bg.m47767a(listM42984a)) {
            return null;
        }
        return (ContentRecord) listM42984a.get(0);
    }

    /* renamed from: b */
    public static C7104et m43127b(Context context) {
        C7104et c7104et;
        synchronized (f32747d) {
            try {
                if (f32746c == null) {
                    f32746c = new C7104et(context);
                }
                c7104et = f32746c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7104et;
    }

    @Override // com.huawei.openalliance.p169ad.C7103es, com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: c */
    public List<ContentRecord> mo43120c() {
        return m42984a(mo43104a(), new String[]{"contentId", "slotId", "templateId"}, EnumC7125fi.CONTENT_EXPIRE_WHERE, new String[]{String.valueOf(AbstractC7741ao.m47566c()), String.valueOf(0)}, null, null);
    }

    @Override // com.huawei.openalliance.p169ad.C7103es, com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public ContentRecord mo43103a(String str, String str2, String str3, int i10, long j10) {
        return m43125a(EnumC7125fi.CONTENT_V3_REAL_SHOW_WHERE, new String[]{str, str2, str3, String.valueOf(j10), String.valueOf(j10)});
    }

    @Override // com.huawei.openalliance.p169ad.C7103es, com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: b */
    public List<ContentRecord> mo43114b(String str, int i10, long j10, int i11) {
        ArrayList arrayList = new ArrayList();
        EnumC7125fi enumC7125fi = 1 == i10 ? EnumC7125fi.CONTENT_V3_PORTRAIT_CACHE_SHOW_WHERE : EnumC7125fi.CONTENT_V3_LANDSCAPE_CACHE_SHOW_WHERE;
        long jM47566c = AbstractC7741ao.m47566c();
        for (ContentRecord contentRecord : m42984a(mo43104a(), null, enumC7125fi, new String[]{String.valueOf(jM47566c), String.valueOf(jM47566c), str, String.valueOf(jM47566c - j10), AbstractC7741ao.m47561b("yyyy-MM-dd")}, "priority asc, displayCount asc, updateTime desc", String.valueOf(4))) {
            if (contentRecord != null) {
                ContentTemplateRecord contentTemplateRecordMo43146a = C7106ev.m43144a(this.f32709a).mo43146a(contentRecord.m41588n(), contentRecord.m41463aO());
                if (contentTemplateRecordMo43146a != null && !AbstractC7760bg.m47767a(contentTemplateRecordMo43146a.m41646c())) {
                    boolean zM47865a = true;
                    for (Asset asset : contentTemplateRecordMo43146a.m41646c()) {
                        if (asset != null && !AbstractC7806cz.m48165b(asset.m40519g())) {
                            if (!AbstractC7731ae.m47462c(this.f32709a, asset.m40519g(), Constants.TPLATE_CACHE)) {
                                zM47865a = false;
                            }
                            if (!zM47865a) {
                                zM47865a = C7780c.m47865a(this.f32709a, contentRecord, m43126a(asset), asset);
                            }
                        }
                    }
                    if (zM47865a) {
                        contentRecord.m41477aa(contentTemplateRecordMo43146a.m41650g());
                        contentRecord.m41584l(contentTemplateRecordMo43146a.m41646c());
                        contentRecord.m41440a(new TemplateData(contentTemplateRecordMo43146a.m41647d(), contentTemplateRecordMo43146a.m41648e(), contentTemplateRecordMo43146a.m41649f()));
                        contentRecord.m41408M(C7128fl.m43510a(this.f32709a).mo43522a(contentRecord.m41585m(), contentRecord.m41463aO()));
                        arrayList.add(contentRecord);
                    }
                }
                m43128b(contentRecord.m41588n(), contentRecord.m41463aO(), contentRecord.m41585m(), "delete not exists");
            }
        }
        return arrayList;
    }

    @Override // com.huawei.openalliance.p169ad.C7103es
    /* renamed from: a */
    public Class<? extends C7013a> mo43104a() {
        return ContentRecordV3.class;
    }

    @Override // com.huawei.openalliance.p169ad.C7103es, com.huawei.openalliance.p169ad.InterfaceC7135fs
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
        m42977a(mo43104a(), contentValuesM41863d, EnumC7125fi.CONTENT_RECORD_BY_IDS, new String[]{contentRecord.m41588n(), contentRecord.m41463aO(), contentRecord.m41585m()});
    }

    /* renamed from: a */
    private String m43126a(Asset asset) {
        if (asset.m40516d() != null) {
            return asset.m40516d().m40573a();
        }
        if (asset.m40517e() != null) {
            return asset.m40517e().m40595a();
        }
        return null;
    }

    /* renamed from: b */
    private void m43128b(String str, String str2, String str3, String str4) {
        AbstractC7185ho.m43818a("ContentRecordV3Dao", "deleteContentByIds, contentId= %s, templateId= %s, slotId= %s, reason: %s", str, str2, str3, str4);
        m42979a(mo43104a(), EnumC7125fi.CONTENT_RECORD_BY_IDS, new String[]{str, str2, str3});
        C7106ev.m43144a(this.f32709a).mo43148a(str, str2, str4);
    }

    @Override // com.huawei.openalliance.p169ad.C7103es, com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public List<ContentRecord> mo43105a(int i10) {
        return m42983a(ContentRecord.class, "SELECT ContentRecordV3.*,ContentTemplateRecord.assets From ContentRecordV3 INNER JOIN ContentTemplateRecord ON ContentRecordV3.adType = " + i10 + " AND ContentTemplateRecord.contentId = ContentRecordV3.contentId AND ContentTemplateRecord.templateId = ContentRecordV3.templateId;", (String[]) null);
    }

    @Override // com.huawei.openalliance.p169ad.C7103es, com.huawei.openalliance.p169ad.InterfaceC7135fs
    /* renamed from: a */
    public void mo43111a(String str, String str2, String str3, String str4) {
        m43128b(str, str2, str3, str4);
    }
}
