package infinite.loop.psychnotes;

import android.app.Application;

import com.firebase.client.Firebase;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class PsychApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Verdana.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }
}
