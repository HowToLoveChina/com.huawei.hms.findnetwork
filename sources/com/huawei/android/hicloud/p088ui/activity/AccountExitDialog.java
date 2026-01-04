package com.huawei.android.hicloud.p088ui.activity;

import ae.C0123f1;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import de.C9087n;
import huawei.android.widget.HwTextView;
import p015ak.C0209d;
import p514o9.C11842p;
import sk.C12806c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class AccountExitDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    public NestedScrollView f13464a;

    /* renamed from: b */
    public HwTextView f13465b;

    /* renamed from: c */
    public HwTextView f13466c;

    /* renamed from: d */
    public HwTextView f13467d;

    /* renamed from: e */
    public HwTextView f13468e;

    /* renamed from: f */
    public HwTextView f13469f;

    /* renamed from: g */
    public Context f13470g;

    /* renamed from: h */
    public LinearLayout f13471h;

    /* renamed from: i */
    public RecyclerView f13472i;

    /* renamed from: j */
    public C0123f1 f13473j;

    /* renamed from: k */
    public AccountExitDialogClickCallback f13474k;

    /* renamed from: l */
    public DialogHeightChangeCallBack f13475l;

    /* renamed from: m */
    public int f13476m;

    public interface AccountExitDialogClickCallback {
        /* renamed from: a */
        void mo18525a();

        /* renamed from: b */
        void mo18526b();

        void onCancel();
    }

    public interface DialogHeightChangeCallBack {
        /* renamed from: a */
        void mo18527a(int i10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.AccountExitDialog$a */
    public class ViewOnLayoutChangeListenerC3114a implements View.OnLayoutChangeListener {
        public ViewOnLayoutChangeListenerC3114a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            int height = view.getHeight();
            int iM18522f = AccountExitDialog.this.m18522f();
            if (height > iM18522f) {
                AccountExitDialog.this.f13476m = iM18522f;
                height = iM18522f;
            } else {
                AccountExitDialog.this.f13476m = height;
            }
            if (height != 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AccountExitDialog.this.f13464a.getLayoutParams();
                layoutParams.height = height;
                AccountExitDialog.this.f13464a.setLayoutParams(layoutParams);
                if (AccountExitDialog.this.f13475l != null) {
                    AccountExitDialog.this.f13475l.mo18527a(AccountExitDialog.this.f13476m);
                }
            }
            view.removeOnLayoutChangeListener(this);
        }
    }

    public AccountExitDialog(Context context, C0123f1 c0123f1, AccountExitDialogClickCallback accountExitDialogClickCallback, DialogHeightChangeCallBack dialogHeightChangeCallBack) {
        super(context);
        requestWindowFeature(1);
        this.f13470g = context;
        this.f13473j = c0123f1;
        this.f13474k = accountExitDialogClickCallback;
        this.f13475l = dialogHeightChangeCallBack;
        m18523g();
    }

    /* renamed from: e */
    public final int m18521e() {
        return C0209d.m1195O(this.f13470g) >= 1.75f ? R$layout.account_exit_third_btn_dialog_3dot2 : R$layout.account_exit_third_btn_dialog;
    }

    /* renamed from: f */
    public int m18522f() {
        this.f13471h.getMeasuredHeight();
        return ((this.f13470g.getResources().getDisplayMetrics().heightPixels - (C12806c.m76818i(this.f13470g) ? C12809f.m76835h(this.f13470g) : 0)) * 8) / 10;
    }

    /* renamed from: g */
    public final void m18523g() {
        View viewM76832e = C12809f.m76832e(getLayoutInflater(), m18521e());
        setContentView(viewM76832e);
        this.f13471h = (LinearLayout) C12809f.m76831d(viewM76832e, R$id.out_linear_layout);
        this.f13464a = (NestedScrollView) C12809f.m76831d(viewM76832e, R$id.exit_outer_scroll);
        m18524h();
        this.f13465b = C12809f.m76831d(viewM76832e, R$id.exit_save_tips);
        this.f13466c = C12809f.m76831d(viewM76832e, R$id.exit_delete_tips);
        this.f13467d = C12809f.m76831d(viewM76832e, R$id.exit_save_data_btn);
        this.f13468e = C12809f.m76831d(viewM76832e, R$id.exit_delete_data_btn);
        this.f13469f = C12809f.m76831d(viewM76832e, R$id.exit_cancel_btn);
        this.f13472i = (RecyclerView) C12809f.m76831d(viewM76832e, R$id.exit_app_recycle);
        setCanceledOnTouchOutside(false);
        this.f13467d.setOnClickListener(this);
        this.f13468e.setOnClickListener(this);
        this.f13469f.setOnClickListener(this);
        this.f13472i.setClickable(false);
        this.f13472i.setContextClickable(false);
        this.f13472i.setLongClickable(false);
        this.f13472i.setPressed(false);
        this.f13472i.setEnabled(false);
        this.f13472i.addItemDecoration(new C9087n(this.f13470g, (int) C11842p.m70844o(getContext(), 16), (int) C11842p.m70844o(getContext(), 10)));
        this.f13472i.setLayoutManager(new GridLayoutManager(getContext(), 4));
        this.f13472i.setAdapter(this.f13473j);
        String string = this.f13470g.getString(R$string.new_exit_cloud_space_save_tips_new);
        String string2 = this.f13470g.getString(R$string.new_exit_cloud_space_remove_tips_new);
        this.f13465b.setText(string);
        this.f13466c.setText(string2);
    }

    /* renamed from: h */
    public void m18524h() {
        NestedScrollView nestedScrollView = this.f13464a;
        if (nestedScrollView == null) {
            return;
        }
        nestedScrollView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC3114a());
        if (this.f13476m != 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13464a.getLayoutParams();
            layoutParams.height = this.f13476m;
            this.f13464a.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.exit_save_data_btn) {
            AccountExitDialogClickCallback accountExitDialogClickCallback = this.f13474k;
            if (accountExitDialogClickCallback != null) {
                accountExitDialogClickCallback.mo18525a();
                return;
            }
            return;
        }
        if (id2 == R$id.exit_delete_data_btn) {
            AccountExitDialogClickCallback accountExitDialogClickCallback2 = this.f13474k;
            if (accountExitDialogClickCallback2 != null) {
                accountExitDialogClickCallback2.mo18526b();
                return;
            }
            return;
        }
        if (id2 == R$id.exit_cancel_btn) {
            AccountExitDialogClickCallback accountExitDialogClickCallback3 = this.f13474k;
            if (accountExitDialogClickCallback3 != null) {
                accountExitDialogClickCallback3.onCancel();
            }
            dismiss();
        }
    }
}
