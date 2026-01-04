package p249e6;

import android.net.Uri;
import java.util.HashMap;
import p229di.C9142g;
import p699v4.C13347p;

/* renamed from: e6.a */
/* loaded from: classes.dex */
public class C9415a {

    /* renamed from: a */
    public static final String f47051a;

    /* renamed from: b */
    public static final Uri f47052b;

    /* renamed from: e6.a$a */
    public static class a {

        /* renamed from: a */
        public static final Uri f47053a = C13347p.m80080c(C9415a.f47052b, "cityInfo");

        /* renamed from: b */
        public static final HashMap<String, Integer> f47054b;

        static {
            HashMap<String, Integer> map = new HashMap<>(12);
            f47054b = map;
            map.put("_id", 2);
            map.put("city_name", 1);
            map.put("city_alias", 1);
            map.put("city_native", 1);
            map.put("state_name", 1);
            map.put("city_code", 1);
            map.put("city_type", 2);
            map.put("time_zone", 1);
            map.put("insert_time", 3);
            map.put("weather_id", 2);
            map.put("manual_set", 2);
            map.put("home_city", 2);
        }

        /* renamed from: a */
        public static HashMap<String, Integer> m59043a() {
            return f47054b;
        }
    }

    /* renamed from: e6.a$b */
    public static class b {

        /* renamed from: a */
        public static final Uri f47055a = C13347p.m80080c(C9415a.f47052b, "settingsInfo");

        /* renamed from: b */
        public static final HashMap<String, Integer> f47056b;

        static {
            HashMap<String, Integer> map = new HashMap<>(3);
            f47056b = map;
            map.put("update_interval", 1);
            map.put("auto_update", 2);
            map.put("temp_unit", 1);
        }

        /* renamed from: a */
        public static HashMap<String, Integer> m59044a() {
            return f47056b;
        }
    }

    /* renamed from: e6.a$c */
    public static class c {

        /* renamed from: a */
        public static final Uri f47057a = C13347p.m80080c(C9415a.f47052b, "weatherDayInfo");

        /* renamed from: b */
        public static final HashMap<String, Integer> f47058b;

        static {
            HashMap<String, Integer> map = new HashMap<>(20);
            f47058b = map;
            map.put("weather_info_id", 2);
            map.put("day_index", 1);
            map.put("obs_date", 3);
            map.put("day_code", 1);
            map.put("sun_rise_time", 3);
            map.put("sun_set_time", 3);
            map.put("high_temp", 6);
            map.put("low_temp", 6);
            map.put("weather_icon", 2);
            map.put("wind_speed", 2);
            map.put("wind_direction", 1);
            map.put("text_short", 1);
            map.put("text_long", 1);
            map.put("night_high_temp", 6);
            map.put("night_low_temp", 6);
            map.put("night_weather_icon", 2);
            map.put("night_wind_speed", 2);
            map.put("night_wind_direction", 1);
            map.put("night_text_short", 1);
            map.put("night_text_long", 1);
        }

        /* renamed from: a */
        public static HashMap<String, Integer> m59045a() {
            return f47058b;
        }
    }

    /* renamed from: e6.a$d */
    public static class d {

        /* renamed from: a */
        public static final Uri f47059a = C13347p.m80080c(C9415a.f47052b, "weatherInfo");

        /* renamed from: b */
        public static final HashMap<String, Integer> f47060b;

        static {
            HashMap<String, Integer> map = new HashMap<>(12);
            f47060b = map;
            map.put("_id", 2);
            map.put("status", 2);
            map.put("city_code", 1);
            map.put("time_zone", 1);
            map.put("update_time", 3);
            map.put("isday_light", 2);
            map.put("temperature", 6);
            map.put("weather_icon", 2);
            map.put("weather_text", 1);
            map.put("observation_time", 3);
            map.put("wind_speed", 2);
            map.put("wind_direction", 1);
        }

        /* renamed from: a */
        public static HashMap<String, Integer> m59046a() {
            return f47060b;
        }
    }

    static {
        String str = C9142g.m57463b() ? "com.hihonor.android.weather" : "com.huawei.android.weather";
        f47051a = str;
        f47052b = C13347p.m80079b("content://" + str + "/");
    }
}
