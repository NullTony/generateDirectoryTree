
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DirectoryTree {

    // Metodo para generar el arbol de directorios
    public static List<String> generateDirectoryTree(File directory, String prefix, List<String> excludePatterns) {

        List<String> output = new ArrayList<>(); // Almacenar las lienas del arbol
        File[] items = directory.listFiles(); // Obtener archivos y carpetas del directorio

        // En el caso de que no haya archivos, carpetas o no se pueda acceder se retorna la lista vacioa
        if (items == null) {
            return output;
        }

        // Se odenan primero directorios y luego los archivos
        Arrays.sort(items, (a, b) -> {
            boolean directoryA = a.isDirectory(); // Verificar si 'a' es directorio
            boolean directoryB = b.isDirectory(); // Verificar si 'b' es directorio

            if (directoryA == directoryB) {

                // Se ordena alfabeticamente
                return a.getName().compareToIgnoreCase(b.getName());
            }

            // Se prioriza primero los directorios y despues los archivos
            return directoryA ? 1 : -1;
        });

        // Se recorre cada directorio y archivo
        for (int i = 0; i < items.length; i++) {
            File item = items[i];
            String itemName = item.getName();

            // Se verifica si el directorio o archivo no esta en la lista negra
            if (excludePatterns
                    .stream()
                    .anyMatch(itemName::contains)) {
                continue;
            }

            boolean isLast = (i == items.length - 1);

            // Se usa '└──' para cada ultimo directorio o archivo y se usa '├──' para los demas
            String connector = isLast ? "└── " : "├── ";

            // Se agrega el directorio o archivo a la lista
            output.add(prefix + connector + itemName);

            // Si es un directorio se genera su subarbol recursivamente
            if (item.isDirectory()) {
                String extension = isLast ? "    " : "│   ";
                output.addAll(generateDirectoryTree(item, prefix + extension, excludePatterns));
            }
        }

        return output;
    }

    // Metodo para imprimir el arbol de directorios
    public static void printDirectoryTree(String directoryPath, List<String> excludePattens) {

        // Se crea un objeto de tipo File con la ruta del directorio
        File root = new File(directoryPath);

        // Se verifica si la ruta es un directorio valido
        if (!root.exists() || !root.isDirectory()) {
            System.out.println("La ruta del directorio no es valida.");

            return;
        }

        System.out.println("📂" + root.getName());

        // Se genera el arbol de directorios
        List<String> tree = generateDirectoryTree(root, "", excludePattens);

        // Se imprime cada linea del arbol
        for (String line : tree) {
            System.err.println(line);
        }
    }

    // Metodo para reemplazar las barras en caso de ingresar una ruta de windows
    public static String normalizePath(String path) {
        return path.replace("\\", "/");
    }

    // Metodo principal
    public static void main(String[] args) {

        // Se crea y solicita la ruta del directorio
        try (Scanner enterRoute = new Scanner(System.in)) {
            System.out.println("Ingresa la ruta a crear el arbol de directorios: ");

            String directoryPath = enterRoute.nextLine();

            // Se normaliza la ruta en caso de ser de windows
            directoryPath = normalizePath(directoryPath);

            // Se crea una lista con los directorios que se desean excluir
            List<String> excludePatterns = Arrays.asList(); // ej: ".git", "node_modules", etc

            // Se genera e imprime el arbol de directorios
            printDirectoryTree(directoryPath, excludePatterns);
        }
    }
}
