package edu.proyectofinal.gui;

import edu.proyectofinal.data.Book;
import edu.proyectofinal.data.Loan;
import edu.proyectofinal.data.User;
import edu.proyectofinal.process.BookManager;
import edu.proyectofinal.process.LoanManager;
import edu.proyectofinal.process.UserManager;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Menu extends javax.swing.JFrame {

    private BookManager bookManager;
    private UserManager userManager;
    private LoanManager loanManager;

    public Menu(BookManager bookManager, UserManager userManager, LoanManager loanManager) {
        this.loanManager = loanManager;
        this.bookManager = bookManager;
        this.userManager = userManager;
        initComponents();
        loadTables();

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

        java.awt.Color backgroundColor = new java.awt.Color(255, 245, 245);
        java.awt.Color primaryColor = new java.awt.Color(0, 150, 136);
        java.awt.Color accentColor = new java.awt.Color(255, 87, 34);
        java.awt.Color textColor = new java.awt.Color(33, 33, 33);

        getContentPane().setBackground(backgroundColor);

        styleButton(btnAddBook, primaryColor, Color.WHITE);
        styleButton(btnAddUser, primaryColor, Color.WHITE);
        styleButton(btnMakeLoan, accentColor, Color.WHITE);

        styleTable(tablBooks, primaryColor);
        styleTable(tablLoans, primaryColor);
        styleTable(tablUsers, primaryColor);

        jLabel1.setForeground(primaryColor);
        jLabel2.setForeground(primaryColor);
        jLabel3.setForeground(primaryColor);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 18);
        jLabel1.setFont(labelFont);
        jLabel2.setFont(labelFont);
        jLabel3.setFont(labelFont);

        jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane3.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane4.setBorder(BorderFactory.createEmptyBorder());
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
                Component c = super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);
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

    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnAddBook = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();
        btnMakeLoan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablBooks = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablLoans = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablUsers = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAddBook.setFont(new java.awt.Font("Segoe UI", 0, 10));
        btnAddBook.setText("Agregar libro");
        btnAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookActionPerformed(evt);
            }
        });

        btnAddUser.setFont(new java.awt.Font("Segoe UI", 0, 10));
        btnAddUser.setText("Agregar usuario");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnMakeLoan.setFont(new java.awt.Font("Segoe UI", 0, 10));
        btnMakeLoan.setText("Hacer prestamo");
        btnMakeLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeLoanActionPerformed(evt);
            }
        });

        tablBooks.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Titulo", "Autor", "Genero", "Copias", "Copias Disponibles"
                }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jScrollPane2.setViewportView(tablBooks);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel1.setText("Libros");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel2.setText("Prestamos");

        tablLoans.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String[]{
                        "Usuario", "Libro", "Fecha del prestamo", "Limite del prestamo", "Dias disponibles", "Status"
                }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jScrollPane3.setViewportView(tablLoans);

        tablUsers.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "ID", "Nombre", "Edad", "Prestamos", "Tipo de usuario"
                }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jScrollPane4.setViewportView(tablUsers);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel3.setText("Usuarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnMakeLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(400, 400, 400)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(345, 345, 345)))
                                .addContainerGap(257, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(403, 403, 403))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel3)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(158, 158, 158)
                                                                .addComponent(btnAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnMakeLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addGap(10, 10, 10)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
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
                    userManager.findUserByName(user.getName()).getUserType()
            });
        }

        for (Loan loan : loanManager.getLoans()) {
            User user = loan.getUser();
            Book book = loan.getBook();
            modelLoans.addRow(new Object[]{
                    user.getName(),
                    book.getTitle(),
                    loan.getStartDate(),
                    loan.getEndDate(),
                    loan.calculateDaysBetween(),
                    loan.getStatus()
            });
        }
    }

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
        DefaultTableModel modelBooks = (DefaultTableModel) tablBooks.getModel();
        DefaultTableModel modelLoans = (DefaultTableModel) tablLoans.getModel();
        DefaultTableModel modelUsers = (DefaultTableModel) tablUsers.getModel();
        MakeLoan makeLoan = new MakeLoan(modelLoans, loanManager, userManager, bookManager, modelBooks, modelUsers);
        makeLoan.setVisible(true);
    }

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
}