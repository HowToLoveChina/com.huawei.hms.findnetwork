package com.huawei.hicloud.model;

import android.os.Build;

/* loaded from: classes6.dex */
public class AccountConstant {
    public static final String DEVICE_NAME = "HUAWEI" + Build.MODEL;

    public static class ATInfo {
        public static final String SP_NAME = "ATInfo";
    }

    public static class Cmd {
        public static final String AUTH_CODE_SHA256_REPORT = "auth_code_sha256_report";
        public static final String CLEAR_AT_EXPIRE_TIME = "clearAtExpireTime";
        public static final String CLEAR_SMS_INFO = "clearSMSInfo";
        public static final String ENCRYPT_SMS_LOGIN_INFO = "encryptSMSLoginInfo";
        public static final String GET_SIGNATURE = "getSignature";
        public static final String SMS_LOGIN = "/userauth/v1/login";
        public static final String SMS_REFRESH = "/userauth/v1/refresh";
    }

    public static class Err {
        public static final int AT_FAILED = 3;
        public static final int PARAM_ERROR = 2;
        public static final int PARSE_FAILED = 4;
        public static final int SERVER_ERROR = 1;
        public static final int SMS_SERVICE_FAILED_APP_NOT_AUTHORIZED = 4012;
        public static final int SMS_SERVICE_FAILED_SESSION_TIME_OUT = 4016;
        public static final int SMS_SERVICE_SIGNATURE_EXPIRED = 4018;
        public static final int SUCCESS = 0;
    }
}
