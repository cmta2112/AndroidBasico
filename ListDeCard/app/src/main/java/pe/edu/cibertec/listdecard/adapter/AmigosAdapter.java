package pe.edu.cibertec.listdecard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.cibertec.listdecard.R;
import pe.edu.cibertec.listdecard.dto.Amigos;

public class AmigosAdapter extends BaseAdapter{

        private Context context;
        private List<Amigos> list_amigos;

        public AmigosAdapter(Context c, List<Amigos> list_amigos) {
            this.context = c;
            this.list_amigos = list_amigos;
        }

        @Override
        public int getCount() {
            return list_amigos.size();
        }

        @Override
        public Object getItem(int i) {
            return list_amigos.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.amigos_layout, viewGroup, false);
            }
            final Amigos amigos = (Amigos) this.getItem(i);
            ImageView foto = view.findViewById(R.id.foto);
            TextView nombre = view.findViewById(R.id.nombre);
            TextView correo = view.findViewById(R.id.correo);
            foto.setImageResource(amigos.getFoto());
            nombre.setText(amigos.getNombre());
            correo.setText(amigos.getCorreo());
            return view;
        }
    }
