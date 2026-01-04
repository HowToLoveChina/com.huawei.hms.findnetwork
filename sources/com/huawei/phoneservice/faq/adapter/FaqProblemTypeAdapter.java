package com.huawei.phoneservice.faq.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.C1554j;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.huawei.phoneservice.faq.R$drawable;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.RequestOptionsInvoker;
import com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter;
import com.huawei.phoneservice.faq.response.FaqClassification;
import java.lang.reflect.InvocationTargetException;
import p507o2.InterfaceC11792e;
import p542p2.InterfaceC12082i;
import p759x1.EnumC13676a;
import p829z1.C14078q;

/* loaded from: classes4.dex */
public class FaqProblemTypeAdapter extends SimpleBaseAdapter<FaqClassification.Classification> {

    /* renamed from: a */
    public Context f38563a;

    /* renamed from: b */
    public int f38564b;

    /* renamed from: com.huawei.phoneservice.faq.adapter.FaqProblemTypeAdapter$b */
    public static class C8281b implements InterfaceC11792e<Drawable> {
        public C8281b() {
        }

        @Override // p507o2.InterfaceC11792e
        /* renamed from: a */
        public boolean mo51694a(C14078q c14078q, Object obj, InterfaceC12082i<Drawable> interfaceC12082i, boolean z10) throws Throwable {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GlideException: ");
            sb2.append(c14078q == null ? "" : c14078q.getMessage());
            sb2.append(" model: ");
            sb2.append(obj.toString());
            FaqLogger.m51840e("FaqProblemTypeAdapter", sb2.toString());
            return false;
        }

        @Override // p507o2.InterfaceC11792e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean mo51695b(Drawable drawable, Object obj, InterfaceC12082i<Drawable> interfaceC12082i, EnumC13676a enumC13676a, boolean z10) {
            return false;
        }
    }

    public FaqProblemTypeAdapter(Context context) {
        this.f38564b = 0;
        this.f38563a = context;
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter, android.widget.Adapter
    public int getCount() {
        int i10 = this.f38564b;
        int size = this.arrayList.size();
        return i10 == 0 ? Math.min(size, 12) : size;
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Throwable {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.faq_sdk_adapter_faq_problem_type_item, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R$id.faq_prombletype_Iv);
        TextView textView = (TextView) view.findViewById(R$id.faq_prombletype_tv);
        FaqClassification.Classification classification = (FaqClassification.Classification) getItem(i10);
        if (classification != null) {
            C1554j<Drawable> c1554jM8954a = ComponentCallbacks2C1546b.m8904t(this.f38563a).m8977k().m8971t(classification.m51923f()).m8954a(new C8281b());
            try {
                int i11 = R$drawable.faq_sdk_ic_no_pic_disable_small;
                RequestOptionsInvoker.invoke(c1554jM8954a, i11, i11);
                c1554jM8954a.m8965n(imageView);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
                FaqLogger.m51840e("FaqProblemTypeAdapter", e10.getMessage());
            }
            textView.setText(classification.m51922e());
        }
        view.setTag(classification);
        return view;
    }

    public FaqProblemTypeAdapter(Context context, int i10) {
        this.f38563a = context;
        this.f38564b = i10;
    }
}
