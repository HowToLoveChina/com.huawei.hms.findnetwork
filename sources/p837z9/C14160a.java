package p837z9;

import android.app.job.JobParameters;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import com.huawei.android.hicloud.commonlib.jobscheduler.CommonJobCallBack;
import p011aa.C0081a;
import p514o9.C11839m;
import p616rk.C12515a;
import p709vj.C13452e;

/* renamed from: z9.a */
/* loaded from: classes3.dex */
public class C14160a implements CommonJobCallBack {
    @Override // com.huawei.android.hicloud.commonlib.jobscheduler.CommonJobCallBack
    /* renamed from: a */
    public boolean mo15902a(Context context, Handler handler, JobParameters jobParameters) {
        if (jobParameters == null) {
            C11839m.m70687e("AllowStatusReportJobCallback", "onStartJob params is null");
            return true;
        }
        int jobId = jobParameters.getJobId();
        C11839m.m70689w("AllowStatusReportJobCallback", "onStartJob job id is " + jobId);
        if (jobId == 4) {
            if (C13452e.m80781L().m80842P0()) {
                PersistableBundle extras = jobParameters.getExtras();
                int i10 = extras.containsKey("retryTime") ? extras.getInt("retryTime", 0) : 0;
                C11839m.m70689w("AllowStatusReportJobCallback", "onStartJob retryTime is " + i10);
                C12515a.m75110o().m75172d(new C0081a(1, i10));
            }
            if (handler != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = jobParameters;
                messageObtain.what = 4;
                handler.sendMessage(messageObtain);
            }
        }
        return true;
    }
}
