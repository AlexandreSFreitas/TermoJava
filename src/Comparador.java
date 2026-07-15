import java.util.Random;
import java.util.Scanner;

public class Comparador {
    static void main(String[] args) {
        jogar();
    }

    public static  String validarPalavra(Scanner scanner,String palavraSec) {
        System.out.println("DIGITE A PALAVRA CORRETA: ");
        String palavraTentada = scanner.next().toUpperCase();
        while (palavraTentada.length() != palavraSec.length() ){
            System.out.println("TAMANHO DA PALAVRA ERRADA, APENAS " + palavraSec.length() + " LETRAS");
            palavraTentada = scanner.next().toUpperCase();
        }
        return palavraTentada;
    }
    public static String[] comparar(String palavraSec,String palavraTentada) {
            String[] resultado = new String[palavraSec.length()];
            boolean[] usado = new boolean[palavraSec.length()];

            for (int i = 0; i < palavraSec.length(); i++) {
                if (palavraTentada.charAt(i) == palavraSec.charAt(i)) {
                    usado[i] = true;
                    resultado[i] = "🟩";
                }
            }
            for (int i = 0; i < palavraSec.length(); i++) {
                if (!"🟩".equals(resultado[i])) {
                    for (int j = 0; j < palavraSec.length(); j++) {
                        if (palavraTentada.charAt(i) == palavraSec.charAt(j) && !usado[j]) {
                            usado[j] = true;
                            resultado[i] = "🟨";
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < palavraSec.length(); i++) {
                if (!"🟩".equals(resultado[i]) && !"🟨".equals(resultado[i])) {
                    resultado[i] = "🟥";
                }
            }
            for (int i = 0; i < resultado.length; i++) {
                System.out.print(resultado[i]);
            }
        return resultado;
    }
    public static void  jogar(){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String[] palavraSecreta = {
                "VASCO",
                "CASAS",
                "LIVRO",
                "PRAIA",
                "NUVEM",
                "MOUSE"
        };
        int indice = random.nextInt(palavraSecreta.length);
        String palavraSec = palavraSecreta[indice];
        for (int tentativas = 0; tentativas < 5; tentativas++) {
            String palavraTentada = validarPalavra(scanner,palavraSec);
            String[] resultado = comparar(palavraSec,palavraTentada);
            if (palavraTentada.equals(palavraSec)) {
                System.out.println("Parabéns você ganhou, a palavra era: " + palavraSec);
                break;
            } else if (tentativas == 4) {
                System.out.println("Infelizmente você perdeu, a palavra era: " + palavraSec);
            }
        }

    }
    }






