package p428kj;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.cloud.pay.R$string;
import p664u0.C13108a;

/* renamed from: kj.b */
/* loaded from: classes5.dex */
public class AlertDialogC11057b extends AlertDialogC11056a {

    /* renamed from: a */
    public Context f52224a;

    /* renamed from: b */
    public Activity f52225b;

    /* renamed from: kj.b$a */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AlertDialogC11057b.this.cancel();
            C13108a.m78878b(AlertDialogC11057b.this.f52224a.getApplicationContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.PRIVATE_SPACE"));
            AlertDialogC11057b.this.f52225b.finish();
        }
    }

    public AlertDialogC11057b(Context context, Activity activity) {
        super(context);
        this.f52224a = context;
        this.f52225b = activity;
        m66625c();
    }

    /* renamed from: c */
    public final void m66625c() {
        setCancelable(false);
        setMessage(this.f52224a.getString(R$string.cloud_unsupport_private_space));
        setButton(-1, this.f52224a.getString(R$string.cloudpay_huaweipay_sure), new a());
    }
}
