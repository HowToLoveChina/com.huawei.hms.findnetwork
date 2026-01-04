package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.p171db.bean.ContentTemplateRecord;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ev */
/* loaded from: classes8.dex */
public class C7106ev extends AbstractC7100ep implements InterfaceC7137fu {

    /* renamed from: c */
    private static final byte[] f32751c = new byte[0];

    public C7106ev(Context context) {
        super(context);
    }

    /* renamed from: b */
    private void m43145b(ContentTemplateRecord contentTemplateRecord) {
        m42981a(ContentTemplateRecord.class, contentTemplateRecord.m41863d(this.f32709a));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7137fu
    /* renamed from: a */
    public ContentTemplateRecord mo43146a(String str, String str2) {
        List listM42984a = m42984a(ContentTemplateRecord.class, null, EnumC7125fi.CONTENT_TEMPLATE_RECORD_BY_IDS, new String[]{str, str2}, null, null);
        if (listM42984a.isEmpty()) {
            return null;
        }
        return (ContentTemplateRecord) listM42984a.get(0);
    }

    /* renamed from: a */
    public static C7106ev m43144a(Context context) {
        return new C7106ev(context);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7137fu
    /* renamed from: a */
    public void mo43147a(ContentTemplateRecord contentTemplateRecord) {
        if (contentTemplateRecord == null) {
            return;
        }
        synchronized (f32751c) {
            try {
                if (mo43146a(contentTemplateRecord.m41643a(), contentTemplateRecord.m41645b()) != null) {
                    m42977a(ContentTemplateRecord.class, contentTemplateRecord.m41863d(this.f32709a), EnumC7125fi.CONTENT_TEMPLATE_RECORD_BY_IDS, new String[]{contentTemplateRecord.m41643a(), contentTemplateRecord.m41645b()});
                } else {
                    m43145b(contentTemplateRecord);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7137fu
    /* renamed from: a */
    public void mo43148a(String str, String str2, String str3) {
        AbstractC7185ho.m43821b("ContentTemplateRecordDao", "deleteContentByIds ids: %s %s, reason: %s", str, str2, str3);
        m42979a(ContentTemplateRecord.class, EnumC7125fi.CONTENT_TEMPLATE_RECORD_BY_IDS, new String[]{str, str2});
    }
}
