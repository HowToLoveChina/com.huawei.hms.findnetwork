package p420k7;

import android.content.Context;
import android.content.DialogInterface;
import bo.InterfaceC1268b;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$string;
import gp.C10028c;
import p676ud.AlertDialogC13154a;

/* renamed from: k7.b */
/* loaded from: classes2.dex */
public class AlertDialogC11015b extends AlertDialogC13154a {

    /* renamed from: a */
    public Context f52082a;

    /* renamed from: b */
    public InterfaceC1268b f52083b;

    /* renamed from: k7.b$a */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AlertDialogC11015b.this.cancel();
            if (AlertDialogC11015b.this.m66367c()) {
                if (AlertDialogC11015b.this.f52083b != null) {
                    AlertDialogC11015b.this.f52083b.mo7532u();
                }
            } else if (AlertDialogC11015b.this.f52083b != null) {
                AlertDialogC11015b.this.f52083b.mo7531n(false);
            }
        }
    }

    /* renamed from: k7.b$b */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AlertDialogC11015b.this.f52083b.mo7530X();
            AlertDialogC11015b.this.cancel();
        }
    }

    public AlertDialogC11015b(Context context, InterfaceC1268b interfaceC1268b) {
        super(context);
        this.f52082a = context;
        this.f52083b = interfaceC1268b;
        initView();
    }

    private void initView() {
        setCancelable(false);
        setMessage(this.f52082a.getString(R$string.cloud_service_terms_disagree));
        setButton(-1, this.f52082a.getString(R$string.cloud_service_terms_stop), new a());
        setButton(-2, this.f52082a.getString(R$string.cloudbackup_Cancel), new b());
    }

    /* renamed from: c */
    public final boolean m66367c() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        return c10028cM62182c0.m62388s("addressbook") || c10028cM62182c0.m62388s("wlan") || c10028cM62182c0.m62388s("notepad") || c10028cM62182c0.m62388s("calendar");
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        getButton(-1).setTextColor(this.f52082a.getResources().getColor(R$color.enui50_red_color));
    }
}
