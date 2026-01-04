package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupConditionDialog;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p015ak.C0209d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupItemTipView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    public Context f19346a;

    /* renamed from: b */
    public ImageView f19347b;

    /* renamed from: c */
    public ImageView f19348c;

    /* renamed from: d */
    public ImageView f19349d;

    /* renamed from: e */
    public TextView f19350e;

    /* renamed from: f */
    public TextView f19351f;

    /* renamed from: g */
    public TextView f19352g;

    public BackupItemTipView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m25665a(Context context) {
        if (context == null) {
            return;
        }
        float fM1195O = C0209d.m1195O(context);
        if (fM1195O >= 1.75f && fM1195O < 3.2f) {
            View.inflate(context, R$layout.item_backup_tip_view_scale_1dot75, this);
        } else if (fM1195O >= 3.2f) {
            View.inflate(context, R$layout.item_backup_tip_view_scale_3dot2, this);
        } else {
            View.inflate(context, R$layout.item_backup_tip_view, this);
        }
        this.f19347b = (ImageView) C12809f.m76831d(this, R$id.iv_backup_cycle);
        this.f19348c = (ImageView) C12809f.m76831d(this, R$id.iv_backup_safe);
        this.f19349d = (ImageView) C12809f.m76831d(this, R$id.iv_backup_restore);
        this.f19350e = (TextView) C12809f.m76831d(this, R$id.tv_backup_cycle);
        this.f19351f = (TextView) C12809f.m76831d(this, R$id.tv_backup_safe);
        this.f19352g = (TextView) C12809f.m76831d(this, R$id.tv_backup_restore);
    }

    /* renamed from: b */
    public void m25666b(int i10, int i11, int i12) {
        this.f19347b.setImageResource(i10);
        this.f19348c.setImageResource(i11);
        this.f19349d.setImageResource(i12);
    }

    /* renamed from: c */
    public void m25667c(int i10, int i11, int i12) {
        this.f19350e.setText(i10);
        this.f19351f.setText(i11);
        this.f19352g.setText(i12);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (C0209d.m1226Y0()) {
            return;
        }
        if (id2 == R$id.rl_backup_cycle) {
            BackupConditionDialog backupConditionDialog = new BackupConditionDialog(this.f19346a);
            backupConditionDialog.setBackupCoditionTip(getResources().getString(R$string.backup_conditon_power));
            backupConditionDialog.show();
        } else if (id2 == R$id.rl_backup_safe) {
            BackupConditionDialog backupConditionDialog2 = new BackupConditionDialog(this.f19346a);
            backupConditionDialog2.setBackupCoditionTip(getResources().getString(R$string.backup_conditon_lock));
            backupConditionDialog2.show();
        } else if (id2 == R$id.rl_backup_restore) {
            BackupConditionDialog backupConditionDialog3 = new BackupConditionDialog(this.f19346a);
            backupConditionDialog3.setBackupCoditionTip(getResources().getString(C2783d.m16179s1(R$string.backup_conditon_wlan, R$string.backup_conditon_wifi)));
            backupConditionDialog3.show();
        }
    }

    public BackupItemTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackupItemTipView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m25665a(context);
        this.f19346a = context;
    }
}
