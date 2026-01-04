package p364ib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.router.data.FamilyShareLanguageString;
import com.huawei.hicloud.router.data.FamilySharePageConfig;
import com.huawei.hicloud.sync.R$string;
import gb.C9902a;
import gb.C9903b;
import gp.C10028c;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Locale;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0234s;
import p514o9.C11839m;
import p664u0.C13108a;
import p681uj.C13195l;
import p709vj.C13452e;

/* renamed from: ib.b */
/* loaded from: classes3.dex */
public class C10465b {
    /* renamed from: a */
    public static Intent m64291a(int i10, String str) {
        Intent intent = new Intent();
        intent.putExtra(FamilyShareConstants.OpenCloudShareResultInfo.RESULT_CODE_KEY, i10);
        intent.putExtra(FamilyShareConstants.OpenCloudShareResultInfo.RESULT_DESC_KEY, str);
        return intent;
    }

    /* renamed from: b */
    public static void m64292b(Context context, String str) {
        boolean zDelete;
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists() || (zDelete = file.delete())) {
                return;
            }
            C11839m.m70687e("FamilyShareUtil", "clearConfig " + str + " is:" + zDelete);
        } catch (Exception e10) {
            C11839m.m70687e("FamilyShareUtil", "clearConfig " + str + " exception:" + e10.toString());
        }
    }

    /* renamed from: c */
    public static String m64293c(String str, Object... objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Exception e10) {
            C11839m.m70687e("FamilyShareUtil", "formatSring err:" + e10.toString());
            return str;
        }
    }

    /* renamed from: d */
    public static String m64294d(String str) throws Throwable {
        String strM1631i = C0234s.m1631i();
        if (TextUtils.isEmpty(strM1631i)) {
            C11839m.m70687e("FamilyShareUtil", "getCloudSpaceUsageLanguage language null,name = " + str);
            return null;
        }
        C9902a c9902a = new C9902a();
        FamilyShareLanguageString familyShareLanguageStringM61482c = c9902a.m61482c(strM1631i, str);
        String currentBaseLanguage = HNUtil.getCurrentBaseLanguage();
        if (familyShareLanguageStringM61482c == null) {
            C11839m.m70688i("FamilyShareUtil", "getCloudSpaceUsageLanguage cannot find detail by language-contry=" + strM1631i + ",query by language = " + currentBaseLanguage + ",name = " + str);
            familyShareLanguageStringM61482c = c9902a.m61483d(currentBaseLanguage, str);
        }
        if (familyShareLanguageStringM61482c != null) {
            return familyShareLanguageStringM61482c.getValue();
        }
        C11839m.m70687e("FamilyShareUtil", "getCloudSpaceUsageLanguage result is null.name = " + str);
        return null;
    }

    /* renamed from: e */
    public static String m64295e(String str) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("FamilyShareUtil", "getFamilyDefaultStr context is null.");
            return "";
        }
        str.hashCode();
        switch (str) {
            case "@SP/finish_title":
                return contextM1377a.getString(R$string.family_finish_title);
            case "@SP/start1_button1":
            case "@SP/start2_button1":
                return contextM1377a.getString(R$string.family_start2_button1);
            case "@SP/start1_button2":
            case "@SP/start2_button2":
                return contextM1377a.getString(R$string.family_start2_button2);
            case "@SP/start2_main_text":
            case "@SP/start1_main_text":
                return contextM1377a.getString(R$string.family_start2_main_text);
            case "@SP/finish_main_text":
                return contextM1377a.getString(R$string.family_finish_main_text);
            case "@SP/finish_button1":
            case "@SP/finish_button2":
                return contextM1377a.getString(R$string.family_finish_button1);
            case "@SP/start1_title":
            case "@SP/start2_title":
                return contextM1377a.getString(R$string.family_start2_title);
            default:
                return m64297g(contextM1377a, str);
        }
    }

    /* renamed from: f */
    public static String m64296f(Context context, String str) {
        str.hashCode();
        return !str.equals("@SP/stop_notice_member_main_text") ? !str.equals("@SP/stop_notice_member_title") ? "" : context.getString(R$string.family_stop_notice_member_title) : context.getString(R$string.family_stop_notice_member_main_text);
    }

    /* renamed from: g */
    public static String m64297g(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "@SP/buy_tile":
                return context.getString(R$string.family_buy_tile);
            case "@SP/buy_main_text":
                return context.getString(R$string.family_buy_main_text);
            case "@SP/stop_main_text":
                return context.getString(R$string.family_stop_main_text);
            case "@SP/join_main_text":
                return context.getString(R$string.family_join_main_text);
            case "@SP/join_title":
                return context.getString(R$string.family_join_title);
            case "@SP/join_insuff_title":
                return context.getString(R$string.family_join_insuff_title);
            case "@SP/join_button1":
                return context.getString(R$string.family_join_button1);
            case "@SP/join_button2":
                return context.getString(R$string.family_join_button2);
            case "@SP/stop_button1":
                return context.getString(R$string.family_stop_button1);
            case "@SP/stop_button2":
                return context.getString(R$string.family_stop_button2);
            case "@SP/buy_comment1":
            case "@SP/buy_comment2":
                return context.getString(R$string.family_buy_comment1);
            case "@SP/stop_title":
                return context.getString(R$string.family_stop_title);
            default:
                return m64298h(context, str);
        }
    }

    /* renamed from: h */
    public static String m64298h(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "@SP/join_insuff_main_text":
                return context.getString(R$string.family_join_insuff_main_text);
            case "@SP/member_upgrade_button1":
                return context.getString(R$string.family_member_upgrade_button1);
            case "@SP/member_upgrade_button2":
                return context.getString(R$string.family_member_upgrade_button2);
            case "@SP/member_upgrade_title":
                return context.getString(R$string.family_member_upgrade_title);
            case "@SP/member_accept_notice_title":
                return context.getString(R$string.family_member_accept_notice_title);
            case "@SP/join_insuff_button1":
            case "@SP/join_insuff_button2":
                return context.getString(R$string.family_join_insuff_button1);
            case "@SP/member_stop_title":
                return context.getString(R$string.family_member_stop_title);
            case "@SP/member_upgrade_main_text":
                return context.getString(R$string.family_member_upgrade_main_text);
            case "@SP/member_stop_button1":
                return context.getString(R$string.family_member_stop_button1);
            case "@SP/member_stop_button2":
                return context.getString(R$string.family_member_stop_button2);
            case "@SP/member_accept_notice_main_text":
                return context.getString(R$string.family_member_accept_notice_main_text);
            case "@SP/bm_member_stop_main_text":
                return context.getString(R$string.family_member_stop_main_text_default);
            case "@SP/member_stop_main_text":
                return context.getString(R$string.family_member_stop_main_text);
            default:
                return m64296f(context, str);
        }
    }

    /* renamed from: i */
    public static String m64299i(String str) {
        String strM1631i = C0234s.m1631i();
        if (TextUtils.isEmpty(strM1631i)) {
            C11839m.m70687e("FamilyShareUtil", "getFamilyShareLanguage language null,name = " + str);
            return m64295e(str);
        }
        C9903b c9903b = new C9903b();
        FamilyShareLanguageString familyShareLanguageStringM61486c = c9903b.m61486c(strM1631i, str);
        String currentBaseLanguage = HNUtil.getCurrentBaseLanguage();
        if (familyShareLanguageStringM61486c == null) {
            C11839m.m70688i("FamilyShareUtil", "getFamilyShareLanguage cannot find detail by language-contry=" + strM1631i + ",query by language = " + currentBaseLanguage + ",name = " + str);
            familyShareLanguageStringM61486c = c9903b.m61487d(currentBaseLanguage, str);
        }
        if (familyShareLanguageStringM61486c != null) {
            String value = familyShareLanguageStringM61486c.getValue();
            return TextUtils.isEmpty(value) ? m64295e(str) : value;
        }
        C11839m.m70687e("FamilyShareUtil", "getFamilyShareLanguage result is null.name = " + str);
        return m64295e(str);
    }

    /* renamed from: j */
    public static void m64300j(Activity activity) {
        if (activity == null) {
            C11839m.m70687e("FamilyShareUtil", "context is null");
            return;
        }
        try {
            Intent intentM79271I = C13195l.m79271I(activity, FamilyShareConstants.SCHEME_ACCOUNT_CENTER);
            if (intentM79271I == null) {
                C11839m.m70687e("FamilyShareUtil", "hmsPackage is invalid!");
            } else {
                activity.startActivityForResult(intentM79271I, 10034);
            }
        } catch (Exception e10) {
            C11839m.m70688i("FamilyShareUtil", "gotoAccountCenter error:" + e10.toString());
        }
    }

    /* renamed from: k */
    public static void m64301k(Activity activity, int i10) {
        if (activity == null) {
            C11839m.m70687e("FamilyShareUtil", "context is null");
            return;
        }
        try {
            Intent intentM79271I = C13195l.m79271I(activity, i10 == 1 ? FamilyShareConstants.SCHEME_FAMILY_INVITATION : "hwid://com.huawei.hwid/FamilyShare");
            if (intentM79271I == null) {
                C11839m.m70687e("FamilyShareUtil", "hmsPackage is invalid!");
            } else {
                activity.startActivityForResult(intentM79271I, 10034);
            }
        } catch (Exception e10) {
            C11839m.m70688i("FamilyShareUtil", "start family invitation or share error:" + e10.toString());
        }
    }

    /* renamed from: l */
    public static boolean m64302l(FamilyShareInfoResult familyShareInfoResult) {
        boolean z10 = false;
        if (familyShareInfoResult == null) {
            C11839m.m70687e("FamilyShareUtil", "isFamilyShareMember familyShareInfoResult is null.");
            return false;
        }
        if (familyShareInfoResult.getSpaceShareEnable() == 1 && familyShareInfoResult.getSpaceShareRole() == 2) {
            z10 = true;
        }
        C13452e.m80781L().m80933j2(z10);
        return z10;
    }

    /* renamed from: m */
    public static boolean m64303m() {
        return C10028c.m62182c0().m62345j1();
    }

    /* renamed from: n */
    public static void m64304n() {
        Intent intent = new Intent();
        intent.setAction("com.huawei.hicloud.QUOTA_INFO_OM_CONFIG_DOWNLOAD_FINISHED");
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    /* renamed from: o */
    public static FamilySharePageConfig m64305o(String str) {
        FamilySharePageConfig familySharePageConfig;
        Exception e10;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                familySharePageConfig = (FamilySharePageConfig) new Gson().fromJson(C0209d.m1290o2(fileInputStream), FamilySharePageConfig.class);
            } finally {
            }
        } catch (Exception e11) {
            familySharePageConfig = null;
            e10 = e11;
        }
        try {
            fileInputStream.close();
        } catch (Exception e12) {
            e10 = e12;
            C11839m.m70687e("FamilyShareUtil", "cloud config file not exitst, msg:" + e10.getMessage());
            return familySharePageConfig;
        }
        return familySharePageConfig;
    }

    /* renamed from: p */
    public static void m64306p(String str) {
        m64307q(str, -1);
    }

    /* renamed from: q */
    public static void m64307q(String str, int i10) {
        HashMap map = new HashMap();
        map.put("result", "1");
        map.put("err_reason", str);
        if (i10 >= 0) {
            map.put("retry_num", String.valueOf(i10));
        }
        C10464a.m64288a().m64290c(map);
    }

    /* renamed from: r */
    public static void m64308r(boolean z10) {
        C10028c.m62182c0().m62212F2(z10);
    }

    /* renamed from: s */
    public static void m64309s(FamilyShareInfoResult familyShareInfoResult) {
        C10028c.m62182c0().m62223H3(familyShareInfoResult);
    }
}
