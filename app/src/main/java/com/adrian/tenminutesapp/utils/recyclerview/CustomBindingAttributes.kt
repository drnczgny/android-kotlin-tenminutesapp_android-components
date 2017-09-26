package com.adrian.tenminutesapp.utils.recyclerview

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.adrian.tenminutesapp.base.ListItemViewModel

/**
 * Created by cadri on 2017. 08. 22..
 */


@BindingAdapter(value = *arrayOf("listItems", "listItemLayout", "variableId"), requireAll = true)
fun  setupRecyclerViewAdapter(recyclerView: RecyclerView, items: List<ListItemViewModel>, itemLayout: Int, variableId: Int) {
    recyclerView.setLayoutManager(LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false))
    val recyclerViewAdapter = getAdapter(recyclerView)
    recyclerViewAdapter.items = items
    recyclerViewAdapter.itemLayout = itemLayout
    recyclerViewAdapter.variableId = variableId
}

fun getAdapter(recyclerView: RecyclerView): RecyclerViewAdapter<ListItemViewModel> {
    var adapter = recyclerView.adapter
    if (adapter == null) {
        adapter = RecyclerViewAdapter<ListItemViewModel>()
        recyclerView.adapter = adapter
    }
    return adapter as RecyclerViewAdapter<ListItemViewModel>
}

