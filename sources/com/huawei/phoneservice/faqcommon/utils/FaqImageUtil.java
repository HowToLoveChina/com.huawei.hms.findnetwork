package com.huawei.phoneservice.faqcommon.utils;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import java.io.ByteArrayOutputStream;

/* loaded from: classes4.dex */
public class FaqImageUtil {
    /* renamed from: a */
    public static byte[] m52496a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int i10 = 70;
        while (byteArrayOutputStream.toByteArray().length / 1024 > 32) {
            byteArrayOutputStream.reset();
            i10 -= 20;
            if (i10 <= 10) {
                break;
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, i10, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m52497b(android.graphics.Bitmap r6) throws java.lang.Throwable {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
            r2 = 100
            r6.compress(r1, r2, r0)
            byte[] r2 = r0.toByteArray()
            int r2 = r2.length
            int r2 = r2 / 1024
            r3 = 32
            if (r2 <= r3) goto L73
            r0.reset()
            r2 = 80
            r6.compress(r1, r2, r0)
            android.graphics.BitmapFactory$Options r6 = new android.graphics.BitmapFactory$Options
            r6.<init>()
            r1 = 0
            r6.inJustDecodeBounds = r1
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r4 = "---------------"
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "FaqImageUtil"
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51846i(r4, r3)
            r3 = 1
            r4 = 1128792064(0x43480000, float:200.0)
            if (r1 <= r2) goto L54
            float r5 = (float) r1
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 <= 0) goto L54
            int r1 = r6.outWidth
        L50:
            float r1 = (float) r1
            float r1 = r1 / r4
            int r1 = (int) r1
            goto L5f
        L54:
            if (r1 >= r2) goto L5e
            float r1 = (float) r2
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 <= 0) goto L5e
            int r1 = r6.outHeight
            goto L50
        L5e:
            r1 = r3
        L5f:
            if (r1 > 0) goto L62
            goto L63
        L62:
            r3 = r1
        L63:
            r6.inSampleSize = r3
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            byte[] r0 = r0.toByteArray()
            r1.<init>(r0)
            r0 = 0
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r1, r0, r6)
        L73:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.faqcommon.utils.FaqImageUtil.m52497b(android.graphics.Bitmap):android.graphics.Bitmap");
    }

    @Keep
    public static byte[] compressImage(Bitmap bitmap) {
        return m52496a(m52497b(bitmap));
    }
}
