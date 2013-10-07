package de.andreasgiemza.imdbrating;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author hurik
 */
public class Gui extends javax.swing.JFrame {

    private final LinkedList<Movie> movies = new LinkedList<>();
    private final Path optionsFile;

    /**
     * Creates new form Gui
     */
    public Gui() {
        initComponents();

        movieTable.setModel(new MovieTableModel(movies));

        optionsFile = Paths.get(System.getProperty("user.home")).resolve(".IMDBRating");

        try {
            if (Files.exists(optionsFile)) {
                movieFolderTextField.setText(Files.readAllLines(optionsFile, Charset.defaultCharset()).get(0));
            }
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        movieFolderFileChooser = new javax.swing.JFileChooser();
        selectMovieFolderButton = new javax.swing.JButton();
        movieFolderTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        movieTable = new javax.swing.JTable();
        getIMDBRatingButton = new javax.swing.JButton();
        saveRatingsButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        progressLabel = new javax.swing.JLabel();
        scanForMoviesButton = new javax.swing.JButton();

        movieFolderFileChooser.setDialogTitle("Choose movie folder ...");
        movieFolderFileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IMDB Rating for XBMC");

        selectMovieFolderButton.setText("Select movie folder");
        selectMovieFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectMovieFolderButtonActionPerformed(evt);
            }
        });

        movieTable.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(movieTable);

        getIMDBRatingButton.setText("Get IMDB rating");
        getIMDBRatingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getIMDBRatingButtonActionPerformed(evt);
            }
        });

        saveRatingsButton.setText("Save ratings");
        saveRatingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRatingsButtonActionPerformed(evt);
            }
        });

        progressLabel.setText("Progress");

        scanForMoviesButton.setText("Scan for movies");
        scanForMoviesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanForMoviesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(movieFolderTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectMovieFolderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scanForMoviesButton))
                    .addComponent(saveRatingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getIMDBRatingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progressLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getIMDBRatingButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveRatingsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(progressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectMovieFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectMovieFolderButtonActionPerformed
        int returnVal = movieFolderFileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            movies.clear();
            movieFolderTextField.setText(movieFolderFileChooser.getSelectedFile().toString());
        }
    }//GEN-LAST:event_selectMovieFolderButtonActionPerformed

    private void getIMDBRatingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getIMDBRatingButtonActionPerformed
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (Movie movie : movies) {
                    if (!"null".equals(movie.getImdbID())) {
                        movie.getIMDBRating();
                    }

                    progressBar.setValue(movies.indexOf(movie) + 1);
                    movieTable.updateUI();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }//GEN-LAST:event_getIMDBRatingButtonActionPerformed

    private void saveRatingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRatingsButtonActionPerformed
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (Movie movie : movies) {
                    movie.updateIMDBRating();

                    progressBar.setValue(movies.indexOf(movie) + 1);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }//GEN-LAST:event_saveRatingsButtonActionPerformed

    private void scanForMoviesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanForMoviesButtonActionPerformed
        Path movieFolder = Paths.get(movieFolderTextField.getText());

        try {
            Files.deleteIfExists(optionsFile);
            Files.write(optionsFile, movieFolder.toString().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (Files.exists(movieFolder)) {
            MovieFinder movieFinder = new MovieFinder(movies);

            try {
                Files.walkFileTree(movieFolder, movieFinder);
            } catch (IOException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }

            progressBar.setMaximum(movies.size());
            movieTable.updateUI();
        }
    }//GEN-LAST:event_scanForMoviesButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
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
    private javax.swing.JButton getIMDBRatingButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFileChooser movieFolderFileChooser;
    private javax.swing.JTextField movieFolderTextField;
    private javax.swing.JTable movieTable;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel progressLabel;
    private javax.swing.JButton saveRatingsButton;
    private javax.swing.JButton scanForMoviesButton;
    private javax.swing.JButton selectMovieFolderButton;
    // End of variables declaration//GEN-END:variables
}
