package com.huawei.hms.common.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.StringUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes8.dex */
public class TransactionIdCreater {
    /* renamed from: a */
    private static SecureRandom m30699a() {
        try {
            return SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception unused) {
            HMSLog.m36986e("TransactionIdCreater", "SecureRandom getInstance happpened NoSuchAlgorithmException!");
            return new SecureRandom();
        }
    }

    public static String getId(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringUtil.addByteForNum(str, 9, '0'));
        sb2.append(StringUtil.addByteForNum(str2, 6, '0'));
        Locale locale = Locale.ENGLISH;
        sb2.append(new SimpleDateFormat("yyyyMMddHHmmssSSS", locale).format(new Date()));
        sb2.append(String.format(locale, "%06d", Integer.valueOf(m30699a().nextInt(Constants.MILLON))));
        return sb2.toString();
    }
}
