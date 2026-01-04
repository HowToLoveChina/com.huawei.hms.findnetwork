package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$menu;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p514o9.C11829c;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudBackupClearSuccessActivity extends CloudBackupBaseUiActivity implements View.OnClickListener {

    /* renamed from: C */
    public NotchFitLinearLayout f13904C;

    /* renamed from: D */
    public TextView f13905D;

    /* renamed from: E */
    public TextView f13906E;

    /* renamed from: F */
    public AlertDialog f13907F;

    /* renamed from: Z1 */
    private void m19253Z1() throws Resources.NotFoundException {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        int intExtra = safeIntent.getIntExtra("source", 0);
        int intExtra2 = safeIntent.getIntExtra("delete_notify_info_number", 0);
        String strM1524g = C0223k.m1524g(this, safeIntent.getLongExtra("delete_notify_info_size", 0L));
        if (intExtra == 0) {
            m22365E1(R$string.app_thin);
            this.f13905D.setText(m19254V1(getResources().getQuantityString(R$plurals.app_thin_success_count, intExtra2, Integer.valueOf(intExtra2)), intExtra2 + ""));
        } else if (intExtra == 1) {
            m22365E1(R$string.cloudbackup_clean_olddevices);
            this.f13905D.setText(m19254V1(getResources().getQuantityString(R$plurals.cloudbackup_delete_success_des, intExtra2, Integer.valueOf(intExtra2)), intExtra2 + ""));
        } else if (intExtra == 2) {
            SpannableStringBuilder spannableStringBuilderM19254V1 = m19254V1(getResources().getQuantityString(R$plurals.backup_record_delete_complete_msg, intExtra2, Integer.valueOf(intExtra2)), intExtra2 + "");
            m22365E1(R$string.backup_clean_records);
            this.f13905D.setText(spannableStringBuilderM19254V1);
        }
        String strM1232a0 = C0209d.m1232a0(strM1524g);
        this.f13906E.setText(m19254V1(getString(R$string.clear_space_success_size, strM1232a0), strM1232a0));
    }

    /* renamed from: V1 */
    public final SpannableStringBuilder m19254V1(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int length = str2.length();
        int iIndexOf = str.indexOf(str2);
        int i10 = length + iIndexOf;
        C11839m.m70686d("CloudBackupClearSuccessActivity", "content =" + str + " handleContent =" + str2);
        if (iIndexOf >= 0 && str.length() > i10) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getColor(R$color.cloud_color_blue)), iIndexOf, i10, 33);
        }
        return spannableStringBuilder;
    }

    /* renamed from: W1 */
    public void m19255W1() {
        LayoutInflater.from(this).inflate(R$layout.activity_clear_success, (ViewGroup) this.f13894y, true);
        this.f13904C = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.ll_content);
        this.f13905D = (TextView) C12809f.m76829b(this, R$id.tv_clear_success_tip_one);
        this.f13906E = (TextView) C12809f.m76829b(this, R$id.tv_clear_success_tip_two);
        ((AutoSizeButton) C12809f.m76829b(this, R$id.bt_complete)).setOnClickListener(this);
        mo19236O1();
        mo19005p1();
    }

    /* renamed from: X1 */
    public final /* synthetic */ void m19256X1(View view) throws IllegalAccessException, IllegalArgumentException {
        m19257a2();
    }

    /* renamed from: a2 */
    public final void m19257a2() throws IllegalAccessException, IllegalArgumentException {
        String string = getString(R$string.clear_success_tip);
        AlertDialog alertDialog = this.f13907F;
        if (alertDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(string).setNeutralButton(getString(R$string.cloudbackup_btn_ok_new), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.a2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    dialogInterface.dismiss();
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            this.f13907F = alertDialogCreate;
            C11829c.m70594l1(this, alertDialogCreate);
        } else {
            alertDialog.setMessage(string);
        }
        this.f13907F.show();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13894y);
        arrayList.add(this.f13904C);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.bt_complete) {
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m19255W1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R$menu.tip_help, menu);
        MenuItem menuItemFindItem = menu.findItem(R$id.help);
        menuItemFindItem.setActionView(R$layout.action_item);
        ((ImageView) C12809f.m76831d(menuItemFindItem.getActionView(), R$id.action_item_image)).setImageResource(R$drawable.ic_sucess_clear_tip);
        menuItemFindItem.getActionView().setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException {
                this.f17831a.m19256X1(view);
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        m19253Z1();
    }
}
