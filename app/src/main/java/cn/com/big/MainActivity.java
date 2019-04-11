package cn.com.big;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import java.util.Arrays;
import java.util.List;

import cn.com.big.base.BaseActivity;
import cn.com.big.home.HomeFragment;
import cn.com.big.mine.MineFragment;

/**
 * 主页.
 *
 * @author luyh
 * @version 1.0
 * @date 2019/04/11
 */
public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;
    private MagicIndicator magicIndicator;
    // 选中了的图片
    private final static int[] CHECK_BG = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    // 未选中了图片
    private final static int[] UNCHECK_BG = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    // 底部栏上的文字
    private final static String[] BOTTOM_TITLES = new String[]{"首页", "我的"};
    private List<String> mTitleList = Arrays.asList(BOTTOM_TITLES);

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initial() {
        mViewPager = findViewById(R.id.view_pager);
        magicIndicator = findViewById(R.id.magic_indicator);
        magicIndicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(mActivity);
        // 标题栏平分
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return mTitleList == null ? 0 : mTitleList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);
                View view = LayoutInflater.from(context).inflate(R.layout.layout_bottom_title, null);
                final AppCompatImageView titleImg = view.findViewById(R.id.iv_tab_img);
                final AppCompatTextView tabTitle = view.findViewById(R.id.tv_tab_title);
                titleImg.setBackgroundResource(CHECK_BG[index]);
                tabTitle.setText(mTitleList.get(index));
                tabTitle.setAlpha(1.0f);
                commonPagerTitleView.setContentView(view);
                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {

                    /**
                     * 选中
                     * @param index
                     * @param totalCount
                     */
                    @Override
                    public void onSelected(int index, int totalCount) {
                        titleImg.setBackgroundResource(CHECK_BG[index]);
                        tabTitle.setTextColor(Color.RED);
                        tabTitle.setAlpha(1.0f);
                    }

                    /**
                     * 未选中
                     * @param index
                     * @param totalCount
                     */
                    @Override
                    public void onDeselected(int index, int totalCount) {
                        titleImg.setBackgroundResource(UNCHECK_BG[index]);
                        tabTitle.setTextColor(Color.BLACK);
                        tabTitle.setAlpha(0.87f);
                    }

                    /**
                     * 在离开
                     * @param index
                     * @param totalCount
                     * @param leavePercent
                     * @param leftToRight
                     */
                    @Override
                    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
                        titleImg.setBackgroundResource(UNCHECK_BG[index]);
                        tabTitle.setTextColor(Color.BLACK);
                        tabTitle.setAlpha(0.87f);
                    }

                    /**
                     * 在进入
                     * @param index
                     * @param totalCount
                     * @param enterPercent
                     * @param leftToRight
                     */
                    @Override
                    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
                        titleImg.setBackgroundResource(CHECK_BG[index]);
                        tabTitle.setTextColor(Color.RED);
                        tabTitle.setAlpha(1.0f);
                    }
                });
                commonPagerTitleView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setColors(Color.RED);
                linePagerIndicator.setLineHeight(UIUtil.dip2px(context, 2));
                return linePagerIndicator;
            }

            @Override
            public float getTitleWeight(Context context, int index) {
                return 1.0f;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        // 将ViewPager与MagicIndicator绑定到一起
        ViewPagerHelper.bind(magicIndicator, mViewPager);
        TabPagerAdapter mPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(0);
    }

    private class TabPagerAdapter extends FragmentPagerAdapter {

        private TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return HomeFragment.newInstance();
            } else {
                return MineFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return BOTTOM_TITLES.length;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int position) {
            return super.instantiateItem(viewGroup, position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            super.destroyItem(container, position, object);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return BOTTOM_TITLES[position];
        }
    }
}
