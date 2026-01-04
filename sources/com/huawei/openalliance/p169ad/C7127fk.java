package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.p171db.bean.TemplateRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.fk */
/* loaded from: classes8.dex */
public class C7127fk extends AbstractC7100ep implements InterfaceC7147gd {

    /* renamed from: c */
    private static C7127fk f32911c;

    /* renamed from: d */
    private static final byte[] f32912d = new byte[0];

    /* renamed from: e */
    private static final byte[] f32913e = new byte[0];

    public C7127fk(Context context) {
        super(context);
    }

    /* renamed from: a */
    public TemplateRecord m43507a(String str) {
        List listM42984a = m42984a(TemplateRecord.class, null, EnumC7125fi.TEMPLATE_BY_ID_WHERE, new String[]{str}, null, null);
        if (listM42984a.isEmpty()) {
            return null;
        }
        return (TemplateRecord) listM42984a.get(0);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7100ep
    /* renamed from: e */
    public void mo42990e() {
        super.mo42990e();
        m42979a(TemplateRecord.class, (EnumC7125fi) null, (String[]) null);
    }

    /* renamed from: a */
    public static C7127fk m43505a(Context context) {
        C7127fk c7127fk;
        synchronized (f32912d) {
            try {
                if (f32911c == null) {
                    f32911c = new C7127fk(context);
                }
                c7127fk = f32911c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7127fk;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7147gd
    /* renamed from: a */
    public List<String> mo43508a() {
        return m43506a(m42984a(TemplateRecord.class, new String[]{"templateId"}, null, null, null, null));
    }

    /* renamed from: a */
    private List<String> m43506a(List<TemplateRecord> list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TemplateRecord> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m41820a());
        }
        return arrayList;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7147gd
    /* renamed from: a */
    public void mo43509a(TemplateRecord templateRecord) {
        synchronized (f32913e) {
            try {
                String strM41820a = templateRecord.m41820a();
                if (m43507a(strM41820a) == null) {
                    m42981a(TemplateRecord.class, templateRecord.m41863d(this.f32709a));
                } else {
                    m42977a(TemplateRecord.class, templateRecord.m41863d(this.f32709a), EnumC7125fi.TEMPLATE_BY_ID_WHERE, new String[]{strM41820a});
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
