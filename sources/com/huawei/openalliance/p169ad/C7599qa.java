package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7830i;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.qa */
/* loaded from: classes8.dex */
public class C7599qa implements InterfaceC7597pz {

    /* renamed from: a */
    private Context f35447a;

    public C7599qa(Context context) {
        this.f35447a = context.getApplicationContext();
    }

    /* renamed from: c */
    private int m46975c(MetaData metaData) {
        int iM46977d = m46977d(metaData);
        if (iM46977d != 1) {
            return iM46977d != 2 ? 9 : 6;
        }
        return 1;
    }

    /* renamed from: d */
    private int m46977d(MetaData metaData) {
        ApkInfo apkInfoM40339s;
        if (metaData == null || (apkInfoM40339s = metaData.m40339s()) == null || TextUtils.isEmpty(apkInfoM40339s.m39626a())) {
            return 3;
        }
        boolean zM48419a = C7830i.m48419a(this.f35447a, apkInfoM40339s.m39626a());
        if (!TextUtils.isEmpty(apkInfoM40339s.m39613N())) {
            m46972a(apkInfoM40339s.m39613N(), zM48419a);
        }
        return zM48419a ? 1 : 2;
    }

    /* renamed from: a */
    public int m46978a(MetaData metaData) {
        if (metaData == null) {
            return -1;
        }
        String strM40332o = metaData.m40332o();
        return !TextUtils.isEmpty(strM40332o) ? m46970a(metaData, strM40332o) : m46975c(metaData);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7597pz
    /* renamed from: b */
    public int mo46966b() {
        return 3;
    }

    /* renamed from: a */
    private int m46970a(MetaData metaData, String str) {
        ApkInfo apkInfoM40339s;
        int iM46977d = m46977d(metaData);
        if (C7830i.m48426b(this.f35447a, str, (metaData == null || (apkInfoM40339s = metaData.m40339s()) == null) ? null : apkInfoM40339s.m39626a(), null) == null) {
            if (iM46977d != 1) {
                return iM46977d != 2 ? 7 : 2;
            }
            return 3;
        }
        if (iM46977d != 1) {
            return iM46977d != 2 ? 8 : 5;
        }
        return 4;
    }

    /* renamed from: b */
    private String m46973b(MetaData metaData) {
        ApkInfo apkInfoM40339s = metaData.m40339s();
        return apkInfoM40339s != null ? AbstractC7807d.m48207a(this.f35447a, apkInfoM40339s.m39626a()) : "";
    }

    /* renamed from: c */
    private C7560ou m46976c(String str, int i10, int i11, Content content) {
        ContentRecord contentRecordM46744a = AbstractC7572pf.m46744a(str, content, i10, null);
        if (contentRecordM46744a == null) {
            AbstractC7185ho.m43820b("PreCheckFilter", "contentRecord is null");
            return null;
        }
        contentRecordM46744a.m41592o(i11);
        Context context = this.f35447a;
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, i10));
        c7560ou.mo46590a(contentRecordM46744a);
        return c7560ou;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46974b(String str, int i10, int i11, Content content) {
        C7560ou c7560ouM46976c;
        MetaData metaDataM39944c = content.m39944c();
        if (metaDataM39944c == null || (c7560ouM46976c = m46976c(str, i10, i11, content)) == null) {
            return;
        }
        c7560ouM46976c.m46579a(m46978a(metaDataM39944c), m46973b(metaDataM39944c));
    }

    /* renamed from: a */
    private void m46972a(String str, boolean z10) {
        List<String> listM48260w = AbstractC7807d.m48260w(this.f35447a);
        if (z10) {
            if (listM48260w.contains(str)) {
                return;
            }
            listM48260w.add(str);
            AbstractC7807d.m48212a(this.f35447a, listM48260w);
            AbstractC7185ho.m43818a("PreCheckFilter", "add app to insApp file ,PkgNameEncoded: %s", str);
            return;
        }
        if (listM48260w.contains(str)) {
            listM48260w.remove(str);
            AbstractC7807d.m48212a(this.f35447a, listM48260w);
            AbstractC7185ho.m43818a("PreCheckFilter", "remove app to insApp file ,PkgNameEncoded: %s", str);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7597pz
    /* renamed from: a */
    public boolean mo46967a(final String str, final int i10, final int i11, final Content content) {
        if (content == null) {
            return false;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PreCheckFilter", "filterContents adType: %d contentid: %s", Integer.valueOf(i10), content.m39962g());
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.qa.1
            @Override // java.lang.Runnable
            public void run() {
                C7599qa.this.m46974b(str, i10, i11, content);
            }
        });
        return false;
    }
}
