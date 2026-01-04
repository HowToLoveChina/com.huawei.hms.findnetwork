package pm;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.BaseServiceAppItem;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.util.C2635l;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.About;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import mk.C11476b;
import ni.C11707b;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0241z;
import p020ap.C1007b;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p618rm.C12590s0;
import p709vj.C13452e;
import p711vl.C13466f;
import p711vl.C13467g;
import p746wn.C13622a;
import p814yl.C13998b0;
import p815ym.AbstractC14026a;
import p847zk.C14315h;
import tl.C13031j;

/* renamed from: pm.c */
/* loaded from: classes6.dex */
public class C12176c {

    /* renamed from: a */
    public boolean f56506a;

    public C12176c() {
        this.f56506a = false;
    }

    /* renamed from: b */
    public static void m73260b(About about, boolean z10) throws C9721b {
        if (about != null) {
            Integer times = about.getTimes();
            if (times != null) {
                int iIntValue = times.intValue();
                if (iIntValue == -1 && (z10 || (!z10 && !about.isManualBypassOnFault()))) {
                    throw new C9721b(3911, "about request times deliver error");
                }
                C13467g.m81086c().m81094i("about_number_of_backup_record", iIntValue);
            }
            Integer baseBakNumber = about.getBaseBakNumber();
            if (baseBakNumber != null) {
                int iIntValue2 = baseBakNumber.intValue();
                if (iIntValue2 == -1 && (z10 || (!z10 && !about.isManualBypassOnFault()))) {
                    throw new C9721b(3911, "about request times deliver error");
                }
                C13467g.m81086c().m81094i("about_number_of_base_backup_record", iIntValue2);
            }
        }
    }

    /* renamed from: c */
    public static String m73261c(About about) {
        C11707b bakSourceStrategy;
        SettingOperator settingOperator = new SettingOperator();
        if (about != null && (bakSourceStrategy = about.getBakSourceStrategy()) != null) {
            String strM68626h = C11476b.m68626h(C13452e.m80781L().m80950o());
            for (Map.Entry<String, Object> entry : bakSourceStrategy.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && key.contains(strM68626h)) {
                    String strValueOf = String.valueOf(entry.getValue());
                    if (!TextUtils.equals(strValueOf, settingOperator.queryBakSourceStrategy())) {
                        settingOperator.replace(new Settings[]{new Settings("bakSourceStrategy", strValueOf, "2")});
                    }
                }
            }
        }
        return settingOperator.queryBakSourceStrategy();
    }

    /* renamed from: d */
    public static String m73262d(SettingOperator settingOperator) {
        settingOperator.replace(new Settings[]{new Settings("lockByDelDeviceStrategy", "0", "2")});
        return settingOperator.queryLockByDelDeviceStrategy();
    }

    /* renamed from: e */
    public static String m73263e(About about) {
        C11707b fileSourceStrategy;
        SettingOperator settingOperator = new SettingOperator();
        if (about != null && (fileSourceStrategy = about.getFileSourceStrategy()) != null) {
            String strM68626h = C11476b.m68626h(C13452e.m80781L().m80950o());
            Iterator<Map.Entry<String, Object>> it = fileSourceStrategy.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                String key = next.getKey();
                if (!TextUtils.isEmpty(key) && key.contains(strM68626h)) {
                    settingOperator.replace(new Settings[]{new Settings("fileSourceStrategy", String.valueOf(next.getValue()), "2")});
                    break;
                }
            }
        }
        return settingOperator.queryFileSourceStrategy();
    }

    /* renamed from: f */
    public static String m73264f(About about, String str) {
        if (about != null) {
            String gradeCode = about.getGradeCode();
            C11839m.m70688i("CloudBackupAboutRequestTask", "about parse GradeCode = " + gradeCode);
            if (!TextUtils.isEmpty(gradeCode)) {
                if (!C12590s0.m75828a1(gradeCode)) {
                    C11839m.m70688i("CloudBackupAboutRequestTask", "update first query trans tag to 1.");
                    C13467g.m81086c().m81094i("isFirstQueryTrans", 1);
                }
                C1007b.m5980s().m5982B(gradeCode, false);
            }
        }
        String strM81079g = C13466f.m81073d().m81079g("gradeCode", "");
        C11839m.m70688i("CloudBackupAboutRequestTask", "about parse GradeCode done, return GradeCode = " + strM81079g);
        return strM81079g;
    }

    /* renamed from: g */
    public static String m73265g(About about, String str) throws C9721b {
        if (about == null) {
            throw new C9721b(3911, "about parse error , about null");
        }
        if (TextUtils.isEmpty(about.getGradeCode())) {
            throw new C9721b(3911, "about parse error , gradeCode isEmpty");
        }
        return m73264f(about, str);
    }

    /* renamed from: i */
    public static int m73266i(About about) {
        if (about == null || about.getApplistStrategy() == null) {
            C11839m.m70688i("CloudBackupAboutRequestTask", "getNewBusinessModel3rdApplistStrategy about is null");
            return 0;
        }
        int iIntValue = about.getApplistStrategy().intValue();
        C11839m.m70688i("CloudBackupAboutRequestTask", "getNewBusinessModel3rdApplistStrategy:  " + iIntValue);
        return iIntValue;
    }

    /* renamed from: j */
    public static List<String> m73267j(About about) {
        List<String> baseAppid = about.getBaseAppid();
        if (baseAppid == null || baseAppid.isEmpty()) {
            C11839m.m70688i("CloudBackupAboutRequestTask", "getNewBusinessModelBaseAppids is empty");
            return new ArrayList();
        }
        if (m73266i(about) == 0) {
            baseAppid.add("applistStrategy");
        }
        try {
            C11839m.m70688i("CloudBackupAboutRequestTask", "getNewBusinessModelBaseAppids " + baseAppid);
            C13031j c13031j = new C13031j();
            c13031j.clear();
            ArrayList arrayList = new ArrayList();
            for (String str : baseAppid) {
                BaseServiceAppItem baseServiceAppItem = new BaseServiceAppItem();
                baseServiceAppItem.setAppId(str);
                arrayList.add(baseServiceAppItem);
            }
            c13031j.m78500a(arrayList);
        } catch (C9721b e10) {
            C11839m.m70688i("CloudBackupAboutRequestTask", "save NewBusinessModelBaseAppids error, " + e10.getMessage());
        }
        return baseAppid;
    }

    /* renamed from: k */
    public static int m73268k(About about) {
        if (about != null) {
            Integer operationControl = about.getOperationControl();
            C11839m.m70688i("CloudBackupAboutRequestTask", "about parse operationControl = " + operationControl);
            if (operationControl != null) {
                C13466f.m81073d().m81082j("operationControl", operationControl.intValue());
            }
        }
        return C13466f.m81073d().m81077e("operationControl", -1);
    }

    /* renamed from: l */
    public static void m73269l(About about) throws C9721b {
        if (about != null) {
            Integer refEffeDays = about.getRefEffeDays();
            if (refEffeDays != null) {
                int iIntValue = refEffeDays.intValue();
                C11839m.m70688i("CloudBackupAboutRequestTask", "getRefurbishRefEffeDays, refEffeDays : " + iIntValue);
                C13467g.m81086c().m81094i("refurbish_backup_record_refeffe_days", iIntValue);
            }
            Integer refEffeDelayDays = about.getRefEffeDelayDays();
            if (refEffeDelayDays != null) {
                int iIntValue2 = refEffeDelayDays.intValue();
                C11839m.m70688i("CloudBackupAboutRequestTask", "getRefurbishRefEffeDays, refEffeDelayDays : " + iIntValue2);
                C13467g.m81086c().m81094i("refurbish_backup_record_delay_refeffe_days", iIntValue2);
            }
        }
    }

    /* renamed from: m */
    public static String m73270m(About about) {
        C11707b uploadTargetStrategy;
        SettingOperator settingOperator = new SettingOperator();
        if (about != null && (uploadTargetStrategy = about.getUploadTargetStrategy()) != null) {
            String strM68626h = C11476b.m68626h(C13452e.m80781L().m80950o());
            Iterator<Map.Entry<String, Object>> it = uploadTargetStrategy.entrySet().iterator();
            boolean z10 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                String key = next.getKey();
                String strValueOf = String.valueOf(next.getValue());
                if ("1".equalsIgnoreCase(strValueOf)) {
                    z10 = true;
                }
                if (!TextUtils.isEmpty(key) && key.contains(strM68626h)) {
                    settingOperator.replace(new Settings[]{new Settings("uploadTargetStrategy", strValueOf, "2")});
                    break;
                }
            }
            if ("1".equalsIgnoreCase(settingOperator.queryUploadTargetStrategy()) && !z10) {
                settingOperator.replace(new Settings[]{new Settings("uploadTargetStrategy", "2", "2")});
                C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02016"), "getUploadTargetStrategy", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66665u("010_200");
                c11060cM66626a.m66635A("report getUploadTargetStrategy, deviceIdHash : " + C12590s0.m75916w0(strM68626h) + " , strategy contains: " + uploadTargetStrategy.toString().contains(strM68626h));
                C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
            }
        }
        return settingOperator.queryUploadTargetStrategy();
    }

    /* renamed from: n */
    public static List<String> m73271n(String str) {
        List<String> list = (List) ((List) Optional.ofNullable(new C13031j().m78503d()).orElse(Collections.emptyList())).stream().map(new C2635l()).collect(Collectors.toList());
        if (!AbstractC14026a.m84159a(list)) {
            return list;
        }
        C13998b0 c13998b0 = new C13998b0();
        if (TextUtils.isEmpty(str)) {
            str = C11058a.m66627b("00000");
        }
        try {
            return m73267j(c13998b0.m84094A("baseAppid,applistStrategy", str, ""));
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupAboutRequestTask", "getWhiteBaseAppIds error: " + e10.getMessage());
            return list;
        }
    }

    /* renamed from: a */
    public void m73272a(String str) throws C9721b {
        C11839m.m70688i("CloudBackupAboutRequestTask", "start query about request");
        if (!C10028c.m62182c0().m62335h1()) {
            C11839m.m70688i("CloudBackupAboutRequestTask", "about request do not support.");
            return;
        }
        About aboutM84095B = new C13998b0().m84095B(C10028c.m62182c0().m62388s("backup_key") ? "uploadTargetStrategy,bakSourceStrategy,fileSourceStrategy,gradeCode,bmType,baseAppid,applistStrategy,maxAttachmentUploadSize,maxBatchNumber,times,refEffeDays,refEffeDelayDays,lockByDelDeviceStrategy" : "bakSourceStrategy,fileSourceStrategy,gradeCode,baseAppid,bmType,applistStrategy,maxAttachmentUploadSize,maxBatchNumber,times,refEffeDays,refEffeDelayDays,", this.f56506a, str, "", null);
        m73267j(aboutM84095B);
        String strM73264f = m73264f(aboutM84095B, str);
        String strM73261c = m73261c(aboutM84095B);
        String strM73270m = m73270m(aboutM84095B);
        String strM73263e = m73263e(aboutM84095B);
        m73269l(aboutM84095B);
        String strM73273h = m73273h(aboutM84095B);
        C14315h.m85262p().m85281r(Objects.equals(aboutM84095B.getBmType(), 1), strM73264f);
        try {
            m73260b(aboutM84095B, true);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupAboutRequestTask", "getAboutBackupRecordNums, CException : " + e10.getMessage());
        }
        long jLongValue = aboutM84095B.getMaxAttachmentUploadSize() == null ? 2147483648L : aboutM84095B.getMaxAttachmentUploadSize().longValue();
        int iIntValue = aboutM84095B.getMaxBatchNumber() == null ? 20 : aboutM84095B.getMaxBatchNumber().intValue();
        new SettingOperator().replace(new Settings[]{new Settings("maxAttachmentUploadSize", String.valueOf(jLongValue), "2"), new Settings("maxBatchNumber", String.valueOf(iIntValue), "2")});
        C11839m.m70688i("CloudBackupAboutRequestTask", "about request, gradeCode:" + strM73264f + ", maxAttachmentUploadSize:" + jLongValue + ", maxBatchNumber" + iIntValue + ", bakStrategy:" + strM73261c + ", uploadStrategy:" + strM73270m + ", fileSourceStrategy: " + strM73263e + ", lockByDelDeviceStrategy:" + strM73273h);
        C13466f.m81073d().m81081i("isAboutRequestCalled", true);
    }

    /* renamed from: h */
    public final String m73273h(About about) {
        C11839m.m70688i("CloudBackupAboutRequestTask", "about request, start parse lockByDelDeviceStrategy.");
        C12590s0.m75771M0("AboutRequest");
        SettingOperator settingOperator = new SettingOperator();
        if (about == null) {
            C11839m.m70688i("CloudBackupAboutRequestTask", "about request, the operator is null.");
            return m73262d(settingOperator);
        }
        C11707b lockByDelDeviceStrategy = about.getLockByDelDeviceStrategy();
        if (lockByDelDeviceStrategy == null || lockByDelDeviceStrategy.size() == 0) {
            C11839m.m70688i("CloudBackupAboutRequestTask", "about request, the lockByDelDeviceStrategy is null.");
            return m73262d(settingOperator);
        }
        String strM68626h = C11476b.m68626h(C13452e.m80781L().m80950o());
        for (Map.Entry<String, Object> entry : lockByDelDeviceStrategy.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key) && key.contains(strM68626h)) {
                String strValueOf = String.valueOf(entry.getValue());
                settingOperator.replace(new Settings[]{new Settings("lockByDelDeviceStrategy", strValueOf, "2")});
                C11839m.m70688i("CloudBackupAboutRequestTask", "about request, the lockByDelDeviceStrategy is:" + strValueOf);
                try {
                    JSONObject jSONObject = new JSONObject(strValueOf);
                    String strOptString = jSONObject.optString("lockByDelDevice");
                    String strOptString2 = jSONObject.optString("lockByDelDeviceTime");
                    if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                        if (strOptString.equals("1")) {
                            long jM81078f = C13466f.m81073d().m81078f("backup_key_active_time", -1L);
                            C11839m.m70688i("CloudBackupAboutRequestTask", "about request, the device is lock, the local active time is:" + jM81078f);
                            if (C0241z.m1689g(strOptString2, -1L) > jM81078f) {
                                C11839m.m70688i("CloudBackupAboutRequestTask", "about request, the device is lock, close the backup switch.");
                                CloudBackupService.getInstance().cloudbackupOpr(false);
                            }
                        } else {
                            C12590s0.m75809V2("AboutRequest");
                        }
                    }
                } catch (JSONException unused) {
                    C11839m.m70688i("CloudBackupAboutRequestTask", "getLockByDelDeviceStrategy: parse json exception.");
                }
            }
        }
        return settingOperator.queryLockByDelDeviceStrategy();
    }

    public C12176c(boolean z10) {
        this.f56506a = z10;
    }
}
