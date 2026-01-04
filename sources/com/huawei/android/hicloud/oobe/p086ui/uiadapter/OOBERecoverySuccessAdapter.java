package com.huawei.android.hicloud.oobe.p086ui.uiadapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import java.util.ArrayList;
import p015ak.C0219i;
import p422k9.C11019b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OOBERecoverySuccessAdapter extends BaseAdapter {

    /* renamed from: a */
    public LayoutInflater f12660a;

    /* renamed from: b */
    public Context f12661b;

    /* renamed from: c */
    public ArrayList<String> f12662c = new ArrayList<>();

    /* renamed from: com.huawei.android.hicloud.oobe.ui.uiadapter.OOBERecoverySuccessAdapter$a */
    public static class C2863a {

        /* renamed from: a */
        public TextView f12663a = null;
    }

    public OOBERecoverySuccessAdapter(Context context) {
        this.f12661b = null;
        this.f12661b = context;
        this.f12660a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public void m17029a(ArrayList<String> arrayList) {
        this.f12662c.addAll(arrayList);
    }

    /* renamed from: b */
    public void m17030b(String str) {
        this.f12662c.add(str);
    }

    /* renamed from: c */
    public void m17031c() {
        this.f12662c.clear();
    }

    /* renamed from: d */
    public ArrayList<String> m17032d() {
        return this.f12662c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f12662c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f12662c.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewM76832e;
        C2863a c2863a;
        if (view == null) {
            c2863a = new C2863a();
            viewM76832e = C0219i.m1463a() < 21 ? C12809f.m76832e(this.f12660a, R$layout.recovery_success_list_item_emui9) : C12809f.m76832e(this.f12660a, R$layout.recovery_success_list_item);
            c2863a.f12663a = (TextView) C12809f.m76831d(viewM76832e, R$id.recovery_success_list_item_name);
            viewM76832e.setTag(c2863a);
        } else {
            viewM76832e = view;
            c2863a = (C2863a) view.getTag();
        }
        String strM66450w = C11019b.m66371t().m66450w(this.f12661b, this.f12662c.get(i10));
        if (!TextUtils.isEmpty(strM66450w)) {
            c2863a.f12663a.setText(strM66450w);
        }
        return viewM76832e;
    }
}
