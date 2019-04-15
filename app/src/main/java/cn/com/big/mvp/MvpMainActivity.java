package cn.com.big.mvp;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.big.R;
import cn.com.big.base.BaseActivity;

public class MvpMainActivity extends BaseActivity {


    @BindView(R.id.back)
    LinearLayout back;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.contentFrame)
    FrameLayout contentFrame;

    @Override
    protected int initLayout() {
        return R.layout.activity_mvp_main;
    }

    @Override
    protected void initView() {
        titleName.setText("MVP模式");
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
