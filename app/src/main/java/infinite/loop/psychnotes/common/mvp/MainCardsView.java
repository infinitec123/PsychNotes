package infinite.loop.psychnotes.common.mvp;


import infinite.loop.psychnotes.common.model.PsychNote;

public interface MainCardsView extends PSView {

    void addToCards(PsychNote note);
}
