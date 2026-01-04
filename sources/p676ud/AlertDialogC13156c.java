package p676ud;

import android.app.Activity;
import android.content.DialogInterface;
import com.huawei.hicloud.sync.R$string;
import p514o9.C11829c;

/* renamed from: ud.c */
/* loaded from: classes3.dex */
public class AlertDialogC13156c extends AlertDialogC13154a {

    /* renamed from: a */
    public Activity f59661a;

    /* renamed from: b */
    public int f59662b;

    /* renamed from: ud.c$a */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -1) {
                C11829c.m70615s1(AlertDialogC13156c.this.f59661a, AlertDialogC13156c.this.f59662b);
            }
            AlertDialogC13156c.this.dismiss();
        }
    }

    public AlertDialogC13156c(Activity activity, DialogInterface.OnClickListener onClickListener) {
        this(activity, onClickListener, R$string.CS_network_connect_error);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    public AlertDialogC13156c(Activity activity, DialogInterface.OnClickListener onClickListener, int i10) {
        super(activity);
        this.f59662b = -1;
        this.f59661a = activity;
        onClickListener = onClickListener == null ? new a() : onClickListener;
        setMessage(this.f59661a.getString(i10));
        setButton(-1, this.f59661a.getString(R$string.set_net), onClickListener);
        setButton(-2, this.f59661a.getString(R$string.cloudbackup_btn_cancel), onClickListener);
    }
}
