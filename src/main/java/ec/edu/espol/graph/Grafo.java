package ec.edu.espol.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ec.edu.espol.model.Aeropuerto;
import ec.edu.espol.model.Vuelo;

public class Grafo {

    private Map<Aeropuerto, List<Vuelo>> adyacencia = new HashMap<>();

    public void agregarAeropuerto(Aeropuerto a) {

        adyacencia.putIfAbsent(a, new ArrayList<>());

    }
    public boolean agregarVuelo(Aeropuerto source, Aeropuerto target, double distance) {
        if(source==null || target==null || distance < 0){return false;}
        return adyacencia.get(source).add(new Vuelo(source, target, distance));

    }
    public void eliminarAeropuerto(Aeropuerto a) { ... }
    public void eliminarVuelo(Aeropuerto origen, Aeropuerto destino) { ... }

}
