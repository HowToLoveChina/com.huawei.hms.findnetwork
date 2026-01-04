package com.huawei.android.hicloud.p088ui.activity;

import ae.C0157p1;
import android.app.ActionBar;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.messagecenter.manager.MessageCenterReportUtil;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$string;
import com.huawei.secure.android.common.intent.SafeIntent;
import ge.C9913h;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0234s;
import p292fn.C9733f;
import p514o9.C11842p;
import p664u0.C13108a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class MessageCenterActivity extends HMSTermsProcessBaseActivity implements View.OnClickListener {

    /* renamed from: p */
    public NotchTopFitLinearLayout f15506p;

    /* renamed from: q */
    public LinearLayout f15507q;

    /* renamed from: r */
    public LinearLayout f15508r;

    /* renamed from: s */
    public NotchFitLinearLayout f15509s;

    /* renamed from: t */
    public LinearLayout f15510t;

    /* renamed from: u */
    public TextView f15511u;

    /* renamed from: v */
    public TextView f15512v;

    /* renamed from: w */
    public TextView f15513w;

    /* renamed from: x */
    public RecyclerView f15514x;

    /* renamed from: y */
    public C0157p1 f15515y;

    /* renamed from: z */
    public C3400c f15516z = null;

    /* renamed from: A */
    public List<MessageCenterMsgObj> f15505A = new ArrayList();

    /* renamed from: com.huawei.android.hicloud.ui.activity.MessageCenterActivity$a */
    public class ViewOnClickListenerC3398a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ Intent f15517a;

        public ViewOnClickListenerC3398a(Intent intent) {
            this.f15517a = intent;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                MessageCenterActivity.this.startActivity(this.f15517a);
            } catch (Exception e10) {
                NotifyLogger.m29914e("MessageCenterActivity", "jump exception: " + e10.toString());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MessageCenterActivity$b */
    public class ViewOnClickListenerC3399b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ JSONArray f15519a;

        /* renamed from: com.huawei.android.hicloud.ui.activity.MessageCenterActivity$b$a */
        public class a implements PopupMenu.OnMenuItemClickListener {
            public a() {
            }

            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                try {
                    Intent commonGotoIntent = GeneralRedirectUtil.getCommonGotoIntent("web", ViewOnClickListenerC3399b.this.f15519a.getJSONObject(menuItem.getItemId()).getString("url"), false);
                    if (commonGotoIntent != null) {
                        commonGotoIntent.putExtra("is_support_orientation", true);
                        commonGotoIntent.putExtra("is_support_dark_mode", true);
                    }
                    MessageCenterActivity.this.startActivity(commonGotoIntent);
                } catch (JSONException e10) {
                    NotifyLogger.m29914e("MessageCenterActivity", "onMenuItemClick exception: " + e10.toString());
                }
                return false;
            }
        }

        public ViewOnClickListenerC3399b(JSONArray jSONArray) {
            this.f15519a = jSONArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws JSONException {
            PopupMenu popupMenu = new PopupMenu(MessageCenterActivity.this, view);
            int length = this.f15519a.length();
            for (int i10 = 0; i10 < length; i10++) {
                try {
                    JSONObject jSONObject = this.f15519a.getJSONObject(i10);
                    if (jSONObject == null) {
                        NotifyLogger.m29913d("MessageCenterActivity", "jsonItem is null");
                    } else {
                        String string = jSONObject.getString("title");
                        if (TextUtils.isEmpty(string)) {
                            NotifyLogger.m29914e("MessageCenterActivity", "title is null");
                        } else {
                            popupMenu.getMenu().add(0, i10, i10, string);
                        }
                    }
                } catch (JSONException e10) {
                    NotifyLogger.m29914e("MessageCenterActivity", "get item exception: " + e10.toString());
                }
            }
            popupMenu.show();
            popupMenu.setOnMenuItemClickListener(new a());
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.MessageCenterActivity$c */
    public class C3400c extends BroadcastReceiver {
        public C3400c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.huawei.hicloud.action.ACTION_MESSAGE_NUM_CHANGED".equals(new SafeIntent(intent).getAction())) {
                NotifyLogger.m29915i("MessageCenterActivity", "receive message changed");
                MessageCenterActivity.this.m21574W1();
            }
        }

        public /* synthetic */ C3400c(MessageCenterActivity messageCenterActivity, ViewOnClickListenerC3398a viewOnClickListenerC3398a) {
            this();
        }
    }

    /* renamed from: N1 */
    private void m21565N1() throws JSONException {
        String strM1634l = C0234s.m1634l();
        NotifyLogger.m29915i("MessageCenterActivity", "initBottomTab, current language is: " + strM1634l);
        if (!"zh-hans-cn".equalsIgnoreCase(strM1634l)) {
            NotifyLogger.m29914e("MessageCenterActivity", "system language code not zh-hans-cn");
            return;
        }
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            NotifyLogger.m29914e("MessageCenterActivity", "sysParamMap is null");
            return;
        }
        String msgCentryMenu = hiCloudSysParamMapM60757p.getMsgCentryMenu();
        if (TextUtils.isEmpty(msgCentryMenu)) {
            NotifyLogger.m29914e("MessageCenterActivity", "no menuStr config");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(msgCentryMenu);
            JSONObject jSONObject2 = jSONObject.getJSONObject("tab1");
            JSONObject jSONObject3 = jSONObject.getJSONObject("tab2");
            JSONObject jSONObject4 = jSONObject.getJSONObject("tab3");
            boolean zM21569Q1 = m21569Q1(jSONObject2, this.f15511u);
            boolean zM21569Q12 = m21569Q1(jSONObject3, this.f15512v);
            boolean zM21569Q13 = m21569Q1(jSONObject4, this.f15513w);
            if (zM21569Q1 && zM21569Q12 && zM21569Q13) {
                this.f15510t.setVisibility(0);
            } else {
                this.f15510t.setVisibility(8);
            }
        } catch (JSONException e10) {
            NotifyLogger.m29914e("MessageCenterActivity", "parse menu str exception, e: " + e10.toString());
        }
    }

    /* renamed from: R1 */
    private void m21566R1() throws IllegalAccessException, JSONException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f15506p = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.layout_main);
        this.f15507q = (LinearLayout) C12809f.m76829b(this, R$id.layout_no_message);
        this.f15508r = (LinearLayout) C12809f.m76829b(this, R$id.layout_no_message_wrap);
        this.f15509s = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.layout_message);
        this.f15514x = (RecyclerView) C12809f.m76829b(this, R$id.message_recycle_view);
        this.f15515y = new C0157p1(this, this.f15505A);
        this.f15514x.setLayoutManager(new LinearLayoutManager(this));
        this.f15514x.setAdapter(this.f15515y);
        this.f15510t = (LinearLayout) C12809f.m76829b(this, R$id.bottom_tab_layout);
        this.f15511u = (TextView) C12809f.m76829b(this, R$id.bottom_tab1);
        this.f15512v = (TextView) C12809f.m76829b(this, R$id.bottom_tab2);
        this.f15513w = (TextView) C12809f.m76829b(this, R$id.bottom_tab3);
        mo13327n1();
        mo19005p1();
        m21565N1();
        m21570S1();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* renamed from: O1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m21567O1(org.json.JSONObject r7, android.widget.TextView r8) throws org.json.JSONException {
        /*
            r6 = this;
            java.lang.String r0 = "MessageCenterActivity"
            java.lang.String r1 = ""
            r2 = 0
            java.lang.String r3 = "goto"
            org.json.JSONObject r2 = r7.getJSONObject(r3)     // Catch: org.json.JSONException -> L1a
            java.lang.String r7 = "type"
            java.lang.String r7 = r2.getString(r7)     // Catch: org.json.JSONException -> L1a
            java.lang.String r3 = "url"
            java.lang.String r1 = r2.getString(r3)     // Catch: org.json.JSONException -> L18
            goto L34
        L18:
            r3 = move-exception
            goto L1c
        L1a:
            r3 = move-exception
            r7 = r1
        L1c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "get goto exception: "
            r4.append(r5)
            java.lang.String r3 = r3.toString()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r0, r3)
        L34:
            r3 = 0
            if (r2 != 0) goto L3d
            java.lang.String r6 = "jumpJson is null"
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r0, r6)
            return r3
        L3d:
            android.content.Intent r7 = com.huawei.hicloud.notification.util.GeneralRedirectUtil.getCommonGotoIntent(r7, r1, r3)
            if (r7 != 0) goto L49
            java.lang.String r6 = "jumpIntent is null"
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r0, r6)
            return r3
        L49:
            java.lang.String r0 = "is_support_orientation"
            r1 = 1
            r7.putExtra(r0, r1)
            java.lang.String r0 = "is_support_dark_mode"
            r7.putExtra(r0, r1)
            com.huawei.android.hicloud.ui.activity.MessageCenterActivity$a r0 = new com.huawei.android.hicloud.ui.activity.MessageCenterActivity$a
            r0.<init>(r7)
            r8.setOnClickListener(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.MessageCenterActivity.m21567O1(org.json.JSONObject, android.widget.TextView):boolean");
    }

    /* renamed from: P1 */
    public final boolean m21568P1(JSONObject jSONObject, TextView textView) throws JSONException {
        JSONArray jSONArray;
        try {
            jSONArray = jSONObject.getJSONArray("menuList");
        } catch (JSONException e10) {
            NotifyLogger.m29914e("MessageCenterActivity", "get goto exception: " + e10.toString());
            jSONArray = null;
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            NotifyLogger.m29914e("MessageCenterActivity", "menuListArr is null");
            return false;
        }
        textView.setOnClickListener(new ViewOnClickListenerC3399b(jSONArray));
        return true;
    }

    /* renamed from: Q1 */
    public final boolean m21569Q1(JSONObject jSONObject, TextView textView) throws JSONException {
        String string;
        if (jSONObject == null) {
            NotifyLogger.m29914e("MessageCenterActivity", "no json obj, return");
            return false;
        }
        if (this.f15511u == null) {
            NotifyLogger.m29914e("MessageCenterActivity", "tab1Textview is null, return");
            return false;
        }
        try {
            string = jSONObject.getString("title");
        } catch (JSONException e10) {
            NotifyLogger.m29914e("MessageCenterActivity", "get title exception: " + e10.toString());
            string = "";
        }
        if (TextUtils.isEmpty(string)) {
            NotifyLogger.m29914e("MessageCenterActivity", "title string is null");
            return false;
        }
        textView.setText(string);
        boolean zHas = jSONObject.has("menuList");
        if (jSONObject.has("goto")) {
            return m21567O1(jSONObject, textView);
        }
        if (zHas) {
            return m21568P1(jSONObject, textView);
        }
        return false;
    }

    /* renamed from: S1 */
    public final void m21570S1() {
        if (this.f15507q != null) {
            C11842p.m70763R1(this, this.f15507q, C11842p.m70731H(this, (int) C11842p.m70844o(this, 120)));
        }
    }

    /* renamed from: T1 */
    public final void m21571T1() {
        NotifyLogger.m29914e("MessageCenterActivity", "onSettingClicked");
        try {
            startActivity(new Intent(this, (Class<?>) MsgSettingActivity.class));
        } catch (Exception e10) {
            NotifyLogger.m29914e("MessageCenterActivity", "onSettingClicked start activity exception: " + e10.toString());
        }
    }

    /* renamed from: U1 */
    public final void m21572U1() {
        NotifyLogger.m29915i("MessageCenterActivity", "registerBroadcast");
        this.f15516z = new C3400c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.action.ACTION_MESSAGE_NUM_CHANGED");
        C13108a.m78878b(getApplicationContext()).m78880c(this.f15516z, intentFilter);
    }

    /* renamed from: V1 */
    public final void m21573V1() {
        NotifyLogger.m29915i("MessageCenterActivity", "unRegisterBroadcast");
        if (this.f15516z != null) {
            C13108a.m78878b(this).m78883f(this.f15516z);
        }
    }

    /* renamed from: W1 */
    public final void m21574W1() {
        NotifyLogger.m29915i("MessageCenterActivity", "updateData");
        List<MessageCenterMsgObj> allMessages = MessageCenterManager.getInstance().getAllMessages();
        this.f15505A = allMessages;
        if (allMessages == null || allMessages.isEmpty()) {
            this.f15508r.setVisibility(0);
            this.f15514x.setVisibility(8);
        } else {
            this.f15508r.setVisibility(8);
            this.f15514x.setVisibility(0);
            this.f15515y.m889R(this.f15505A);
            this.f15515y.m5213j();
        }
        MessageCenterReportUtil.reportMsgShow(this.f15505A);
        MessageCenterManager.getInstance().setAllMsgAsRead();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15506p);
        arrayList.add(this.f15509s);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: n1 */
    public void mo13327n1() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.mo13327n1();
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            return;
        }
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        View viewInflate = getLayoutInflater().inflate(R$layout.actionbar_message_center, (ViewGroup) null);
        ((TextView) C12809f.m76831d(viewInflate, R$id.title)).setText(R$string.message_title);
        ImageView imageView = (ImageView) C12809f.m76831d(viewInflate, R$id.ic_back_img);
        imageView.setOnClickListener(this);
        imageView.setContentDescription(getString(R$string.talkback_upward_navigation));
        ((RelativeLayout) C12809f.m76831d(viewInflate, R$id.ic_setting_hot_space)).setOnClickListener(this);
        actionBar.setCustomView(viewInflate, new ActionBar.LayoutParams(-1, -1));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (R$id.ic_back_img == id2) {
            onBackPressed();
        } else if (R$id.ic_setting_hot_space == id2) {
            m21571T1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mo19005p1();
        m21570S1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, JSONException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.activity_message_center);
        m21572U1();
        m21566R1();
        m21574W1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        m21573V1();
        C9913h.m61574q().m61577D();
        super.onDestroy();
    }
}
