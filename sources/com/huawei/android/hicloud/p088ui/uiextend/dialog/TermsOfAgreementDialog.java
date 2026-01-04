package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.extend.PermissionListView;
import com.huawei.android.hicloud.p088ui.uiadapter.PermissionsItemAdapter;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p015ak.C0219i;
import p472m7.C11427b;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TermsOfAgreementDialog extends AlertDialogC13154a {
    private static final String TAG = "TermsOfAgreementDialog";
    private Context mContext;
    private DialogInterface.OnClickListener mListener;

    public TermsOfAgreementDialog(Context context, DialogInterface.OnClickListener onClickListener) {
        super(context);
        this.mContext = context;
        this.mListener = onClickListener;
        initView();
    }

    private void initView() {
        Context context = this.mContext;
        if (context == null) {
            C11839m.m70689w(TAG, "context is null");
            return;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        View viewInflate = C0219i.m1463a() >= 23 ? layoutInflaterFrom.inflate(R$layout.hisync_agr_permissions_agreement_dialog_oobe, (ViewGroup) null) : layoutInflaterFrom.inflate(R$layout.hisync_agr_permissions_agreement_dialog, (ViewGroup) null);
        PermissionListView permissionListView = (PermissionListView) C12809f.m76831d(viewInflate, R$id.permissions_list);
        permissionListView.setAdapter((ListAdapter) new PermissionsItemAdapter(this.mContext));
        permissionListView.setFocusable(false);
        String string = this.mContext.getString(R$string.cloud_service_terms_text);
        String string2 = this.mContext.getString(R$string.huaweicloud_overseas_agreement, string);
        SpanClickText spanClickText = (SpanClickText) C12809f.m76831d(viewInflate, R$id.overseas_confirm_text);
        spanClickText.m15931c(string, new C11427b(this.mContext, "user_agreement"));
        spanClickText.m15934g(string2, false);
        setTitle(this.mContext.getString(R$string.huaweicloud_user_agreement_title));
        setCancelable(false);
        setView(viewInflate);
        setButton(-2, this.mContext.getString(R$string.huaweicloud_overseas_disagree), this.mListener);
        setButton(-1, this.mContext.getString(R$string.user_permission_ok), this.mListener);
    }
}
