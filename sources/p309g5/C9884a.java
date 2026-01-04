package p309g5;

import com.huawei.android.backup.service.logic.calendar.CalendarConfigTable;
import java.util.HashMap;

/* renamed from: g5.a */
/* loaded from: classes.dex */
public class C9884a {

    /* renamed from: a */
    public static final HashMap<String, Integer> f48516a;

    static {
        HashMap<String, Integer> map = new HashMap<>(13);
        f48516a = map;
        map.put("hour", 2);
        map.put(CalendarConfigTable.CalendarTable.Reminds.MINUTES, 2);
        map.put("daysofweek", 2);
        map.put("alarmtime", 3);
        map.put("enabled", 5);
        map.put("vibrate", 5);
        map.put("volume", 2);
        map.put("message", 1);
        map.put("alert", 1);
        map.put("daysofweektype", 2);
        map.put("ringduration", 2);
        map.put("snoozeduration", 2);
        map.put("snoozetimes", 2);
        map.put("allow_skip", 2);
    }

    /* renamed from: a */
    public static HashMap<String, Integer> m61336a() {
        return f48516a;
    }
}
