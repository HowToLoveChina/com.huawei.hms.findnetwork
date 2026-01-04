package p469m4;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: m4.m */
/* loaded from: classes.dex */
public class C11412m {
    /* renamed from: a */
    public static String m68359a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Log.w("ResourcesUtils", "resName is empty");
            return null;
        }
        int identifier = context.getResources().getIdentifier(str2, ExtractOWiFiHelper.STING_NODE, str);
        if (identifier == 0) {
            Log.w("ResourcesUtils", "resId == 0");
            return null;
        }
        try {
            return context.getResources().getString(identifier);
        } catch (Resources.NotFoundException e10) {
            Log.e("ResourcesUtils", "resources not fund" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public static String m68360b(Context context, String str, String str2, String str3) {
        try {
            return m68359a(context, str, str2 + C11400a.m68317c(m68361c(str3.getBytes("utf-8"))));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e10) {
            Log.e("ResourcesUtils", "getResources exception:" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static byte[] m68361c(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(bArr);
    }
}
