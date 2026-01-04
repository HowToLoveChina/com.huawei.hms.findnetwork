package com.huawei.openalliance.p169ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ty */
/* loaded from: classes8.dex */
public class C7703ty implements InterfaceC7701tw {

    /* renamed from: a */
    private String f35754a;

    /* renamed from: a */
    private List<Intent> m47336a(List<ResolveInfo> list, List<String> list2) {
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : list) {
            if (list2.contains(resolveInfo.activityInfo.packageName)) {
                AbstractC7185ho.m43818a("MoreShareProcessor", "%s Not showing", resolveInfo.activityInfo.packageName);
            } else {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType(InterfaceC5483d.f25083i);
                intent.putExtra("android.intent.extra.TEXT", this.f35754a);
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
                arrayList.add(intent);
            }
        }
        return arrayList;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7701tw
    /* renamed from: a */
    public void mo47333a(Activity activity, C7706ua c7706ua, C7708uc c7708uc) {
        if (activity == null || activity.getApplicationContext() == null) {
            return;
        }
        Context applicationContext = activity.getApplicationContext();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c7706ua.m47346c() == null ? "" : c7706ua.m47346c());
        sb2.append(c7706ua.m47347d() != null ? c7706ua.m47347d() : "");
        this.f35754a = sb2.toString();
        Intent intent = new Intent("android.intent.action.SEND");
        String strM47345b = InterfaceC5483d.f25083i;
        intent.setType(InterfaceC5483d.f25083i);
        List<Intent> listM47336a = m47336a(applicationContext.getPackageManager().queryIntentActivities(intent, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT), c7708uc.m47359d());
        Intent intentRemove = listM47336a.remove(0);
        if (c7706ua.m47345b() != null) {
            strM47345b = c7706ua.m47345b();
        }
        Intent intentCreateChooser = Intent.createChooser(intentRemove, strM47345b);
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) listM47336a.toArray(new Parcelable[0]));
        intentCreateChooser.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        applicationContext.startActivity(intentCreateChooser);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7701tw
    /* renamed from: a */
    public boolean mo47334a() {
        return true;
    }
}
