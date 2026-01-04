package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import cn.C1461a;
import com.google.gson.Gson;
import com.huawei.hicloud.bean.WebViewAllowBean;
import com.huawei.hicloud.notification.manager.HiCloudWebViewPolicyManager;
import com.huawei.hicloud.notification.task.HiCloudWebViewConfigTask;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import mu.C11526c;
import p015ak.C0209d;
import p015ak.C0213f;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class HiCloudWebViewPolicyManager {
    private static final int CONTROL_TYPE_HOST = 0;
    private static final int CONTROL_TYPE_PATH = 1;
    private static final String TAG = "HiCloudWebViewPolicyManager";
    private List<WebViewAllowBean.Configuration.Policy> policyList;
    private String[] urlArray;
    private WebViewAllowBean webViewAllowBean;

    /* renamed from: com.huawei.hicloud.notification.manager.HiCloudWebViewPolicyManager$1 */
    public class C49311 extends AbstractC12367d {
        public C49311() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$call$0(List list, String str) {
            if (StringUtil.isBlank(str)) {
                return;
            }
            list.add(str);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b, IOException {
            Context contextM1378b = C0213f.m1378b();
            if (contextM1378b == null) {
                C1461a.m8358e(HiCloudWebViewPolicyManager.TAG, "reloadParseLocalFile, context is null");
                return;
            }
            File file = new File(contextM1378b.getFilesDir() + "/HiCloudWebViewAllownlist.json");
            if (!file.exists()) {
                C1461a.m8358e(HiCloudWebViewPolicyManager.TAG, "webview config file is not existed.");
                HiCloudWebViewPolicyManager.this.checkAndDownWebViewConfig();
                return;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    HiCloudWebViewPolicyManager.this.webViewAllowBean = (WebViewAllowBean) new Gson().fromJson(C0209d.m1290o2(fileInputStream), WebViewAllowBean.class);
                    HiCloudWebViewPolicyManager.this.policyList = new ArrayList(HiCloudWebViewPolicyManager.this.webViewAllowBean.getConfigurations().getPolicyList());
                    final ArrayList arrayList = new ArrayList();
                    HiCloudWebViewPolicyManager.this.webViewAllowBean.getConfigurations().getAllowList().stream().map(new Function() { // from class: com.huawei.hicloud.notification.manager.k
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return ((WebViewAllowBean.Configuration.Allow) obj).getUrl();
                        }
                    }).forEach(new Consumer() { // from class: com.huawei.hicloud.notification.manager.l
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            HiCloudWebViewPolicyManager.C49311.lambda$call$0(arrayList, (String) obj);
                        }
                    });
                    HiCloudWebViewPolicyManager.this.urlArray = (String[]) arrayList.toArray(new String[0]);
                    fileInputStream.close();
                } finally {
                }
            } catch (Exception e10) {
                C1461a.m8358e(HiCloudWebViewPolicyManager.TAG, "reloadParseLocalFile failed: " + e10.getMessage());
            }
        }
    }

    public static class HiCloudWebViewManagerHolder {
        protected static HiCloudWebViewPolicyManager instance = new HiCloudWebViewPolicyManager(null);

        private HiCloudWebViewManagerHolder() {
        }
    }

    public /* synthetic */ HiCloudWebViewPolicyManager(C49311 c49311) {
        this();
    }

    public static HiCloudWebViewPolicyManager getInstance() {
        return HiCloudWebViewManagerHolder.instance;
    }

    private WebViewAllowBean.Configuration.Policy getPolicy(String str) {
        for (WebViewAllowBean.Configuration.Policy policy : this.policyList) {
            String interfaceList = policy.getInterfaceList();
            if (!TextUtils.isEmpty(interfaceList) && Arrays.asList(interfaceList.split(",")).contains(str)) {
                return policy;
            }
        }
        return null;
    }

    private WebViewAllowBean.Configuration.Policy getStartPolicy() {
        for (WebViewAllowBean.Configuration.Policy policy : this.policyList) {
            if (TextUtils.equals("*", policy.getInterfaceList())) {
                return policy;
            }
        }
        return null;
    }

    private String[] getUrlList(String str) {
        List<WebViewAllowBean.Configuration.Allow> allowList = this.webViewAllowBean.getConfigurations().getAllowList();
        ArrayList arrayList = new ArrayList();
        for (WebViewAllowBean.Configuration.Allow allow : allowList) {
            if (TextUtils.equals(str, allow.getPolicyId())) {
                arrayList.add(allow.getUrl());
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private boolean matchHostOrPath(String str, WebViewAllowBean.Configuration.Policy policy) {
        C1461a.m8359i(TAG, "enter matchHostOrPath");
        String[] urlList = getUrlList(policy.getPolicyId());
        C1461a.m8357d(TAG, "urls=" + Arrays.toString(urlList));
        if (policy.getControlType() == 0 && C11526c.m68808e(str, urlList)) {
            return true;
        }
        if (policy.getControlType() == 1 && C11526c.m68806c(str, urlList)) {
            return true;
        }
        C1461a.m8360w(TAG, "matchHostOrPath failed, no url matches");
        return false;
    }

    public void checkAndDownWebViewConfig() {
        C1461a.m8357d(TAG, "enter checkAndDownWebViewConfig");
        if (!C0209d.m1333z1(C0213f.m1377a())) {
            C1461a.m8360w(TAG, "checkAndDownWebViewConfig, no network");
        } else {
            C12515a.m75110o().m75172d(new HiCloudWebViewConfigTask());
        }
    }

    public boolean checkUrlByWebViewPolicy(String str, String str2) {
        WebViewAllowBean.Configuration.Policy policy;
        C1461a.m8359i(TAG, "enter checkUrlByWebViewPolicy");
        if (TextUtils.isEmpty(str2)) {
            C1461a.m8360w(TAG, "checkUrlByWebViewPolicy, url null");
            return false;
        }
        if (this.webViewAllowBean == null) {
            C1461a.m8360w(TAG, "checkUrlByWebViewPolicy, webViewAllowBean is null");
            return false;
        }
        try {
            policy = getPolicy(str);
        } catch (Exception e10) {
            C1461a.m8358e(TAG, "checkUrlByWebViewPolicy failed: " + e10.getMessage());
        }
        if (policy != null) {
            C1461a.m8357d(TAG, str + " matches policy: " + policy.getPolicyId());
            return matchHostOrPath(str2, policy);
        }
        WebViewAllowBean.Configuration.Policy startPolicy = getStartPolicy();
        if (startPolicy != null) {
            C1461a.m8357d(TAG, str + " matches starPolicy: " + startPolicy.getPolicyId());
            return matchHostOrPath(str2, startPolicy);
        }
        C1461a.m8358e(TAG, str + " checkUrlByWebViewPolicy failed, no policy matches");
        return false;
    }

    public boolean checkUrlHost(String str) {
        if (TextUtils.isEmpty(str)) {
            C1461a.m8358e(TAG, "checkUrlHost urlStr is empty");
            return false;
        }
        if (!URLUtil.isNetworkUrl(str)) {
            try {
                String host = new URI(str).getHost();
                C1461a.m8357d(TAG, "checkUrlHost host=" + host + ", urlArray= " + Arrays.toString(this.urlArray));
                return Arrays.asList(this.urlArray).contains(host);
            } catch (URISyntaxException e10) {
                C1461a.m8358e(TAG, "getHost catch exception：" + e10.getMessage());
            }
        }
        boolean zM68808e = C11526c.m68808e(str, this.urlArray);
        C1461a.m8359i(TAG, "checkUrlHost isUrlHostInWhitelist: " + zM68808e);
        return zM68808e;
    }

    public void clearConfigFile() {
        boolean zDelete;
        C1461a.m8359i(TAG, "enter clearConfigFile");
        try {
            Context contextM1378b = C0213f.m1378b();
            if (contextM1378b == null) {
                C1461a.m8358e(TAG, "clearConfigFile context null");
                return;
            }
            File file = new File(contextM1378b.getFilesDir() + File.separator + "HiCloudWebViewAllownlist.json");
            if (!file.exists() || (zDelete = file.delete())) {
                return;
            }
            C1461a.m8358e(TAG, "clearConfigFile deleteResult is:" + zDelete);
        } catch (Exception e10) {
            C1461a.m8358e(TAG, "clearConfigFile exception:" + e10.toString());
        }
    }

    public WebViewAllowBean getWebViewPolicyBean() {
        WebViewAllowBean webViewAllowBean = this.webViewAllowBean;
        if (webViewAllowBean != null) {
            return webViewAllowBean;
        }
        C1461a.m8359i(TAG, "webViewAllowBean is null");
        checkAndDownWebViewConfig();
        return null;
    }

    public void reloadParseLocalFile() {
        C1461a.m8359i(TAG, "enter reloadParseLocalFile");
        C12515a.m75110o().m75172d(new C49311());
    }

    private HiCloudWebViewPolicyManager() {
        this.urlArray = new String[0];
        this.policyList = new ArrayList();
    }
}
