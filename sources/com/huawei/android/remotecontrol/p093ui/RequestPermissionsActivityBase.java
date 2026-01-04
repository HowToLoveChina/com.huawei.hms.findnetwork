package com.huawei.android.remotecontrol.p093ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Arrays;
import p015ak.C0209d;
import p015ak.C0234s;
import p514o9.C11829c;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public abstract class RequestPermissionsActivityBase extends Activity {

    /* renamed from: a */
    public HiCloudSafeIntent f20519a = null;

    /* renamed from: b */
    public AlertDialog f20520b;

    /* renamed from: com.huawei.android.remotecontrol.ui.RequestPermissionsActivityBase$a */
    public class DialogInterfaceOnDismissListenerC4471a implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC4471a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            C13981a.m83989i("RequestPermissionsActivityBase", "dialog dismiss");
            RequestPermissionsActivityBase.this.setResult(0);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.RequestPermissionsActivityBase$b */
    public class DialogInterfaceOnClickListenerC4472b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4472b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C13981a.m83989i("RequestPermissionsActivityBase", "dialog cancel");
            RequestPermissionsActivityBase.this.setResult(0);
            RequestPermissionsActivityBase.this.finish();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.RequestPermissionsActivityBase$c */
    public class DialogInterfaceOnClickListenerC4473c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC4473c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C13981a.m83989i("RequestPermissionsActivityBase", "dialog positive");
            C11829c.m70570d1(RequestPermissionsActivityBase.this, 100);
        }
    }

    /* renamed from: c */
    public static boolean m27227c(Context context, String[] strArr) {
        try {
            for (String str : strArr) {
                if (context.checkSelfPermission(str) != 0) {
                    C13981a.m83989i("RequestPermissionsActivityBase", "permission denied:" + str);
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            C13981a.m83989i("RequestPermissionsActivityBase", "check permission exception:" + e10.getMessage());
            return true;
        }
    }

    /* renamed from: h */
    public static boolean m27228h(Activity activity, String[] strArr, Class<?> cls) {
        if (m27227c(activity, strArr)) {
            return false;
        }
        Intent intent = new Intent(activity, cls);
        if (activity.getIntent() == null) {
            return false;
        }
        intent.putExtra("previous_intent", activity.getIntent());
        C0209d.m1302r2(intent, activity.getPackageName());
        activity.startActivity(intent);
        activity.finish();
        return true;
    }

    /* renamed from: i */
    public static boolean m27229i(Activity activity, String[] strArr, Class<?> cls) {
        if (m27227c(activity, strArr)) {
            return true;
        }
        Intent intent = new Intent(activity.getApplicationContext(), cls);
        C0209d.m1302r2(intent, activity.getPackageName());
        activity.startActivity(intent);
        return false;
    }

    /* renamed from: a */
    public abstract String[] mo27225a();

    /* renamed from: b */
    public abstract String[] mo27226b();

    /* renamed from: d */
    public final boolean m27230d(String[] strArr, int[] iArr) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (iArr[i10] != 0 && m27231e(strArr[i10])) {
                C13981a.m83989i("RequestPermissionsActivityBase", "permission denied:" + strArr[i10]);
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public final boolean m27231e(String str) {
        return Arrays.asList(mo27226b()).contains(str);
    }

    /* renamed from: f */
    public final void m27232f() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : mo27225a()) {
                if (checkSelfPermission(str) != 0) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() == 0) {
                requestPermissions(mo27226b(), 1);
            } else {
                requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 1);
            }
        } catch (Exception e10) {
            C13981a.m83989i("RequestPermissionsActivityBase", "request permission exception:" + e10.getMessage());
        }
    }

    /* renamed from: g */
    public void m27233g() {
        C13981a.m83989i("RequestPermissionsActivityBase", "show permission dialog");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(R$string.cloudbackup_alert).setMessage(R$string.phone_finder_permission_rationale_ask).setPositiveButton(R$string.conform, new DialogInterfaceOnClickListenerC4473c()).setNegativeButton(R$string.cancel, new DialogInterfaceOnClickListenerC4472b()).setOnDismissListener(new DialogInterfaceOnDismissListenerC4471a()).create();
        this.f20520b = alertDialogCreate;
        alertDialogCreate.show();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 100) {
            if (i11 == 0) {
                C13981a.m83989i("RequestPermissionsActivityBase", "onActivityResult: RESULT_CANCELED");
                finish();
                return;
            }
            if (-1 == i11) {
                C13981a.m83989i("RequestPermissionsActivityBase", "onActivityResult: RESULT_OK");
                if (!m27227c(this, mo27226b())) {
                    C13981a.m83990w("RequestPermissionsActivityBase", "onActivityResult: Permission is still denied ");
                    finish();
                    return;
                }
                HiCloudSafeIntent hiCloudSafeIntent = this.f20519a;
                if (hiCloudSafeIntent != null) {
                    try {
                        hiCloudSafeIntent.setFlags(65536);
                        C0209d.m1302r2(this.f20519a, getPackageName());
                        startActivity(this.f20519a);
                    } catch (Exception e10) {
                        C13981a.m83988e("RequestPermissionsActivityBase", "startActivity e:" + e10.getMessage());
                    }
                    finish();
                } else {
                    finish();
                }
                C13981a.m83989i("RequestPermissionsActivityBase", "onActivityResult: Permission is granted");
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = new HiCloudSafeIntent(intent).getExtras();
            if (extras != null) {
                this.f20519a = new HiCloudSafeIntent((Intent) new C10343b(extras).m63680b("previous_intent"));
            }
            if (bundle == null) {
                m27232f();
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f20520b;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.f20520b.dismiss();
        this.f20520b = null;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length <= 0 || !m27230d(strArr, iArr)) {
            m27233g();
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = this.f20519a;
        if (hiCloudSafeIntent != null) {
            try {
                hiCloudSafeIntent.setFlags(65536);
                C0209d.m1302r2(this.f20519a, getPackageName());
                startActivity(this.f20519a);
            } catch (Exception e10) {
                C13981a.m83988e("RequestPermissionsActivityBase", "startActivity exception:" + e10.getMessage());
            }
        }
        finish();
    }
}
