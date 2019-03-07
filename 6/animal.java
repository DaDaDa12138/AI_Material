//本人找到的Java程序,写的好强 
 
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
 
       private String[] str={"该动物有毛发","该动物有奶","该动物有羽毛","该动物会飞","该动物会吃肉","该动物有犬齿","有爪","眼盯前方","该动物是哺乳动物","有蹄","是嚼反刍动物","该动物是食肉动物","是黄褐色","身上有暗斑点","身上有黑色条纹","该动物是有蹄类动物","有长脖子","有长腿","不会飞","有黑白二色","会游泳","该动物是鸟","善飞"};
       private JList list=new JList(str);
       private JTextArea text=new JTextArea(10,10);
       private JTextArea result=new JTextArea(20,20);
       private JButton  button=new JButton("开始识别");
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
              this.setTitle("动物识别系统");
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
 
             if("开始识别".equalsIgnoreCase(actionCommand))
             {
                    resultString=thinker(cause);
                    if(resultString!=null)
                           result.append(resultString);
                    else
                           result.append("Sorry!，请输入更有效的信息^_^");
 
             }
       }
 
 
       public String  thinker(String[] cause)       //推理机
       {
              String[] resultList = { "该动物是哺乳动物", "该动物是哺乳动物", "该动物是鸟", "该动物是鸟",
                            "该动物是食肉动物", "该动物是食肉动物", "该动物是有蹄类动物", "该动物是有蹄类动物", "该动物是金钱豹",
                            "该动物是老虎", "该动物是长颈鹿", "该动物是斑马", "该动物是鸵鸟", "该动物是企鹅", "该动物是信天翁" };
 
              String[][] conditList = { { "该动物有毛发" }, { "该动物有奶" }, { "该动物有羽毛" },
                            { "该动物会飞" }, { "该动物会吃肉" }, { "该动物有犬齿" }, { "该动物是哺乳动物", "有蹄" },
                            { "该动物是哺乳动物", "是嚼反刍动物" },
                            { "该动物是哺乳动物", "该动物是食肉动物", "是黄褐色", "身上有暗斑点" },
                            { "该动物是哺乳动物", "该动物是食肉动物", "是黄褐色", "身上有黑色条纹" },
                            { "该动物是有蹄类动物", "有长脖子", "有长腿", "身上有暗斑点" },
                            { "该动物是有蹄类动物", "身上有黑色条纹" },
                            { "该动物是鸟", "有长脖子", "有长腿", "不会飞", "有黑白二色" },
                            { "该动物是鸟", "会游泳", "不会飞", "有黑白二色" }, { "该动物是鸟", "善飞" } };
 
              boolean[][] flag = { { false }, { false }, { false }, { false },
                            { false }, { false }, { false, false }, { false, false },
                            { false, false, false, false }, { false, false, false, false },
                            { false, false, false, false }, { false, false },
                            { false, false, false, false, false },
                            { false, false, false, false }, { false, false } };
 
              boolean checkResult = true;
 
              //String[] cause = { "该动物有毛发", "有蹄", "有长脖子", "有长腿", "身上有暗斑点" };
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
 
                                   for(int i=0;i<conditTemp.length;i++)   //清空数组
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
 
                               for(int i=0;i<conditTemp.length;i++)        //取出条件的部分与事实比较
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
                               for(int i=0;i<conditList[row].length;i++)   //统计flag数组
                               {
 
                                     if(flag[row][i]==true)
                                            count++;
                               }
 
                               if((temp+1)==count)                         //取出规则的结论部分
                               {
                                    result.add(resultList[row]);
 
                                    for(int i=0;i<conditList.length;i++)                        //检测结论是否为最终结论
                                      for(int j=0;j<conditList[i].length;j++)
                                      {
                                           if(conditList[i][j]!=null&&resultList[row]!=null)
                                           {
                                              if(conditList[i][j].equals(resultList[row]))
                                                     checkResult=false;
                                            }
                                          }
 
                                      if(checkResult==true)           //输出最终结论
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
  
  
 

