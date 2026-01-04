package p676ud;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.huawei.hicloud.sync.R$string;
import gp.C10028c;
import p422k9.C11019b;
import p514o9.C11842p;

/* renamed from: ud.d */
/* loaded from: classes3.dex */
public class AlertDialogC13157d extends AlertDialogC13154a {

    /* renamed from: a */
    public Activity f59664a;

    /* renamed from: b */
    public int f59665b;

    /* renamed from: ud.d$a */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C10028c c10028cM62182c0 = C10028c.m62182c0();
            boolean zM62395t1 = c10028cM62182c0.m62395t1("is_all_guide_over");
            boolean zM62395t12 = c10028cM62182c0.m62395t1("is_already_configed_NV4");
            if (i10 != -1) {
                if (i10 == -2) {
                    if (zM62395t1) {
                        c10028cM62182c0.m62377p3("is_agree_root_alert_gallery", false);
                        c10028cM62182c0.m62377p3("is_agree_root_alert_hicloud", false);
                    }
                    AlertDialogC13157d.this.dismiss();
                    if (C11842p.m70774V0(AlertDialogC13157d.this.f59664a)) {
                        return;
                    }
                    AlertDialogC13157d.this.f59664a.finish();
                    return;
                }
                return;
            }
            if (!zM62395t1 || !zM62395t12) {
                AlertDialogC13157d alertDialogC13157d = AlertDialogC13157d.this;
                alertDialogC13157d.m79149e(alertDialogC13157d.f59664a);
                AlertDialogC13157d.this.dismiss();
            } else {
                if (AlertDialogC13157d.this.f59665b == 1) {
                    c10028cM62182c0.m62377p3("is_agree_root_alert_gallery", true);
                } else if (AlertDialogC13157d.this.f59665b == 2) {
                    c10028cM62182c0.m62377p3("is_agree_root_alert_hicloud", true);
                }
                AlertDialogC13157d.this.dismiss();
            }
        }
    }

    public AlertDialogC13157d(Activity activity, DialogInterface.OnClickListener onClickListener, int i10) {
        super(activity);
        this.f59664a = activity;
        this.f59665b = i10;
        onClickListener = onClickListener == null ? new a() : onClickListener;
        setCanceledOnTouchOutside(false);
        setMessage(this.f59664a.getString(R$string.root_alert_msg1));
        setButton(-1, this.f59664a.getString(R$string.root_alert_go_on), onClickListener);
        setButton(-2, this.f59664a.getString(R$string.root_alert_not_use), onClickListener);
    }

    /* renamed from: c */
    public static boolean m79147c(Context context, int i10) {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (i10 == 1) {
            return c10028cM62182c0.m62395t1("is_agree_root_alert_gallery");
        }
        if (i10 == 2) {
            return c10028cM62182c0.m62395t1("is_agree_root_alert_hicloud");
        }
        return false;
    }

    /* renamed from: d */
    public static void m79148d(Context context, int i10) {
        if (context == null) {
            return;
        }
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (i10 == 1) {
            c10028cM62182c0.m62377p3("is_agree_root_alert_gallery", true);
        } else if (i10 == 2) {
            c10028cM62182c0.m62377p3("is_agree_root_alert_hicloud", true);
        }
    }

    /* renamed from: e */
    public void m79149e(Context context) {
        C11019b.m66371t().m66455y0(context, this.f59664a);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        this.f59664a.finish();
    }
}
