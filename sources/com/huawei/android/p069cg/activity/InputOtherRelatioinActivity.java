package com.huawei.android.p069cg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p031b7.C1120a;
import p031b7.C1130k;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes2.dex */
public class InputOtherRelatioinActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public NotchTopFitLinearLayout f10158p;

    /* renamed from: q */
    public EditText f10159q;

    /* renamed from: L1 */
    private void m13566L1() {
        this.f10158p = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        ((TextView) C12809f.m76829b(this, R$id.tv_confirm_type)).setOnClickListener(this);
        ((ImageView) C12809f.m76829b(this, R$id.iv_type_relation_back)).setOnClickListener(this);
        EditText editText = (EditText) C12809f.m76829b(this, R$id.et_input_name);
        this.f10159q = editText;
        editText.setFilters(new InputFilter[]{C1130k.m6918c(), C1130k.m6917b()});
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10158p);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 != R$id.tv_confirm_type) {
            if (id2 == R$id.iv_type_relation_back) {
                setResult(0);
                finish();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.f10159q.getText().toString())) {
            C1120a.m6675d("InputOtherRelatioinActivity", "input other relation is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("type_other_relation", this.f10159q.getText().toString());
        setResult(11001, intent);
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.layout_input_other_relation);
        m13566L1();
        mo19005p1();
        C11842p.m70889z0(this);
    }
}
