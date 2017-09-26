package com.adrian.tenminutesapp.pages.tenminutes.subpages.history.view


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrian.tenminutesapp.BR
import com.adrian.tenminutesapp.R
import com.adrian.tenminutesapp.base.BaseFragment
import com.adrian.tenminutesapp.databinding.FragmentHistoryPageBinding
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.viewmodel.HistoryPageViewModel
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.view.HomePageFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HistoryPageFragment : BaseFragment(), HistoryPageRouter {

    object logging {
        val TAG = HomePageFragment::class.java.simpleName
    }

    lateinit var binding: FragmentHistoryPageBinding

    @Inject lateinit var viewModel: HistoryPageViewModel

    companion object {
        fun newInstance(): HistoryPageFragment {
            val fragment = HistoryPageFragment()
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
//        binding?.rvCostRegistries?.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false))
        return binding.getRoot()
    }

    override fun onSelectedInViewPager() {
        Log.e(logging.TAG, HomePageFragment.logging.TAG + " selected in ViewPager")
    }

    private fun bind(inflater: LayoutInflater?, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding?.viewModel = viewModel
        binding?.executePendingBindings()
    }


    private fun getLayoutId() = R.layout.fragment_history_page

    private fun getVariableId(): Int {
        return BR.viewModel
    }

}
