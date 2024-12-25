## Отчет по лабораторной работе № 3

#### № группы: `ПМ-2401`

#### Выполнил: `Плешаков Вадим Алексеевич`

#### Вариант: `20`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Описание классов и их полей](#2-описание-классов-и-их-полей)
- [Документация](#3-документация)

### 1. Постановка задачи

>Разработать программу для работы с направленным графом, представленным в виде
набора рёбер. Реализовать функции добавления и удаления рёбер и вершин, анализа
структуры графа и выполнения операций над графами.
>
- ###  Вывод графа
Отображает все рёбра графа в порядке их добавления. Каждое ребро представлено парой чисел: «ID откуда» и «ID куда»
- ### Добавление ребра
Добавляет ребро в граф по двум ID вершин: начальной и конечной. Рёбра должны
быть уникальны. Рёбра, соединяющие вершину саму с собой, не добавляются.
- ### Вывод ID всех вершин
Отображает список всех вершин в графе. Допускается вывод без определённого
порядка, но предпочтительно по возрастанию.
- ### Вершины с минимальным числом рёбер
Возвращает номера вершин, в которых соединяется не менее указанного количества рёбер.
- ### Вершины с преобладанием входящих рёбер
Отображает номера вершин, в которые входит больше рёбер, чем выходит.
- ###  Перенаправление ребра
Изменяет текущее направление ребра. Передаются ID начальной и конечной вершин. После перенаправления начальная и 
конечная вершины меняются местами.
- ### Удаление ребра
Удаляет ребро из графа по двум числам: ID начальной и конечной вершин.
- ### Удаление вершины
Удаляет указанную вершину из графа. Все рёбра, входящие в неё и выходящие
из неё, также удаляются.
- ### Удаление вершин с минимальной разницей рёбер
Удаляет вершины, у которых разница между количеством входящих и исходящих
рёбер (по модулю) минимальна среди всех вершин.
- ### Вершины достижимые за 2 хода
Выводит список вершин, в которые можно попасть из указанной вершины за не
более чем 2 хода.
- ### Вершины достижимые за n ходов
Выводит список вершин, в которые можно попасть из указанной вершины за не
более чем переданное количество ходов (n). Решение может быть реализовано
рекурсивно или с использованием циклов.
- ### Сложение двух графов
Объединяет два графа. Результирующий граф содержит все вершины и рёбра из
обоих графов, без повторений.
- ### Удаление повторений из массива
Предоставляет вспомогательную функцию для создания массива без повторений
из массива с дублирующими элементами. Может быть использована в задачах для
возврата уникальных значений.

### 2. Описание классов и их полей

Для реализации функционала создано 2 класса

1. Класс `Edge`  
    Класс, содержащий в себе ID начала и конца дуги.
`from` - поле типа int, содержащее информацию о начале дуги
`to` - поле типа int, содержащее информацию о конце дуги
2. Класс `Graph`
    Класс содержащий в себе массивы вершин и рёбер
`Vertices` - массив int, содержащий в себе вершины
`Edges` - массив Edge, содержащий в себе рёбра


### 3. Документация

### 1. Конструкторы классов (создание объектов на основе вышеописанных классов) ###  
- Graph() - создаётся пустой граф без вершин и рёбер. Основной класс программы.
- Edge(int,int) - создаётся ребро с началом и концом (дуга). Вспомогательный класс для удобства взаимодействия.
### 2. Методы классов (вспомогательные) ###  
Эти методы были написаны по моему хотению, не являются обзательными по заданию.
- int[] sizePlus(int []) - статический, увеличивает на 1 размер массива и сохраняет значения (6 использований)
- boolean notExistEdge(Edge) - проверяет ребро на несуществование (2 использования)
- boolean notExistVer(int) - проверяет вершину на несуществование (5 использований)
- void addVer(int) - добавляет вершину (3 использования)
- int countIn(int) - считает ребра входящие в вершину (3 использования)
- int countOut(int) - считает ребра выходящие из вершины (4 использования)
- int[] oneStep(int) - возвращает достижимые в 1 ход вершины (3 использования)
### 3. Методы классов (по заданию)
- int[] deleteRepeats(int []) - вспомогательный метод, удаляющий дубликаты из массива (2 использования)
- void printGraph() - выводит граф как список дуг
- void PrintVertices() - выводит список вершин графа
- void addEdge(int, int) - добавляет в граф ребро с указанными ID начала и конца
- void deleteEdge(int, int) - удаляет из графа ребро с указанными ID начала и конца
- void deleteVer(int) - удаляет вершину и инцидентные ей рёбра
- int[] minEdgeVer(int) - возвращает список вершин в которых соединется не менее указанного числа ребер
- void inMoreOut() - выводит список вершин у которых входящих рёбер больше выходящих
- void reverseEdge(int,int) - меняет начало и конец ребра местами
- void deleteBadVertices() - удаляет вершины с минимальной разницей рёбер
- void twoSteps(int) - выводит список вершин до которых можно добраться за 2 шага
- void inNssteps(int,int) - выводит список вершин до которых можно добраться за n шагов
- void inNstepsRecursive(int,int,int[]) - рекурсия для предыдущего метода
- boolean contains(int[],int) - проверяет содержание элемента в массиве для предпредыдущего метода
- Graph sumOfGraphs(Graph,Graph) - выводит граф полученный объединением (в смысле теории множеств) двух
### 4. Код классов
```java
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
        int[] v = new int[0];
        int[] res = inNstepsRecursive(a, n, v);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    //рекурсия
    private int[] inNstepsRecursive(int cur, int steps, int[] v) {
        if (steps == 0) {
            if (!contains(v, cur)) {
                v = sizePlus(v);
                v[v.length - 1] = cur;
            }
            return v;
        }
        int[] n = oneStep(cur);
        int[] result = v;
        for (int ng : n) {
            if (!contains(result, ng)) {
                result = inNstepsRecursive(ng, steps - 1, result);
            }
        }
        if (!contains(result, cur)) {
            result = sizePlus(result);
            result[result.length - 1] = cur;
        }
        return result;
    }
    //проверка на содержание
    private boolean contains(int[] ar, int v) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == v) {
                return true;
            }
        }
        return false;
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
```
- Код для теста и ввода с клавиатуры:
```java
import java.io.PrintStream;
import java.util.Scanner;
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
```

### 5. Анализ правильности решения.
 ```
==== Ввод и вывод графа ====
Введите ребра парами 2 чисел (для остановки введите 0 0)
1 3
1 4
1 5
2 3
2 4
2 5
0 0
Ребра и вершины:
1 -> 3
1 -> 4
1 -> 5
2 -> 3
2 -> 4
2 -> 5
1 2 3 4 5
===Список вершин в которых соединяется не менее n ребер===
1 2
===Список вершин с преобладанием входящих рёбер===
3 4 5
===Удаление ребра 2 5===
1 -> 3
1 -> 4
1 -> 5
2 -> 3
2 -> 4
===Удаление вершины 5===
1 -> 3
1 -> 4
2 -> 3
2 -> 4
1 2 3 4
===Разворот дуги 1 3===
3 -> 1
1 -> 4
2 -> 3
2 -> 4
===Удаление вершин с минимальной разницей рёбер===
2 -> 4

===Проверка на сложение с  графом===
Ребра и вершины:
1 -> 2
1 -> 3
2 -> 4
2 -> 5
3 -> 4
3 -> 6
5 -> 6
6 -> 7
6 -> 8
6 -> 9
4 -> 2
1 2 3 4 5 6 7 8 9
Введите ребра парами 2 чисел (для остановки введите 0 0
3 5
3 8
3 9
8 9
0 0
Ребра и вершины:
1 -> 2
1 -> 3
2 -> 4
2 -> 5
3 -> 4
3 -> 6
4 -> 2
5 -> 6
6 -> 7
6 -> 8
6 -> 9
1 2 3 4 5 6 7 8 9 Складываю, вот что получилось!
1 -> 2
1 -> 3
2 -> 4
2 -> 5
3 -> 4
3 -> 6
4 -> 2
5 -> 6
6 -> 7
6 -> 8
6 -> 9
3 -> 5
3 -> 8
3 -> 9
8 -> 9
1 2 3 4 5 6 7 8 9 
===Тесты на сложение с пустым графом и графом с новыми вершинами===
Введите ребра парами 2 чисел (для остановки введите 0 0
1 2
2 3
3 1
0 0
Ребра и вершины:
1 -> 2
2 -> 3
3 -> 1
1 2 3 Теперь давайте возьмем еще один граф и сложим с предыдущим
Введите ребра парами 2 чисел (для остановки введите 0 0
0 0
Складываю, вот что получилось!
1 -> 2
2 -> 3
3 -> 1
1 2 3 

Введите ребра парами 2 чисел (для остановки введите 0 0
1 2
2 3
3 1
0 0
Ребра и вершины:
1 -> 2
2 -> 3
3 -> 1
1 2 3 Теперь давайте возьмем еще один граф и сложим с предыдущим
Введите ребра парами 2 чисел (для остановки введите 0 0
3 4
3 5
2 1
0 0
Ребра и вершины:
3 -> 4
3 -> 5
2 -> 1
3 4 5 2 1 Складываю, вот что получилось!
1 -> 2
2 -> 3
3 -> 1
3 -> 4
3 -> 5
2 -> 1
1 2 3 4 5 

Введите ребра парами 2 чисел (для остановки введите 0 0
1 2
1 3
3 4
2 4
2 5
5 6
3 6
6 7
6 8
6 9
0 0
Ребра и вершины:
1 -> 2
1 -> 3
3 -> 4
2 -> 4
2 -> 5
5 -> 6
3 -> 6
6 -> 7
6 -> 8
6 -> 9
1 2 3 4 5 6 7 8 9 Введите вершину, а я скажу до куда можно дойти за 2 шага
5
7 8 9 6 5 
А теперь шаги тоже введите
4 3
4
```
  