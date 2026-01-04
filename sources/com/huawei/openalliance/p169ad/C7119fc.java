package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.p171db.bean.PlacementRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.fc */
/* loaded from: classes8.dex */
public class C7119fc extends AbstractC7100ep implements InterfaceC7141fy {

    /* renamed from: c */
    private static final byte[] f32826c = new byte[0];

    /* renamed from: d */
    private static final byte[] f32827d = new byte[0];

    /* renamed from: e */
    private static C7119fc f32828e;

    public C7119fc(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7141fy
    /* renamed from: a */
    public PlacementRecord mo43283a(String str) {
        List listM42984a = m42984a(PlacementRecord.class, null, EnumC7125fi.PLACEMENT_BY_ID_WHERE, new String[]{str}, null, null);
        if (listM42984a.isEmpty()) {
            return null;
        }
        return (PlacementRecord) listM42984a.get(0);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7141fy
    /* renamed from: b */
    public void mo43286b(PlacementRecord placementRecord) {
        if (placementRecord == null) {
            return;
        }
        synchronized (f32827d) {
            try {
                String strM41791a = placementRecord.m41791a();
                if (mo43283a(strM41791a) != null) {
                    m42977a(PlacementRecord.class, placementRecord.m41863d(this.f32709a), EnumC7125fi.PLACEMENT_BY_ID_WHERE, new String[]{strM41791a});
                } else {
                    m43285a(placementRecord);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static C7119fc m43281a(Context context) {
        C7119fc c7119fc;
        synchronized (f32826c) {
            try {
                if (f32828e == null) {
                    f32828e = new C7119fc(context);
                }
                c7119fc = f32828e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7119fc;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7141fy
    /* renamed from: b */
    public void mo43287b(String str) {
        m42979a(PlacementRecord.class, EnumC7125fi.PLACEMENT_BY_ID_WHERE, new String[]{str});
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7141fy
    /* renamed from: a */
    public List<String> mo43284a() {
        return m43282a(m42984a(PlacementRecord.class, new String[]{"contentId"}, null, null, null, null));
    }

    /* renamed from: a */
    private List<String> m43282a(List<PlacementRecord> list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PlacementRecord> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m41791a());
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m43285a(PlacementRecord placementRecord) {
        m42981a(PlacementRecord.class, placementRecord.m41863d(this.f32709a));
    }
}
