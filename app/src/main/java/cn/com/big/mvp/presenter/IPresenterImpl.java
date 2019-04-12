package cn.com.big.mvp.presenter;

import java.util.List;

import cn.com.big.mvp.IModel;
import cn.com.big.mvp.IPresenter;
import cn.com.big.mvp.IView;
import cn.com.big.mvp.model.IModelImpl;

public class IPresenterImpl implements IPresenter {
    private IView view;
    private IModel model;

    public IPresenterImpl(IView iView) {
        this.view = iView;
        model = new IModelImpl();
    }

    @Override
    public void loadData() {
        model.loadData(this);
    }

    @Override
    public void onSuccess(List<String> data) {
        if (view != null) {
            view.upViewData(data);
        }
    }

    @Override
    public void onFailed() {

    }

}
