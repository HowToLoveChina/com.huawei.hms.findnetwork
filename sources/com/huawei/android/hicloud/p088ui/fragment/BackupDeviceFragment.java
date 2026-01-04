package com.huawei.android.hicloud.p088ui.fragment;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.p088ui.activity.HiSyncSpaceClearBackupActivity;
import com.huawei.android.hicloud.p088ui.fragment.BackupDeviceFragment;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hicloud.request.cbs.bean.CBSDeviceCleanItem;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import gl.C9961b;
import gp.C10028c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import je.C10810x;
import p015ak.C0209d;
import p015ak.C0223k;
import p015ak.C0241z;
import p336he.C10159j;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12540b1;
import p626ry.C12652a;
import p664u0.C13108a;
import p684un.C13225d;
import p684un.C13230i;
import p703v8.C13368e;
import p709vj.C13452e;
import p746wn.C13622a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupDeviceFragment extends Fragment implements View.OnClickListener {

    /* renamed from: u */
    public static List<CBSDeviceCleanItem> f18040u;

    /* renamed from: a */
    public View f18041a;

    /* renamed from: b */
    public HwTextView f18042b;

    /* renamed from: c */
    public View f18043c;

    /* renamed from: d */
    public ImageView f18044d;

    /* renamed from: e */
    public LinearLayout f18045e;

    /* renamed from: f */
    public ImageView f18046f;

    /* renamed from: g */
    public HwTextView f18047g;

    /* renamed from: h */
    public HwTextView f18048h;

    /* renamed from: i */
    public HwTextView f18049i;

    /* renamed from: j */
    public LinearLayout f18050j;

    /* renamed from: k */
    public ImageView f18051k;

    /* renamed from: l */
    public HwTextView f18052l;

    /* renamed from: m */
    public HwTextView f18053m;

    /* renamed from: n */
    public HwTextView f18054n;

    /* renamed from: o */
    public View f18055o;

    /* renamed from: p */
    public LinearLayout f18056p;

    /* renamed from: q */
    public C3954e f18057q;

    /* renamed from: r */
    public HandlerC3953d f18058r;

    /* renamed from: s */
    public boolean f18059s = false;

    /* renamed from: t */
    public Handler.Callback f18060t = new C3950a();

    /* renamed from: com.huawei.android.hicloud.ui.fragment.BackupDeviceFragment$a */
    public class C3950a implements Handler.Callback {
        public C3950a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 33055) {
                C11839m.m70688i("BackupDeviceFragment", "refresh mBackupDeviceIv");
                if (C12652a.m76180b(BackupDeviceFragment.f18040u)) {
                    return false;
                }
                if (BackupDeviceFragment.f18040u.size() > 0) {
                    CBSDeviceCleanItem cBSDeviceCleanItem = BackupDeviceFragment.f18040u.get(0);
                    BackupDeviceFragment backupDeviceFragment = BackupDeviceFragment.this;
                    backupDeviceFragment.m24095p(backupDeviceFragment.f18046f, cBSDeviceCleanItem);
                }
                if (BackupDeviceFragment.f18040u.size() > 1) {
                    CBSDeviceCleanItem cBSDeviceCleanItem2 = BackupDeviceFragment.f18040u.get(1);
                    BackupDeviceFragment backupDeviceFragment2 = BackupDeviceFragment.this;
                    backupDeviceFragment2.m24095p(backupDeviceFragment2.f18051k, cBSDeviceCleanItem2);
                }
            }
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.BackupDeviceFragment$b */
    public class C3951b extends TypeToken<List<CBSDeviceCleanItem>> {
        public C3951b() {
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.BackupDeviceFragment$c */
    public static class C3952c extends AbstractC12367d {

        /* renamed from: a */
        public final Handler f18063a;

        public C3952c(Handler handler) {
            this.f18063a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public static /* synthetic */ int m24101d(CBSDeviceCleanItem cBSDeviceCleanItem, CBSDeviceCleanItem cBSDeviceCleanItem2) {
            return Long.compare(C0241z.m1688f(cBSDeviceCleanItem.getCbsDevice().getBakUpdateTime()), C0241z.m1688f(cBSDeviceCleanItem2.getCbsDevice().getBakUpdateTime()));
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            ArrayList arrayList = new ArrayList();
            List<CBSDevice> listM61807u = C9961b.m61788i().m61807u();
            if (C0209d.m1205R0(listM61807u)) {
                C11839m.m70688i("BackupDeviceFragment", "queryDeviceDeleteList empty");
            } else {
                C11839m.m70688i("BackupDeviceFragment", "queryDeviceDeleteList:" + listM61807u.size());
                Iterator<CBSDevice> it = listM61807u.iterator();
                while (it.hasNext()) {
                    CBSDeviceCleanItem cBSDeviceCleanItem = new CBSDeviceCleanItem(false, it.next());
                    cBSDeviceCleanItem.setCurrent(false);
                    arrayList.add(cBSDeviceCleanItem);
                }
                arrayList.sort(new Comparator() { // from class: com.huawei.android.hicloud.ui.fragment.a
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return BackupDeviceFragment.C3952c.m24101d((CBSDeviceCleanItem) obj, (CBSDeviceCleanItem) obj2);
                    }
                });
                BackupDeviceFragment.f18040u = new ArrayList(arrayList);
            }
            Handler handler = this.f18063a;
            if (handler != null) {
                Message.obtain(handler, 1, C12540b1.m75485c(arrayList)).sendToTarget();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.BackupDeviceFragment$d */
    public static class HandlerC3953d extends Handler {

        /* renamed from: a */
        public final WeakReference<BackupDeviceFragment> f18064a;

        public /* synthetic */ HandlerC3953d(BackupDeviceFragment backupDeviceFragment, C3950a c3950a) {
            this(backupDeviceFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            BackupDeviceFragment backupDeviceFragment = this.f18064a.get();
            if (backupDeviceFragment == null || backupDeviceFragment.getActivity() == null || backupDeviceFragment.getActivity().isFinishing()) {
                C11839m.m70689w("BackupDeviceFragment", "fragment null");
                return;
            }
            C11839m.m70688i("BackupDeviceFragment", "handleMessage: " + message.what);
            int i10 = message.what;
            if (i10 == 1) {
                backupDeviceFragment.m24091l(message.obj);
            } else if (i10 == 2) {
                backupDeviceFragment.f18059s = true;
            }
        }

        public HandlerC3953d(BackupDeviceFragment backupDeviceFragment) {
            super(Looper.getMainLooper());
            this.f18064a = new WeakReference<>(backupDeviceFragment);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.BackupDeviceFragment$e */
    public static class C3954e extends BroadcastReceiver {

        /* renamed from: a */
        public final Handler f18065a;

        public C3954e(Handler handler) {
            this.f18065a = handler;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C11839m.m70689w("BackupDeviceFragment", "intent null");
                return;
            }
            if ("ACTION_BACKUP_DEVICE_DELETE_REFRESH".equals(new HiCloudSafeIntent(intent).getAction())) {
                C11839m.m70688i("BackupDeviceFragment", "queryDeviceDeleteList refreshing");
                Handler handler = this.f18065a;
                if (handler != null) {
                    Message.obtain(handler, 2).sendToTarget();
                }
            }
        }
    }

    /* renamed from: f */
    public final long m24085f(List<CBSDeviceCleanItem> list) {
        long jM1688f = 0;
        if (list == null) {
            return 0L;
        }
        Iterator<CBSDeviceCleanItem> it = list.iterator();
        while (it.hasNext()) {
            jM1688f += C0241z.m1688f(it.next().getCbsDevice().getDeviceSpace());
        }
        return jM1688f;
    }

    /* renamed from: g */
    public final void m24086g() {
        C11839m.m70688i("BackupDeviceFragment", "start BackupSpaceClearActivity");
        if (getActivity() != null) {
            startActivityForResult(new Intent(getActivity(), (Class<?>) HiSyncSpaceClearBackupActivity.class), 10046);
            C13225d.m79490f1().m79585f0("click_to_space_clear_backup", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "click_to_space_clear_backup", "1", "85");
        }
        m24087h();
        C10028c.m62182c0().m62346j2(System.currentTimeMillis());
    }

    /* renamed from: h */
    public final void m24087h() {
        View view = this.f18055o;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* renamed from: i */
    public final void m24088i() {
        C11839m.m70688i("BackupDeviceFragment", "queryDeviceDeleteList");
        C12515a.m75110o().m75172d(new C3952c(this.f18058r));
    }

    /* renamed from: j */
    public final void m24089j() {
        if (this.f18057q == null) {
            this.f18057q = new C3954e(this.f18058r);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("ACTION_BACKUP_DEVICE_DELETE_REFRESH");
            if (getActivity() != null) {
                C13108a.m78878b(getActivity()).m78880c(this.f18057q, intentFilter);
            }
        }
    }

    /* renamed from: k */
    public final void m24090k() {
        this.f18042b = (HwTextView) C12809f.m76831d(this.f18041a, R$id.backup_space_use_tv);
        this.f18043c = C12809f.m76831d(this.f18041a, R$id.backup_info_layout);
        this.f18044d = (ImageView) C12809f.m76831d(this.f18041a, R$id.backup_clear_arrow);
        this.f18045e = (LinearLayout) C12809f.m76831d(this.f18041a, R$id.backup_layout_item1);
        this.f18046f = (ImageView) C12809f.m76831d(this.f18041a, R$id.backup_device_iv1);
        this.f18047g = (HwTextView) C12809f.m76831d(this.f18041a, R$id.backup_device_name1);
        this.f18048h = (HwTextView) C12809f.m76831d(this.f18041a, R$id.backup_space_time1);
        this.f18049i = (HwTextView) C12809f.m76831d(this.f18041a, R$id.backup_space_size1);
        this.f18050j = (LinearLayout) C12809f.m76831d(this.f18041a, R$id.backup_layout_item2);
        this.f18051k = (ImageView) C12809f.m76831d(this.f18041a, R$id.backup_device_iv2);
        this.f18052l = (HwTextView) C12809f.m76831d(this.f18041a, R$id.backup_device_name2);
        this.f18053m = (HwTextView) C12809f.m76831d(this.f18041a, R$id.backup_space_time2);
        this.f18054n = (HwTextView) C12809f.m76831d(this.f18041a, R$id.backup_space_size2);
        this.f18056p = (LinearLayout) C12809f.m76831d(this.f18041a, R$id.backup_layout_button);
        this.f18055o = C12809f.m76831d(this.f18041a, R$id.backup_clear_red_img);
        ((HwButton) C12809f.m76831d(this.f18041a, R$id.backup_clear_device_btn)).setOnClickListener(this);
        m24099t(C9961b.m61788i().m61797j());
    }

    /* renamed from: l */
    public final void m24091l(Object obj) throws Resources.NotFoundException {
        C11839m.m70688i("BackupDeviceFragment", "refreshBackupDevices");
        if (getActivity() == null || !isAdded()) {
            C11839m.m70689w("BackupDeviceFragment", "activity null");
            return;
        }
        List<CBSDeviceCleanItem> list = null;
        try {
            list = (List) C12540b1.m75484b(obj instanceof String ? (String) obj : null, new C3951b().getType());
        } catch (Exception unused) {
            C11839m.m70687e("BackupDeviceFragment", "fromJson exception");
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        if (list == null || list.size() <= 0) {
            C11839m.m70686d("BackupDeviceFragment", "refreshBackupDevices empty");
            m24099t(0);
            this.f18042b.setText(C0223k.m1524g(getActivity(), 0L));
            linkedHashMapM79497A.put("cloudspace_backup_size", "0");
            linkedHashMapM79497A.put("cloudspace_backup_num", "0");
        } else {
            m24099t(list.size());
            long jM24085f = m24085f(list);
            String strM1236b0 = C0209d.m1236b0(C0223k.m1524g(getActivity(), jM24085f));
            this.f18042b.setText(getActivity().getResources().getQuantityString(R$plurals.space_clear_infrequently_used_size, list.size(), Integer.valueOf(list.size()), strM1236b0, strM1236b0));
            m24098s(jM24085f);
            if (list.size() > 0) {
                CBSDeviceCleanItem cBSDeviceCleanItem = list.get(0);
                m24096q(this.f18047g, cBSDeviceCleanItem);
                m24094o(this.f18048h, cBSDeviceCleanItem);
                m24097r(this.f18049i, cBSDeviceCleanItem);
                m24095p(this.f18046f, cBSDeviceCleanItem);
            }
            if (list.size() > 1) {
                CBSDeviceCleanItem cBSDeviceCleanItem2 = list.get(1);
                m24096q(this.f18052l, cBSDeviceCleanItem2);
                m24094o(this.f18053m, cBSDeviceCleanItem2);
                m24097r(this.f18054n, cBSDeviceCleanItem2);
                m24095p(this.f18051k, cBSDeviceCleanItem2);
            }
            linkedHashMapM79497A.put("cloudspace_backup_size", strM1236b0);
            linkedHashMapM79497A.put("cloudspace_backup_num", String.valueOf(list.size()));
        }
        linkedHashMapM79497A.put(RemoteMessageConst.FROM, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        linkedHashMapM79497A.put("user_grade_code", C13452e.m80781L().m80790C());
        QuotaSpaceInfo quotaSpaceInfoM80224M = C13368e.m80184F().m80224M();
        linkedHashMapM79497A.put("user_space_available", String.valueOf(quotaSpaceInfoM80224M != null ? quotaSpaceInfoM80224M.getAvailable() : 0L));
        m24093n(linkedHashMapM79497A);
    }

    /* renamed from: m */
    public final void m24092m() {
        if (this.f18059s) {
            this.f18059s = false;
            C11839m.m70688i("BackupDeviceFragment", "refreshing");
            C12515a.m75110o().m75172d(new C3952c(this.f18058r));
        }
    }

    /* renamed from: n */
    public final void m24093n(LinkedHashMap<String, String> linkedHashMap) {
        C13225d.m79490f1().m79567R("ENTER_BACKUP_DEVICE", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "ENTER_BACKUP_DEVICE", linkedHashMap);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02022"), "Remove.device.list", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        C13622a.m81969o(getActivity(), c11060cM66626a, linkedHashMap);
    }

    /* renamed from: o */
    public final void m24094o(TextView textView, CBSDeviceCleanItem cBSDeviceCleanItem) {
        textView.setText(getActivity().getResources().getString(R$string.backup_last_used, C10159j.m63334j(new Date(C0241z.m1688f(cBSDeviceCleanItem.getCbsDevice().getBakUpdateTime())))));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.backup_info_layout || id2 == R$id.backup_clear_device_btn) {
            if (C0209d.m1226Y0()) {
                C11839m.m70689w("BackupDeviceFragment", "fast click");
            } else {
                m24086g();
            }
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2;
        View view = this.f18041a;
        if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
            viewGroup2.removeView(this.f18041a);
        }
        if (C0209d.m1195O(getActivity()) >= 1.45f) {
            this.f18041a = layoutInflater.inflate(R$layout.item_space_clear_backup_scale_3, viewGroup, false);
        } else {
            this.f18041a = layoutInflater.inflate(R$layout.item_space_clear_backup, viewGroup, false);
        }
        this.f18058r = new HandlerC3953d(this, null);
        m24090k();
        m24089j();
        CloudBackupService.getInstance().register(this.f18060t);
        m24088i();
        return this.f18041a;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f18057q != null && getActivity() != null) {
            C13108a.m78878b(getActivity()).m78883f(this.f18057q);
            this.f18057q = null;
        }
        if (this.f18060t != null) {
            CloudBackupService.getInstance().unregister(this.f18060t);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m24092m();
    }

    /* renamed from: p */
    public final void m24095p(ImageView imageView, CBSDeviceCleanItem cBSDeviceCleanItem) {
        imageView.setImageDrawable(DeviceIconManager.getInstance().getDeviceIconFromCache(cBSDeviceCleanItem.getCbsDevice().getTerminalType(), cBSDeviceCleanItem.getCbsDevice().getDeviceCategory()));
    }

    /* renamed from: q */
    public final void m24096q(TextView textView, CBSDeviceCleanItem cBSDeviceCleanItem) throws Resources.NotFoundException {
        String devDisplayName = cBSDeviceCleanItem.getCbsDevice().getDevDisplayName();
        if (TextUtils.isEmpty(devDisplayName)) {
            devDisplayName = cBSDeviceCleanItem.getCbsDevice().getAliasName();
        }
        if (TextUtils.isEmpty(devDisplayName)) {
            devDisplayName = getString(R$string.setting_other);
        }
        if (cBSDeviceCleanItem.isCurrent()) {
            devDisplayName = getActivity().getResources().getString(R$string.cloudbackup_self_device_new_update, devDisplayName);
        }
        textView.setText(devDisplayName);
        textView.setContentDescription(devDisplayName + ".");
    }

    /* renamed from: r */
    public final void m24097r(TextView textView, CBSDeviceCleanItem cBSDeviceCleanItem) {
        String strM1524g = C0223k.m1524g(getActivity(), C0241z.m1688f(cBSDeviceCleanItem.getCbsDevice().getDeviceSpace()));
        textView.setText(strM1524g);
        textView.setContentDescription(strM1524g);
    }

    /* renamed from: s */
    public final void m24098s(long j10) {
        View view;
        if (C10810x.m65812h(System.currentTimeMillis(), C10028c.m62182c0().m62393t()) && C10810x.m65813i(j10) && (view = this.f18055o) != null) {
            view.setVisibility(0);
        } else {
            this.f18055o.setVisibility(8);
        }
    }

    /* renamed from: t */
    public final void m24099t(int i10) {
        if (i10 > 1) {
            C12809f.m76843p(this.f18044d, true);
            C12809f.m76843p(this.f18045e, true);
            C12809f.m76843p(this.f18050j, true);
            C12809f.m76843p(this.f18056p, true);
            this.f18043c.setOnClickListener(this);
            this.f18043c.setEnabled(true);
            return;
        }
        if (i10 > 0) {
            C12809f.m76843p(this.f18044d, true);
            C12809f.m76843p(this.f18045e, true);
            C12809f.m76843p(this.f18050j, false);
            C12809f.m76843p(this.f18056p, true);
            this.f18043c.setOnClickListener(this);
            this.f18043c.setEnabled(true);
            return;
        }
        C12809f.m76843p(this.f18044d, false);
        C12809f.m76843p(this.f18045e, false);
        C12809f.m76843p(this.f18050j, false);
        C12809f.m76843p(this.f18056p, false);
        this.f18043c.setOnClickListener(null);
        this.f18043c.setEnabled(false);
    }
}
