package co.com.sebas.certification.flash.utils;

import net.serenitybdd.core.Serenity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void readData(int registerNumber) {
        String csvFile = "src/main/resources/DataBases/Clientes.csv";
        String line;
        String csvSplitBy = ";";
        boolean isFirstLine = true;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Leer el archivo línea por línea
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                // Separar los campos utilizando el delimitador ";"
                String[] fields = line.split(csvSplitBy);


                    // Acceder a los datos en cada campo
                    int consecutivo = Integer.parseInt(fields [0]);
                    String celular = fields[1];
                    String cedula = fields[2];
                    String nombre = fields[3];
                    String apellido = fields[4];
                    String correoElectronico = fields[5];
                    String usuario = fields[6];
                    Serenity.setSessionVariable("user").to(usuario);
                    String contrasena = fields[7];
                    Serenity.setSessionVariable("password").to(contrasena);
                    String plan = fields[8];
                    String paquete = fields[9];
                    String fechaUltimaRenovacion = fields[10];
                    String horaUltimaRenovacion = fields[11];
                    String fechaProximaRenovacion = fields[12];
                    String horaProximaRenovacion = fields[13];
                    String flashCoins = fields[14];
                    String renovacionExitosa = fields[15];
                    String consumoMesActual = fields[16];

                if(consecutivo==registerNumber){
                    Serenity.setSessionVariable("user").to(usuario);
                    Serenity.setSessionVariable("password").to(contrasena);
                    // Realizar cualquier operación deseada con los datos
                    System.out.println("Celular: " + celular);
                    System.out.println("Cedula: " + cedula);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Apellido: " + apellido);
                    System.out.println("Correo electrónico: " + correoElectronico);
                    System.out.println("Usuario: " + usuario);
                    System.out.println("Contraseña: " + contrasena);
                    System.out.println("Plan: " + plan);
                    System.out.println("Paquete: " + paquete);
                    System.out.println("Fecha última renovación: " + fechaUltimaRenovacion);
                    System.out.println("Hora última renovación: " + horaUltimaRenovacion);
                    System.out.println("Fecha próxima renovación: " + fechaProximaRenovacion);
                    System.out.println("Hora próxima renovación: " + horaProximaRenovacion);
                    System.out.println("Flash Coins: " + flashCoins);
                    System.out.println("Renovación exitosa: " + renovacionExitosa);
                    System.out.println("Consumo mes actual: " + consumoMesActual);
                    System.out.println("--------------------------------");
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
