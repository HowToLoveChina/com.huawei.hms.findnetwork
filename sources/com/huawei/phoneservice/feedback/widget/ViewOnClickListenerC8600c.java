package com.huawei.phoneservice.feedback.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;

/* renamed from: com.huawei.phoneservice.feedback.widget.c */
/* loaded from: classes5.dex */
public class ViewOnClickListenerC8600c extends RecyclerView.AbstractC0833c0 implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: u */
    public final SparseArray<View> f40025u;

    public ViewOnClickListenerC8600c(View view) {
        super(view);
        this.f40025u = new SparseArray<>();
    }

    /* renamed from: P */
    public <T extends View> T m53167P(int i10) {
        T t10 = (T) this.f40025u.get(i10);
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) this.f4327a.findViewById(i10);
        this.f40025u.put(i10, t11);
        return t11;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NoDoubleClickUtil.isDoubleClick(view);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }
}
