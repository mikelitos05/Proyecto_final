package edu.proyectofinal.ui;

import edu.proyectofinal.data.Book;
import edu.proyectofinal.data.Loan;
import edu.proyectofinal.data.User;
import edu.proyectofinal.process.BookManager;
import edu.proyectofinal.process.LoanManager;
import edu.proyectofinal.process.UserManager;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Menu extends javax.swing.JFrame {

    private BookManager bookManager;
    private UserManager userManager;
    private LoanManager loanManager;
    private ResourceBundle resources;
    private JMenu languageMenu;
    private JMenuItem spanishItem;
    private JMenuItem englishItem;

    public Menu(BookManager bookManager, UserManager userManager, LoanManager loanManager) {
        this.loanManager = loanManager;
        this.bookManager = bookManager;
        this.userManager = userManager;

        // Cargar recursos iniciales
        resources = ResourceBundle.getBundle("edu.proyectofinal.i18n.Messages", Locale.getDefault());

        initComponents();
        setupMenuBar();
        loadTables();
        configureStyles();
        updateUI();

        // Configuración de la ventana
        this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        languageMenu = new JMenu();
        spanishItem = new JMenuItem();
        englishItem = new JMenuItem();

        // Configurar acciones
        spanishItem.addActionListener(e -> changeLocale(new Locale("es")));
        englishItem.addActionListener(e -> changeLocale(Locale.ENGLISH));

        languageMenu.add(spanishItem);
        languageMenu.add(englishItem);
        menuBar.add(languageMenu);

        this.setJMenuBar(menuBar);
    }

    private void changeLocale(Locale locale) {
        resources = ResourceBundle.getBundle("edu.proyectofinal.i18n.Messages", locale);
        updateUI();
    }

    private void updateUI() {
        // Actualizar menú
        languageMenu.setText(resources.getString("menu.language"));
        spanishItem.setText(resources.getString("language.spanish"));
        englishItem.setText(resources.getString("language.english"));

        // Actualizar etiquetas
        jLabel1.setText(resources.getString("menu.books"));
        jLabel2.setText(resources.getString("menu.loans"));
        jLabel3.setText(resources.getString("menu.users"));

        // Actualizar botones
        btnAddBook.setText(resources.getString("button.addBook"));
        btnAddUser.setText(resources.getString("button.addUser"));
        btnMakeLoan.setText(resources.getString("button.makeLoan"));

        // Actualizar encabezados de tablas
        updateTableHeaders();
    }

    private void updateTableHeaders() {
        // Libros
        String[] bookColumns = {
                resources.getString("book.title"),
                resources.getString("book.author"),
                resources.getString("book.genero"),
                resources.getString("book.copies"),
                resources.getString("book.available")
        };
        ((DefaultTableModel) tablBooks.getModel()).setColumnIdentifiers(bookColumns);

        // Usuarios
        String[] userColumns = {
                resources.getString("user.id"),
                resources.getString("user.name"),
                resources.getString("user.age"),
                resources.getString("user.loans"),
                resources.getString("user.type")
        };
        ((DefaultTableModel) tablUsers.getModel()).setColumnIdentifiers(userColumns);

        // Préstamos
        String[] loanColumns = {
                resources.getString("loan.user"),
                resources.getString("loan.book"),
                resources.getString("loan.startDate"),
                resources.getString("loan.endDate"),
                resources.getString("loan.daysLeft"),
                resources.getString("loan.status")
        };
        ((DefaultTableModel) tablLoans.getModel()).setColumnIdentifiers(loanColumns);
    }

    private void configureStyles() {
        Color backgroundColor = new Color(255, 245, 245);
        Color primaryColor = new Color(0, 150, 136);
        Color accentColor = new Color(255, 87, 34);

        getContentPane().setBackground(backgroundColor);

        styleButton(btnAddBook, primaryColor, Color.WHITE);
        styleButton(btnAddUser, primaryColor, Color.WHITE);
        styleButton(btnMakeLoan, accentColor, Color.WHITE);

        styleTable(tablBooks, primaryColor);
        styleTable(tablLoans, primaryColor);
        styleTable(tablUsers, primaryColor);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 18);
        jLabel1.setFont(labelFont);
        jLabel2.setFont(labelFont);
        jLabel3.setFont(labelFont);
    }

    private void styleTable(JTable table, Color headerColor) {
        JTableHeader header = table.getTableHeader();
        header.setBackground(headerColor);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));

        table.setRowHeight(25);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setSelectionBackground(headerColor.brighter());
        table.setSelectionForeground(Color.WHITE);
        table.setGridColor(new Color(224, 224, 224));

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240));
                }
                return c;
            }
        });
    }

    private void styleButton(JButton button, Color bgColor, Color textColor) {
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 10));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(bgColor.darker(), 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
    }

    private void initComponents() {
        // Código generado por el diseñador de GUI (NetBeans/Swing)
        // [El código original de initComponents permanece igual]
        // ... (Mantener el código generado original sin cambios)
    }

    private void loadTables() {
        DefaultTableModel modelBooks = (DefaultTableModel) tablBooks.getModel();
        DefaultTableModel modelLoans = (DefaultTableModel) tablLoans.getModel();
        DefaultTableModel modelUsers = (DefaultTableModel) tablUsers.getModel();
        modelBooks.setRowCount(0);
        modelLoans.setRowCount(0);
        modelUsers.setRowCount(0);

        for (Book book : bookManager.getBooks()) {
            modelBooks.addRow(new Object[]{
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getTotalCopies(),
                    book.getTotalCopies()
            });
        }

        for (User user : userManager.getUsers()) {
            modelUsers.addRow(new Object[]{
                    user.getId(),
                    user.getName(),
                    user.getAge(),
                    user.getActiveLend(),
                    user.getUserType().toString()
            });
        }

        for (Loan loan : loanManager.getLoans()) {
            modelLoans.addRow(new Object[]{
                    loan.getUser().getName(),
                    loan.getBook().getTitle(),
                    loan.getStartDate(),
                    loan.getEndDate(),
                    loan.calculateDaysBetween(),
                    loan.getStatus()
            });
        }
    }

    // Métodos de acción para los botones (sin cambios)
    private void btnAddBookActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel modelBooks = (DefaultTableModel) tablBooks.getModel();
        AddBook addBook = new AddBook(modelBooks, bookManager);
        addBook.setVisible(true);
    }

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel modelUsers = (DefaultTableModel) tablUsers.getModel();
        AddUser addUser = new AddUser(modelUsers, userManager);
        addUser.setVisible(true);
    }

    private void btnMakeLoanActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel modelLoans = (DefaultTableModel) tablLoans.getModel();
        MakeLoan makeloan = new MakeLoan(modelLoans, loanManager, userManager, bookManager);
        makeloan.setVisible(true);
    }

    // Variables declaration - no modificar
    private javax.swing.JButton btnAddBook;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnMakeLoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablBooks;
    private javax.swing.JTable tablLoans;
    private javax.swing.JTable tablUsers;
    // End of variables declaration
}