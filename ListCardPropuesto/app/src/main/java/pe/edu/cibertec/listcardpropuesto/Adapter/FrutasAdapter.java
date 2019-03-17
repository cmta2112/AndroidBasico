package pe.edu.cibertec.listcardpropuesto.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.cibertec.listcardpropuesto.R;
import pe.edu.cibertec.listcardpropuesto.dto.Frutas;

public class FrutasAdapter extends BaseAdapter{

    private Context context;
    private List<Frutas> list_frutas;

    public FrutasAdapter(Context c, List<Frutas> list_frutas) {
        this.context = c;
        this.list_frutas = list_frutas;
    }

    @Override
    public int getCount() {
        return list_frutas.size();
    }

    @Override
    public Object getItem(int i) {
        return list_frutas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.frutas_layout, viewGroup, false);
        }
        final Frutas frutas = (Frutas) this.getItem(i);
        ImageView foto = view.findViewById(R.id.foto);
        TextView nombre = view.findViewById(R.id.nombre);
        TextView correo = view.findViewById(R.id.descripcion);
        foto.setImageResource(frutas.getFoto());
        nombre.setText(frutas.getNombre());
        correo.setText(frutas.getDescripcion());
        return view;
    }
}
