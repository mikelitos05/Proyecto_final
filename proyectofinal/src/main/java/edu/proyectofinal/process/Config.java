package edu.proyectofinal.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase Config que carga las configuraciones desde un archivo de texto.
 * Permite obtener nombres de objetos u otros valores configurables.
 */
public class Config {
    private static Map<String, String> configMap = new HashMap<String, String>();

    static {
        try (BufferedReader br = new BufferedReader(new FileReader("DataBase.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith(":"))
                    continue;
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    configMap.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar archivo de configuración: " + e.getMessage());
        }
    }

    /**
     * Obtiene el valor configurado para una clave dada.
     * @param key La clave de configuración.
     * @return El valor asociado o null si no existe.
     */
    public static String get(String key) {
        return configMap.get(key);
    }
}


