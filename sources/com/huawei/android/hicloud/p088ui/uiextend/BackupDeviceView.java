package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.task.BackupRecordSingleTask;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.hisync.model.BackupDetailItem;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.HiCloudTextView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.fragment.TempMainPageRecordFragment;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupDeviceAdapter;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.router.data.UserBackupInfo;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0223k;
import p037bp.C1270a;
import p053ce.C1424b;
import p232dp.InterfaceC9283b;
import p292fn.C9733f;
import p336he.C10155f;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import p681uj.C13195l;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13461a;
import p711vl.C13467g;
import p847zk.C14317j;
import p848zl.C14342k;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupDeviceView extends FrameLayout implements View.OnClickListener, BackupDeviceAdapter.IRecyclerViewOnListener {
    private static final float DISABLE_ALPHA = 0.6f;
    private static final String HWID_DEVIC_MANAGER_URI = "hwid://com.huawei.hwid/DeviceManager";
    private static final int MAX = 3;
    private static final String STATUS_BACKUP = "1";
    private static final String STATUS_BACKUP_COMPLETED = "3";
    private static final String STATUS_BACKUP_INTERRUPTION = "2";
    private static final String STATUS_INCOMPLETE = "6";
    private static final String STATUS_OTHER_DEVICE = "5";
    private static final String STATUS_RESTORE = "4";
    private static final String TAG = "BackupDeviceView";
    private static final String TYPE_FACE_SPAN_FAMILY_HW_CHINESE_MEDIUM = "HwChinese-medium";
    private RelativeLayout backupBannerLayout;
    private TextView backupBannerText;
    private HiCloudTextView backupBannerTitle;
    private BackupDeviceAdapter backupDeviceAdapter;
    private HwTextView backupDeviceTextMore;
    private LinearLayout backupDeviceTitle;
    private NotchFitRelativeLayout backupMainLayout;
    private AutoSizeButton backupNowButton;
    private RecyclerView backupRecyclerView;
    private View backupStateView;
    private View bannerView;
    private CloudBackupState cloudBackupState;
    private Context context;
    private int deviceSize;
    private GridLayoutManager gridLayoutManager;
    private boolean hasSameDeviceNames;
    private View inflateView;
    private boolean isBackFromDeviceManager;
    private boolean isRefurbishing;
    private boolean isSupportDeviceManager;
    private C1424b itemDecoration;
    private View loadingView;
    private List<Object> recyclerViewItemList;
    private TempMainPageRecordFragment tempBackupRecordsFragment;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.BackupDeviceView$1 */
    public class C41051 extends BackupRecordSingleTask {
        public C41051() {
        }

        public /* synthetic */ void lambda$call$0(String str, List list, LinkedList linkedList, int i10) throws Resources.NotFoundException {
            BackupDeviceView backupDeviceView = BackupDeviceView.this;
            backupDeviceView.initDeviceTitleMore(backupDeviceView.deviceSize);
            BackupDeviceView.this.refreshCurDeviceName(str);
            BackupDeviceView.this.initListData(list);
            BackupDeviceView.this.tempBackupRecordsFragment.m24335h(linkedList, i10);
        }

        /* JADX WARN: Removed duplicated region for block: B:129:0x00fc  */
        @Override // com.huawei.android.hicloud.cloudbackup.process.task.BackupRecordSingleTask, p616rk.AbstractRunnableC12516b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call() {
            /*
                Method dump skipped, instructions count: 530
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.uiextend.BackupDeviceView.C41051.call():void");
        }
    }

    public static class LayoutManager extends GridLayoutManager {
        public LayoutManager(Context context, int i10) {
            super(context, i10);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0846p
        public boolean canScrollVertically() {
            return false;
        }
    }

    public BackupDeviceView(Context context) throws Resources.NotFoundException {
        super(context);
        this.recyclerViewItemList = new ArrayList();
        this.isRefurbishing = false;
        this.context = context;
        this.isRefurbishing = C14317j.m85300d().m85309j();
        initView();
    }

    private ViewStub findViewStubById(View view, int i10) {
        if (view == null) {
            return null;
        }
        View viewFindViewById = view.findViewById(i10);
        if (viewFindViewById instanceof ViewStub) {
            return (ViewStub) viewFindViewById;
        }
        return null;
    }

    public String getTempCurrentName(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        if (!C9733f.m60705z().m60720O("cloudBackupDeviceNameManagement")) {
            return C0209d.m1174H();
        }
        CloudBackupState cloudBackupState = this.cloudBackupState;
        return cloudBackupState == null ? C11477c.m68633c(userDeviceInfo.getDevDisplayName()) : TextUtils.isEmpty(cloudBackupState.getDeviceName()) ? C0209d.m1171G() : this.cloudBackupState.getDeviceName();
    }

    private boolean hasSameDeviceNames(List<UserBackupInfo.UserDeviceInfo> list) {
        if (!this.isSupportDeviceManager) {
            return false;
        }
        HashSet hashSet = new HashSet();
        if (list != null && !list.isEmpty()) {
            for (UserBackupInfo.UserDeviceInfo userDeviceInfo : list) {
                String str = userDeviceInfo.getDeviceCategory() + "_" + userDeviceInfo.getDeviceName().trim();
                if (hashSet.contains(str)) {
                    return true;
                }
                hashSet.add(str);
            }
        }
        return false;
    }

    private void initBackupDeviceNamePrompt() throws Resources.NotFoundException {
        final SpanClickText spanClickText = (SpanClickText) C12809f.m76831d(this.backupStateView, R$id.device_name_duplicate_tip);
        if (!this.hasSameDeviceNames) {
            C11839m.m70689w(TAG, "no need initBackupDeviceNamePrompt");
            spanClickText.setVisibility(8);
            return;
        }
        try {
            Resources resources = getResources();
            if (resources != null) {
                String string = resources.getString(R$string.login_devices_management_prompt);
                String string2 = resources.getString(R$string.backup_device_names_duplicate_prompt, string);
                spanClickText.m15931c(string, new SpanClickText.ISpanClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.b
                    @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
                    public final void onClick() {
                        this.f19181a.lambda$initBackupDeviceNamePrompt$4(spanClickText);
                    }
                });
                spanClickText.m15934g(string2, false);
                spanClickText.setVisibility(0);
            }
        } catch (Exception e10) {
            C11839m.m70689w(TAG, "initBackupDeviceNamePrompt error: " + e10.toString());
        }
    }

    private void initBackupStateView() {
        if (this.backupStateView == null) {
            this.backupStateView = findViewStubById(this.inflateView, R$id.backupmain_state).inflate();
        }
        this.backupRecyclerView = (RecyclerView) C12809f.m76831d(this.backupStateView, R$id.backupmain_state_recyclerView);
        if (this.backupDeviceAdapter == null) {
            this.backupDeviceAdapter = new BackupDeviceAdapter(this.context);
        }
        this.backupDeviceAdapter.m24721Z(this);
        this.backupRecyclerView.setAdapter(this.backupDeviceAdapter);
        this.backupRecyclerView.setHasFixedSize(true);
        Context context = this.context;
        LayoutManager layoutManager = new LayoutManager(context, C11842p.m70868u(context));
        this.gridLayoutManager = layoutManager;
        this.backupRecyclerView.setLayoutManager(layoutManager);
        this.backupRecyclerView.setNestedScrollingEnabled(false);
        this.backupStateView.setVisibility(8);
    }

    private void initBannerView() {
        if (this.bannerView == null) {
            this.bannerView = findViewStubById(this.inflateView, R$id.backupmain_state_switch_off_layout).inflate();
        }
        this.backupNowButton = (AutoSizeButton) C12809f.m76831d(this.bannerView, R$id.backup_start_now);
        this.backupBannerText = (TextView) C12809f.m76831d(this.bannerView, R$id.backup_banner_text);
        this.backupBannerTitle = (HiCloudTextView) C12809f.m76831d(this.bannerView, R$id.backup_banner_title);
        this.backupBannerLayout = (RelativeLayout) C12809f.m76831d(this.bannerView, R$id.backup_banner_layout);
        this.bannerView.setVisibility(0);
        this.backupNowButton.setOnClickListener(new ViewOnClickListenerC4133a(this));
        this.backupBannerLayout.setOnClickListener(new ViewOnClickListenerC4133a(this));
        setDeviceTitleStatus(false);
        this.backupMainLayout.setBackground(this.context.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
        if (!C0209d.m1166E1()) {
            this.backupNowButton.setEnabled(false);
            this.backupNowButton.setAlpha(0.6f);
            this.backupBannerLayout.setEnabled(false);
            this.backupBannerLayout.setAlpha(0.6f);
        }
        initBannerViewForBig();
    }

    private void initBannerViewForBig() {
        if (C0209d.m1195O(this.context) >= 1.75f) {
            TextView textView = this.backupBannerText;
            if (textView != null) {
                textView.setVisibility(8);
            }
            HiCloudTextView hiCloudTextView = this.backupBannerTitle;
            if (hiCloudTextView != null) {
                hiCloudTextView.setTextSize(1, 36.0f);
            }
        }
    }

    public void initDeviceTitleMore(int i10) {
        if (i10 > 3) {
            setDeviceTitleStatus(true);
        } else {
            setDeviceTitleStatus(false);
        }
    }

    public void initListData(List<UserBackupInfo.UserDeviceInfo> list) throws Resources.NotFoundException {
        if (this.cloudBackupState == null || this.backupStateView == null) {
            return;
        }
        this.recyclerViewItemList.clear();
        this.recyclerViewItemList.add(this.cloudBackupState);
        if (list != null) {
            this.recyclerViewItemList.addAll(list);
        }
        this.backupDeviceAdapter.m24719X(this.recyclerViewItemList);
        setLayoutManager();
        this.backupDeviceAdapter.m24723b0(this.isRefurbishing);
        this.backupDeviceAdapter.m5213j();
        this.hasSameDeviceNames = hasSameDeviceNames(list);
        initBackupDeviceNamePrompt();
        if (this.loadingView != null && this.recyclerViewItemList.size() > 0) {
            this.loadingView.setVisibility(8);
        }
        C13461a.m81002d(this.context).m81012k(this.cloudBackupState);
    }

    private void initLoadingView() {
        if (this.loadingView == null) {
            this.loadingView = findViewStubById(this.inflateView, R$id.backupmain_state_loading).inflate();
        }
        this.loadingView.setVisibility(0);
    }

    private void initView() throws Resources.NotFoundException {
        C11839m.m70688i(TAG, "initView newBmType: " + C13452e.m80781L().m80887a1());
        setVisibility(8);
        if (C0209d.m1195O(this.context) >= 1.75f) {
            this.inflateView = View.inflate(this.context, R$layout.backup_device_state_scale, this);
        } else {
            this.inflateView = View.inflate(this.context, R$layout.backup_device_state, this);
        }
        this.backupDeviceTextMore = (HwTextView) C12809f.m76831d(this.inflateView, R$id.backup_device_text_more);
        this.backupDeviceTitle = (LinearLayout) C12809f.m76831d(this.inflateView, R$id.backup_device_item_title);
        this.backupMainLayout = (NotchFitRelativeLayout) C12809f.m76831d(this.inflateView, R$id.backup_main_layout);
        this.backupDeviceTitle.setOnClickListener(new ViewOnClickListenerC4133a(this));
        this.backupDeviceTextMore.setVisibility(8);
        this.tempBackupRecordsFragment = (TempMainPageRecordFragment) C12809f.m76828a(((Activity) this.context).getFragmentManager(), R$id.fragment_temp_backup_records);
        if (C9733f.m60705z().m60720O("cloudBackupDeviceNameManagement")) {
            this.isSupportDeviceManager = true;
        }
        ArrayList arrayList = new ArrayList();
        CloudBackupState cloudBackupStateM81005c = C13461a.m81002d(this.context).m81005c();
        if (cloudBackupStateM81005c != null) {
            arrayList.add(cloudBackupStateM81005c);
        }
        List<UserBackupInfo.UserDeviceInfo> listM81008g = C13461a.m81002d(this.context).m81008g();
        int size = listM81008g.size();
        this.deviceSize = size;
        if (size > 0) {
            arrayList.addAll(listM81008g);
            this.hasSameDeviceNames = hasSameDeviceNames(listM81008g);
        }
        initDeviceTitleMore(this.deviceSize);
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        this.itemDecoration = new C1424b(C11842p.m70840n(this.context, 8));
        if (zM62388s) {
            initBackupStateView();
            if (arrayList.size() > 0) {
                this.backupDeviceAdapter.m24723b0(this.isRefurbishing);
                this.backupDeviceAdapter.m24719X(arrayList);
                this.backupDeviceAdapter.m5213j();
                this.backupStateView.setVisibility(0);
                initBackupDeviceNamePrompt();
            } else {
                initLoadingView();
            }
            setLayoutManager();
        } else {
            initBannerView();
        }
        List<UserBackupInfo.UserDeviceInfo> listM81007f = C13461a.m81002d(this.context).m81007f();
        if (listM81007f != null && !listM81007f.isEmpty()) {
            this.tempBackupRecordsFragment.m24335h(listM81007f, listM81007f.size());
        }
        if (!C0209d.m1166E1()) {
            setEnabled(false);
            setAlpha(0.6f);
            LinearLayout linearLayout = this.backupDeviceTitle;
            if (linearLayout != null) {
                linearLayout.setEnabled(false);
                this.backupDeviceTitle.setAlpha(0.6f);
            }
        }
        if (C10155f.m63301y()) {
            return;
        }
        setVisibility(8);
    }

    private static boolean isEnterRestorePage(int i10) {
        if (i10 == 0 || i10 == 8) {
            return false;
        }
        if (i10 == 3 || i10 == 5) {
            List<CloudRestoreItem> itemList = RestoreUtil.getItemList();
            int failCount = RestoreUtil.getFailCount(0, itemList);
            int succeedCount = RestoreUtil.getSucceedCount(0, itemList);
            if ((failCount <= 0 || succeedCount <= 0) && failCount <= 0 && succeedCount > 0) {
                return false;
            }
        }
        return true;
    }

    private void jumpToHmsDeviceManager() {
        try {
            Intent intentM79271I = C13195l.m79271I(this.context, HWID_DEVIC_MANAGER_URI);
            if (intentM79271I == null) {
                C11839m.m70687e(TAG, "hmsPackage is invalid!");
            } else {
                ((Activity) this.context).startActivityForResult(intentM79271I, 10055);
            }
        } catch (Exception e10) {
            C11839m.m70688i(TAG, "jumpToHmsDeviceManager exception: " + e10.toString());
        }
    }

    public /* synthetic */ void lambda$initBackupDeviceNamePrompt$4(SpanClickText spanClickText) {
        if (spanClickText != null) {
            C11839m.m70688i(TAG, "set tvBackupDeviceNamePrompt on click");
            jumpToHmsDeviceManager();
        }
    }

    public static /* synthetic */ boolean lambda$sortOtherDevicePolicy$0(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        return userDeviceInfo.getLastbackupTime() > 0;
    }

    public static /* synthetic */ int lambda$sortOtherDevicePolicy$1(UserBackupInfo.UserDeviceInfo userDeviceInfo, UserBackupInfo.UserDeviceInfo userDeviceInfo2) {
        if (userDeviceInfo2.getLastbackupTime() - userDeviceInfo.getLastbackupTime() > 0) {
            return 1;
        }
        return userDeviceInfo2.getLastbackupTime() - userDeviceInfo.getLastbackupTime() < 0 ? -1 : 0;
    }

    public static /* synthetic */ boolean lambda$sortOtherDevicePolicy$2(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        return userDeviceInfo.getLastbackupTime() == 0;
    }

    public static /* synthetic */ int lambda$sortOtherDevicePolicy$3(UserBackupInfo.UserDeviceInfo userDeviceInfo, UserBackupInfo.UserDeviceInfo userDeviceInfo2) {
        if (userDeviceInfo2.getSize() - userDeviceInfo.getSize() > 0) {
            return 1;
        }
        return userDeviceInfo2.getSize() - userDeviceInfo.getSize() < 0 ? -1 : 0;
    }

    public static void processBackupItemClick(Context context, boolean z10, boolean z11, boolean z12) {
        int iM80916g0 = C13452e.m80781L().m80916g0();
        C11839m.m70688i(TAG, "restoreStatus = " + iM80916g0);
        if (!isEnterRestorePage(iM80916g0)) {
            if (!z12) {
                C11839m.m70688i(TAG, "can not goto backup main");
                return;
            }
            C11839m.m70688i(TAG, "<processBackupItemClick> start backup main activity.");
            Intent intent = new Intent(context, (Class<?>) BackupMainActivity.class);
            MainActivity mainActivity = (MainActivity) context;
            if (!TextUtils.isEmpty(mainActivity.m21260R5())) {
                intent.putExtra("channel_of_open_switch", mainActivity.m21260R5());
            }
            if (!TextUtils.isEmpty(mainActivity.m21323Z5())) {
                intent.putExtra("scene_of_manual_backup", mainActivity.m21323Z5());
            }
            if (!TextUtils.isEmpty(mainActivity.m21283U5())) {
                intent.putExtra("entrance_of_restore", mainActivity.m21283U5());
            }
            intent.putExtra("isOpenSwitch", z10);
            intent.putExtra("queryType", z11);
            C13230i.m79525e1(intent, "1", "2");
            context.startActivity(intent);
            return;
        }
        C11839m.m70688i(TAG, "<processBackupItemClick> start restore main activity.");
        if (CBAccess.inRestoreTask()) {
            startRestoreMainActivity(context, 2, iM80916g0);
            C11839m.m70688i(TAG, "inRestore = " + CBAccess.inRestore());
        } else {
            if (C0209d.m1150A1(context)) {
                if (iM80916g0 == 1) {
                    C13452e.m80781L().m80914f3(7);
                } else if (iM80916g0 != 2) {
                    C13452e.m80781L().m80914f3(6);
                }
            } else if (iM80916g0 == 1) {
                C13452e.m80781L().m80914f3(7);
            }
            startRestoreMainActivity(context, 2, iM80916g0);
        }
        if (z10 && (context instanceof MainActivity)) {
            BackupMainActivity.m18672b6(TAG, ((MainActivity) context).m21260R5());
        }
    }

    private void refreshCloudBackupState(CloudBackupState cloudBackupState) {
        if (this.isSupportDeviceManager) {
            String strM81088b = C13467g.m81086c().m81088b();
            if (TextUtils.isEmpty(strM81088b)) {
                return;
            }
            String strM68633c = C11477c.m68633c(strM81088b);
            if (TextUtils.isEmpty(strM68633c)) {
                return;
            }
            cloudBackupState.setDeviceName(strM68633c);
        }
    }

    public void refreshCurDeviceName(String str) {
        if (this.isSupportDeviceManager && this.cloudBackupState != null) {
            if (TextUtils.isEmpty(str)) {
                refreshCloudBackupState(this.cloudBackupState);
            } else {
                this.cloudBackupState.setDeviceName(str);
            }
        }
    }

    private void reportClickEvent(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            C11839m.m70689w(TAG, "reportClickEvent eventId or eventXChl is empty");
        } else {
            C13225d.m79490f1().m79585f0(str, C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", str, "1", str2);
        }
    }

    private void setLayoutManager() {
        if (this.backupRecyclerView == null || this.backupStateView.getVisibility() == 8) {
            C11839m.m70688i(TAG, "setLayoutManager backupRecyclerView is null");
            return;
        }
        int iM70868u = C11842p.m70868u(this.context);
        if (iM70868u > 1) {
            this.backupMainLayout.setBackground(null);
        } else {
            this.backupMainLayout.setBackground(this.context.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
        }
        C1424b c1424b = this.itemDecoration;
        if (c1424b != null) {
            this.backupRecyclerView.removeItemDecoration(c1424b);
        }
        if (this.backupDeviceAdapter.mo721e() == 1) {
            this.backupMainLayout.setBackground(this.context.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
            this.itemDecoration.m8279a(1);
            iM70868u = 1;
        }
        if (iM70868u > 1) {
            this.itemDecoration.m8279a(iM70868u);
            this.backupRecyclerView.addItemDecoration(this.itemDecoration);
        }
        if (this.backupRecyclerView.getAdapter() != null) {
            this.backupDeviceAdapter.m24718W(iM70868u);
        }
        this.gridLayoutManager.setSpanCount(iM70868u);
        this.backupDeviceAdapter.m5213j();
    }

    public List<UserBackupInfo.UserDeviceInfo> sortOtherDevicePolicy(List<UserBackupInfo.UserDeviceInfo> list) {
        ArrayList arrayList = new ArrayList();
        List list2 = (List) list.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.uiextend.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return BackupDeviceView.lambda$sortOtherDevicePolicy$0((UserBackupInfo.UserDeviceInfo) obj);
            }
        }).sorted(new Comparator() { // from class: com.huawei.android.hicloud.ui.uiextend.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BackupDeviceView.lambda$sortOtherDevicePolicy$1((UserBackupInfo.UserDeviceInfo) obj, (UserBackupInfo.UserDeviceInfo) obj2);
            }
        }).collect(Collectors.toList());
        List list3 = (List) list.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.ui.uiextend.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return BackupDeviceView.lambda$sortOtherDevicePolicy$2((UserBackupInfo.UserDeviceInfo) obj);
            }
        }).sorted(new Comparator() { // from class: com.huawei.android.hicloud.ui.uiextend.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BackupDeviceView.lambda$sortOtherDevicePolicy$3((UserBackupInfo.UserDeviceInfo) obj, (UserBackupInfo.UserDeviceInfo) obj2);
            }
        }).collect(Collectors.toList());
        arrayList.addAll(list2);
        arrayList.addAll(list3);
        return arrayList;
    }

    private static void startRestoreMainActivity(Context context, int i10, int i11) {
        ((InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class)).mo58490V(context, i10, i11);
    }

    public boolean isRefurbishing() {
        return this.isRefurbishing;
    }

    public void notifyItem() {
        C11839m.m70688i(TAG, " notifyItem ");
        if (C13452e.m80781L().m80887a1()) {
            return;
        }
        C12515a.m75110o().m75172d(new C41051());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        if (C0209d.m1226Y0()) {
            return;
        }
        if (view.getId() == R$id.backup_banner_layout) {
            processBackupItemClick(this.context, false, this.isBackFromDeviceManager, true);
            str = "action_code_backupitem_open";
            str2 = "67";
        } else if (view.getId() == R$id.backup_start_now) {
            processBackupItemClick(this.context, true, this.isBackFromDeviceManager, true);
            str = "action_code_backupitem_open_view";
            str2 = "87";
        } else if (view.getId() == R$id.backup_device_item_title) {
            Intent intent = new Intent(this.context, (Class<?>) CloudSpaceBackupActivity.class);
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 1);
            intent.putExtra("queryType", this.isBackFromDeviceManager);
            C13230i.m79525e1(intent, "1", "mecloud_backupmain_click_more");
            this.context.startActivity(intent);
            str2 = "86";
            str = "mecloud_backupmain_click_more";
        } else {
            str = null;
            str2 = null;
        }
        reportClickEvent(str, str2);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setLayoutManager();
        TempMainPageRecordFragment tempMainPageRecordFragment = this.tempBackupRecordsFragment;
        if (tempMainPageRecordFragment != null) {
            tempMainPageRecordFragment.m24337j();
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.BackupDeviceAdapter.IRecyclerViewOnListener
    public void onItemClick(int i10, Object obj) {
        if (C0209d.m1226Y0()) {
            return;
        }
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        if (obj instanceof CloudBackupState) {
            processBackupItemClick(this.context, false, this.isBackFromDeviceManager, true);
            CloudBackupState cloudBackupState = (CloudBackupState) obj;
            if (cloudBackupState.getId() == 1) {
                int iIntValue = cloudBackupState.getState().intValue();
                if (C14342k.m85520a(iIntValue)) {
                    linkedHashMapM79499C.put("status", "1");
                } else if (iIntValue == 2) {
                    linkedHashMapM79499C.put("status", "2");
                } else if (iIntValue == 3) {
                    linkedHashMapM79499C.put("status", "3");
                } else if (iIntValue == 4) {
                    linkedHashMapM79499C.put("status", "6");
                }
            } else {
                linkedHashMapM79499C.put("status", "4");
            }
        } else if (obj instanceof UserBackupInfo.UserDeviceInfo) {
            linkedHashMapM79499C.put("status", "5");
            UserBackupInfo.UserDeviceInfo userDeviceInfo = (UserBackupInfo.UserDeviceInfo) obj;
            BackupDetailItem backupDetailItem = new BackupDetailItem();
            backupDetailItem.m16384n(userDeviceInfo.getBackupDeviceId());
            backupDetailItem.m16386p(userDeviceInfo.isCurrent() ? 1 : 0);
            backupDetailItem.m16388r(userDeviceInfo.getDeviceCategory());
            backupDetailItem.m16389s(userDeviceInfo.getDeviceID());
            backupDetailItem.m16390t(userDeviceInfo.getDeviceType());
            backupDetailItem.m16368A(String.valueOf(userDeviceInfo.getLastbackupTime()));
            backupDetailItem.m16369I(TextUtils.isEmpty(userDeviceInfo.getDevDisplayName()) ? userDeviceInfo.getDeviceName() : userDeviceInfo.getDevDisplayName());
            backupDetailItem.m16370K(userDeviceInfo.getSize());
            backupDetailItem.m16372M(C0223k.m1524g(this.context, userDeviceInfo.getSize()));
            C11839m.m70688i(TAG, "onItemClick:detailItem.getSize" + userDeviceInfo.getSize());
            Intent intent = new Intent(this.context, (Class<?>) CloudSpaceBackupDetailActivity.class);
            intent.putExtra("backup_item_param", backupDetailItem);
            intent.putExtra("queryType", this.isBackFromDeviceManager);
            intent.putExtra("isOnlyRefurbish", userDeviceInfo.isOnlyRefurbish());
            intent.putExtra("isOnlyHarmonyNext", userDeviceInfo.isOnlyHarmonyNext());
            intent.putExtra("backup_delete_report_entry", 3);
            ((Activity) this.context).startActivityForResult(intent, 10024);
        }
        C13225d.m79490f1().m79591l0("mecloud_main_click_cloudbackup", linkedHashMapM79499C);
        UBAAnalyze.m29954O("PVC", "mecloud_main_click_cloudbackup", "1", "43");
    }

    public void setBackFromDeviceManager(boolean z10) {
        this.isBackFromDeviceManager = z10;
    }

    public void setDeviceTitleStatus(boolean z10) {
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        if (zM62388s) {
            this.backupDeviceTextMore.setVisibility(z10 ? 0 : 8);
        } else {
            this.backupDeviceTextMore.setVisibility(8);
        }
        if (C0209d.m1166E1() && zM62388s) {
            this.backupDeviceTitle.setEnabled(z10);
            this.backupDeviceTitle.setClickable(z10);
        } else {
            this.backupDeviceTitle.setEnabled(false);
            this.backupDeviceTitle.setClickable(false);
        }
    }

    public void setRefurbishing(boolean z10) {
        this.isRefurbishing = z10;
        BackupDeviceAdapter backupDeviceAdapter = this.backupDeviceAdapter;
        if (backupDeviceAdapter != null) {
            backupDeviceAdapter.m24723b0(z10);
            this.backupDeviceAdapter.m5214k(0);
        }
    }

    public void show(CloudBackupState cloudBackupState) {
        if (cloudBackupState != null) {
            this.cloudBackupState = cloudBackupState;
            if (TextUtils.isEmpty(cloudBackupState.getDeviceName())) {
                refreshCloudBackupState(this.cloudBackupState);
            }
        }
        if (!C10028c.m62182c0().m62388s("backup_key")) {
            initBannerView();
            View view = this.loadingView;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.backupStateView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this.bannerView;
            if (view3 != null) {
                view3.setVisibility(0);
                return;
            }
            return;
        }
        initBackupStateView();
        List<Object> list = this.recyclerViewItemList;
        if (list == null || list.size() == 0) {
            C11839m.m70688i(TAG, "initBackupStateView notifyItem");
            notifyItem();
        } else {
            C11839m.m70688i(TAG, "initBackupStateView notifyItemChanged");
            this.recyclerViewItemList.set(0, cloudBackupState);
            this.backupDeviceAdapter.m24723b0(this.isRefurbishing);
            this.backupDeviceAdapter.m24719X(this.recyclerViewItemList);
            this.backupDeviceAdapter.m5214k(0);
        }
        View view4 = this.backupStateView;
        if (view4 != null) {
            view4.setVisibility(0);
        }
        if (this.loadingView != null && this.recyclerViewItemList.size() > 0) {
            this.loadingView.setVisibility(8);
        }
        View view5 = this.bannerView;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        setLayoutManager();
        TempMainPageRecordFragment tempMainPageRecordFragment = this.tempBackupRecordsFragment;
        if (tempMainPageRecordFragment != null) {
            tempMainPageRecordFragment.m24334g();
        }
        initDeviceTitleMore(this.deviceSize);
    }

    public BackupDeviceView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.recyclerViewItemList = new ArrayList();
        this.isRefurbishing = false;
        this.context = context;
        this.isRefurbishing = C14317j.m85300d().m85309j();
        initView();
    }
}
