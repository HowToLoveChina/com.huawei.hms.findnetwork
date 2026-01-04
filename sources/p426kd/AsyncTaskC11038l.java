package p426kd;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.hicloud.base.bean.ModuleItem;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import fk.C9721b;
import gp.C10028c;
import java.util.List;
import je.C10777a0;
import ke.C11046a;
import p015ak.C0209d;
import p458lo.C11322a;
import p514o9.C11839m;
import p516ob.C11845a;

/* renamed from: kd.l */
/* loaded from: classes3.dex */
public class AsyncTaskC11038l extends AsyncTask<Void, Void, List<ModuleItem>> {

    /* renamed from: d */
    public static AsyncTaskC11038l f52165d;

    /* renamed from: e */
    public static final String[] f52166e = new String[0];

    /* renamed from: a */
    public String f52167a;

    /* renamed from: b */
    public Context f52168b;

    /* renamed from: c */
    public Messenger f52169c;

    public AsyncTaskC11038l(Context context, Messenger messenger) {
        this.f52168b = context;
        this.f52169c = messenger;
    }

    /* renamed from: b */
    public static AsyncTaskC11038l m66556b(Context context, Messenger messenger) {
        if (f52165d == null || AsyncTask.Status.FINISHED.equals(f52165d.getStatus())) {
            f52165d = new AsyncTaskC11038l(context, messenger);
        } else {
            AsyncTaskC11038l asyncTaskC11038l = f52165d;
            if (messenger != asyncTaskC11038l.f52169c) {
                asyncTaskC11038l.f52169c = messenger;
            }
        }
        return f52165d;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<ModuleItem> doInBackground(Void... voidArr) {
        try {
            return m66558c(new C11322a().m68004K(), "recording");
        } catch (Exception unused) {
            C11839m.m70686d("GetRecordingTask", "cbs queryDevice exception");
            return null;
        }
    }

    /* renamed from: c */
    public final List<ModuleItem> m66558c(List<CBSDevice> list, String str) throws C9721b {
        return C10028c.m62182c0().m62420y1() ? C10777a0.m65616c(list, this.f52167a, "GetRecordingTask", this.f52168b) : C10777a0.m65617d(list, this.f52167a, "GetRecordingTask", this.f52168b);
    }

    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<ModuleItem> list) throws RemoteException {
        Message message = new Message();
        message.what = PlayerConstants.ErrorCode.SWITCH_PLAYMODE_NORMAL_FAILED;
        if (list == null || (list.isEmpty() && !C0209d.m1208S0(this.f52168b))) {
            message.arg1 = -5;
        } else {
            message.arg1 = 0;
            if (!CloudSyncUtil.m16016i0(this.f52167a) && !CloudSyncUtil.m16007f0()) {
                C11845a.m70908E("recordig", list);
                C11845a.m70937x(this.f52167a, Long.valueOf(System.currentTimeMillis()));
            }
        }
        C11046a.m66596d(this.f52169c, message);
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        this.f52167a = "autorecordingkey";
    }
}
