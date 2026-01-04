package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import com.huawei.android.p073ds.R$string;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class PackageExpExpiredFragment extends PackageExperienceFragment {
    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.PackageExperienceFragment
    /* renamed from: L */
    public int mo23630L() {
        return 3;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.PackageExperienceFragment
    /* renamed from: M */
    public int mo23631M() {
        return 2;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.PackageExperienceFragment, com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: s */
    public void mo23526s() {
        super.mo23526s();
        this.f17475h.setVisibility(8);
        C11842p.m70815g2(this.f17470c, 0.0f);
        this.f17477j.setText(R$string.voucher_expire_no_data);
    }
}
