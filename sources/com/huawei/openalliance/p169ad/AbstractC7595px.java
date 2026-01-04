package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.metadata.Content;

/* renamed from: com.huawei.openalliance.ad.px */
/* loaded from: classes8.dex */
public abstract class AbstractC7595px implements InterfaceC7597pz {

    /* renamed from: a */
    protected Context f35445a;

    public AbstractC7595px(Context context) {
        this.f35445a = context.getApplicationContext();
    }

    /* renamed from: a */
    public abstract String mo46964a();

    /* renamed from: a */
    public abstract boolean mo46965a(Content content, int i10);

    @Override // com.huawei.openalliance.p169ad.InterfaceC7597pz
    /* renamed from: a */
    public boolean mo46967a(String str, int i10, int i11, Content content) {
        if (content == null) {
            return true;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(mo46964a(), "filterContents adType: %d contentid: %s requestType: %d", Integer.valueOf(i10), content.m39962g(), Integer.valueOf(i11));
        }
        boolean zMo46965a = mo46965a(content, i10);
        if (zMo46965a) {
            AbstractC7185ho.m43824c(mo46964a(), "contentid %s is discarded", content.m39962g());
        }
        return zMo46965a;
    }
}
