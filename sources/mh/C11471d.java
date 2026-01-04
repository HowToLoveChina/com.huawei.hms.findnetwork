package mh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.appgallery.marketinstallerservice.api.BaseParamSpec;
import com.huawei.appgallery.marketinstallerservice.api.FailResultParam;
import com.huawei.appgallery.marketinstallerservice.api.InstallCallback;
import com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.RequestBean;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.ResponseBean;
import com.huawei.appgallery.marketinstallerservice.p094a.p095e.C4570a;
import com.huawei.appgallery.marketinstallerservice.p096ui.MarketDownloadActivity;
import java.util.ArrayList;
import p492nh.C11705a;
import p740wh.C13608c;
import p775xh.InterfaceC13814b;
import ph.C12141a;
import th.C13012a;

/* renamed from: mh.d */
/* loaded from: classes4.dex */
public class C11471d implements InterfaceC11470c {

    /* renamed from: mh.d$a */
    public static class a implements InterfaceC13814b {

        /* renamed from: a */
        public InstallCallback f53365a;

        public a(InstallCallback installCallback) {
            this.f53365a = installCallback;
        }

        @Override // p775xh.InterfaceC13814b
        /* renamed from: a */
        public void mo68599a(RequestBean requestBean, ResponseBean responseBean) {
        }

        @Override // p775xh.InterfaceC13814b
        /* renamed from: b */
        public void mo68600b(RequestBean requestBean, ResponseBean responseBean) {
            if (this.f53365a == null) {
                C13012a.m78317c("MarketInstallApiImpl", "callback is null!");
                return;
            }
            if (!(responseBean instanceof C11705a)) {
                C13012a.m78317c("MarketInstallApiImpl", "get Market info error!");
                return;
            }
            if (responseBean.getResponseCode() == 0 && responseBean.getRtnCode() == 0) {
                this.f53365a.onSuccess(((C11705a) responseBean).getHiAppInfo());
                return;
            }
            C13012a.m78317c("MarketInstallApiImpl", "get Market info error: responseCode:" + responseBean.getResponseCode() + ", rtnCode:" + responseBean.getRtnCode());
            FailResultParam failResultParam = new FailResultParam();
            failResultParam.setResult(-4);
            failResultParam.setResponseCode(responseBean.getResponseCode());
            failResultParam.setRtnCode(responseBean.getRtnCode());
            this.f53365a.onFailed(failResultParam);
        }
    }

    @Override // mh.InterfaceC11470c
    /* renamed from: a */
    public void mo68597a(Activity activity, InstallParamSpec installParamSpec, InstallCallback installCallback) {
        if (installParamSpec.isSilentDownload()) {
            C13012a.m78318d("MarketInstallApiImpl", "start silent download market!");
            new C13608c(activity, installParamSpec, installCallback).m81817a();
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) MarketDownloadActivity.class);
        intent.putExtra("callback_key", C11468a.m68591b(installCallback));
        MarketInfo marketInfo = installParamSpec.getMarketInfo();
        if (marketInfo != null) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(marketInfo);
            intent.putParcelableArrayListExtra("market_info_key", arrayList);
        } else {
            String serverUrl = installParamSpec.getServerUrl();
            String subsystem = installParamSpec.getSubsystem();
            String marketPkg = installParamSpec.getMarketPkg();
            boolean zIsUpdate = installParamSpec.isUpdate();
            intent.putExtra("service_url_key", serverUrl);
            intent.putExtra("sub_system_key", subsystem);
            intent.putExtra("market_pkg_key", marketPkg);
            intent.putExtra("is_update_key", zIsUpdate);
        }
        intent.putExtra("fail_result_type_key", installParamSpec.getFailResultPromptType());
        activity.startActivity(intent);
    }

    @Override // mh.InterfaceC11470c
    /* renamed from: b */
    public void mo68598b(Context context, BaseParamSpec baseParamSpec, InstallCallback installCallback) {
        C4570a c4570aNewInstance = C4570a.newInstance(context);
        c4570aNewInstance.setServiceUrl(baseParamSpec.getServerUrl());
        c4570aNewInstance.setSubsystem(baseParamSpec.getSubsystem());
        c4570aNewInstance.setMarketPkg(baseParamSpec.getMarketPkg());
        C12141a.m72779b(c4570aNewInstance, new a(installCallback));
    }
}
