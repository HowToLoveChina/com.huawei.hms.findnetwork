package p015ak;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import p399jk.AbstractC10896a;

/* renamed from: ak.b0 */
/* loaded from: classes6.dex */
public class C0206b0 {

    /* renamed from: a */
    public static final Uri f768a = Uri.parse("content://com.huawei.android.hicloud.SwitchStatusProvider/globalSettings");

    /* renamed from: b */
    public static final Uri f769b = Uri.parse("content://com.huawei.android.hicloud.SwitchStatusProvider/syncContact");

    /* renamed from: c */
    public static final Uri f770c = Uri.parse("content://com.huawei.android.hicloud.SwitchStatusProvider/deviceName");

    /* renamed from: d */
    public static final Uri f771d = Uri.parse("content://com.huawei.android.hicloud.SwitchStatusProvider/syncSettings");

    /* renamed from: e */
    public static final Uri f772e = Uri.parse("content://com.huawei.android.hicloud.SwitchStatusProvider/syncSettingsDefaultTrue");

    /* renamed from: f */
    public static final Uri f773f = Uri.parse("content://com.huawei.android.hicloud.SwitchStatusProvider/updateBadgeForDs");

    /* renamed from: a */
    public static void m1129a(Context context) {
        m1132d(f773f, "", context);
    }

    /* renamed from: b */
    public static boolean m1130b(String str, Context context) {
        return m1132d(f770c, str, context);
    }

    /* renamed from: c */
    public static boolean m1131c(String str, Context context) {
        return m1132d(f768a, str, context);
    }

    /* renamed from: d */
    public static boolean m1132d(Uri uri, String str, Context context) {
        if (context == null) {
            AbstractC10896a.m65887i("QuerySwitchStatus", "querySwitchStatus context = null");
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uri, null, null, new String[]{str}, null);
                while (cursorQuery != null) {
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("switch_status"));
                    AbstractC10896a.m65885d("QuerySwitchStatus", "switch status: " + str + " = " + string);
                    if (string.contains(FaqConstants.DISABLE_HA_REPORT)) {
                        cursorQuery.close();
                        return true;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            } catch (Exception e10) {
                AbstractC10896a.m65886e("QuerySwitchStatus", " is not support!" + e10.toString());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    /* renamed from: e */
    public static boolean m1133e(String str, Context context) {
        return m1132d(f769b, str, context);
    }

    /* renamed from: f */
    public static boolean m1134f(String str, Context context) {
        return m1132d(f771d, str, context);
    }

    /* renamed from: g */
    public static boolean m1135g(String str, Context context) {
        return m1132d(f772e, str, context);
    }
}
