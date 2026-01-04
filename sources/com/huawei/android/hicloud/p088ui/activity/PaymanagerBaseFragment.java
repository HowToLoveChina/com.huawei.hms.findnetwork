package com.huawei.android.hicloud.p088ui.activity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0219i;
import p514o9.C11829c;
import p514o9.C11842p;
import sk.C12806c;

@SuppressLint({"ValidFragment"})
/* loaded from: classes3.dex */
public class PaymanagerBaseFragment extends Fragment {

    /* renamed from: a */
    public List<View> f15774a = new ArrayList();

    /* renamed from: b */
    public Context f15775b;

    public PaymanagerBaseFragment() {
    }

    /* renamed from: a */
    public List<View> mo21938a() {
        return null;
    }

    /* renamed from: b */
    public void m21939b() {
        List<View> listMo21938a = mo21938a();
        List<List<View>> listM70887y2 = C11842p.m70887y2(listMo21938a);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this.f15775b)) {
            C12806c.m76821l(this.f15775b, listMo21938a);
            C12806c.m76820k(this.f15775b, listM70887y2.get(1));
        }
        m21940c(listM70887y2.get(0));
        C12806c.m76820k(this.f15775b, listM70887y2.get(0));
    }

    /* renamed from: c */
    public void m21940c(List<View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f15774a.addAll(list);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C12806c.m76820k(this.f15775b, this.f15774a);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public PaymanagerBaseFragment(Context context) {
        this.f15775b = context;
    }
}
