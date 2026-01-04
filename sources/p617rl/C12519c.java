package p617rl;

import android.database.Cursor;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.bean.AppIcon;
import com.huawei.android.hicloud.cloudbackup.bean.AppInfoList;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackup;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ml.AbstractC11478a;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p514o9.C11839m;
import p618rm.C12540b1;
import p682ul.C13216j;
import p815ym.AbstractC14026a;

/* renamed from: rl.c */
/* loaded from: classes6.dex */
public class C12519c extends AbstractC11478a<AppInfoList> {
    public C12519c() {
        super(C13216j.m79427l(C13216j.c.SETTING, null));
    }

    /* renamed from: d */
    public static void m75290d(List<AppInfoList> list) throws Throwable {
        if (AbstractC14026a.m84159a(list)) {
            try {
                AppInfoList appInfoList = (AppInfoList) new Gson().fromJson(C0209d.m1290o2(C0213f.m1377a().getAssets().open("tempbackup_app_setting_local.json")), AppInfoList.class);
                list.add(appInfoList);
                C11839m.m70686d("AppInfoListOperator", "getDefaultTempBackupConfig: " + appInfoList);
            } catch (Exception e10) {
                C11839m.m70687e("AppInfoListOperator", "getDefaultTempBackupConfig error:" + e10.getMessage());
            }
        }
    }

    /* renamed from: a */
    public final C12518b m75291a(AppInfoList appInfoList) {
        if (appInfoList == null) {
            return null;
        }
        CloudBackup cloudBackup = appInfoList.getCloudBackup();
        C12518b c12518b = new C12518b();
        c12518b.m75255c0(appInfoList.getId());
        c12518b.m75232I(appInfoList.getAppId());
        c12518b.m75234K(appInfoList.getAppType());
        c12518b.m75233J(appInfoList.getAppName());
        c12518b.m75231H(C12540b1.m75485c(appInfoList.getAppIcon()));
        c12518b.m75259e0(cloudBackup.getListType());
        c12518b.m75235L(C12540b1.m75485c(cloudBackup.getAppVer()));
        c12518b.m75236M(C12540b1.m75485c(cloudBackup.getAppVersRegex()));
        c12518b.m75248Y(C12540b1.m75485c(cloudBackup.getEmuiVersRegex()));
        c12518b.m75245V(cloudBackup.getDevCompatible());
        c12518b.m75257d0(C12540b1.m75485c(cloudBackup.getInclude()));
        c12518b.m75249Z(C12540b1.m75485c(cloudBackup.getExclude()));
        c12518b.m75277n0(cloudBackup.getWakeUpService());
        c12518b.m75271k0(appInfoList.getSkipWhenInsuff());
        if (cloudBackup.getOsVersRegex() != null) {
            c12518b.m75273l0(1);
            c12518b.m75263g0(cloudBackup.getOsVersRegex());
        }
        c12518b.m75265h0(appInfoList.getPriority());
        c12518b.m75251a0(cloudBackup.getForegroundBackup());
        c12518b.m75253b0(C12540b1.m75485c(cloudBackup.getForegroundBackupTime()));
        c12518b.m75261f0(appInfoList.getMinClientVersion());
        c12518b.m75246W(C12540b1.m75485c(cloudBackup.getEffectDevice()));
        c12518b.m75247X(C12540b1.m75485c(cloudBackup.getEffectPackage()));
        c12518b.m75267i0(cloudBackup.getSdcardAcptErrNum());
        c12518b.m75269j0(cloudBackup.getSdcardAcptErrRate());
        c12518b.m75243T(cloudBackup.getDataAcptErrNum());
        c12518b.m75244U(cloudBackup.getDataAcptErrRate());
        c12518b.m75237N(String.valueOf(cloudBackup.getBackgroundBackup()));
        c12518b.m75238O(String.valueOf(cloudBackup.getShowType()));
        c12518b.m75239P(C12540b1.m75485c(cloudBackup.getPathMapping()));
        c12518b.m75240Q(cloudBackup.getDBDiffDBFileName());
        c12518b.m75241R(C12540b1.m75485c(cloudBackup.getBakCategory()));
        c12518b.m75275m0(cloudBackup.isSupportTwinApp());
        return c12518b;
    }

    /* renamed from: b */
    public boolean m75292b(String str) {
        if (C4633d0.m28404a(str)) {
            C11839m.m70688i("AppInfoListOperator", "check is default app info, appId is null.");
        }
        List arrayList = new ArrayList();
        try {
            arrayList = query("select id, appId, appType, appName, appIcon, listType, appVer, appVersRegex, emuiVersRegex, devCompatible, include, exclude, wakeUpService, skipWhenInsuff, supportOsVersRegex, osVersRegex, priority, foregroundBackup, foregroundBackupTime, minClientVersion, effectDevice, effectPackage, sdcardAcptErrNum, sdcardAcptErrRate, dataAcptErrNum, dataAcptErrRate, isSupportTwinApp, data1, data2, data3, data4, data5, data6 from app_file_info where appId = ?;", new String[]{str});
        } catch (C9721b e10) {
            C11839m.m70687e("AppInfoListOperator", "queryDefaultAppInfoList error: " + e10.toString());
        }
        return arrayList.isEmpty();
    }

    @Override // ml.AbstractC11478a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String[] getColumns(AppInfoList appInfoList) {
        C12518b c12518bM75291a = m75291a(appInfoList);
        return new String[]{c12518bM75291a.m75285v(), c12518bM75291a.m75252b(), String.valueOf(c12518bM75291a.m75256d()), c12518bM75291a.m75254c(), c12518bM75291a.m75250a(), String.valueOf(c12518bM75291a.m75287x()), c12518bM75291a.m75258e(), c12518bM75291a.m75260f(), c12518bM75291a.m75281r(), String.valueOf(c12518bM75291a.m75278o()), c12518bM75291a.m75286w(), c12518bM75291a.m75282s(), c12518bM75291a.m75229F(), String.valueOf(c12518bM75291a.m75227D()), String.valueOf(c12518bM75291a.m75228E()), c12518bM75291a.m75289z(), String.valueOf(c12518bM75291a.m75224A()), String.valueOf(c12518bM75291a.m75283t()), c12518bM75291a.m75284u(), String.valueOf(c12518bM75291a.m75288y()), c12518bM75291a.m75279p(), c12518bM75291a.m75280q(), String.valueOf(c12518bM75291a.m75225B()), String.valueOf(c12518bM75291a.m75226C()), String.valueOf(c12518bM75291a.m75274m()), String.valueOf(c12518bM75291a.m75276n()), String.valueOf(c12518bM75291a.m75230G()), c12518bM75291a.m75262g(), c12518bM75291a.m75264h(), c12518bM75291a.m75266i(), c12518bM75291a.m75268j(), c12518bM75291a.m75270k(), c12518bM75291a.m75272l()};
    }

    public void clear() {
        try {
            execSQL("delete from app_file_info");
        } catch (C9721b e10) {
            C11839m.m70687e("AppInfoListOperator", "execSQL clear error: " + e10.toString());
        }
    }

    @Override // ml.AbstractC11478a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AppInfoList getObject(Cursor cursor) {
        C12518b c12518b = new C12518b();
        c12518b.m75255c0(cursor.getString(0));
        c12518b.m75232I(cursor.getString(1));
        c12518b.m75234K(cursor.getInt(2));
        c12518b.m75233J(cursor.getString(3));
        c12518b.m75231H(cursor.getString(4));
        c12518b.m75259e0(cursor.getInt(5));
        c12518b.m75235L(cursor.getString(6));
        c12518b.m75236M(cursor.getString(7));
        c12518b.m75248Y(cursor.getString(8));
        c12518b.m75245V(cursor.getInt(9));
        c12518b.m75257d0(cursor.getString(10));
        c12518b.m75249Z(cursor.getString(11));
        c12518b.m75277n0(cursor.getString(12));
        c12518b.m75271k0(cursor.getInt(13));
        c12518b.m75273l0(cursor.getInt(14));
        c12518b.m75263g0(cursor.getString(15));
        c12518b.m75265h0(cursor.getInt(16));
        c12518b.m75251a0(cursor.getInt(17));
        c12518b.m75253b0(cursor.getString(18));
        c12518b.m75261f0(cursor.getInt(19));
        c12518b.m75246W(cursor.getString(20));
        c12518b.m75247X(cursor.getString(21));
        c12518b.m75267i0(cursor.getInt(22));
        c12518b.m75269j0(cursor.getInt(23));
        c12518b.m75243T(cursor.getInt(24));
        c12518b.m75244U(cursor.getInt(25));
        c12518b.m75275m0(cursor.getInt(26));
        c12518b.m75237N(cursor.getString(27));
        c12518b.m75238O(cursor.getString(28));
        c12518b.m75239P(cursor.getString(29));
        c12518b.m75240Q(cursor.getString(30));
        c12518b.m75241R(cursor.getString(31));
        c12518b.m75242S(cursor.getString(32));
        return m75295f(c12518b);
    }

    /* renamed from: f */
    public final AppInfoList m75295f(C12518b c12518b) {
        if (c12518b == null) {
            return null;
        }
        AppInfoList appInfoList = new AppInfoList();
        appInfoList.setId(c12518b.m75285v());
        appInfoList.setAppId(c12518b.m75252b());
        appInfoList.setAppType(c12518b.m75256d());
        appInfoList.setAppName(c12518b.m75254c());
        CloudBackup cloudBackup = new CloudBackup();
        cloudBackup.setListType(c12518b.m75287x());
        cloudBackup.setAppVer(c12518b.m75258e());
        cloudBackup.setAppVersRegex(c12518b.m75260f());
        cloudBackup.setEmuiVersRegex(c12518b.m75281r());
        if (c12518b.m75228E() == 1) {
            cloudBackup.setOsVersRegex(c12518b.m75289z());
        }
        cloudBackup.setDevCompatible(c12518b.m75278o());
        cloudBackup.setInclude(c12518b.m75286w());
        cloudBackup.setExclude(c12518b.m75282s());
        cloudBackup.setWakeUpService(c12518b.m75229F());
        cloudBackup.setForegroundBackup(c12518b.m75283t());
        cloudBackup.setForegroundBackupTime(c12518b.m75284u());
        cloudBackup.setEffectDevice(c12518b.m75279p());
        cloudBackup.setEffectPackage(c12518b.m75280q());
        cloudBackup.setBackgroundBackup(c12518b.m75262g().equals("1") ? 1 : 2);
        cloudBackup.setSdcardAcptErrNum(c12518b.m75225B());
        cloudBackup.setSdcardAcptErrRate(c12518b.m75226C());
        cloudBackup.setDataAcptErrNum(c12518b.m75274m());
        cloudBackup.setDataAcptErrRate(c12518b.m75276n());
        cloudBackup.setShowType(C0241z.m1685c(c12518b.m75264h()));
        cloudBackup.setPathMapping(c12518b.m75266i());
        cloudBackup.setSupportTwinApp(c12518b.m75230G());
        cloudBackup.setDBDiffDBFileName(c12518b.m75268j());
        cloudBackup.setBakCategory(c12518b.m75270k());
        appInfoList.setCloudBackup(cloudBackup);
        appInfoList.setAppIcon(c12518b.m75250a());
        appInfoList.setSkipWhenInsuff(c12518b.m75227D());
        appInfoList.setMinClientVersion(c12518b.m75288y());
        appInfoList.setPriority(c12518b.m75224A());
        return appInfoList;
    }

    /* renamed from: g */
    public AppIcon m75296g(String str) {
        try {
            Cursor cursorRawQuery = rawQuery("select appIcon from app_file_info where appId = ?;", new String[]{str});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        AppInfoList appInfoList = new AppInfoList();
                        appInfoList.setAppIcon(cursorRawQuery.getString(0));
                        AppIcon appIcon = appInfoList.getAppIcon();
                        cursorRawQuery.close();
                        return appIcon;
                    }
                } finally {
                }
            }
            if (cursorRawQuery == null) {
                return null;
            }
            cursorRawQuery.close();
            return null;
        } catch (C9721b e10) {
            C11839m.m70689w("AppInfoListOperator", "check old db tag exists error." + e10.toString());
            return null;
        }
    }

    /* renamed from: h */
    public List<String> m75297h(int i10) throws C9721b {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = rawQuery("select distinct appId from app_file_info where appType = ?;", new String[]{String.valueOf(i10)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        arrayList.add(cursorRawQuery.getString(0));
                    } while (cursorRawQuery.moveToNext());
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return arrayList;
    }

    /* renamed from: i */
    public String m75298i(String str) {
        try {
            Cursor cursorRawQuery = rawQuery("select appName from app_file_info where appId = ?;", new String[]{str});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string = cursorRawQuery.getString(0);
                        cursorRawQuery.close();
                        return string;
                    }
                } finally {
                }
            }
            if (cursorRawQuery == null) {
                return null;
            }
            cursorRawQuery.close();
            return null;
        } catch (C9721b e10) {
            C11839m.m70689w("AppInfoListOperator", "check old db tag exists error." + e10.toString());
            return null;
        }
    }

    /* renamed from: j */
    public List<String> m75299j() throws C9721b {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorRawQuery = rawQuery("select appId from app_file_info;", null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            arrayList.add(cursorRawQuery.getString(0));
                        } while (cursorRawQuery.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70687e("AppInfoListOperator", "queryAll error: " + e10.getMessage());
        }
        return arrayList;
    }

    /* renamed from: k */
    public List<AppInfoList> m75300k(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            return query("select id, appId, appType, appName, appIcon, listType, appVer, appVersRegex, emuiVersRegex, devCompatible, include, exclude, wakeUpService, skipWhenInsuff, supportOsVersRegex, osVersRegex, priority, foregroundBackup, foregroundBackupTime, minClientVersion, effectDevice, effectPackage, sdcardAcptErrNum, sdcardAcptErrRate, dataAcptErrNum, dataAcptErrRate, isSupportTwinApp, data1, data2, data3, data4, data5, data6 from app_file_info where appId = ?;", new String[]{str});
        } catch (C9721b e10) {
            C11839m.m70687e("AppInfoListOperator", "queryAppFileInfo error: " + e10.toString());
            return arrayList;
        }
    }

    /* renamed from: l */
    public List<String> m75301l() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorRawQuery = rawQuery("select distinct appId from app_file_info where priority != 0 order by priority;", new String[0]);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            arrayList.add(cursorRawQuery.getString(0));
                        } while (cursorRawQuery.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (C9721b e10) {
            C11839m.m70687e("AppInfoListOperator", "queryBackupPriority error: " + e10.toString());
        }
        return arrayList;
    }

    /* renamed from: m */
    public List<AppInfoList> m75302m() {
        ArrayList arrayList = new ArrayList();
        try {
            return query("select id, appId, appType, appName, appIcon, listType, appVer, appVersRegex, emuiVersRegex, devCompatible, include, exclude, wakeUpService, skipWhenInsuff, supportOsVersRegex, osVersRegex, priority, foregroundBackup, foregroundBackupTime, minClientVersion, effectDevice, effectPackage, sdcardAcptErrNum, sdcardAcptErrRate, dataAcptErrNum, dataAcptErrRate, isSupportTwinApp, data1, data2, data3, data4, data5, data6 from app_file_info where appId like 'default%' order by appId;", new String[0]);
        } catch (C9721b e10) {
            C11839m.m70687e("AppInfoListOperator", "queryDefaultAppInfoList error: " + e10.toString());
            return arrayList;
        }
    }

    /* renamed from: n */
    public List<AppInfoList> m75303n() {
        ArrayList arrayList = new ArrayList();
        try {
            return query("select id, appId, appType, appName, appIcon, listType, appVer, appVersRegex, emuiVersRegex, devCompatible, include, exclude, wakeUpService, skipWhenInsuff, supportOsVersRegex, osVersRegex, priority, foregroundBackup, foregroundBackupTime, minClientVersion, effectDevice, effectPackage, sdcardAcptErrNum, sdcardAcptErrRate, dataAcptErrNum, dataAcptErrRate, isSupportTwinApp, data1, data2, data3, data4, data5, data6 from app_file_info where appId like 'refurbish%' order by appId;", new String[0]);
        } catch (C9721b e10) {
            C11839m.m70687e("AppInfoListOperator", "queryRefurbishAppInfoList error: " + e10.toString());
            return arrayList;
        }
    }

    /* renamed from: o */
    public List<AppInfoList> m75304o() throws Throwable {
        List<AppInfoList> arrayList = new ArrayList<>();
        try {
            arrayList = query("select id, appId, appType, appName, appIcon, listType, appVer, appVersRegex, emuiVersRegex, devCompatible, include, exclude, wakeUpService, skipWhenInsuff, supportOsVersRegex, osVersRegex, priority, foregroundBackup, foregroundBackupTime, minClientVersion, effectDevice, effectPackage, sdcardAcptErrNum, sdcardAcptErrRate, dataAcptErrNum, dataAcptErrRate, isSupportTwinApp, data1, data2, data3, data4, data5, data6 from app_file_info where appId like 'TempBackup%' order by appId;", new String[0]);
        } catch (C9721b e10) {
            C11839m.m70687e("AppInfoListOperator", "queryTempBackupAppInfoList error: " + e10);
        }
        m75290d(arrayList);
        return arrayList;
    }

    /* renamed from: p */
    public String m75305p(String str) {
        try {
            Cursor cursorRawQuery = rawQuery("select data2 from app_file_info where appId = ?;", new String[]{str});
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string = cursorRawQuery.getString(0);
                        cursorRawQuery.close();
                        return string;
                    }
                } finally {
                }
            }
            if (cursorRawQuery == null) {
                return null;
            }
            cursorRawQuery.close();
            return null;
        } catch (C9721b e10) {
            C11839m.m70689w("AppInfoListOperator", "queryVirtualAppShowType exists error." + e10.toString());
            return null;
        }
    }

    /* renamed from: q */
    public List<String> m75306q() throws C9721b {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = rawQuery("select distinct appId from app_file_info where appType in(?,?);", new String[]{String.valueOf(1), String.valueOf(2)});
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        arrayList.add(cursorRawQuery.getString(0));
                    } while (cursorRawQuery.moveToNext());
                }
            } catch (Throwable th2) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return arrayList;
    }

    /* renamed from: r */
    public void m75307r(List<AppInfoList> list) throws C9721b {
        if (list == null) {
            C11839m.m70687e("AppInfoListOperator", "updateAppInfoList appInfoList is null ");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (AppInfoList appInfoList : list) {
            if (appInfoList.getAppId() == null) {
                C11839m.m70689w("AppInfoListOperator", "appId is empty, appInfo: " + appInfoList);
            } else {
                C11839m.m70688i("AppInfoListOperator", "add appInfo: " + appInfoList);
                arrayList.add(getColumns(appInfoList));
            }
        }
        try {
            execute("replace into app_file_info(id, appId, appType, appName, appIcon, listType, appVer, appVersRegex, emuiVersRegex, devCompatible, include, exclude, wakeUpService, skipWhenInsuff, supportOsVersRegex, osVersRegex, priority, foregroundBackup, foregroundBackupTime, minClientVersion, effectDevice, effectPackage, sdcardAcptErrNum, sdcardAcptErrRate, dataAcptErrNum, dataAcptErrRate, isSupportTwinApp, data1, data2, data3, data4, data5, data6) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", arrayList);
        } catch (C9721b e10) {
            C11839m.m70687e("AppInfoListOperator", "updateAppInfoList error: " + e10.toString());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "update app info list exec error. " + e10.getMessage(), "execSQL");
        }
    }
}
