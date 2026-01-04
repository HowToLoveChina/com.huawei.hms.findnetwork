package pg;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import p015ak.C0214f0;

/* renamed from: pg.e */
/* loaded from: classes4.dex */
public class C12140e {
    /* renamed from: a */
    public static void m72777a(Context context) {
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0).edit();
        editorEdit.remove("AccountInfoaccountName");
        editorEdit.remove("AccountInfoserviceToken");
        editorEdit.remove("AccountInfoaccountType");
        editorEdit.remove("AccountInfositeID");
        editorEdit.remove("AccountInfodeviceID");
        editorEdit.remove("AccountInfodeviceType");
        editorEdit.remove("AccountInfouserID");
        editorEdit.commit();
    }
}
