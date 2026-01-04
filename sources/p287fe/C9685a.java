package p287fe;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupAppEstimateUtil;
import com.huawei.android.hicloud.cloudbackup.util.BackupNewBmTypeUtil;
import com.huawei.android.hicloud.p088ui.activity.NoticeBeforeBackupActivity;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.secure.android.common.webview.SafeWebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import p514o9.C11839m;
import p618rm.C12540b1;
import p618rm.C12590s0;
import p684un.C13225d;
import p684un.C13230i;
import p703v8.C13368e;
import p709vj.C13452e;
import p711vl.C13466f;
import p836z8.C14157f;
import pm.C12176c;
import tl.C13026e;

/* renamed from: fe.a */
/* loaded from: classes3.dex */
public class C9685a extends C9686b {

    /* renamed from: f */
    public WeakReference<NoticeBeforeBackupActivity> f47907f;

    /* renamed from: fe.a$a */
    public class a extends TypeToken<List<String>> {
        public a() {
        }
    }

    public C9685a(SafeWebView safeWebView, String[] strArr, NoticeBeforeBackupActivity noticeBeforeBackupActivity) {
        super(safeWebView, strArr, "3", "47");
        this.f47907f = new WeakReference<>(noticeBeforeBackupActivity);
    }

    /* renamed from: f */
    private String m60515f(List<C4987f> list) {
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (C4987f c4987f : list) {
                map.put(c4987f.m30026b(), c4987f.m30027c());
            }
        }
        try {
            return new GsonBuilder().disableHtmlEscaping().create().toJson(map);
        } catch (Exception unused) {
            return "";
        }
    }

    @JavascriptInterface
    public long getNewBmTypeBaseData() {
        C11839m.m70686d("BackupWebViewInterface", "getNewBmTypeBaseData enter.");
        if (!C13452e.m80781L().m80887a1()) {
            C11839m.m70688i("BackupWebViewInterface", "current user is not new bm type.");
            return -1L;
        }
        long jM69963a = C12590s0.m75927z(true, C12590s0.m75868k0()).m69963a();
        C11839m.m70688i("BackupWebViewInterface", "getNewBmTypeBaseData result is:" + jM69963a);
        return jM69963a;
    }

    @JavascriptInterface
    public String getParams(String str) {
        C11839m.m70688i("BackupWebViewInterface", "backupWebViewInterface getParams start.");
        return m60515f(C14157f.m84942g().m84949i(null, (List) C12540b1.m75484b(str, new a().getType()), "BackupWeb"));
    }

    @JavascriptInterface
    public boolean isSpaceRunningOut() {
        C11839m.m70686d("BackupWebViewInterface", "isSpaceRunningOut enter.");
        if (BackupNewBmTypeUtil.isNewBmUserBackupOnlyBaseData()) {
            C11839m.m70688i("BackupWebViewInterface", "newBmUser only backup base Data.");
            return false;
        }
        QuotaSpaceInfo quotaSpaceInfoM80224M = C13368e.m80184F().m80224M();
        return BackupAppEstimateUtil.isSpaceRunningOut(quotaSpaceInfoM80224M.getAvailable(), quotaSpaceInfoM80224M.getTotal(), C12590s0.m75927z(false, C12176c.m73271n(null)).m69963a(), 0L);
    }

    @JavascriptInterface
    public boolean isThirdAppBackup() {
        return new C13026e().m78395p();
    }

    @JavascriptInterface
    public void noMoreRemind(boolean z10) {
        C11839m.m70688i("BackupWebViewInterface", "click noMoreRemind, the switch status is :" + z10);
        C13466f.m81073d().m81081i("noMoreRemindBeforeBackup", z10);
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("status", Boolean.valueOf(z10));
        C9686b.m60516e(linkedHashMapM79499C);
        C13225d.m79490f1().m79591l0("mecloud_backupbefore_reminderpage_click_no_more_reminders", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_backupbefore_reminderpage_click_no_more_reminders", "1", "82", linkedHashMapM79499C);
    }

    @JavascriptInterface
    public void refreshActionBar(String str, boolean z10) {
        C11839m.m70688i("BackupWebViewInterface", "titleName is:" + str + ",needBackAction:" + z10);
        NoticeBeforeBackupActivity noticeBeforeBackupActivity = this.f47907f.get();
        if (TextUtils.isEmpty(str) || noticeBeforeBackupActivity == null || noticeBeforeBackupActivity.isFinishing()) {
            C11839m.m70687e("BackupWebViewInterface", "title is empty,or activity is null or finishing");
            return;
        }
        int i10 = z10 ? -1 : 0;
        if ("space_usage_suggestion_title".equals(str)) {
            noticeBeforeBackupActivity.m21698p2(R$string.space_usage_suggestion_title, i10);
        }
    }
}
