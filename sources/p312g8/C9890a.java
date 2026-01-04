package p312g8;

import android.os.Bundle;
import android.os.Message;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import p031b7.C1120a;

/* renamed from: g8.a */
/* loaded from: classes2.dex */
public class C9890a {

    /* renamed from: a */
    public static HashMap<String, StringBuilder> f48537a = new HashMap<>();

    /* renamed from: a */
    public static String m61363a(int i10) {
        Random random = new Random();
        StringBuilder sb2 = new StringBuilder(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("0123456789qwertyuiopasdfghjklzxcvbnm".charAt(random.nextInt(36)));
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static Bundle m61364b(String str, boolean z10, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("HashKey", str);
        bundle.putBoolean("SliceFlag", true);
        bundle.putBoolean("SliceEndFlag", z10);
        bundle.putString("SliceData", str2);
        return bundle;
    }

    /* renamed from: c */
    public static Message m61365c(int i10, Bundle bundle) {
        Message message = new Message();
        message.what = i10;
        message.arg1 = 9202;
        message.obj = bundle;
        return message;
    }

    /* renamed from: d */
    public static Message[] m61366d(Message message) {
        if (message == null) {
            C1120a.m6676e("ApplyBatch", "Input params msg is null!");
            return new Message[0];
        }
        Bundle[] bundleArrM61367e = m61367e(message.what, (Bundle) message.obj);
        int length = bundleArrM61367e.length;
        Message[] messageArr = new Message[length];
        for (int i10 = 0; i10 < length; i10++) {
            messageArr[i10] = m61365c(message.what, bundleArrM61367e[i10]);
        }
        return messageArr;
    }

    /* renamed from: e */
    public static Bundle[] m61367e(int i10, Bundle bundle) {
        if (bundle == null) {
            C1120a.m6676e("ApplyBatch", "getSlices input params bundle is null!");
            return new Bundle[0];
        }
        boolean z10 = bundle.getBoolean("SliceFlag", false);
        String string = z10 ? bundle.getString("HashKey") : m61363a(6) + i10;
        String string2 = z10 ? bundle.getString("SliceData") : C9893d.m61374a(bundle, "$$ClassName$$");
        if (string2 == null || string2.isEmpty()) {
            C1120a.m6676e("ApplyBatch", "get or serialize bundle error!");
            return new Bundle[0];
        }
        ArrayList arrayList = new ArrayList();
        if (string2.length() <= 102400) {
            arrayList.add(string2);
        } else {
            int length = string2.length();
            int length2 = string2.length();
            int i11 = 0;
            int length3 = 102400;
            while (length > 0) {
                arrayList.add(string2.substring(i11, length3));
                length = length2 - length3;
                int i12 = length3;
                length3 = length > 102400 ? length3 + Constants.GIF_SIZE_UPPER_LIMIT_KB : string2.length();
                i11 = i12;
            }
        }
        Bundle[] bundleArr = new Bundle[arrayList.size()];
        for (int i13 = 0; i13 < arrayList.size() - 1; i13++) {
            bundleArr[i13] = m61364b(string, false, (String) arrayList.get(i13));
        }
        bundleArr[arrayList.size() - 1] = m61364b(string, !z10 || bundle.getBoolean("SliceEndFlag"), (String) arrayList.get(arrayList.size() - 1));
        return bundleArr;
    }
}
