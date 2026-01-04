package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.BrandMarket;
import com.huawei.hicloud.notification.p106db.bean.BrandMarkets;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpaceBrandMarkets;
import com.huawei.hicloud.notification.p106db.bean.Pps;
import com.huawei.hicloud.notification.p106db.operator.HiCloudBrandBuyBannerOperator;
import com.huawei.hicloud.notification.p106db.operator.HiCloudBrandHomePageBannerOperator;
import com.huawei.hicloud.notification.task.QueryHiCloudBrandBuyBannerTask;
import com.huawei.hicloud.notification.task.QueryHiCloudBrandHomePageBannerTask;
import com.huawei.hicloud.notification.util.NotifyUtil;
import gp.C10028c;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import p015ak.C0209d;
import p015ak.C0213f;
import p459lp.C11327e;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class HiCloudBrandBannerManager {
    private static final String TAG = "HiCloudBrandBannerManager";

    public static class Holder {
        private static HiCloudBrandBannerManager INSTANCE = new HiCloudBrandBannerManager();

        private Holder() {
        }
    }

    public /* synthetic */ HiCloudBrandBannerManager(C49231 c49231) {
        this();
    }

    private void clearConfigFile(String str) {
        if (RecommendCardManager.getInstance().checkEntrance(str)) {
            Context contextM1378b = C0213f.m1378b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(contextM1378b.getFilesDir());
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("recommend_card_config");
            sb2.append(str2);
            String string = sb2.toString();
            if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
                string = string + "HiCloudBrandHomePageBanner.json";
            } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
                string = string + "HiCloudBrandBuyBanner.json";
            }
            RecommendCardManager.getInstance().clearFile(string);
        }
    }

    private BrandMarkets getBrandMarkets(String str) {
        if (!RecommendCardManager.getInstance().checkEntrance(str)) {
            return null;
        }
        HiCloudSpaceBrandMarkets configFromFile = getConfigFromFile(str);
        if (configFromFile != null) {
            return configFromFile.getBrandMarkets();
        }
        NotifyLogger.m29914e(TAG, "hiCloudSpaceBrandMarkets is null");
        return null;
    }

    public static HiCloudBrandBannerManager getInstance() {
        return Holder.INSTANCE;
    }

    private void parseLanguageXMLSplit(String str, File file, CommonLanguage commonLanguage) throws Throwable {
        Throwable th2;
        FileInputStream fileInputStream;
        Exception e10;
        ArrayList<CommonLanguageDbString> arrayList = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e11) {
                fileInputStream = null;
                e10 = e11;
            } catch (Throwable th3) {
                th2 = th3;
                RecommendCardManager.getInstance().closeIn(null);
                throw th2;
            }
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setInput(fileInputStream, "utf-8");
                String str2 = "";
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType != 2) {
                        if (eventType == 3 && !"resource".equals(name) && !"text".equals(name) && arrayList != null) {
                            if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
                                new HiCloudBrandHomePageBannerOperator().batchInsert(arrayList);
                                arrayList.clear();
                                C10028c.m62182c0().m62386r2(RecommendCardConstants.LanguageVersion.HICLOUD_BRAND_HOMEPAGE_BANNER, commonLanguage.getVersion());
                                C10028c.m62182c0().m62381q2(RecommendCardConstants.LanguageHash.HICLOUD_BRAND_HOMEPAGE_BANNER, commonLanguage.getHash());
                            } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
                                new HiCloudBrandBuyBannerOperator().batchInsert(arrayList);
                                arrayList.clear();
                                C10028c.m62182c0().m62386r2(RecommendCardConstants.LanguageVersion.HICLOUD_BRAND_BUY_BANNER, commonLanguage.getVersion());
                                C10028c.m62182c0().m62381q2(RecommendCardConstants.LanguageHash.HICLOUD_BRAND_BUY_BANNER, commonLanguage.getHash());
                            }
                        }
                    } else if ("resource".equals(name)) {
                        arrayList = new ArrayList<>();
                    } else if ("text".equals(name)) {
                        CommonLanguageDbString commonLanguageDbString = new CommonLanguageDbString();
                        commonLanguageDbString.setName(xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "name"));
                        commonLanguageDbString.setValue(xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "value"));
                        commonLanguageDbString.setLanguage(str2);
                        if (arrayList != null) {
                            arrayList.add(commonLanguageDbString);
                        }
                    } else {
                        str2 = name;
                    }
                }
            } catch (Exception e12) {
                e10 = e12;
                NotifyLogger.m29914e(TAG, "parseLanguageXML exception: " + e10.toString());
                RecommendCardManager.getInstance().closeIn(fileInputStream);
            }
            RecommendCardManager.getInstance().closeIn(fileInputStream);
        } catch (Throwable th4) {
            th2 = th4;
            RecommendCardManager.getInstance().closeIn(null);
            throw th2;
        }
    }

    public void checkLanguageDataBase(String str) throws Throwable {
        if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            if (new HiCloudBrandHomePageBannerOperator().hasRecord()) {
                NotifyLogger.m29915i(TAG, "operator has record");
                return;
            }
        } else if (str.equals(RecommendCardConstants.Entrance.BUY) && new HiCloudBrandBuyBannerOperator().hasRecord()) {
            NotifyLogger.m29915i(TAG, "operator has record");
            return;
        }
        BrandMarkets brandMarkets = getBrandMarkets(str);
        if (brandMarkets == null) {
            NotifyLogger.m29914e(TAG, "brandMarkets is null");
            return;
        }
        CommonLanguage language = brandMarkets.getLanguage();
        if (language == null) {
            NotifyLogger.m29914e(TAG, "commonLanguage is null");
            return;
        }
        String languageXMLPath = getLanguageXMLPath(str);
        if (TextUtils.isEmpty(languageXMLPath)) {
            NotifyLogger.m29914e(TAG, "xmlPath is empty");
        } else if (new File(languageXMLPath).exists()) {
            NotifyLogger.m29915i(TAG, "checkLanguageDataBase, need parseLanguageXmlAndInsertDB");
            parseLanguageXML(str, languageXMLPath, language);
        }
    }

    public void clearConfigFileAndDb() {
        clearLanguageXml(RecommendCardConstants.Entrance.HOMEPAGE);
        clearLanguageXml(RecommendCardConstants.Entrance.BUY);
        clearLanguageDb(RecommendCardConstants.Entrance.HOMEPAGE);
        clearLanguageDb(RecommendCardConstants.Entrance.BUY);
        clearConfigFile(RecommendCardConstants.Entrance.HOMEPAGE);
        clearConfigFile(RecommendCardConstants.Entrance.BUY);
        C11327e.m68059b("HiCloudBrandHomePageBanner");
        C11327e.m68059b("HiCloudBrandBuyBanner");
    }

    public void clearLanguageDb(String str) {
        if (RecommendCardManager.getInstance().checkEntrance(str)) {
            if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
                new HiCloudBrandHomePageBannerOperator().clear();
            } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
                new HiCloudBrandBuyBannerOperator().clear();
            }
        }
    }

    public void clearLanguageXml(String str) {
        if (RecommendCardManager.getInstance().checkEntrance(str)) {
            String languageXMLPath = getLanguageXMLPath(str);
            if (TextUtils.isEmpty(languageXMLPath)) {
                NotifyLogger.m29914e(TAG, "languageXMLPath is empty");
            } else {
                RecommendCardManager.getInstance().clearFile(languageXMLPath);
            }
        }
    }

    public BrandMarket getBrandObjectByActivityId(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            NotifyLogger.m29914e(TAG, "activityId is empty");
            return null;
        }
        BrandMarkets brandMarkets = getBrandMarkets(str);
        if (brandMarkets == null) {
            NotifyLogger.m29914e(TAG, "brandMarkets is null");
            return null;
        }
        BrandMarket[] brandMarkets2 = brandMarkets.getBrandMarkets();
        if (brandMarkets2 == null) {
            NotifyLogger.m29914e(TAG, "brandMarketArray is null");
            return null;
        }
        for (BrandMarket brandMarket : brandMarkets2) {
            if (brandMarket == null) {
                NotifyLogger.m29914e(TAG, "brandMarket is null");
            } else {
                String activityId = brandMarket.getActivityId();
                if (!TextUtils.isEmpty(activityId) && activityId.equals(str2)) {
                    NotifyLogger.m29915i(TAG, "match activityId: " + str2);
                    return brandMarket;
                }
            }
        }
        NotifyLogger.m29916w(TAG, "not match activityId: " + str2);
        return null;
    }

    public HiCloudSpaceBrandMarkets getConfigFromFile(String str) {
        if (!RecommendCardManager.getInstance().checkEntrance(str)) {
            return null;
        }
        Context contextM1378b = C0213f.m1378b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("recommend_card_config");
        sb2.append(str2);
        String string = sb2.toString();
        if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            string = string + "HiCloudBrandHomePageBanner.json";
        } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
            string = string + "HiCloudBrandBuyBanner.json";
        }
        File file = new File(string);
        if (!file.exists()) {
            NotifyLogger.m29915i(TAG, "config file not existed");
            getConfigFromOM(str);
            return null;
        }
        try {
            return (HiCloudSpaceBrandMarkets) new Gson().fromJson(C0209d.m1290o2(new FileInputStream(file)), HiCloudSpaceBrandMarkets.class);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getConfigFromFile exception: " + e10.toString());
            return null;
        }
    }

    public void getConfigFromOM(String str) {
        if (RecommendCardManager.getInstance().checkGetConfigParam(str)) {
            NotifyLogger.m29915i(TAG, "getConfigFromOM entrance: " + str);
            if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
                C12515a.m75110o().m75172d(new QueryHiCloudBrandHomePageBannerTask());
            } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
                C12515a.m75110o().m75172d(new QueryHiCloudBrandBuyBannerTask());
            }
        }
    }

    public String getLanguageXMLPath(String str) {
        if (!RecommendCardManager.getInstance().checkEntrance(str)) {
            return "";
        }
        Context contextM1378b = C0213f.m1378b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(RecommendCardConstants.LanguageFileName.FOLDER);
        sb2.append(str2);
        String string = sb2.toString();
        if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            return string + RecommendCardConstants.LanguageFileName.HICLOUD_BRAND_HOMEPAGE_BANNER;
        }
        if (!str.equals(RecommendCardConstants.Entrance.BUY)) {
            return string;
        }
        return string + RecommendCardConstants.LanguageFileName.HICLOUD_BRAND_BUY_BANNER;
    }

    public String[] getPpsAdid(String str) {
        Pps pps;
        String[] strArr = new String[0];
        BrandMarkets brandMarkets = getBrandMarkets(str);
        if (brandMarkets == null) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        for (BrandMarket brandMarket : brandMarkets.getBrandMarkets()) {
            if (brandMarket.isPpsCard() && (pps = brandMarket.getPps()) != null && !arrayList.contains(pps.getAdvertId())) {
                arrayList.add(pps.getAdvertId());
            }
        }
        String[] strArr2 = new String[arrayList.size()];
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            strArr2[i10] = (String) arrayList.get(i10);
            NotifyLogger.m29915i(TAG, "PpsAdid: " + ((String) arrayList.get(i10)));
        }
        return strArr2;
    }

    public String getStringFromDB(String str, String str2) {
        if (!RecommendCardManager.getInstance().checkEntrance(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            NotifyLogger.m29914e(TAG, "id is empty");
            return "";
        }
        String currentBaseLanguage = HNUtil.getCurrentBaseLanguage();
        String currentLanguage = HNUtil.getCurrentLanguage();
        return NotifyUtil.getStringFromConfig(str2, true, str.equals(RecommendCardConstants.Entrance.HOMEPAGE) ? new HiCloudBrandHomePageBannerOperator().queryString(currentLanguage, currentBaseLanguage, HNConstants.Language.EN_STANDARD, str2) : str.equals(RecommendCardConstants.Entrance.BUY) ? new HiCloudBrandBuyBannerOperator().queryString(currentLanguage, currentBaseLanguage, HNConstants.Language.EN_STANDARD, str2) : null);
    }

    public void parseLanguageXML(String str, String str2, CommonLanguage commonLanguage) throws Throwable {
        NotifyLogger.m29915i(TAG, "parseLanguageXML");
        if (RecommendCardManager.getInstance().checkEntrance(str)) {
            if (commonLanguage == null) {
                NotifyLogger.m29914e(TAG, "commonLanguage is null");
                return;
            }
            File file = new File(str2);
            if (file.exists()) {
                parseLanguageXMLSplit(str, file, commonLanguage);
            } else {
                NotifyLogger.m29914e(TAG, "language xml not exist");
            }
        }
    }

    private HiCloudBrandBannerManager() {
    }
}
