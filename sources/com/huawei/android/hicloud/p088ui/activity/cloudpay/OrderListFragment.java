package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import be.C1166b;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.OnRefreshListener;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.PullableListViewForOrderList;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.TransactionItem;
import com.huawei.cloud.pay.p098ui.activity.BasePayActivity;
import dj.C9158a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import p054cj.C1442a;
import p398jj.InterfaceC10892a;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11290m;
import p454lj.C11296s;
import p514o9.C11842p;
import p845zi.C14302a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OrderListFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    public View f17184a;

    /* renamed from: b */
    public InterfaceC10892a f17185b;

    /* renamed from: c */
    public NotchTopFitRelativeLayout f17186c;

    /* renamed from: d */
    public NotchFitRelativeLayout f17187d;

    /* renamed from: e */
    public PullableListViewForOrderList f17188e;

    /* renamed from: f */
    public LinearLayout f17189f;

    /* renamed from: g */
    public View f17190g;

    /* renamed from: h */
    public View f17191h;

    /* renamed from: i */
    public View f17192i;

    /* renamed from: j */
    public C1166b f17193j;

    /* renamed from: l */
    public AutoSizeButton f17195l;

    /* renamed from: m */
    public AutoSizeButton f17196m;

    /* renamed from: n */
    public HiCloudExceptionView f17197n;

    /* renamed from: o */
    public C11060c f17198o;

    /* renamed from: k */
    public HandlerC3638c f17194k = new HandlerC3638c(this);

    /* renamed from: p */
    public boolean f17199p = false;

    /* renamed from: q */
    public List<TransactionItem> f17200q = new ArrayList();

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.OrderListFragment$a */
    public class C3636a implements OnRefreshListener {

        /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.OrderListFragment$a$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1442a.m8290i("OrderListFragment", "load more");
                OrderListFragment.this.m23620l();
            }
        }

        public C3636a() {
        }

        @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.OnRefreshListener
        public void onLoadingMore() {
            OrderListFragment.this.f17194k.postDelayed(new a(), 1500L);
        }

        @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.OnRefreshListener
        public void onPullRefresh() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.OrderListFragment$b */
    public class ViewOnClickListenerC3637b implements View.OnClickListener {
        public ViewOnClickListenerC3637b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (OrderListFragment.this.f17193j != null && OrderListFragment.this.f17200q != null && OrderListFragment.this.f17200q.size() > 0) {
                OrderListFragment.this.f17188e.setServerFailType(false);
            }
            OrderListFragment.this.m23623o();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.OrderListFragment$c */
    public static class HandlerC3638c extends Handler {

        /* renamed from: a */
        public WeakReference<OrderListFragment> f17204a;

        public HandlerC3638c(OrderListFragment orderListFragment) {
            this.f17204a = new WeakReference<>(orderListFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            OrderListFragment orderListFragment = this.f17204a.get();
            if (orderListFragment == null) {
                C1442a.m8288d("OrderListFragment", "orders activity has been collected.");
                return;
            }
            int i10 = message.what;
            if (i10 == 2007) {
                orderListFragment.f17199p = false;
                orderListFragment.m23619k((List) message.obj);
            } else if (i10 != 2107) {
                super.handleMessage(message);
            } else {
                orderListFragment.f17199p = false;
                orderListFragment.m23618j();
            }
        }
    }

    public OrderListFragment() {
    }

    /* renamed from: j */
    public final void m23618j() {
        List<TransactionItem> list;
        List<TransactionItem> list2 = this.f17200q;
        if (list2 != null && list2.isEmpty()) {
            m23625q();
            return;
        }
        this.f17188e.completeRefresh();
        if (this.f17193j == null || (list = this.f17200q) == null || list.size() <= 0) {
            return;
        }
        this.f17188e.setServerFailType(true);
    }

    /* renamed from: k */
    public final void m23619k(List<TransactionItem> list) {
        if (this.f17193j != null && list != null && list.size() > 0) {
            this.f17188e.setNoNetWorkType();
        }
        if (list == null || list.isEmpty()) {
            C14302a.m85176d().m85183h(false);
            if (this.f17193j != null && list != null && list.size() > 0) {
                this.f17188e.setNoNetWorkType();
            }
        } else {
            C14302a.m85176d().m85177a(list);
            List<TransactionItem> listM85180e = C14302a.m85176d().m85180e();
            Collections.sort(listM85180e);
            this.f17200q.clear();
            this.f17200q.addAll(listM85180e);
            C1166b c1166b = this.f17193j;
            if (c1166b != null) {
                c1166b.notifyDataSetChanged();
            }
        }
        if (this.f17200q.isEmpty()) {
            m23629u();
        } else {
            m23627s();
            this.f17188e.completeRefresh();
        }
    }

    /* renamed from: l */
    public final void m23620l() {
        List<TransactionItem> list;
        if (C11296s.m67786J(getContext())) {
            C9158a.m57503F().m57511I(this.f17194k, this.f17198o, true);
            return;
        }
        this.f17188e.completeRefresh();
        if (this.f17193j == null || (list = this.f17200q) == null || list.size() <= 0) {
            return;
        }
        this.f17188e.setNoNetWorkType();
    }

    /* renamed from: m */
    public final void m23621m() {
        C11060c c11060c = new C11060c();
        this.f17198o = c11060c;
        c11060c.m66636B("06008");
        this.f17198o.m66643I(C11058a.m66627b("06008"));
        TimeZone timeZoneM67755p = C11290m.m67755p(getContext());
        if (this.f17193j == null) {
            C1166b c1166b = new C1166b(getContext(), this.f17200q, timeZoneM67755p, this.f17185b);
            this.f17193j = c1166b;
            this.f17188e.setAdapter((ListAdapter) c1166b);
        }
        this.f17188e.setOnRefreshListener(new C3636a());
        this.f17188e.setServerFailListener(new ViewOnClickListenerC3637b());
        if (C11296s.m67786J(getContext())) {
            m23623o();
        } else {
            m23628t();
        }
    }

    /* renamed from: n */
    public final void m23622n() {
        this.f17186c = (NotchTopFitRelativeLayout) C12809f.m76831d(this.f17184a, R$id.main_notch_fit_top_layout);
        this.f17187d = (NotchFitRelativeLayout) C12809f.m76831d(this.f17184a, R$id.notch_fit_layout);
        this.f17188e = (PullableListViewForOrderList) C12809f.m76831d(this.f17184a, R$id.lv_order_list);
        this.f17189f = (LinearLayout) C12809f.m76831d(this.f17184a, R$id.order_list_nodata);
        this.f17191h = C12809f.m76831d(this.f17184a, R$id.layout_nodata);
        this.f17196m = (AutoSizeButton) C12809f.m76831d(this.f17184a, R$id.set_retry_getinfo);
        C11842p.m70874v1(getActivity(), this.f17196m);
        this.f17191h.setOnClickListener(this);
        this.f17190g = C12809f.m76831d(this.f17184a, R$id.layout_loading);
        View viewM76831d = C12809f.m76831d(this.f17184a, R$id.layout_nonetwork);
        this.f17192i = viewM76831d;
        viewM76831d.setOnClickListener(this);
        this.f17195l = (AutoSizeButton) C12809f.m76831d(this.f17192i, R$id.set_no_net_btn);
        C11842p.m70874v1(getActivity(), this.f17195l);
        this.f17195l.setOnClickListener(this);
        this.f17197n = (HiCloudExceptionView) C12809f.m76831d(this.f17184a, R$id.exception_view);
        m23624p();
    }

    /* renamed from: o */
    public final void m23623o() {
        if (this.f17199p) {
            return;
        }
        this.f17199p = true;
        this.f17200q.clear();
        this.f17193j.notifyDataSetChanged();
        C14302a.m85176d().m85178b();
        m23626r();
        C9158a.m57503F().m57511I(this.f17194k, this.f17198o, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (R$id.layout_nonetwork == view.getId() || R$id.layout_nodata == view.getId()) {
            if (C11296s.m67786J(getContext())) {
                m23623o();
            }
        } else if (R$id.set_no_net_btn == view.getId()) {
            Activity activity = getActivity();
            if (activity instanceof BasePayActivity) {
                ((BasePayActivity) activity).mo19446D1();
            }
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(getActivity(), this.f17196m);
        C11842p.m70874v1(getActivity(), this.f17195l);
        m23624p();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f17184a = layoutInflater.inflate(R$layout.pay_order_list_fragment, viewGroup, false);
        m23622n();
        m23621m();
        return this.f17184a;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        C14302a.m85176d().m85178b();
        super.onDestroy();
    }

    /* renamed from: p */
    public final void m23624p() {
        C11842p.m70760Q1(getActivity(), C12809f.m76831d(this.f17184a, R$id.layout_nonet_icon));
        C11842p.m70760Q1(getActivity(), this.f17190g);
        C11842p.m70760Q1(getActivity(), C12809f.m76831d(this.f17184a, R$id.layout_no_service_icon));
        C11842p.m70760Q1(getActivity(), this.f17189f);
    }

    /* renamed from: q */
    public final void m23625q() {
        this.f17190g.setVisibility(8);
        this.f17189f.setVisibility(8);
        this.f17188e.setVisibility(8);
        this.f17192i.setVisibility(8);
        this.f17191h.setVisibility(0);
    }

    /* renamed from: r */
    public final void m23626r() {
        this.f17190g.setVisibility(0);
        this.f17189f.setVisibility(8);
        this.f17188e.setVisibility(8);
        this.f17192i.setVisibility(8);
        this.f17191h.setVisibility(8);
    }

    /* renamed from: s */
    public final void m23627s() {
        this.f17190g.setVisibility(8);
        this.f17189f.setVisibility(8);
        this.f17192i.setVisibility(8);
        this.f17188e.setVisibility(0);
        this.f17191h.setVisibility(8);
    }

    /* renamed from: t */
    public final void m23628t() {
        this.f17190g.setVisibility(8);
        this.f17189f.setVisibility(8);
        this.f17188e.setVisibility(8);
        this.f17192i.setVisibility(0);
        this.f17191h.setVisibility(8);
    }

    /* renamed from: u */
    public final void m23629u() {
        this.f17190g.setVisibility(8);
        this.f17189f.setVisibility(0);
        this.f17188e.setVisibility(8);
        this.f17192i.setVisibility(8);
        this.f17191h.setVisibility(8);
    }

    @SuppressLint({"ValidFragment"})
    public OrderListFragment(InterfaceC10892a interfaceC10892a) {
        this.f17185b = interfaceC10892a;
    }
}
