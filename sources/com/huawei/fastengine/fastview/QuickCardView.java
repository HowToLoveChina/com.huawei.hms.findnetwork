package com.huawei.fastengine.fastview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard;
import com.huawei.fastengine.fastview.activitymgr.IConfigurationCallback;
import com.huawei.fastengine.fastview.activitymgr.QuickCardActivityMgr;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastsdk.IQuickCardListener;
import com.huawei.fastsdk.IUiConfiguration;
import java.util.Map;

/* loaded from: classes5.dex */
public class QuickCardView extends FrameLayout {
    private static final String TAG = "FastSDKEngine";
    private Activity activity;
    private IConfigurationCallback configurationCallback;
    private IActivityLifecycleForCard lifecycleForCardCallback;
    private FastViewInstance mFastViewInstance;
    private String mQuickCardUri;

    public QuickCardView(Context context) {
        super(context);
        this.configurationCallback = new IConfigurationCallback() { // from class: com.huawei.fastengine.fastview.QuickCardView.1
            @Override // com.huawei.fastengine.fastview.activitymgr.IConfigurationCallback
            public void onActivityConfigurationChanged(Configuration configuration) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onConfigurationChanged(configuration);
                }
            }
        };
        this.lifecycleForCardCallback = new IActivityLifecycleForCard() { // from class: com.huawei.fastengine.fastview.QuickCardView.2
            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityDestroyed(Activity activity) {
                QuickCardView.this.destroy();
            }

            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityPause(Activity activity) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onPause();
                }
            }

            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityResume(Activity activity) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onResume();
                }
            }

            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityStart(Activity activity) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onStart();
                }
            }

            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityStop(Activity activity) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onStop();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mFastViewInstance = FastViewInstance.builder().setContext(context).build();
    }

    public int bindData(String str) {
        FastViewLogUtils.m28726i(TAG, "begin bindData");
        long jCurrentTimeMillis = System.currentTimeMillis();
        FastViewInstance fastViewInstance = this.mFastViewInstance;
        if (fastViewInstance != null) {
            return fastViewInstance.bindData(str);
        }
        QuickCardAnalytic.reportBindData(getContext(), jCurrentTimeMillis, System.currentTimeMillis(), -1, this.mQuickCardUri);
        return -1;
    }

    public void destroy() {
        Activity activity = this.activity;
        if (activity != null) {
            QuickCardActivityMgr quickCardActivityMgr = QuickCardActivityMgr.INST;
            quickCardActivityMgr.unRegisterActivitLifeCycleEvent(activity, this.lifecycleForCardCallback);
            quickCardActivityMgr.unRegisterConfigurationEvent(this.configurationCallback);
        }
        this.activity = null;
        FastViewInstance fastViewInstance = this.mFastViewInstance;
        if (fastViewInstance != null) {
            fastViewInstance.onDestroy();
            this.mFastViewInstance = null;
        }
    }

    public void evaluateExpression(String str) {
        FastViewLogUtils.m28726i(TAG, "begin evaluateExpression");
        FastViewInstance fastViewInstance = this.mFastViewInstance;
        if (fastViewInstance != null) {
            fastViewInstance.evaluateExpression(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Context context = getContext();
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.activity = activity;
            QuickCardActivityMgr quickCardActivityMgr = QuickCardActivityMgr.INST;
            quickCardActivityMgr.registerActivitLifeCycleEvent(activity, this.lifecycleForCardCallback);
            quickCardActivityMgr.registerConfigurationEvent(this.configurationCallback);
        }
    }

    public int renderQuickCard(String str, Map<String, Object> map) {
        FastViewLogUtils.m28726i(TAG, "begin renderQuickCard");
        long jCurrentTimeMillis = System.currentTimeMillis();
        FastViewInstance fastViewInstance = this.mFastViewInstance;
        if (fastViewInstance == null) {
            QuickCardAnalytic.reportRenderCard(getContext(), jCurrentTimeMillis, System.currentTimeMillis(), -1, str);
            return -1;
        }
        this.mQuickCardUri = str;
        fastViewInstance.attachRootView(this);
        return this.mFastViewInstance.renderQuickCard(str, map);
    }

    public void setQuickCardListener(IQuickCardListener iQuickCardListener) {
        FastViewInstance fastViewInstance = this.mFastViewInstance;
        if (fastViewInstance != null) {
            fastViewInstance.registerQuickCardListener(iQuickCardListener);
        }
    }

    public void setUiConfiguration(IUiConfiguration iUiConfiguration) {
        FastViewInstance fastViewInstance = this.mFastViewInstance;
        if (fastViewInstance != null) {
            fastViewInstance.registerUiConfiguration(iUiConfiguration);
        }
    }

    public QuickCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.configurationCallback = new IConfigurationCallback() { // from class: com.huawei.fastengine.fastview.QuickCardView.1
            @Override // com.huawei.fastengine.fastview.activitymgr.IConfigurationCallback
            public void onActivityConfigurationChanged(Configuration configuration) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onConfigurationChanged(configuration);
                }
            }
        };
        this.lifecycleForCardCallback = new IActivityLifecycleForCard() { // from class: com.huawei.fastengine.fastview.QuickCardView.2
            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityDestroyed(Activity activity) {
                QuickCardView.this.destroy();
            }

            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityPause(Activity activity) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onPause();
                }
            }

            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityResume(Activity activity) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onResume();
                }
            }

            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityStart(Activity activity) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onStart();
                }
            }

            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityStop(Activity activity) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onStop();
                }
            }
        };
        init(context);
    }

    public int bindData(Map<String, Object> map) {
        FastViewLogUtils.m28726i(TAG, "begin bindjsonData");
        long jCurrentTimeMillis = System.currentTimeMillis();
        FastViewInstance fastViewInstance = this.mFastViewInstance;
        if (fastViewInstance != null) {
            return fastViewInstance.bindData(map);
        }
        QuickCardAnalytic.reportBindData(getContext(), jCurrentTimeMillis, System.currentTimeMillis(), -1, this.mQuickCardUri);
        return -1;
    }

    public QuickCardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.configurationCallback = new IConfigurationCallback() { // from class: com.huawei.fastengine.fastview.QuickCardView.1
            @Override // com.huawei.fastengine.fastview.activitymgr.IConfigurationCallback
            public void onActivityConfigurationChanged(Configuration configuration) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onConfigurationChanged(configuration);
                }
            }
        };
        this.lifecycleForCardCallback = new IActivityLifecycleForCard() { // from class: com.huawei.fastengine.fastview.QuickCardView.2
            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityDestroyed(Activity activity) {
                QuickCardView.this.destroy();
            }

            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityPause(Activity activity) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onPause();
                }
            }

            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityResume(Activity activity) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onResume();
                }
            }

            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityStart(Activity activity) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onStart();
                }
            }

            @Override // com.huawei.fastengine.fastview.activitymgr.IActivityLifecycleForCard
            public void onActivityStop(Activity activity) {
                if (QuickCardView.this.mFastViewInstance != null) {
                    QuickCardView.this.mFastViewInstance.onStop();
                }
            }
        };
        init(context);
    }
}
