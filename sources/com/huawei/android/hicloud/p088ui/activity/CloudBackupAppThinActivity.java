package com.huawei.android.hicloud.p088ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.uiadapter.CloudBackupAppThinAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.CloudAppThinConfirmDialog;
import com.huawei.android.hicloud.task.simple.C3045j;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.ThinAppStatus;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0223k;
import p514o9.C11839m;
import p616rk.C12515a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudBackupAppThinActivity extends CloudBackupBaseUiActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    /* renamed from: C */
    public CheckBox f13874C;

    /* renamed from: D */
    public TextView f13875D;

    /* renamed from: E */
    public AutoSizeButton f13876E;

    /* renamed from: F */
    public CloudBackupAppThinAdapter f13877F;

    /* renamed from: G */
    public CloudAppThinConfirmDialog f13878G;

    /* renamed from: H */
    public String f13879H;

    /* renamed from: I */
    public ArrayList<ThinAppStatus> f13880I;

    /* renamed from: J */
    public long f13881J;

    /* renamed from: K */
    public final Handler.Callback f13882K = new Handler.Callback() { // from class: com.huawei.android.hicloud.ui.activity.y1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f17815a.m19227X1(message);
        }
    };

    /* renamed from: V1 */
    private void m19226V1() {
        m19228Z1();
    }

    /* renamed from: X1 */
    public /* synthetic */ boolean m19227X1(Message message) {
        Bundle data;
        int i10 = message.what;
        if (i10 == 20012) {
            if (message.arg1 != 30001 || (data = message.getData()) == null) {
                mo19229P1(R$string.thin_empty_thin_app, R$drawable.app_thin_empty_ic);
            } else {
                ArrayList<ThinAppStatus> parcelableArrayList = data.getParcelableArrayList("thinAppList");
                this.f13880I = parcelableArrayList;
                if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                    mo19229P1(R$string.thin_empty_thin_app, R$drawable.app_thin_empty_ic);
                } else {
                    mo19236O1();
                    long j10 = data.getLong("totalSize");
                    this.f13881J = j10;
                    this.f13875D.setText(C0223k.m1524g(this, j10));
                    this.f13877F.m24862c(this.f13880I);
                    m19233a2();
                }
            }
        } else if (i10 == 20013) {
            m19237Q1(R$string.connect_server_fail_msg1);
        } else if (i10 == 20011) {
            C12515a.m75110o().m75172d(new C3045j(2, this.f13879H));
        } else if (i10 == 20014) {
            ArrayList<ThinAppStatus> arrayList = this.f13880I;
            if (arrayList == null) {
                return false;
            }
            Iterator<ThinAppStatus> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == 1) {
                    it.remove();
                }
            }
            if (this.f13880I.size() > 0) {
                this.f13877F.m24862c(this.f13880I);
            } else {
                mo19229P1(R$string.thin_empty_thin_app, R$drawable.app_thin_empty_ic);
            }
            C11839m.m70688i("CloudBackupAppThinActivity", "transfer success");
        } else if (i10 == 20015) {
            C11839m.m70688i("CloudBackupAppThinActivity", "transfer fail");
        }
        return false;
    }

    /* renamed from: Z1 */
    private void m19228Z1() {
        String stringExtra = new SafeIntent(getIntent()).getStringExtra(CloudBackupConstant.BACKUP_DEVICE_ID);
        this.f13879H = stringExtra;
        C12515a.m75110o().m75172d(new C3045j(1, stringExtra));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity
    /* renamed from: P1 */
    public void mo19229P1(int i10, int i11) {
        super.mo19229P1(i10, i11);
        this.f13891v.setVisibility(0);
        this.f13891v.setText(R$string.app_thin_tip);
    }

    /* renamed from: U1 */
    public void m19230U1() {
        ArrayList<ThinAppStatus> arrayList = this.f13880I;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<ThinAppStatus> it = this.f13880I.iterator();
        while (it.hasNext()) {
            ThinAppStatus next = it.next();
            if (next.getAction() == 0) {
                next.setType(1);
                arrayList2.add(next.getBackupAppName());
            }
            C12515a.m75110o().m75172d(new C3045j(3, this.f13879H, arrayList2));
        }
    }

    /* renamed from: W1 */
    public void m19231W1() {
        m22365E1(R$string.app_thin);
        LayoutInflater.from(this).inflate(R$layout.activity_app_thin, (ViewGroup) this.f13894y, true);
        this.f13874C = (CheckBox) C12809f.m76829b(this, R$id.cb_all);
        this.f13875D = (TextView) C12809f.m76829b(this, R$id.tv_total_des);
        ListView listView = (ListView) C12809f.m76829b(this, R$id.lv_app_thin);
        this.f13876E = (AutoSizeButton) C12809f.m76829b(this, R$id.bt_app_thin);
        CloudBackupAppThinAdapter cloudBackupAppThinAdapter = new CloudBackupAppThinAdapter(this);
        this.f13877F = cloudBackupAppThinAdapter;
        listView.setAdapter((ListAdapter) cloudBackupAppThinAdapter);
        this.f13874C.setOnClickListener(this);
        this.f13876E.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        m19238R1();
        this.f13878G = new CloudAppThinConfirmDialog(this);
        CBCallBack.getInstance().registerCallback(this.f13882K);
    }

    /* renamed from: Y1 */
    public final void m19232Y1() {
        boolean zIsChecked = this.f13874C.isChecked();
        this.f13876E.setEnabled(zIsChecked);
        ArrayList<ThinAppStatus> arrayList = this.f13880I;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int i10 = !zIsChecked ? 1 : 0;
        Iterator<ThinAppStatus> it = this.f13880I.iterator();
        while (it.hasNext()) {
            it.next().setAction(i10);
        }
        this.f13876E.setText(zIsChecked ? getString(R$string.thin_now_selected, C0223k.m1524g(this, this.f13881J)) : getString(R$string.thin_now));
        this.f13877F.m24862c(this.f13880I);
    }

    /* renamed from: a2 */
    public final void m19233a2() {
        ArrayList<ThinAppStatus> arrayList = this.f13880I;
        if (arrayList == null || arrayList.size() <= 0) {
            mo19229P1(R$string.thin_empty_thin_app, R$drawable.app_thin_empty_ic);
            return;
        }
        Iterator<ThinAppStatus> it = this.f13880I.iterator();
        long appDelTotalSize = 0;
        boolean z10 = true;
        boolean z11 = false;
        while (it.hasNext()) {
            ThinAppStatus next = it.next();
            C11839m.m70686d("CloudBackupAppThinActivity", "appId =" + next.getAppName() + " action = " + next.getAction());
            boolean z12 = next.getAction() == 0;
            z10 = z12 && z10;
            z11 = next.getAction() != 1 || z11;
            if (z12) {
                appDelTotalSize += next.getAppDelTotalSize();
            }
        }
        this.f13874C.setChecked(z10);
        this.f13876E.setEnabled(z11);
        this.f13876E.setText(z11 ? getString(R$string.thin_now_selected, C0223k.m1524g(this, appDelTotalSize)) : getString(R$string.thin_now));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13885p);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.bt_app_thin) {
            this.f13878G.show(this.f13880I);
        } else if (id2 == R$id.cb_all) {
            m19232Y1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m19231W1();
        mo19005p1();
        m19226V1();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        ArrayList<ThinAppStatus> arrayList = this.f13880I;
        if (arrayList != null) {
            ThinAppStatus thinAppStatus = arrayList.get(i10);
            thinAppStatus.setAction(thinAppStatus.getAction() == 0 ? 1 : 0);
            this.f13877F.m24862c(this.f13880I);
        }
        m19233a2();
    }
}
