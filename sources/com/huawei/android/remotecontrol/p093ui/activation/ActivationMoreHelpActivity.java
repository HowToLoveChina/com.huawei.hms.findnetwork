package com.huawei.android.remotecontrol.p093ui.activation;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.huawei.android.remotecontrol.p093ui.activation.RemoteActivationUtil;
import com.huawei.android.remotecontrol.p093ui.widget.ExplandItem;
import com.huawei.android.remotecontrol.p093ui.widget.ListItemPatterm;
import com.huawei.android.remotecontrol.p093ui.widget.SpanClickText;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.HashMap;
import p809yg.C13981a;
import sk.C12809f;

/* loaded from: classes4.dex */
public class ActivationMoreHelpActivity extends ActivationBaseActivity {

    /* renamed from: S */
    public static final String f20580S = "ActivationMoreHelpActivity";

    /* renamed from: H */
    public TextView f20581H;

    /* renamed from: I */
    public ListItemPatterm f20582I;

    /* renamed from: J */
    public ListItemPatterm f20583J;

    /* renamed from: K */
    public ListItemPatterm f20584K;

    /* renamed from: L */
    public ExplandItem f20585L;

    /* renamed from: M */
    public ExplandItem f20586M;

    /* renamed from: N */
    public ExplandItem f20587N;

    /* renamed from: O */
    public C4485b f20588O;

    /* renamed from: P */
    public SpanClickText f20589P;

    /* renamed from: Q */
    public String f20590Q = null;

    /* renamed from: R */
    public RemoteActivationUtil.InterfaceC4525c f20591R = new C4484a();

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationMoreHelpActivity$a */
    public class C4484a implements RemoteActivationUtil.InterfaceC4525c {
        public C4484a() {
        }

        @Override // com.huawei.android.remotecontrol.p093ui.activation.RemoteActivationUtil.InterfaceC4525c
        public void onFinish() {
            ActivationMoreHelpActivity.this.mo27259Y0(true);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationMoreHelpActivity$b */
    public static class C4485b implements SpanClickText.ISpanClickListem {

        /* renamed from: a */
        public WeakReference<ActivationMoreHelpActivity> f20593a;

        public C4485b(ActivationMoreHelpActivity activationMoreHelpActivity) {
            this.f20593a = new WeakReference<>(activationMoreHelpActivity);
        }

        @Override // com.huawei.android.remotecontrol.ui.widget.SpanClickText.ISpanClickListem
        public void onClick(int i10) {
            ActivationMoreHelpActivity activationMoreHelpActivity = this.f20593a.get();
            C13981a.m83987d(ActivationMoreHelpActivity.f20580S, "SpanClickListem--onClick:activity=" + activationMoreHelpActivity);
            if (activationMoreHelpActivity == null) {
                return;
            }
            activationMoreHelpActivity.m27308k1();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() throws Resources.NotFoundException {
        super.mo16559G();
        this.f20588O = new C4485b(this);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        int i10 = R$id.activation_appeal;
        TextView textView = (TextView) C12809f.m76829b(this, i10);
        this.f20581H = textView;
        textView.setOnClickListener(this);
        this.f20585L = (ExplandItem) C12809f.m76829b(this, R$id.activaton_more_help_1_contain);
        this.f20586M = (ExplandItem) C12809f.m76829b(this, R$id.activaton_more_help_2_contain);
        this.f20587N = (ExplandItem) C12809f.m76829b(this, R$id.activaton_more_help_3_contain);
        ListItemPatterm listItemPatterm = (ListItemPatterm) C12809f.m76829b(this, R$id.activaton_more_help_1);
        this.f20582I = listItemPatterm;
        if (listItemPatterm != null) {
            listItemPatterm.setText(NumberFormat.getNumberInstance().format(1L) + ". " + getResources().getString(R$string.more_help_1));
            this.f20582I.setOnClickListener(this);
        }
        ListItemPatterm listItemPatterm2 = (ListItemPatterm) C12809f.m76829b(this, R$id.activaton_more_help_2);
        this.f20583J = listItemPatterm2;
        if (listItemPatterm2 != null) {
            listItemPatterm2.setText(NumberFormat.getNumberInstance().format(2L) + ". " + getResources().getString(R$string.more_help_2));
            this.f20583J.setOnClickListener(this);
        }
        ListItemPatterm listItemPatterm3 = (ListItemPatterm) C12809f.m76829b(this, R$id.activaton_more_help_3);
        this.f20584K = listItemPatterm3;
        if (listItemPatterm3 != null) {
            listItemPatterm3.setText(NumberFormat.getNumberInstance().format(3L) + ". " + getResources().getString(R$string.more_help_3_90));
            this.f20584K.setOnClickListener(this);
        }
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.actionvation_morehelp_3_content_3);
        if (textView2 != null) {
            textView2.setText(getString(R$string.more_help_3_content_3, 1));
        }
        TextView textView3 = (TextView) C12809f.m76829b(this, R$id.actionvation_morehelp_3_content_4);
        if (textView3 != null) {
            textView3.setText(getString(R$string.more_help_3_content_4_90, 2));
        }
        TextView textView4 = (TextView) C12809f.m76829b(this, R$id.actionvation_morehelp_3_content_6);
        if (textView4 != null) {
            textView4.setText(getString(R$string.more_help_3_content_6, 4));
        }
        TextView textView5 = (TextView) C12809f.m76829b(this, R$id.actionvation_morehelp_3_content_5);
        ImageSpan imageSpan = new ImageSpan(this, R$drawable.activation_ic_minus);
        int i11 = R$string.more_help_3_content_5;
        int iLastIndexOf = getString(i11, NumberFormat.getNumberInstance().format(3L), "spanimage").lastIndexOf("spanimage");
        SpannableString spannableString = new SpannableString(getString(i11, NumberFormat.getNumberInstance().format(3L), "spanimage"));
        spannableString.setSpan(imageSpan, iLastIndexOf, iLastIndexOf + 9, 33);
        if (textView5 != null) {
            textView5.setText(spannableString);
            textView5.setGravity(16);
        }
        this.f20589P = (SpanClickText) C12809f.m76829b(this, i10);
        String string = getString(R$string.appeal_activation);
        String string2 = getString(R$string.more_help_4_new, string);
        HashMap map = new HashMap();
        map.put(0, string);
        this.f20589P.initText(string2, this.f20588O, map);
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity
    /* renamed from: R0 */
    public String mo27240R0() {
        return getResources().getString(R$string.more_help);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        return R$layout.activation_more_help;
    }

    /* renamed from: k1 */
    public final void m27308k1() {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) ActivationAppealActivity.class);
        intent.putExtra("hw_frp_token", this.f20590Q);
        startActivity(intent);
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (R$id.activaton_more_help_1 == view.getId()) {
            this.f20585L.onExplandExchange();
        } else if (R$id.activaton_more_help_2 == view.getId()) {
            this.f20586M.onExplandExchange();
        } else if (R$id.activaton_more_help_3 == view.getId()) {
            this.f20587N.onExplandExchange();
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        RemoteActivationUtil.m27647r().m27656n(this.f20591R);
        this.f20590Q = new HiCloudSafeIntent(getIntent()).getStringExtra("hw_frp_token");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onDestroy() {
        RemoteActivationUtil.m27647r().m27650C(this.f20591R);
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
