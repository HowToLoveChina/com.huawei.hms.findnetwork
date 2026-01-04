package su;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.wearengine.p2p.C8902a;
import com.huawei.wearengine.p2p.MessageParcel;
import com.huawei.wearengine.p2p.MessageParcelExtra;
import java.io.File;
import java.io.FileNotFoundException;
import org.json.JSONException;
import org.json.JSONObject;
import p558pu.C12227b;
import p752wu.C13639a;

/* renamed from: su.b */
/* loaded from: classes9.dex */
public class C12860b {
    /* renamed from: a */
    public static int m77197a(String str, String str2) {
        return Log.e("WearEngine_" + str, str2);
    }

    /* renamed from: b */
    public static int m77198b(String str, String str2, String str3, int i10) {
        StringBuilder sb2;
        String str4;
        if (TextUtils.isEmpty(str)) {
            sb2 = new StringBuilder();
            sb2.append(str2);
            str4 = " jsonString is empty";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(str3)) {
                    return jSONObject.getInt(str3);
                }
                m77205i("ClientJsonUtil", str2 + " input json not has key");
                return i10;
            } catch (JSONException unused) {
                sb2 = new StringBuilder();
                sb2.append(str2);
                str4 = " catch JSONException";
            }
        }
        sb2.append(str4);
        m77205i("ClientJsonUtil", sb2.toString());
        return i10;
    }

    /* renamed from: c */
    public static MessageParcel m77199c(C8902a c8902a) {
        File fileM56590c;
        if (c8902a == null) {
            return null;
        }
        MessageParcel messageParcel = new MessageParcel();
        int iM56591d = c8902a.m56591d();
        messageParcel.m56577p(iM56591d);
        if (iM56591d == 1) {
            messageParcel.m56572j(c8902a.m56588a());
        } else if (iM56591d == 2 && (fileM56590c = c8902a.m56590c()) != null) {
            try {
                messageParcel.m56576o(ParcelFileDescriptor.open(fileM56590c, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK));
                messageParcel.m56574m(fileM56590c.getName());
                messageParcel.m56573l(c8902a.m56589b());
                messageParcel.m56575n(C13639a.m82010d(fileM56590c));
            } catch (FileNotFoundException unused) {
                m77197a("ConvertParcelUtil", "convertToMessageParcel FileNotFoundException");
                throw new C12227b(10);
            }
        }
        return messageParcel;
    }

    /* renamed from: d */
    public static MessageParcelExtra m77200d(C8902a c8902a, MessageParcel messageParcel) throws JSONException {
        if (c8902a == null) {
            m77197a("ConvertParcelUtil", "convertToMessageParcelExtra message is null");
            return null;
        }
        if (messageParcel == null) {
            m77197a("ConvertParcelUtil", "convertToMessageParcelExtra messageParcel is null");
            return null;
        }
        MessageParcelExtra messageParcelExtra = new MessageParcelExtra();
        messageParcelExtra.m56577p(messageParcel.m56571h());
        messageParcelExtra.m56572j(messageParcel.m56566c());
        messageParcelExtra.m56576o(messageParcel.m56570g());
        messageParcelExtra.m56574m(messageParcel.m56568e());
        messageParcelExtra.m56573l(messageParcel.m56567d());
        messageParcelExtra.m56575n(messageParcel.m56569f());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message_enable_encrypt", c8902a.m56592e());
        } catch (JSONException unused) {
            m77197a("P2pJsonUtil", "buildMessageExJson JSONException");
        }
        messageParcelExtra.m56581r(jSONObject.toString());
        return messageParcelExtra;
    }

    /* renamed from: e */
    public static <T> T m77201e(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        m77197a("Preconditions", String.valueOf(obj));
        throw new C12227b(5);
    }

    /* renamed from: f */
    public static boolean m77202f(String str, String str2, String str3) {
        StringBuilder sb2;
        String str4;
        if (TextUtils.isEmpty(str)) {
            sb2 = new StringBuilder();
            sb2.append(str2);
            str4 = " jsonString is empty";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(str3)) {
                    return jSONObject.getBoolean(str3);
                }
                m77205i("ClientJsonUtil", str2 + " input json not has key");
                return false;
            } catch (JSONException unused) {
                sb2 = new StringBuilder();
                sb2.append(str2);
                str4 = " catch JSONException";
            }
        }
        sb2.append(str4);
        m77205i("ClientJsonUtil", sb2.toString());
        return false;
    }

    /* renamed from: g */
    public static int m77203g(String str, String str2) {
        return Log.i("WearEngine_" + str, str2);
    }

    /* renamed from: h */
    public static String m77204h(String str, String str2, String str3) {
        StringBuilder sb2;
        String str4;
        if (TextUtils.isEmpty(str)) {
            sb2 = new StringBuilder();
            sb2.append(str2);
            str4 = " jsonString is empty";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(str3)) {
                    return jSONObject.getString(str3);
                }
                m77205i("ClientJsonUtil", str2 + " input json not has key");
                return "";
            } catch (JSONException unused) {
                sb2 = new StringBuilder();
                sb2.append(str2);
                str4 = " catch JSONException";
            }
        }
        sb2.append(str4);
        m77205i("ClientJsonUtil", sb2.toString());
        return "";
    }

    /* renamed from: i */
    public static int m77205i(String str, String str2) {
        return Log.w("WearEngine_" + str, str2);
    }
}
