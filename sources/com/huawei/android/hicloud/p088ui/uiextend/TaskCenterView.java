package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.TaskCenterAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.bean.TaskCenterItem;
import com.huawei.android.hicloud.utils.C4308a;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import java.util.List;
import je.C10801o;
import p015ak.C0209d;
import p015ak.C0213f;
import p053ce.C1424b;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p778xk.C13823d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TaskCenterView extends FrameLayout implements View.OnClickListener, TaskCenterAdapter.IRecyclerViewOnListener {
    private static final int LIST_NUM = 2;
    private static final String TAG = "TaskCenterView";
    private Context context;
    private GridLayoutManager gridLayoutManager;
    private View inflateView;
    private C1424b itemDecoration;
    TextView listTitle;
    private View noTaskLayout;
    private TextView noTaskText;
    private TextView noTaskTitle;
    private View noTaskView;
    private AutoSizeButton startNowButton;
    private NotchFitRelativeLayout taskCenter;
    private TaskCenterAdapter taskCenterAdapter;
    private RelativeLayout taskCenterMore;
    private ImageView taskCenterRedDot;
    private View taskCenterTitleLayout;
    private RecyclerView taskListView;
    private View taskView;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.TaskCenterView$1 */
    public class ViewTreeObserverOnGlobalLayoutListenerC41291 implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC41291() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onGlobalLayout$0() {
            int lineCount = TaskCenterView.this.noTaskTitle.getLineCount();
            if (lineCount == 0) {
                return;
            }
            if (lineCount == 1) {
                TaskCenterView.this.noTaskText.setMaxLines(3);
            } else {
                TaskCenterView.this.noTaskText.setSingleLine();
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            TaskCenterView.this.noTaskTitle.post(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19296a.lambda$onGlobalLayout$0();
                }
            });
            TaskCenterView.this.noTaskTitle.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public TaskCenterView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    private ViewStub findViewStubById(View view, int i10) {
        if (view == null) {
            return null;
        }
        View viewFindViewById = view.findViewById(i10);
        if (viewFindViewById instanceof ViewStub) {
            return (ViewStub) viewFindViewById;
        }
        return null;
    }

    private void initItemList() {
        C11839m.m70688i(TAG, "initItemList ");
        if (this.taskView == null) {
            this.taskView = findViewStubById(this.inflateView, R$id.task_center_list).inflate();
        }
        this.taskCenter = (NotchFitRelativeLayout) C12809f.m76831d(this.inflateView, R$id.task_center_list_region);
        RecyclerView recyclerView = (RecyclerView) C12809f.m76831d(this.taskView, R$id.task_center_view);
        this.taskListView = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.taskListView.setNestedScrollingEnabled(false);
        this.listTitle = (TextView) C12809f.m76831d(this.taskView, R$id.task_center_list_title);
        this.listTitle.setText(this.context.getResources().getQuantityString(R$plurals.task_center_list_title, 30, 30, this.context.getString(R$string.hidisk_file_size_gb, String.valueOf(50))));
        this.taskCenterAdapter = new TaskCenterAdapter(this.context);
        this.itemDecoration = C10801o.m65745b(this.context);
        Context context = this.context;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, C11842p.m70868u(context));
        this.gridLayoutManager = gridLayoutManager;
        this.taskListView.setLayoutManager(gridLayoutManager);
        this.taskListView.setAdapter(this.taskCenterAdapter);
        this.taskCenterAdapter.m25299I(this);
        View view = this.noTaskView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void initTaskCenterView() {
        TextView textView;
        C11839m.m70688i(TAG, "initTaskCenterView");
        if (this.noTaskView == null) {
            this.noTaskView = findViewStubById(this.inflateView, R$id.task_center_off).inflate();
        }
        this.noTaskTitle = (TextView) C12809f.m76831d(this.noTaskView, R$id.swith_off_banner_title);
        this.noTaskText = (TextView) C12809f.m76831d(this.noTaskView, R$id.swith_off_banner_text);
        this.noTaskText.setText(this.context.getResources().getQuantityString(R$plurals.task_center_banner_text, 30, 30, this.context.getString(R$string.hidisk_file_size_gb, String.valueOf(50))));
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76831d(this.noTaskView, R$id.go_to_see);
        this.startNowButton = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        View viewM76831d = C12809f.m76831d(this.noTaskView, R$id.swith_off_layout);
        this.noTaskLayout = viewM76831d;
        viewM76831d.setOnClickListener(this);
        if (C0209d.m1195O(this.context) >= 1.75f && (textView = this.noTaskText) != null) {
            textView.setVisibility(8);
        }
        this.taskCenterMore.setVisibility(8);
        this.taskCenterTitleLayout.setEnabled(false);
        this.noTaskView.setVisibility(0);
        View view = this.taskView;
        if (view != null) {
            view.setVisibility(8);
        }
        setMaxLines();
        NotchFitRelativeLayout notchFitRelativeLayout = this.taskCenter;
        if (notchFitRelativeLayout == null || this.listTitle == null) {
            return;
        }
        notchFitRelativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.android.hicloud.ui.uiextend.x
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f19295a.lambda$initTaskCenterView$0();
            }
        });
    }

    private void initTitle() {
        C11839m.m70688i(TAG, "initTitle");
        this.taskCenterMore = (RelativeLayout) C12809f.m76831d(this.inflateView, R$id.task_center_title_more);
        this.taskCenterTitleLayout = C12809f.m76831d(this.inflateView, R$id.task_center_layout);
        this.taskCenterRedDot = (ImageView) C12809f.m76831d(this.inflateView, R$id.task_center_redDot_icon);
        this.taskCenterTitleLayout.setOnClickListener(this);
    }

    private void initView() {
        this.inflateView = View.inflate(this.context, R$layout.task_center_layout, this);
        initTitle();
        initItemList();
        initTaskCenterView();
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTaskCenterView$0() {
        C4308a.m25920s(C11842p.m70810f1(C0213f.m1377a(), this.taskCenter.getHeight() - this.listTitle.getHeight()));
    }

    private void reportBI(String str, LinkedHashMap<String, String> linkedHashMap) {
        C13227f.m79492i1().m79567R(str, linkedHashMap);
        UBAAnalyze.m29947H("CKC", str, linkedHashMap);
    }

    private void setLayoutManager() {
        RecyclerView recyclerView = this.taskListView;
        if (recyclerView == null || recyclerView.getAdapter() == null) {
            return;
        }
        setRecyclerViewLayout(this.taskListView);
        this.taskListView.getAdapter().m5213j();
    }

    private void setRecyclerViewLayout(RecyclerView recyclerView) {
        int iM70868u = C11842p.m70868u(this.context);
        this.gridLayoutManager.setSpanCount(iM70868u);
        C1424b c1424b = this.itemDecoration;
        if (c1424b != null) {
            recyclerView.removeItemDecoration(c1424b);
        }
        if (iM70868u > 1 && C11842p.m70753O0(this.context)) {
            this.itemDecoration.m8279a(iM70868u);
            recyclerView.addItemDecoration(this.itemDecoration);
        }
        TaskCenterAdapter taskCenterAdapter = this.taskCenterAdapter;
        if (taskCenterAdapter != null) {
            taskCenterAdapter.m25297G(iM70868u);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        if (R$id.swith_off_layout == view.getId() || R$id.go_to_see == view.getId()) {
            reportBI("no_task_go_see", linkedHashMapM79499C);
        } else if (R$id.task_center_layout == view.getId()) {
            reportBI("task_center_click_more", linkedHashMapM79499C);
        }
        C13823d.m82904y().m82913I(this.context, 10);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setLayoutManager();
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.TaskCenterAdapter.IRecyclerViewOnListener
    public void onItemClick(int i10, TaskCenterItem taskCenterItem) {
        if (C0209d.m1226Y0()) {
            return;
        }
        reportBI("task_center_item_click", C13230i.m79499C(C13452e.m80781L().m80971t0()));
        C13823d.m82904y().m82913I(this.context, 10);
    }

    public void refreshStatus(List<TaskCenterItem> list, int i10) {
        setVisibility(0);
        if (list == null || list.size() < 2) {
            C12809f.m76842o(this.noTaskView, this.taskView);
            this.taskCenterTitleLayout.setEnabled(false);
            C12809f.m76843p(this.taskCenterMore, false);
            return;
        }
        C12809f.m76842o(this.taskView, this.noTaskView);
        this.taskCenterTitleLayout.setEnabled(true);
        C12809f.m76843p(this.taskCenterMore, true);
        C12809f.m76843p(this.taskCenterRedDot, i10 > 2);
        this.taskCenterAdapter.m25298H(list);
        setLayoutManager();
        this.taskCenterAdapter.m5213j();
        C11839m.m70688i(TAG, "refreshStatus :" + list.size());
    }

    public void setMaxLines() {
        TextView textView = this.noTaskTitle;
        if (textView == null || this.noTaskText == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC41291());
    }

    public TaskCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        initView();
    }
}
