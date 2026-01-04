package com.huawei.android.remotecontrol.p093ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import hk.C10278a;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0234s;
import p514o9.C11829c;
import p514o9.C11842p;
import p521og.C11881n;
import p664u0.C13108a;
import p809yg.C13981a;
import sk.C12808e;
import sk.C12809f;

/* loaded from: classes4.dex */
public class LockCallActivity extends Activity {

    /* renamed from: a */
    public Button f20409a;

    /* renamed from: b */
    public TextView f20410b;

    /* renamed from: c */
    public TextView f20411c;

    /* renamed from: d */
    public TextView f20412d;

    /* renamed from: e */
    public TextView f20413e;

    /* renamed from: f */
    public TextView f20414f;

    /* renamed from: g */
    public String f20415g;

    /* renamed from: h */
    public String f20416h;

    /* renamed from: i */
    public String f20417i;

    /* renamed from: j */
    public String f20418j;

    /* renamed from: k */
    public String f20419k;

    /* renamed from: l */
    public C4455c f20420l;

    /* renamed from: m */
    public C4455c f20421m;

    /* renamed from: n */
    public boolean f20422n;

    /* renamed from: com.huawei.android.remotecontrol.ui.LockCallActivity$a */
    public class ViewOnClickListenerC4453a implements View.OnClickListener {
        public ViewOnClickListenerC4453a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LockCallActivity.this.m27040b();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.LockCallActivity$b */
    public class KeyguardManagerKeyguardDismissCallbackC4454b extends KeyguardManager.KeyguardDismissCallback {
        public KeyguardManagerKeyguardDismissCallbackC4454b() {
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissCancelled() {
            super.onDismissCancelled();
            C13981a.m83989i("LockCallActivity", "onDismissCancelled");
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissError() {
            super.onDismissError();
            C13981a.m83988e("LockCallActivity", "onDismissError");
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissSucceeded() {
            super.onDismissSucceeded();
            C13981a.m83989i("LockCallActivity", "onDismissSucceeded");
            LockCallActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.LockCallActivity$c */
    public class C4455c extends BroadcastReceiver {
        public C4455c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = new HiCloudSafeIntent(intent).getAction();
            if ("finish_lockActivity".equals(action)) {
                C13981a.m83989i("LockCallActivity", "LockActivityReceiver:" + action);
                LockCallActivity.this.finish();
                return;
            }
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                C13981a.m83989i("LockCallActivity", "LockActivityReceiver:" + action);
                LockCallActivity.this.finish();
            }
        }

        public /* synthetic */ C4455c(LockCallActivity lockCallActivity, ViewOnClickListenerC4453a viewOnClickListenerC4453a) {
            this();
        }
    }

    /* renamed from: b */
    public final void m27040b() {
        C13981a.m83989i("LockCallActivity", "start to call");
        if (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.CALL_PHONE") != 0) {
            C13981a.m83988e("LockCallActivity", "haven't call phone permission");
            return;
        }
        if (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.READ_PHONE_STATE") != 0) {
            C13981a.m83988e("LockCallActivity", "haven't call phone permission");
            return;
        }
        TelecomManager telecomManager = (TelecomManager) getSystemService("telecom");
        if (telecomManager == null) {
            C13981a.m83988e("LockCallActivity", "telecomManager null");
            return;
        }
        PhoneAccountHandle defaultOutgoingPhoneAccount = telecomManager.getDefaultOutgoingPhoneAccount("tel");
        if (defaultOutgoingPhoneAccount != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("android.telecom.extra.PHONE_ACCOUNT_HANDLE", defaultOutgoingPhoneAccount);
            telecomManager.placeCall(Uri.parse(NavigationUtils.TEL_SCHEMA_PREF + this.f20416h), bundle);
            return;
        }
        C13981a.m83989i("LockCallActivity", "defaultHandle == null");
        List<PhoneAccountHandle> callCapablePhoneAccounts = telecomManager.getCallCapablePhoneAccounts();
        if (callCapablePhoneAccounts == null || callCapablePhoneAccounts.size() <= 0) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("android.telecom.extra.PHONE_ACCOUNT_HANDLE", callCapablePhoneAccounts.get(0));
        telecomManager.placeCall(Uri.parse(NavigationUtils.TEL_SCHEMA_PREF + this.f20416h), bundle2);
    }

    /* renamed from: c */
    public final String m27041c(String str) {
        int length = str.length();
        int i10 = length - 1;
        while (true) {
            if (i10 < 0) {
                break;
            }
            if ("\n".equals(String.valueOf(str.charAt(i10)))) {
                C13981a.m83989i("LockCallActivity", "message has split character");
                length = i10;
                break;
            }
            i10--;
        }
        return str.substring(0, length);
    }

    /* renamed from: d */
    public final void m27042d() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f20415g = hiCloudSafeIntent.getStringExtra("message");
        this.f20416h = hiCloudSafeIntent.getStringExtra("phoneNum");
        this.f20417i = hiCloudSafeIntent.getStringExtra("email");
        m27045g();
        m27046h(this.f20415g, this.f20416h, this.f20417i);
        this.f20409a.setOnClickListener(new ViewOnClickListenerC4453a());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (25 == keyEvent.getKeyCode() || 24 == keyEvent.getKeyCode()) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* renamed from: e */
    public final void m27043e() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("LockCallActivity", "initView");
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C11829c.m70591k1(this);
        }
        C12808e.m76822a(this);
        setContentView(R$layout.activity_lock_call);
        this.f20409a = (Button) C12809f.m76829b(this, R$id.call_button);
        this.f20413e = (TextView) C12809f.m76829b(this, R$id.lock_contact);
        this.f20410b = (TextView) C12809f.m76829b(this, R$id.lock_time);
        this.f20411c = (TextView) C12809f.m76829b(this, R$id.lock_date);
        this.f20412d = (TextView) C12809f.m76829b(this, R$id.lock_message);
        this.f20414f = (TextView) C12809f.m76829b(this, R$id.lock_text_contact);
        String str = Environment.getRootDirectory() + "/fonts/HWDigit-Regular.ttf";
        if (C10278a.m63442h(str).exists()) {
            this.f20410b.setTypeface(Typeface.createFromFile(str));
        }
    }

    /* renamed from: f */
    public final void m27044f() {
        if (TextUtils.isEmpty(this.f20416h)) {
            this.f20413e.setText(this.f20417i.trim().replaceAll("%40", SplitAppUtil.SPLIT_APP_SUFFIX));
        } else {
            this.f20413e.setText(this.f20416h.trim());
        }
        if (TextUtils.isEmpty(this.f20416h) || C11881n.m71345H(this)) {
            this.f20409a.setVisibility(8);
        } else {
            this.f20409a.setVisibility(0);
        }
    }

    /* renamed from: g */
    public final void m27045g() {
        this.f20418j = new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis()));
        this.f20419k = C11881n.m71356f(this, System.currentTimeMillis(), 26);
        TextView textView = this.f20410b;
        if (textView != null) {
            textView.setText(this.f20418j);
        }
        TextView textView2 = this.f20411c;
        if (textView2 != null) {
            textView2.setText(this.f20419k);
        }
    }

    /* renamed from: h */
    public final void m27046h(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            this.f20413e.setVisibility(8);
            this.f20414f.setVisibility(8);
            this.f20409a.setVisibility(8);
            if (TextUtils.isEmpty(str)) {
                this.f20412d.setVisibility(8);
                return;
            } else {
                this.f20412d.setVisibility(0);
                this.f20412d.setText(str.trim());
                return;
            }
        }
        this.f20414f.setVisibility(0);
        this.f20413e.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            this.f20412d.setVisibility(8);
        } else if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            this.f20412d.setText(str.trim());
        } else {
            this.f20412d.setText(m27041c(str).trim());
        }
        m27044f();
    }

    /* renamed from: i */
    public final void m27047i() {
        try {
            if (C11842p.m70771U0() || C11842p.m70747M0(this) || C11842p.m70735I0()) {
                C11842p.m70772U1(this, 4);
            } else {
                C11842p.m70772U1(this, 1);
            }
        } catch (Exception unused) {
            C13981a.m83988e("LockCallActivity", "setOrientation err");
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    /* renamed from: j */
    public final void m27048j() {
        C13981a.m83989i("LockCallActivity", "slideUnLock");
        if (!this.f20422n) {
            C13981a.m83990w("LockCallActivity", "lostMode in StartUp, return");
            finish();
            return;
        }
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
        if (keyguardManager == null) {
            C13981a.m83990w("LockCallActivity", "keyguardManager null");
            return;
        }
        if (!keyguardManager.isKeyguardLocked()) {
            C13981a.m83990w("LockCallActivity", "isKeyguardLocked false");
            finish();
        }
        C13981a.m83989i("LockCallActivity", "requestKeyguard");
        keyguardManager.requestDismissKeyguard(this, new KeyguardManagerKeyguardDismissCallbackC4454b());
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    @SuppressLint({"ObsoleteSdkInt"})
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m27047i();
        super.onCreate(bundle);
        setShowWhenLocked(true);
        m27043e();
        this.f20420l = new C4455c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        registerReceiver(this.f20420l, intentFilter);
        this.f20421m = new C4455c(this, null);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("finish_lockActivity");
        C13108a.m78878b(this).m78880c(this.f20421m, intentFilter2);
        m27042d();
        this.f20422n = C0209d.m1203Q1(this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C13981a.m83989i("LockCallActivity", "onDestroy");
        C4455c c4455c = this.f20420l;
        if (c4455c != null) {
            unregisterReceiver(c4455c);
        }
        if (this.f20421m != null) {
            C13108a.m78878b(this).m78883f(this.f20421m);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        C13981a.m83987d("LockCallActivity", "KEYCODE_BACK");
        return true;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        m27042d();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13981a.m83989i("LockCallActivity", "onPause");
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        m27045g();
        C13981a.m83989i("LockCallActivity", "onResume");
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x10;
        float y10;
        if (motionEvent.getAction() == 0) {
            x10 = motionEvent.getX();
            y10 = motionEvent.getY();
        } else {
            x10 = 0.0f;
            y10 = 0.0f;
        }
        if (motionEvent.getAction() == 1) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            if (y10 - y11 > 50.0f || y11 - y10 > 50.0f || x10 - x11 > 50.0f || x11 - x10 > 50.0f) {
                m27048j();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }
}
