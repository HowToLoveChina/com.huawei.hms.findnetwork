package p014aj;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import bj.C1247a;
import com.huawei.cloud.pay.config.bean.BannerAfterPayItem;
import com.huawei.cloud.pay.config.bean.BannerAfterPayRealtePackage;
import hk.C10278a;
import java.io.File;
import p015ak.C0212e0;
import p015ak.C0213f;
import p054cj.C1442a;
import p341hj.C10268v;
import p454lj.C11278a;
import p514o9.C11829c;
import p616rk.C12515a;
import p783xp.C13843a;

/* renamed from: aj.a */
/* loaded from: classes5.dex */
public class C0202a {

    /* renamed from: aj.a$a */
    public static class a {

        /* renamed from: a */
        public static C0202a f767a = new C0202a();
    }

    /* renamed from: c */
    public static C0202a m1119c() {
        return a.f767a;
    }

    /* renamed from: a */
    public void m1120a() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C1442a.m8289e("BannerAfterPayManager", "clearPayAfterFiles context is null.");
            return;
        }
        File fileM63442h = C10278a.m63442h(contextM1377a.getFilesDir() + File.separator + "HiCloudPayBanners.json");
        if (fileM63442h.exists() && fileM63442h.delete()) {
            C1442a.m8290i("BannerAfterPayManager", "clearPayAfterFiles delete");
        }
        C13843a.m83085g(contextM1377a.getFilesDir() + "/pay_after_banner_pic");
        C0212e0.m1352b(contextM1377a, "pay_after_banner_pic_info");
    }

    /* renamed from: b */
    public Bitmap m1121b(BannerAfterPayItem bannerAfterPayItem) {
        Bitmap bitmapM70501B = C11829c.m70501B(C0212e0.m1363m(C0213f.m1377a(), "pay_after_banner_pic_info", C11278a.m67686d(bannerAfterPayItem.getPictures()), null));
        if (bitmapM70501B == null) {
            C1442a.m8289e("BannerAfterPayManager", "getBannerBitmap bannerBitmap is null.");
            m1123e(2);
        }
        return bitmapM70501B;
    }

    /* renamed from: d */
    public void m1122d(BannerAfterPayRealtePackage bannerAfterPayRealtePackage, Handler handler) {
        if (bannerAfterPayRealtePackage == null) {
            C1442a.m8289e("BannerAfterPayManager", "startGetBannerParams buyPackage is null.");
        } else {
            new C10268v(bannerAfterPayRealtePackage, handler).m63381g();
        }
    }

    /* renamed from: e */
    public void m1123e(int i10) {
        C1442a.m8290i("BannerAfterPayManager", "startTask");
        C12515a.m75110o().m75172d(new C1247a(i10));
    }
}
