package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import com.huawei.android.hicloud.p088ui.uiadapter.PackageExpManagerAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.OnRefreshListener;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.reward.GetRewardsResp;
import com.huawei.cloud.pay.model.reward.Reward;
import com.huawei.cloud.pay.p098ui.activity.BasePayActivity;
import java.util.List;
import java.util.Objects;
import p015ak.C0209d;
import p015ak.C0226l0;
import p054cj.C1442a;
import p341hj.C10235i0;
import p454lj.C11296s;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class PackageExperienceFragment extends VoucherListFragment {

    /* renamed from: C */
    public int f17205C = 0;

    /* renamed from: D */
    public PackageExpManagerAdapter f17206D;

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.PackageExperienceFragment$a */
    public class C3639a implements OnRefreshListener {
        public C3639a() {
        }

        /* renamed from: b */
        public final /* synthetic */ void m23640b() {
            PackageExperienceFragment.this.mo23524h();
        }

        @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.OnRefreshListener
        public void onLoadingMore() {
            C0226l0.m1585e(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.k0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17554a.m23640b();
                }
            }, 1500L);
        }

        @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.OnRefreshListener
        public void onPullRefresh() {
        }
    }

    /* renamed from: L */
    public int mo23630L() {
        return 1;
    }

    /* renamed from: M */
    public int mo23631M() {
        return 0;
    }

    /* renamed from: N */
    public final void m23634N() {
        getActivity().startActivity(new Intent(getActivity(), (Class<?>) ExpiredPkgExpActivity.class));
    }

    /* renamed from: O */
    public final /* synthetic */ void m23635O(View view) {
        if (this.f17481n != null) {
            this.f17471d.setServerFailType(false);
        }
        mo23527v();
    }

    /* renamed from: P */
    public final void m23636P(GetRewardsResp getRewardsResp) {
        this.f17487t = false;
        if (Objects.isNull(getRewardsResp)) {
            m23868G();
            C1442a.m8289e("PackageExperienceFragment", "onQueryRewardsSuccess:no data");
            return;
        }
        List<Reward> rewards = getRewardsResp.getRewards();
        C1442a.m8290i("PackageExperienceFragment", "onQueryRewardsSuccess,reward size:" + rewards.size());
        if (C0209d.m1205R0(rewards)) {
            m23868G();
        } else {
            PackageExpManagerAdapter packageExpManagerAdapter = this.f17206D;
            if (packageExpManagerAdapter != null) {
                packageExpManagerAdapter.m25058a(rewards);
                this.f17206D.notifyDataSetChanged();
            }
            m23866E();
            this.f17471d.completeRefresh();
        }
        this.f17471d.setHasMoreData(!TextUtils.isEmpty(getRewardsResp.getCursor()));
    }

    /* renamed from: Q */
    public final void m23637Q(View view) {
        Reward item = this.f17206D.getItem(((Integer) view.getTag()).intValue());
        C1442a.m8290i("PackageExperienceFragment", "processPkgExp:" + item.getId());
        Intent intent = new Intent(getActivity(), (Class<?>) ExchangeCloudCardActivity.class);
        intent.putExtra("reward_id", item.getId());
        intent.putExtra("product_id", item.getProductId());
        intent.putExtra("reward_duration_month", item.getDuration());
        intent.putExtra("reward_duration_unit", item.getDurationUnit());
        intent.putExtra("rewad_support_sub", item.getSupportSub());
        intent.putExtra("rewad_package_capacity", item.getCapacity());
        intent.putExtra("reward_pomid", item.getPromId());
        getActivity().startActivity(intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: h */
    public void mo23524h() {
        if (C0209d.m1333z1(getContext())) {
            int i10 = this.f17205C + 1;
            this.f17205C = i10;
            new C10235i0(String.valueOf(i10), 50, Integer.valueOf(mo23630L()), new C3679i0(this)).m63381g();
        } else {
            this.f17471d.completeRefresh();
            if (this.f17206D != null) {
                this.f17471d.setNoNetWorkType();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            C1442a.m8289e("PackageExperienceFragment", "onClick view is null");
            return;
        }
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (R$id.layout_nonetwork == id2 || R$id.layout_nodata == id2) {
            if (C11296s.m67786J(getContext())) {
                mo23527v();
                return;
            }
            return;
        }
        if (R$id.bt_use == id2) {
            m23637Q(view);
            return;
        }
        if (R$id.rl_expired_voucher == view.getId()) {
            m23886x("UNIFORM_VOUCHER_CENTER_PKG_EXP_EXPIRED_CLICK");
            m23634N();
            return;
        }
        if (R$id.set_no_net_btn == id2) {
            Activity activity = getActivity();
            if (activity instanceof BasePayActivity) {
                ((BasePayActivity) activity).mo19446D1();
                return;
            }
            return;
        }
        if (id2 == R$id.ic_voucher_rule_expand) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            PackageExpManagerAdapter packageExpManagerAdapter = this.f17206D;
            if (packageExpManagerAdapter == null) {
                C1442a.m8289e("PackageExperienceFragment", "pkgAdapter is null");
            } else {
                packageExpManagerAdapter.getItem(iIntValue).reverseExpandState();
                this.f17206D.notifyDataSetChanged();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment, android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        PackageExpManagerAdapter packageExpManagerAdapter = this.f17206D;
        if (packageExpManagerAdapter != null) {
            packageExpManagerAdapter.m25063f(C11842p.m70829k0(getActivity()));
            this.f17206D.notifyDataSetChanged();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: q */
    public void mo23525q() {
        PackageExpManagerAdapter packageExpManagerAdapter = new PackageExpManagerAdapter(getActivity());
        this.f17206D = packageExpManagerAdapter;
        packageExpManagerAdapter.m25064g(this);
        this.f17206D.m25067j(mo23631M());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: r */
    public void mo23638r() {
        mo23525q();
        this.f17471d.setAdapter((ListAdapter) this.f17206D);
        this.f17471d.setOnRefreshListener(new C3639a());
        this.f17471d.setServerFailListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17552a.m23635O(view);
            }
        });
        C1442a.m8290i("PackageExperienceFragment", "initData");
        if (C0209d.m1333z1(getContext())) {
            mo23527v();
        } else {
            m23867F();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: s */
    public void mo23526s() {
        super.mo23526s();
        this.f17477j.setText(R$string.card_expire_no_data);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: v */
    public void mo23527v() {
        if (this.f17487t) {
            return;
        }
        this.f17487t = true;
        this.f17206D.notifyDataSetChanged();
        m23865D();
        this.f17205C = 0;
        new C10235i0(String.valueOf(0), 50, Integer.valueOf(mo23630L()), new C3679i0(this)).m63381g();
    }
}
