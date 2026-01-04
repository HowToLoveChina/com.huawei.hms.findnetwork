package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.DiskDeleteDialog;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hms.network.embedded.C5963j;
import p015ak.C0209d;
import p020ap.C1006a;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13225d;
import p684un.C13230i;
import p783xp.C13843a;
import p850zo.InterfaceC14351b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class DiskAppDetailActivity extends UIActivity implements View.OnClickListener, InterfaceC14351b {

    /* renamed from: A */
    public ProgressDialog f14719A;

    /* renamed from: B */
    public Handler f14720B;

    /* renamed from: D */
    public ImageView f14722D;

    /* renamed from: r */
    public long f14726r;

    /* renamed from: s */
    public String f14727s;

    /* renamed from: t */
    public boolean f14728t;

    /* renamed from: u */
    public boolean f14729u;

    /* renamed from: v */
    public boolean f14730v;

    /* renamed from: y */
    public DiskDeleteDialog f14733y;

    /* renamed from: p */
    public TextView f14724p = null;

    /* renamed from: q */
    public ImageView f14725q = null;

    /* renamed from: w */
    public Button f14731w = null;

    /* renamed from: x */
    public TextView f14732x = null;

    /* renamed from: z */
    public boolean f14734z = false;

    /* renamed from: C */
    public Handler.Callback f14721C = new C3270a();

    /* renamed from: E */
    public DialogInterface.OnCancelListener f14723E = new DialogInterfaceOnCancelListenerC3272c();

    /* renamed from: com.huawei.android.hicloud.ui.activity.DiskAppDetailActivity$a */
    public class C3270a implements Handler.Callback {
        public C3270a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (32309 == message.what) {
                if (!DiskAppDetailActivity.this.f14728t && message.arg1 == 0) {
                    DiskAppDetailActivity.this.m20382R1();
                } else if (DiskAppDetailActivity.this.f14728t) {
                    DiskAppDetailActivity.this.m20383S1(message.arg1, message.arg2);
                }
                DiskAppDetailActivity.this.f14730v = false;
            }
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DiskAppDetailActivity$b */
    public class HandlerC3271b extends Handler {
        public HandlerC3271b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (7 == message.what) {
                ProgressDialog progressDialog = DiskAppDetailActivity.this.f14719A;
                if (progressDialog != null) {
                    progressDialog.dismiss();
                    DiskAppDetailActivity.this.f14719A = null;
                }
                if (((Bundle) message.obj).getInt(C5963j.f27041j) == 0) {
                    DiskAppDetailActivity.this.m20382R1();
                    C11839m.m70688i("DiskAppDetailActivity", "delete success.");
                } else {
                    DiskAppDetailActivity.this.m20381Y1(8);
                    C11839m.m70688i("DiskAppDetailActivity", "delete failed.");
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DiskAppDetailActivity$c */
    public class DialogInterfaceOnCancelListenerC3272c implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC3272c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            DiskAppDetailActivity.this.f14734z = false;
        }
    }

    /* renamed from: U1 */
    private void m20379U1() {
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.disk_app_detail_main_layout);
        this.f14724p = (TextView) C12809f.m76829b(this, R$id.disk_app_size_value);
        int i10 = R$id.disk_app_detail_page_icon;
        this.f14725q = (ImageView) C12809f.m76829b(this, i10);
        this.f14731w = (Button) C12809f.m76829b(this, R$id.disk_app_detail_delete);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.disk_notepad_tips);
        this.f14732x = textView;
        textView.setVisibility(8);
        this.f14722D = (ImageView) C12809f.m76829b(this, i10);
        if (C0209d.m1269j1()) {
            this.f14722D.setImageDrawable(getResources().getDrawable(R$drawable.ic_home_disk_normal_honor));
        } else {
            this.f14722D.setImageDrawable(getResources().getDrawable(R$drawable.ic_home_disk_normal));
        }
        if (getResources().getConfiguration().orientation == 2) {
            DisplayMetrics displayMetricsM70876w = C11842p.m70876w(this);
            RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.gellery_detail_page_left_frame);
            if (relativeLayout2 != null) {
                ViewGroup.LayoutParams layoutParams = relativeLayout2.getLayoutParams();
                layoutParams.width = (displayMetricsM70876w.widthPixels * 5) / 12;
                relativeLayout2.setLayoutParams(layoutParams);
            }
            if (C11842p.m70771U0()) {
                C11842p.m70775V1(this, relativeLayout);
            }
        }
        if (C11842p.m70771U0() && getResources().getConfiguration().orientation == 1) {
            C11842p.m70778W1(this, this.f14731w);
        }
    }

    /* renamed from: X1 */
    private void m20380X1() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.f14719A = progressDialog;
        progressDialog.setMessage(getResources().getString(R$string.hicloud_notepad_deleting));
        this.f14719A.setCancelable(false);
        this.f14719A.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y1 */
    public void m20381Y1(int i10) {
        String string;
        if (6 == i10) {
            string = getString(R$string.hicloud_notepad_deleting);
        } else if (5 == i10) {
            string = getString(R$string.hicloud_notepad_delete_failed);
        } else if (8 == i10) {
            C11839m.m70688i("DiskAppDetailActivity", "GALLERYDELETE_FAIL and showtoast");
            string = getString(R$string.hicloud_gallery_recylcle_clear_failed);
        } else {
            string = "";
        }
        Toast.makeText(this, string, 0).show();
    }

    /* renamed from: R1 */
    public final void m20382R1() {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("disk_app_item_id_param", this.f14727s);
            intent.putExtra("disk_app_item_size_param", this.f14726r);
            setResult(101, intent);
            finish();
        }
    }

    /* renamed from: S1 */
    public final void m20383S1(int i10, int i11) {
        Intent intent;
        if (i11 != 0) {
            m20381Y1(i11);
            return;
        }
        if ((!this.f14729u || i10 == 0) && (intent = getIntent()) != null) {
            intent.putExtra("disk_app_item_id_param", this.f14727s);
            intent.putExtra("disk_app_item_size_param", this.f14726r);
            setResult(101, intent);
            finish();
        }
    }

    /* renamed from: T1 */
    public final void m20384T1() {
        CloudBackupService.getInstance().register(this.f14721C);
        Intent intent = getIntent();
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("disk_app_item_size_str_param");
                this.f14726r = intent.getLongExtra("disk_app_item_size_param", 0L);
                this.f14727s = intent.getStringExtra("disk_app_item_id_param");
                boolean booleanExtra = intent.getBooleanExtra("disk_app_item_delete_param", false);
                this.f14728t = intent.getBooleanExtra("disk_app_item_sync_param", false);
                this.f14729u = intent.getBooleanExtra("disk_app_item_history_data_param", false);
                int intExtra = intent.getIntExtra("disk_app_item_icon_param", 0);
                if (intExtra != 0) {
                    this.f14725q.setImageDrawable(getDrawable(intExtra));
                }
                if (!booleanExtra) {
                    this.f14731w.setVisibility(8);
                }
                this.f14724p.setText(stringExtra);
                this.f14733y = new DiskDeleteDialog(this, this.f14727s);
                this.f14731w.setVisibility(0);
                this.f14731w.setOnClickListener(this);
                if ("notepad".equals(this.f14727s)) {
                    this.f14732x.setVisibility(0);
                    this.f14731w.setText(getString(R$string.cloudbackup_btn_delete_all));
                } else if ("gallerydelete".equals(this.f14727s)) {
                    this.f14732x.setVisibility(8);
                    this.f14731w.setText(getString(R$string.clear_button));
                } else {
                    this.f14732x.setVisibility(8);
                    this.f14731w.setText(getString(R$string.cloudbackup_btn_delete));
                }
            } catch (Exception unused) {
                C11839m.m70687e("DiskAppDetailActivity", "intent Serializable error.");
            }
        }
    }

    /* renamed from: V1 */
    public void m20385V1() {
        C11839m.m70686d("DiskAppDetailActivity", "onDeleteConfirmed");
        if ("notepad".equals(this.f14727s) && this.f14728t) {
            CloudBackupService.getInstance().deleteRecord(this.f14727s, true);
            this.f14730v = true;
        } else if (!"gallerydelete".equals(this.f14727s)) {
            CloudBackupService.getInstance().deleteRecord(this.f14727s, false);
        } else {
            m20380X1();
            C1006a.m5936k().m5959e(this, this);
        }
    }

    /* renamed from: W1 */
    public void m20386W1(boolean z10) {
        this.f14734z = z10;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (R$id.disk_app_detail_delete == view.getId()) {
            C11839m.m70686d("DiskAppDetailActivity", "backup_detail_delete click");
            if (!C0209d.m1333z1(this)) {
                Toast.makeText(this, getString(R$string.gallery_no_network_tips), 0).show();
                return;
            }
            if (this.f14730v) {
                Toast.makeText(this, getString(R$string.hicloud_notepad_deleting), 0).show();
                return;
            }
            this.f14733y.show();
            this.f14734z = true;
            this.f14733y.setOnCancelListener(this.f14723E);
            this.f14733y.getButton(-1).setTextColor(getResources().getColor(R$color.red));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.disk_app_detail);
        this.f14720B = new HandlerC3271b();
        m20379U1();
        C11842p.m70780X0(this.f14731w, this);
        m20384T1();
        String strM16168p = C2783d.m16168p(this, this.f14727s);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(strM16168p);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f14721C != null) {
            CloudBackupService.getInstance().unregister(this.f14721C);
        }
        DiskDeleteDialog diskDeleteDialog = this.f14733y;
        if (diskDeleteDialog != null) {
            diskDeleteDialog.dismiss();
            this.f14733y = null;
        }
        Handler handler = this.f14720B;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f14720B = null;
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        boolean z10 = bundle.getBoolean("isShowDeleteDialog");
        this.f14734z = z10;
        if (z10) {
            this.f14733y.show();
            this.f14733y.setOnCancelListener(this.f14723E);
            this.f14733y.getButton(-1).setTextColor(getResources().getColor(R$color.red));
        }
    }

    @Override // p850zo.InterfaceC14351b
    public void onResult(Bundle bundle) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 7;
        messageObtain.obj = bundle;
        this.f14720B.sendMessageDelayed(messageObtain, 1000L);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isShowDeleteDialog", this.f14734z);
    }
}
