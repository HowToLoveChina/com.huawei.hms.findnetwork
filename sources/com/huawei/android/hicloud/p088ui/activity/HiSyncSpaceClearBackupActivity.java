package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.content.ContextCompat;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.hisync.model.BackupDetailItem;
import com.huawei.android.hicloud.p088ui.activity.HiSyncSpaceClearBackupActivity;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.uiadapter.BackUpDeviceSpaceAdapter;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.gson.reflect.TypeToken;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisabledListView;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hicloud.request.cbs.bean.CBSDeviceCleanItem;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.uikit.phone.hwcheckbox.widget.HwCheckBox;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import gl.C9961b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0209d;
import p015ak.C0223k;
import p015ak.C0241z;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p618rm.C12540b1;
import p664u0.C13108a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p783xp.C13843a;
import p807yd.C13948d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class HiSyncSpaceClearBackupActivity extends HMSTermsProcessBaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, BackUpDeviceSpaceAdapter.DeviceCheckedCallback {

    /* renamed from: A */
    public View f14959A;

    /* renamed from: B */
    public View f14960B;

    /* renamed from: C */
    public long f14961C;

    /* renamed from: G */
    public List<CBSDeviceCleanItem> f14965G;

    /* renamed from: I */
    public ProgressDialog f14967I;

    /* renamed from: J */
    public AlertDialog f14968J;

    /* renamed from: K */
    public AlertDialog f14969K;

    /* renamed from: L */
    public C11060c f14970L;

    /* renamed from: M */
    public List<CBSDeviceCleanItem> f14971M;

    /* renamed from: N */
    public BackUpDeviceSpaceAdapter f14972N;

    /* renamed from: O */
    public HandlerC3318c f14973O;

    /* renamed from: p */
    public long f14975p;

    /* renamed from: q */
    public View f14976q;

    /* renamed from: r */
    public AutoSizeButton f14977r;

    /* renamed from: s */
    public View f14978s;

    /* renamed from: t */
    public HiCloudExceptionView f14979t;

    /* renamed from: u */
    public View f14980u;

    /* renamed from: v */
    public HwTextView f14981v;

    /* renamed from: w */
    public View f14982w;

    /* renamed from: x */
    public ScrollDisabledListView f14983x;

    /* renamed from: y */
    public View f14984y;

    /* renamed from: z */
    public View f14985z;

    /* renamed from: D */
    public long f14962D = 0;

    /* renamed from: E */
    public boolean f14963E = false;

    /* renamed from: F */
    public boolean f14964F = false;

    /* renamed from: H */
    public int f14966H = 3;

    /* renamed from: P */
    public Handler.Callback f14974P = new C3316a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.HiSyncSpaceClearBackupActivity$a */
    public class C3316a implements Handler.Callback {
        public C3316a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 33055) {
                return false;
            }
            C11839m.m70688i("HiSyncSpaceClearBackupActivity", " HiSyncSpaceClearBackupActivity notifyDataSetChanged:");
            HiSyncSpaceClearBackupActivity.this.f14972N.notifyDataSetChanged();
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HiSyncSpaceClearBackupActivity$b */
    public class C3317b extends TypeToken<List<CBSDeviceCleanItem>> {
        public C3317b() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HiSyncSpaceClearBackupActivity$c */
    public static class HandlerC3318c extends Handler {

        /* renamed from: a */
        public final WeakReference<HiSyncSpaceClearBackupActivity> f14988a;

        public /* synthetic */ HandlerC3318c(HiSyncSpaceClearBackupActivity hiSyncSpaceClearBackupActivity, C3316a c3316a) {
            this(hiSyncSpaceClearBackupActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
            HiSyncSpaceClearBackupActivity hiSyncSpaceClearBackupActivity = this.f14988a.get();
            if (hiSyncSpaceClearBackupActivity == null || hiSyncSpaceClearBackupActivity.isFinishing()) {
                C11839m.m70689w("HiSyncSpaceClearBackupActivity", "activity null or isFinishing!");
                return;
            }
            C11839m.m70688i("HiSyncSpaceClearBackupActivity", "handleMessage: " + message.what);
            int i10 = message.what;
            if (1 == i10) {
                hiSyncSpaceClearBackupActivity.m20668g2(message.obj, message.arg1);
                return;
            }
            if (2 == i10) {
                hiSyncSpaceClearBackupActivity.m20665d2(message.obj);
            } else if (3 == i10) {
                hiSyncSpaceClearBackupActivity.m20667f2();
            } else if (4 == i10) {
                hiSyncSpaceClearBackupActivity.m20666e2();
            }
        }

        public HandlerC3318c(HiSyncSpaceClearBackupActivity hiSyncSpaceClearBackupActivity) {
            super(Looper.getMainLooper());
            this.f14988a = new WeakReference<>(hiSyncSpaceClearBackupActivity);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HiSyncSpaceClearBackupActivity$d */
    public class DialogInterfaceOnClickListenerC3319d implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public List<CBSDeviceCleanItem> f14989a;

        public DialogInterfaceOnClickListenerC3319d(List<CBSDeviceCleanItem> list) {
            this.f14989a = list;
        }

        /* renamed from: a */
        public final void m20676a(List<CBSDeviceCleanItem> list) {
            if (list == null || list.size() == 0) {
                C11839m.m70687e("HiSyncSpaceClearBackupActivity", "deleteDeviceSpace is empty");
                return;
            }
            C11839m.m70688i("HiSyncSpaceClearBackupActivity", "deleteDeviceSpace:" + list.size());
            HiSyncSpaceClearBackupActivity.this.m20661v2();
            C12515a c12515aM75110o = C12515a.m75110o();
            HiSyncSpaceClearBackupActivity hiSyncSpaceClearBackupActivity = HiSyncSpaceClearBackupActivity.this;
            c12515aM75110o.m75172d(hiSyncSpaceClearBackupActivity.new C3322g(hiSyncSpaceClearBackupActivity.f14973O, list, HiSyncSpaceClearBackupActivity.this.f14964F));
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (C0209d.m1226Y0()) {
                C11839m.m70689w("HiSyncSpaceClearBackupActivity", "click too fast");
            } else {
                m20676a(this.f14989a);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HiSyncSpaceClearBackupActivity$e */
    public static class C3320e extends AbstractC12367d {

        /* renamed from: a */
        public final Handler f14991a;

        public C3320e(Handler handler) {
            this.f14991a = handler;
        }

        /* renamed from: e */
        public static /* synthetic */ int m20678e(CBSDeviceCleanItem cBSDeviceCleanItem, CBSDeviceCleanItem cBSDeviceCleanItem2) {
            return Long.compare(C0241z.m1688f(cBSDeviceCleanItem.getCbsDevice().getBakUpdateTime()), C0241z.m1688f(cBSDeviceCleanItem2.getCbsDevice().getBakUpdateTime()));
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            ArrayList arrayList = new ArrayList();
            int iM61796h = C9961b.m61788i().m61796h();
            List<CBSDevice> listM61807u = C9961b.m61788i().m61807u();
            if (C0209d.m1205R0(listM61807u)) {
                C11839m.m70688i("HiSyncSpaceClearBackupActivity", "queryDeviceDeleteList empty");
            } else {
                C11839m.m70688i("HiSyncSpaceClearBackupActivity", "queryDeviceDeleteList:" + listM61807u.size());
                List<HashMap<String, String>> listM61798k = C9961b.m61788i().m61798k();
                for (CBSDevice cBSDevice : listM61807u) {
                    CBSDeviceCleanItem cBSDeviceCleanItem = new CBSDeviceCleanItem(false, cBSDevice);
                    cBSDeviceCleanItem.setCurrent(false);
                    cBSDeviceCleanItem.setSendPush(m20679d(cBSDevice.getAppVersion(), listM61798k));
                    arrayList.add(cBSDeviceCleanItem);
                }
                arrayList.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.o5
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return HiSyncSpaceClearBackupActivity.C3320e.m20678e((CBSDeviceCleanItem) obj, (CBSDeviceCleanItem) obj2);
                    }
                });
            }
            Handler handler = this.f14991a;
            if (handler != null) {
                Message.obtain(handler, 1, iM61796h, 0, C12540b1.m75485c(arrayList)).sendToTarget();
            }
        }

        /* renamed from: d */
        public final boolean m20679d(String str, List<HashMap<String, String>> list) {
            if (list == null || list.size() == 0) {
                C11839m.m70687e("HiSyncSpaceClearBackupActivity", "checkAppVersion：empty version range");
                return false;
            }
            try {
                C11839m.m70686d("HiSyncSpaceClearBackupActivity", "checkAppVersion： " + list);
                long jM1689g = C0241z.m1689g(str, 0L);
                for (int i10 = 0; i10 < list.size(); i10++) {
                    HashMap<String, String> map = list.get(i10);
                    String str2 = map.containsKey("start") ? map.get("start") : null;
                    String str3 = map.containsKey("end") ? map.get("end") : null;
                    if (jM1689g >= C0241z.m1688f(str2) && jM1689g <= C0241z.m1688f(str3)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception unused) {
                C11839m.m70687e("HiSyncSpaceClearBackupActivity", "checkAppVersion Exception");
                return false;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HiSyncSpaceClearBackupActivity$f */
    public class C3321f extends AbstractC12367d {

        /* renamed from: a */
        public final Handler f14992a;

        /* renamed from: b */
        public final boolean f14993b;

        /* renamed from: c */
        public final CBSDevice f14994c;

        /* renamed from: d */
        public final CountDownLatch f14995d;

        public C3321f(Handler handler, boolean z10, CBSDevice cBSDevice, CountDownLatch countDownLatch) {
            this.f14992a = handler;
            this.f14993b = z10;
            this.f14994c = cBSDevice;
            this.f14995d = countDownLatch;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v3, types: [java.util.concurrent.CountDownLatch] */
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                try {
                    C9961b.m61788i().m61792d(this.f14994c, this.f14993b ? 1 : 0);
                    C9961b.m61788i().m61791c(this.f14994c.getDeviceId());
                    C11839m.m70688i("HiSyncSpaceClearBackupActivity", "deleteDeviceBackupRecord success");
                    Handler handler = this.f14992a;
                    if (handler != null) {
                        Message.obtain(handler, 2, this.f14994c).sendToTarget();
                    }
                } catch (Exception e10) {
                    HiSyncSpaceClearBackupActivity.this.f14963E = true;
                    C11839m.m70688i("HiSyncSpaceClearBackupActivity", "deleteDeviceBackupRecordReq error:" + e10.getMessage());
                }
            } finally {
                C11839m.m70688i("HiSyncSpaceClearBackupActivity", "countDownLatch countDown:");
                this.f14995d.countDown();
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.BACKUP_DELETE;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HiSyncSpaceClearBackupActivity$g */
    public class C3322g extends AbstractC12367d {

        /* renamed from: a */
        public final Handler f14997a;

        /* renamed from: b */
        public final List<CBSDeviceCleanItem> f14998b;

        /* renamed from: c */
        public final boolean f14999c;

        public C3322g(Handler handler, List<CBSDeviceCleanItem> list, boolean z10) {
            this.f14997a = handler;
            this.f14998b = list;
            this.f14999c = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException {
            int size = this.f14998b.size();
            CountDownLatch countDownLatch = new CountDownLatch(size);
            boolean zAwait = false;
            for (int i10 = 0; i10 < size; i10++) {
                C12515a.m75110o().m75175e(HiSyncSpaceClearBackupActivity.this.new C3321f(this.f14997a, this.f14999c, this.f14998b.get(i10).getCbsDevice(), countDownLatch), false);
            }
            try {
                zAwait = countDownLatch.await(50L, TimeUnit.SECONDS);
                C11839m.m70686d("HiSyncSpaceClearBackupActivity", "isFinish：" + zAwait);
            } catch (InterruptedException e10) {
                C11839m.m70688i("HiSyncSpaceClearBackupActivity", "countDownLatch error:" + e10.getMessage());
            }
            List<Runnable> listM75171c1 = C12515a.m75110o().m75171c1();
            if (!HiSyncSpaceClearBackupActivity.this.f14963E && zAwait && C0209d.m1205R0(listM75171c1)) {
                C11839m.m70688i("HiSyncSpaceClearBackupActivity", "delete success!");
                Handler handler = this.f14997a;
                if (handler != null) {
                    Message.obtain(handler, 3).sendToTarget();
                    return;
                }
                return;
            }
            C11839m.m70689w("HiSyncSpaceClearBackupActivity", "some task execute failed");
            Handler handler2 = this.f14997a;
            if (handler2 != null) {
                Message.obtain(handler2, 4).sendToTarget();
            }
        }
    }

    /* renamed from: b2 */
    private void m20652b2() {
        if (this.f14975p != C9961b.m61788i().m61805s()) {
            C11839m.m70688i("HiSyncSpaceClearBackupActivity", "refresh backup space");
            m20658o2();
        }
    }

    /* renamed from: c2 */
    private void m20653c2(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* renamed from: h2 */
    private void m20654h2() {
        this.f14961C = 0L;
        this.f14962D = 0L;
        this.f14963E = false;
        this.f14964F = false;
        this.f14965G = null;
        List<CBSDeviceCleanItem> list = this.f14971M;
        if (list == null) {
            this.f14971M = new ArrayList();
        } else {
            list.clear();
        }
        AutoSizeButton autoSizeButton = this.f14977r;
        if (autoSizeButton != null) {
            autoSizeButton.setTextColor(getColor(R$color.device_space_clear_color_disable));
        }
        m20659t2();
        C12515a.m75110o().m75172d(new C3320e(this.f14973O));
    }

    /* renamed from: i2 */
    private void m20655i2() {
        this.f14976q = C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f14977r = (AutoSizeButton) C12809f.m76829b(this, R$id.delete_button);
        this.f14978s = C12809f.m76829b(this, R$id.backups_detail_frame);
        this.f14979t = (HiCloudExceptionView) C12809f.m76829b(this, R$id.backup_clear_exception_view);
        this.f14980u = C12809f.m76829b(this, R$id.backup_clear_title);
        this.f14981v = (HwTextView) C12809f.m76829b(this, R$id.backup_clear_textview);
        this.f14982w = C12809f.m76829b(this, R$id.backup_device_content);
        ScrollDisabledListView scrollDisabledListView = (ScrollDisabledListView) C12809f.m76829b(this, R$id.backup_device_list);
        this.f14983x = scrollDisabledListView;
        scrollDisabledListView.setOnItemClickListener(this);
        this.f14984y = C12809f.m76829b(this, R$id.backups_query_no_data);
        this.f14985z = C12809f.m76829b(this, R$id.no_data_image_frame);
        this.f14959A = C12809f.m76829b(this, R$id.backups_query_no_net);
        this.f14960B = C12809f.m76829b(this, R$id.backups_query_loading);
        this.f14977r.setEnabled(false);
        this.f14977r.setTextColor(getColor(R$color.device_space_clear_color_disable));
        this.f14977r.setOnClickListener(this);
        C11842p.m70760Q1(this, this.f14985z);
        C11842p.m70866t1(this, this.f14977r);
        this.f14972N = new BackUpDeviceSpaceAdapter(this, this);
    }

    /* renamed from: n2 */
    private void m20657n2(LinkedHashMap<String, String> linkedHashMap) {
        C13227f.m79492i1().m79567R("cloud_space_file_delete", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloud_space_file_delete", linkedHashMap);
        if (this.f14970L == null) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02023"), "deleteDeviceBackupRecord", C13452e.m80781L().m80971t0());
            this.f14970L = c11060cM66626a;
            c11060cM66626a.m66665u("010_200");
        }
        C13622a.m81969o(this, this.f14970L, linkedHashMap);
    }

    /* renamed from: o2 */
    private void m20658o2() {
        Intent intent = new Intent();
        intent.setAction("ACTION_BACKUP_DEVICE_DELETE_REFRESH");
        C13108a.m78878b(this).m78881d(intent);
    }

    /* renamed from: t2 */
    private void m20659t2() {
        C11842p.m70712A2(this.f14977r, false);
        C11842p.m70712A2(this.f14978s, false);
        C11842p.m70712A2(this.f14984y, false);
        C11842p.m70712A2(this.f14959A, false);
        C11842p.m70712A2(this.f14960B, true);
    }

    /* renamed from: u2 */
    private void m20660u2() throws Resources.NotFoundException {
        C11839m.m70688i("HiSyncSpaceClearBackupActivity", "showView");
        List<CBSDeviceCleanItem> list = this.f14965G;
        if (list == null) {
            C11839m.m70688i("HiSyncSpaceClearBackupActivity", "mTempList null");
            return;
        }
        if (list.size() <= 0) {
            m20674r2();
            return;
        }
        this.f14971M.addAll(this.f14965G);
        this.f14972N.m24680k(this.f14971M);
        this.f14972N.m24675f(this.f14966H);
        this.f14983x.setAdapter((ListAdapter) this.f14972N);
        Resources resources = getResources();
        int i10 = R$plurals.space_clear_infrequently_used_tips;
        int i11 = this.f14966H;
        this.f14981v.setText(resources.getQuantityString(i10, i11, Integer.valueOf(i11)));
        m20662Z1();
        m20672p2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v2 */
    public void m20661v2() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.f14967I = progressDialog;
        progressDialog.setMessage(getResources().getString(R$string.hicloud_notepad_deleting));
        this.f14967I.setCancelable(false);
        this.f14967I.show();
    }

    /* renamed from: Z1 */
    public final void m20662Z1() {
        if (this.f14977r == null) {
            C11839m.m70687e("HiSyncSpaceClearBackupActivity", "deleteButton is null");
            return;
        }
        Iterator<CBSDeviceCleanItem> it = this.f14971M.iterator();
        long jM1688f = 0;
        while (it.hasNext()) {
            jM1688f += C0241z.m1688f(it.next().getCbsDevice().getDeviceSpace());
        }
        this.f14961C = jM1688f;
        this.f14977r.setText(getResources().getString(R$string.delete_has_choose_size, C0223k.m1524g(this, 0L)));
    }

    /* renamed from: a2 */
    public final void m20663a2() {
        if (this.f14977r == null) {
            C11839m.m70687e("HiSyncSpaceClearBackupActivity", "calCheckedSpace,deleteButton is null");
            return;
        }
        long jM1688f = 0;
        for (CBSDeviceCleanItem cBSDeviceCleanItem : this.f14971M) {
            if (cBSDeviceCleanItem.isChecked()) {
                jM1688f += C0241z.m1688f(cBSDeviceCleanItem.getCbsDevice().getDeviceSpace());
            }
        }
        this.f14977r.setText(getResources().getString(R$string.delete_has_choose_size, C0223k.m1524g(this, jM1688f)));
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.BackUpDeviceSpaceAdapter.DeviceCheckedCallback
    /* renamed from: b */
    public void mo20664b(boolean z10) {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14976q);
        arrayList.add(this.f14979t);
        arrayList.add(this.f14980u);
        arrayList.add(this.f14982w);
        arrayList.add(this.f14984y);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m20665d2(Object obj) {
        if (obj instanceof CBSDevice) {
            CBSDevice cBSDevice = (CBSDevice) obj;
            this.f14972N.m24672c(cBSDevice.getDeviceId());
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(RemoteMessageConst.FROM, CloudBackupConstant.Command.PMS_CMD_BACKUP);
            linkedHashMap.put("total_size", cBSDevice.getDeviceSpace());
            linkedHashMap.put("total_count", String.valueOf(1));
            linkedHashMap.put("success_size", cBSDevice.getDeviceSpace());
            linkedHashMap.put("success_count", String.valueOf(1));
            linkedHashMap.put("user_grade_code", C13452e.m80781L().m80790C());
            linkedHashMap.put("user_space_available", String.valueOf(C9961b.m61788i().m61794f(C0241z.m1688f(cBSDevice.getDeviceSpace()))));
            m20657n2(linkedHashMap);
        }
    }

    /* renamed from: e2 */
    public final void m20666e2() throws IllegalAccessException, IllegalArgumentException {
        this.f14963E = false;
        this.f14972N.notifyDataSetChanged();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(RemoteMessageConst.FROM, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        linkedHashMap.put("error_reason", "backup device delete fail");
        m20657n2(linkedHashMap);
        m20653c2(this.f14967I);
        m20658o2();
        m20663a2();
        m20675s2();
    }

    /* renamed from: f2 */
    public final void m20667f2() {
        m20653c2(this.f14967I);
        m20658o2();
        m20654h2();
    }

    /* renamed from: g2 */
    public final void m20668g2(Object obj, int i10) throws Resources.NotFoundException {
        if (obj instanceof String) {
            this.f14966H = i10;
            this.f14965G = (List) C12540b1.m75484b((String) obj, new C3317b().getType());
        }
        if (this.f14965G == null) {
            this.f14965G = new ArrayList();
        }
        m20660u2();
    }

    /* renamed from: j2 */
    public final void m20669j2(CBSDeviceCleanItem cBSDeviceCleanItem) {
        if (!C0209d.m1181J0(this)) {
            C11839m.m70688i("HiSyncSpaceClearBackupActivity", "isActivityRunningForeground false return");
            return;
        }
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("isCurrent", String.valueOf(cBSDeviceCleanItem.isCurrent()));
        C13227f.m79492i1().m79591l0("hisync_space_clear_backup_click_backup_detail", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "hisync_space_clear_backup_click_backup_detail", "1", "43", linkedHashMapM79499C);
        Intent intent = new Intent(this, (Class<?>) CloudSpaceBackupDetailActivity.class);
        BackupDetailItem backupDetailItem = new BackupDetailItem();
        if (cBSDeviceCleanItem.getCbsDevice() != null) {
            String devDisplayName = cBSDeviceCleanItem.getCbsDevice().getDevDisplayName();
            String deviceId = cBSDeviceCleanItem.getCbsDevice().getDeviceId();
            int deviceType = cBSDeviceCleanItem.getCbsDevice().getDeviceType();
            long jM1688f = C0241z.m1688f(cBSDeviceCleanItem.getCbsDevice().getDeviceSpace());
            String deviceCategory = cBSDeviceCleanItem.getCbsDevice().getDeviceCategory();
            String backupDeviceId = cBSDeviceCleanItem.getCbsDevice().getBackupDeviceId();
            String bakUpdateTime = cBSDeviceCleanItem.getCbsDevice().getBakUpdateTime();
            backupDetailItem.m16369I(devDisplayName);
            backupDetailItem.m16389s(deviceId);
            backupDetailItem.m16390t(deviceType);
            if (cBSDeviceCleanItem.isCurrent()) {
                backupDetailItem.m16386p(1);
            } else {
                backupDetailItem.m16386p(0);
            }
            backupDetailItem.m16370K(jM1688f);
            backupDetailItem.m16388r(deviceCategory);
            backupDetailItem.m16384n(backupDeviceId);
            backupDetailItem.m16372M(C0223k.m1524g(this, backupDetailItem.m16382l()));
            backupDetailItem.m16368A(bakUpdateTime);
        }
        intent.putExtra("backup_item_param", backupDetailItem);
        intent.putExtra("backup_delete_report_entry", 4);
        intent.putExtra("terminalType", cBSDeviceCleanItem.getCbsDevice().getTerminalType());
        startActivityForResult(intent, 10024);
    }

    /* renamed from: k2 */
    public final /* synthetic */ void m20670k2(HwCheckBox hwCheckBox, View view) {
        this.f14964F = hwCheckBox.isChecked();
        C11839m.m70688i("HiSyncSpaceClearBackupActivity", "send close Backup push: " + this.f14964F);
    }

    /* renamed from: m2 */
    public final /* synthetic */ void m20671m2(DialogInterface dialogInterface, int i10) {
        AlertDialog alertDialog = this.f14969K;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        m20654h2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C11839m.m70686d("HiSyncSpaceClearBackupActivity", "onActivityResult: requestCode: " + i10 + " resultCode: " + i11);
        super.onActivityResult(i10, i11, intent);
        if (i10 == 10024 && i11 == 101) {
            m20667f2();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException {
        if (R$id.delete_button == view.getId()) {
            if (C0209d.m1333z1(this)) {
                m20673q2();
                return;
            }
            C11839m.m70689w("HiSyncSpaceClearBackupActivity", "no network");
            HiCloudExceptionView hiCloudExceptionView = this.f14979t;
            if (hiCloudExceptionView != null) {
                hiCloudExceptionView.m23919i();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70760Q1(this, this.f14985z);
        C11842p.m70866t1(this, this.f14977r);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.activity_cloud_space_clear_backup);
        m22365E1(R$string.space_clear_infrequently_used);
        mo19982C1();
        this.f14973O = new HandlerC3318c(this, null);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02023"), "deleteDeviceBackupRecord", C13452e.m80781L().m80971t0());
        this.f14970L = c11060cM66626a;
        c11060cM66626a.m66665u("010_200");
        this.f14975p = C9961b.m61788i().m61805s();
        m20655i2();
        mo19005p1();
        CloudBackupService.getInstance().register(this.f14974P);
        m20654h2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C13948d.m83788f().m83802o();
        super.onDestroy();
        m20653c2(this.f14968J);
        m20653c2(this.f14967I);
        m20653c2(this.f14969K);
        if (this.f14974P != null) {
            CloudBackupService.getInstance().unregister(this.f14974P);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        if (i10 >= 0 && i10 < this.f14971M.size()) {
            m20669j2(this.f14971M.get(i10));
            return;
        }
        C11839m.m70689w("HiSyncSpaceClearBackupActivity", "onItemClick, i = " + i10 + " is invalid.");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m20652b2();
        finish();
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f14979t != null) {
            if (C0209d.m1333z1(this)) {
                this.f14979t.m23914a();
            } else {
                this.f14979t.m23919i();
            }
        }
    }

    /* renamed from: p2 */
    public final void m20672p2() {
        C11842p.m70712A2(this.f14977r, true);
        C11842p.m70712A2(this.f14978s, true);
        C11842p.m70712A2(this.f14984y, false);
        C11842p.m70712A2(this.f14959A, false);
        C11842p.m70712A2(this.f14960B, false);
    }

    /* renamed from: q2 */
    public final void m20673q2() throws IllegalAccessException, IllegalArgumentException {
        ArrayList arrayList = new ArrayList();
        boolean z10 = true;
        for (CBSDeviceCleanItem cBSDeviceCleanItem : this.f14971M) {
            if (cBSDeviceCleanItem != null && cBSDeviceCleanItem.isChecked()) {
                arrayList.add(cBSDeviceCleanItem);
                if (z10 && !cBSDeviceCleanItem.isSendPush()) {
                    z10 = false;
                }
            }
        }
        int size = arrayList.size();
        if (size <= 0) {
            C11839m.m70687e("HiSyncSpaceClearBackupActivity", "selectSize: " + size);
            return;
        }
        String string = size == 1 ? getResources().getString(R$string.space_clear_msg_delete1) : getResources().getQuantityString(R$plurals.space_clear_msg_delete2, size, Integer.valueOf(size));
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.backup_dialog_space_delete_confirm, (ViewGroup) null, false);
        HwTextView hwTextView = (HwTextView) C12809f.m76831d(viewInflate, R$id.delete_title);
        View viewM76831d = C12809f.m76831d(viewInflate, R$id.delete_check_layout);
        final HwCheckBox hwCheckBox = (HwCheckBox) C12809f.m76831d(viewInflate, R$id.delete_check_box);
        hwTextView.setText(string);
        if (z10) {
            this.f14964F = true;
            viewM76831d.setVisibility(0);
            hwCheckBox.setChecked(true);
            hwCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.m5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f17673a.m20670k2(hwCheckBox, view);
                }
            });
        } else {
            this.f14964F = false;
            viewM76831d.setVisibility(8);
        }
        m20653c2(this.f14968J);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(viewInflate).setPositiveButton(getResources().getString(R$string.confirm_delete_backup), new DialogInterfaceOnClickListenerC3319d(arrayList)).setNegativeButton(getResources().getString(R$string.cloudbackup_Cancel), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.n5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        this.f14968J = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14968J.setCancelable(false);
        this.f14968J.show();
        this.f14968J.getButton(-1).setTextColor(ContextCompat.getColor(this, R$color.red));
        C13227f.m79492i1().m79585f0("click_to_space_clear_backup_delete", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "click_to_space_clear_backup_delete", "1", "85");
    }

    /* renamed from: r2 */
    public final void m20674r2() {
        C11842p.m70712A2(this.f14977r, false);
        C11842p.m70712A2(this.f14978s, false);
        C11842p.m70712A2(this.f14984y, true);
        C11842p.m70712A2(this.f14959A, false);
        C11842p.m70712A2(this.f14960B, false);
    }

    /* renamed from: s2 */
    public final void m20675s2() throws IllegalAccessException, IllegalArgumentException {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.f14969K = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14969K.setMessage(getString(R$string.delete_fail_tip));
        this.f14969K.setButton(-1, getString(R$string.cloudbackup_btn_ok_new), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.l5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f17665a.m20671m2(dialogInterface, i10);
            }
        });
        this.f14969K.show();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        m20652b2();
        return super.mo13429v1(i10, keyEvent);
    }
}
