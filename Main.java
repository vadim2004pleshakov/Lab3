import java.io.PrintStream;
import java.util.Scanner;
//класс ребра
class Edge {
    public int from;
    public int to;
    public Edge(int a, int b){//конструктор ребра по ID вершин
        this.from=a;
        this.to=b;
    }
}
//класс графа
class Graph {
    public int[] Vertices;//массив хранящий ID вершин
    public Edge[] Edges;//массив хранящий ребра
    //конструктор создающий пустой граф
    public Graph() {
        this.Vertices = new int[0];
        this.Edges = new Edge[0];
    }
    //вывод графа как списка рёбер
    public void printGraph() {
        for (int i = 0; i < Edges.length; i++) {
            System.out.println(Edges[i].from + " -> " + Edges[i].to);
        }
    }
    //вывод списка вершин
    public void printVertices() {
        for (int i = 0; i < Vertices.length; i++) {
            System.out.print(Vertices[i] + " ");
        }
    }
    //добавление ребра
    public void addEdge(int a, int b) {
        if (a != b) {//проверка что это не цикл
            Edge n = new Edge(a, b);
            if (this.notExistEdge(n)) {//проверка на существование
                Edge[] temp = Edges;
                this.Edges = new Edge[temp.length + 1];
                for (int i = 0; i < temp.length; i++) {
                    this.Edges[i] = temp[i];
                }
                this.Edges[temp.length] = n;
            }
        }//и добавляем вершины если их не было
        if (notExistVer(a)) {
            this.addVer(a);
        }
        if (notExistVer(b)) {
            this.addVer(b);
        }
    }
    //удаление ребра по ID вершин
    public void deleteEdge(int a, int b) {
        Edge n = new Edge(a, b);
        if (!this.notExistEdge(n)) {
            Edge[] temp = this.Edges;
            this.Edges = new Edge[temp.length - 1];
            int c = 0;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i].from != n.from || temp[i].to != n.to) {
                    this.Edges[c] = temp[i];
                    c++;
                }
            }
        }
    }
    //удаление вершины
    public void deleteVer(int a) {
        if (!this.notExistVer(a)) {
            int[] temp = this.Vertices;
            this.Vertices = new int[temp.length - 1];
            int c = 0;
            for (int i = 0; i < temp.length; i++) {
                if (a != temp[i]) {
                    this.Vertices[c] = temp[i];
                    c++;
                }
            }
            Edge[] toDelete = new Edge[0];//массив который собирает ребра присоединённые к удаляемой вершине
            for (int i = 0; i < this.Edges.length; i++) {
                if (Edges[i] != null) {
                    if (Edges[i].from == a || Edges[i].to == a) {
                        Edge[] t = toDelete;
                        toDelete = new Edge[t.length + 1];
                        for (int j = 0; j < t.length; j++) {
                            toDelete[j] = t[j];
                        }
                        toDelete[t.length] = Edges[i];
                    }
                }
            }
            for (int i = 0; i < toDelete.length; i++) {//удаление ребер:)
                int x = toDelete[i].from;
                int y = toDelete[i].to;
                this.deleteEdge(x, y);
            }
        }
    }
    //список вершин в которых соединяется не менее n ребер
    public int[] minEdgeVer(int p) {
        int[] res = new int[0];
        for (int i = 0; i < Vertices.length; i++) {
            int c = this.countIn(Vertices[i]) + this.countOut(Vertices[i]);
            if (c >= p) {
                res = sizePlus(res);
                res[res.length - 1] = Vertices[i];
            }
        }
        return res;
    }
    //список вершин с преобладанием входящим ребер
    public void inMoreOut() {
        for (int i = 0; i < Vertices.length; i++) {
            if (this.countIn(Vertices[i]) > this.countOut(Vertices[i])) {
                System.out.print(Vertices[i] + " ");
            }
        }
    }
    //разворот ребра
    public void reverseEdge(int a, int b) {
        for (int i = 0; i < Edges.length; i++) {
            if (Edges[i].from == a && Edges[i].to == b) {
                int t = Edges[i].from;
                Edges[i].from = Edges[i].to;
                Edges[i].to = t;
            }
        }
    }
    //удаление ребер с минимальной разницей во входящих и исходящих вершинах
    public void deleteBadVertices() {
        int[] t = new int[Vertices.length];
        int qq;
        for (int i = 0; i < Vertices.length; i++) {
            int q = this.countIn(Vertices[i]) - this.countOut(Vertices[i]);
            if (q > 0) {
                qq = q;
            } else qq = -q;
            t[i] = qq;
        }
        int min = Vertices.length;
        int[] toDelete = new int[0];
        for (int i = 0; i < t.length; i++) {
            if (t[i] < min) {
                min = t[i];
            }
        }
        for (int i = 0; i < t.length; i++) {
            if (t[i] == min) {
                toDelete = sizePlus(toDelete);
                toDelete[toDelete.length - 1] = i + 1;
            }
        }
        for (int i = 0; i < toDelete.length; i++) {
            this.deleteVer(toDelete[i]);
        }
    }
    //список ребер до которых можно добраться за два шага
    public void twoSteps(int a) {
        this.inNsteps(a,2);
    }
    //список ребер куда можно добраться за n шагов
    public void inNsteps(int a, int n) {
        int[]res=new int[1];
        res[0]=a;
        res=inNstepsRecursive(a,n,res);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
    //рекурсия
    private int[] inNstepsRecursive(int a, int n, int[]res) {
        if(n==0){
            return deleteRepeats(res);
        }
        else {
            int[]nres=new int[0];
            int c=0;
            for(int i=0;i<res.length;i++){
                for(int j=0;j<this.Edges.length;j++){
                    if(Edges[j].from==res[i]){
                        nres=sizePlus(nres);
                        nres[c]=Edges[j].to;
                        c++;
                    }
                }
            }
            for(int i=0;i<nres.length;i++){
                res=sizePlus(res);
                res[res.length-1]=nres[i];
            }
            return inNstepsRecursive(a,n-1,res);
        }
    }
    //сумма графов
    public static Graph sumOfGraphs(Graph a, Graph b) {
        Graph res = new Graph();
        int[] verplus = new int[a.Vertices.length + b.Vertices.length];
        for (int i = 0; i < a.Vertices.length; i++) {
            verplus[i] = a.Vertices[i];
        }
        for (int i = a.Vertices.length; i < verplus.length; i++) {
            verplus[i] = b.Vertices[i - a.Vertices.length];
        }
        verplus = deleteRepeats(verplus);
        for (int i = 0; i < verplus.length; i++) {
            res.addVer(verplus[i]);
        }
        for (int i = 0; i < a.Edges.length; i++) {
            int x = a.Edges[i].from;
            int y = a.Edges[i].to;
            res.addEdge(x, y);
        }
        for (int i = 0; i < b.Edges.length; i++) {
            int x = b.Edges[i].from;
            int y = b.Edges[i].to;
            res.addEdge(x, y);
        }
        return res;
    }
    //вспомогательные методы
    public static int[] sizePlus(int[] a) {//увеличение массива на 1
        int[] t = a;
        a = new int[t.length + 1];
        for (int i = 0; i < t.length; i++) {
            a[i] = t[i];
        }
        return a;
    }
    public boolean notExistEdge(Edge a) {//проверка на несуществование ребра
        for (int i = 0; i < Edges.length; i++) {
            if (a.from == Edges[i].from && a.to == Edges[i].to) {
                return false;
            }
        }
        return true;
    }
    public boolean notExistVer(int a) {//проверка на несуществование вершины
        for (int i = 0; i < Vertices.length; i++) {
            if (Vertices[i] == a) {
                return false;
            }
        }
        return true;
    }
    public void addVer(int a) {//добавление вершины
        this.Vertices = sizePlus(this.Vertices);
        Vertices[Vertices.length - 1] = a;
    }
    public int countIn(int a) {//счет ребер входящих в вершину
        int cnt = 0;
        if (!notExistVer(a)) {
            for (int i = 0; i < Edges.length; i++) {
                if (Edges[i].to == a) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public int countOut(int a) {//счет ребер выходящих из вершины
        int cnt = 0;
        if (!notExistVer(a)) {
            for (int i = 0; i < Edges.length; i++) {
                if (Edges[i].from == a) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static int[] deleteRepeats(int[] a) {//удаление повторных элементов
        int[] b = new int[0];
        for (int i = 0; i < a.length; i++) {
            boolean t = true;
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    t = false;
                }
            }
            if (t) {
                b = sizePlus(b);
                b[b.length - 1] = a[i];
            }
        }
        return b;
    }
    public int[] oneStep(int a) {//список ребер до которых можно добраться за 1 шаг
        int[] first = new int[countOut(a)];
        int c = 0;
        for (int i = 0; i < Edges.length; i++) {
            if (Edges[i].from == a) {
                first[c] = Edges[i].to;
                c++;
            }
        }
        return first;
    }
}
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        Graph test = new Graph();
        out.println("Введите ребра парами 2 чисел (для остановки введите 0 0");
        int a=1; int b=1;
        while (a!=0 || b!=0){
            a = in.nextInt();
            b = in.nextInt();
            test.addEdge(a,b);}
        test.deleteVer(0);
        out.println("Ребра и вершины:");
        test.printGraph();
        test.printVertices();
        //out.println();
        //out.println("Список вершин в которых соединяется не менее (введите) рёбер:");
        //int q = in.nextInt();
        //int[]mev = test.minEdgeVer(q);
        //for(int i=0;i<mev.length;i++){
        //    out.print(mev[i]+" ");
        //}
        //out.println();
        //out.println("Список вершин с преобладанием входящих рёбер:");
        //test.inMoreOut();
        //out.println();
        //out.println("Давайте удалим ребро! Введите начало и конец");
        //int a1=in.nextInt();
        //int a2=in.nextInt();
        //test.deleteEdge(a1,a2);
        //test.printGraph();
        //out.println();
        //out.println("А теперь давайте удалим вершину! Введите ID");
        //n=in.nextInt();
        //test.deleteVer(n);
        //test.printGraph();
        //test.printVertices();
        //out.println("А теперь развернём дугу! Введите начало и конец");
        //a1=in.nextInt();
        //a2=in.nextInt();
        //test.reverseEdge(a1,a2);
        //test.printGraph();
        //out.println("Сейчас я удалю вершины с минимальной разницей рёбер!");
        //test.deleteBadVertices();
        //test.printGraph();
        out.println("Введите вершину, а я скажу до куда можно дойти за 2 шага");
        int n=in.nextInt();
        test.twoSteps(n);
        out.println("А теперь шаги тоже введите");
        n=in.nextInt();
        int a1=in.nextInt();
        test.inNsteps(n,a1);
        out.println("Теперь давайте возьмем еще один граф и сложим с предыдущим");
        Graph test1 = new Graph();
        out.println("Введите ребра парами 2 чисел (для остановки введите 0 0");
        a=1; b=1;
        while (a!=0 || b!=0){
            a = in.nextInt();
            b = in.nextInt();
            test1.addEdge(a,b);}
        test1.deleteVer(0);
        out.println("Ребра и вершины:");
        test1.printGraph();
        test1.printVertices();
        out.println("Складываю, вот что получилось!");
        Graph ogo = Graph.sumOfGraphs(test,test1);
        ogo.printGraph();
        ogo.printVertices();
    }
}
