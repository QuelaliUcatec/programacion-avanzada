import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HistorialManager {
    private static final String RUTA = "../data/historial.json";
    private Gson gson = new Gson();

    // Lee el archivo y devuelve la lista de partidas ya guardadas
    public List<Partida> cargarHistorial() {
        try (FileReader reader = new FileReader(RUTA)) {
            Type tipoLista = new TypeToken<List<Partida>>(){}.getType();
            List<Partida> lista = gson.fromJson(reader, tipoLista);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            // El archivo no existe todavia (primera vez que se juega)
            return new ArrayList<>();
        }
    }

    // Agrega una partida nueva y reescribe el archivo completo
    public void guardarPartida(Partida partida) {
        List<Partida> historial = cargarHistorial();
        historial.add(partida);

        try (FileWriter writer = new FileWriter(RUTA)) {
            gson.toJson(historial, writer);
        } catch (IOException e) {
            System.out.println("No se pudo guardar el historial: " + e.getMessage());
        }
    }
}