package com.huawei.android.hicloud.p088ui.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.notification.CleanNotifyManager;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.CloudBackupDeleteRecordAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.backup.CleanupEntryView;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.DeleteDevicesDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.OpenAutomaticCleanDialog;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.BackUpOverMonthRecordConstants;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.manager.HiCloudSceneSpaceMgrManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwprogressbar.widget.HwProgressBar;
import fk.C9721b;
import gl.C9964e;
import io.C10582a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import je.C10782d;
import p015ak.C0209d;
import p015ak.C0223k;
import p015ak.C0226l0;
import p015ak.C0241z;
import p053ce.C1423a;
import p252e9.C9426c;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13466f;
import p746wn.C13622a;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudBackupOldDevicesCleanActivity extends CloudBackupBaseUiActivity implements CloudBackupDeleteRecordAdapter.IRecyclerViewOnListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: C */
    public HiCloudExceptionView f13941C;

    /* renamed from: D */
    public NotchFitLinearLayout f13942D;

    /* renamed from: E */
    public ScrollView f13943E;

    /* renamed from: F */
    public UnionSwitch f13944F;

    /* renamed from: G */
    public RecyclerView f13945G;

    /* renamed from: H */
    public CheckBox f13946H;

    /* renamed from: I */
    public CloudBackupDeleteRecordAdapter f13947I;

    /* renamed from: K */
    public AutoSizeButton f13949K;

    /* renamed from: L */
    public Context f13950L;

    /* renamed from: M */
    public TextView f13951M;

    /* renamed from: N */
    public volatile boolean f13952N;

    /* renamed from: O */
    public ProgressDialog f13953O;

    /* renamed from: P */
    public NetWorkChangeReceiver f13954P;

    /* renamed from: Q */
    public int f13955Q;

    /* renamed from: V */
    public NotchFitLinearLayout f13960V;

    /* renamed from: W */
    public boolean f13961W;

    /* renamed from: X */
    public HwProgressBar f13962X;

    /* renamed from: Y */
    public DeleteDevicesDialog f13963Y;

    /* renamed from: Z */
    public OpenAutomaticCleanDialog f13964Z;

    /* renamed from: J */
    public List<CBSDevice> f13948J = new ArrayList();

    /* renamed from: R */
    public boolean f13956R = false;

    /* renamed from: S */
    public boolean f13957S = false;

    /* renamed from: T */
    public long f13958T = 0;

    /* renamed from: U */
    public int f13959U = 3;

    /* renamed from: a0 */
    public Handler f13965a0 = new HandlerC3174a();

    public static class LinearLayoutManagerClass extends LinearLayoutManager {
        public LinearLayoutManagerClass(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
        public boolean canScrollVertically() {
            return false;
        }

        public LinearLayoutManagerClass(Context context, AttributeSet attributeSet, int i10, int i11) {
            super(context, attributeSet, i10, i11);
        }
    }

    public class NetWorkChangeReceiver extends BroadcastReceiver {
        public NetWorkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction())) {
                CloudBackupOldDevicesCleanActivity.this.m19333B2();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupOldDevicesCleanActivity$a */
    public class HandlerC3174a extends Handler {
        public HandlerC3174a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            int i10 = message.what;
            if (i10 == 1001) {
                Bundle data = message.getData();
                if (data != null) {
                    long j10 = data.getLong("deleted_size");
                    if (CloudBackupOldDevicesCleanActivity.this.f13948J == null || CloudBackupOldDevicesCleanActivity.this.f13948J.size() == 0) {
                        CloudBackupOldDevicesCleanActivity.this.f13949K.setVisibility(8);
                        CloudBackupOldDevicesCleanActivity.this.m19334C2();
                        return;
                    }
                    CloudBackupOldDevicesCleanActivity.this.f13949K.setVisibility(0);
                    if (j10 == 0) {
                        CloudBackupOldDevicesCleanActivity.this.f13949K.setText(CloudBackupOldDevicesCleanActivity.this.getResources().getString(R$string.cloudbackup_btn_delete));
                        CloudBackupOldDevicesCleanActivity.this.f13949K.setEnabled(false);
                        return;
                    }
                    CloudBackupOldDevicesCleanActivity.this.f13958T = j10;
                    String strM1524g = C0223k.m1524g(CloudBackupOldDevicesCleanActivity.this.f13950L, j10);
                    CloudBackupOldDevicesCleanActivity.this.f13949K.setEnabled(true);
                    CloudBackupOldDevicesCleanActivity.this.f13949K.setText(CloudBackupOldDevicesCleanActivity.this.getResources().getString(R$string.cloudbackup_delete_olddevices_button_text, strM1524g));
                    return;
                }
                return;
            }
            if (i10 == 1002) {
                List list = (List) message.obj;
                if (list == null || list.size() == 0) {
                    CloudBackupOldDevicesCleanActivity.this.f13949K.setVisibility(8);
                    CloudBackupOldDevicesCleanActivity.this.f13948J.clear();
                    CloudBackupOldDevicesCleanActivity.this.m19334C2();
                    return;
                }
                CloudBackupOldDevicesCleanActivity.this.f13949K.setVisibility(0);
                CloudBackupOldDevicesCleanActivity.this.f13948J.clear();
                CloudBackupOldDevicesCleanActivity.this.f13948J.addAll(list);
                Collections.sort(CloudBackupOldDevicesCleanActivity.this.f13948J, new C3176c());
                CloudBackupOldDevicesCleanActivity.this.m19334C2();
                C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "list Size:" + list.size());
                return;
            }
            if (i10 == 1005) {
                CloudBackupOldDevicesCleanActivity.this.f13948J.clear();
                CloudBackupOldDevicesCleanActivity.this.m19339I2();
                CloudBackupOldDevicesCleanActivity.this.f13949K.setVisibility(8);
                return;
            }
            if (i10 == 1003) {
                C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "auto clear switch request fail");
                if (CloudBackupOldDevicesCleanActivity.this.f13944F != null && (message.obj instanceof Boolean)) {
                    CloudBackupOldDevicesCleanActivity.this.f13944F.setCheckedProgrammatically(!((Boolean) message.obj).booleanValue());
                    return;
                }
                return;
            }
            if (i10 == 1004) {
                CloudBackupOldDevicesCleanActivity.this.f13962X.setVisibility(8);
                CloudBackupOldDevicesCleanActivity.this.f13944F.setVisibility(0);
                CloudBackupOldDevicesCleanActivity.this.f13944F.setClickable(true);
                CloudBackupOldDevicesCleanActivity.this.m19353t2();
                return;
            }
            if (i10 == 1007) {
                CloudBackupOldDevicesCleanActivity.this.m19338H2(message);
                CloudBackupOldDevicesCleanActivity.this.m19356w2();
            } else if (i10 == 1008) {
                if (CloudBackupOldDevicesCleanActivity.this.f13948J == null || CloudBackupOldDevicesCleanActivity.this.f13948J.size() == 0) {
                    CloudBackupOldDevicesCleanActivity.this.f13949K.setVisibility(8);
                    CloudBackupOldDevicesCleanActivity.this.m19339I2();
                } else {
                    CloudBackupOldDevicesCleanActivity.this.f13949K.setVisibility(0);
                    CloudBackupOldDevicesCleanActivity.this.f13949K.setText(CloudBackupOldDevicesCleanActivity.this.getResources().getString(R$string.cloudbackup_btn_delete));
                    CloudBackupOldDevicesCleanActivity.this.f13949K.setEnabled(false);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupOldDevicesCleanActivity$b */
    public static class C3175b extends AbstractC12367d {

        /* renamed from: a */
        public final boolean f13968a;

        public C3175b(boolean z10) {
            this.f13968a = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            String strM81958d = C13622a.m81958d("03003");
            HashMap map = new HashMap();
            map.put(BackUpOverMonthRecordConstants.SpKey.AUTO_CLEAR_BACKUP_SWITCH, this.f13968a ? "AUTO" : "DISABLED");
            new C10582a(strM81958d).m64928b0(map, "1", null);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupOldDevicesCleanActivity$c */
    public static class C3176c implements Comparator<CBSDevice>, Serializable {
        private static final long serialVersionUID = 5699171561950138319L;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(CBSDevice cBSDevice, CBSDevice cBSDevice2) {
            long jM1688f = C0241z.m1688f(cBSDevice.getBakUpdateTime());
            long jM1688f2 = C0241z.m1688f(cBSDevice2.getBakUpdateTime());
            if (jM1688f > jM1688f2) {
                return -1;
            }
            return jM1688f < jM1688f2 ? 1 : 0;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupOldDevicesCleanActivity$d */
    public class C3177d extends AbstractC12367d {

        /* renamed from: a */
        public final List<CBSDevice> f13969a;

        public C3177d(List<CBSDevice> list) {
            this.f13969a = list;
        }

        /* renamed from: e */
        public /* synthetic */ void m19363e() {
            CloudBackupOldDevicesCleanActivity cloudBackupOldDevicesCleanActivity = CloudBackupOldDevicesCleanActivity.this;
            cloudBackupOldDevicesCleanActivity.m19357x2(cloudBackupOldDevicesCleanActivity.f13953O);
            CloudBackupOldDevicesCleanActivity.this.m19345P2();
        }

        public /* synthetic */ void lambda$call$0() {
            CloudBackupOldDevicesCleanActivity cloudBackupOldDevicesCleanActivity = CloudBackupOldDevicesCleanActivity.this;
            cloudBackupOldDevicesCleanActivity.m19357x2(cloudBackupOldDevicesCleanActivity.f13953O);
            if (!CloudBackupOldDevicesCleanActivity.this.f13957S) {
                CloudBackupOldDevicesCleanActivity.this.m19345P2();
            }
            CloudBackupOldDevicesCleanActivity.this.f13957S = false;
            CloudBackupOldDevicesCleanActivity.this.f13956R = false;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException, C9721b {
            int size = this.f13969a.size();
            try {
                CountDownLatch countDownLatch = new CountDownLatch(size);
                for (int i10 = 0; i10 < size; i10++) {
                    C12515a.m75110o().m75175e(CloudBackupOldDevicesCleanActivity.this.new C3178e(this.f13969a.get(i10), countDownLatch), false);
                }
                boolean zAwait = countDownLatch.await(30L, TimeUnit.SECONDS);
                List<Runnable> listM75171c1 = C12515a.m75110o().m75171c1();
                C11839m.m70686d("CloudBackupOldDevicesCleanActivity", "isFinish：" + zAwait);
                if (C0209d.m1205R0(listM75171c1) && !CloudBackupOldDevicesCleanActivity.this.f13956R && zAwait) {
                    m19364f(this.f13969a.size(), CloudBackupOldDevicesCleanActivity.this.f13958T);
                } else {
                    C11839m.m70689w("CloudBackupOldDevicesCleanActivity", "some task execute failed");
                    C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.f2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f17606a.lambda$call$0();
                        }
                    });
                }
            } catch (Exception e10) {
                C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "DeviceSpaceClearTask error:" + e10.getMessage());
                C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.g2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17616a.m19363e();
                    }
                });
            }
        }

        /* renamed from: f */
        public final void m19364f(int i10, long j10) {
            Message messageObtainMessage = CloudBackupOldDevicesCleanActivity.this.f13965a0.obtainMessage();
            messageObtainMessage.what = FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST;
            CloudBackupOldDevicesCleanActivity.this.f13965a0.sendMessage(messageObtainMessage);
            CloudBackupOldDevicesCleanActivity cloudBackupOldDevicesCleanActivity = CloudBackupOldDevicesCleanActivity.this;
            cloudBackupOldDevicesCleanActivity.m19357x2(cloudBackupOldDevicesCleanActivity.f13953O);
            CleanNotifyManager cleanNotifyManager = new CleanNotifyManager(CloudBackupOldDevicesCleanActivity.this.f13950L);
            Bundle bundle = new Bundle();
            bundle.putString("delete_notify_info_title", CloudBackupOldDevicesCleanActivity.this.getString(R$string.cloudbackup_delete_notify_des));
            bundle.putInt("delete_notify_info_number", i10);
            bundle.putInt("source", 1);
            bundle.putLong("delete_notify_info_size", j10);
            Intent intent = new Intent();
            intent.putExtra("delete_notify_info", bundle);
            cleanNotifyManager.m16515b(intent);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupOldDevicesCleanActivity$e */
    public class C3178e extends AbstractC12367d {

        /* renamed from: a */
        public final CBSDevice f13971a;

        /* renamed from: b */
        public final CountDownLatch f13972b;

        public C3178e(CBSDevice cBSDevice, CountDownLatch countDownLatch) {
            this.f13971a = cBSDevice;
            this.f13972b = countDownLatch;
        }

        public /* synthetic */ void lambda$call$0() {
            Iterator it = CloudBackupOldDevicesCleanActivity.this.f13948J.iterator();
            while (it.hasNext()) {
                CBSDevice cBSDevice = (CBSDevice) it.next();
                if (cBSDevice != null && StringUtil.equals(this.f13971a.getDeviceId(), cBSDevice.getDeviceId())) {
                    it.remove();
                }
            }
            CloudBackupOldDevicesCleanActivity.this.m19339I2();
            CloudBackupOldDevicesCleanActivity.this.m19358y2();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v3, types: [java.util.concurrent.CountDownLatch] */
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                try {
                    C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "delete device:" + this.f13971a.getDevDisplayName());
                    C9964e.m61814f().m61818d(this.f13971a);
                    C9964e.m61814f().m61817c(this.f13971a.getDeviceId());
                    C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "deleteDeviceBackupRecord success");
                    C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.h2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f17626a.lambda$call$0();
                        }
                    });
                } catch (C9721b e10) {
                    CloudBackupOldDevicesCleanActivity.this.f13956R = true;
                    C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "deleteDeviceBackupRecordReq error show toast code:" + e10.m60659c());
                    if (e10.m60659c() == 4959) {
                        CloudBackupOldDevicesCleanActivity.this.m19346Q2();
                        CloudBackupOldDevicesCleanActivity.this.f13957S = true;
                    }
                } catch (Exception e11) {
                    CloudBackupOldDevicesCleanActivity.this.f13956R = true;
                    C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "deleteDeviceBackupRecordReq error:" + e11.getMessage());
                }
            } finally {
                C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "countDownLatch countDown:");
                this.f13972b.countDown();
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.BACKUP_DELETE;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupOldDevicesCleanActivity$f */
    public static class C3179f extends AbstractC12367d {

        /* renamed from: a */
        public final Handler f13974a;

        /* renamed from: b */
        public int f13975b;

        /* renamed from: c */
        public List<CBSDevice> f13976c;

        /* renamed from: d */
        public int f13977d;

        public C3179f(Handler handler, int i10, int i11, List<CBSDevice> list) {
            ArrayList arrayList = new ArrayList();
            this.f13976c = arrayList;
            this.f13974a = handler;
            this.f13975b = i10;
            this.f13977d = i11;
            arrayList.addAll(list);
        }

        /* renamed from: c */
        public final void m19366c(List<CBSDevice> list) {
            ArrayList arrayList = new ArrayList();
            for (CBSDevice cBSDevice : this.f13976c) {
                Iterator<CBSDevice> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (StringUtil.equals(cBSDevice.getDeviceId(), it.next().getDeviceId())) {
                            arrayList.add(cBSDevice);
                            break;
                        }
                    }
                }
            }
            Message messageObtainMessage = this.f13974a.obtainMessage();
            messageObtainMessage.what = 1007;
            messageObtainMessage.obj = arrayList;
            this.f13974a.sendMessage(messageObtainMessage);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Handler handler = this.f13974a;
            if (handler == null) {
                return;
            }
            Message messageObtainMessage = handler.obtainMessage();
            try {
                if (this.f13975b == 0) {
                    messageObtainMessage.what = 1005;
                    this.f13974a.sendMessage(messageObtainMessage);
                    C11839m.m70689w("CloudBackupOldDevicesCleanActivity", "clearTimeMonth is 0");
                    return;
                }
                C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "start query");
                List<CBSDevice> listM61826o = C9964e.m61814f().m61826o(false, this.f13975b);
                if (listM61826o != null && listM61826o.size() != 0) {
                    if (this.f13977d == 2) {
                        m19366c(listM61826o);
                        return;
                    }
                    Iterator<CBSDevice> it = listM61826o.iterator();
                    while (it.hasNext()) {
                        if (it.next().getDeviceId().equals(C13452e.m80781L().m80950o())) {
                            it.remove();
                        }
                    }
                    if (listM61826o.size() > 0) {
                        messageObtainMessage.what = 1002;
                        messageObtainMessage.obj = listM61826o;
                        this.f13974a.sendMessage(messageObtainMessage);
                        return;
                    } else {
                        messageObtainMessage.what = 1005;
                        this.f13974a.sendMessage(messageObtainMessage);
                        C11839m.m70689w("CloudBackupOldDevicesCleanActivity", "newQueryList is null or size is 0");
                        return;
                    }
                }
                messageObtainMessage.what = 1005;
                this.f13974a.sendMessage(messageObtainMessage);
                C11839m.m70689w("CloudBackupOldDevicesCleanActivity", "newQueryList query is null");
            } catch (C9721b unused) {
                messageObtainMessage.what = 1005;
                this.f13974a.sendMessage(messageObtainMessage);
                C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "query list error");
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupOldDevicesCleanActivity$g */
    public class C3180g extends AbstractC12367d {
        public C3180g() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                CloudBackupOldDevicesCleanActivity.this.f13952N = C9964e.m61814f().m61827p();
                C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "isOpenBackupClear:" + CloudBackupOldDevicesCleanActivity.this.f13952N);
            } catch (Exception e10) {
                C11839m.m70687e("CloudBackupOldDevicesCleanActivity", "QuerySwitchStatusTask error:" + e10.getMessage());
            }
            Message messageObtainMessage = CloudBackupOldDevicesCleanActivity.this.f13965a0.obtainMessage();
            messageObtainMessage.what = 1004;
            CloudBackupOldDevicesCleanActivity.this.f13965a0.sendMessage(messageObtainMessage);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupOldDevicesCleanActivity$h */
    public static class C3181h extends AbstractC12367d {

        /* renamed from: a */
        public final boolean f13979a;

        /* renamed from: b */
        public final Handler f13980b;

        public C3181h(boolean z10, Handler handler) {
            this.f13979a = z10;
            this.f13980b = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            boolean zM61828q = C9964e.m61814f().m61828q(this.f13979a);
            C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "UpdateSwitchTask result:" + zM61828q);
            Handler handler = this.f13980b;
            if (handler == null || zM61828q) {
                return;
            }
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 1003;
            messageObtainMessage.obj = Boolean.valueOf(this.f13979a);
            this.f13980b.sendMessage(messageObtainMessage);
        }
    }

    /* renamed from: A2 */
    private void m19306A2() {
        m19340J2();
        m19359z2();
        if (!C0209d.m1333z1(this)) {
            C11839m.m70689w("CloudBackupOldDevicesCleanActivity", "net is error");
            return;
        }
        C12515a.m75110o().m75172d(new C3179f(this.f13965a0, this.f13959U, 0, this.f13948J));
        this.f13955Q = C9426c.m59108d().m59112e();
        this.f13961W = C9426c.m59108d().m59111c();
        C11839m.m70688i("CloudBackupOldDevicesCleanActivity", " clearTime:" + this.f13955Q + " clearTimeMonth:" + this.f13959U + " switchStatusFromSp:" + this.f13961W);
    }

    /* renamed from: E2 */
    private void m19307E2() {
        this.f13941C = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        this.f13942D = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.clear_devices_all);
        this.f13943E = (ScrollView) C12809f.m76829b(this, R$id.scrollView);
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.backup_vip_clean_switch_btn);
        this.f13944F = unionSwitch;
        unionSwitch.setOnCheckedChangeListener(this);
        this.f13951M = (TextView) C12809f.m76829b(this, R$id.clear_backup_over_months_des);
        this.f13944F.setOnClickListener(this);
        this.f13962X = (HwProgressBar) C12809f.m76829b(this, R$id.load_progress);
        this.f13945G = (RecyclerView) C12809f.m76829b(this, R$id.cloudbackup_device_recyclerview);
        this.f13960V = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.cloudbackup_olddevices_rela);
        CheckBox checkBox = (CheckBox) C12809f.m76829b(this, R$id.select_all);
        this.f13946H = checkBox;
        checkBox.setOnClickListener(this);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.delete_backup_btn);
        this.f13949K = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        if (!C0209d.m1333z1(this)) {
            this.f13941C.m23919i();
        }
        TextView textView = this.f13951M;
        Resources resources = getResources();
        int i10 = R$plurals.cloudbackup_olddevices_vipclean_des;
        int i11 = this.f13955Q;
        textView.setText(resources.getQuantityString(i10, i11, Integer.valueOf(i11)));
        C11842p.m70874v1(this, this.f13949K);
        this.f13949K.setEnabled(false);
        m19334C2();
        m19358y2();
        this.f13944F.setCheckedProgrammatically(this.f13961W);
    }

    /* renamed from: O2 */
    private void m19308O2() {
        Iterator<CBSDevice> it = this.f13948J.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().isChecked()) {
                i10++;
            }
        }
        if (i10 == 0) {
            C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "deleted device count is 0,not show dialog");
            return;
        }
        DeleteDevicesDialog deleteDevicesDialog = new DeleteDevicesDialog(this, this, i10);
        this.f13963Y = deleteDevicesDialog;
        deleteDevicesDialog.show();
        this.f13963Y.getButton(-1).setTextColor(getColor(R$color.emui_functional_red));
    }

    /* renamed from: q2 */
    private void m19332q2() {
        if (this.f13941C != null) {
            if (C0209d.m1333z1(this)) {
                this.f13941C.m23914a();
            } else {
                this.f13941C.m23919i();
            }
        }
    }

    /* renamed from: B2 */
    public void m19333B2() {
        if (C0209d.m1333z1(this)) {
            m19336F2();
        } else {
            m19337G2();
        }
    }

    /* renamed from: C2 */
    public final void m19334C2() {
        if (m19351r2()) {
            return;
        }
        LinearLayoutManagerClass linearLayoutManagerClass = new LinearLayoutManagerClass(this);
        linearLayoutManagerClass.setOrientation(1);
        this.f13945G.setNestedScrollingEnabled(false);
        this.f13945G.setFocusable(false);
        this.f13945G.setFocusableInTouchMode(false);
        this.f13945G.setItemAnimator(null);
        this.f13945G.setLayoutManager(linearLayoutManagerClass);
        CloudBackupDeleteRecordAdapter cloudBackupDeleteRecordAdapter = new CloudBackupDeleteRecordAdapter(this, this.f13948J, this.f13955Q);
        this.f13947I = cloudBackupDeleteRecordAdapter;
        cloudBackupDeleteRecordAdapter.m24878K(this);
        this.f13945G.addItemDecoration(C1423a.m8274a(this).m8277d(58).m8278e(12).m8276c(0.3f));
        this.f13945G.setAdapter(this.f13947I);
    }

    /* renamed from: D2 */
    public void m19335D2() {
    }

    /* renamed from: F2 */
    public void m19336F2() {
        C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "onNetworkConnected");
        this.f13941C.m23914a();
        if (C10782d.m65634a().m65652s(this)) {
            this.f13949K.setEnabled(true);
        } else {
            this.f13949K.setEnabled(false);
        }
    }

    /* renamed from: G2 */
    public void m19337G2() {
        C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "onNetworkDisconnected");
        this.f13949K.setEnabled(false);
        this.f13941C.m23919i();
    }

    /* renamed from: H2 */
    public final void m19338H2(Message message) {
        List list = (List) message.obj;
        if (list == null || list.size() == 0) {
            this.f13949K.setVisibility(8);
            return;
        }
        this.f13949K.setVisibility(0);
        this.f13948J.clear();
        this.f13948J.addAll(list);
        Collections.sort(this.f13948J, new C3176c());
        m19334C2();
        C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "list Size:" + list.size());
    }

    /* renamed from: I2 */
    public final void m19339I2() {
        if (m19351r2()) {
            return;
        }
        this.f13947I.m24874G(this.f13948J, this.f13955Q);
        this.f13945G.setAdapter(this.f13947I);
        this.f13947I.m5213j();
    }

    /* renamed from: J2 */
    public final void m19340J2() {
        this.f13954P = new NetWorkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f13954P, intentFilter, "com.huawei.cg.permission.SERVICE", null);
    }

    /* renamed from: K2 */
    public final void m19341K2() {
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        C13225d.m79490f1().m79567R("cloudbackup_clean_device", linkedHashMapM79499C);
        UBAAnalyze.m29947H("PVC", "cloudbackup_clean_device", linkedHashMapM79499C);
    }

    /* renamed from: L2 */
    public final void m19342L2(int i10) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("delete_count", String.valueOf(i10));
        linkedHashMap.put("delete_space_size", String.valueOf(this.f13958T));
        C13225d.m79490f1().m79567R(BackUpOverMonthRecordConstants.Report.DELETE_CLICK, linkedHashMap);
        UBAAnalyze.m29947H("CKC", BackUpOverMonthRecordConstants.Report.DELETE_CLICK, linkedHashMap);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02018"), "deleteDeviceBackupRecord", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        C13622a.m81969o(this, c11060cM66626a, linkedHashMap);
    }

    /* renamed from: M2 */
    public void m19343M2(boolean z10) {
        C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "set switch:" + z10);
        if (!C0209d.m1333z1(this)) {
            this.f13941C.m23919i();
            this.f13944F.setCheckedProgrammatically(!z10);
        } else {
            C12515a.m75110o().m75172d(new C3181h(z10, this.f13965a0));
            C9426c.m59108d().m59115h(z10);
            C9426c.m59108d().m59114g("CKC", z10 ? BackUpOverMonthRecordConstants.Report.CLICK_OPEN_SWITCH : BackUpOverMonthRecordConstants.Report.CLICK_CLOSE_SWITCH);
            C12515a.m75110o().m75172d(new C3175b(z10));
        }
    }

    /* renamed from: N2 */
    public final void m19344N2(boolean z10) {
        this.f13944F.setCheckedProgrammatically(z10);
        C9426c.m59108d().m59115h(z10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity
    /* renamed from: O1 */
    public void mo19236O1() {
        this.f13886q.setVisibility(8);
    }

    /* renamed from: P2 */
    public final void m19345P2() {
        C11841o.m70708d(this, getString(R$string.recovery_no_data_server_error), 0);
    }

    /* renamed from: Q2 */
    public final void m19346Q2() {
        C11841o.m70708d(this, getString(R$string.delete_failed_toast), 0);
    }

    /* renamed from: R2 */
    public final void m19347R2() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.f13953O = progressDialog;
        progressDialog.setMessage(getResources().getString(R$string.hicloud_notepad_deleting));
        this.f13953O.setCancelable(false);
        this.f13953O.show();
    }

    /* renamed from: S2 */
    public final void m19348S2() {
        NetWorkChangeReceiver netWorkChangeReceiver = this.f13954P;
        if (netWorkChangeReceiver != null) {
            unregisterReceiver(netWorkChangeReceiver);
            this.f13954P = null;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13885p);
        arrayList.add(this.f13942D);
        arrayList.add(this.f13943E);
        arrayList.add(this.f13960V);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(CleanupEntryView.OLD_DEVICE_SIZE, this.f13948J.size());
        setResult(10000, intent);
        super.finish();
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.CloudBackupDeleteRecordAdapter.IRecyclerViewOnListener
    /* renamed from: l0 */
    public void mo19349l0(int i10, boolean z10) {
        this.f13948J.get(i10).setChecked(z10);
        m19358y2();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        if (R$id.backup_vip_clean_switch_btn == compoundButton.getId()) {
            C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "backup_vip_clean_switch_btn=" + z10);
            if (this.f13944F.isChecked()) {
                m19352s2();
            } else {
                m19343M2(false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.select_all) {
            C11839m.m70686d("CloudBackupOldDevicesCleanActivity", "onClick select_all:" + this.f13946H.isChecked());
            Iterator<CBSDevice> it = this.f13948J.iterator();
            while (it.hasNext()) {
                it.next().setChecked(this.f13946H.isChecked());
            }
            m19339I2();
            m19358y2();
        }
        if (view.getId() == R$id.delete_backup_btn) {
            m19308O2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mo19005p1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
        super.onCreate(bundle);
        C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "onCreate");
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        C11829c.m70591k1(this);
        LayoutInflater.from(this).inflate(R$layout.activity_cloudbackup_cleanolddevices, (ViewGroup) this.f13894y, true);
        this.f13950L = this;
        m22365E1(R$string.cloudbackup_clean_olddevices);
        mo19982C1();
        mo19236O1();
        m19335D2();
        m19306A2();
        m19307E2();
        mo19005p1();
        m19341K2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        OpenAutomaticCleanDialog openAutomaticCleanDialog = this.f13964Z;
        if (openAutomaticCleanDialog != null) {
            openAutomaticCleanDialog.dismiss();
        }
        DeleteDevicesDialog deleteDevicesDialog = this.f13963Y;
        if (deleteDevicesDialog != null) {
            deleteDevicesDialog.dismiss();
        }
        ProgressDialog progressDialog = this.f13953O;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        m19348S2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m19332q2();
        this.f13962X.setVisibility(0);
        this.f13944F.setVisibility(8);
        C12515a.m75110o().m75172d(new C3180g());
        C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "detailList size:" + this.f13948J.size() + " checkBoxDeleteAll isChecked:" + this.f13946H.isChecked());
        if (this.f13946H.isChecked() && this.f13948J.size() == 0) {
            this.f13946H.setChecked(false);
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.CloudBackupDeleteRecordAdapter.IRecyclerViewOnListener
    /* renamed from: r */
    public void mo19350r(boolean z10) {
        CheckBox checkBox = this.f13946H;
        if (checkBox != null) {
            checkBox.setChecked(z10);
        }
    }

    /* renamed from: r2 */
    public final boolean m19351r2() {
        List<CBSDevice> list = this.f13948J;
        if (list != null && list.size() != 0) {
            this.f13945G.setVisibility(0);
            this.f13960V.setVisibility(0);
            return false;
        }
        C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "detailList is null");
        this.f13945G.setVisibility(8);
        this.f13960V.setVisibility(8);
        return true;
    }

    /* renamed from: s2 */
    public final void m19352s2() {
        OpenAutomaticCleanDialog openAutomaticCleanDialog = new OpenAutomaticCleanDialog(this, this);
        this.f13964Z = openAutomaticCleanDialog;
        openAutomaticCleanDialog.show();
    }

    /* renamed from: t2 */
    public final void m19353t2() {
        C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "checkShowSwitch isOpenBackupClear:" + this.f13952N);
        if (this.f13952N) {
            m19344N2(true);
        } else {
            m19344N2(false);
        }
    }

    /* renamed from: u2 */
    public void m19354u2() {
        UnionSwitch unionSwitch = this.f13944F;
        if (unionSwitch != null) {
            unionSwitch.setCheckedProgrammatically(false);
        }
    }

    /* renamed from: v2 */
    public void m19355v2(int i10) {
        C12515a.m75110o().m75172d(new C3179f(this.f13965a0, this.f13959U, i10, this.f13948J));
    }

    /* renamed from: w2 */
    public void m19356w2() {
        ArrayList arrayList = new ArrayList();
        long jM1688f = 0;
        for (CBSDevice cBSDevice : this.f13948J) {
            if (cBSDevice.isChecked()) {
                arrayList.add(cBSDevice);
                jM1688f = C0241z.m1688f(cBSDevice.getDeviceSpace()) + jM1688f;
            }
        }
        m19358y2();
        if (arrayList.size() == 0) {
            C11839m.m70687e("CloudBackupOldDevicesCleanActivity", "deleteDeviceSpace is empty");
            return;
        }
        int size = arrayList.size();
        this.f13958T = jM1688f;
        m19342L2(size);
        C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "deleteDeviceSpace:" + size);
        m19347R2();
        C12515a.m75110o().m75172d(new C3177d(arrayList));
    }

    /* renamed from: x2 */
    public final void m19357x2(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* renamed from: y2 */
    public final void m19358y2() {
        long jM1688f = 0;
        for (CBSDevice cBSDevice : this.f13948J) {
            if (cBSDevice.isChecked()) {
                jM1688f = C0241z.m1688f(cBSDevice.getDeviceSpace()) + jM1688f;
            }
        }
        C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "initButton size:" + jM1688f);
        Message messageObtainMessage = this.f13965a0.obtainMessage();
        messageObtainMessage.what = 1001;
        Bundle bundle = new Bundle();
        bundle.putLong("deleted_size", jM1688f);
        messageObtainMessage.setData(bundle);
        this.f13965a0.sendMessage(messageObtainMessage);
    }

    /* renamed from: z2 */
    public final void m19359z2() {
        boolean zM81075b = C13466f.m81073d().m81075b("backup_key", false);
        C11839m.m70688i("CloudBackupOldDevicesCleanActivity", "backupSwitch: " + zM81075b);
        this.f13959U = HiCloudSceneSpaceMgrManager.getInstance().getOverMonths(zM81075b ? 1 : 0);
    }
}
