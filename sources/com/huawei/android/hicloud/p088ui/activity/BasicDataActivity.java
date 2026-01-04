package com.huawei.android.hicloud.p088ui.activity;

import ae.C0153o0;
import android.app.ActionBar;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.uikit.hwalphaindexerlistview.widget.HwAlphaIndexerListView;
import com.huawei.uikit.phone.hwalphaindexerlistview.widget.HwAlphaIndexerListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11839m;
import p514o9.C11842p;
import p618rm.C12547e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BasicDataActivity extends CloudBackupBaseUiActivity {

    /* renamed from: C */
    public HwAlphaIndexerListView f13859C;

    /* renamed from: D */
    public TextView f13860D;

    /* renamed from: E */
    public NotchFitLinearLayout f13861E;

    /* renamed from: F */
    public List<AppDetailsInfo> f13862F;

    /* renamed from: G */
    public ListView f13863G;

    /* renamed from: H */
    public C0153o0 f13864H;

    /* renamed from: I */
    public TextView f13865I;

    /* renamed from: J */
    public AutoSizeButton f13866J;

    /* renamed from: K */
    public final Handler f13867K = new Handler(new C3166a());

    /* renamed from: L */
    public final Handler.Callback f13868L = new Handler.Callback() { // from class: com.huawei.android.hicloud.ui.activity.u1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f17752a.m19201f2(message);
        }
    };

    /* renamed from: com.huawei.android.hicloud.ui.activity.BasicDataActivity$a */
    public class C3166a implements Handler.Callback {
        public C3166a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws Resources.NotFoundException {
            C11839m.m70688i("BasicDataActivity", "msg " + message.what);
            int i10 = message.what;
            if (i10 == 330001) {
                BasicDataActivity.this.mo19236O1();
                BasicDataActivity basicDataActivity = BasicDataActivity.this;
                if (basicDataActivity.f13863G == null || basicDataActivity.f13859C == null) {
                    C11839m.m70687e("BasicDataActivity", "CALLBACK_ALPHA_VIEW，view is null");
                    return false;
                }
                Object obj = message.obj;
                if (obj instanceof List) {
                    BasicDataActivity.this.m19211l2();
                    BasicDataActivity.this.f13864H.m862s((List) obj);
                }
            } else if (i10 == 330000) {
                Object obj2 = message.obj;
                if (obj2 instanceof List) {
                    BasicDataActivity.this.mo18868n2((List) obj2);
                }
            }
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BasicDataActivity$b */
    public class C3167b implements AbsListView.OnScrollListener {
        public C3167b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) throws Resources.NotFoundException {
            String[] strArrM19202Z1 = BasicDataActivity.this.m19202Z1();
            BasicDataActivity basicDataActivity = BasicDataActivity.this;
            if (basicDataActivity.f13864H == null || strArrM19202Z1 == null || strArrM19202Z1.length == 0) {
                C11839m.m70687e("BasicDataActivity", "onScroll: adapter is null");
                return;
            }
            basicDataActivity.f13859C.invalidate();
            int iM857m = BasicDataActivity.this.f13864H.m857m(i10);
            if (iM857m == -1 || iM857m >= strArrM19202Z1.length) {
                C11839m.m70687e("BasicDataActivity", "sectionPos is -1");
            } else {
                BasicDataActivity.this.f13859C.setOverLayInfo((String) BasicDataActivity.this.f13864H.m859o()[iM857m]);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            BasicDataActivity basicDataActivity;
            ListView listView;
            C0153o0 c0153o0 = BasicDataActivity.this.f13864H;
            if (c0153o0 == null || c0153o0.m859o() == null || (listView = (basicDataActivity = BasicDataActivity.this).f13863G) == null) {
                C11839m.m70687e("BasicDataActivity", "onScrollStateChanged: adapter is null");
            } else if (i10 == 0) {
                basicDataActivity.f13859C.dismissPopup();
            } else {
                if (i10 != 1) {
                    return;
                }
                listView.clearFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f2 */
    public /* synthetic */ boolean m19201f2(Message message) {
        if (message.what != 33001) {
            return false;
        }
        m19207h2((String) message.obj);
        return false;
    }

    /* renamed from: Z1 */
    public final String[] m19202Z1() {
        try {
            return (String[]) this.f13864H.m859o();
        } catch (ClassCastException e10) {
            C11839m.m70687e("BasicDataActivity", "getSections ClassCastException: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: a2 */
    public void mo18866a2() {
        List<AppDetailsInfo> listM75498f = C12547e.m75495e().m75498f();
        if (listM75498f == null) {
            C11839m.m70687e("BasicDataActivity", "initData: sysItem data is null");
            return;
        }
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R$string.all_basic_data));
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 330000;
        messageObtain.obj = listM75498f;
        this.f13867K.sendMessageDelayed(messageObtain, 50L);
    }

    /* renamed from: b2 */
    public void mo18867b2() {
        LayoutInflater.from(this).inflate(R$layout.activity_basic_data, (ViewGroup) this.f13894y, true);
        this.f13861E = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.detail_layout);
        this.f13859C = (HwAlphaIndexerListView) C12809f.m76829b(this, R$id.app_record_letters);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.basic_data_length);
        this.f13860D = textView;
        C11842p.m70721D1(textView, 1.45f);
        this.f13863G = (ListView) C12809f.m76829b(this, R$id.list_view);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.basic_data_desc);
        this.f13865I = textView2;
        C11842p.m70721D1(textView2, 1.45f);
        this.f13866J = (AutoSizeButton) C12809f.m76829b(this, R$id.ok_btn);
        m19209j2();
        this.f13866J.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.v1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17769a.m19204d2(view);
            }
        });
    }

    /* renamed from: c2 */
    public final void m19203c2() {
        List<AppDetailsInfo> list = this.f13862F;
        if (list == null || list.isEmpty()) {
            C11839m.m70687e("BasicDataActivity", "isShowAlphaIndexListView: recordItem data is null");
        } else {
            this.f13863G.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.android.hicloud.ui.activity.w1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    this.f17784a.m19205e2();
                }
            });
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13885p);
        arrayList.add(this.f13861E);
        return arrayList;
    }

    /* renamed from: d2 */
    public final /* synthetic */ void m19204d2(View view) {
        finish();
    }

    /* renamed from: e2 */
    public final /* synthetic */ void m19205e2() {
        if (this.f13862F.size() > (this.f13863G.getLastVisiblePosition() - this.f13863G.getFirstVisiblePosition()) + 1) {
            this.f13859C.setVisibility(0);
        } else {
            this.f13859C.setVisibility(8);
        }
    }

    /* renamed from: g2 */
    public final /* synthetic */ void m19206g2(ListView listView, String str, int i10) throws Resources.NotFoundException {
        String str2;
        if (str != null) {
            String[] strArrM19202Z1 = m19202Z1();
            if (strArrM19202Z1 == null || strArrM19202Z1.length == 0 || listView.getCount() == 0) {
                C11839m.m70687e("BasicDataActivity", "setAlphaIndexerListViewOnListen sections is null");
                return;
            }
            int i11 = 0;
            while (true) {
                if (i11 >= strArrM19202Z1.length) {
                    str2 = null;
                    i11 = i10;
                    break;
                } else {
                    if (this.f13859C.equalsChar(str, strArrM19202Z1[i11], i10)) {
                        str2 = strArrM19202Z1[i11];
                        break;
                    }
                    i11++;
                }
            }
            if (str2 == null) {
                if (this.f13859C.needSwitchIndexer(i10)) {
                    if (this.f13859C.isNativeIndexerShow()) {
                        listView.setSelection(listView.getCount() - 1);
                    } else {
                        listView.setSelection(0);
                    }
                }
                m19212m2(i10, listView);
                return;
            }
            this.f13859C.showPopup(str2);
            int iM856l = this.f13864H.m856l(i11);
            if (iM856l >= 0 && iM856l < listView.getCount()) {
                listView.setSelection(iM856l);
            }
            int lastVisiblePosition = (listView.getLastVisiblePosition() - listView.getFirstVisiblePosition()) + 1;
            if (iM856l + lastVisiblePosition > this.f13864H.getCount()) {
                str2 = (String) this.f13864H.m858n(listView.getCount() - lastVisiblePosition);
            }
            this.f13859C.setOverLayInfo(i10, str2);
        }
    }

    /* renamed from: h2 */
    public void m19207h2(String str) {
        List<AppDetailsInfo> list;
        if (str == null || (list = this.f13862F) == null) {
            C11839m.m70687e("BasicDataActivity", "refreshItemIcon appId or recordItem is null");
            return;
        }
        Iterator<AppDetailsInfo> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (str.equals(it.next().getBackupAppName())) {
                m19213o2(i10);
                return;
            }
            i10++;
        }
    }

    /* renamed from: i2 */
    public final void m19208i2(final ListView listView) {
        this.f13859C.setOnItemClickListener(new HwAlphaIndexerListView.OnItemClickListener() { // from class: com.huawei.android.hicloud.ui.activity.x1
            @Override // com.huawei.uikit.hwalphaindexerlistview.widget.HwAlphaIndexerListView.OnItemClickListener
            public final void onItemClick(String str, int i10) throws Resources.NotFoundException {
                this.f17796a.m19206g2(listView, str, i10);
            }
        });
    }

    /* renamed from: j2 */
    public final void m19209j2() {
        float fM1195O = C0209d.m1195O(this);
        if (!C11842p.m70753O0(this) || fM1195O < 1.75f) {
            AutoSizeButton autoSizeButton = this.f13866J;
            if (autoSizeButton == null) {
                return;
            }
            autoSizeButton.setAutoTextSize(2, 16.0f);
            return;
        }
        AutoSizeButton autoSizeButton2 = this.f13866J;
        if (autoSizeButton2 == null) {
            return;
        }
        autoSizeButton2.setAutoTextSize(0, C11842p.m70840n(this, 16));
    }

    /* renamed from: k2 */
    public final void m19210k2(ListView listView) {
        listView.setOnScrollListener(new C3167b());
    }

    /* renamed from: l2 */
    public void m19211l2() throws Resources.NotFoundException {
        this.f13863G.setFastScrollEnabled(false);
        this.f13863G.setVerticalScrollBarEnabled(false);
        this.f13859C.setListViewAttachTo(this.f13863G);
        this.f13859C.setOverLayInfo((String) this.f13864H.m859o()[this.f13864H.m857m(this.f13863G.getFirstVisiblePosition())]);
        m19210k2(this.f13863G);
        m19208i2(this.f13863G);
    }

    /* renamed from: m2 */
    public final void m19212m2(int i10, ListView listView) throws Resources.NotFoundException {
        C11839m.m70688i("BasicDataActivity", "setOverLayInfoWhenNoMatchItem");
        this.f13859C.setOverLayInfo(i10, (String) this.f13864H.m858n(listView.getFirstVisiblePosition()));
    }

    /* renamed from: n2 */
    public void mo18868n2(List<AppDetailsInfo> list) throws Resources.NotFoundException {
        this.f13862F = list;
        if (list == null || list.isEmpty()) {
            C11839m.m70687e("BasicDataActivity", "showDetailList: recordItem data is null");
            return;
        }
        mo19236O1();
        this.f13886q.setVisibility(8);
        this.f13861E.setVisibility(0);
        C0153o0 c0153o0 = new C0153o0(this, this.f13867K, this.f13862F);
        this.f13864H = c0153o0;
        this.f13863G.setAdapter((ListAdapter) c0153o0);
        this.f13860D.setText(getResources().getQuantityString(R$plurals.backup_basic_data_count_tips_new, this.f13862F.size(), Integer.valueOf(this.f13862F.size())));
    }

    /* renamed from: o2 */
    public final void m19213o2(int i10) {
        ListView listView = this.f13863G;
        if (listView == null || this.f13864H == null) {
            C11839m.m70687e("BasicDataActivity", "updateView listView is null");
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int lastVisiblePosition = this.f13863G.getLastVisiblePosition();
        if (i10 < firstVisiblePosition || i10 > lastVisiblePosition) {
            return;
        }
        C11839m.m70688i("BasicDataActivity", "updateView refresh view, position = " + i10);
        this.f13864H.m864u(this.f13863G.getChildAt(i10 - firstVisiblePosition), i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m19209j2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo18867b2();
        mo19005p1();
        mo18866a2();
        mo22385x1();
        m19203c2();
        CBCallBack.getInstance().registerCallback(this.f13868L);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CBCallBack.getInstance().unregisterCallback(this.f13868L);
    }
}
