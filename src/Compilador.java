
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.io.IOException;

public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private Directory directorio2;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd, rang, enti, entProd;
    private ArrayList<Production> asigprod, asigprod2;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "LICA";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".Learn");
        directorio2 = new Directory(this,CampoIntermedio1,title,".asm");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (1000 * 0.01), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        asigprod = new ArrayList<>();
        asigprod2 = new ArrayList<>();
        entProd = new ArrayList<>();
        rang = new ArrayList<>();
        enti = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        CampoIntermedio = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        CampoIntermedio1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setBackground(new java.awt.Color(102, 102, 102));

        jtpCode.setBackground(new java.awt.Color(51, 51, 51));
        jtpCode.setFont(new java.awt.Font("Courier New", 3, 18)); // NOI18N
        jtpCode.setForeground(new java.awt.Color(255, 255, 255));
        jtpCode.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtpCode);

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(51, 51, 51));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setForeground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setBackground(new java.awt.Color(51, 51, 51));
        tblTokens.setForeground(new java.awt.Color(255, 255, 255));
        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ID", "Componente Léxico", "Entrada", "[R, C]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo Objeto");

        CampoIntermedio.setEditable(false);
        CampoIntermedio.setBackground(new java.awt.Color(51, 51, 51));
        CampoIntermedio.setColumns(20);
        CampoIntermedio.setForeground(new java.awt.Color(255, 255, 255));
        CampoIntermedio.setRows(5);
        jScrollPane4.setViewportView(CampoIntermedio);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Errores:");

        CampoIntermedio1.setEditable(false);
        CampoIntermedio1.setBackground(new java.awt.Color(51, 51, 51));
        CampoIntermedio1.setColumns(20);
        CampoIntermedio1.setForeground(new java.awt.Color(255, 255, 255));
        CampoIntermedio1.setRows(5);
        jScrollPane5.setViewportView(CampoIntermedio1);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Codigo Intermedio");

        jButton1.setText("Guardar Asm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(12, 12, 12))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel3))
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)))
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rootPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(148, 148, 148))))))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane2)))
        );

        getContentPane().add(rootPanel);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/20x20.jpg"))); // NOI18N
        jMenu5.setMaximumSize(new java.awt.Dimension(40, 40));
        jMenuBar1.add(jMenu5);
        jMenu5.setFocusPainted(false);
        jMenu5.setFocusable(false);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.jpg"))); // NOI18N
        jMenu1.setText("Abrir");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4.png"))); // NOI18N
        jMenu2.setText("Nuevo");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.png"))); // NOI18N
        jMenu3.setText("Guardar");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/3.jpg"))); // NOI18N
        jMenu4.setText("Guardar Como");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu6.setText("                                    ");
        jMenu6.setEnabled(false);
        jMenu6.setFocusable(false);
        jMenuBar1.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/231.png"))); // NOI18N
        jMenu7.setText("Analizar");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        directorio.New();
        clearFields();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        directorio2.SaveAs();
        directorio2.Save();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void borrarprod() {

    }

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
       
        printConsole();
        if(errors.isEmpty()){
         fillTablaCuadruplos();
         llenarcodigoObjeto();}
        codeHasBeenCompiled = true;

    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no Existe " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error Al Guardar " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {
        Grammar gramatica = new Grammar(tokens, errors);
        /* Eliminar errores */
        gramatica.delete(new String[]{"error", "ERROR"}, 1);
        /* agrupar identificadores y parametros */

 /* agrupar valores */
        gramatica.group("VALOR", "numero_decimal | valor_cadena | dato_bol | numero_entero", true);
        gramatica.group("OPERADOR", "operador_suma| operador_resta| operador_multiplicacion | operador_division | operador_and | operador_or | operador_diferente | operador_menorque | operador_mayorque | operador_equivalencia | operador_menoroigual | operador_mayoroigual");
        gramatica.group("TIPO", "dato_cadena | dato_entero | dato_entero | dato_fecha | dato_booleano", true);
        gramatica.group("ENTIDADES", "entidades");

        /* declarar variable */
        gramatica.group("DECLARAR_VARIABLE", "TIPO identificador operador_asignacion VALOR", true, identProd);
        //No !
        gramatica.group("DECLARAR_VARIABLE", "TIPO identificador operador_asignacion", true,
                2, "Error sintáctico {}: falta el valor en la declaracion de variable en:[#,%]");
        // no identificador
        gramatica.group("DECLARAR_VARIABLE", "TIPO operador_asignacion VALOR", true,
                3, "Error sintáctico {}: falta el IDENTIFICADOR en la declaracion de variable en:[#,%]");
        //no asignacion
        gramatica.group("DECLARAR_VARIABLE", "TIPO identificador VALOR", true,
                4, "Error sintáctico {}: falta el identificador en la declaracion de variable en:[#,%]");
        // no tipo de dato
        // gramatica.group("DECLARAR_VARIABLE"," identificador operador_asignacion VALOR | OPERACIONES",true,
        // 5,"Error sintáctico {}: falta el valor en la declaracion de variable en:[#,%]");  
        //gramatica.delete("TIPO",34,"Error sintáctico {}: se espera la estructura (tipo de dato)(identificador)(=)(valor) (Linea: # )");
        gramatica.delete("TIPO", 6, "Error sintáctico {}: se espera la estructura (tipo de dato)(identificador)(=)(valor) (Linea: # )");

        //ENTIDADES-----------
        gramatica.group("ENTIDADES_COMPZ", "ENTIDADES corchete_a VALOR corchete_c", true, enti);

        gramatica.group("ENTIDADES_COMP", "ENTIDADES VALOR corchete_c", true, 9, "error sintáctico {}: falta el corchete de apertura [#,%]");
        gramatica.finalLineColumn();
        gramatica.group("ENTIDADES_COMP", "ENTIDADES corchete_a VALOR", true, 10, "error sintáctico {}: falta el corchete de cierre [#,%]");
        gramatica.group("ENTIDADES_COMP", "ENTIDADES corchete_a corchete_c", true, 11, "error sintáctico {}: falta el indice[#,%]");
        gramatica.initialLineColumn();
        gramatica.group("ENTIDADES_COMP", "ENTIDADES VALOR ", true, 12, "error sintáctico {}: faltan los corchetes [#,%]");

        gramatica.group("ENTIDADES_COMP", "ENTIDADES parentesis_c ", true, 13, "error sintáctico {}: no se permiten parentesis , usa corchetes [#,%]");
        gramatica.group("ENTIDADES_COMP", "ENTIDADES parentesis_a ", true, 14, "error sintáctico {}: no se permiten parentesis , usa corchetes [#,%]");
        gramatica.group("ENTIDADES_COMP", "ENTIDADES parentesis_a parentesis_c ", true, 15, "error sintáctico {}: no se permiten parentesis , usa corchetes [#,%]");
        gramatica.group("ENTIDADES_COMP", "ENTIDADES llaves_c ", true, 16, "error sintáctico {}: no se permiten llaves , usa corchetes [#,%]");
        gramatica.group("ENTIDADES_COMP", "ENTIDADES llaves_a ", true, 17, "error sintáctico {}: no se permiten llaves , usa corchetes [#,%]");
        gramatica.group("ENTIDADES_COMP", "ENTIDADES llaves_a llaves_c ", true, 18, "error sintáctico {}: no se permiten llaves , usa corchetes [#,%]");

        gramatica.group("ENTIDADES_COMP", "ENTIDADES", true, 19, "error sintáctico {}: se espera la estructura: entidad [ numero_entero ] [#,%]");

        //-----------------------------------------------------
//operaciones
        gramatica.group("VALORES", "identificador | VALOR");

        gramatica.group("OPERACIONES", "VALORES operador_asignacion VALORES OPERADOR VALORES", true, asigprod2);

        gramatica.group("OPERACIONEU", "VALORES operador_asignacion VALORES", true, asigprod);

        //falta de primer operador
        gramatica.group("OPERACIONES", " (VALORES operador_asignacion VALORES OPERADOR)", true, 7, "Error sintáctico {}: falta un operando en la operacion en:[#,%]");
        // falta segundo operador (error en operaciones impares) 
// gramatica.group("OPERACIONES","(operador_asignacion VALORES OPERADOR VALORES)",true,8,"Error sintáctico {}: falta el identificador en:[#,%]");

        gramatica.group("OPERACIONES", "(VALORES VALORES OPERADOR VALORES )", true, 8, "Error sintáctico {}: falta el operador de asignacion en:[#,%]");

        gramatica.group("OPERACIONES", "VALORES operador_asignacion", true, 58, "Error sintáctico {}: falta el valor a asignar en:[#,%]");
        //RANGO-------------------_____

        gramatica.group("RANGO", "rango_entidad parentesis_a VALORES coma VALORES parentesis_c", true, rang);

        gramatica.group("RANGO",
                "(rango_entidad VALORES coma VALORES parentesis_c) |"
                + "(rango_entidad coma VALORES parentesis_c) |"
                + "(rango_entidad coma parentesis_c) |"
                + "rango_entidad coma parentesis_c", true, 20, "\"error sintáctico {}: falta el parentesis de apertura [#,%]");

        gramatica.group("RANGO",
                "(rango_entidad parentesis_a (VALORES coma)? parentesis_c) |"
                + "rango_entidad parentesis_a coma parentesis_c", true, 21, "\"error sintáctico {}: falta el valor del rango[#,%]");

        gramatica.group("RANGO",
                "rango_entidad parentesis_a (VALORES coma VALORES) |"
                + "(rango_entidad parentesis_a coma VALORES) |"
                + "(rango_entidad parentesis_a VALORES coma) |"
                + "rango_entidad parentesis_a coma", true, 22, "\"error sintáctico {}: falta el parentesis de cierre [#,%]");

        gramatica.group("RANGO",
                "rango_entidad parentesis_a VALORES coma VALOR_NO_E parentesis_c |"
                + "rango_entidad parentesis_a VALOR_NO_E coma VALORES parentesis_c|", true, 23, "\"error sintáctico {}: falta el parentesis de cierre [#,%]");

        gramatica.group("RANGO", "rango_entidad", true, 24, "\"error sintáctico {}: La estructura es: rango(IDENTIFICADOR O NUMERO ENTERO,IDENTIFICADOR O NUMERO ENTERO) [#,%]");

        gramatica.group("ENT", "entidad_unica | ENTIDADES_COMP");
        gramatica.group("ENTI", "ENT punto (FUNCIONES | RANGO)");
        // gramatica.group("ENTI", "ENT (FUNCIONES | RANGO)", true, 32, "error sintáctico {}: el punto para llamar metodo[#,%]");

        //FUNCIONES /// COMPLETAR.-----
        gramatica.group("FUNCION", "reservada_imprime | conversion | reservada_leer");
        gramatica.group("FUNCIONES", "FUNCION parentesis_a (VALORES | (VALORES coma VALORES)+) parentesis_c", true);
        gramatica.group("FUNCIONES", "FUNCION parentesis_a parentesis_c", true, 25, "error sintáctico {}: faltan parametros [#,%]");
        gramatica.group("FUNCIONES", "FUNCION (VALORES | (VALORES coma VALORES)+) parentesis_c", true, 26, "error sintáctico {}: falta el parentesis de apertura [#,%]");
        gramatica.group("FUNCIONES", "FUNCION parentesis_a (VALORES | (VALORES coma VALORES)+)", true, 27, "error sintáctico {}: falta el parentesis de cierre [#,%]");

        //-------------------
        //Definir if
        gramatica.group("E_SI", "(reservada_si | reservada_no | reservada_si_no | reservada_mientras)");

        gramatica.group("SI_S", "E_SI  parentesis_a VALORES OPERADOR VALORES parentesis_c doblePunto (DECLARAR_VARIABLE |  OPERACIONES | OPERACIONEU | RANGO | FUNCION | ENTIDADES_COMPZ | FUNCIONES)*? doblePunto");
        gramatica.group("SI", " parentesis_a VALORES OPERADOR VALORES parentesis_c doblePunto (DECLARAR_VARIABLE |  OPERACIONES | OPERACIONEU | RANGO | FUNCION | ENTIDADES_COMPZ | FUNCIONES)*? doblePunto", true, 34, "error sintáctico {}: falta la palabra reservada de condicion [#,%]");
        gramatica.group("SI", "E_SI VALORES OPERADOR VALORES parentesis_c doblePunto (DECLARAR_VARIABLE | OPERACIONES | OPERACIONEU | RANGO | FUNCION | ENTIDADES_COMPZ | FUNCIONES)*? doblePunto", true, 36, "error sintáctico {}: falta parentesis de apertura en condicion [#,%]");
        gramatica.group("SI", "E_SI parentesis_a VALORES OPERADOR VALORES doblePunto (DECLARAR_VARIABLE |  OPERACIONES | OPERACIONEU | RANGO | FUNCION | ENTIDADES_COMPZ | FUNCIONES)*? doblePunto", true, 37, "error sintáctico {}: falta parentesis de cierre en condicion [#,%]");
        gramatica.group("SI", "E_SI parentesis_a VALORES OPERADOR VALORES parentesis_c (DECLARAR_VARIABLE |  OPERACIONES | OPERACIONEU | RANGO | FUNCION | ENTIDADES_COMPZ | FUNCIONES)*? doblePunto", true, 38, "error sintáctico {}: falta doble punto de apertura en condicion [#,%]");
        gramatica.group("SI", "E_SI parentesis_a VALORES OPERADOR VALORES parentesis_c  doblePunto (DECLARAR_VARIABLE |  OPERACIONES | OPERACIONEU | RANGO | FUNCION | ENTIDADES_COMPZ | FUNCIONES)*?", true, 39, "error sintáctico {}: falta doble punto de cierre en condicion [#,%]");
        gramatica.group("SI", "E_SI parentesis_a OPERADOR VALORES parentesis_c  doblePunto (DECLARAR_VARIABLE |  OPERACIONES | OPERACIONEU | RANGO | FUNCION | ENTIDADES_COMPZ | FUNCIONES)*? doblePunto", true, 40, "error sintáctico {}: falta valor en la condicion [#,%]");
        gramatica.group("SI", "E_SI parentesis_a VALORES OPERADOR parentesis_c  doblePunto (DECLARAR_VARIABLE | OPERACIONES | OPERACIONEU | RANGO | FUNCION | ENTIDADES_COMPZ | FUNCIONES)*? doblePunto", true, 41, "error sintáctico {}: falta valor en la condicion [#,%]");
        gramatica.group("SI", "E_SI parentesis_a VALORES VALORES parentesis_c  doblePunto (DECLARAR_VARIABLE |  OPERACIONES | OPERACIONEU | RANGO | FUNCION | ENTIDADES_COMPZ | FUNCIONES)*? doblePunto", true, 42, "error sintáctico {}: falta operador en la condicion [#,%]");

        //definir ciclo
        gramatica.group("CICLO_H", "while parentesis_a VALORES parentesis_c signociclo (DECLARAR_VARIABLE |  OPERACIONES | OPERACIONEU | RANGO | FUNCION | ENTIDADES_COMPZ | FUNCIONES | SI | SI_S)*? signociclo");
        gramatica.group("CICLO_H2", "while parentesis_a VALORES parentesis_c signociclo", true, 43, "error sintáctico {}: falta cerrar el ciclo [#,%]");

        gramatica.group("CODIGO_DF", "(DECLARAR_VARIABLE | OPERACIONES | OPERACIONEU | RANGO | FUNCION | ENTIDADES_COMPZ | FUNCIONES | SI  | SI_S | CICLO_H)", true);

        gramatica.group("MET", "reservada_inicio | reservada_principal | reservada_funcion");

        gramatica.group("METODO", "MET parentesis_a parentesis_c llaves_a (CODIGO_DF)*? llaves_c", true);
        gramatica.group("METODO", "MET parentesis_a parentesis_c (CODIGO_DF)*?llaves_c", true, 31, "error sintáctico {}: falta la llave de apertura [#,%]");
        gramatica.group("METODO", "MET parentesis_a parentesis_c llaves_a (CODIGO_DF)*?", true, 32, "error sintáctico {}: falta la llave de cierre [#,%]");

        gramatica.group("METODO", "MET parentesis_c llaves_a (CODIGO_DF)*? llaves_c", true, 33, "error sintáctico {}: falta parentesis de apertura [#,%]");
        gramatica.group("METODO", "MET parentesis_a llaves_a (CODIGO_DF)*? llaves_c", true, 34, "error sintáctico {}: falta parentesis de cierre [#,%]");
        gramatica.group("METODO", "MET (VALORES | PARAMETROS) llaves_a (CODIGO_DF)*? llaves_c", true, 35, "error sintáctico {}: faltan parentesis [#,%]");

        /* Mostrar gramáticas */
        gramatica.show();
    }

    private void semanticAnalysis() {
        System.out.println("Anális semántico:" + identProd.size());

        //Analisis semántico para las declaraciones de variables 
        //HashMap que tiene como clave el lexema y valor el tipo de dato valido
        HashMap<String, String> identDataType = new HashMap<>();
        //Para las cadenas
        identDataType.put("cadena", "valor_cadena");
        identDataType.put("fecha", "valor_cadena");
        //Para tipos de dato que reciben enteros
        identDataType.put("torque", "numero_entero");
        identDataType.put("entero", "numero_entero");
        identDataType.put("potencia", "numero_entero");
        identDataType.put("rotacion", "numero_entero");
        identDataType.put("velocidad", "numero_entero");
        identDataType.put("presion", "numero_entero");
        identDataType.put("kilometraje", "numero_entero");
        identDataType.put("giro", "numero_entero");
        //Para tipos de dato que reciben decimales
        identDataType.put("flotante", "numero_decimal");
        identDataType.put("tiempo", "numero_decimal");
        identDataType.put("temperatura", "numero_decimal");
        identDataType.put("aceleracion", "numero_decimal");

        identDataType.put("booleano", "dato_bol");
        //operadores

        try {
            for (Production id : identProd) {
                if (!identDataType.get(id.lexemeRank(0)).equals(id.lexicalCompRank(-1))) {
                    errors.add(new ErrorLSSL(1, "Error semántico {}: Valor no compatible es con el tipo de dato [#, %]", id, true));
                }/*else if(identDataType.get(id.lexemeRank(0)).equals("dato_fecha") && !id.lexemeRank(-1).matches("'[0-9][0-9]/[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9]'")) {
                errors.add(new ErrorLSSL(2, "Error semántico {}: La fecha no tiene el formato correcto [#, %]",id,false));
            
            }*/ else {
                    if (identificadores.containsKey(id.lexemeRank(1))) {
                        errors.add(new ErrorLSSL(2, "Error semántico {}: Variable ya declarada [#, %]", id, false));
                    } else {
                        identificadores.put(id.lexemeRank(1), id.lexicalCompRank(-1));
                    }

                }

                System.out.println(id.lexemeRank(1) + " : " + id.lexicalCompRank(-1));

            }//for identProd
            //Analisis de asignación 
            for (Production id : asigprod) {
                if (!id.lexicalCompRank(0).equals("identificador")) {
                    errors.add(new ErrorLSSL(3, "Error semántico {}: Asignación invalida, debe ser un identificador [#, %]", id, true));
                } else {
                    if (!identificadores.containsKey(id.lexemeRank(0))) {
                        errors.add(new ErrorLSSL(4, "Error semántico {}: La variable no ha sido inicializada [#, %]", id, false));
                    } else {

                        //Es cuando la asignación no tiene operaciones
                        //Existen dos posibles, que el componente lexico que se asigna sea un identificador
                        if (id.lexicalCompRank(2).equals("identificador")) {
                            if (!identificadores.containsKey(id.lexemeRank(2))) {

                                errors.add(new ErrorLSSL(5, "Error semántico {}: el valor asignado no es compatible ya que no esta declarado" + "[#, %]", id, false));

                            } else {
                                //Si es un identificador el token a asignar
                                if (!identificadores.get(id.lexemeRank(0)).equals(identificadores.get(id.lexemeRank(2)))) {
                                    errors.add(new ErrorLSSL(6, "Error semántico {}: No es compatible el tipo de dato del identificador a asignar se esperaba un " + identificadores.get(id.lexemeRank(0)) + "[#, %]", id, false));
                                }
                            }
                        } else {
                            //si no es identificador
                            if (!identificadores.get(id.lexemeRank(0)).equals(id.lexicalCompRank(2))) {
                                errors.add(new ErrorLSSL(7, "Error semántico {}: No es compatible la asignación se esperaba un " + identificadores.get(id.lexemeRank(0)) + "[#, %]", id, false));

                            }
                        }
                    }
                }

            }//for asigProd

            for (Production id : asigprod2) {

                System.out.println("CompLex: " + id.lexicalCompRank(0) + " - Tipo de dato " + identificadores.get(id.lexemeRank(0)) + " - Identificador " + id.lexemeRank(0));
                System.out.println(" = ");
                System.out.println("CompLex: " + id.lexicalCompRank(2) + " - Tipo de dato " + identificadores.get(id.lexemeRank(2)) + " - Identificador " + id.lexemeRank(2));
                System.out.println(id.lexemeRank(3));
                System.out.println("CompLex: " + id.lexicalCompRank(4) + " - Tipo de dato " + identificadores.get(id.lexemeRank(4)) + " - Identificador " + id.lexemeRank(4));
                //Cuando la asignación tiene operaciones, las operaciones son binarias
                System.out.println(identificadores.get(id.lexemeRank(2)));

                if (!id.lexicalCompRank(0).equals("identificador")) {
                    errors.add(new ErrorLSSL(8, "Error semántico {}: Asignación invalida, debe ser un identificador [#, %]", id, true));
                }

                if (!id.lexicalCompRank(2).equals("identificador") && !id.lexicalCompRank(4).equals("identificador")) {
                    //Entra cuando ambos operandos no son identificadores
                    if (!identificadores.get(id.lexemeRank(0)).equals(id.lexicalCompRank(4)) || !identificadores.get(id.lexemeRank(0)).equals(id.lexicalCompRank(2))) {
                        errors.add(new ErrorLSSL(15, "Error semántico {}: asignacion invalida, se esperaba un " + identificadores.get(id.lexemeRank(0)) + "[#, %]", id, false));
                    }

                }

                if (id.lexicalCompRank(2).equals("identificador") || id.lexicalCompRank(4).equals("identificador")) {

                    if ((!identificadores.containsKey(id.lexemeRank(2)) && id.lexicalCompRank(2).equals("identificador")) || (!identificadores.containsKey(id.lexemeRank(4)) && id.lexicalCompRank(4).equals("identificador"))) {
                        // aqui lanza error cuando algun identificador de los operandos no exista
                        errors.add(new ErrorLSSL(9, "Error semántico {}: asignación invalida la variable no está declarada" + "[#, %]", id, false));

                    } else { // entra a este else cuando ya evaluo que existen lso operandos para comparar op/num num/op y 
                        if (id.lexicalCompRank(2).equals("identificador") && !id.lexicalCompRank(4).equals("identificador")) {
                            if (!identificadores.get(id.lexemeRank(0)).equals(identificadores.get(id.lexemeRank(2)))) {
                                errors.add(new ErrorLSSL(10, "Error semántico {}: Variable invalida, se esperaba un " + identificadores.get(id.lexemeRank(0)) + "[#, %]", id, false));
                            } else if (!identificadores.get(id.lexemeRank(0)).equals(id.lexicalCompRank(4))) {
                                errors.add(new ErrorLSSL(11, "Error semántico {}: No es compatible la asignación se esperaba un " + identificadores.get(id.lexemeRank(0)) + "[#, %]", id, false));
                            }

                        } else if (id.lexicalCompRank(4).equals("identificador") && !id.lexicalCompRank(2).equals("identificador")) {

                            if (!identificadores.get(id.lexemeRank(0)).equals(identificadores.get(id.lexemeRank(4)))) {
                                errors.add(new ErrorLSSL(12, "Error semántico {}: Variable invalida, se esperaba un " + identificadores.get(id.lexemeRank(0)) + "[#, %]", id, false));
                            } else if (!identificadores.get(id.lexemeRank(0)).equals(id.lexicalCompRank(2))) {
                                errors.add(new ErrorLSSL(13, "Error semántico {}: No es compatible la asignación se esperaba un " + identificadores.get(id.lexemeRank(0)) + "[#, %]", id, false));
                            }
                        } else if (id.lexicalCompRank(2).equals("identificador") && id.lexicalCompRank(4).equals("identificador")) {

                            if (!identificadores.get(id.lexemeRank(2)).equals(identificadores.get(id.lexemeRank(0))) || !identificadores.get(id.lexemeRank(4)).equals(identificadores.get(id.lexemeRank(0)))) {
                                errors.add(new ErrorLSSL(14, "Error semántico {}: No es compatible la asignación se esperaba un " + identificadores.get(id.lexemeRank(0)) + "[#, %]", id, false));
                            }
                        }

                    }//else

                }//if padre
                //-------------------------------------------------------

                //operadores
                /*
        //Lógicos
            operador_and
            operador_diferente
            operador_or
        //Númericos
            operador_suma
            operador_resta
            operador_multiplicacion
            operador_division
            operador_asignacion
            operador_mayoroigual
            operador_menoroigual
            operador_menorque"
            operador_mayorque
            operador_equivalencia
                 */
                //Aquí se va a evaluar el operador
                HashMap<String, String> opeTypes = new HashMap<>();
                //Operadores Lógicos
                opeTypes.put("operador_and", "operador_Logico");
                opeTypes.put("operador_diferente", "operador_Logico");
                opeTypes.put("operador_or", "operador_Logico");
                //Operadores numericos
                opeTypes.put("operador_suma", "operador_Numerico");
                opeTypes.put("operador_resta", "operador_Numerico");
                opeTypes.put("operador_multiplicacion", "operador_Numerico");
                opeTypes.put("operador_division", "operador_Numerico");
                //Operadores de comparación
                opeTypes.put("operador_mayoroigual", "operador_Comparacion");
                opeTypes.put("operador_menoroigual", "operador_Comparacion");
                opeTypes.put("operador_menorque", "operador_Comparacion");
                opeTypes.put("operador_mayorque", "operador_Comparacion");
                opeTypes.put("operador_equivalencia", "operador_Comparacion");

                if (identificadores.get(id.lexemeRank(0)).equals("dato_bol") && !opeTypes.get(id.lexicalCompRank(3)).equals("operador_Logico")) {
                    errors.add(new ErrorLSSL(16, "Error semántico {}: Operación invalida, debe ser un operador lógico [#, %]", id, false));
                } else if ((identificadores.get(id.lexemeRank(0)).equals("numero_entero") || identificadores.get(id.lexemeRank(0)).equals("numero_decimal"))
                        && !opeTypes.get(id.lexicalCompRank(3)).equals("operador_Numerico")) {
                    errors.add(new ErrorLSSL(17, "Error semántico {}: Operación invalida, debe ser un operador Aritmetico [#, %]", id, false));
                }
                if ((identificadores.get(id.lexemeRank(0)).equals("numero_decimal")) || identificadores.get(id.lexemeRank(0)).equals("numero_entero")
                        && id.lexemeRank(4).substring(0, 1).equals("0") && id.lexicalCompRank(3).equals("operador_division")) {
                    errors.add(new ErrorLSSL(17, "Error semántico {}: Operación invalida, No es valido dividir entre cero [#, %]", id, false));
                }

                //System.out.println("Tipo del identificador: "+identificadores.get(id.lexemeRank(0))+", Operador: "+Integer.parseInt(id.lexemeRank(4)));
            }//for asigProd2

            for (Production id : enti) {
                System.out.println(id.lexicalCompRank(2));
                if (!id.lexicalCompRank(2).equals("numero_entero")) {
                    errors.add(new ErrorLSSL(18, "Error semántico {}: Una entidad recibe como parametro un número entero [#, %]", id, false));
                }
            }

            for (Production id : rang) {
                System.out.println("-+++++++" + id.lexicalCompRank(2));
                System.out.println(id.lexicalCompRank(4));

                if (!id.lexicalCompRank(2).equals("numero_entero") || !id.lexicalCompRank(4).equals("numero_entero")) {
                    errors.add(new ErrorLSSL(19, "Error semántico {}: Un rango recibe como parametros números enteros [#, %]", id, false));
                }
            }
        } catch (Exception ex) {

            System.out.println("NullPointerException");
        }

    }

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no Existe " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error Al guardar " + ex.getMessage());
        }

        Functions.colorTextPane(textsColor, jtpCode, new Color(255, 255, 255));
    }//color
    ///inicio
    
        public ArrayList<String> matches(String text, String regex) {
        ArrayList<String> texts = new ArrayList();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Found text: " + matcher.group());
            System.out.println("Start index: " + matcher.start());
            System.out.println("End index: " + matcher.end());
            System.out.println("=============================");
            texts.add(matcher.group());
        }
        return texts;
    }
    public ArrayList<String> codigoIntermedio() {
        String codigo = jtpCode.getText();
        // codigo = codigo.replaceAll("//.*", "");
        codigo = codigo.replaceAll("[\r]+", "");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXx");
        System.out.println(codigo);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXx");
        //llaves removidas
        String expregularnumero = "(for[\\t\\s]*\\([\\t\\s]*([0-9]+|\\_[A-Za-zÑñÁÉÍÓÚ]+)[\\t\\s]*\\))|"
                + "(si[\\t\\s]*\\([\\t\\s]*([0-9]+|\\_[A-Za-zÑñÁÉÍÓÚ]+)[\\t\\s]*(>|<|>=|<=|==|!=)[\\t\\s]*([0-9]+|\\_[A-Za-zÑñÁÉÍÓÚ]+)[\\t\\s]*\\))|"
                + "(\\_[A-Za-zÑñÁÉÍÓÚ]+[\\t\\s]*=[\\t\\s]*([0-9]+|\".*\"))|"
                + "\\_[A-Za-zÑñÁÉÍÓÚ]+[\\t\\s]*=[\\t\\\\s]*\\_[A-Za-zÑñÁÉÍÓÚ]+[\\t\\s]*(\\+|\\-|\\*|\\/)[\\t\\s]*\\_[A-Za-zÑñÁÉÍÓÚ]+|"
                + "(imprime\\('[^']*'\\))";
                
        return matches(codigo,expregularnumero);
      
    }
    private void fillTablaCuadruplos() {
        String Estado = "";
        String If_For = "";
        String cadena = "";
        String cadenaOpti = "";
        ArrayList<String> Arre = codigoIntermedio();
        System.out.println("=================\n" + Arre);
  

        for (int a = 0; a < Arre.size(); a++) {
            ArbolExpresion arbolExpresionArit = new ArbolExpresion();
            String cad = Arre.get(a);
            String Cadena[] = arbolExpresionArit.crearArbol(cad);
            cadena = cadena + Cadena[0];
            cadenaOpti = cadenaOpti + Cadena[1];
            if (cad.contains("si")) {
                If_For = "si";
                if (Arre.get(a + 1).equals(":")){
                    cadenaOpti = cadenaOpti + "\n\n label L1\n";
                    cadena = cadena + "\n\n label L1\n";
                    Estado = "NoCodigo";
                } else {
                    Estado = "SiCodigo";
                }
            }
            // "\n goto L1\n label L2\n\n" ; 
            if (cad.contains("for")) {
                If_For = "for";
                if (Arre.get(a + 1).equals("_")) {
                    cadenaOpti = cadenaOpti + "\n\n goto L1\n label L2\n\n";
                    cadena = cadena + "\n\n goto L1\n label L2\n\n";
                    Estado = "NoCodigo";
                } else {
                    Estado = "SiCodigo";
                }
            }
            if (cad.contains(":") && Estado.equals("SiCodigo") && If_For.equals("si")) {
                cadenaOpti = cadenaOpti + "\n\n label L1\n";
                cadena = cadena + "\n\n label L1\n";
                If_For = "NoBucles";
            }
            if (cad.contains("$") && Estado.equals("SiCodigo") && If_For.equals("for")) {
                cadenaOpti = cadenaOpti + "\n\n goto L1\n label L2\n\n";
                cadena = cadena + "\n\n goto L1\n label L2\n\n";
                If_For = "NoBucles";
            }
              if (cad.contains("$") && Estado.equals("SiCodigo") && If_For.equals("for")) {
                cadenaOpti = cadenaOpti + "\n\n goto L1\n label L2\n\n";
                cadena = cadena + "\n\n goto L1\n label L2\n\n";
                If_For = "NoBucles";
            }
              
            System.out.println("CadenaOptimazada\n" + Cadena[1]);

            ArrayList<Cuadruplo> cuadruplos = arbolExpresionArit.getCuadruplos();
            for (int i = 0; i < cuadruplos.size(); i++) {
                Cuadruplo cuadruplo = cuadruplos.get(i);
                String operador = cuadruplo.getOp();
                String argu1 = cuadruplo.getArg1();
                String argu2 = cuadruplo.getArg2();
                String resul = cuadruplo.getR();
               
                
                System.out.println("*****************----"+operador + " " + argu1 + " " + argu2 + " " + resul);
            }
        }
        System.out.println("Tokens listos");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&\n" + cadena);
       // System.out.println("Optimizado\n" + cadenaOpti);
       // CodigoOptimizado = cadenaOpti;
        CampoIntermedio.setText(cadena);
    
    }
    
    
public ArrayList<String> codigoObjeto(){
   String codigoI = CampoIntermedio.getText();
   codigoI = codigoI.replaceAll("[\r]+", "");
    String expregular ="(\\_[A-Za-zÑñÁÉÍÓÚ]+[\\t\\s]*=[\\t\\s]*([0-9]+|\".*\"))|"
            +"(imprime\\('[^']*'\\))";
    //si(_torque<150)
    return matches(codigoI,expregular);
}

public void llenarcodigoObjeto(){
     String cadenaObjeto = ".model small\n" +
".stack \n" +
".data \n";
     ArrayList<String> Arre = codigoObjeto();
        System.out.println("pppppppppppppppppppppppppp\n" + Arre);
        int h=1;
         for (int a = 0; a < Arre.size(); a++) {
            ArbolExpresion arbolExpresionArit = new ArbolExpresion();
            String cad = Arre.get(a);
            String Cadena[] = arbolExpresionArit.crearArbol(cad);
            cadenaObjeto = cadenaObjeto + Cadena[0];
           
              if (cad.contains("_")) {
      
                cadenaObjeto = cadenaObjeto.replace("=", " dw ");
                
              cadenaObjeto = cadenaObjeto + "";   
              }
                 if (cad.contains("imprime")) {
                     
                    
      cadenaObjeto = cadenaObjeto.replace("imprime(", "mensaje"+h+" db ");
      cadenaObjeto = cadenaObjeto.replace("')", "',0ah,0dh");
     
              cadenaObjeto = cadenaObjeto + "";  
              
                 h++;
              }
                 if(h==3){
                                      cadenaObjeto = cadenaObjeto+ " \n msg_end db 0 \n .code \n"+
                                              "\n principal: \n"+ "\n"+
                                              
    "mov ax, @data \n"  +    "\n"+  
    "mov ds, ax \n";
                                     cadenaObjeto = cadenaObjeto+"\n"+    

        "MOV DL,12"+"\n"+ "\n"+
        "MOV AH,5"+"\n"+ "\n"+
        "INT 21H"+"\n"+ "\n"+
        
          
        "MOV CX,offset msg_end - offset mensaje1"+"\n"+ "\n"+
        "MOV SI,OFFSET mensaje1"+"\n"+ "\n"+
      " ifsi: " + "\n"+  "\n"+
        "MOV DL,[SI]"+"\n"+ "\n"+
        "MOV AH,5"+"\n"+ "\n"+
        "INT 21H"+"\n"+ "\n"+
            
            "INC SI"+"\n"+ "\n"+
    
       " LOOP ifsi"  +"\n"+ "\n"+
            
        
    
    "MOV AX,4C00H"+"\n"+ "\n"+
    "INT 21H"+"\n";
                 }
                 
           
         }
   
                 
 
              
                
              
 
      CampoIntermedio1.setText(cadenaObjeto);

}

    public String id(String n) {

        return "";
    }

    private void fillTableTokens() {

        tokens.forEach(token -> {

            Object[] data = new Object[]{id(token.getLexicalComp()), token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private int numerrores() {

        String line = System.getProperty("line.separator");

        String demo = jtaOutputConsole.getText();

        int replace = demo.length() - demo.replace("\n", "").length();

        return replace - 3;

    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";

            }
            int replace = strErrors.length() - strErrors.replace("\n", "").length();
            int a = replace - 1;
            jtaOutputConsole.setText("Compilación lista\n" + strErrors + "\n La compilación terminó con " + a + " ERRORES...");
        } else {
            jtaOutputConsole.setText("Compilación sin errores\n");
        }
        jtaOutputConsole.setCaretPosition(0);
 
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        CampoIntermedio.setText("");
           CampoIntermedio1.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        asigprod.clear();
        asigprod2.clear();
        rang.clear();
        enti.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CampoIntermedio;
    private javax.swing.JTextArea CampoIntermedio1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
