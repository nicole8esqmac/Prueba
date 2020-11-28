package com.example.proyecto_final;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ListaExpandible extends BaseExpandableListAdapter {

    private Context context;
    private List<String>ListTitulo;
    private HashMap<String, Formula> expandablelistDetalle;

    public ListaExpandible(Context context,
                           List<String> listTitulo,
                           HashMap<String, Formula> expandablelistDetalle) {
        this.context = context;
        this.ListTitulo = listTitulo;
        this.expandablelistDetalle = expandablelistDetalle;
    }


    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        Formula formula = (Formula)getChild(i,i1);

        if (view == null){
            LayoutInflater LayoutInflater = (android.view.LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = LayoutInflater.inflate(R.layout.lista_item, null);
        }



        ImageView ImageView = view.findViewById(R.id.circleIMG);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), formula.getImg());
        ImageView.setImageBitmap(bitmap);


        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        view.startAnimation(animation);

        return view;
    }
    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String nombre = (String) getGroup(i);
        Formula formula =(Formula) getChild(i,0);

        if (view == null){
            LayoutInflater LayoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = LayoutInflater.inflate(R.layout.lista_grupo, null);
        }

        TextView txtNombre = view.findViewById(R.id.txtGroupNombre);
        txtNombre.setText(nombre);

        return view;
    }

    @Override
    public int getGroupCount() {
        return this.ListTitulo.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return this.ListTitulo.get(i);
    }

    @Override
    public Object getChild(int i, int i1) { return this.expandablelistDetalle.get(this.ListTitulo.get(i)); }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
