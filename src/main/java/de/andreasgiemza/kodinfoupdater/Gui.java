package de.andreasgiemza.kodinfoupdater;

import de.andreasgiemza.kodinfoupdater.movietable.MovieTableModel;
import de.andreasgiemza.kodinfoupdater.movietable.MovieTableCellRenderer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author hurik
 */
public class Gui extends javax.swing.JFrame {
    
    private final Gui gui = this;
    private final LinkedList<Movie> movies = new LinkedList<>();
    private final MovieTableModel movieTableModel = new MovieTableModel(movies);
    private final Properties properties = new Properties();
    private final Path optionsFile = Paths.get(System.getProperty("user.home")).resolve(".KODInfoUPDATER");
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    /**
     * Creates new form Gui
     */
    public Gui() {
        initComponents();
        
        try {
            properties.load(new FileInputStream(optionsFile.toFile()));
        } catch (IOException ex) {
        }
        
        movieFolderTextField.setText(properties.getProperty("lastDir"));
        
        moviesTable.setModel(movieTableModel);
        
        moviesTable.setDefaultRenderer(String.class, new MovieTableCellRenderer());
        moviesTable.setDefaultRenderer(Double.class, new MovieTableCellRenderer());
        moviesTable.setDefaultRenderer(Long.class, new MovieTableCellRenderer());
        moviesTable.setDefaultRenderer(Integer.class, new MovieTableCellRenderer());
        moviesTable.setDefaultRenderer(List.class, new MovieTableCellRenderer());
        
        progressBar.setStringPainted(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        moviesFolderFileChooser = new javax.swing.JFileChooser();
        movieFolderTextField = new javax.swing.JTextField();
        selectMovieFolderButton = new javax.swing.JButton();
        scanForMoviesButton = new javax.swing.JButton();
        moviesScrollPane = new javax.swing.JScrollPane();
        moviesTable = new javax.swing.JTable();
        saveRatingsButton = new javax.swing.JButton();
        ignoreOldRatingsCheckBox = new javax.swing.JCheckBox();
        progressLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        moviesFolderFileChooser.setDialogTitle("Choose movie folder ...");
        moviesFolderFileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KODInfoUPDATER");

        selectMovieFolderButton.setText("Select movie folder");
        selectMovieFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectMovieFolderButtonActionPerformed(evt);
            }
        });

        scanForMoviesButton.setText("Scan for movies");
        scanForMoviesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanForMoviesButtonActionPerformed(evt);
            }
        });

        moviesTable.setAutoCreateRowSorter(true);
        moviesScrollPane.setViewportView(moviesTable);

        saveRatingsButton.setText("Save ratings");
        saveRatingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRatingsButtonActionPerformed(evt);
            }
        });

        ignoreOldRatingsCheckBox.setSelected(true);
        ignoreOldRatingsCheckBox.setText("Ignore older ratings");

        progressLabel.setText("Progress");

        progressBar.setString("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moviesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(movieFolderTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectMovieFolderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scanForMoviesButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progressLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveRatingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ignoreOldRatingsCheckBox)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectMovieFolderButton)
                    .addComponent(movieFolderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scanForMoviesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moviesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveRatingsButton)
                    .addComponent(ignoreOldRatingsCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(progressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectMovieFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectMovieFolderButtonActionPerformed
        int returnVal = moviesFolderFileChooser.showOpenDialog(this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            movieFolderTextField.setText(moviesFolderFileChooser.getSelectedFile().toString());
        }
    }//GEN-LAST:event_selectMovieFolderButtonActionPerformed

    private void saveRatingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRatingsButtonActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                progressBar.setString("");
                
                for (Movie movie : movies) {
                    if (movie.getChanges()) {
                        NFO.updateNfo(movie, ignoreOldRatingsCheckBox.isSelected());
                    }
                    
                    progressBar.setValue(movies.indexOf(movie) + 1);
                }
                
                scanForMoviesButtonActionPerformed(null);
            }
        }).start();
    }//GEN-LAST:event_saveRatingsButtonActionPerformed

    private void scanForMoviesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanForMoviesButtonActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                Path movieFolder = Paths.get(movieFolderTextField.getText());
                
                if (Files.exists(movieFolder)) {
                    properties.setProperty("lastDir", movieFolder.toString());
                    try {
                        properties.store(new FileOutputStream(optionsFile.toFile()), null);
                    } catch (IOException ex) {
                        Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    movies.clear();
                    
                    List<Path> noNfoPaths = new LinkedList<>();
                    
                    try {
                        Files.walkFileTree(movieFolder, new MovieFinder(movies, gui, noNfoPaths, executor));
                    } catch (IOException ex) {
                        Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if (!noNfoPaths.isEmpty()) {
                        String folders = "";
                        
                        for (Path noNfoPath : noNfoPaths) {
                            folders += noNfoPath + "\n";
                        }
                        
                        JOptionPane.showMessageDialog(gui,
                                "NFO file is missing in this folders:\n" + folders,
                                "Error",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    
                    progressBar.setMaximum(movies.size());
                }
                
                if (movies.isEmpty()) {
                    progressBar.setString("No movies found!");
                }
            }
        }).start();
    }//GEN-LAST:event_scanForMoviesButtonActionPerformed
    
    public void updateMovieTable() {
        movieTableModel.fireTableDataChanged();
    }
    
    public void updateMovieFinder(int movieCount) {
        progressBar.setString(movieCount + " movies found!");
        movieTableModel.fireTableDataChanged();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Windows is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ignoreOldRatingsCheckBox;
    private javax.swing.JTextField movieFolderTextField;
    private javax.swing.JFileChooser moviesFolderFileChooser;
    private javax.swing.JScrollPane moviesScrollPane;
    private javax.swing.JTable moviesTable;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel progressLabel;
    private javax.swing.JButton saveRatingsButton;
    private javax.swing.JButton scanForMoviesButton;
    private javax.swing.JButton selectMovieFolderButton;
    // End of variables declaration//GEN-END:variables
}
