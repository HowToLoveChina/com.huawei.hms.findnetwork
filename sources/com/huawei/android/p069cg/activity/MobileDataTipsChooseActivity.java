package com.huawei.android.p069cg.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0212e0;
import p031b7.C1122c;
import sk.C12809f;

/* loaded from: classes2.dex */
public class MobileDataTipsChooseActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public TextView f10209p;

    /* renamed from: q */
    public TextView f10210q;

    /* renamed from: r */
    public RadioButton f10211r;

    /* renamed from: s */
    public RadioButton f10212s;

    /* renamed from: t */
    public RadioButton f10213t;

    /* renamed from: u */
    public NotchTopFitRelativeLayout f10214u = null;

    /* renamed from: v */
    public NotchFitRelativeLayout f10215v = null;

    /* renamed from: L1 */
    private void m13607L1() {
        this.f10209p = (TextView) C12809f.m76829b(this, R$id.tips_more_than_ask_tv);
        this.f10210q = (TextView) C12809f.m76829b(this, R$id.tips_more_than_ask_desc_tv);
        String fileSize = Formatter.formatFileSize(this, C1122c.f5368v);
        this.f10209p.setText(getString(R$string.mobile_data_notify_more_than, fileSize));
        this.f10210q.setText(getString(R$string.mobile_data_notify_more_than_tips, fileSize));
        this.f10211r = (RadioButton) C12809f.m76829b(this, R$id.tips_always_ask_rb);
        this.f10212s = (RadioButton) C12809f.m76829b(this, R$id.tips_more_than_ask_rb);
        this.f10213t = (RadioButton) C12809f.m76829b(this, R$id.tips_never_ask_rb);
        this.f10211r.setOnClickListener(this);
        this.f10212s.setOnClickListener(this);
        this.f10213t.setOnClickListener(this);
        this.f10214u = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.top_notch_fit_layout);
        this.f10215v = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        int iM1357g = C0212e0.m1357g(this, "mobile_data_tips_sp", "current_tips_setting_type", 0);
        if (iM1357g == 1) {
            this.f10211r.setChecked(false);
            this.f10212s.setChecked(true);
            this.f10213t.setChecked(false);
        } else if (iM1357g != 2) {
            this.f10211r.setChecked(true);
            this.f10212s.setChecked(false);
            this.f10213t.setChecked(false);
        } else {
            this.f10211r.setChecked(false);
            this.f10212s.setChecked(false);
            this.f10213t.setChecked(true);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10215v);
        arrayList.add(this.f10214u);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: n1 */
    public void mo13327n1() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.mo13327n1();
        getActionBar().setTitle(R$string.mobile_data_notify_use_data);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.tips_always_ask_rb) {
            C0212e0.m1368r(this, "mobile_data_tips_sp", "current_tips_setting_type", 0);
            this.f10211r.setChecked(true);
            this.f10212s.setChecked(false);
            this.f10213t.setChecked(false);
            return;
        }
        if (id2 == R$id.tips_more_than_ask_rb) {
            C0212e0.m1368r(this, "mobile_data_tips_sp", "current_tips_setting_type", 1);
            this.f10211r.setChecked(false);
            this.f10212s.setChecked(true);
            this.f10213t.setChecked(false);
            return;
        }
        if (id2 == R$id.tips_never_ask_rb) {
            C0212e0.m1368r(this, "mobile_data_tips_sp", "current_tips_setting_type", 2);
            this.f10211r.setChecked(false);
            this.f10212s.setChecked(false);
            this.f10213t.setChecked(true);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.mobile_data_tips_choose_activity_view);
        m13607L1();
        mo13327n1();
        mo19005p1();
    }
}
