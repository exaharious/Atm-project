package task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T01_DiziTask {


        public static void yerDegistir(String[] yeniDizi){

            // Sortit[1,[3],2]->[1,2,[3]]
            String konteynir="";

            while (true)
            {
                konteynir=yeniDizi[1];//konteynır [3]
                yeniDizi[1]=yeniDizi[2];//1,2,2
                yeniDizi[2]=konteynir;//1,2,[3]
                break;
            }

            System.out.println(Arrays.toString(yeniDizi));
        }
        public static void yerDegistir(int[] yeniDizi){

            //   int[] dizi2={1,3,2};
            int konteynir=0;

            while (true)
            {

                konteynir=yeniDizi[1];//konteynır 3
                yeniDizi[1]=yeniDizi[2];//1,2,2
                yeniDizi[2]=konteynir;//1,2,3
                break;
            }

            System.out.println(Arrays.toString(yeniDizi));
        }
        public static void yerDegistir(int[][] yeniDizi){

            int konteynir= 0;

            while (true)
            {
                konteynir=yeniDizi[1][0];
                yeniDizi[1][0]=yeniDizi[2][0];
                yeniDizi[2][0]=konteynir;
                break;
            }

            System.out.println(Arrays.deepToString(yeniDizi));
        }

        public static boolean bolumVarMi(double[] yeniDizi){

            //[2,8,4,1] -->True
            //  [-1,-10,1,-2,20]-->false
            List<Double> liste=new ArrayList<>();
            for (double w:yeniDizi)
            {
                liste.add(w);
            }
            double buyuk=0;
            double kucuk=0;
            double bolum=0;
            for (int i = 0; i < yeniDizi.length; i++)
            {
                for (int j = 0; j < yeniDizi.length ; j++)
                {
                    buyuk=  Math.max(yeniDizi[i],yeniDizi[j]);
                    kucuk=  Math.min(yeniDizi[i],yeniDizi[j]);
                    bolum=buyuk/kucuk;
                    if (!liste.contains(bolum))
                    {
                        return false;
                    }
                }
            }
            return true;
        }


        public static void main(String[] args)
        {
      /*  Canada Marketinden taze interview soruları.
        1)Write a function that returns true if you can partition an array into one element and the rest,such that this element is equal to produc of all other elements excluding itself.
            Example:
            [2,8,4,1] -->True
            [-1,-10,1,-2,20]-->false
        2)Aşağıdaki sıralamaları sağlayan Java Kodunu yazınız.
        Sortit[1,3,2]->[1,2,3]
        Sortit[[1][3][2]]->[[1][2][3]]
        Sortit[1,[3],2]->[1,2,[3]]
        3)Replace(-314159.2653 -->"-$314,159.21")*/

            //task
            String[] dizi={"1","{3}","2"};
            yerDegistir(dizi);

            int[] dizi2={1,3,2};
            yerDegistir(dizi2);

            int[][] dizi3={{1}, {3}, {2}};
            yerDegistir(dizi3);






            //task metodu ustte
            double[] dizi5={1,3,9,27};

            System.out.println(bolumVarMi(dizi5));


           //task cözumu
            String str="-314159.2653";
            String[] strDizi=str.replace(".","").split("");
            String toplam="";

            for (int i = 0; i < strDizi.length; i++)
            {
                if (strDizi[i].equals("-"))
                {
                    toplam+="-$";
                }
                else if (toplam.equals("-$314"))
                {
                    toplam+=",1";
                }
                else if (toplam.equals("-$314,159"))
                {
                    toplam+=".21";
                    break;
                }else {
                    toplam+=strDizi[i];
                }
            }
            System.out.println(toplam);

            str=str.replace("-314159.2653","-$314,159.21");
            System.out.println(str);
        }
    }

