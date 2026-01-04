package com.huawei.android.hicloud.agreement.oobe;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import fk.C9721b;
import hk.C10279b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import p015ak.C0209d;
import p015ak.C0221j;
import p052cb.C1413j;
import p514o9.C11827a;
import p514o9.C11839m;
import p514o9.C11843q;
import p606r9.C12478a;
import p652t9.EnumC12999a;

/* loaded from: classes2.dex */
public class OOBEAgreementHelper {
    private static final String OOBE_LOCAL_PATH = "oobe_agreement/cloud/";
    private static final String OOBE_SUB_PATH = "/b0/latest/";
    private static final String OOBE_TMS_FILE_NAME = "agreements";
    private static final String TAG = "OOBEAgreementHelper";
    private static final int TIMEOUT = 10000;
    private String country;
    private String language;
    private Context mContext;
    private String oobeTmsPath;
    private String productType;

    public static class ServiceCallback implements ICallback {
        public boolean onPause() {
            return false;
        }

        @Override // com.huawei.android.hicloud.connect.progress.ICallback
        public void onProgress(long j10, long j11) {
        }

        @Override // com.huawei.android.hicloud.connect.progress.ICallback
        public boolean onStop() {
            return false;
        }
    }

    public OOBEAgreementHelper(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.productType = str;
        this.country = str2;
        this.language = str3;
        this.oobeTmsPath = C10279b.m63452a(this.mContext.getFilesDir()) + "/oobetms";
    }

    private String getBodyStr(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "getBodyStr configStr null");
            return null;
        }
        return "<html>" + str.substring(str.indexOf("</head>") + 7);
    }

    private ContryGroupConfig getContryGroupConfig(Context context) throws Throwable {
        try {
            return (ContryGroupConfig) new Gson().fromJson(C0209d.m1290o2(context.getAssets().open("oobe_agreement/contry_group_config.json")), ContryGroupConfig.class);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getContryGroupConfig exception:" + e10.toString());
            return null;
        }
    }

    private String getDefaultLocalAgreement(Context context, String str, String str2) {
        try {
            return getBodyStr(C0209d.m1290o2(context.getAssets().open(OOBE_LOCAL_PATH + str + OOBE_SUB_PATH + str2 + ".htm")));
        } catch (IOException e10) {
            C11839m.m70687e(TAG, "getDefaultLocalAgreement exception:" + e10.toString());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getDefaultTmsAgreement(java.lang.String r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.String r0 = "getDefaultTmsAgreement FileInputStream close exception:"
            java.lang.String r1 = "OOBEAgreementHelper"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r5.oobeTmsPath
            r2.append(r3)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            java.lang.String r4 = "agreements"
            r2.append(r4)
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = "/b0/latest/"
            r2.append(r6)
            r2.append(r7)
            java.lang.String r6 = ".htm"
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r7 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L63 java.io.IOException -> L65
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L63 java.io.IOException -> L65
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L63 java.io.IOException -> L65
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L63 java.io.IOException -> L65
            java.lang.String r6 = p015ak.C0209d.m1290o2(r2)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            java.lang.String r5 = r5.getBodyStr(r6)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            r2.close()     // Catch: java.io.IOException -> L46
            goto L5d
        L46:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            java.lang.String r6 = r6.toString()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            p514o9.C11839m.m70687e(r1, r6)
        L5d:
            return r5
        L5e:
            r5 = move-exception
            r7 = r2
            goto L9d
        L61:
            r5 = move-exception
            goto L67
        L63:
            r5 = move-exception
            goto L9d
        L65:
            r5 = move-exception
            r2 = r7
        L67:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e
            r6.<init>()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r3 = "getDefaultTmsAgreement exception:"
            r6.append(r3)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L5e
            r6.append(r5)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L5e
            p514o9.C11839m.m70687e(r1, r5)     // Catch: java.lang.Throwable -> L5e
            if (r2 == 0) goto L9c
            r2.close()     // Catch: java.io.IOException -> L85
            goto L9c
        L85:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r5 = r5.toString()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            p514o9.C11839m.m70687e(r1, r5)
        L9c:
            return r7
        L9d:
            if (r7 == 0) goto Lba
            r7.close()     // Catch: java.io.IOException -> La3
            goto Lba
        La3:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            java.lang.String r6 = r6.toString()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            p514o9.C11839m.m70687e(r1, r6)
        Lba:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.agreement.oobe.OOBEAgreementHelper.getDefaultTmsAgreement(java.lang.String, java.lang.String):java.lang.String");
    }

    private String getTermsName() {
        String str = this.productType;
        str.hashCode();
        return !str.equals("user_agreement") ? !str.equals("privacy_statement") ? "" : "privacy-statement" : "terms";
    }

    public String getAgreement(boolean z10) throws Throwable {
        String string;
        String strM1290o2;
        C11839m.m70686d(TAG, "getAgreement, isTMS:" + z10);
        ContryGroupConfig contryGroupConfig = getContryGroupConfig(this.mContext);
        FileInputStream fileInputStream = null;
        if (contryGroupConfig == null) {
            C11839m.m70687e(TAG, "getAgreement config null");
            return null;
        }
        CountryGroupObject[] contryGroupConfig2 = contryGroupConfig.getContryGroupConfig();
        if (contryGroupConfig2.length <= 0) {
            C11839m.m70687e(TAG, "groupObjects.length 0");
            return null;
        }
        String groupNameByCountry = "";
        for (CountryGroupObject countryGroupObject : contryGroupConfig2) {
            groupNameByCountry = countryGroupObject.getGroupNameByCountry(this.country);
            if (!TextUtils.isEmpty(groupNameByCountry)) {
                break;
            }
        }
        if (TextUtils.isEmpty(groupNameByCountry)) {
            groupNameByCountry = "common";
        }
        if (TextUtils.isEmpty(this.language)) {
            C11839m.m70687e(TAG, "language is null");
            return null;
        }
        String languageCode = LanguageConfig.getLanguageCode(this.mContext, this.language.toLowerCase(Locale.US));
        if (z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.oobeTmsPath);
            String str = File.separator;
            sb2.append(str);
            sb2.append(OOBE_TMS_FILE_NAME);
            sb2.append(str);
            string = sb2.toString();
        } else {
            string = OOBE_LOCAL_PATH;
        }
        StringBuilder sb3 = new StringBuilder(string);
        sb3.append(groupNameByCountry);
        sb3.append(OOBE_SUB_PATH);
        sb3.append(getTermsName());
        if (!TextUtils.isEmpty(languageCode)) {
            sb3.append("-");
            sb3.append(languageCode);
        }
        sb3.append(".htm");
        String string2 = sb3.toString();
        try {
            try {
                if (z10) {
                    FileInputStream fileInputStream2 = new FileInputStream(new File(string2));
                    try {
                        strM1290o2 = C0209d.m1290o2(fileInputStream2);
                        fileInputStream = fileInputStream2;
                    } catch (IOException e10) {
                        e = e10;
                        fileInputStream = fileInputStream2;
                        C11839m.m70687e(TAG, "getAgreement exception:" + e.toString());
                        String agreement = this.getAgreement(z10, groupNameByCountry);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e11) {
                                C11839m.m70687e(TAG, "FileInputStream close exception:" + e11.toString());
                            }
                        }
                        return agreement;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e12) {
                                C11839m.m70687e(TAG, "FileInputStream close exception:" + e12.toString());
                            }
                        }
                        throw th;
                    }
                } else {
                    strM1290o2 = C0209d.m1290o2(this.mContext.getAssets().open(string2));
                }
                String bodyStr = getBodyStr(strM1290o2);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e13) {
                        C11839m.m70687e(TAG, "FileInputStream close exception:" + e13.toString());
                    }
                }
                return bodyStr;
            } catch (IOException e14) {
                e = e14;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public String getAgreementFromTMS() {
        C11839m.m70686d(TAG, "getAgreementFromTMS start.");
        String str = this.oobeTmsPath + File.separator + OOBE_TMS_FILE_NAME + FeedbackWebConstants.SUFFIX;
        if (!new File(str).exists()) {
            C0221j.m1509s(this.mContext);
            try {
                new C12478a(EnumC12999a.CLOUD_OOBE, null, 10000).m74915k(C11827a.m70480e(), null, str, 0L, new ServiceCallback());
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "download error: " + e10.toString());
                return null;
            }
        }
        try {
            if (!C11843q.m70899g(str, this.oobeTmsPath, false)) {
                return null;
            }
            C11839m.m70688i(TAG, "unZip success: " + str);
            return getAgreement(true);
        } catch (C1413j e11) {
            C11839m.m70687e(TAG, "unZip error: " + e11.toString());
            return null;
        }
    }

    private String getAgreement(boolean z10, String str) {
        if (z10) {
            return getDefaultTmsAgreement(str, getTermsName());
        }
        return getDefaultLocalAgreement(this.mContext, str, getTermsName());
    }
}
