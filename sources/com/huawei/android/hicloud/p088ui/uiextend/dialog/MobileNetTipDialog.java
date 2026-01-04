package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p514o9.C11829c;
import p514o9.C11840n;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class MobileNetTipDialog extends AlertDialogC13154a {
    private String appId;
    Context context;
    private boolean isBackup;
    private boolean isOOBE;

    public interface MobileNetTipClickListener extends DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        void onClick(DialogInterface dialogInterface, int i10);
    }

    public MobileNetTipDialog(Context context, MobileNetTipClickListener mobileNetTipClickListener, boolean z10) {
        super(context);
        this.isOOBE = false;
        this.context = context;
        this.isBackup = z10;
        setTitle(R$string.mobile_net_title);
        setButton(-2, context.getString(R$string.cloudbackup_btn_cancel), mobileNetTipClickListener);
        setButton(-1, context.getString(R$string.using_mobile_network), mobileNetTipClickListener);
        initView();
    }

    private void initView() {
        View viewInflate = LayoutInflater.from(this.context).inflate(R$layout.dialog_mobile_tip, (ViewGroup) null);
        setView(viewInflate);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.tv_network);
        if (this.isBackup) {
            textView.setText(C2783d.m16179s1(R$string.backup_mobile_network_content_wlan, R$string.backup_mobile_network_content_wifi));
        } else {
            textView.setText(C2783d.m16179s1(R$string.restore_net_content_wlan, R$string.restore_net_content_wifi));
        }
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setIsOOBE(boolean z10) {
        this.isOOBE = z10;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.isOOBE) {
            C11829c.m70585i1(getWindow());
            C11840n.m70694e(this);
        }
        super.show();
    }
}
