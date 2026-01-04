package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.MotionData;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;

/* renamed from: com.huawei.openalliance.ad.bq */
/* loaded from: classes8.dex */
public class C6973bq {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static C7653sb m41063b(Asset asset) {
        if (asset == null || asset.m40517e() == null) {
            return null;
        }
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47187d(asset.m40517e().m40595a());
        c7653sb.m47184c(asset.m40517e().m40610f());
        c7653sb.m47181b(asset.m40517e().m40612h() == 0);
        c7653sb.m47185c(true);
        c7653sb.m47180b(Constants.TEMPLATE_VIDEO_SUB_DIR);
        c7653sb.m47173a(true);
        return c7653sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static C7653sb m41064b(MotionData motionData) {
        if (motionData == null) {
            return null;
        }
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47187d(motionData.m40539g());
        c7653sb.m47184c(motionData.m40540h());
        c7653sb.m47181b(true);
        c7653sb.m47185c(true);
        c7653sb.m47190e(Constants.TPLATE_CACHE);
        return c7653sb;
    }

    /* renamed from: a */
    public static boolean m41062a(Context context, ContentRecord contentRecord) {
        String str;
        AbstractC7185ho.m43817a("TDownloadUtil", "checkAndDownloadContent");
        if (contentRecord == null) {
            str = "content is null";
        } else {
            if (!AbstractC7760bg.m47767a(contentRecord.m41471aW())) {
                C7022dk c7022dkM41937a = C7019dh.m41937a(context, Constants.TPLATE_CACHE);
                final InterfaceC7140fx interfaceC7140fxM43196a = C7118fb.m43196a(context);
                boolean z10 = true;
                for (final Asset asset : contentRecord.m41471aW()) {
                    if (asset != null && asset.m40517e() != null && !AbstractC7731ae.m47458b(c7022dkM41937a.m41968c(c7022dkM41937a.m41970e(asset.m40517e().m40595a())))) {
                        AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.bq.1
                            @Override // java.lang.Runnable
                            public void run() {
                                C7653sb c7653sbM41063b = C6973bq.m41063b(asset);
                                if (c7653sbM41063b != null) {
                                    c7653sbM41063b.m47185c(true);
                                    c7653sbM41063b.m47190e(Constants.TPLATE_CACHE);
                                    C7654sc c7654scMo43274a = interfaceC7140fxM43196a.mo43274a(c7653sbM41063b);
                                    if (c7654scMo43274a == null || TextUtils.isEmpty(c7654scMo43274a.m47207a())) {
                                        AbstractC7185ho.m43820b("TDownloadUtil", "down asset failed");
                                    }
                                }
                            }
                        });
                        z10 = false;
                    }
                }
                if (contentRecord.m41469aU() != null && !AbstractC7760bg.m47767a(contentRecord.m41469aU().m40554c())) {
                    for (final MotionData motionData : contentRecord.m41469aU().m40554c()) {
                        if (motionData != null && !AbstractC7731ae.m47458b(c7022dkM41937a.m41968c(c7022dkM41937a.m41970e(motionData.m40539g())))) {
                            AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.bq.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    C7654sc c7654scMo43274a = interfaceC7140fxM43196a.mo43274a(C6973bq.m41064b(motionData));
                                    if (c7654scMo43274a == null || TextUtils.isEmpty(c7654scMo43274a.m47207a())) {
                                        AbstractC7185ho.m43821b("TDownloadUtil", "down motion failed %s", c7654scMo43274a);
                                    }
                                }
                            });
                            z10 = false;
                        }
                    }
                }
                AbstractC7185ho.m43821b("TDownloadUtil", "result: %s", Boolean.valueOf(z10));
                return z10;
            }
            str = "assets is null";
        }
        AbstractC7185ho.m43820b("TDownloadUtil", str);
        return false;
    }
}
