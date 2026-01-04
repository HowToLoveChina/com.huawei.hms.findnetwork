package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.huawei.android.hicloud.p088ui.uiadapter.TicketsManagerAdapter;
import com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.VouchersManagerAdapter;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.GetAllTicketsResp;
import com.huawei.cloud.pay.model.Tickets;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.p098ui.activity.BasePayActivity;
import dj.C9158a;
import java.lang.ref.WeakReference;
import java.util.List;
import p015ak.C0213f;
import p054cj.C1442a;
import p454lj.C11296s;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class TicketListFragment extends VoucherListFragment {

    /* renamed from: C */
    public int f17407C = 1;

    /* renamed from: D */
    public int f17408D = 50;

    /* renamed from: E */
    public HandlerC3655a f17409E = new HandlerC3655a(this);

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.TicketListFragment$a */
    public static class HandlerC3655a extends Handler {

        /* renamed from: a */
        public WeakReference<TicketListFragment> f17410a;

        public HandlerC3655a(TicketListFragment ticketListFragment) {
            this.f17410a = new WeakReference<>(ticketListFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TicketListFragment ticketListFragment = this.f17410a.get();
            if (ticketListFragment == null) {
                C1442a.m8288d("TicketListFragment", "orders activity has been collected.");
                return;
            }
            int i10 = message.what;
            if (i10 == 6033) {
                C1442a.m8290i("TicketListFragment", "GET_ALL_CARDS_SUCCESS");
                ticketListFragment.f17487t = false;
                ticketListFragment.m23819K((GetAllTicketsResp) message.obj);
            } else {
                if (i10 != 6034) {
                    super.handleMessage(message);
                    return;
                }
                C1442a.m8290i("TicketListFragment", "GET_ALL_CARDS_FAIL");
                ticketListFragment.f17487t = false;
                ticketListFragment.m23871c();
            }
        }
    }

    /* renamed from: J */
    public final void m23818J(View view) {
        Voucher item = this.f17481n.getItem(((Integer) view.getTag()).intValue());
        if (item instanceof Tickets) {
            String exchangeCode = ((Tickets) item).getExchangeCode();
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null || TextUtils.isEmpty(exchangeCode)) {
                return;
            }
            ClipboardManager clipboardManager = (ClipboardManager) contextM1377a.getSystemService("clipboard");
            clipboardManager.setText(exchangeCode.trim());
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, exchangeCode));
            Toast.makeText(contextM1377a, contextM1377a.getResources().getString(R$string.copy_text_success), 0).show();
        }
    }

    /* renamed from: K */
    public void m23819K(GetAllTicketsResp getAllTicketsResp) {
        List<Tickets> ticketsList = getAllTicketsResp.getTicketsList();
        if (ticketsList == null || ticketsList.isEmpty()) {
            m23868G();
        } else {
            VouchersManagerAdapter vouchersManagerAdapter = this.f17481n;
            if (vouchersManagerAdapter != null) {
                vouchersManagerAdapter.mo25309a(ticketsList);
                this.f17481n.notifyDataSetChanged();
            }
            m23866E();
            this.f17471d.completeRefresh();
        }
        if (getAllTicketsResp.getTotalCount() >= this.f17407C * this.f17408D) {
            this.f17471d.setHasMoreData(true);
        } else {
            this.f17471d.setHasMoreData(false);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: h */
    public void mo23524h() {
        if (C11296s.m67786J(getContext())) {
            this.f17407C++;
            C9158a.m57503F().m57553r(this.f17409E, null, "50", String.valueOf(this.f17407C));
        } else {
            this.f17471d.completeRefresh();
            if (this.f17481n != null) {
                this.f17471d.setNoNetWorkType();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            C1442a.m8289e("TicketListFragment", "onClick view is null");
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
            m23818J(view);
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
            Voucher item = this.f17481n.getItem(((Integer) view.getTag()).intValue());
            if (item.getRuleStatus() == 0) {
                item.setRuleStatus(1);
            } else {
                item.setRuleStatus(0);
            }
            this.f17481n.notifyDataSetChanged();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: q */
    public void mo23525q() {
        TicketsManagerAdapter ticketsManagerAdapter = new TicketsManagerAdapter(getActivity());
        this.f17481n = ticketsManagerAdapter;
        ticketsManagerAdapter.m25444o(C11842p.m70829k0(getActivity()));
        this.f17481n.m25450v(this);
        this.f17481n.m25447s(0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherListFragment
    /* renamed from: s */
    public void mo23526s() {
        super.mo23526s();
        this.f17475h.setVisibility(8);
        C11842p.m70815g2(this.f17470c, 0.0f);
        this.f17477j.setText(R$string.card_expire_no_data);
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
        this.f17407C = 1;
        C9158a.m57503F().m57553r(this.f17409E, null, "50", String.valueOf(this.f17407C));
    }
}
