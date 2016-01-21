package infinite.loop.psychnotes.common.mvp;

import android.content.Context;

/**
 * @author Sharath Pandeshwar
 * @since 08/08/2015
 * <p>
 * Interface all the Views (of a model view presenter (MVP) pattern) of the project have to implement.
 */
public interface PSView {
    /**
     * Indicate the data loading is in progress.
     */
    void showLoading();

    /**
     * Hide data loading indicator.
     */
    void hideLoading();


    /**
     * Hide a retry view shown if there was an error when retrieving data.
     */
    void hideError();

    /**
     * Show an error message
     *
     * @param message A string representing an error.
     */
    void showError(String message);

    /**
     * Show a success message
     *
     * @param message A string representing a success.
     */
    void showSuccess(String message);

    /**
     * Get a {@link Context}.
     */
    Context getContext();
}
