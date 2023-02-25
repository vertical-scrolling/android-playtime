package com.hackathon.playtime

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    protected val activityViewModel by sharedViewModel<MainViewModel>()

    fun NavController.navigateSafe(directions: NavDirections) {
        try {
            navigate(directions)
        } catch (e: Exception) {
            Log.e("Navigator", "navigateSafe error: $e")
        }
    }

    override fun onStart() {
        super.onStart()
        restoreFromActivity(activityViewModel.getState(this.javaClass.simpleName))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //show keyboard when any fragment of this class has been attached
        showSoftwareKeyboard(true)
    }


    override fun onDetach() {
        super.onDetach()

        //hide keyboard when any fragment of this class has been detached
        showSoftwareKeyboard(false)
    }

    override fun onStop() {
        activityViewModel.saveState(this.javaClass.simpleName, getBundleForActivity())
        super.onStop()
    }

    fun clearSavedState() {
        activityViewModel.saveState(this.javaClass.simpleName, null)
    }

    protected open fun showSoftwareKeyboard(showKeyboard: Boolean) {
        val inputManager: InputMethodManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
                requireActivity().currentFocus?.windowToken,
                if (showKeyboard) InputMethodManager.SHOW_FORCED else InputMethodManager.HIDE_NOT_ALWAYS
        )
    }

    /**
     * Method that should be overridden by fragments that want to store the state in the
     * activity
     */
    protected open fun getBundleForActivity(): Bundle? {
        return null
    }

    /**
     * Method that should be overridden by fragments that want to restore
     * the bundle from the activity. This is what saveInstanceState does,
     * but in this case we don't need the activity to be killed
     */
    protected open fun restoreFromActivity(bundle: Bundle?) = Unit

    protected fun checkViewInitializedCorrectly(): Boolean {
        return activity?.isDestroyed == false && this.isAdded && view != null
    }
}