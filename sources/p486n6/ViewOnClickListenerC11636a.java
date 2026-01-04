package p486n6;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.activity.AppealMainActivity;
import p015ak.C0224k0;
import p031b7.C1120a;
import p514o9.C11829c;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* renamed from: n6.a */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC11636a extends AlertDialogC13154a implements View.OnClickListener {

    /* renamed from: a */
    public Activity f53970a;

    /* renamed from: b */
    public View f53971b;

    public ViewOnClickListenerC11636a(Activity activity) throws IllegalAccessException, IllegalArgumentException {
        super(activity);
        this.f53970a = activity;
        View viewInflate = LayoutInflater.from(activity).inflate(R$layout.album_account_abnormal, (ViewGroup) null);
        this.f53971b = viewInflate;
        ((TextView) C12809f.m76831d(viewInflate, R$id.tv_known)).setOnClickListener(this);
        ((TextView) C12809f.m76831d(this.f53971b, R$id.tv_go_appeal)).setOnClickListener(this);
        setView(this.f53971b);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(1024, 1024);
        }
        setCanceledOnTouchOutside(false);
        C11829c.m70594l1(activity, this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.tv_known) {
            dismiss();
            return;
        }
        if (id2 == R$id.tv_go_appeal) {
            if (this.f53970a == null) {
                C1120a.m6676e("AccountRiskManageDialog", "context is null");
                return;
            }
            Intent intent = new Intent();
            intent.setClass(this.f53970a, AppealMainActivity.class);
            intent.putExtra("appeal_type", "account");
            C0224k0.m1542L(this.f53970a, intent);
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
