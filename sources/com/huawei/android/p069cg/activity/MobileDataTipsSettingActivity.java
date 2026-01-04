package com.huawei.android.p069cg.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.LinearLayout;
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
public class MobileDataTipsSettingActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public LinearLayout f10216p;

    /* renamed from: q */
    public TextView f10217q;

    /* renamed from: r */
    public NotchTopFitRelativeLayout f10218r = null;

    /* renamed from: s */
    public NotchFitRelativeLayout f10219s = null;

    /* renamed from: L1 */
    private void m13608L1() {
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.setting_choosen_ll);
        this.f10216p = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f10217q = (TextView) C12809f.m76829b(this, R$id.setting_choosen);
        m13609M1();
        this.f10218r = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.top_notch_fit_layout);
        this.f10219s = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
    }

    /* renamed from: M1 */
    public final void m13609M1() {
        int iM1357g = C0212e0.m1357g(this, "mobile_data_tips_sp", "current_tips_setting_type", 0);
        if (iM1357g == 1) {
            this.f10217q.setText(getString(R$string.mobile_data_notify_more_than, Formatter.formatFileSize(this, C1122c.f5368v)));
        } else if (iM1357g != 2) {
            this.f10217q.setText(getString(R$string.mobile_data_notify_always_notify));
        } else {
            this.f10217q.setText(getString(R$string.mobile_data_notify_always_allow));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10219s);
        arrayList.add(this.f10218r);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: n1 */
    public void mo13327n1() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.mo13327n1();
        getActionBar().setTitle(R$string.setting_general_title);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && view.getId() == R$id.setting_choosen_ll) {
            startActivity(new Intent(this, (Class<?>) MobileDataTipsChooseActivity.class));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.mobile_data_tips_setting_activity_view);
        m13608L1();
        mo13327n1();
        mo19005p1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m13609M1();
    }
}
