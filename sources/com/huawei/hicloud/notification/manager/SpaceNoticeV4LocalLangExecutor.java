package com.huawei.hicloud.notification.manager;

import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.languageoperator.SpaceNoticeV4LocalLanguageOperator;
import gp.C10028c;
import java.util.ArrayList;
import p429kk.C11058a;
import p429kk.C11060c;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class SpaceNoticeV4LocalLangExecutor extends NoticeCfgLanguageBaseManager {
    private static final SpaceNoticeV4LocalLangExecutor INSTANCE = new SpaceNoticeV4LocalLangExecutor();
    private static final String TAG = "SpaceNoticeV4LocalLangExecutor";

    public static SpaceNoticeV4LocalLangExecutor getInstance() {
        return INSTANCE;
    }

    public void checkLanguageDataBase() throws Throwable {
        if (databaseHasRecord()) {
            return;
        }
        NotifyLogger.m29915i(TAG, "checkLanguageDataBase, need parseLanguageXml");
        parseLanguageFile("");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearCurrentLanguageDownloadResult() {
        C10028c.m62182c0().m62353l("space_notice_v4_local_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLangVersionAndResult() {
        NotifyLogger.m29915i(TAG, "clear notice language");
        C10028c.m62182c0().m62353l("space_notice_v4_local_version");
        C10028c.m62182c0().m62353l("space_notice_v4_local_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLanguageDb() throws SQLException {
        new SpaceNoticeV4LocalLanguageOperator().clear();
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean databaseHasRecord() {
        try {
            return new SpaceNoticeV4LocalLanguageOperator().hasRecord();
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "databaseHasRecord exceptions:" + e10.toString());
            return false;
        }
    }

    public void execute(CommonLanguage commonLanguage) throws Throwable {
        if (commonLanguage == null) {
            NotifyLogger.m29914e(TAG, "commonLanguage null");
            return;
        }
        int currentLanguageVersion = getCurrentLanguageVersion();
        NotifyLogger.m29915i(TAG, "current language version is: " + currentLanguageVersion + ", OM file language version is: " + commonLanguage.getVersion());
        if (currentLanguageVersion == 0 || currentLanguageVersion < commonLanguage.getVersion()) {
            clearLanguageDb();
            parseLanguageFile("");
            setCurrentLanguageVersion(commonLanguage.getVersion());
            setCurrentLanguageHash(commonLanguage.getHash());
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getCurrentLanguageHash() {
        return C10028c.m62182c0().m62184A("space_notice_v4_local_hash");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public int getCurrentLanguageVersion() {
        return C10028c.m62182c0().m62189B("space_notice_v4_local_version");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean getExtractResult() {
        return C10028c.m62182c0().m62324f0("space_notice_v4_local_result");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getLanguageFilePath() {
        return "";
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public AbstractRunnableC12516b.a getLanguageTaskEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public C11060c getStat() {
        if (this.stat == null) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07034"), "07034", C13452e.m80781L().m80971t0());
            this.stat = c11060cM66626a;
            c11060cM66626a.m66665u("0");
        }
        return this.stat;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void insertLanguageToDB(ArrayList<CommonLanguageDbString> arrayList) {
        try {
            new SpaceNoticeV4LocalLanguageOperator().batchInsert(arrayList);
        } catch (Exception e10) {
            String str = "insertDataToDB exceptions:" + e10.toString();
            NotifyLogger.m29914e(TAG, str);
            reportDownloadInfo("1", str, -1);
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void parseLanguageEnd(String str, ArrayList<CommonLanguageDbString> arrayList) {
        if ("resource".equals(str) || "text".equals(str) || arrayList == null) {
            return;
        }
        insertLanguageToDB(arrayList);
        arrayList.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00c4  */
    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parseLanguageFile(java.lang.String r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r10 = "SpaceNoticeV4LocalLangExecutor"
            android.content.Context r0 = p015ak.C0213f.m1377a()
            if (r0 != 0) goto L9
            return
        L9:
            r1 = 0
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.String r2 = "space_usage_notice_v4_language.xml"
            java.io.InputStream r0 = r0.open(r2)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            org.xmlpull.v1.XmlPullParser r2 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            java.lang.String r3 = "utf-8"
            r2.setInput(r0, r3)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            int r3 = r2.getEventType()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            java.lang.String r4 = ""
        L23:
            r5 = 1
            if (r3 == r5) goto L92
            java.lang.String r5 = r2.getName()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            r6 = 2
            if (r3 == r6) goto L3c
            r6 = 3
            if (r3 == r6) goto L31
            goto L8d
        L31:
            r9.parseLanguageEnd(r5, r1)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            goto L8d
        L35:
            r10 = move-exception
            r1 = r0
            goto Lc2
        L39:
            r1 = move-exception
            goto La6
        L3c:
            java.lang.String r3 = "resource"
            boolean r3 = r3.equals(r5)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            if (r3 == 0) goto L4a
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            r1.<init>()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            goto L8d
        L4a:
            java.lang.String r3 = "text"
            boolean r3 = r3.equals(r5)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            if (r3 == 0) goto L8c
            com.huawei.hicloud.notification.db.bean.CommonLanguageDbString r3 = new com.huawei.hicloud.notification.db.bean.CommonLanguageDbString     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            r3.<init>()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            java.lang.String r5 = r2.getNamespace()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            java.lang.String r6 = "name"
            java.lang.String r5 = r2.getAttributeValue(r5, r6)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            java.lang.String r6 = r2.getNamespace()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            java.lang.String r7 = "value"
            java.lang.String r6 = r2.getAttributeValue(r6, r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            if (r7 != 0) goto L8d
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            if (r7 != 0) goto L8d
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            if (r7 != 0) goto L8d
            r3.setLanguage(r4)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            r3.setName(r5)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            r3.setValue(r6)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            if (r1 == 0) goto L8d
            r1.add(r3)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            goto L8d
        L8c:
            r4 = r5
        L8d:
            int r3 = r2.next()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            goto L23
        L92:
            r9.setExtractResult(r5)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            java.lang.String r1 = "spaceNoticeV4LocalLangExecutor, parse notice language xml success"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r10, r1)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L39
            if (r0 == 0) goto Lc1
        L9c:
            r9.safeClose(r0)
            goto Lc1
        La0:
            r10 = move-exception
            goto Lc2
        La2:
            r0 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
        La6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r2.<init>()     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = "spaceNoticeV4LocalLangExecutor, parse notice language xml error:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L35
            r2.append(r1)     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L35
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r10, r1)     // Catch: java.lang.Throwable -> L35
            if (r0 == 0) goto Lc1
            goto L9c
        Lc1:
            return
        Lc2:
            if (r1 == 0) goto Lc7
            r9.safeClose(r1)
        Lc7:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.SpaceNoticeV4LocalLangExecutor.parseLanguageFile(java.lang.String):void");
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageHash(String str) {
        C10028c.m62182c0().m62381q2("space_notice_v4_local_hash", str);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageVersion(int i10) {
        C10028c.m62182c0().m62386r2("space_notice_v4_local_version", i10);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setExtractResult(boolean z10) {
        C10028c.m62182c0().m62281U2("space_notice_v4_local_result", z10);
    }
}
