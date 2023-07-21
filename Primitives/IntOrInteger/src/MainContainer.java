public class MainContainer {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

        int i;
        for (i = 1040; i <= 1103; i++) {
            char c = (char) i;
            System.out.println(i + " - " + c);
        }
        for (i = 1105; i < 1106; i++) {
            char c = (char) i;
            System.out.println(i + " - " + c);
        }
        for (i = 1025; i < 1026; i++) {
            char c = (char) i;
            System.out.println(i + " - " + c);
        }
    }
}
