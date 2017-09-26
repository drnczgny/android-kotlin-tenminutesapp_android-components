package com.adrian.tenminutesapp.pages.tenminutes.subpages.home.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrian.tenminutesapp.BR
import com.adrian.tenminutesapp.R
import com.adrian.tenminutesapp.base.BaseFragment
import com.adrian.tenminutesapp.databinding.FragmentHomePageBinding
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.viewmodel.HomePageViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class HomePageFragment : BaseFragment(), HomePageRouter {

    object logging {
        val TAG = HomePageFragment::class.java.simpleName
    }

    lateinit var binding: FragmentHomePageBinding

    @Inject lateinit var viewModel: HomePageViewModel

    companion object {
        fun newInstance(): HomePageFragment {
            val fragment = HomePageFragment()
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)

        viewModel.onCreate()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bind(inflater, container)

        setUpuploadBalanceOnLongClickListener()
        return binding.getRoot()
    }

    override fun onSelectedInViewPager() {
        Log.e(logging.TAG,logging.TAG + " selected in ViewPager")
    }

    private fun bind(inflater: LayoutInflater?, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding?.viewModel = viewModel as HomePageViewModel
        binding?.executePendingBindings()
    }

    private fun setUpuploadBalanceOnLongClickListener() {
        binding.uploadBalance.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                viewModel.setupBalance(binding?.uploadBalanceAmount.text.toString());
                return true
            }
        })
    }

    private fun getLayoutId() = R.layout.fragment_home_page

    private fun getVariableId(): Int {
        return BR.viewModel
    }

}
