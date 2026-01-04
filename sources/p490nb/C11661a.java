package p490nb;

import com.huawei.android.p073ds.R$drawable;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.sync.R$string;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0209d;

/* renamed from: nb.a */
/* loaded from: classes3.dex */
public class C11661a {

    /* renamed from: a */
    public static final Map<String, Integer> f54099a = Collections.unmodifiableMap(new a());

    /* renamed from: b */
    public static final Map<String, Integer> f54100b = Collections.unmodifiableMap(new b());

    /* renamed from: nb.a$a */
    public class a extends HashMap<String, Integer> {
        public a() {
            if (C0209d.m1293p1()) {
                put(HNConstants.DataType.MEDIA, Integer.valueOf(R$drawable.ic_cloud_album_ink));
                put("calendar", Integer.valueOf(R$drawable.icon_calendar_ink));
                put("notepad", Integer.valueOf(R$drawable.ic_memorandum_ink));
                put("wlan", Integer.valueOf(R$drawable.ic_wifi_ink));
                put("browser", Integer.valueOf(R$drawable.ic_hicloud_browser_list_new_ink));
                return;
            }
            if (C0209d.m1269j1()) {
                put("addressbook", Integer.valueOf(R$drawable.ic_contacts_honor));
                put(HNConstants.DataType.MEDIA, Integer.valueOf(R$drawable.ic_cloud_album_honor));
                put("calendar", Integer.valueOf(R$drawable.icon_calendar_honor));
                put("notepad", Integer.valueOf(R$drawable.ic_memorandum_honor));
                put("wlan", Integer.valueOf(R$drawable.ic_wifi));
                put("browser", Integer.valueOf(R$drawable.ic_hicloud_browser_list_new_honor));
                return;
            }
            put("addressbook", Integer.valueOf(R$drawable.ic_contacts));
            put(HNConstants.DataType.MEDIA, Integer.valueOf(R$drawable.ic_cloud_album));
            put("calendar", Integer.valueOf(R$drawable.icon_calendar));
            put("notepad", Integer.valueOf(R$drawable.ic_memorandum));
            put("wlan", Integer.valueOf(R$drawable.ic_wifi));
            put("browser", Integer.valueOf(R$drawable.ic_hicloud_browser_list_new));
        }
    }

    /* renamed from: nb.a$b */
    public class b extends HashMap<String, Integer> {
        public b() {
            put(HNConstants.DataType.MEDIA, Integer.valueOf(R$string.gallery_item_title));
            put("addressbook", Integer.valueOf(R$string.contact));
            put("calendar", Integer.valueOf(R$string.calendar_sync_item));
            put("notepad", Integer.valueOf(R$string.notepad_app_name));
            put("wlan", Integer.valueOf(R$string.wlan_sync));
            put("browser", Integer.valueOf(R$string.browser));
        }
    }
}
