package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13227f;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PersonalizationActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public NotchTopFitRelativeLayout f15776p;

    /* renamed from: q */
    public NotchFitRelativeLayout f15777q;

    /* renamed from: r */
    public RelativeLayout f15778r;

    /* renamed from: L1 */
    private void m21941L1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f15776p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.notch_top_fit_frame);
        this.f15777q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_frame);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.personalization_item);
        this.f15778r = relativeLayout;
        if (this.f15776p == null || this.f15777q == null || relativeLayout == null) {
            C11839m.m70687e("PersonalizationActivity", "initView error");
            return;
        }
        relativeLayout.setOnClickListener(this);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
        }
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(getColor(R$color.hicloud_hmos_bg));
        }
        C11829c.m70609q1(this, getWindow());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15776p);
        arrayList.add(this.f15777q);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (C0209d.m1226Y0()) {
            C11839m.m70687e("PersonalizationActivity", "fast click");
            return;
        }
        if (view.getId() == R$id.personalization_item) {
            C13227f.m79492i1().m79585f0("mecloud_setting_click_personalization_ad", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_personalization_ad", "1", "4");
            try {
                startActivity(new Intent(this, (Class<?>) PersonalizationDetailActivity.class));
            } catch (Exception e10) {
                C11839m.m70687e("PersonalizationActivity", "start personalization detail exception: " + e10.toString());
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("PersonalizationActivity", "onCreate");
        super.onCreate(bundle);
        setContentView(R$layout.personalization_activity);
        m21941L1();
        mo19005p1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11839m.m70688i("PersonalizationActivity", "onDestroy");
        super.onDestroy();
    }
}
