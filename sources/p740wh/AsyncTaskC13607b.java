package p740wh;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.AsyncTask;
import androidx.core.content.FileProvider;
import com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec;
import com.huawei.appgallery.marketinstallerservice.impl.download.MarketInstallReceiver;
import com.huawei.appgallery.marketinstallerservice.p096ui.MarketDownloadActivity;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import mh.C11469b;
import th.C13012a;

/* renamed from: wh.b */
/* loaded from: classes4.dex */
public class AsyncTaskC13607b extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a */
    public a f61206a;

    /* renamed from: b */
    public InstallParamSpec f61207b;

    /* renamed from: c */
    public String f61208c;

    /* renamed from: wh.b$a */
    public interface a {
        /* renamed from: a */
        void mo81815a(boolean z10);

        /* renamed from: b */
        Context mo81807b();
    }

    public AsyncTaskC13607b(a aVar) {
        this.f61207b = null;
        this.f61208c = "";
        this.f61206a = aVar;
    }

    /* renamed from: a */
    public static Intent m81809a(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".marketinstall.fileprovider", new File(C11469b.m68596a(context))), "application/vnd.android.package-archive");
        intent.addFlags(1);
        intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
        return intent;
    }

    /* renamed from: f */
    public static boolean m81810f(Context context) {
        try {
        } catch (Exception unused) {
            C13012a.m78318d("MarketInstallTask", "has not silent install permission Exception!");
        }
        if (context.getPackageManager().checkPermission("android.permission.INSTALL_PACKAGES", context.getPackageName()) == 0) {
            return true;
        }
        C13012a.m78318d("MarketInstallTask", "has not silent install permission!");
        return false;
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) {
        PendingIntent activity;
        a aVar = this.f61206a;
        if (aVar == null) {
            C13012a.m78317c("MarketInstallTask", "callback is null!");
        } else {
            File file = new File(C11469b.m68596a(aVar.mo81807b()));
            if (file.exists()) {
                PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(1);
                PackageInstaller packageInstaller = this.f61206a.mo81807b().getPackageManager().getPackageInstaller();
                PackageInstaller.Session sessionOpenSession = null;
                try {
                    try {
                        int iCreateSession = packageInstaller.createSession(sessionParams);
                        sessionOpenSession = packageInstaller.openSession(iCreateSession);
                        boolean zM81814e = m81814e(file, sessionOpenSession);
                        if (zM81814e) {
                            InstallParamSpec installParamSpec = this.f61207b;
                            if (installParamSpec == null || !installParamSpec.isSilentDownload()) {
                                activity = PendingIntent.getActivity(this.f61206a.mo81807b(), iCreateSession, new Intent(this.f61206a.mo81807b(), (Class<?>) MarketDownloadActivity.class), HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
                            } else {
                                Intent intent = new Intent(this.f61206a.mo81807b(), (Class<?>) MarketInstallReceiver.class);
                                intent.putExtra("callback_key", this.f61208c);
                                activity = PendingIntent.getBroadcast(this.f61206a.mo81807b(), iCreateSession, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
                            }
                            sessionOpenSession.commit(activity.getIntentSender());
                        }
                        Boolean boolValueOf = Boolean.valueOf(zM81814e);
                        if (sessionOpenSession != null) {
                            sessionOpenSession.close();
                        }
                        return boolValueOf;
                    } catch (Exception unused) {
                        C13012a.m78317c("MarketInstallTask", "start install Exception!");
                        Boolean bool = Boolean.FALSE;
                        if (sessionOpenSession != null) {
                            sessionOpenSession.close();
                        }
                        return bool;
                    }
                } catch (Throwable th2) {
                    if (sessionOpenSession != null) {
                        sessionOpenSession.close();
                    }
                    throw th2;
                }
            }
            C13012a.m78318d("MarketInstallTask", "download file is empty!");
        }
        return Boolean.FALSE;
    }

    /* renamed from: c */
    public final void m81812c(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
                C13012a.m78318d("MarketInstallTask", "fis close Exception");
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused2) {
                C13012a.m78318d("MarketInstallTask", "fos close Exception");
            }
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        C13012a.m78318d("MarketInstallTask", "start install task result:" + bool);
        a aVar = this.f61206a;
        if (aVar != null) {
            aVar.mo81815a(bool.booleanValue());
        }
    }

    /* renamed from: e */
    public final boolean m81814e(File file, PackageInstaller.Session session) throws Throwable {
        OutputStream outputStream;
        FileInputStream fileInputStream;
        byte[] bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
        FileInputStream fileInputStream2 = null;
        outputStreamOpenWrite = null;
        OutputStream outputStreamOpenWrite = null;
        fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException e10) {
            e = e10;
            outputStream = null;
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
        try {
            outputStreamOpenWrite = session.openWrite("MarketInstallService", 0L, file.length());
            while (true) {
                int i10 = fileInputStream.read(bArr);
                if (i10 == -1) {
                    session.fsync(outputStreamOpenWrite);
                    m81812c(fileInputStream, outputStreamOpenWrite);
                    return true;
                }
                outputStreamOpenWrite.write(bArr, 0, i10);
            }
        } catch (IOException e11) {
            e = e11;
            outputStream = outputStreamOpenWrite;
            fileInputStream2 = fileInputStream;
            try {
                C13012a.m78316b("MarketInstallTask", "copyApk apk error", e);
                m81812c(fileInputStream2, outputStream);
                return false;
            } catch (Throwable th3) {
                th = th3;
                m81812c(fileInputStream2, outputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStream = outputStreamOpenWrite;
            fileInputStream2 = fileInputStream;
            m81812c(fileInputStream2, outputStream);
            throw th;
        }
    }

    public AsyncTaskC13607b(a aVar, InstallParamSpec installParamSpec, String str) {
        this.f61206a = aVar;
        this.f61207b = installParamSpec;
        this.f61208c = str;
    }
}
