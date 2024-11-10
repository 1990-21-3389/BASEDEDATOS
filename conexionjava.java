import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class conexionjava extends JFrame implements ActionListener {
    private static final String URL = "jdbc:mysql://localhost:3306/BDNegocio";
    private static final String USER = "root";
    private static final String PASSWORD = "Perez.25";
    private JLabel label1, label2, label3, label4,etiqueta2;
    private JButton btnBuscarproducto,btnDesp, btnNewInvent, btnInsertar, btnMostrar, btnBuscar, btnModificar, btnRepVentas, btnEliminar, btnSalir;
       
    public conexionjava() {
        setTitle("CONTROL DE MERCADERIA");
        setIconImage(new ImageIcon(getClass().getResource("logoagro_1.png")).getImage());
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        label2 = new JLabel("SISTEMA DE CONTROL");
        label2.setBounds(140, 80, 600, 30);
        label2.setFont(new Font("Arial Black", Font.BOLD, 30));
        label2.setForeground(Color.WHITE);
        add(label2);
        
         label2 = new JLabel("DE INVENTARIO");
        label2.setBounds(200, 120, 600, 30);
        label2.setFont(new Font("Arial Black", Font.BOLD, 30));
        label2.setForeground(Color.WHITE);
        add(label2);
        
        label2 = new JLabel("DE AGROSERVICIO EL CAMPESINO");
        label2.setBounds(20, 160, 700, 30);
        label2.setFont(new Font("Arial Black", Font.BOLD, 30));
        label2.setForeground(Color.WHITE);
        add(label2);    
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(15, 10, 100, 100);
        add(panel);

        // Cargar la imagen
        ImageIcon imagen = new ImageIcon(getClass().getResource("agrologo.com.png")); // Asegúrate de tener la imagen en el directorio correcto
        JLabel etiqueta2 = new JLabel();
        etiqueta2.setBounds(0, 0, 100, 100); // Establecer tamaño adecuado
        // Escalar la imagen para ajustarla al JLabel
        Image imagenEscalada = imagen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH);
        etiqueta2.setIcon(new ImageIcon(imagenEscalada)); // Asigna la imagen escalada al JLabel

        panel.add(etiqueta2); // Añadir la imagen al panel

        //JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setPreferredSize(new Dimension(500,700));//Esta dimensiones del panel de gestión de productos
        panel.setLayout(null);//Deshabilitar el diseño por default del panel
        panel.setBackground(new Color(10, 20, 15)); // Gris claro//Establece color a la etiqueta.
        
        
        btnDesp = new JButton("EXPENDER");
        btnDesp.setBounds(480, 400,170,40);
        btnDesp.setBackground(new Color(43, 70, 73)); // Rojo
        btnDesp.setForeground(Color.WHITE); // Blanco
        
        btnNewInvent = new JButton("NUEVO INVENTARIO");
        btnNewInvent.setBounds(480, 450,170,40);
        btnNewInvent.setBackground(new Color(43, 70, 73)); // Rojo
        btnNewInvent.setForeground(Color.WHITE); // Blanco        
        
        
        JLabel etiquetaImagen = new JLabel();
        etiquetaImagen.setBounds(20, 70, 300, 300); // Posición y tamaño de la etiqueta
        //etiquetaImagen.setIcon(new ImageIcon("C:/Users/ronyc/Documents/4to. Ciclo 2 2024/5. Progra_II/MySQL/NetBeansConnector/BDConnectorMySQL/src/Pirata.png")); // Agregar imagen
       
        
         
        btnMostrar = new JButton("MOSTRAR PRODUCTOS");
        btnMostrar.setBounds(25, 400,170,40);
        btnMostrar.setBackground(new Color(43, 70, 73)); // Rojo
        btnMostrar.setForeground(Color.WHITE); // Blanco
        
        btnBuscar = new JButton("BUSCAR PRODUCTO");
        btnBuscar.setBounds(250, 400,170,40);
        btnBuscar.setBackground(new Color(43, 70, 73)); // Rojo
        btnBuscar.setForeground(Color.WHITE); // Blanco        
        
        
        btnInsertar = new JButton("INGRESAR PRODUCTO");
        btnInsertar.setBounds(25, 450,170,40);
        btnInsertar.setBackground(new Color(43, 70, 73)); // Rojo
        btnInsertar.setForeground(Color.WHITE); // Blanco
        

        btnModificar = new JButton("ACTUALIZAR PRECIO");
        btnModificar.setBounds(250, 450,170,40);
        btnModificar.setBackground(new Color(43, 70, 73)); // Rojo
        btnModificar.setForeground(Color.WHITE); // Blanco        

        btnRepVentas = new JButton("REPORTE DE VENTAS");
        btnRepVentas.setBounds(260, 600,170,40);
        btnRepVentas.setBackground(new Color(20, 10, 50)); // Rojo
        btnRepVentas.setForeground(Color.white); // Blanco        
        
        btnEliminar = new JButton("ELIMINAR PRODUCTO");
        btnEliminar.setBounds(25, 510,170,40);
        btnEliminar.setBackground(new Color(43, 70, 73))); // Rojo
        btnEliminar.setForeground(Color.WHITE); // Blanco
        
        btnSalir = new JButton("SALIR");
        btnSalir.setBounds(480, 510,170,40);
        btnSalir.setBackground(new Color(43, 70, 73)); // Rojo
        btnSalir.setForeground(Color.WHITE); // Blanco
        
        btnBuscarproducto = new JButton("BUSCAR PRODUCTO POR NOMBRE");
        btnBuscarproducto.setBounds(210, 510,250,40);
        btnBuscarproducto.setBackground(new Color(43, 70, 73)); // Rojo
        btnBuscarproducto.setForeground(Color.WHITE); // Blanco       

        // Añadir botones al panel
        panel.add(btnDesp);
        panel.add(btnNewInvent);
        panel.add(btnInsertar);
        panel.add(btnMostrar);
        panel.add(btnBuscar);
        panel.add(btnBuscarproducto);
        panel.add(btnModificar);
        panel.add(btnRepVentas);
        panel.add(btnEliminar);
        panel.add(btnSalir);
        panel.add(etiquetaImagen);

        // Asignar ActionListener a cada botón
        btnDesp.addActionListener(this);
        btnNewInvent.addActionListener(this);
        btnInsertar.addActionListener(this);
        btnMostrar.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnBuscarproducto.addActionListener(this);
        btnModificar.addActionListener(this);
        btnRepVentas.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnSalir.addActionListener(this);

        add(panel);
    }

    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conexion;
    }

    public static void insertarProducto(String codigo, String nombre, double precio, int cantidad, int vendido, String fecha) {
        String query = "INSERT INTO producto (codigoProducto, nombreProducto, precioUnitario, cantidadProducto, ventaProducto, fechaVencimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = conectar(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, codigo);
            pst.setString(2, nombre);
            pst.setDouble(3, precio);
            pst.setInt(4, cantidad);
            pst.setInt(5, vendido);
            pst.setDate(6, Date.valueOf(fecha));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto insertado correctamente", "Insertar Producto", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
        }
    }

    public static void listarProductos() {
        String query = "SELECT * FROM producto";
        JFrame frame = new JFrame("Lista de Productos");
       
        frame.setSize(400, 700);
        frame.setLocationRelativeTo(null);
        //frame.setBackground(new Color(139, 135, 91)); // Rojo
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Configura que se cierre solo la ventana actual (no el programa entero) cuando se cierre.

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        try (Connection con = conectar(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
            boolean hayProductos = false;

            while (rs.next()) {
                hayProductos = true;
                String productoInfo =
                        "<html>Código: " + rs.getString("codigoProducto") +
                                      "<br>Nombre: " + rs.getString("nombreProducto") +
                                      "<br>Precio: " + rs.getDouble("precioUnitario") +
                                      "<br>Cant.Disp: " + rs.getInt("cantidadProducto") +
                                      "<br>Vendidos: " + rs.getInt("ventaProducto") +
                                      "<br>Fecha de Vencimiento: " + rs.getDate("fechaVencimiento") + 
                                      "<br>--------------------------</html>";

                JLabel labelProducto = new JLabel(productoInfo);
                panel.add(labelProducto);
            }

            if (!hayProductos) {
                JLabel noProductos = new JLabel("No hay productos disponibles.");
                panel.add(noProductos);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }
        
         //Agrega el panel a un JScrollPane, que permitirá desplazarse hacia abajo si la lista de productos es extensa.
        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    public static void buscarProducto(String codigoProducto) {
        String query = "SELECT * FROM producto WHERE codigoProducto = ?";
        try (Connection con = conectar(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, codigoProducto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String producto = "Código: " + rs.getString("codigoProducto") +
                                  "\nNombre: " + rs.getString("nombreProducto") +
                                  "\nPrecio: " + rs.getDouble("precioUnitario") +
                                  "\nCant.Disp: " + rs.getInt("cantidadProducto") +
                                  "\nVendidos: " + rs.getInt("ventaProducto") +
                                  "\nFecha de Vencimiento: " + rs.getDate("fechaVencimiento");
                JOptionPane.showMessageDialog(null, producto, "Producto Encontrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Buscar Producto", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        }
    }
    
    public static void buscarProductonombre(String nombreProducto) {
        String query = "SELECT * FROM producto WHERE nombreProducto = ?";
        try (Connection con = conectar(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, nombreProducto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String producto = "Código: " + rs.getString("codigoProducto") +
                                  "\nNombre: " + rs.getString("nombreProducto") +
                                  "\nPrecio: " + rs.getDouble("precioUnitario") +
                                  "\nCant.Disp: " + rs.getInt("cantidadProducto") +
                                  "\nVendidos: " + rs.getInt("ventaProducto") +
                                  "\nFecha de Vencimiento: " + rs.getDate("fechaVencimiento");
                JOptionPane.showMessageDialog(null, producto, "Producto Encontrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Buscar Producto", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        }
    }

    public static void actualizarProducto(String codigoProducto, double precio) {
        String query = "UPDATE producto SET precioUnitario = ? WHERE codigoProducto = ?";
        try (Connection con = conectar(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setDouble(1, precio);
            pst.setString(2, codigoProducto);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente", "Actualizar Producto", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar producto: " + e.getMessage(), "Actualizar Producto", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        public static void actualizarInventario(String Producto, int cantidad) {
        String query = "UPDATE producto SET cantidadProducto = cantidadProducto +? WHERE codigoProducto = ?";
        try (Connection con = conectar(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, cantidad);
            pst.setString(2, Producto);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente", "Actualizar Producto", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar producto: " + e.getMessage(), "Actualizar Producto", JOptionPane.ERROR_MESSAGE);
        }
    }


        public static void verificarYDespachar(String codigoProducto, int cantidadSolicitada) {
    // Consulta para obtener la cantidad disponible del producto
    String queryCantidad = "SELECT cantidadProducto FROM producto WHERE codigoProducto = ?";
    
    try (Connection con = conectar(); 
         PreparedStatement pstCantidad = con.prepareStatement(queryCantidad)) {
        
        // Configura el parámetro de la consulta
        pstCantidad.setString(1, codigoProducto);
        
        // Ejecuta la consulta para obtener la cantidad disponible
        ResultSet rs = pstCantidad.executeQuery();
        
        if (rs.next()) {
            int cantidadDisponible = rs.getInt("cantidadProducto");
            
            // Verifica si hay suficiente cantidad para despachar
            if (cantidadDisponible >= cantidadSolicitada) {
                // Llama al método de despacho para realizar la operación
                despacho(codigoProducto, cantidadSolicitada);
            } else {
                // Muestra un mensaje indicando que no hay suficiente cantidad
                JOptionPane.showMessageDialog(null, "Cantidad insuficiente. Disponible: " + cantidadDisponible, 
                                              "Error de Despacho", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            // Si el producto no se encuentra, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Producto no encontrado.", 
                                          "Buscar Producto", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        System.out.println("Error al verificar cantidad del producto: " + e.getMessage());
    }
}

public static void despacho(String codigoProducto, int cantidad) {
    // Consulta para actualizar la venta y la cantidad en inventario
    String queryDespacho = "UPDATE producto SET ventaProducto = ventaProducto + ?, cantidadProducto = cantidadProducto - ? WHERE codigoProducto = ?";
    
    try (Connection con = conectar(); 
         PreparedStatement pstDespacho = con.prepareStatement(queryDespacho)) {
        
        // Configura los parámetros de la consulta de despacho
        pstDespacho.setInt(1, cantidad);
        pstDespacho.setInt(2, cantidad);
        pstDespacho.setString(3, codigoProducto);
        
        // Ejecuta la actualización en la base de datos
        pstDespacho.executeUpdate();
        
        // Muestra un mensaje confirmando la operación de despacho
        JOptionPane.showMessageDialog(null, "Venta Operada Exitosamente", "Despacho", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al despachar el producto", "Despacho de Producto", JOptionPane.ERROR_MESSAGE);
    }
}   
        
    public static void eliminarProducto(String codigoProducto) {
        String query = "DELETE FROM producto WHERE codigoProducto = ?";
        try (Connection con = conectar(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, codigoProducto);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente", "Eliminar Producto", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInsertar) {
            String codigo = JOptionPane.showInputDialog("Ingrese código del producto:");
            String nombre = JOptionPane.showInputDialog("Ingrese nombre del producto:");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio unitario:"));
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad:"));
            int vendido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad vendida:"));
            String fecha = JOptionPane.showInputDialog("Ingrese fecha de vencimiento (YYYY-MM-DD):");
            insertarProducto(codigo, nombre, precio, cantidad, vendido, fecha);
        } else if (e.getSource() == btnMostrar) {
            listarProductos();
        } else if (e.getSource() == btnBuscar) {
            String codigo = JOptionPane.showInputDialog("Ingrese código del producto a buscar:");
            buscarProducto(codigo);
            } else if (e.getSource() == btnBuscarproducto) {
            String producto = JOptionPane.showInputDialog("Ingrese nombre del producto a buscar:");
            buscarProductonombre(producto);
        } else if (e.getSource() == btnModificar) {
            String codigo = JOptionPane.showInputDialog("Ingrese código del producto a modificar:");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese nuevo precio unitario:"));
            actualizarProducto(codigo, precio);
        } else if (e.getSource() == btnNewInvent) {
            String codigo = JOptionPane.showInputDialog("Ingrese código del producto a inventariar:");
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que se suman al inventario:"));
            actualizarInventario(codigo, cantidad);
        } else if (e.getSource() == btnDesp) {
            String codigoProducto = JOptionPane.showInputDialog("Ingrese código del producto:");
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a despachar:"));
            //despacho(idProducto,cantidad);
            verificarYDespachar(codigoProducto, cantidad);
        }else if (e.getSource() == btnEliminar) {
            String codigo = JOptionPane.showInputDialog("Ingrese código del producto a eliminar:");
            eliminarProducto(codigo);
        } else if (e.getSource() == btnSalir) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}

class LoginFrame extends JFrame implements ActionListener {
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JButton btnIngresar;

    public LoginFrame() {
        setTitle("AGROSERVICIO EL CAMPESINO");
        setSize(375, 300);
        setIconImage(new ImageIcon(getClass().getResource("logoagro_1.png")).getImage());
        setLocationRelativeTo(null);//Establece la locación de la pantalla al centro. (Resolución
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);//Deshabilitar el diseño por default del panel
        panel.setPreferredSize(new Dimension(300,500));//Esta dimensiones de la pantalla de bienvenida
        panel.setBackground(new Color(25, 10, 73)); // Gris claro//Establece color a la etiqueta.
        //panel.setLayout(null);// Desactivar el layout manager

        JLabel lblUsuario = new JLabel("USUARIO:");
        lblUsuario.setBounds(10, 20, 100, 30);  // x, y, width, height
        lblUsuario.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,20)); // Establece la fuente del texto |tipo|
        lblUsuario.setForeground(Color.white);//Establece el color de la letra.
        lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);//Método que establece la alineación del texto en la etiqueta
        
        //Cajas de texto para usuario
        txtUsuario = new JTextField();
        txtUsuario.setBounds(170, 20, 150, 30);

        JLabel lblContraseña = new JLabel("CONTRASEÑA:");
        lblContraseña.setBounds(10, 60, 150, 30);
        lblContraseña.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,20)); // Establece la fuente del texto |tipo|
        lblContraseña.setForeground(Color.white);//Establece el color de la letra.
        lblContraseña.setHorizontalAlignment(SwingConstants.LEFT);//Método que establece la alineación del texto en la etiqueta
        
        //Caja de texto para contraseña
        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(170, 60, 150, 30);

    btnIngresar = new JButton("INGRESAR");
    btnIngresar.setBounds(150, 130, 100, 40); // Aquí colocas el tamaño y la posición
    btnIngresar.addActionListener(this);

        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblContraseña);
        panel.add(txtContraseña);
        panel.add(new JLabel());
        panel.add(btnIngresar);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIngresar) {
            String usuario = txtUsuario.getText();
            String contraseña = new String(txtContraseña.getPassword());

            // Verificar credenciales (ejemplo: usuario "admin", contraseña "1234")
            if (usuario.equals("erickapen") && contraseña.equals("2024")) {
                dispose();
                conexionjava frame = new conexionjava();
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error de autenticación", JOptionPane.ERROR_MESSAGE); 
            }
        }
    }
}