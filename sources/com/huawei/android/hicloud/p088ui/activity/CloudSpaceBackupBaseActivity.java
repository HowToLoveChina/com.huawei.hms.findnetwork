package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p015ak.C0209d;
import p684un.C13225d;
import p684un.C13230i;
import p783xp.C13843a;
import p814yl.C13998b0;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudSpaceBackupBaseActivity extends UIManagerActivity {

    /* renamed from: N0 */
    public C13998b0 f14455N0;

    /* renamed from: O0 */
    public AlertDialog f14456O0;

    /* renamed from: P0 */
    public boolean f14457P0;

    /* renamed from: Q0 */
    public boolean f14458Q0;

    /* renamed from: R0 */
    public boolean f14459R0;

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceBackupBaseActivity$a */
    public class DialogInterfaceOnClickListenerC3240a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3240a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AlertDialog alertDialog = CloudSpaceBackupBaseActivity.this.f14456O0;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }
    }

    /* renamed from: S2 */
    public String m20021S2(int i10, String str) {
        return i10 == 2 ? CloudBackupLanguageUtil.getVirtualName(str) : i10 == 0 ? C2783d.m16079E(this, str) : NewHiSyncUtil.m25632b(str);
    }

    /* renamed from: T2 */
    public void m20022T2() {
        if (this.f16192J0 != null) {
            if (C0209d.m1333z1(this)) {
                this.f16192J0.m23914a();
            } else {
                this.f16192J0.m23919i();
            }
        }
    }

    /* renamed from: U2 */
    public void m20023U2() {
        m20025W2(R$string.delete_backup_record_failed);
    }

    /* renamed from: V2 */
    public void m20024V2(boolean z10, boolean z11) {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.hicloud_new_backup_dialog, (ViewGroup) null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.new_backup_auto);
        ((TextView) C12809f.m76831d(viewInflate, R$id.backup_tip)).setVisibility(8);
        textView.setText(getString(R$string.manager_basic_system_data_detail, C2783d.m16079E(this, "setting"), C2783d.m16079E(this, "HWlanucher"), C2783d.m16079E(this, "thirdApp")));
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || (movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(viewInflate).setTitle(R$string.backup_option_sys_tip_title).setPositiveButton(R$string.cloud_space_dialog_know, new DialogInterfaceOnClickListenerC3240a());
        AlertDialog alertDialogCreate = builder.create();
        this.f14456O0 = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* renamed from: W2 */
    public void m20025W2(int i10) {
        Toast.makeText(this, getString(i10), 0).show();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        m22365E1(R$string.cloud_backup_item_title);
        mo19982C1();
        mo19005p1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
