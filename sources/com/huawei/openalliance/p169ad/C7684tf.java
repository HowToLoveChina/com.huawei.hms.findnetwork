package com.huawei.openalliance.p169ad;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.constant.IntentFailError;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.utils.C7792cl;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* renamed from: com.huawei.openalliance.ad.tf */
/* loaded from: classes8.dex */
public class C7684tf extends AbstractC7687ti {
    public C7684tf(Context context, ContentRecord contentRecord) {
        super(context, contentRecord);
    }

    /* renamed from: d */
    private String m47243d() {
        for (String str : C7124fh.m43316b(this.f35700a).mo43410bk()) {
            if (C7830i.m48419a(this.f35700a, str)) {
                return str;
            }
        }
        return "";
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7687ti
    /* renamed from: a */
    public boolean mo47233a() {
        Context context;
        String str;
        ContentRecord contentRecord = this.f35701b;
        if (contentRecord == null || !(AbstractC7558os.m46463b(contentRecord.m41427W()) || C7775bv.m47831e(this.f35700a))) {
            return m47249b();
        }
        AbstractC7185ho.m43820b("OuterWebAction", "handle outer browser action");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        String strM41386B = this.f35701b.m41386B();
        if (!AbstractC7806cz.m48165b(strM41386B)) {
            intent.setData(Uri.parse(strM41386B));
            if (!(this.f35700a instanceof Activity)) {
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            C7692tn.a aVar = new C7692tn.a();
            aVar.m47274a(this.f35701b).m47272a(intent);
            C7692tn c7692tnM47277a = aVar.m47277a();
            try {
                if (AbstractC7558os.m46464c(this.f35701b.m41427W())) {
                    AbstractC7185ho.m43817a("OuterWebAction", "handleUri, use default browser");
                    String strM47243d = m47243d();
                    if (TextUtils.isEmpty(strM47243d)) {
                        AbstractC7185ho.m43823c("OuterWebAction", "can not find default browser");
                    } else {
                        intent.setPackage(strM47243d);
                    }
                }
                PackageManager packageManager = this.f35700a.getPackageManager();
                if (packageManager == null) {
                    context = this.f35700a;
                    str = IntentFailError.ACTIVITY_NOT_FOUND;
                } else {
                    if (!packageManager.queryIntentActivities(intent, 65536).isEmpty()) {
                        m47248b("web");
                        C7830i.m48412a(this.f35700a, intent, c7692tnM47277a);
                        return true;
                    }
                    context = this.f35700a;
                    str = IntentFailError.CAN_NOT_GET_PKG_MANAGER;
                }
                C7792cl.m48072a(context, c7692tnM47277a, str);
            } catch (ActivityNotFoundException unused) {
                C7792cl.m48072a(this.f35700a, c7692tnM47277a, IntentFailError.ACTIVITY_NOT_FOUND_EXP);
                AbstractC7185ho.m43826d("OuterWebAction", "fail to open uri");
            } catch (Throwable th2) {
                C7792cl.m48072a(this.f35700a, c7692tnM47277a, "unknown exception : " + th2.getClass().getSimpleName());
                AbstractC7185ho.m43827d("OuterWebAction", "handle uri exception: %s", th2.getClass().getSimpleName());
            }
        }
        return m47249b();
    }
}
