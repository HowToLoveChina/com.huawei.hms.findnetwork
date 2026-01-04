package com.huawei.android.hicloud.p088ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import p514o9.C11839m;
import sk.C12809f;

/* renamed from: com.huawei.android.hicloud.ui.fragment.d */
/* loaded from: classes3.dex */
public class C3983d extends Fragment {

    /* renamed from: c0 */
    public final String f18320c0 = "titleId";

    /* renamed from: d0 */
    public final String f18321d0 = "contentId";

    /* renamed from: e0 */
    public final String f18322e0 = "imageId";

    /* renamed from: f0 */
    public View f18323f0;

    /* renamed from: g0 */
    public View f18324g0;

    /* renamed from: h0 */
    public HwTextView f18325h0;

    /* renamed from: i0 */
    public HwTextView f18326i0;

    /* renamed from: j0 */
    public ImageView f18327j0;

    /* renamed from: k0 */
    public int f18328k0;

    /* renamed from: l0 */
    public int f18329l0;

    /* renamed from: m0 */
    public int f18330m0;

    public C3983d(int i10, int i11, int i12) {
        this.f18328k0 = i10;
        this.f18329l0 = i11;
        this.f18330m0 = i12;
        C11839m.m70688i("NewBusinessIntroBaseFragment", "NewBusinessIntroBaseFragment(int titleId, int sunTitleId, int imageId)");
    }

    /* renamed from: C1 */
    public int m24367C1() {
        return this.f18329l0;
    }

    /* renamed from: D1 */
    public int m24368D1() {
        return this.f18328k0;
    }

    /* renamed from: E1 */
    public void m24369E1() {
        View view = this.f18323f0;
        if (view == null) {
            C11839m.m70687e("NewBusinessIntroBaseFragment", "initView err, mView is null");
            return;
        }
        this.f18327j0 = (ImageView) C12809f.m76831d(view, R$id.image_background_phone_view);
        this.f18325h0 = (HwTextView) C12809f.m76831d(this.f18323f0, R$id.main_title_text);
        this.f18326i0 = (HwTextView) C12809f.m76831d(this.f18323f0, R$id.sub_title_text);
        this.f18324g0 = C12809f.m76831d(this.f18323f0, R$id.pager_content_region);
        m24371G1();
    }

    /* renamed from: F1 */
    public final void m24370F1(Bundle bundle) {
        if (bundle != null) {
            this.f18328k0 = bundle.getInt("titleId");
            this.f18329l0 = bundle.getInt("contentId");
            this.f18330m0 = bundle.getInt("imageId");
        }
    }

    /* renamed from: G1 */
    public void m24371G1() {
        C12809f.m76840m(this.f18325h0, this.f18328k0);
        C12809f.m76840m(this.f18326i0, this.f18329l0);
        this.f18327j0.setImageResource(this.f18330m0);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: H0 */
    public void mo4350H0(Bundle bundle) {
        super.mo4350H0(bundle);
        C11839m.m70687e("NewBusinessIntroBaseFragment", "onSaveInstanceState");
        bundle.putInt("titleId", this.f18328k0);
        bundle.putInt("contentId", this.f18329l0);
        bundle.putInt("imageId", this.f18330m0);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: L0 */
    public void mo4357L0(Bundle bundle) {
        C11839m.m70687e("NewBusinessIntroBaseFragment", "onViewStateRestored");
        super.mo4357L0(bundle);
        m24370F1(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: l0 */
    public void mo4415l0(Bundle bundle) {
        super.mo4415l0(bundle);
        C11839m.m70688i("NewBusinessIntroBaseFragment", "onCreate");
        if (bundle != null) {
            m24370F1(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: p0 */
    public View mo4427p0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C11839m.m70688i("NewBusinessIntroBaseFragment", "onCreateView");
        if (m4426p() == null) {
            C11839m.m70687e("NewBusinessIntroBaseFragment", "context is null");
            return null;
        }
        this.f18323f0 = layoutInflater.inflate(R$layout.new_business_intro_pager_view, viewGroup, false);
        m24369E1();
        return this.f18323f0;
    }

    public C3983d() {
        C11839m.m70688i("NewBusinessIntroBaseFragment", "NewBusinessIntroBaseFragment()");
    }
}
