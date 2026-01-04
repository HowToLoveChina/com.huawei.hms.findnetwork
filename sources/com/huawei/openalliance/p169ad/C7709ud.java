package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import java.io.ByteArrayOutputStream;

/* renamed from: com.huawei.openalliance.ad.ud */
/* loaded from: classes8.dex */
public final class C7709ud {
    /* renamed from: a */
    private static Bitmap m47360a(Context context, C7706ua c7706ua) {
        Bitmap bitmapM47361a = m47361a(context, c7706ua.m47341a());
        return bitmapM47361a == null ? BitmapFactory.decodeStream(context.getResources().openRawResource(c7706ua.m47348e())) : bitmapM47361a;
    }

    /* renamed from: a */
    public static Bitmap m47361a(Context context, String str) {
        C7653sb c7653sb = new C7653sb();
        c7653sb.m47187d(str);
        c7653sb.m47181b(false);
        return (Bitmap) AbstractC7810dc.m48268a(new CallableC7702tx(new C7650rz(context, c7653sb)), RippleView.SINGLE_RIPPLE_TIME, null);
    }

    /* renamed from: a */
    private static Bitmap m47362a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == height) {
            return bitmap;
        }
        int iMin = Math.min(width, height);
        return Bitmap.createBitmap(bitmap, (width - iMin) / 2, (height - iMin) / 2, iMin, iMin);
    }

    /* renamed from: a */
    public static String m47363a(String str, int i10) {
        return (TextUtils.isEmpty(str) || str.length() <= i10) ? str : str.substring(0, i10);
    }

    /* renamed from: a */
    public static boolean m47364a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            AbstractC7185ho.m43824c("ShareUtil", "class not fount %s", str);
            return false;
        }
    }

    /* renamed from: a */
    public static byte[] m47365a(Context context, C7706ua c7706ua, int i10) {
        byte[] bArr = new byte[0];
        if (c7706ua == null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Bitmap bitmapM47360a = m47360a(context, c7706ua);
            if (bitmapM47360a == null) {
                return bArr;
            }
            Bitmap bitmapM47362a = m47362a(bitmapM47360a);
            int i11 = 100;
            bitmapM47362a.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            while (byteArrayOutputStream.toByteArray().length > i10) {
                byteArrayOutputStream.reset();
                bitmapM47362a.compress(Bitmap.CompressFormat.JPEG, i11, byteArrayOutputStream);
                i11 -= 5;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            try {
                AbstractC7185ho.m43824c("ShareUtil", "get bitmap arr failed, cause: %s", th2.getClass().getSimpleName());
                return bArr;
            } finally {
                AbstractC7805cy.m48142a(byteArrayOutputStream);
            }
        }
    }
}
