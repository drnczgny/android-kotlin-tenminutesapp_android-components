package com.adrian.tenminutesapp.pages.tenminutes.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.adrian.tenminutesapp.R
import com.adrian.tenminutesapp.databinding.ActivityTenMinutesBinding
import com.adrian.tenminutesapp.pages.tenminutes.viewmodel.TenMinutesViewModel
import com.adrian.tenminutesapp.utils.viewpager.ViewPagerAdapter
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class TenMinutesActivity : AppCompatActivity(), TenMinutesRouter, HasSupportFragmentInjector {

    object logging {
        val TAG = TenMinutesActivity::class.java.simpleName
    }

    lateinit var binding: ActivityTenMinutesBinding

    @Inject lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject lateinit var viewModel: TenMinutesViewModel

    @Inject lateinit var viewPagerAdapter: ViewPagerAdapter

    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout

    /**
     * Dagger injector method build/inject fragments for this activity
     */
    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)
        bind()

        viewModel.onCreate()

        setupViewPager()

//        setUpuploadBalanceOnLongClickListener()

//        var mFragmentManager = supportFragmentManager
//        var mFragmentTransaction = mFragmentManager.beginTransaction()
//        mFragmentTransaction.replace(binding.contentFrame.id, HomePageFragment.newInstance())
//        mFragmentTransaction.commit()
    }

    private fun setupViewPager() {
        this.tabLayout = binding.tabLayout
        this.viewPager = binding.viewPager
        this.viewPager.adapter = viewPagerAdapter
        this.tabLayout.setupWithViewPager(this.viewPager)

        this.viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                // NO-OP
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // NO-OP
            }

            override fun onPageSelected(position: Int) {
                viewPagerAdapter.onPageSelected(position)
            }
        })
    }

    private fun bind() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding?.viewModel = viewModel
        binding?.executePendingBindings()
    }


//    fun getVariableId(): Int {
//        return BR.viewModel
//    }

    fun getLayoutId() = R.layout.activity_ten_minutes
}
