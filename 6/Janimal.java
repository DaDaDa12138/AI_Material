//�����ҵ���Java����,д�ĺ�ǿ 
 
//package ai;
 
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.event.*;
 
 
public class Janimal extends JFrame implements ActionListener {
 
       private String[] str={"�ö�����ë��","�ö�������","�ö�������ë","�ö�����","�ö�������","�ö�����Ȯ��","��צ","�۶�ǰ��","�ö����ǲ��鶯��","����","�ǽ���ۻ����","�ö�����ʳ�⶯��","�ǻƺ�ɫ","�����а��ߵ�","�����к�ɫ����","�ö����������ද��","�г�����","�г���","�����","�кڰ׶�ɫ","����Ӿ","�ö�������","�Ʒ�"};
       private JList list=new JList(str);
       private JTextArea text=new JTextArea(10,10);
       private JTextArea result=new JTextArea(20,20);
       private JButton  button=new JButton("��ʼʶ��");
       private  String[] cause=new String[20];
       private  String resultString="";
 
       int width = Toolkit.getDefaultToolkit().getScreenSize().width;
       int height = Toolkit.getDefaultToolkit().getScreenSize().height;
 
       private ListSelectionListener lister=new ListSelectionListener()
       {
              public void valueChanged(ListSelectionEvent e) {
                     if(e.getValueIsAdjusting()) return;
                     text.setText("");
                     Object[] items=list.getSelectedValues();
                     for(int i=0;i<items.length;i++)
                     {
                            text.append(items[i]+"\n");
                            cause[i]=(String)items[i];
                     }
              }
       };
 
       public Janimal()
       {
              this.setTitle("����ʶ��ϵͳ");
              this.setSize(600, 400);
              this.setLocation((width - 600) / 2, (height - 400) / 2);
              text.setEditable(false);
              list.setVisibleRowCount(6);
              Container  contentPane=getContentPane();
              contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.X_AXIS));
 
              contentPane.add(new JScrollPane(list));
              contentPane.add(text);
              contentPane.add(button);
              contentPane.add(result);
              list.addListSelectionListener(lister);
              setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              button.addActionListener(this);
              setVisible(true);
       }
 
 
       public void actionPerformed(ActionEvent e) {
              // TODO Auto-generated method stub
 
      String actionCommand=e.getActionCommand()      ;
 
      if(e.getSource() instanceof JButton)
 
             if("��ʼʶ��".equalsIgnoreCase(actionCommand))
             {
                    resultString=thinker(cause);
                    if(resultString!=null)
                           result.append(resultString);
                    else
                           result.append("Sorry!�����������Ч����Ϣ^_^");
 
             }
       }
 
 
       public String  thinker(String[] cause)       //�����
       {
              String[] resultList = { "�ö����ǲ��鶯��", "�ö����ǲ��鶯��", "�ö�������", "�ö�������",
                            "�ö�����ʳ�⶯��", "�ö�����ʳ�⶯��", "�ö����������ද��", "�ö����������ද��", "�ö����ǽ�Ǯ��",
                            "�ö������ϻ�", "�ö����ǳ���¹", "�ö����ǰ���", "�ö���������", "�ö��������", "�ö�����������" };
 
              String[][] conditList = { { "�ö�����ë��" }, { "�ö�������" }, { "�ö�������ë" },
                            { "�ö�����" }, { "�ö�������" }, { "�ö�����Ȯ��" }, { "�ö����ǲ��鶯��", "����" },
                            { "�ö����ǲ��鶯��", "�ǽ���ۻ����" },
                            { "�ö����ǲ��鶯��", "�ö�����ʳ�⶯��", "�ǻƺ�ɫ", "�����а��ߵ�" },
                            { "�ö����ǲ��鶯��", "�ö�����ʳ�⶯��", "�ǻƺ�ɫ", "�����к�ɫ����" },
                            { "�ö����������ද��", "�г�����", "�г���", "�����а��ߵ�" },
                            { "�ö����������ද��", "�����к�ɫ����" },
                            { "�ö�������", "�г�����", "�г���", "�����", "�кڰ׶�ɫ" },
                            { "�ö�������", "����Ӿ", "�����", "�кڰ׶�ɫ" }, { "�ö�������", "�Ʒ�" } };
 
              boolean[][] flag = { { false }, { false }, { false }, { false },
                            { false }, { false }, { false, false }, { false, false },
                            { false, false, false, false }, { false, false, false, false },
                            { false, false, false, false }, { false, false },
                            { false, false, false, false, false },
                            { false, false, false, false }, { false, false } };
 
              boolean checkResult = true;
 
              //String[] cause = { "�ö�����ë��", "����", "�г�����", "�г���", "�����а��ߵ�" };
              ArrayList<String> result = new ArrayList();
              String[] conditTemp = new String[6];
              int temp, count = 0;
 
               for(int i=0;i<cause.length;i++)
                     {
                            result.add(cause[i]);
                     }
 
 
                            for(int row=0;row<conditList.length;row++)
                            {
                                   temp=0;
                                   checkResult=true;
 
                                   for(int i=0;i<conditTemp.length;i++)   //�������
                                   {
                                          conditTemp[i]="";
                                   }
 
                               for(int column=0;column<conditList[row].length;column++)
                               {
                                      if(conditList[row][column]!=null)
                                      {
                                        conditTemp[column]=conditList[row][column];
                                        temp=column;
                                      }
                             }
 
 
                               int m=0;
 
                               for(int i=0;i<conditTemp.length;i++)        //ȡ�������Ĳ�������ʵ�Ƚ�
                               {
 
                                    for(int j=0;j<result.size();j++)
                                    {
 
                                           if(conditTemp[i]!=null&&result.get(j)!=null)
                                           {
                                             if(conditTemp[i].equals(result.get(j)))
                                             {
                                                  flag[row][i]=true;
                                               m++;
                                             }
                                           }
                                    }
                               }
 
 
                               count=0;
                               for(int i=0;i<conditList[row].length;i++)   //ͳ��flag����
                               {
 
                                     if(flag[row][i]==true)
                                            count++;
                               }
 
                               if((temp+1)==count)                         //ȡ������Ľ��۲���
                               {
                                    result.add(resultList[row]);
 
                                    for(int i=0;i<conditList.length;i++)                        //�������Ƿ�Ϊ���ս���
                                      for(int j=0;j<conditList[i].length;j++)
                                      {
                                           if(conditList[i][j]!=null&&resultList[row]!=null)
                                           {
                                              if(conditList[i][j].equals(resultList[row]))
                                                     checkResult=false;
                                            }
                                          }
 
                                      if(checkResult==true)           //������ս���
                                      {
                                            System.out.print(resultList[row]);
                                            return resultList[row];
                                      }
                                     }
 
                            }
                            return null;
 
       }
       public static void main(String[] args) {
              // TODO Auto-generated method stub
              Janimal animal=new Janimal();
       }
}
  
  
 

