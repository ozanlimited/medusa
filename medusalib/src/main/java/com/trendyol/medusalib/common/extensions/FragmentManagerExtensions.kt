package com.trendyol.medusalib.common.extensions

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction


internal inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) = beginTransaction().func().commitAllowingStateLoss()

internal fun FragmentManager.commitAdd(containerId: Int, fragment: Fragment, fragmentTag: String) =
    inTransaction {
        add(containerId, fragment, fragmentTag)
    }

internal fun FragmentManager.commitRemove(fragmentTag: String) =
    findFragmentByTag(fragmentTag)?.let {
        inTransaction {
            remove(it)
        }
    }

internal fun FragmentManager.commitAttach(fragmentTag: String) =
    findFragmentByTag(fragmentTag)?.let {
        inTransaction {
            attach(it)
        }
    }

internal fun FragmentManager.commitDetach(fragmentTag: String) =
    findFragmentByTag(fragmentTag)?.let {
        inTransaction {
            detach(it)
        }
    }

internal fun FragmentManager.commitHide(fragmentTag: String) {
    findFragmentByTag(fragmentTag)?.let {
        inTransaction {
            hide(it)
        }
    }
}

internal fun FragmentManager.commitShow(fragmentTag: String) {
    findFragmentByTag(fragmentTag)?.let {
        inTransaction {
            show(it)
        }
    }
}
