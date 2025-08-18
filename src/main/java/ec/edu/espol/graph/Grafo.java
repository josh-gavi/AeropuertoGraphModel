package ec.edu.espol.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ec.edu.espol.model.Aeropuerto;
import ec.edu.espol.model.Vuelo;

public class Grafo {

    private Map<Aeropuerto, List<Vuelo>> adyacencia = new HashMap<>();

    public void agregarAeropuerto(Aeropuerto a) {
        if (a != null){
            adyacencia.putIfAbsent(a, new ArrayList<>());
        }
    }
    public boolean agregarVuelo(Aeropuerto source, Aeropuerto target, double distance) {
        if(source==null || target==null || distance < 0) return false;

        return adyacencia.get(source).add(new Vuelo(source, target, distance));
    }
    public void eliminarAeropuerto(Aeropuerto a) {
        if ( a == null || !adyacencia.containsKey(a)) return;
        
        adyacencia.remove(a);
        
        for (List<Vuelo> vuelos : adyacencia.values()) {
            vuelos.removeIf(v -> v.getTarget().equals(a));
        }
    }
    public void eliminarVuelo(Aeropuerto origen, Aeropuerto destino) {
        if (origen == null || destino == null) {
            return;
        }
        
        List<Vuelo> vuelos = adyacencia.get(origen);
        if (vuelos != null) {
            vuelos.removeIf(v -> v.getTarget().equals(destino));
        }
    }

    public Set<Aeropuerto> getAeropuertos() {
        return adyacencia.keySet();
    }

    public List<Vuelo> getVuelosDesde(Aeropuerto a) {
        return adyacencia.getOrDefault(a, new ArrayList<>());
    }

}
