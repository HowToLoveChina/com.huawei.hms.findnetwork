package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.eu */
/* loaded from: classes8.dex */
public class C7105eu extends AbstractC7100ep implements InterfaceC7136ft {

    /* renamed from: c */
    private static C7105eu f32748c;

    /* renamed from: d */
    private static final byte[] f32749d = new byte[0];

    /* renamed from: e */
    private static final byte[] f32750e = new byte[0];

    public C7105eu(Context context) {
        super(context);
    }

    /* renamed from: a */
    private C7016de m43129a(ContentResource contentResource) {
        return new C7016de(ContentResource.class.getSimpleName(), null, null, EnumC7125fi.CONTENT_BY_RESOURCE_NAME_AND_CONTENTID_AND_CACHETYPE_AND_SLOTID_WHERE.m43493a(), new String[]{contentResource.m41621a(), contentResource.m41628c(), contentResource.m41642j(), contentResource.m41625b()}, contentResource.m41863d(this.f32709a));
    }

    /* renamed from: e */
    private List<ContentResource> m43132e(String str) {
        return TextUtils.isEmpty(str) ? new ArrayList() : m42984a(ContentResource.class, null, EnumC7125fi.CONTENT_BY_CONTENT_ID_WHERE, new String[]{str}, null, null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7136ft
    /* renamed from: b */
    public List<ContentResource> mo43138b(String str) {
        return m42984a(ContentResource.class, null, EnumC7125fi.CONTENT_BY_CACHETYPE_WHERE, new String[]{str}, "priority ASC, updateTime ASC", null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7136ft
    /* renamed from: c */
    public List<ContentResource> mo43141c(String str) {
        return m42984a(ContentResource.class, null, EnumC7125fi.CONTENT_BY_CACHETYPE_WHERE, new String[]{str}, "priority ASC", null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7136ft
    /* renamed from: d */
    public void mo43143d(String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43826d("ContentResourceDao", "contentId is null, can't update content resource");
            return;
        }
        synchronized (f32749d) {
            try {
                List<ContentResource> listM43132e = m43132e(str);
                if (AbstractC7760bg.m47767a(listM43132e)) {
                    AbstractC7185ho.m43820b("ContentResourceDao", "contentResources is empty");
                } else {
                    for (ContentResource contentResource : listM43132e) {
                        AbstractC7185ho.m43818a("ContentResourceDao", "contentResource slotId: %s contentId: %s useCount: %s", contentResource.m41625b(), contentResource.m41628c(), Integer.valueOf(contentResource.m41640h()));
                        contentResource.m41635e(contentResource.m41640h() + 1);
                    }
                    mo43137a(listM43132e);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static C7105eu m43130a(Context context) {
        C7105eu c7105eu;
        synchronized (f32750e) {
            try {
                if (f32748c == null) {
                    f32748c = new C7105eu(context);
                }
                c7105eu = f32748c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7105eu;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7136ft
    /* renamed from: b */
    public List<ContentResource> mo43139b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (AbstractC7760bg.m47767a(list)) {
            AbstractC7185ho.m43826d("ContentResourceDao", "contentId is null, can't update content resource");
            return arrayList;
        }
        synchronized (f32749d) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.addAll(m43132e(it.next()));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7136ft
    /* renamed from: c */
    public List<ContentResource> mo43142c(String str, String str2) {
        return TextUtils.isEmpty(str) ? new ArrayList() : m42984a(ContentResource.class, null, EnumC7125fi.CONTENT_BY_RESOURCE_NAME_AND_CACHETYPE_WHERE, new String[]{str, str2}, null, null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7136ft
    /* renamed from: a */
    public List<ContentResource> mo43133a(String str) {
        return TextUtils.isEmpty(str) ? new ArrayList() : m42984a(ContentResource.class, null, EnumC7125fi.CONTENT_BY_RESOURCE_NAME_WHERE, new String[]{str}, null, null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7136ft
    /* renamed from: b */
    public void mo43140b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43823c("ContentResourceDao", "deleteContentResource with empty contentId");
        } else {
            AbstractC7185ho.m43818a("ContentResourceDao", "deleteContentResourceByContentId: %s", str);
            m42979a(ContentResource.class, EnumC7125fi.CONTENT_BY_CONTENT_ID_AND_RESOURCE_NAME_WHERE, new String[]{str, str2});
        }
    }

    /* renamed from: a */
    private List<ContentResource> m43131a(String str, String str2, String str3, String str4) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? new ArrayList() : m42984a(ContentResource.class, null, EnumC7125fi.CONTENT_BY_RESOURCE_NAME_AND_CONTENTID_AND_CACHETYPE_AND_SLOTID_WHERE, new String[]{str2, str, str3, str4}, null, null);
    }

    /* renamed from: a */
    public void m43134a(ContentResource contentResource, String str) {
        if (contentResource == null) {
            return;
        }
        synchronized (f32749d) {
            try {
                String strM41628c = contentResource.m41628c();
                if (TextUtils.isEmpty(strM41628c)) {
                    AbstractC7185ho.m43820b("ContentResourceDao", "insertContent - content id is empty");
                    return;
                }
                if (AbstractC7760bg.m47767a(m43131a(strM41628c, contentResource.m41621a(), str, contentResource.m41625b()))) {
                    AbstractC7185ho.m43818a("ContentResourceDao", "insert contentid: %s fileName: %s cacheType: %s", strM41628c, contentResource.m41621a(), str);
                    contentResource.m41636e(str);
                    m42981a(ContentResource.class, contentResource.m41863d(this.f32709a));
                } else {
                    AbstractC7185ho.m43820b("ContentResourceDao", "resource is exist, contentId:" + strM41628c);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7136ft
    /* renamed from: a */
    public void mo43135a(String str, int i10, String str2) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43826d("ContentResourceDao", "contentId is null, can't update prio");
            return;
        }
        synchronized (f32749d) {
            try {
                List<ContentResource> listM43132e = m43132e(str);
                if (AbstractC7760bg.m47767a(listM43132e)) {
                    AbstractC7185ho.m43820b("ContentResourceDao", "contentResources is empty");
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (ContentResource contentResource : listM43132e) {
                        if (AbstractC7185ho.m43819a()) {
                            AbstractC7185ho.m43818a("ContentResourceDao", "contentResource fileName: %s, contentId: %s oldPrio: %s newPrio: %s cacheType: %s", contentResource.m41621a(), contentResource.m41628c(), Integer.valueOf(contentResource.m41634e()), Integer.valueOf(i10), str2);
                        }
                        List<ContentResource> listMo43142c = mo43142c(contentResource.m41621a(), str2);
                        if (AbstractC7760bg.m47767a(listMo43142c)) {
                            AbstractC7185ho.m43820b("ContentResourceDao", "contentResourcesByName is empty");
                        } else {
                            for (ContentResource contentResource2 : listMo43142c) {
                                if (i10 != contentResource2.m41634e()) {
                                    contentResource2.m41626b(i10);
                                    arrayList.add(contentResource2);
                                }
                            }
                        }
                    }
                    mo43137a(arrayList);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m43136a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43823c("ContentResourceDao", "deleteContentResource with empty file name");
        } else {
            AbstractC7185ho.m43818a("ContentResourceDao", "deleteContentResourceByName: %s cacheType: %s", str, str2);
            m42979a(ContentResource.class, EnumC7125fi.CONTENT_BY_RESOURCE_NAME_AND_CACHETYPE_WHERE, new String[]{str, str2});
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7136ft
    /* renamed from: a */
    public void mo43137a(List<ContentResource> list) {
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ContentResource contentResource : list) {
            if (contentResource != null) {
                arrayList.add(m43129a(contentResource));
            }
        }
        m42989c(arrayList);
    }
}
