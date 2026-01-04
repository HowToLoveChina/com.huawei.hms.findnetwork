package ke;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import p514o9.C11839m;

/* renamed from: ke.a */
/* loaded from: classes3.dex */
public class C11046a {
    /* renamed from: a */
    public static boolean m66593a(Handler.Callback callback, int i10, int i11, int i12, Object obj) {
        if (callback == null) {
            return false;
        }
        return callback.handleMessage(Message.obtain(null, i10, i11, i12, obj));
    }

    /* renamed from: b */
    public static boolean m66594b(Handler.Callback callback, Message message) {
        if (callback == null) {
            return false;
        }
        return callback.handleMessage(Message.obtain(message));
    }

    /* renamed from: c */
    public static Message m66595c(long j10, String str, boolean z10) {
        Message messageObtain = Message.obtain();
        if (z10) {
            messageObtain.what = 1002;
        } else {
            messageObtain.what = FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("totalSize", j10);
        bundle.putString("moduleName", str);
        bundle.putBoolean("isBackupOpr", z10);
        messageObtain.setData(bundle);
        return messageObtain;
    }

    /* renamed from: d */
    public static void m66596d(Messenger messenger, Message message) throws RemoteException {
        if (messenger != null) {
            try {
                messenger.send(message);
            } catch (RemoteException e10) {
                C11839m.m70687e("MessageUtil", "Messenger send message fail:" + e10.toString());
            }
        }
    }
}
