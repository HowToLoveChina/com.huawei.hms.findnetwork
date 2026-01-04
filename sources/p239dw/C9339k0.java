package p239dw;

import android.content.Context;
import android.text.TextUtils;
import aw.C1029b;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import cw.C8956a;
import cw.C8957b;
import cw.C8958c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import p857zv.C14389c;

/* renamed from: dw.k0 */
/* loaded from: classes9.dex */
public class C9339k0 {
    /* renamed from: a */
    public static void m58692a(Context context, C9338k c9338k) throws C14389c, IOException {
        String strM56705d = C8957b.m56705d("ucscomponent.jws", null, context);
        if (strM56705d == null || !new File(strM56705d).exists()) {
            throw new C14389c(1009L, "Init component from local failed, file error");
        }
        C1029b.m6234e("KeyComponentLocalHandler", "Start init data =  component through local file", new Object[0]);
        try {
            FileInputStream fileInputStream = new FileInputStream(strM56705d);
            try {
                m58693b(context, C8956a.m56701c(fileInputStream, Constants.UTF_8));
                fileInputStream.close();
            } finally {
            }
        } catch (IOException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Init data failed, msg = ");
            sbM58651a.append(e10.getMessage());
            String string = sbM58651a.toString();
            throw C9344n.m58700a("KeyComponentLocalHandler", string, new Object[0], 1009L, string);
        }
    }

    /* renamed from: b */
    public static void m58693b(Context context, String str) throws C14389c {
        try {
            C9337j0 c9337j0 = new C9337j0(str);
            C9340l.m58696c(context, c9337j0);
            UcsLib.ucsUpdateRootKey(C8958c.m56709a(c9337j0.f46739b.f46745b, 0), 32);
            C8957b.m56706e("Local-C1-Version", c9337j0.f46739b.f46744a, context);
        } catch (Throwable th2) {
            String strM56705d = C8957b.m56705d("ucscomponent.jws", null, context);
            if (TextUtils.isEmpty(strM56705d) || !new File(strM56705d).exists()) {
                C1029b.m6234e("KeyComponentLocalHandler", "tryToDeleteFile failed, file not exists.", new Object[0]);
            } else {
                try {
                    boolean zDelete = new File(strM56705d).delete();
                    C1029b.m6234e("KeyComponentLocalHandler", zDelete ? "deleteFile success." : "deleteFile failed.", new Object[0]);
                    if (zDelete) {
                        C8957b.m56707f("Last-Query-Time_ucscomponent_ucscomponent.jws", 0L, context);
                        C8957b.m56708g("ucscomponent.jws", "", context);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("ETag_");
                        sb2.append("ucscomponent");
                        C8957b.m56708g(sb2.toString(), "", context);
                        C8957b.m56708g("Last-Modified_ucscomponent", "", context);
                    }
                } catch (Throwable th3) {
                    C1029b.m6231b("KeyComponentLocalHandler", "deleteFile failed, {0}", th3.getMessage());
                }
            }
            StringBuilder sbM58651a = C9320b.m58651a("verify jws error, ");
            sbM58651a.append(th2.getMessage());
            String string = sbM58651a.toString();
            throw C9344n.m58700a("KeyComponentLocalHandler", string, new Object[0], 1012L, string);
        }
    }
}
