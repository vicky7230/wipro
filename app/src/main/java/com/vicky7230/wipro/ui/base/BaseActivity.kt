package com.vicky7230.wipro.ui.base

import android.app.Dialog
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.vicky7230.wipro.utils.CommonUtils

open class BaseActivity : AppCompatActivity() {

    private var progressDialog: Dialog? = null

    fun hasPermissions(permissions: Array<String>): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true
        return permissions.none {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }
    }

    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    private fun displayMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun displayError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun showLoading() {
        hideLoading()
        progressDialog = CommonUtils.showLoadingDialog(this)
    }

    fun hideLoading() {
        if (progressDialog != null) {
            if (progressDialog?.isShowing == true)
                progressDialog?.cancel()
        }
    }

    fun showMessage(message: String?) {
        if (message != null)
            displayMessage(message)
    }

    fun showError(message: String?) {
        if (message != null)
            displayError(message)
    }

    /*fun handleApiError(throwable: Throwable) {
        if (throwable is HttpException) {
            when (throwable.code()) {
                401 -> {
                    showError("sessionId expired or invalid.")
                    // TODO
                    // log out the user and clear his data
                }
            }
        } else {
            showError(throwable.message ?: "")
        }
    }*/
}
