package p031b7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.content.FileProvider;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.File;
import p015ak.C0209d;
import p035bk.C1248a;
import p514o9.C11829c;
import p514o9.C11839m;
import p757x.AbstractC13671c;
import p757x.C13672d;

/* renamed from: b7.p */
/* loaded from: classes2.dex */
public class C1135p {
    /* renamed from: a */
    public static void m6938a(Uri uri, Activity activity, int i10) {
        C1120a.m6677i("SelectPicUtils", "begin to crop image");
        Intent intent = new Intent("com.android.camera.action.CROP");
        Uri uriM6941d = m6941d(activity);
        try {
            intent.setDataAndType(uri, "image/*");
            intent.putExtra("crop", FaqConstants.DISABLE_HA_REPORT);
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("outputX", 1080);
            intent.putExtra("outputY", 1080);
            intent.putExtra("return-data", false);
            intent.putExtra("output", uriM6941d);
            intent.putExtra("outputFormat", Bitmap.CompressFormat.PNG);
            String strM70522I = C11829c.m70522I(activity, intent);
            C1120a.m6677i("SelectPicUtils", "packageName:" + strM70522I);
            if (!TextUtils.isEmpty(strM70522I)) {
                C0209d.m1302r2(intent, strM70522I);
                activity.grantUriPermission(strM70522I, uriM6941d, 3);
            }
            activity.startActivityForResult(intent, i10);
        } catch (SecurityException unused) {
            C1120a.m6676e("SelectPicUtils", "Did not have read-access to uri.");
        } catch (Exception e10) {
            C1120a.m6676e("SelectPicUtils", "Exception:" + e10.getMessage());
        }
    }

    /* renamed from: b */
    public static void m6939b(Activity activity, int i10) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        intent.putExtra("support-multipick-items", false);
        intent.putExtra("android.intent.extra.LOCAL_ONLY", true);
        String strM70522I = C11829c.m70522I(activity, intent);
        if (!TextUtils.isEmpty(strM70522I)) {
            C0209d.m1302r2(intent, strM70522I);
        }
        activity.startActivityForResult(intent, i10);
    }

    /* renamed from: c */
    public static File m6940c(Context context) {
        return new File(context.getFilesDir(), "temp");
    }

    /* renamed from: d */
    public static Uri m6941d(Context context) {
        Uri uriForFile = FileProvider.getUriForFile(context, FeedbackConst.Mail.HIDISK_FILE_PROVIDER, new File(context.getFilesDir(), "temp"));
        C1120a.m6676e("SelectPicUtils", "outputUri:" + uriForFile.toString());
        return uriForFile;
    }

    /* renamed from: e */
    public static void m6942e(Context context, ImageView imageView, float f10) {
        try {
            AbstractC13671c abstractC13671cM82255a = C13672d.m82255a(context.getResources(), C1248a.m7475f(context.getContentResolver().openInputStream(m6941d(context))));
            abstractC13671cM82255a.m82252e(C1140u.m7190b(context, f10));
            imageView.setImageDrawable(abstractC13671cM82255a);
        } catch (Exception e10) {
            C11839m.m70687e("SelectPicUtils", "Exception: " + e10.getMessage());
        }
    }
}
