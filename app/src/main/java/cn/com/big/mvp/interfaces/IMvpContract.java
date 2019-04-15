package cn.com.big.mvp.interfaces;

public interface IMvpContract {
    interface IView extends BaseView<Presenter> {
        void setData();
    }

    interface Presenter extends BasePresenter {
        void loadData();
    }
}
