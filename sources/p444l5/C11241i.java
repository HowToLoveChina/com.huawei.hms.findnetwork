package p444l5;

import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import p229di.C9142g;
import p699v4.C13347p;

/* renamed from: l5.i */
/* loaded from: classes.dex */
public class C11241i {

    /* renamed from: a */
    public static final String f52776a;

    /* renamed from: b */
    public static final String f52777b;

    /* renamed from: c */
    public static final String f52778c;

    /* renamed from: d */
    public static final String f52779d;

    /* renamed from: e */
    public static final String f52780e;

    /* renamed from: f */
    public static final String f52781f;

    /* renamed from: g */
    public static final String f52782g;

    /* renamed from: h */
    public static final String f52783h;

    /* renamed from: i */
    public static final String f52784i;

    /* renamed from: j */
    public static final String f52785j;

    /* renamed from: k */
    public static final Uri f52786k;

    /* renamed from: l */
    public static final Uri f52787l;

    /* renamed from: m */
    public static final String[] f52788m;

    /* renamed from: l5.i$a */
    public static class a {

        /* renamed from: a */
        public static final Uri f52789a = C13347p.m80080c(C11241i.f52786k, "aggregation_exceptions");

        /* renamed from: b */
        public static final HashMap<String, Integer> f52790b;

        static {
            HashMap<String, Integer> map = new HashMap<>(3);
            f52790b = map;
            map.put("type", 2);
            map.put("raw_contact_id1", 3);
            map.put("raw_contact_id2", 3);
        }

        /* renamed from: a */
        public static HashMap<String, Integer> m67547a() {
            return f52790b;
        }
    }

    /* renamed from: l5.i$b */
    public static class b {

        /* renamed from: a */
        public static final Uri f52791a = C13347p.m80080c(C11241i.f52786k, "data");

        /* renamed from: b */
        public static final HashMap<String, Integer> f52792b;

        /* renamed from: c */
        public static final HashMap<String, Integer> f52793c;

        static {
            HashMap<String, Integer> map = new HashMap<>(20);
            f52792b = map;
            HashMap<String, Integer> map2 = new HashMap<>(15);
            f52793c = map2;
            map.put("raw_contact_id", 3);
            map.put("is_primary", 2);
            map.put("is_super_primary", 2);
            map.put("mimetype", 1);
            map.put("data1", 1);
            map.put("data2", 1);
            map.put("data3", 1);
            map.put("data4", 1);
            map.put("data5", 1);
            map.put("data6", 1);
            map.put("data7", 1);
            map.put("data8", 1);
            map.put("data9", 1);
            map.put("data10", 1);
            map.put("data11", 1);
            map.put("data12", 1);
            map.put("data13", 1);
            map.put("data14", 1);
            map.put("data15", 4);
            map.put("photo_uri", 1);
            map2.put("vnd.android.cursor.item/name", 1);
            map2.put("vnd.android.cursor.item/phone_v2", 2);
            map2.put("vnd.android.cursor.item/email_v2", 3);
            map2.put("vnd.android.cursor.item/photo", 4);
            map2.put("vnd.android.cursor.item/organization", 5);
            map2.put("vnd.android.cursor.item/im", 6);
            map2.put("vnd.android.cursor.item/nickname", 7);
            map2.put("vnd.android.cursor.item/note", 8);
            map2.put("vnd.android.cursor.item/postal-address_v2", 9);
            map2.put("vnd.android.cursor.item/group_membership", 10);
            map2.put("vnd.android.cursor.item/website", 11);
            map2.put("vnd.android.cursor.item/contact_event", 12);
            map2.put("vnd.android.cursor.item/relation", 13);
            map2.put("vnd.android.cursor.item/sip_address", 14);
            map2.put(C11241i.f52778c, 15);
        }

        /* renamed from: a */
        public static HashMap<String, Integer> m67548a() {
            return f52792b;
        }

        /* renamed from: b */
        public static HashMap<String, Integer> m67549b() {
            return f52793c;
        }
    }

    /* renamed from: l5.i$c */
    public static class c {

        /* renamed from: a */
        public static final Uri f52794a = C13347p.m80080c(C11241i.f52786k, "groups");

        /* renamed from: b */
        public static final HashMap<String, Integer> f52795b;

        /* renamed from: c */
        public static final ArrayList<String> f52796c;

        static {
            HashMap<String, Integer> map = new HashMap<>(5);
            f52795b = map;
            ArrayList<String> arrayList = new ArrayList<>(3);
            f52796c = arrayList;
            map.put("_id", 3);
            map.put("title", 1);
            map.put("sync1", 1);
            map.put("is_private", 2);
            map.put("group_is_read_only", 2);
            arrayList.add("PREDEFINED_HUAWEI_GROUP_FAMILY");
            arrayList.add("PREDEFINED_HUAWEI_GROUP_FRIENDS");
            arrayList.add("PREDEFINED_HUAWEI_GROUP_WORK");
        }

        /* renamed from: a */
        public static HashMap<String, Integer> m67550a() {
            return f52795b;
        }

        /* renamed from: b */
        public static ArrayList<String> m67551b() {
            return f52796c;
        }
    }

    /* renamed from: l5.i$d */
    public static class d {

        /* renamed from: a */
        public static final Uri f52797a = C13347p.m80080c(C11241i.f52786k, "raw_contacts");

        /* renamed from: b */
        public static final HashMap<String, Integer> f52798b;

        static {
            HashMap<String, Integer> map = new HashMap<>(12);
            f52798b = map;
            map.put("_id", 3);
            map.put("account_name", 1);
            map.put("account_type", 1);
            map.put("aggregation_mode", 2);
            map.put("send_to_voicemail", 2);
            map.put("times_contacted", 2);
            map.put("last_time_contacted", 3);
            map.put("starred", 2);
            map.put("name_verified", 2);
            map.put("is_private", 2);
        }

        /* renamed from: a */
        public static HashMap<String, Integer> m67552a() {
            return f52798b;
        }
    }

    static {
        String str = C9142g.m57463b() ? "com.android.hihonor.phone" : "com.android.huawei.phone";
        f52776a = str;
        String str2 = C9142g.m57463b() ? "com.android.hihonor.social.linkedin" : "com.android.huawei.social.linkedin";
        f52777b = str2;
        f52778c = C9142g.m57463b() ? "vnd.android.cursor.item/vnd.com.hihonor.camcard.photo" : "vnd.android.cursor.item/vnd.com.huawei.camcard.photo";
        String str3 = C9142g.m57463b() ? "com.android.hihonor.sim" : "com.android.huawei.sim";
        f52779d = str3;
        String str4 = C9142g.m57463b() ? "com.android.hihonor.secondsim" : "com.android.huawei.secondsim";
        f52780e = str4;
        f52781f = str + "Phone";
        f52782g = "deleted=0 and account_id in (select _id from accounts where account_type is null or account_type in ('" + str + "') or (account_type = 'com.google'))";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(account_type is null or account_type in ('");
        sb2.append(str);
        sb2.append("'))");
        f52783h = sb2.toString();
        f52784i = "deleted=0 and account_id in (select _id from accounts where account_type is null or account_type not in ('com.tencent.mm.account', 'com.tencent.mobileqq.account','com.whatsapp','com.google.android.exchange','com.google.android.gm.exchange','com.android.exchange','com.linkedin.android','com.skype.contacts.sync','" + str2 + "','" + str3 + "', '" + str4 + "','com.skype.raider'))";
        StringBuilder sb3 = new StringBuilder();
        sb3.append("account_type is null or account_type in ('");
        sb3.append(str);
        sb3.append("', '");
        sb3.append("com.huawei.hwid");
        sb3.append("')");
        f52785j = sb3.toString();
        Uri uriM80079b = C13347p.m80079b("content://com.android.contacts");
        f52786k = uriM80079b;
        f52787l = C13347p.m80080c(uriM80079b, "profile/data");
        f52788m = new String[]{"com.android.huawei.social.linkedin", "com.linkedin.android", "com.tencent.mm.account", "com.tencent.mobileqq.account", "com.whatsapp", "com.google.android.exchange", "com.google.android.gm.exchange", "com.android.exchange", "com.skype.contacts.sync", "com.skype.raider"};
    }
}
