package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.huawei.android.hicloud.cloudbackup.clean.BackupCleanRecordsManager;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiextend.backup.CleanupEntryView;
import com.huawei.android.hicloud.p088ui.uiextend.backup.CleanupItemView;
import com.huawei.android.hicloud.p088ui.uiextend.backup.RecommendCleanupView;
import com.huawei.android.hicloud.task.simple.C3012a2;
import com.huawei.android.hicloud.task.simple.C3024d2;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0219i;
import p020ap.C1006a;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13225d;
import p709vj.C13452e;
import p771xd.HandlerC13763g;
import p783xp.C13843a;
import p850zo.InterfaceC14350a;
import p850zo.InterfaceC14351b;
import sk.C12806c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class IntelligentClearActivity extends Activity implements View.OnClickListener {

    /* renamed from: r */
    public static final Uri f15136r = Uri.parse(NotifyConstants.CloudAlbumReleaseSpace.ALBUM_SPACE_SIZE_URI);

    /* renamed from: a */
    public String f15137a;

    /* renamed from: b */
    public String f15138b;

    /* renamed from: d */
    public ScrollView f15140d;

    /* renamed from: e */
    public NotchTopFitRelativeLayout f15141e;

    /* renamed from: f */
    public NotchFitRelativeLayout f15142f;

    /* renamed from: g */
    public CleanupEntryView f15143g;

    /* renamed from: h */
    public RecommendCleanupView f15144h;

    /* renamed from: i */
    public NotchFitRelativeLayout f15145i;

    /* renamed from: j */
    public CleanupItemView f15146j;

    /* renamed from: k */
    public CleanupItemView f15147k;

    /* renamed from: l */
    public CleanupItemView f15148l;

    /* renamed from: m */
    public HiCloudExceptionView f15149m;

    /* renamed from: n */
    public NetWorkChangeReceiver f15150n;

    /* renamed from: c */
    public boolean f15139c = false;

    /* renamed from: o */
    public HandlerC13763g f15151o = new HandlerC13763g(this);

    /* renamed from: p */
    public List<View> f15152p = new ArrayList();

    /* renamed from: q */
    public final Handler f15153q = new HandlerC3331a(Looper.myLooper());

    public class NetWorkChangeReceiver extends BroadcastReceiver {
        public NetWorkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction())) {
                boolean zM1333z1 = C0209d.m1333z1(context);
                if (IntelligentClearActivity.this.f15149m != null) {
                    if (zM1333z1) {
                        IntelligentClearActivity.this.f15149m.m23914a();
                    } else {
                        IntelligentClearActivity.this.f15149m.m23919i();
                    }
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.IntelligentClearActivity$a */
    public class HandlerC3331a extends Handler {
        public HandlerC3331a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            C11839m.m70688i("IntelligentClearActivity", "msg what: " + message.what);
            int i10 = message.what;
            if (i10 != 9000) {
                if (i10 == 100) {
                    C11839m.m70688i("IntelligentClearActivity", "msg what: " + message.what + ", albumDisableState: " + message.arg1);
                    IntelligentClearActivity.this.m20921H(message.arg1);
                    return;
                }
                return;
            }
            Object obj = message.obj;
            if (obj instanceof C3012a2.a) {
                C3012a2.a aVar = (C3012a2.a) obj;
                C11839m.m70688i("IntelligentClearActivity", "msg dataCallback: " + aVar.toString());
                IntelligentClearActivity.this.m20916C(aVar);
                IntelligentClearActivity.this.m20917D(aVar);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.IntelligentClearActivity$b */
    public class C3332b implements InterfaceC14350a {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC9282a f15156a;

        public C3332b(InterfaceC9282a interfaceC9282a) {
            this.f15156a = interfaceC9282a;
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: a */
        public void mo13562a() {
            m20942e(0L, 0, this.f15156a);
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: b */
        public void mo13563b() {
            m20942e(0L, -2, this.f15156a);
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: c */
        public void mo13564c() {
            m20942e(0L, -1, this.f15156a);
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: d */
        public void mo13565d(int i10, int i11, long j10, int i12) {
            m20942e(j10, 1, this.f15156a);
        }

        /* renamed from: e */
        public final void m20942e(long j10, int i10, InterfaceC9282a interfaceC9282a) {
            if (i10 != -2) {
                interfaceC9282a.mo58439l(IntelligentClearActivity.this, i10, j10);
            }
            IntelligentClearActivity.this.f15153q.obtainMessage(100, i10, 0).sendToTarget();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.IntelligentClearActivity$c */
    public class C3333c extends AbstractC12367d {
        public C3333c() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                CloudSpace cloudSpace = CloudSpaceNotifyUtil.getInstance().getSpaceProxy().getCloudSpace();
                if (cloudSpace != null) {
                    long total = cloudSpace.getTotal();
                    IntelligentClearActivity.this.f15143g.setTotalSize(total);
                    C11839m.m70688i("getQuotaSpaceInfo", "getQuotaSpaceInfo total:" + total);
                }
            } catch (Exception e10) {
                C11839m.m70687e("IntelligentClearActivity", "QuerySpaceCheckVipTask querySpace error:" + e10.getMessage());
            }
        }
    }

    /* renamed from: A */
    public void m20914A(int i10) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(i10));
        }
    }

    /* renamed from: B */
    public boolean m20915B() {
        int iM1357g;
        String strM18235I = C3024d2.m18235I(this, false, null);
        String strM18234H = C3024d2.m18234H(this, false, null);
        if (FrequencyManager.checkInValidTime(this, strM18235I, strM18234H)) {
            C11839m.m70688i("IntelligentClearActivity", "showGuidH5 checkInValidTime true");
            return false;
        }
        if (!C0212e0.m1363m(this, strM18235I, strM18234H + "_pageType", "").equals("clean")) {
            C11839m.m70688i("IntelligentClearActivity", "showGuidH5  pageType error");
            return false;
        }
        if (!C0212e0.m1363m(this, strM18235I, strM18234H + "_" + FrequencyManager.H5DialogConstant.SCENETYPE, "").equals("exit")) {
            C11839m.m70688i("IntelligentClearActivity", "showGuidH5  intelligentClearSceneType error");
            return false;
        }
        int iM1357g2 = C0212e0.m1357g(this, strM18235I, strM18234H + "_num", -1);
        String strM1363m = C0212e0.m1363m(this, strM18235I, strM18234H + "_" + FrequencyManager.H5DialogConstant.H5URL, "");
        if (TextUtils.isEmpty(strM1363m) || iM1357g2 == -1) {
            C11839m.m70688i("IntelligentClearActivity", "showGuidH5  h5Url == null:  true");
            return false;
        }
        int iM1357g3 = C0212e0.m1357g(this, strM18235I, strM18234H + "_frequency", 1);
        FrequencyManager frequencyManager = new FrequencyManager();
        C11839m.m70688i("IntelligentClearActivity", "showGuidH5  intelligentClearFrequency: " + iM1357g3);
        if (iM1357g3 == 0) {
            iM1357g = C0212e0.m1357g(this, strM18235I, strM18234H + "_interval", 0);
        } else {
            iM1357g = 0;
        }
        if (!frequencyManager.checkGuideH5DialogFrequency(this, iM1357g3, -1, iM1357g)) {
            C11839m.m70688i("IntelligentClearActivity", "showGuidH5  checkGuideH5DialogFrequency:  false");
            return false;
        }
        String strM1363m2 = C0212e0.m1363m(this, strM18235I, strM18234H + "_" + FrequencyManager.H5DialogConstant.ACTIVEURL, "");
        String strM1363m3 = C0212e0.m1363m(this, strM18235I, strM18234H + "_" + FrequencyManager.H5DialogConstant.PACKAGEID, "");
        String strM1363m4 = C0212e0.m1363m(this, strM18235I, strM18234H + "_" + FrequencyManager.H5DialogConstant.NOTIFYTYPE, "");
        String strM1363m5 = C0212e0.m1363m(this, strM18235I, strM18234H + "_" + FrequencyManager.H5DialogConstant.NOTIFYURL, "");
        String strM1363m6 = C0212e0.m1363m(this, strM18235I, strM18234H + "_gradeCode", "");
        String strM1363m7 = C0212e0.m1363m(this, strM18235I, strM18234H + "_expireTime", "");
        if (iM1357g2 != 3 && iM1357g2 != 4) {
            return false;
        }
        m20922I(this, iM1357g2, strM1363m, strM1363m3, strM1363m4, strM1363m5, strM1363m2, strM1363m6, strM1363m7);
        return true;
    }

    /* renamed from: C */
    public final void m20916C(C3012a2.a aVar) throws Resources.NotFoundException {
        if (aVar.m18189b() == 0) {
            this.f15143g.setOldDeviceTip(aVar.m18188a());
            m20918E(aVar.m18188a());
        } else {
            this.f15143g.setDeviceErrorSubTip();
            this.f15144h.setVisibility(8);
        }
    }

    /* renamed from: D */
    public final void m20917D(C3012a2.a aVar) throws Resources.NotFoundException {
        if (aVar.m18189b() == 0) {
            this.f15143g.setOldRecordsTip(aVar.m18190c());
        } else {
            this.f15143g.setRecordErrorSubTip();
        }
    }

    /* renamed from: E */
    public final void m20918E(int i10) throws Resources.NotFoundException {
        if (i10 <= 0) {
            this.f15144h.setVisibility(8);
        } else {
            this.f15144h.setVisibility(0);
            this.f15144h.showOldDeviceCard(i10);
        }
    }

    /* renamed from: F */
    public final void m20919F() {
        C11839m.m70688i("IntelligentClearActivity", "IntelligentClearActivity start QueryGuideH5Task");
        C12515a.m75110o().m75175e(new C3024d2(this, this.f15151o, 1, "IntelligentClearActivity"), false);
    }

    /* renamed from: G */
    public final void m20920G() {
        NetWorkChangeReceiver netWorkChangeReceiver = this.f15150n;
        if (netWorkChangeReceiver != null) {
            unregisterReceiver(netWorkChangeReceiver);
            this.f15150n = null;
        }
    }

    /* renamed from: H */
    public final void m20921H(int i10) {
        C11839m.m70688i("IntelligentClearActivity", "updateAlbumView: disableState=" + i10);
        if (!C1006a.m5936k().m5975v(this)) {
            if (this.f15146j.getVisibility() == 8 && this.f15147k.getVisibility() == 8) {
                this.f15145i.setVisibility(8);
            }
            this.f15148l.setVisibility(8);
            return;
        }
        if (this.f15145i.getVisibility() == 8) {
            this.f15145i.setVisibility(0);
        }
        this.f15148l.setVisibility(0);
        if (i10 == 1) {
            this.f15148l.setSubTitleText(this.f15138b);
            this.f15148l.setEnabled(false);
        } else {
            this.f15148l.setSubTitleText(this.f15137a);
            this.f15148l.setEnabled(true);
        }
    }

    /* renamed from: I */
    public void m20922I(Activity activity, int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        try {
            Intent intent = new Intent(C0213f.m1377a(), (Class<?>) GuideWebViewActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("isEnableJs", true);
            intent.putExtra(NotifyConstants.Keys.NOTIFY_TYPE, str3);
            intent.putExtra(NotifyConstants.Keys.NOTIFY_URI, str4);
            intent.putExtra("activeUri", str5);
            intent.putExtra("packageId", str2);
            intent.putExtra("notifyAction", i10);
            intent.putExtra("gradeCode", str6);
            intent.putExtra("expireTime", str7);
            activity.startActivity(intent);
            long jCurrentTimeMillis = System.currentTimeMillis();
            C0212e0.m1370t(this, FrequencyManager.CHECK_GUID_H5_DIALOG_SP, FrequencyManager.CHECK_GUID_H5_DIALOG_TIME, jCurrentTimeMillis);
            C11839m.m70688i("IntelligentClearActivity", " QueryGuideH5Task  showGuidH5 System.currentTimeMillis(): " + jCurrentTimeMillis);
        } catch (Exception e10) {
            C11839m.m70687e("IntelligentClearActivity", "viewWeb Exception: " + e10.toString());
        }
    }

    /* renamed from: h */
    public List<View> m20923h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15144h);
        arrayList.add(this.f15142f);
        arrayList.add(this.f15141e);
        arrayList.add(this.f15149m);
        return arrayList;
    }

    /* renamed from: i */
    public final void m20924i() {
        this.f15145i = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.local_file_clear_title);
        this.f15146j = (CleanupItemView) C12809f.m76829b(this, R$id.local_junk_file);
        this.f15147k = (CleanupItemView) C12809f.m76829b(this, R$id.cleanup_app);
        this.f15148l = (CleanupItemView) C12809f.m76829b(this, R$id.item_album_cleanup);
        boolean zM20929n = m20929n();
        boolean zM20927l = m20927l();
        boolean zM20928m = m20928m();
        C11839m.m70688i("IntelligentClearActivity", "isSupportJunkClear: " + zM20929n + ", isSupportBatchUninstall: " + zM20927l + ", isSupportCleanAlbum: " + zM20928m);
        if (!zM20929n && !zM20927l && !zM20928m) {
            this.f15145i.setVisibility(8);
            this.f15146j.setVisibility(8);
            this.f15147k.setVisibility(8);
            this.f15148l.setVisibility(8);
            return;
        }
        if (zM20929n) {
            this.f15146j.setOnClickListener(this);
        } else {
            this.f15146j.setVisibility(8);
        }
        if (zM20927l) {
            this.f15147k.setOnClickListener(this);
        } else {
            this.f15147k.setVisibility(8);
        }
        if (zM20928m) {
            this.f15148l.setOnClickListener(this);
        } else {
            this.f15148l.setVisibility(8);
        }
    }

    /* renamed from: j */
    public void m20925j() {
        List<View> listM20923h = m20923h();
        List<List<View>> listM70887y2 = C11842p.m70887y2(listM20923h);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C12806c.m76821l(this, listM20923h);
            C12806c.m76820k(this, listM70887y2.get(1));
        }
        m20938w(listM70887y2.get(0));
        C12806c.m76820k(this, listM70887y2.get(0));
    }

    /* renamed from: k */
    public final void m20926k() {
        this.f15140d = (ScrollView) C12809f.m76829b(this, R$id.content_sl);
        RecommendCleanupView recommendCleanupView = (RecommendCleanupView) C12809f.m76829b(this, R$id.recommend_cleanup_view);
        this.f15144h = recommendCleanupView;
        recommendCleanupView.setActivity(this);
        CleanupEntryView cleanupEntryView = (CleanupEntryView) C12809f.m76829b(this, R$id.cleanup_entry_view);
        this.f15143g = cleanupEntryView;
        cleanupEntryView.setEntry(CleanupEntryView.INTELLIGENT_CLEAR);
        this.f15143g.setActivity(this);
        this.f15143g.setSpaceClearTitle();
        this.f15141e = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.root_layout);
        this.f15142f = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_layout);
        this.f15149m = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        this.f15143g.initSubTip();
        m20924i();
        m20939x();
    }

    /* renamed from: l */
    public final boolean m20927l() {
        PackageManager packageManager = getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("com.android.packageinstaller.intent.action.DELETE_PACKAGES");
        C0209d.m1302r2(intent, Constants.SYSTEM_PKG_INSTALLER);
        return packageManager.queryIntentActivities(intent, 0).size() > 0;
    }

    /* renamed from: m */
    public final boolean m20928m() {
        try {
            ContentResolver contentResolver = getContentResolver();
            Uri uri = f15136r;
            if (C0209d.m1227Y1(this, uri)) {
                Bundle bundleCall = contentResolver.call(uri, "getGalleryData", (String) null, (Bundle) null);
                this.f15137a = bundleCall.getString("string_clean_file_sub");
                this.f15138b = bundleCall.getString("string_clean_file_disabled_sub");
            }
        } catch (Exception e10) {
            C11839m.m70687e("IntelligentClearActivity", "isSupportCleanupAlbum Exception:" + e10.toString());
        }
        boolean z10 = (TextUtils.isEmpty(this.f15137a) || TextUtils.isEmpty(this.f15138b)) ? false : true;
        this.f15139c = z10;
        return z10;
    }

    /* renamed from: n */
    public final boolean m20929n() {
        PackageManager packageManager = getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("huawei.intent.action.HSM_STORAGE_CLEANER");
        if (C0209d.m1269j1()) {
            C0209d.m1302r2(intent, "com.hihonor.systemmanager");
        } else {
            C0209d.m1302r2(intent, "com.huawei.systemmanager");
        }
        return packageManager.queryIntentActivities(intent, 0).size() > 0;
    }

    /* renamed from: o */
    public final /* synthetic */ void m20930o(InterfaceC9282a interfaceC9282a, Bundle bundle) {
        boolean z10 = bundle.getBoolean("isSupportDisableAndResume");
        C11839m.m70688i("IntelligentClearActivity", "isSupportDisableAndResume:" + z10);
        if (z10) {
            interfaceC9282a.mo58426g(new C3332b(interfaceC9282a));
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws Resources.NotFoundException {
        C11839m.m70688i("IntelligentClearActivity", "onActivityResult requestCode: " + i10 + ", resultCode: " + i11);
        if (intent == null) {
            C11839m.m70689w("IntelligentClearActivity", "onActivityResult data is null");
            m20936u();
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        if (10000 != i10) {
            if (10001 != i10) {
                m20936u();
                return;
            }
            int cleanRecordsNum = BackupCleanRecordsManager.getInstance().getCleanRecordsNum();
            C11839m.m70688i("IntelligentClearActivity", "onActivityResult oldBackupRecords: " + cleanRecordsNum);
            this.f15143g.setOldRecordsTip(cleanRecordsNum);
            return;
        }
        int intExtra = safeIntent.getIntExtra(CleanupEntryView.OLD_DEVICE_SIZE, -1);
        C11839m.m70688i("IntelligentClearActivity", "onActivityResult oldDeviceSize: " + intExtra);
        if (-1 == intExtra) {
            m20936u();
        } else {
            this.f15143g.setOldDeviceTip(intExtra);
            m20918E(intExtra);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("IntelligentClearActivity", "click too fast");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.local_junk_file) {
            m20934s();
        } else if (id2 == R$id.cleanup_app) {
            m20931p();
        } else if (id2 == R$id.item_album_cleanup) {
            m20932q();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        NotchTopFitRelativeLayout notchTopFitRelativeLayout = this.f15141e;
        if (notchTopFitRelativeLayout != null) {
            this.f15144h.setMaxWidth(notchTopFitRelativeLayout.getHeight() / 3);
        }
        C12806c.m76820k(this, this.f15152p);
        m20939x();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, JSONException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        InterfaceC9282a interfaceC9282a;
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C11829c.m70591k1(this);
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 1024);
        }
        setContentView(R$layout.intelligent_clear_activity);
        m20914A(R$string.smart_clean);
        m20940y();
        m20941z();
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(1280);
        window.setStatusBarColor(0);
        m20926k();
        m20925j();
        m20919F();
        C13225d.m79490f1().m79598v0(this, new SafeIntent(getIntent()), "IntelligentClearActivity");
        if (this.f15139c && (interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class)) != null) {
            m20921H(interfaceC9282a.mo58394T(this));
        }
        m20936u();
        m20937v();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m20920G();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        C11829c.m70579g1(getClass().getCanonicalName());
        return m20933r(i10, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (m20915B()) {
            C11839m.m70688i("IntelligentClearActivity", "showGuidH5 onOptionsItemSelected home");
            return false;
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        m20919F();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        m20935t();
        if (this.f15149m != null) {
            if (C0209d.m1333z1(this)) {
                this.f15149m.m23914a();
            } else {
                this.f15149m.m23919i();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        C11839m.m70686d("IntelligentClearActivity", "onWindowFocusChanged w: " + this.f15141e.getWidth());
        this.f15144h.setMaxWidth(this.f15141e.getWidth() / 3);
    }

    /* renamed from: p */
    public final void m20931p() {
        startActivity(new Intent(this, (Class<?>) SmartClearAppActivity.class));
    }

    /* renamed from: q */
    public final void m20932q() {
        try {
            Intent intent = new Intent();
            C0209d.m1302r2(intent, C13843a.m83054F(this));
            intent.setAction("com.huawei.gallery.action.CLEAN_FILE");
            intent.addCategory("android.intent.category.DEFAULT");
            startActivity(intent);
            C13225d.m79490f1().m79585f0("mecloud_gallerymain_click_release_space", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_gallerymain_click_release_space", "1", "80");
        } catch (Exception unused) {
            C11839m.m70687e("IntelligentClearActivity", "not found gallery release space activity");
        }
    }

    /* renamed from: r */
    public boolean m20933r(int i10, KeyEvent keyEvent) {
        if (m20915B()) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    /* renamed from: s */
    public final void m20934s() {
        Intent intent = new Intent();
        intent.setAction("huawei.intent.action.HSM_STORAGE_CLEANER");
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
        intent.putExtra("auto_start", true);
        intent.putExtra(MapKeyNames.PACKAGE_NAME, getApplicationContext().getPackageName());
        try {
            if (C0209d.m1269j1()) {
                C0209d.m1302r2(intent, "com.hihonor.systemmanager");
            } else {
                C0209d.m1302r2(intent, "com.huawei.systemmanager");
            }
            startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("IntelligentClearActivity", "onLocalCleanClick error: " + e10.toString());
        }
        C13225d.m79490f1().m79585f0("mecloud_smart_clear_junk_clear", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_smart_clear_junk_clear", "1", "80");
    }

    /* renamed from: t */
    public final void m20935t() {
        if (!this.f15139c) {
            C11839m.m70688i("IntelligentClearActivity", "queryAlbumDisableState: album not support cleanup");
            return;
        }
        final InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70687e("IntelligentClearActivity", "queryAlbumDisableState: cloudAlbumRouter is null");
        } else {
            interfaceC9282a.mo58435j(new InterfaceC14351b() { // from class: com.huawei.android.hicloud.ui.activity.t5
                @Override // p850zo.InterfaceC14351b
                public final void onResult(Bundle bundle) {
                    this.f17738a.m20930o(interfaceC9282a, bundle);
                }
            });
        }
    }

    /* renamed from: u */
    public final void m20936u() {
        C12515a.m75110o().m75175e(new C3012a2(this.f15153q), false);
        C12515a.m75110o().m75175e(new C3333c(), false);
    }

    /* renamed from: v */
    public final void m20937v() {
        if (this.f15150n == null) {
            this.f15150n = new NetWorkChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.f15150n, intentFilter, "com.huawei.cg.permission.SERVICE", null);
        }
    }

    /* renamed from: w */
    public void m20938w(List<View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f15152p.addAll(list);
    }

    /* renamed from: x */
    public final void m20939x() {
        ViewGroup.LayoutParams layoutParams = this.f15140d.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (C11842p.m70753O0(this)) {
                layoutParams2.setMargins(0, C11842p.m70852q(this) + C11842p.m70789a0(this), 0, 0);
            } else {
                layoutParams2.setMargins(0, C11842p.m70852q(this), 0, 0);
            }
            this.f15140d.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: y */
    public final void m20940y() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /* renamed from: z */
    public void m20941z() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C11839m.m70688i("IntelligentClearActivity", "setActionBarBg is null");
        } else {
            C11842p.m70842n1(actionBar, new ColorDrawable(0));
            actionBar.setBackgroundDrawable(new ColorDrawable(0));
        }
    }
}
