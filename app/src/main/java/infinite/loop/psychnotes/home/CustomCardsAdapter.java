package infinite.loop.psychnotes.home;


import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andtinder.view.BaseCardStackAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import infinite.loop.psychnotes.R;
import infinite.loop.psychnotes.common.Utils;
import infinite.loop.psychnotes.common.model.PsychNote;

public final class CustomCardsAdapter extends BaseCardStackAdapter {

    private List<PsychNote> mNotes;
    private Context mContext;

    public CustomCardsAdapter(Context context) {
        mContext = context;
        mNotes = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return mNotes.size();
    }

    @Override
    public Object getItem(int i) {
        return mNotes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mNotes.get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.layout_card, parent, false);
            assert convertView != null;
        }

        PsychNote note = mNotes.get(position);

        ImageView thumbNail = ((ImageView) convertView.findViewById(R.id.id_image));
        if (Utils.isNonNullAndNonEmpty(note.getImage_url())) {
            Picasso.with(mContext).load(note.getImage_url()).placeholder(R.drawable.psych_placeholder).error(R.drawable.psych_placeholder).into(thumbNail);
        } else {
            thumbNail.setImageDrawable(mContext.getResources().getDrawable(R.drawable.psych_placeholder));
        }

        ((TextView) convertView.findViewById(R.id.id_brief)).setText(note.getBrief());
        ((TextView) convertView.findViewById(R.id.id_title)).setText(note.getTitle());
        ((TextView) convertView.findViewById(R.id.id_description)).setText(Html.fromHtml(note.getDescriptionHTML()));

        return convertView;
    }

    public void addNotes(PsychNote note) {
        mNotes.add(note);
        notifyDataSetChanged();
    }
}
