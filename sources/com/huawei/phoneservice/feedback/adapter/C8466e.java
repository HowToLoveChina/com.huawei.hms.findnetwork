package com.huawei.phoneservice.feedback.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedback.adapter.e */
/* loaded from: classes5.dex */
public class C8466e extends BaseAdapter {

    /* renamed from: a */
    public List<CharSequence> f39515a;

    /* renamed from: b */
    public final int f39516b;

    /* renamed from: com.huawei.phoneservice.feedback.adapter.e$a */
    public static class a {

        /* renamed from: a */
        public TextView f39517a;

        /* renamed from: b */
        public RadioButton f39518b;

        /* renamed from: c */
        public View f39519c;
    }

    public C8466e(CharSequence[] charSequenceArr, int i10) {
        this.f39515a = new ArrayList();
        if (charSequenceArr != null) {
            this.f39515a = Arrays.asList(charSequenceArr);
        }
        this.f39516b = i10;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CharSequence getItem(int i10) {
        return this.f39515a.get(i10);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f39515a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        if (view == null) {
            aVar = new a();
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.feedback_sdk_item_list_dialog, viewGroup, false);
            aVar.f39517a = (TextView) viewInflate.findViewById(R$id.list_dialog_item_content);
            aVar.f39518b = (RadioButton) viewInflate.findViewById(R$id.list_dialog_item_radio);
            aVar.f39519c = viewInflate.findViewById(R$id.list_dialog_item_line);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        aVar.f39517a.setText(getItem(i10));
        aVar.f39518b.setChecked(i10 == this.f39516b);
        aVar.f39519c.setVisibility(i10 == getCount() - 1 ? 8 : 0);
        return viewInflate;
    }
}
