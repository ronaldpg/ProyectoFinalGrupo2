package ClassInterfaceG;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ClassToI.Libro;
import Nodo.Nodo;
import Arbol.ArbolBinario;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreDelAutor;
	private JTextField txtNombreLibro;
	private JTextField txtFechaP;
	private JTextField txtIngreseElGenero;
	private JTextField txtNumPag;
	ArbolBinario arbol = new ArbolBinario();
	private static JTable jTable;
	DefaultTableModel modeloTablaL = new DefaultTableModel();
	boolean tablaCreada = false;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 638, 343);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(139, 69, 19));
		panel_1.setBounds(0, 0, 196, 343);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNombreAutor = new JLabel("Nombre:");
		lblNombreAutor.setForeground(new Color(0, 0, 0));
		lblNombreAutor.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblNombreAutor.setBounds(10, 11, 75, 14);
		panel_1.add(lblNombreAutor);

		txtNombreDelAutor = new JTextField();
		txtNombreDelAutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtNombreDelAutor.getText().equals("Ingrese el nombre del autor" ) || txtNombreDelAutor.getText() != "Ingrese el nombre del autor") {
					txtNombreDelAutor.setText("");
					txtNombreDelAutor.setForeground(Color.BLACK);
				}
				if(txtNombreLibro.getText().isEmpty() || txtFechaP.getText().isEmpty() || txtIngreseElGenero.getText().isEmpty() || txtNumPag.getText().isEmpty()) {
					txtNombreLibro.setText("Ingrese el nombre del libro");
					txtNombreLibro.setForeground(Color.LIGHT_GRAY);
					txtFechaP.setText("Ingrese la fecha de publicación");
					txtFechaP.setForeground(Color.LIGHT_GRAY);
					txtIngreseElGenero.setText("Ingrese el genero del libro");
					txtIngreseElGenero.setForeground(Color.LIGHT_GRAY);
					txtNumPag.setText("Ingrese el numero de paginas");
					txtNumPag.setForeground(Color.LIGHT_GRAY);	
				}

			}
		});
		txtNombreDelAutor.setBackground(new Color(139, 69, 19));
		txtNombreDelAutor.setForeground(new Color(192, 192, 192));
		txtNombreDelAutor.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		txtNombreDelAutor.setText("Ingrese el nombre del autor");
		txtNombreDelAutor.setBounds(10, 27, 176, 20);
		panel_1.add(txtNombreDelAutor);
		txtNombreDelAutor.setColumns(10);
		txtNombreDelAutor.setBorder(null);

		JLabel lblNombreLibro = new JLabel("Nombre:");
		lblNombreLibro.setForeground(new Color(0, 0, 0));
		lblNombreLibro.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblNombreLibro.setBounds(10, 61, 75, 14);
		panel_1.add(lblNombreLibro);

		txtNombreLibro = new JTextField();
		txtNombreLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtNombreLibro.getText().equals("Ingrese el nombre del libro") || txtNombreLibro.getText() != "Ingrese el nombre del libro") {
					txtNombreLibro.setText("");
					txtNombreLibro.setForeground(Color.BLACK);
				}
				if(txtNombreDelAutor.getText().isEmpty() || txtFechaP.getText().isEmpty() || txtIngreseElGenero.getText().isEmpty() || txtNumPag.getText().isEmpty()) {
					txtNombreDelAutor.setText("Ingrese el nombre del autor");
					txtNombreDelAutor.setForeground(Color.LIGHT_GRAY);
					txtFechaP.setText("Ingrese la fecha de publicación");
					txtFechaP.setForeground(Color.LIGHT_GRAY);
					txtIngreseElGenero.setText("Ingrese el genero del libro");
					txtIngreseElGenero.setForeground(Color.LIGHT_GRAY);
					txtNumPag.setText("Ingrese el numero de paginas");
					txtNumPag.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtNombreLibro.setBackground(new Color(139, 69, 19));
		txtNombreLibro.setText("Ingrese el nombre del libro");
		txtNombreLibro.setForeground(Color.LIGHT_GRAY);
		txtNombreLibro.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		txtNombreLibro.setColumns(10);
		txtNombreLibro.setBorder(null);
		txtNombreLibro.setBounds(10, 75, 176, 20);
		panel_1.add(txtNombreLibro);

		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(10, 106, 60, 14);
		panel_1.add(lblNewLabel);

		txtFechaP = new JTextField();
		txtFechaP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtFechaP.getText().equals("Ingrese la fecha de publicación") || txtFechaP.getText() != "Ingrese la fecha de publicación"){
					txtFechaP.setText("");
					txtFechaP.setForeground(Color.BLACK);
				}
				if(txtNombreDelAutor.getText().isEmpty() || txtNombreLibro.getText().isEmpty() || txtIngreseElGenero.getText().isEmpty() || txtNumPag.getText().isEmpty()){
					txtNombreDelAutor.setText("Ingrese el nombre del autor");
					txtNombreDelAutor.setForeground(Color.LIGHT_GRAY);
					txtNombreLibro.setText("Ingrese el nombre del libro");
					txtNombreLibro.setForeground(Color.LIGHT_GRAY);
					txtIngreseElGenero.setText("Ingrese el genero del libro");
					txtIngreseElGenero.setForeground(Color.LIGHT_GRAY);
					txtNumPag.setText("Ingrese el numero de paginas");
					txtNumPag.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtFechaP.setBackground(new Color(139, 69, 19));
		txtFechaP.setText("Ingrese la fecha de publicación");
		txtFechaP.setForeground(Color.LIGHT_GRAY);
		txtFechaP.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		txtFechaP.setColumns(10);
		txtFechaP.setBorder(null);
		txtFechaP.setBounds(10, 120, 176, 20);
		panel_1.add(txtFechaP);

		JLabel lblGeneroLibro = new JLabel("Genero:");
		lblGeneroLibro.setForeground(new Color(0, 0, 0));
		lblGeneroLibro.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblGeneroLibro.setBounds(10, 153, 75, 14);
		panel_1.add(lblGeneroLibro);

		txtIngreseElGenero = new JTextField();
		txtIngreseElGenero.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtIngreseElGenero.getText().equals("Ingrese el genero del libro") || txtIngreseElGenero.getText() != "Ingrese el genero del libro") {
					txtIngreseElGenero.setText("");
					txtIngreseElGenero.setForeground(Color.BLACK);
				}
				if(txtNombreLibro.getText().isEmpty() || txtFechaP.getText().isEmpty() || txtNombreDelAutor.getText().isEmpty() || txtNumPag.getText().isEmpty()) {
					txtNombreDelAutor.setText("Ingrese el nombre del autor");
					txtNombreDelAutor.setForeground(Color.LIGHT_GRAY);
					txtNombreLibro.setText("Ingrese el nombre del libro");
					txtNombreLibro.setForeground(Color.LIGHT_GRAY);
					txtFechaP.setText("Ingrese la fecha de publicación");
					txtFechaP.setForeground(Color.LIGHT_GRAY);
					txtNumPag.setText("Ingrese el numero de paginas");
					txtNumPag.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtIngreseElGenero.setBackground(new Color(139, 69, 19));
		txtIngreseElGenero.setText("Ingrese el genero del libro");
		txtIngreseElGenero.setForeground(Color.LIGHT_GRAY);
		txtIngreseElGenero.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		txtIngreseElGenero.setColumns(10);
		txtIngreseElGenero.setBorder(null);
		txtIngreseElGenero.setBounds(10, 167, 176, 20);
		panel_1.add(txtIngreseElGenero);

		JLabel lblNumPaginas = new JLabel("Paginas:");
		lblNumPaginas.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblNumPaginas.setForeground(new Color(0, 0, 0));
		lblNumPaginas.setBounds(10, 198, 75, 14);
		panel_1.add(lblNumPaginas);

		txtNumPag = new JTextField();
		txtNumPag.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtNumPag.getText().equals("Ingrese el numero de paginas") || txtNumPag.getText() != "Ingrese el numero de paginas") {
					txtNumPag.setText("");
					txtNumPag.setForeground(Color.BLACK);
				}
				if(txtNombreLibro.getText().isEmpty() || txtFechaP.getText().isEmpty() || txtIngreseElGenero.getText().isEmpty() || txtNombreDelAutor.getText().isEmpty()) {
					txtNombreDelAutor.setText("Ingrese el nombre del autor");
					txtNombreDelAutor.setForeground(Color.LIGHT_GRAY);
					txtNombreLibro.setText("Ingrese el nombre del libro");
					txtNombreLibro.setForeground(Color.LIGHT_GRAY);
					txtFechaP.setText("Ingrese la fecha de publicación");
					txtFechaP.setForeground(Color.LIGHT_GRAY);
					txtIngreseElGenero.setText("Ingrese el genero del libro");
					txtIngreseElGenero.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtNumPag.setBackground(new Color(139, 69, 19));
		txtNumPag.setText("Ingrese el numero de paginas");
		txtNumPag.setForeground(Color.LIGHT_GRAY);
		txtNumPag.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		txtNumPag.setColumns(10);
		txtNumPag.setBorder(null);
		txtNumPag.setBounds(10, 212, 176, 20);
		panel_1.add(txtNumPag);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 47, 176, 2);
		panel_1.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(10, 96, 176, 2);
		panel_1.add(separator_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(0, 0, 0));
		separator_1_1.setBackground(new Color(0, 0, 0));
		separator_1_1.setBounds(10, 140, 176, 2);
		panel_1.add(separator_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(new Color(0, 0, 0));
		separator_1_1_1.setBackground(new Color(0, 0, 0));
		separator_1_1_1.setBounds(10, 187, 176, 2);
		panel_1.add(separator_1_1_1);

		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setForeground(new Color(0, 0, 0));
		separator_1_1_1_1.setBackground(new Color(0, 0, 0));
		separator_1_1_1_1.setBounds(10, 232, 176, 2);
		panel_1.add(separator_1_1_1_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(528, 0, 110, 343);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JPanel pnInsertar = new JPanel();
		pnInsertar.setBounds(-1, 11, 112, 21);
		panel_2.add(pnInsertar);
		pnInsertar.setLayout(null);

		JLabel lblInsertar = new JLabel("INSERTAR");
		lblInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombreA = txtNombreDelAutor.getText();
				String nombreL = txtNombreLibro.getText();
				String fechaP = txtFechaP.getText();
				String genero = txtIngreseElGenero.getText();
				String numPaginas = txtNumPag.getText();
				int numP = Integer.parseInt(numPaginas);
				Libro libro = new Libro(nombreA, nombreL, fechaP, genero, numP);
				arbol.insertar(libro);
				actualizarTabla(arbol);
				
				txtFechaP.setText("");
				txtIngreseElGenero.setText("");
				txtNombreDelAutor.setText("");
				txtNombreLibro.setText("");
				txtNumPag.setText("");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnInsertar.setBackground(new Color(205,133,63));
				lblInsertar.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnInsertar.setBackground(new Color(240,240,240));
				lblInsertar.setForeground(Color.BLACK);
			}
		});
		lblInsertar.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblInsertar.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertar.setBounds(0, 0, 112, 21);
		pnInsertar.add(lblInsertar);

		JPanel pnBuscar = new JPanel();
		pnBuscar.setLayout(null);
		pnBuscar.setBounds(-1, 59, 112, 21);
		panel_2.add(pnBuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombreA = txtNombreDelAutor.getText();
				String nombreL = txtNombreLibro.getText();
				String fechaP = txtFechaP.getText();
				String genero = txtIngreseElGenero.getText();
				String numPaginas = txtNumPag.getText();
				int numP = Integer.parseInt(numPaginas);
				Libro libro1 = new Libro(nombreA, nombreL, fechaP, genero, numP);
				arbol.buscar(libro1);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnBuscar.setBackground(new Color(205,133,63));
				lblBuscar.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnBuscar.setBackground(new Color(240,240,240));
				lblBuscar.setForeground(Color.BLACK);
			}
		});
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblBuscar.setBounds(0, 0, 112, 21);
		pnBuscar.add(lblBuscar);

		JPanel pnEliminar = new JPanel();
		pnEliminar.setLayout(null);
		pnEliminar.setBounds(-1, 107, 112, 21);
		panel_2.add(pnEliminar);

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombreL = JOptionPane.showInputDialog("Ingrese el nombre del libro para eliminarlo");
				eliminarLibro(arbol, nombreL);
				actualizarTabla(arbol);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnEliminar.setBackground(new Color(205,133,63));
				lblEliminar.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnEliminar.setBackground(new Color(240,240,240));
				lblEliminar.setForeground(Color.BLACK);
			}
		});
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblEliminar.setBounds(0, 0, 112, 21);
		pnEliminar.add(lblEliminar);

		JPanel pnNodoMax = new JPanel();
		pnNodoMax.setLayout(null);
		pnNodoMax.setBounds(-1, 156, 112, 21);
		panel_2.add(pnNodoMax);

		JLabel lblNodoMax = new JLabel("NODO MAX");
		lblNodoMax.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Nodo nodoMax = arbol.obtenerMaximo();
				if(nodoMax != null) {
					JOptionPane.showMessageDialog(null, "Libro máximo: " + nodoMax.getLibro().getNombreLibro());
				}else {
					JOptionPane.showMessageDialog(null,"El árbol está vacío.");
		        }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnNodoMax.setBackground(new Color(205,133,63));
				lblNodoMax.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnNodoMax.setBackground(new Color(240,240,240));
				lblNodoMax.setForeground(Color.BLACK);
			}
		});
		lblNodoMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblNodoMax.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblNodoMax.setBounds(0, 0, 112, 21);
		pnNodoMax.add(lblNodoMax);

		JPanel pnOrdenar = new JPanel();
		pnOrdenar.setLayout(null);
		pnOrdenar.setBounds(-1, 206, 112, 21);
		panel_2.add(pnOrdenar);

		JLabel lblOrdenar = new JLabel("ORDENAR");
		lblOrdenar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Libro> listaLibrosOrdenados = ordenarEnPostOrden(arbol);
		        actualizarTabla(listaLibrosOrdenados);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnOrdenar.setBackground(new Color(205,133,63));
				lblOrdenar.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnOrdenar.setBackground(new Color(240,240,240));
				lblOrdenar.setForeground(Color.BLACK);
			}
		});
		lblOrdenar.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdenar.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblOrdenar.setBounds(0, 0, 112, 21);
		pnOrdenar.add(lblOrdenar);

		JPanel pnTotal = new JPanel();
		pnTotal.setLayout(null);
		pnTotal.setBounds(-1, 254, 112, 21);
		panel_2.add(pnTotal);

		JLabel lblTotalNodos = new JLabel("TAMAÑO");
		lblTotalNodos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int cantidad = arbol.contarLibros();
				JOptionPane.showMessageDialog(null, "Existen " + cantidad + " libros en el arbol");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnTotal.setBackground(new Color(205,133,63));
				lblTotalNodos.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnTotal.setBackground(new Color(240,240,240));
				lblTotalNodos.setForeground(Color.BLACK);
			}
		});
		lblTotalNodos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalNodos.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblTotalNodos.setBounds(0, 0, 112, 21);
		pnTotal.add(lblTotalNodos);

		JPanel pnSalir = new JPanel();
		pnSalir.setLayout(null);
		pnSalir.setBounds(-1, 300, 112, 21);
		panel_2.add(pnSalir);

		JLabel lblSalir = new JLabel("SALIR");
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnSalir.setBackground(new Color(205,133,63));
				lblSalir.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnSalir.setBackground(new Color(240,240,240));
				lblSalir.setForeground(Color.BLACK);
			}
		});
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblSalir.setBounds(0, 0, 112, 21);
		pnSalir.add(lblSalir);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(197, 0, 334, 343);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblEncabezado = new JLabel("");
		lblEncabezado.setIcon(new ImageIcon(Main.class.getResource("/Images/Fondo1.png")));
		lblEncabezado.setBounds(-1, 0, 332, 77);
		panel_4.add(lblEncabezado);

		JPanel pnTable = new JPanel();
		pnTable.setBounds(-1, 76, 332, 267);
		panel_4.add(pnTable);
		pnTable.setLayout(null);
	}

	
	//Metodo para agregar la tabla
	private void actualizarTabla(ArbolBinario arbol) {
        if (!tablaCreada) {
            // Si la tabla no ha sido creada, la creamos y la mostramos en una ventana JFrame
            String[] columnas = {"Nombre Autor", "Nombre Libro", "Fecha de Publicación", "Género", "Número de Páginas"};
            modeloTablaL = new DefaultTableModel(columnas, 0);
            jTable = new JTable(modeloTablaL);

            JFrame ventana = new JFrame();
            ventana.getContentPane().add(new JScrollPane(jTable));
            ventana.pack();
            ventana.setVisible(true);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            tablaCreada = true;
        }

        // Limpiar el modelo actual de la tabla
        modeloTablaL.setRowCount(0);

        // Obtener la lista de libros desde el árbol
        List<Libro> listaLibros = arbol.obtenerListaDeLibros();

        // Agregar los libros al modelo de la tabla
        for (Libro libro : listaLibros) {
            Object[] fila = {libro.getNombreAutor(), libro.getNombreLibro(), libro.getFechaP(), libro.getGeneroLibro(), libro.getNumeroPaginas()};
            modeloTablaL.addRow(fila);
        }
    }
	
	private void actualizarTabla(List<Libro> listaLibros) {
        if (!tablaCreada) {
            // Si la tabla no ha sido creada, la creamos y la mostramos en una ventana JFrame
            String[] columnas = {"Nombre Autor", "Nombre Libro", "Fecha de Publicación", "Género", "Número de Páginas"};
            modeloTablaL = new DefaultTableModel(columnas, 0);
            jTable = new JTable(modeloTablaL);

            JFrame ventana = new JFrame();
            ventana.getContentPane().add(new JScrollPane(jTable));
            ventana.pack();
            ventana.setVisible(true);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            tablaCreada = true;
        }

        // Limpiar el modelo actual de la tabla
        modeloTablaL.setRowCount(0);

        // Agregar los libros al modelo de la tabla
        for (Libro libro : listaLibros) {
            Object[] fila = {libro.getNombreAutor(), libro.getNombreLibro(), libro.getFechaP(), libro.getGeneroLibro(), libro.getNumeroPaginas()};
            modeloTablaL.addRow(fila);
        }
    }
	
	private static void eliminarLibro(ArbolBinario arbol, String nombreLibro) {
        arbol.eliminar(nombreLibro);
    }
	
	private static List<Libro> ordenarEnPostOrden(ArbolBinario arbol) {
        List<Libro> listaLibros = new ArrayList<>();
        ordenarEnPostOrden(arbol.obtenerRaiz(), listaLibros);
        return listaLibros;
    }
	
	private static void ordenarEnPostOrden(Nodo nodo, List<Libro> listaLibros) {
        if (nodo != null) {
            ordenarEnPostOrden(nodo.getHijoIzquierdo(), listaLibros);
            ordenarEnPostOrden(nodo.getHijoDerecho(), listaLibros);
            listaLibros.add((Libro) nodo.getLibro());
        }
    }

}
