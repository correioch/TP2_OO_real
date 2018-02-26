package com.example.chlopes.tp2_oo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chlopes.tp2_oo.R;
import com.example.chlopes.tp2_oo.model.MorseAlpha;

import java.util.List;

/**
 * Created by chlopes on 2018-02-25.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<MorseAlpha> listMorseAlpha;

    public Adapter(List<MorseAlpha> list) {

        this.listMorseAlpha = list;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_morse, parent, false);

        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        MorseAlpha morseAlpha = listMorseAlpha.get(position);
        holder.alpha.setText(morseAlpha.getAlpha());
        holder.morse.setText((CharSequence) morseAlpha.getMorse());

    }

    @Override
    public int getItemCount() {
        return listMorseAlpha.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView morse;
        TextView alpha;

        public MyViewHolder(View itemView) {
            super(itemView);

            morse = itemView.findViewById(R.id.textMorse);
            alpha = itemView.findViewById(R.id.textAlpha);

        }

    }


}
