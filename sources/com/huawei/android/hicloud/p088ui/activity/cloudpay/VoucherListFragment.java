package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.VouchersManagerAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.PullableListViewForVoucherList;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.OnRefreshListener;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.GetAllVouchersResp;
import com.huawei.cloud.pay.model.GsonVoucher;
import com.huawei.cloud.pay.model.PickedWelfareContent;
import com.huawei.cloud.pay.model.QueryPickedWelfaresResp;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.model.VouchersTaskInfo;
import com.huawei.cloud.pay.model.Welfare;
import com.huawei.cloud.pay.p098ui.activity.BasePayActivity;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import dj.C9158a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import p015ak.C0209d;
import p054cj.C1442a;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11296s;
import p514o9.C11842p;
import p618rm.C12540b1;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class VoucherListFragment extends Fragment implements View.OnClickListener {

    /* renamed from: A */
    public boolean f17466A;

    /* renamed from: a */
    public View f17468a;

    /* renamed from: b */
    public NotchTopFitRelativeLayout f17469b;

    /* renamed from: c */
    public NotchFitRelativeLayout f17470c;

    /* renamed from: d */
    public PullableListViewForVoucherList f17471d;

    /* renamed from: e */
    public LinearLayout f17472e;

    /* renamed from: f */
    public ScrollView f17473f;

    /* renamed from: g */
    public RelativeLayout f17474g;

    /* renamed from: h */
    public RelativeLayout f17475h;

    /* renamed from: i */
    public RelativeLayout f17476i;

    /* renamed from: j */
    public TextView f17477j;

    /* renamed from: k */
    public View f17478k;

    /* renamed from: l */
    public View f17479l;

    /* renamed from: m */
    public View f17480m;

    /* renamed from: n */
    public VouchersManagerAdapter f17481n;

    /* renamed from: p */
    public AutoSizeButton f17483p;

    /* renamed from: q */
    public AutoSizeButton f17484q;

    /* renamed from: r */
    public HiCloudExceptionView f17485r;

    /* renamed from: s */
    public C11060c f17486s;

    /* renamed from: v */
    public boolean f17489v;

    /* renamed from: w */
    public long f17490w;

    /* renamed from: z */
    public boolean f17493z;

    /* renamed from: o */
    public HandlerC3659c f17482o = new HandlerC3659c(this);

    /* renamed from: t */
    public boolean f17487t = false;

    /* renamed from: u */
    public String f17488u = null;

    /* renamed from: x */
    public List<Voucher> f17491x = new ArrayList();

    /* renamed from: y */
    public List<Welfare> f17492y = new ArrayList();

    /* renamed from: B */
    public CountDownLatch f17467B = new CountDownLatch(2);

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.VoucherListFragment$a */
    public class C3657a implements OnRefreshListener {

        /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.VoucherListFragment$a$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1442a.m8290i("VoucherListFragment", "load more");
                VoucherListFragment.this.mo23524h();
            }
        }

        public C3657a() {
        }

        @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.OnRefreshListener
        public void onLoadingMore() {
            VoucherListFragment.this.f17482o.postDelayed(new a(), 1500L);
        }

        @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.OnRefreshListener
        public void onPullRefresh() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.VoucherListFragment$b */
    public class ViewOnClickListenerC3658b implements View.OnClickListener {
        public ViewOnClickListenerC3658b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VoucherListFragment voucherListFragment = VoucherListFragment.this;
            if (voucherListFragment.f17481n != null) {
                voucherListFragment.f17471d.setServerFailType(false);
            }
            VoucherListFragment.this.mo23527v();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.VoucherListFragment$c */
    public static class HandlerC3659c extends Handler {

        /* renamed from: a */
        public WeakReference<VoucherListFragment> f17497a;

        public HandlerC3659c(VoucherListFragment voucherListFragment) {
            this.f17497a = new WeakReference<>(voucherListFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VoucherListFragment voucherListFragment = this.f17497a.get();
            if (voucherListFragment == null) {
                C1442a.m8288d("VoucherListFragment", "orders activity has been collected.");
            }
            int i10 = message.what;
            if (i10 == 6031) {
                voucherListFragment.mo23522b((GetAllVouchersResp) message.obj);
                voucherListFragment.m23873f().countDown();
                return;
            }
            if (i10 == 6032) {
                voucherListFragment.m23863B(false);
                voucherListFragment.m23873f().countDown();
                return;
            }
            switch (i10) {
                case 6038:
                    voucherListFragment.mo23523e((QueryPickedWelfaresResp) message.obj);
                    voucherListFragment.m23873f().countDown();
                    break;
                case 6039:
                    voucherListFragment.m23864C(false);
                    voucherListFragment.m23873f().countDown();
                    break;
                case 6040:
                    voucherListFragment.f17487t = false;
                    if (voucherListFragment.m23883t() || voucherListFragment.m23884u()) {
                        voucherListFragment.m23872d();
                    } else {
                        voucherListFragment.m23871c();
                    }
                    voucherListFragment.m23888z(new CountDownLatch(2));
                    break;
                default:
                    super.handleMessage(message);
                    break;
            }
        }
    }

    /* renamed from: A */
    public final void m23862A() {
        Activity activity = getActivity();
        C11842p.m70760Q1(activity, C12809f.m76831d(this.f17468a, R$id.layout_nonet_icon));
        C11842p.m70760Q1(activity, this.f17478k);
        C11842p.m70760Q1(activity, C12809f.m76831d(this.f17468a, R$id.layout_no_service_icon));
        C11842p.m70760Q1(activity, this.f17472e);
    }

    /* renamed from: B */
    public void m23863B(boolean z10) {
        this.f17493z = z10;
    }

    /* renamed from: C */
    public void m23864C(boolean z10) {
        this.f17466A = z10;
    }

    /* renamed from: D */
    public void m23865D() {
        this.f17478k.setVisibility(0);
        this.f17472e.setVisibility(8);
        this.f17473f.setVisibility(8);
        this.f17480m.setVisibility(8);
        this.f17479l.setVisibility(8);
    }

    /* renamed from: E */
    public void m23866E() {
        this.f17478k.setVisibility(8);
        this.f17472e.setVisibility(8);
        this.f17473f.setVisibility(8);
        this.f17480m.setVisibility(8);
        this.f17479l.setVisibility(8);
        this.f17471d.setVisibility(0);
    }

    /* renamed from: F */
    public void m23867F() {
        this.f17478k.setVisibility(8);
        this.f17472e.setVisibility(8);
        this.f17473f.setVisibility(8);
        this.f17480m.setVisibility(0);
        this.f17479l.setVisibility(8);
    }

    /* renamed from: G */
    public void m23868G() {
        this.f17478k.setVisibility(8);
        this.f17472e.setVisibility(0);
        this.f17473f.setVisibility(0);
        this.f17480m.setVisibility(8);
        this.f17479l.setVisibility(8);
    }

    /* renamed from: H */
    public void mo23521H(List<Voucher> list) {
        Collections.sort(list);
    }

    /* renamed from: I */
    public final List<Voucher> m23869I(List<Welfare> list, Context context) {
        ArrayList arrayList = new ArrayList();
        for (Welfare welfare : list) {
            Voucher voucher = new Voucher();
            m23870a(context, welfare, voucher);
            arrayList.add(voucher);
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void m23870a(Context context, Welfare welfare, Voucher voucher) {
        PickedWelfareContent pickedWelfareContentM23876j = m23876j(welfare.getContent());
        voucher.setVoucherCardType(1);
        voucher.setOrderStatus(0);
        voucher.setWelfareName(m23874g(welfare, context, pickedWelfareContentM23876j));
        voucher.setEffectiveTime(welfare.getPickTime());
        voucher.setExpireTime(welfare.getExpireTime());
        voucher.setVoucherSubTitle(m23878l(welfare, context));
        voucher.setUseUrl(welfare.getUseUrl());
        voucher.setGradeCode(pickedWelfareContentM23876j.getGradeCode());
        voucher.setCapacity(pickedWelfareContentM23876j.getSpace());
    }

    /* renamed from: b */
    public void mo23522b(GetAllVouchersResp getAllVouchersResp) {
        C1442a.m8290i("VoucherListFragment", "dealGetAllVouchersSuccess");
        GsonVoucher gsonVoucher = (GsonVoucher) C12540b1.m75483a("{\"usefulVouchers\":" + getAllVouchersResp.getUsefulVouchers() + "}", GsonVoucher.class);
        m23875i().addAll(gsonVoucher.getUsefulVouchers());
        this.f17489v = m23882p(gsonVoucher.getUsefulVouchers());
        this.f17490w = getAllVouchersResp.getUsefulCount();
        this.f17488u = getAllVouchersResp.getPageToken();
        m23863B(true);
    }

    /* renamed from: c */
    public void m23871c() {
        C1442a.m8290i("VoucherListFragment", "dealQueryPageFailed");
        m23868G();
    }

    /* renamed from: d */
    public void m23872d() {
        C1442a.m8290i("VoucherListFragment", "dealQueryPageSuccess");
        ArrayList arrayList = new ArrayList();
        if (m23875i() != null && !m23875i().isEmpty()) {
            arrayList.addAll(m23875i());
            m23875i().clear();
        }
        if (m23877k() != null && !m23877k().isEmpty()) {
            arrayList.addAll(m23869I(m23877k(), getContext()));
            m23877k().clear();
        }
        mo23521H(arrayList);
        String str = this.f17488u;
        if (str != null) {
            if (str.equals("0|0|0|0")) {
                this.f17471d.setHasMoreData(false);
            } else {
                this.f17471d.setHasMoreData(true);
            }
        }
        if (arrayList.isEmpty()) {
            m23868G();
            return;
        }
        VouchersManagerAdapter vouchersManagerAdapter = this.f17481n;
        if (vouchersManagerAdapter != null) {
            vouchersManagerAdapter.mo25309a(arrayList);
            this.f17481n.notifyDataSetChanged();
        }
        m23866E();
        this.f17471d.completeRefresh();
    }

    /* renamed from: e */
    public void mo23523e(QueryPickedWelfaresResp queryPickedWelfaresResp) {
        C1442a.m8290i("VoucherListFragment", "dealQueryPickedWelfaresSuccess");
        if (queryPickedWelfaresResp.getUsefulWelfares() != null) {
            m23877k().addAll(queryPickedWelfaresResp.getUsefulWelfares());
        } else {
            C1442a.m8288d("VoucherListFragment", "dealQueryPickedWelfaresSuccess usefulWelfares is null");
        }
        m23864C(true);
    }

    /* renamed from: f */
    public CountDownLatch m23873f() {
        return this.f17467B;
    }

    /* renamed from: g */
    public final String m23874g(Welfare welfare, Context context, PickedWelfareContent pickedWelfareContent) {
        String name = welfare.getName();
        if (context == null) {
            C1442a.m8291w("VoucherListFragment", "getFullWelfName context is null");
            return name;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            C1442a.m8291w("VoucherListFragment", "getFullWelfName resources is null");
            return name;
        }
        if (pickedWelfareContent == null) {
            C1442a.m8291w("VoucherListFragment", "getFullWelfName content is null");
            return name;
        }
        int duration = pickedWelfareContent.getDuration();
        if (pickedWelfareContent.getTimeUnit() != 1) {
            return name;
        }
        try {
            return resources.getQuantityString(R$plurals.welfare_full_name, duration, name, Integer.valueOf(duration));
        } catch (Exception e10) {
            C1442a.m8291w("VoucherListFragment", "getFullWelfName exception=" + e10.toString());
            return name;
        }
    }

    /* renamed from: h */
    public void mo23524h() {
        if (C11296s.m67786J(getContext())) {
            C9158a.m57503F().m57520R(this.f17482o, new VouchersTaskInfo("0|1|2", m23879m("0"), "50", this.f17488u), this.f17467B);
            return;
        }
        this.f17471d.completeRefresh();
        if (this.f17481n != null) {
            this.f17471d.setNoNetWorkType();
        }
    }

    /* renamed from: i */
    public List<Voucher> m23875i() {
        return this.f17491x;
    }

    /* renamed from: j */
    public final PickedWelfareContent m23876j(String str) {
        return (PickedWelfareContent) C12540b1.m75483a(str, PickedWelfareContent.class);
    }

    /* renamed from: k */
    public List<Welfare> m23877k() {
        return this.f17492y;
    }

    /* renamed from: l */
    public final String m23878l(Welfare welfare, Context context) {
        if (context == null) {
            C1442a.m8291w("VoucherListFragment", "getWelfRule context is null");
            return "";
        }
        Resources resources = context.getResources();
        if (resources != null) {
            return welfare.getState() == 2 ? resources.getString(R$string.voucher_used) : welfare.getState() == 4 ? resources.getString(R$string.voucher_expired) : welfare.getDesc();
        }
        C1442a.m8291w("VoucherListFragment", "getWelfRule resources is null");
        return "";
    }

    /* renamed from: m */
    public String m23879m(String str) {
        str.hashCode();
        return !str.equals("1") ? !str.equals("2") ? "1000" : "0010" : "0100";
    }

    /* renamed from: n */
    public final void m23880n() {
        Activity activity = getActivity();
        if (activity == null) {
            C1442a.m8289e("VoucherListFragment", "gotoExpire activity is null");
        } else {
            activity.startActivity(new Intent(activity, (Class<?>) UnusefulVoucherActivity.class));
        }
    }

    /* renamed from: o */
    public final void m23881o(View view) {
        String queryParameter;
        Voucher item = this.f17481n.getItem(((Integer) view.getTag()).intValue());
        try {
            queryParameter = Uri.parse(item.getUseUrl()).getQueryParameter("path");
        } catch (Exception e10) {
            C1442a.m8290i("VoucherListFragment", "getQueryParameter error" + e10.toString());
            queryParameter = null;
        }
        String json = new Gson().toJson(item);
        Intent intent = new Intent();
        intent.putExtra("iap_intent_voucher_info", json);
        if (item.getVoucherCardType() == 1) {
            String gradeCode = item.getGradeCode();
            long capacity = item.getCapacity();
            intent.putExtra(HNConstants.PayIntentKey.IS_FROM_COUPON_CENTER_WELFARE_CARD, true);
            intent.putExtra(HNConstants.PayIntentKey.RECOMMEND_GRADE_CODE_KEY, gradeCode);
            intent.putExtra(HNConstants.PayIntentKey.RECOMMEND_CAPACITY_KEY, capacity);
        }
        Activity activity = getActivity();
        if (activity == null) {
            C1442a.m8289e("VoucherListFragment", "handeUse activity is null");
            return;
        }
        if (TextUtils.equals(queryParameter, "PurchaseCloudCardActivity")) {
            intent.setClass(activity, PurchaseCloudCardActivity.class);
        } else if (TextUtils.equals(queryParameter, "CloudSpaceUpgradeActivity")) {
            intent.setClass(activity, CloudSpaceUpgradeActivity.class);
        } else {
            intent.setClass(activity, MainActivity.class);
        }
        activity.startActivityForResult(intent, 10014);
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        if (i10 == 10014) {
            mo23527v();
        }
        super.onActivityResult(i10, i11, hiCloudSafeIntent);
    }

    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        if (R$id.layout_nonetwork == view.getId() || R$id.layout_nodata == view.getId()) {
            if (C11296s.m67786J(getContext())) {
                mo23527v();
                return;
            }
            return;
        }
        if (R$id.bt_use == view.getId()) {
            if (this.f17481n.getItem(((Integer) view.getTag()).intValue()).getVoucherCardType() == 1) {
                m23887y();
            } else {
                m23885w();
            }
            m23881o(view);
            return;
        }
        if (R$id.set_no_net_btn == view.getId()) {
            Activity activity = getActivity();
            if (activity instanceof BasePayActivity) {
                ((BasePayActivity) activity).mo19446D1();
                return;
            }
            return;
        }
        if (R$id.rl_expired_voucher == view.getId()) {
            m23886x("UNIFORM_CLOUDPAY_PAY_MANAGE_USELESS_VOUCHER_CLICK");
            m23880n();
        } else if (view.getId() == R$id.ic_voucher_rule_expand) {
            Voucher item = this.f17481n.getItem(((Integer) view.getTag()).intValue());
            if (item.getRuleStatus() == 0) {
                item.setRuleStatus(1);
            } else {
                item.setRuleStatus(0);
            }
            this.f17481n.notifyDataSetChanged();
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        VouchersManagerAdapter vouchersManagerAdapter = this.f17481n;
        if (vouchersManagerAdapter != null) {
            vouchersManagerAdapter.m25444o(C11842p.m70829k0(getActivity()));
            this.f17481n.notifyDataSetChanged();
        }
        m23862A();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1442a.m8290i("VoucherListFragment", "onCreate");
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f17468a = layoutInflater.inflate(R$layout.pay_vouchers_list_activity, viewGroup, false);
        C1442a.m8290i("VoucherListFragment", "onCreateView");
        mo23526s();
        mo23638r();
        return this.f17468a;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
    }

    /* renamed from: p */
    public final boolean m23882p(List<Voucher> list) {
        String scheme;
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (Voucher voucher : list) {
            String useUrl = voucher.getUseUrl();
            if (!TextUtils.isEmpty(useUrl) && (scheme = Uri.parse(useUrl).getScheme()) != null && scheme.equals("hicloud") && voucher.getOrderStatus() == 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: q */
    public void mo23525q() {
        Activity activity = getActivity();
        VouchersManagerAdapter vouchersManagerAdapter = new VouchersManagerAdapter(activity);
        this.f17481n = vouchersManagerAdapter;
        vouchersManagerAdapter.m25444o(C11842p.m70829k0(activity));
        this.f17481n.m25450v(this);
        this.f17481n.m25447s(0);
    }

    /* renamed from: r */
    public void mo23638r() {
        C11060c c11060c = new C11060c();
        this.f17486s = c11060c;
        c11060c.m66636B("06008");
        this.f17486s.m66643I(C11058a.m66627b("06008"));
        mo23525q();
        this.f17471d.setAdapter((ListAdapter) this.f17481n);
        this.f17471d.setOnRefreshListener(new C3657a());
        this.f17471d.setServerFailListener(new ViewOnClickListenerC3658b());
        C1442a.m8290i("VoucherListFragment", "initData");
        if (C11296s.m67786J(getContext())) {
            mo23527v();
        } else {
            m23867F();
        }
    }

    /* renamed from: s */
    public void mo23526s() {
        Activity activity = getActivity();
        this.f17469b = (NotchTopFitRelativeLayout) C12809f.m76831d(this.f17468a, R$id.main_notch_fit_top_layout);
        this.f17470c = (NotchFitRelativeLayout) C12809f.m76831d(this.f17468a, R$id.notch_fit_layout);
        this.f17472e = (LinearLayout) C12809f.m76831d(this.f17468a, R$id.voucher_list_nodata);
        this.f17473f = (ScrollView) C12809f.m76831d(this.f17468a, R$id.scroll_no_voucher);
        this.f17479l = C12809f.m76831d(this.f17468a, R$id.layout_nodata);
        this.f17484q = (AutoSizeButton) C12809f.m76831d(this.f17468a, R$id.set_retry_getinfo);
        this.f17471d = (PullableListViewForVoucherList) C12809f.m76831d(this.f17468a, R$id.vouchers_list);
        this.f17474g = (RelativeLayout) C12809f.m76831d(this.f17468a, R$id.rl_voucher_list);
        this.f17477j = (TextView) C12809f.m76831d(this.f17468a, R$id.tv_no_vouchers);
        this.f17475h = (RelativeLayout) C12809f.m76831d(this.f17468a, R$id.expired_voucher_layout);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(this.f17468a, R$id.rl_expired_voucher);
        this.f17476i = relativeLayout;
        relativeLayout.setOnClickListener(this);
        C11842p.m70874v1(activity, this.f17484q);
        this.f17479l.setOnClickListener(this);
        this.f17478k = C12809f.m76831d(this.f17468a, R$id.layout_loading);
        View viewM76831d = C12809f.m76831d(this.f17468a, R$id.layout_nonetwork);
        this.f17480m = viewM76831d;
        viewM76831d.setOnClickListener(this);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76831d(this.f17480m, R$id.set_no_net_btn);
        this.f17483p = autoSizeButton;
        C11842p.m70874v1(activity, autoSizeButton);
        this.f17483p.setOnClickListener(this);
        this.f17485r = (HiCloudExceptionView) C12809f.m76831d(this.f17468a, R$id.exception_view);
        m23862A();
    }

    /* renamed from: t */
    public boolean m23883t() {
        return this.f17493z;
    }

    /* renamed from: u */
    public boolean m23884u() {
        return this.f17466A;
    }

    /* renamed from: v */
    public void mo23527v() {
        if (this.f17487t) {
            return;
        }
        this.f17487t = true;
        this.f17481n.m25434b();
        this.f17481n.notifyDataSetChanged();
        m23865D();
        C9158a.m57503F().m57520R(this.f17482o, new VouchersTaskInfo("0|1|2", "1000", "50", ""), this.f17467B);
    }

    /* renamed from: w */
    public final void m23885w() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_PAY_MANAGE_VOUCHER_USE_CLICK", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_PAY_MANAGE_VOUCHER_USE_CLICK", "1", "31", linkedHashMapM79497A);
    }

    /* renamed from: x */
    public void m23886x(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        C13227f.m79492i1().m79567R(str, linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", str, "1", "31", linkedHashMapM79497A);
    }

    /* renamed from: y */
    public final void m23887y() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_PAY_MANAGE_WELFARE_USE_CLICK", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_PAY_MANAGE_WELFARE_USE_CLICK", "1", "31", linkedHashMapM79497A);
    }

    /* renamed from: z */
    public void m23888z(CountDownLatch countDownLatch) {
        this.f17467B = countDownLatch;
    }
}
