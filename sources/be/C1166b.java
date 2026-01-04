package be;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.TransactionItem;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import p015ak.C0213f;
import p015ak.C0234s;
import p054cj.C1442a;
import p398jj.InterfaceC10892a;
import p454lj.C11290m;
import p514o9.C11842p;
import p783xp.C13843a;
import sk.C12806c;
import sk.C12809f;

/* renamed from: be.b */
/* loaded from: classes3.dex */
public class C1166b extends BaseAdapter {

    /* renamed from: a */
    public Context f5484a;

    /* renamed from: b */
    public List<TransactionItem> f5485b;

    /* renamed from: c */
    public TimeZone f5486c;

    /* renamed from: d */
    public InterfaceC10892a f5487d;

    /* renamed from: be.b$a */
    public class a implements View.OnLongClickListener {

        /* renamed from: a */
        public final /* synthetic */ b f5488a;

        public a(b bVar) {
            this.f5488a = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ((ClipboardManager) C1166b.this.f5484a.getSystemService("clipboard")).setText(this.f5488a.f5506n.getText().toString().trim());
            Toast.makeText(C1166b.this.f5484a, R$string.cloudpay_order_id_copy_finish, 0).show();
            if (C1166b.this.f5487d != null) {
                C1166b.this.f5487d.mo23655T();
            }
            return false;
        }
    }

    /* renamed from: be.b$b */
    public static class b {

        /* renamed from: A */
        public TextView f5490A;

        /* renamed from: B */
        public View f5491B;

        /* renamed from: C */
        public View f5492C;

        /* renamed from: a */
        public NotchFitLinearLayout f5493a;

        /* renamed from: b */
        public LinearLayout f5494b;

        /* renamed from: c */
        public RelativeLayout f5495c;

        /* renamed from: d */
        public TextView f5496d;

        /* renamed from: e */
        public TextView f5497e;

        /* renamed from: f */
        public ImageView f5498f;

        /* renamed from: g */
        public LinearLayout f5499g;

        /* renamed from: h */
        public TextView f5500h;

        /* renamed from: i */
        public TextView f5501i;

        /* renamed from: j */
        public TextView f5502j;

        /* renamed from: k */
        public TextView f5503k;

        /* renamed from: l */
        public LinearLayout f5504l;

        /* renamed from: m */
        public TextView f5505m;

        /* renamed from: n */
        public TextView f5506n;

        /* renamed from: o */
        public LinearLayout f5507o;

        /* renamed from: p */
        public TextView f5508p;

        /* renamed from: q */
        public TextView f5509q;

        /* renamed from: r */
        public LinearLayout f5510r;

        /* renamed from: s */
        public TextView f5511s;

        /* renamed from: t */
        public TextView f5512t;

        /* renamed from: u */
        public TextView f5513u;

        /* renamed from: v */
        public TextView f5514v;

        /* renamed from: w */
        public TextView f5515w;

        /* renamed from: x */
        public TextView f5516x;

        /* renamed from: y */
        public LinearLayout f5517y;

        /* renamed from: z */
        public TextView f5518z;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public C1166b(Context context, List<TransactionItem> list, TimeZone timeZone, InterfaceC10892a interfaceC10892a) {
        this.f5484a = context;
        this.f5485b = list;
        this.f5486c = timeZone;
        this.f5487d = interfaceC10892a;
    }

    /* renamed from: g */
    public static void m7282g(Context context, int i10, int i11, View view) {
        if (view == null) {
            return;
        }
        if (C11842p.m70771U0()) {
            if (C11842p.m70753O0(context)) {
                m7283i(view, C11842p.m70840n(context, i10));
                return;
            } else {
                m7283i(view, C11842p.m70840n(context, i10));
                return;
            }
        }
        if (C11842p.m70747M0(context)) {
            if (C11842p.m70753O0(context)) {
                m7283i(view, C11842p.m70840n(context, i10));
                return;
            } else {
                m7283i(view, C11842p.m70840n(context, i10));
                return;
            }
        }
        if (C11842p.m70753O0(context)) {
            m7283i(view, C11842p.m70840n(context, i10));
        } else {
            m7283i(view, C11842p.m70840n(context, i11));
        }
    }

    /* renamed from: i */
    public static void m7283i(View view, int i10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart(i10);
                layoutParams2.setMarginEnd(i10);
                view.setLayoutParams(layoutParams2);
            }
        }
    }

    /* renamed from: c */
    public final void m7284c(b bVar, TransactionItem transactionItem) {
        if (bVar == null || transactionItem == null) {
            C1442a.m8289e("OrdersAdapter", "holder or order null");
            return;
        }
        Context contextM7286e = m7286e();
        if (contextM7286e == null) {
            C1442a.m8289e("OrdersAdapter", "displayOrder context null");
            return;
        }
        bVar.f5499g.setVisibility(0);
        bVar.f5510r.setVisibility(8);
        bVar.f5498f.setVisibility(8);
        bVar.f5496d.setVisibility(0);
        bVar.f5496d.setText(transactionItem.getProductName());
        if (TextUtils.isEmpty(transactionItem.getLabel())) {
            bVar.f5497e.setVisibility(8);
        } else {
            bVar.f5497e.setVisibility(0);
            bVar.f5497e.setText(transactionItem.getLabel());
        }
        int orderSource = transactionItem.getOrderSource();
        if (C13843a.m83071W(this.f5484a)) {
            bVar.f5506n.setTextDirection(4);
            bVar.f5501i.setTextDirection(4);
            bVar.f5503k.setTextDirection(4);
            bVar.f5509q.setTextDirection(4);
        }
        if (orderSource == 0) {
            bVar.f5500h.setText(R$string.cloudpay_order_buy_time);
            bVar.f5504l.setVisibility(0);
            String trxId = transactionItem.getTrxId();
            if (TextUtils.isEmpty(trxId)) {
                bVar.f5506n.setText(contextM7286e.getString(R$string.order_info_order_id_value));
            } else {
                bVar.f5506n.setText(trxId);
                bVar.f5506n.setOnLongClickListener(new a(bVar));
            }
        } else if (orderSource == 1) {
            bVar.f5504l.setVisibility(8);
            bVar.f5500h.setText(R$string.cloudpay_collection_time);
        }
        bVar.f5501i.setText(C11290m.m67744e(contextM7286e, transactionItem.getTrxTime(), this.f5486c));
        bVar.f5503k.setText(transactionItem.getFee());
        if (TextUtils.isEmpty(transactionItem.getComment())) {
            bVar.f5507o.setVisibility(8);
        } else {
            bVar.f5507o.setVisibility(0);
            bVar.f5509q.setText(transactionItem.getComment());
        }
    }

    /* renamed from: d */
    public final void m7285d(b bVar, TransactionItem transactionItem, String str) {
        if (bVar == null || transactionItem == null) {
            C1442a.m8289e("OrdersAdapter", "holder or record null");
            return;
        }
        Context contextM7286e = m7286e();
        if (contextM7286e == null) {
            C1442a.m8289e("OrdersAdapter", "displaySignRecord context null");
            return;
        }
        bVar.f5499g.setVisibility(8);
        bVar.f5510r.setVisibility(0);
        bVar.f5498f.setVisibility(0);
        bVar.f5496d.setText(R$string.cloudpay_order_sign_status);
        String label = transactionItem.getLabel();
        if (TextUtils.isEmpty(label)) {
            bVar.f5497e.setVisibility(8);
        } else {
            bVar.f5497e.setVisibility(0);
            bVar.f5497e.setText(label);
        }
        if (C13843a.m83071W(this.f5484a)) {
            bVar.f5512t.setTextDirection(4);
            bVar.f5514v.setTextDirection(4);
            bVar.f5516x.setTextDirection(4);
            bVar.f5490A.setTextDirection(4);
        }
        if (str.equals("toSign")) {
            bVar.f5498f.setImageDrawable(contextM7286e.getDrawable(R$drawable.vip));
            bVar.f5511s.setText(R$string.cloudpay_order_sign_time);
            bVar.f5512t.setText(C11290m.m67744e(this.f5484a, transactionItem.getTrxTime(), this.f5486c));
            bVar.f5513u.setText(R$string.cloudpay_order_sign_package);
            bVar.f5514v.setText(transactionItem.getProductName());
            bVar.f5515w.setText(R$string.cloudpay_order_sign_pay_mode);
            bVar.f5516x.setText(transactionItem.getPayChannelDesc());
        } else if (str.equals("unSign")) {
            bVar.f5498f.setImageDrawable(contextM7286e.getDrawable(R$drawable.unsign_pic));
            bVar.f5511s.setText(R$string.cloudpay_cancel_time);
            bVar.f5512t.setText(C11290m.m67744e(this.f5484a, transactionItem.getTrxTime(), this.f5486c));
            bVar.f5513u.setText(R$string.cloudpay_cancel_package);
            bVar.f5514v.setText(transactionItem.getProductName());
            bVar.f5515w.setText(R$string.cloudpay_cancel_payment_method);
            bVar.f5516x.setText(transactionItem.getPayChannelDesc());
        }
        String comment = transactionItem.getComment();
        if (TextUtils.isEmpty(comment)) {
            bVar.f5517y.setVisibility(8);
        } else {
            bVar.f5517y.setVisibility(0);
            bVar.f5490A.setText(comment);
        }
    }

    /* renamed from: e */
    public final Context m7286e() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null || (contextM1377a = this.f5484a) != null) {
            return contextM1377a;
        }
        C1442a.m8289e("OrdersAdapter", "getContext context is null.");
        return null;
    }

    @Override // android.widget.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public TransactionItem getItem(int i10) {
        return this.f5485b.get(i10);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<TransactionItem> list = this.f5485b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f5484a).inflate(R$layout.pay_order_list_item, viewGroup, false);
            bVar = new b(null);
            bVar.f5493a = (NotchFitLinearLayout) C12809f.m76831d(view, R$id.notch_fit_layout);
            bVar.f5494b = (LinearLayout) C12809f.m76831d(view, R$id.nontch_view_divider);
            bVar.f5495c = (RelativeLayout) C12809f.m76831d(view, R$id.inner_notch_fit_layout);
            bVar.f5496d = (TextView) C12809f.m76831d(view, R$id.tv_order_title);
            bVar.f5497e = (TextView) C12809f.m76831d(view, R$id.tv_title_lable);
            bVar.f5498f = (ImageView) C12809f.m76831d(view, R$id.img_title_icon);
            bVar.f5499g = (LinearLayout) C12809f.m76831d(view, R$id.normal_order_area);
            bVar.f5500h = (TextView) C12809f.m76831d(view, R$id.tv_order_time_prefix);
            bVar.f5501i = (TextView) C12809f.m76831d(view, R$id.tv_order_time);
            bVar.f5502j = (TextView) C12809f.m76831d(view, R$id.tv_fee_prefix);
            bVar.f5503k = (TextView) C12809f.m76831d(view, R$id.tv_fee);
            bVar.f5504l = (LinearLayout) C12809f.m76831d(view, R$id.tv_order_id_area);
            bVar.f5505m = (TextView) C12809f.m76831d(view, R$id.tv_order_id_title);
            bVar.f5506n = (TextView) C12809f.m76831d(view, R$id.tv_order_id);
            bVar.f5507o = (LinearLayout) C12809f.m76831d(view, R$id.tv_order_remark_area);
            bVar.f5508p = (TextView) C12809f.m76831d(view, R$id.tv_order_remark_title);
            bVar.f5509q = (TextView) C12809f.m76831d(view, R$id.tv_order_remark);
            bVar.f5510r = (LinearLayout) C12809f.m76831d(view, R$id.month_order_area);
            bVar.f5511s = (TextView) C12809f.m76831d(view, R$id.tv_sign_time_prefix);
            bVar.f5512t = (TextView) C12809f.m76831d(view, R$id.tv_sign_time);
            bVar.f5513u = (TextView) C12809f.m76831d(view, R$id.tv_sign_package_prefix);
            bVar.f5514v = (TextView) C12809f.m76831d(view, R$id.tv_sign_package);
            bVar.f5515w = (TextView) C12809f.m76831d(view, R$id.tv_sign_pay_mode_prefix);
            bVar.f5516x = (TextView) C12809f.m76831d(view, R$id.tv_sign_pay_mode);
            bVar.f5517y = (LinearLayout) C12809f.m76831d(view, R$id.sign_remark_area);
            bVar.f5518z = (TextView) C12809f.m76831d(view, R$id.tv_sign_mark_prefix);
            bVar.f5490A = (TextView) C12809f.m76831d(view, R$id.tv_sign_mark);
            bVar.f5491B = C12809f.m76831d(view, R$id.view_driver);
            bVar.f5492C = C12809f.m76831d(view, R$id.blank_view_for_padding);
            view.setTag(bVar);
            m7288h(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        view.setAccessibilityDelegate(C2783d.m16078D0());
        TransactionItem item = getItem(i10);
        if (item != null) {
            String trxType = item.getTrxType();
            if (!TextUtils.isEmpty(trxType)) {
                if (trxType.equals(NotifyConstants.NotificationReport.KEY_ORDER)) {
                    m7284c(bVar, item);
                } else if (trxType.equals("toSign") || trxType.equals("unSign")) {
                    m7285d(bVar, item, trxType);
                } else {
                    C1442a.m8289e("OrdersAdapter", "getView invalid tryType = " + trxType);
                }
            }
        }
        if (i10 >= getCount() - 1) {
            bVar.f5491B.setVisibility(8);
            bVar.f5492C.setVisibility(0);
        } else {
            bVar.f5491B.setVisibility(0);
            bVar.f5492C.setVisibility(8);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar.f5493a);
        C12806c.m76817h(this.f5484a, arrayList);
        C11842p.m70863s2(bVar.f5495c, bVar.f5494b, bVar.f5492C);
        m7282g(this.f5484a, 24, 0, bVar.f5491B);
        return view;
    }

    /* renamed from: h */
    public final void m7288h(b bVar) {
        String strM1631i = C0234s.m1631i();
        if (HNConstants.Language.CN_STANDARD.equals(strM1631i) || FeedbackConst.SDK.EMUI_LANGUAGE.equals(strM1631i)) {
            m7289j(bVar.f5500h);
            m7289j(bVar.f5502j);
            m7289j(bVar.f5505m);
            m7289j(bVar.f5508p);
            m7289j(bVar.f5511s);
            m7289j(bVar.f5513u);
            m7289j(bVar.f5515w);
            m7289j(bVar.f5518z);
        }
    }

    /* renamed from: j */
    public final void m7289j(TextView textView) {
        if (textView != null) {
            textView.setMinWidth((int) C11842p.m70844o(this.f5484a, 64));
        }
    }
}
