
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {

    private ObservableList<Contacto> listaContactos = FXCollections.observableArrayList();

    private String[] opcionesParentesco = {"Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"};

    private TextField txtNombre = new TextField();
    private TextField txtTelefono = new TextField();
    private ComboBox<String> comboParentesco = new ComboBox<>();
    private ListView<Contacto> listViewContactos = new ListView<>();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Registro de Contactos de Emergencia");

        comboParentesco.getItems().addAll(opcionesParentesco);
        comboParentesco.setPromptText("Seleccione Parentesco");

        Button btnAgregar = new Button("Agregar");
        Button btnBuscar = new Button("Buscar");
        Button btnActualizar = new Button("Actualizar");
        Button btnEliminar = new Button("Eliminar");
        Button btnLimpiar = new Button("Limpiar");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        HBox botones = new HBox(10, btnAgregar, btnBuscar, btnActualizar, btnEliminar, btnLimpiar);

        layout.getChildren().addAll(
                new Label("Nombre:"), txtNombre,
                new Label("Teléfono:"), txtTelefono,
                new Label("Parentesco:"), comboParentesco,
                botones,
                new Label("Lista de Contactos:"), listViewContactos
        );

        btnAgregar.setOnAction(e -> agregarContacto());
        btnBuscar.setOnAction(e -> buscarContacto());
        btnActualizar.setOnAction(e -> actualizarContacto());
        btnEliminar.setOnAction(e -> eliminarContacto());
        btnLimpiar.setOnAction(e -> limpiarCampos());

        listViewContactos.setItems(listaContactos);

        Scene scene = new Scene(layout, 500, 500);
        stage.setScene(scene);
        stage.show();
    }


    private void agregarContacto() {
        String nombre = txtNombre.getText().trim();
        String tel = txtTelefono.getText().trim();
        String par = comboParentesco.getValue();

        if (validar(nombre, tel, par)) {
            for (Contacto c : listaContactos) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    mostrarAlerta("Error", "Ya existe un contacto con ese nombre.");
                    return;
                }
            }
            listaContactos.add(new Contacto(nombre, tel, par));
            limpiarCampos();
        }
    }

    private void buscarContacto() {
        String nombreABuscar = txtNombre.getText().trim();
        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombreABuscar)) {
                txtNombre.setText(c.getNombre());
                txtTelefono.setText(c.getTelefono());
                comboParentesco.setValue(c.getParentesco());
                return;
            }
        }
        mostrarAlerta("Búsqueda", "Contacto no encontrado.");
    }

    private void actualizarContacto() {
        String nombre = txtNombre.getText().trim();
        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                if (validar(nombre, txtTelefono.getText(), comboParentesco.getValue())) {
                    c.setTelefono(txtTelefono.getText());
                    c.setParentesco(comboParentesco.getValue());
                    listViewContactos.refresh(); // Refrescar vista
                    mostrarAlerta("Éxito", "Contacto actualizado.");
                    return;
                }
            }
        }
    }

    private void eliminarContacto() {
        String nombre = txtNombre.getText().trim();
        Contacto encontrado = null;
        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = c;
                break;
            }
        }
        if (encontrado != null) {
            listaContactos.remove(encontrado);
            limpiarCampos();
        } else {
            mostrarAlerta("Error", "No se encontró el contacto para eliminar.");
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtTelefono.clear();
        comboParentesco.setValue(null);
    }

    private boolean validar(String nombre, String tel, String par) {
        if (nombre.isEmpty() || tel.isEmpty() || par == null) {
            mostrarAlerta("Error", "Todos los campos son obligatorios.");
            return false;
        }
        if (tel.length() != 10 || !tel.matches("\\d+")) {
            mostrarAlerta("Error", "El teléfono debe tener 10 dígitos numéricos.");
            return false;
        }
        return true;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}