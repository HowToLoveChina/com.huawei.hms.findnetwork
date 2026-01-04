package com.huawei.hms.drive;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* renamed from: com.huawei.hms.drive.g */
/* loaded from: classes8.dex */
public class C5284g {

    /* renamed from: a */
    public static final Map<String, String> f24507a;

    static {
        HashMap map = new HashMap();
        f24507a = map;
        map.put("com.huawei.cloud.services.drive.Drive.About.Get", "12100");
        map.put("com.huawei.cloud.services.drive.Drive.Files.create", "12205");
        map.put("com.huawei.cloud.services.drive.Drive.Files.update", "12206");
        map.put("com.huawei.cloud.services.drive.Drive.Files.delete", "12207");
        map.put("com.huawei.cloud.services.drive.Drive.Files.EmptyRecycle", "12208");
        map.put("com.huawei.cloud.services.drive.Drive.Files.Copy", "12209");
        map.put("com.huawei.cloud.services.drive.Drive.Files.Get", "12211");
        map.put("com.huawei.cloud.services.drive.Drive.Files.List", "12212");
        map.put("com.huawei.cloud.services.drive.Drive.Files.Subscribe", "12213");
        map.put("com.huawei.cloud.services.drive.Drive.Changes.GetStartCursor", "12300");
        map.put("com.huawei.cloud.services.drive.Drive.Changes.List", "12301");
        map.put("com.huawei.cloud.services.drive.Drive.Changes.Subscribe", "12302");
        map.put("com.huawei.cloud.services.drive.Drive.Channels.Stop", "12400");
    }

    /* renamed from: a */
    public static String m31720a(String str) {
        if (str == null || str.isEmpty()) {
            str = "12000";
        }
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder(8);
        Random random = new Random();
        for (int i10 = 0; i10 < 8; i10++) {
            sb3.append(random.nextInt(10));
        }
        sb2.append(str);
        sb2.append("_");
        sb2.append("15");
        sb2.append("_");
        sb2.append(System.currentTimeMillis() / 1000);
        sb2.append("_");
        sb2.append((CharSequence) sb3);
        return sb2.toString();
    }

    /* renamed from: b */
    public static String m31721b(String str) {
        return (str == null || str.isEmpty()) ? "12000" : f24507a.get(str);
    }
}
