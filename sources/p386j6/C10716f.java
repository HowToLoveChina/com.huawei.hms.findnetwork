package p386j6;

import android.content.Context;
import android.text.TextUtils;
import p699v4.C13345n;

/* renamed from: j6.f */
/* loaded from: classes.dex */
public class C10716f {

    /* renamed from: a */
    public static final String[] f51361a = {"Podcasts", "Music", "Alarms", "Ringtones", "Pictures", "Notifications", "Download", "Movies", "Documents", "DCIM", "Recordings", "Audiobooks"};

    /* renamed from: a */
    public static String m65406a(Context context, String str) {
        String[] strArrM80071j = C13345n.m80071j(context);
        String str2 = strArrM80071j[0];
        String str3 = strArrM80071j[1];
        if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
            str = str.substring(str2.length());
        }
        return (TextUtils.isEmpty(str3) || !str.startsWith(str3)) ? str : str.substring(str3.length());
    }
}
