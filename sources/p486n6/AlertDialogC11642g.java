package p486n6;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.activity.GalleryMainActivity;
import p676ud.AlertDialogC13154a;

/* renamed from: n6.g */
/* loaded from: classes2.dex */
public class AlertDialogC11642g extends AlertDialogC13154a {

    /* renamed from: a */
    public GalleryMainActivity f53998a;

    /* renamed from: b */
    public Context f53999b;

    /* renamed from: n6.g$a */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                AlertDialogC11642g.this.f53998a.m13549o3();
            } else if (-2 == i10) {
                AlertDialogC11642g.this.f53998a.m13557w3();
            }
        }
    }

    /* renamed from: n6.g$b */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AlertDialogC11642g.this.f53998a.m13557w3();
        }
    }

    public AlertDialogC11642g(Context context, GalleryMainActivity galleryMainActivity) {
        super(context);
        this.f53998a = galleryMainActivity;
        this.f53999b = context;
        a aVar = new a();
        setButton(-1, context.getString(R$string.common_btn_close), aVar);
        setButton(-2, context.getString(R$string.cloudbackup_btn_cancel), aVar);
        setOnCancelListener(new b());
        setCanceledOnTouchOutside(false);
        setMessage(this.f53999b.getString(R$string.cg_classify_closed_alert_new));
    }
}
