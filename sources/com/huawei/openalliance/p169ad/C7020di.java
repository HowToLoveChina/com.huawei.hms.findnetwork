package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.analysis.C6927h;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MetaCreativeType;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.huawei.openalliance.ad.di */
/* loaded from: classes8.dex */
public class C7020di implements InterfaceC7025dn {

    /* renamed from: a */
    private Context f32208a;

    /* renamed from: b */
    private String f32209b;

    public C7020di(Context context, String str) {
        this.f32208a = context.getApplicationContext();
        this.f32209b = str;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7025dn
    /* renamed from: a */
    public List<ContentResource> mo41943a() {
        C7105eu c7105euM43130a = C7105eu.m43130a(this.f32208a);
        int iMo43424by = C7124fh.m43316b(this.f32208a).mo43424by();
        String str = this.f32209b;
        return 1 == iMo43424by ? c7105euM43130a.mo43141c(str) : c7105euM43130a.mo43138b(str);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7025dn
    /* renamed from: a */
    public Set<String> mo41944a(List<String> list) {
        HashSet hashSet = new HashSet();
        List<ContentResource> listMo43139b = C7105eu.m43130a(this.f32208a).mo43139b(list);
        if (!AbstractC7760bg.m47767a(listMo43139b)) {
            for (ContentResource contentResource : listMo43139b) {
                if (contentResource != null) {
                    hashSet.add(contentResource.m41621a());
                }
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    private void m41941a(String str) {
        StringBuilder sb2;
        String str2;
        try {
            AbstractC7731ae.m47444a(C7022dk.m41951a(this.f32208a, this.f32209b).getCanonicalPath() + File.separator + MetaCreativeType.f32139AR + str);
        } catch (IOException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "IOException delete ar unzip dir:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("DiskCacheFileOperation", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "Exception delete ar unzip dir:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("DiskCacheFileOperation", sb2.toString());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7025dn
    /* renamed from: a */
    public void mo41945a(final String str, final int i10) {
        AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.di.3
            @Override // java.lang.Runnable
            public void run() {
                C7105eu c7105euM43130a = C7105eu.m43130a(C7020di.this.f32208a);
                List<ContentResource> listMo43142c = c7105euM43130a.mo43142c(str, C7020di.this.f32209b);
                if (AbstractC7760bg.m47767a(listMo43142c)) {
                    return;
                }
                Iterator<ContentResource> it = listMo43142c.iterator();
                while (it.hasNext()) {
                    it.next().m41626b(i10);
                }
                c7105euM43130a.mo43137a(listMo43142c);
            }
        }, AbstractC7834m.a.DISK_CACHE, false);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7025dn
    /* renamed from: a */
    public void mo41946a(final String str, final long j10) {
        AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.di.2
            @Override // java.lang.Runnable
            public void run() {
                C7105eu c7105euM43130a = C7105eu.m43130a(C7020di.this.f32208a);
                List<ContentResource> listMo43142c = c7105euM43130a.mo43142c(str, C7020di.this.f32209b);
                if (AbstractC7760bg.m47767a(listMo43142c)) {
                    return;
                }
                Iterator<ContentResource> it = listMo43142c.iterator();
                while (it.hasNext()) {
                    it.next().m41623a(j10);
                }
                c7105euM43130a.mo43137a(listMo43142c);
            }
        }, AbstractC7834m.a.DISK_CACHE, false);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7025dn
    /* renamed from: a */
    public void mo41947a(String str, final ContentResource contentResource) {
        if (contentResource != null) {
            AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.di.1
                @Override // java.lang.Runnable
                public void run() {
                    C7105eu.m43130a(C7020di.this.f32208a).m43134a(contentResource, C7020di.this.f32209b);
                }
            }, AbstractC7834m.a.DISK_CACHE, false);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7025dn
    /* renamed from: a */
    public void mo41948a(String str, boolean z10, Integer num) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43820b("DiskCacheFileOperation", "fileName is empty");
            return;
        }
        AbstractC7185ho.m43821b("DiskCacheFileOperation", "onFileRemoved: %s", str);
        List<ContentResource> listMo43142c = C7105eu.m43130a(this.f32208a).mo43142c(str, this.f32209b);
        if (AbstractC7760bg.m47767a(listMo43142c)) {
            AbstractC7185ho.m43820b("DiskCacheFileOperation", "contentResources is empty");
            return;
        }
        AbstractC7185ho.m43820b("DiskCacheFileOperation", "contentResources is not empty");
        if (z10) {
            new C6927h(this.f32208a).m39193a(listMo43142c, num);
        }
        C7105eu.m43130a(this.f32208a).m43136a(str, this.f32209b);
        for (ContentResource contentResource : listMo43142c) {
            if (MetaCreativeType.f32139AR.equalsIgnoreCase(contentResource.m41641i())) {
                AbstractC7185ho.m43820b("DiskCacheFileOperation", "AR deleteUnzipDir");
                m41941a(str);
            } else if (contentResource.m41631d() == 1 || contentResource.m41631d() == 18) {
                if (TextUtils.equals(this.f32209b, Constants.NORMAL_CACHE)) {
                    C7103es.m43094a(this.f32208a).mo43122c(contentResource.m41628c());
                }
            }
        }
    }
}
