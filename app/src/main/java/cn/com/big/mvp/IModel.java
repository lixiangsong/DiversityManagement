package cn.com.big.mvp;

public interface IModel {
    //加载数据可能是异步操作，通过接口回调告知Presenter结果

    void loadData(IPresenter listener);
}
