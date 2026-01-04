package uk;

import android.app.Activity;
import android.content.Context;
import com.huawei.hicloud.base.p103ui.NotificationDialog;
import dk.C9163d;
import p015ak.C0209d;
import p015ak.C0226l0;
import p399jk.AbstractC10896a;
import p494nk.C11718b;

/* renamed from: uk.c */
/* loaded from: classes6.dex */
public class C13205c {

    /* renamed from: b */
    public static final C13205c f59837b = new C13205c();

    /* renamed from: a */
    public NotificationDialog f59838a;

    /* renamed from: d */
    public static C13205c m79395d() {
        return f59837b;
    }

    /* renamed from: c */
    public void m79396c() {
        AbstractC10896a.m65887i("NotificationDialogManager", "dismissPermissionNotice");
        C0226l0.m1586f(new Runnable() { // from class: uk.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f59836a.m79397e();
            }
        });
    }

    /* renamed from: e */
    public final /* synthetic */ void m79397e() {
        try {
            NotificationDialog notificationDialog = this.f59838a;
            if (notificationDialog != null) {
                notificationDialog.dismiss();
                this.f59838a = null;
            }
        } catch (Exception e10) {
            AbstractC10896a.m65887i("NotificationDialogManager", "dismissPermissionNotice err: " + e10.getMessage());
        }
    }

    /* renamed from: g */
    public void m79399g(final Activity activity, String str) {
        AbstractC10896a.m65887i("NotificationDialogManager", "showPermissionNotice");
        String strM69910i = new C11718b().m69910i(str, activity);
        final String strM57584a = C9163d.m57584a(str);
        final String str2 = String.format(C9163d.m57584a("R.string.some_permission_instruction"), strM69910i);
        C0226l0.m1586f(new Runnable() { // from class: uk.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f59832a.m79398f(activity, str2, strM57584a);
            }
        });
    }

    /* renamed from: h */
    public void m79398f(Context context, String str, String str2) {
        AbstractC10896a.m65887i("NotificationDialogManager", "showPermissionNotice");
        if (C0209d.m1202Q0()) {
            AbstractC10896a.m65885d("NotificationDialogManager", "show nothing");
            return;
        }
        try {
            if (this.f59838a == null) {
                this.f59838a = new NotificationDialog(context);
            }
            this.f59838a.create();
            this.f59838a.m29119b(str, str2);
        } catch (Exception e10) {
            AbstractC10896a.m65887i("NotificationDialogManager", "showPermissionNotice err: " + e10.getMessage());
        }
    }
}
