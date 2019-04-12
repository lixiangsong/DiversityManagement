package cn.com.big.mvp;

import android.util.Log;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import cn.com.big.R;
import cn.com.big.base.BaseActivity;
import cn.com.big.mvp.presenter.IPresenterImpl;

public class MvpMainActivity extends BaseActivity implements IView {
    @BindView(R.id.text_tv)
    TextView textTv;

    private IPresenter presenter;

    @Override
    protected int initLayout() {
        return R.layout.activity_mvp_main;
    }

    @Override
    protected void initView() {
        presenter = new IPresenterImpl(this);
        presenter.loadData();
    }

    @Override
    public void upViewData(List<String> data) {
        textTv.setText("dsdsds" + data.get(0));
    }
}
