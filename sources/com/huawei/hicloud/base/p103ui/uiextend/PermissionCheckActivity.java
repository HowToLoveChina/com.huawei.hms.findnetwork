package com.huawei.hicloud.base.p103ui.uiextend;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.base.R$string;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p015ak.C0207c;
import p015ak.C0209d;
import p015ak.C0216g0;
import p015ak.C0234s;
import p399jk.AbstractC10896a;
import p494nk.C11718b;
import p783xp.C13843a;
import uk.C13205c;

/* loaded from: classes6.dex */
public class PermissionCheckActivity extends Activity {

    /* renamed from: a */
    public AlertDialog f22162a;

    /* renamed from: b */
    public C11718b f22163b = new C11718b();

    /* renamed from: c */
    public List<String> f22164c = new ArrayList();

    /* renamed from: d */
    public List<String> f22165d = new ArrayList();

    /* renamed from: e */
    public int f22166e = -1;

    /* renamed from: f */
    public Handler f22167f = new HandlerC4857a();

    /* renamed from: g */
    public long f22168g;

    /* renamed from: com.huawei.hicloud.base.ui.uiextend.PermissionCheckActivity$a */
    public class HandlerC4857a extends Handler {
        public HandlerC4857a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 10001) {
                PermissionCheckActivity permissionCheckActivity = PermissionCheckActivity.this;
                permissionCheckActivity.m29124W0(permissionCheckActivity.f22164c, message.arg1);
            }
        }
    }

    /* renamed from: com.huawei.hicloud.base.ui.uiextend.PermissionCheckActivity$b */
    public static class DialogInterfaceOnClickListenerC4858b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public boolean f22170a;

        /* renamed from: b */
        public PermissionCheckActivity f22171b;

        /* renamed from: c */
        public int f22172c;

        public DialogInterfaceOnClickListenerC4858b(PermissionCheckActivity permissionCheckActivity, boolean z10, int i10) {
            this.f22170a = z10;
            this.f22171b = permissionCheckActivity;
            this.f22172c = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (this.f22171b == null) {
                AbstractC10896a.m65888w("PermissionCheckActivity", "onClick, mActivity null");
            } else if (this.f22170a) {
                AbstractC10896a.m65887i("PermissionCheckActivity", "onClick, dialog positive!");
                C0209d.m1282m2(this.f22171b, this.f22172c);
            } else {
                AbstractC10896a.m65887i("PermissionCheckActivity", "onClick, dialog cancel!");
                this.f22171b.mo13484E0(this.f22172c);
            }
        }
    }

    /* renamed from: O0 */
    private void m29122O0(List<String> list, int i10) {
        C11718b c11718b = new C11718b();
        ArrayList arrayList = new ArrayList();
        this.f22164c.clear();
        for (String str : list) {
            if (c11718b.m69913m(this, str)) {
                this.f22164c.add(str);
            } else {
                arrayList.add(str);
            }
        }
        if (arrayList.size() <= 0) {
            AbstractC10896a.m65887i("PermissionCheckActivity", "processSwitchPermissions, go switch permission set page");
            m29124W0(this.f22164c, i10);
            this.f22164c.clear();
        } else {
            AbstractC10896a.m65887i("PermissionCheckActivity", "processSwitchPermissions, request switch permission direct:" + arrayList.size());
            c11718b.m69914p(this, (String[]) arrayList.toArray(new String[0]), i10);
        }
    }

    /* renamed from: T0 */
    private void m29123T0(int i10) {
        if (!mo21668H0()) {
            AbstractC10896a.m65887i("PermissionCheckActivity", "isCheckPermissionOverSea is false");
            return;
        }
        C13205c.m79395d().m79396c();
        int i11 = this.f22166e + 1;
        this.f22166e = i11;
        if (i11 >= this.f22165d.size()) {
            AbstractC10896a.m65887i("PermissionCheckActivity", "requestPermissionOneByOne, request end");
            onRequestPermissionsResult(i10, new String[0], new int[1]);
            this.f22164c.clear();
            this.f22165d.clear();
            this.f22166e = -1;
            return;
        }
        try {
            String str = this.f22165d.get(this.f22166e);
            AbstractC10896a.m65887i("PermissionCheckActivity", "requestPermissionOneByOne permissionName: " + str + ", curRequestPermissionPosition: " + this.f22166e);
            if (checkSelfPermission(str) == 0 || this.f22163b.m69913m(this, str)) {
                AbstractC10896a.m65887i("PermissionCheckActivity", "requestPermissionOneByOne current permission have been granted");
                m29123T0(i10);
            } else {
                AbstractC10896a.m65887i("PermissionCheckActivity", "requestPermissionOneByOne start request");
                C13205c.m79395d().m79399g(this, str);
                this.f22163b.m69914p(this, C11718b.m69900j(str), i10);
            }
        } catch (Exception e10) {
            AbstractC10896a.m65887i("PermissionCheckActivity", "requestPermissionOneByOne failed, e: " + e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0 */
    public void m29124W0(List<String> list, int i10) {
        AbstractC10896a.m65887i("PermissionCheckActivity", "show set permission dialog");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setMessage(this.f22163b.m69905d(list, this)).setPositiveButton(R$string.set_permission, new DialogInterfaceOnClickListenerC4858b(this, true, i10)).setNegativeButton(R$string.cancel, new DialogInterfaceOnClickListenerC4858b(this, false, i10)).create();
        this.f22162a = alertDialogCreate;
        alertDialogCreate.setCancelable(false);
        if (isFinishing() || isDestroyed()) {
            AbstractC10896a.m65886e("PermissionCheckActivity", "showPermissionDialog,the activity is not avaiable");
            mo21267S0("");
        } else {
            this.f22162a.show();
            this.f22162a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tk.a
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f59283a.m29133K0(dialogInterface);
                }
            });
            mo21267S0(this.f22163b.m69906e(list, this));
        }
    }

    /* renamed from: A0 */
    public boolean m29127A0(String str, boolean z10) {
        List<String> listM69903b;
        List<String> listM69909h = this.f22163b.m69909h(str);
        if (listM69909h == null || listM69909h.size() == 0 || (listM69903b = this.f22163b.m69903b(this, listM69909h)) == null || listM69903b.size() == 0) {
            return true;
        }
        if (!z10) {
            return false;
        }
        if (C0209d.m1202Q0()) {
            m29122O0(listM69903b, m29131G0(str));
            return false;
        }
        m29134P0(listM69903b, m29131G0(str));
        return false;
    }

    /* renamed from: B0 */
    public void m29128B0(List<String> list) {
        List<String> listM69903b = this.f22163b.m69903b(this, list);
        if (listM69903b.size() <= 0) {
            mo21218M0();
        } else if (C0209d.m1202Q0()) {
            m29135Q0(listM69903b, true);
        } else {
            m29136R0(listM69903b, true);
        }
    }

    /* renamed from: C0 */
    public final void m29129C0() {
        AlertDialog alertDialog = this.f22162a;
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            } catch (IllegalArgumentException unused) {
                AbstractC10896a.m65886e("PermissionCheckActivity", "permission dialog dismiss IllegalArgumentException");
            } catch (Exception unused2) {
                AbstractC10896a.m65886e("PermissionCheckActivity", "permission dialog dismiss exception");
            }
        }
    }

    /* renamed from: D0 */
    public void m29130D0() {
        mo21218M0();
    }

    /* renamed from: E0 */
    public void mo13484E0(int i10) {
    }

    /* renamed from: F0 */
    public int mo18593F0() {
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f22168g) / 1000);
        if (iCurrentTimeMillis <= 0) {
            return 1;
        }
        return iCurrentTimeMillis;
    }

    /* renamed from: G0 */
    public final int m29131G0(String str) {
        if (str.equals("addressbook")) {
            return 20004;
        }
        if (str.equals("calendar")) {
            return 20005;
        }
        if (str.equals(HNConstants.DataType.MEDIA)) {
            return 20003;
        }
        if (str.equals(CloudBackupConstant.Command.PMS_CMD_BACKUP)) {
            return 20006;
        }
        if (str.equals("backup_sms")) {
            return 20007;
        }
        if (str.equals("backup_contact")) {
            return 20008;
        }
        if (str.equals("backup_calllog")) {
            return 20009;
        }
        if (str.equals("backup_calendar")) {
            return 20010;
        }
        if (str.equals("autosmslistkey")) {
            return 20011;
        }
        if (str.equals("autorecordingkey")) {
            return 20013;
        }
        if (str.equals("autocallloglistkey")) {
            return 20012;
        }
        if (str.equals("cloud_disk_download_sms")) {
            return 20014;
        }
        if (str.equals("cloud_disk_download_recording")) {
            return 20016;
        }
        return str.equals("cloud_disk_download_calllog") ? 20015 : 0;
    }

    /* renamed from: H0 */
    public boolean mo21668H0() {
        return true;
    }

    /* renamed from: I0 */
    public final boolean m29132I0(int i10) {
        return i10 == 20007 || i10 == 20008 || i10 == 20009 || i10 == 20010;
    }

    /* renamed from: J0 */
    public boolean mo19714J0(int i10) {
        return 20003 == i10 || 20004 == i10 || 20005 == i10 || 20006 == i10 || m29132I0(i10);
    }

    /* renamed from: K0 */
    public final /* synthetic */ void m29133K0(DialogInterface dialogInterface) {
        mo21267S0("");
    }

    /* renamed from: L0 */
    public void mo29120L0() {
    }

    /* renamed from: M0 */
    public void mo21218M0() {
    }

    /* renamed from: N0 */
    public void mo21227N0() {
    }

    /* renamed from: P0 */
    public final void m29134P0(List<String> list, int i10) {
        AbstractC10896a.m65887i("PermissionCheckActivity", "oversea ungranted permissions are:" + list);
        C11718b c11718b = new C11718b();
        this.f22164c.clear();
        this.f22165d.clear();
        this.f22166e = -1;
        for (String str : list) {
            if (c11718b.m69913m(this, str)) {
                this.f22164c.add(str);
            } else {
                this.f22165d.add(str);
            }
        }
        AbstractC10896a.m65887i("PermissionCheckActivity", "forbidPermissions:" + this.f22164c);
        if (this.f22165d.isEmpty()) {
            AbstractC10896a.m65887i("PermissionCheckActivity", "processSwitchPermissions, go switch permission set page");
            m29124W0(this.f22164c, i10);
            this.f22164c.clear();
        } else {
            AbstractC10896a.m65887i("PermissionCheckActivity", "request permission list size:" + Arrays.toString(this.f22165d.toArray()));
            m29123T0(i10);
        }
    }

    /* renamed from: Q0 */
    public final void m29135Q0(List<String> list, boolean z10) {
        C11718b c11718b = new C11718b();
        ArrayList arrayList = new ArrayList();
        this.f22164c.clear();
        for (String str : list) {
            if (c11718b.m69913m(this, str)) {
                this.f22164c.add(str);
            } else {
                arrayList.add(str);
            }
        }
        AbstractC10896a.m65887i("PermissionCheckActivity", "processUngrantedPermissions, forbidPermissions:" + this.f22164c);
        if (arrayList.size() > 0) {
            AbstractC10896a.m65887i("PermissionCheckActivity", "request permission direct:" + arrayList.size());
            c11718b.m69914p(this, (String[]) arrayList.toArray(new String[0]), 20001);
            return;
        }
        AbstractC10896a.m65887i("PermissionCheckActivity", "processUngrantedPermissions, go permission set page");
        if (z10) {
            m29124W0(this.f22164c, 20002);
            return;
        }
        Message message = new Message();
        message.what = 10001;
        message.arg1 = 20002;
        this.f22167f.sendMessage(message);
    }

    /* renamed from: R0 */
    public final void m29136R0(List<String> list, boolean z10) {
        AbstractC10896a.m65887i("PermissionCheckActivity", "oversea ungranted permissions are:" + list);
        C11718b c11718b = new C11718b();
        this.f22164c.clear();
        this.f22165d.clear();
        this.f22166e = -1;
        for (String str : list) {
            if (c11718b.m69913m(this, str)) {
                this.f22164c.add(str);
            } else {
                this.f22165d.add(str);
            }
        }
        AbstractC10896a.m65887i("PermissionCheckActivity", "forbidPermissions:" + this.f22164c);
        if (!this.f22165d.isEmpty()) {
            AbstractC10896a.m65887i("PermissionCheckActivity", "request permission list size:" + Arrays.toString(this.f22165d.toArray()));
            m29123T0(20001);
            return;
        }
        AbstractC10896a.m65887i("PermissionCheckActivity", "processUngrantedPermissions, go permission set page");
        if (z10) {
            m29124W0(this.f22164c, 20002);
            return;
        }
        Message message = new Message();
        message.what = 10001;
        message.arg1 = 20002;
        this.f22167f.sendMessage(message);
    }

    /* renamed from: S0 */
    public void mo21267S0(String str) {
    }

    /* renamed from: U0 */
    public void m29137U0() {
        try {
            setTheme(getResources().getIdentifier(C13843a.m83102x(), null, null));
        } catch (Exception e10) {
            AbstractC10896a.m65886e("PermissionCheckActivity", "setTheme exception: " + e10.toString());
        }
    }

    /* renamed from: V0 */
    public void m29138V0() {
        if (C0209d.m1269j1()) {
            m29137U0();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        AbstractC10896a.m65887i("PermissionCheckActivity", "onActivityResult, requestCode = " + i10 + ", resultCode = " + i11);
        if (i10 == 20001) {
            if (this.f22164c.size() > 0) {
                m29124W0(this.f22164c, 20002);
                return;
            }
            mo13484E0(i10);
        } else if (i10 == 20002) {
            mo21218M0();
            this.f22164c.clear();
            mo13484E0(i10);
        }
        if (mo19714J0(i10)) {
            if (this.f22164c.size() <= 0) {
                mo13484E0(i10);
            } else {
                m29124W0(this.f22164c, i10);
                this.f22164c.clear();
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
        m29139v0();
        mo29120L0();
        C0216g0.m1402e(this).m1447y(new SafeIntent(getIntent()));
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (mo21668H0()) {
            AbstractC10896a.m65887i("PermissionCheckActivity", "isCheckPermissionOverSea is true");
            C13205c.m79395d().m79396c();
        }
        m29129C0();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C0216g0.m1402e(this).m1447y(new SafeIntent(intent));
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length < 1) {
            return;
        }
        if (!C0209d.m1202Q0()) {
            C13205c.m79395d().m79396c();
            if (this.f22166e < this.f22165d.size() - 1) {
                AbstractC10896a.m65887i("PermissionCheckActivity", "requestPermissionOneByOne continue, current position: " + this.f22166e);
                m29123T0(i10);
                return;
            }
        }
        AbstractC10896a.m65887i("PermissionCheckActivity", "onRequestPermissionsResult" + i10);
        if (i10 == 20001) {
            if (this.f22164c.size() > 0) {
                m29124W0(this.f22164c, 20002);
                return;
            }
            mo13484E0(i10);
        }
        if (i10 == 20002) {
            this.f22164c.clear();
            mo13484E0(i10);
        }
        if (mo19714J0(i10)) {
            if (this.f22164c.size() > 0) {
                m29124W0(this.f22164c, i10);
            } else {
                mo13484E0(i10);
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        this.f22168g = System.currentTimeMillis();
        super.onResume();
        mo21227N0();
    }

    /* renamed from: v0 */
    public final void m29139v0() {
        new C0207c().m1137b(getIntent());
    }

    /* renamed from: w0 */
    public boolean m29140w0(String str) {
        List<String> listM69903b;
        List<String> listM69911k = this.f22163b.m69911k(str);
        if (listM69911k == null || listM69911k.size() == 0 || (listM69903b = this.f22163b.m69903b(this, listM69911k)) == null || listM69903b.size() == 0) {
            return true;
        }
        if (C0209d.m1202Q0()) {
            m29122O0(listM69903b, m29131G0(str));
            return false;
        }
        m29134P0(listM69903b, m29131G0(str));
        return false;
    }

    /* renamed from: x0 */
    public boolean m29141x0(List<String> list) {
        List<String> listM69903b;
        if (list == null || list.size() == 0 || (listM69903b = this.f22163b.m69903b(this, list)) == null || listM69903b.size() == 0) {
            return true;
        }
        if (C0209d.m1202Q0()) {
            m29122O0(listM69903b, m29131G0(CloudBackupConstant.Command.PMS_CMD_BACKUP));
            return false;
        }
        m29134P0(listM69903b, m29131G0(CloudBackupConstant.Command.PMS_CMD_BACKUP));
        return false;
    }

    /* renamed from: y0 */
    public void m29142y0(List<String> list) {
        List<String> listM69903b = this.f22163b.m69903b(this, list);
        if (listM69903b.size() <= 0) {
            mo21218M0();
        } else if (C0209d.m1202Q0()) {
            m29135Q0(listM69903b, false);
        } else {
            m29136R0(listM69903b, false);
        }
    }

    /* renamed from: z0 */
    public boolean m29143z0(String str) {
        return m29127A0(str, true);
    }
}
