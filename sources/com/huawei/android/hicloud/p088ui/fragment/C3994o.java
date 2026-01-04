package com.huawei.android.hicloud.p088ui.fragment;

import android.widget.ImageView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.ui.fragment.o */
/* loaded from: classes3.dex */
public class C3994o extends AbstractC3992m {
    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: F1 */
    public void mo24376F1() {
        super.mo24376F1();
        if (this.f18342c0 == null) {
            C11839m.m70687e("UpgradeIntroNewInterfaceFragment", "initView err, mView is null");
            return;
        }
        ImageView imageView = this.f18345f0;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f18345f0.setImageResource(R$drawable.upgrade_intro_first_page);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: K1 */
    public void mo24380K1() {
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m
    /* renamed from: O1 */
    public void mo24384O1() {
        super.mo24384O1();
        this.f18343d0.setText(R$string.intro_main_title);
        this.f18344e0.setText(R$string.intro_main_sub_title);
    }
}
