import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        boolean bool = true;
        while (bool) {
            System.out.println("�������û�����");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();//��������
            System.out.println("���������룺");
            String password = sc.next();

            //File file = new File("C:\\Users\\Administrator\\IdeaProjects\\ConsoleShop\\src\\users.xlsx");
            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            InputStream inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
            ReadUserExcel readExcel = new ReadUserExcel();//��������
            User users[] = readExcel.readExcel(in);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("��¼�ɹ�");
                    bool = false;
                    /*
                    ��ʾ��Ʒ
                     */
                    ReadProductExcel readProductExcel = new ReadProductExcel();
                    Product products[] = readProductExcel.getAllProduct(inProduct);
                    for (Product product : products) {
                        System.out.print(product.getpId());
                        System.out.print("\t" + product.getpName());
                        System.out.print("\t" + product.getPrice());
                        System.out.println("\t" + product.getpDesc());
                    }
                    System.out.println("��������ƷID�Ѹ���Ʒ���빺�ﳵ");
                    String pId = sc.next();
                    int count = 0;
                    /*
                    ����һ�����ﳵ�����飺�������Ʒ
                     */
                    Product carts[] = new Product[3];
                    /*
                    ���ݴ�IDȥExcel��ȥ�����Ƿ��и�ID����Ʒ��Ϣ��������򷵻ظ���Ʒ����
                     */
                    inProduct = null;
                    inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                    Product product = readProductExcel.getProductById(pId, inProduct);
                    System.out.println("Ҫ�������Ʒ�۸�" + product.getPrice());
                    if (product != null) {
                        carts[count++] = product;
                    }
                    System.out.println("����������Ʒ�밴1");
                    System.out.println("�鿴���ﳵ�밴2");
                    int choose = sc.nextInt();
                    if (choose == 1) {
                        inProduct = null;
                        inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                        readProductExcel = new ReadProductExcel();
                        products = readProductExcel.getAllProduct(inProduct);
                        for (Product p : products) {
                            System.out.print(p.getpId());
                            System.out.print("\t" + p.getpName());
                            System.out.print("\t" + p.getPrice());
                            System.out.println("\t" + p.getpDesc());
                        }
                        System.out.println("��������ƷID�Ѹ���Ʒ���빺�ﳵ");
                        pId = sc.next();
                        inProduct = null;
                        inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                        product = readProductExcel.getProductById(pId, inProduct);
                        System.out.println("Ҫ�������Ʒ�۸�" + product.getPrice());
                        if (product != null) {         //��ӹ��ﳵ
                            carts[count++] = product;
                        }
                    } else if (choose == 2) {
                        /*
                        �鿴���ﳵ
                        1�����ﳵ������
                        2����forѭ���鿴
                         */
                        Product[] Product = new Product[3];
                        for (Product p : carts) {
                            if (p != null)
                                System.out.print(p.getpId());
                                System.out.print("\t" + p.getpName());
                                System.out.print("\t" + p.getPrice());
                                System.out.println("\t" + p.getpDesc());
                            System.out.println("���˰�3");
                            System.out.println("����������Ʒ�밴4");
                            if (choose == 1) {
                                //����
                            }
                            if (choose == 2) {
                                inProduct = null;
                                inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                                readProductExcel = new ReadProductExcel();
                                products = readProductExcel.getAllProduct(inProduct);
                                for (Product pro : products) {
                                    System.out.print(pro.getpId());
                                    System.out.print("\t" + pro.getpName());
                                    System.out.print("\t" + pro.getPrice());
                                    System.out.println("\t" + pro.getpDesc());
                                }
                                System.out.println("ddddd");
                                System.out.println("��������ƷID�Ѹ���Ʒ���빺�ﳵ");
                                pId = sc.next();
                                inProduct = null;
                                inProduct = Class.forName("Test").getResourceAsStream("/product.xlsx");
                                product = readProductExcel.getProductById(pId, inProduct);
                                System.out.println("Ҫ�������Ʒ�۸�" + product.getPrice());
                                if (product != null) {         //��ӹ��ﳵ
                                    carts[count++] = product;
                                }
                            }
                        }
                        //��1����
                        //��2��������

                        break;
                    } else {
                        System.out.println("��¼ʧ��");
                    }
                }
            }
        }
    }
}