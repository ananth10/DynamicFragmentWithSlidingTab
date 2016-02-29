package com.activity.dynamicfragmentwithslidingtab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class DynamicFragmentActivity extends AppCompatActivity {

    MyPagerAdapter mAdaper;
    private ViewPager mViewPager;
    private PagerSlidingTabStrip tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        mAdaper = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mViewPager.setAdapter(mAdaper);
        tabs.setViewPager(mViewPager);
    }



    public static class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = new MyFragment();
            Bundle args = new Bundle();
            args.putInt(MyFragment.PAGE, i + 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "PAGE " + (position + 1);
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }
    }

    public static class MyFragment extends Fragment {

        public static final String PAGE = "page";
        View rootView;
        TextView mText;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            rootView = inflater.inflate(R.layout.fragment_lay, container, false);
            mText = (TextView) rootView.findViewById(android.R.id.text1);
            Bundle args = getArguments();
            mText.setText(Integer.toString(args.getInt(PAGE)));
            return rootView;
        }


        }

    @Override
    public void onResume() {
        super.onResume();
    }
}
