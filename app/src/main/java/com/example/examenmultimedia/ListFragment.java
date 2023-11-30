package com.example.examenmultimedia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ListView listView = (ListView) view.findViewById(R.id.list);

        // Lista de mapas para cada elemento:
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        // Creación un mapa para cada elemento y su inclusión a la lista 'data':
        Map<String, Object> item1 = new HashMap<String, Object>();
        item1.put("logo", R.drawable.sprint);
        item1.put("title", "Extremidades a tope");
        data.add(item1);

        Map<String, Object> item2 = new HashMap<String, Object>();
        item2.put("logo", R.drawable.weigh);
        item2.put("title", "Agonía máxima");
        data.add(item2);

        Map<String, Object> item3 = new HashMap<String, Object>();
        item3.put("logo", R.drawable.core);
        item3.put("title", "Fuerza y longitud");
        data.add(item3);

        Map<String, Object> item4 = new HashMap<String, Object>();
        item4.put("logo", R.drawable.custom);
        item4.put("title", "Entrenamiento especial");
        data.add(item4);

        // String array para identificar las claves del mapa:
        String[] from = {"logo", "title"};

        // array de los IDs de las vistas donde la información será colocada:
        int[] to = {R.id.image_view_logo, R.id.text_view_title};

        // Crea el adaptador con el contexto, la lista de datos, el layout de fila y los arrays 'from' y 'to'
        SimpleAdapter adapter = new SimpleAdapter(getContext(), data, R.layout.list_item, from, to);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Check if we're in horizontal orientation with the second container
                if (getActivity().findViewById(R.id.fragmentContainerViewh2) != null) {
                    // We're in horizontal mode, update the detail fragment
                    Fragment newFragment;
                    switch (position) {
                        case 0:
                            newFragment = new ExtremidadesFragment();
                            break;
                        case 1:
                            newFragment = new AgoniaFragment();
                            break;
                        case 2:
                            newFragment = new FuerzaFragment();
                            break;
                        case 3:
                            newFragment = new EspecialFragment();
                            break;
                        default:
                            return; // Exit if no matching position is found
                    }

                    // Replace the detail fragment container with the new fragment
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentContainerViewh2, newFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                } else {
                    // We're in vertical mode, handle as before
                    Fragment newFragment;
                    switch (position) {
                        case 0:
                            newFragment = new ExtremidadesFragment();
                            break;
                        case 1:
                            newFragment = new AgoniaFragment();
                            break;
                        case 2:
                            newFragment = new FuerzaFragment();
                            break;
                        case 3:
                            newFragment = new EspecialFragment();
                            break;
                        default:
                            return; // Exit if no matching position is found
                    }

                    // Replace the main fragment container with the new fragment
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentContainerView, newFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
        return view;
    }
}