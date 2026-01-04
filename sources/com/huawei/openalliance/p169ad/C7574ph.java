package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.server.PermissionRsp;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.PermissionEntity;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7783cc;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ph */
/* loaded from: classes8.dex */
public class C7574ph {

    /* renamed from: a */
    private static final String f35320a = "ph";

    /* renamed from: b */
    private Context f35321b;

    /* renamed from: c */
    private InterfaceC7140fx f35322c;

    /* renamed from: d */
    private a f35323d;

    /* renamed from: com.huawei.openalliance.ad.ph$a */
    public interface a {
        /* renamed from: a */
        void mo42424a(List<PermissionEntity> list);
    }

    public C7574ph(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f35321b = applicationContext;
        this.f35322c = C7118fb.m43196a(applicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public List<PermissionEntity> m46763b(AppInfo appInfo) {
        if (appInfo == null || TextUtils.isEmpty(appInfo.getPackageName())) {
            AbstractC7185ho.m43823c(f35320a, "empty request parameters");
            return null;
        }
        PermissionRsp permissionRspMo43271a = this.f35322c.mo43271a(appInfo.getPackageName(), appInfo.m44436x(), appInfo.m44438y(), appInfo.m44342B(), C7845x.m48577k(this.f35321b));
        if (permissionRspMo43271a != null) {
            AbstractC7185ho.m43821b(f35320a, "request permissions, retCode: %s", Integer.valueOf(permissionRspMo43271a.m40956a()));
            appInfo.m44372a(permissionRspMo43271a.m40957b());
        }
        return appInfo.getPermissions();
    }

    /* renamed from: c */
    private String m46764c(AppInfo appInfo) {
        if (appInfo == null) {
            return "";
        }
        return appInfo.getPackageName() + "_" + appInfo.m44436x() + "_" + appInfo.m44438y() + "_" + AbstractC7807d.m48204a() + "_" + AbstractC7811dd.m48322d();
    }

    public C7574ph(Context context, a aVar) {
        this(context);
        this.f35323d = aVar;
    }

    /* renamed from: a */
    public void m46765a(final AppInfo appInfo) {
        if (appInfo != null && AbstractC7760bg.m47767a(appInfo.getPermissions()) && appInfo.m44435w()) {
            final C7783cc c7783ccM47879a = C7783cc.m47879a();
            final String strM46764c = m46764c(appInfo);
            listM47881a = TextUtils.isEmpty(strM46764c) ? null : c7783ccM47879a.m47881a(strM46764c);
            if (AbstractC7760bg.m47767a(listM47881a)) {
                AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.ph.1
                    @Override // java.lang.Runnable
                    public void run() {
                        List<PermissionEntity> listM46763b = C7574ph.this.m46763b(appInfo);
                        if (!AbstractC7760bg.m47767a(listM46763b)) {
                            c7783ccM47879a.m47882a(strM46764c, listM46763b);
                        }
                        C7574ph.this.m46762a(listM46763b);
                    }
                });
                return;
            }
            appInfo.m44381b(listM47881a);
        }
        m46762a(listM47881a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m46762a(List<PermissionEntity> list) {
        a aVar = this.f35323d;
        if (aVar != null) {
            aVar.mo42424a(list);
        }
    }
}
