package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.base.R$string;
import com.huawei.hicloud.notification.constants.HNConstants;
import ec.AlertDialogC9442a;
import ec.AlertDialogC9443b;
import ec.AlertDialogC9444c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0219i;
import p399jk.AbstractC10896a;
import p494nk.C11718b;
import p514o9.C11839m;
import p846zj.C14306d;
import uk.C13205c;

/* loaded from: classes3.dex */
public abstract class OOBEBaseAuthActivity extends OOBEBaseActivity {

    /* renamed from: B */
    public AlertDialog f12375B;

    /* renamed from: C */
    public boolean f12376C;

    /* renamed from: A */
    public C11718b f12374A = new C11718b();

    /* renamed from: D */
    public List<String> f12377D = new ArrayList();

    /* renamed from: E */
    public AlertDialogC9444c f12378E = null;

    /* renamed from: F */
    public AlertDialogC9442a f12379F = null;

    /* renamed from: G */
    public AlertDialogC9443b f12380G = null;

    /* renamed from: H */
    public List<String> f12381H = new ArrayList();

    /* renamed from: I */
    public int f12382I = -1;

    /* renamed from: J */
    public DialogInterface.OnClickListener f12383J = new DialogInterfaceOnClickListenerC2822a();

    /* renamed from: K */
    public DialogInterface.OnClickListener f12384K = new DialogInterfaceOnClickListenerC2823b();

    /* renamed from: L */
    public DialogInterface.OnClickListener f12385L = new DialogInterfaceOnClickListenerC2824c();

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEBaseAuthActivity$a */
    public class DialogInterfaceOnClickListenerC2822a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2822a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -2) {
                C11839m.m70688i("OOBEBaseAuthActivity", "mSecondCenterAuthAlertDialog click negative button");
            } else if (i10 == -1) {
                C11839m.m70688i("OOBEBaseAuthActivity", "mSecondCenterAuthAlertDialog click positive button");
                OOBEBaseAuthActivity.this.mo16632M0();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEBaseAuthActivity$b */
    public class DialogInterfaceOnClickListenerC2823b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2823b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -2) {
                C11839m.m70688i("OOBEBaseAuthActivity", "mAuthPrivacyOOBEDialog click negative button");
                return;
            }
            if (i10 == -1) {
                C11839m.m70688i("OOBEBaseAuthActivity", "mAuthPrivacyOOBEDialog click positive button");
                OOBEBaseAuthActivity oOBEBaseAuthActivity = OOBEBaseAuthActivity.this;
                if (oOBEBaseAuthActivity.f12380G == null) {
                    OOBEBaseAuthActivity oOBEBaseAuthActivity2 = OOBEBaseAuthActivity.this;
                    oOBEBaseAuthActivity.f12380G = new AlertDialogC9443b(oOBEBaseAuthActivity2, oOBEBaseAuthActivity2.f12385L);
                }
                OOBEBaseAuthActivity oOBEBaseAuthActivity3 = OOBEBaseAuthActivity.this;
                oOBEBaseAuthActivity3.m16637R0(oOBEBaseAuthActivity3.f12379F);
                OOBEBaseAuthActivity.this.f12380G.show();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEBaseAuthActivity$c */
    public class DialogInterfaceOnClickListenerC2824c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2824c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 != -2) {
                if (i10 == -1) {
                    C11839m.m70688i("OOBEBaseAuthActivity", "mAuthUserAgreementOOBEDialog click positive button");
                    OOBEBaseAuthActivity.this.mo16632M0();
                    return;
                }
                return;
            }
            C11839m.m70688i("OOBEBaseAuthActivity", "mAuthUserAgreementOOBEDialog click negative button");
            OOBEBaseAuthActivity oOBEBaseAuthActivity = OOBEBaseAuthActivity.this;
            if (oOBEBaseAuthActivity.f12379F == null) {
                OOBEBaseAuthActivity oOBEBaseAuthActivity2 = OOBEBaseAuthActivity.this;
                oOBEBaseAuthActivity.f12379F = new AlertDialogC9442a(oOBEBaseAuthActivity2, oOBEBaseAuthActivity2.f12384K);
            }
            OOBEBaseAuthActivity oOBEBaseAuthActivity3 = OOBEBaseAuthActivity.this;
            oOBEBaseAuthActivity3.m16637R0(oOBEBaseAuthActivity3.f12379F);
            OOBEBaseAuthActivity.this.f12379F.show();
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEBaseAuthActivity$d */
    public static class DialogInterfaceOnClickListenerC2825d implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public boolean f12389a;

        /* renamed from: b */
        public OOBEBaseAuthActivity f12390b;

        /* renamed from: c */
        public int f12391c;

        public DialogInterfaceOnClickListenerC2825d(OOBEBaseAuthActivity oOBEBaseAuthActivity, boolean z10, int i10) {
            this.f12389a = z10;
            this.f12390b = oOBEBaseAuthActivity;
            this.f12391c = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (this.f12390b == null) {
                AbstractC10896a.m65887i("OOBEBaseAuthActivity", "mActivity null");
            } else if (this.f12389a) {
                AbstractC10896a.m65887i("OOBEBaseAuthActivity", "dialog positive");
                C0209d.m1282m2(this.f12390b, this.f12391c);
            } else {
                AbstractC10896a.m65887i("OOBEBaseAuthActivity", "dialog cancel");
                this.f12390b.mo16629J0(this.f12391c);
            }
        }
    }

    /* renamed from: G0 */
    public boolean m16626G0(String str) {
        List<String> listM69909h;
        List<String> listM69903b;
        if (this.f12376C || (listM69909h = this.f12374A.m69909h(str)) == null || listM69909h.size() == 0 || (listM69903b = this.f12374A.m69903b(this, listM69909h)) == null || listM69903b.size() == 0) {
            return true;
        }
        m16633N0(listM69903b, m16630K0(str));
        return false;
    }

    /* renamed from: H0 */
    public void m16627H0(List<String> list) {
        List<String> listM69903b = this.f12374A.m69903b(this, list);
        if (listM69903b.size() > 0) {
            if (C0209d.m1202Q0()) {
                m16634O0(listM69903b);
            } else {
                m16635P0(listM69903b);
            }
        }
    }

    /* renamed from: I0 */
    public void mo16628I0() {
        try {
            AlertDialogC9444c alertDialogC9444c = this.f12378E;
            if (alertDialogC9444c != null) {
                alertDialogC9444c.dismiss();
                this.f12378E = null;
            }
            AlertDialogC9442a alertDialogC9442a = this.f12379F;
            if (alertDialogC9442a != null) {
                alertDialogC9442a.dismiss();
                this.f12379F = null;
            }
            AlertDialogC9443b alertDialogC9443b = this.f12380G;
            if (alertDialogC9443b != null) {
                alertDialogC9443b.dismiss();
                this.f12380G = null;
            }
        } catch (IllegalArgumentException unused) {
            C11839m.m70687e("OOBEBaseAuthActivity", "auth dialog dismiss IllegalArgumentException");
        }
    }

    /* renamed from: J0 */
    public void mo16629J0(int i10) {
    }

    /* renamed from: K0 */
    public final int m16630K0(String str) {
        if (str.equals("addressbook")) {
            return 20004;
        }
        if (str.equals("calendar")) {
            return 20005;
        }
        if (str.equals(HNConstants.DataType.MEDIA)) {
            return 20003;
        }
        return str.equals(CloudBackupConstant.Command.PMS_CMD_BACKUP) ? 20006 : 0;
    }

    /* renamed from: L0 */
    public final boolean m16631L0(int i10) {
        return 20004 == i10 || 20005 == i10 || 20003 == i10 || 20006 == i10;
    }

    /* renamed from: M0 */
    public void mo16632M0() {
    }

    /* renamed from: N0 */
    public final void m16633N0(List<String> list, int i10) {
        C11718b c11718b = new C11718b();
        ArrayList arrayList = new ArrayList();
        this.f12377D.clear();
        for (String str : list) {
            if (c11718b.m69913m(this, str)) {
                this.f12377D.add(str);
            } else {
                arrayList.add(str);
            }
        }
        if (arrayList.size() <= 0) {
            AbstractC10896a.m65887i("OOBEBaseAuthActivity", "go switch permission set page");
            m16639T0(this.f12377D, i10);
            return;
        }
        AbstractC10896a.m65887i("OOBEBaseAuthActivity", "request switch permission direct:" + arrayList.size());
        c11718b.m69914p(this, (String[]) arrayList.toArray(new String[0]), i10);
    }

    /* renamed from: O0 */
    public final void m16634O0(List<String> list) {
        AbstractC10896a.m65887i("OOBEBaseAuthActivity", "ungranted permissions are:" + list);
        C11718b c11718b = new C11718b();
        this.f12377D.clear();
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (c11718b.m69913m(this, str)) {
                this.f12377D.add(str);
            } else {
                arrayList.add(str);
            }
        }
        AbstractC10896a.m65887i("OOBEBaseAuthActivity", "forbidPermissions:" + this.f12377D);
        if (arrayList.size() <= 0) {
            AbstractC10896a.m65887i("OOBEBaseAuthActivity", "go permission set page");
            m16639T0(this.f12377D, 20002);
            return;
        }
        AbstractC10896a.m65887i("OOBEBaseAuthActivity", "request permission direct:" + arrayList.size());
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        AbstractC10896a.m65887i("OOBEBaseAuthActivity", "requestPermissions:" + strArr.length);
        c11718b.m69914p(this, strArr, 20001);
    }

    /* renamed from: P0 */
    public final void m16635P0(List<String> list) {
        AbstractC10896a.m65887i("OOBEBaseAuthActivity", "oversea ungranted permissions are:" + list);
        C11718b c11718b = new C11718b();
        this.f12377D.clear();
        this.f12381H.clear();
        this.f12382I = -1;
        for (String str : list) {
            if (c11718b.m69913m(this, str)) {
                this.f12377D.add(str);
            } else {
                this.f12381H.add(str);
            }
        }
        AbstractC10896a.m65887i("OOBEBaseAuthActivity", "forbidPermissions:" + this.f12377D);
        if (this.f12381H.isEmpty()) {
            AbstractC10896a.m65887i("OOBEBaseAuthActivity", "go permission set page");
            m16639T0(this.f12377D, 20002);
            return;
        }
        AbstractC10896a.m65887i("OOBEBaseAuthActivity", "request permission list size:" + Arrays.toString(this.f12381H.toArray()));
        m16636Q0(20001);
    }

    /* renamed from: Q0 */
    public final void m16636Q0(int i10) {
        int i11 = this.f12382I + 1;
        this.f12382I = i11;
        if (i11 >= this.f12381H.size()) {
            AbstractC10896a.m65887i("OOBEBaseAuthActivity", "requestPermissionOneByOne, request end");
            C13205c.m79395d().m79396c();
            onRequestPermissionsResult(i10, new String[0], new int[0]);
            this.f12377D.clear();
            this.f12381H.clear();
            this.f12382I = -1;
            return;
        }
        try {
            String str = this.f12381H.get(this.f12382I);
            AbstractC10896a.m65887i("OOBEBaseAuthActivity", "requestPermissionOneByOne permissionName: " + str + ", curRequestPermissionPosition: " + this.f12382I);
            if (checkSelfPermission(str) == 0 || this.f12374A.m69913m(this, str)) {
                AbstractC10896a.m65887i("OOBEBaseAuthActivity", "requestPermissionOneByOne current permission have been granted");
                m16636Q0(i10);
            } else {
                AbstractC10896a.m65887i("OOBEBaseAuthActivity", "requestPermissionOneByOne start request");
                C13205c.m79395d().m79399g(this, str);
                this.f12374A.m69914p(this, C11718b.m69900j(str), i10);
            }
        } catch (Exception e10) {
            AbstractC10896a.m65887i("OOBEBaseAuthActivity", "requestPermissionOneByOne failed, e: " + e10.getMessage());
        }
    }

    /* renamed from: R0 */
    public final void m16637R0(Dialog dialog) {
        if (C0219i.m1465c()) {
            m16607r0(dialog);
        }
    }

    /* renamed from: S0 */
    public void m16638S0() {
        if (C14306d.m85208i()) {
            if (this.f12378E == null) {
                this.f12378E = new AlertDialogC9444c(this, this.f12383J);
            }
            m16637R0(this.f12378E);
            this.f12378E.show();
            return;
        }
        if (this.f12379F == null) {
            this.f12379F = new AlertDialogC9442a(this, this.f12384K);
        }
        m16637R0(this.f12379F);
        this.f12379F.show();
    }

    /* renamed from: T0 */
    public final void m16639T0(List<String> list, int i10) {
        AbstractC10896a.m65887i("OOBEBaseAuthActivity", "show set permission dialog");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setMessage(this.f12374A.m69905d(list, this)).setPositiveButton(R$string.set_permission, new DialogInterfaceOnClickListenerC2825d(this, true, i10)).setNegativeButton(R$string.cancel, new DialogInterfaceOnClickListenerC2825d(this, false, i10)).create();
        this.f12375B = alertDialogCreate;
        alertDialogCreate.setCancelable(false);
        if (isFinishing() || isDestroyed()) {
            AbstractC10896a.m65886e("OOBEBaseAuthActivity", "showPermissionDialog,the activity is not avaiable");
        } else {
            this.f12375B.show();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        AbstractC10896a.m65887i("OOBEBaseAuthActivity", "onActivityResult, requestCode = " + i10 + ", resultCode = " + i11);
        if (i10 == 20001) {
            if (this.f12377D.size() > 0) {
                m16639T0(this.f12377D, 20002);
                return;
            }
            mo16629J0(i10);
        } else if (i10 == 20002) {
            this.f12377D.clear();
            mo16629J0(i10);
        }
        if (m16631L0(i10)) {
            mo16629J0(i10);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        this.f12376C = true;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C13205c.m79395d().m79396c();
        mo16628I0();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        AbstractC10896a.m65887i("OOBEBaseAuthActivity", "onRequestPermissionsResult, requestCode = " + i10);
        if (!C0209d.m1202Q0()) {
            C13205c.m79395d().m79396c();
            if (this.f12382I < this.f12381H.size() - 1) {
                AbstractC10896a.m65887i("OOBEBaseAuthActivity", "requestPermissionOneByOne continue, current position: " + this.f12382I);
                m16636Q0(i10);
                return;
            }
        }
        if (i10 == 20001 || i10 == 20002) {
            if (this.f12377D.size() > 0) {
                m16639T0(this.f12377D, 20002);
                return;
            }
            mo16629J0(i10);
        }
        if (m16631L0(i10)) {
            if (this.f12377D.size() <= 0) {
                mo16629J0(i10);
            } else {
                m16639T0(this.f12377D, i10);
                this.f12377D.clear();
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f12376C = false;
    }
}
