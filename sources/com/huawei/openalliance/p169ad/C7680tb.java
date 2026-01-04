package com.huawei.openalliance.p169ad;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.constant.IntentFailError;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.C7792cl;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.tb */
/* loaded from: classes8.dex */
public class C7680tb extends AbstractC7687ti {

    /* renamed from: c */
    private String f35689c;

    /* renamed from: d */
    private String f35690d;

    /* renamed from: e */
    private InterfaceC7615qq f35691e;

    public C7680tb(Context context, ContentRecord contentRecord, Map<String, String> map) {
        super(context, contentRecord);
        this.f35689c = map.get("appId");
        this.f35690d = map.get("thirdId");
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()));
        this.f35691e = c7560ou;
        c7560ou.mo46590a(contentRecord);
    }

    /* renamed from: d */
    private void m47236d() {
        this.f35691e.mo46588a(EventType.INTENTFAIL, (Integer) 3, Integer.valueOf(C7830i.m48419a(this.f35700a, "com.huawei.appmarket") ? 2 : 1));
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7687ti
    /* renamed from: a */
    public boolean mo47233a() {
        Context context;
        String str;
        AbstractC7185ho.m43820b("HwMarketAction", "handle hw app market action");
        Intent intent = new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withid");
        intent.setPackage("com.huawei.appmarket");
        intent.putExtra("appId", this.f35689c);
        intent.putExtra("thirdId", this.f35690d);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        C7692tn.a aVar = new C7692tn.a();
        aVar.m47274a(this.f35701b).m47272a(intent);
        C7692tn c7692tnM47277a = aVar.m47277a();
        try {
            PackageManager packageManager = this.f35700a.getPackageManager();
            if (packageManager == null) {
                context = this.f35700a;
                str = IntentFailError.CAN_NOT_GET_PKG_MANAGER;
            } else {
                if (!packageManager.queryIntentActivities(intent, 65536).isEmpty()) {
                    C7830i.m48412a(this.f35700a, intent, c7692tnM47277a);
                    m47248b(ClickDestination.APPMARKET);
                    this.f35691e.mo46588a(EventType.INTENTSUCCESS, (Integer) 3, (Integer) null);
                    return true;
                }
                context = this.f35700a;
                str = IntentFailError.ACTIVITY_NOT_FOUND;
            }
            C7792cl.m48072a(context, c7692tnM47277a, str);
        } catch (ActivityNotFoundException unused) {
            C7792cl.m48072a(this.f35700a, c7692tnM47277a, IntentFailError.ACTIVITY_NOT_FOUND_EXP);
            AbstractC7185ho.m43826d("HwMarketAction", "fail to open market detail page");
        }
        m47236d();
        return m47249b();
    }
}
