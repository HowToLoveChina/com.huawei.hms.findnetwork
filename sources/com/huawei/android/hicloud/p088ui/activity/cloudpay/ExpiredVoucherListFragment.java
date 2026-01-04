package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.VouchersManagerAdapter;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.GetAllVouchersResp;
import com.huawei.cloud.pay.model.GsonVoucher;
import com.huawei.cloud.pay.model.QueryPickedWelfaresResp;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.model.VouchersTaskInfo;
import dj.C9158a;
import java.util.Collections;
import java.util.List;
import p054cj.C1442a;
import p454lj.C11296s;
import p514o9.C11842p;
import p618rm.C12540b1;

/* loaded from: classes3.dex */
public class ExpiredVoucherListFragment extends VoucherListFragment {
    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: H */
    public void mo23521H(List<Voucher> list) {
        list.sort(Collections.reverseOrder());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: b */
    public void mo23522b(GetAllVouchersResp getAllVouchersResp) {
        C1442a.m8290i("ExpiredVoucherListFragment", "dealGetAllVouchersSuccess");
        m23875i().addAll(((GsonVoucher) C12540b1.m75483a("{\"usefulVouchers\":" + getAllVouchersResp.getUnusefulVouchers() + "}", GsonVoucher.class)).getUsefulVouchers());
        this.f17488u = getAllVouchersResp.getPageToken();
        m23863B(true);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: e */
    public void mo23523e(QueryPickedWelfaresResp queryPickedWelfaresResp) {
        C1442a.m8290i("ExpiredVoucherListFragment", "dealQueryPickedWelfaresSuccess");
        if (queryPickedWelfaresResp.getUnusefulWelfares() != null) {
            m23877k().addAll(queryPickedWelfaresResp.getUnusefulWelfares());
        } else {
            C1442a.m8288d("ExpiredVoucherListFragment", "dealQueryPickedWelfaresSuccess unusefulWelfares is null");
        }
        m23864C(true);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: h */
    public void mo23524h() {
        if (C11296s.m67786J(getContext())) {
            C9158a.m57503F().m57520R(this.f17482o, new VouchersTaskInfo("0|1|2", m23879m("2"), "50", this.f17488u), m23873f());
            return;
        }
        this.f17471d.completeRefresh();
        if (this.f17481n != null) {
            this.f17471d.setNoNetWorkType();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: q */
    public void mo23525q() {
        VouchersManagerAdapter vouchersManagerAdapter = new VouchersManagerAdapter(getActivity());
        this.f17481n = vouchersManagerAdapter;
        vouchersManagerAdapter.m25444o(C11842p.m70829k0(getActivity()));
        this.f17481n.m25450v(this);
        this.f17481n.m25447s(2);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: s */
    public void mo23526s() {
        super.mo23526s();
        this.f17475h.setVisibility(8);
        C11842p.m70815g2(this.f17470c, 0.0f);
        this.f17477j.setText(R$string.voucher_expire_no_data);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: v */
    public void mo23527v() {
        if (this.f17487t) {
            return;
        }
        this.f17487t = true;
        this.f17481n.notifyDataSetChanged();
        m23865D();
        C9158a.m57503F().m57520R(this.f17482o, new VouchersTaskInfo("0|1|2", "0010", "50", ""), m23873f());
    }
}
