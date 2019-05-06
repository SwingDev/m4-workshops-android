package io.swingdev.microconf.advancedmvvm.extensions

import android.view.LayoutInflater
import android.view.View

fun View.getLayoutInflater(): LayoutInflater = LayoutInflater.from(context)