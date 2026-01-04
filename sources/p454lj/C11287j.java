package p454lj;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.huawei.cloud.pay.R$string;
import dj.C9159b;
import p054cj.C1442a;
import p514o9.C11829c;

/* renamed from: lj.j */
/* loaded from: classes5.dex */
public class C11287j {

    /* renamed from: lj.j$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f52935a;

        static {
            int[] iArr = new int[EnumC11283f.values().length];
            f52935a = iArr;
            try {
                iArr[EnumC11283f.NEED_BIND_EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52935a[EnumC11283f.BIND_EMAIL_FAILED_REBIND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52935a[EnumC11283f.ACTIVATION_SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52935a[EnumC11283f.ACTIVATION_SUCCESSES_AFTER_BIND_EMAIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52935a[EnumC11283f.BIND_EMAIL_FAILED_TIP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f52935a[EnumC11283f.ACTIVATION_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: d */
    public static /* synthetic */ void m67721d(boolean z10, Activity activity, DialogInterface dialogInterface, int i10) {
        if (z10) {
            activity.finish();
        }
    }

    /* renamed from: e */
    public static /* synthetic */ boolean m67722e(Activity activity, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        activity.finish();
        return false;
    }

    /* renamed from: g */
    public static void m67724g(final Activity activity, AlertDialog.Builder builder, EnumC11283f enumC11283f) {
        if (EnumC11283f.ACTIVATION_SUCCEEDED_TIP_BIND_EMAIL.compareTo(enumC11283f) >= 0) {
            builder.setPositiveButton(activity.getString(R$string.goto_bind_email_btn), new DialogInterface.OnClickListener() { // from class: lj.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    C9159b.m57562a(activity);
                }
            });
            builder.setNegativeButton(activity.getString(R$string.cancel), (DialogInterface.OnClickListener) null);
            return;
        }
        final boolean z10 = EnumC11283f.ACTIVATION_SUCCESS.compareTo(enumC11283f) <= 0;
        builder.setPositiveButton(activity.getString(R$string.error_display_got_it_button_text), new DialogInterface.OnClickListener() { // from class: lj.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                C11287j.m67721d(z10, activity, dialogInterface, i10);
            }
        });
        if (z10) {
            builder.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: lj.h
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                    return C11287j.m67722e(activity, dialogInterface, i10, keyEvent);
                }
            });
        }
    }

    /* renamed from: h */
    public static void m67725h(Context context, EnumC11283f enumC11283f, AlertDialog.Builder builder) {
        switch (a.f52935a[enumC11283f.ordinal()]) {
            case 1:
                builder.setMessage(context.getString(R$string.new_need_bind_email));
                break;
            case 2:
                builder.setMessage(context.getString(R$string.bind_email_failed_rebind));
                break;
            case 3:
                builder.setMessage(context.getString(R$string.activation_succeeded));
                break;
            case 4:
                builder.setMessage(context.getString(R$string.activation_succeeded_after_bind_email));
                break;
            case 5:
                builder.setMessage(context.getString(R$string.bind_email_failed_tip));
                break;
            case 6:
                builder.setMessage(context.getString(R$string.CS_ERR_for_cannot_conn_service));
                break;
        }
    }

    /* renamed from: i */
    public static void m67726i(Activity activity, EnumC11283f enumC11283f) throws IllegalAccessException, IllegalArgumentException {
        C1442a.m8290i("InActiveUserDialogUtil", "show dialog, dialog type is:" + enumC11283f);
        if (activity == null) {
            C1442a.m8289e("InActiveUserDialogUtil", "show dialog, context is null!");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        m67725h(activity, enumC11283f, builder);
        m67724g(activity, builder, enumC11283f);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        if (!activity.isFinishing()) {
            alertDialogCreate.show();
        }
        C11829c.m70594l1(activity, alertDialogCreate);
    }
}
