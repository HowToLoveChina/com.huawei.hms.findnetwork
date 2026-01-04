package com.huawei.android.p069cg.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.user.model.RisksRecord;
import com.huawei.hicloud.base.drive.user.model.RisksRecordList;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0224k0;
import p031b7.C1120a;
import p514o9.C11829c;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.C12515a;
import p834z6.C14142b;
import sk.C12809f;

/* loaded from: classes2.dex */
public class AppealRecordActivity extends UIActivity implements C14142b.b, View.OnClickListener {

    /* renamed from: A */
    public Handler f10000A = new HandlerC2182b();

    /* renamed from: p */
    public NotchTopFitRelativeLayout f10001p;

    /* renamed from: q */
    public NotchFitRelativeLayout f10002q;

    /* renamed from: r */
    public LinearLayout f10003r;

    /* renamed from: s */
    public LinearLayout f10004s;

    /* renamed from: t */
    public HwRecyclerView f10005t;

    /* renamed from: u */
    public TextView f10006u;

    /* renamed from: v */
    public C14142b f10007v;

    /* renamed from: w */
    public NetworkChangeReceiver f10008w;

    /* renamed from: x */
    public AutoSizeButton f10009x;

    /* renamed from: y */
    public ImageView f10010y;

    /* renamed from: z */
    public TextView f10011z;

    public class NetworkChangeReceiver extends BroadcastReceiver {
        public NetworkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || context == null) {
                C1120a.m6677i("AppealRecordActivity", "NetworkChangeReceiver return");
                return;
            }
            String action = new SafeIntent(intent).getAction();
            C1120a.m6677i("AppealRecordActivity", "NetworkChangeReceiver action =" + action);
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                boolean zM1333z1 = C0209d.m1333z1(context);
                C1120a.m6677i("AppealRecordActivity", "NetworkChangeReceiver isNetWorkConnected " + zM1333z1);
                if (zM1333z1) {
                    AppealRecordActivity.this.m13382R1();
                    return;
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 1105;
                AppealRecordActivity.this.f10000A.sendMessage(messageObtain);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.AppealRecordActivity$a */
    public class C2181a extends AbstractC12367d {
        public C2181a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                RisksRecordList risksRecordListM74755i = C12469b.m74746l().m74755i();
                Message messageObtain = Message.obtain();
                if (risksRecordListM74755i != null) {
                    messageObtain.what = 1102;
                    messageObtain.obj = risksRecordListM74755i;
                } else {
                    messageObtain.what = 1104;
                }
                AppealRecordActivity.this.f10000A.sendMessage(messageObtain);
            } catch (C4616s e10) {
                C1120a.m6676e("AppealRecordActivity", "e " + e10.getMessage());
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 1103;
                messageObtain2.obj = e10;
                AppealRecordActivity.this.f10000A.sendMessage(messageObtain2);
            } catch (Exception e11) {
                C1120a.m6676e("AppealRecordActivity", "error " + e11.getMessage());
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = 1104;
                AppealRecordActivity.this.f10000A.sendMessage(messageObtain3);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.AppealRecordActivity$b */
    public class HandlerC2182b extends Handler {
        public HandlerC2182b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" handle msg.what ");
            sb2.append(message != null ? Integer.valueOf(message.what) : "msg is null");
            C1120a.m6675d("AppealRecordActivity", sb2.toString());
            int i10 = message.what;
            if (i10 == 1102) {
                RisksRecordList risksRecordList = (RisksRecordList) message.obj;
                if (risksRecordList == null || risksRecordList.getAppeals() == null || risksRecordList.getAppeals().size() <= 0) {
                    AppealRecordActivity.this.m13387Y1();
                    return;
                } else {
                    AppealRecordActivity.this.m13386X1(risksRecordList.getAppeals());
                    return;
                }
            }
            if (i10 == 1103) {
                AppealRecordActivity.this.m13389a2();
                C4616s c4616s = (C4616s) message.obj;
                if (c4616s != null) {
                    C12091d.m72280a0().m72307G0(c4616s, this);
                    return;
                }
                return;
            }
            if (i10 == 1104) {
                AppealRecordActivity.this.m13389a2();
            } else if (i10 == 1105) {
                AppealRecordActivity.this.m13388Z1();
            } else {
                C12091d.m72280a0().m72361j1(AppealRecordActivity.this, message.what, "");
            }
        }
    }

    /* renamed from: S1 */
    private void m13380S1() throws Resources.NotFoundException {
        m13383T1();
        m22365E1(R$string.appeal_record);
        this.f10006u.setText(getResources().getQuantityString(R$plurals.show_appeal_record_tips, 6, 6));
        mo19005p1();
        mo19982C1();
        if (C0209d.m1333z1(this)) {
            m13382R1();
        } else {
            m13388Z1();
        }
    }

    /* renamed from: U1 */
    private void m13381U1() {
        this.f10001p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10002q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_all);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.raly_empty_view);
        this.f10003r = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f10004s = (LinearLayout) C12809f.m76829b(this, R$id.llay_record_container);
        this.f10006u = (TextView) C12809f.m76829b(this, R$id.tv_show_record_tips);
        this.f10005t = (HwRecyclerView) C12809f.m76829b(this, R$id.rv_appeal_record);
        this.f10005t.setLayoutManager(new LinearLayoutManager(this));
        C14142b c14142b = new C14142b(this, this);
        this.f10007v = c14142b;
        this.f10005t.setAdapter(c14142b);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f10009x = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        this.f10010y = (ImageView) C12809f.m76829b(this, R$id.iv_error_status);
        this.f10011z = (TextView) C12809f.m76829b(this, R$id.tv_error_desc);
    }

    /* renamed from: R1 */
    public final void m13382R1() {
        C12515a.m75110o().m75172d(new C2181a());
    }

    /* renamed from: T1 */
    public final void m13383T1() {
        C1120a.m6677i("AppealRecordActivity", "initNetworkChangeReceiver");
        if (this.f10008w == null) {
            this.f10008w = new NetworkChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f10008w, intentFilter);
        }
    }

    /* renamed from: V1 */
    public final boolean m13384V1() {
        LinearLayout linearLayout = this.f10004s;
        if (linearLayout == null || this.f10011z == null) {
            C1120a.m6676e("AppealRecordActivity", "recordLayout or errorDesc is null ");
            return false;
        }
        if (linearLayout.getVisibility() != 0) {
            return false;
        }
        return getString(R$string.connect_server_fail_msg1).equals(this.f10011z.getText().toString());
    }

    /* renamed from: W1 */
    public final void m13385W1(RisksRecord risksRecord) {
        if (risksRecord == null) {
            C1120a.m6676e("AppealRecordActivity", "jumpToDetail record is null");
            return;
        }
        try {
            Intent intent = new Intent(this, (Class<?>) AppealDetailActivity.class);
            intent.putExtra("appeal_reason", risksRecord.getReason());
            intent.putExtra("appeal_file", risksRecord.getFileName());
            intent.putExtra("appeal_time", risksRecord.getCreatedTime());
            intent.putExtra("appeal_done_time", risksRecord.getDoneTime());
            intent.putExtra("appeal_edit_time", risksRecord.getEditedTime());
            intent.putExtra("appeal_done_status", risksRecord.getState());
            intent.putExtra("appeal_type", risksRecord.getType());
            C0224k0.m1542L(this, intent);
        } catch (Exception e10) {
            C1120a.m6676e("AppealRecordActivity", "e " + e10.getMessage());
        }
    }

    /* renamed from: X1 */
    public final void m13386X1(List<RisksRecord> list) {
        this.f10004s.setVisibility(0);
        this.f10003r.setVisibility(8);
        this.f10007v.m84909F(list);
        this.f10007v.m5213j();
    }

    /* renamed from: Y1 */
    public final void m13387Y1() {
        C1120a.m6677i("AppealRecordActivity", "showEmptyView");
        this.f10004s.setVisibility(8);
        this.f10003r.setVisibility(0);
        this.f10010y.setImageDrawable(getDrawable(R$drawable.ic_no_record));
        this.f10011z.setText(getString(R$string.no_appeal_record));
    }

    /* renamed from: Z1 */
    public final void m13388Z1() {
        C1120a.m6677i("AppealRecordActivity", "showNetUnAvailableView");
        this.f10004s.setVisibility(8);
        this.f10009x.setVisibility(0);
        this.f10003r.setVisibility(0);
        this.f10010y.setImageDrawable(getDrawable(R$drawable.pay_ic_no_wifi_disable));
        this.f10011z.setText(getString(R$string.network_unavailable));
    }

    /* renamed from: a2 */
    public final void m13389a2() {
        C1120a.m6677i("AppealRecordActivity", "showServerErrorView");
        this.f10004s.setVisibility(8);
        this.f10009x.setVisibility(8);
        this.f10003r.setVisibility(0);
        this.f10010y.setImageDrawable(getDrawable(R$drawable.pay_ic_no_wifi_disable));
        this.f10011z.setText(getString(R$string.connect_server_fail_msg1));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10001p);
        arrayList.add(this.f10002q);
        return arrayList;
    }

    @Override // p834z6.C14142b.b
    /* renamed from: o0 */
    public void mo13390o0(RisksRecord risksRecord) {
        if (C0209d.m1226Y0()) {
            C1120a.m6675d("AppealRecordActivity", "onClickRecord do not fast click");
        } else {
            m13385W1(risksRecord);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C1120a.m6678w("AppealRecordActivity", "do not fast click");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.set_no_net_btn) {
            C11829c.m70612r1(this);
        } else if (id2 == R$id.raly_empty_view && m13384V1()) {
            m13382R1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R$layout.layout_appeal_record);
        m13381U1();
        m13380S1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        NetworkChangeReceiver networkChangeReceiver = this.f10008w;
        if (networkChangeReceiver != null) {
            unregisterReceiver(networkChangeReceiver);
            this.f10008w = null;
        }
    }
}
