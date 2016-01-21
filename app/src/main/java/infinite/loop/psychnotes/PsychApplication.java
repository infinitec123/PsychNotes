package infinite.loop.psychnotes;

import android.app.Application;

import com.firebase.client.Firebase;


public class PsychApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
