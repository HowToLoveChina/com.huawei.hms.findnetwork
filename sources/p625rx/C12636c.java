package p625rx;

import android.util.ArrayMap;
import com.huawei.ohos.localability.R$string;
import java.util.ArrayList;
import java.util.List;

/* renamed from: rx.c */
/* loaded from: classes9.dex */
public class C12636c {

    /* renamed from: a */
    public static ArrayMap<String, String> f58083a;

    /* renamed from: b */
    public static ArrayMap<String, Integer> f58084b;

    /* renamed from: c */
    public static List<String> f58085c;

    /* renamed from: d */
    public static ArrayMap<String, Integer> f58086d;

    static {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        f58083a = arrayMap;
        arrayMap.put("ohos.permission.READ_CONTACTS", "android.permission-group.CONTACTS");
        f58083a.put("ohos.permission.WRITE_CONTACTS", "android.permission-group.CONTACTS");
        f58083a.put("ohos.permission.GET_APP_ACCOUNTS", "android.permission-group.CONTACTS");
        f58083a.put("ohos.permission.READ_CALENDAR", "android.permission-group.CALENDAR");
        f58083a.put("ohos.permission.WRITE_CALENDAR", "android.permission-group.CALENDAR");
        f58083a.put("ohos.permission.SEND_MESSAGES", "android.permission-group.SMS");
        f58083a.put("ohos.permission.RECEIVE_SMS", "android.permission-group.SMS");
        f58083a.put("ohos.permission.READ_MESSAGES", "android.permission-group.SMS");
        f58083a.put("ohos.permission.RECEIVE_MMS", "android.permission-group.SMS");
        f58083a.put("ohos.permission.RECEIVE_WAP_MESSAGES", "android.permission-group.SMS");
        f58083a.put("ohos.permission.READ_CELL_MESSAGES", "android.permission-group.SMS");
        f58083a.put("ohos.permission.READ_USER_STORAGE", "android.permission-group.STORAGE");
        f58083a.put("ohos.permission.WRITE_USER_STORAGE", "android.permission-group.STORAGE");
        f58083a.put("ohos.permission.MEDIA_LOCATION", "android.permission-group.STORAGE");
        f58083a.put("ohos.permission.LOCATION", "android.permission-group.LOCATION");
        f58083a.put("ohos.permission.LOCATION_IN_BACKGROUND", "android.permission-group.LOCATION");
        f58083a.put("ohos.permission.READ_CALL_LOG", "android.permission-group.CALL_LOG");
        f58083a.put("ohos.permission.WRITE_CALL_LOG", "android.permission-group.CALL_LOG");
        f58083a.put("ohos.permission.MANAGE_VOICEMAIL", "android.permission-group.PHONE");
        f58083a.put("ohos.permission.ANSWER_CALL", "android.permission-group.PHONE");
        f58083a.put("ohos.permission.CALL_TRANSFER", "android.permission-group.PHONE");
        f58083a.put("ohos.permission.PLACE_CALL", "android.permission-group.PHONE");
        f58083a.put("ohos.permission.GET_PRIVILEGED_PHONE_STATE", "android.permission-group.PHONE");
        f58083a.put("ohos.permission.GET_PHONE_STATE", "android.permission-group.PHONE");
        f58083a.put("ohos.permission.MICROPHONE", "android.permission-group.MICROPHONE");
        f58083a.put("ohos.permission.ACTIVITY_MOTION", "android.permission-group.ACTIVITY_RECOGNITION");
        f58083a.put("ohos.permission.CAMERA", "android.permission-group.CAMERA");
        f58083a.put("ohos.permission.READ_HEALTH_DATA", "android.permission-group.SENSORS");
        ArrayList arrayList = new ArrayList();
        f58085c = arrayList;
        arrayList.add("android.permission-group.STORAGE");
        f58085c.add("android.permission-group.PHONE");
        f58085c.add("android.permission-group.LOCATION");
        f58085c.add("android.permission-group.CAMERA");
        f58085c.add("android.permission-group.MICROPHONE");
        f58085c.add("android.permission-group.ACTIVITY_RECOGNITION");
        f58085c.add("android.permission-group.CONTACTS");
        f58085c.add("android.permission-group.SMS");
        f58085c.add("android.permission-group.CALL_LOG");
        f58085c.add("android.permission-group.CALENDAR");
        f58085c.add("android.permission-group.SENSORS");
        ArrayMap<String, Integer> arrayMap2 = new ArrayMap<>();
        f58084b = arrayMap2;
        arrayMap2.put("android.permission-group.CONTACTS", Integer.valueOf(R$string.permission_contacts));
        f58084b.put("android.permission-group.CALENDAR", Integer.valueOf(R$string.permission_calender));
        f58084b.put("android.permission-group.SMS", Integer.valueOf(R$string.permission_message));
        f58084b.put("android.permission-group.STORAGE", Integer.valueOf(R$string.permission_storage));
        f58084b.put("android.permission-group.LOCATION", Integer.valueOf(R$string.permission_location));
        f58084b.put("android.permission-group.CALL_LOG", Integer.valueOf(R$string.permission_calllog));
        f58084b.put("android.permission-group.PHONE", Integer.valueOf(R$string.permission_phone));
        f58084b.put("android.permission-group.MICROPHONE", Integer.valueOf(R$string.permission_mircophone));
        f58084b.put("android.permission-group.ACTIVITY_RECOGNITION", Integer.valueOf(R$string.permission_physical));
        f58084b.put("android.permission-group.CAMERA", Integer.valueOf(R$string.permission_camera));
        f58084b.put("android.permission-group.SENSORS", Integer.valueOf(R$string.permission_sensors));
        ArrayMap<String, Integer> arrayMap3 = new ArrayMap<>();
        f58086d = arrayMap3;
        arrayMap3.put("ohos.permission.MANAGE_VOICEMAIL", Integer.valueOf(R$string.permission_voicemail));
        f58086d.put("ohos.permission.ANSWER_CALL", Integer.valueOf(R$string.permission_phone_answer));
        f58086d.put("ohos.permission.CALL_TRANSFER", Integer.valueOf(R$string.permission_phone_continue));
        f58086d.put("ohos.permission.PLACE_CALL", Integer.valueOf(R$string.permission_phone_call));
        ArrayMap<String, Integer> arrayMap4 = f58086d;
        int i10 = R$string.permission_phone_read_info;
        arrayMap4.put("ohos.permission.GET_PRIVILEGED_PHONE_STATE", Integer.valueOf(i10));
        f58086d.put("ohos.permission.GET_PHONE_STATE", Integer.valueOf(i10));
    }

    /* renamed from: a */
    public static List<String> m76171a() {
        return f58085c;
    }
}
