import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.sql.statement;
import java.util.ArrayList;
import java.Scanner;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.Date;
import java.sql.Statement;
import java.io.Closeable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;



import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import com.cine.Data.Entity;


public interface iDatapostCRUD {
    // Configura los detalles de conexión a la base de datos
    String url = "jdbc:mysql://localhost:3306/sakila";
    String username = "tu_usuario";
    String password = "tu_contraseña";
    
    // Método para crear un nuevo registro
    default void create(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            System.out.println("Registro creado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear el registro: " + e.getMessage());
        }
    }
    
    // Método para leer un registro
    default void read(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                // Procesa los datos del resultado
                // Ejemplo: String name = resultSet.getString("name");
                //         int age = resultSet.getInt("age");
                //         System.out.println("Nombre: " + name + ", Edad: " + age);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer los registros: " + e.getMessage());
        }
    }
    
    // Método para actualizar un registro
    default void update(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            System.out.println("Registro actualizado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el registro: " + e.getMessage());
        }
    }
    
    // Método para eliminar un registro
    default void delete(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            System.out.println("Registro eliminado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el registro: " + e.getMessage());
        }
    }


//*******************************************************************************************

public abstract class DataContext {
    // Configura los detalles de conexión a la base de datos
    protected String url = "jdbc:mysql://localhost:3306/sakila";
    protected String username = "tu_usuario";
    protected String password = "tu_contraseña";
    
    // Método para realizar actualizaciones en la base de datos
    public final void put(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            System.out.println("Actualización realizada con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al realizar la actualización: " + e.getMessage());
        }
    }
    
    // Método para obtener datos de la base de datos o realizar búsquedas
    public final void get(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                // Procesa los datos del resultado
                // Ejemplo: String name = resultSet.getString("name");
                //         int age = resultSet.getInt("age");
                //         System.out.println("Nombre: " + name + ", Edad: " + age);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos: " + e.getMessage());
        }
    }
    
    // Método para insertar nuevos datos en la base de datos
    public final void post(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            System.out.println("Inserción realizada con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al realizar la inserción: " + e.getMessage());
        }
    }
    
    // Método para eliminar datos de la base de datos
    public final void delete(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            System.out.println("Eliminación realizada con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al realizar la eliminación: " + e.getMessage());
        }
    }
    
    // Otros métodos y lógica de la clase DataContext...


//************************************************************************************

public class InventarioController {
    private InventarioModel inventarioModel;
    private InventarioView inventarioView;
    
    public InventarioController(InventarioModel inventarioModel, InventarioView inventarioView) {
        this.inventarioModel = inventarioModel;
        this.inventarioView = inventarioView;
    }
    
    // Métodos para gestionar el inventario (CRUD)...
}

public class RentasController {
    private RentasModel rentasModel;
    private RentasView rentasView;
    
    public RentasController(RentasModel rentasModel, RentasView rentasView) {
        this.rentasModel = rentasModel;
        this.rentasView = rentasView;
    }
    
    // Métodos para gestionar las rentas (CRUD)...
}

public class PeliculasController {
    private PeliculasModel peliculasModel;
    private PeliculasView peliculasView;
    
    public PeliculasController(PeliculasModel peliculasModel, PeliculasView peliculasView) {
        this.peliculasModel = peliculasModel;
        this.peliculasView = peliculasView;
    }
    
    // Métodos para gestionar las películas (CRUD)...
}


//**************************************************************************************


//Estructura basica de la interfaz de Consola

public class ConsoleUI {
    private InventarioController inventarioController;
    private RentasController rentasController;
    private PeliculasController peliculasController;
    
    public ConsoleUI() {
        this.inventarioController = new InventarioController();
        this.rentasController = new RentasController();
        this.peliculasController = new PeliculasController();
    }
    
    public void mostrarMenuPrincipal() {
        boolean salir = false;
        
        while (!salir) {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestionar Inventario");
            System.out.println("2. Gestionar Rentas");
            System.out.println("3. Gestionar Películas");
            System.out.println("4. Salir");
            
            int opcion = obtenerOpcion();
            
            switch (opcion) {
                case 1:
                    gestionarInventario();
                    break;
                case 2:
                    gestionarRentas();
                    break;
                case 3:
                    gestionarPeliculas();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }
        }
    }
    
    private void gestionarInventario() {
        // Lógica para gestionar el inventario (CRUD) en la interfaz de consola
    }
    
    private void gestionarRentas() {
        // Lógica para gestionar las rentas (CRUD) en la interfaz de consola
    }
    
    private void gestionarPeliculas() {
        // Lógica para gestionar las películas (CRUD) en la interfaz de consola
    }
    
    private int obtenerOpcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu opción: ");
        
        while (!scanner.hasNextInt()) {
            System.out.println("Opción inválida. Por favor, ingresa un número válido.");
            System.out.print("Ingresa tu opción: ");
            scanner.next();
        }
        
        return scanner.nextInt();
    }
}


//***********************************************************************************************


// Gestion de inventario





public class InventoryManager {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public InventoryManager() {
        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "usuario", "contraseña");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        int choice;

        do {
            System.out.println("-------- Menú de Gestión de Inventario --------");
            System.out.println("1. Crear Registro en el Inventario");
            System.out.println("2. Mostrar Registros del Inventario");
            System.out.println("3. Actualizar Registro del Inventario");
            System.out.println("4. Eliminar Registro del Inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            switch (choice) {
                case 1:
                    createInventoryRecord();
                    break;
                case 2:
                    displayInventoryRecords();
                    break;
                case 3:
                    updateInventoryRecord();
                    break;
                case 4:
                    deleteInventoryRecord();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }

            System.out.println();
        } while (choice != 5);
    }

    private void createInventoryRecord() {
        try {
            System.out.println("-------- Crear Registro en el Inventario --------");
            System.out.print("Ingrese el ID de la película: ");
            int filmId = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            // Verificar si la película existe en la base de datos
            String checkFilmQuery = "SELECT count(*) FROM film WHERE film_id = ?";
            preparedStatement = connection.prepareStatement(checkFilmQuery);
            preparedStatement.setInt(1, filmId);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            int count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("La película con el ID proporcionado no existe en la base de datos.");
                return;
            }

            System.out.print("Ingrese el ID de la tienda: ");
            int storeId = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            // Verificar si la tienda existe en la base de datos
            String checkStoreQuery = "SELECT count(*) FROM store WHERE store_id = ?";
            preparedStatement = connection.prepareStatement(checkStoreQuery);
            preparedStatement.setInt(1, storeId);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("La tienda con el ID proporcionado no existe en la base de datos.");
                return;
            }

            // Insertar el registro en el inventario
            String insertQuery = "INSERT INTO inventory (film_id, store_id) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, filmId);
            preparedStatement.setInt(2, storeId);
            preparedStatement.executeUpdate();

            System.out.println("Registro en el inventario creado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayInventoryRecords() {
        try {
            System.out.println("-------- Registros del Inventario --------");

            String selectQuery = "SELECT * FROM inventory";
            resultSet = statement.executeQuery(selectQuery);

            if (!resultSet.next()) {
                System.out.println("No hay registros en el inventario.");
            } else {
                do {
                    int inventoryId = resultSet.getInt("inventory_id");
                    int filmId = resultSet.getInt("film_id");
                    int storeId = resultSet.getInt("store_id");

                    System.out.println("ID de Inventario: " + inventoryId);
                    System.out.println("ID de Película: " + filmId);
                    System.out.println("ID de Tienda: " + storeId);
                    System.out.println("--------------------");
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateInventoryRecord() {
        try {
            System.out.println("-------- Actualizar Registro del Inventario --------");
            System.out.print("Ingrese el ID del registro de inventario a actualizar: ");
            int inventoryId = scanner.nextInt();
            scanner.nextLine(); //Vaciar el búfer del scanner

            // Verificar si el registro de inventario existe en la base de datos
            String checkInventoryQuery = "SELECT count(*) FROM inventory WHERE inventory_id = ?";
            preparedStatement = connection.prepareStatement(checkInventoryQuery);
            preparedStatement.setInt(1, inventoryId);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            int count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("El registro de inventario con el ID proporcionado no existe en la base de datos.");
                return;
            }

            System.out.print("Ingrese el nuevo ID de la película: ");
            int newFilmId = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            // Verificar si la nueva película existe en la base de datos
            String checkFilmQuery = "SELECT count(*) FROM film WHERE film_id = ?";
            preparedStatement = connection.prepareStatement(checkFilmQuery);
            preparedStatement.setInt(1, newFilmId);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("La película con el ID proporcionado no existe en la base de datos.");
                return;
            }

            System.out.print("Ingrese el nuevo ID de la tienda: ");
            int newStoreId = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            // Verificar si la nueva tienda existe en la base de datos
            String checkStoreQuery = "SELECT count(*) FROM store WHERE store_id = ?";
            preparedStatement = connection.prepareStatement(checkStoreQuery);
            preparedStatement.setInt(1, newStoreId);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("La tienda con el ID proporcionado no existe en la base de datos.");
                return;
            }

            // Actualizar el registro de inventario
            String updateQuery = "UPDATE inventory SET film_id = ?, store_id = ? WHERE inventory_id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, newFilmId);
            preparedStatement.setInt(2, newStoreId);
            preparedStatement.setInt(3, inventoryId);
            preparedStatement.executeUpdate();

            System.out.println("Registro del inventario actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteInventoryRecord() {
        try {
            System.out.println("-------- Eliminar Registro del Inventario --------");
            System.out.print("Ingrese el ID del registro de inventario a eliminar: ");
            int inventoryId = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            // Verificar si el registro de inventario existe en la base de datos
            String checkInventoryQuery = "SELECT count(*) FROM inventory WHERE inventory_id = ?";
            preparedStatement = connection.prepareStatement(checkInventoryQuery);
            preparedStatement.setInt(1, inventoryId);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            int count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("El registro de inventario con el ID proporcionado no existe en la base de datos.");
                return;
            }

            // Eliminar el registro de inventario
            String deleteQuery = "DELETE FROM inventory WHERE inventory_id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, inventoryId);
            preparedStatement.executeUpdate();

            System.out.println("Registro del inventario eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    






//*******************************************************************************************






//**************************************************************************************

// Gestion de la clase Author


public class AuthorManager {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public AuthorManager() {
        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "usuario", "contraseña");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAuthor(Author author) {
        try {
            // Consulta preparada para insertar un registro de autor
            String insertQuery = "INSERT INTO author (name, email) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getEmail());
            preparedStatement.executeUpdate();

            System.out.println("Autor creado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Author getAuthor(int id) {
        Author author = null;
        try {
            // Consulta preparada para obtener un autor por su ID
            String selectQuery = "SELECT * FROM author WHERE id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                author = new Author(id, name, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    public void updateAuthor(Author author) {
        try {
            // Consulta preparada para actualizar un autor por su ID
            String updateQuery = "UPDATE author SET name = ?, email = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getEmail());
            preparedStatement.setInt(3, author.getId());
            preparedStatement.executeUpdate();

            System.out.println("Autor actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAuthor(int id) {
        try {
            // Consulta preparada para eliminar un autor por su ID
            String deleteQuery = "DELETE FROM author WHERE id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Autor eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



//**************************************************************************************

// Gestion de Autores 

;

public class AuthorManager {
    private Connection connection;
    private Scanner scanner;

    public AuthorManager() {
        scanner = new Scanner(System.in);
    }

    public void connectToDatabase() {
        try {
            // Establecer conexión con la base de datos
            String url = "jdbc:mysql://localhost:3306/nombre_base_de_datos";
            String username = "tu_usuario";
            String password = "tu_contraseña";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public void disconnectFromDatabase() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Desconexión exitosa de la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectar de la base de datos: " + e.getMessage());
        }
    }

    public void start() {
        connectToDatabase();

        int choice;

        do {
            System.out.println("-------- Menú de Gestión de Autores --------");
            System.out.println("1. Crear Autor");
            System.out.println("2. Mostrar Autores");
            System.out.println("3. Actualizar Autor");
            System.out.println("4. Eliminar Autor");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            switch (choice) {
                case 1:
                    createAuthor();
                    break;
                case 2:
                    displayAuthors();
                    break;
                case 3:
                    updateAuthor();
                    break;
                case 4:
                    deleteAuthor();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }

            System.out.println();
        } while (choice != 5);

        disconnectFromDatabase();
    }

    private void createAuthor() {
        System.out.println("-------- Crear Autor --------");
        System.out.print("Ingrese el nombre del autor: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese la nacionalidad del autor: ");
        String nationality = scanner.nextLine();

        try {
            // Insertar el nuevo autor en la base de datos
            String query = "INSERT INTO authors (name, nationality) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, nationality);
            statement.executeUpdate();
            System.out.println("Autor creado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear el autor: " + e.getMessage());
        }
    }

    private void displayAuthors() {
        System.out.println("-------- Autores Registrados --------");

        try {
            // Obtener todos los autores de la base de datos
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM authors";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String nationality = resultSet.getString("nationality");
                System.out.println("ID: " + id + ", Nombre: " + name + ", Nacionalidad: " + nationality);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los autores: " + e.getMessage());
        }
    }

    private void updateAuthor() {
        System.out.println("-------- Actualizar Autor --------");
        System.out.print("Ingrese el ID del autor a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            // Verificar si el autor existe en la base de datos
            String query = "SELECT * FROM authors WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.print("Ingrese el nuevo nombre del autor: ");
                String newName = scanner.nextLine();
                System.out.print("Ingrese la nueva nacionalidad del autor: ");
                String newNationality = scanner.nextLine();

                // Actualizar el autor en la base de datos
                String updateQuery = "UPDATE authors SET name = ?, nationality = ? WHERE id = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
				preparedStatement.executeUpdate();
				
				System.out.println("Autor actualiznado exitosamente.");
				
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


public class AuthorManager {
    private Connection connection;
    private Scanner scanner;

    public AuthorManager() {
        scanner = new Scanner(System.in);
    }

    public void connectToDatabase() {
        try {
            // Establecer conexión con la base de datos
            String url = "jdbc:mysql://localhost:3306/nombre_base_de_datos";
            String username = "tu_usuario";
            String password = "tu_contraseña";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public void disconnectFromDatabase() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Desconexión exitosa de la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectar de la base de datos: " + e.getMessage());
        }
    }

    public void start() {
        connectToDatabase();

        int choice;

        do {
            System.out.println("-------- Menú de Gestión de Autores --------");
            System.out.println("1. Crear Autor");
            System.out.println("2. Mostrar Autores");
            System.out.println("3. Actualizar Autor");
            System.out.println("4. Eliminar Autor");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            switch (choice) {
                case 1:
                    createAuthor();
                    break;
                case 2:
                    displayAuthors();
                    break;
                case 3:
                    updateAuthor();
                    break;
                case 4:
                    deleteAuthor();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }

            System.out.println();
        } while (choice != 5);

        disconnectFromDatabase();
    }

    private void createAuthor() {
        System.out.println("-------- Crear Autor --------");
        System.out.print("Ingrese el nombre del autor: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese la nacionalidad del autor: ");
        String nationality = scanner.nextLine();

        try {
            // Insertar el nuevo autor en la base de datos
            String query = "INSERT INTO authors (name, nationality) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, nationality);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Autor creado exitosamente.");
            } else {
                System.out.println("Error al crear el autor.");
            }
        } catch (SQLException e) {
            System.out.println("Error al crear el autor: " + e.getMessage());
        }
    }

    private void displayAuthors() {
        System.out.println("-------- Autores Registrados --------");

        try {
            // Obtener todos los autores de la base de datos
            String query = "SELECT * FROM authors";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String nationality = resultSet.getString("nationality");
                System.out.println("ID: " + id + ", Nombre: " + name + ", Nacionalidad: " + nationality);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los autores: " + e.getMessage());
        }
    }

    private void updateAuthor() {
        System.out.println("-------- Actualizar Autor --------");
        System.out.print("Ingrese el ID del autor a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            // Verificar si el autor existe en la base de datos
            String query = "SELECT * FROM authors WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.print("Ingrese el nuevo nombre del autor: ");
                String newName = scanner.nextLine();
                System.out.print("Ingrese la nueva nacionalidad del autor: ");
                String newNationality = scanner.nextLine();

                // Actualizar el autor en la base de datos
                String updateQuery = "UPDATE authors SET name = ?";
				
			}
			System.out.println("Autor actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
			
		}
	}
				
}			
//****************************************************************************************

// Gestionar la clase staff 



public class StaffManager {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public StaffManager() {
        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "usuario", "contraseña");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createStaff(Staff staff) {
        try {
            // Consulta preparada para insertar un registro de personal
            String insertQuery = "INSERT INTO staff (first_name, last_name, email) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, staff.getFirstName());
            preparedStatement.setString(2, staff.getLastName());
            preparedStatement.setString(3, staff.getEmail());
            preparedStatement.executeUpdate();

            System.out.println("Personal creado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Staff getStaff(int id) {
        Staff staff = null;
        try {
            // Consulta preparada para obtener información de un miembro del personal por su ID
            String selectQuery = "SELECT * FROM staff WHERE id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                staff = new Staff(id, firstName, lastName, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staff;
    }

    public void updateStaff(Staff staff) {
        try {
            // Consulta preparada para actualizar información de un miembro del personal por su ID
            String updateQuery = "UPDATE staff SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, staff.getFirstName());
            preparedStatement.setString(2, staff.getLastName());
            preparedStatement.setString(3, staff.getEmail());
            preparedStatement.setInt(4, staff.getId());
            preparedStatement.executeUpdate();

            System.out.println("Información del personal actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStaff(int id) {
        try {
            // Consulta preparada para eliminar un miembro del personal por su ID
            String deleteQuery = "DELETE FROM staff WHERE id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Personal eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



//*******************************************************************************************


//gestionar la clase Staff




//****************************************************************************

//gestionar la clase Film 

         

//****************************************************************************

// Gestionar la clase Filn




public class FilmManager {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public FilmManager() {
        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "usuario", "contraseña");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createFilm(Film film) {
        try {
            // Consulta preparada para insertar un registro de película
            String insertQuery = "INSERT INTO film (title, description, release_year) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, film.getTitle());
            preparedStatement.setString(2, film.getDescription());
            preparedStatement.setInt(3, film.getReleaseYear());
            preparedStatement.executeUpdate();

            System.out.println("Película creada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Film getFilm(int id) {
        Film film = null;
        try {
            // Consulta preparada para obtener información de una película por su ID
            String selectQuery = "SELECT * FROM film WHERE film_id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                int releaseYear = resultSet.getInt("release_year");
                film = new Film(id, title, description, releaseYear);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    public void updateFilm(Film film) {
        try {
            // Consulta preparada para actualizar información de una película por su ID
            String updateQuery = "UPDATE film SET title = ?, description = ?, release_year = ? WHERE film_id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, film.getTitle());
            preparedStatement.setString(2, film.getDescription());
            preparedStatement.setInt(3, film.getReleaseYear());
            preparedStatement.setInt(4, film.getId());
            preparedStatement.executeUpdate();

            System.out.println("Información de la película actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFilm(int id) {
        try {
            // Consulta preparada para eliminar una película por su ID
            String deleteQuery = "DELETE FROM film WHERE film_id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Película eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




//****************************************************************************

// Gestionar la clase Customer




public class CustomerManager {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CustomerManager() {
        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "usuario", "contraseña");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCustomer(Customer customer) {
        try {
            // Consulta preparada para insertar un registro de cliente
            String insertQuery = "INSERT INTO customer (first_name, last_name, email) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.executeUpdate();

            System.out.println("Cliente creado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomer(int id) {
        Customer customer = null;
        try {
            // Consulta preparada para obtener información de un cliente por su ID
            String selectQuery = "SELECT * FROM customer WHERE customer_id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                customer = new Customer(id, firstName, lastName, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void updateCustomer(Customer customer) {
        try {
            // Consulta preparada para actualizar información de un cliente por su ID
            String updateQuery = "UPDATE customer SET first_name = ?, last_name = ?, email = ? WHERE customer_id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setInt(4, customer.getId());
            preparedStatement.executeUpdate();

            System.out.println("Información del cliente actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int id) {
        try {
            // Consulta preparada para eliminar un cliente por su ID
            String deleteQuery = "DELETE FROM customer WHERE customer_id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Cliente eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




//******************************************************************************

//  gestionar la clase Customer

   

     
//**********************************************************************************

//		Gestionar la clase Store



public class StoreManager {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public StoreManager() {
        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "usuario", "contraseña");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createStore(Store store) {
        try {
            // Consulta preparada para insertar un registro de tienda
            String insertQuery = "INSERT INTO store (manager_staff_id, address_id) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, store.getManagerStaffId());
            preparedStatement.setInt(2, store.getAddressId());
            preparedStatement.executeUpdate();

            System.out.println("Tienda creada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Store getStore(int id) {
        Store store = null;
        try {
            // Consulta preparada para obtener información de una tienda por su ID
            String selectQuery = "SELECT * FROM store WHERE store_id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int managerStaffId = resultSet.getInt("manager_staff_id");
                int addressId = resultSet.getInt("address_id");
                store = new Store(id, managerStaffId, addressId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return store;
    }

    public void updateStore(Store store) {
        try {
            // Consulta preparada para actualizar información de una tienda por su ID
            String updateQuery = "UPDATE store SET manager_staff_id = ?, address_id = ? WHERE store_id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, store.getManagerStaffId());
            preparedStatement.setInt(2, store.getAddressId());
            preparedStatement.setInt(3, store.getId());
            preparedStatement.executeUpdate();

            System.out.println("Información de la tienda actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStore(int id) {
        try {
            // Consulta preparada para eliminar una tienda por su ID
            String deleteQuery = "DELETE FROM store WHERE store_id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Tienda eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//*************************************************************************************

//  gestionar la clase Store 


         



//**********************************************************************************


//  Gestionar la clase payment





public class PaymentManager {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public PaymentManager() {
        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "usuario", "contraseña");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPayment(Payment payment) {
        try {
            // Consulta preparada para insertar un registro de pago
            String insertQuery = "INSERT INTO payment (customer_id, staff_id, amount, payment_date) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, payment.getCustomerId());
            preparedStatement.setInt(2, payment.getStaffId());
            preparedStatement.setDouble(3, payment.getAmount());
            preparedStatement.setTimestamp(4, new Timestamp(payment.getPaymentDate().getTime()));
            preparedStatement.executeUpdate();

            System.out.println("Pago creado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Payment getPayment(int id) {
        Payment payment = null;
        try {
            // Consulta preparada para obtener información de un pago por su ID
            String selectQuery = "SELECT * FROM payment WHERE payment_id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                int staffId = resultSet.getInt("staff_id");
                double amount = resultSet.getDouble("amount");
                Timestamp paymentDate = resultSet.getTimestamp("payment_date");
                payment = new Payment(id, customerId, staffId, amount, paymentDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

    public void updatePayment(Payment payment) {
        try {
            // Consulta preparada para actualizar información de un pago por su ID
            String updateQuery = "UPDATE payment SET customer_id = ?, staff_id = ?, amount = ?, payment_date = ? WHERE payment_id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, payment.getCustomerId());
            preparedStatement.setInt(2, payment.getStaffId());
            preparedStatement.setDouble(3, payment.getAmount());
            preparedStatement.setTimestamp(4, new Timestamp(payment.getPaymentDate().getTime()));
            preparedStatement.setInt(5, payment.getId());
            preparedStatement.executeUpdate();

            System.out.println("Información del pago actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePayment(int id) {
        try {
            // Consulta preparada para eliminar un pago por su ID
            String deleteQuery = "DELETE FROM payment WHERE payment_id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Pago eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



//**********************************************************************************


//gestionar la clase Payment 




//***************************************************************************************


//******Gestionar clase film category



public class FilmCategoryManager {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public FilmCategoryManager() {
        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "usuario", "contraseña");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createFilmCategory(FilmCategory filmCategory) {
        try {
            // Consulta preparada para insertar una nueva categoría de película
            String insertQuery = "INSERT INTO film_category (film_id, category_id) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, filmCategory.getFilmId());
            preparedStatement.setInt(2, filmCategory.getCategoryId());
            preparedStatement.executeUpdate();

            System.out.println("Categoría de película creada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FilmCategory getFilmCategory(int filmId, int categoryId) {
        FilmCategory filmCategory = null;
        try {
            // Consulta preparada para obtener información de una categoría de película por su film_id y category_id
            String selectQuery = "SELECT * FROM film_category WHERE film_id = ? AND category_id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, filmId);
            preparedStatement.setInt(2, categoryId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                filmCategory = new FilmCategory(filmId, categoryId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmCategory;
    }

    public void updateFilmCategory(FilmCategory filmCategory) {
        try {
            // Consulta preparada para actualizar información de una categoría de película por su film_id y category_id
            String updateQuery = "UPDATE film_category SET film_id = ?, category_id = ? WHERE film_id = ? AND category_id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, filmCategory.getFilmId());
            preparedStatement.setInt(2, filmCategory.getCategoryId());
            preparedStatement.setInt(3, filmCategory.getFilmId());
            preparedStatement.setInt(4, filmCategory.getCategoryId());
            preparedStatement.executeUpdate();

            System.out.println("Información de la categoría de película actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFilmCategory(int filmId, int categoryId) {
        try {
            // Consulta preparada para eliminar una categoría de película por su film_id y category_id
            String deleteQuery = "DELETE FROM film_category WHERE film_id = ? AND category_id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, filmId);
            preparedStatement.setInt(2, categoryId);
            preparedStatement.executeUpdate();

            System.out.println("Categoría de película eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}






//*******************************************************************************************

//gestionar la clase FilmCategory 



//************************************************************************************

// ****	Gestionar la clase Address 



public class AddressManager {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public AddressManager() {
        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "usuario", "contraseña");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAddress(Address address) {
        try {
            // Consulta preparada para insertar una nueva dirección
            String insertQuery = "INSERT INTO address (address, city_id, postal_code, phone) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, address.getAddress());
            preparedStatement.setInt(2, address.getCityId());
            preparedStatement.setString(3, address.getPostalCode());
            preparedStatement.setString(4, address.getPhone());
            preparedStatement.executeUpdate();

            System.out.println("Dirección creada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Address getAddress(int id) {
        Address address = null;
        try {
            // Consulta preparada para obtener información de una dirección por su ID
            String selectQuery = "SELECT * FROM address WHERE address_id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String addressText = resultSet.getString("address");
                int cityId = resultSet.getInt("city_id");
                String postalCode = resultSet.getString("postal_code");
                String phone = resultSet.getString("phone");
                address = new Address(id, addressText, cityId, postalCode, phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    public void updateAddress(Address address) {
        try {
            // Consulta preparada para actualizar información de una dirección por su ID
            String updateQuery = "UPDATE address SET address = ?, city_id = ?, postal_code = ?, phone = ? WHERE address_id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, address.getAddress());
            preparedStatement.setInt(2, address.getCityId());
            preparedStatement.setString(3, address.getPostalCode());
            preparedStatement.setString(4, address.getPhone());
            preparedStatement.setInt(5, address.getId());
            preparedStatement.executeUpdate();

            System.out.println("Información de la dirección actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAddress(int id) {
        try {
            // Consulta preparada para eliminar una dirección por su ID
            String deleteQuery = "DELETE FROM address WHERE address_id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Dirección eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




// ************************************************************************************                            
  //		gestionar la clase Address
  
 



//*******************************************************************************


// **************Gestionar la clase Language **************************************




public class LanguageManager {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public LanguageManager() {
        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "usuario", "contraseña");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createLanguage(Language language) {
        try {
            // Consulta preparada para insertar un nuevo idioma
            String insertQuery = "INSERT INTO language (name) VALUES (?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, language.getName());
            preparedStatement.executeUpdate();

            System.out.println("Idioma creado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Language getLanguage(int id) {
        Language language = null;
        try {
            // Consulta preparada para obtener información de un idioma por su ID
            String selectQuery = "SELECT * FROM language WHERE language_id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                language = new Language(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return language;
    }

    public void updateLanguage(Language language) {
        try {
            // Consulta preparada para actualizar información de un idioma por su ID
            String updateQuery = "UPDATE language SET name = ? WHERE language_id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, language.getName());
            preparedStatement.setInt(2, language.getId());
            preparedStatement.executeUpdate();

            System.out.println("Información del idioma actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLanguage(int id) {
        try {
            // Consulta preparada para eliminar un idioma por su ID
            String deleteQuery = "DELETE FROM language WHERE language_id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Idioma eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



//********************************************************************************

//			 gestionar la clase Language 

               




//*******************************************************************************

// 			 gestionar la clase Rental 



public class RentalManager {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public RentalManager() {
        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "usuario", "contraseña");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createRental(Rental rental) {
        try {
            // Consulta preparada para insertar un nuevo alquiler
            String insertQuery = "INSERT INTO rental (rental_date, inventory_id, customer_id, return_date) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setTimestamp(1, rental.getRentalDate());
            preparedStatement.setInt(2, rental.getInventoryId());
            preparedStatement.setInt(3, rental.getCustomerId());
            preparedStatement.setTimestamp(4, rental.getReturnDate());
            preparedStatement.executeUpdate();

            System.out.println("Alquiler creado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Rental getRental(int id) {
        Rental rental = null;
        try {
            // Consulta preparada para obtener información de un alquiler por su ID
            String selectQuery = "SELECT * FROM rental WHERE rental_id = ?";
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Timestamp rentalDate = resultSet.getTimestamp("rental_date");
                int inventoryId = resultSet.getInt("inventory_id");
                int customerId = resultSet.getInt("customer_id");
                Timestamp returnDate = resultSet.getTimestamp("return_date");
                rental = new Rental(id, rentalDate, inventoryId, customerId, returnDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rental;
    }

    public void updateRental(Rental rental) {
        try {
            // Consulta preparada para actualizar información de un alquiler por su ID
            String updateQuery = "UPDATE rental SET rental_date = ?, inventory_id = ?, customer_id = ?, return_date = ? WHERE rental_id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setTimestamp(1, rental.getRentalDate());
            preparedStatement.setInt(2, rental.getInventoryId());
            preparedStatement.setInt(3, rental.getCustomerId());
            preparedStatement.setTimestamp(4, rental.getReturnDate());
            preparedStatement.setInt(5, rental.getId());
            preparedStatement.executeUpdate();

            System.out.println("Información del alquiler actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRental(int id) {
        try {
            // Consulta preparada para eliminar un alquiler por su ID
            String deleteQuery = "DELETE FROM rental WHERE rental_id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Alquiler eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//*********************************************************************************



//  Gestionar  clase RentalManager {
   
          


//********************************************************************************************

// Gestionar la calse inventory 


public class InventoryManager {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public InventoryManager() {
        try {
            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "usuario", "contraseña");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        int choice;

        do {
            System.out.println("-------- Menú de Gestión de Inventario --------");
            System.out.println("1. Crear Registro en el Inventario");
            System.out.println("2. Mostrar Registros del Inventario");
            System.out.println("3. Actualizar Registro del Inventario");
            System.out.println("4. Eliminar Registro del Inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            switch (choice) {
                case 1:
                    createInventoryRecord();
                    break;
                case 2:
                    displayInventoryRecords();
                    break;
                case 3:
                    updateInventoryRecord();
                    break;
                case 4:
                    deleteInventoryRecord();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }

            System.out.println();
        } while (choice != 5);
    }

    private void createInventoryRecord() {
        try {
            System.out.println("-------- Crear Registro en el Inventario --------");
            System.out.print("Ingrese el ID de la película: ");
            int filmId = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            // Verificar si la película existe en la base de datos
            String checkFilmQuery = "SELECT count(*) FROM film WHERE film_id = ?";
            preparedStatement = connection.prepareStatement(checkFilmQuery);
            preparedStatement.setInt(1, filmId);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            int count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("La película con el ID proporcionado no existe en la base de datos.");
                return;
            }

            System.out.print("Ingrese el ID de la tienda: ");
            int storeId = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            // Verificar si la tienda existe en la base de datos
            String checkStoreQuery = "SELECT count(*) FROM store WHERE store_id = ?";
            preparedStatement = connection.prepareStatement(checkStoreQuery);
            preparedStatement.setInt(1, storeId);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("La tienda con el ID proporcionado no existe en la base de datos.");
                return;
            }

            // Insertar el registro en el inventario
            String insertQuery = "INSERT INTO inventory (film_id, store_id) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, filmId);
            preparedStatement.setInt(2, storeId);
            preparedStatement.executeUpdate();

            System.out.println("Registro en el inventario creado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayInventoryRecords() {
        try {
            System.out.println("-------- Registros del Inventario --------");

            String selectQuery = "SELECT * FROM inventory";
            resultSet = statement.executeQuery(selectQuery);

            if (!resultSet.next()) {
                System.out.println("No hay registros en el inventario.");
            } else {
                do {
                    int inventoryId = resultSet.getInt("inventory_id");
                    int filmId = resultSet.getInt("film_id");
                    int storeId = resultSet.getInt("store_id");

                    System.out.println("ID de Inventario: " + inventoryId);
                    System.out.println("ID de Película: " + filmId);
                    System.out.println("ID de Tienda: " + storeId);
                    System.out.println("--------------------");
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateInventoryRecord() {
        try {
            System.out.println("-------- Actualizar Registro del Inventario --------");
            System.out.print("Ingrese el ID del registro de inventario a actualizar: ");
            int inventoryId = scanner.nextInt();
            scanner.nextLine(); //Vaciar el búfer del scanner

            // Verificar si el registro de inventario existe en la base de datos
            String checkInventoryQuery = "SELECT count(*) FROM inventory WHERE inventory_id = ?";
            preparedStatement = connection.prepareStatement(checkInventoryQuery);
            preparedStatement.setInt(1, inventoryId);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            int count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("El registro de inventario con el ID proporcionado no existe en la base de datos.");
                return;
            }

            System.out.print("Ingrese el nuevo ID de la película: ");
            int newFilmId = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            // Verificar si la nueva película existe en la base de datos
            String checkFilmQuery = "SELECT count(*) FROM film WHERE film_id = ?";
            preparedStatement = connection.prepareStatement(checkFilmQuery);
            preparedStatement.setInt(1, newFilmId);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("La película con el ID proporcionado no existe en la base de datos.");
                return;
            }

            System.out.print("Ingrese el nuevo ID de la tienda: ");
            int newStoreId = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            // Verificar si la nueva tienda existe en la base de datos
            String checkStoreQuery = "SELECT count(*) FROM store WHERE store_id = ?";
            preparedStatement = connection.prepareStatement(checkStoreQuery);
            preparedStatement.setInt(1, newStoreId);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("La tienda con el ID proporcionado no existe en la base de datos.");
                return;
            }

            // Actualizar el registro de inventario
            String updateQuery = "UPDATE inventory SET film_id = ?, store_id = ? WHERE inventory_id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, newFilmId);
            preparedStatement.setInt(2, newStoreId);
            preparedStatement.setInt(3, inventoryId);
            preparedStatement.executeUpdate();

            System.out.println("Registro del inventario actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteInventoryRecord() {
        try {
            System.out.println("-------- Eliminar Registro del Inventario --------");
            System.out.print("Ingrese el ID del registro de inventario a eliminar: ");
            int inventoryId = scanner.nextInt();
            scanner.nextLine(); // Vaciar el búfer del scanner

            // Verificar si el registro de inventario existe en la base de datos
            String checkInventoryQuery = "SELECT count(*) FROM inventory WHERE inventory_id = ?";
            preparedStatement = connection.prepareStatement(checkInventoryQuery);
            preparedStatement.setInt(1, inventoryId);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            int count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("El registro de inventario con el ID proporcionado no existe en la base de datos.");
                return;
            }

            // Eliminar el registro de inventario
            String deleteQuery = "DELETE FROM inventory WHERE inventory_id = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, inventoryId);
            preparedStatement.executeUpdate();

            System.out.println("Registro del inventario eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
	}
	
	
	//*********************************************************************************
	

     public static void main(String[] args) {
        // Crear una instancia de DatabaseConnection
        DatabaseConnection dbConnection = new DatabaseConnection();

        // Obtener la conexión a la base de datos
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            try {
                // Crear instancias de los gestores de modelo para cada tabla
                CustomerManager customerManager = new CustomerManager();
                ActorManager actorManager = new ActorManager();
                FilmManager filmManager = new FilmManager();
                PaymentManager paymentManager = new PaymentManager();
                // ... crear instancias para los demás gestores de modelo

                // Realizar operaciones de CRUD
                // Ejemplo: Insertar un nuevo registro
                Customer newCustomer = new Customer(1, "John", "Doe");
                customerManager.addCustomer(newCustomer);

                // Ejemplo: Obtener un registro
                Customer retrievedCustomer = customerManager.getCustomer(1);
                System.out.println("Cliente obtenido: " + retrievedCustomer.getFirstName() + " " + retrievedCustomer.getLastName());

                // Ejemplo: Actualizar un registro
                retrievedCustomer.setFirstName("Jane");
                retrievedCustomer.setLastName("Smith");
                customerManager.updateCustomer(retrievedCustomer);

                // Ejemplo: Eliminar un registro
                customerManager.deleteCustomer(retrievedCustomer);

                // Cerrar la conexión a la base de datos cuando hayas terminado
                dbConnection.closeConnection();
            } catch (Exception e) {
                System.out.println("Error al realizar operaciones en la base de datos: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo establecer la conexión con la base de datos.");
        }
    }




//***************


}// end of SakilaCRUD









