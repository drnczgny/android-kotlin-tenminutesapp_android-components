package com.adrian.tenminutesapp.pages.tenminutes.subpages.history.viewmodel

import android.databinding.Bindable
import com.adrian.tenminutesapp.base.ListItemViewModel
import com.adrian.tenminutesapp.pages.tenminutes.dto.SingleCostRegistry

/**
 * Created by cadri on 2017. 09. 23..
 */

class SingleCostRegistryItemViewModel constructor(val singleCostRegistry: SingleCostRegistry) : ListItemViewModel() {

    @Bindable
    var foodType: String = singleCostRegistry.foodType.toString()
        set(value) {
            if (foodType != value) {
                field = value
//                notifyPropertyChanged(BR.menuA)
            }
        }

    @Bindable
    var price: String = singleCostRegistry.price.toString()
        set(value) {
            if (price != value) {
                field = value
//                notifyPropertyChanged(BR.menuA)
            }
        }

    @Bindable
    var dateTime: String = singleCostRegistry.dateTime.toString()
        set(value) {
            if (dateTime != value) {
                field = value
//                notifyPropertyChanged(BR.menuA)
            }
        }
}