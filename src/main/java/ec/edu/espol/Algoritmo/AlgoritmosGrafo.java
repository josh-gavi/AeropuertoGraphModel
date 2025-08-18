package ec.edu.espol.Algoritmo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import ec.edu.espol.graph.Grafo;
import ec.edu.espol.model.Aeropuerto;
import ec.edu.espol.model.Vuelo;

public class AlgoritmosGrafo {
    public static void dijkstra(Grafo g, Aeropuerto origen, Aeropuerto destino) {
        Map<Aeropuerto, Double> distancias = new HashMap<>();
        for (Aeropuerto a : g.getAeropuertos()) {
            distancias.put(a, Double.POSITIVE_INFINITY);
        }
        distancias.put(origen, 0.0);

        Map<Aeropuerto, Aeropuerto> predecesor = new HashMap<>();

        PriorityQueue<Aeropuerto> pq = new PriorityQueue<>(Comparator.comparing(distancias::get));
        pq.add(origen);

        while (!pq.isEmpty()) {
            Aeropuerto actual = pq.poll();

            // Si llegamos al destino, paramos
            if (actual.equals(destino)) break;

            for (Vuelo v : g.getVuelosDesde(actual)) {
                Aeropuerto vecino = v.getTarget();
                double nuevaDist = distancias.get(actual) + v.getWeight();
                if (nuevaDist < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDist);
                    predecesor.put(vecino, actual);
                    pq.add(vecino);
                }
            }
        }

        // Mostrar resultado
        if (distancias.get(destino) == Double.POSITIVE_INFINITY) {
            System.out.println("No existe ruta entre " + origen.getCode() + " y " + destino.getCode());
        } else {
            System.out.print("Ruta más corta: ");
            imprimirRuta(predecesor, origen, destino);
            System.out.println("\nDistancia total: " + distancias.get(destino));
        }
    }

    private static void imprimirRuta(Map<Aeropuerto, Aeropuerto> predecesor, Aeropuerto origen, Aeropuerto destino) {
        List<Aeropuerto> camino = new ArrayList<>();
        Aeropuerto actual = destino;
        while (actual != null) {
            camino.add(actual);
            actual = predecesor.get(actual);
        }
        Collections.reverse(camino);

        for (int i = 0; i < camino.size(); i++) {
            System.out.print(camino.get(i).getCode());
            if (i < camino.size() - 1) System.out.print(" -> ");
        }
    }
}
