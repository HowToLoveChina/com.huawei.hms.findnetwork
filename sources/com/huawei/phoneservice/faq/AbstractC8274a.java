package com.huawei.phoneservice.faq;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.huawei.phoneservice.faq.base.util.FaqSdk;

/* renamed from: com.huawei.phoneservice.faq.a */
/* loaded from: classes4.dex */
public abstract class AbstractC8274a extends Fragment {

    /* renamed from: c0 */
    public View f38542c0;

    /* renamed from: d0 */
    public Activity f38543d0;

    /* renamed from: C1 */
    public abstract int mo51685C1();

    /* renamed from: D1 */
    public abstract void mo51686D1(View view);

    /* renamed from: E1 */
    public Activity m51687E1() {
        FragmentActivity fragmentActivityM4400f = m4400f();
        return fragmentActivityM4400f == null ? this.f38543d0 : fragmentActivityM4400f;
    }

    /* renamed from: F1 */
    public abstract void mo51688F1();

    /* renamed from: G1 */
    public abstract void mo51689G1();

    @Override // androidx.fragment.app.Fragment
    /* renamed from: h0 */
    public void mo4405h0(Activity activity) {
        super.mo4405h0(activity);
        this.f38543d0 = activity;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: p0 */
    public View mo4427p0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2;
        View viewInflate = layoutInflater.inflate(mo51685C1(), viewGroup, false);
        this.f38542c0 = viewInflate;
        mo51686D1(viewInflate);
        mo51689G1();
        mo51688F1();
        View view = this.f38542c0;
        if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
            viewGroup2.removeView(this.f38542c0);
        }
        return this.f38542c0;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: q0 */
    public void mo4430q0() {
        FaqSdk.getISdk().canceledSubmit(m51687E1());
        super.mo4430q0();
    }
}
