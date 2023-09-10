/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.com.alurahotel.view;

import com.alurahotel.util.ColoresComponentesUtil;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Date;
import javax.swing.DefaultComboBoxModel;
import com.alurahotel.controller.HuespedController;
import com.alurahotel.controller.ReservaController;
import com.alurahotel.modelo.Huesped;
import com.alurahotel.util.ConvertirFecha;
import com.alurahotel.util.ListarNacionalidadesUtil;
import com.alurahotel.util.ValidarFormulariosUtil;


public class RegistrarHuesped extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    Reservas ventanaReservas = new Reservas();
    private final HuespedController huespedController;
    private final ReservaController reservaController;

  
    public RegistrarHuesped() {
        initComponents();
        configurarColoresComponentes();
        this.huespedController = new HuespedController();
        this.reservaController = new ReservaController();
        //Agregando el arreglo String[] de 190 nacionalidades al ComboBox.
        seleccionNacionalidad.setModel(new DefaultComboBoxModel<>(ListarNacionalidadesUtil.filtrarNacionalidades()));
        campoNumeroReserva.setEnabled(false);
        campoNumeroReserva.setText(ventanaReservas.getReserva().getId_Reserva());
    }

    private void configurarColoresComponentes() {
        setBackground(ColoresComponentesUtil.TRANSPARENTE);
        panelFormularioRegistroHuesped.setBackground(ColoresComponentesUtil.TRANSPARENTE);
        btnCerrar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
        btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
        btnGuardar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
        btnCancelar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
        btnMenuUsuario.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
    }

   
    private void guardarReserva() {
        if (ValidarFormulariosUtil.esFormularioHuespedValido(
                campoNombre.getText(), campoApellido.getText(), fechaNacimiento, campoTelefono.getText())) {
            this.reservaController.guardar(ventanaReservas.getReserva());
            guardarHuesped();
        }
    }

    private void guardarHuesped() {
        Date fechaNac = Date.valueOf(ConvertirFecha.convertirDateALocalDate(fechaNacimiento.getDate()));
        Huesped huesped = new Huesped(
                campoNombre.getText(),
                campoApellido.getText(),
                fechaNac,
                seleccionNacionalidad.getSelectedItem().toString(),
                campoTelefono.getText()
        );
        this.huespedController.guardar(huesped, ventanaReservas.getReserva().getId_Reserva());
        mostrarMensajeGuardado();
    }

    private void mostrarMensajeGuardado() {
        Exito e = new Exito();
        e.setVisible(true);
        this.dispose();
    }

    public void limpiarCampos() {
        campoNombre.setText("");
        campoApellido.setText("");
        fechaNacimiento.setCalendar(null);
        seleccionNacionalidad.setSelectedIndex(0);
        campoTelefono.setText("");
    }

  
    @Override
    public Image getIconImage() {
        Image retImage = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("mx/com/alurahotel/imagenes/persona.png"));
        return retImage;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new JPanelTransparente();
        bannerRegistroHuesped = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        panelFormularioRegistroHuesped = new javax.swing.JPanel();
        jLabelIconoHotelAlura = new javax.swing.JLabel();
        jLabelTituloFormulario = new javax.swing.JLabel();
        jLabelTextoApellido = new javax.swing.JLabel();
        campoApellido = new javax.swing.JTextField();
        jLabelTextoNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabelTextoFechaNacimiento = new javax.swing.JLabel();
        fechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabelTextoNacionalidad = new javax.swing.JLabel();
        seleccionNacionalidad = new javax.swing.JComboBox<>();
        jLabelTextoTelefono = new javax.swing.JLabel();
        campoTelefono = new javax.swing.JTextField();
        jLabelTextoNumeroReserva = new javax.swing.JLabel();
        campoNumeroReserva = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        btnMenuUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);

        panelPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelPrincipalMouseDragged(evt);
            }
        });
        panelPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelPrincipalMousePressed(evt);
            }
        });
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bannerRegistroHuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/registro.png"))); // NOI18N
        panelPrincipal.add(bannerRegistroHuesped, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 502, -1));

        btnCerrar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(204, 204, 204));
        btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrar.setText("x");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.setOpaque(true);
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarMouseExited(evt);
            }
        });
        panelPrincipal.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 60, 30));

        btnMinimizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnMinimizar.setForeground(new java.awt.Color(204, 204, 204));
        btnMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimizar.setText("-");
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimizar.setOpaque(true);
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseExited(evt);
            }
        });
        panelPrincipal.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 60, 30));

        jLabelIconoHotelAlura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconoHotelAlura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/Ha-100px.png"))); // NOI18N

        jLabelTituloFormulario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTituloFormulario.setForeground(new java.awt.Color(12, 138, 199));
        jLabelTituloFormulario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloFormulario.setText("Registro de Huésped");

        jLabelTextoApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelTextoApellido.setForeground(new java.awt.Color(204, 204, 204));
        jLabelTextoApellido.setText("Apellido:");

        campoApellido.setBackground(new java.awt.Color(60, 63, 65));
        campoApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoApellido.setForeground(new java.awt.Color(204, 204, 204));
        campoApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoApellido.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199), new java.awt.Color(12, 138, 199)));

        jLabelTextoNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelTextoNombre.setForeground(new java.awt.Color(204, 204, 204));
        jLabelTextoNombre.setText("Nombre:");

        campoNombre.setBackground(new java.awt.Color(60, 63, 65));
        campoNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(204, 204, 204));
        campoNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199), new java.awt.Color(12, 138, 199)));

        jLabelTextoFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelTextoFechaNacimiento.setForeground(new java.awt.Color(204, 204, 204));
        jLabelTextoFechaNacimiento.setText("Fecha de Nacimiento:");

        fechaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabelTextoNacionalidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelTextoNacionalidad.setForeground(new java.awt.Color(204, 204, 204));
        jLabelTextoNacionalidad.setText("Nacionalidad:");

        seleccionNacionalidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seleccionNacionalidad.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199), new java.awt.Color(12, 138, 199)));

        jLabelTextoTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelTextoTelefono.setForeground(new java.awt.Color(204, 204, 204));
        jLabelTextoTelefono.setText("Teléfono:");

        campoTelefono.setBackground(new java.awt.Color(60, 63, 65));
        campoTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoTelefono.setForeground(new java.awt.Color(204, 204, 204));
        campoTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoTelefono.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199), new java.awt.Color(12, 138, 199)));

        jLabelTextoNumeroReserva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelTextoNumeroReserva.setForeground(new java.awt.Color(204, 204, 204));
        jLabelTextoNumeroReserva.setText("Número de Reserva:");

        campoNumeroReserva.setBackground(new java.awt.Color(60, 63, 65));
        campoNumeroReserva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoNumeroReserva.setForeground(new java.awt.Color(0, 0, 0));
        campoNumeroReserva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoNumeroReserva.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(12, 138, 199), new java.awt.Color(12, 138, 199)));
        campoNumeroReserva.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/disquete.png"))); // NOI18N
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardar.setOpaque(true);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });

        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.setOpaque(true);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });

        btnMenuUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMenuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/com/alurahotel/imagenes/cerrar-sesion 32-px.png"))); // NOI18N
        btnMenuUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMenuUsuario.setOpaque(true);
        btnMenuUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMenuUsuarioMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelFormularioRegistroHuespedLayout = new javax.swing.GroupLayout(panelFormularioRegistroHuesped);
        panelFormularioRegistroHuesped.setLayout(panelFormularioRegistroHuespedLayout);
        panelFormularioRegistroHuespedLayout.setHorizontalGroup(
            panelFormularioRegistroHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioRegistroHuespedLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelFormularioRegistroHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTextoNumeroReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTextoTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seleccionNacionalidad, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTextoNacionalidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTextoFechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoNombre)
                    .addComponent(jLabelTextoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTituloFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTextoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoNumeroReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormularioRegistroHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelIconoHotelAlura)
                    .addGroup(panelFormularioRegistroHuespedLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelFormularioRegistroHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMenuUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(446, 446, 446))
        );
        panelFormularioRegistroHuespedLayout.setVerticalGroup(
            panelFormularioRegistroHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioRegistroHuespedLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(panelFormularioRegistroHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormularioRegistroHuespedLayout.createSequentialGroup()
                        .addComponent(jLabelTituloFormulario)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTextoNombre))
                    .addComponent(jLabelIconoHotelAlura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panelFormularioRegistroHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFormularioRegistroHuespedLayout.createSequentialGroup()
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTextoApellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTextoFechaNacimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTextoNacionalidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seleccionNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTextoTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTextoNumeroReserva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoNumeroReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFormularioRegistroHuespedLayout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMenuUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        panelPrincipal.add(panelFormularioRegistroHuesped, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 410, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        Mensaje.confirmarSalida(evt);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        evt.consume();
        btnCerrar.setBackground(ColoresComponentesUtil.ROJO_OSCURO);
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        evt.consume();
        btnCerrar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
    }//GEN-LAST:event_btnCerrarMouseExited

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        evt.consume();
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseEntered
        evt.consume();
        btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
    }//GEN-LAST:event_btnMinimizarMouseEntered

    private void btnMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseExited
        evt.consume();
        btnMinimizar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
    }//GEN-LAST:event_btnMinimizarMouseExited

    private void panelPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPrincipalMousePressed
        evt.consume();
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelPrincipalMousePressed

    private void panelPrincipalMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPrincipalMouseDragged
        evt.consume();
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panelPrincipalMouseDragged

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        Mensaje.cancelarRegistro(evt, this);
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        evt.consume();
        btnCancelar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        evt.consume();
        btnCancelar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        evt.consume();
        guardarReserva();
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        evt.consume();
        btnGuardar.setBackground(ColoresComponentesUtil.GRIS_CLARO);
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        evt.consume();
        btnGuardar.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnMenuUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuUsuarioMouseClicked
        evt.consume();
        this.dispose();
        MenuUsuario menuUsuario = new MenuUsuario();
        menuUsuario.setVisible(true);
    }//GEN-LAST:event_btnMenuUsuarioMouseClicked

    private void btnMenuUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuUsuarioMouseEntered
        evt.consume();
        btnMenuUsuario.setBackground(ColoresComponentesUtil.GRIS_CLARO);
    }//GEN-LAST:event_btnMenuUsuarioMouseEntered

    private void btnMenuUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuUsuarioMouseExited
        evt.consume();
        btnMenuUsuario.setBackground(ColoresComponentesUtil.GRIS_OSCURO);
    }//GEN-LAST:event_btnMenuUsuarioMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
   
        java.awt.EventQueue.invokeLater(() -> {
            new RegistrarHuesped().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bannerRegistroHuesped;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnMenuUsuario;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoNumeroReserva;
    private javax.swing.JTextField campoTelefono;
    private com.toedter.calendar.JDateChooser fechaNacimiento;
    private javax.swing.JLabel jLabelIconoHotelAlura;
    private javax.swing.JLabel jLabelTextoApellido;
    private javax.swing.JLabel jLabelTextoFechaNacimiento;
    private javax.swing.JLabel jLabelTextoNacionalidad;
    private javax.swing.JLabel jLabelTextoNombre;
    private javax.swing.JLabel jLabelTextoNumeroReserva;
    private javax.swing.JLabel jLabelTextoTelefono;
    private javax.swing.JLabel jLabelTituloFormulario;
    private javax.swing.JPanel panelFormularioRegistroHuesped;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JComboBox<String> seleccionNacionalidad;
    // End of variables declaration//GEN-END:variables
}
