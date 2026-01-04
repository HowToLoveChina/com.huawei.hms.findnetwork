package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.R$color;
import com.huawei.android.hicloud.oobe.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import gp.C10028c;
import hu.C10343b;
import p015ak.C0219i;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class OOBEQueryBaseActivity extends OOBEAuthCallbackActivity {

    /* renamed from: f */
    public int f12406f;

    /* renamed from: i */
    public String f12409i;

    /* renamed from: j */
    public LinearLayout f12410j;

    /* renamed from: k */
    public LinearLayout f12411k;

    /* renamed from: l */
    public LinearLayout f12412l;

    /* renamed from: m */
    public boolean f12413m;

    /* renamed from: n */
    public boolean f12414n;

    /* renamed from: p */
    public LinearLayout f12416p;

    /* renamed from: q */
    public LinearLayout f12417q;

    /* renamed from: r */
    public RelativeLayout f12418r;

    /* renamed from: s */
    public RelativeLayout f12419s;

    /* renamed from: t */
    public LinearLayout f12420t;

    /* renamed from: u */
    public LinearLayout f12421u;

    /* renamed from: v */
    public HwButton f12422v;

    /* renamed from: w */
    public Button f12423w;

    /* renamed from: x */
    public Button f12424x;

    /* renamed from: y */
    public TextView f12425y;

    /* renamed from: e */
    public C10028c f12405e = C10028c.m62182c0();

    /* renamed from: g */
    public boolean f12407g = false;

    /* renamed from: h */
    public boolean f12408h = false;

    /* renamed from: o */
    public boolean f12415o = false;

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEQueryBaseActivity$b */
    public class C2830b extends ClickableSpan {

        /* renamed from: a */
        public boolean f12426a = false;

        /* renamed from: b */
        public Context f12427b;

        public C2830b(Context context) {
            this.f12427b = context;
        }

        /* renamed from: a */
        public void m16675a(boolean z10) {
            this.f12426a = z10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            C11839m.m70688i("OOBEQueryBaseActivity", "MyClickableSpan email on click");
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", OOBEQueryBaseActivity.this.getString(R$string.hidisk_hwcloud_email_address_for_feedback), null));
            intent.putExtra("android.intent.extra.SUBJECT", "Subject");
            intent.putExtra("android.intent.extra.TEXT", "Body");
            OOBEQueryBaseActivity.this.startActivity(Intent.createChooser(intent, ""));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f12426a ? this.f12427b.getResources().getColor(R$color.oobe_btn_pressed) : this.f12427b.getResources().getColor(R$color.attention_color));
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEQueryBaseActivity$c */
    public class C2831c extends LinkMovementMethod {

        /* renamed from: a */
        public C2830b f12429a;

        public C2831c() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            this.f12429a = OOBEQueryBaseActivity.this.m16671k(textView, spannable, motionEvent);
            if (motionEvent.getAction() == 0) {
                C11839m.m70688i("OOBEQueryBaseActivity", "MyLinkMovementMethod email on click");
                if (this.f12429a != null) {
                    C11839m.m70688i("OOBEQueryBaseActivity", "mClickSpan is not null");
                    this.f12429a.m16675a(true);
                }
            } else if (2 == motionEvent.getAction()) {
                C2830b c2830bM16671k = OOBEQueryBaseActivity.this.m16671k(textView, spannable, motionEvent);
                C2830b c2830b = this.f12429a;
                if (c2830b != null && c2830bM16671k != c2830b) {
                    c2830b.m16675a(false);
                    this.f12429a = null;
                    Selection.removeSelection(spannable);
                }
            } else {
                Selection.removeSelection(spannable);
                C2830b c2830b2 = this.f12429a;
                if (c2830b2 == null) {
                    return true;
                }
                c2830b2.m16675a(false);
                this.f12429a = null;
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEQueryBaseActivity$d */
    public static class ViewOnSystemUiVisibilityChangeListenerC2832d implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a */
        public Context f12431a;

        /* renamed from: b */
        public Window f12432b;

        public ViewOnSystemUiVisibilityChangeListenerC2832d(Context context, Window window) {
            this.f12431a = context;
            this.f12432b = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            C11829c.m70585i1(this.f12432b);
            C11829c.m70633y1(this.f12431a, this.f12432b);
        }
    }

    /* renamed from: j */
    public void m16670j() {
        C11019b.m66371t().m66433n(this, getIntent());
    }

    /* renamed from: k */
    public final C2830b m16671k(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y10 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        C2830b[] c2830bArr = (C2830b[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, C2830b.class);
        if (c2830bArr.length > 0) {
            return c2830bArr[0];
        }
        return null;
    }

    /* renamed from: l */
    public void m16672l(boolean z10) {
        C10028c c10028cM62183d0 = C10028c.m62183d0(getApplicationContext());
        if (c10028cM62183d0 != null) {
            c10028cM62183d0.m62377p3("funcfg_cloud_backup", false);
            c10028cM62183d0.m62377p3("funcfg_huawei_drive", false);
            c10028cM62183d0.m62377p3("funcfg_find_my_phone_globe", false);
            c10028cM62183d0.m62377p3("funcfg_gallery", false);
            c10028cM62183d0.m62377p3("funcfg_contacts", false);
            c10028cM62183d0.m62377p3("funcfg_calendar", false);
            c10028cM62183d0.m62377p3("funcfg_notes", false);
            c10028cM62183d0.m62377p3("funcfg_wlan", false);
            c10028cM62183d0.m62377p3("funcfg_browser", false);
            c10028cM62183d0.m62377p3("funcfg_messaging_up", false);
            c10028cM62183d0.m62377p3("funcfg_call_log_up", false);
            c10028cM62183d0.m62377p3("funcfg_recordings_up", false);
            c10028cM62183d0.m62377p3("funcfg_blocked_up", false);
            c10028cM62183d0.m62377p3("funcfg_messaging_down", false);
            c10028cM62183d0.m62377p3("funcfg_call_log_down", false);
            c10028cM62183d0.m62377p3("funcfg_recordings_down", false);
            c10028cM62183d0.m62377p3("funcfg_blocked_down", false);
            c10028cM62183d0.m62377p3("funcfg_manage_storage", false);
            c10028cM62183d0.m62377p3("is_already_configed_NV4", z10);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: m */
    public void m16673m() {
        String string = getString(R$string.contact_email_value);
        SpannableString spannableString = new SpannableString(getString(R$string.set_get_info_not_avi, string));
        int iIndexOf = spannableString.toString().indexOf(string);
        spannableString.setSpan(new C2830b(this), iIndexOf, string.length() + iIndexOf, 33);
        TextView textView = this.f12425y;
        if (textView != null) {
            textView.setMovementMethod(new C2831c());
            this.f12425y.setHighlightColor(getResources().getColor(R.color.transparent));
            this.f12425y.setText(spannableString);
        }
    }

    /* renamed from: n */
    public void m16674n() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        this.f12413m = hiCloudSafeIntent.getBooleanExtra("intent_from_settings", false);
        this.f12414n = hiCloudSafeIntent.getBooleanExtra("intent_from_settings_data", false);
        this.f12407g = hiCloudSafeIntent.getBooleanExtra("is_from_oobe_recover", false);
        Bundle extras = hiCloudSafeIntent.getExtras();
        if (extras == null) {
            return;
        }
        int iM63687i = new C10343b(extras).m63687i(FamilyShareConstants.ENTRY_TYPE, 1);
        this.f12406f = iM63687i;
        if (iM63687i == 3) {
            this.f12409i = hiCloudSafeIntent.getStringExtra(RemoteMessageConst.FROM);
        } else if (iM63687i == 1 && C11842p.m70759Q0()) {
            setRequestedOrientation(1);
        }
        if (1 != this.f12406f || getActionBar() == null) {
            return;
        }
        getActionBar().hide();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEAuthCallbackActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C0219i.m1463a() >= 17) {
            if (C11842p.m70759Q0() || this.f12406f == 2) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(-1);
            }
        }
    }
}
