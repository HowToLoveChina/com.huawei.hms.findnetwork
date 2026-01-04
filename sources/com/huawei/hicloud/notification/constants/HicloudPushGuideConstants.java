package com.huawei.hicloud.notification.constants;

import java.io.File;

/* loaded from: classes6.dex */
public class HicloudPushGuideConstants {
    public static final int GET_USER_PACEAGE_TYPE_CLAIMSPACE = 1;
    public static final int GET_USER_PACEAGE_TYPE_PUSH_GUIDE = 2;
    public static final int GET_USER_PACEAGE_TYPE_QUERY_GRADE = 3;
    public static final String HICLOUD_PUSH_GUIDE_FILEPATH = File.separator + "HiCloudPushGuide.json";
    public static final String HICLOUD_PUSH_GUIDE_LOCAL_CONFIG_FILE = "hicloud_push_guide_local.json";
    public static final String LANGUAGE_ATTRIBUTE_NAME = "name";
    public static final String LANGUAGE_ATTRIBUTE_VALUE = "value";
    public static final String LANGUAGE_HASH = "push_guide_language_hash";
    public static final String LANGUAGE_PACKAGE_NAME = "hicloud_push_guide_strings.xml";
    public static final String LANGUAGE_RESOURCE_TAG = "resource";
    public static final String LANGUAGE_TEXT_TAG = "text";
    public static final String LANGUAGE_VERSION = "push_guide_language_version";
    public static final int PUSH_GUIDE_SUB_CONSENT_COUNT = 4;

    public interface ParamDefault {
        public static final String GIF_TPACKAGE_MODE_NO = "0";
        public static final String GIF_TPACKAGE_MODE_YES = "1";
        public static final String RESTABLE_NO = "0";
        public static final String RESTABLE_YES = "1";
    }
}
