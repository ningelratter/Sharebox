**
*
*/
package de.sharebox.gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;

import de.sharebox.controller.Controller;
import de.sharebox.entities.User;
import de.sharebox.models.UserModel;

/**
* @author MW
*
*/
// class in which the user can change the properties
public class UserPropertiesPanel extends MenuPanel {

// every GUI class has to have a UID to verify
private static final long serialVersionUID = 2342342341L;
private final JTextField userField;
private final JTextField passwordField;
private final JList languageList;
private final JTextField limitField;
private final JTextField emailField;
private JFrame frame;
private Popup popup, popup1;
private final User user;

public UserPropertiesPanel(final Controller controller, final UserModel userModel) {

super(controller, userModel);
user = userModel.getUser();

Font font = new Font("Tahoma", Font.PLAIN, 18);
Font font2 = new Font("Tahoma", Font.PLAIN, 16);
Font font3 = new Font("Tahoma", Font.PLAIN, 14);
JLabel welcomeUserText = new JLabel("Hier koennen Sie die Einstellungen fuer: " + user.getName() + " aendern!");
welcomeUserText.setFont(font);
welcomeUserText.setBounds(25, 33, 615, 54);
add(welcomeUserText);

JLabel lblUsername = new JLabel("Benutzername:");
lblUsername.setFont(font2);
lblUsername.setBounds(25, 116, 115, 34);
add(lblUsername);

JLabel lblPasswort = new JLabel("Passwort:");
lblPasswort.setFont(font2);
lblPasswort.setBounds(25, 169, 115, 34);
add(lblPasswort);

JLabel lblEmail = new JLabel("Email:");
lblEmail.setFont(font2);
lblEmail.setBounds(25, 230, 115, 34);
add(lblEmail);

JLabel lblSprache = new JLabel("Sprache:");
lblSprache.setFont(font2);
lblSprache.setBounds(25, 364, 115, 34);
add(lblSprache);

JLabel lblLimit = new JLabel("Limit:");
lblLimit.setFont(font2);
lblLimit.setBounds(25, 298, 115, 34);
add(lblLimit);

userField = new JTextField();
userField.setToolTipText("Hier neuen Benutzernamen eingeben");
userField.setBounds(168, 118, 203, 34);
add(userField);
userField.setColumns(10);

passwordField = new JPasswordField();
passwordField.setToolTipText("Hier neues Passwort eigeben");
passwordField.setColumns(10);
passwordField.setBounds(168, 171, 203, 34);
add(passwordField);

emailField = new JTextField();
emailField.setToolTipText("Hier neues Emailadresse eigeben");
emailField.setColumns(10);
emailField.setBounds(168, 232, 203, 34);
add(emailField);

final JLabel currentUserName = new JLabel("");
currentUserName.setToolTipText("aktueller Benutzername");
currentUserName.setBounds(25, 144, 115, 34);
add(currentUserName);
currentUserName.setText(user.getName());

languageList = new JList();
languageList
.setToolTipText("waehlen Sie die gewuenschte Sprache in der ihre ShareBoxUltimate angezeigt werden soll");
languageList.setFont(font3);
languageList.setName("");
languageList.setModel(new AbstractListModel() {
/**
*
*/
private static final long serialVersionUID = -3117312090257427767L;
String[] values = new String[] { "Deutsch = 0", "Englisch = 1", "Franz\u00F6sisch = 2", "Spanisch = 3" };

public int getSize() {
return values.length;
}

public Object getElementAt(int index) {
return values[index];
}
});
languageList.setBounds(168, 364, 203, 76);
add(languageList);

limitField = new JTextField();
limitField.setColumns(10);
limitField.setBounds(168, 300, 203, 34);
add(limitField);

JButton einstellungenndern = new JButton("Einstellungen aendern");
einstellungenndern.addMouseListener(new MouseAdapter() {
@Override
public void mouseReleased(MouseEvent arg0) {

changeUserName(user);
changeUserPassword(user);
changeUserEmail(user);
controller.saveData();
// TODO geht vllt auch mit repaint() aber wusste nicht wie! ;)
// is refreshing the view
changePanel(new UserPropertiesPanel(controller, userModel));
}
});
einstellungenndern.setToolTipText("Hier klicken, wenn die getaetigten Einstellungen uebernommen werden sollen");
einstellungenndern.setFont(font);
einstellungenndern.setBounds(168, 462, 238, 54);
add(einstellungenndern);

JLabel currentPassword = new JLabel((String) null);
currentPassword.setToolTipText("aktuelles Passwort");
currentPassword.setBounds(25, 199, 115, 34);
add(currentPassword);
currentPassword.setText(user.getPassword());

JLabel currentMail = new JLabel((String) null);
currentMail.setToolTipText("aktuelle Emailadresse");
currentMail.setBounds(25, 263, 115, 34);
add(currentMail);
currentMail.setText(user.getMail());

JLabel currentLimit = new JLabel((String) null);
currentLimit.setToolTipText("aktuelles Limit");
currentLimit.setBounds(25, 330, 115, 34);
add(currentLimit);
double limit = user.getLimit();
String sLimit = String.valueOf(limit);
currentLimit.setText(sLimit);

JLabel currentLanguage = new JLabel((String) null);
currentLanguage.setToolTipText("aktuell eingestellte Sprache");
currentLanguage.setBounds(25, 406, 115, 34);
add(currentLanguage);
int iLanguage = user.getLanguage();
String sLanguage = String.valueOf(iLanguage);
currentLanguage.setText(sLanguage);

JButton removeAccount = new JButton("Account loeschen");
removeAccount.addMouseListener(new MouseAdapter() {
@Override
public void mouseReleased(MouseEvent eevent) {

areYouSure();

}
});
removeAccount.setToolTipText("Hier klicken, wenn Sie ihren Account l\u00F6schen m\u00F6chten");
removeAccount.setFont(font);
removeAccount.setBounds(168, 537, 238, 54);
add(removeAccount);

}

// is setting the new userName
public void changeUserName(User user) {

String name = userField.getText();
if (name.length() >= 5 && name.length() <= 12) {
controller.setUserName(name);
}
}

// is setting the new password
public void changeUserPassword(User user) {

String password = passwordField.getText();
if (password.length() >= 5 && password.length() <= 12) {
controller.setUserPassword(user, password);
}
}

// is setting the new mailadress
public void changeUserEmail(User user) {

String email = emailField.getText();
// checking the mail properties
boolean validEmail = email.contains("@") && email.contains(".de") || email.contains("@") && email.contains(".com")
|| email.contains("@") && email.contains(".fr") || email.contains("@") && email.contains(".net");

if (validEmail) {

controller.setUserEmail(user, email);

}
}

public void areYouSure() {

frame = new JFrame("Sind Sie sicher?!");
frame.setSize(400, 300);
frame.setLocation(150, 200);

PopupFactory factory = PopupFactory.getSharedInstance();

JButton remove = new JButton();
add(remove);
JButton stay = new JButton();
add(stay);

popup = factory.getPopup(frame, remove = new JButton("Ja, Accounnt loeschen"), 250, 300);
frame.setVisible(true);
popup1 = factory.getPopup(frame, stay = new JButton("Nein, Account nicht loeschen"), 250, 400);
popup.show();
popup1.show();
remove.addMouseListener(new MouseAdapter() {

public void mouseClicked(MouseEvent arg0) {

controller.removeUser(user);
LoginPanel loginPanel = new LoginPanel(controller);
changePanel(loginPanel);
frame.setVisible(false);
}

});
stay.addMouseListener(new MouseAdapter() {

public void mouseClicked(MouseEvent arg0) {

frame.setVisible(false);
}

});

}

}


