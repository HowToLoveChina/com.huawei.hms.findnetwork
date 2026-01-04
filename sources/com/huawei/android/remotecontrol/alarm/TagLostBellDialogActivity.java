package com.huawei.android.remotecontrol.alarm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.android.remotecontrol.sdk.R$dimen;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0224k0;
import p015ak.C0234s;
import p227dg.C9097b;
import p227dg.C9120m0;
import p237du.C9310c;
import p514o9.C11829c;
import p514o9.C11842p;
import p664u0.C13108a;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class TagLostBellDialogActivity extends Activity implements DialogInterface.OnClickListener {

    /* renamed from: d */
    public static String f19733d;

    /* renamed from: e */
    public static String f19734e;

    /* renamed from: f */
    public static String f19735f;

    /* renamed from: g */
    public static Dialog f19736g;

    /* renamed from: a */
    public C4326b f19737a;

    /* renamed from: b */
    public C4327c f19738b;

    /* renamed from: c */
    public final DialogInterface.OnKeyListener f19739c = new DialogInterface.OnKeyListener() { // from class: se.n
        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            return this.f58474a.m26007d(dialogInterface, i10, keyEvent);
        }
    };

    /* renamed from: com.huawei.android.remotecontrol.alarm.TagLostBellDialogActivity$b */
    public class C4326b extends BroadcastReceiver {
        public C4326b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SafeIntent safeIntent = new SafeIntent(intent);
            C13981a.m83989i("TagLostBellDialogActivity", "ScreenOffBroadcastReceiver: " + safeIntent.getAction());
            if (safeIntent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                TagLostBellDialogActivity.this.m26013j();
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.alarm.TagLostBellDialogActivity$c */
    public class C4327c extends BroadcastReceiver {
        public C4327c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SafeIntent safeIntent = new SafeIntent(intent);
            C13981a.m83989i("TagLostBellDialogActivity", "TagBellEndBroadcastReceiver: " + safeIntent.getAction());
            if (safeIntent.getAction().equals("com.huawei.hidisk.phone.finder.TAG.BELL.AUTO.END")) {
                TagLostBellDialogActivity.this.m26013j();
            }
        }
    }

    /* renamed from: c */
    public final void m26006c() {
        C13981a.m83989i("TagLostBellDialogActivity", "dialogDismiss");
        Dialog dialog = f19736g;
        if (dialog != null) {
            dialog.dismiss();
            f19736g = null;
        }
    }

    /* renamed from: d */
    public final /* synthetic */ boolean m26007d(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        C13981a.m83989i("TagLostBellDialogActivity", "keyListener, keyCode: " + i10);
        boolean z10 = i10 == 25 || i10 == 24;
        boolean z11 = i10 == 26 || i10 == 3 || i10 == 4;
        if (!z10 && !z11) {
            return false;
        }
        m26013j();
        return true;
    }

    /* renamed from: e */
    public final /* synthetic */ void m26008e(int i10) {
        C11829c.m70585i1(getWindow());
        C11829c.m70633y1(getApplicationContext(), getWindow());
    }

    /* renamed from: f */
    public final void m26009f() {
        C13981a.m83989i("TagLostBellDialogActivity", "registerBroadcast");
        if (this.f19737a == null) {
            this.f19737a = new C4326b();
        }
        registerReceiver(this.f19737a, new IntentFilter("android.intent.action.SCREEN_OFF"));
        if (this.f19738b == null) {
            this.f19738b = new C4327c();
        }
        C13108a.m78878b(this).m78880c(this.f19738b, new IntentFilter("com.huawei.hidisk.phone.finder.TAG.BELL.AUTO.END"));
    }

    /* renamed from: g */
    public final void m26010g(Dialog dialog) {
        WindowManager.LayoutParams attributes;
        int paddingLeft;
        if (dialog == null) {
            return;
        }
        C13981a.m83989i("TagLostBellDialogActivity", "setDialogWidth");
        dialog.show();
        Window window = dialog.getWindow();
        if (window != null) {
            attributes = window.getAttributes();
            paddingLeft = window.getDecorView().getPaddingLeft();
        } else {
            attributes = null;
            paddingLeft = 0;
        }
        if (attributes != null) {
            int iM70758Q = C11842p.m70758Q(this);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.cloud_space_328_dp) + (paddingLeft * 2);
            if (dimensionPixelSize <= iM70758Q) {
                C13981a.m83987d("TagLostBellDialogActivity", "setDialogWidth, set maxWidth");
                attributes.width = dimensionPixelSize;
                window.setAttributes(attributes);
            }
        }
    }

    /* renamed from: h */
    public final void m26011h() {
        C11829c.m70585i1(getWindow());
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: se.o
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i10) {
                this.f58475a.m26008e(i10);
            }
        });
        C11829c.m70633y1(this, getWindow());
    }

    /* renamed from: i */
    public final void m26012i() {
        C13981a.m83989i("TagLostBellDialogActivity", "showLostBellDialog");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R$string.tag_lost_bell_message, f19734e)).setPositiveButton(R$string.conform, this).setNegativeButton(R$string.close_current_date_display, this).setOnKeyListener(this.f19739c);
            AlertDialog alertDialogCreate = builder.create();
            f19736g = alertDialogCreate;
            alertDialogCreate.setCanceledOnTouchOutside(false);
            m26010g(f19736g);
            f19736g.show();
        } catch (Exception unused) {
            C13981a.m83988e("TagLostBellDialogActivity", "showLostBellDialog Exception");
        }
    }

    /* renamed from: j */
    public void m26013j() {
        C13981a.m83989i("TagLostBellDialogActivity", "tagBellEnd");
        m26006c();
        finish();
        C9097b.m57310t(this);
    }

    /* renamed from: k */
    public final void m26014k() {
        C13981a.m83989i("TagLostBellDialogActivity", "unregisterBroadcast");
        C4326b c4326b = this.f19737a;
        if (c4326b != null) {
            try {
                unregisterReceiver(c4326b);
            } catch (IllegalArgumentException e10) {
                C13981a.m83988e("TagLostBellDialogActivity", "unregisterBroadcast, e: " + e10.getMessage());
            }
            this.f19737a = null;
        }
        if (this.f19738b != null) {
            try {
                C13108a.m78878b(this).m78883f(this.f19738b);
            } catch (IllegalArgumentException e11) {
                C13981a.m83988e("TagLostBellDialogActivity", "unregisterBroadcast, e: " + e11.getMessage());
            }
            this.f19738b = null;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        C13981a.m83989i("TagLostBellDialogActivity", "onClick, which: " + i10);
        if (i10 == -2) {
            C9097b.m57313w(C9310c.m58618b(f19733d), false);
            m26013j();
            C9120m0.m57383e1(this, "mecloud_findmyphone_tag_lost_bell_dialog_click_no_bell_today", f19733d, f19734e, f19735f, 0);
        } else if (i10 == -1) {
            m26013j();
            C9120m0.m57383e1(this, "mecloud_findmyphone_tag_lost_bell_dialog_click_confirm", f19733d, f19734e, f19735f, 0);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C13981a.m83989i("TagLostBellDialogActivity", "onConfigurationChanged");
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("TagLostBellDialogActivity", "onCreate");
        super.onCreate(bundle);
        requestWindowFeature(1);
        C0224k0.m1541K(getWindow(), false);
        getWindow().addFlags(2098304);
        getWindow().setType(2038);
        SafeIntent safeIntent = new SafeIntent(getIntent());
        f19733d = safeIntent.getStringExtra("TagSN");
        f19734e = safeIntent.getStringExtra("itemName");
        f19735f = safeIntent.getStringExtra("modelId");
        m26009f();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        C13981a.m83989i("TagLostBellDialogActivity", "onDestroy");
        super.onDestroy();
        m26006c();
        m26014k();
        C9097b.m57310t(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        C13981a.m83989i("TagLostBellDialogActivity", "onResume");
        super.onResume();
        m26011h();
        if (f19736g == null) {
            m26012i();
        }
    }
}
