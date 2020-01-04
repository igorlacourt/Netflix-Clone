package com.movies.allmovies.idlingresource

import androidx.annotation.VisibleForTesting

object IdlingResourceManager {
    // The Idling Resource which will be null in production.
    var mIdlingResource: SimpleIdlingResource? = null
    /**
     * Only called from test, creates and returns a new [SimpleIdlingResource].
     */
    @VisibleForTesting
    fun getIdlingResource(): SimpleIdlingResource {
        if (mIdlingResource == null) {
            mIdlingResource = SimpleIdlingResource()
        }
        return mIdlingResource as SimpleIdlingResource
    }

    fun setIdleState(state: Boolean){
        if(mIdlingResource != null)
            mIdlingResource?.setIdleState(state)
    }
}