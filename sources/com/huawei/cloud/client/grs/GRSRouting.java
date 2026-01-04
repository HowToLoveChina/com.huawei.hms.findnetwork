package com.huawei.cloud.client.grs;

import android.content.Context;
import android.content.res.AssetManager;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.base.util.C4650r;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p523oi.C11903a;
import p680ui.C13183g;
import p680ui.InterfaceC13180d;

/* loaded from: classes.dex */
public class GRSRouting {

    /* renamed from: a */
    private static final C4650r f21344a = C4650r.m28485f("GRSRouting");

    /* renamed from: b */
    private static final Object f21345b = new Object();

    /* renamed from: c */
    private static volatile String f21346c;

    /* renamed from: d */
    private static volatile String f21347d;

    /* renamed from: e */
    private static volatile String f21348e;

    /* renamed from: f */
    private static C13183g f21349f;

    /* renamed from: g */
    private static Map<String, Map<String, String>> f21350g;

    static {
        HashMap map = new HashMap();
        f21350g = map;
        map.put("com.huawei.cloud.hianalytics", new HashMap());
    }

    /* renamed from: a */
    private static void m28497a(Context context) {
        try {
            C13183g c13183g = new C13183g(new File(context.getCacheDir().getPath() + "/DriveSDK"));
            f21349f = c13183g;
            InterfaceC13180d interfaceC13180dM79226b = c13183g.m79226b("DriveDomain");
            if (interfaceC13180dM79226b == null || interfaceC13180dM79226b.isEmpty()) {
                interfaceC13180dM79226b.mo79228b("DriveDomain", "primary");
                f21348e = "primary";
            } else {
                f21348e = (String) interfaceC13180dM79226b.mo79229c("DriveDomain");
            }
        } catch (IOException e10) {
            f21344a.m28489d("getDomainTypeFromStore: " + e10.toString());
        }
    }

    public static String getBackUpDomain() {
        return f21347d;
    }

    public static String getDriveURL(Context context) {
        List<String> driveURLs;
        if (f21346c == null && f21347d == null) {
            synchronized (f21345b) {
                try {
                    if (f21346c == null && f21347d == null && (driveURLs = getDriveURLs(context)) != null && !driveURLs.isEmpty() && driveURLs.size() >= 2) {
                        f21346c = driveURLs.get(0);
                        f21347d = driveURLs.get(1);
                    }
                } finally {
                }
            }
        }
        m28497a(context);
        return (C4633d0.m28404a(f21348e) || !CloudBackupConstant.Command.PMS_CMD_BACKUP.equals(f21348e)) ? f21346c : f21347d;
    }

    public static List<String> getDriveURLs(Context context) throws IOException {
        try {
            AssetManager assets = context.getAssets();
            if (assets != null) {
                return ((ServerConfig) C11903a.m71435l().m71437k(assets.open("huawei_drive_server_config.json")).m69886u(ServerConfig.class)).getDriverServer().getBaseUrl();
            }
        } catch (IOException e10) {
            f21344a.m28489d("getGlobalDriveURL: " + e10.toString());
        }
        return new ArrayList();
    }

    public static String getPrimaryDomain() {
        return f21346c;
    }
}
