package com.huawei.openalliance.p169ad.download.app;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.p169ad.views.viewpager.AbstractC8161f;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.download.app.o */
/* loaded from: classes2.dex */
public class C7058o extends AbstractC8161f {

    /* renamed from: a */
    List<View> f32504a;

    public C7058o(List<View> list) {
        this.f32504a = list;
    }

    @Override // com.huawei.openalliance.p169ad.views.viewpager.AbstractC8161f
    /* renamed from: a */
    public int mo42547a() {
        List<View> list = this.f32504a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.huawei.openalliance.p169ad.views.viewpager.AbstractC8161f
    /* renamed from: a */
    public Object mo42548a(ViewGroup viewGroup, int i10) {
        List<View> list = this.f32504a;
        if (list == null) {
            return null;
        }
        viewGroup.addView(list.get(i10));
        return this.f32504a.get(i10);
    }

    @Override // com.huawei.openalliance.p169ad.views.viewpager.AbstractC8161f
    /* renamed from: a */
    public void mo42549a(ViewGroup viewGroup, int i10, Object obj) {
        List<View> list = this.f32504a;
        if (list != null) {
            viewGroup.removeView(list.get(i10));
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.viewpager.AbstractC8161f
    /* renamed from: a */
    public boolean mo42550a(View view, Object obj) {
        return view == obj;
    }
}
