package p618rm;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p015ak.C0213f;
import p514o9.C11839m;
import p783xp.C13843a;
import p848zl.C14333b;

/* renamed from: rm.e */
/* loaded from: classes6.dex */
public class C12547e {

    /* renamed from: c */
    public static final Collator f57890c = Collator.getInstance();

    /* renamed from: a */
    public List<AppDetailsInfo> f57891a;

    /* renamed from: b */
    public List<AppDetailsInfo> f57892b;

    /* renamed from: rm.e$b */
    public static class b {

        /* renamed from: a */
        public static final C12547e f57893a = new C12547e();
    }

    /* renamed from: b */
    public static int m75493b(String str, String str2) {
        String strM83056H = C13843a.m83056H(str);
        String strM83056H2 = C13843a.m83056H(str2);
        return ("".equals(strM83056H) || "".equals(strM83056H2)) ? m75494d(strM83056H, strM83056H2, str, str2) : f57890c.compare(strM83056H, strM83056H2);
    }

    /* renamed from: d */
    public static int m75494d(String str, String str2, String str3, String str4) {
        if ("".equals(str) && "".equals(str2)) {
            return f57890c.compare(str3, str4);
        }
        if ("".equals(str)) {
            return 1;
        }
        return "".equals(str2) ? -1 : 0;
    }

    /* renamed from: e */
    public static C12547e m75495e() {
        return b.f57893a;
    }

    /* renamed from: g */
    public static /* synthetic */ int m75496g(AppDetailsInfo appDetailsInfo, AppDetailsInfo appDetailsInfo2) {
        if (TextUtils.equals("basic_system_data", appDetailsInfo.getBackupAppName())) {
            return -1;
        }
        if (TextUtils.equals("basic_system_data", appDetailsInfo2.getBackupAppName())) {
            return 1;
        }
        return m75493b(appDetailsInfo.getName(), appDetailsInfo2.getName());
    }

    /* renamed from: c */
    public void m75497c() {
        this.f57891a.clear();
        this.f57892b.clear();
    }

    /* renamed from: f */
    public List<AppDetailsInfo> m75498f() {
        return this.f57891a;
    }

    /* renamed from: h */
    public void m75499h(List<AppDetailsInfo> list) {
        for (AppDetailsInfo appDetailsInfo : list) {
            String backupAppName = appDetailsInfo.getBackupAppName();
            if (C14333b.m85486u().containsKey(backupAppName)) {
                appDetailsInfo.setName(C2783d.m16079E(C0213f.m1377a(), backupAppName));
            } else {
                String propertiesValue = appDetailsInfo.getPropertiesValue(SnapshotBackupMeta.KEY_STRING_APP_NAME);
                if (propertiesValue == null || StringUtil.isBlank(propertiesValue)) {
                    appDetailsInfo.setName(appDetailsInfo.getBackupAppName());
                } else {
                    appDetailsInfo.setName(propertiesValue);
                }
            }
        }
    }

    /* renamed from: i */
    public void m75500i(List<AppDetailsInfo> list) {
        this.f57892b.clear();
        this.f57892b = list;
    }

    /* renamed from: j */
    public void m75501j(List<AppDetailsInfo> list) {
        try {
            this.f57891a.clear();
            List<AppDetailsInfo> list2 = this.f57892b;
            if (list2 != null && !list2.isEmpty()) {
                AppDetailsInfo appDetailsInfo = new AppDetailsInfo();
                appDetailsInfo.setParentId("thirdApp");
                appDetailsInfo.setBackupAppName("thirdApp");
                appDetailsInfo.setChildList(new CopyOnWriteArrayList<>(this.f57892b));
                list.get(0).getChildList().add(appDetailsInfo);
            }
        } catch (Exception e10) {
            C11839m.m70687e("BasicDataUtil", "add thirdapp failed, e = " + e10.getMessage());
        }
        m75499h(list);
        m75502k(list);
        this.f57891a = list;
    }

    /* renamed from: k */
    public void m75502k(List<AppDetailsInfo> list) {
        list.sort(new Comparator() { // from class: rm.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C12547e.m75496g((AppDetailsInfo) obj, (AppDetailsInfo) obj2);
            }
        });
    }

    public C12547e() {
        this.f57891a = new ArrayList();
        this.f57892b = new ArrayList();
    }
}
