package com.huawei.android.hicloud.p088ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huawei.android.hicloud.cloudbackup.bean.OverdueBackupRecordsPolicy;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.hisync.model.BackupDetailItem;
import com.huawei.android.hicloud.p088ui.activity.OverdueBackupRecordsActivity;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.uiadapter.ExpiredBackupRecordsAdapter;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.gson.reflect.TypeToken;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisabledListView;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hicloud.request.cbs.bean.CBSDeviceCleanItem;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import gl.C9961b;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0241z;
import p054cj.C1442a;
import p252e9.C9428e;
import p336he.C10159j;
import p429kk.C11058a;
import p429kk.C11060c;
import p431ko.C11081g;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p550pb.C12126b;
import p572qb.C12312h0;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12540b1;
import p664u0.C13108a;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p783xp.C13843a;
import p807yd.C13948d;
import p815ym.AbstractC14026a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OverdueBackupRecordsActivity extends HMSTermsProcessBaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, ExpiredBackupRecordsAdapter.DeviceCheckedCallback {

    /* renamed from: A */
    public ScrollDisabledListView f15724A;

    /* renamed from: B */
    public View f15725B;

    /* renamed from: C */
    public TextView f15726C;

    /* renamed from: D */
    public View f15727D;

    /* renamed from: E */
    public View f15728E;

    /* renamed from: F */
    public TextView f15729F;

    /* renamed from: G */
    public View f15730G;

    /* renamed from: I */
    public List<CBSDeviceCleanItem> f15732I;

    /* renamed from: J */
    public int f15733J;

    /* renamed from: K */
    public OverdueBackupRecordsPolicy f15734K;

    /* renamed from: M */
    public String f15736M;

    /* renamed from: N */
    public ProgressDialog f15737N;

    /* renamed from: O */
    public AlertDialog f15738O;

    /* renamed from: P */
    public AlertDialog f15739P;

    /* renamed from: Q */
    public C11060c f15740Q;

    /* renamed from: R */
    public List<CBSDeviceCleanItem> f15741R;

    /* renamed from: S */
    public ExpiredBackupRecordsAdapter f15742S;

    /* renamed from: T */
    public Activity f15743T;

    /* renamed from: p */
    public long f15747p;

    /* renamed from: q */
    public View f15748q;

    /* renamed from: r */
    public View f15749r;

    /* renamed from: s */
    public AutoSizeButton f15750s;

    /* renamed from: t */
    public AutoSizeButton f15751t;

    /* renamed from: u */
    public View f15752u;

    /* renamed from: v */
    public HiCloudExceptionView f15753v;

    /* renamed from: w */
    public View f15754w;

    /* renamed from: x */
    public SpanClickText f15755x;

    /* renamed from: y */
    public CheckBox f15756y;

    /* renamed from: z */
    public View f15757z;

    /* renamed from: H */
    public boolean f15731H = false;

    /* renamed from: L */
    public OverdueBackupRecordsPolicy.PHASE f15735L = OverdueBackupRecordsPolicy.PHASE.PHASE1;

    /* renamed from: U */
    public Handler f15744U = new HandlerC3435a(Looper.getMainLooper());

    /* renamed from: V */
    public Handler.Callback f15745V = new C3436b();

    /* renamed from: W */
    public BroadcastReceiver f15746W = new C3437c();

    /* renamed from: com.huawei.android.hicloud.ui.activity.OverdueBackupRecordsActivity$a */
    public class HandlerC3435a extends Handler {
        public HandlerC3435a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, IllegalArgumentException {
            super.handleMessage(message);
            C11839m.m70688i("OverdueBackupRecordsActivity", "handleMessage: " + message.what);
            int i10 = message.what;
            if (1 == i10) {
                OverdueBackupRecordsActivity.this.m21914k2(message.obj, message.arg1);
                return;
            }
            if (2 == i10) {
                OverdueBackupRecordsActivity.this.m21911h2(message.obj);
                return;
            }
            if (3 == i10) {
                C10028c.m62182c0().m62255O2(0L);
                C9428e.m59118h().m59129k(C0213f.m1377a());
                OverdueBackupRecordsActivity.this.m21913j2();
            } else if (4 == i10) {
                C10028c.m62182c0().m62255O2(0L);
                C9428e.m59118h().m59129k(C0213f.m1377a());
                OverdueBackupRecordsActivity.this.m21912i2();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OverdueBackupRecordsActivity$b */
    public class C3436b implements Handler.Callback {
        public C3436b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 33055) {
                return false;
            }
            C11839m.m70688i("OverdueBackupRecordsActivity", "mExpiredBackupRecordsAdapter notifyDataSetChanged.");
            OverdueBackupRecordsActivity.this.f15742S.notifyDataSetChanged();
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OverdueBackupRecordsActivity$c */
    public class C3437c extends BroadcastReceiver {
        public C3437c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction()) && C0209d.m1333z1(OverdueBackupRecordsActivity.this.f15743T)) {
                OverdueBackupRecordsActivity.this.m21915l2();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OverdueBackupRecordsActivity$d */
    public class C3438d extends TypeToken<List<CBSDeviceCleanItem>> {
        public C3438d() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OverdueBackupRecordsActivity$e */
    public class DialogInterfaceOnClickListenerC3439e implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public List<CBSDeviceCleanItem> f15762a;

        public DialogInterfaceOnClickListenerC3439e(List<CBSDeviceCleanItem> list) {
            this.f15762a = list;
        }

        /* renamed from: a */
        public final void m21934a(List<CBSDeviceCleanItem> list) {
            if (list == null || list.isEmpty()) {
                C11839m.m70687e("OverdueBackupRecordsActivity", "deleteDeviceSpace is empty");
                return;
            }
            C11839m.m70688i("OverdueBackupRecordsActivity", "deleteDeviceSpace:" + list.size());
            OverdueBackupRecordsActivity.this.m21890H2();
            C12515a c12515aM75110o = C12515a.m75110o();
            OverdueBackupRecordsActivity overdueBackupRecordsActivity = OverdueBackupRecordsActivity.this;
            c12515aM75110o.m75172d(overdueBackupRecordsActivity.new C3442h(overdueBackupRecordsActivity.f15744U, list, false));
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (C0209d.m1226Y0()) {
                C11839m.m70689w("OverdueBackupRecordsActivity", "click too fast");
                return;
            }
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("key_event", "click_delete");
            C13227f.m79492i1().m79567R("event_delete_device_dialog", linkedHashMapM79497A);
            UBAAnalyze.m29947H("PVC", "event_delete_device_dialog", linkedHashMapM79497A);
            m21934a(this.f15762a);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OverdueBackupRecordsActivity$f */
    public static class C3440f extends AbstractC12367d {

        /* renamed from: a */
        public final Handler f15764a;

        public C3440f(Handler handler) {
            this.f15764a = handler;
        }

        /* renamed from: d */
        private boolean m21936d(String str, List<HashMap<String, String>> list) {
            if (list == null || list.size() == 0) {
                C11839m.m70687e("OverdueBackupRecordsActivity", "checkAppVersion：empty version range");
                return false;
            }
            try {
                C11839m.m70686d("OverdueBackupRecordsActivity", "checkAppVersion： " + list);
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
                C11839m.m70687e("OverdueBackupRecordsActivity", "checkAppVersion Exception");
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public static /* synthetic */ int m21937e(CBSDeviceCleanItem cBSDeviceCleanItem, CBSDeviceCleanItem cBSDeviceCleanItem2) {
            return Long.compare(C0241z.m1688f(cBSDeviceCleanItem.getCbsDevice().getBakUpdateTime()), C0241z.m1688f(cBSDeviceCleanItem2.getCbsDevice().getBakUpdateTime()));
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            ArrayList arrayList = new ArrayList();
            Pair<List<CBSDevice>, Long> pairM61806t = C9961b.m61788i().m61806t("SilenceDevice");
            List<CBSDevice> list = (List) pairM61806t.first;
            long jLongValue = ((Long) pairM61806t.second).longValue();
            int size = AbstractC14026a.m84159a(list) ? 0 : list.size();
            C13452e c13452eM80781L = C13452e.m80781L();
            if (jLongValue <= 0) {
                size = 0;
            }
            c13452eM80781L.m80832M2(size);
            C13452e.m80781L().m80828L2(list != null ? C12312h0.m74027b().m74028c() : 0L);
            if (C0209d.m1205R0(list)) {
                C11839m.m70688i("OverdueBackupRecordsActivity", "queryDeviceDeleteList empty");
            } else {
                C11839m.m70688i("OverdueBackupRecordsActivity", "queryDeviceDeleteList:" + list.size());
                List<HashMap<String, String>> listM61798k = C9961b.m61788i().m61798k();
                for (CBSDevice cBSDevice : list) {
                    CBSDeviceCleanItem cBSDeviceCleanItem = new CBSDeviceCleanItem(false, cBSDevice);
                    cBSDeviceCleanItem.setCurrent(false);
                    cBSDeviceCleanItem.setSendPush(m21936d(cBSDevice.getAppVersion(), listM61798k));
                    arrayList.add(cBSDeviceCleanItem);
                }
                arrayList.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.activity.c8
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return OverdueBackupRecordsActivity.C3440f.m21937e((CBSDeviceCleanItem) obj, (CBSDeviceCleanItem) obj2);
                    }
                });
            }
            if (this.f15764a != null) {
                Message.obtain(this.f15764a, 1, Math.max((int) C10159j.m63335k(jLongValue), 0), 0, C12540b1.m75485c(arrayList)).sendToTarget();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OverdueBackupRecordsActivity$g */
    public class C3441g extends AbstractC12367d {

        /* renamed from: a */
        public final Handler f15765a;

        /* renamed from: b */
        public final boolean f15766b;

        /* renamed from: c */
        public final CBSDevice f15767c;

        /* renamed from: d */
        public final CountDownLatch f15768d;

        public C3441g(Handler handler, boolean z10, CBSDevice cBSDevice, CountDownLatch countDownLatch) {
            this.f15765a = handler;
            this.f15766b = z10;
            this.f15767c = cBSDevice;
            this.f15768d = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                try {
                    C11839m.m70688i("OverdueBackupRecordsActivity", "delete device:" + this.f15767c.getDevDisplayName());
                    C9961b.m61788i().m61793e(this.f15767c, this.f15766b ? 1 : 0, 6);
                    C9961b.m61788i().m61791c(this.f15767c.getDeviceId());
                    C11839m.m70688i("OverdueBackupRecordsActivity", "deleteDeviceBackupRecord success");
                    Handler handler = this.f15765a;
                    if (handler != null) {
                        Message.obtain(handler, 2, this.f15767c).sendToTarget();
                    }
                } catch (Exception e10) {
                    OverdueBackupRecordsActivity.this.f15731H = true;
                    C11839m.m70688i("OverdueBackupRecordsActivity", "deleteDeviceBackupRecordReq error:" + e10.getMessage());
                }
            } finally {
                C11839m.m70688i("OverdueBackupRecordsActivity", "countDownLatch countDown:");
                this.f15768d.countDown();
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.BACKUP_DELETE;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.OverdueBackupRecordsActivity$h */
    public class C3442h extends AbstractC12367d {

        /* renamed from: a */
        public final Handler f15770a;

        /* renamed from: b */
        public final List<CBSDeviceCleanItem> f15771b;

        /* renamed from: c */
        public final boolean f15772c;

        public C3442h(Handler handler, List<CBSDeviceCleanItem> list, boolean z10) {
            this.f15770a = handler;
            this.f15771b = list;
            this.f15772c = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException {
            int size = this.f15771b.size();
            CountDownLatch countDownLatch = new CountDownLatch(size);
            boolean zAwait = false;
            for (int i10 = 0; i10 < size; i10++) {
                C12515a.m75110o().m75175e(OverdueBackupRecordsActivity.this.new C3441g(this.f15770a, this.f15772c, this.f15771b.get(i10).getCbsDevice(), countDownLatch), false);
            }
            try {
                zAwait = countDownLatch.await(50L, TimeUnit.SECONDS);
                C11839m.m70686d("OverdueBackupRecordsActivity", "isFinish：" + zAwait);
            } catch (InterruptedException e10) {
                C11839m.m70688i("OverdueBackupRecordsActivity", "countDownLatch error:" + e10.getMessage());
            }
            List<Runnable> listM75171c1 = C12515a.m75110o().m75171c1();
            if (!OverdueBackupRecordsActivity.this.f15731H && zAwait && C0209d.m1205R0(listM75171c1)) {
                C11839m.m70688i("OverdueBackupRecordsActivity", "delete success!");
                Handler handler = this.f15770a;
                if (handler != null) {
                    Message.obtain(handler, 3).sendToTarget();
                    return;
                }
                return;
            }
            C11839m.m70689w("OverdueBackupRecordsActivity", "some task execute failed");
            Handler handler2 = this.f15770a;
            if (handler2 != null) {
                Message.obtain(handler2, 4).sendToTarget();
            }
        }
    }

    /* renamed from: A2 */
    private void m21884A2() {
        C11842p.m70712A2(this.f15749r, true);
        C11842p.m70712A2(this.f15752u, true);
        C11842p.m70712A2(this.f15725B, false);
        C11842p.m70712A2(this.f15728E, false);
        C11842p.m70712A2(this.f15730G, false);
    }

    /* renamed from: B2 */
    private void m21885B2() throws IllegalAccessException, IllegalArgumentException {
        ArrayList arrayList = new ArrayList();
        for (CBSDeviceCleanItem cBSDeviceCleanItem : this.f15741R) {
            if (cBSDeviceCleanItem != null && cBSDeviceCleanItem.isChecked()) {
                arrayList.add(cBSDeviceCleanItem);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            C11839m.m70689w("OverdueBackupRecordsActivity", "selectSize: " + size);
            return;
        }
        m21910g2(this.f15738O);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(this.f15743T.getResources().getQuantityString(R$plurals.delete_device_backup_records_title, size, Integer.valueOf(size))).setMessage(this.f15743T.getResources().getQuantityString(R$plurals.delete_device_backup_records_content, size, Integer.valueOf(size))).setPositiveButton(getResources().getString(R$string.cloudbackup_btn_delete_all), new DialogInterfaceOnClickListenerC3439e(arrayList)).setNegativeButton(getResources().getString(R$string.cloudbackup_Cancel), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.y7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                OverdueBackupRecordsActivity.m21919r2(dialogInterface, i10);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        this.f15738O = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f15738O.setCancelable(false);
        this.f15738O.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.huawei.android.hicloud.ui.activity.z7
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f17840a.m21930u2(dialogInterface);
            }
        });
        this.f15738O.show();
    }

    /* renamed from: C2 */
    private void m21886C2() {
        C11842p.m70712A2(this.f15749r, false);
        C11842p.m70712A2(this.f15752u, false);
        C11842p.m70712A2(this.f15725B, true);
        C11842p.m70712A2(this.f15728E, false);
        C11842p.m70712A2(this.f15730G, false);
        if (C13452e.m80781L().m80791C0()) {
            this.f15726C.setText(R$string.no_overdue_backup_records);
        } else if (C13452e.m80781L().m80907e1()) {
            this.f15726C.setText(R$string.upgrade_membership_result_in_no_data);
        } else {
            this.f15726C.setText(R$string.manually_delete_data_result_in_no_data);
        }
    }

    /* renamed from: D2 */
    private void m21887D2() throws IllegalAccessException, IllegalArgumentException {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.f15739P = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f15739P.setMessage(getString(R$string.delete_fail_tip));
        this.f15739P.setButton(-1, getString(R$string.cloudbackup_btn_ok_new), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.x7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f17805a.m21931v2(dialogInterface, i10);
            }
        });
        this.f15739P.show();
    }

    /* renamed from: E2 */
    private void m21888E2() {
        C11842p.m70712A2(this.f15749r, false);
        C11842p.m70712A2(this.f15752u, false);
        C11842p.m70712A2(this.f15725B, false);
        C11842p.m70712A2(this.f15728E, false);
        C11842p.m70712A2(this.f15730G, true);
    }

    /* renamed from: G2 */
    private void m21889G2() {
        String string;
        C11839m.m70688i("OverdueBackupRecordsActivity", "showView");
        List<CBSDeviceCleanItem> list = this.f15732I;
        if (list == null) {
            C11839m.m70688i("OverdueBackupRecordsActivity", "mTempList null");
            return;
        }
        if (list.isEmpty()) {
            m21886C2();
            return;
        }
        this.f15741R.addAll(this.f15732I);
        this.f15742S.m25045l(this.f15741R);
        this.f15724A.setAdapter((ListAdapter) this.f15742S);
        String string2 = getString(R$string.user_agreement);
        if (!m21926f2() || this.f15735L == OverdueBackupRecordsPolicy.PHASE.PHASE1) {
            string = getString(R$string.upgrade_to_cloud_space);
            this.f15750s.setText(R$string.upgrade_and_retain);
        } else {
            string = getString(R$string.free_trial_cloud_space_membership_service);
            this.f15750s.setText(R$string.free_cloud_space_upgrade_title);
        }
        String quantityString = this.f15733J == 0 ? getResources().getQuantityString(R$plurals.expired_backup_records_top_tips_less_than_one_day, 180, 180, string2, string) : getResources().getQuantityString(R$plurals.expired_backup_records_top_tips, this.f15733J, 180, string2, Integer.valueOf(this.f15733J), string);
        this.f15755x.m15931c(string, new SpanClickText.ISpanClickListener() { // from class: com.huawei.android.hicloud.ui.activity.v7
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.f17779a.m21932w2();
            }
        });
        this.f15755x.m15934g(quantityString, false);
        this.f15756y.setChecked(false);
        this.f15751t.setEnabled(false);
        m21884A2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H2 */
    public void m21890H2() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.f15737N = progressDialog;
        progressDialog.setMessage(getResources().getString(R$string.hicloud_notepad_deleting));
        this.f15737N.setCancelable(false);
        this.f15737N.show();
    }

    /* renamed from: e2 */
    private void m21909e2() {
        if (this.f15747p != C9961b.m61788i().m61805s()) {
            C11839m.m70688i("OverdueBackupRecordsActivity", "refresh backup space");
            m21922z2();
        }
    }

    /* renamed from: g2 */
    private void m21910g2(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h2 */
    public void m21911h2(Object obj) {
        if (obj instanceof CBSDevice) {
            CBSDevice cBSDevice = (CBSDevice) obj;
            this.f15742S.m25037d(cBSDevice.getDeviceId());
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(RemoteMessageConst.FROM, CloudBackupConstant.Command.PMS_CMD_BACKUP);
            linkedHashMap.put("total_size", cBSDevice.getDeviceSpace());
            linkedHashMap.put("total_count", String.valueOf(1));
            linkedHashMap.put("success_size", cBSDevice.getDeviceSpace());
            linkedHashMap.put("success_count", String.valueOf(1));
            linkedHashMap.put("user_grade_code", C13452e.m80781L().m80790C());
            linkedHashMap.put("user_space_available", String.valueOf(C9961b.m61788i().m61794f(C0241z.m1688f(cBSDevice.getDeviceSpace()))));
            m21921x2(linkedHashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i2 */
    public void m21912i2() throws IllegalAccessException, IllegalArgumentException {
        this.f15731H = false;
        this.f15742S.notifyDataSetChanged();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(RemoteMessageConst.FROM, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        linkedHashMap.put("error_reason", "backup device delete fail");
        m21921x2(linkedHashMap);
        m21910g2(this.f15737N);
        m21922z2();
        m21887D2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j2 */
    public void m21913j2() {
        m21910g2(this.f15737N);
        m21922z2();
        m21915l2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k2 */
    public void m21914k2(Object obj, int i10) {
        if (obj instanceof String) {
            this.f15732I = (List) C12540b1.m75484b((String) obj, new C3438d().getType());
        }
        if (this.f15732I == null) {
            this.f15732I = new ArrayList();
        }
        this.f15733J = i10;
        m21889G2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l2 */
    public void m21915l2() {
        this.f15731H = false;
        this.f15732I = null;
        List<CBSDeviceCleanItem> list = this.f15741R;
        if (list == null) {
            this.f15741R = new ArrayList();
        } else {
            list.clear();
        }
        AutoSizeButton autoSizeButton = this.f15751t;
        if (autoSizeButton != null) {
            autoSizeButton.setTextColor(getColor(R$color.device_space_clear_color_disable));
        }
        m21888E2();
        if (C0209d.m1333z1(this.f15743T)) {
            C12515a.m75110o().m75172d(new C3440f(this.f15744U));
            this.f15753v.m23914a();
        } else {
            C11839m.m70689w("OverdueBackupRecordsActivity", "have not network");
            m21923F2();
            this.f15753v.m23919i();
        }
    }

    /* renamed from: m2 */
    private void m21916m2() {
        this.f15748q = C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f15749r = C12809f.m76829b(this, R$id.button_layout);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.upgrade_button);
        this.f15750s = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        this.f15751t = (AutoSizeButton) C12809f.m76829b(this, R$id.delete_button);
        this.f15752u = C12809f.m76829b(this, R$id.backups_detail_frame);
        this.f15753v = (HiCloudExceptionView) C12809f.m76829b(this, R$id.backup_clear_exception_view);
        this.f15754w = C12809f.m76829b(this, R$id.backup_clear_title);
        this.f15755x = (SpanClickText) C12809f.m76829b(this, R$id.backup_clear_textview);
        this.f15757z = C12809f.m76829b(this, R$id.backup_device_content);
        CheckBox checkBox = (CheckBox) C12809f.m76829b(this, R$id.check_box);
        this.f15756y = checkBox;
        checkBox.setOnClickListener(this);
        ScrollDisabledListView scrollDisabledListView = (ScrollDisabledListView) C12809f.m76829b(this, R$id.backup_device_list);
        this.f15724A = scrollDisabledListView;
        scrollDisabledListView.setOnItemClickListener(this);
        this.f15725B = C12809f.m76829b(this, R$id.backups_query_no_data);
        this.f15726C = (TextView) C12809f.m76829b(this, R$id.no_data_record_text);
        this.f15727D = C12809f.m76829b(this, R$id.no_data_image_frame);
        this.f15728E = C12809f.m76829b(this, R$id.backups_query_no_net);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f15729F = textView;
        textView.setOnClickListener(this);
        this.f15730G = C12809f.m76829b(this, R$id.backups_query_loading);
        this.f15751t.setEnabled(false);
        this.f15751t.setTextColor(getColor(R$color.device_space_clear_color_disable));
        this.f15751t.setOnClickListener(this);
        this.f15742S = new ExpiredBackupRecordsAdapter(this, this);
    }

    /* renamed from: o2 */
    private void m21917o2(CBSDeviceCleanItem cBSDeviceCleanItem) {
        if (!C0209d.m1181J0(this)) {
            C11839m.m70688i("OverdueBackupRecordsActivity", "isActivityRunningForeground false return");
            return;
        }
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("isCurrent", String.valueOf(cBSDeviceCleanItem.isCurrent()));
        C13227f.m79492i1().m79591l0("mecloud_cloudspace_click_expired_device_detail", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_cloudspace_click_expired_device_detail", "1", "43", linkedHashMapM79499C);
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
            backupDetailItem.m16387q(this.f15733J);
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

    /* renamed from: r2 */
    public static /* synthetic */ void m21919r2(DialogInterface dialogInterface, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("key_event", "click_cancel");
        C13227f.m79492i1().m79567R("event_delete_device_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "event_delete_device_dialog", linkedHashMapM79497A);
        dialogInterface.cancel();
    }

    /* renamed from: s2 */
    public static /* synthetic */ String m21920s2(CBSDeviceCleanItem cBSDeviceCleanItem) {
        CBSDevice cbsDevice = cBSDeviceCleanItem.getCbsDevice();
        if (cbsDevice == null) {
            return "";
        }
        return cbsDevice.getDevDisplayName() + ":" + cbsDevice.getBackupDeviceId();
    }

    /* renamed from: x2 */
    private void m21921x2(LinkedHashMap<String, String> linkedHashMap) {
        C13227f.m79492i1().m79567R("expired_device_delete", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "expired_device_delete", linkedHashMap);
        if (this.f15740Q == null) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02023"), "deleteDeviceBackupRecord", C13452e.m80781L().m80971t0());
            this.f15740Q = c11060cM66626a;
            c11060cM66626a.m66665u("010_200");
        }
        C13622a.m81969o(this, this.f15740Q, linkedHashMap);
    }

    /* renamed from: z2 */
    private void m21922z2() {
        Intent intent = new Intent();
        intent.setAction("ACTION_BACKUP_DEVICE_DELETE_REFRESH");
        C13108a.m78878b(this).m78881d(intent);
    }

    /* renamed from: F2 */
    public final void m21923F2() {
        C11842p.m70712A2(this.f15749r, false);
        C11842p.m70712A2(this.f15752u, false);
        C11842p.m70712A2(this.f15725B, false);
        C11842p.m70712A2(this.f15728E, true);
        C11842p.m70712A2(this.f15730G, false);
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.ExpiredBackupRecordsAdapter.DeviceCheckedCallback
    /* renamed from: a0 */
    public void mo21924a0(boolean z10) {
        if (this.f15742S.m25035b() != 0) {
            this.f15751t.setEnabled(true);
            this.f15751t.setTextColor(getColor(R$color.device_space_clear_color));
        } else {
            this.f15751t.setEnabled(false);
            this.f15751t.setTextColor(getColor(R$color.device_space_clear_color_disable));
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.ExpiredBackupRecordsAdapter.DeviceCheckedCallback
    /* renamed from: b */
    public void mo21925b(boolean z10) {
        this.f15756y.setChecked(z10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15748q);
        arrayList.add(this.f15753v);
        arrayList.add(this.f15754w);
        arrayList.add(this.f15757z);
        arrayList.add(this.f15725B);
        arrayList.add(this.f15749r);
        return arrayList;
    }

    /* renamed from: f2 */
    public final boolean m21926f2() {
        OverdueBackupRecordsPolicy overdueBackupRecordsPolicy = this.f15734K;
        if (overdueBackupRecordsPolicy == null) {
            C11839m.m70689w("OverdueBackupRecordsActivity", "checkPolicyValid, overdueBackupRecordsPolicy is null");
            return false;
        }
        List<OverdueBackupRecordsPolicy.RecordsDeletePhases> recordsDeletePhases = overdueBackupRecordsPolicy.getRecordsDeletePhases();
        if (AbstractC14026a.m84159a(recordsDeletePhases)) {
            C11839m.m70689w("OverdueBackupRecordsActivity", "checkPolicyValid, recordsDeletePhases is empty");
            return false;
        }
        if (this.f15733J > this.f15734K.getRecordsDeletePhaseTime()) {
            this.f15735L = OverdueBackupRecordsPolicy.PHASE.PHASE1;
        } else {
            this.f15735L = OverdueBackupRecordsPolicy.PHASE.PHASE2;
        }
        for (OverdueBackupRecordsPolicy.RecordsDeletePhases recordsDeletePhases2 : recordsDeletePhases) {
            if (recordsDeletePhases2 == null) {
                C11839m.m70689w("OverdueBackupRecordsActivity", "checkPolicyValid, recordsDeletePhasesItem is null");
                return false;
            }
            String subscribeUri = recordsDeletePhases2.getSubscribeUri();
            if (TextUtils.isEmpty(subscribeUri)) {
                C11839m.m70689w("OverdueBackupRecordsActivity", "checkPolicyValid, subscribeUriStr is empty");
                return false;
            }
            String phase = recordsDeletePhases2.getPhase();
            if (TextUtils.isEmpty(phase)) {
                C11839m.m70689w("OverdueBackupRecordsActivity", "checkPolicyValid, phaseStr is empty");
                return false;
            }
            if (this.f15735L == OverdueBackupRecordsPolicy.PHASE.getPhase(phase)) {
                this.f15736M = subscribeUri;
            }
        }
        return true;
    }

    /* renamed from: n2 */
    public final void m21927n2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Bundle bundle = new Bundle();
        bundle.putInt("from_where", 18);
        bundle.putInt("nav_source", 20);
        C13230i.m79522d1(bundle, "1", "7");
        String strM79465g = C13222a.m79465g(this.f15743T);
        C12126b.m72707c(strM79465g, bundle);
        new HwAnimationReflection(this.f15743T).m15927c(1);
        String strM80790C = C13452e.m80781L().m80790C();
        C13223b.m79478f("expired_backup_records", "1", C13452e.m80781L().m80971t0(), strM79465g, strM80790C);
        UBAAnalyze.m29960U("PVC", "expired_backup_records", "1", "7", "1", strM79465g, strM80790C);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C11839m.m70686d("OverdueBackupRecordsActivity", "onActivityResult: requestCode: " + i10 + " resultCode: " + i11);
        super.onActivityResult(i10, i11, intent);
        if (i10 == 10024 && i11 == 101) {
            m21913j2();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int id2 = view.getId();
        if (R$id.delete_button == id2) {
            if (C0209d.m1333z1(this)) {
                m21885B2();
                return;
            }
            C11839m.m70689w("OverdueBackupRecordsActivity", "no network");
            HiCloudExceptionView hiCloudExceptionView = this.f15753v;
            if (hiCloudExceptionView != null) {
                hiCloudExceptionView.m23919i();
                return;
            }
            return;
        }
        if (R$id.upgrade_button == id2) {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("key_event", "overdue_page_bottom_button_click_jump_upgrade_page");
            C13227f.m79492i1().m79567R("event_overdue_backup_records", linkedHashMapM79497A);
            UBAAnalyze.m29947H("PVC", "event_overdue_backup_records", linkedHashMapM79497A);
            m21928p2();
            return;
        }
        if (R$id.set_no_net_btn == id2) {
            C11829c.m70612r1(this.f15743T);
            return;
        }
        if (R$id.check_box == id2) {
            final boolean zIsChecked = this.f15756y.isChecked();
            LinkedHashMap<String, String> linkedHashMapM79497A2 = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A2.put("key_event", zIsChecked ? "select_all" : "deselect_all");
            C13227f.m79492i1().m79567R("event_overdue_backup_records", linkedHashMapM79497A2);
            UBAAnalyze.m29947H("PVC", "event_overdue_backup_records", linkedHashMapM79497A2);
            if (zIsChecked) {
                this.f15751t.setEnabled(true);
                this.f15751t.setTextColor(getColor(R$color.device_space_clear_color));
            } else {
                this.f15751t.setEnabled(false);
                this.f15751t.setTextColor(getColor(R$color.device_space_clear_color_disable));
            }
            this.f15741R.forEach(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.w7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((CBSDeviceCleanItem) obj).setChecked(zIsChecked);
                }
            });
            this.f15742S.m25045l(this.f15741R);
            this.f15742S.m25038e(zIsChecked);
            for (int i10 = 0; i10 < this.f15742S.getCount(); i10++) {
                try {
                    ((ExpiredBackupRecordsAdapter.C4053a) this.f15724A.getChildAt(i10).getTag()).m25052g().setChecked(zIsChecked);
                } catch (Exception e10) {
                    C11839m.m70689w("OverdueBackupRecordsActivity", "onClick, setChecked error, e: " + e10.getMessage());
                }
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70760Q1(this, this.f15727D);
        C11842p.m70866t1(this, this.f15751t);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.activity_expired_backup_records);
        this.f15743T = this;
        m22365E1(R$string.expired_backup_records);
        mo19982C1();
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02023"), "expiredBackupRecords", C13452e.m80781L().m80971t0());
        this.f15740Q = c11060cM66626a;
        c11060cM66626a.m66665u("010_200");
        this.f15747p = C9961b.m61788i().m61805s();
        m21916m2();
        mo19005p1();
        this.f15734K = new C12526j().m75420t0();
        CloudBackupService.getInstance().register(this.f15745V);
        m21915l2();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f15746W, intentFilter, "com.huawei.cg.permission.SERVICE", null);
        m21933y2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C13948d.m83788f().m83802o();
        super.onDestroy();
        m21910g2(this.f15738O);
        m21910g2(this.f15737N);
        m21910g2(this.f15739P);
        BroadcastReceiver broadcastReceiver = this.f15746W;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f15746W = null;
        }
        if (this.f15745V != null) {
            CloudBackupService.getInstance().unregister(this.f15745V);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        if (i10 >= 0 && i10 < this.f15741R.size()) {
            m21917o2(this.f15741R.get(i10));
            return;
        }
        C11839m.m70689w("OverdueBackupRecordsActivity", "onItemClick, i = " + i10 + " is invalid.");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (16908332 != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m21909e2();
        finish();
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f15753v != null) {
            if (C0209d.m1333z1(this)) {
                this.f15753v.m23914a();
            } else {
                this.f15753v.m23919i();
            }
        }
    }

    /* renamed from: p2 */
    public final void m21928p2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (TextUtils.isEmpty(this.f15736M)) {
            m21927n2();
            return;
        }
        try {
            Intent commonGotoIntent = GeneralRedirectUtil.getCommonGotoIntent(this.f15736M.startsWith("hicloud") ? NotifyConstants.TYPE_DEEPLINK : "web", this.f15736M, false);
            commonGotoIntent.putExtra("from_where", 18);
            commonGotoIntent.putExtra("nav_source", 20);
            startActivity(new HiCloudSafeIntent(commonGotoIntent));
        } catch (Exception e10) {
            C11839m.m70687e("OverdueBackupRecordsActivity", "startActivity error: " + e10.getMessage());
            m21927n2();
        }
    }

    /* renamed from: t2 */
    public final /* synthetic */ String[] m21929t2(int i10) {
        return new String[this.f15741R.size()];
    }

    /* renamed from: u2 */
    public final /* synthetic */ void m21930u2(DialogInterface dialogInterface) {
        this.f15738O.getButton(-1).setTextColor(ContextCompat.getColor(this, R$color.red));
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("key_event", ParamConstants.CallbackMethod.ON_SHOW);
        linkedHashMapM79497A.put("device_info", Arrays.toString((String[]) this.f15741R.stream().map(new Function() { // from class: com.huawei.android.hicloud.ui.activity.a8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return OverdueBackupRecordsActivity.m21920s2((CBSDeviceCleanItem) obj);
            }
        }).toArray(new IntFunction() { // from class: com.huawei.android.hicloud.ui.activity.b8
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return this.f16486a.m21929t2(i10);
            }
        })));
        C13227f.m79492i1().m79567R("event_delete_device_dialog", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "event_delete_device_dialog", linkedHashMapM79497A);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        m21909e2();
        return super.mo13429v1(i10, keyEvent);
    }

    /* renamed from: v2 */
    public final /* synthetic */ void m21931v2(DialogInterface dialogInterface, int i10) {
        AlertDialog alertDialog = this.f15739P;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        m21915l2();
    }

    /* renamed from: w2 */
    public final /* synthetic */ void m21932w2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("key_event", "overdue_page_top_tips_hyperlinks_click_jump_upgrade_page");
        C13227f.m79492i1().m79567R("event_overdue_backup_records", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "event_overdue_backup_records", linkedHashMapM79497A);
        m21928p2();
    }

    /* renamed from: y2 */
    public final void m21933y2() {
        try {
            SafeIntent safeIntent = new SafeIntent(getIntent());
            String stringExtra = safeIntent.getStringExtra("srcChannel");
            String stringExtra2 = safeIntent.getStringExtra("salChannel");
            String stringExtra3 = safeIntent.getStringExtra("activityCode");
            String stringExtra4 = safeIntent.getStringExtra("from_where");
            String stringExtra5 = safeIntent.getStringExtra("startupSource");
            String stringExtra6 = safeIntent.getStringExtra("startupSourceId");
            String stringExtra7 = safeIntent.getStringExtra("cfgId");
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("from_where", stringExtra4);
            linkedHashMapM79497A.put("startupSource", stringExtra5);
            linkedHashMapM79497A.put("startupSourceId", stringExtra6);
            linkedHashMapM79497A.put("cfgId", stringExtra7);
            linkedHashMapM79497A.put("pay_sal_channel", stringExtra2);
            linkedHashMapM79497A.put("pay_src_channel", stringExtra);
            linkedHashMapM79497A.put("pay_activity_code", stringExtra3);
            C13227f.m79492i1().m79567R("OVERDUE_BACKUP_RECORDS", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "OVERDUE_BACKUP_RECORDS", "1", "7", linkedHashMapM79497A);
            String str = "";
            if (TextUtils.equals(stringExtra3, "001")) {
                str = "homepageBanner";
            } else if (TextUtils.equals(stringExtra3, "003")) {
                str = "notifyBar";
            } else if (TextUtils.equals(stringExtra3, "004")) {
                str = "messageCenter";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            C12515a.m75110o().m75172d(new C11081g(getString(R$string.space_notify_content), str, 18));
        } catch (Exception e10) {
            C1442a.m8289e("OverdueBackupRecordsActivity", "reportEnterUpgradeActivity error occur:" + e10.getMessage());
        }
    }
}
