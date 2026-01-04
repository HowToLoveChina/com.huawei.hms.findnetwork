package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.os.Bundle;
import android.view.View;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.p098ui.activity.BasePayActivity;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import p684un.C13227f;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OrderListActivity extends BasePayActivity {

    /* renamed from: C */
    public NotchTopFitLinearLayout f17183C;

    /* renamed from: O1 */
    private void m23608O1() {
        this.f17183C = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        m28587n1();
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f17183C);
        return arrayList;
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, JSONException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.pay_order_list_activity);
        m23608O1();
        C13227f.m79492i1().m79598v0(this, new SafeIntent(getIntent()), "OrderListActivity");
    }
}
