package infinite.loop.psychnotes.common.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * @author Sharath Pandeshwar
 * @since 08/08/2015
 * <p>
 * Interface representing a Presenter in a model view presenter (MVP) pattern. All the presenters in the project
 * have to implement this.
 */
public interface Presenter <T extends PSView> {
    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    void pause();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    void destroy();

    /**
     * Any or All initializations can be done here. This will be called in {@linkplain Activity#onCreate}
     * and {@linkplain android.app.Fragment#onActivityCreated(Bundle) method}
     */
    void initialize();

    /**
     * Set the view which this presenter will manage.
     *
     * @param view
     */
    void setView(@NonNull T view);
}
