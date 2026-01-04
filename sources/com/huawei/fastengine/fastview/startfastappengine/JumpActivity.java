package com.huawei.fastengine.fastview.startfastappengine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.fastengine.fastview.Config;
import com.huawei.fastengine.fastview.OpenFastAppEngine;
import com.huawei.fastengine.fastview.StartFastAPPEngine;
import com.huawei.fastengine.fastview.download.emui.widget.EMUISupportUtil;
import com.huawei.fastengine.fastview.download.utils.CommonUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.preload.PreloadManager;
import com.huawei.fastengine.fastview.shortcut.ShortCutManager;
import com.huawei.fastengine.fastview.weakup.WeakUpManagement;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes5.dex */
public class JumpActivity extends Activity {
    public static final String ACTIVITY_NAME = "com.huawei.fastapp.app.protocol.JumpActivity";
    public static final String INTENT_FOR_WEAK_UP = "forWeakUp";
    private static final int MSG_TIMEOUT = 1000;
    private static final int REQUEST_CODE = 2001;
    private static final String TAG = "JumpActivity";
    private static final int TIME_OUT = 2000;
    private boolean isfromold = false;
    private Handler mHandler = new Handler() { // from class: com.huawei.fastengine.fastview.startfastappengine.JumpActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (1000 == message.what) {
                JumpActivity.this.setStatus(false);
            }
        }
    };
    private OpenFastAppEngine mInstance;
    private PreloadManager mInstancePreload;
    private ShortCutManager mInstanceShortCut;
    private StartFastAPPEngine mInstanceold;
    private WeakUpManagement weakUpManagement;

    private static void requestActivityTransparent(Activity activity) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        activity.requestWindowFeature(1);
        if (EMUISupportUtil.getInstance().isEMUI4Style()) {
            Window window = activity.getWindow();
            window.addFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
            setHwFloating(window, true);
        }
    }

    private static void setHwFloating(Window window, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            window.getClass().getMethod("setHwFloating", Boolean.TYPE).invoke(window, Boolean.valueOf(z10));
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            FastViewLogUtils.m28724e(TAG, "Failed to call Window.setHwFloating().");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(boolean z10) {
        FastViewLogUtils.m28726i(TAG, "setStatus: " + z10);
        ShortCutManager shortCutManager = this.mInstanceShortCut;
        if (shortCutManager != null) {
            shortCutManager.jumpActivityCallback(z10);
        } else {
            PreloadManager preloadManager = this.mInstancePreload;
            if (preloadManager != null) {
                preloadManager.jumpActivityCallback(z10);
            } else {
                WeakUpManagement weakUpManagement = this.weakUpManagement;
                if (weakUpManagement == null) {
                    if (this.isfromold) {
                        if (this.mInstanceold != null) {
                            FastViewLogUtils.m28726i(TAG, "isfromold setStatus: mInstance is not null");
                            this.mInstanceold.setJumpActivityStatus(z10);
                        }
                    } else if (this.mInstance != null) {
                        FastViewLogUtils.m28726i(TAG, "setStatus: mInstance is not null");
                        this.mInstance.setJumpActivityStatus(z10);
                    }
                    finish();
                    return;
                }
                weakUpManagement.jumpActivityCallback(z10);
            }
        }
        finish();
    }

    private void startActivityForResult() {
        FastViewLogUtils.m28726i(TAG, " startActivityForResult：");
        Intent intent = new Intent();
        intent.setClassName(Config.getPackageName(), ACTIVITY_NAME);
        try {
            startActivityForResult(intent, 2001);
            overridePendingTransition(0, 0);
            Message messageObtain = Message.obtain(this.mHandler);
            messageObtain.what = 1000;
            this.mHandler.sendMessageDelayed(messageObtain, RippleView.SINGLE_RIPPLE_TIME);
        } catch (Exception unused) {
            FastViewLogUtils.m28724e(TAG, "ActivityNotFoundException");
            this.mHandler.removeMessages(1000);
            setStatus(false);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        boolean z10;
        super.onActivityResult(i10, i11, intent);
        FastViewLogUtils.m28726i(TAG, " onActivityResult: " + i11);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1000);
        }
        if (i10 == 2001 && i11 == -1) {
            FastViewLogUtils.m28726i(TAG, " flag: true");
            z10 = true;
        } else {
            z10 = false;
        }
        setStatus(z10);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        requestActivityTransparent(this);
        Intent intent = getIntent();
        if (intent != null && !CommonUtils.hasParseException(intent)) {
            if (intent.hasExtra(PreloadManager.INTENT_IS_FROM_PRELOAD)) {
                this.mInstancePreload = PreloadManager.getInstance();
            } else if (intent.hasExtra(INTENT_FOR_WEAK_UP)) {
                this.weakUpManagement = WeakUpManagement.getInstance();
            } else if (intent.hasExtra("isfromShortCut")) {
                this.mInstanceShortCut = ShortCutManager.getInstance();
            } else {
                boolean booleanExtra = intent.getBooleanExtra("isfromold", false);
                this.isfromold = booleanExtra;
                if (booleanExtra) {
                    this.mInstanceold = StartFastAPPEngine.getInstance();
                } else {
                    this.mInstance = OpenFastAppEngine.getInstance();
                }
            }
            startActivityForResult();
            return;
        }
        startActivityForResult();
    }

    @Override // android.app.Activity
    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }
}
