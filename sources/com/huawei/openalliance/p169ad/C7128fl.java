package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.SlotTemplate;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.SlotTemplateRsp;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateConfig;
import com.huawei.openalliance.p169ad.p171db.bean.TemplateStyleRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.C7757bd;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.fl */
/* loaded from: classes8.dex */
public class C7128fl extends AbstractC7100ep implements InterfaceC7148ge {

    /* renamed from: c */
    private static final byte[] f32914c = new byte[0];

    public C7128fl(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static InterfaceC7148ge m43510a(Context context) {
        return new C7128fl(context);
    }

    /* renamed from: b */
    private TemplateStyleRecord m43516b(String str, String str2) {
        List listM42984a = m42984a(TemplateStyleRecord.class, null, EnumC7125fi.TEMPLATE_STYLE_BY_SLOTID_AND_TEMPLATEID, new String[]{str, str2}, null, null);
        if (!AbstractC7760bg.m47767a(listM42984a)) {
            return (TemplateStyleRecord) listM42984a.get(0);
        }
        AbstractC7185ho.m43817a("TemplateConfigDao", "no style");
        return null;
    }

    /* renamed from: c */
    private List<String> m43517c() {
        try {
            if (C7084e.m42838b() != null) {
                return C7084e.m42838b().mo30521a((Bundle) null);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("TemplateConfigDao", "get blackTptIdList err: %s", th2.getClass().getSimpleName());
        }
        return null;
    }

    /* renamed from: d */
    private Map<String, List<String>> m43520d() {
        AbstractC7185ho.m43820b("TemplateConfigDao", "queryAllSlotTemplateIds");
        List<TemplateStyleRecord> listM42984a = m42984a(TemplateStyleRecord.class, null, null, null, null, null);
        if (AbstractC7760bg.m47767a(listM42984a)) {
            return null;
        }
        HashMap map = new HashMap();
        for (TemplateStyleRecord templateStyleRecord : listM42984a) {
            if (templateStyleRecord != null) {
                String strM41824a = templateStyleRecord.m41824a();
                List arrayList = (List) map.get(strM41824a);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(templateStyleRecord.m41825b());
                map.put(strM41824a, arrayList);
            }
        }
        return map;
    }

    /* renamed from: e */
    private void m43521e(List<String> list) {
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            m43518c(it.next());
        }
    }

    /* renamed from: c */
    private void m43518c(String str) {
        m42979a(TemplateStyleRecord.class, EnumC7125fi.TEMPLATE_STYLE_BY_TEMPLATEID, new String[]{str});
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7148ge
    /* renamed from: a */
    public String mo43522a(String str, String str2) {
        TemplateStyleRecord templateStyleRecordM43516b = m43516b(str, str2);
        if (templateStyleRecordM43516b != null) {
            return templateStyleRecordM43516b.m41826c();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7148ge
    /* renamed from: b */
    public List<SlotTemplate> mo43528b() {
        return m43511a(EnumC7125fi.TEMPLATE_STYLE_H5, (String[]) null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7148ge
    /* renamed from: d */
    public Map<String, List<String>> mo43533d(List<String> list) {
        if (AbstractC7760bg.m47767a(list)) {
            return m43520d();
        }
        HashMap map = new HashMap();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                List<String> listM42985a = m42985a("SELECT templateId FROM " + TemplateStyleRecord.class.getSimpleName() + " WHERE slotId = \"" + str + "\";", (String[]) null, "templateId");
                if (!AbstractC7760bg.m47767a(listM42985a)) {
                    map.put(str, listM42985a);
                }
            }
        }
        return map;
    }

    /* renamed from: c */
    private void m43519c(String str, String str2) {
        m42979a(TemplateStyleRecord.class, EnumC7125fi.TEMPLATE_STYLE_BY_SLOTID_AND_TEMPLATEID, new String[]{str, str2});
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7148ge
    /* renamed from: a */
    public List<SlotTemplate> mo43523a() {
        return m43511a(EnumC7125fi.TEMPLATE_STYLE, (String[]) null);
    }

    /* renamed from: b */
    public List<TemplateStyleRecord> m43529b(String str) {
        return m42984a(TemplateStyleRecord.class, null, EnumC7125fi.TEMPLATE_STYLE_H5_BY_SLOTID, new String[]{str}, null, null);
    }

    /* renamed from: a */
    private List<SlotTemplate> m43511a(EnumC7125fi enumC7125fi, String[] strArr) {
        List<TemplateStyleRecord> listM42984a = m42984a(TemplateStyleRecord.class, null, enumC7125fi, strArr, null, null);
        if (AbstractC7760bg.m47767a(listM42984a)) {
            return new ArrayList();
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (TemplateStyleRecord templateStyleRecord : listM42984a) {
            if (templateStyleRecord != null) {
                String strM41824a = templateStyleRecord.m41824a();
                List arrayList = (List) concurrentHashMap.get(strM41824a);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(new TemplateConfig(templateStyleRecord.m41825b(), templateStyleRecord.m41827d()));
                concurrentHashMap.put(strM41824a, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            arrayList2.add(new SlotTemplate((String) entry.getKey(), (List) entry.getValue()));
        }
        return arrayList2;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7148ge
    /* renamed from: b */
    public List<String> mo43530b(String str, Map<String, Integer> map) {
        List<String> listM43512a = m43512a(str, map, 1);
        if (AbstractC7760bg.m47767a(listM43512a)) {
            return null;
        }
        return listM43512a;
    }

    /* renamed from: c */
    public boolean m43532c(String str, Map<String, Integer> map) {
        AbstractC7185ho.m43818a("TemplateConfigDao", "tag: %s, unsupportedTags： %s", str, map);
        Map map2 = (Map) AbstractC7758be.m47739b(str, Map.class, Integer.class);
        if (C7765bl.m47802a(map2)) {
            AbstractC7185ho.m43817a("TemplateConfigDao", "tag is null");
            return false;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            AbstractC7185ho.m43818a("TemplateConfigDao", "unsupportedTag: %s, templateTags: %s", entry, map2);
            Integer value = entry.getValue();
            if (value != null && value.intValue() >= -1 && value.intValue() <= 9) {
                if (value.intValue() == -1) {
                    return true;
                }
                if (map2.containsKey(entry.getKey()) && value.equals(map2.get(entry.getKey()))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public List<TemplateStyleRecord> m43524a(String str) {
        return m42984a(TemplateStyleRecord.class, null, EnumC7125fi.TEMPLATE_STYLE_NATIVE_BY_SLOTID, new String[]{str}, null, null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7148ge
    /* renamed from: b */
    public void mo43531b(List<SlotTemplateRsp> list) {
        m43515a(list, true);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7148ge
    /* renamed from: a */
    public List<String> mo43525a(String str, Map<String, Integer> map) {
        List<String> listM43512a = m43512a(str, map, 0);
        if (AbstractC7760bg.m47767a(listM43512a)) {
            return null;
        }
        return listM43512a;
    }

    /* renamed from: a */
    private List<String> m43512a(String str, Map<String, Integer> map, int i10) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (C7765bl.m47802a(map)) {
            AbstractC7185ho.m43817a("TemplateConfigDao", "unsupportedTags is empty");
            return m42985a("SELECT templateId FROM " + TemplateStyleRecord.class.getSimpleName() + " WHERE slotId = \"" + str + "\" and tmpType = " + i10 + ";", (String[]) null, "templateId");
        }
        List<TemplateStyleRecord> listM43529b = C7757bd.m47712a(i10) ? m43529b(str) : m43524a(str);
        if (AbstractC7760bg.m47767a(listM43529b)) {
            return arrayList;
        }
        for (TemplateStyleRecord templateStyleRecord : listM43529b) {
            if (templateStyleRecord != null && !m43532c(templateStyleRecord.m41828e(), map) && !TextUtils.isEmpty(templateStyleRecord.m41825b())) {
                arrayList.add(templateStyleRecord.m41825b());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m43513a(TemplateStyleRecord templateStyleRecord) {
        if (m43516b(templateStyleRecord.m41824a(), templateStyleRecord.m41825b()) != null) {
            m42977a(TemplateStyleRecord.class, templateStyleRecord.m41863d(this.f32709a), EnumC7125fi.TEMPLATE_STYLE_BY_SLOTID_AND_TEMPLATEID, new String[]{templateStyleRecord.m41824a(), templateStyleRecord.m41825b()});
        } else {
            m42981a(TemplateStyleRecord.class, templateStyleRecord.m41863d(this.f32709a));
        }
    }

    /* renamed from: a */
    private void m43514a(String str, List<String> list) {
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            m43519c(str, it.next());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7148ge
    /* renamed from: a */
    public void mo43526a(List<SlotTemplateRsp> list) {
        m43515a(list, false);
    }

    /* renamed from: a */
    private void m43515a(List<SlotTemplateRsp> list, boolean z10) {
        if (AbstractC7760bg.m47767a(list)) {
            AbstractC7185ho.m43820b("TemplateConfigDao", "slotTemplateRsps is empty");
            return;
        }
        synchronized (f32914c) {
            try {
                List<String> listM43517c = m43517c();
                AbstractC7185ho.m43818a("TemplateConfigDao", "blackIdList = %s", listM43517c);
                for (SlotTemplateRsp slotTemplateRsp : list) {
                    if (slotTemplateRsp != null && !AbstractC7760bg.m47767a(slotTemplateRsp.m40544c())) {
                        m43514a(slotTemplateRsp.m40542a(), slotTemplateRsp.m40544c());
                    }
                    if (slotTemplateRsp != null && !AbstractC7760bg.m47767a(slotTemplateRsp.m40543b())) {
                        for (TemplateConfig templateConfig : slotTemplateRsp.m40543b()) {
                            if (templateConfig != null && !TextUtils.isEmpty(templateConfig.m40545a()) && (AbstractC7760bg.m47767a(listM43517c) || !listM43517c.contains(templateConfig.m40545a()))) {
                                m43513a(z10 ? new TemplateStyleRecord(slotTemplateRsp.m40542a(), templateConfig, 1) : new TemplateStyleRecord(slotTemplateRsp.m40542a(), templateConfig));
                            }
                        }
                    }
                }
                m43521e(listM43517c);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7148ge
    /* renamed from: a */
    public boolean mo43527a(String str, String str2, Map<String, Integer> map) {
        if (C7765bl.m47802a(map)) {
            return false;
        }
        TemplateStyleRecord templateStyleRecordM43516b = m43516b(str, str2);
        if (templateStyleRecordM43516b != null && !m43532c(templateStyleRecordM43516b.m41828e(), map)) {
            return false;
        }
        AbstractC7185ho.m43820b("TemplateConfigDao", "not support");
        return true;
    }
}
