package su;

import android.text.TextUtils;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.riemann.location.common.utils.Constant;
import java.util.HashMap;
import java.util.Map;

/* renamed from: su.a */
/* loaded from: classes9.dex */
public final class C12859a {

    /* renamed from: a */
    public static Map<Integer, String> f58623a;

    static {
        HashMap map = new HashMap();
        f58623a = map;
        map.put(0, "Success");
        f58623a.put(1, "Generic error");
        f58623a.put(2, "Health app not exist");
        f58623a.put(3, "Health app not login");
        f58623a.put(4, "Health app unbound device");
        f58623a.put(5, "Invalid argument");
        f58623a.put(6, "Server remote binder is null");
        f58623a.put(7, "User unauthorized in health");
        f58623a.put(8, "Scope unauthorized");
        f58623a.put(9, "User unauthorized in wear engine");
        f58623a.put(10, "Invalid file");
        f58623a.put(11, "Too much receivers");
        f58623a.put(12, "Internal error");
        f58623a.put(13, "Device version is not supported");
        f58623a.put(14, "Health version is low");
        f58623a.put(15, "Health does not has permission to start");
        f58623a.put(16, "Device is not connected");
        f58623a.put(17, "Device uuid is invalid");
        f58623a.put(18, "Interface is not supported");
        f58623a.put(200, "Watch app not exist");
        f58623a.put(201, "Watch app not running");
        f58623a.put(202, "Watch app running");
        f58623a.put(203, "Other error");
        f58623a.put(204, "Phone app not exist");
        f58623a.put(Integer.valueOf(Constant.ERROR_ACC_GRAVITY_INVALID), "Phone app exist");
        f58623a.put(206, "Fail");
        f58623a.put(Integer.valueOf(PlayerConstants.EventCode.VIDEO_FIRST_FRAME), "Success");
        f58623a.put(300, "Sensor Watch Wear Off");
        f58623a.put(Integer.valueOf(LocationRequest.PRIORITY_MAG_POSITION), "Sensor Watch Lead Off");
        f58623a.put(302, "Sensor Watch User Stop");
        f58623a.put(303, "Sensor Watch Sensor Used");
        f58623a.put(304, "Sensor Not Abilites");
        f58623a.put(Integer.valueOf(PlayerConstants.EventCode.MEDIA_INFO_METADATA_UPDATE), "Send Offline Msg Success");
        f58623a.put(19, "Service Timeout");
        f58623a.put(20, "Power mode changing");
    }

    /* renamed from: a */
    public static int m77194a(String str) throws NumberFormatException {
        int i10;
        try {
            i10 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            C12860b.m77197a("WearEngineErrorCode", "NumberFormatException");
            i10 = 1;
        }
        if (f58623a.containsKey(Integer.valueOf(i10))) {
            return i10;
        }
        return 1;
    }

    /* renamed from: b */
    public static int m77195b(String str) {
        int iIntValue = 1;
        if (!TextUtils.isEmpty(str)) {
            for (Map.Entry<Integer, String> entry : f58623a.entrySet()) {
                if (str.equals(entry.getValue())) {
                    iIntValue = entry.getKey().intValue();
                }
            }
        }
        return iIntValue;
    }

    /* renamed from: c */
    public static String m77196c(int i10) {
        return f58623a.containsKey(Integer.valueOf(i10)) ? f58623a.get(Integer.valueOf(i10)) : "Generic error";
    }
}
