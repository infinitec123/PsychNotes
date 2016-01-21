package infinite.loop.psychnotes.common.mvp;


import android.support.annotation.NonNull;
import android.util.Log;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import infinite.loop.psychnotes.common.model.PsychNote;

public class MainCardsPresenter implements Presenter<MainCardsView> {

    private final static String TAG = "MainCardsPresenter";

    private MainCardsView mMainCardsView;
    Firebase mFirebaseRef;

    public MainCardsPresenter() {
        mFirebaseRef = new Firebase("https://sizzling-inferno-2645.firebaseio.com/notes");
        mFirebaseRef.keepSynced(true);
    }

    @Override
    public void setView(@NonNull MainCardsView view) {
        mMainCardsView = view;
        this.mMainCardsView.showLoading();

        mFirebaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                PsychNote note = dataSnapshot.getValue(PsychNote.class);
                //Log.v(TAG, note.toString());
                MainCardsPresenter.this.mMainCardsView.hideLoading();
                mMainCardsView.addToCards(note);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e(TAG, firebaseError.toString());
            }
        });
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void initialize() {

    }
}
