package p514o9;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.util.SafeBase64;
import java.io.UnsupportedEncodingException;
import p015ak.C0209d;
import p015ak.C0221j;
import p417k4.AbstractC10984c;
import p783xp.C13843a;

/* renamed from: o9.l */
/* loaded from: classes3.dex */
public class C11838l {
    /* renamed from: a */
    public static void m70683a(Context context) {
        C11839m.m70688i("MapUtil", "clear map image files.");
        try {
            C0221j.m1499i(context.getFilesDir() + "/mappic/");
        } catch (Exception unused) {
            C11839m.m70687e("MapUtil", "clear map image files err");
        }
    }

    /* renamed from: b */
    public static String m70684b(Context context) {
        return (context.getFilesDir() + "/mappic/" + (C13843a.m83067S() ? "zh" : FaqConstants.DEFAULT_ISO_LANGUAGE)) + "_" + (C0209d.m1333z1(context) ? "_online.png" : "_offline.png");
    }

    /* renamed from: c */
    public static String m70685c() {
        try {
            return new String(SafeBase64.decode(AbstractC10984c.m66351c().mo66354d().mo66356b("/phonefinder/map_key"), 0), Constants.UTF_8);
        } catch (UnsupportedEncodingException e10) {
            C11839m.m70687e("MapUtil", "getMapKey error: " + e10.getMessage());
            return null;
        }
    }
}
