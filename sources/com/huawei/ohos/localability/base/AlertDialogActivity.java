package com.huawei.ohos.localability.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.ohos.localability.R$dimen;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import java.lang.ref.WeakReference;
import ohos.ohos.ohos.ohos.ohos.C11889d;
import ohos.ohos.ohos.ohos.ohos.C11893h;
import p625rx.C12634a;
import p625rx.C12645l;

/* loaded from: classes8.dex */
public class AlertDialogActivity extends Activity implements DialogInterface.OnCancelListener, C12645l.a, DialogInterface.OnDismissListener {

    /* renamed from: a */
    public AlertDialog f31428a;

    /* renamed from: b */
    public Intent f31429b;

    /* renamed from: c */
    public C6825a f31430c;

    /* renamed from: d */
    public boolean f31431d = false;

    /* renamed from: e */
    public InterfaceC6826b f31432e;

    /* renamed from: com.huawei.ohos.localability.base.AlertDialogActivity$a */
    public static class C6825a extends BroadcastReceiver {

        /* renamed from: a */
        public WeakReference<Activity> f31433a;

        /* renamed from: b */
        public WeakReference<InterfaceC6826b> f31434b;

        public C6825a(Activity activity, InterfaceC6826b interfaceC6826b) {
            this.f31433a = new WeakReference<>(activity);
            this.f31434b = new WeakReference<>(interfaceC6826b);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Activity activity = this.f31433a.get();
            if (activity == null || activity.isFinishing()) {
                Log.e("AlertDialogActivity", "activity is finishing");
                return;
            }
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra("reason");
                if ("homekey".equals(stringExtra) || "recentapps".equals(stringExtra)) {
                    if (this.f31434b.get() != null) {
                        this.f31434b.get().mo38541a();
                    }
                    if (activity.isFinishing()) {
                        return;
                    }
                    activity.finish();
                }
            }
        }
    }

    /* renamed from: com.huawei.ohos.localability.base.AlertDialogActivity$b */
    public interface InterfaceC6826b {
        /* renamed from: a */
        void mo38541a();
    }

    @Override // p625rx.C12645l.a
    /* renamed from: a */
    public void mo38539a() {
        this.f31431d = true;
    }

    /* renamed from: b */
    public final void m38540b(Bundle bundle) {
        AlertDialog alertDialogCreate;
        int i10 = bundle.getInt("dialogName");
        if (i10 == 1) {
            C11893h c11893h = new C11893h(this, bundle);
            this.f31432e = c11893h;
            AlertDialog.Builder builder = new AlertDialog.Builder(c11893h.f58105b);
            builder.setView(c11893h.f55044e);
            alertDialogCreate = builder.create();
            c11893h.f55063x = alertDialogCreate;
        } else {
            if (i10 != 2) {
                Log.e("AlertDialogActivity", "unknown dialog type");
                return;
            }
            C11889d c11889d = new C11889d(this, bundle);
            this.f31432e = c11889d;
            AlertDialog.Builder builder2 = new AlertDialog.Builder(c11889d.f58105b);
            builder2.setView(c11889d.f55010e);
            alertDialogCreate = builder2.create();
            c11889d.f55031z = alertDialogCreate;
        }
        this.f31428a = alertDialogCreate;
        C12634a.m76170e(alertDialogCreate);
        getWindowManager().getDefaultDisplay().getSize(new Point());
        this.f31428a.show();
        Window window = this.f31428a.getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.y = getResources().getDimensionPixelOffset(R$dimen.interwork_16_dp);
        window.setAttributes(attributes);
        window.addFlags(2);
        this.f31428a.setOnCancelListener(this);
        this.f31428a.setOnDismissListener(this);
        this.f31428a.setCancelable(true);
        this.f31428a.setCanceledOnTouchOutside(true);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (isFinishing()) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("AlertDialogActivity", "can't get bundle data");
            return;
        }
        this.f31429b = (Intent) extras.getParcelable("abilityIntent");
        requestWindowFeature(1);
        getWindow().setFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        m38540b(extras);
        this.f31430c = new C6825a(this, this.f31432e);
        registerReceiver(this.f31430c, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C6825a c6825a = this.f31430c;
        if (c6825a != null) {
            unregisterReceiver(c6825a);
        }
        InterfaceC6826b interfaceC6826b = this.f31432e;
        if (interfaceC6826b != null) {
            interfaceC6826b.mo38541a();
            this.f31432e = null;
        }
        AlertDialog alertDialog = this.f31428a;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f31428a = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        InterfaceC6826b interfaceC6826b = this.f31432e;
        if (interfaceC6826b != null) {
            interfaceC6826b.mo38541a();
        }
        if (isFinishing()) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        ComponentName component;
        ComponentName component2;
        super.onNewIntent(intent);
        setIntent(intent);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("AlertDialogActivity", "can't get bundle data");
            return;
        }
        Intent intent2 = (Intent) extras.getParcelable("abilityIntent");
        if (intent2 == null || (component = intent2.getComponent()) == null) {
            return;
        }
        String packageName = component.getPackageName();
        String className = component.getClassName();
        if (TextUtils.isEmpty(packageName) || TextUtils.isEmpty(className) || (component2 = this.f31429b.getComponent()) == null) {
            return;
        }
        if (packageName.equals(component2.getPackageName()) && className.equals(component2.getClassName())) {
            Log.e("AlertDialogActivity", "same component");
            return;
        }
        this.f31429b = (Intent) extras.getParcelable("abilityIntent");
        InterfaceC6826b interfaceC6826b = this.f31432e;
        if (interfaceC6826b != null) {
            interfaceC6826b.mo38541a();
            this.f31432e = null;
        }
        C6825a c6825a = this.f31430c;
        if (c6825a != null) {
            unregisterReceiver(c6825a);
        }
        AlertDialog alertDialog = this.f31428a;
        if (alertDialog != null) {
            alertDialog.setOnCancelListener(null);
            this.f31428a.setOnDismissListener(null);
            this.f31428a.dismiss();
        }
        m38540b(extras);
        this.f31430c = new C6825a(this, this.f31432e);
        registerReceiver(this.f31430c, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        if (this.f31431d) {
            this.f31431d = false;
            return;
        }
        AlertDialog alertDialog = this.f31428a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (isFinishing()) {
            return;
        }
        finish();
    }
}
