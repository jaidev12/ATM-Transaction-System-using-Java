package javaminipro;
import javax.swing. * ;
import java.awt. * ;
import java.awt.event. * ;
import java.util.Date;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
public class ATMDesign extends JFrame implements ActionListener {
  public java.util.Date date;
  JFrame ATMframe = new JFrame("ATM Menu");
  int PIN = 1234;
  int ctr = 0;
  int NewPIN;
  double money = 0.0;
  JLabel lPIN,
  lWithdraw,
  lDeposit,
  lChangePIN;
  JPasswordField pPIN,
  pCurrentPIN,
  pNewPIN,
  pConfirmPIN;
  JButton bOK,
  bClose,
  bClear,
  bWithdraw,
  bWithdrawOK,
  bWithdrawCancel,
  bDeposit,
  bInquiry,
  bChangePIN;
  JTextField tdWithdraw,
  tDeposit;
  public int getPIN() {
    return PIN;
  }
  public void setPIN(int pn) {
    this.PIN = pn;
  }
  public void changePIN(int PIN) {
    setPIN(PIN);

  }
  public ATMDesign() {
    UIManager UI = new UIManager();
    UI.put("OptionPane.background", Color.black);
    UI.put("Panel.background", Color.black);
    UI.put("Button.background", Color.white);
    UI.put("PasswordField.background", new ColorUIResource(204, 255, 255));
    UI.put("TextField.background", new ColorUIResource(255, 204, 204));
    FlowLayout fl = new FlowLayout();
    setLayout(fl);
    lPIN = new JLabel("<html><font size = 5>PLEASE ENTER YOUR PIN : ");
    pPIN = new JPasswordField(10);
    bOK = new JButton("OK");
    bClear = new JButton("Clear");
    bClose = new JButton("Close");

    setTitle("ATM");
    setSize(304, 104);
    setLocation(390, 170);
    setVisible(true);
    setResizable(false);
    add(lPIN);
    add(pPIN);
    add(bOK);
    add(bClear);
    add(bClose);
    bOK.addActionListener(this);

    bClear.addActionListener(this);
    bClose.addActionListener(this);
  }
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == bOK) {
      int PIN = Integer.parseInt(pPIN.getText());
      if (PIN == getPIN()) {
        Object[] options = {
          "WITHDRAW",
          "DEPOSIT",
          "CHECK CURRENT BALANCE",
          "CHANGE PIN"
        };
        int atm = JOptionPane.showOptionDialog(null, "<html><font size = 20><font color = white>Select Transaction: ", "WELCOME TO THE ATM SYSTEM", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        switch (atm) {
        case 0:
          JTextField tfWithdraw = new JTextField();
          double mod = 0.0;
          double WithdrawOptions = JOptionPane.showOptionDialog(null, new Object[] {
            "<html><font size = 5><font color = white>HOW MUCH DO YOU WANT TO WITHDRAW? :",
            tfWithdraw,
            null
          },
          "Withdraw", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

          mod = (Double.parseDouble(tfWithdraw.getText())) % 100;
          if (WithdrawOptions == JOptionPane.OK_OPTION) {
            if (Double.parseDouble(tfWithdraw.getText()) > money) {
              JOptionPane.showMessageDialog(null, "<html><font size = 5><font color = white>Insufficient Balance. ", "Withdraw", JOptionPane.WARNING_MESSAGE);
            } else if (Double.parseDouble(tfWithdraw.getText()) == money) {
              JOptionPane.showMessageDialog(null, "<html><font size = 4><font color = white>Maintaining balance is 100 RS!", null, JOptionPane.INFORMATION_MESSAGE);
            } else if (mod == 0) {
              money = money - Double.parseDouble(tfWithdraw.getText());
            } else {
              JOptionPane.showMessageDialog(null, "<html><font size = 4><font color = white>Amount should be divisible by 100.\n", null, JOptionPane.INFORMATION_MESSAGE);
            }
          } else {
            int WResponse = JOptionPane.showConfirmDialog(null, "<html><font size = 4><font color = white>Are you sure do you want to cancel the transaction?", null, JOptionPane.YES_NO_OPTION);
          }
          break;
        case 1:
          JTextField tfldDeposit = new JTextField();
          double DepositOptions = JOptionPane.showOptionDialog(null, new Object[] {

            "<html><font size = 3><font color = blue>How much do you want to Deposit? : ",
            tfldDeposit,
            null
          },
          "Deposit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
          if (DepositOptions == JOptionPane.OK_OPTION) {
            if (Double.parseDouble(tfldDeposit.getText()) < 100) {
              JOptionPane.showMessageDialog(null, "<html><font size = 4><font color = blue>Minimum deposit is 100 RS. ", "Deposit", JOptionPane.WARNING_MESSAGE);
            } else {
              money = money + Double.parseDouble(tfldDeposit.getText());
              JOptionPane.showMessageDialog(null, "<html><font size = 5><font color = blue>THANK YOU!");
            }
          } else {
            int WResponse = JOptionPane.showConfirmDialog(null, "<html><font size = 3><font color = blue>ARE YOU SURE DO YOU WANT TO CANCEL?", null, JOptionPane.YES_NO_OPTION);
            if (WResponse == JOptionPane.YES_OPTION) {
              System.exit(0);
            } else {
              pPIN.setText("");
            }
          }
          break;

        case 2:
          Date date = new Date();
          JOptionPane.showMessageDialog(null, "<html><font size = 4><font color = white>As of " + date.toString() + "<html><font size = 4><font color = white>, \n" + "<html><font size = 4><font color = white> your balance is: " + "<html><font size = 4><font color = blue>P " + money, "BALANCE ENQUIRY", JOptionPane.INFORMATION_MESSAGE);
          break;
        case 3:
          JPasswordField pfldCurrentPIN = new JPasswordField();
          int CurrentPIN = JOptionPane.showOptionDialog(null, new Object[] {
            "<html><font size = 3><font color = blue>ENTER YOUR CURRENT PIN CODE: ",
            pfldCurrentPIN,
            null
          },
          "Current PIN", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
          if (CurrentPIN == JOptionPane.OK_OPTION) {
            if (Integer.parseInt(pfldCurrentPIN.getText()) == PIN) {
              JPasswordField pfldNewPIN = new
              JPasswordField();
              int NewPIN = JOptionPane.showOptionDialog(null, new Object[] {
                "<html><font size = 3><font color = blue>ENTER YOUR NEW PIN CODE: ",

                pfldNewPIN,

                null
              },
              "New PIN", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
              if (NewPIN == JOptionPane.OK_OPTION) {
                JPasswordField pfldConfirmPIN = new
                JPasswordField();
                int ConfirmPIN = JOptionPane.showOptionDialog(null, new Object[] {
                  "<html><font size = 3><font color = blue>CONFIRM PIN CODE: ",
                  pfldConfirmPIN,

                  null
                },
                "Confirm PIN", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,

                null, null, null);

                if (ConfirmPIN == JOptionPane.OK_OPTION) {
                  if (Integer.parseInt(pfldConfirmPIN.getText()) == Integer.parseInt(pfldNewPIN.getText())) {
                    changePIN(Integer.parseInt(pfldNewPIN.getText()));
                  } else {
                    JOptionPane.showMessageDialog(null, "<html><font size = 4><font color = red>PIN Code does not match.", null, JOptionPane.ERROR_MESSAGE);
                  }

                }
              }
            } else {
              JOptionPane.showMessageDialog(null, "<html><font size = 4><font color = red>Invalid PIN!", "Change PIN", JOptionPane.ERROR_MESSAGE);
            }
          }

          break;
        }
        int end = JOptionPane.showConfirmDialog(null, "<html><font size = 4><font color = white>DO YOU WANT TO CONTINUE?", null, JOptionPane.YES_NO_OPTION);
        if (end == JOptionPane.YES_OPTION) {
          pPIN.getActions();
        } else {
          System.exit(0);
        }
      } else {
        JOptionPane.showMessageDialog(null, "<html><font size = 4><font color = red>Invalid PIN!", "ATM", JOptionPane.WARNING_MESSAGE);
        ctr += 1;
        pPIN.setText("");
        if ((ctr > 1) && (ctr == 2)) {
          JOptionPane.showMessageDialog(null, "<html><font size = 3><font color = red>You only have one last try to input your PIN.", "ATM", JOptionPane.WARNING_MESSAGE);
        }
        if (ctr > 2) {

          JOptionPane.showMessageDialog(null, "<html><font size = 4><font color = red>Captured Card!", "ATM", JOptionPane.ERROR_MESSAGE);
          System.exit(0);
        }
      }
    } else if (ae.getSource() == bClear) {
      pPIN.setText("");
    } else if (ae.getSource() == bClose) {
      int exit = JOptionPane.showConfirmDialog(null, "<html><font size = 4><font color = blue>ARE YOU SURE YOU WANT TO EXIT?", "Exit", JOptionPane.YES_NO_OPTION);
      if (exit == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(null, "<html><font size = 4><font color = yellow>Thank You for using the ATM!", "Exit", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
      } else {
        pPIN.setText("");
      }
    }
  }
  public static void main(String args[]) {
    ATMDesign ATM = new ATMDesign();
  }
}