package io.swingdev.microconf.workshop.extensions

import android.view.LayoutInflater
import android.view.View

fun View.getLayoutInflater(): LayoutInflater = LayoutInflater.from(context)