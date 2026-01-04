package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p015ak.C0219i;
import p472m7.C11427b;
import p514o9.C11829c;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TermsOfPrivacyNoticeDialog extends AlertDialogC13154a {
    private static final String TAG = "TermsOfPrivacyNoticeDialog";
    private Context mContext;
    private DialogInterface.OnClickListener mListener;

    public TermsOfPrivacyNoticeDialog(Context context, DialogInterface.OnClickListener onClickListener) {
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
        View viewInflate = C0219i.m1463a() >= 23 ? layoutInflaterFrom.inflate(R$layout.hisync_agr_privacy_notice_dialog_oobe, (ViewGroup) null) : layoutInflaterFrom.inflate(R$layout.hisync_agr_privacy_notice_dialog, (ViewGroup) null);
        boolean zM70620u0 = C11829c.m70620u0(this.mContext);
        String string = this.mContext.getString(R$string.huaweicloud_notice_here);
        String string2 = this.mContext.getString(zM70620u0 ? R$string.huaweicloud_notice_confirm : R$string.huaweicloud_notice_sg_confirm, string);
        SpanClickText spanClickText = (SpanClickText) C12809f.m76831d(viewInflate, R$id.more_info);
        spanClickText.m15931c(string, new C11427b(this.mContext, "privacy_statement"));
        spanClickText.m15934g(string2, false);
        if (!zM70620u0) {
            ((TextView) C12809f.m76831d(viewInflate, R$id.purpose)).setText(this.mContext.getString(R$string.huaweicloud_data_sg_controller));
        }
        setTitle(this.mContext.getString(R$string.huaweicloud_privacy_notice_title));
        setCancelable(false);
        setView(viewInflate);
        setButton(-2, this.mContext.getString(R$string.cloudbackup_Cancel), this.mListener);
        setButton(-1, this.mContext.getString(R$string.next_step), this.mListener);
    }
}
