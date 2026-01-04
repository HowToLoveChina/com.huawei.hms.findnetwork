package com.huawei.hianalytics;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hianalytics.core.log.HiLog;
import java.util.Locale;
import mu.C11526c;
import p237du.C9310c;

/* renamed from: com.huawei.hianalytics.i1 */
/* loaded from: classes5.dex */
public class C4784i1 {

    /* renamed from: a */
    public static final String[] f21832a = {"e2f856b9f9a4fd4cb2795aeaf83268e4bff189aaec05d691ffde76e075b82648", "173cf86fe9894a0f70dadd09d4fd88c380836099d4939f8c3754361bdc16a32b", "b368b110e3b565fe97c91f786e11bc48754cc8e4e6f21d8a94a68ac6ad67aaaf", "db48223fd9e143f7e133c57f5d08a4e38549ce3ebd921fe3b4003c26e5e35bed", "4bdecdf772491e35c4e8b48f88aee22bae1311984f2e1da4dfad0b78ee7f5163", "3081a0adab3018d57165e6dd24074bdbac640f6dbe21a9e24d3474a87ebf38b8", "db53fcdc9ab71e9bdd4eab257fe1aba7989ad2b24fbe3a85dfef72ea1dd6bae2", "d80f18e8081b624cc64985f87f70118f1702985d2e10dbc985ee7be334fd3c7d", "5fed96c85bd58c58aadbd465c172a4c9a794d8eb2f86cbc7bcee6caf4c7a2c5f", "07ff9b7aeeff969173c45b285fe0fecdbaae244576ff7a2796a36f1c0c11adb4", "92974c6802419e4d18b5ec536cbfa167b8e8eff09ec4c8510a5b95750b1e0c82", "403f14ad2f0e5eb3c4f3a0bcd5c1592cc4492662ad53191c92905255d4990656", "4230baa077b401374d0fc012375047e79ea0790d58d095ef18d97d95470c738d", "f8d927750a0952ffb5bd87dfb83d781ae65f7bed043a7886d1d3cdcfc94bb77a", "e9702f1e92e97fce49cdf81a5fa730a4e913554d09b3fe41e1d8a7fba00a8459", "24fbae40bcd50b759b26e3ba0f46aa25e932fa7da05f226d75ec507bcf53bce5", "9603261b85f2b0f672f7a1c0baf081ca001455d64adef7d8f21f65e0a63a93c7"};

    /* renamed from: a */
    public static boolean m28894a(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            HiLog.m28809i("UriUtil", "url is null");
        } else {
            try {
                if (URLUtil.isNetworkUrl(str) && !str.toLowerCase(Locale.US).startsWith("http:")) {
                    str = C11526c.m68805b(str);
                }
                HiLog.m28808e("UriUtil", "url don't starts with https");
            } catch (Exception unused) {
                HiLog.m28808e("UriUtil", "getHostByURI error");
            }
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            HiLog.m28808e("UriUtil", "url or whitelistHash is null");
            return false;
        }
        String strM58618b = C9310c.m58618b(str);
        for (String str2 : f21832a) {
            if (str2.equals(strM58618b)) {
                return true;
            }
        }
        if (TextUtils.isEmpty(str)) {
            HiLog.m28809i("UriUtil", "url is null");
            string = str;
        } else {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length < 2) {
                string = "";
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(strArrSplit[strArrSplit.length - 2]);
                stringBuffer.append(".");
                stringBuffer.append(strArrSplit[strArrSplit.length - 1]);
                string = stringBuffer.toString();
            }
        }
        if (TextUtils.isEmpty(string)) {
            HiLog.m28808e("UriUtil", "get urlLastNStr is null");
            return false;
        }
        String strM58618b2 = C9310c.m58618b(string);
        for (String str3 : f21832a) {
            if (str3.equals(strM58618b2)) {
                try {
                    String strSubstring = str.substring(0, str.length() - string.length());
                    if (strSubstring.endsWith(".")) {
                        return strSubstring.matches("^[A-Za-z0-9.-]+$");
                    }
                    return false;
                } catch (Exception unused2) {
                    HiLog.m28808e("UriUtil", "check domain error");
                    return false;
                }
            }
        }
        return false;
    }
}
