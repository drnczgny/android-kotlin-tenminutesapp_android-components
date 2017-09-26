package com.adrian.tenminutesapp.pages.tenminutes.subpages.history.viewmodel

import android.databinding.Bindable
import com.adrian.tenminutesapp.base.ListItemViewModel

/**
 * Created by cadri on 2017. 09. 24..
 */

class TempListItemViewModel : ListItemViewModel() {

    @Bindable
    var text: String = "asd"
        set(value) {
            if (!text.equals(value)) {
                field = value
            }
        }

//    @Bindable
//    fun getItemLayoutId() = R.layout.list_item_temp
//
//    @Bindable
//    fun getVariableId(): Int {
//        return BR.viewModel
//    }

}