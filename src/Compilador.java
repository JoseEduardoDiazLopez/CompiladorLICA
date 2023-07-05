
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
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

   
    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "LEARN++";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".Learn");
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

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addContainerGap())
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
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

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
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
          gramatica.delete(new String[]{"error","ERROR"},1);
          /* agrupar identificadores y parametros */
           
          
            /* agrupar valores */
      
            gramatica.group("VALOR","numero_decimal | valor_cadena | bool_v | bool_f | numero_entero",true);
            gramatica.group("OPERADOR","operador_suma| operador_resta| operador_multiplicacion | operador_division | operador_and | operador_or | operador_diferente");
            gramatica.group("TIPO","dato_cadena | dato_entero | dato_entero | dato_fecha | dato_booleano",true);
            gramatica.group("ENTIDADES", "entidades");
        
          
           /* declarar variable */
           gramatica.group("DECLARAR_VARIABLE","TIPO identificador operador_asignacion VALOR | OPERACIONES",true);
           //No !
           gramatica.group("DECLARAR_VARIABLE","TIPO identificador operador_asignacion",true,
                   2,"Error sintáctico {}: falta el valor en la declaracion de variable en:[#,%]");
           // no identificador
        gramatica.group("DECLARAR_VARIABLE","TIPO operador_asignacion VALOR | OPERACIONES",true,
                   3,"Error sintáctico {}: falta el IDENTIFICADOR en la declaracion de variable en:[#,%]");
        //no asignacion
         gramatica.group("DECLARAR_VARIABLE","TIPO identificador VALOR | OPERACIONES",true,
                   4,"Error sintáctico {}: falta el identificador en la declaracion de variable en:[#,%]");
            // no tipo de dato
           gramatica.group("DECLARAR_VARIABLE"," identificador operador_asignacion VALOR | OPERACIONES",true,
                   5,"Error sintáctico {}: falta el valor en la declaracion de variable en:[#,%]");  
           //gramatica.delete("TIPO",34,"Error sintáctico {}: se espera la estructura (tipo de dato)(identificador)(=)(valor) (Linea: # )");
           gramatica.delete("TIPO",6,"Error sintáctico {}: se espera la estructura (tipo de dato)(identificador)(=)(valor) (Linea: # )");
           
           
       //ENTIDADES-----------
       
    gramatica.group("ENTIDADES_COMP", "ENTIDADES corchete_a VALOR corchete_c", true);
        
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
gramatica.group("VALORES", " IDENTIFICADOR | VALOR");

 gramatica.group("OPERACIONES"," VALORES OPERADOR VALORES",true); 
 
    //falta de primer operador
  gramatica.group("OPERACIONES"," VALORES OPERADOR",true,7,"Error sintáctico {}: falta un operando en la operacion en:[#,%]");
          // falta segundo operador (error en operaciones impares) 
 //gramatica.group("OPERACIONES"," OPERADOR VALORES",true,8,"Error sintáctico {}: falta un valor en la operacion en:[#,%]");
  
   
 
 //RANGO-------------------
 
 gramatica.group("RANGO", "rango_entidad parentesis_a VALORES coma VALORES parentesis_c", true);
        
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
        
         gramatica.group("CODIGO_DF", "(DECLARAR_VARIABLE | OPERACIONES)", true);
         
        gramatica.group("MET", "reservada_inicio | reservada_principal | reservada_funcion");
        
        gramatica.loopForFunExecUntilChangeNotDetected(()->{
 gramatica.group("METODO","MET parentesis_a parentesis_a parentesis_c llaves_a CODIGO_DF llaves_c", true);
        });
              gramatica.loopForFunExecUntilChangeNotDetected(()->{ 
                  gramatica.initialLineColumn();
                  gramatica.group("METODO", "MET parentesis_a parentesis_a parentesis_c llaves_a CODIGO_DF", true, 30, "error sintáctico {}: falta la llave de cierre [#,%]");
                  gramatica.finalLineColumn();
                   gramatica.group("METODO", "MET parentesis_a parentesis_a parentesis_c CODIGO_DF llaves_c", true, 31, "error sintáctico {}: falta la llave de apertura [#,%]");
              
                   gramatica.group("CODIGO_DF","CODIGO_DF");
              
              });
        
        /*gramatica.group("METODO", "MET parentesis_a });parentesis_a parentesis_c llaves_a (CODIGO_DF)*? llaves_c", true);
        gramatica.group("METODO", "MET parentesis_a parentesis_a parentesis_c (CODIGO_DF)*? llaves_c", true, 31, "error sintáctico {}: falta la llave de apertura [#,%]");
        gramatica.group("METODO", "MET parentesis_a parentesis_a parentesis_c llaves_a (CODIGO_DF)*", true, 30, "error sintáctico {}: falta la llave de cierre [#,%]");
        //gramatica.group("METODO", "MET parentesis_a parentesis_c (CODIGO_DF)*?", true, 28, "error sintáctico {}: faltan llaves [#,%]");
        gramatica.group("METODO", "MET parentesis_c llaves_a (CODIGO_DF)*? llaves_c", true, 29, "error sintáctico {}: falta parentesis de apertura [#,%]");
        gramatica.group("METODO", "MET parentesis_allaves_a (CODIGO_DF)*? llaves_c", true, 30, "error sintáctico {}: falta parentesis de cierre [#,%]");
        gramatica.group("METODO", "MET (VALORES | PARAMETROS) llaves_a (CODIGO_DF)*? llaves_c", true, 31, "error sintáctico {}: faltan parentesis [#,%]");
           */
           
           // gramatica.group("CODIGO_DF", "(FUNCIONES | VARIABLE | ENTI | ENTIDADES_COMP)", true);
              

            
        //definir estructura condición-----------------------
        gramatica.group("CONDICION_D", "(VALORES | identificador) ((operador_logico | operador_relacional) (VALOR | identificador))+ ");
        gramatica.group("CONDICION_D", "(VALORES | identificador) ((operador_logico | operador_relacional) )+ ", true, 32, "error sintáctico {}: faltan un operador [#,%]");
        gramatica.group("CONDICION_D", " ((operador_logico | operador_relacional) (VALOR | identificador))+ ", true, 33, "error sintáctico {}: faltan un operador [#,%]");
        //gramatica.group("CONDICION", "parentesis_a CONDICION_D parentesis_c");

        //Definir si
        gramatica.group("E_SI", "(reservada_si | reservada_no | reservada_si_no | reservada_mientras)");
        gramatica.group("SI", "E_SI parentesis_a CONDICION_D parentesis_c llaves_a (CODIGO_DF)*? llaves_c");
        gramatica.group("SI", "E_SI parentesis_a CONDICION_D parentesis_c (CODIGO_DF)*? llaves_c", true, 34, "error sintáctico {}: faltan las llaves de apertura [#,%]");
        gramatica.group("SI", "E_SI parentesis_a CONDICION_D parentesis_c llaves_a (CODIGO_DF)*", true, 35, "error sintáctico {}: faltan las llaves de cierre [#,%]");
        //gramatica.group("SI","E_SI parentesis_a CONDICION_D parentesis_c (CODIGO_DF)*",true,15,"error sintáctico {}: faltan las llaves [#,%]");
        gramatica.group("SI", "E_SI CONDICION_D llaves_a (CODIGO_DF)*? llaves_c", true, 36, "error sintáctico {}: faltan parentesis [#,%]");
        gramatica.group("SI", "E_SI CONDICION_D parentesis_c llaves_a (CODIGO_DF)*? llaves_c", true, 37, "error sintáctico {}: faltan el parentesis de apertura [#,%]");
        gramatica.group("SI", "E_SI parentesis_a CONDICION_D llaves_a (CODIGO_DF)*? llaves_c", true, 38, "error sintáctico {}: faltan el parentesis de cierre [#,%]");

        //
        gramatica.group("INCDEC", "identificador operador_aritmetico operador_aritmetico ");
        //definir ciclo
        gramatica.group("CONDICION_CICLO", "identificador doblePunto VALOR puntoYcoma CONDICION_D puntoYcoma INCDEC");
        gramatica.group("CICLO_H", "reservada_ciclo parentesis_a CONDICION_CICLO parentesis_c llaves_a (CODIGO_DF)*? llaves_c");
        gramatica.group("CICLO_H", "reservada_ciclo CONDICION_CICLO parentesis_c llaves_a (CODIGO_DF)*? llaves_c", true, 39, "error sintáctico {}: faltan el parentesis de apertura [#,%]");
        gramatica.group("CICLO_H", "reservada_ciclo parentesis_a CONDICION_CICLO llaves_a (CODIGO_DF)*? llaves_c", true, 40, "error sintáctico {}: faltan el parentesis de cierre [#,%]");
        gramatica.group("CICLO_H", "reservada_ciclo parentesis_a CONDICION_CICLO parentesis_c (CODIGO_DF)*? llaves_c", true, 41, "error sintáctico {}: falta la llave de apertura [#,%]");
        gramatica.group("CICLO_H", "reservada_ciclo parentesis_a CONDICION_CICLO parentesis_c llaves_a (CODIGO_DF)*? ", true, 42, "error sintáctico {}: falta la llave de cierre [#,%]");
        gramatica.group("CICLO_H", "reservada_ciclo CONDICION_CICLO llaves_a (CODIGO_DF)*? ", true, 43, "error sintáctico {}: faltan parentesis [#,%]");
        gramatica.group("CICLO_H", "reservada_ciclo parentesis_a CONDICION_CICLO parentesis_c (CODIGO_DF)*?", true, 44, "error sintáctico {}: falta las llaves [#,%]");
           
        /* Mostrar gramáticas */
        gramatica.show();
    }

    private void semanticAnalysis() {
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
    }
    public String id(String n){
        if(n.equals("IDENTIFICADOR")){return "1";}
        if(n.equals("CADENA")){return "2";}
        if(n.equals("TIPO_DE_DATO_ENTERO")){return "3";}
        if(n.equals("NUMERO")){return "4";}
        if(n.equals("COLOR")){return "5";}
        if(n.equals("LLAVE_ABIERTA")){return "6";}
        if(n.equals("LLAVE_CERRADA")){return "7";}
        if(n.equals("OPERADOR_ASIGNACION")){return "8";}
        if(n.equals("OPERADOR_MAS")){return "9";}
        if(n.equals("OPERADOR_MENOS")){return "10";}
        if(n.equals("OPERADOR_MULTIPLICAR")){return "11";}
        if(n.equals("OPERADOR_DIVIDIR")){return "12";}
        if(n.equals("OPERADOR_AND")){return "13";}
        if(n.equals("OPERADOR_OR")){return "14";}
        if(n.equals("OPERADOR_DIFERENTEQUE")){return "15";}
        if(n.equals("OPERADOR_MAYORQUE")){return "16";}
        if(n.equals("OPERADOR_MENORQUE")){return "17";}
        if(n.equals("OPERADOR_INCREMENTO")){return "18";}
        if(n.equals("OPERADOR_DECREMENTO")){return "19";}
        if(n.equals("FIN_DE_SENTENCIA")){return "20";}
        if(n.equals("COMA")){return "1";}
        if(n.equals("ABRE_PARENTESIS")){return "21";}
        if(n.equals("CIERRA_PARENTESIS")){return "22";}
        if(n.equals("INICIO_CONDICIONAL")){return "23";}
        if(n.equals("SEGUIR_CONDICIONAL")){return "24";}
        if(n.equals("CICLO_WHILE")){return "25";}
        if(n.equals("CICLO_FOR")){return "26";}
        if(n.equals("CICLO_DOWHILE")){return "27";}
        if(n.equals("PALABRA_RESERVADA")){return "28";}
        if(n.equals("VERDADERO")){return "29";}
        if(n.equals("FALSO")){return "30";}
        if(n.equals("FUNCION")){return "31";}
        if(n.equals("ERROR_1")){return "32";}
        if(n.equals("ERROR_2")){return "33";}
        if(n.equals("ERROR_3")){return "34";}
        if(n.equals("TIPO_DE_DATO_CADENA")){return "35";}
        if(n.equals("TIPO_DE_DATO_BOOLEANO")){return "36";}
        if(n.equals("TIPO_DE_DATO_DECIMAL")){return "37";}
        if(n.equals("NUMERO_DECIMAL")){return "38";}
        return "";
    }
    private void fillTableTokens() {
             
        tokens.forEach(token -> {
           
            Object[] data = new Object[]{id(token.getLexicalComp()),token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }
private int numerrores(){
    
   String line = System.getProperty("line.separator");
   
String demo = jtaOutputConsole.getText();

       int replace = demo.length() - demo.replace("\n", "").length();
    
return replace-3;

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
             int a=replace-1;
            jtaOutputConsole.setText("Compilación lista\n" + strErrors + "\n La compilación terminó con " + a +" ERRORES...");
        } else {
            jtaOutputConsole.setText("Compilación sin errores\n");
        }
        jtaOutputConsole.setCaretPosition(0);
        
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
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
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
