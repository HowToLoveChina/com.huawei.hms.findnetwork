package p812yj;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import sk.AlertDialogC12804a;

/* renamed from: yj.b */
/* loaded from: classes5.dex */
public class AlertDialogC13993b extends AlertDialogC12804a {

    /* renamed from: a */
    public InterfaceC13992a f62697a;

    /* renamed from: b */
    public int f62698b;

    /* renamed from: yj.b$a */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            if (AlertDialogC13993b.this.f62697a != null) {
                AlertDialogC13993b.this.f62697a.onClickNegative(AlertDialogC13993b.this.f62698b);
            }
        }
    }

    /* renamed from: yj.b$b */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            if (AlertDialogC13993b.this.f62697a != null) {
                if (i10 == -1) {
                    AlertDialogC13993b.this.f62697a.mo29091a(AlertDialogC13993b.this.f62698b);
                } else if (i10 == -2) {
                    AlertDialogC13993b.this.f62697a.onClickNegative(AlertDialogC13993b.this.f62698b);
                }
            }
        }
    }

    public AlertDialogC13993b(Activity activity, InterfaceC13992a interfaceC13992a, int i10) {
        super(activity);
        this.f62697a = interfaceC13992a;
        this.f62698b = i10;
        setOnCancelListener(new a());
    }

    /* renamed from: c */
    public void m84031c(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            super.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            super.setMessage(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            super.setButton(-1, str3, new b());
        }
        if (!TextUtils.isEmpty(str4)) {
            super.setButton(-2, str4, new b());
        }
        super.show();
    }
}
