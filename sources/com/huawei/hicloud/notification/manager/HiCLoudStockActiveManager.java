package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.content.res.Resources;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.StockActiveConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.operator.StockActiveConfigLanguageOperator;
import com.huawei.hicloud.notify.R$string;
import java.io.File;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p459lp.C11327e;

/* loaded from: classes6.dex */
public class HiCLoudStockActiveManager {
    private static final String TAG = "HiCLoudStockActiveManager";
    private boolean isProcessExit;

    public static class Holder {
        private static HiCLoudStockActiveManager INSTANCE = new HiCLoudStockActiveManager();

        private Holder() {
        }
    }

    private void clearConfigFile() {
        File file = new File(C0213f.m1378b().getFilesDir() + File.separator + "HiCloudStockActive.json");
        if (!file.exists()) {
            NotifyLogger.m29915i(TAG, "config file not exist");
        } else {
            if (file.delete()) {
                return;
            }
            NotifyLogger.m29914e(TAG, "config file delete fail");
        }
    }

    public static HiCLoudStockActiveManager getInstance() {
        return Holder.INSTANCE;
    }

    public void clearConfigFileAndDb() throws SQLException {
        clearConfigFile();
        clearLanguageXml();
        clearLanguageDb();
        clearPicture();
        C11327e.m68059b("HiCloudStockActive");
    }

    public void clearLanguageDb() throws SQLException {
        new StockActiveConfigLanguageOperator().clear();
    }

    public void clearLanguageXml() {
        String languageXMLPath = getLanguageXMLPath();
        if (TextUtils.isEmpty(languageXMLPath)) {
            NotifyLogger.m29914e(TAG, "languageXMLPath is empty");
            return;
        }
        File file = new File(languageXMLPath);
        if (!file.exists()) {
            NotifyLogger.m29915i(TAG, "config file not exist");
        } else {
            if (file.delete()) {
                return;
            }
            NotifyLogger.m29914e(TAG, "config file delete fail");
        }
    }

    public void clearPicture() {
        String picturePath = getInstance().getPicturePath();
        if (TextUtils.isEmpty(picturePath)) {
            NotifyLogger.m29914e(TAG, "picturePath is empty");
            return;
        }
        File file = new File(picturePath);
        if (!file.exists()) {
            NotifyLogger.m29915i(TAG, "config file not exist");
        } else {
            if (file.delete()) {
                return;
            }
            NotifyLogger.m29914e(TAG, "config file delete fail");
        }
    }

    public String getLanguageXMLPath() {
        return C0213f.m1378b().getFilesDir() + File.separator + StockActiveConstants.LANGUAGE_FILE_NAME;
    }

    public String getPicturePath() {
        return C0213f.m1378b().getFilesDir() + File.separator + StockActiveConstants.PICTURE_FILE_NAME;
    }

    public String[] getStockActiveBanner() throws Resources.NotFoundException {
        String string;
        String string2;
        String[] strArr = new String[0];
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "context is null");
            return strArr;
        }
        Resources resources = contextM1377a.getResources();
        if (resources == null) {
            NotifyLogger.m29914e(TAG, "resources is null");
            return strArr;
        }
        if (C0209d.m1269j1()) {
            string = resources.getString(R$string.stock_active_notification_title);
            string2 = resources.getString(R$string.stock_active_notification_content);
        } else {
            string = resources.getString(R$string.stock_active_notification_title_hw);
            string2 = resources.getString(R$string.stock_active_notification_content_hw);
        }
        return new String[]{string, string2};
    }

    public String[] getStockPopup() throws Resources.NotFoundException {
        String string;
        String string2;
        String[] strArr = new String[0];
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "context is null");
            return strArr;
        }
        Resources resources = contextM1377a.getResources();
        if (resources == null) {
            NotifyLogger.m29914e(TAG, "resources is null");
            return strArr;
        }
        if (C0209d.m1269j1()) {
            string = resources.getString(R$string.stock_active_popup_title);
            string2 = resources.getString(R$string.stock_active_popup_content);
        } else {
            string = resources.getString(R$string.stock_active_popup_title_hw);
            string2 = resources.getString(R$string.stock_active_popup_content_hw_new);
        }
        return new String[]{string, string2, resources.getString(R$string.stock_active_popup_button_first), resources.getString(R$string.stock_active_popup_button_second_new)};
    }

    public boolean isActiveCloudAuto() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "context is null");
            return false;
        }
        boolean zM1355e = C0212e0.m1355e(contextM1377a, StockActiveConstants.STOCK_ACTIVE_SP_NAME, StockActiveConstants.SpKey.IS_ACTIVE_CLOUD_AUTO, false);
        NotifyLogger.m29915i(TAG, "isActiveCloudAuto: " + zM1355e);
        return zM1355e;
    }

    public boolean isProcessExit() {
        NotifyLogger.m29915i(TAG, "getProcessExit: " + this.isProcessExit);
        return this.isProcessExit;
    }

    public void setProcessExit(boolean z10) {
        this.isProcessExit = z10;
        NotifyLogger.m29915i(TAG, "setProcessExit: " + z10);
    }

    private HiCLoudStockActiveManager() {
    }
}
