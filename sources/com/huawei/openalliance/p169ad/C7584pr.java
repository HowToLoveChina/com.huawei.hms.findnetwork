package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.util.Log;
import com.huawei.openalliance.p169ad.beans.metadata.Template;
import com.huawei.openalliance.p169ad.p171db.bean.TemplateRecord;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.pr */
/* loaded from: classes8.dex */
public class C7584pr implements InterfaceC7620qv {

    /* renamed from: a */
    private static final String f35384a = "pr";

    /* renamed from: b */
    private InterfaceC7147gd f35385b;

    /* renamed from: c */
    private Context f35386c;

    public C7584pr(Context context) {
        this.f35386c = context.getApplicationContext();
        this.f35385b = C7127fk.m43505a(context);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7620qv
    /* renamed from: a */
    public void mo46844a(List<Template> list) {
        if (list == null || list.isEmpty()) {
            Log.i(f35384a, "templates is empty, don't need to save");
            return;
        }
        Iterator<Template> it = list.iterator();
        while (it.hasNext()) {
            TemplateRecord templateRecordM46748a = AbstractC7572pf.m46748a(it.next());
            if (templateRecordM46748a != null) {
                this.f35385b.mo43509a(templateRecordM46748a);
            }
        }
    }
}
