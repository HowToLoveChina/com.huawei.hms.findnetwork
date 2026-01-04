package com.huawei.cloud.services.drive;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public class DriveScopes {
    public static final String SCOPE_DRIVE = "https://www.huawei.com/auth/drive";
    public static final String SCOPE_DRIVE_APPDATA = "https://www.huawei.com/auth/drive.appdata";
    public static final String SCOPE_DRIVE_FILE = "https://www.huawei.com/auth/drive.file";
    public static final String SCOPE_DRIVE_METADATA = "https://www.huawei.com/auth/drive.metadata";
    public static final String SCOPE_DRIVE_METADATA_READONLY = "https://www.huawei.com/auth/drive.metadata.readonly";
    public static final String SCOPE_DRIVE_READONLY = "https://www.huawei.com/auth/drive.readonly";

    private DriveScopes() {
    }

    public static Set<String> all() {
        HashSet hashSet = new HashSet();
        hashSet.add(SCOPE_DRIVE);
        hashSet.add(SCOPE_DRIVE_FILE);
        hashSet.add(SCOPE_DRIVE_METADATA);
        hashSet.add(SCOPE_DRIVE_METADATA_READONLY);
        hashSet.add(SCOPE_DRIVE_READONLY);
        hashSet.add(SCOPE_DRIVE_APPDATA);
        return Collections.unmodifiableSet(hashSet);
    }
}
